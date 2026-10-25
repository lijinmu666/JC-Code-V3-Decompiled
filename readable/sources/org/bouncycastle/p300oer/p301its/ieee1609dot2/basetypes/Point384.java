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
public class Point384 extends ASN1Object {

    /* renamed from: x */
    private final ASN1OctetString f22744x;

    /* renamed from: y */
    private final ASN1OctetString f22745y;

    /* renamed from: org.bouncycastle.oer.its.ieee1609dot2.basetypes.Point384$Builder */
    public static class C5952Builder {

        /* renamed from: x */
        private ASN1OctetString f22746x;

        /* renamed from: y */
        private ASN1OctetString f22747y;

        public Point384 createPoint384() {
            return new Point384(this.f22746x, this.f22747y);
        }

        /* renamed from: setX */
        public C5952Builder m17303setX(BigInteger bigInteger) {
            this.f22746x = new DEROctetString(BigIntegers.asUnsignedByteArray(48, bigInteger));
            return this;
        }

        /* renamed from: setY */
        public C5952Builder m17306setY(BigInteger bigInteger) {
            this.f22747y = new DEROctetString(BigIntegers.asUnsignedByteArray(48, bigInteger));
            return this;
        }

        /* renamed from: setX */
        public C5952Builder m17304setX(ASN1OctetString aSN1OctetString) {
            this.f22746x = aSN1OctetString;
            return this;
        }

        /* renamed from: setY */
        public C5952Builder m17307setY(ASN1OctetString aSN1OctetString) {
            this.f22747y = aSN1OctetString;
            return this;
        }

        /* renamed from: setX */
        public C5952Builder m17305setX(byte[] bArr) {
            this.f22746x = new DEROctetString(bArr);
            return this;
        }

        /* renamed from: setY */
        public C5952Builder m17308setY(byte[] bArr) {
            this.f22747y = new DEROctetString(bArr);
            return this;
        }
    }

    public Point384(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        if (aSN1OctetString.getOctets().length != 48) {
            throw new IllegalArgumentException("x must be 48 bytes long");
        }
        if (aSN1OctetString2.getOctets().length != 48) {
            throw new IllegalArgumentException("y must be 48 bytes long");
        }
        this.f22744x = aSN1OctetString;
        this.f22745y = aSN1OctetString2;
    }

    /* renamed from: builder */
    public static C5952Builder m17300builder() {
        return new C5952Builder();
    }

    public static Point384 getInstance(Object obj) {
        if (obj instanceof Point384) {
            return (Point384) obj;
        }
        if (obj != null) {
            return new Point384(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    /* renamed from: getX */
    public ASN1OctetString m17301getX() {
        return this.f22744x;
    }

    /* renamed from: getY */
    public ASN1OctetString m17302getY() {
        return this.f22745y;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERSequence(new ASN1Encodable[]{this.f22744x, this.f22745y});
    }

    private Point384(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() != 2) {
            throw new IllegalArgumentException("expected sequence size of 2");
        }
        ASN1OctetString aSN1OctetString = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0));
        this.f22744x = aSN1OctetString;
        ASN1OctetString aSN1OctetString2 = ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1));
        this.f22745y = aSN1OctetString2;
        if (aSN1OctetString.getOctets().length != 48) {
            throw new IllegalArgumentException("x must be 48 bytes long");
        }
        if (aSN1OctetString2.getOctets().length != 48) {
            throw new IllegalArgumentException("y must be 48 bytes long");
        }
    }
}
