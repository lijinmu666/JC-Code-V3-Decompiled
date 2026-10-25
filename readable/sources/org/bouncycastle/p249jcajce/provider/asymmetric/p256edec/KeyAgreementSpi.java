package org.bouncycastle.p249jcajce.provider.asymmetric.p256edec;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.RawAgreement;
import org.bouncycastle.p194crypto.agreement.X25519Agreement;
import org.bouncycastle.p194crypto.agreement.X448Agreement;
import org.bouncycastle.p194crypto.agreement.XDHUnifiedAgreement;
import org.bouncycastle.p194crypto.agreement.p197kdf.ConcatenationKDFGenerator;
import org.bouncycastle.p194crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.p194crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.XDHUPrivateParameters;
import org.bouncycastle.p194crypto.p213params.XDHUPublicParameters;
import org.bouncycastle.p194crypto.p221util.DigestFactory;
import org.bouncycastle.p249jcajce.p279spec.DHUParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.UserKeyingMaterialSpec;
import org.bouncycastle.p249jcajce.p279spec.XDHParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes2.dex */
public class KeyAgreementSpi extends BaseAgreementSpi {
    private RawAgreement agreement;

    /* renamed from: dhuSpec */
    private DHUParameterSpec f21543dhuSpec;

    /* renamed from: result */
    private byte[] f21544result;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X25519 */
    public static final class C5553X25519 extends KeyAgreementSpi {
        public C5553X25519() {
            super(XDHParameterSpec.f21951X25519);
        }
    }

    public static class X25519UwithSHA256CKDF extends KeyAgreementSpi {
        public X25519UwithSHA256CKDF() {
            super("X25519UwithSHA256CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA256()));
        }
    }

    public static class X25519UwithSHA256KDF extends KeyAgreementSpi {
        public X25519UwithSHA256KDF() {
            super("X25519UwithSHA256KDF", new KDF2BytesGenerator(DigestFactory.createSHA256()));
        }
    }

    public static final class X25519withSHA256CKDF extends KeyAgreementSpi {
        public X25519withSHA256CKDF() {
            super("X25519withSHA256CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA256()));
        }
    }

    public static final class X25519withSHA256HKDF extends KeyAgreementSpi {
        public X25519withSHA256HKDF() {
            super("X25519withSHA256HKDF", new HKDFBytesGenerator(DigestFactory.createSHA256()));
        }
    }

    public static final class X25519withSHA256KDF extends KeyAgreementSpi {
        public X25519withSHA256KDF() {
            super("X25519withSHA256KDF", new KDF2BytesGenerator(DigestFactory.createSHA256()));
        }
    }

    public static class X25519withSHA384CKDF extends KeyAgreementSpi {
        public X25519withSHA384CKDF() {
            super("X25519withSHA384CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA384()));
        }
    }

