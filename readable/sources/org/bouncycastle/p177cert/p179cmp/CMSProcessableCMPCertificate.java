package org.bouncycastle.p177cert.p179cmp;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p138cmp.CMPCertificate;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.CMSTypedData;

/* loaded from: classes2.dex */
public class CMSProcessableCMPCertificate implements CMSTypedData {

    /* renamed from: cmpCert */
    private final CMPCertificate f18809cmpCert;

    public CMSProcessableCMPCertificate(CMPCertificate cMPCertificate) {
        this.f18809cmpCert = cMPCertificate;
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    public Object getContent() {
        return this.f18809cmpCert;
    }

    @Override // org.bouncycastle.p191cms.CMSTypedData
    public ASN1ObjectIdentifier getContentType() {
        return PKCSObjectIdentifiers.f18493data;
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    /* renamed from: write */
    public void mo14759write(OutputStream outputStream) throws IOException {
        outputStream.write(this.f18809cmpCert.getEncoded());
    }

    public CMSProcessableCMPCertificate(X509CertificateHolder x509CertificateHolder) {
        this(new CMPCertificate(x509CertificateHolder.toASN1Structure()));
    }
}
