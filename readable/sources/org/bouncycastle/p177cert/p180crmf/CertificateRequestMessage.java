package org.bouncycastle.p177cert.p180crmf;

import java.io.IOException;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1UTF8String;
import org.bouncycastle.p133asn1.p141crmf.AttributeTypeAndValue;
import org.bouncycastle.p133asn1.p141crmf.CRMFObjectIdentifiers;
import org.bouncycastle.p133asn1.p141crmf.CertReqMsg;
import org.bouncycastle.p133asn1.p141crmf.CertTemplate;
import org.bouncycastle.p133asn1.p141crmf.Controls;
import org.bouncycastle.p133asn1.p141crmf.PKIArchiveOptions;
import org.bouncycastle.p133asn1.p141crmf.POPOSigningKey;
import org.bouncycastle.p133asn1.p141crmf.ProofOfPossession;
import org.bouncycastle.p177cert.CertIOException;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class CertificateRequestMessage implements Encodable {
    public static final int popKeyAgreement = 3;
    public static final int popKeyEncipherment = 2;
    public static final int popRaVerified = 0;
    public static final int popSigningKey = 1;
    private final CertReqMsg certReqMsg;
    private final Controls controls;

    public CertificateRequestMessage(CertReqMsg certReqMsg) {
        this.certReqMsg = certReqMsg;
        this.controls = certReqMsg.getCertReq().getControls();
    }

    private AttributeTypeAndValue findControl(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Controls controls = this.controls;
        if (controls == null) {
            return null;
        }
        AttributeTypeAndValue[] attributeTypeAndValueArray = controls.toAttributeTypeAndValueArray();
        for (int i = 0; i != attributeTypeAndValueArray.length; i++) {
            if (attributeTypeAndValueArray[i].m14561getType().m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                return attributeTypeAndValueArray[i];
            }
        }
        return null;
    }

    private static CertReqMsg parseBytes(byte[] bArr) throws CertIOException {
        try {
            return CertReqMsg.getInstance(bArr);
        } catch (ClassCastException e) {
            throw new CertIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    private boolean verifySignature(ContentVerifierProvider contentVerifierProvider, POPOSigningKey pOPOSigningKey) throws CRMFException, IOException {
        try {
            ContentVerifier contentVerifierMo17379get = contentVerifierProvider.mo17379get(pOPOSigningKey.getAlgorithmIdentifier());
            ASN1Object poposkInput = pOPOSigningKey.getPoposkInput();
            if (poposkInput == null) {
                poposkInput = this.certReqMsg.getCertReq();
            }
            CRMFUtil.derEncodeToStream(poposkInput, contentVerifierMo17379get.getOutputStream());
            return contentVerifierMo17379get.mo16015verify(pOPOSigningKey.getSignature().getOctets());
        } catch (OperatorCreationException e) {
            throw new CRMFException("unable to create verifier: " + e.getMessage(), e);
        }
    }

    public ASN1Integer getCertReqId() {
        return this.certReqMsg.getCertReq().getCertReqId();
    }

    public CertTemplate getCertTemplate() {
        return this.certReqMsg.getCertReq().getCertTemplate();
    }

    public InterfaceC5223Control getControl(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        AttributeTypeAndValue attributeTypeAndValueFindControl = findControl(aSN1ObjectIdentifier);
        if (attributeTypeAndValueFindControl == null) {
            return null;
        }
        if (attributeTypeAndValueFindControl.m14561getType().m14446equals((ASN1Primitive) CRMFObjectIdentifiers.id_regCtrl_pkiArchiveOptions)) {
            return new PKIArchiveControl(PKIArchiveOptions.getInstance(attributeTypeAndValueFindControl.getValue()));
        }
        if (attributeTypeAndValueFindControl.m14561getType().m14446equals((ASN1Primitive) CRMFObjectIdentifiers.id_regCtrl_regToken)) {
            return new RegTokenControl(ASN1UTF8String.getInstance(attributeTypeAndValueFindControl.getValue()));
        }
        if (attributeTypeAndValueFindControl.m14561getType().m14446equals((ASN1Primitive) CRMFObjectIdentifiers.id_regCtrl_authenticator)) {
            return new AuthenticatorControl(ASN1UTF8String.getInstance(attributeTypeAndValueFindControl.getValue()));
        }
        return null;
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return this.certReqMsg.getEncoded();
    }

    public int getProofOfPossessionType() {
        return this.certReqMsg.m14562getPop().m14567getType();
    }

    public boolean hasControl(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return findControl(aSN1ObjectIdentifier) != null;
    }

    public boolean hasControls() {
        return this.controls != null;
    }

    public boolean hasProofOfPossession() {
        return this.certReqMsg.m14562getPop() != null;
    }

    public boolean hasSigningKeyProofOfPossessionWithPKMAC() {
        ProofOfPossession proofOfPossessionM14562getPop = this.certReqMsg.m14562getPop();
        return proofOfPossessionM14562getPop.m14567getType() == 1 && POPOSigningKey.getInstance(proofOfPossessionM14562getPop.getObject()).getPoposkInput().getPublicKeyMAC() != null;
    }

    public boolean isValidSigningKeyPOP(ContentVerifierProvider contentVerifierProvider) {
        ProofOfPossession proofOfPossessionM14562getPop = this.certReqMsg.m14562getPop();
        if (proofOfPossessionM14562getPop.m14567getType() != 1) {
            throw new IllegalStateException("not Signing Key type of proof of possession");
        }
        POPOSigningKey pOPOSigningKey = POPOSigningKey.getInstance(proofOfPossessionM14562getPop.getObject());
        if (pOPOSigningKey.getPoposkInput() == null || pOPOSigningKey.getPoposkInput().getPublicKeyMAC() == null) {
            return verifySignature(contentVerifierProvider, pOPOSigningKey);
        }
        throw new IllegalStateException("verification requires password check");
    }

    public CertReqMsg toASN1Structure() {
        return this.certReqMsg;
    }

    public CertificateRequestMessage(byte[] bArr) {
        this(parseBytes(bArr));
    }

    public boolean isValidSigningKeyPOP(ContentVerifierProvider contentVerifierProvider, PKMACBuilder pKMACBuilder, char[] cArr) {
        ProofOfPossession proofOfPossessionM14562getPop = this.certReqMsg.m14562getPop();
        if (proofOfPossessionM14562getPop.m14567getType() != 1) {
            throw new IllegalStateException("not Signing Key type of proof of possession");
        }
        POPOSigningKey pOPOSigningKey = POPOSigningKey.getInstance(proofOfPossessionM14562getPop.getObject());
        if (pOPOSigningKey.getPoposkInput() == null || pOPOSigningKey.getPoposkInput().getSender() != null) {
            throw new IllegalStateException("no PKMAC present in proof of possession");
        }
        return new PKMACValueVerifier(pKMACBuilder).m14791isValid(pOPOSigningKey.getPoposkInput().getPublicKeyMAC(), cArr, getCertTemplate().getPublicKey()) && verifySignature(contentVerifierProvider, pOPOSigningKey);
    }
}
