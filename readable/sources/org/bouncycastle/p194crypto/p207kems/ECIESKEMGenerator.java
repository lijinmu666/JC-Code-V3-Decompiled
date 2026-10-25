package org.bouncycastle.p194crypto.p207kems;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.KDFParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECMultiplier;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class ECIESKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: ONE */
    private static final BigInteger f20368ONE = BigInteger.valueOf(1);
    private boolean CofactorMode;
    private boolean OldCofactorMode;
    private boolean SingleHashMode;

    /* renamed from: kdf */
    private DerivationFunction f20369kdf;

    /* renamed from: keySize */
    private final int f20370keySize;

    /* renamed from: rnd */
    private SecureRandom f20371rnd;

    public ECIESKEMGenerator(int i, DerivationFunction derivationFunction, SecureRandom secureRandom) {
        this.f20370keySize = i;
        this.f20369kdf = derivationFunction;
        this.f20371rnd = secureRandom;
        this.CofactorMode = false;
        this.OldCofactorMode = false;
        this.SingleHashMode = false;
    }

    private ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public static byte[] deriveKey(boolean z, DerivationFunction derivationFunction, int i, byte[] bArr, byte[] bArr2) {
        if (!z) {
            byte[] bArrConcatenate = C6238Arrays.concatenate(bArr, bArr2);
            C6238Arrays.m18249fill(bArr2, (byte) 0);
            bArr2 = bArrConcatenate;
        }
        try {
            derivationFunction.mo14966init(new KDFParameters(bArr2, null));
            byte[] bArr3 = new byte[i];
            derivationFunction.generateBytes(bArr3, 0, i);
            return bArr3;
        } finally {
            C6238Arrays.m18249fill(bArr2, (byte) 0);
        }
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        if (!(asymmetricKeyParameter instanceof ECPublicKeyParameters)) {
            throw new IllegalArgumentException("EC public key required");
        }
        ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) asymmetricKeyParameter;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("ECIESKem", ConstraintUtils.bitsOfSecurityFor(eCPublicKeyParameters.getParameters().getCurve()), asymmetricKeyParameter, CryptoServicePurpose.ENCRYPTION));
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        AbstractC5817ECCurve curve = parameters.getCurve();
        BigInteger bigIntegerM15723getN = parameters.m15723getN();
        BigInteger bigIntegerM15721getH = parameters.m15721getH();
        BigInteger bigIntegerCreateRandomInRange = BigIntegers.createRandomInRange(f20368ONE, bigIntegerM15723getN, this.f20371rnd);
        AbstractC5820ECPoint[] abstractC5820ECPointArr = {createBasePointMultiplier().multiply(parameters.m15720getG(), bigIntegerCreateRandomInRange), eCPublicKeyParameters.m15728getQ().multiply(this.OldCofactorMode ? bigIntegerCreateRandomInRange.multiply(bigIntegerM15721getH).mod(bigIntegerM15723getN) : bigIntegerCreateRandomInRange)};
        curve.normalizeAll(abstractC5820ECPointArr);
        AbstractC5820ECPoint abstractC5820ECPoint = abstractC5820ECPointArr[0];
        AbstractC5820ECPoint abstractC5820ECPoint2 = abstractC5820ECPointArr[1];
        byte[] encoded = abstractC5820ECPoint.getEncoded(false);
        byte[] bArr = new byte[encoded.length];
        System.arraycopy(encoded, 0, bArr, 0, encoded.length);
        return new SecretWithEncapsulationImpl(deriveKey(this.SingleHashMode, this.f20369kdf, this.f20370keySize, encoded, abstractC5820ECPoint2.getAffineXCoord().getEncoded()), bArr);
    }

    public ECIESKEMGenerator(int i, DerivationFunction derivationFunction, SecureRandom secureRandom, boolean z, boolean z2, boolean z3) {
        this.f20369kdf = derivationFunction;
        this.f20371rnd = secureRandom;
        this.f20370keySize = i;
        this.CofactorMode = z;
        if (z) {
            this.OldCofactorMode = false;
        } else {
            this.OldCofactorMode = z2;
        }
        this.SingleHashMode = z3;
    }
}
