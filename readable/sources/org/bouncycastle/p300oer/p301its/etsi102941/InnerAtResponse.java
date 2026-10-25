package org.bouncycastle.p300oer.p301its.etsi102941;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p300oer.OEROptional;
import org.bouncycastle.p300oer.p301its.etsi103097.EtsiTs103097Certificate;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class InnerAtResponse extends ASN1Object {
    private final EtsiTs103097Certificate certificate;
    private final ASN1OctetString requestHash;
    private final AuthorizationResponseCode responseCode;

    /* renamed from: org.bouncycastle.oer.its.etsi102941.InnerAtResponse$Builder */
    public static class C5905Builder {
        private EtsiTs103097Certificate certificate;
        private ASN1OctetString requestHash;
        private AuthorizationResponseCode responseCode;

        public InnerAtResponse createInnerAtResponse() {
            return new InnerAtResponse(this.requestHash, this.responseCode, this.certificate);
        }

        public C5905Builder setCertificate(EtsiTs103097Certificate etsiTs103097Certificate) {
            this.certificate = etsiTs103097Certificate;
            return this;
        }

        public C5905Builder setRequestHash(ASN1OctetString aSN1OctetString) {
            this.requestHash = aSN1OctetString;
            return this;
        }

        public C5905Builder setResponseCode(AuthorizationResponseCode authorizationResponseCode) {
            this.responseCode = authorizationResponseCode;
            return this;
        }

        public C5905Builder setRequestHash(byte[] bArr) {
            this.requestHash = new DEROctetString(C6238Arrays.m18231clone(bArr));
            return this;
        }
    }

    public InnerAtResponse(ASN1OctetString aSN1OctetString, AuthorizationResponseCode authorizationResponseCode, EtsiTs103097Certificate etsiTs103097Certificate) {
        this.requestHash = aSN1OctetString;
        this.responseCode = authorizationResponseCode;
        this.certificate = etsiTs103097Certificate;
    }

    /* renamed from: builder */
    public static C5905Builder m17194builder() {
        return new C5905Builder();
    }

    public static InnerAtResponse getInstance(Object obj) {
        if (obj instanceof InnerAtResponse) {
            return (InnerAtResponse) obj;
        }
        if (obj != null) {
            return new InnerAtResponse(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public EtsiTs103097Certificate getCertificate() {
        return this.certificate;
    }

    public ASN1OctetString getRequestHash() {
        return this.requestHash;
    }

    public AuthorizationResponseCode getResponseCode() {
        return this.responseCode;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.requestHash, this.responseCode, OEROptional.getInstance(this.certificate)});
    }

    private InnerAtResponse(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("expected sequence size of 3");
        }
        this.requestHash = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.responseCode = AuthorizationResponseCode.getInstance((Object) aSN1Sequence.getObjectAt(1));
        this.certificate = (EtsiTs103097Certificate) OEROptional.getValue(EtsiTs103097Certificate.class, aSN1Sequence.getObjectAt(2));
    }
}
