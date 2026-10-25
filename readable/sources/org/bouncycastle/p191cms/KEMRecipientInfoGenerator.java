package org.bouncycastle.p191cms;

import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OperatorException;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.IssuerAndSerialNumber;
import org.bouncycastle.p133asn1.p139cms.KEMRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.OtherRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.RecipientIdentifier;
import org.bouncycastle.p133asn1.p139cms.RecipientInfo;

/* loaded from: classes2.dex */
public abstract class KEMRecipientInfoGenerator implements RecipientInfoGenerator {
    private IssuerAndSerialNumber issuerAndSerial;
    private byte[] subjectKeyIdentifier;

    /* renamed from: wrapper */
    protected final KEMKeyWrapper f19019wrapper;

    public KEMRecipientInfoGenerator(IssuerAndSerialNumber issuerAndSerialNumber, KEMKeyWrapper kEMKeyWrapper) {
        this.issuerAndSerial = issuerAndSerialNumber;
        this.f19019wrapper = kEMKeyWrapper;
    }

    @Override // org.bouncycastle.p191cms.RecipientInfoGenerator
    public final RecipientInfo generate(GenericKey genericKey) throws CMSException {
        try {
            byte[] bArrGenerateWrappedKey = this.f19019wrapper.generateWrappedKey(genericKey);
            IssuerAndSerialNumber issuerAndSerialNumber = this.issuerAndSerial;
            return new RecipientInfo(new OtherRecipientInfo(CMSObjectIdentifiers.id_ori_kem, new KEMRecipientInfo(issuerAndSerialNumber != null ? new RecipientIdentifier(issuerAndSerialNumber) : new RecipientIdentifier((ASN1OctetString) new DEROctetString(this.subjectKeyIdentifier)), this.f19019wrapper.getAlgorithmIdentifier(), new DEROctetString(this.f19019wrapper.getEncapsulation()), this.f19019wrapper.getKdfAlgorithmIdentifier(), ASN1Integer.m14429valueOf(this.f19019wrapper.getKekLength()), null, this.f19019wrapper.getWrapAlgorithmIdentifier(), new DEROctetString(bArrGenerateWrappedKey))));
        } catch (OperatorException e) {
            throw new CMSException("exception wrapping content key: " + e.getMessage(), e);
        }
    }

    public KEMRecipientInfoGenerator(byte[] bArr, KEMKeyWrapper kEMKeyWrapper) {
        this.subjectKeyIdentifier = bArr;
        this.f19019wrapper = kEMKeyWrapper;
    }
}
