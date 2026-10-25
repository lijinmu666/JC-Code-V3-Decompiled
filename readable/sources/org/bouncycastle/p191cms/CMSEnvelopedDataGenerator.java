package org.bouncycastle.p191cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.OutputAEADEncryptor;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.BEROctetString;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.EnvelopedData;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class CMSEnvelopedDataGenerator extends CMSEnvelopedGenerator {
    private CMSEnvelopedData doGenerate(CMSTypedData cMSTypedData, OutputEncryptor outputEncryptor) throws CMSException, IOException {
        ASN1EncodableVector recipentInfos = CMSUtils.getRecipentInfos(outputEncryptor.mo14795getKey(), this.recipientInfoGenerators);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            OutputStream outputStream = outputEncryptor.getOutputStream(byteArrayOutputStream);
            cMSTypedData.mo14759write(outputStream);
            outputStream.close();
            if (outputEncryptor instanceof OutputAEADEncryptor) {
                byte[] bArrMo14908getMAC = ((OutputAEADEncryptor) outputEncryptor).mo14908getMAC();
                byteArrayOutputStream.write(bArrMo14908getMAC, 0, bArrMo14908getMAC.length);
            }
            return new CMSEnvelopedData(new ContentInfo(CMSObjectIdentifiers.envelopedData, new EnvelopedData(this.originatorInfo, new C5104DERSet(recipentInfos), CMSUtils.getEncryptedContentInfo(cMSTypedData, outputEncryptor, new BEROctetString(byteArrayOutputStream.toByteArray())), CMSUtils.getAttrBERSet(this.unprotectedAttributeGenerator))));
        } catch (IOException unused) {
            throw new CMSException(BuildConfig.f24315FLAVOR);
        }
    }

    public CMSEnvelopedData generate(CMSTypedData cMSTypedData, OutputEncryptor outputEncryptor) {
        return doGenerate(cMSTypedData, outputEncryptor);
    }
}
