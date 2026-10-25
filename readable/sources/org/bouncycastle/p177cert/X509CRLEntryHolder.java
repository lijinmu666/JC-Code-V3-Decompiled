package org.bouncycastle.p177cert;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.TBSCertList;

/* loaded from: classes2.dex */
public class X509CRLEntryHolder {

    /* renamed from: ca */
    private GeneralNames f18800ca;

    /* renamed from: entry */
    private TBSCertList.CRLEntry f18801entry;

    public X509CRLEntryHolder(TBSCertList.CRLEntry cRLEntry, boolean z, GeneralNames generalNames) {
        Extension extension;
        this.f18801entry = cRLEntry;
        this.f18800ca = generalNames;
        if (z && cRLEntry.hasExtensions() && (extension = cRLEntry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
            this.f18800ca = GeneralNames.getInstance(extension.getParsedValue());
        }
    }

    public GeneralNames getCertificateIssuer() {
        return this.f18800ca;
    }

    public Set getCriticalExtensionOIDs() {
        return CertUtils.getCriticalExtensionOIDs(this.f18801entry.getExtensions());
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Extensions extensions = this.f18801entry.getExtensions();
        if (extensions != null) {
            return extensions.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return CertUtils.getExtensionOIDs(this.f18801entry.getExtensions());
    }

    public Extensions getExtensions() {
        return this.f18801entry.getExtensions();
    }

    public Set getNonCriticalExtensionOIDs() {
        return CertUtils.getNonCriticalExtensionOIDs(this.f18801entry.getExtensions());
    }

    public Date getRevocationDate() {
        return this.f18801entry.getRevocationDate().m14707getDate();
    }

    public BigInteger getSerialNumber() {
        return this.f18801entry.getUserCertificate().getValue();
    }

    public boolean hasExtensions() {
        return this.f18801entry.hasExtensions();
    }
}
