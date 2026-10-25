package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p133asn1.ASN1SequenceParser;
import org.bouncycastle.p133asn1.ASN1StreamParser;
import org.bouncycastle.p133asn1.p139cms.ContentInfoParser;

/* loaded from: classes2.dex */
public class CMSContentInfoParser {
    protected ContentInfoParser _contentInfo;

    /* renamed from: _data */
    protected InputStream f18966_data;

    public CMSContentInfoParser(InputStream inputStream) throws CMSException {
        this.f18966_data = inputStream;
        try {
            ASN1SequenceParser aSN1SequenceParser = (ASN1SequenceParser) new ASN1StreamParser(inputStream).readObject();
            if (aSN1SequenceParser == null) {
                throw new CMSException("No content found.");
            }
            this._contentInfo = new ContentInfoParser(aSN1SequenceParser);
        } catch (IOException e) {
            throw new CMSException("IOException reading content.", e);
        } catch (ClassCastException e2) {
            throw new CMSException("Unexpected object reading content.", e2);
        }
    }

    /* renamed from: close */
    public void m14861close() throws IOException {
        this.f18966_data.close();
    }
}
