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
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECMultiplier;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class ECDSASigner implements ECConstants, InterfaceC5276DSAExt {
    private final DSAKCalculator kCalculator;

    /* renamed from: key */
    private ECKeyParameters f20948key;

    /* renamed from: random */
    private SecureRandom f20949random;

    public ECDSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    public BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        int iBitLength = bigInteger.bitLength();
        int length = bArr.length * 8;
        BigInteger bigInteger2 = new BigInteger(1, bArr);
        return iBitLength < length ? bigInteger2.shiftRight(length - iBitLength) : bigInteger2;
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        ECDomainParameters parameters = this.f20948key.getParameters();
        BigInteger bigIntegerM15723getN = parameters.m15723getN();
        BigInteger bigIntegerCalculateE = calculateE(bigIntegerM15723getN, bArr);
        BigInteger bigIntegerM15727getD = ((ECPrivateKeyParameters) this.f20948key).m15727getD();
        if (this.kCalculator.isDeterministic()) {
            this.kCalculator.mo15858init(bigIntegerM15723getN, bigIntegerM15727getD, bArr);
        } else {
            this.kCalculator.mo15859init(bigIntegerM15723getN, this.f20949random);
        }
        ECMultiplier eCMultiplierCreateBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger bigIntegerMo15860nextK = this.kCalculator.mo15860nextK();
            BigInteger bigIntegerMod = eCMultiplierCreateBasePointMultiplier.multiply(parameters.m15720getG(), bigIntegerMo15860nextK).normalize().getAffineXCoord().toBigInteger().mod(bigIntegerM15723getN);
            BigInteger bigInteger = ECConstants.f22094ZERO;
            if (!bigIntegerMod.equals(bigInteger)) {
                BigInteger bigIntegerMod2 = BigIntegers.modOddInverse(bigIntegerM15723getN, bigIntegerMo15860nextK).multiply(bigIntegerCalculateE.add(bigIntegerM15727getD.multiply(bigIntegerMod))).mod(bigIntegerM15723getN);
                if (!bigIntegerMod2.equals(bigInteger)) {
                    return new BigInteger[]{bigIntegerMod, bigIntegerMod2};
                }
            }
        }
    }

    public ECFieldElement getDenominator(int i, AbstractC5820ECPoint abstractC5820ECPoint) {
        if (i != 1) {
            if (i == 2 || i == 3 || i == 4) {
                return abstractC5820ECPoint.getZCoord(0).mo16318square();
            }
            if (i != 6 && i != 7) {
                return null;
            }
        }
        return abstractC5820ECPoint.getZCoord(0);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5276DSAExt
    public BigInteger getOrder() {
        return this.f20948key.getParameters().m15723getN();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    /* renamed from: init */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo14965init(boolean z, CipherParameters cipherParameters) {
        ECKeyParameters eCKeyParameters;
        SecureRandom random;
        if (!z) {
            eCKeyParameters = (ECPublicKeyParameters) cipherParameters;
        } else {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f20948key = (ECPrivateKeyParameters) parametersWithRandom.getParameters();
                random = parametersWithRandom.getRandom();
                CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties("ECDSA", this.f20948key, z));
                this.f20949random = initSecureRandom((z || this.kCalculator.isDeterministic()) ? false : true, random);
            }
            eCKeyParameters = (ECPrivateKeyParameters) cipherParameters;
        }
        this.f20948key = eCKeyParameters;
        random = null;
        CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties("ECDSA", this.f20948key, z));
        this.f20949random = initSecureRandom((z || this.kCalculator.isDeterministic()) ? false : true, random);
    }

    public SecureRandom initSecureRandom(boolean z, SecureRandom secureRandom) {
        if (z) {
            return CryptoServicesRegistrar.getSecureRandom(secureRandom);
        }
        return null;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger cofactor;
        ECFieldElement denominator;
        ECDomainParameters parameters = this.f20948key.getParameters();
        BigInteger bigIntegerM15723getN = parameters.m15723getN();
        BigInteger bigIntegerCalculateE = calculateE(bigIntegerM15723getN, bArr);
        BigInteger bigInteger3 = ECConstants.f22091ONE;
        if (bigInteger.compareTo(bigInteger3) < 0 || bigInteger.compareTo(bigIntegerM15723getN) >= 0 || bigInteger2.compareTo(bigInteger3) < 0 || bigInteger2.compareTo(bigIntegerM15723getN) >= 0) {
            return false;
        }
        BigInteger bigIntegerModOddInverseVar = BigIntegers.modOddInverseVar(bigIntegerM15723getN, bigInteger2);
        AbstractC5820ECPoint abstractC5820ECPointSumOfTwoMultiplies = ECAlgorithms.sumOfTwoMultiplies(parameters.m15720getG(), bigIntegerCalculateE.multiply(bigIntegerModOddInverseVar).mod(bigIntegerM15723getN), ((ECPublicKeyParameters) this.f20948key).m15728getQ(), bigInteger.multiply(bigIntegerModOddInverseVar).mod(bigIntegerM15723getN));
        if (abstractC5820ECPointSumOfTwoMultiplies.isInfinity()) {
            return false;
        }
        AbstractC5817ECCurve curve = abstractC5820ECPointSumOfTwoMultiplies.getCurve();
        if (curve == null || (cofactor = curve.getCofactor()) == null || cofactor.compareTo(ECConstants.f22089EIGHT) > 0 || (denominator = getDenominator(curve.getCoordinateSystem(), abstractC5820ECPointSumOfTwoMultiplies)) == null || denominator.mo16315isZero()) {
            return abstractC5820ECPointSumOfTwoMultiplies.normalize().getAffineXCoord().toBigInteger().mod(bigIntegerM15723getN).equals(bigInteger);
        }
        ECFieldElement xCoord = abstractC5820ECPointSumOfTwoMultiplies.getXCoord();
        while (curve.isValidFieldElement(bigInteger)) {
            if (curve.fromBigInteger(bigInteger).multiply(denominator).equals(xCoord)) {
                return true;
            }
            bigInteger = bigInteger.add(bigIntegerM15723getN);
        }
        return false;
    }

    public ECDSASigner(DSAKCalculator dSAKCalculator) {
        this.kCalculator = dSAKCalculator;
    }
}
