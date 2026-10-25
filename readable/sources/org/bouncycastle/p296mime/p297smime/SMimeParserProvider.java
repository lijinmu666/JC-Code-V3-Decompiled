package org.bouncycastle.p296mime.p297smime;

import java.io.InputStream;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.p296mime.BasicMimeParser;
import org.bouncycastle.p296mime.C5880Headers;
import org.bouncycastle.p296mime.MimeParser;
import org.bouncycastle.p296mime.MimeParserProvider;

/* loaded from: classes2.dex */
public class SMimeParserProvider implements MimeParserProvider {
    private final String defaultContentTransferEncoding;
    private final DigestCalculatorProvider digestCalculatorProvider;

    public SMimeParserProvider(String str, DigestCalculatorProvider digestCalculatorProvider) {
        this.defaultContentTransferEncoding = str;
        this.digestCalculatorProvider = digestCalculatorProvider;
    }

    @Override // org.bouncycastle.p296mime.MimeParserProvider
    public MimeParser createParser(InputStream inputStream) {
        return new BasicMimeParser(new SMimeParserContext(this.defaultContentTransferEncoding, this.digestCalculatorProvider), SMimeUtils.autoBuffer(inputStream));
    }

    @Override // org.bouncycastle.p296mime.MimeParserProvider
    public MimeParser createParser(C5880Headers c5880Headers, InputStream inputStream) {
        return new BasicMimeParser(new SMimeParserContext(this.defaultContentTransferEncoding, this.digestCalculatorProvider), c5880Headers, SMimeUtils.autoBuffer(inputStream));
    }
}
