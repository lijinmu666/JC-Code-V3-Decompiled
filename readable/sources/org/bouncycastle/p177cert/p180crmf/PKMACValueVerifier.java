package org.bouncycastle.p177cert.p180crmf;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.p138cmp.PBMParameter;
import org.bouncycastle.p133asn1.p141crmf.PKMACValue;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class PKMACValueVerifier {

    /* renamed from: builder */
    private final PKMACBuilder f18839builder;

    public PKMACValueVerifier(PKMACBuilder pKMACBuilder) {
        this.f18839builder = pKMACBuilder;
    }

    /* renamed from: isValid */
    public boolean m14791isValid(PKMACValue pKMACValue, char[] cArr, SubjectPublicKeyInfo subjectPublicKeyInfo) throws CRMFException, IOException {
        this.f18839builder.setParameters(PBMParameter.getInstance(pKMACValue.getAlgId().getParameters()));
        MacCalculator macCalculatorM14787build = this.f18839builder.m14787build(cArr);
        OutputStream outputStream = macCalculatorM14787build.getOutputStream();
        try {
            outputStream.write(subjectPublicKeyInfo.getEncoded(ASN1Encoding.f17902DER));
            outputStream.close();
            return C6238Arrays.constantTimeAreEqual(macCalculatorM14787build.mo14790getMac(), pKMACValue.getValue().getOctets());
        } catch (IOException e) {
            throw new CRMFException("exception encoding mac input: " + e.getMessage(), e);
        }
    }
}
