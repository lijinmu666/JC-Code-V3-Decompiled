package org.bouncycastle.p296mime.p297smime;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p296mime.C5880Headers;
import org.bouncycastle.p296mime.CanonicalOutputStream;
import org.bouncycastle.p296mime.MimeContext;
import org.bouncycastle.p296mime.MimeMultipartContext;
import org.bouncycastle.p296mime.MimeParserContext;
import org.bouncycastle.p361util.p362io.TeeInputStream;
import org.bouncycastle.p361util.p362io.TeeOutputStream;

/* loaded from: classes2.dex */
public class SMimeMultipartContext implements MimeMultipartContext {
    private DigestCalculator[] calculators;
    private final SMimeParserContext parserContext;

    public SMimeMultipartContext(MimeParserContext mimeParserContext, C5880Headers c5880Headers) {
        this.parserContext = (SMimeParserContext) mimeParserContext;
        this.calculators = createDigestCalculators(c5880Headers);
    }

    private DigestCalculator[] createDigestCalculators(C5880Headers c5880Headers) {
        try {
            String str = c5880Headers.getContentTypeAttributes().get("micalg");
            if (str == null) {
                throw new IllegalStateException("No micalg field on content-type header");
            }
            String[] strArrSplit = str.substring(str.indexOf(61) + 1).split(",");
            DigestCalculator[] digestCalculatorArr = new DigestCalculator[strArrSplit.length];
            for (int i = 0; i < strArrSplit.length; i++) {
                digestCalculatorArr[i] = this.parserContext.getDigestCalculatorProvider().mo14763get(new AlgorithmIdentifier(SMimeUtils.getDigestOID(SMimeUtils.lessQuotes(strArrSplit[i]).trim())));
            }
            return digestCalculatorArr;
        } catch (OperatorCreationException unused) {
            return null;
        }
    }

    @Override // org.bouncycastle.p296mime.MimeContext
    public InputStream applyContext(C5880Headers c5880Headers, InputStream inputStream) {
        return inputStream;
    }

    @Override // org.bouncycastle.p296mime.MimeMultipartContext
    public MimeContext createContext(final int i) {
        return new MimeContext(this) { // from class: org.bouncycastle.mime.smime.SMimeMultipartContext.1

            /* renamed from: this$0 */
            final /* synthetic */ SMimeMultipartContext f22531this$0;

            {
                this.f22531this$0 = this;
            }

            @Override // org.bouncycastle.p296mime.MimeContext
            public InputStream applyContext(C5880Headers c5880Headers, InputStream inputStream) throws IOException {
                if (i != 0) {
                    return inputStream;
                }
                OutputStream digestOutputStream = this.f22531this$0.getDigestOutputStream();
                c5880Headers.dumpHeaders(digestOutputStream);
                digestOutputStream.write(13);
                digestOutputStream.write(10);
                return new TeeInputStream(inputStream, new CanonicalOutputStream(this.f22531this$0.parserContext, c5880Headers, digestOutputStream));
            }
        };
    }

    public DigestCalculator[] getDigestCalculators() {
        return this.calculators;
    }

    public OutputStream getDigestOutputStream() {
        DigestCalculator[] digestCalculatorArr = this.calculators;
        int i = 1;
        if (digestCalculatorArr.length == 1) {
            return digestCalculatorArr[0].getOutputStream();
        }
        OutputStream outputStream = digestCalculatorArr[0].getOutputStream();
        while (i < this.calculators.length) {
            TeeOutputStream teeOutputStream = new TeeOutputStream(this.calculators[i].getOutputStream(), outputStream);
            i++;
            outputStream = teeOutputStream;
        }
        return outputStream;
    }
}
