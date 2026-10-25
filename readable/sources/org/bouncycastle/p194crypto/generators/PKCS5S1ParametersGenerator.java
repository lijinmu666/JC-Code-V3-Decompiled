package org.bouncycastle.p194crypto.generators;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;

/* loaded from: classes2.dex */
public class PKCS5S1ParametersGenerator extends PBEParametersGenerator {

    /* renamed from: digest */
    private InterfaceC5277Digest f20276digest;

    public PKCS5S1ParametersGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        this.f20276digest = interfaceC5277Digest;
    }

    private byte[] generateDerivedKey() {
        int digestSize = this.f20276digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        InterfaceC5277Digest interfaceC5277Digest = this.f20276digest;
        byte[] bArr2 = this.password;
        interfaceC5277Digest.mo14970update(bArr2, 0, bArr2.length);
        InterfaceC5277Digest interfaceC5277Digest2 = this.f20276digest;
        byte[] bArr3 = this.f19139salt;
        interfaceC5277Digest2.mo14970update(bArr3, 0, bArr3.length);
        this.f20276digest.mo14967doFinal(bArr, 0);
        for (int i = 1; i < this.iterationCount; i++) {
            this.f20276digest.mo14970update(bArr, 0, digestSize);
            this.f20276digest.mo14967doFinal(bArr, 0);
        }
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.PBEParametersGenerator
    public CipherParameters generateDerivedMacParameters(int i) {
        return generateDerivedParameters(i);
    }

    @Override // org.bouncycastle.p194crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i) {
        int i2 = i / 8;
        if (i2 <= this.f20276digest.getDigestSize()) {
            return new KeyParameter(generateDerivedKey(), 0, i2);
        }
        throw new IllegalArgumentException("Can't generate a derived key " + i2 + " bytes long.");
    }

    @Override // org.bouncycastle.p194crypto.PBEParametersGenerator
    public CipherParameters generateDerivedParameters(int i, int i2) {
        int i3 = i / 8;
        int i4 = i2 / 8;
        int i5 = i3 + i4;
        if (i5 <= this.f20276digest.getDigestSize()) {
            byte[] bArrGenerateDerivedKey = generateDerivedKey();
            return new ParametersWithIV(new KeyParameter(bArrGenerateDerivedKey, 0, i3), bArrGenerateDerivedKey, i3, i4);
        }
        throw new IllegalArgumentException("Can't generate a derived key " + i5 + " bytes long.");
    }
}
