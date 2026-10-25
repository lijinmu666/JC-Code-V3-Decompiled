package org.bouncycastle.p177cert.p179cmp;

import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.p133asn1.p138cmp.C5114PKIBody;
import org.bouncycastle.p133asn1.p138cmp.CertConfirmContent;
import org.bouncycastle.p133asn1.p138cmp.CertStatus;

/* loaded from: classes2.dex */
public class CertificateConfirmationContent {

    /* renamed from: content */
    private CertConfirmContent f18810content;
    private DigestAlgorithmIdentifierFinder digestAlgFinder;

    public CertificateConfirmationContent(CertConfirmContent certConfirmContent) {
        this(certConfirmContent, new DefaultDigestAlgorithmIdentifierFinder());
    }

    public static CertificateConfirmationContent fromPKIBody(C5114PKIBody c5114PKIBody) {
        return fromPKIBody(c5114PKIBody, new DefaultDigestAlgorithmIdentifierFinder());
    }

    public static boolean isCertificateConfirmationContent(int i) {
        return i == 24;
    }

    public CertificateStatus[] getStatusMessages() {
        CertStatus[] certStatusArray = this.f18810content.toCertStatusArray();
        int length = certStatusArray.length;
        CertificateStatus[] certificateStatusArr = new CertificateStatus[length];
        for (int i = 0; i != length; i++) {
            certificateStatusArr[i] = new CertificateStatus(this.digestAlgFinder, certStatusArray[i]);
        }
        return certificateStatusArr;
    }

    public CertConfirmContent toASN1Structure() {
        return this.f18810content;
    }

    public CertificateConfirmationContent(CertConfirmContent certConfirmContent, DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        this.digestAlgFinder = digestAlgorithmIdentifierFinder;
        this.f18810content = certConfirmContent;
    }

    public static CertificateConfirmationContent fromPKIBody(C5114PKIBody c5114PKIBody, DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        if (isCertificateConfirmationContent(c5114PKIBody.m14517getType())) {
            return new CertificateConfirmationContent(CertConfirmContent.getInstance(c5114PKIBody.getContent()), digestAlgorithmIdentifierFinder);
        }
        throw new IllegalArgumentException("content of PKIBody wrong type: " + c5114PKIBody.m14517getType());
    }
}
