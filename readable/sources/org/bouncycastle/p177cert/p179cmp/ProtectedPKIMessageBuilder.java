package org.bouncycastle.p177cert.p179cmp;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p138cmp.C5114PKIBody;
import org.bouncycastle.p133asn1.p138cmp.CMPCertificate;
import org.bouncycastle.p133asn1.p138cmp.InfoTypeAndValue;
import org.bouncycastle.p133asn1.p138cmp.PKIFreeText;
import org.bouncycastle.p133asn1.p138cmp.PKIHeader;
import org.bouncycastle.p133asn1.p138cmp.PKIHeaderBuilder;
import org.bouncycastle.p133asn1.p138cmp.PKIMessage;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p180crmf.CertificateRepMessage;
import org.bouncycastle.p177cert.p180crmf.CertificateReqMessages;

/* loaded from: classes2.dex */
public class ProtectedPKIMessageBuilder {

    /* renamed from: body */
    private C5114PKIBody f18815body;
    private List extraCerts;
    private List generalInfos;
    private PKIHeaderBuilder hdrBuilder;

    public ProtectedPKIMessageBuilder(int i, GeneralName generalName, GeneralName generalName2) {
        this.generalInfos = new ArrayList();
        this.extraCerts = new ArrayList();
        this.hdrBuilder = new PKIHeaderBuilder(i, generalName, generalName2);
    }

