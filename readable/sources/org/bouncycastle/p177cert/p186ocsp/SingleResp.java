package org.bouncycastle.p177cert.p186ocsp;

import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p164ocsp.CertStatus;
import org.bouncycastle.p133asn1.p164ocsp.RevokedInfo;
import org.bouncycastle.p133asn1.p164ocsp.SingleResponse;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;

/* loaded from: classes2.dex */
public class SingleResp {
    private Extensions extensions;

    /* renamed from: resp */
    private SingleResponse f18898resp;

    public SingleResp(SingleResponse singleResponse) {
        this.f18898resp = singleResponse;
        this.extensions = singleResponse.getSingleExtensions();
    }

    public CertificateID getCertID() {
        return new CertificateID(this.f18898resp.getCertID());
    }

    public CertificateStatus getCertStatus() {
        CertStatus certStatus = this.f18898resp.getCertStatus();
        if (certStatus.getTagNo() == 0) {
            return null;
        }
        return certStatus.getTagNo() == 1 ? new RevokedStatus(RevokedInfo.getInstance(certStatus.getStatus())) : new UnknownStatus();
    }

    public Set getCriticalExtensionOIDs() {
        return OCSPUtils.getCriticalExtensionOIDs(this.extensions);
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Extensions extensions = this.extensions;
        if (extensions != null) {
            return extensions.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return OCSPUtils.getExtensionOIDs(this.extensions);
    }

    public Date getNextUpdate() {
        if (this.f18898resp.getNextUpdate() == null) {
            return null;
        }
        return OCSPUtils.extractDate(this.f18898resp.getNextUpdate());
    }

    public Set getNonCriticalExtensionOIDs() {
        return OCSPUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public Date getThisUpdate() {
        return OCSPUtils.extractDate(this.f18898resp.getThisUpdate());
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }
}
