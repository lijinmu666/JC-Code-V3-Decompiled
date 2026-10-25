package org.bouncycastle.p296mime.p297smime;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p191cms.CMSEnvelopedDataParser;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p191cms.CMSSignedData;
import org.bouncycastle.p191cms.OriginatorInformation;
import org.bouncycastle.p191cms.RecipientInformationStore;
import org.bouncycastle.p191cms.SignerInformationStore;
import org.bouncycastle.p296mime.C5880Headers;
import org.bouncycastle.p296mime.ConstantMimeContext;
import org.bouncycastle.p296mime.MimeContext;
import org.bouncycastle.p296mime.MimeIOException;
import org.bouncycastle.p296mime.MimeParserContext;
import org.bouncycastle.p296mime.MimeParserListener;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public abstract class SMimeParserListener implements MimeParserListener {
    private DigestCalculator[] digestCalculators;

    /* renamed from: parent */
    private SMimeMultipartContext f22532parent;

    /* renamed from: content */
    public void m17116content(MimeParserContext mimeParserContext, C5880Headers c5880Headers, InputStream inputStream) {
        throw new IllegalStateException("content handling not implemented");
    }

    @Override // org.bouncycastle.p296mime.MimeParserListener
    public MimeContext createContext(MimeParserContext mimeParserContext, C5880Headers c5880Headers) {
        if (!c5880Headers.isMultipart()) {
            return new ConstantMimeContext();
        }
        SMimeMultipartContext sMimeMultipartContext = new SMimeMultipartContext(mimeParserContext, c5880Headers);
        this.f22532parent = sMimeMultipartContext;
        this.digestCalculators = sMimeMultipartContext.getDigestCalculators();
        return this.f22532parent;
    }

    public void envelopedData(MimeParserContext mimeParserContext, C5880Headers c5880Headers, OriginatorInformation originatorInformation, RecipientInformationStore recipientInformationStore) {
        throw new IllegalStateException("envelopedData handling not implemented");
    }

    @Override // org.bouncycastle.p296mime.MimeParserListener
    /* renamed from: object */
    public void mo15966object(MimeParserContext mimeParserContext, C5880Headers c5880Headers, InputStream inputStream) throws IOException {
        try {
            if (!c5880Headers.getContentType().equals("application/pkcs7-signature") && !c5880Headers.getContentType().equals("application/x-pkcs7-signature")) {
                if (!c5880Headers.getContentType().equals("application/pkcs7-mime") && !c5880Headers.getContentType().equals("application/x-pkcs7-mime")) {
                    m17116content(mimeParserContext, c5880Headers, inputStream);
                    return;
                }
                CMSEnvelopedDataParser cMSEnvelopedDataParser = new CMSEnvelopedDataParser(inputStream);
                envelopedData(mimeParserContext, c5880Headers, cMSEnvelopedDataParser.getOriginatorInfo(), cMSEnvelopedDataParser.getRecipientInfos());
                cMSEnvelopedDataParser.m14861close();
                return;
            }
            HashMap map = new HashMap();
            int i = 0;
            while (true) {
                DigestCalculator[] digestCalculatorArr = this.digestCalculators;
                if (i == digestCalculatorArr.length) {
                    CMSSignedData cMSSignedData = new CMSSignedData(map, C6257Streams.m18363readAll(inputStream));
                    signedData(mimeParserContext, c5880Headers, cMSSignedData.getCertificates(), cMSSignedData.m14867getCRLs(), cMSSignedData.getAttributeCertificates(), cMSSignedData.getSignerInfos());
                    return;
                } else {
                    digestCalculatorArr[i].getOutputStream().close();
                    map.put(this.digestCalculators[i].getAlgorithmIdentifier().getAlgorithm(), this.digestCalculators[i].getDigest());
                    i++;
                }
            }
        } catch (CMSException e) {
            throw new MimeIOException("CMS failure: " + e.getMessage(), e);
        }
    }

    public void signedData(MimeParserContext mimeParserContext, C5880Headers c5880Headers, InterfaceC6249Store interfaceC6249Store, InterfaceC6249Store interfaceC6249Store2, InterfaceC6249Store interfaceC6249Store3, SignerInformationStore signerInformationStore) {
        throw new IllegalStateException("signedData handling not implemented");
    }
}
