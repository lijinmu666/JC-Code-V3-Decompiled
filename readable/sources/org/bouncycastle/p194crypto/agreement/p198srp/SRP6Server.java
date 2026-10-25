package org.bouncycastle.p194crypto.agreement.p198srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p213params.SRP6GroupParameters;

/* loaded from: classes2.dex */
public class SRP6Server {

    /* renamed from: A */
    protected BigInteger f19240A;

    /* renamed from: B */
    protected BigInteger f19241B;

    /* renamed from: Key */
    protected BigInteger f19242Key;

    /* renamed from: M1 */
    protected BigInteger f19243M1;

    /* renamed from: M2 */
    protected BigInteger f19244M2;

    /* renamed from: N */
    protected BigInteger f19245N;

    /* renamed from: S */
    protected BigInteger f19246S;

    /* renamed from: b */
    protected BigInteger f19247b;

    /* renamed from: digest */
    protected InterfaceC5277Digest f19248digest;

    /* renamed from: g */
    protected BigInteger f19249g;

    /* renamed from: random */
    protected SecureRandom f19250random;

    /* renamed from: u */
    protected BigInteger f19251u;

    /* renamed from: v */
    protected BigInteger f19252v;

    private BigInteger calculateS() {
        return this.f19252v.modPow(this.f19251u, this.f19245N).multiply(this.f19240A).mod(this.f19245N).modPow(this.f19247b, this.f19245N);
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger bigIntegerValidatePublicValue = SRP6Util.validatePublicValue(this.f19245N, bigInteger);
        this.f19240A = bigIntegerValidatePublicValue;
        this.f19251u = SRP6Util.calculateU(this.f19248digest, this.f19245N, bigIntegerValidatePublicValue, this.f19241B);
        BigInteger bigIntegerCalculateS = calculateS();
        this.f19246S = bigIntegerCalculateS;
        return bigIntegerCalculateS;
    }

    public BigInteger calculateServerEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f19240A;
        if (bigInteger3 == null || (bigInteger = this.f19243M1) == null || (bigInteger2 = this.f19246S) == null) {
            throw new CryptoException("Impossible to compute M2: some data are missing from the previous operations (A,M1,S)");
        }
        BigInteger bigIntegerCalculateM2 = SRP6Util.calculateM2(this.f19248digest, this.f19245N, bigInteger3, bigInteger, bigInteger2);
        this.f19244M2 = bigIntegerCalculateM2;
        return bigIntegerCalculateM2;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.f19246S;
        if (bigInteger == null || this.f19243M1 == null || this.f19244M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger bigIntegerCalculateKey = SRP6Util.calculateKey(this.f19248digest, this.f19245N, bigInteger);
        this.f19242Key = bigIntegerCalculateKey;
        return bigIntegerCalculateKey;
    }

    public BigInteger generateServerCredentials() {
        BigInteger bigIntegerCalculateK = SRP6Util.calculateK(this.f19248digest, this.f19245N, this.f19249g);
        this.f19247b = selectPrivateValue();
        BigInteger bigIntegerMod = bigIntegerCalculateK.multiply(this.f19252v).mod(this.f19245N).add(this.f19249g.modPow(this.f19247b, this.f19245N)).mod(this.f19245N);
        this.f19241B = bigIntegerMod;
        return bigIntegerMod;
    }

    /* renamed from: init */
    public void m15032init(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, InterfaceC5277Digest interfaceC5277Digest, SecureRandom secureRandom) {
        this.f19245N = bigInteger;
        this.f19249g = bigInteger2;
        this.f19252v = bigInteger3;
        this.f19250random = secureRandom;
        this.f19248digest = interfaceC5277Digest;
    }

    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.f19248digest, this.f19245N, this.f19249g, this.f19250random);
    }

    public boolean verifyClientEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f19240A;
        if (bigInteger4 == null || (bigInteger2 = this.f19241B) == null || (bigInteger3 = this.f19246S) == null) {
            throw new CryptoException("Impossible to compute and verify M1: some data are missing from the previous operations (A,B,S)");
        }
        if (!SRP6Util.calculateM1(this.f19248digest, this.f19245N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        }
        this.f19243M1 = bigInteger;
        return true;
    }

    /* renamed from: init */
    public void m15033init(SRP6GroupParameters sRP6GroupParameters, BigInteger bigInteger, InterfaceC5277Digest interfaceC5277Digest, SecureRandom secureRandom) {
        m15032init(sRP6GroupParameters.m15826getN(), sRP6GroupParameters.m15825getG(), bigInteger, interfaceC5277Digest, secureRandom);
    }
}
