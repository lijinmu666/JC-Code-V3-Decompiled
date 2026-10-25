package org.bouncycastle.p177cert.p186ocsp;

import java.util.Date;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.p164ocsp.RevokedInfo;
import org.bouncycastle.p133asn1.p174x509.CRLReason;

/* loaded from: classes2.dex */
public class RevokedStatus implements CertificateStatus {

    /* renamed from: info */
    RevokedInfo f18897info;

    public RevokedStatus(Date date) {
        this.f18897info = new RevokedInfo(new ASN1GeneralizedTime(date));
    }

    public int getRevocationReason() {
        if (this.f18897info.getRevocationReason() != null) {
            return this.f18897info.getRevocationReason().getValue().intValue();
        }
        throw new IllegalStateException("attempt to get a reason where none is available");
    }

    public Date getRevocationTime() {
        return OCSPUtils.extractDate(this.f18897info.getRevocationTime());
    }

    public boolean hasRevocationReason() {
        return this.f18897info.getRevocationReason() != null;
    }

    public RevokedStatus(Date date, int i) {
        this.f18897info = new RevokedInfo(new ASN1GeneralizedTime(date), CRLReason.m14676lookup(i));
    }

    public RevokedStatus(RevokedInfo revokedInfo) {
        this.f18897info = revokedInfo;
    }
}
