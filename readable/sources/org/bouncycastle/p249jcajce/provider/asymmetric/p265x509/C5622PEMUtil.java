package org.bouncycastle.p249jcajce.provider.asymmetric.p265x509;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p302openssl.PEMParser;
import org.bouncycastle.p361util.encoders.C6253Base64;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.x509.PEMUtil */
/* loaded from: classes2.dex */
class C5622PEMUtil {
    private final Boundaries[] _supportedBoundaries;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.x509.PEMUtil$Boundaries */
    public static class Boundaries {

        /* renamed from: _footer */
        private final String f21648_footer;

        /* renamed from: _header */
        private final String f21649_header;

        private Boundaries(String str) {
            this.f21649_header = "-----BEGIN " + str + "-----";
            this.f21648_footer = "-----END " + str + "-----";
        }

        public boolean isTheExpectedFooter(String str) {
            return str.startsWith(this.f21648_footer);
        }

        public boolean isTheExpectedHeader(String str) {
            return str.startsWith(this.f21649_header);
        }
    }

    public C5622PEMUtil(String str) {
        this._supportedBoundaries = new Boundaries[]{new Boundaries(str), new Boundaries("X509 " + str), new Boundaries(PEMParser.TYPE_PKCS7)};
    }

    private Boundaries getBoundaries(String str) {
        Boundaries boundaries;
        int i = 0;
        while (true) {
            Boundaries[] boundariesArr = this._supportedBoundaries;
            if (i == boundariesArr.length) {
                return null;
            }
            boundaries = boundariesArr[i];
            if (boundaries.isTheExpectedHeader(str) || boundaries.isTheExpectedFooter(str)) {
                break;
            }
            i++;
        }
        return boundaries;
    }

    private String readLine(InputStream inputStream) throws IOException {
        int i;
        StringBuffer stringBuffer = new StringBuffer();
        while (true) {
            i = inputStream.read();
            if (i != 13 && i != 10 && i >= 0) {
                stringBuffer.append((char) i);
            } else if (i < 0 || stringBuffer.length() != 0) {
                break;
            }
        }
        if (i < 0) {
            if (stringBuffer.length() == 0) {
                return null;
            }
            return stringBuffer.toString();
        }
        if (i == 13) {
            inputStream.mark(1);
            int i2 = inputStream.read();
            if (i2 == 10) {
                inputStream.mark(1);
            }
            if (i2 > 0) {
                inputStream.reset();
            }
        }
        return stringBuffer.toString();
    }

    public ASN1Sequence readPEMObject(InputStream inputStream, boolean z) throws IOException {
        StringBuffer stringBuffer = new StringBuffer();
        Boundaries boundaries = null;
        while (boundaries == null) {
            String line = readLine(inputStream);
            if (line == null) {
                break;
            }
            boundaries = getBoundaries(line);
            if (boundaries != null && !boundaries.isTheExpectedHeader(line)) {
                throw new IOException("malformed PEM data: found footer where header was expected");
            }
        }
        if (boundaries == null) {
            if (z) {
                throw new IOException("malformed PEM data: no header found");
            }
            return null;
        }
        Boundaries boundaries2 = null;
        while (boundaries2 == null) {
            String line2 = readLine(inputStream);
            if (line2 == null) {
                break;
            }
            boundaries2 = getBoundaries(line2);
            if (boundaries2 == null) {
                stringBuffer.append(line2);
            } else if (!boundaries.isTheExpectedFooter(line2)) {
                throw new IOException("malformed PEM data: header/footer mismatch");
            }
        }
        if (boundaries2 == null) {
            throw new IOException("malformed PEM data: no footer found");
        }
        if (stringBuffer.length() == 0) {
            return null;
        }
        try {
            return ASN1Sequence.getInstance(C6253Base64.m18326decode(stringBuffer.toString()));
        } catch (Exception unused) {
            throw new IOException("malformed PEM data encountered");
        }
    }
}
