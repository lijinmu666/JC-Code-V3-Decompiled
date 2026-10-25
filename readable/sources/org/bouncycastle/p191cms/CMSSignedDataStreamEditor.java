package org.bouncycastle.p191cms;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1SequenceParser;
import org.bouncycastle.p133asn1.ASN1StreamParser;
import org.bouncycastle.p133asn1.BERSequenceGenerator;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.C5105DLSet;
import org.bouncycastle.p133asn1.p139cms.CMSObjectIdentifiers;
import org.bouncycastle.p133asn1.p139cms.ContentInfoParser;
import org.bouncycastle.p133asn1.p139cms.SignedDataParser;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public class CMSSignedDataStreamEditor {

    /* renamed from: HELPER */
    private static final CMSSignedHelper f18991HELPER = CMSSignedHelper.INSTANCE;
    private static final DefaultDigestAlgorithmIdentifierFinder dgstAlgFinder = new DefaultDigestAlgorithmIdentifierFinder();

    public static OutputStream addDigestAlgorithm(OutputStream outputStream, InputStream inputStream, AlgorithmIdentifier algorithmIdentifier, DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder, DigestCalculatorProvider digestCalculatorProvider) throws CMSException, IOException {
        SignedDataParser signedDataParser = SignedDataParser.getInstance(new ContentInfoParser((ASN1SequenceParser) new ASN1StreamParser(inputStream).readObject()).getContent(16));
        BERSequenceGenerator bERSequenceGenerator = new BERSequenceGenerator(outputStream);
        bERSequenceGenerator.addObject((ASN1Primitive) CMSObjectIdentifiers.signedData);
        BERSequenceGenerator bERSequenceGenerator2 = new BERSequenceGenerator(bERSequenceGenerator.getRawOutputStream(), 0, true);
        bERSequenceGenerator2.addObject((ASN1Primitive) signedDataParser.getVersion());
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        try {
            Iterator<ASN1Encodable> it = ((C5105DLSet) signedDataParser.getDigestAlgorithms().toASN1Primitive()).iterator();
            while (it.hasNext()) {
                AlgorithmIdentifier algorithmIdentifier2 = AlgorithmIdentifier.getInstance(it.next());
                aSN1EncodableVector.m14420add(f18991HELPER.fixDigestAlgID(algorithmIdentifier2, digestAlgorithmIdentifierFinder));
                linkedHashMap.put(algorithmIdentifier2, digestCalculatorProvider.mo14763get(algorithmIdentifier2));
            }
            if (!linkedHashMap.containsKey(algorithmIdentifier)) {
                aSN1EncodableVector.m14420add(f18991HELPER.fixDigestAlgID(algorithmIdentifier, digestAlgorithmIdentifierFinder));
                linkedHashMap.put(algorithmIdentifier, digestCalculatorProvider.mo14763get(algorithmIdentifier));
            }
            bERSequenceGenerator2.addObject((ASN1Primitive) new C5104DERSet(aSN1EncodableVector));
            CMSSignedDataParser.writeEncapContentInfoToGenerator(signedDataParser, bERSequenceGenerator2);
            CMSSignedDataParser.writeSetToGeneratorTagged(bERSequenceGenerator2, signedDataParser.getCertificates(), 0);
            CMSSignedDataParser.writeSetToGeneratorTagged(bERSequenceGenerator2, signedDataParser.m14554getCrls(), 1);
            bERSequenceGenerator2.addObject(signedDataParser.getSignerInfos());
            bERSequenceGenerator2.m14466close();
            bERSequenceGenerator.m14466close();
            return outputStream;
        } catch (OperatorCreationException unused) {
            throw new CMSException("unable to find digest algorithm");
        }
    }

    public static OutputStream addDigestAlgorithm(OutputStream outputStream, InputStream inputStream, AlgorithmIdentifier algorithmIdentifier, DigestCalculatorProvider digestCalculatorProvider) {
        return addDigestAlgorithm(outputStream, inputStream, algorithmIdentifier, dgstAlgFinder, digestCalculatorProvider);
    }
}
