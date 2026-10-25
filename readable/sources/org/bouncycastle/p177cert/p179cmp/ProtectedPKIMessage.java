package org.bouncycastle.p177cert.p179cmp;

import java.io.IOException;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.operator.PBEMacCalculatorProvider;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p138cmp.C5114PKIBody;
import org.bouncycastle.p133asn1.p138cmp.CMPCertificate;
import org.bouncycastle.p133asn1.p138cmp.CMPObjectIdentifiers;
import org.bouncycastle.p133asn1.p138cmp.PKIHeader;
import org.bouncycastle.p133asn1.p138cmp.PKIMessage;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ProtectedPKIMessage {
    private PKIMessage pkiMessage;

    public ProtectedPKIMessage(PKIMessage pKIMessage) {
        if (pKIMessage.getHeader().getProtectionAlg() == null) {
            throw new IllegalArgumentException("PKIMessage not protected");
        }
        this.pkiMessage = pKIMessage;
    }

    private DERSequence createProtected() {
        return new DERSequence(this.pkiMessage.getHeader(), this.pkiMessage.m14521getBody());
    }

    private boolean verifySignature(byte[] bArr, ContentVerifier contentVerifier) throws IOException {
        C5221CMPUtil.derEncodeToStream(createProtected(), contentVerifier.getOutputStream());
        return contentVerifier.mo16015verify(bArr);
    }

    /* renamed from: getBody */
    public C5114PKIBody m14765getBody() {
        return this.pkiMessage.m14521getBody();
    }

    public X509CertificateHolder[] getCertificates() {
        CMPCertificate[] extraCerts = this.pkiMessage.getExtraCerts();
        if (extraCerts == null) {
            return new X509CertificateHolder[0];
        }
        X509CertificateHolder[] x509CertificateHolderArr = new X509CertificateHolder[extraCerts.length];
        for (int i = 0; i != extraCerts.length; i++) {
            x509CertificateHolderArr[i] = new X509CertificateHolder(extraCerts[i].getX509v3PKCert());
        }
        return x509CertificateHolderArr;
    }

    public PKIHeader getHeader() {
        return this.pkiMessage.getHeader();
    }

    public AlgorithmIdentifier getProtectionAlgorithm() {
        return this.pkiMessage.getHeader().getProtectionAlg();
    }

    public boolean hasPasswordBasedMacProtection() {
        return CMPObjectIdentifiers.passwordBasedMac.m14446equals((ASN1Primitive) getProtectionAlgorithm().getAlgorithm());
    }

    public PKIMessage toASN1Structure() {
        return this.pkiMessage;
    }

    /* renamed from: verify */
    public boolean m14766verify(ContentVerifierProvider contentVerifierProvider) throws CMPException {
        try {
            return verifySignature(this.pkiMessage.getProtection().getOctets(), contentVerifierProvider.mo17379get(getProtectionAlgorithm()));
        } catch (Exception e) {
            throw new CMPException("unable to verify signature: " + e.getMessage(), e);
        }
    }

    public ProtectedPKIMessage(GeneralPKIMessage generalPKIMessage) {
        if (!generalPKIMessage.hasProtection()) {
            throw new IllegalArgumentException("PKIMessage not protected");
        }
        this.pkiMessage = generalPKIMessage.toASN1Structure();
    }

    /* renamed from: verify */
    public boolean m14767verify(PBEMacCalculatorProvider pBEMacCalculatorProvider, char[] cArr) throws CMPException {
        try {
            MacCalculator macCalculatorMo14788get = pBEMacCalculatorProvider.mo14788get(getProtectionAlgorithm(), cArr);
            C5221CMPUtil.derEncodeToStream(createProtected(), macCalculatorMo14788get.getOutputStream());
            return C6238Arrays.constantTimeAreEqual(macCalculatorMo14788get.mo14790getMac(), this.pkiMessage.getProtection().getOctets());
        } catch (Exception e) {
            throw new CMPException("unable to verify MAC: " + e.getMessage(), e);
        }
    }
}
