package org.bouncycastle.p358tsp.p359cms;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p139cms.AttributeTable;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.Evidence;
import org.bouncycastle.p133asn1.p139cms.TimeStampAndCRL;
import org.bouncycastle.p133asn1.p139cms.TimeStampTokenEvidence;
import org.bouncycastle.p133asn1.p139cms.TimeStampedData;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p358tsp.TimeStampToken;

/* loaded from: classes2.dex */
public class CMSTimeStampedData {
    private ContentInfo contentInfo;
    private TimeStampedData timeStampedData;

    /* renamed from: util */
    private TimeStampDataUtil f24171util;

    public CMSTimeStampedData(InputStream inputStream) throws IOException {
        try {
            initialize(ContentInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
        } catch (ClassCastException e) {
            throw new IOException("Malformed content: " + e);
        } catch (IllegalArgumentException e2) {
            throw new IOException("Malformed content: " + e2);
        }
    }

    private void initialize(ContentInfo contentInfo) {
        this.contentInfo = contentInfo;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CMSObjectIdentifiers.timestampedData;
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) contentInfo.getContentType())) {
            TimeStampedData timeStampedData = TimeStampedData.getInstance(contentInfo.getContent());
            this.timeStampedData = timeStampedData;
            this.f24171util = new TimeStampDataUtil(timeStampedData);
        } else {
            throw new IllegalArgumentException("Malformed content - type must be " + aSN1ObjectIdentifier.m14433getId());
        }
    }

    public CMSTimeStampedData addTimeStamp(TimeStampToken timeStampToken) {
        TimeStampAndCRL[] timeStamps = this.f24171util.getTimeStamps();
        TimeStampAndCRL[] timeStampAndCRLArr = new TimeStampAndCRL[timeStamps.length + 1];
        System.arraycopy(timeStamps, 0, timeStampAndCRLArr, 0, timeStamps.length);
        timeStampAndCRLArr[timeStamps.length] = new TimeStampAndCRL(timeStampToken.toCMSSignedData().toASN1Structure());
        return new CMSTimeStampedData(new ContentInfo(CMSObjectIdentifiers.timestampedData, new TimeStampedData(this.timeStampedData.getDataUriIA5(), this.timeStampedData.getMetaData(), this.timeStampedData.getContent(), new Evidence(new TimeStampTokenEvidence(timeStampAndCRLArr)))));
    }

    public byte[] calculateNextHash(DigestCalculator digestCalculator) {
        return this.f24171util.calculateNextHash(digestCalculator);
    }

    public byte[] getContent() {
        if (this.timeStampedData.getContent() != null) {
            return this.timeStampedData.getContent().getOctets();
        }
        return null;
    }

    public URI getDataUri() {
        ASN1IA5String dataUriIA5 = this.timeStampedData.getDataUriIA5();
        if (dataUriIA5 != null) {
            return new URI(dataUriIA5.getString());
        }
        return null;
    }

    public byte[] getEncoded() {
        return this.contentInfo.getEncoded();
    }

    public String getFileName() {
        return this.f24171util.getFileName();
    }

    public String getMediaType() {
        return this.f24171util.getMediaType();
    }

    public DigestCalculator getMessageImprintDigestCalculator(DigestCalculatorProvider digestCalculatorProvider) {
        return this.f24171util.getMessageImprintDigestCalculator(digestCalculatorProvider);
    }

    public AttributeTable getOtherMetaData() {
        return this.f24171util.getOtherMetaData();
    }

    public TimeStampToken[] getTimeStampTokens() {
        return this.f24171util.getTimeStampTokens();
    }

    public void initialiseMessageImprintDigestCalculator(DigestCalculator digestCalculator) throws CMSException, IOException {
        this.f24171util.initialiseMessageImprintDigestCalculator(digestCalculator);
    }

    public void validate(DigestCalculatorProvider digestCalculatorProvider, byte[] bArr) throws ImprintDigestInvalidException, CMSException, IOException {
        this.f24171util.validate(digestCalculatorProvider, bArr);
    }

    public CMSTimeStampedData(ContentInfo contentInfo) {
        initialize(contentInfo);
    }

    public void validate(DigestCalculatorProvider digestCalculatorProvider, byte[] bArr, TimeStampToken timeStampToken) throws ImprintDigestInvalidException, CMSException, IOException {
        this.f24171util.validate(digestCalculatorProvider, bArr, timeStampToken);
    }

    public CMSTimeStampedData(byte[] bArr) {
        this(new ByteArrayInputStream(bArr));
    }
}
