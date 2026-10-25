package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p213params.ParametersWithSBox;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class GOST28147Mac implements InterfaceC5278Mac {
    private static final int BLOCK_SIZE = 8;
    private static final int MAC_SIZE = 4;

    /* renamed from: S */
    private byte[] f20445S;

    /* renamed from: buf */
    private byte[] f20446buf;

    /* renamed from: bufOff */
    private int f20447bufOff;
    private boolean firstStep;

    /* renamed from: mac */
    private byte[] f20448mac;

    /* renamed from: macIV */
    private byte[] f20449macIV;

    /* renamed from: purpose */
    private final CryptoServicePurpose f20450purpose;
    private int[] workingKey;

    public GOST28147Mac() {
        this(CryptoServicePurpose.AUTHENTICATION);
    }

    /* renamed from: CM5func */
    private static void m15584CM5func(byte[] bArr, int i, byte[] bArr2, byte[] bArr3) {
        for (int i2 = 0; i2 < 8; i2++) {
            bArr3[i2] = (byte) (bArr[i + i2] ^ bArr2[i2]);
        }
    }

    private int[] generateWorkingKey(byte[] bArr) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Key length invalid. Key needs to be 32 byte - 256 bit!!!");
        }
        int[] iArr = new int[8];
        for (int i = 0; i != 8; i++) {
            iArr[i] = AbstractC6245Pack.littleEndianToInt(bArr, i * 4);
        }
        return iArr;
    }

    private void gost28147MacFunc(int[] iArr, byte[] bArr, int i, byte[] bArr2, int i2) {
        int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, i);
        int iLittleEndianToInt2 = AbstractC6245Pack.littleEndianToInt(bArr, i + 4);
        for (int i3 = 0; i3 < 2; i3++) {
            int i4 = 0;
            while (i4 < 8) {
                int iGost28147_mainStep = iLittleEndianToInt2 ^ gost28147_mainStep(iLittleEndianToInt, iArr[i4]);
                i4++;
                int i5 = iLittleEndianToInt;
                iLittleEndianToInt = iGost28147_mainStep;
                iLittleEndianToInt2 = i5;
            }
        }
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt, bArr2, i2);
        AbstractC6245Pack.intToLittleEndian(iLittleEndianToInt2, bArr2, i2 + 4);
    }

    private int gost28147_mainStep(int i, int i2) {
        int i3 = i2 + i;
        byte[] bArr = this.f20445S;
        int i4 = bArr[i3 & 15] + (bArr[((i3 >> 4) & 15) + 16] << 4) + (bArr[((i3 >> 8) & 15) + 32] << 8) + (bArr[((i3 >> 12) & 15) + 48] << 12) + (bArr[((i3 >> 16) & 15) + 64] << 16) + (bArr[((i3 >> 20) & 15) + 80] << 20) + (bArr[((i3 >> 24) & 15) + 96] << 24) + (bArr[((i3 >> 28) & 15) + 112] << 28);
        return (i4 << 11) | (i4 >>> 21);
    }

    private void recursiveInit(CipherParameters cipherParameters) {
        CipherParameters parameters;
        if (cipherParameters == null) {
            return;
        }
        if (cipherParameters instanceof ParametersWithSBox) {
            ParametersWithSBox parametersWithSBox = (ParametersWithSBox) cipherParameters;
            System.arraycopy(parametersWithSBox.m15802getSBox(), 0, this.f20445S, 0, parametersWithSBox.m15802getSBox().length);
            parameters = parametersWithSBox.getParameters();
        } else if (cipherParameters instanceof KeyParameter) {
            this.workingKey = generateWorkingKey(((KeyParameter) cipherParameters).m15773getKey());
            parameters = null;
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("invalid parameter passed to GOST28147 init - " + cipherParameters.getClass().getName());
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
            byte[] bArr = this.f20448mac;
            System.arraycopy(bArrM15801getIV, 0, bArr, 0, bArr.length);
            this.f20449macIV = parametersWithIV.m15801getIV();
            parameters = parametersWithIV.getParameters();
        }
        recursiveInit(parameters);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        while (true) {
            int i2 = this.f20447bufOff;
            if (i2 >= 8) {
                break;
            }
            this.f20446buf[i2] = 0;
            this.f20447bufOff = i2 + 1;
        }
        byte[] bArr2 = this.f20446buf;
        byte[] bArr3 = new byte[bArr2.length];
        if (this.firstStep) {
            this.firstStep = false;
            System.arraycopy(bArr2, 0, bArr3, 0, this.f20448mac.length);
        } else {
            m15584CM5func(bArr2, 0, this.f20448mac, bArr3);
        }
        gost28147MacFunc(this.workingKey, bArr3, 0, this.f20448mac, 0);
        byte[] bArr4 = this.f20448mac;
        System.arraycopy(bArr4, (bArr4.length / 2) - 4, bArr, i, 4);
        mo14977reset();
        return 4;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return "GOST28147Mac";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return 4;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        mo14977reset();
        this.f20446buf = new byte[8];
        this.f20449macIV = null;
        recursiveInit(cipherParameters);
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 178, cipherParameters, this.f20450purpose));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        int i = 0;
        while (true) {
            byte[] bArr = this.f20446buf;
            if (i >= bArr.length) {
                this.f20447bufOff = 0;
                this.firstStep = true;
                return;
            } else {
                bArr[i] = 0;
                i++;
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        int i = this.f20447bufOff;
        byte[] bArr = this.f20446buf;
        if (i == bArr.length) {
            byte[] bArr2 = new byte[bArr.length];
            if (this.firstStep) {
                this.firstStep = false;
                byte[] bArr3 = this.f20449macIV;
                if (bArr3 != null) {
                    m15584CM5func(bArr, 0, bArr3, bArr2);
                } else {
                    System.arraycopy(bArr, 0, bArr2, 0, this.f20448mac.length);
                }
            } else {
                m15584CM5func(bArr, 0, this.f20448mac, bArr2);
            }
            gost28147MacFunc(this.workingKey, bArr2, 0, this.f20448mac, 0);
            this.f20447bufOff = 0;
        }
        byte[] bArr4 = this.f20446buf;
        int i2 = this.f20447bufOff;
        this.f20447bufOff = i2 + 1;
        bArr4[i2] = b;
    }

    public GOST28147Mac(CryptoServicePurpose cryptoServicePurpose) {
        this.firstStep = true;
        this.workingKey = null;
        this.f20449macIV = null;
        this.f20445S = new byte[]{9, 6, 3, 2, 8, 11, 1, 7, 10, 4, 14, 15, 12, 0, 13, 5, 3, 7, 14, 9, 8, 10, 15, 0, 5, 2, 6, 12, 11, 4, 13, 1, 14, 4, 6, 2, 11, 3, 13, 8, 12, 15, 5, 10, 0, 7, 1, 9, 14, 7, 10, 12, 13, 1, 3, 9, 0, 2, 11, 4, 15, 8, 5, 6, 11, 5, 1, 9, 8, 13, 15, 0, 14, 4, 2, 3, 12, 7, 10, 6, 3, 10, 13, 12, 1, 2, 0, 11, 7, 5, 9, 4, 8, 15, 14, 6, 1, 13, 2, 9, 7, 10, 6, 0, 8, 12, 4, 5, 15, 3, 11, 14, 11, 10, 15, 5, 0, 12, 14, 8, 6, 2, 3, 9, 1, 7, 13, 4};
        this.f20450purpose = cryptoServicePurpose;
        this.f20448mac = new byte[8];
        this.f20446buf = new byte[8];
        this.f20447bufOff = 0;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        if (i2 < 0) {
            throw new IllegalArgumentException("Can't have a negative input length!");
        }
        int i3 = this.f20447bufOff;
        int i4 = 8 - i3;
        if (i2 > i4) {
            System.arraycopy(bArr, i, this.f20446buf, i3, i4);
            byte[] bArr2 = this.f20446buf;
            byte[] bArr3 = new byte[bArr2.length];
            if (this.firstStep) {
                this.firstStep = false;
                byte[] bArr4 = this.f20449macIV;
                if (bArr4 != null) {
                    m15584CM5func(bArr2, 0, bArr4, bArr3);
                } else {
                    System.arraycopy(bArr2, 0, bArr3, 0, this.f20448mac.length);
                }
            } else {
                m15584CM5func(bArr2, 0, this.f20448mac, bArr3);
            }
            gost28147MacFunc(this.workingKey, bArr3, 0, this.f20448mac, 0);
            this.f20447bufOff = 0;
            i2 -= i4;
            i += i4;
            while (i2 > 8) {
                m15584CM5func(bArr, i, this.f20448mac, bArr3);
                gost28147MacFunc(this.workingKey, bArr3, 0, this.f20448mac, 0);
                i2 -= 8;
                i += 8;
            }
        }
        System.arraycopy(bArr, i, this.f20446buf, this.f20447bufOff, i2);
        this.f20447bufOff += i2;
    }
}
