package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Iterator;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class PKCS7ProcessableObject implements CMSTypedData {
    private final ASN1Encodable structure;

    /* renamed from: type */
    private final ASN1ObjectIdentifier f19025type;

    public PKCS7ProcessableObject(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.f19025type = aSN1ObjectIdentifier;
        this.structure = aSN1Encodable;
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    public Object getContent() {
        return this.structure;
    }

    @Override // org.bouncycastle.p191cms.CMSTypedData
    public ASN1ObjectIdentifier getContentType() {
        return this.f19025type;
    }

    @Override // org.bouncycastle.p191cms.CMSProcessable
    /* renamed from: write */
    public void mo14759write(OutputStream outputStream) throws IOException {
        ASN1Encodable aSN1Encodable = this.structure;
        if (aSN1Encodable instanceof ASN1Sequence) {
            Iterator<ASN1Encodable> it = ASN1Sequence.getInstance(aSN1Encodable).iterator();
            while (it.hasNext()) {
                outputStream.write(it.next().toASN1Primitive().getEncoded(ASN1Encoding.f17902DER));
            }
        } else {
            byte[] encoded = aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.f17902DER);
            int i = 1;
            while ((encoded[i] & C1126UByte.MAX_VALUE) > 127) {
                i++;
            }
            int i2 = i + 1;
            outputStream.write(encoded, i2, encoded.length - i2);
        }
    }
}
