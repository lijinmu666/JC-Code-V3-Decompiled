package org.bouncycastle.p296mime;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p296mime.encoding.Base64InputStream;
import org.bouncycastle.p296mime.encoding.QuotedPrintableInputStream;

/* loaded from: classes2.dex */
public class BasicMimeParser implements MimeParser {
    private final String boundary;
    private final String defaultContentTransferEncoding;

    /* renamed from: headers */
    private C5880Headers f22491headers;
    private boolean isMultipart;
    private final MimeParserContext parserContext;

    /* renamed from: src */
    private final InputStream f22492src;

    public BasicMimeParser(InputStream inputStream) {
        this(null, new C5880Headers(inputStream, "7bit"), inputStream);
    }

    private InputStream processStream(C5880Headers c5880Headers, InputStream inputStream) {
        return c5880Headers.getContentTransferEncoding().equals("base64") ? new Base64InputStream(inputStream) : c5880Headers.getContentTransferEncoding().equals("quoted-printable") ? new QuotedPrintableInputStream(inputStream) : inputStream;
    }

    public boolean isMultipart() {
        return this.isMultipart;
    }

    @Override // org.bouncycastle.p296mime.MimeParser
    /* renamed from: parse */
    public void mo17109parse(MimeParserListener mimeParserListener) throws IOException {
        MimeContext mimeContextCreateContext = mimeParserListener.createContext(this.parserContext, this.f22491headers);
        if (!this.isMultipart) {
            InputStream inputStreamApplyContext = mimeContextCreateContext.applyContext(this.f22491headers, this.f22492src);
            MimeParserContext mimeParserContext = this.parserContext;
            C5880Headers c5880Headers = this.f22491headers;
            mimeParserListener.mo15966object(mimeParserContext, c5880Headers, processStream(c5880Headers, inputStreamApplyContext));
            return;
        }
        MimeMultipartContext mimeMultipartContext = (MimeMultipartContext) mimeContextCreateContext;
        String str = "--" + this.boundary;
        LineReader lineReader = new LineReader(this.f22492src);
        boolean z = false;
        int i = 0;
        while (true) {
            String line = lineReader.readLine();
            if (line == null || "--".equals(line)) {
                return;
            }
            if (z) {
                BoundaryLimitedInputStream boundaryLimitedInputStream = new BoundaryLimitedInputStream(this.f22492src, this.boundary);
                C5880Headers c5880Headers2 = new C5880Headers(boundaryLimitedInputStream, this.defaultContentTransferEncoding);
                int i2 = i + 1;
                InputStream inputStreamApplyContext2 = mimeMultipartContext.createContext(i).applyContext(c5880Headers2, boundaryLimitedInputStream);
                mimeParserListener.mo15966object(this.parserContext, c5880Headers2, processStream(c5880Headers2, inputStreamApplyContext2));
                if (inputStreamApplyContext2.read() >= 0) {
                    throw new IOException("MIME object not fully processed");
                }
                i = i2;
            } else if (str.equals(line)) {
                BoundaryLimitedInputStream boundaryLimitedInputStream2 = new BoundaryLimitedInputStream(this.f22492src, this.boundary);
                C5880Headers c5880Headers3 = new C5880Headers(boundaryLimitedInputStream2, this.defaultContentTransferEncoding);
                int i3 = i + 1;
                InputStream inputStreamApplyContext3 = mimeMultipartContext.createContext(i).applyContext(c5880Headers3, boundaryLimitedInputStream2);
                mimeParserListener.mo15966object(this.parserContext, c5880Headers3, processStream(c5880Headers3, inputStreamApplyContext3));
                if (inputStreamApplyContext3.read() >= 0) {
                    throw new IOException("MIME object not fully processed");
                }
                z = true;
                i = i3;
            } else {
                continue;
            }
        }
    }

    public BasicMimeParser(C5880Headers c5880Headers, InputStream inputStream) {
        this(null, c5880Headers, inputStream);
    }

    public BasicMimeParser(MimeParserContext mimeParserContext, InputStream inputStream) {
        this(mimeParserContext, new C5880Headers(inputStream, mimeParserContext.getDefaultContentTransferEncoding()), inputStream);
    }

    public BasicMimeParser(MimeParserContext mimeParserContext, C5880Headers c5880Headers, InputStream inputStream) {
        String boundary;
        this.isMultipart = false;
        if (c5880Headers.isMultipart()) {
            this.isMultipart = true;
            boundary = c5880Headers.getBoundary();
        } else {
            boundary = null;
        }
        this.boundary = boundary;
        this.f22491headers = c5880Headers;
        this.parserContext = mimeParserContext;
        this.f22492src = inputStream;
        this.defaultContentTransferEncoding = mimeParserContext != null ? mimeParserContext.getDefaultContentTransferEncoding() : "7bit";
    }
}
