package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p300oer.p301its.ItsUtils;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class EcdsaP256Signature extends ASN1Object {

    /* renamed from: rSig */
    private final EccP256CurvePoint f22710rSig;

    /* renamed from: sSig */
    private final ASN1OctetString f22711sSig;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.EcdsaP256Signature$Builder */
    public static class C5945Builder {

        /* renamed from: rSig */
        private EccP256CurvePoint f22712rSig;

        /* renamed from: sSig */
        private ASN1OctetString f22713sSig;

        public EcdsaP256Signature createEcdsaP256Signature() {
            return new EcdsaP256Signature(this.f22712rSig, this.f22713sSig);
        }

        /* renamed from: setRSig */
        public C5945Builder m17271setRSig(EccP256CurvePoint eccP256CurvePoint) {
            this.f22712rSig = eccP256CurvePoint;
            return this;
        }

        /* renamed from: setSSig */
        public C5945Builder m17272setSSig(ASN1OctetString aSN1OctetString) {
            this.f22713sSig = aSN1OctetString;
            return this;
        }

        /* renamed from: setSSig */
        public C5945Builder m17273setSSig(byte[] bArr) {
            this.f22713sSig = new DEROctetString(C6238Arrays.m18231clone(bArr));
            return this;
        }
    }

    private EcdsaP256Signature(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        this.f22710rSig = EccP256CurvePoint.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22711sSig = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
    }

    /* renamed from: builder */
    public static C5945Builder m17268builder() {
        return new C5945Builder();
    }

    public static EcdsaP256Signature getInstance(Object obj) {
        if (obj instanceof EcdsaP256Signature) {
            return (EcdsaP256Signature) obj;
        }
        if (obj != null) {
            return new EcdsaP256Signature(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getRSig */
    public EccP256CurvePoint m17269getRSig() {
        return this.f22710rSig;
    }

    /* renamed from: getSSig */
    public ASN1OctetString m17270getSSig() {
        return this.f22711sSig;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.f22710rSig, this.f22711sSig);
    }

    public EcdsaP256Signature(EccP256CurvePoint eccP256CurvePoint, ASN1OctetString aSN1OctetString) {
        this.f22710rSig = eccP256CurvePoint;
        this.f22711sSig = aSN1OctetString;
    }
}
