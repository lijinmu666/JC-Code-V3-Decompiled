package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.p301its.etsi102941.basetypes.EcSignature;
import org.bouncycastle.p300oer.p301its.etsi102941.basetypes.PublicKeys;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class InnerAtRequest extends ASN1Object {
    private final EcSignature ecSignature;

    /* renamed from: hmacKey */
    private final ASN1OctetString f22600hmacKey;
    private final PublicKeys publicKeys;
    private final SharedAtRequest sharedAtRequest;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.InnerAtRequest$Builder */
    public static class C5904Builder {
        private EcSignature ecSignature;

        /* renamed from: hmacKey */
        private ASN1OctetString f22601hmacKey;
        private PublicKeys publicKeys;
        private SharedAtRequest sharedAtRequest;

        public InnerAtRequest createInnerAtRequest() {
            return new InnerAtRequest(this.publicKeys, this.f22601hmacKey, this.sharedAtRequest, this.ecSignature);
        }

        public C5904Builder setEcSignature(EcSignature ecSignature) {
            this.ecSignature = ecSignature;
            return this;
        }

        public C5904Builder setHmacKey(ASN1OctetString aSN1OctetString) {
            this.f22601hmacKey = aSN1OctetString;
            return this;
        }

        public C5904Builder setPublicKeys(PublicKeys publicKeys) {
            this.publicKeys = publicKeys;
            return this;
        }

        public C5904Builder setSharedAtRequest(SharedAtRequest sharedAtRequest) {
            this.sharedAtRequest = sharedAtRequest;
            return this;
        }

        public C5904Builder setHmacKey(byte[] bArr) {
            this.f22601hmacKey = new DEROctetString(C6238Arrays.m18231clone(bArr));
            return this;
        }
    }

    private InnerAtRequest(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 4) {
            throw new IllegalArgumentException("expected sequence size of 4");
        }
        this.publicKeys = PublicKeys.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22600hmacKey = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
        this.sharedAtRequest = SharedAtRequest.getInstance(aSN1Sequence.getObjectAt(2));
        this.ecSignature = EcSignature.getInstance(aSN1Sequence.getObjectAt(3));
    }

    /* renamed from: builder */
    public static C5904Builder m17193builder() {
        return new C5904Builder();
    }

    public static InnerAtRequest getInstance(Object obj) {
        if (obj instanceof InnerAtRequest) {
            return (InnerAtRequest) obj;
        }
        if (obj != null) {
            return new InnerAtRequest(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EcSignature getEcSignature() {
        return this.ecSignature;
    }

    public ASN1OctetString getHmacKey() {
        return this.f22600hmacKey;
    }

    public PublicKeys getPublicKeys() {
        return this.publicKeys;
    }

    public SharedAtRequest getSharedAtRequest() {
        return this.sharedAtRequest;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.publicKeys, this.f22600hmacKey, this.sharedAtRequest, this.ecSignature});
    }

    public InnerAtRequest(PublicKeys publicKeys, ASN1OctetString aSN1OctetString, SharedAtRequest sharedAtRequest, EcSignature ecSignature) {
        this.publicKeys = publicKeys;
        this.f22600hmacKey = aSN1OctetString;
        this.sharedAtRequest = sharedAtRequest;
        this.ecSignature = ecSignature;
    }
}
