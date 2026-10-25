package org.bouncycastle.p177cert.p186ocsp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p164ocsp.BasicOCSPResponse;
import org.bouncycastle.p133asn1.p164ocsp.ResponseData;
import org.bouncycastle.p133asn1.p164ocsp.SingleResponse;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class BasicOCSPResp implements Encodable {

    /* renamed from: data */
    private ResponseData f18883data;
    private Extensions extensions;

    /* renamed from: resp */
    private BasicOCSPResponse f18884resp;

    public BasicOCSPResp(BasicOCSPResponse basicOCSPResponse) {
        this.f18884resp = basicOCSPResponse;
        this.f18883data = basicOCSPResponse.getTbsResponseData();
        this.extensions = Extensions.getInstance(basicOCSPResponse.getTbsResponseData().getResponseExtensions());
    }

    /* renamed from: equals */
    public boolean m14814equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BasicOCSPResp) {
            return this.f18884resp.mo14431equals(((BasicOCSPResp) obj).f18884resp);
        }
        return false;
    }

    public X509CertificateHolder[] getCerts() {
        ASN1Sequence certs;
        if (this.f18884resp.getCerts() != null && (certs = this.f18884resp.getCerts()) != null) {
            int iMo14450size = certs.mo14450size();
            X509CertificateHolder[] x509CertificateHolderArr = new X509CertificateHolder[iMo14450size];
            for (int i = 0; i != iMo14450size; i++) {
                x509CertificateHolderArr[i] = new X509CertificateHolder(Certificate.getInstance(certs.getObjectAt(i)));
            }
            return x509CertificateHolderArr;
        }
        return OCSPUtils.EMPTY_CERTS;
    }

    public Set getCriticalExtensionOIDs() {
        return OCSPUtils.getCriticalExtensionOIDs(this.extensions);
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return this.f18884resp.getEncoded();
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

    public Date getProducedAt() {
        return OCSPUtils.extractDate(this.f18883data.getProducedAt());
    }

    public C5230RespID getResponderId() {
        return new C5230RespID(this.f18883data.getResponderID());
    }

    public SingleResp[] getResponses() {
        ASN1Sequence responses = this.f18883data.getResponses();
        int iMo14450size = responses.mo14450size();
        SingleResp[] singleRespArr = new SingleResp[iMo14450size];
        for (int i = 0; i != iMo14450size; i++) {
            singleRespArr[i] = new SingleResp(SingleResponse.getInstance(responses.getObjectAt(i)));
        }
        return singleRespArr;
    }

    public byte[] getSignature() {
        return this.f18884resp.getSignature().getOctets();
    }

    public ASN1ObjectIdentifier getSignatureAlgOID() {
        return this.f18884resp.getSignatureAlgorithm().getAlgorithm();
    }

    public AlgorithmIdentifier getSignatureAlgorithmID() {
        return this.f18884resp.getSignatureAlgorithm();
    }

    public byte[] getTBSResponseData() {
        try {
            return this.f18884resp.getTbsResponseData().getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException unused) {
            return null;
        }
    }

    public int getVersion() {
        return this.f18883data.getVersion().intValueExact() + 1;
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public int hashCode() {
        return this.f18884resp.hashCode();
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) throws IOException, OCSPException {
        try {
            ContentVerifier contentVerifierMo17379get = contentVerifierProvider.mo17379get(this.f18884resp.getSignatureAlgorithm());
            OutputStream outputStream = contentVerifierMo17379get.getOutputStream();
            outputStream.write(this.f18884resp.getTbsResponseData().getEncoded(ASN1Encoding.f17902DER));
            outputStream.close();
            return contentVerifierMo17379get.mo16015verify(getSignature());
        } catch (Exception e) {
            throw new OCSPException("exception processing sig: " + e, e);
        }
    }
}
