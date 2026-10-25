package org.bouncycastle.p307pkcs.p309jcajce;

import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p307pkcs.PKCS10CertificationRequest;
import org.bouncycastle.p307pkcs.PKCS10CertificationRequestBuilder;

/* loaded from: classes2.dex */
public class JcaPKCS10CertificationRequestBuilder extends PKCS10CertificationRequestBuilder {
    public JcaPKCS10CertificationRequestBuilder(X500Principal x500Principal, PublicKey publicKey) {
        super(X500Name.getInstance(x500Principal.getEncoded()), SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
    }

    /* renamed from: build */
    public PKCS10CertificationRequest m17420build(ContentSigner contentSigner, PublicKey publicKey, ContentSigner contentSigner2) {
        return super.m17406build(contentSigner, SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()), contentSigner2);
    }

    public JcaPKCS10CertificationRequestBuilder(X500Name x500Name, PublicKey publicKey) {
        super(x500Name, SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
    }
}
