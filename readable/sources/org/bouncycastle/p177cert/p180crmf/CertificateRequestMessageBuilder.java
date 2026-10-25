package org.bouncycastle.p177cert.p180crmf;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p141crmf.AttributeTypeAndValue;
import org.bouncycastle.p133asn1.p141crmf.CertReqMsg;
import org.bouncycastle.p133asn1.p141crmf.CertRequest;
import org.bouncycastle.p133asn1.p141crmf.CertTemplate;
import org.bouncycastle.p133asn1.p141crmf.CertTemplateBuilder;
import org.bouncycastle.p133asn1.p141crmf.OptionalValidity;
import org.bouncycastle.p133asn1.p141crmf.PKMACValue;
import org.bouncycastle.p133asn1.p141crmf.POPOPrivKey;
import org.bouncycastle.p133asn1.p141crmf.ProofOfPossession;
import org.bouncycastle.p133asn1.p141crmf.SubsequentMessage;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.C5194Time;
import org.bouncycastle.p133asn1.p174x509.ExtensionsGenerator;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.CertIOException;

/* loaded from: classes2.dex */
public class CertificateRequestMessageBuilder {
    private PKMACValue agreeMAC;
    private final BigInteger certReqId;
    private char[] password;
    private PKMACBuilder pkmacBuilder;
    private ASN1Null popRaVerified;
    private ContentSigner popSigner;
    private POPOPrivKey popoPrivKey;

    /* renamed from: sender */
    private GeneralName f18825sender;
    private int popoType = 2;
    private ExtensionsGenerator extGenerator = new ExtensionsGenerator();
    private CertTemplateBuilder templateBuilder = new CertTemplateBuilder();
    private List controls = new ArrayList();

    /* renamed from: regInfo */
    private AttributeTypeAndValue[] f18824regInfo = null;

    public CertificateRequestMessageBuilder(BigInteger bigInteger) {
        this.certReqId = bigInteger;
    }

    private C5194Time createTime(Date date) {
        if (date != null) {
            return new C5194Time(date);
        }
        return null;
    }

    public CertificateRequestMessageBuilder addControl(InterfaceC5223Control interfaceC5223Control) {
        this.controls.add(interfaceC5223Control);
        return this;
    }

