package org.bouncycastle.p358tsp;

import java.math.BigInteger;
import org.bouncycastle.operator.DefaultDigestAlgorithmIdentifierFinder;
import org.bouncycastle.operator.DigestAlgorithmIdentifierFinder;
import org.bouncycastle.p133asn1.ASN1Boolean;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p169tsp.MessageImprint;
import org.bouncycastle.p133asn1.p169tsp.TimeStampReq;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.ExtensionsGenerator;

/* loaded from: classes2.dex */
public class TimeStampRequestGenerator {
    private static final DefaultDigestAlgorithmIdentifierFinder DEFAULT_DIGEST_ALG_FINDER = new DefaultDigestAlgorithmIdentifierFinder();

    /* renamed from: certReq */
    private ASN1Boolean f24157certReq;
    private final DigestAlgorithmIdentifierFinder digestAlgFinder;
    private final ExtensionsGenerator extGenerator;
    private ASN1ObjectIdentifier reqPolicy;

    public TimeStampRequestGenerator() {
        this(DEFAULT_DIGEST_ALG_FINDER);
    }

    public void addExtension(String str, boolean z, ASN1Encodable aSN1Encodable) {
        addExtension(new ASN1ObjectIdentifier(str), z, aSN1Encodable);
    }

    public TimeStampRequest generate(String str, byte[] bArr) {
        return generate(str, bArr, (BigInteger) null);
    }

    public void setCertReq(ASN1Boolean aSN1Boolean) {
        this.f24157certReq = aSN1Boolean;
    }

    public void setReqPolicy(String str) {
        setReqPolicy(new ASN1ObjectIdentifier(str));
    }

    public TimeStampRequestGenerator(DigestAlgorithmIdentifierFinder digestAlgorithmIdentifierFinder) {
        this.extGenerator = new ExtensionsGenerator();
        if (digestAlgorithmIdentifierFinder == null) {
            throw new NullPointerException("'digestAlgFinder' cannot be null");
        }
        this.digestAlgFinder = digestAlgorithmIdentifierFinder;
    }

    public void addExtension(String str, boolean z, byte[] bArr) {
        addExtension(new ASN1ObjectIdentifier(str), z, bArr);
    }

    public TimeStampRequest generate(String str, byte[] bArr, BigInteger bigInteger) {
        if (str != null) {
            return generate(new ASN1ObjectIdentifier(str), bArr, bigInteger);
        }
        throw new NullPointerException("'digestAlgorithmOID' cannot be null");
    }

    public void setCertReq(boolean z) {
        setCertReq(ASN1Boolean.getInstance(z));
    }

    public void setReqPolicy(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.reqPolicy = aSN1ObjectIdentifier;
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        C6230TSPUtil.addExtension(this.extGenerator, aSN1ObjectIdentifier, z, aSN1Encodable);
    }

    public TimeStampRequest generate(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr) {
        return generate(aSN1ObjectIdentifier, bArr, (BigInteger) null);
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extGenerator.addExtension(aSN1ObjectIdentifier, z, bArr);
    }

    public TimeStampRequest generate(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, BigInteger bigInteger) {
        return generate(this.digestAlgFinder.mo17381find(aSN1ObjectIdentifier), bArr, bigInteger);
    }

    public TimeStampRequest generate(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        return generate(algorithmIdentifier, bArr, (BigInteger) null);
    }

    public TimeStampRequest generate(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, BigInteger bigInteger) {
        if (algorithmIdentifier != null) {
            return new TimeStampRequest(new TimeStampReq(new MessageImprint(algorithmIdentifier, bArr), this.reqPolicy, bigInteger == null ? null : new ASN1Integer(bigInteger), this.f24157certReq, this.extGenerator.m14688isEmpty() ? null : this.extGenerator.generate()));
        }
        throw new NullPointerException("'digestAlgorithmID' cannot be null");
    }
}
