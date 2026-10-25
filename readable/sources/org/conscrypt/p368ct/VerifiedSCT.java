package org.conscrypt.p368ct;

/* loaded from: classes2.dex */
public final class VerifiedSCT {

    /* renamed from: sct */
    public final SignedCertificateTimestamp f24492sct;

    /* renamed from: status */
    public final EnumC6342Status f24493status;

    /* renamed from: org.conscrypt.ct.VerifiedSCT$Status */
    public enum EnumC6342Status {
        VALID,
        INVALID_SIGNATURE,
        UNKNOWN_LOG,
        INVALID_SCT
    }

    public VerifiedSCT(SignedCertificateTimestamp signedCertificateTimestamp, EnumC6342Status enumC6342Status) {
        this.f24492sct = signedCertificateTimestamp;
        this.f24493status = enumC6342Status;
    }
}
