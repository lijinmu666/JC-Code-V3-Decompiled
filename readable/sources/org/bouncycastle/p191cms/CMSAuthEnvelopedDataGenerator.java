package org.bouncycastle.p191cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.OutputAEADEncryptor;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BEROctetString;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p139cms.AuthEnvelopedData;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;

/* loaded from: classes2.dex */
public class CMSAuthEnvelopedDataGenerator extends CMSAuthEnvelopedGenerator {
    private CMSAuthEnvelopedData doGenerate(CMSTypedData cMSTypedData, OutputAEADEncryptor outputAEADEncryptor) throws CMSException, IOException {
        AbstractC5093ASN1Set abstractC5093ASN1SetProcessAuthAttrSet;
        ASN1EncodableVector recipentInfos = CMSUtils.getRecipentInfos(outputAEADEncryptor.mo14795getKey(), this.recipientInfoGenerators);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            OutputStream outputStream = outputAEADEncryptor.getOutputStream(byteArrayOutputStream);
            if (CMSAlgorithm.ChaCha20Poly1305.m14446equals((ASN1Primitive) outputAEADEncryptor.getAlgorithmIdentifier().getAlgorithm())) {
                abstractC5093ASN1SetProcessAuthAttrSet = CMSUtils.processAuthAttrSet(this.authAttrsGenerator, outputAEADEncryptor);
                cMSTypedData.mo14759write(outputStream);
            } else {
                cMSTypedData.mo14759write(outputStream);
                abstractC5093ASN1SetProcessAuthAttrSet = CMSUtils.processAuthAttrSet(this.authAttrsGenerator, outputAEADEncryptor);
            }
            AbstractC5093ASN1Set abstractC5093ASN1Set = abstractC5093ASN1SetProcessAuthAttrSet;
            outputStream.close();
            BEROctetString bEROctetString = new BEROctetString(byteArrayOutputStream.toByteArray());
            return new CMSAuthEnvelopedData(new ContentInfo(CMSObjectIdentifiers.authEnvelopedData, new AuthEnvelopedData(((CMSAuthEnvelopedGenerator) this).originatorInfo, new C5104DERSet(recipentInfos), CMSUtils.getEncryptedContentInfo(cMSTypedData, outputAEADEncryptor, bEROctetString), abstractC5093ASN1Set, new DEROctetString(outputAEADEncryptor.mo14908getMAC()), CMSUtils.getAttrDLSet(this.unauthAttrsGenerator))));
        } catch (IOException e) {
            throw new CMSException("unable to process authenticated content: " + e.getMessage(), e);
        }
    }

    public CMSAuthEnvelopedData generate(CMSTypedData cMSTypedData, OutputAEADEncryptor outputAEADEncryptor) {
        return doGenerate(cMSTypedData, outputAEADEncryptor);
    }
}
