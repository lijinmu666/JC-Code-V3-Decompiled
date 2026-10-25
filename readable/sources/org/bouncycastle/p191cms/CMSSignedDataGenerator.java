package org.bouncycastle.p191cms;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.BEROctetString;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p139cms.SignedData;
import org.bouncycastle.p133asn1.p139cms.SignerInfo;

/* loaded from: classes2.dex */
public class CMSSignedDataGenerator extends CMSSignedGenerator {
    private String encoding;

    public CMSSignedDataGenerator() {
        this.encoding = ASN1Encoding.f17901BER;
    }

    private static AbstractC5093ASN1Set createSetFromList(List list, String str) {
        if (list.size() < 1) {
            return null;
        }
        return ASN1Encoding.f17903DL.equals(str) ? CMSUtils.createDlSetFromList(list) : ASN1Encoding.f17902DER.equals(str) ? CMSUtils.createDerSetFromList(list) : CMSUtils.createBerSetFromList(list);
    }

    private SignerInfo generateSignerInfo(SignerInfoGenerator signerInfoGenerator, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        SignerInfo signerInfoGenerate = signerInfoGenerator.generate(aSN1ObjectIdentifier);
        byte[] calculatedDigest = signerInfoGenerator.getCalculatedDigest();
        if (calculatedDigest != null) {
            this.f19005digests.put(signerInfoGenerate.getDigestAlgorithm().getAlgorithm().m14433getId(), calculatedDigest);
        }
        return signerInfoGenerate;
    }

    private void writeContentViaSignerGens(CMSTypedData cMSTypedData, OutputStream outputStream) throws CMSException, IOException {
        OutputStream safeOutputStream = CMSUtils.getSafeOutputStream(CMSUtils.attachSignersToOutputStream(this.signerGens, outputStream));
        try {
            cMSTypedData.mo14759write(safeOutputStream);
            safeOutputStream.close();
        } catch (IOException e) {
            throw new CMSException("data processing exception: " + e.getMessage(), e);
        }
    }

    public CMSSignedData generate(CMSTypedData cMSTypedData) {
        return generate(cMSTypedData, false);
    }

    public SignerInformationStore generateCounterSigners(SignerInformation signerInformation) throws CMSException, IOException {
        this.f19005digests.clear();
        CMSProcessableByteArray cMSProcessableByteArray = new CMSProcessableByteArray(null, signerInformation.getSignature());
        ArrayList arrayList = new ArrayList();
        Iterator it = this._signers.iterator();
        while (it.hasNext()) {
            arrayList.add(new SignerInformation(((SignerInformation) it.next()).toASN1Structure(), null, cMSProcessableByteArray, null));
        }
        writeContentViaSignerGens(cMSProcessableByteArray, null);
        Iterator it2 = this.signerGens.iterator();
        while (it2.hasNext()) {
            arrayList.add(new SignerInformation(generateSignerInfo((SignerInfoGenerator) it2.next(), null), null, cMSProcessableByteArray, null));
        }
        return new SignerInformationStore(arrayList);
    }

    public void setDefiniteLengthEncoding(boolean z) {
        setEncoding(z ? ASN1Encoding.f17903DL : ASN1Encoding.f17901BER);
    }

    public void setEncoding(String str) {
        if (!ASN1Encoding.f17901BER.equals(str) && !ASN1Encoding.f17903DL.equals(str) && !ASN1Encoding.f17902DER.equals(str)) {
            throw new IllegalArgumentException("encoding must be one of BER, DER, or DL");
        }
        this.encoding = str;
    }

    public CMSSignedDataGenerator(DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        super(digestAlgorithmIdentifierFinder);
        this.encoding = ASN1Encoding.f17901BER;
    }

    public CMSSignedData generate(CMSTypedData cMSTypedData, boolean z) throws CMSException, IOException {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        this.f19005digests.clear();
        linkedHashSet.addAll(this.extraDigestAlgorithms);
        for (SignerInformation signerInformation : this._signers) {
            CMSUtils.addDigestAlgs(linkedHashSet, signerInformation, this.digestAlgIdFinder);
            aSN1EncodableVector.m14420add(signerInformation.toASN1Structure());
        }
        ASN1ObjectIdentifier contentType = cMSTypedData.getContentType();
        ASN1Encodable bEROctetString = null;
        if (cMSTypedData.getContent() != null) {
            if (z) {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                writeContentViaSignerGens(cMSTypedData, byteArrayOutputStream);
                bEROctetString = ASN1Encoding.f17901BER.equals(this.encoding) ? new BEROctetString(byteArrayOutputStream.toByteArray()) : new DEROctetString(byteArrayOutputStream.toByteArray());
            } else {
                writeContentViaSignerGens(cMSTypedData, null);
            }
        }
        Iterator it = this.signerGens.iterator();
        while (it.hasNext()) {
            SignerInfo signerInfoGenerateSignerInfo = generateSignerInfo((SignerInfoGenerator) it.next(), contentType);
            linkedHashSet.add(signerInfoGenerateSignerInfo.getDigestAlgorithm());
            aSN1EncodableVector.m14420add(signerInfoGenerateSignerInfo);
        }
        return new CMSSignedData(cMSTypedData, new ContentInfo(CMSObjectIdentifiers.signedData, new SignedData(CMSUtils.convertToDlSet(linkedHashSet), new ContentInfo(contentType, bEROctetString), createSetFromList(this.f19003certs, this.encoding), createSetFromList(this.f19004crls, this.encoding), new C5104DERSet(aSN1EncodableVector))));
    }
}
