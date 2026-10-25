package org.bouncycastle.p191cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class PKCS7TypedStream extends CMSTypedStream {

    /* renamed from: content */
    private final ASN1Encodable f19026content;

    public PKCS7TypedStream(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        super(aSN1ObjectIdentifier);
        this.f19026content = aSN1Encodable;
    }

    @Override // org.bouncycastle.p191cms.CMSTypedStream
    /* renamed from: drain */
    public void mo14877drain() {
        this.f19026content.toASN1Primitive();
    }

    public ASN1Encodable getContent() {
        return this.f19026content;
    }

    @Override // org.bouncycastle.p191cms.CMSTypedStream
    public InputStream getContentStream() {
        try {
            return getContentStream(this.f19026content);
        } catch (IOException e) {
            throw new CMSRuntimeException("unable to convert content to stream: " + e.getMessage(), e);
        }
    }

    private InputStream getContentStream(ASN1Encodable aSN1Encodable) {
        int i;
        byte[] encoded = aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.f17902DER);
        int i2 = 1;
        if ((encoded[0] & 31) == 31) {
            do {
                i = encoded[i2] & ByteCompanionObject.MIN_VALUE;
                i2++;
            } while (i != 0);
        }
        int i3 = i2 + 1;
        byte b = encoded[i2];
        if ((b & ByteCompanionObject.MIN_VALUE) != 0) {
            i3 += b & ByteCompanionObject.MAX_VALUE;
        }
        return new ByteArrayInputStream(encoded, i3, encoded.length - i3);
    }
}
