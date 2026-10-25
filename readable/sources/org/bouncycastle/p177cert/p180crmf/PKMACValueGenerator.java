package org.bouncycastle.p177cert.p180crmf;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.p141crmf.PKMACValue;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;

/* loaded from: classes2.dex */
abstract class PKMACValueGenerator {
    private PKMACValueGenerator() {
    }

    public static PKMACValue generate(PKMACBuilder pKMACBuilder, char[] cArr, SubjectPublicKeyInfo subjectPublicKeyInfo) throws CRMFException, IOException {
        MacCalculator macCalculatorM14787build = pKMACBuilder.m14787build(cArr);
        OutputStream outputStream = macCalculatorM14787build.getOutputStream();
        try {
            outputStream.write(subjectPublicKeyInfo.getEncoded(ASN1Encoding.f17902DER));
            outputStream.close();
            return new PKMACValue(macCalculatorM14787build.getAlgorithmIdentifier(), new DERBitString(macCalculatorM14787build.mo14790getMac()));
        } catch (IOException e) {
            throw new CRMFException("exception encoding mac input: " + e.getMessage(), e);
        }
    }
}
