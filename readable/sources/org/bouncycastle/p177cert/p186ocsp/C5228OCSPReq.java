package org.bouncycastle.p177cert.p186ocsp;

import java.io.IOException;
import java.util.List;
import java.util.Set;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Exception;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p164ocsp.C5133Request;
import org.bouncycastle.p133asn1.p164ocsp.OCSPRequest;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p177cert.CertIOException;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* renamed from: org.bouncycastle.cert.ocsp.OCSPReq */
/* loaded from: classes2.dex */
public class C5228OCSPReq {
    private static final X509CertificateHolder[] EMPTY_CERTS = new X509CertificateHolder[0];
    private Extensions extensions;

    /* renamed from: req */
    private OCSPRequest f18890req;

    private C5228OCSPReq(ASN1InputStream aSN1InputStream) throws CertIOException {
        try {
            OCSPRequest oCSPRequest = OCSPRequest.getInstance(aSN1InputStream.readObject());
            this.f18890req = oCSPRequest;
            if (oCSPRequest == null) {
                throw new CertIOException("malformed request: no request data found");
            }
            this.extensions = oCSPRequest.getTbsRequest().getRequestExtensions();
        } catch (ClassCastException e) {
            throw new CertIOException("malformed request: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new CertIOException("malformed request: " + e2.getMessage(), e2);
        } catch (ASN1Exception e3) {
            throw new CertIOException("malformed request: " + e3.getMessage(), e3);
        }
    }

    public X509CertificateHolder[] getCerts() {
        ASN1Sequence certs;
        if (this.f18890req.getOptionalSignature() != null && (certs = this.f18890req.getOptionalSignature().getCerts()) != null) {
            int iMo14450size = certs.mo14450size();
            X509CertificateHolder[] x509CertificateHolderArr = new X509CertificateHolder[iMo14450size];
            for (int i = 0; i != iMo14450size; i++) {
                x509CertificateHolderArr[i] = new X509CertificateHolder(Certificate.getInstance(certs.getObjectAt(i)));
            }
            return x509CertificateHolderArr;
        }
        return EMPTY_CERTS;
    }

    public Set getCriticalExtensionOIDs() {
        return OCSPUtils.getCriticalExtensionOIDs(this.extensions);
    }

    public byte[] getEncoded() {
        return this.f18890req.getEncoded();
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Extensions extensions = this.extensions;
        if (extensions != null) {
            return extensions.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return OCSPUtils.getExtensionOIDs(this.extensions);
    }

    public Set getNonCriticalExtensionOIDs() {
        return OCSPUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public C5229Req[] getRequestList() {
        ASN1Sequence requestList = this.f18890req.getTbsRequest().getRequestList();
        int iMo14450size = requestList.mo14450size();
        C5229Req[] c5229ReqArr = new C5229Req[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            c5229ReqArr[i] = new C5229Req(C5133Request.getInstance(requestList.getObjectAt(i)));
        }
        return c5229ReqArr;
    }

    public GeneralName getRequestorName() {
        return GeneralName.getInstance(this.f18890req.getTbsRequest().getRequestorName());
    }

    public byte[] getSignature() {
        if (isSigned()) {
            return this.f18890req.getOptionalSignature().getSignature().getOctets();
        }
        return null;
    }

    public ASN1ObjectIdentifier getSignatureAlgOID() {
        if (isSigned()) {
            return this.f18890req.getOptionalSignature().getSignatureAlgorithm().getAlgorithm();
        }
        return null;
    }

    public int getVersionNumber() {
        return this.f18890req.getTbsRequest().getVersion().intValueExact() + 1;
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) throws OCSPException, IOException {
        if (!isSigned()) {
            throw new OCSPException("attempt to verify signature on unsigned object");
        }
        try {
            ContentVerifier contentVerifierMo17379get = contentVerifierProvider.mo17379get(this.f18890req.getOptionalSignature().getSignatureAlgorithm());
            contentVerifierMo17379get.getOutputStream().write(this.f18890req.getTbsRequest().getEncoded(ASN1Encoding.f17902DER));
            return contentVerifierMo17379get.mo16015verify(getSignature());
        } catch (Exception e) {
            throw new OCSPException("exception processing signature: " + e, e);
        }
    }

    public boolean isSigned() {
        return this.f18890req.getOptionalSignature() != null;
    }

    public C5228OCSPReq(OCSPRequest oCSPRequest) {
        this.f18890req = oCSPRequest;
        this.extensions = oCSPRequest.getTbsRequest().getRequestExtensions();
    }

    public C5228OCSPReq(byte[] bArr) {
        this(new ASN1InputStream(bArr));
    }
}
