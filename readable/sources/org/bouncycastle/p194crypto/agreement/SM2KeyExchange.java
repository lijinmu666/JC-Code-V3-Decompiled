package org.bouncycastle.p194crypto.agreement;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SM3Digest;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithID;
import org.bouncycastle.p194crypto.p213params.SM2KeyExchangePrivateParameters;
import org.bouncycastle.p194crypto.p213params.SM2KeyExchangePublicParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class SM2KeyExchange {

    /* renamed from: digest */
    private final InterfaceC5277Digest f19158digest;
    private ECDomainParameters ecParams;
    private ECPrivateKeyParameters ephemeralKey;
    private AbstractC5820ECPoint ephemeralPubPoint;
    private boolean initiator;
    private ECPrivateKeyParameters staticKey;
    private AbstractC5820ECPoint staticPubPoint;

    /* renamed from: userID */
    private byte[] f19159userID;

    /* renamed from: w */
    private int f19160w;

    public SM2KeyExchange() {
        this(new SM3Digest());
    }

    /* renamed from: S1 */
    private byte[] m15004S1(InterfaceC5277Digest interfaceC5277Digest, AbstractC5820ECPoint abstractC5820ECPoint, byte[] bArr) {
        interfaceC5277Digest.mo14969update((byte) 2);
        addFieldElement(interfaceC5277Digest, abstractC5820ECPoint.getAffineYCoord());
        interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
        return digestDoFinal();
    }

    /* renamed from: S2 */
    private byte[] m15005S2(InterfaceC5277Digest interfaceC5277Digest, AbstractC5820ECPoint abstractC5820ECPoint, byte[] bArr) {
        interfaceC5277Digest.mo14969update((byte) 3);
        addFieldElement(interfaceC5277Digest, abstractC5820ECPoint.getAffineYCoord());
        interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
        return digestDoFinal();
    }

    private void addFieldElement(InterfaceC5277Digest interfaceC5277Digest, ECFieldElement eCFieldElement) {
        byte[] encoded = eCFieldElement.getEncoded();
        interfaceC5277Digest.mo14970update(encoded, 0, encoded.length);
    }

    private void addUserID(InterfaceC5277Digest interfaceC5277Digest, byte[] bArr) {
        int length = bArr.length * 8;
        interfaceC5277Digest.mo14969update((byte) (length >>> 8));
        interfaceC5277Digest.mo14969update((byte) length);
        interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
    }

    private byte[] calculateInnerHash(InterfaceC5277Digest interfaceC5277Digest, AbstractC5820ECPoint abstractC5820ECPoint, byte[] bArr, byte[] bArr2, AbstractC5820ECPoint abstractC5820ECPoint2, AbstractC5820ECPoint abstractC5820ECPoint3) {
        addFieldElement(interfaceC5277Digest, abstractC5820ECPoint.getAffineXCoord());
        interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
        interfaceC5277Digest.mo14970update(bArr2, 0, bArr2.length);
        addFieldElement(interfaceC5277Digest, abstractC5820ECPoint2.getAffineXCoord());
        addFieldElement(interfaceC5277Digest, abstractC5820ECPoint2.getAffineYCoord());
        addFieldElement(interfaceC5277Digest, abstractC5820ECPoint3.getAffineXCoord());
        addFieldElement(interfaceC5277Digest, abstractC5820ECPoint3.getAffineYCoord());
        return digestDoFinal();
    }

    private AbstractC5820ECPoint calculateU(SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters) {
        ECDomainParameters parameters = this.staticKey.getParameters();
        AbstractC5820ECPoint abstractC5820ECPointCleanPoint = ECAlgorithms.cleanPoint(parameters.getCurve(), sM2KeyExchangePublicParameters.getStaticPublicKey().m15728getQ());
        AbstractC5820ECPoint abstractC5820ECPointCleanPoint2 = ECAlgorithms.cleanPoint(parameters.getCurve(), sM2KeyExchangePublicParameters.getEphemeralPublicKey().m15728getQ());
        BigInteger bigIntegerM15008reduce = m15008reduce(this.ephemeralPubPoint.getAffineXCoord().toBigInteger());
        BigInteger bigIntegerM15008reduce2 = m15008reduce(abstractC5820ECPointCleanPoint2.getAffineXCoord().toBigInteger());
        BigInteger bigIntegerMod = this.ecParams.m15721getH().multiply(this.staticKey.m15727getD().add(bigIntegerM15008reduce.multiply(this.ephemeralKey.m15727getD()))).mod(this.ecParams.m15723getN());
        return ECAlgorithms.sumOfTwoMultiplies(abstractC5820ECPointCleanPoint, bigIntegerMod, abstractC5820ECPointCleanPoint2, bigIntegerMod.multiply(bigIntegerM15008reduce2).mod(this.ecParams.m15723getN())).normalize();
    }

    private static byte[] checkUserID(byte[] bArr) {
        if (bArr.length < 8192) {
            return bArr;
        }
        throw new IllegalArgumentException("SM2 user ID must be less than 2^16 bits long");
    }

    private byte[] digestDoFinal() {
        byte[] bArr = new byte[this.f19158digest.getDigestSize()];
        this.f19158digest.mo14967doFinal(bArr, 0);
        return bArr;
    }

    /* renamed from: getZ */
    private byte[] m15006getZ(InterfaceC5277Digest interfaceC5277Digest, byte[] bArr, AbstractC5820ECPoint abstractC5820ECPoint) {
        addUserID(interfaceC5277Digest, bArr);
        addFieldElement(interfaceC5277Digest, this.ecParams.getCurve().m16298getA());
        addFieldElement(interfaceC5277Digest, this.ecParams.getCurve().m16299getB());
        addFieldElement(interfaceC5277Digest, this.ecParams.m15720getG().getAffineXCoord());
        addFieldElement(interfaceC5277Digest, this.ecParams.m15720getG().getAffineYCoord());
        addFieldElement(interfaceC5277Digest, abstractC5820ECPoint.getAffineXCoord());
        addFieldElement(interfaceC5277Digest, abstractC5820ECPoint.getAffineYCoord());
        return digestDoFinal();
    }

    /* renamed from: kdf */
    private byte[] m15007kdf(AbstractC5820ECPoint abstractC5820ECPoint, byte[] bArr, byte[] bArr2, int i) {
        Memoable memoable;
        Memoable memoableMo14823copy;
        int digestSize = this.f19158digest.getDigestSize();
        byte[] bArr3 = new byte[Math.max(4, digestSize)];
        int i2 = (i + 7) / 8;
        byte[] bArr4 = new byte[i2];
        InterfaceC5277Digest interfaceC5277Digest = this.f19158digest;
        if (interfaceC5277Digest instanceof Memoable) {
            addFieldElement(interfaceC5277Digest, abstractC5820ECPoint.getAffineXCoord());
            addFieldElement(this.f19158digest, abstractC5820ECPoint.getAffineYCoord());
            this.f19158digest.mo14970update(bArr, 0, bArr.length);
            this.f19158digest.mo14970update(bArr2, 0, bArr2.length);
            memoable = (Memoable) this.f19158digest;
            memoableMo14823copy = memoable.mo14823copy();
        } else {
            memoable = null;
            memoableMo14823copy = null;
        }
        int i3 = 0;
        int i4 = 0;
        while (i3 < i2) {
            if (memoable != null) {
                memoable.mo14824reset(memoableMo14823copy);
            } else {
                addFieldElement(this.f19158digest, abstractC5820ECPoint.getAffineXCoord());
                addFieldElement(this.f19158digest, abstractC5820ECPoint.getAffineYCoord());
                this.f19158digest.mo14970update(bArr, 0, bArr.length);
                this.f19158digest.mo14970update(bArr2, 0, bArr2.length);
            }
            i4++;
            AbstractC6245Pack.intToBigEndian(i4, bArr3, 0);
            this.f19158digest.mo14970update(bArr3, 0, 4);
            this.f19158digest.mo14967doFinal(bArr3, 0);
            int iMin = Math.min(digestSize, i2 - i3);
            System.arraycopy(bArr3, 0, bArr4, i3, iMin);
            i3 += iMin;
        }
        return bArr4;
    }

    /* renamed from: reduce */
    private BigInteger m15008reduce(BigInteger bigInteger) {
        return bigInteger.and(BigInteger.valueOf(1L).shiftLeft(this.f19160w).subtract(BigInteger.valueOf(1L))).setBit(this.f19160w);
    }

    public byte[] calculateKey(int i, CipherParameters cipherParameters) {
        SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters;
        byte[] bArrCheckUserID;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) parametersWithID.getParameters();
            bArrCheckUserID = checkUserID(parametersWithID.m15800getID());
        } else {
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) cipherParameters;
            bArrCheckUserID = new byte[0];
        }
        byte[] bArrM15006getZ = m15006getZ(this.f19158digest, this.f19159userID, this.staticPubPoint);
        byte[] bArrM15006getZ2 = m15006getZ(this.f19158digest, bArrCheckUserID, sM2KeyExchangePublicParameters.getStaticPublicKey().m15728getQ());
        AbstractC5820ECPoint abstractC5820ECPointCalculateU = calculateU(sM2KeyExchangePublicParameters);
        return this.initiator ? m15007kdf(abstractC5820ECPointCalculateU, bArrM15006getZ, bArrM15006getZ2, i) : m15007kdf(abstractC5820ECPointCalculateU, bArrM15006getZ2, bArrM15006getZ, i);
    }

    public byte[][] calculateKeyWithConfirmation(int i, byte[] bArr, CipherParameters cipherParameters) {
        SM2KeyExchangePublicParameters sM2KeyExchangePublicParameters;
        byte[] bArrCheckUserID;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) parametersWithID.getParameters();
            bArrCheckUserID = checkUserID(parametersWithID.m15800getID());
        } else {
            sM2KeyExchangePublicParameters = (SM2KeyExchangePublicParameters) cipherParameters;
            bArrCheckUserID = new byte[0];
        }
        if (this.initiator && bArr == null) {
            throw new IllegalArgumentException("if initiating, confirmationTag must be set");
        }
        byte[] bArrM15006getZ = m15006getZ(this.f19158digest, this.f19159userID, this.staticPubPoint);
        byte[] bArrM15006getZ2 = m15006getZ(this.f19158digest, bArrCheckUserID, sM2KeyExchangePublicParameters.getStaticPublicKey().m15728getQ());
        AbstractC5820ECPoint abstractC5820ECPointCalculateU = calculateU(sM2KeyExchangePublicParameters);
        if (!this.initiator) {
            byte[] bArrM15007kdf = m15007kdf(abstractC5820ECPointCalculateU, bArrM15006getZ2, bArrM15006getZ, i);
            byte[] bArrCalculateInnerHash = calculateInnerHash(this.f19158digest, abstractC5820ECPointCalculateU, bArrM15006getZ2, bArrM15006getZ, sM2KeyExchangePublicParameters.getEphemeralPublicKey().m15728getQ(), this.ephemeralPubPoint);
            return new byte[][]{bArrM15007kdf, m15004S1(this.f19158digest, abstractC5820ECPointCalculateU, bArrCalculateInnerHash), m15005S2(this.f19158digest, abstractC5820ECPointCalculateU, bArrCalculateInnerHash)};
        }
        byte[] bArrM15007kdf2 = m15007kdf(abstractC5820ECPointCalculateU, bArrM15006getZ, bArrM15006getZ2, i);
        byte[] bArrCalculateInnerHash2 = calculateInnerHash(this.f19158digest, abstractC5820ECPointCalculateU, bArrM15006getZ, bArrM15006getZ2, this.ephemeralPubPoint, sM2KeyExchangePublicParameters.getEphemeralPublicKey().m15728getQ());
        if (C6238Arrays.constantTimeAreEqual(m15004S1(this.f19158digest, abstractC5820ECPointCalculateU, bArrCalculateInnerHash2), bArr)) {
            return new byte[][]{bArrM15007kdf2, m15005S2(this.f19158digest, abstractC5820ECPointCalculateU, bArrCalculateInnerHash2)};
        }
        throw new IllegalStateException("confirmation tag mismatch");
    }

    /* renamed from: init */
    public void m15009init(CipherParameters cipherParameters) {
        SM2KeyExchangePrivateParameters sM2KeyExchangePrivateParameters;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            sM2KeyExchangePrivateParameters = (SM2KeyExchangePrivateParameters) parametersWithID.getParameters();
            this.f19159userID = checkUserID(parametersWithID.m15800getID());
        } else {
            sM2KeyExchangePrivateParameters = (SM2KeyExchangePrivateParameters) cipherParameters;
            this.f19159userID = new byte[0];
        }
        this.initiator = sM2KeyExchangePrivateParameters.isInitiator();
        this.staticKey = sM2KeyExchangePrivateParameters.getStaticPrivateKey();
        this.ephemeralKey = sM2KeyExchangePrivateParameters.getEphemeralPrivateKey();
        this.ecParams = this.staticKey.getParameters();
        this.staticPubPoint = sM2KeyExchangePrivateParameters.getStaticPublicPoint();
        this.ephemeralPubPoint = sM2KeyExchangePrivateParameters.getEphemeralPublicPoint();
        this.f19160w = (this.ecParams.getCurve().getFieldSize() / 2) - 1;
        CryptoServicesRegistrar.checkConstraints(C5285Utils.getDefaultProperties("SM2KE", this.staticKey));
    }

    public SM2KeyExchange(InterfaceC5277Digest interfaceC5277Digest) {
        this.f19158digest = interfaceC5277Digest;
    }
}
