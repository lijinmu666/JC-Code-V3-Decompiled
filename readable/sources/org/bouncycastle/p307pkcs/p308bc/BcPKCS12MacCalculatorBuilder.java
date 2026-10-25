package org.bouncycastle.p307pkcs.p308bc;

import java.security.SecureRandom;
import org.bouncycastle.operator.MacCalculator;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder;

/* loaded from: classes2.dex */
public class BcPKCS12MacCalculatorBuilder implements PKCS12MacCalculatorBuilder {
    private AlgorithmIdentifier algorithmIdentifier;

    /* renamed from: digest */
    private ExtendedDigest f22934digest;
    private int iterationCount;

    /* renamed from: random */
    private SecureRandom f22935random;
    private int saltLength;

    public BcPKCS12MacCalculatorBuilder() {
        this(new SHA1Digest(), new AlgorithmIdentifier(OIWObjectIdentifiers.f18459idSHA1, C5103DERNull.INSTANCE));
    }

    @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder
    /* renamed from: build */
    public MacCalculator mo17407build(char[] cArr) {
        if (this.f22935random == null) {
            this.f22935random = new SecureRandom();
        }
        byte[] bArr = new byte[this.saltLength];
        this.f22935random.nextBytes(bArr);
        return PKCS12PBEUtils.createMacCalculator(this.algorithmIdentifier.getAlgorithm(), this.f22934digest, new PKCS12PBEParams(bArr, this.iterationCount), cArr);
    }

    @Override // org.bouncycastle.p307pkcs.PKCS12MacCalculatorBuilder
    public AlgorithmIdentifier getDigestAlgorithmIdentifier() {
        return this.algorithmIdentifier;
    }

    public BcPKCS12MacCalculatorBuilder setIterationCount(int i) {
        this.iterationCount = i;
        return this;
    }

    public BcPKCS12MacCalculatorBuilder(ExtendedDigest extendedDigest, AlgorithmIdentifier algorithmIdentifier) {
        this.iterationCount = 1024;
        this.f22934digest = extendedDigest;
        this.algorithmIdentifier = algorithmIdentifier;
        this.saltLength = extendedDigest.getDigestSize();
    }
}
