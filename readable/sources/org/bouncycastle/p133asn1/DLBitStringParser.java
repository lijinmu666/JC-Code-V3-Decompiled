package org.bouncycastle.p133asn1;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class DLBitStringParser implements ASN1BitStringParser {

    /* renamed from: padBits */
    private int f17996padBits = 0;

    /* renamed from: stream */
    private final DefiniteLengthInputStream f17997stream;

    public DLBitStringParser(DefiniteLengthInputStream definiteLengthInputStream) {
        this.f17997stream = definiteLengthInputStream;
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitStringParser
    public InputStream getBitStream() {
        return getBitStream(false);
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return ASN1BitString.createPrimitive(this.f17997stream.toByteArray());
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitStringParser
    public InputStream getOctetStream() {
        return getBitStream(true);
    }

    @Override // org.bouncycastle.p133asn1.ASN1BitStringParser
    public int getPadBits() {
        return this.f17996padBits;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }

    private InputStream getBitStream(boolean z) throws IOException {
        int remaining = this.f17997stream.getRemaining();
        if (remaining < 1) {
            throw new IllegalStateException("content octets cannot be empty");
        }
        int i = this.f17997stream.read();
        this.f17996padBits = i;
        if (i > 0) {
            if (remaining < 2) {
                throw new IllegalStateException("zero length data with non-zero pad bits");
            }
            if (i > 7) {
                throw new IllegalStateException("pad bits cannot be greater than 7 or less than 0");
            }
            if (z) {
                throw new IOException("expected octet-aligned bitstring, but found padBits: " + this.f17996padBits);
            }
        }
        return this.f17997stream;
    }
}
