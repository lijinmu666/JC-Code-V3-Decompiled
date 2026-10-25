package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5276DSAExt;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECMultiplier;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ECGOST3410Signer implements InterfaceC5276DSAExt {

    /* renamed from: key */
    ECKeyParameters f20950key;

    /* renamed from: random */
    SecureRandom f20951random;

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        BigInteger bigInteger = new BigInteger(1, C6238Arrays.m18267reverse(bArr));
        ECDomainParameters parameters = this.f20950key.getParameters();
        BigInteger bigIntegerM15723getN = parameters.m15723getN();
        BigInteger bigIntegerM15727getD = ((ECPrivateKeyParameters) this.f20950key).m15727getD();
        ECMultiplier eCMultiplierCreateBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(bigIntegerM15723getN.bitLength(), this.f20951random);
            BigInteger bigInteger2 = ECConstants.f22094ZERO;
            if (!bigIntegerCreateRandomBigInteger.equals(bigInteger2)) {
                BigInteger bigIntegerMod = eCMultiplierCreateBasePointMultiplier.multiply(parameters.m15720getG(), bigIntegerCreateRandomBigInteger).normalize().getAffineXCoord().toBigInteger().mod(bigIntegerM15723getN);
                if (bigIntegerMod.equals(bigInteger2)) {
                    continue;
                } else {
                    BigInteger bigIntegerMod2 = bigIntegerCreateRandomBigInteger.multiply(bigInteger).add(bigIntegerM15727getD.multiply(bigIntegerMod)).mod(bigIntegerM15723getN);
                    if (!bigIntegerMod2.equals(bigInteger2)) {
                        return new BigInteger[]{bigIntegerMod, bigIntegerMod2};
                    }
                }
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5276DSAExt
    public BigInteger getOrder() {
        return this.f20950key.getParameters().m15723getN();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    /* renamed from: init */
    public void mo14965init(boolean z, CipherParameters cipherParameters) {
        SecureRandom random = null;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                random = parametersWithRandom.getRandom();
                cipherParameters = parametersWithRandom.getParameters();
            }
            this.f20950key = (ECPrivateKeyParameters) cipherParameters;
            this.f20951random = CryptoServicesRegistrar.getSecureRandom(random);
        } else {
            this.f20950key = (ECPublicKeyParameters) cipherParameters;
            this.f20951random = null;
        }
        CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties("ECGOST3410", this.f20950key, z));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigInteger3 = new BigInteger(1, C6238Arrays.m18267reverse(bArr));
        BigInteger bigIntegerM15723getN = this.f20950key.getParameters().m15723getN();
        BigInteger bigInteger4 = ECConstants.f22091ONE;
        if (bigInteger.compareTo(bigInteger4) < 0 || bigInteger.compareTo(bigIntegerM15723getN) >= 0 || bigInteger2.compareTo(bigInteger4) < 0 || bigInteger2.compareTo(bigIntegerM15723getN) >= 0) {
            return false;
        }
        BigInteger bigIntegerModOddInverseVar = BigIntegers.modOddInverseVar(bigIntegerM15723getN, bigInteger3);
        AbstractC5820ECPoint abstractC5820ECPointNormalize = ECAlgorithms.sumOfTwoMultiplies(this.f20950key.getParameters().m15720getG(), bigInteger2.multiply(bigIntegerModOddInverseVar).mod(bigIntegerM15723getN), ((ECPublicKeyParameters) this.f20950key).m15728getQ(), bigIntegerM15723getN.subtract(bigInteger).multiply(bigIntegerModOddInverseVar).mod(bigIntegerM15723getN)).normalize();
        if (abstractC5820ECPointNormalize.isInfinity()) {
            return false;
        }
        return abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger().mod(bigIntegerM15723getN).equals(bigInteger);
    }
}
