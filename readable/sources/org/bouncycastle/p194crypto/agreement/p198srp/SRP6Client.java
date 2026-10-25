package org.bouncycastle.p194crypto.agreement.p198srp;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p213params.SRP6GroupParameters;

/* loaded from: classes2.dex */
public class SRP6Client {

    /* renamed from: A */
    protected BigInteger f19227A;

    /* renamed from: B */
    protected BigInteger f19228B;

    /* renamed from: Key */
    protected BigInteger f19229Key;

    /* renamed from: M1 */
    protected BigInteger f19230M1;

    /* renamed from: M2 */
    protected BigInteger f19231M2;

    /* renamed from: N */
    protected BigInteger f19232N;

    /* renamed from: S */
    protected BigInteger f19233S;

    /* renamed from: a */
    protected BigInteger f19234a;

    /* renamed from: digest */
    protected InterfaceC5277Digest f19235digest;

    /* renamed from: g */
    protected BigInteger f19236g;

    /* renamed from: random */
    protected SecureRandom f19237random;

    /* renamed from: u */
    protected BigInteger f19238u;

    /* renamed from: x */
    protected BigInteger f19239x;

    private BigInteger calculateS() {
        BigInteger bigIntegerCalculateK = SRP6Util.calculateK(this.f19235digest, this.f19232N, this.f19236g);
        return this.f19228B.subtract(this.f19236g.modPow(this.f19239x, this.f19232N).multiply(bigIntegerCalculateK).mod(this.f19232N)).mod(this.f19232N).modPow(this.f19238u.multiply(this.f19239x).add(this.f19234a), this.f19232N);
    }

    public BigInteger calculateClientEvidenceMessage() throws CryptoException {
        BigInteger bigInteger;
        BigInteger bigInteger2;
        BigInteger bigInteger3 = this.f19227A;
        if (bigInteger3 == null || (bigInteger = this.f19228B) == null || (bigInteger2 = this.f19233S) == null) {
            throw new CryptoException("Impossible to compute M1: some data are missing from the previous operations (A,B,S)");
        }
        BigInteger bigIntegerCalculateM1 = SRP6Util.calculateM1(this.f19235digest, this.f19232N, bigInteger3, bigInteger, bigInteger2);
        this.f19230M1 = bigIntegerCalculateM1;
        return bigIntegerCalculateM1;
    }

    public BigInteger calculateSecret(BigInteger bigInteger) throws CryptoException {
        BigInteger bigIntegerValidatePublicValue = SRP6Util.validatePublicValue(this.f19232N, bigInteger);
        this.f19228B = bigIntegerValidatePublicValue;
        this.f19238u = SRP6Util.calculateU(this.f19235digest, this.f19232N, this.f19227A, bigIntegerValidatePublicValue);
        BigInteger bigIntegerCalculateS = calculateS();
        this.f19233S = bigIntegerCalculateS;
        return bigIntegerCalculateS;
    }

    public BigInteger calculateSessionKey() throws CryptoException {
        BigInteger bigInteger = this.f19233S;
        if (bigInteger == null || this.f19230M1 == null || this.f19231M2 == null) {
            throw new CryptoException("Impossible to compute Key: some data are missing from the previous operations (S,M1,M2)");
        }
        BigInteger bigIntegerCalculateKey = SRP6Util.calculateKey(this.f19235digest, this.f19232N, bigInteger);
        this.f19229Key = bigIntegerCalculateKey;
        return bigIntegerCalculateKey;
    }

    public BigInteger generateClientCredentials(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.f19239x = SRP6Util.calculateX(this.f19235digest, this.f19232N, bArr, bArr2, bArr3);
        BigInteger bigIntegerSelectPrivateValue = selectPrivateValue();
        this.f19234a = bigIntegerSelectPrivateValue;
        BigInteger bigIntegerModPow = this.f19236g.modPow(bigIntegerSelectPrivateValue, this.f19232N);
        this.f19227A = bigIntegerModPow;
        return bigIntegerModPow;
    }

    /* renamed from: init */
    public void m15030init(BigInteger bigInteger, BigInteger bigInteger2, InterfaceC5277Digest interfaceC5277Digest, SecureRandom secureRandom) {
        this.f19232N = bigInteger;
        this.f19236g = bigInteger2;
        this.f19235digest = interfaceC5277Digest;
        this.f19237random = secureRandom;
    }

    public BigInteger selectPrivateValue() {
        return SRP6Util.generatePrivateValue(this.f19235digest, this.f19232N, this.f19236g, this.f19237random);
    }

    public boolean verifyServerEvidenceMessage(BigInteger bigInteger) throws CryptoException {
        BigInteger bigInteger2;
        BigInteger bigInteger3;
        BigInteger bigInteger4 = this.f19227A;
        if (bigInteger4 == null || (bigInteger2 = this.f19230M1) == null || (bigInteger3 = this.f19233S) == null) {
            throw new CryptoException("Impossible to compute and verify M2: some data are missing from the previous operations (A,M1,S)");
        }
        if (!SRP6Util.calculateM2(this.f19235digest, this.f19232N, bigInteger4, bigInteger2, bigInteger3).equals(bigInteger)) {
            return false;
        }
        this.f19231M2 = bigInteger;
        return true;
    }

    /* renamed from: init */
    public void m15031init(SRP6GroupParameters sRP6GroupParameters, InterfaceC5277Digest interfaceC5277Digest, SecureRandom secureRandom) {
        m15030init(sRP6GroupParameters.m15826getN(), sRP6GroupParameters.m15825getG(), interfaceC5277Digest, secureRandom);
    }
}
