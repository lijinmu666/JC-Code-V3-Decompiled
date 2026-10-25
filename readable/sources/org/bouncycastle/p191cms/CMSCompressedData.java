package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.operator.InputExpanderProvider;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.p139cms.CompressedData;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class CMSCompressedData implements Encodable {

    /* renamed from: comData */
    CompressedData f18959comData;
    ContentInfo contentInfo;

    public CMSCompressedData(InputStream inputStream) {
        this(CMSUtils.readContentInfo(inputStream));
    }

    public ASN1ObjectIdentifier getCompressedContentType() {
        return this.f18959comData.getEncapContentInfo().getContentType();
    }

    public byte[] getContent(InputExpanderProvider inputExpanderProvider) throws CMSException {
        try {
            return CMSUtils.streamToByteArray(inputExpanderProvider.mo14942get(this.f18959comData.getCompressionAlgorithmIdentifier()).getInputStream(((ASN1OctetString) this.f18959comData.getEncapContentInfo().getContent()).getOctetStream()));
        } catch (IOException e) {
            throw new CMSException("exception reading compressed stream.", e);
        }
    }

    public CMSTypedStream getContentStream(InputExpanderProvider inputExpanderProvider) {
        ContentInfo encapContentInfo = this.f18959comData.getEncapContentInfo();
        return new CMSTypedStream(encapContentInfo.getContentType(), inputExpanderProvider.mo14942get(this.f18959comData.getCompressionAlgorithmIdentifier()).getInputStream(((ASN1OctetString) encapContentInfo.getContent()).getOctetStream()));
    }

    public ASN1ObjectIdentifier getContentType() {
        return this.contentInfo.getContentType();
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return this.contentInfo.getEncoded();
    }

    public ContentInfo toASN1Structure() {
        return this.contentInfo;
    }

    public CMSCompressedData(ContentInfo contentInfo) throws CMSException {
        this.contentInfo = contentInfo;
        try {
            this.f18959comData = CompressedData.getInstance(contentInfo.getContent());
        } catch (ClassCastException e) {
            throw new CMSException("Malformed content.", e);
        } catch (IllegalArgumentException e2) {
            throw new CMSException("Malformed content.", e2);
        }
    }

    public CMSCompressedData(byte[] bArr) {
        this(CMSUtils.readContentInfo(bArr));
    }
}
