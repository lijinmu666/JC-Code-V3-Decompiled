package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.etsi102941.basetypes.CertificateSubjectAttributes;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class AuthorizationValidationResponse extends ASN1Object {
    private final CertificateSubjectAttributes confirmedSubjectAttributes;
    private final ASN1OctetString requestHash;
    private final AuthorizationValidationResponseCode responseCode;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.AuthorizationValidationResponse$Builder */
    public static class C5897Builder {
        private CertificateSubjectAttributes confirmedSubjectAttributes;
        private ASN1OctetString requestHash;
        private AuthorizationValidationResponseCode responseCode;

        public AuthorizationValidationResponse createAuthorizationValidationResponse() {
            return new AuthorizationValidationResponse(this.requestHash, this.responseCode, this.confirmedSubjectAttributes);
        }

        public C5897Builder setConfirmedSubjectAttributes(CertificateSubjectAttributes certificateSubjectAttributes) {
            this.confirmedSubjectAttributes = certificateSubjectAttributes;
            return this;
        }

        public C5897Builder setRequestHash(ASN1OctetString aSN1OctetString) {
            this.requestHash = aSN1OctetString;
            return this;
        }

        public C5897Builder setResponseCode(AuthorizationValidationResponseCode authorizationValidationResponseCode) {
            this.responseCode = authorizationValidationResponseCode;
            return this;
        }

        public C5897Builder setRequestHash(byte[] bArr) {
            this.requestHash = new DEROctetString(C6238Arrays.m18231clone(bArr));
            return this;
        }
    }

    public AuthorizationValidationResponse(ASN1OctetString aSN1OctetString, AuthorizationValidationResponseCode authorizationValidationResponseCode, CertificateSubjectAttributes certificateSubjectAttributes) {
        this.requestHash = aSN1OctetString;
        this.responseCode = authorizationValidationResponseCode;
        this.confirmedSubjectAttributes = certificateSubjectAttributes;
    }

    /* renamed from: builder */
    public static C5897Builder m17174builder() {
        return new C5897Builder();
    }

    public static AuthorizationValidationResponse getInstance(Object obj) {
        if (obj instanceof AuthorizationValidationResponse) {
            return (AuthorizationValidationResponse) obj;
        }
        if (obj != null) {
            return new AuthorizationValidationResponse(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertificateSubjectAttributes getConfirmedSubjectAttributes() {
        return this.confirmedSubjectAttributes;
    }

    public ASN1OctetString getRequestHash() {
        return this.requestHash;
    }

    public AuthorizationValidationResponseCode getResponseCode() {
        return this.responseCode;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.requestHash, this.responseCode, OEROptional.getInstance(this.confirmedSubjectAttributes)});
    }

    private AuthorizationValidationResponse(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("expected sequence size of 3");
        }
        this.requestHash = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.responseCode = AuthorizationValidationResponseCode.getInstance((Object) aSN1Sequence.getObjectAt(1));
        this.confirmedSubjectAttributes = (CertificateSubjectAttributes) OEROptional.getValue(CertificateSubjectAttributes.class, aSN1Sequence.getObjectAt(2));
    }
}
