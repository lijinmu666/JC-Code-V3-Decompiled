package org.bouncycastle.p314pqc.p316crypto.p329snova;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SnovaKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {
    static final int privateSeedLength = 32;
    static final int publicSeedLength = 16;
    private static final int seedLength = 48;

    /* renamed from: engine */
    private SnovaEngine f23554engine;
    private boolean initialized;

    /* renamed from: params */
    private SnovaParameters f23555params;

    /* renamed from: random */
    private SecureRandom f23556random;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        if (!this.initialized) {
            throw new IllegalStateException("SNOVA key pair generator not initialized");
        }
        byte[] bArr = new byte[48];
        this.f23556random.nextBytes(bArr);
        byte[] bArr2 = new byte[this.f23555params.getPublicKeyLength()];
        int privateKeyLength = this.f23555params.getPrivateKeyLength();
        byte[] bArr3 = new byte[privateKeyLength];
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 0, 16);
        byte[] bArrCopyOfRange2 = C6238Arrays.copyOfRange(bArr, 16, 48);
        SnovaKeyElements snovaKeyElements = new SnovaKeyElements(this.f23555params);
        System.arraycopy(bArrCopyOfRange, 0, bArr2, 0, bArrCopyOfRange.length);
        this.f23554engine.genMap1T12Map2(snovaKeyElements, bArrCopyOfRange, bArrCopyOfRange2);
        this.f23554engine.m17859genP22(bArr2, bArrCopyOfRange.length, snovaKeyElements.f23550T12, snovaKeyElements.f23551map1.f23532p21, snovaKeyElements.f23552map2.f23536f12);
        System.arraycopy(bArrCopyOfRange, 0, bArr2, 0, bArrCopyOfRange.length);
        if (!this.f23555params.isSkIsSeed()) {
            int iM17869getO = this.f23555params.m17869getO();
            int iM17865getLsq = this.f23555params.m17865getLsq();
            int iM17870getV = this.f23555params.m17870getV();
            int i = iM17870getV * iM17869getO;
            int alpha = (this.f23555params.getAlpha() * iM17869getO * iM17865getLsq * 4) + (i * iM17865getLsq) + (((i * iM17870getV) + (i * iM17869getO) + (iM17869getO * iM17869getO * iM17870getV)) * iM17865getLsq);
            byte[] bArr4 = new byte[alpha];
            SnovaKeyElements.m17863copy4d(snovaKeyElements.f23552map2.f23537f21, bArr4, SnovaKeyElements.m17863copy4d(snovaKeyElements.f23552map2.f23536f12, bArr4, SnovaKeyElements.m17863copy4d(snovaKeyElements.f23552map2.f23535f11, bArr4, SnovaKeyElements.m17861copy3d(snovaKeyElements.f23550T12, bArr4, SnovaKeyElements.m17861copy3d(snovaKeyElements.f23551map1.f23534qAlpha2, bArr4, SnovaKeyElements.m17861copy3d(snovaKeyElements.f23551map1.f23533qAlpha1, bArr4, SnovaKeyElements.m17861copy3d(snovaKeyElements.f23551map1.f23529bAlpha, bArr4, SnovaKeyElements.m17861copy3d(snovaKeyElements.f23551map1.f23528aAlpha, bArr4, 0))))))));
            GF16Utils.encodeMergeInHalf(bArr4, alpha, bArr3);
            System.arraycopy(bArr, 0, bArr3, privateKeyLength - 48, 48);
            bArr = bArr3;
        }
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new SnovaPublicKeyParameters(this.f23555params, bArr2), (AsymmetricKeyParameter) new SnovaPrivateKeyParameters(this.f23555params, bArr));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        SnovaKeyGenerationParameters snovaKeyGenerationParameters = (SnovaKeyGenerationParameters) keyGenerationParameters;
        this.f23555params = snovaKeyGenerationParameters.getParameters();
        this.f23556random = snovaKeyGenerationParameters.getRandom();
        this.initialized = true;
        this.f23554engine = new SnovaEngine(this.f23555params);
    }
}
