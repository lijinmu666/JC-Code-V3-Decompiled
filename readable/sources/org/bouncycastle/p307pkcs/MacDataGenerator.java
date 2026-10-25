package org.bouncycastle.p307pkcs;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p166pkcs.C5136MacData;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.DigestInfo;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
class MacDataGenerator {

    /* renamed from: builder */
    private PKCS12MacCalculatorBuilder f22927builder;

    public MacDataGenerator(PKCS12MacCalculatorBuilder pKCS12MacCalculatorBuilder) {
        this.f22927builder = pKCS12MacCalculatorBuilder;
    }

    /* renamed from: build */
    public C5136MacData m17403build(char[] cArr, byte[] bArr) throws IOException, PKCSException {
        int iIntValueExact;
        byte[] uTF8ByteArray;
        try {
            MacCalculator macCalculatorMo17407build = this.f22927builder.mo17407build(cArr);
            OutputStream outputStream = macCalculatorMo17407build.getOutputStream();
            outputStream.write(bArr);
            outputStream.close();
            AlgorithmIdentifier algorithmIdentifier = macCalculatorMo17407build.getAlgorithmIdentifier();
            DigestInfo digestInfo = new DigestInfo(this.f22927builder.getDigestAlgorithmIdentifier(), macCalculatorMo17407build.mo14790getMac());
            if (PKCSObjectIdentifiers.id_PBMAC1.m14446equals((ASN1Primitive) digestInfo.getAlgorithmId().getAlgorithm())) {
                uTF8ByteArray = C6250Strings.toUTF8ByteArray("NOT USED".toCharArray());
                iIntValueExact = 1;
            } else {
                PKCS12PBEParams pKCS12PBEParams = PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters());
                byte[] bArrM14636getIV = pKCS12PBEParams.m14636getIV();
                iIntValueExact = BigIntegers.intValueExact(pKCS12PBEParams.getIterations());
                uTF8ByteArray = bArrM14636getIV;
            }
            return new C5136MacData(digestInfo, uTF8ByteArray, iIntValueExact);
        } catch (Exception e) {
            throw new PKCSException("unable to process data: " + e.getMessage(), e);
        }
    }
}
