package org.bouncycastle.p194crypto.p205hpke;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.RawAgreement;
import org.bouncycastle.p194crypto.agreement.BasicRawAgreement;
import org.bouncycastle.p194crypto.agreement.ECDHCBasicAgreement;
import org.bouncycastle.p194crypto.agreement.X25519Agreement;
import org.bouncycastle.p194crypto.agreement.X448Agreement;
import org.bouncycastle.p194crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.p194crypto.generators.X25519KeyPairGenerator;
import org.bouncycastle.p194crypto.generators.X448KeyPairGenerator;
import org.bouncycastle.p194crypto.p200ec.CustomNamedCurves;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.X448PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PublicKeyParameters;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;
import org.bouncycastle.p284math.p285ec.WNafUtil;
import org.bouncycastle.p284math.p285ec.p291rfc7748.AbstractC5860X25519;
import org.bouncycastle.p284math.p285ec.p291rfc7748.AbstractC5861X448;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* renamed from: org.bouncycastle.crypto.hpke.DHKEM */
/* loaded from: classes2.dex */
class C5349DHKEM extends AbstractC5352KEM {

    /* renamed from: Nenc */
    private int f20332Nenc;

    /* renamed from: Nsecret */
    private int f20333Nsecret;

    /* renamed from: Nsk */
    private int f20334Nsk;

    /* renamed from: bitmask */
    private byte f20335bitmask;
    ECDomainParameters domainParams;

    /* renamed from: hkdf */
    private C5350HKDF f20336hkdf;

    /* renamed from: kemId */
    private final short f20337kemId;

    /* renamed from: kpGen */
    private AsymmetricCipherKeyPairGenerator f20338kpGen;
    private RawAgreement rawAgreement;

    public C5349DHKEM(short s) {
        AsymmetricCipherKeyPairGenerator x25519KeyPairGenerator;
        KeyGenerationParameters x25519KeyGenerationParameters;
        ECKeyPairGenerator eCKeyPairGenerator;
        ECKeyGenerationParameters eCKeyGenerationParameters;
        this.f20337kemId = s;
        if (s == 32) {
            this.f20336hkdf = new C5350HKDF((short) 1);
            this.rawAgreement = new X25519Agreement();
            this.f20333Nsecret = 32;
            this.f20334Nsk = 32;
            this.f20332Nenc = 32;
            x25519KeyPairGenerator = new X25519KeyPairGenerator();
            this.f20338kpGen = x25519KeyPairGenerator;
            x25519KeyGenerationParameters = new X25519KeyGenerationParameters(getSecureRandom());
        } else {
            if (s != 33) {
                switch (s) {
                    case 16:
                        this.f20336hkdf = new C5350HKDF((short) 1);
                        this.domainParams = getDomainParameters("P-256");
                        this.rawAgreement = new BasicRawAgreement(new ECDHCBasicAgreement());
                        this.f20335bitmask = (byte) -1;
                        this.f20334Nsk = 32;
                        this.f20333Nsecret = 32;
                        this.f20332Nenc = 65;
                        eCKeyPairGenerator = new ECKeyPairGenerator();
                        this.f20338kpGen = eCKeyPairGenerator;
                        eCKeyGenerationParameters = new ECKeyGenerationParameters(this.domainParams, getSecureRandom());
                        break;
                    case 17:
                        this.f20336hkdf = new C5350HKDF((short) 2);
                        this.domainParams = getDomainParameters("P-384");
                        this.rawAgreement = new BasicRawAgreement(new ECDHCBasicAgreement());
                        this.f20335bitmask = (byte) -1;
                        this.f20334Nsk = 48;
                        this.f20333Nsecret = 48;
                        this.f20332Nenc = 97;
                        eCKeyPairGenerator = new ECKeyPairGenerator();
                        this.f20338kpGen = eCKeyPairGenerator;
                        eCKeyGenerationParameters = new ECKeyGenerationParameters(this.domainParams, getSecureRandom());
                        break;
                    case 18:
                        this.f20336hkdf = new C5350HKDF((short) 3);
                        this.domainParams = getDomainParameters("P-521");
                        this.rawAgreement = new BasicRawAgreement(new ECDHCBasicAgreement());
                        this.f20335bitmask = (byte) 1;
                        this.f20334Nsk = 66;
                        this.f20333Nsecret = 64;
                        this.f20332Nenc = 133;
                        eCKeyPairGenerator = new ECKeyPairGenerator();
                        this.f20338kpGen = eCKeyPairGenerator;
                        eCKeyGenerationParameters = new ECKeyGenerationParameters(this.domainParams, getSecureRandom());
                        break;
                    default:
                        throw new IllegalArgumentException("invalid kem id");
                }
                eCKeyPairGenerator.mo14944init(eCKeyGenerationParameters);
                return;
            }
            this.f20336hkdf = new C5350HKDF((short) 3);
            this.rawAgreement = new X448Agreement();
            this.f20333Nsecret = 64;
            this.f20334Nsk = 56;
            this.f20332Nenc = 56;
            x25519KeyPairGenerator = new X448KeyPairGenerator();
            this.f20338kpGen = x25519KeyPairGenerator;
            x25519KeyGenerationParameters = new X448KeyGenerationParameters(getSecureRandom());
        }
        x25519KeyPairGenerator.mo14944init(x25519KeyGenerationParameters);
    }

