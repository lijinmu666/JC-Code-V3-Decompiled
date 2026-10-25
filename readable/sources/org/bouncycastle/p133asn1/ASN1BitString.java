package org.bouncycastle.p133asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Integers;
import p094kotlin.C1126UByte;

/* loaded from: classes.dex */
public abstract class ASN1BitString extends ASN1Primitive implements ASN1String, ASN1BitStringParser {
    final byte[] contents;

    /* renamed from: TYPE */
    static final ASN1UniversalType f17895TYPE = new ASN1UniversalType(ASN1BitString.class, 3) { // from class: org.bouncycastle.asn1.ASN1BitString.1
        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
            return aSN1Sequence.toASN1BitString();
        }

        @Override // org.bouncycastle.p133asn1.ASN1UniversalType
        public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
            return ASN1BitString.createPrimitive(dEROctetString.getOctets());
        }
    };
    static final byte[] EMPTY_OCTETS_CONTENTS = {0};

    /* renamed from: table */
    private static final char[] f17896table = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    public ASN1BitString(byte b, int i) {
        if (i > 7 || i < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        this.contents = new byte[]{(byte) i, b};
    }

    public static ASN1BitString createPrimitive(byte[] bArr) {
        int length = bArr.length;
        if (length < 1) {
            throw new IllegalArgumentException("truncated BIT STRING detected");
        }
        int i = bArr[0] & C1126UByte.MAX_VALUE;
        if (i > 0) {
            if (i > 7 || length < 2) {
                throw new IllegalArgumentException("invalid pad bits detected");
            }
            byte b = bArr[length - 1];
            if (b != ((byte) ((255 << i) & b))) {
                return new DLBitString(bArr, false);
            }
        }
        return new DERBitString(bArr, false);
    }

    public static ASN1BitString getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1BitString)) {
            return (ASN1BitString) obj;
        }
        if (obj instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1BitString) {
                return (ASN1BitString) aSN1Primitive;
            }
        } else if (obj instanceof byte[]) {
            try {
                return (ASN1BitString) f17895TYPE.fromByteArray((byte[]) obj);
            } catch (IOException e) {
                throw new IllegalArgumentException("failed to construct BIT STRING from byte[]: " + e.getMessage());
            }
        }
        throw new IllegalArgumentException("illegal object in getInstance: " + obj.getClass().getName());
    }

    public static ASN1BitString getTagged(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1BitString) f17895TYPE.getTagged(aSN1TaggedObject, z);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1BitString)) {
            return false;
        }
        byte[] bArr = this.contents;
        byte[] bArr2 = ((ASN1BitString) aSN1Primitive).contents;
        int length = bArr.length;
        if (bArr2.length != length) {
            return false;
        }
        if (length == 1) {
            return true;
        }
        int i = length - 1;
        for (int i2 = 0; i2 < i; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        int i3 = 255 << (bArr[0] & C1126UByte.MAX_VALUE);
        return ((byte) (bArr[i] & i3)) == ((byte) (bArr2[i] & i3));
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitStringParser
    public InputStream getBitStream() {
        byte[] bArr = this.contents;
        return new ByteArrayInputStream(bArr, 1, bArr.length - 1);
    }

    public byte[] getBytes() {
        byte[] bArr = this.contents;
        if (bArr.length == 1) {
            return ASN1OctetString.EMPTY_OCTETS;
        }
        int i = bArr[0] & C1126UByte.MAX_VALUE;
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 1, bArr.length);
        int length = bArrCopyOfRange.length - 1;
        bArrCopyOfRange[length] = (byte) (((byte) (255 << i)) & bArrCopyOfRange[length]);
        return bArrCopyOfRange;
    }

    public int getBytesLength() {
        return this.contents.length - 1;
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return toASN1Primitive();
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitStringParser
    public InputStream getOctetStream() throws IOException {
        int i = this.contents[0] & C1126UByte.MAX_VALUE;
        if (i == 0) {
            return getBitStream();
        }
        throw new IOException("expected octet-aligned bitstring, but found padBits: " + i);
    }

    public byte[] getOctets() {
        byte[] bArr = this.contents;
        if (bArr[0] == 0) {
            return bArr.length == 1 ? ASN1OctetString.EMPTY_OCTETS : C6238Arrays.copyOfRange(bArr, 1, bArr.length);
        }
        throw new IllegalStateException("attempt to get non-octet aligned data from BIT STRING");
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitStringParser
    public int getPadBits() {
        return this.contents[0] & C1126UByte.MAX_VALUE;
    }

    @Override // org.bouncycastle.p133asn1.ASN1String
    public String getString() {
        try {
            byte[] encoded = getEncoded();
            StringBuilder sb = new StringBuilder((encoded.length * 2) + 1);
            sb.append('#');
            for (int i = 0; i != encoded.length; i++) {
                byte b = encoded[i];
                char[] cArr = f17896table;
                sb.append(cArr[(b >>> 4) & 15]);
                sb.append(cArr[b & 15]);
            }
            return sb.toString();
        } catch (IOException e) {
            throw new ASN1ParsingException("Internal error encoding BitString: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive, org.bouncycastle.p133asn1.ASN1Object
    public int hashCode() {
        byte[] bArr = this.contents;
        if (bArr.length < 2) {
            return 1;
        }
        int i = bArr[0] & C1126UByte.MAX_VALUE;
        int length = bArr.length - 1;
        return (C6238Arrays.hashCode(bArr, 0, length) * 257) ^ ((byte) ((255 << i) & bArr[length]));
    }

    public int intValue() {
        int iMin = Math.min(5, this.contents.length - 1);
        int i = 0;
        for (int i2 = 1; i2 < iMin; i2++) {
            i |= (255 & this.contents[i2]) << ((i2 - 1) * 8);
        }
        if (1 > iMin || iMin >= 5) {
            return i;
        }
        byte[] bArr = this.contents;
        return i | ((((byte) (bArr[iMin] & (255 << (bArr[0] & C1126UByte.MAX_VALUE)))) & C1126UByte.MAX_VALUE) << ((iMin - 1) * 8));
    }

    public boolean isOctetAligned() {
        return getPadBits() == 0;
    }

    /* renamed from: parser */
    public ASN1BitStringParser m14418parser() {
        return this;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDERObject() {
        return new DERBitString(this.contents, false);
    }

    @Override // org.bouncycastle.p133asn1.ASN1Primitive
    public ASN1Primitive toDLObject() {
        return new DLBitString(this.contents, false);
    }

    public String toString() {
        return getString();
    }

    public ASN1BitString(int i) {
        if (i == 0) {
            this.contents = EMPTY_OCTETS_CONTENTS;
            return;
        }
        int iBitLength = (Integers.bitLength(i) + 7) / 8;
        byte[] bArr = new byte[iBitLength + 1];
        for (int i2 = 1; i2 < iBitLength; i2++) {
            bArr[i2] = (byte) i;
            i >>>= 8;
        }
        bArr[iBitLength] = (byte) i;
        bArr[0] = (byte) Integers.numberOfTrailingZeros(i);
        this.contents = bArr;
    }

    public static byte[] getBytes(int i) {
        if (i == 0) {
            return new byte[0];
        }
        int i2 = 4;
        for (int i3 = 3; i3 >= 1 && ((255 << (i3 * 8)) & i) == 0; i3--) {
            i2--;
        }
        byte[] bArr = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr[i4] = (byte) ((i >> (i4 * 8)) & 255);
        }
        return bArr;
    }

    public static ASN1BitString getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z) {
        return (ASN1BitString) f17895TYPE.getContextTagged(aSN1TaggedObject, z);
    }

    public static int getPadBits(int i) {
        int i2;
        int i3 = 3;
        while (true) {
            if (i3 < 0) {
                i2 = 0;
                break;
            }
            if (i3 != 0) {
                int i4 = i >> (i3 * 8);
                if (i4 != 0) {
                    i2 = i4 & 255;
                    break;
                }
                i3--;
            } else {
                if (i != 0) {
                    i2 = i & 255;
                    break;
                }
                i3--;
            }
        }
        if (i2 == 0) {
            return 0;
        }
        int i5 = 1;
        while (true) {
            i2 <<= 1;
            if ((i2 & 255) == 0) {
                return 8 - i5;
            }
            i5++;
        }
    }

    public ASN1BitString(byte[] bArr, int i) {
        if (bArr == null) {
            throw new NullPointerException("'data' cannot be null");
        }
        if (i > 7 || i < 0) {
            throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
        }
        if (bArr.length == 0 && i != 0) {
            throw new IllegalArgumentException("zero length data with non-zero pad bits");
        }
        this.contents = C6238Arrays.m18263prepend(bArr, (byte) i);
    }

    public ASN1BitString(byte[] bArr, boolean z) {
        if (z) {
            if (bArr == null) {
                throw new NullPointerException("'contents' cannot be null");
            }
            if (bArr.length < 1) {
                throw new IllegalArgumentException("'contents' cannot be empty");
            }
            int i = bArr[0] & C1126UByte.MAX_VALUE;
            if (i > 0) {
                if (bArr.length < 2) {
                    throw new IllegalArgumentException("zero length data with non-zero pad bits");
                }
                if (i > 7) {
                    throw new IllegalArgumentException("pad bits cannot be greater than 7 or less than 0");
                }
            }
        }
        this.contents = bArr;
    }
}
