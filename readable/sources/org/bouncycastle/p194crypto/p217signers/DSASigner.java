package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5276DSAExt;
import org.bouncycastle.p194crypto.p213params.DSAKeyParameters;
import org.bouncycastle.p194crypto.p213params.DSAParameters;
import org.bouncycastle.p194crypto.p213params.DSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.DSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class DSASigner implements InterfaceC5276DSAExt {
    private final DSAKCalculator kCalculator;

    /* renamed from: key */
    private DSAKeyParameters f20932key;

    /* renamed from: random */
    private SecureRandom f20933random;

    public DSASigner() {
        this.kCalculator = new RandomDSAKCalculator();
    }

    private BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        if (bigInteger.bitLength() >= bArr.length * 8) {
            return new BigInteger(1, bArr);
        }
        int iBitLength = bigInteger.bitLength() / 8;
        byte[] bArr2 = new byte[iBitLength];
        System.arraycopy(bArr, 0, bArr2, 0, iBitLength);
        return new BigInteger(1, bArr2);
    }

    private BigInteger getRandomizer(BigInteger bigInteger, SecureRandom secureRandom) {
        return BigIntegers.createRandomBigInteger(7, CryptoServicesRegistrar.getSecureRandom(secureRandom)).add(BigInteger.valueOf(128L)).multiply(bigInteger);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        DSAParameters parameters = this.f20932key.getParameters();
        BigInteger bigIntegerM15706getQ = parameters.m15706getQ();
        BigInteger bigIntegerCalculateE = calculateE(bigIntegerM15706getQ, bArr);
        BigInteger bigIntegerM15707getX = ((DSAPrivateKeyParameters) this.f20932key).m15707getX();
        if (this.kCalculator.isDeterministic()) {
            this.kCalculator.mo15858init(bigIntegerM15706getQ, bigIntegerM15707getX, bArr);
        } else {
            this.kCalculator.mo15859init(bigIntegerM15706getQ, this.f20933random);
        }
        BigInteger bigIntegerMo15860nextK = this.kCalculator.mo15860nextK();
        BigInteger bigIntegerMod = parameters.m15704getG().modPow(bigIntegerMo15860nextK.add(getRandomizer(bigIntegerM15706getQ, this.f20933random)), parameters.m15705getP()).mod(bigIntegerM15706getQ);
        return new BigInteger[]{bigIntegerMod, BigIntegers.modOddInverse(bigIntegerM15706getQ, bigIntegerMo15860nextK).multiply(bigIntegerCalculateE.add(bigIntegerM15707getX.multiply(bigIntegerMod))).mod(bigIntegerM15706getQ)};
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5276DSAExt
    public BigInteger getOrder() {
        return this.f20932key.getParameters().m15706getQ();
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0035  */
    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    /* renamed from: init */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void mo14965init(boolean z, CipherParameters cipherParameters) {
        DSAKeyParameters dSAKeyParameters;
        SecureRandom random;
        if (!z) {
            dSAKeyParameters = (DSAPublicKeyParameters) cipherParameters;
        } else {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f20932key = (DSAPrivateKeyParameters) parametersWithRandom.getParameters();
                random = parametersWithRandom.getRandom();
                CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties("DSA", this.f20932key, z));
                this.f20933random = initSecureRandom((z || this.kCalculator.isDeterministic()) ? false : true, random);
            }
            dSAKeyParameters = (DSAPrivateKeyParameters) cipherParameters;
        }
        this.f20932key = dSAKeyParameters;
        random = null;
        CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties("DSA", this.f20932key, z));
        this.f20933random = initSecureRandom((z || this.kCalculator.isDeterministic()) ? false : true, random);
    }

    public SecureRandom initSecureRandom(boolean z, SecureRandom secureRandom) {
        if (z) {
            return CryptoServicesRegistrar.getSecureRandom(secureRandom);
        }
        return null;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        DSAParameters parameters = this.f20932key.getParameters();
        BigInteger bigIntegerM15706getQ = parameters.m15706getQ();
        BigInteger bigIntegerCalculateE = calculateE(bigIntegerM15706getQ, bArr);
        BigInteger bigIntegerValueOf = BigInteger.valueOf(0L);
        if (bigIntegerValueOf.compareTo(bigInteger) >= 0 || bigIntegerM15706getQ.compareTo(bigInteger) <= 0 || bigIntegerValueOf.compareTo(bigInteger2) >= 0 || bigIntegerM15706getQ.compareTo(bigInteger2) <= 0) {
            return false;
        }
        BigInteger bigIntegerModOddInverseVar = BigIntegers.modOddInverseVar(bigIntegerM15706getQ, bigInteger2);
        BigInteger bigIntegerMod = bigIntegerCalculateE.multiply(bigIntegerModOddInverseVar).mod(bigIntegerM15706getQ);
        BigInteger bigIntegerMod2 = bigInteger.multiply(bigIntegerModOddInverseVar).mod(bigIntegerM15706getQ);
        BigInteger bigIntegerM15705getP = parameters.m15705getP();
        return parameters.m15704getG().modPow(bigIntegerMod, bigIntegerM15705getP).multiply(((DSAPublicKeyParameters) this.f20932key).m15708getY().modPow(bigIntegerMod2, bigIntegerM15705getP)).mod(bigIntegerM15705getP).mod(bigIntegerM15706getQ).equals(bigInteger);
    }

    public DSASigner(DSAKCalculator dSAKCalculator) {
        this.kCalculator = dSAKCalculator;
    }
}
