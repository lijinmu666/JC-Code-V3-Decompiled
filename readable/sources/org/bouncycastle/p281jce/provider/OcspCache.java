package org.bouncycastle.p281jce.provider;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.security.cert.CertPathValidatorException;
import java.security.cert.Extension;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p164ocsp.BasicOCSPResponse;
import org.bouncycastle.p133asn1.p164ocsp.C5131CertID;
import org.bouncycastle.p133asn1.p164ocsp.C5133Request;
import org.bouncycastle.p133asn1.p164ocsp.OCSPObjectIdentifiers;
import org.bouncycastle.p133asn1.p164ocsp.OCSPRequest;
import org.bouncycastle.p133asn1.p164ocsp.OCSPResponse;
import org.bouncycastle.p133asn1.p164ocsp.ResponseBytes;
import org.bouncycastle.p133asn1.p164ocsp.ResponseData;
import org.bouncycastle.p133asn1.p164ocsp.SingleResponse;
import org.bouncycastle.p133asn1.p164ocsp.TBSRequest;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p249jcajce.PKIXCertRevocationCheckerParameters;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
class OcspCache {
    private static final int DEFAULT_MAX_RESPONSE_SIZE = 32768;
    private static final int DEFAULT_TIMEOUT = 15000;

    /* renamed from: cache */
    private static Map<URI, WeakReference<Map<C5131CertID, OCSPResponse>>> f22019cache = Collections.synchronizedMap(new WeakHashMap());

    public static OCSPResponse getOcspResponse(C5131CertID c5131CertID, PKIXCertRevocationCheckerParameters pKIXCertRevocationCheckerParameters, URI uri, X509Certificate x509Certificate, List<Extension> list, JcaJceHelper jcaJceHelper) throws IOException, CertPathValidatorException {
        OCSPResponse oCSPResponse;
        WeakReference<Map<C5131CertID, OCSPResponse>> weakReference = f22019cache.get(uri);
        Map<C5131CertID, OCSPResponse> map = weakReference != null ? weakReference.get() : null;
        if (map != null && (oCSPResponse = map.get(c5131CertID)) != null) {
            if (isCertIDFoundAndCurrent(BasicOCSPResponse.getInstance(ASN1OctetString.getInstance(oCSPResponse.getResponseBytes().getResponse()).getOctets()), pKIXCertRevocationCheckerParameters.getValidDate(), c5131CertID)) {
                return oCSPResponse;
            }
            map.remove(c5131CertID);
        }
        try {
            URL url = uri.toURL();
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            aSN1EncodableVector.m14420add(new C5133Request(c5131CertID, null));
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            byte[] bArrM18231clone = null;
            for (int i = 0; i != list.size(); i++) {
                Extension extension = list.get(i);
                ASN1ObjectIdentifier aSN1ObjectIdentifier = new ASN1ObjectIdentifier(extension.getId());
                DEROctetString dEROctetString = new DEROctetString(extension.getValue());
                if (OCSPObjectIdentifiers.id_pkix_ocsp_nonce.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                    bArrM18231clone = C6238Arrays.m18231clone(dEROctetString.getOctets());
                }
                aSN1EncodableVector2.m14420add(new org.bouncycastle.p133asn1.p174x509.Extension(aSN1ObjectIdentifier, extension.isCritical(), dEROctetString));
            }
            try {
                byte[] encoded = new OCSPRequest(aSN1EncodableVector2.m14424size() != 0 ? new TBSRequest((GeneralName) null, new DERSequence(aSN1EncodableVector), Extensions.getInstance(new DERSequence(aSN1EncodableVector2))) : new TBSRequest((GeneralName) null, new DERSequence(aSN1EncodableVector), (Extensions) null), null).getEncoded();
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setConnectTimeout(DEFAULT_TIMEOUT);
                httpURLConnection.setReadTimeout(DEFAULT_TIMEOUT);
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setRequestProperty("Content-type", "application/ocsp-request");
                httpURLConnection.setRequestProperty("Content-length", String.valueOf(encoded.length));
                OutputStream outputStream = httpURLConnection.getOutputStream();
                outputStream.write(encoded);
                outputStream.flush();
                InputStream inputStream = httpURLConnection.getInputStream();
                int contentLength = httpURLConnection.getContentLength();
                if (contentLength < 0) {
                    contentLength = 32768;
                }
                OCSPResponse oCSPResponse2 = OCSPResponse.getInstance(C6257Streams.readAllLimited(inputStream, contentLength));
                try {
                    if (oCSPResponse2.getResponseStatus().getIntValue() != 0) {
                        throw new CertPathValidatorException("OCSP responder failed: " + oCSPResponse2.getResponseStatus().getValue(), null, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
                    }
                    ResponseBytes responseBytes = ResponseBytes.getInstance(oCSPResponse2.getResponseBytes());
                    if (responseBytes.getResponseType().m14446equals((ASN1Primitive) OCSPObjectIdentifiers.id_pkix_ocsp_basic)) {
                        BasicOCSPResponse basicOCSPResponse = BasicOCSPResponse.getInstance(responseBytes.getResponse().getOctets());
                        if (ProvOcspRevocationChecker.validatedOcspResponse(basicOCSPResponse, pKIXCertRevocationCheckerParameters, bArrM18231clone, x509Certificate, jcaJceHelper) && isCertIDFoundAndCurrent(basicOCSPResponse, pKIXCertRevocationCheckerParameters.getValidDate(), c5131CertID)) {
                            WeakReference<Map<C5131CertID, OCSPResponse>> weakReference2 = f22019cache.get(uri);
                            if (weakReference2 != null) {
                                map = weakReference2.get();
                            }
                            if (map != null) {
                                map.put(c5131CertID, oCSPResponse2);
                            } else {
                                HashMap map2 = new HashMap();
                                map2.put(c5131CertID, oCSPResponse2);
                                f22019cache.put(uri, new WeakReference<>(map2));
                            }
                            return oCSPResponse2;
                        }
                    }
                    throw new CertPathValidatorException("OCSP response failed to validate", null, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
                } catch (IOException e) {
                    e = e;
                    throw new CertPathValidatorException("configuration error: " + e.getMessage(), e, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
                }
            } catch (IOException e2) {
                e = e2;
            }
        } catch (MalformedURLException e3) {
            throw new CertPathValidatorException("configuration error: " + e3.getMessage(), e3, pKIXCertRevocationCheckerParameters.getCertPath(), pKIXCertRevocationCheckerParameters.getIndex());
        }
    }

    private static boolean isCertIDFoundAndCurrent(BasicOCSPResponse basicOCSPResponse, Date date, C5131CertID c5131CertID) {
        ASN1Sequence responses = ResponseData.getInstance(basicOCSPResponse.getTbsResponseData()).getResponses();
        for (int i = 0; i != responses.mo14450size(); i++) {
            SingleResponse singleResponse = SingleResponse.getInstance(responses.getObjectAt(i));
            if (c5131CertID.mo14431equals(singleResponse.getCertID())) {
                ASN1GeneralizedTime nextUpdate = singleResponse.getNextUpdate();
                if (nextUpdate != null) {
                    return !date.after(nextUpdate.m14427getDate());
                }
                return true;
            }
        }
        return false;
    }
}
