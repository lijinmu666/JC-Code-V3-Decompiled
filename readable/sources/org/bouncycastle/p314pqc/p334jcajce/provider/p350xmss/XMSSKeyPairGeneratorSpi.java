package org.bouncycastle.p314pqc.p334jcajce.provider.p350xmss;

import java.security.InvalidAlgorithmParameterException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyGenerationParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyPairGenerator;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSPublicKeyParameters;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.XMSSParameterSpec;

/* loaded from: classes2.dex */
public class XMSSKeyPairGeneratorSpi extends KeyPairGenerator {

    /* renamed from: engine */
    private XMSSKeyPairGenerator f23881engine;
    private boolean initialised;

    /* renamed from: param */
    private XMSSKeyGenerationParameters f23882param;

    /* renamed from: random */
    private SecureRandom f23883random;
    private ASN1ObjectIdentifier treeDigest;

    public XMSSKeyPairGeneratorSpi() {
        super("XMSS");
        this.f23881engine = new XMSSKeyPairGenerator();
        this.f23883random = CryptoServicesRegistrar.getSecureRandom();
        this.initialised = false;
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public KeyPair generateKeyPair() {
        if (!this.initialised) {
            XMSSKeyGenerationParameters xMSSKeyGenerationParameters = new XMSSKeyGenerationParameters(new XMSSParameters(10, new SHA512Digest()), this.f23883random);
            this.f23882param = xMSSKeyGenerationParameters;
            this.f23881engine.mo14944init(xMSSKeyGenerationParameters);
            this.initialised = true;
        }
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair = this.f23881engine.generateKeyPair();
        return new KeyPair(new BCXMSSPublicKey(this.treeDigest, (XMSSPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()), new BCXMSSPrivateKey(this.treeDigest, (XMSSPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()));
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(int i, SecureRandom secureRandom) {
        throw new IllegalArgumentException("use AlgorithmParameterSpec");
    }

    @Override // java.security.KeyPairGenerator, java.security.KeyPairGeneratorSpi
    public void initialize(AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidAlgorithmParameterException {
        XMSSKeyGenerationParameters xMSSKeyGenerationParameters;
        if (!(algorithmParameterSpec instanceof XMSSParameterSpec)) {
            throw new InvalidAlgorithmParameterException("parameter object not a XMSSParameterSpec");
        }
        XMSSParameterSpec xMSSParameterSpec = (XMSSParameterSpec) algorithmParameterSpec;
        if (xMSSParameterSpec.getTreeDigest().equals("SHA256")) {
            this.treeDigest = NISTObjectIdentifiers.id_sha256;
            xMSSKeyGenerationParameters = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHA256Digest()), secureRandom);
        } else if (xMSSParameterSpec.getTreeDigest().equals("SHA512")) {
            this.treeDigest = NISTObjectIdentifiers.id_sha512;
            xMSSKeyGenerationParameters = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHA512Digest()), secureRandom);
        } else {
            if (!xMSSParameterSpec.getTreeDigest().equals("SHAKE128")) {
                if (xMSSParameterSpec.getTreeDigest().equals("SHAKE256")) {
                    this.treeDigest = NISTObjectIdentifiers.id_shake256;
                    xMSSKeyGenerationParameters = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHAKEDigest(256)), secureRandom);
                }
                this.f23881engine.mo14944init(this.f23882param);
                this.initialised = true;
            }
            this.treeDigest = NISTObjectIdentifiers.id_shake128;
            xMSSKeyGenerationParameters = new XMSSKeyGenerationParameters(new XMSSParameters(xMSSParameterSpec.getHeight(), new SHAKEDigest(128)), secureRandom);
        }
        this.f23882param = xMSSKeyGenerationParameters;
        this.f23881engine.mo14944init(this.f23882param);
        this.initialised = true;
    }
}
