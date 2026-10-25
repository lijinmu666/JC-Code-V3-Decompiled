package org.bouncycastle.p314pqc.p316crypto.p322mayo;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p284math.p295raw.AbstractC5869Nat;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6242GF16;

/* loaded from: classes2.dex */
public class MayoKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: p */
    private MayoParameters f23272p;

    /* renamed from: random */
    private SecureRandom f23273random;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        int mVecLimbs = this.f23272p.getMVecLimbs();
        int iM17668getM = this.f23272p.m17668getM();
        int iM17672getV = this.f23272p.m17672getV();
        int iM17671getO = this.f23272p.m17671getO();
        int oBytes = this.f23272p.getOBytes();
        int p1Limbs = this.f23272p.getP1Limbs();
        int p3Limbs = this.f23272p.getP3Limbs();
        int pkSeedBytes = this.f23272p.getPkSeedBytes();
        int skSeedBytes = this.f23272p.getSkSeedBytes();
        byte[] bArr = new byte[this.f23272p.getCpkBytes()];
        byte[] bArr2 = new byte[this.f23272p.getCskBytes()];
        int i = oBytes + pkSeedBytes;
        byte[] bArr3 = new byte[i];
        long[] jArr = new long[this.f23272p.getP2Limbs() + p1Limbs];
        int i2 = iM17672getV * iM17671getO;
        byte[] bArr4 = new byte[i2];
        this.f23273random.nextBytes(bArr2);
        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
        int i3 = 0;
        sHAKEDigest.mo14970update(bArr2, 0, skSeedBytes);
        sHAKEDigest.mo14998doFinal(bArr3, 0, i);
        C6242GF16.m18285decode(bArr3, pkSeedBytes, bArr4, 0, i2);
        C6071Utils.expandP1P2(this.f23272p, jArr, bArr3);
        long[] jArr2 = new long[iM17671getO * iM17671getO * mVecLimbs];
        GF16Utils.mulAddMUpperTriangularMatXMat(mVecLimbs, jArr, bArr4, jArr, p1Limbs, iM17672getV, iM17671getO);
        GF16Utils.mulAddMatTransXMMat(mVecLimbs, bArr4, jArr, p1Limbs, jArr2, iM17672getV, iM17671getO);
        System.arraycopy(bArr3, 0, bArr, 0, pkSeedBytes);
        long[] jArr3 = new long[p3Limbs];
        int i4 = iM17671getO * mVecLimbs;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i3 < iM17671getO) {
            int i8 = i5;
            int i9 = i6;
            int i10 = i3;
            while (i10 < iM17671getO) {
                int i11 = iM17671getO;
                long[] jArr4 = jArr2;
                System.arraycopy(jArr4, i6 + i8, jArr3, i7, mVecLimbs);
                if (i3 != i10) {
                    AbstractC5869Nat.m16951xorTo64(mVecLimbs, jArr4, i9 + i5, jArr3, i7);
                }
                i7 += mVecLimbs;
                i10++;
                i8 += mVecLimbs;
                i9 += i4;
                jArr2 = jArr4;
                iM17671getO = i11;
            }
            i3++;
            i6 += i4;
            i5 += mVecLimbs;
            iM17671getO = iM17671getO;
        }
        C6071Utils.packMVecs(jArr3, bArr, pkSeedBytes, p3Limbs / mVecLimbs, iM17668getM);
        C6238Arrays.m18227clear(bArr4);
        C6238Arrays.m18230clear(jArr2);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new MayoPublicKeyParameters(this.f23272p, bArr), (AsymmetricKeyParameter) new MayoPrivateKeyParameters(this.f23272p, bArr2));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23272p = ((MayoKeyGenerationParameters) keyGenerationParameters).getParameters();
        this.f23273random = keyGenerationParameters.getRandom();
    }
}
