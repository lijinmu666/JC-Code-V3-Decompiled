package org.bouncycastle.p191cms;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p139cms.PasswordRecipientInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class PasswordRecipientInformation extends RecipientInformation {
    static Map BLOCKSIZES;
    static Map KEYSIZES = new HashMap();

    /* renamed from: info */
    private PasswordRecipientInfo f19032info;

    static {
        HashMap map = new HashMap();
        BLOCKSIZES = map;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = CMSAlgorithm.DES_EDE3_CBC;
        map.put(aSN1ObjectIdentifier, Integers.m18296valueOf(8));
        Map map2 = BLOCKSIZES;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = CMSAlgorithm.AES128_CBC;
        map2.put(aSN1ObjectIdentifier2, Integers.m18296valueOf(16));
        Map map3 = BLOCKSIZES;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = CMSAlgorithm.AES192_CBC;
        map3.put(aSN1ObjectIdentifier3, Integers.m18296valueOf(16));
        Map map4 = BLOCKSIZES;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = CMSAlgorithm.AES256_CBC;
        map4.put(aSN1ObjectIdentifier4, Integers.m18296valueOf(16));
        KEYSIZES.put(aSN1ObjectIdentifier, Integers.m18296valueOf(192));
        KEYSIZES.put(aSN1ObjectIdentifier2, Integers.m18296valueOf(128));
        KEYSIZES.put(aSN1ObjectIdentifier3, Integers.m18296valueOf(192));
        KEYSIZES.put(aSN1ObjectIdentifier4, Integers.m18296valueOf(256));
    }

    public PasswordRecipientInformation(PasswordRecipientInfo passwordRecipientInfo, AlgorithmIdentifier algorithmIdentifier, CMSSecureReadable cMSSecureReadable) {
        super(passwordRecipientInfo.getKeyEncryptionAlgorithm(), algorithmIdentifier, cMSSecureReadable);
        this.f19032info = passwordRecipientInfo;
        this.f19036rid = new PasswordRecipientId();
    }

    public String getKeyDerivationAlgOID() {
        if (this.f19032info.getKeyDerivationAlgorithm() != null) {
            return this.f19032info.getKeyDerivationAlgorithm().getAlgorithm().m14433getId();
        }
        return null;
    }

    public byte[] getKeyDerivationAlgParams() {
        ASN1Encodable parameters;
        try {
            if (this.f19032info.getKeyDerivationAlgorithm() == null || (parameters = this.f19032info.getKeyDerivationAlgorithm().getParameters()) == null) {
                return null;
            }
            return parameters.toASN1Primitive().getEncoded();
        } catch (Exception e) {
            throw new RuntimeException("exception getting encryption parameters " + e);
        }
    }

    public AlgorithmIdentifier getKeyDerivationAlgorithm() {
        return this.f19032info.getKeyDerivationAlgorithm();
    }

    @Override // org.bouncycastle.p191cms.RecipientInformation
    public RecipientOperator getRecipientOperator(Recipient recipient) {
        PasswordRecipient passwordRecipient = (PasswordRecipient) recipient;
        AlgorithmIdentifier algorithmIdentifier = AlgorithmIdentifier.getInstance(AlgorithmIdentifier.getInstance(this.f19032info.getKeyEncryptionAlgorithm()).getParameters());
        return passwordRecipient.getRecipientOperator(algorithmIdentifier, this.messageAlgorithm, passwordRecipient.calculateDerivedKey(passwordRecipient.getPasswordConversionScheme(), getKeyDerivationAlgorithm(), ((Integer) KEYSIZES.get(algorithmIdentifier.getAlgorithm())).intValue()), this.f19032info.getEncryptedKey().getOctets());
    }
}
