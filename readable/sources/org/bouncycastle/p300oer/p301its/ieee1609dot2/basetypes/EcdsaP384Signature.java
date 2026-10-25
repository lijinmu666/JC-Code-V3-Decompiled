package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class EcdsaP384Signature extends ASN1Object {

    /* renamed from: rSig */
    private final EccP384CurvePoint f22714rSig;

    /* renamed from: sSig */
    private final ASN1OctetString f22715sSig;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.EcdsaP384Signature$Builder */
    public static class C5946Builder {

        /* renamed from: rSig */
        private EccP384CurvePoint f22716rSig;

        /* renamed from: sSig */
        private ASN1OctetString f22717sSig;

        public EcdsaP384Signature createEcdsaP384Signature() {
            return new EcdsaP384Signature(this.f22716rSig, this.f22717sSig);
        }

        /* renamed from: setRSig */
        public C5946Builder m17277setRSig(EccP384CurvePoint eccP384CurvePoint) {
            this.f22716rSig = eccP384CurvePoint;
            return this;
        }

        /* renamed from: setSSig */
        public C5946Builder m17278setSSig(ASN1OctetString aSN1OctetString) {
            this.f22717sSig = aSN1OctetString;
            return this;
        }

        /* renamed from: setSSig */
        public C5946Builder m17279setSSig(byte[] bArr) {
            return m17278setSSig(new DEROctetString(C6238Arrays.m18231clone(bArr)));
        }
    }

    private EcdsaP384Signature(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22714rSig = EccP384CurvePoint.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22715sSig = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5946Builder m17274builder() {
        return new C5946Builder();
    }

    public static EcdsaP384Signature getInstance(Object obj) {
        if (obj instanceof EcdsaP384Signature) {
            return (EcdsaP384Signature) obj;
        }
        if (obj != null) {
            return new EcdsaP384Signature(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getRSig */
    public EccP384CurvePoint m17275getRSig() {
        return this.f22714rSig;
    }

    /* renamed from: getSSig */
    public ASN1OctetString m17276getSSig() {
        return this.f22715sSig;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22714rSig, this.f22715sSig);
    }

    public EcdsaP384Signature(EccP384CurvePoint eccP384CurvePoint, ASN1OctetString aSN1OctetString) {
        this.f22714rSig = eccP384CurvePoint;
        this.f22715sSig = aSN1OctetString;
    }
}
