package org.bouncycastle.p191cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.operator.InputExpanderProvider;
import org.bouncycastle.p133asn1.ASN1OctetStringParser;
import org.bouncycastle.p133asn1.ASN1SequenceParser;
import org.bouncycastle.p133asn1.p139cms.CompressedDataParser;
import org.bouncycastle.p133asn1.p139cms.ContentInfoParser;

/* loaded from: classes2.dex */
public class CMSCompressedDataParser extends CMSContentInfoParser {
    public CMSCompressedDataParser(InputStream inputStream) {
        super(inputStream);
    }

    public CMSTypedStream getContent(InputExpanderProvider inputExpanderProvider) throws CMSException {
        try {
            CompressedDataParser compressedDataParser = new CompressedDataParser((ASN1SequenceParser) this._contentInfo.getContent(16));
            ContentInfoParser encapContentInfo = compressedDataParser.getEncapContentInfo();
            return new CMSTypedStream(encapContentInfo.getContentType(), inputExpanderProvider.mo14942get(compressedDataParser.getCompressionAlgorithmIdentifier()).getInputStream(((ASN1OctetStringParser) encapContentInfo.getContent(4)).getOctetStream()));
        } catch (IOException e) {
            throw new CMSException("IOException reading compressed content.", e);
        }
    }

    public CMSCompressedDataParser(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