    public CertificateRequestMessageBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) throws CertIOException {
        CRMFUtil.addExtension(this.extGenerator, aSN1ObjectIdentifier, z, aSN1Encodable);
        return this;
    }

    /* renamed from: build */
    public CertificateRequestMessage m14780build() {
        ProofOfPossession proofOfPossession;
        ProofOfPossessionSigningKeyBuilder proofOfPossessionSigningKeyBuilder;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(new ASN1Integer(this.certReqId));
        if (!this.extGenerator.m14688isEmpty()) {
            this.templateBuilder.setExtensions(this.extGenerator.generate());
        }
        aSN1EncodableVector.m14420add(this.templateBuilder.m14564build());
        if (!this.controls.isEmpty()) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
            for (InterfaceC5223Control interfaceC5223Control : this.controls) {
                aSN1EncodableVector2.m14420add(new AttributeTypeAndValue(interfaceC5223Control.mo14777getType(), interfaceC5223Control.getValue()));
            }
            aSN1EncodableVector.m14420add(new DERSequence(aSN1EncodableVector2));
        }
        CertRequest certRequest = CertRequest.getInstance(new DERSequence(aSN1EncodableVector));
        if (this.popSigner != null) {
            CertTemplate certTemplate = certRequest.getCertTemplate();
            if (certTemplate.getSubject() == null || certTemplate.getPublicKey() == null) {
                ProofOfPossessionSigningKeyBuilder proofOfPossessionSigningKeyBuilder2 = new ProofOfPossessionSigningKeyBuilder(certRequest.getCertTemplate().getPublicKey());
                GeneralName generalName = this.f18825sender;
                if (generalName != null) {
                    proofOfPossessionSigningKeyBuilder2.setSender(generalName);
                } else {
                    proofOfPossessionSigningKeyBuilder2.setPublicKeyMac(this.pkmacBuilder, this.password);
                }
                proofOfPossessionSigningKeyBuilder = proofOfPossessionSigningKeyBuilder2;
            } else {
                proofOfPossessionSigningKeyBuilder = new ProofOfPossessionSigningKeyBuilder(certRequest);
            }
            proofOfPossession = new ProofOfPossession(proofOfPossessionSigningKeyBuilder.m14793build(this.popSigner));
        } else {
            POPOPrivKey pOPOPrivKey = this.popoPrivKey;
            if (pOPOPrivKey != null) {
                proofOfPossession = new ProofOfPossession(this.popoType, pOPOPrivKey);
            } else {
                PKMACValue pKMACValue = this.agreeMAC;
                if (pKMACValue != null) {
                    proofOfPossession = new ProofOfPossession(3, new POPOPrivKey(pKMACValue));
                } else {
                    proofOfPossession = this.popRaVerified != null ? new ProofOfPossession() : new ProofOfPossession();
                }
            }
        }
        return new CertificateRequestMessage(new CertReqMsg(certRequest, proofOfPossession, this.f18824regInfo));
    }

    public CertificateRequestMessageBuilder setAuthInfoPKMAC(PKMACBuilder pKMACBuilder, char[] cArr) {
        this.pkmacBuilder = pKMACBuilder;
        this.password = cArr;
        return this;
    }

    public CertificateRequestMessageBuilder setAuthInfoSender(X500Name x500Name) {
        return setAuthInfoSender(new GeneralName(x500Name));
    }

    public CertificateRequestMessageBuilder setIssuer(X500Name x500Name) {
        if (x500Name != null) {
            this.templateBuilder.setIssuer(x500Name);
        }
        return this;
    }

    public CertificateRequestMessageBuilder setProofOfPossessionAgreeMAC(PKMACValue pKMACValue) {
        if (this.popSigner != null || this.popRaVerified != null || this.popoPrivKey != null) {
            throw new IllegalStateException("only one proof of possession allowed");
        }
        this.agreeMAC = pKMACValue;
        return this;
    }

    public CertificateRequestMessageBuilder setProofOfPossessionRaVerified() {
        if (this.popSigner != null || this.popoPrivKey != null) {
            throw new IllegalStateException("only one proof of possession allowed");
        }
        this.popRaVerified = C5103DERNull.INSTANCE;
        return this;
    }

    public CertificateRequestMessageBuilder setProofOfPossessionSigningKeySigner(ContentSigner contentSigner) {
        if (this.popoPrivKey != null || this.popRaVerified != null || this.agreeMAC != null) {
            throw new IllegalStateException("only one proof of possession allowed");
        }
        this.popSigner = contentSigner;
        return this;
    }

    public CertificateRequestMessageBuilder setProofOfPossessionSubsequentMessage(int i, SubsequentMessage subsequentMessage) {
        if (this.popSigner != null || this.popRaVerified != null || this.agreeMAC != null) {
            throw new IllegalStateException("only one proof of possession allowed");
        }
        if (i != 2 && i != 3) {
            throw new IllegalArgumentException("type must be ProofOfPossession.TYPE_KEY_ENCIPHERMENT or ProofOfPossession.TYPE_KEY_AGREEMENT");
        }
        this.popoType = i;
        this.popoPrivKey = new POPOPrivKey(subsequentMessage);
        return this;
    }

    public CertificateRequestMessageBuilder setPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        if (subjectPublicKeyInfo != null) {
            this.templateBuilder.setPublicKey(subjectPublicKeyInfo);
        }
        return this;
    }

    public CertificateRequestMessageBuilder setRegInfo(AttributeTypeAndValue[] attributeTypeAndValueArr) {
        this.f18824regInfo = attributeTypeAndValueArr;
        return this;
    }

    public CertificateRequestMessageBuilder setSerialNumber(BigInteger bigInteger) {
        if (bigInteger != null) {
            this.templateBuilder.setSerialNumber(new ASN1Integer(bigInteger));
        }
        return this;
    }

    public CertificateRequestMessageBuilder setSubject(X500Name x500Name) {
        if (x500Name != null) {
            this.templateBuilder.setSubject(x500Name);
        }
        return this;
    }

    public CertificateRequestMessageBuilder setValidity(Date date, Date date2) {
        this.templateBuilder.setValidity(new OptionalValidity(createTime(date), createTime(date2)));
        return this;
    }

    public CertificateRequestMessageBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extGenerator.addExtension(aSN1ObjectIdentifier, z, bArr);
        return this;
    }

    public CertificateRequestMessageBuilder setAuthInfoSender(GeneralName generalName) {
        this.f18825sender = generalName;
        return this;
    }

    public CertificateRequestMessageBuilder setProofOfPossessionSubsequentMessage(SubsequentMessage subsequentMessage) {
        if (this.popSigner != null || this.popRaVerified != null || this.agreeMAC != null) {
            throw new IllegalStateException("only one proof of possession allowed");
        }
        this.popoType = 2;
        this.popoPrivKey = new POPOPrivKey(subsequentMessage);
        return this;
    }

    public CertificateRequestMessageBuilder setSerialNumber(ASN1Integer aSN1Integer) {
        if (aSN1Integer != null) {
            this.templateBuilder.setSerialNumber(aSN1Integer);
        }
        return this;
    }
}
