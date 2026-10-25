package org.bouncycastle.p358tsp.p359cms;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.p133asn1.BEROctetString;
import org.bouncycastle.p133asn1.DERIA5String;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.Evidence;
import org.bouncycastle.p133asn1.p139cms.TimeStampAndCRL;
import org.bouncycastle.p133asn1.p139cms.TimeStampTokenEvidence;
import org.bouncycastle.p133asn1.p139cms.TimeStampedData;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p358tsp.TimeStampToken;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class CMSTimeStampedDataGenerator extends CMSTimeStampedGenerator {
    public CMSTimeStampedData generate(TimeStampToken timeStampToken) {
        return generate(timeStampToken, (InputStream) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0037  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public CMSTimeStampedData generate(TimeStampToken timeStampToken, InputStream inputStream) throws CMSException {
        BEROctetString bEROctetString;
        if (inputStream != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                C6257Streams.m18361pipeAll(inputStream, byteArrayOutputStream);
                bEROctetString = byteArrayOutputStream.size() != 0 ? new BEROctetString(byteArrayOutputStream.toByteArray()) : null;
            } catch (IOException e) {
                throw new CMSException("exception encapsulating content: " + e.getMessage(), e);
            }
        }
        return new CMSTimeStampedData(new ContentInfo(CMSObjectIdentifiers.timestampedData, new TimeStampedData(this.f24173dataUri != null ? new DERIA5String(this.f24173dataUri.toString()) : null, this.metaData, bEROctetString, new Evidence(new TimeStampTokenEvidence(new TimeStampAndCRL(timeStampToken.toCMSSignedData().toASN1Structure()))))));
    }

    public CMSTimeStampedData generate(TimeStampToken timeStampToken, byte[] bArr) {
        return generate(timeStampToken, new ByteArrayInputStream(bArr));
    }
}
