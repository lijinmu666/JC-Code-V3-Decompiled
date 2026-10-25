package org.bouncycastle.p177cert.p180crmf;

import java.io.IOException;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.p141crmf.CertRequest;
import org.bouncycastle.p133asn1.p141crmf.PKMACValue;
import org.bouncycastle.p133asn1.p141crmf.POPOSigningKey;
import org.bouncycastle.p133asn1.p141crmf.POPOSigningKeyInput;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;

/* loaded from: classes2.dex */
public class ProofOfPossessionSigningKeyBuilder {
    private CertRequest certRequest;

    /* renamed from: name */
    private GeneralName f18840name;
    private SubjectPublicKeyInfo pubKeyInfo;
    private PKMACValue publicKeyMAC;

    public ProofOfPossessionSigningKeyBuilder(CertRequest certRequest) {
        this.certRequest = certRequest;
    }

    /* renamed from: build */
    public POPOSigningKey m14793build(ContentSigner contentSigner) throws IOException {
        POPOSigningKeyInput pOPOSigningKeyInput;
        GeneralName generalName = this.f18840name;
        if (generalName != null && this.publicKeyMAC != null) {
            throw new IllegalStateException("name and publicKeyMAC cannot both be set.");
        }
        CertRequest certRequest = this.certRequest;
        if (certRequest != null) {
            CRMFUtil.derEncodeToStream(certRequest, contentSigner.getOutputStream());
            pOPOSigningKeyInput = null;
        } else if (generalName != null) {
            POPOSigningKeyInput pOPOSigningKeyInput2 = new POPOSigningKeyInput(generalName, this.pubKeyInfo);
            CRMFUtil.derEncodeToStream(pOPOSigningKeyInput2, contentSigner.getOutputStream());
            pOPOSigningKeyInput = pOPOSigningKeyInput2;
        } else {
            POPOSigningKeyInput pOPOSigningKeyInput3 = new POPOSigningKeyInput(this.publicKeyMAC, this.pubKeyInfo);
            CRMFUtil.derEncodeToStream(pOPOSigningKeyInput3, contentSigner.getOutputStream());
            pOPOSigningKeyInput = pOPOSigningKeyInput3;
        }
        return new POPOSigningKey(pOPOSigningKeyInput, contentSigner.getAlgorithmIdentifier(), new DERBitString(contentSigner.getSignature()));
    }

    public ProofOfPossessionSigningKeyBuilder setPublicKeyMac(PKMACBuilder pKMACBuilder, char[] cArr) {
        this.publicKeyMAC = PKMACValueGenerator.generate(pKMACBuilder, cArr, this.pubKeyInfo);
        return this;
    }

    public ProofOfPossessionSigningKeyBuilder setSender(GeneralName generalName) {
        this.f18840name = generalName;
        return this;
    }

    public ProofOfPossessionSigningKeyBuilder(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.pubKeyInfo = subjectPublicKeyInfo;
    }
}
