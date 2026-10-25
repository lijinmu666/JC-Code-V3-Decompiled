package org.bouncycastle.p314pqc.p352legacy.p355rainbow;

import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class RainbowKeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: rkc */
    private RainbowKeyComputation f24034rkc;

    /* renamed from: version */
    private EnumC6223Version f24035version;

    /* renamed from: org.bouncycastle.pqc.legacy.rainbow.RainbowKeyPairGenerator$1 */
    public static /* synthetic */ class C62211 {
        static final /* synthetic */ int[] $SwitchMap$org$bouncycastle$pqc$legacy$rainbow$Version;

        static {
            int[] iArr = new int[EnumC6223Version.m18143values().length];
            $SwitchMap$org$bouncycastle$pqc$legacy$rainbow$Version = iArr;
            try {
                iArr[EnumC6223Version.CLASSIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$bouncycastle$pqc$legacy$rainbow$Version[EnumC6223Version.CIRCUMZENITHAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$org$bouncycastle$pqc$legacy$rainbow$Version[EnumC6223Version.COMPRESSED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private void initialize(KeyGenerationParameters keyGenerationParameters) {
        RainbowParameters parameters = ((RainbowKeyGenerationParameters) keyGenerationParameters).getParameters();
        this.f24034rkc = new RainbowKeyComputation(parameters, keyGenerationParameters.getRandom());
        this.f24035version = parameters.getVersion();
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        int i = C62211.$SwitchMap$org$bouncycastle$pqc$legacy$rainbow$Version[this.f24035version.ordinal()];
        if (i == 1) {
            return this.f24034rkc.genKeyPairClassical();
        }
        if (i == 2) {
            return this.f24034rkc.genKeyPairCircumzenithal();
        }
        if (i == 3) {
            return this.f24034rkc.genKeyPairCompressed();
        }
        throw new IllegalArgumentException("No valid version. Please choose one of the following: classic, circumzenithal, compressed");
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        initialize(keyGenerationParameters);
    }
}
