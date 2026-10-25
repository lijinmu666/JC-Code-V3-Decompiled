package org.bouncycastle.p133asn1;

import java.io.IOException;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes.dex */
public class BEROctetString extends ASN1OctetString {
    private static final int DEFAULT_SEGMENT_LIMIT = 1000;

    /* renamed from: EMPTY */
    public static final BEROctetString f17964EMPTY = new BEROctetString(ASN1OctetString.EMPTY_OCTETS);
    private final ASN1OctetString[] elements;
    private final int segmentLimit;

    public BEROctetString(byte[] bArr) {
        this(bArr, 1000);
    }

    public static byte[] flattenOctetStrings(ASN1OctetString[] aSN1OctetStringArr) {
        int length = aSN1OctetStringArr.length;
        if (length == 0) {
            return ASN1OctetString.EMPTY_OCTETS;
        }
        if (length == 1) {
            return aSN1OctetStringArr[0].f17932string;
        }
        int length2 = 0;
        for (ASN1OctetString aSN1OctetString : aSN1OctetStringArr) {
            length2 += aSN1OctetString.f17932string.length;
        }
        byte[] bArr = new byte[length2];
        int length3 = 0;
        for (ASN1OctetString aSN1OctetString2 : aSN1OctetStringArr) {
            byte[] bArr2 = aSN1OctetString2.f17932string;
            System.arraycopy(bArr2, 0, bArr, length3, bArr2.length);
            length3 += bArr2.length;
        }
        return bArr;
    }

    public static BEROctetString fromContents(byte[] bArr) {
        if (bArr != null) {
            return internalFromContents(bArr);
        }
        throw new NullPointerException("'contents' cannot be null");
    }

    public static BEROctetString fromContentsOptional(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return internalFromContents(bArr);
    }

    public static BEROctetString internalFromContents(byte[] bArr) {
        return bArr.length < 1 ? f17964EMPTY : new BEROctetString(C6238Arrays.m18231clone(bArr));
    }

    public static BEROctetString internalWithContents(byte[] bArr) {
        return bArr.length < 1 ? f17964EMPTY : new BEROctetString(bArr);
    }

    public static BEROctetString withContents(byte[] bArr) {
        if (bArr != null) {
            return internalWithContents(bArr);
        }
        throw new NullPointerException("'contents' cannot be null");
    }

    public static BEROctetString withContentsOptional(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        return internalWithContents(bArr);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    /* renamed from: encode */
    public void mo14417encode(ASN1OutputStream aSN1OutputStream, boolean z) throws IOException {
        aSN1OutputStream.writeIdentifier(z, 36);
        aSN1OutputStream.m14442write(128);
        ASN1OctetString[] aSN1OctetStringArr = this.elements;
        if (aSN1OctetStringArr == null) {
            int i = 0;
            while (true) {
                byte[] bArr = this.f17932string;
                if (i >= bArr.length) {
                    break;
                }
                int iMin = Math.min(bArr.length - i, this.segmentLimit);
                DEROctetString.m14471encode(aSN1OutputStream, true, this.f17932string, i, iMin);
                i += iMin;
            }
        } else {
            aSN1OutputStream.writePrimitives(aSN1OctetStringArr);
        }
        aSN1OutputStream.m14442write(0);
        aSN1OutputStream.m14442write(0);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean encodeConstructed() {
        return true;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public int encodedLength(boolean z) {
        int iEncodedLength = z ? 4 : 3;
        if (this.elements == null) {
            int length = this.f17932string.length;
            int i = this.segmentLimit;
            int i2 = length / i;
            int iEncodedLength2 = iEncodedLength + (DEROctetString.encodedLength(true, i) * i2);
            int length2 = this.f17932string.length - (i2 * this.segmentLimit);
            return length2 > 0 ? iEncodedLength2 + DEROctetString.encodedLength(true, length2) : iEncodedLength2;
        }
        int i3 = 0;
        while (true) {
            ASN1OctetString[] aSN1OctetStringArr = this.elements;
            if (i3 >= aSN1OctetStringArr.length) {
                return iEncodedLength;
            }
            iEncodedLength += aSN1OctetStringArr[i3].encodedLength(true);
            i3++;
        }
    }

    public BEROctetString(byte[] bArr, int i) {
        this(bArr, null, i);
    }

    private BEROctetString(byte[] bArr, ASN1OctetString[] aSN1OctetStringArr, int i) {
        super(bArr);
        this.elements = aSN1OctetStringArr;
        this.segmentLimit = i;
    }

    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr) {
        this(aSN1OctetStringArr, 1000);
    }

    public BEROctetString(ASN1OctetString[] aSN1OctetStringArr, int i) {
        this(flattenOctetStrings(aSN1OctetStringArr), aSN1OctetStringArr, i);
    }
}
