package org.bouncycastle.p223eac;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ParsingException;
import org.bouncycastle.p133asn1.p143eac.CVCertificateRequest;
import org.bouncycastle.p133asn1.p143eac.PublicKeyDataObject;
import org.bouncycastle.p223eac.operator.EACSignatureVerifier;

/* loaded from: classes2.dex */
public class EACCertificateRequestHolder {

    /* renamed from: request */
    private CVCertificateRequest f21151request;

    public EACCertificateRequestHolder(CVCertificateRequest cVCertificateRequest) {
        this.f21151request = cVCertificateRequest;
    }

    private static CVCertificateRequest parseBytes(byte[] bArr) throws IOException {
        try {
            return CVCertificateRequest.getInstance(bArr);
        } catch (ClassCastException e) {
            throw new EACIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new EACIOException("malformed data: " + e2.getMessage(), e2);
        } catch (ASN1ParsingException e3) {
            if (e3.getCause() instanceof IOException) {
                throw ((IOException) e3.getCause());
            }
            throw new EACIOException("malformed data: " + e3.getMessage(), e3);
        }
    }

    public PublicKeyDataObject getPublicKeyDataObject() {
        return this.f21151request.getPublicKey();
    }

    public boolean isInnerSignatureValid(EACSignatureVerifier eACSignatureVerifier) throws EACException, IOException {
        try {
            OutputStream outputStream = eACSignatureVerifier.getOutputStream();
            outputStream.write(this.f21151request.getCertificateBody().getEncoded(ASN1Encoding.f17902DER));
            outputStream.close();
            return eACSignatureVerifier.mo15949verify(this.f21151request.getInnerSignature());
        } catch (Exception e) {
            throw new EACException("unable to process signature: " + e.getMessage(), e);
        }
    }

    public CVCertificateRequest toASN1Structure() {
        return this.f21151request;
    }

    public EACCertificateRequestHolder(byte[] bArr) {
        this(parseBytes(bArr));
    }
}
