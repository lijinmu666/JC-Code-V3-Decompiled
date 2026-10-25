package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class Point256 extends ASN1Object {

    /* renamed from: x */
    private final ASN1OctetString f22740x;

    /* renamed from: y */
    private final ASN1OctetString f22741y;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.Point256$Builder */
    public static class C5951Builder {

        /* renamed from: x */
        private ASN1OctetString f22742x;

        /* renamed from: y */
        private ASN1OctetString f22743y;

        public Point256 createPoint256() {
            return new Point256(this.f22742x, this.f22743y);
        }

        /* renamed from: setX */
        public C5951Builder m17294setX(BigInteger bigInteger) {
            return m17296setX(BigIntegers.asUnsignedByteArray(32, bigInteger));
        }

        /* renamed from: setY */
        public C5951Builder m17297setY(BigInteger bigInteger) {
            return m17299setY(BigIntegers.asUnsignedByteArray(32, bigInteger));
        }

        /* renamed from: setX */
        public C5951Builder m17295setX(ASN1OctetString aSN1OctetString) {
            this.f22742x = aSN1OctetString;
            return this;
        }

        /* renamed from: setY */
        public C5951Builder m17298setY(ASN1OctetString aSN1OctetString) {
            this.f22743y = aSN1OctetString;
            return this;
        }

        /* renamed from: setX */
        public C5951Builder m17296setX(byte[] bArr) {
            this.f22742x = new DEROctetString(bArr);
            return this;
        }

        /* renamed from: setY */
        public C5951Builder m17299setY(byte[] bArr) {
            this.f22743y = new DEROctetString(bArr);
            return this;
        }
    }

    public Point256(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        if (aSN1OctetString == null || aSN1OctetString.getOctets().length != 32) {
            throw new IllegalArgumentException("x must be 32 bytes long");
        }
        if (aSN1OctetString2 == null || aSN1OctetString2.getOctets().length != 32) {
            throw new IllegalArgumentException("y must be 32 bytes long");
        }
        this.f22740x = aSN1OctetString;
        this.f22741y = aSN1OctetString2;
    }

    /* renamed from: builder */
    public static C5951Builder m17291builder() {
        return new C5951Builder();
    }

    public static Point256 getInstance(Object obj) {
        if (obj instanceof Point256) {
            return (Point256) obj;
        }
        if (obj != null) {
            return new Point256(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getX */
    public ASN1OctetString m17292getX() {
        return this.f22740x;
    }

    /* renamed from: getY */
    public ASN1OctetString m17293getY() {
        return this.f22741y;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22740x, this.f22741y});
    }

    private Point256(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        ASN1OctetString aSN1OctetString = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22740x = aSN1OctetString;
        ASN1OctetString aSN1OctetString2 = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
        this.f22741y = aSN1OctetString2;
        if (aSN1OctetString.getOctets().length != 32) {
            throw new IllegalArgumentException("x must be 32 bytes long");
        }
        if (aSN1OctetString2.getOctets().length != 32) {
            throw new IllegalArgumentException("y must be 32 bytes long");
        }
    }
}
