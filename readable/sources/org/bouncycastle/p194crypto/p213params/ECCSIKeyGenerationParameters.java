package org.bouncycastle.p194crypto.p213params;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ECCSIKeyGenerationParameters extends KeyGenerationParameters {

    /* renamed from: G */
    private final AbstractC5820ECPoint f20723G;

    /* renamed from: digest */
    private final InterfaceC5277Digest f20724digest;

    /* renamed from: id */
    private final byte[] f20725id;

    /* renamed from: kpak */
    private final AbstractC5820ECPoint f20726kpak;

    /* renamed from: ksak */
    private final BigInteger f20727ksak;

    /* renamed from: n */
    private final int f20728n;

    /* renamed from: q */
    private final BigInteger f20729q;

    public ECCSIKeyGenerationParameters(SecureRandom secureRandom, X9ECParameters x9ECParameters, InterfaceC5277Digest interfaceC5277Digest, byte[] bArr) {
        super(secureRandom, x9ECParameters.getCurve().m16298getA().bitLength());
        BigInteger order = x9ECParameters.getCurve().getOrder();
        this.f20729q = order;
        AbstractC5820ECPoint abstractC5820ECPointM14735getG = x9ECParameters.m14735getG();
        this.f20723G = abstractC5820ECPointM14735getG;
        this.f20724digest = interfaceC5277Digest;
        this.f20725id = C6238Arrays.m18231clone(bArr);
        int iBitLength = x9ECParameters.getCurve().m16298getA().bitLength();
        this.f20728n = iBitLength;
        BigInteger bigIntegerMod = BigIntegers.createRandomBigInteger(iBitLength, secureRandom).mod(order);
        this.f20727ksak = bigIntegerMod;
        this.f20726kpak = abstractC5820ECPointM14735getG.multiply(bigIntegerMod).normalize();
    }

    public BigInteger computeSSK(BigInteger bigInteger) {
        return this.f20727ksak.add(bigInteger).mod(this.f20729q);
    }

    public InterfaceC5277Digest getDigest() {
        return this.f20724digest;
    }

    /* renamed from: getG */
    public AbstractC5820ECPoint m15712getG() {
        return this.f20723G;
    }

    /* renamed from: getId */
    public byte[] m15713getId() {
        return C6238Arrays.m18231clone(this.f20725id);
    }

    /* renamed from: getKPAK */
    public AbstractC5820ECPoint m15714getKPAK() {
        return this.f20726kpak;
    }

    /* renamed from: getN */
    public int m15715getN() {
        return this.f20728n;
    }

    /* renamed from: getQ */
    public BigInteger m15716getQ() {
        return this.f20729q;
    }
}