    public static class X25519withSHA512CKDF extends KeyAgreementSpi {
        public X25519withSHA512CKDF() {
            super("X25519withSHA512CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA512()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$X448 */
    public static final class C5554X448 extends KeyAgreementSpi {
        public C5554X448() {
            super(XDHParameterSpec.f21952X448);
        }
    }

    public static class X448UwithSHA512CKDF extends KeyAgreementSpi {
        public X448UwithSHA512CKDF() {
            super("X448UwithSHA512CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA512()));
        }
    }

    public static class X448UwithSHA512KDF extends KeyAgreementSpi {
        public X448UwithSHA512KDF() {
            super("X448UwithSHA512KDF", new KDF2BytesGenerator(DigestFactory.createSHA512()));
        }
    }

    public static final class X448withSHA256CKDF extends KeyAgreementSpi {
        public X448withSHA256CKDF() {
            super("X448withSHA256CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA256()));
        }
    }

    public static class X448withSHA384CKDF extends KeyAgreementSpi {
        public X448withSHA384CKDF() {
            super("X448withSHA384CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA384()));
        }
    }

    public static final class X448withSHA512CKDF extends KeyAgreementSpi {
        public X448withSHA512CKDF() {
            super("X448withSHA512CKDF", new ConcatenationKDFGenerator(DigestFactory.createSHA512()));
        }
    }

    public static final class X448withSHA512HKDF extends KeyAgreementSpi {
        public X448withSHA512HKDF() {
            super("X448withSHA512HKDF", new HKDFBytesGenerator(DigestFactory.createSHA512()));
        }
    }

    public static final class X448withSHA512KDF extends KeyAgreementSpi {
        public X448withSHA512KDF() {
            super("X448withSHA512KDF", new KDF2BytesGenerator(DigestFactory.createSHA512()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.edec.KeyAgreementSpi$XDH */
    public static final class C5555XDH extends KeyAgreementSpi {
        public C5555XDH() {
            super("XDH");
        }
    }

    public KeyAgreementSpi(String str) {
        super(Properties.isOverrideSet(Properties.EMULATE_ORACLE) ? "XDH" : str, null);
    }

    private RawAgreement getAgreement(String str) throws InvalidKeyException {
        if (this.kaAlgorithm.equals("XDH") || this.kaAlgorithm.startsWith(str)) {
            return this.kaAlgorithm.indexOf(85) > 0 ? str.startsWith(XDHParameterSpec.f21952X448) ? new XDHUnifiedAgreement(new X448Agreement()) : new XDHUnifiedAgreement(new X25519Agreement()) : str.startsWith(XDHParameterSpec.f21952X448) ? new X448Agreement() : new X25519Agreement();
        }
        throw new InvalidKeyException("inappropriate key for " + this.kaAlgorithm);
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi
    public byte[] doCalcSecret() {
        return this.f21544result;
    }

    @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseAgreementSpi
    public void doInitFromKey(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        String str;
        if (!(key instanceof PrivateKey)) {
            throw new InvalidKeyException("private XDH key required");
        }
        AsymmetricKeyParameter asymmetricKeyParameterGeneratePrivateKeyParameter = EdECUtil.generatePrivateKeyParameter((PrivateKey) key);
        if (asymmetricKeyParameterGeneratePrivateKeyParameter instanceof X25519PrivateKeyParameters) {
            str = XDHParameterSpec.f21951X25519;
        } else {
            if (!(asymmetricKeyParameterGeneratePrivateKeyParameter instanceof X448PrivateKeyParameters)) {
                throw new InvalidKeyException("unsupported private key type");
            }
            str = XDHParameterSpec.f21952X448;
        }
        this.agreement = getAgreement(str);
        this.ukmParameters = null;
        this.ukmParametersSalt = null;
        if (algorithmParameterSpec instanceof DHUParameterSpec) {
            if (this.kaAlgorithm.indexOf(85) < 0) {
                throw new InvalidAlgorithmParameterException("agreement algorithm not DHU based");
            }
            DHUParameterSpec dHUParameterSpec = (DHUParameterSpec) algorithmParameterSpec;
            this.f21543dhuSpec = dHUParameterSpec;
            this.ukmParameters = dHUParameterSpec.getUserKeyingMaterial();
            this.agreement.mo14986init(new XDHUPrivateParameters(asymmetricKeyParameterGeneratePrivateKeyParameter, ((BCXDHPrivateKey) this.f21543dhuSpec.getEphemeralPrivateKey()).engineGetKeyParameters(), ((BCXDHPublicKey) this.f21543dhuSpec.getEphemeralPublicKey()).engineGetKeyParameters()));
        } else if (algorithmParameterSpec != null) {
            this.agreement.mo14986init(asymmetricKeyParameterGeneratePrivateKeyParameter);
            if (!(algorithmParameterSpec instanceof UserKeyingMaterialSpec)) {
                throw new InvalidAlgorithmParameterException("unknown ParameterSpec");
            }
            if (this.f21631kdf == null) {
                throw new InvalidAlgorithmParameterException("no KDF specified for UserKeyingMaterialSpec");
            }
            UserKeyingMaterialSpec userKeyingMaterialSpec = (UserKeyingMaterialSpec) algorithmParameterSpec;
            this.ukmParameters = userKeyingMaterialSpec.getUserKeyingMaterial();
            this.ukmParametersSalt = userKeyingMaterialSpec.m16222getSalt();
        } else {
            this.agreement.mo14986init(asymmetricKeyParameterGeneratePrivateKeyParameter);
        }
        if (this.f21631kdf == null || this.ukmParameters != null) {
            return;
        }
        this.ukmParameters = new byte[0];
    }

    @Override // javax.crypto.KeyAgreementSpi
    public Key engineDoPhase(Key key, boolean z) throws InvalidKeyException {
        if (!(key instanceof PublicKey)) {
            throw new InvalidKeyException("public XDH key required");
        }
        if (this.agreement == null) {
            throw new IllegalStateException(this.kaAlgorithm + " not initialised.");
        }
        if (!z) {
            throw new IllegalStateException(this.kaAlgorithm + " can only be between two parties.");
        }
        AsymmetricKeyParameter asymmetricKeyParameterGeneratePublicKeyParameter = EdECUtil.generatePublicKeyParameter((PublicKey) key);
        byte[] bArr = new byte[this.agreement.getAgreementSize()];
        this.f21544result = bArr;
        DHUParameterSpec dHUParameterSpec = this.f21543dhuSpec;
        if (dHUParameterSpec != null) {
            this.agreement.calculateAgreement(new XDHUPublicParameters(asymmetricKeyParameterGeneratePublicKeyParameter, ((BCXDHPublicKey) dHUParameterSpec.getOtherPartyEphemeralKey()).engineGetKeyParameters()), this.f21544result, 0);
            return null;
        }
        this.agreement.calculateAgreement(asymmetricKeyParameterGeneratePublicKeyParameter, bArr, 0);
        return null;
    }

    public KeyAgreementSpi(String str, DerivationFunction derivationFunction) {
        super(Properties.isOverrideSet(Properties.EMULATE_ORACLE) ? "XDH" : str, derivationFunction);
    }
}
