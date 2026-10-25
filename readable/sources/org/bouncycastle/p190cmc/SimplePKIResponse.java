package org.bouncycastle.p190cmc;

import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.CMSSignedData;
import org.bouncycastle.p361util.Encodable;
import org.bouncycastle.p361util.InterfaceC6249Store;

/* loaded from: classes2.dex */
public class SimplePKIResponse implements Encodable {
    private final CMSSignedData certificateResponse;

    public SimplePKIResponse(ContentInfo contentInfo) throws CMCException {
        try {
            CMSSignedData cMSSignedData = new CMSSignedData(contentInfo);
            this.certificateResponse = cMSSignedData;
            if (cMSSignedData.getSignerInfos().m14904size() != 0) {
                throw new CMCException("malformed response: SignerInfo structures found");
            }
            if (cMSSignedData.getSignedContent() != null) {
                throw new CMCException("malformed response: Signed Content found");
            }
        } catch (CMSException e) {
            throw new CMCException("malformed response: " + e.getMessage(), e);
        }
    }

    private static ContentInfo parseBytes(byte[] bArr) throws CMCException {
        try {
            return ContentInfo.getInstance(ASN1Primitive.fromByteArray(bArr));
        } catch (Exception e) {
            throw new CMCException("malformed data: " + e.getMessage(), e);
        }
    }

    /* renamed from: getCRLs */
    public InterfaceC6249Store<X509CRLHolder> m14842getCRLs() {
        return this.certificateResponse.m14867getCRLs();
    }

    public InterfaceC6249Store<X509CertificateHolder> getCertificates() {
        return this.certificateResponse.getCertificates();
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return this.certificateResponse.getEncoded();
    }

    public SimplePKIResponse(byte[] bArr) {
        this(parseBytes(bArr));
    }
}
