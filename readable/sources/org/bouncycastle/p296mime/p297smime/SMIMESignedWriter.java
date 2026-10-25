package org.bouncycastle.p296mime.p297smime;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p191cms.CMSAlgorithm;
import org.bouncycastle.p191cms.CMSSignedDataStreamGenerator;
import org.bouncycastle.p191cms.SignerInfoGenerator;
import org.bouncycastle.p296mime.C5880Headers;
import org.bouncycastle.p296mime.MimeWriter;
import org.bouncycastle.p296mime.encoding.Base64OutputStream;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.InterfaceC6249Store;
import p094kotlin.p117text.Typography;

/* loaded from: classes2.dex */
public class SMIMESignedWriter extends MimeWriter {
    public static final Map RFC3851_MICALGS;
    public static final Map RFC5751_MICALGS;
    public static final Map STANDARD_MICALGS;
    private final String boundary;
    private final String contentTransferEncoding;

    /* renamed from: mimeOut */
    private final OutputStream f22523mimeOut;

    /* renamed from: sigGen */
    private final CMSSignedDataStreamGenerator f22524sigGen;

    /* renamed from: org.bouncycastle.mime.smime.SMIMESignedWriter$Builder */
    public static class C5884Builder {
        private static final String[] detHeaders = {"Content-Type"};
        private static final String[] detValues = {"multipart/signed; protocol=\"application/pkcs7-signature\""};
        private static final String[] encHeaders = {"Content-Type", "Content-Disposition", "Content-Transfer-Encoding", "Content-Description"};
        private static final String[] encValues = {"application/pkcs7-mime; name=\"smime.p7m\"; smime-type=enveloped-data", "attachment; filename=\"smime.p7m\"", "base64", "S/MIME Signed Message"};
        String contentTransferEncoding;
        private final boolean encapsulated;
        private final Map<String, String> extraHeaders;

        /* renamed from: micAlgs */
        private final Map f22525micAlgs;

        /* renamed from: sigGen */
        private final CMSSignedDataStreamGenerator f22526sigGen;

        public C5884Builder() {
            this(false);
        }

        private void addBoundary(StringBuilder sb, String str) {
            sb.append(";\r\n\tboundary=\"");
            sb.append(str);
            sb.append("\"");
        }

        private void addHashHeader(StringBuilder sb, List list) {
            Iterator it = list.iterator();
            TreeSet<String> treeSet = new TreeSet();
            while (it.hasNext()) {
                String str = (String) this.f22525micAlgs.get(((AlgorithmIdentifier) it.next()).getAlgorithm());
                if (str == null) {
                    str = "unknown";
                }
                treeSet.add(str);
            }
            int i = 0;
            for (String str2 : treeSet) {
                if (i == 0) {
                    sb.append(treeSet.size() != 1 ? "; micalg=\"" : "; micalg=");
                } else {
                    sb.append(',');
                }
                sb.append(str2);
                i++;
            }
            if (i == 0 || treeSet.size() == 1) {
                return;
            }
            sb.append(Typography.quote);
        }

        private String generateBoundary() {
            return "==" + new BigInteger(180, new SecureRandom()).setBit(179).toString(16) + "=";
        }

        public C5884Builder addCertificate(X509CertificateHolder x509CertificateHolder) {
            this.f22526sigGen.addCertificate(x509CertificateHolder);
            return this;
        }

        public C5884Builder addCertificates(InterfaceC6249Store interfaceC6249Store) {
            this.f22526sigGen.addCertificates(interfaceC6249Store);
            return this;
        }

        public C5884Builder addSignerInfoGenerator(SignerInfoGenerator signerInfoGenerator) {
            this.f22526sigGen.addSignerInfoGenerator(signerInfoGenerator);
            return this;
        }

        /* renamed from: build */
        public SMIMESignedWriter m17115build(OutputStream outputStream) {
            String strGenerateBoundary;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            int i = 0;
            if (!this.encapsulated) {
                strGenerateBoundary = generateBoundary();
                StringBuilder sb = new StringBuilder(detValues[0]);
                addHashHeader(sb, this.f22526sigGen.getDigestAlgorithms());
                addBoundary(sb, strGenerateBoundary);
                linkedHashMap.put(detHeaders[0], sb.toString());
                int i2 = 1;
                while (true) {
                    String[] strArr = detHeaders;
                    if (i2 >= strArr.length) {
                        break;
                    }
                    linkedHashMap.put(strArr[i2], detValues[i2]);
                    i2++;
                }
            } else {
                while (true) {
                    String[] strArr2 = encHeaders;
                    if (i == strArr2.length) {
                        break;
                    }
                    linkedHashMap.put(strArr2[i], encValues[i]);
                    i++;
                }
                strGenerateBoundary = null;
            }
            String str = strGenerateBoundary;
            for (Map.Entry<String, String> entry : this.extraHeaders.entrySet()) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
            return new SMIMESignedWriter(this, linkedHashMap, str, SMimeUtils.autoBuffer(outputStream));
        }

        public C5884Builder withHeader(String str, String str2) {
            this.extraHeaders.put(str, str2);
            return this;
        }

        public C5884Builder(boolean z) {
            this.f22526sigGen = new CMSSignedDataStreamGenerator();
            this.extraHeaders = new LinkedHashMap();
            this.f22525micAlgs = SMIMESignedWriter.STANDARD_MICALGS;
            this.contentTransferEncoding = "base64";
            this.encapsulated = z;
        }
    }

    public class ContentOutputStream extends OutputStream {

        /* renamed from: backing */
        private final OutputStream f22527backing;

        /* renamed from: main */
        private final OutputStream f22528main;

