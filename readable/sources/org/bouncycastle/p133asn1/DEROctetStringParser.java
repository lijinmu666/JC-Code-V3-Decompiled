package org.bouncycastle.p133asn1;

import java.io.IOException;
import java.io.InputStream;

/* loaded from: classes.dex */
public class DEROctetStringParser implements ASN1OctetStringParser {

    /* renamed from: stream */
    private DefiniteLengthInputStream f17993stream;

    public DEROctetStringParser(DefiniteLengthInputStream definiteLengthInputStream) {
        this.f17993stream = definiteLengthInputStream;
    }

    @Override // org.bouncycastle.p133asn1.InMemoryRepresentable
    public ASN1Primitive getLoadedObject() {
        return new DEROctetString(this.f17993stream.toByteArray());
    }

    @Override // org.bouncycastle.p133asn1.ASN1OctetStringParser
    public InputStream getOctetStream() {
        return this.f17993stream;
    }

    @Override // org.bouncycastle.p133asn1.ASN1Encodable
    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e) {
            throw new ASN1ParsingException("IOException converting stream to byte array: " + e.getMessage(), e);
        }
    }
}
