package org.bouncycastle.p246its;

import org.bouncycastle.p246its.operator.ETSIDataDecryptor;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.AesCcmCiphertext;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.EncryptedData;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.PKRecipientInfo;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.RecipientInfo;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP256CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EciesP256EncryptedKey;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ETSIRecipientInfo {
    private final EncryptedData encryptedData;
    private final RecipientInfo recipientInfo;

    public ETSIRecipientInfo(EncryptedData encryptedData, RecipientInfo recipientInfo) {
        this.recipientInfo = recipientInfo;
        this.encryptedData = encryptedData;
    }

    public byte[] getContent(ETSIDataDecryptor eTSIDataDecryptor) {
        if (this.encryptedData.getCiphertext().getChoice() != 0) {
            throw new IllegalArgumentException("Encrypted data is no AES 128 CCM");
        }
        AesCcmCiphertext aesCcmCiphertext = AesCcmCiphertext.getInstance(this.encryptedData.getCiphertext().getSymmetricCiphertext());
        EciesP256EncryptedKey eciesP256EncryptedKey = EciesP256EncryptedKey.getInstance(PKRecipientInfo.getInstance(this.recipientInfo.getRecipientInfo()).getEncKey().getEncryptedDataEncryptionKey());
        return eTSIDataDecryptor.mo16021decrypt(C6238Arrays.concatenate(EccP256CurvePoint.getInstance(eciesP256EncryptedKey.m17283getV()).getEncodedPoint(), eciesP256EncryptedKey.m17281getC().getOctets(), eciesP256EncryptedKey.m17282getT().getOctets()), aesCcmCiphertext.getCcmCiphertext().getContent(), aesCcmCiphertext.getNonce().getOctets());
    }

    public EncryptedData getEncryptedData() {
        return this.encryptedData;
    }

    public RecipientInfo getRecipientInfo() {
        return this.recipientInfo;
    }

    public ETSIRecipientInfo(RecipientInfo recipientInfo) {
        this.recipientInfo = recipientInfo;
        this.encryptedData = null;
    }
}
