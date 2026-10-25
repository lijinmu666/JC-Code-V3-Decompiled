package org.bouncycastle.p194crypto.p201engines;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InvalidCipherTextException;
import org.bouncycastle.p194crypto.constraints.ConstraintUtils;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p199digests.SM3Digest;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECMultiplier;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class SM2Engine {
    private int curveLength;

    /* renamed from: digest */
    private final InterfaceC5277Digest f20065digest;

    /* renamed from: ecKey */
    private ECKeyParameters f20066ecKey;
    private ECDomainParameters ecParams;
    private boolean forEncryption;

    /* renamed from: mode */
    private final EnumC5341Mode f20067mode;

    /* renamed from: random */
    private SecureRandom f20068random;

    /* renamed from: org.bouncycastle.crypto.engines.SM2Engine$Mode */
    public enum EnumC5341Mode {
        C1C2C3,
        C1C3C2
    }

    public SM2Engine() {
        this(new SM3Digest());
    }

    private void addFieldElement(InterfaceC5277Digest interfaceC5277Digest, ECFieldElement eCFieldElement) {
        byte[] bArrAsUnsignedByteArray = BigIntegers.asUnsignedByteArray(this.curveLength, eCFieldElement.toBigInteger());
        interfaceC5277Digest.mo14970update(bArrAsUnsignedByteArray, 0, bArrAsUnsignedByteArray.length);
    }

    /* renamed from: decrypt */
    private byte[] m15391decrypt(byte[] bArr, int i, int i2) throws InvalidCipherTextException {
        int i3;
        int i4 = (this.curveLength * 2) + 1;
        byte[] bArr2 = new byte[i4];
        System.arraycopy(bArr, i, bArr2, 0, i4);
        AbstractC5820ECPoint abstractC5820ECPointDecodePoint = this.ecParams.getCurve().decodePoint(bArr2);
        if (abstractC5820ECPointDecodePoint.multiply(this.ecParams.m15721getH()).isInfinity()) {
            throw new InvalidCipherTextException("[h]C1 at infinity");
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = abstractC5820ECPointDecodePoint.multiply(((ECPrivateKeyParameters) this.f20066ecKey).m15727getD()).normalize();
        int digestSize = this.f20065digest.getDigestSize();
        int i5 = (i2 - i4) - digestSize;
        byte[] bArr3 = new byte[i5];
        EnumC5341Mode enumC5341Mode = this.f20067mode;
        EnumC5341Mode enumC5341Mode2 = EnumC5341Mode.C1C3C2;
        if (enumC5341Mode == enumC5341Mode2) {
            System.arraycopy(bArr, i + i4 + digestSize, bArr3, 0, i5);
        } else {
            System.arraycopy(bArr, i + i4, bArr3, 0, i5);
        }
        m15393kdf(this.f20065digest, abstractC5820ECPointNormalize, bArr3);
        int digestSize2 = this.f20065digest.getDigestSize();
        byte[] bArr4 = new byte[digestSize2];
        addFieldElement(this.f20065digest, abstractC5820ECPointNormalize.getAffineXCoord());
        this.f20065digest.mo14970update(bArr3, 0, i5);
        addFieldElement(this.f20065digest, abstractC5820ECPointNormalize.getAffineYCoord());
        this.f20065digest.mo14967doFinal(bArr4, 0);
        if (this.f20067mode == enumC5341Mode2) {
            i3 = 0;
            for (int i6 = 0; i6 != digestSize2; i6++) {
                i3 |= bArr4[i6] ^ bArr[(i + i4) + i6];
            }
        } else {
            int i7 = 0;
            for (int i8 = 0; i8 != digestSize2; i8++) {
                i7 |= bArr4[i8] ^ bArr[((i + i4) + i5) + i8];
            }
            i3 = i7;
        }
        C6238Arrays.m18249fill(bArr2, (byte) 0);
        C6238Arrays.m18249fill(bArr4, (byte) 0);
        if (i3 == 0) {
            return bArr3;
        }
        C6238Arrays.m18249fill(bArr3, (byte) 0);
        throw new InvalidCipherTextException("invalid cipher text");
    }

    /* renamed from: encrypt */
    private byte[] m15392encrypt(byte[] bArr, int i, int i2) {
        byte[] encoded;
        AbstractC5820ECPoint abstractC5820ECPointNormalize;
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        ECMultiplier eCMultiplierCreateBasePointMultiplier = createBasePointMultiplier();
        do {
            BigInteger bigIntegerM15394nextK = m15394nextK();
            encoded = eCMultiplierCreateBasePointMultiplier.multiply(this.ecParams.m15720getG(), bigIntegerM15394nextK).normalize().getEncoded(false);
            abstractC5820ECPointNormalize = ((ECPublicKeyParameters) this.f20066ecKey).m15728getQ().multiply(bigIntegerM15394nextK).normalize();
            m15393kdf(this.f20065digest, abstractC5820ECPointNormalize, bArr2);
        } while (notEncrypted(bArr2, bArr, i));
        byte[] bArr3 = new byte[this.f20065digest.getDigestSize()];
        addFieldElement(this.f20065digest, abstractC5820ECPointNormalize.getAffineXCoord());
        this.f20065digest.mo14970update(bArr, i, i2);
        addFieldElement(this.f20065digest, abstractC5820ECPointNormalize.getAffineYCoord());
        this.f20065digest.mo14967doFinal(bArr3, 0);
        return this.f20067mode.ordinal() != 1 ? C6238Arrays.concatenate(encoded, bArr2, bArr3) : C6238Arrays.concatenate(encoded, bArr3, bArr2);
    }

    /* renamed from: kdf */
    private void m15393kdf(InterfaceC5277Digest interfaceC5277Digest, AbstractC5820ECPoint abstractC5820ECPoint, byte[] bArr) {
        Memoable memoable;
        Memoable memoableMo14823copy;
        int digestSize = interfaceC5277Digest.getDigestSize();
        byte[] bArr2 = new byte[Math.max(4, digestSize)];
        if (interfaceC5277Digest instanceof Memoable) {
            addFieldElement(interfaceC5277Digest, abstractC5820ECPoint.getAffineXCoord());
            addFieldElement(interfaceC5277Digest, abstractC5820ECPoint.getAffineYCoord());
            memoable = (Memoable) interfaceC5277Digest;
            memoableMo14823copy = memoable.mo14823copy();
        } else {
            memoable = null;
            memoableMo14823copy = null;
        }
        int i = 0;
        int i2 = 0;
        while (i < bArr.length) {
            if (memoable != null) {
                memoable.mo14824reset(memoableMo14823copy);
            } else {
                addFieldElement(interfaceC5277Digest, abstractC5820ECPoint.getAffineXCoord());
                addFieldElement(interfaceC5277Digest, abstractC5820ECPoint.getAffineYCoord());
            }
            i2++;
            AbstractC6245Pack.intToBigEndian(i2, bArr2, 0);
            interfaceC5277Digest.mo14970update(bArr2, 0, 4);
            interfaceC5277Digest.mo14967doFinal(bArr2, 0);
            int iMin = Math.min(digestSize, bArr.length - i);
            C6240Bytes.m18280xorTo(iMin, bArr2, 0, bArr, i);
            i += iMin;
        }
    }

    /* renamed from: nextK */
    private BigInteger m15394nextK() {
        int iBitLength = this.ecParams.m15723getN().bitLength();
        while (true) {
            BigInteger bigIntegerCreateRandomBigInteger = BigIntegers.createRandomBigInteger(iBitLength, this.f20068random);
            if (!bigIntegerCreateRandomBigInteger.equals(BigIntegers.f24192ZERO) && bigIntegerCreateRandomBigInteger.compareTo(this.ecParams.m15723getN()) < 0) {
                return bigIntegerCreateRandomBigInteger;
            }
        }
    }

    private boolean notEncrypted(byte[] bArr, byte[] bArr2, int i) {
        for (int i2 = 0; i2 != bArr.length; i2++) {
            if (bArr[i2] != bArr2[i + i2]) {
                return false;
            }
        }
        return true;
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    public int getOutputSize(int i) {
        return (this.curveLength * 2) + 1 + i + this.f20065digest.getDigestSize();
    }

    /* renamed from: init */
    public void m15395init(boolean z, CipherParameters cipherParameters) {
        this.forEncryption = z;
        if (z) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            ECKeyParameters eCKeyParameters = (ECKeyParameters) parametersWithRandom.getParameters();
            this.f20066ecKey = eCKeyParameters;
            this.ecParams = eCKeyParameters.getParameters();
            if (((ECPublicKeyParameters) this.f20066ecKey).m15728getQ().multiply(this.ecParams.m15721getH()).isInfinity()) {
                throw new IllegalArgumentException("invalid key: [h]Q at infinity");
            }
            this.f20068random = parametersWithRandom.getRandom();
        } else {
            ECKeyParameters eCKeyParameters2 = (ECKeyParameters) cipherParameters;
            this.f20066ecKey = eCKeyParameters2;
            this.ecParams = eCKeyParameters2.getParameters();
        }
        this.curveLength = this.ecParams.getCurve().getFieldElementEncodingLength();
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties("SM2", ConstraintUtils.bitsOfSecurityFor(this.ecParams.getCurve()), this.f20066ecKey, C5342Utils.getPurpose(z)));
    }

    public byte[] processBlock(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length || i2 == 0) {
            throw new DataLengthException("input buffer too short");
        }
        return this.forEncryption ? m15392encrypt(bArr, i, i2) : m15391decrypt(bArr, i, i2);
    }

    public SM2Engine(InterfaceC5277Digest interfaceC5277Digest) {
        this(interfaceC5277Digest, EnumC5341Mode.C1C2C3);
    }

    public SM2Engine(InterfaceC5277Digest interfaceC5277Digest, EnumC5341Mode enumC5341Mode) {
        if (enumC5341Mode == null) {
            throw new IllegalArgumentException("mode cannot be NULL");
        }
        this.f20065digest = interfaceC5277Digest;
        this.f20067mode = enumC5341Mode;
    }

    public SM2Engine(EnumC5341Mode enumC5341Mode) {
        this(new SM3Digest(), enumC5341Mode);
    }
}
