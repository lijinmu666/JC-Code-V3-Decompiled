package org.bouncycastle.p191cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.BEROctetString;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.EncryptedData;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class CMSEncryptedDataGenerator extends CMSEncryptedGenerator {
    private CMSEncryptedData doGenerate(CMSTypedData cMSTypedData, OutputEncryptor outputEncryptor) throws CMSException, IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            OutputStream outputStream = outputEncryptor.getOutputStream(byteArrayOutputStream);
            cMSTypedData.mo14759write(outputStream);
            outputStream.close();
            return new CMSEncryptedData(new ContentInfo(CMSObjectIdentifiers.encryptedData, new EncryptedData(CMSUtils.getEncryptedContentInfo(cMSTypedData, outputEncryptor, new BEROctetString(byteArrayOutputStream.toByteArray())), CMSUtils.getAttrBERSet(this.unprotectedAttributeGenerator))));
        } catch (IOException unused) {
            throw new CMSException(BuildConfig.f24315FLAVOR);
        }
    }

    public CMSEncryptedData generate(CMSTypedData cMSTypedData, OutputEncryptor outputEncryptor) {
        return doGenerate(cMSTypedData, outputEncryptor);
    }
}
