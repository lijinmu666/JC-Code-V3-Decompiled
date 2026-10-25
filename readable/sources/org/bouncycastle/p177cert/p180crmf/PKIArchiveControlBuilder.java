package org.bouncycastle.p177cert.p180crmf;

import java.io.IOException;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.p139cms.EnvelopedData;
import org.bouncycastle.p133asn1.p141crmf.CRMFObjectIdentifiers;
import org.bouncycastle.p133asn1.p141crmf.EncKeyWithID;
import org.bouncycastle.p133asn1.p141crmf.EncryptedKey;
import org.bouncycastle.p133asn1.p141crmf.PKIArchiveOptions;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p191cms.CMSEnvelopedDataGenerator;
import org.bouncycastle.p191cms.CMSProcessableByteArray;
import org.bouncycastle.p191cms.RecipientInfoGenerator;

/* loaded from: classes2.dex */
public class PKIArchiveControlBuilder {

    /* renamed from: envGen */
    private CMSEnvelopedDataGenerator f18832envGen;
    private CMSProcessableByteArray keyContent;

    public PKIArchiveControlBuilder(PrivateKeyInfo privateKeyInfo, GeneralName generalName) {
        try {
            this.keyContent = new CMSProcessableByteArray(CRMFObjectIdentifiers.id_ct_encKeyWithID, new EncKeyWithID(privateKeyInfo, generalName).getEncoded());
            this.f18832envGen = new CMSEnvelopedDataGenerator();
        } catch (IOException unused) {
            throw new IllegalStateException("unable to encode key and general name info");
        }
    }

    public PKIArchiveControlBuilder addRecipientGenerator(RecipientInfoGenerator recipientInfoGenerator) {
        this.f18832envGen.addRecipientInfoGenerator(recipientInfoGenerator);
        return this;
    }

    /* renamed from: build */
    public PKIArchiveControl m14786build(OutputEncryptor outputEncryptor) {
        return new PKIArchiveControl(new PKIArchiveOptions(new EncryptedKey(EnvelopedData.getInstance(this.f18832envGen.generate(this.keyContent, outputEncryptor).toASN1Structure().getContent()))));
    }
}
