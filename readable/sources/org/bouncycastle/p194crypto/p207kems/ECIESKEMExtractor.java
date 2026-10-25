package org.bouncycastle.p194crypto.p207kems;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.EncapsulatedSecretExtractor;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;

/* loaded from: classes2.dex */
public class ECIESKEMExtractor implements EncapsulatedSecretExtractor {
    private boolean CofactorMode;
    private boolean OldCofactorMode;
    private boolean SingleHashMode;

    /* renamed from: decKey */
    private final ECPrivateKeyParameters f20365decKey;

    /* renamed from: kdf */
    private DerivationFunction f20366kdf;

    /* renamed from: keyLen */
    private int f20367keyLen;

    public ECIESKEMExtractor(ECPrivateKeyParameters eCPrivateKeyParameters, int i, DerivationFunction derivationFunction) {
        this.f20365decKey = eCPrivateKeyParameters;
        this.f20367keyLen = i;
        this.f20366kdf = derivationFunction;
        this.CofactorMode = false;
        this.OldCofactorMode = false;
        this.SingleHashMode = false;
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public byte[] extractSecret(byte[] bArr) {
        ECPrivateKeyParameters eCPrivateKeyParameters = this.f20365decKey;
        ECDomainParameters parameters = eCPrivateKeyParameters.getParameters();
        AbstractC5817ECCurve curve = parameters.getCurve();
        BigInteger bigIntegerM15723getN = parameters.m15723getN();
        BigInteger bigIntegerM15721getH = parameters.m15721getH();
        AbstractC5820ECPoint abstractC5820ECPointDecodePoint = curve.decodePoint(bArr);
        if (this.CofactorMode || this.OldCofactorMode) {
            abstractC5820ECPointDecodePoint = abstractC5820ECPointDecodePoint.multiply(bigIntegerM15721getH);
        }
        BigInteger bigIntegerM15727getD = eCPrivateKeyParameters.m15727getD();
        if (this.CofactorMode) {
            bigIntegerM15727getD = bigIntegerM15727getD.multiply(parameters.m15722getHInv()).mod(bigIntegerM15723getN);
        }
        return ECIESKEMGenerator.deriveKey(this.SingleHashMode, this.f20366kdf, this.f20367keyLen, bArr, abstractC5820ECPointDecodePoint.multiply(bigIntegerM15727getD).normalize().getAffineXCoord().getEncoded());
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretExtractor
    public int getEncapsulationLength() {
        return this.f20365decKey.getParameters().getCurve().getAffinePointEncodingLength(false);
    }

    public ECIESKEMExtractor(ECPrivateKeyParameters eCPrivateKeyParameters, int i, DerivationFunction derivationFunction, boolean z, boolean z2, boolean z3) {
        this.f20365decKey = eCPrivateKeyParameters;
        this.f20367keyLen = i;
        this.f20366kdf = derivationFunction;
        this.CofactorMode = z;
        if (z) {
            this.OldCofactorMode = false;
        } else {
            this.OldCofactorMode = z2;
        }
        this.SingleHashMode = z3;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("ECIESKem", ConstraintUtils.bitsOfSecurityFor(eCPrivateKeyParameters.getParameters().getCurve()), eCPrivateKeyParameters, CryptoServicePurpose.DECRYPTION));
    }
}
