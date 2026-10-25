package org.bouncycastle.p133asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes.dex */
public class ASN1StreamParser {

    /* renamed from: _in */
    private final InputStream f17948_in;

    /* renamed from: _limit */
    private final int f17949_limit;

    /* renamed from: level */
    private final int f17950level;
    private final int maxLevel;
    private final byte[][] tmpBuffers;

    public ASN1StreamParser(InputStream inputStream) {
        this(inputStream, StreamUtil.findLimit(inputStream));
    }

    private void set00Check(boolean z) {
        InputStream inputStream = this.f17948_in;
        if (inputStream instanceof IndefiniteLengthInputStream) {
            ((IndefiniteLengthInputStream) inputStream).setEofOn00(z);
        }
    }

    public ASN1Encodable implParseObject(int i) throws IOException {
        if (this.f17950level == this.maxLevel) {
            throw new IOException("maximum nested construction level reached - increase org.bouncycastle.asn1.max_cons_depth (currently " + this.maxLevel + ")");
        }
        set00Check(false);
        int tagNumber = ASN1InputStream.readTagNumber(this.f17948_in, i);
        int length = ASN1InputStream.readLength(this.f17948_in, this.f17949_limit, tagNumber == 3 || tagNumber == 4 || tagNumber == 16 || tagNumber == 17 || tagNumber == 8);
        if (length < 0) {
            if ((i & 32) == 0) {
                throw new IOException("indefinite-length primitive encoding encountered");
            }
            ASN1StreamParser aSN1StreamParser = new ASN1StreamParser(new IndefiniteLengthInputStream(this.f17948_in, this.f17949_limit), this.f17949_limit, this.tmpBuffers, this.f17950level + 1, this.maxLevel);
            int i2 = i & 192;
            return i2 != 0 ? new BERTaggedObjectParser(i2, tagNumber, aSN1StreamParser) : aSN1StreamParser.parseImplicitConstructedIL(tagNumber);
        }
        DefiniteLengthInputStream definiteLengthInputStream = new DefiniteLengthInputStream(this.f17948_in, length, this.f17949_limit);
        if ((i & InterfaceC5102BERTags.f17976FLAGS) == 0) {
            return parseImplicitPrimitive(tagNumber, definiteLengthInputStream);
        }
        ASN1StreamParser aSN1StreamParser2 = new ASN1StreamParser(definiteLengthInputStream, definiteLengthInputStream.getLimit(), this.tmpBuffers, this.f17950level + 1, this.maxLevel);
        int i3 = i & 192;
        if (i3 != 0) {
            return new DLTaggedObjectParser(i3, tagNumber, (i & 32) != 0, aSN1StreamParser2);
        }
        return aSN1StreamParser2.parseImplicitConstructedDL(tagNumber);
    }

    public ASN1Primitive loadTaggedDL(int i, int i2, boolean z) {
        return !z ? ASN1TaggedObject.createPrimitive(i, i2, ((DefiniteLengthInputStream) this.f17948_in).toByteArray()) : ASN1TaggedObject.createConstructedDL(i, i2, readVector());
    }

    public ASN1Primitive loadTaggedIL(int i, int i2) {
        return ASN1TaggedObject.createConstructedIL(i, i2, readVector());
    }

    public ASN1Encodable parseImplicitConstructedDL(int i) throws ASN1Exception {
        if (i == 3) {
            return new BERBitStringParser(this);
        }
        if (i == 4) {
            return new BEROctetStringParser(this);
        }
        if (i == 8) {
            return new DERExternalParser(this);
        }
        if (i == 16) {
            return new DLSequenceParser(this);
        }
        if (i == 17) {
            return new DLSetParser(this);
        }
        throw new ASN1Exception("unknown DL object encountered: 0x" + Integer.toHexString(i));
    }

