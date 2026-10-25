package org.bouncycastle.p226est;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Set;
import org.bouncycastle.p226est.HttpUtil;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Properties;
import p094kotlin.p105jvm.internal.LongCompanionObject;

/* loaded from: classes2.dex */
public class ESTResponse {

    /* renamed from: ZERO */
    private static final Long f21188ZERO = 0L;
    private String HttpVersion;
    private Long absoluteReadLimit;
    private Long contentLength;

    /* renamed from: headers */
    private final HttpUtil.C5443Headers f21189headers;
    private InputStream inputStream;
    private final byte[] lineBuffer;
    private final ESTRequest originalRequest;

    /* renamed from: read */
    private long f21190read = 0;

    /* renamed from: source */
    private final InterfaceC5444Source f21191source;
    private int statusCode;
    private String statusMessage;

    public static class PrintingInputStream extends InputStream {

        /* renamed from: src */
        private final InputStream f21195src;

        private PrintingInputStream(InputStream inputStream) {
            this.f21195src = inputStream;
        }

        @Override // java.io.InputStream
        public int available() {
            return this.f21195src.available();
        }

        @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f21195src.close();
        }

        @Override // java.io.InputStream
        public int read() {
            return this.f21195src.read();
        }
    }

    public ESTResponse(ESTRequest eSTRequest, InterfaceC5444Source interfaceC5444Source) throws IOException {
        this.originalRequest = eSTRequest;
        this.f21191source = interfaceC5444Source;
        if (interfaceC5444Source instanceof LimitedSource) {
            this.absoluteReadLimit = ((LimitedSource) interfaceC5444Source).getAbsoluteReadLimit();
        }
        Set<String> setAsKeySet = Properties.asKeySet("org.bouncycastle.debug.est");
        this.inputStream = (setAsKeySet.contains("input") || setAsKeySet.contains("all")) ? new PrintingInputStream(interfaceC5444Source.getInputStream()) : interfaceC5444Source.getInputStream();
        this.f21189headers = new HttpUtil.C5443Headers();
        this.lineBuffer = new byte[1024];
        m15963process();
    }

    public static /* synthetic */ long access$108(ESTResponse eSTResponse) {
        long j = eSTResponse.f21190read;
        eSTResponse.f21190read = 1 + j;
        return j;
    }

    /* renamed from: process */
    private void m15963process() throws IOException {
        this.HttpVersion = readStringIncluding(' ');
        this.statusCode = Integer.parseInt(readStringIncluding(' '));
        this.statusMessage = readStringIncluding('\n');
        while (true) {
            String stringIncluding = readStringIncluding('\n');
            if (stringIncluding.length() <= 0) {
                break;
            }
            int iIndexOf = stringIncluding.indexOf(58);
            if (iIndexOf > -1) {
                this.f21189headers.m15972add(C6250Strings.toLowerCase(stringIncluding.substring(0, iIndexOf).trim()), stringIncluding.substring(iIndexOf + 1).trim());
            }
        }
        boolean zEqualsIgnoreCase = this.f21189headers.getFirstValueOrEmpty("Transfer-Encoding").equalsIgnoreCase("chunked");
        this.contentLength = zEqualsIgnoreCase ? 0L : getContentLength();
        int i = this.statusCode;
        if (i == 204 || i == 202) {
            Long l = this.contentLength;
            if (l == null) {
                this.contentLength = 0L;
            } else if (i == 204 && l.longValue() > 0) {
                throw new IOException("Got HTTP status 204 but Content-length > 0.");
            }
        }
        Long l2 = this.contentLength;
        if (l2 == null) {
            throw new IOException("No Content-length header.");
        }
        if (l2.equals(f21188ZERO) && !zEqualsIgnoreCase) {
            this.inputStream = new InputStream() { // from class: org.bouncycastle.est.ESTResponse.1
                @Override // java.io.InputStream
                public int read() {
                    return -1;
                }
            };
        }
        if (this.contentLength.longValue() < 0) {
            throw new IOException("Server returned negative content length: " + this.absoluteReadLimit);
        }
        if (this.absoluteReadLimit != null && this.contentLength.longValue() >= this.absoluteReadLimit.longValue()) {
            throw new IOException("Content length longer than absolute read limit: " + this.absoluteReadLimit + " Content-Length: " + this.contentLength);
        }
        this.inputStream = wrapWithCounter(this.inputStream, this.absoluteReadLimit);
        if (zEqualsIgnoreCase) {
            this.inputStream = new CTEChunkedInputStream(this.inputStream);
        }
        if ("base64".equalsIgnoreCase(getHeader("content-transfer-encoding"))) {
            this.inputStream = zEqualsIgnoreCase ? new CTEBase64InputStream(this.inputStream) : new CTEBase64InputStream(this.inputStream, this.contentLength);
        }
    }

    /* renamed from: close */
    public void m15964close() throws IOException {
        InputStream inputStream = this.inputStream;
        if (inputStream != null) {
            inputStream.close();
        }
        this.f21191source.mo15977close();
    }

    public long getAbsoluteReadLimit() {
        Long l = this.absoluteReadLimit;
        return l == null ? LongCompanionObject.MAX_VALUE : l.longValue();
    }

    public Long getContentLength() {
        String firstValue = this.f21189headers.getFirstValue("Content-Length");
        if (firstValue == null) {
            return null;
        }
        try {
            return Long.valueOf(Long.parseLong(firstValue));
        } catch (RuntimeException e) {
            throw new RuntimeException("Content Length: '" + firstValue + "' invalid. " + e.getMessage());
        }
    }

    public String getHeader(String str) {
        return this.f21189headers.getFirstValue(str);
    }

    public String getHeaderOrEmpty(String str) {
        return this.f21189headers.getFirstValueOrEmpty(str);
    }

    public HttpUtil.C5443Headers getHeaders() {
        return this.f21189headers;
    }

    public String getHttpVersion() {
        return this.HttpVersion;
    }

    public InputStream getInputStream() {
        return this.inputStream;
    }

    public ESTRequest getOriginalRequest() {
        return this.originalRequest;
    }

    public InterfaceC5444Source getSource() {
        return this.f21191source;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getStatusMessage() {
        return this.statusMessage;
    }

    public String readStringIncluding(char c) throws IOException {
        int i;
        byte[] bArr;
        int i2;
        int i3 = 0;
        while (true) {
            i = this.inputStream.read();
            bArr = this.lineBuffer;
            i2 = i3 + 1;
            bArr[i3] = (byte) i;
            if (i2 >= bArr.length) {
                throw new IOException("Server sent line > " + this.lineBuffer.length);
            }
            if (i == c || i <= -1) {
                break;
            }
            i3 = i2;
        }
        if (i != -1) {
            return new String(bArr, 0, i2).trim();
        }
        throw new EOFException();
    }

    public InputStream wrapWithCounter(final InputStream inputStream, final Long l) {
        return new InputStream(this) { // from class: org.bouncycastle.est.ESTResponse.2

            /* renamed from: this$0 */
            final /* synthetic */ ESTResponse f21193this$0;

            {
                this.f21193this$0 = this;
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() throws IOException {
                if (this.f21193this$0.contentLength == null || this.f21193this$0.contentLength.longValue() - 1 <= this.f21193this$0.f21190read) {
                    if (inputStream.available() > 0) {
                        throw new IOException("Stream closed with extra content in pipe that exceeds content length.");
                    }
                    inputStream.close();
                } else {
                    throw new IOException("Stream closed before limit fully read, Read: " + this.f21193this$0.f21190read + " ContentLength: " + this.f21193this$0.contentLength);
                }
            }

            @Override // java.io.InputStream
            public int read() throws IOException {
                int i = inputStream.read();
                if (i > -1) {
                    ESTResponse.access$108(this.f21193this$0);
                    if (l != null && this.f21193this$0.f21190read >= l.longValue()) {
                        throw new IOException("Absolute Read Limit exceeded: " + l);
                    }
                }
                return i;
            }
        };
    }
}
