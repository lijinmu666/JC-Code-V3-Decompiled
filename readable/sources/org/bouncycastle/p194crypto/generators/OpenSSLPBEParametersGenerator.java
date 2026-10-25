package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p194crypto.p221util.DigestFactory;

/* loaded from: classes2.dex */
public class OpenSSLPBEParametersGenerator extends PBEParametersGenerator {

    /* renamed from: digest */
    private final InterfaceC5277Digest f20272digest;

    public OpenSSLPBEParametersGenerator() {
        this(DigestFactory.createMD5());
    }

    private byte[] generateDerivedKey(int i) {
        int digestSize = this.f20272digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        byte[] bArr2 = new byte[i];
        int i2 = 0;
        while (true) {
            InterfaceC5277Digest interfaceC5277Digest = this.f20272digest;
            byte[] bArr3 = this.password;
            interfaceC5277Digest.mo14970update(bArr3, 0, bArr3.length);
            InterfaceC5277Digest interfaceC5277Digest2 = this.f20272digest;
            byte[] bArr4 = this.f19139salt;
            interfaceC5277Digest2.mo14970update(bArr4, 0, bArr4.length);
            this.f20272digest.mo14967doFinal(bArr, 0);
            int i3 = i > digestSize ? digestSize : i;
            System.arraycopy(bArr, 0, bArr2, i2, i3);
            i2 += i3;
            i -= i3;
            if (i == 0) {
                return bArr2;
            }
            this.f20272digest.mo14968reset();
            this.f20272digest.mo14970update(bArr, 0, digestSize);
        }
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

    /* renamed from: init */
    public void m15496init(byte[] bArr, byte[] bArr2) {
        super.m14982init(bArr, bArr2, 1);
    }

    public OpenSSLPBEParametersGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        this.f20272digest = interfaceC5277Digest;
    }

    @Override // org.bouncycastle.p194crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        byte[] bArrGenerateDerivedKey = generateDerivedKey(i3 + i4);
        return new ParametersWithIV(new KeyParameter(bArrGenerateDerivedKey, 0, i3), bArrGenerateDerivedKey, i3, i4);
    }
}
