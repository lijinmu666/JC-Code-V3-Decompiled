package org.bouncycastle.p358tsp;

import java.io.InputStream;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DLSequence;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.bouncycastle.p133asn1.p138cmp.PKIFreeText;
import org.bouncycastle.p133asn1.p139cms.Attribute;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p169tsp.TimeStampResp;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class TimeStampResponse {

    /* renamed from: resp */
    private final TimeStampResp f24158resp;
    private final TimeStampToken timeStampToken;

    public TimeStampResponse(InputStream inputStream) {
        this(parseTimeStampResp(inputStream));
    }

    private static TimeStampResp parseTimeStampResp(InputStream inputStream) throws TSPException {
        try {
            return TimeStampResp.getInstance(new ASN1InputStream(inputStream).readObject());
        } catch (ClassCastException e) {
            throw new TSPException("malformed timestamp response: " + e, e);
        } catch (IllegalArgumentException e2) {
            throw new TSPException("malformed timestamp response: " + e2, e2);
        }
    }

    public byte[] getEncoded() {
        return this.f24158resp.getEncoded();
    }

    public PKIFailureInfo getFailInfo() {
        if (this.f24158resp.getStatus().getFailInfo() != null) {
            return new PKIFailureInfo(this.f24158resp.getStatus().getFailInfo());
        }
        return null;
    }

    public int getStatus() {
        return this.f24158resp.getStatus().getStatusObject().intValueExact();
    }

    public String getStatusString() {
        if (this.f24158resp.getStatus().getStatusString() == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        PKIFreeText statusString = this.f24158resp.getStatus().getStatusString();
        for (int i = 0; i != statusString.m14518size(); i++) {
            sb.append(statusString.getStringAtUTF8(i).getString());
        }
        return sb.toString();
    }

    public TimeStampToken getTimeStampToken() {
        return this.timeStampToken;
    }

    public void validate(TimeStampRequest timeStampRequest) throws TSPValidationException {
        TimeStampToken timeStampToken = getTimeStampToken();
        if (timeStampToken == null) {
            if (getStatus() == 0 || getStatus() == 1) {
                throw new TSPValidationException("no time stamp token found and one expected.");
            }
            return;
        }
        TimeStampTokenInfo timeStampInfo = timeStampToken.getTimeStampInfo();
        if (timeStampRequest.getNonce() != null && !timeStampRequest.getNonce().equals(timeStampInfo.getNonce())) {
            throw new TSPValidationException("response contains wrong nonce value.");
        }
        if (getStatus() != 0 && getStatus() != 1) {
            throw new TSPValidationException("time stamp token found in failed request.");
        }
        if (!timeStampInfo.getMessageImprintAlgOID().m14446equals((ASN1Primitive) timeStampRequest.getMessageImprintAlgOID())) {
            throw new TSPValidationException("response for different message imprint algorithm.");
        }
        if (!C6238Arrays.constantTimeAreEqual(timeStampRequest.getMessageImprintDigest(), timeStampInfo.getMessageImprintDigest())) {
            throw new TSPValidationException("response for different message imprint digest.");
        }
        Attribute attributeM14530get = timeStampToken.getSignedAttributes().m14530get(PKCSObjectIdentifiers.id_aa_signingCertificate);
        Attribute attributeM14530get2 = timeStampToken.getSignedAttributes().m14530get(PKCSObjectIdentifiers.id_aa_signingCertificateV2);
        if (attributeM14530get == null && attributeM14530get2 == null) {
            throw new TSPValidationException("no signing certificate attribute present.");
        }
        if (timeStampRequest.getReqPolicy() != null && !timeStampRequest.getReqPolicy().m14446equals((ASN1Primitive) timeStampInfo.getPolicy())) {
            throw new TSPValidationException("TSA policy wrong for request.");
        }
    }

    public TimeStampResponse(DLSequence dLSequence) throws TSPException {
        try {
            this.f24158resp = TimeStampResp.getInstance(dLSequence);
            this.timeStampToken = new TimeStampToken(ContentInfo.getInstance(dLSequence.getObjectAt(1)));
        } catch (ClassCastException e) {
            throw new TSPException("malformed timestamp response: " + e, e);
        } catch (IllegalArgumentException e2) {
            throw new TSPException("malformed timestamp response: " + e2, e2);
        }
    }

    private static TimeStampResp parseTimeStampResp(byte[] bArr) throws TSPException {
        try {
            return TimeStampResp.getInstance(bArr);
        } catch (ClassCastException e) {
            throw new TSPException("malformed timestamp response: " + e, e);
        } catch (IllegalArgumentException e2) {
            throw new TSPException("malformed timestamp response: " + e2, e2);
        }
    }

    public byte[] getEncoded(String str) {
        ASN1Object dLSequence = this.f24158resp;
        if (ASN1Encoding.f17903DL.equals(str)) {
            dLSequence = this.timeStampToken == null ? new DLSequence(this.f24158resp.getStatus()) : new DLSequence(this.f24158resp.getStatus(), this.timeStampToken.toCMSSignedData().toASN1Structure());
        }
        return dLSequence.getEncoded(str);
    }

    public TimeStampResponse(TimeStampResp timeStampResp) {
        this.f24158resp = timeStampResp;
        ContentInfo timeStampToken = timeStampResp.getTimeStampToken();
        this.timeStampToken = timeStampToken == null ? null : new TimeStampToken(timeStampToken);
    }

    public TimeStampResponse(byte[] bArr) {
        this(parseTimeStampResp(bArr));
    }
}
