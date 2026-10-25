package org.bouncycastle.p314pqc.p334jcajce.provider.p345picnic;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p249jcajce.p280util.SpecUtil;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.PicnicParameterSpec;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicKeyGenerationParameters;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicKeyPairGenerator;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicParameters;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicPrivateKeyParameters;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicPublicKeyParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class PicnicKeyPairGeneratorSpi extends KeyPairGenerator {
    private static Map parameters;

    /* renamed from: engine */
    PicnicKeyPairGenerator f23835engine;
    boolean initialised;

    /* renamed from: param */
    PicnicKeyGenerationParameters f23836param;

    /* renamed from: random */
    SecureRandom f23837random;

    static {
        HashMap map = new HashMap();
        parameters = map;
        map.put(PicnicParameterSpec.picnicl1fs.m18052getName(), PicnicParameters.picnicl1fs);
        parameters.put(PicnicParameterSpec.picnicl1ur.m18052getName(), PicnicParameters.picnicl1ur);
        parameters.put(PicnicParameterSpec.picnicl3fs.m18052getName(), PicnicParameters.picnicl3fs);
        parameters.put(PicnicParameterSpec.picnicl3ur.m18052getName(), PicnicParameters.picnicl3ur);
        parameters.put(PicnicParameterSpec.picnicl5fs.m18052getName(), PicnicParameters.picnicl5fs);
        parameters.put(PicnicParameterSpec.picnicl5ur.m18052getName(), PicnicParameters.picnicl5ur);
        parameters.put(PicnicParameterSpec.picnic3l1.m18052getName(), PicnicParameters.picnic3l1);
        parameters.put(PicnicParameterSpec.picnic3l3.m18052getName(), PicnicParameters.picnic3l3);
        parameters.put(PicnicParameterSpec.picnic3l5.m18052getName(), PicnicParameters.picnic3l5);
        parameters.put(PicnicParameterSpec.picnicl1full.m18052getName(), PicnicParameters.picnicl1full);
        parameters.put(PicnicParameterSpec.picnicl3full.m18052getName(), PicnicParameters.picnicl3full);
        parameters.put(PicnicParameterSpec.picnicl5full.m18052getName(), PicnicParameters.picnicl5full);
    }

    public PicnicKeyPairGeneratorSpi() {
        super("Picnic");
        this.f23835engine = new PicnicKeyPairGenerator();
        this.f23837random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    private static String getNameFromParams(AlgorithmParameterSpec algorithmParameterSpec) {
        return algorithmParameterSpec instanceof PicnicParameterSpec ? ((PicnicParameterSpec) algorithmParameterSpec).m18052getName() : C6250Strings.toLowerCase(SpecUtil.getNameFrom(algorithmParameterSpec));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            PicnicKeyGenerationParameters picnicKeyGenerationParameters = new PicnicKeyGenerationParameters(this.f23837random, PicnicParameters.picnicl3ur);
            this.f23836param = picnicKeyGenerationParameters;
            this.f23835engine.mo14944init(picnicKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23835engine.generateKeyPair();
        return new KeyPair(new BCPicnicPublicKey((PicnicPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCPicnicPrivateKey((PicnicPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        String nameFromParams = getNameFromParams(algorithmParameterSpec);
        if (nameFromParams == null) {
            throw new InvalidAlgorithmParameterException("invalid ParameterSpec: " + algorithmParameterSpec);
        }
        PicnicKeyGenerationParameters picnicKeyGenerationParameters = new PicnicKeyGenerationParameters(secureRandom, (PicnicParameters) parameters.get(nameFromParams));
        this.f23836param = picnicKeyGenerationParameters;
        this.f23835engine.mo14944init(picnicKeyGenerationParameters);
        this.initialised = true;
    }
}
