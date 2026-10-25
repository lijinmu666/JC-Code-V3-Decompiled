package org.bouncycastle.p177cert.p186ocsp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p164ocsp.C5133Request;
import org.bouncycastle.p133asn1.p164ocsp.OCSPRequest;
import org.bouncycastle.p133asn1.p164ocsp.Signature;
import org.bouncycastle.p133asn1.p164ocsp.TBSRequest;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class OCSPReqBuilder {

    /* renamed from: list */
    private List f18891list = new ArrayList();
    private GeneralName requestorName = null;
    private Extensions requestExtensions = null;

    public static class RequestObject {

        /* renamed from: certId */
        CertificateID f18892certId;
        Extensions extensions;

        public RequestObject(CertificateID certificateID, Extensions extensions) {
            this.f18892certId = certificateID;
            this.extensions = extensions;
        }

        public C5133Request toRequest() {
            return new C5133Request(this.f18892certId.toASN1Primitive(), this.extensions);
        }
    }

    private C5228OCSPReq generateRequest(ContentSigner contentSigner, X509CertificateHolder[] x509CertificateHolderArr) throws OCSPException, IOException {
        Signature signature;
        Iterator it = this.f18891list.iterator();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        while (it.hasNext()) {
            try {
                aSN1EncodableVector.m14420add(((RequestObject) it.next()).toRequest());
            } catch (Exception e) {
                throw new OCSPException("exception creating Request", e);
            }
        }
        TBSRequest tBSRequest = new TBSRequest(this.requestorName, new DERSequence(aSN1EncodableVector), this.requestExtensions);
        if (contentSigner == null) {
            signature = null;
        } else {
            if (this.requestorName == null) {
                throw new OCSPException("requestorName must be specified if request is signed.");
            }
            try {
                OutputStream outputStream = contentSigner.getOutputStream();
                outputStream.write(tBSRequest.getEncoded(ASN1Encoding.f17902DER));
                outputStream.close();
                DERBitString dERBitString = new DERBitString(contentSigner.getSignature());
                AlgorithmIdentifier algorithmIdentifier = contentSigner.getAlgorithmIdentifier();
                if (x509CertificateHolderArr == null || x509CertificateHolderArr.length <= 0) {
                    signature = new Signature(algorithmIdentifier, dERBitString);
                } else {
                    ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
                    for (int i = 0; i != x509CertificateHolderArr.length; i++) {
                        aSN1EncodableVector2.m14420add(x509CertificateHolderArr[i].toASN1Structure());
                    }
                    signature = new Signature(algorithmIdentifier, dERBitString, new DERSequence(aSN1EncodableVector2));
                }
            } catch (Exception e2) {
                throw new OCSPException("exception processing TBSRequest: " + e2, e2);
            }
        }
        return new C5228OCSPReq(new OCSPRequest(tBSRequest, signature));
    }

    public OCSPReqBuilder addRequest(CertificateID certificateID) {
        this.f18891list.add(new RequestObject(certificateID, null));
        return this;
    }

    /* renamed from: build */
    public C5228OCSPReq m14817build() {
        return generateRequest(null, null);
    }

    public OCSPReqBuilder setRequestExtensions(Extensions extensions) {
        this.requestExtensions = extensions;
        return this;
    }

    public OCSPReqBuilder setRequestorName(X500Name x500Name) {
        this.requestorName = new GeneralName(4, x500Name);
        return this;
    }

    public OCSPReqBuilder addRequest(CertificateID certificateID, Extensions extensions) {
        this.f18891list.add(new RequestObject(certificateID, extensions));
        return this;
    }

    /* renamed from: build */
    public C5228OCSPReq m14818build(ContentSigner contentSigner, X509CertificateHolder[] x509CertificateHolderArr) {
        if (contentSigner != null) {
            return generateRequest(contentSigner, x509CertificateHolderArr);
        }
        throw new IllegalArgumentException("no signer specified");
    }

    public OCSPReqBuilder setRequestorName(GeneralName generalName) {
        this.requestorName = generalName;
        return this;
    }
}
