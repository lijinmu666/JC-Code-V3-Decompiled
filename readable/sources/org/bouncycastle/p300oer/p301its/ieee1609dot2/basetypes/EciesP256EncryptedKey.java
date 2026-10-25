package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class EciesP256EncryptedKey extends ASN1Object {

    /* renamed from: c */
    private final ASN1OctetString f22718c;

    /* renamed from: t */
    private final ASN1OctetString f22719t;

    /* renamed from: v */
    private final EccP256CurvePoint f22720v;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.EciesP256EncryptedKey$Builder */
    public static class C5947Builder {

        /* renamed from: c */
        private ASN1OctetString f22721c;

        /* renamed from: t */
        private ASN1OctetString f22722t;

        /* renamed from: v */
        private EccP256CurvePoint f22723v;

        public EciesP256EncryptedKey createEciesP256EncryptedKey() {
            return new EciesP256EncryptedKey(this.f22723v, this.f22721c, this.f22722t);
        }

        /* renamed from: setC */
        public C5947Builder m17284setC(ASN1OctetString aSN1OctetString) {
            this.f22721c = aSN1OctetString;
            return this;
        }

        /* renamed from: setT */
        public C5947Builder m17286setT(ASN1OctetString aSN1OctetString) {
            this.f22722t = aSN1OctetString;
            return this;
        }

        /* renamed from: setV */
        public C5947Builder m17288setV(EccP256CurvePoint eccP256CurvePoint) {
            this.f22723v = eccP256CurvePoint;
            return this;
        }

        /* renamed from: setC */
        public C5947Builder m17285setC(byte[] bArr) {
            this.f22721c = new DEROctetString(C6238Arrays.m18231clone(bArr));
            return this;
        }

        /* renamed from: setT */
        public C5947Builder m17287setT(byte[] bArr) {
            this.f22722t = new DEROctetString(C6238Arrays.m18231clone(bArr));
            return this;
        }
    }

    private EciesP256EncryptedKey(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 3) {
            throw new IllegalArgumentException("expected sequence size of 3");
        }
        this.f22720v = EccP256CurvePoint.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22718c = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
        this.f22719t = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(2));
    }

    /* renamed from: builder */
    public static C5947Builder m17280builder() {
        return new C5947Builder();
    }

    public static EciesP256EncryptedKey getInstance(Object obj) {
        if (obj instanceof EciesP256EncryptedKey) {
            return (EciesP256EncryptedKey) obj;
        }
        if (obj != null) {
            return new EciesP256EncryptedKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getC */
    public ASN1OctetString m17281getC() {
        return this.f22718c;
    }

    /* renamed from: getT */
    public ASN1OctetString m17282getT() {
        return this.f22719t;
    }

    /* renamed from: getV */
    public EccP256CurvePoint m17283getV() {
        return this.f22720v;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22720v, this.f22718c, this.f22719t});
    }

    public EciesP256EncryptedKey(EccP256CurvePoint eccP256CurvePoint, ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        this.f22720v = eccP256CurvePoint;
        this.f22718c = aSN1OctetString;
        this.f22719t = aSN1OctetString2;
    }
}
