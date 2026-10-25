package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p199digests.SM3Digest;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithID;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p284math.p285ec.ECAlgorithms;
import org.bouncycastle.p284math.p285ec.ECConstants;
import org.bouncycastle.p284math.p285ec.ECFieldElement;
import org.bouncycastle.p284math.p285ec.ECMultiplier;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class SM2Signer implements InterfaceC5282Signer, ECConstants {

    /* renamed from: LOG */
    private static final Logger f21042LOG = Logger.getLogger(SM2Signer.class.getName());

    /* renamed from: digest */
    private final InterfaceC5277Digest f21043digest;

    /* renamed from: ecKey */
    private ECKeyParameters f21044ecKey;
    private ECDomainParameters ecParams;
    private final DSAEncoding encoding;
    private final DSAKCalculator kCalculator;
    private AbstractC5820ECPoint pubPoint;

    /* renamed from: state */
    private int f21045state;

    /* renamed from: z */
    private byte[] f21046z;

    /* renamed from: org.bouncycastle.crypto.signers.SM2Signer$State */
    public static final class C5386State {

        /* renamed from: DATA */
        static final int f21047DATA = 2;

        /* renamed from: INIT */
        static final int f21048INIT = 1;
        static final int UNINITIALIZED = 0;

        private C5386State() {
        }
    }

    public SM2Signer() {
        this(StandardDSAEncoding.INSTANCE, new SM3Digest());
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

    private void checkData() {
        int i = this.f21045state;
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("SM2Signer needs to be initialized");
            }
        } else {
            InterfaceC5277Digest interfaceC5277Digest = this.f21043digest;
            byte[] bArr = this.f21046z;
            interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
            this.f21045state = 2;
        }
    }

    private byte[] digestDoFinal() {
        byte[] bArr = new byte[this.f21043digest.getDigestSize()];
        this.f21043digest.mo14967doFinal(bArr, 0);
        return bArr;
    }

    /* renamed from: getZ */
    private byte[] m15865getZ(byte[] bArr) {
        addUserID(this.f21043digest, bArr);
        addFieldElement(this.f21043digest, this.ecParams.getCurve().m16298getA());
        addFieldElement(this.f21043digest, this.ecParams.getCurve().m16299getB());
        addFieldElement(this.f21043digest, this.ecParams.m15720getG().getAffineXCoord());
        addFieldElement(this.f21043digest, this.ecParams.m15720getG().getAffineYCoord());
        addFieldElement(this.f21043digest, this.pubPoint.getAffineXCoord());
        addFieldElement(this.f21043digest, this.pubPoint.getAffineYCoord());
        return digestDoFinal();
    }

    private boolean verifySignature(BigInteger bigInteger, BigInteger bigInteger2) {
        BigInteger bigIntegerM15723getN = this.ecParams.m15723getN();
        BigInteger bigInteger3 = ECConstants.f22091ONE;
        if (bigInteger.compareTo(bigInteger3) < 0 || bigInteger.compareTo(bigIntegerM15723getN) >= 0) {
            Logger logger = f21042LOG;
            if (logger.isLoggable(Level.FINE)) {
                logger.fine("SM2 signature verification failed: r out of range");
            }
            return false;
        }
        if (bigInteger2.compareTo(bigInteger3) < 0 || bigInteger2.compareTo(bigIntegerM15723getN) >= 0) {
            Logger logger2 = f21042LOG;
            if (logger2.isLoggable(Level.FINE)) {
                logger2.fine("SM2 signature verification failed: s out of range");
            }
            return false;
        }
        BigInteger bigIntegerCalculateE = calculateE(bigIntegerM15723getN, digestDoFinal());
        BigInteger bigIntegerMod = bigInteger.add(bigInteger2).mod(bigIntegerM15723getN);
        if (bigIntegerMod.equals(ECConstants.f22094ZERO)) {
            Logger logger3 = f21042LOG;
            if (logger3.isLoggable(Level.FINE)) {
                logger3.fine("SM2 signature verification failed: t equals zero");
            }
            return false;
        }
        AbstractC5820ECPoint abstractC5820ECPointNormalize = ECAlgorithms.sumOfTwoMultiplies(this.ecParams.m15720getG(), bigInteger2, ((ECPublicKeyParameters) this.f21044ecKey).m15728getQ(), bigIntegerMod).normalize();
        if (!abstractC5820ECPointNormalize.isInfinity()) {
            return bigIntegerCalculateE.add(abstractC5820ECPointNormalize.getAffineXCoord().toBigInteger()).mod(bigIntegerM15723getN).equals(bigInteger);
        }
        Logger logger4 = f21042LOG;
        if (logger4.isLoggable(Level.FINE)) {
            logger4.fine("SM2 signature verification failed: calculated point at infinity");
        }
        return false;
    }

    public BigInteger calculateE(BigInteger bigInteger, byte[] bArr) {
        return new BigInteger(1, bArr);
    }

    public ECMultiplier createBasePointMultiplier() {
        return new FixedPointCombMultiplier();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        checkData();
        byte[] bArrDigestDoFinal = digestDoFinal();
        BigInteger bigIntegerM15723getN = this.ecParams.m15723getN();
        BigInteger bigIntegerCalculateE = calculateE(bigIntegerM15723getN, bArrDigestDoFinal);
        BigInteger bigIntegerM15727getD = ((ECPrivateKeyParameters) this.f21044ecKey).m15727getD();
        ECMultiplier eCMultiplierCreateBasePointMultiplier = createBasePointMultiplier();
        while (true) {
            BigInteger bigIntegerMo15860nextK = this.kCalculator.mo15860nextK();
            BigInteger bigIntegerMod = bigIntegerCalculateE.add(eCMultiplierCreateBasePointMultiplier.multiply(this.ecParams.m15720getG(), bigIntegerMo15860nextK).normalize().getAffineXCoord().toBigInteger()).mod(bigIntegerM15723getN);
            BigInteger bigInteger = ECConstants.f22094ZERO;
            if (!bigIntegerMod.equals(bigInteger) && !bigIntegerMod.add(bigIntegerMo15860nextK).equals(bigIntegerM15723getN)) {
                BigInteger bigIntegerMod2 = BigIntegers.modOddInverse(bigIntegerM15723getN, bigIntegerM15727getD.add(ECConstants.f22091ONE)).multiply(bigIntegerMo15860nextK.subtract(bigIntegerMod.multiply(bigIntegerM15727getD)).mod(bigIntegerM15723getN)).mod(bigIntegerM15723getN);
                if (!bigIntegerMod2.equals(bigInteger)) {
                    try {
                        try {
                            return this.encoding.mo15857encode(this.ecParams.m15723getN(), bigIntegerMod, bigIntegerMod2);
                        } catch (Exception e) {
                            throw new CryptoException("unable to encode signature: " + e.getMessage(), e);
                        }
                    } finally {
                        mo14988reset();
                    }
                }
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        byte[] bArrDecodeStrict;
        AbstractC5820ECPoint abstractC5820ECPointM15728getQ;
        SecureRandom random;
        if (cipherParameters instanceof ParametersWithID) {
            ParametersWithID parametersWithID = (ParametersWithID) cipherParameters;
            CipherParameters parameters = parametersWithID.getParameters();
            byte[] bArrM15800getID = parametersWithID.m15800getID();
            if (bArrM15800getID.length >= 8192) {
                throw new IllegalArgumentException("SM2 user ID must be less than 2^16 bits long");
            }
            bArrDecodeStrict = bArrM15800getID;
            cipherParameters = parameters;
        } else {
            bArrDecodeStrict = C6255Hex.decodeStrict("31323334353637383132333435363738");
        }
        if (z) {
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                CipherParameters parameters2 = parametersWithRandom.getParameters();
                random = parametersWithRandom.getRandom();
                cipherParameters = parameters2;
            } else {
                random = null;
            }
            ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) cipherParameters;
            this.f21044ecKey = eCPrivateKeyParameters;
            this.ecParams = eCPrivateKeyParameters.getParameters();
            BigInteger bigIntegerM15727getD = eCPrivateKeyParameters.m15727getD();
            BigInteger bigIntegerM15723getN = this.ecParams.m15723getN();
            BigInteger bigInteger = ECConstants.f22091ONE;
            if (bigIntegerM15727getD.compareTo(bigInteger) < 0 || bigIntegerM15727getD.compareTo(bigIntegerM15723getN.subtract(bigInteger)) >= 0) {
                throw new IllegalArgumentException("SM2 private key out of range");
            }
            this.kCalculator.mo15859init(bigIntegerM15723getN, CryptoServicesRegistrar.getSecureRandom(random));
            abstractC5820ECPointM15728getQ = createBasePointMultiplier().multiply(this.ecParams.m15720getG(), bigIntegerM15727getD).normalize();
        } else {
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) cipherParameters;
            this.f21044ecKey = eCPublicKeyParameters;
            this.ecParams = eCPublicKeyParameters.getParameters();
            abstractC5820ECPointM15728getQ = eCPublicKeyParameters.m15728getQ();
        }
        this.pubPoint = abstractC5820ECPointM15728getQ;
        CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties("ECNR", this.f21044ecKey, z));
        this.f21043digest.mo14968reset();
        this.f21046z = m15865getZ(bArrDecodeStrict);
        this.f21045state = 1;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        int i = this.f21045state;
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("SM2Signer needs to be initialized");
            }
            this.f21043digest.mo14968reset();
            this.f21045state = 1;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        checkData();
        this.f21043digest.mo14969update(b);
    }

    public SM2Signer(InterfaceC5277Digest interfaceC5277Digest) {
        this(StandardDSAEncoding.INSTANCE, interfaceC5277Digest);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        checkData();
        this.f21043digest.mo14970update(bArr, i, i2);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        checkData();
        try {
            BigInteger[] bigIntegerArrMo15856decode = this.encoding.mo15856decode(this.ecParams.m15723getN(), bArr);
            return verifySignature(bigIntegerArrMo15856decode[0], bigIntegerArrMo15856decode[1]);
        } catch (Exception e) {
            Logger logger = f21042LOG;
            Level level = Level.FINE;
            if (logger.isLoggable(level)) {
                logger.log(level, "SM2 signature verification failed due to exception", (Throwable) e);
            }
            return false;
        } finally {
            mo14988reset();
        }
    }

    public SM2Signer(DSAEncoding dSAEncoding) {
        this.kCalculator = new RandomDSAKCalculator();
        this.f21045state = 0;
        this.encoding = dSAEncoding;
        this.f21043digest = new SM3Digest();
    }

    public SM2Signer(DSAEncoding dSAEncoding, InterfaceC5277Digest interfaceC5277Digest) {
        this.kCalculator = new RandomDSAKCalculator();
        this.f21045state = 0;
        this.encoding = dSAEncoding;
        this.f21043digest = interfaceC5277Digest;
    }
}
