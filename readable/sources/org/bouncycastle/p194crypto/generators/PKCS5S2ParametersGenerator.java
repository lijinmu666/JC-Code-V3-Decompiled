package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.p209macs.C5360HMac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p221util.DigestFactory;

/* loaded from: classes2.dex */
public class PKCS5S2ParametersGenerator extends PBEParametersGenerator {

    /* renamed from: hMac */
    private InterfaceC5278Mac f20277hMac;

    /* renamed from: state */
    private byte[] f20278state;

    public PKCS5S2ParametersGenerator() {
        this(DigestFactory.createSHA1());
    }

    /* renamed from: F */
    private void m15498F(byte[] bArr, int i, byte[] bArr2, byte[] bArr3, int i2) {
        if (i == 0) {
            throw new IllegalArgumentException("iteration count must be at least 1.");
        }
        if (bArr != null) {
            this.f20277hMac.mo14979update(bArr, 0, bArr.length);
        }
        this.f20277hMac.mo14979update(bArr2, 0, bArr2.length);
        this.f20277hMac.mo14975doFinal(this.f20278state, 0);
        byte[] bArr4 = this.f20278state;
        System.arraycopy(bArr4, 0, bArr3, i2, bArr4.length);
        for (int i3 = 1; i3 < i; i3++) {
            InterfaceC5278Mac interfaceC5278Mac = this.f20277hMac;
            byte[] bArr5 = this.f20278state;
            interfaceC5278Mac.mo14979update(bArr5, 0, bArr5.length);
            this.f20277hMac.mo14975doFinal(this.f20278state, 0);
            int i4 = 0;
            while (true) {
                byte[] bArr6 = this.f20278state;
                if (i4 != bArr6.length) {
                    int i5 = i2 + i4;
                    bArr3[i5] = (byte) (bArr6[i4] ^ bArr3[i5]);
                    i4++;
                }
            }
        }
    }

    private byte[] generateDerivedKey(int i) {
        int i2;
        int macSize = this.f20277hMac.getMacSize();
        int i3 = ((i + macSize) - 1) / macSize;
        byte[] bArr = new byte[4];
        byte[] bArr2 = new byte[i3 * macSize];
        this.f20277hMac.mo14976init(new KeyParameter(this.password));
        int i4 = 0;
        for (int i5 = 1; i5 <= i3; i5++) {
            while (true) {
                byte b = (byte) (bArr[i2] + 1);
                bArr[i2] = b;
                i2 = b == 0 ? i2 - 1 : 3;
            }
            m15498F(this.f19139salt, this.iterationCount, bArr, bArr2, i4);
            i4 += macSize;
        }
        return bArr2;
    }

    @Override // org.bouncycastle.p194crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int i) {
        return generateDerivedParameters(i);
    }

    @Override // org.bouncycastle.p194crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i) {
        int i2 = i / 8;
        return new KeyParameter(generateDerivedKey(i2), 0, i2);
    }

    public PKCS5S2ParametersGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        C5360HMac c5360HMac = new C5360HMac(interfaceC5277Digest);
        this.f20277hMac = c5360HMac;
        this.f20278state = new byte[c5360HMac.getMacSize()];
    }

    @Override // org.bouncycastle.p194crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        byte[] bArrGenerateDerivedKey = generateDerivedKey(i3 + i4);
        return new ParametersWithIV(new KeyParameter(bArrGenerateDerivedKey, 0, i3), bArrGenerateDerivedKey, i3, i4);
    }
}
