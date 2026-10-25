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
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECMultiplier;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DSTU4145Signer implements InterfaceC5276DSAExt {

    /* renamed from: ONE */
    private static final BigInteger f20934ONE = BigInteger.valueOf(1);

    /* renamed from: key */
    private ECKeyParameters f20935key;

    /* renamed from: random */
    private SecureRandom f20936random;

    private static BigInteger fieldElement2Integer(BigInteger bigInteger, ECFieldElement eCFieldElement) {
        return truncate(eCFieldElement.toBigInteger(), bigInteger.bitLength() - 1);
    }

    private static ECFieldElement hash2FieldElement(AbstractC5817ECCurve abstractC5817ECCurve, byte[] bArr) {
        return abstractC5817ECCurve.fromBigInteger(truncate(new BigInteger(1, C6238Arrays.m18267reverse(bArr)), abstractC5817ECCurve.getFieldSize()));
    }

    private static BigInteger truncate(BigInteger bigInteger, int i) {
        return bigInteger.bitLength() > i ? bigInteger.mod(f20934ONE.shiftLeft(i)) : bigInteger;
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        ECDomainParameters parameters = this.f20935key.getParameters();
        AbstractC5817ECCurve curve = parameters.getCurve();
        ECFieldElement eCFieldElementHash2FieldElement = hash2FieldElement(curve, bArr);
        if (eCFieldElementHash2FieldElement.mo16315isZero()) {
            eCFieldElementHash2FieldElement = curve.fromBigInteger(f20934ONE);
        }
        BigInteger bigIntegerM15723getN = parameters.m15723getN();
        BigInteger bigIntegerM15727getD = ((ECPrivateKeyParameters) this.f20935key).m15727getD();
        ECMultiplier eCMultiplierCreateBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger bigInteger = BigInteger.ONE;
            BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(bigInteger, bigIntegerM15723getN.subtract(bigInteger), this.f20936random);
            ECFieldElement affineXCoord = eCMultiplierCreateBasePointMultiplier.multiply(parameters.m15720getG(), bigIntegerCreateRandomInRange).normalize().getAffineXCoord();
            if (!affineXCoord.mo16315isZero()) {
                BigInteger bigIntegerFieldElement2Integer = fieldElement2Integer(bigIntegerM15723getN, eCFieldElementHash2FieldElement.multiply(affineXCoord));
                if (bigIntegerFieldElement2Integer.signum() != 0) {
                    BigInteger bigIntegerMod = bigIntegerFieldElement2Integer.multiply(bigIntegerM15727getD).add(bigIntegerCreateRandomInRange).mod(bigIntegerM15723getN);
                    if (bigIntegerMod.signum() != 0) {
                        return new BigInteger[]{bigIntegerFieldElement2Integer, bigIntegerMod};
                    }
                } else {
                    continue;
                }
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5276DSAExt
    public BigInteger getOrder() {
        return this.f20935key.getParameters().m15723getN();
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
            this.f20935key = (ECPrivateKeyParameters) cipherParameters;
            this.f20936random = CryptoServicesRegistrar.getSecureRandom(random);
        } else {
            this.f20935key = (ECPublicKeyParameters) cipherParameters;
            this.f20936random = null;
        }
        CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties("DSTU4145", this.f20935key, z));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        if (bigInteger.signum() <= 0 || bigInteger2.signum() <= 0) {
            return false;
        }
        ECDomainParameters parameters = this.f20935key.getParameters();
        BigInteger bigIntegerM15723getN = parameters.m15723getN();
        if (bigInteger.compareTo(bigIntegerM15723getN) >= 0 || bigInteger2.compareTo(bigIntegerM15723getN) >= 0) {
            return false;
        }
        AbstractC5817ECCurve curve = parameters.getCurve();
        ECFieldElement eCFieldElementHash2FieldElement = hash2FieldElement(curve, bArr);
        if (eCFieldElementHash2FieldElement.mo16315isZero()) {
            eCFieldElementHash2FieldElement = curve.fromBigInteger(f20934ONE);
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = ECAlgorithms.sumOfTwoMultiplies(parameters.m15720getG(), bigInteger2, ((ECPublicKeyParameters) this.f20935key).m15728getQ(), bigInteger).normalize();
        return !abstractC5820ECPointNormalize.isInfinity() && fieldElement2Integer(bigIntegerM15723getN, eCFieldElementHash2FieldElement.multiply(abstractC5820ECPointNormalize.getAffineXCoord())).compareTo(bigInteger) == 0;
    }
}
