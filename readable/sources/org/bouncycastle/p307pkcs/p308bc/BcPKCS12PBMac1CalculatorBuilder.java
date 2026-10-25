package org.bouncycastle.p307pkcs.p308bc;

import java.io.IOException;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PBMAC1Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder;

/* loaded from: classes2.dex */
public class BcPKCS12PBMac1CalculatorBuilder implements PKCS12MacCalculatorBuilder {
    private PBKDF2Params pbkdf2Params;
    private final PBMAC1Params pbmac1Params;

    public BcPKCS12PBMac1CalculatorBuilder(PBMAC1Params pBMAC1Params) throws IOException {
        this.pbkdf2Params = null;
        this.pbmac1Params = pBMAC1Params;
        if (!PKCSObjectIdentifiers.id_PBKDF2.m14446equals((ASN1Primitive) pBMAC1Params.getKeyDerivationFunc().getAlgorithm())) {
            throw new IllegalArgumentException("unrecognised PBKDF");
        }
        PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(pBMAC1Params.getKeyDerivationFunc().getParameters());
        this.pbkdf2Params = pBKDF2Params;
        if (pBKDF2Params.getKeyLength() == null) {
            throw new IOException("Key length must be present when using PBMAC1.");
        }
    }

    @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder
    /* renamed from: build */
    public MacCalculator mo17407build(char[] cArr) {
        return PKCS12PBEUtils.createPBMac1Calculator(this.pbmac1Params, this.pbkdf2Params, cArr);
    }

    @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder
    public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
        return new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBMAC1, this.pbmac1Params);
    }
}