        /* renamed from: sigBase */
        private final OutputStream f22529sigBase;
        private final ByteArrayOutputStream sigStream;

        public ContentOutputStream(OutputStream outputStream, OutputStream outputStream2, ByteArrayOutputStream byteArrayOutputStream, OutputStream outputStream3) {
            this.f22528main = outputStream;
            this.f22527backing = outputStream2;
            this.sigStream = byteArrayOutputStream;
            this.f22529sigBase = outputStream3;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            if (SMIMESignedWriter.this.boundary != null) {
                this.f22528main.close();
                this.f22527backing.write(C6250Strings.toByteArray("\r\n--"));
                this.f22527backing.write(C6250Strings.toByteArray(SMIMESignedWriter.this.boundary));
                this.f22527backing.write(C6250Strings.toByteArray("\r\n"));
                this.f22527backing.write(C6250Strings.toByteArray("Content-Type: application/pkcs7-signature; name=\"smime.p7s\"\r\n"));
                this.f22527backing.write(C6250Strings.toByteArray("Content-Transfer-Encoding: base64\r\n"));
                this.f22527backing.write(C6250Strings.toByteArray("Content-Disposition: attachment; filename=\"smime.p7s\"\r\n"));
                this.f22527backing.write(C6250Strings.toByteArray("\r\n"));
                OutputStream outputStream = this.f22529sigBase;
                if (outputStream != null) {
                    outputStream.close();
                }
                this.f22527backing.write(this.sigStream.toByteArray());
                this.f22527backing.write(C6250Strings.toByteArray("\r\n--"));
                this.f22527backing.write(C6250Strings.toByteArray(SMIMESignedWriter.this.boundary));
                this.f22527backing.write(C6250Strings.toByteArray("--\r\n"));
            }
            OutputStream outputStream2 = this.f22527backing;
            if (outputStream2 != null) {
                outputStream2.close();
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f22528main.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f22528main.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f22528main.write(bArr, i, i2);
        }
    }

    static {
        HashMap map = new HashMap();
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CMSAlgorithm.f18928MD5;
        map.put(aSN1ObjectIdentifier, "md5");
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CMSAlgorithm.f18931SHA1;
        map.put(aSN1ObjectIdentifier2, "sha-1");
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = CMSAlgorithm.f18932SHA224;
        map.put(aSN1ObjectIdentifier3, "sha-224");
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = CMSAlgorithm.f18933SHA256;
        map.put(aSN1ObjectIdentifier4, "sha-256");
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = CMSAlgorithm.f18934SHA384;
        map.put(aSN1ObjectIdentifier5, "sha-384");
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = CMSAlgorithm.f18935SHA512;
        map.put(aSN1ObjectIdentifier6, "sha-512");
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = CMSAlgorithm.GOST3411;
        map.put(aSN1ObjectIdentifier7, "gostr3411-94");
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = CMSAlgorithm.GOST3411_2012_256;
        map.put(aSN1ObjectIdentifier8, "gostr3411-2012-256");
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = CMSAlgorithm.GOST3411_2012_512;
        map.put(aSN1ObjectIdentifier9, "gostr3411-2012-512");
        Map mapUnmodifiableMap = Collections.unmodifiableMap(map);
        RFC5751_MICALGS = mapUnmodifiableMap;
        HashMap map2 = new HashMap();
        map2.put(aSN1ObjectIdentifier, "md5");
        map2.put(aSN1ObjectIdentifier2, "sha1");
        map2.put(aSN1ObjectIdentifier3, "sha224");
        map2.put(aSN1ObjectIdentifier4, "sha256");
        map2.put(aSN1ObjectIdentifier5, "sha384");
        map2.put(aSN1ObjectIdentifier6, "sha512");
        map2.put(aSN1ObjectIdentifier7, "gostr3411-94");
        map2.put(aSN1ObjectIdentifier8, "gostr3411-2012-256");
        map2.put(aSN1ObjectIdentifier9, "gostr3411-2012-512");
        RFC3851_MICALGS = Collections.unmodifiableMap(map2);
        STANDARD_MICALGS = mapUnmodifiableMap;
    }

    private SMIMESignedWriter(C5884Builder c5884Builder, Map<String, String> map, String str, OutputStream outputStream) {
        super(new C5880Headers(MimeWriter.mapToLines(map), c5884Builder.contentTransferEncoding));
        this.f22524sigGen = c5884Builder.f22526sigGen;
        this.contentTransferEncoding = c5884Builder.contentTransferEncoding;
        this.boundary = str;
        this.f22523mimeOut = outputStream;
    }

    @Override // org.bouncycastle.p296mime.MimeWriter
    public OutputStream getContentStream() throws IOException {
        this.f22508headers.dumpHeaders(this.f22523mimeOut);
        this.f22523mimeOut.write(C6250Strings.toByteArray("\r\n"));
        if (this.boundary == null) {
            return null;
        }
        this.f22523mimeOut.write(C6250Strings.toByteArray("This is an S/MIME signed message\r\n"));
        this.f22523mimeOut.write(C6250Strings.toByteArray("\r\n--"));
        this.f22523mimeOut.write(C6250Strings.toByteArray(this.boundary));
        this.f22523mimeOut.write(C6250Strings.toByteArray("\r\n"));
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        Base64OutputStream base64OutputStream = new Base64OutputStream(byteArrayOutputStream);
        return new ContentOutputStream(this.f22524sigGen.m14871open((OutputStream) base64OutputStream, false, SMimeUtils.createUnclosable(this.f22523mimeOut)), this.f22523mimeOut, byteArrayOutputStream, base64OutputStream);
    }
}