    private byte[] ExtractAndExpand(byte[] bArr, byte[] bArr2) {
        byte[] bArrConcatenate = C6238Arrays.concatenate(C6250Strings.toByteArray("KEM"), AbstractC6245Pack.shortToBigEndian(this.f20337kemId));
        return this.f20336hkdf.LabeledExpand(this.f20336hkdf.LabeledExtract(null, bArrConcatenate, "eae_prk", bArr), bArrConcatenate, "shared_secret", bArr2, this.f20333Nsecret);
    }

    private static byte[] calculateRawAgreement(RawAgreement rawAgreement, AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricKeyParameter asymmetricKeyParameter2) {
        rawAgreement.mo14986init(asymmetricKeyParameter);
        byte[] bArr = new byte[rawAgreement.getAgreementSize()];
        rawAgreement.calculateAgreement(asymmetricKeyParameter2, bArr, 0);
        return bArr;
    }

    private static ECDomainParameters getDomainParameters(String str) {
        return new ECDomainParameters(CustomNamedCurves.getByName(str));
    }

    private static SecureRandom getSecureRandom() {
        return CryptoServicesRegistrar.getSecureRandom();
    }

    private boolean validateSk(BigInteger bigInteger) {
        BigInteger bigIntegerM15723getN = this.domainParams.m15723getN();
        return bigInteger.compareTo(BigInteger.valueOf(1L)) >= 0 && bigInteger.compareTo(bigIntegerM15723getN) < 0 && WNafUtil.getNafWeight(bigInteger) >= (bigIntegerM15723getN.bitLength() >>> 2);
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    public byte[] AuthDecap(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair, AsymmetricKeyParameter asymmetricKeyParameter) {
        AsymmetricKeyParameter asymmetricKeyParameterDeserializePublicKey = DeserializePublicKey(bArr);
        this.rawAgreement.mo14986init(asymmetricCipherKeyPair.getPrivate());
        int agreementSize = this.rawAgreement.getAgreementSize();
        byte[] bArr2 = new byte[agreementSize * 2];
        this.rawAgreement.calculateAgreement(asymmetricKeyParameterDeserializePublicKey, bArr2, 0);
        this.rawAgreement.calculateAgreement(asymmetricKeyParameter, bArr2, agreementSize);
        return ExtractAndExpand(bArr2, C6238Arrays.concatenate(bArr, SerializePublicKey(asymmetricCipherKeyPair.getPublic()), SerializePublicKey(asymmetricKeyParameter)));
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    public byte[][] AuthEncap(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricCipherKeyPair asymmetricCipherKeyPair) {
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f20338kpGen.generateKeyPair();
        this.rawAgreement.mo14986init(asymmetricCipherKeyPairGenerateKeyPair.getPrivate());
        int agreementSize = this.rawAgreement.getAgreementSize();
        byte[] bArr = new byte[agreementSize * 2];
        this.rawAgreement.calculateAgreement(asymmetricKeyParameter, bArr, 0);
        this.rawAgreement.mo14986init(asymmetricCipherKeyPair.getPrivate());
        if (agreementSize != this.rawAgreement.getAgreementSize()) {
            throw new IllegalStateException();
        }
        this.rawAgreement.calculateAgreement(asymmetricKeyParameter, bArr, agreementSize);
        byte[] bArrSerializePublicKey = SerializePublicKey(asymmetricCipherKeyPairGenerateKeyPair.getPublic());
        return new byte[][]{ExtractAndExpand(bArr, C6238Arrays.concatenate(bArrSerializePublicKey, SerializePublicKey(asymmetricKeyParameter), SerializePublicKey(asymmetricCipherKeyPair.getPublic()))), bArrSerializePublicKey};
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    /* renamed from: Decap */
    public byte[] mo15540Decap(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair) {
        return ExtractAndExpand(calculateRawAgreement(this.rawAgreement, asymmetricCipherKeyPair.getPrivate(), DeserializePublicKey(bArr)), C6238Arrays.concatenate(bArr, SerializePublicKey(asymmetricCipherKeyPair.getPublic())));
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    public AsymmetricCipherKeyPair DeriveKeyPair(byte[] bArr) {
        byte[] bArrConcatenate = C6238Arrays.concatenate(C6250Strings.toByteArray("KEM"), AbstractC6245Pack.shortToBigEndian(this.f20337kemId));
        short s = this.f20337kemId;
        if (s == 32) {
            X25519PrivateKeyParameters x25519PrivateKeyParameters = new X25519PrivateKeyParameters(this.f20336hkdf.LabeledExpand(this.f20336hkdf.LabeledExtract(null, bArrConcatenate, "dkp_prk", bArr), bArrConcatenate, "sk", null, this.f20334Nsk));
            return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) x25519PrivateKeyParameters.generatePublicKey(), (AsymmetricKeyParameter) x25519PrivateKeyParameters);
        }
        if (s == 33) {
            X448PrivateKeyParameters x448PrivateKeyParameters = new X448PrivateKeyParameters(this.f20336hkdf.LabeledExpand(this.f20336hkdf.LabeledExtract(null, bArrConcatenate, "dkp_prk", bArr), bArrConcatenate, "sk", null, this.f20334Nsk));
            return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) x448PrivateKeyParameters.generatePublicKey(), (AsymmetricKeyParameter) x448PrivateKeyParameters);
        }
        switch (s) {
            case 16:
            case 17:
            case 18:
                byte[] bArrLabeledExtract = this.f20336hkdf.LabeledExtract(null, bArrConcatenate, "dkp_prk", bArr);
                for (int i = 0; i < 256; i++) {
                    byte[] bArrLabeledExpand = this.f20336hkdf.LabeledExpand(bArrLabeledExtract, bArrConcatenate, "candidate", new byte[]{(byte) i}, this.f20334Nsk);
                    bArrLabeledExpand[0] = (byte) (bArrLabeledExpand[0] & this.f20335bitmask);
                    BigInteger bigInteger = new BigInteger(1, bArrLabeledExpand);
                    if (validateSk(bigInteger)) {
                        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new ECPublicKeyParameters(new FixedPointCombMultiplier().multiply(this.domainParams.m15720getG(), bigInteger), this.domainParams), (AsymmetricKeyParameter) new ECPrivateKeyParameters(bigInteger, this.domainParams));
                    }
                }
                throw new IllegalStateException("DeriveKeyPairError");
            default:
                throw new IllegalStateException("invalid kem id");
        }
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    public AsymmetricCipherKeyPair DeserializePrivateKey(byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            throw new NullPointerException("'skEncoded' cannot be null");
        }
        if (bArr.length != this.f20334Nsk) {
            throw new IllegalArgumentException("'skEncoded' has invalid length");
        }
        AsymmetricKeyParameter asymmetricKeyParameterDeserializePublicKey = bArr2 != null ? DeserializePublicKey(bArr2) : null;
        short s = this.f20337kemId;
        if (s == 32) {
            X25519PrivateKeyParameters x25519PrivateKeyParameters = new X25519PrivateKeyParameters(bArr);
            if (asymmetricKeyParameterDeserializePublicKey == null) {
                asymmetricKeyParameterDeserializePublicKey = x25519PrivateKeyParameters.generatePublicKey();
            }
            return new AsymmetricCipherKeyPair(asymmetricKeyParameterDeserializePublicKey, (AsymmetricKeyParameter) x25519PrivateKeyParameters);
        }
        if (s == 33) {
            X448PrivateKeyParameters x448PrivateKeyParameters = new X448PrivateKeyParameters(bArr);
            if (asymmetricKeyParameterDeserializePublicKey == null) {
                asymmetricKeyParameterDeserializePublicKey = x448PrivateKeyParameters.generatePublicKey();
            }
            return new AsymmetricCipherKeyPair(asymmetricKeyParameterDeserializePublicKey, (AsymmetricKeyParameter) x448PrivateKeyParameters);
        }
        switch (s) {
            case 16:
            case 17:
            case 18:
                ECPrivateKeyParameters eCPrivateKeyParameters = new ECPrivateKeyParameters(new BigInteger(1, bArr), this.domainParams);
                if (asymmetricKeyParameterDeserializePublicKey == null) {
                    asymmetricKeyParameterDeserializePublicKey = new ECPublicKeyParameters(new FixedPointCombMultiplier().multiply(this.domainParams.m15720getG(), eCPrivateKeyParameters.m15727getD()), this.domainParams);
                }
                return new AsymmetricCipherKeyPair(asymmetricKeyParameterDeserializePublicKey, (AsymmetricKeyParameter) eCPrivateKeyParameters);
            default:
                throw new IllegalStateException("invalid kem id");
        }
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    public AsymmetricKeyParameter DeserializePublicKey(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'pkEncoded' cannot be null");
        }
        if (bArr.length != this.f20332Nenc) {
            throw new IllegalArgumentException("'pkEncoded' has invalid length");
        }
        short s = this.f20337kemId;
        if (s == 32) {
            return new X25519PublicKeyParameters(bArr);
        }
        if (s == 33) {
            return new X448PublicKeyParameters(bArr);
        }
        switch (s) {
            case 16:
            case 17:
            case 18:
                if (bArr[0] == 4) {
                    return new ECPublicKeyParameters(this.domainParams.getCurve().decodePoint(bArr), this.domainParams);
                }
                throw new IllegalArgumentException("'pkEncoded' has invalid format");
            default:
                throw new IllegalStateException("invalid kem id");
        }
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    /* renamed from: Encap */
    public byte[][] mo15541Encap(AsymmetricKeyParameter asymmetricKeyParameter) {
        return mo15542Encap(asymmetricKeyParameter, this.f20338kpGen.generateKeyPair());
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    public AsymmetricCipherKeyPair GeneratePrivateKey() {
        return this.f20338kpGen.generateKeyPair();
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    public byte[] SerializePrivateKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        short s = this.f20337kemId;
        if (s == 32) {
            byte[] encoded = ((X25519PrivateKeyParameters) asymmetricKeyParameter).getEncoded();
            AbstractC5860X25519.clampPrivateKey(encoded);
            return encoded;
        }
        if (s != 33) {
            switch (s) {
                case 16:
                case 17:
                case 18:
                    return BigIntegers.asUnsignedByteArray(this.f20334Nsk, ((ECPrivateKeyParameters) asymmetricKeyParameter).m15727getD());
                default:
                    throw new IllegalStateException("invalid kem id");
            }
        }
        byte[] encoded2 = ((X448PrivateKeyParameters) asymmetricKeyParameter).getEncoded();
        AbstractC5861X448.clampPrivateKey(encoded2);
        return encoded2;
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    public byte[] SerializePublicKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        short s = this.f20337kemId;
        if (s == 32) {
            return ((X25519PublicKeyParameters) asymmetricKeyParameter).getEncoded();
        }
        if (s == 33) {
            return ((X448PublicKeyParameters) asymmetricKeyParameter).getEncoded();
        }
        switch (s) {
            case 16:
            case 17:
            case 18:
                return ((ECPublicKeyParameters) asymmetricKeyParameter).m15728getQ().getEncoded(false);
            default:
                throw new IllegalStateException("invalid kem id");
        }
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    public int getEncryptionSize() {
        return this.f20332Nenc;
    }

    @Override // org.bouncycastle.p194crypto.p205hpke.AbstractC5352KEM
    /* renamed from: Encap */
    public byte[][] mo15542Encap(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricCipherKeyPair asymmetricCipherKeyPair) {
        byte[] bArrCalculateRawAgreement = calculateRawAgreement(this.rawAgreement, asymmetricCipherKeyPair.getPrivate(), asymmetricKeyParameter);
        byte[] bArrSerializePublicKey = SerializePublicKey(asymmetricCipherKeyPair.getPublic());
        return new byte[][]{ExtractAndExpand(bArrCalculateRawAgreement, C6238Arrays.concatenate(bArrSerializePublicKey, SerializePublicKey(asymmetricKeyParameter))), bArrSerializePublicKey};
    }
}
