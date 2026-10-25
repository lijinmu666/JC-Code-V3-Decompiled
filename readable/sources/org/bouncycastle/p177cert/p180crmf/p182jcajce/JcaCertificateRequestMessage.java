package org.bouncycastle.p177cert.p180crmf.p182jcajce;

import java.io.IOException;
import java.security.Provider;
import java.security.PublicKey;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.p141crmf.CertReqMsg;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.p180crmf.CertificateRequestMessage;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;

/* loaded from: classes2.dex */
public class JcaCertificateRequestMessage extends CertificateRequestMessage {

    /* renamed from: helper */
    private CRMFHelper f18854helper;

    public JcaCertificateRequestMessage(CertReqMsg certReqMsg) {
        super(certReqMsg);
        this.f18854helper = new CRMFHelper(new DefaultJcaJceHelper());
    }

    public PublicKey getPublicKey() {
        SubjectPublicKeyInfo publicKey = getCertTemplate().getPublicKey();
        if (publicKey != null) {
            return this.f18854helper.toPublicKey(publicKey);
        }
        return null;
    }

    public X500Principal getSubjectX500Principal() {
        X500Name subject = getCertTemplate().getSubject();
        if (subject == null) {
            return null;
        }
        try {
            return new X500Principal(subject.getEncoded(ASN1Encoding.f17902DER));
        } catch (IOException e) {
            throw new IllegalStateException("unable to construct DER encoding of name: " + e.getMessage());
        }
    }

    public JcaCertificateRequestMessage setProvider(String str) {
        this.f18854helper = new CRMFHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JcaCertificateRequestMessage(CertificateRequestMessage certificateRequestMessage) {
        this(certificateRequestMessage.toASN1Structure());
    }

    public JcaCertificateRequestMessage setProvider(Provider provider) {
        this.f18854helper = new CRMFHelper(new ProviderJcaJceHelper(provider));
        return this;
    }

    public JcaCertificateRequestMessage(byte[] bArr) {
        this(CertReqMsg.getInstance(bArr));
    }
}
