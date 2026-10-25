package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.p301its.etsi102941.basetypes.EcSignature;

/* loaded from: classes2.dex */
public class AuthorizationValidationRequest extends ASN1Object {
    private final EcSignature ecSignature;
    private final SharedAtRequest sharedAtRequest;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.AuthorizationValidationRequest$Builder */
    public static class C5896Builder {
        private EcSignature ecSignature;
        private SharedAtRequest sharedAtRequest;

        public AuthorizationValidationRequest createAuthorizationValidationRequest() {
            return new AuthorizationValidationRequest(this.sharedAtRequest, this.ecSignature);
        }

        public C5896Builder setEcSignature(EcSignature ecSignature) {
            this.ecSignature = ecSignature;
            return this;
        }

        public C5896Builder setSharedAtRequest(SharedAtRequest sharedAtRequest) {
            this.sharedAtRequest = sharedAtRequest;
            return this;
        }
    }

    private AuthorizationValidationRequest(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.sharedAtRequest = SharedAtRequest.getInstance(aSN1Sequence.getObjectAt(0));
        this.ecSignature = EcSignature.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5896Builder m17173builder() {
        return new C5896Builder();
    }

    public static AuthorizationValidationRequest getInstance(Object obj) {
        if (obj instanceof AuthorizationValidationRequest) {
            return (AuthorizationValidationRequest) obj;
        }
        if (obj != null) {
            return new AuthorizationValidationRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EcSignature getEcSignature() {
        return this.ecSignature;
    }

    public SharedAtRequest getSharedAtRequest() {
        return this.sharedAtRequest;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.sharedAtRequest, this.ecSignature});
    }

    public AuthorizationValidationRequest(SharedAtRequest sharedAtRequest, EcSignature ecSignature) {
        this.sharedAtRequest = sharedAtRequest;
        this.ecSignature = ecSignature;
    }
}