    private byte[] calculateMac(MacCalculator macCalculator, PKIHeader pKIHeader, C5114PKIBody c5114PKIBody) throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(pKIHeader);
        aSN1EncodableVector.m14420add(c5114PKIBody);
        OutputStream outputStream = macCalculator.getOutputStream();
        outputStream.write(new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.f17902DER));
        outputStream.close();
        return macCalculator.mo14790getMac();
    }

    private byte[] calculateSignature(ContentSigner contentSigner, PKIHeader pKIHeader, C5114PKIBody c5114PKIBody) throws IOException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(pKIHeader);
        aSN1EncodableVector.m14420add(c5114PKIBody);
        OutputStream outputStream = contentSigner.getOutputStream();
        outputStream.write(new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.f17902DER));
        outputStream.close();
        return contentSigner.getSignature();
    }

    private void finaliseHeader(AlgorithmIdentifier algorithmIdentifier) {
        this.hdrBuilder.setProtectionAlg(algorithmIdentifier);
        if (this.generalInfos.isEmpty()) {
            return;
        }
        this.hdrBuilder.setGeneralInfo((InfoTypeAndValue[]) this.generalInfos.toArray(new InfoTypeAndValue[this.generalInfos.size()]));
    }

    private ProtectedPKIMessage finaliseMessage(PKIHeader pKIHeader, DERBitString dERBitString) {
        if (this.extraCerts.isEmpty()) {
            return new ProtectedPKIMessage(new PKIMessage(pKIHeader, this.f18815body, dERBitString));
        }
        int size = this.extraCerts.size();
        CMPCertificate[] cMPCertificateArr = new CMPCertificate[size];
        for (int i = 0; i != size; i++) {
            cMPCertificateArr[i] = new CMPCertificate(((X509CertificateHolder) this.extraCerts.get(i)).toASN1Structure());
        }
        return new ProtectedPKIMessage(new PKIMessage(pKIHeader, this.f18815body, dERBitString, cMPCertificateArr));
    }

    public ProtectedPKIMessageBuilder addCMPCertificate(X509CertificateHolder x509CertificateHolder) {
        this.extraCerts.add(x509CertificateHolder);
        return this;
    }

    public ProtectedPKIMessageBuilder addGeneralInfo(InfoTypeAndValue infoTypeAndValue) {
        this.generalInfos.add(infoTypeAndValue);
        return this;
    }

    /* renamed from: build */
    public ProtectedPKIMessage m14768build(ContentSigner contentSigner) throws CMPException {
        if (this.f18815body == null) {
            throw new IllegalStateException("body must be set before building");
        }
        finaliseHeader(contentSigner.getAlgorithmIdentifier());
        PKIHeader pKIHeaderM14520build = this.hdrBuilder.m14520build();
        try {
            return finaliseMessage(pKIHeaderM14520build, new DERBitString(calculateSignature(contentSigner, pKIHeaderM14520build, this.f18815body)));
        } catch (IOException e) {
            throw new CMPException("unable to encode signature input: " + e.getMessage(), e);
        }
    }

    /* renamed from: setBody */
    public ProtectedPKIMessageBuilder m14770setBody(int i, CertificateConfirmationContent certificateConfirmationContent) {
        if (CertificateConfirmationContent.isCertificateConfirmationContent(i)) {
            this.f18815body = new C5114PKIBody(i, certificateConfirmationContent.toASN1Structure());
            return this;
        }
        throw new IllegalArgumentException("body type " + i + " does not match CMP type CertConfirmContent");
    }

    public ProtectedPKIMessageBuilder setFreeText(PKIFreeText pKIFreeText) {
        this.hdrBuilder.setFreeText(pKIFreeText);
        return this;
    }

    public ProtectedPKIMessageBuilder setMessageTime(Date date) {
        this.hdrBuilder.setMessageTime(new ASN1GeneralizedTime(date));
        return this;
    }

    public ProtectedPKIMessageBuilder setRecipKID(byte[] bArr) {
        this.hdrBuilder.setRecipKID(bArr);
        return this;
    }

    public ProtectedPKIMessageBuilder setRecipNonce(byte[] bArr) {
        this.hdrBuilder.setRecipNonce(bArr);
        return this;
    }

    public ProtectedPKIMessageBuilder setSenderKID(byte[] bArr) {
        this.hdrBuilder.setSenderKID(bArr);
        return this;
    }

    public ProtectedPKIMessageBuilder setSenderNonce(byte[] bArr) {
        this.hdrBuilder.setSenderNonce(bArr);
        return this;
    }

    public ProtectedPKIMessageBuilder setTransactionID(byte[] bArr) {
        this.hdrBuilder.setTransactionID(bArr);
        return this;
    }

    public ProtectedPKIMessageBuilder(GeneralName generalName, GeneralName generalName2) {
        this(2, generalName, generalName2);
    }

    /* renamed from: build */
    public ProtectedPKIMessage m14769build(MacCalculator macCalculator) throws CMPException {
        if (this.f18815body == null) {
            throw new IllegalStateException("body must be set before building");
        }
        finaliseHeader(macCalculator.getAlgorithmIdentifier());
        PKIHeader pKIHeaderM14520build = this.hdrBuilder.m14520build();
        try {
            return finaliseMessage(pKIHeaderM14520build, new DERBitString(calculateMac(macCalculator, pKIHeaderM14520build, this.f18815body)));
        } catch (IOException e) {
            throw new CMPException("unable to encode MAC input: " + e.getMessage(), e);
        }
    }

    /* renamed from: setBody */
    public ProtectedPKIMessageBuilder m14771setBody(int i, CertificateRepMessage certificateRepMessage) {
        if (CertificateRepMessage.isCertificateRepMessage(i)) {
            this.f18815body = new C5114PKIBody(i, certificateRepMessage.toASN1Structure());
            return this;
        }
        throw new IllegalArgumentException("body type " + i + " does not match CMP type CertRepMessage");
    }

    /* renamed from: setBody */
    public ProtectedPKIMessageBuilder m14772setBody(int i, CertificateReqMessages certificateReqMessages) {
        if (CertificateReqMessages.isCertificateRequestMessages(i)) {
            this.f18815body = new C5114PKIBody(i, certificateReqMessages.toASN1Structure());
            return this;
        }
        throw new IllegalArgumentException("body type " + i + " does not match CMP type CertReqMessages");
    }

    /* renamed from: setBody */
    public ProtectedPKIMessageBuilder m14773setBody(C5114PKIBody c5114PKIBody) {
        this.f18815body = c5114PKIBody;
        return this;
    }

    /* renamed from: setBody */
    public ProtectedPKIMessageBuilder m14774setBody(POPODecryptionKeyChallengeContent pOPODecryptionKeyChallengeContent) {
        this.f18815body = new C5114PKIBody(5, pOPODecryptionKeyChallengeContent.toASN1Structure());
        return this;
    }

    /* renamed from: setBody */
    public ProtectedPKIMessageBuilder m14775setBody(POPODecryptionKeyResponseContent pOPODecryptionKeyResponseContent) {
        this.f18815body = new C5114PKIBody(6, pOPODecryptionKeyResponseContent.toASN1Structure());
        return this;
    }
}
