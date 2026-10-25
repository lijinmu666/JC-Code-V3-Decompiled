package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InterfaceC5276DSAExt;
import org.bouncycastle.p194crypto.generators.ECKeyPairGenerator;
import org.bouncycastle.p194crypto.p213params.ECKeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.ECKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p361util.BigIntegers;

/* loaded from: classes2.dex */
public class ECNRSigner implements InterfaceC5276DSAExt {
    private boolean forSigning;

    /* renamed from: key */
    private ECKeyParameters f20952key;

    /* renamed from: random */
    private SecureRandom f20953random;

    private BigInteger extractT(ECPublicKeyParameters eCPublicKeyParameters, BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerM15723getN = eCPublicKeyParameters.getParameters().m15723getN();
        if (bigInteger.compareTo(ECConstants.f22091ONE) < 0 || bigInteger.compareTo(bigIntegerM15723getN) >= 0 || bigInteger2.compareTo(ECConstants.f22094ZERO) < 0 || bigInteger2.compareTo(bigIntegerM15723getN) >= 0) {
            return null;
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = ECAlgorithms.sumOfTwoMultiplies(eCPublicKeyParameters.getParameters().m15720getG(), bigInteger2, eCPublicKeyParameters.m15728getQ(), bigInteger).normalize();
        if (abstractC5820ECPointNormalize.isInfinity()) {
            return null;
        }
        return bigInteger.subtract(abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger()).mod(bigIntegerM15723getN);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public BigInteger[] generateSignature(byte[] bArr) {
        AsymmetricCipherKeyPair asymmetricCipherKeyPairGenerateKeyPair;
        BigInteger bigIntegerMod;
        if (!this.forSigning) {
            throw new IllegalStateException("not initialised for signing");
        }
        BigInteger order = getOrder();
        BigInteger bigInteger = new BigInteger(1, bArr);
        ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) this.f20952key;
        if (bigInteger.compareTo(order) >= 0) {
            throw new DataLengthException("input too large for ECNR key");
        }
        do {
            ECKeyPairGenerator eCKeyPairGenerator = new ECKeyPairGenerator();
            eCKeyPairGenerator.mo14944init(new ECKeyGenerationParameters(eCPrivateKeyParameters.getParameters(), this.f20953random));
            asymmetricCipherKeyPairGenerateKeyPair = eCKeyPairGenerator.generateKeyPair();
            bigIntegerMod = ((ECPublicKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPublic()).m15728getQ().getAffineXCoord().toBigInteger().add(bigInteger).mod(order);
        } while (bigIntegerMod.equals(ECConstants.f22094ZERO));
        return new BigInteger[]{bigIntegerMod, ((ECPrivateKeyParameters) asymmetricCipherKeyPairGenerateKeyPair.getPrivate()).m15727getD().subtract(bigIntegerMod.multiply(eCPrivateKeyParameters.m15727getD())).mod(order)};
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5276DSAExt
    public BigInteger getOrder() {
        return this.f20952key.getParameters().m15723getN();
    }

    public byte[] getRecoveredMessage(BigInteger bigInteger, BigInteger bigInteger2) {
        if (this.forSigning) {
            throw new IllegalStateException("not initialised for verifying/recovery");
        }
        BigInteger bigIntegerExtractT = extractT((ECPublicKeyParameters) this.f20952key, bigInteger, bigInteger2);
        if (bigIntegerExtractT != null) {
            return BigIntegers.asUnsignedByteArray(bigIntegerExtractT);
        }
        return null;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    /* renamed from: init */
    public void mo14965init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        SecureRandom random = null;
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                random = parametersWithRandom.getRandom();
                cipherParameters = parametersWithRandom.getParameters();
            }
            this.f20952key = (ECPrivateKeyParameters) cipherParameters;
            this.f20953random = CryptoServicesRegistrar.getSecureRandom(random);
        } else {
            this.f20952key = (ECPublicKeyParameters) cipherParameters;
            this.f20953random = null;
        }
        CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties("ECNR", this.f20952key, z));
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5275DSA
    public boolean verifySignature(byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) {
        if (this.forSigning) {
            throw new IllegalStateException("not initialised for verifying");
        }
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) this.f20952key;
        BigInteger bigIntegerM15723getN = eCPublicKeyParameters.getParameters().m15723getN();
        int iBitLength = bigIntegerM15723getN.bitLength();
        BigInteger bigInteger3 = new BigInteger(1, bArr);
        if (bigInteger3.bitLength() > iBitLength) {
            throw new DataLengthException("input too large for ECNR key.");
        }
        BigInteger bigIntegerExtractT = extractT(eCPublicKeyParameters, bigInteger, bigInteger2);
        return bigIntegerExtractT != null && bigIntegerExtractT.equals(bigInteger3.mod(bigIntegerM15723getN));
    }
}
