package org.bouncycastle.p226est;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERPrintableString;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p147est.CsrAttrs;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p190cmc.CMCException;
import org.bouncycastle.p190cmc.SimplePKIResponse;
import org.bouncycastle.p296mime.BasicMimeParser;
import org.bouncycastle.p296mime.C5880Headers;
import org.bouncycastle.p296mime.ConstantMimeContext;
import org.bouncycastle.p296mime.MimeContext;
import org.bouncycastle.p296mime.MimeParserContext;
import org.bouncycastle.p296mime.MimeParserListener;
import org.bouncycastle.p307pkcs.PKCS10CertificationRequest;
import org.bouncycastle.p307pkcs.PKCS10CertificationRequestBuilder;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.Selector;
import org.bouncycastle.p361util.encoders.C6253Base64;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class ESTService {

    /* renamed from: CACERTS */
    protected static final String f21196CACERTS = "/cacerts";
    protected static final String CSRATTRS = "/csrattrs";

    /* renamed from: FULLCMC */
    protected static final String f21197FULLCMC = "/fullcmc";
    protected static final String SERVERGEN = "/serverkeygen";
    protected static final String SIMPLE_ENROLL = "/simpleenroll";
    protected static final String SIMPLE_REENROLL = "/simplereenroll";
    protected static final Set<String> illegalParts;
    private static final Pattern pathInValid;
    private final ESTClientProvider clientProvider;

    /* renamed from: server */
    private final String f21198server;

    static {
        HashSet hashSet = new HashSet();
        illegalParts = hashSet;
        hashSet.add("cacerts");
        hashSet.add("simpleenroll");
        hashSet.add("simplereenroll");
        hashSet.add("fullcmc");
        hashSet.add("serverkeygen");
        hashSet.add("csrattrs");
        pathInValid = Pattern.compile("^[0-9a-zA-Z_\\-.~!$&'()*+,;:=]+");
    }

    public ESTService(String str, String str2, ESTClientProvider eSTClientProvider) {
        String str3;
        String strVerifyServer = verifyServer(str);
        if (str2 != null) {
            str3 = "https://" + strVerifyServer + "/.well-known/est/" + verifyLabel(str2);
        } else {
            str3 = "https://" + strVerifyServer + "/.well-known/est";
        }
        this.f21198server = str3;
        this.clientProvider = eSTClientProvider;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String annotateRequest(byte[] bArr) {
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        int length = 0;
        do {
            int i = length + 48;
            if (i < bArr.length) {
                printWriter.print(C6253Base64.toBase64String(bArr, length, 48));
                length = i;
            } else {
                printWriter.print(C6253Base64.toBase64String(bArr, length, bArr.length - length));
                length = bArr.length;
            }
            printWriter.print('\n');
        } while (length < bArr.length);
        printWriter.flush();
        return stringWriter.toString();
    }

    private ASN1InputStream getASN1InputStream(InputStream inputStream, Long l) {
        if (l != null && l.intValue() == l.longValue()) {
            return new ASN1InputStream(inputStream, l.intValue());
        }
        return new ASN1InputStream(inputStream);
    }

    public static X509CertificateHolder[] storeToArray(InterfaceC6249Store<X509CertificateHolder> interfaceC6249Store) {
        return storeToArray(interfaceC6249Store, null);
    }

    private String verifyLabel(String str) {
        while (str.endsWith("/") && str.length() > 0) {
            str = str.substring(0, str.length() - 1);
        }
        while (str.startsWith("/") && str.length() > 0) {
            str = str.substring(1);
        }
        if (str.length() == 0) {
            throw new IllegalArgumentException("Label set but after trimming '/' is not zero length string.");
        }
        if (!pathInValid.matcher(str).matches()) {
            throw new IllegalArgumentException("Server path " + str + " contains invalid characters");
        }
        if (!illegalParts.contains(str)) {
            return str;
        }
        throw new IllegalArgumentException("Label " + str + " is a reserved path segment.");
    }

    private String verifyServer(String str) {
        while (str.endsWith("/") && str.length() > 0) {
            try {
                str = str.substring(0, str.length() - 1);
            } catch (Exception e) {
                if (e instanceof IllegalArgumentException) {
                    throw ((IllegalArgumentException) e);
                }
                throw new IllegalArgumentException("Scheme and host is invalid: " + e.getMessage(), e);
            }
        }
        if (str.contains("://")) {
            throw new IllegalArgumentException("Server contains scheme, must only be <dnsname/ipaddress>:port, https:// will be added arbitrarily.");
        }
        URL url = new URL("https://" + str);
        if (url.getPath().length() != 0 && !url.getPath().equals("/")) {
            throw new IllegalArgumentException("Server contains path, must only be <dnsname/ipaddress>:port, a path of '/.well-known/est/<label>' will be added arbitrarily.");
        }
        return str;
    }

    /* renamed from: enroll */
    public EnrollmentResponse m15965enroll(boolean z, PKCS10CertificationRequest pKCS10CertificationRequest, InterfaceC5436ESTAuth interfaceC5436ESTAuth, boolean z2) throws IOException {
        if (!this.clientProvider.isTrusted()) {
            throw new IllegalStateException("No trust anchors.");
        }
        ESTResponse eSTResponseDoRequest = null;
        try {
            byte[] bytes = annotateRequest(pKCS10CertificationRequest.getEncoded()).getBytes();
            StringBuilder sb = new StringBuilder();
            sb.append(this.f21198server);
            sb.append(z2 ? SERVERGEN : z ? SIMPLE_REENROLL : SIMPLE_ENROLL);
            URL url = new URL(sb.toString());
            ESTClient eSTClientMakeClient = this.clientProvider.makeClient();
            ESTRequestBuilder eSTRequestBuilderWithClient = new ESTRequestBuilder("POST", url).withData(bytes).withClient(eSTClientMakeClient);
            eSTRequestBuilderWithClient.addHeader("Content-Type", "application/pkcs10");
            eSTRequestBuilderWithClient.addHeader("Content-Length", BuildConfig.f24315FLAVOR + bytes.length);
            eSTRequestBuilderWithClient.addHeader("Content-Transfer-Encoding", "base64");
            if (interfaceC5436ESTAuth != null) {
                interfaceC5436ESTAuth.applyAuth(eSTRequestBuilderWithClient);
            }
            eSTResponseDoRequest = eSTClientMakeClient.doRequest(eSTRequestBuilderWithClient.m15961build());
            EnrollmentResponse enrollmentResponseHandleEnrollResponse = handleEnrollResponse(eSTResponseDoRequest);
            if (eSTResponseDoRequest != null) {
                eSTResponseDoRequest.m15964close();
            }
            return enrollmentResponseHandleEnrollResponse;
        } catch (Throwable th) {
            try {
                if (th instanceof ESTException) {
                    throw th;
                }
                throw new ESTException(th.getMessage(), th);
            } catch (Throwable th2) {
                if (eSTResponseDoRequest != null) {
                    eSTResponseDoRequest.m15964close();
                }
                throw th2;
            }
        }
    }

    public EnrollmentResponse enrollPop(boolean z, final PKCS10CertificationRequestBuilder pKCS10CertificationRequestBuilder, final ContentSigner contentSigner, InterfaceC5436ESTAuth interfaceC5436ESTAuth, boolean z2) throws IOException {
        if (!this.clientProvider.isTrusted()) {
            throw new IllegalStateException("No trust anchors.");
        }
        ESTResponse eSTResponseDoRequest = null;
        try {
            StringBuilder sb = new StringBuilder();
            sb.append(this.f21198server);
            sb.append(z ? SIMPLE_REENROLL : SIMPLE_ENROLL);
            URL url = new URL(sb.toString());
            ESTClient eSTClientMakeClient = this.clientProvider.makeClient();
            ESTRequestBuilder eSTRequestBuilderWithConnectionListener = new ESTRequestBuilder("POST", url).withClient(eSTClientMakeClient).withConnectionListener(new ESTSourceConnectionListener(this) { // from class: org.bouncycastle.est.ESTService.1

                /* renamed from: this$0 */
                final /* synthetic */ ESTService f21199this$0;

                {
                    this.f21199this$0 = this;
                }

                @Override // org.bouncycastle.p226est.ESTSourceConnectionListener
                public ESTRequest onConnection(InterfaceC5444Source interfaceC5444Source, ESTRequest eSTRequest) throws IOException {
                    if (interfaceC5444Source instanceof TLSUniqueProvider) {
                        TLSUniqueProvider tLSUniqueProvider = (TLSUniqueProvider) interfaceC5444Source;
                        if (tLSUniqueProvider.isTLSUniqueAvailable()) {
                            PKCS10CertificationRequestBuilder pKCS10CertificationRequestBuilder2 = new PKCS10CertificationRequestBuilder(pKCS10CertificationRequestBuilder);
                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            pKCS10CertificationRequestBuilder2.setAttribute(PKCSObjectIdentifiers.pkcs_9_at_challengePassword, new DERPrintableString(C6253Base64.toBase64String(tLSUniqueProvider.getTLSUnique())));
                            byteArrayOutputStream.write(this.f21199this$0.annotateRequest(pKCS10CertificationRequestBuilder2.m17405build(contentSigner).getEncoded()).getBytes());
                            byteArrayOutputStream.flush();
                            ESTRequestBuilder eSTRequestBuilderWithData = new ESTRequestBuilder(eSTRequest).withData(byteArrayOutputStream.toByteArray());
                            eSTRequestBuilderWithData.setHeader("Content-Type", "application/pkcs10");
                            eSTRequestBuilderWithData.setHeader("Content-Transfer-Encoding", "base64");
                            eSTRequestBuilderWithData.setHeader("Content-Length", Long.toString(byteArrayOutputStream.size()));
                            return eSTRequestBuilderWithData.m15961build();
                        }
                    }
                    throw new IOException("Source does not supply TLS unique.");
                }
            });
            if (interfaceC5436ESTAuth != null) {
                interfaceC5436ESTAuth.applyAuth(eSTRequestBuilderWithConnectionListener);
            }
            eSTResponseDoRequest = eSTClientMakeClient.doRequest(eSTRequestBuilderWithConnectionListener.m15961build());
            EnrollmentResponse enrollmentResponseHandleEnrollResponse = handleEnrollResponse(eSTResponseDoRequest);
            if (eSTResponseDoRequest != null) {
                eSTResponseDoRequest.m15964close();
            }
            return enrollmentResponseHandleEnrollResponse;
        } catch (Throwable th) {
            try {
                if (th instanceof ESTException) {
                    throw th;
                }
                throw new ESTException(th.getMessage(), th);
            } catch (Throwable th2) {
                if (eSTResponseDoRequest != null) {
                    eSTResponseDoRequest.m15964close();
                }
                throw th2;
            }
        }
    }

    public CACertsResponse getCACerts() throws ESTException {
        URL url;
        ESTRequest eSTRequestM15961build;
        ESTResponse eSTResponseDoRequest;
        InterfaceC6249Store<X509CertificateHolder> certificates;
        InterfaceC6249Store<X509CRLHolder> interfaceC6249StoreM14842getCRLs;
        String str;
        ESTResponse eSTResponse = null;
        try {
            url = new URL(this.f21198server + f21196CACERTS);
            ESTClient eSTClientMakeClient = this.clientProvider.makeClient();
            eSTRequestM15961build = new ESTRequestBuilder("GET", url).withClient(eSTClientMakeClient).m15961build();
            eSTResponseDoRequest = eSTClientMakeClient.doRequest(eSTRequestM15961build);
        } catch (Throwable th) {
            th = th;
        }
        try {
            if (eSTResponseDoRequest.getStatusCode() == 200) {
                String firstValue = eSTResponseDoRequest.getHeaders().getFirstValue("Content-Type");
                if (firstValue == null || !firstValue.startsWith("application/pkcs7-mime")) {
                    if (firstValue != null) {
                        str = " got " + firstValue;
                    } else {
                        str = " but was not present.";
                    }
                    throw new ESTException("Response : " + url.toString() + "Expecting application/pkcs7-mime " + str, null, eSTResponseDoRequest.getStatusCode(), eSTResponseDoRequest.getInputStream());
                }
                try {
                    SimplePKIResponse simplePKIResponse = new SimplePKIResponse(ContentInfo.getInstance(getASN1InputStream(eSTResponseDoRequest.getInputStream(), eSTResponseDoRequest.getContentLength()).readObject()));
                    certificates = simplePKIResponse.getCertificates();
                    interfaceC6249StoreM14842getCRLs = simplePKIResponse.m14842getCRLs();
                } catch (Throwable th2) {
                    throw new ESTException("Decoding CACerts: " + url.toString() + " " + th2.getMessage(), th2, eSTResponseDoRequest.getStatusCode(), eSTResponseDoRequest.getInputStream());
                }
            } else {
                if (eSTResponseDoRequest.getStatusCode() != 204) {
                    throw new ESTException("Get CACerts: " + url.toString(), null, eSTResponseDoRequest.getStatusCode(), eSTResponseDoRequest.getInputStream());
                }
                certificates = null;
                interfaceC6249StoreM14842getCRLs = null;
            }
            CACertsResponse cACertsResponse = new CACertsResponse(certificates, interfaceC6249StoreM14842getCRLs, eSTRequestM15961build, eSTResponseDoRequest.getSource(), this.clientProvider.isTrusted());
            try {
                eSTResponseDoRequest.m15964close();
                e = null;
            } catch (Exception e) {
                e = e;
            }
            if (e == null) {
                return cACertsResponse;
            }
            if (e instanceof ESTException) {
                throw ((ESTException) e);
            }
            throw new ESTException("Get CACerts: " + url.toString(), e, eSTResponseDoRequest.getStatusCode(), null);
        } catch (Throwable th3) {
            th = th3;
            eSTResponse = eSTResponseDoRequest;
            try {
                if (th instanceof ESTException) {
                    throw th;
                }
                throw new ESTException(th.getMessage(), th);
            } catch (Throwable th4) {
                if (eSTResponse != null) {
                    try {
                        eSTResponse.m15964close();
                    } catch (Exception unused) {
                    }
                }
                throw th4;
            }
        }
    }

    public CSRRequestResponse getCSRAttributes() throws ESTException {
        CSRAttributesResponse cSRAttributesResponse;
        if (!this.clientProvider.isTrusted()) {
            throw new IllegalStateException("No trust anchors.");
        }
        ESTResponse eSTResponse = null;
        try {
            URL url = new URL(this.f21198server + CSRATTRS);
            ESTClient eSTClientMakeClient = this.clientProvider.makeClient();
            ESTRequest eSTRequestM15961build = new ESTRequestBuilder("GET", url).withClient(eSTClientMakeClient).m15961build();
            ESTResponse eSTResponseDoRequest = eSTClientMakeClient.doRequest(eSTRequestM15961build);
            try {
                int statusCode = eSTResponseDoRequest.getStatusCode();
                if (statusCode == 200) {
                    try {
                        cSRAttributesResponse = new CSRAttributesResponse(CsrAttrs.getInstance(ASN1Sequence.getInstance(getASN1InputStream(eSTResponseDoRequest.getInputStream(), eSTResponseDoRequest.getContentLength()).readObject())));
                    } catch (Throwable th) {
                        throw new ESTException("Decoding CACerts: " + url.toString() + " " + th.getMessage(), th, eSTResponseDoRequest.getStatusCode(), eSTResponseDoRequest.getInputStream());
                    }
                } else {
                    if (statusCode != 204 && statusCode != 404) {
                        throw new ESTException("CSR Attribute request: " + eSTRequestM15961build.m15960getURL().toString(), null, eSTResponseDoRequest.getStatusCode(), eSTResponseDoRequest.getInputStream());
                    }
                    cSRAttributesResponse = null;
                }
                try {
                    eSTResponseDoRequest.m15964close();
                    e = null;
                } catch (Exception e) {
                    e = e;
                }
                if (e == null) {
                    return new CSRRequestResponse(cSRAttributesResponse, eSTResponseDoRequest.getSource());
                }
                if (e instanceof ESTException) {
                    throw ((ESTException) e);
                }
                throw new ESTException(e.getMessage(), e, eSTResponseDoRequest.getStatusCode(), null);
            } catch (Throwable th2) {
                th = th2;
                eSTResponse = eSTResponseDoRequest;
                try {
                    if (th instanceof ESTException) {
                        throw th;
                    }
                    throw new ESTException(th.getMessage(), th);
                } catch (Throwable th3) {
                    if (eSTResponse != null) {
                        try {
                            eSTResponse.m15964close();
                        } catch (Exception unused) {
                        }
                    }
                    throw th3;
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public EnrollmentResponse handleEnrollResponse(ESTResponse eSTResponse) throws ESTException {
        Object obj;
        long time;
        ESTRequest originalRequest = eSTResponse.getOriginalRequest();
        if (eSTResponse.getStatusCode() != 202) {
            if (eSTResponse.getStatusCode() == 200 && eSTResponse.getHeaderOrEmpty("content-type").contains("multipart/mixed")) {
                final Object[] objArr = new Object[2];
                new BasicMimeParser(new C5880Headers(eSTResponse.getHeaderOrEmpty("content-type"), "base64"), eSTResponse.getInputStream()).mo17109parse(new MimeParserListener(this) { // from class: org.bouncycastle.est.ESTService.2

                    /* renamed from: this$0 */
                    final /* synthetic */ ESTService f21200this$0;

                    {
                        this.f21200this$0 = this;
                    }

                    @Override // org.bouncycastle.p296mime.MimeParserListener
                    public MimeContext createContext(MimeParserContext mimeParserContext, C5880Headers c5880Headers) {
                        return ConstantMimeContext.Instance;
                    }

                    @Override // org.bouncycastle.p296mime.MimeParserListener
                    /* renamed from: object */
                    public void mo15966object(MimeParserContext mimeParserContext, C5880Headers c5880Headers, InputStream inputStream) throws IOException {
                        if (c5880Headers.getContentType().contains("application/pkcs8")) {
                            ASN1InputStream aSN1InputStream = new ASN1InputStream(inputStream);
                            objArr[0] = PrivateKeyInfo.getInstance(aSN1InputStream.readObject());
                            if (aSN1InputStream.readObject() != null) {
                                throw new ESTException("Unexpected ASN1 object after private key info");
                            }
                            return;
                        }
                        if (c5880Headers.getContentType().contains("application/pkcs7-mime")) {
                            ASN1InputStream aSN1InputStream2 = new ASN1InputStream(inputStream);
                            try {
                                objArr[1] = new SimplePKIResponse(ContentInfo.getInstance(aSN1InputStream2.readObject()));
                                if (aSN1InputStream2.readObject() != null) {
                                    throw new ESTException("Unexpected ASN1 object after reading certificates");
                                }
                            } catch (CMCException e) {
                                throw new IOException(e.getMessage());
                            }
                        }
                    }
                });
                if (objArr[0] == null || (obj = objArr[1]) == null) {
                    throw new ESTException("received neither private key info and certificates");
                }
                return new EnrollmentResponse(((SimplePKIResponse) obj).getCertificates(), -1L, null, eSTResponse.getSource(), PrivateKeyInfo.getInstance(objArr[0]));
            }
            if (eSTResponse.getStatusCode() == 200) {
                try {
                    return new EnrollmentResponse(new SimplePKIResponse(ContentInfo.getInstance(new ASN1InputStream(eSTResponse.getInputStream()).readObject())).getCertificates(), -1L, null, eSTResponse.getSource());
                } catch (CMCException e) {
                    throw new ESTException(e.getMessage(), e.getCause());
                }
            }
            throw new ESTException("Simple Enroll: " + originalRequest.m15960getURL().toString(), null, eSTResponse.getStatusCode(), eSTResponse.getInputStream());
        }
        String header = eSTResponse.getHeader("Retry-After");
        if (header == null) {
            throw new ESTException("Got Status 202 but not Retry-After header from: " + originalRequest.m15960getURL().toString());
        }
        try {
            try {
                time = System.currentTimeMillis() + (Long.parseLong(header) * 1000);
            } catch (Exception e2) {
                throw new ESTException("Unable to parse Retry-After header:" + originalRequest.m15960getURL().toString() + " " + e2.getMessage(), null, eSTResponse.getStatusCode(), eSTResponse.getInputStream());
            }
        } catch (NumberFormatException unused) {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
            time = simpleDateFormat.parse(header).getTime();
        }
        return new EnrollmentResponse(null, time, originalRequest, eSTResponse.getSource());
    }

    public EnrollmentResponse simpleEnroll(EnrollmentResponse enrollmentResponse) throws IOException {
        if (!this.clientProvider.isTrusted()) {
            throw new IllegalStateException("No trust anchors.");
        }
        ESTResponse eSTResponseDoRequest = null;
        try {
            ESTClient eSTClientMakeClient = this.clientProvider.makeClient();
            eSTResponseDoRequest = eSTClientMakeClient.doRequest(new ESTRequestBuilder(enrollmentResponse.getRequestToRetry()).withClient(eSTClientMakeClient).m15961build());
            EnrollmentResponse enrollmentResponseHandleEnrollResponse = handleEnrollResponse(eSTResponseDoRequest);
            if (eSTResponseDoRequest != null) {
                eSTResponseDoRequest.m15964close();
            }
            return enrollmentResponseHandleEnrollResponse;
        } catch (Throwable th) {
            try {
                if (th instanceof ESTException) {
                    throw th;
                }
                throw new ESTException(th.getMessage(), th);
            } catch (Throwable th2) {
                if (eSTResponseDoRequest != null) {
                    eSTResponseDoRequest.m15964close();
                }
                throw th2;
            }
        }
    }

    public EnrollmentResponse simpleEnrollPoP(boolean z, PKCS10CertificationRequestBuilder pKCS10CertificationRequestBuilder, ContentSigner contentSigner, InterfaceC5436ESTAuth interfaceC5436ESTAuth) {
        return enrollPop(z, pKCS10CertificationRequestBuilder, contentSigner, interfaceC5436ESTAuth, false);
    }

    public EnrollmentResponse simpleEnrollPopWithServersideCreation(PKCS10CertificationRequestBuilder pKCS10CertificationRequestBuilder, ContentSigner contentSigner, InterfaceC5436ESTAuth interfaceC5436ESTAuth) {
        return enrollPop(false, pKCS10CertificationRequestBuilder, contentSigner, interfaceC5436ESTAuth, true);
    }

    public EnrollmentResponse simpleEnrollWithServersideCreation(PKCS10CertificationRequest pKCS10CertificationRequest, InterfaceC5436ESTAuth interfaceC5436ESTAuth) {
        return m15965enroll(false, pKCS10CertificationRequest, interfaceC5436ESTAuth, true);
    }

    public static X509CertificateHolder[] storeToArray(InterfaceC6249Store<X509CertificateHolder> interfaceC6249Store, Selector<X509CertificateHolder> selector) {
        Collection<X509CertificateHolder> matches = interfaceC6249Store.getMatches(selector);
        return (X509CertificateHolder[]) matches.toArray(new X509CertificateHolder[matches.size()]);
    }

    public EnrollmentResponse simpleEnroll(boolean z, PKCS10CertificationRequest pKCS10CertificationRequest, InterfaceC5436ESTAuth interfaceC5436ESTAuth) {
        return m15965enroll(z, pKCS10CertificationRequest, interfaceC5436ESTAuth, false);
    }
}
