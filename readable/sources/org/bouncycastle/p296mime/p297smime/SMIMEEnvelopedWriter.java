package org.bouncycastle.p296mime.p297smime;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p191cms.CMSAttributeTableGenerator;
import org.bouncycastle.p191cms.CMSEnvelopedDataStreamGenerator;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.OriginatorInformation;
import org.bouncycastle.p191cms.RecipientInfoGenerator;
import org.bouncycastle.p296mime.C5880Headers;
import org.bouncycastle.p296mime.MimeIOException;
import org.bouncycastle.p296mime.MimeWriter;
import org.bouncycastle.p296mime.encoding.Base64OutputStream;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SMIMEEnvelopedWriter extends MimeWriter {
    private final String contentTransferEncoding;

    /* renamed from: envGen */
    private final CMSEnvelopedDataStreamGenerator f22516envGen;

    /* renamed from: mimeOut */
    private final OutputStream f22517mimeOut;

    /* renamed from: outEnc */
    private final OutputEncryptor f22518outEnc;

    /* renamed from: org.bouncycastle.mime.smime.SMIMEEnvelopedWriter$Builder */
    public static class C5882Builder {
        private static final String[] stdHeaders = {"Content-Type", "Content-Disposition", "Content-Transfer-Encoding", "Content-Description"};
        private static final String[] stdValues = {"application/pkcs7-mime; name=\"smime.p7m\"; smime-type=enveloped-data", "attachment; filename=\"smime.p7m\"", "base64", "S/MIME Encrypted Message"};

        /* renamed from: envGen */
        private final CMSEnvelopedDataStreamGenerator f22519envGen = new CMSEnvelopedDataStreamGenerator();

        /* renamed from: headers */
        private final Map<String, String> f22520headers = new LinkedHashMap();
        String contentTransferEncoding = "base64";

        public C5882Builder() {
            int i = 0;
            while (true) {
                String[] strArr = stdHeaders;
                if (i == strArr.length) {
                    return;
                }
                this.f22520headers.put(strArr[i], stdValues[i]);
                i++;
            }
        }

        public C5882Builder addRecipientInfoGenerator(RecipientInfoGenerator recipientInfoGenerator) {
            this.f22519envGen.addRecipientInfoGenerator(recipientInfoGenerator);
            return this;
        }

        /* renamed from: build */
        public SMIMEEnvelopedWriter m17114build(OutputStream outputStream, OutputEncryptor outputEncryptor) {
            return new SMIMEEnvelopedWriter(this, outputEncryptor, SMimeUtils.autoBuffer(outputStream));
        }

        public C5882Builder setBufferSize(int i) {
            this.f22519envGen.setBufferSize(i);
            return this;
        }

        public C5882Builder setOriginatorInfo(OriginatorInformation originatorInformation) {
            this.f22519envGen.setOriginatorInfo(originatorInformation);
            return this;
        }

        public C5882Builder setUnprotectedAttributeGenerator(CMSAttributeTableGenerator cMSAttributeTableGenerator) {
            this.f22519envGen.setUnprotectedAttributeGenerator(cMSAttributeTableGenerator);
            return this;
        }

        public C5882Builder withHeader(String str, String str2) {
            this.f22520headers.put(str, str2);
            return this;
        }
    }

    public static class ContentOutputStream extends OutputStream {

        /* renamed from: backing */
        private final OutputStream f22521backing;

        /* renamed from: main */
        private final OutputStream f22522main;

        public ContentOutputStream(OutputStream outputStream, OutputStream outputStream2) {
            this.f22522main = outputStream;
            this.f22521backing = outputStream2;
        }

        @Override // java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            this.f22522main.close();
            OutputStream outputStream = this.f22521backing;
            if (outputStream != null) {
                outputStream.close();
            }
        }

        @Override // java.io.OutputStream
        public void write(int i) throws IOException {
            this.f22522main.write(i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws IOException {
            this.f22522main.write(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws IOException {
            this.f22522main.write(bArr, i, i2);
        }
    }

    private SMIMEEnvelopedWriter(C5882Builder c5882Builder, OutputEncryptor outputEncryptor, OutputStream outputStream) {
        super(new C5880Headers(MimeWriter.mapToLines(c5882Builder.f22520headers), c5882Builder.contentTransferEncoding));
        this.f22516envGen = c5882Builder.f22519envGen;
        this.contentTransferEncoding = c5882Builder.contentTransferEncoding;
        this.f22518outEnc = outputEncryptor;
        this.f22517mimeOut = outputStream;
    }

    @Override // org.bouncycastle.p296mime.MimeWriter
    public OutputStream getContentStream() throws IOException {
        this.f22508headers.dumpHeaders(this.f22517mimeOut);
        this.f22517mimeOut.write(C6250Strings.toByteArray("\r\n"));
        try {
            OutputStream base64OutputStream = this.f22517mimeOut;
            if ("base64".equals(this.contentTransferEncoding)) {
                base64OutputStream = new Base64OutputStream(base64OutputStream);
            }
            return new ContentOutputStream(this.f22516envGen.m14864open(SMimeUtils.createUnclosable(base64OutputStream), this.f22518outEnc), base64OutputStream);
        } catch (CMSException e) {
            throw new MimeIOException(e.getMessage(), e);
        }
    }
}
