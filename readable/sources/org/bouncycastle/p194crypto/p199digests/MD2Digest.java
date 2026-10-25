package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.p217signers.PSSSigner;
import org.bouncycastle.p361util.Memoable;
import p094kotlin.C1126UByte;
import p094kotlin.p101io.encoding.C1217Base64;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public class MD2Digest implements ExtendedDigest, Memoable {
    private static final int DIGEST_LENGTH = 16;

    /* renamed from: S */
    private static final byte[] f19425S = {41, 46, 67, -55, -94, -40, 124, 1, C1217Base64.padSymbol, 54, 84, -95, -20, -16, 6, 19, 98, -89, 5, -13, -64, -57, 115, -116, -104, -109, 43, -39, PSSSigner.TRAILER_IMPLICIT, 76, -126, -54, 30, -101, 87, 60, -3, -44, -32, 22, 103, 66, 111, 24, -118, 23, -27, 18, -66, 78, -60, -42, -38, -98, -34, 73, -96, -5, -11, -114, -69, 47, -18, 122, -87, 104, 121, -111, 21, -78, 7, C5066Utf8.REPLACEMENT_BYTE, -108, -62, 16, -119, 11, 34, 95, 33, ByteCompanionObject.MIN_VALUE, ByteCompanionObject.MAX_VALUE, 93, -102, 90, -112, 50, 39, 53, 62, -52, -25, -65, -9, -105, 3, -1, 25, 48, -77, 72, -91, -75, -47, -41, 94, -110, 42, -84, 86, -86, -58, 79, -72, 56, -46, -106, -92, 125, -74, 118, -4, 107, -30, -100, 116, 4, -15, 69, -99, 112, 89, 100, 113, -121, 32, -122, 91, -49, 101, -26, 45, -88, 2, 27, 96, 37, -83, -82, -80, -71, -10, 28, 70, 97, 105, 52, 64, 126, 15, 85, 71, -93, 35, -35, 81, -81, 58, -61, 92, -7, -50, -70, -59, -22, 38, 44, 83, 13, 110, -123, 40, -124, 9, -45, -33, -51, -12, 65, -127, 77, 82, 106, -36, 55, -56, 108, -63, -85, -6, 36, -31, 123, 8, 12, -67, -79, 74, 120, -120, -107, -117, -29, 99, -24, 109, -23, -53, -43, -2, 59, 0, 29, 57, -14, -17, -73, 14, 102, 88, -48, -28, -90, 119, 114, -8, -21, 117, 75, 10, 49, 68, 80, -76, -113, -19, 31, 26, -37, -103, -115, 51, -97, 17, -125, 20};

    /* renamed from: C */
    private byte[] f19426C;

    /* renamed from: COff */
    private int f19427COff;

    /* renamed from: M */
    private byte[] f19428M;

    /* renamed from: X */
    private byte[] f19429X;

    /* renamed from: mOff */
    private int f19430mOff;

    /* renamed from: purpose */
    private final CryptoServicePurpose f19431purpose;

    /* renamed from: xOff */
    private int f19432xOff;

    public MD2Digest() {
        this(CryptoServicePurpose.ANY);
    }

    /* renamed from: copyIn */
    private void m15100copyIn(MD2Digest mD2Digest) {
        byte[] bArr = mD2Digest.f19429X;
        System.arraycopy(bArr, 0, this.f19429X, 0, bArr.length);
        this.f19432xOff = mD2Digest.f19432xOff;
        byte[] bArr2 = mD2Digest.f19428M;
        System.arraycopy(bArr2, 0, this.f19428M, 0, bArr2.length);
        this.f19430mOff = mD2Digest.f19430mOff;
        byte[] bArr3 = mD2Digest.f19426C;
        System.arraycopy(bArr3, 0, this.f19426C, 0, bArr3.length);
        this.f19427COff = mD2Digest.f19427COff;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new MD2Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        int length = this.f19428M.length;
        int i2 = this.f19430mOff;
        byte b = (byte) (length - i2);
        while (true) {
            byte[] bArr2 = this.f19428M;
            if (i2 >= bArr2.length) {
                processCheckSum(bArr2);
                processBlock(this.f19428M);
                processBlock(this.f19426C);
                System.arraycopy(this.f19429X, this.f19432xOff, bArr, i, 16);
                mo14968reset();
                return 16;
            }
            bArr2[i2] = b;
            i2++;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "MD2";
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return 16;
    }

    public void processBlock(byte[] bArr) {
        for (int i = 0; i < 16; i++) {
            byte[] bArr2 = this.f19429X;
            bArr2[i + 16] = bArr[i];
            bArr2[i + 32] = (byte) (bArr[i] ^ bArr2[i]);
        }
        int i2 = 0;
        for (int i3 = 0; i3 < 18; i3++) {
            for (int i4 = 0; i4 < 48; i4++) {
                byte[] bArr3 = this.f19429X;
                byte b = (byte) (f19425S[i2] ^ bArr3[i4]);
                bArr3[i4] = b;
                i2 = b & C1126UByte.MAX_VALUE;
            }
            i2 = (i2 + i3) % 256;
        }
    }

    public void processCheckSum(byte[] bArr) {
        byte b = this.f19426C[15];
        for (int i = 0; i < 16; i++) {
            byte[] bArr2 = this.f19426C;
            b = (byte) (f19425S[(b ^ bArr[i]) & 255] ^ bArr2[i]);
            bArr2[i] = b;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.f19432xOff = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f19429X;
            if (i == bArr.length) {
                break;
            }
            bArr[i] = 0;
            i++;
        }
        this.f19430mOff = 0;
        int i2 = 0;
        while (true) {
            byte[] bArr2 = this.f19428M;
            if (i2 == bArr2.length) {
                break;
            }
            bArr2[i2] = 0;
            i2++;
        }
        this.f19427COff = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr3 = this.f19426C;
            if (i3 == bArr3.length) {
                return;
            }
            bArr3[i3] = 0;
            i3++;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        byte[] bArr = this.f19428M;
        int i = this.f19430mOff;
        int i2 = i + 1;
        this.f19430mOff = i2;
        bArr[i] = b;
        if (i2 == 16) {
            processCheckSum(bArr);
            processBlock(this.f19428M);
            this.f19430mOff = 0;
        }
    }

    public MD2Digest(CryptoServicePurpose cryptoServicePurpose) {
        this.f19429X = new byte[48];
        this.f19428M = new byte[16];
        this.f19426C = new byte[16];
        this.f19431purpose = cryptoServicePurpose;
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, 64, cryptoServicePurpose));
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15100copyIn((MD2Digest) memoable);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        while (this.f19430mOff != 0 && i2 > 0) {
            mo14969update(bArr[i]);
            i++;
            i2--;
        }
        while (i2 >= 16) {
            System.arraycopy(bArr, i, this.f19428M, 0, 16);
            processCheckSum(this.f19428M);
            processBlock(this.f19428M);
            i2 -= 16;
            i += 16;
        }
        while (i2 > 0) {
            mo14969update(bArr[i]);
            i++;
            i2--;
        }
    }

    public MD2Digest(MD2Digest mD2Digest) {
        this.f19429X = new byte[48];
        this.f19428M = new byte[16];
        this.f19426C = new byte[16];
        CryptoServicePurpose cryptoServicePurpose = mD2Digest.f19431purpose;
        this.f19431purpose = cryptoServicePurpose;
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, 64, cryptoServicePurpose));
        m15100copyIn(mD2Digest);
    }
}