    public ASN1Encodable parseImplicitConstructedIL(int i) throws ASN1Exception {
        if (i == 3) {
            return new BERBitStringParser(this);
        }
        if (i == 4) {
            return new BEROctetStringParser(this);
        }
        if (i == 8) {
            return new DERExternalParser(this);
        }
        if (i == 16) {
            return new BERSequenceParser(this);
        }
        if (i == 17) {
            return new BERSetParser(this);
        }
        throw new ASN1Exception("unknown BER object encountered: 0x" + Integer.toHexString(i));
    }

    public ASN1Encodable parseImplicitPrimitive(int i) {
        return parseImplicitPrimitive(i, (DefiniteLengthInputStream) this.f17948_in);
    }

    public ASN1Encodable parseObject(int i) throws IOException {
        if (i < 0 || i > 30) {
            throw new IllegalArgumentException("invalid universal tag number: " + i);
        }
        int i2 = this.f17948_in.read();
        if (i2 < 0) {
            return null;
        }
        if ((i2 & (-33)) == i) {
            return implParseObject(i2);
        }
        throw new IOException("unexpected identifier encountered: " + i2);
    }

    public ASN1TaggedObjectParser parseTaggedObject() throws IOException {
        int i = this.f17948_in.read();
        if (i < 0) {
            return null;
        }
        if ((i & 192) != 0) {
            return (ASN1TaggedObjectParser) implParseObject(i);
        }
        throw new ASN1Exception("no tagged object found");
    }

    public ASN1Encodable readObject() throws IOException {
        int i = this.f17948_in.read();
        if (i < 0) {
            return null;
        }
        return implParseObject(i);
    }

    public ASN1EncodableVector readVector() throws IOException {
        int i = this.f17948_in.read();
        if (i < 0) {
            return new ASN1EncodableVector(0);
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        do {
            ASN1Encodable aSN1EncodableImplParseObject = implParseObject(i);
            aSN1EncodableVector.m14420add(aSN1EncodableImplParseObject instanceof InMemoryRepresentable ? ((InMemoryRepresentable) aSN1EncodableImplParseObject).getLoadedObject() : aSN1EncodableImplParseObject.toASN1Primitive());
            i = this.f17948_in.read();
        } while (i >= 0);
        return aSN1EncodableVector;
    }

    public ASN1StreamParser(InputStream inputStream, int i) {
        this(inputStream, i, new byte[11][]);
    }

    public ASN1Encodable parseImplicitPrimitive(int i, DefiniteLengthInputStream definiteLengthInputStream) throws ASN1Exception {
        if (i == 3) {
            return new DLBitStringParser(definiteLengthInputStream);
        }
        if (i == 4) {
            return new DEROctetStringParser(definiteLengthInputStream);
        }
        if (i == 8) {
            throw new ASN1Exception("externals must use constructed encoding (see X.690 8.18)");
        }
        if (i == 16) {
            throw new ASN1Exception("sets must use constructed encoding (see X.690 8.11.1/8.12.1)");
        }
        if (i == 17) {
            throw new ASN1Exception("sequences must use constructed encoding (see X.690 8.9.1/8.10.1)");
        }
        try {
            return ASN1InputStream.createPrimitiveDERObject(i, definiteLengthInputStream, this.tmpBuffers);
        } catch (IllegalArgumentException e) {
            throw new ASN1Exception("corrupted stream detected", e);
        }
    }

    public ASN1StreamParser(InputStream inputStream, int i, byte[][] bArr) {
        this.f17948_in = inputStream;
        this.f17949_limit = i;
        this.tmpBuffers = bArr;
        this.f17950level = 0;
        this.maxLevel = Properties.asInteger("org.bouncycastle.asn1.max_cons_depth", 32);
    }

    private ASN1StreamParser(InputStream inputStream, int i, byte[][] bArr, int i2, int i3) {
        this.f17948_in = inputStream;
        this.f17949_limit = i;
        this.tmpBuffers = bArr;
        this.f17950level = i2;
        this.maxLevel = i3;
    }

    public ASN1StreamParser(byte[] bArr) {
        this(new ByteArrayInputStream(bArr), bArr.length);
    }
}
