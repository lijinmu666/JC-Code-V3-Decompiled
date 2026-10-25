package org.bouncycastle.p177cert.p179cmp;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* renamed from: org.bouncycastle.cert.cmp.CMPUtil */
/* loaded from: classes2.dex */
class C5221CMPUtil {
    public static byte[] calculateCertHash(ASN1Object aSN1Object, AlgorithmIdentifier algorithmIdentifier, DigestCalculatorProvider digestCalculatorProvider, DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) throws CMPException {
        AlgorithmIdentifier algorithmIdentifierMo17382find = digestAlgorithmIdentifierFinder.mo17382find(algorithmIdentifier);
        if (algorithmIdentifierMo17382find != null) {
            return calculateDigest(aSN1Object, algorithmIdentifierMo17382find, digestCalculatorProvider);
        }
        throw new CMPException("cannot find digest algorithm from signature algorithm");
    }

    public static byte[] calculateDigest(ASN1Object aSN1Object, AlgorithmIdentifier algorithmIdentifier, DigestCalculatorProvider digestCalculatorProvider) throws CMPException, IOException {
        DigestCalculator digestCalculator = getDigestCalculator(algorithmIdentifier, digestCalculatorProvider);
        derEncodeToStream(aSN1Object, digestCalculator.getOutputStream());
        return digestCalculator.getDigest();
    }

    public static void derEncodeToStream(ASN1Object aSN1Object, OutputStream outputStream) throws IOException {
        try {
            aSN1Object.encodeTo(outputStream, ASN1Encoding.f17902DER);
            outputStream.close();
        } catch (IOException e) {
            throw new CMPRuntimeException("unable to DER encode object: " + e.getMessage(), e);
        }
    }

    public static DigestCalculator getDigestCalculator(AlgorithmIdentifier algorithmIdentifier, DigestCalculatorProvider digestCalculatorProvider) throws CMPException {
        try {
            return digestCalculatorProvider.mo14763get(algorithmIdentifier);
        } catch (OperatorCreationException e) {
            throw new CMPException("unable to create digester: " + e.getMessage(), e);
        }
    }
}
