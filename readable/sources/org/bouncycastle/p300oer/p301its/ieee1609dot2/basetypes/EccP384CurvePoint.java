package org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes;

import org.bouncycastle.p133asn1.ASN1Choice;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class EccP384CurvePoint extends EccCurvePoint implements ASN1Choice {
    public static final int compressedY0 = 2;
    public static final int compressedY1 = 3;

    /* renamed from: fill */
    public static final int f22707fill = 1;
    public static final int uncompressedP384 = 4;

    /* renamed from: xonly */
    public static final int f22708xonly = 0;

    /* renamed from: choice */
    private final int f22709choice;
    private final ASN1Encodable eccP384CurvePoint;

    public EccP384CurvePoint(int i, ASN1Encodable aSN1Encodable) {
        this.f22709choice = i;
        this.eccP384CurvePoint = aSN1Encodable;
    }

    public static EccP384CurvePoint compressedY0(ASN1OctetString aSN1OctetString) {
        return new EccP384CurvePoint(2, aSN1OctetString);
    }

    public static EccP384CurvePoint compressedY1(ASN1OctetString aSN1OctetString) {
        return new EccP384CurvePoint(3, aSN1OctetString);
    }

    /* renamed from: fill */
    public static EccP384CurvePoint m17265fill() {
        return new EccP384CurvePoint(1, C5103DERNull.INSTANCE);
    }

    public static EccP384CurvePoint getInstance(Object obj) {
        if (obj instanceof EccP384CurvePoint) {
            return (EccP384CurvePoint) obj;
        }
        if (obj != null) {
            return new EccP384CurvePoint(ASN1TaggedObject.getContextInstance(obj));
        }
        return null;
    }

    public static EccP384CurvePoint uncompressedP384(Point384 point384) {
        return new EccP384CurvePoint(4, point384);
    }

    /* renamed from: xOnly */
    public static EccP384CurvePoint m17266xOnly(ASN1OctetString aSN1OctetString) {
        return new EccP384CurvePoint(0, aSN1OctetString);
    }

    public int getChoice() {
        return this.f22709choice;
    }

    public ASN1Encodable getEccP384CurvePoint() {
        return this.eccP384CurvePoint;
    }

    @Override // org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccCurvePoint
    public byte[] getEncodedPoint() {
        byte[] bArr;
        int i = this.f22709choice;
        if (i == 0) {
            throw new IllegalStateException("x Only not implemented");
        }
        if (i == 2) {
            byte[] octets = ASN1OctetString.getInstance(this.eccP384CurvePoint).getOctets();
            bArr = new byte[octets.length + 1];
            bArr[0] = 2;
            System.arraycopy(octets, 0, bArr, 1, octets.length);
        } else {
            if (i != 3) {
                if (i != 4) {
                    throw new IllegalStateException("unknown point choice");
                }
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(this.eccP384CurvePoint);
                return C6238Arrays.concatenate(new byte[]{4}, ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(0)).getOctets(), ASN1OctetString.getInstance(aSN1Sequence.getObjectAt(1)).getOctets());
            }
            byte[] octets2 = ASN1OctetString.getInstance(this.eccP384CurvePoint).getOctets();
            bArr = new byte[octets2.length + 1];
            bArr[0] = 3;
            System.arraycopy(octets2, 0, bArr, 1, octets2.length);
        }
        return bArr;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Object, org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.f22709choice, this.eccP384CurvePoint);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private EccP384CurvePoint(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable aSN1OctetString;
        this.f22709choice = aSN1TaggedObject.getTagNo();
        int tagNo = aSN1TaggedObject.getTagNo();
        if (tagNo == 0) {
            aSN1OctetString = ASN1OctetString.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo == 1) {
            aSN1OctetString = ASN1Null.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        } else if (tagNo != 2 && tagNo != 3) {
            if (tagNo != 4) {
                throw new IllegalArgumentException("invalid choice value " + aSN1TaggedObject.getTagNo());
            }
            aSN1OctetString = ASN1Sequence.getInstance(aSN1TaggedObject.getExplicitBaseObject());
        }
        this.eccP384CurvePoint = aSN1OctetString;
    }

    public static EccP384CurvePoint compressedY0(byte[] bArr) {
        return new EccP384CurvePoint(2, new DEROctetString(C6238Arrays.m18231clone(bArr)));
    }

    public static EccP384CurvePoint compressedY1(byte[] bArr) {
        return new EccP384CurvePoint(3, new DEROctetString(C6238Arrays.m18231clone(bArr)));
    }

    /* renamed from: xOnly */
    public static EccP384CurvePoint m17267xOnly(byte[] bArr) {
        return new EccP384CurvePoint(0, new DEROctetString(C6238Arrays.m18231clone(bArr)));
    }
}
