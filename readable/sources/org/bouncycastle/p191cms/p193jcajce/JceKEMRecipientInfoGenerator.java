package org.bouncycastle.p191cms.p193jcajce;

import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p139cms.IssuerAndSerialNumber;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateHolder;
import org.bouncycastle.p191cms.KEMRecipientInfoGenerator;

/* loaded from: classes2.dex */
public class JceKEMRecipientInfoGenerator extends KEMRecipientInfoGenerator {
    public JceKEMRecipientInfoGenerator(X509Certificate x509Certificate, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        super(new IssuerAndSerialNumber(new JcaX509CertificateHolder(x509Certificate).toASN1Structure()), new JceCMSKEMKeyWrapper(x509Certificate.getPublicKey(), aSN1ObjectIdentifier));
    }

    public JceKEMRecipientInfoGenerator setAlgorithmMapping(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str) {
        ((JceCMSKEMKeyWrapper) this.f19019wrapper).setAlgorithmMapping(aSN1ObjectIdentifier, str);
        return this;
    }

    /* renamed from: setKDF */
    public JceKEMRecipientInfoGenerator m14940setKDF(AlgorithmIdentifier algorithmIdentifier) {
        ((JceCMSKEMKeyWrapper) this.f19019wrapper).m14938setKDF(algorithmIdentifier);
        return this;
    }

    public JceKEMRecipientInfoGenerator setProvider(String str) {
        ((JceCMSKEMKeyWrapper) this.f19019wrapper).setProvider(str);
        return this;
    }

    public JceKEMRecipientInfoGenerator setSecureRandom(SecureRandom secureRandom) {
        ((JceCMSKEMKeyWrapper) this.f19019wrapper).setSecureRandom(secureRandom);
        return this;
    }

    public JceKEMRecipientInfoGenerator(byte[] bArr, PublicKey publicKey, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        super(bArr, new JceCMSKEMKeyWrapper(publicKey, aSN1ObjectIdentifier));
    }

    public JceKEMRecipientInfoGenerator setProvider(Provider provider) {
        ((JceCMSKEMKeyWrapper) this.f19019wrapper).setProvider(provider);
        return this;
    }
}
