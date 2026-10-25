package org.bouncycastle.p194crypto.agreement.p195ecjpake;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p191cms.CMSAttributeTableGenerator;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;
import org.bouncycastle.p284math.p285ec.AbstractC5820ECPoint;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
public class ECJPAKEParticipant {
    public static final int STATE_INITIALIZED = 0;
    public static final int STATE_KEY_CALCULATED = 50;
    public static final int STATE_ROUND_1_CREATED = 10;
    public static final int STATE_ROUND_1_VALIDATED = 20;
    public static final int STATE_ROUND_2_CREATED = 30;
    public static final int STATE_ROUND_2_VALIDATED = 40;
    public static final int STATE_ROUND_3_CREATED = 60;
    public static final int STATE_ROUND_3_VALIDATED = 70;

    /* renamed from: b */
    private AbstractC5820ECPoint f19164b;

    /* renamed from: digest */
    private final InterfaceC5277Digest f19165digest;

    /* renamed from: ecCurve */
    private AbstractC5817ECCurve.AbstractFp f19166ecCurve;

    /* renamed from: g */
    private AbstractC5820ECPoint f19167g;

    /* renamed from: gx1 */
    private AbstractC5820ECPoint f19168gx1;

    /* renamed from: gx2 */
    private AbstractC5820ECPoint f19169gx2;

    /* renamed from: gx3 */
    private AbstractC5820ECPoint f19170gx3;

    /* renamed from: gx4 */
    private AbstractC5820ECPoint f19171gx4;

    /* renamed from: h */
    private BigInteger f19172h;

    /* renamed from: n */
    private BigInteger f19173n;
    private final String participantId;
    private String partnerParticipantId;
    private char[] password;

    /* renamed from: q */
    private BigInteger f19174q;

    /* renamed from: random */
    private final SecureRandom f19175random;

    /* renamed from: state */
    private int f19176state;

    /* renamed from: x1 */
    private BigInteger f19177x1;

    /* renamed from: x2 */
    private BigInteger f19178x2;

    public ECJPAKEParticipant(String str, char[] cArr) {
        this(str, cArr, ECJPAKECurves.NIST_P256);
    }

    private BigInteger calculateS() {
        try {
            return ECJPAKEUtil.calculateS(this.f19173n, this.password);
        } catch (CryptoException e) {
            throw Exceptions.illegalStateException(e.getMessage(), e);
        }
    }

    public BigInteger calculateKeyingMaterial() {
        int i = this.f19176state;
        if (i >= 50) {
            throw new IllegalStateException("Key already calculated for " + this.participantId);
        }
        if (i < 40) {
            throw new IllegalStateException("Round2 payload must be validated prior to creating key for " + this.participantId);
        }
        BigInteger bigIntegerCalculateS = calculateS();
        C6238Arrays.m18251fill(this.password, (char) 0);
        this.password = null;
        BigInteger bigIntegerCalculateKeyingMaterial = ECJPAKEUtil.calculateKeyingMaterial(this.f19173n, this.f19171gx4, this.f19178x2, bigIntegerCalculateS, this.f19164b);
        this.f19177x1 = null;
        this.f19178x2 = null;
        this.f19164b = null;
        this.f19176state = 50;
        return bigIntegerCalculateKeyingMaterial;
    }

    public ECJPAKERound1Payload createRound1PayloadToSend() {
        if (this.f19176state >= 10) {
            throw new IllegalStateException("Round1 payload already created for " + this.participantId);
        }
        this.f19177x1 = ECJPAKEUtil.generateX1(this.f19173n, this.f19175random);
        this.f19178x2 = ECJPAKEUtil.generateX1(this.f19173n, this.f19175random);
        this.f19168gx1 = ECJPAKEUtil.calculateGx(this.f19167g, this.f19177x1);
        this.f19169gx2 = ECJPAKEUtil.calculateGx(this.f19167g, this.f19178x2);
        ECSchnorrZKP eCSchnorrZKPCalculateZeroKnowledgeProof = ECJPAKEUtil.calculateZeroKnowledgeProof(this.f19167g, this.f19173n, this.f19177x1, this.f19168gx1, this.f19165digest, this.participantId, this.f19175random);
        ECSchnorrZKP eCSchnorrZKPCalculateZeroKnowledgeProof2 = ECJPAKEUtil.calculateZeroKnowledgeProof(this.f19167g, this.f19173n, this.f19178x2, this.f19169gx2, this.f19165digest, this.participantId, this.f19175random);
        this.f19176state = 10;
        return new ECJPAKERound1Payload(this.participantId, this.f19168gx1, this.f19169gx2, eCSchnorrZKPCalculateZeroKnowledgeProof, eCSchnorrZKPCalculateZeroKnowledgeProof2);
    }

    public ECJPAKERound2Payload createRound2PayloadToSend() {
        int i = this.f19176state;
        if (i >= 30) {
            throw new IllegalStateException("Round2 payload already created for " + this.participantId);
        }
        if (i < 20) {
            throw new IllegalStateException("Round1 payload must be validated prior to creating Round2 payload for " + this.participantId);
        }
        AbstractC5820ECPoint abstractC5820ECPointCalculateGA = ECJPAKEUtil.calculateGA(this.f19168gx1, this.f19170gx3, this.f19171gx4);
        BigInteger bigIntegerCalculateX2s = ECJPAKEUtil.calculateX2s(this.f19173n, this.f19178x2, calculateS());
        AbstractC5820ECPoint abstractC5820ECPointCalculateA = ECJPAKEUtil.calculateA(abstractC5820ECPointCalculateGA, bigIntegerCalculateX2s);
        ECSchnorrZKP eCSchnorrZKPCalculateZeroKnowledgeProof = ECJPAKEUtil.calculateZeroKnowledgeProof(abstractC5820ECPointCalculateGA, this.f19173n, bigIntegerCalculateX2s, abstractC5820ECPointCalculateA, this.f19165digest, this.participantId, this.f19175random);
        this.f19176state = 30;
        return new ECJPAKERound2Payload(this.participantId, abstractC5820ECPointCalculateA, eCSchnorrZKPCalculateZeroKnowledgeProof);
    }

    public ECJPAKERound3Payload createRound3PayloadToSend(BigInteger bigInteger) {
        int i = this.f19176state;
        if (i >= 60) {
            throw new IllegalStateException("Round3 payload already created for " + this.participantId);
        }
        if (i >= 50) {
            BigInteger bigIntegerCalculateMacTag = ECJPAKEUtil.calculateMacTag(this.participantId, this.partnerParticipantId, this.f19168gx1, this.f19169gx2, this.f19170gx3, this.f19171gx4, bigInteger, this.f19165digest);
            this.f19176state = 60;
            return new ECJPAKERound3Payload(this.participantId, bigIntegerCalculateMacTag);
        }
        throw new IllegalStateException("Keying material must be calculated prior to creating Round3 payload for " + this.participantId);
    }

    public int getState() {
        return this.f19176state;
    }

    public void validateRound1PayloadReceived(ECJPAKERound1Payload eCJPAKERound1Payload) throws CryptoException {
        if (this.f19176state >= 20) {
            throw new IllegalStateException("Validation already attempted for round1 payload for" + this.participantId);
        }
        this.partnerParticipantId = eCJPAKERound1Payload.getParticipantId();
        this.f19170gx3 = eCJPAKERound1Payload.m15016getGx1();
        this.f19171gx4 = eCJPAKERound1Payload.m15017getGx2();
        ECSchnorrZKP knowledgeProofForX1 = eCJPAKERound1Payload.getKnowledgeProofForX1();
        ECSchnorrZKP knowledgeProofForX2 = eCJPAKERound1Payload.getKnowledgeProofForX2();
        ECJPAKEUtil.validateParticipantIdsDiffer(this.participantId, eCJPAKERound1Payload.getParticipantId());
        ECJPAKEUtil.validateZeroKnowledgeProof(this.f19167g, this.f19170gx3, knowledgeProofForX1, this.f19174q, this.f19173n, this.f19166ecCurve, this.f19172h, eCJPAKERound1Payload.getParticipantId(), this.f19165digest);
        ECJPAKEUtil.validateZeroKnowledgeProof(this.f19167g, this.f19171gx4, knowledgeProofForX2, this.f19174q, this.f19173n, this.f19166ecCurve, this.f19172h, eCJPAKERound1Payload.getParticipantId(), this.f19165digest);
        this.f19176state = 20;
    }

    public void validateRound2PayloadReceived(ECJPAKERound2Payload eCJPAKERound2Payload) throws CryptoException {
        int i = this.f19176state;
        if (i >= 40) {
            throw new IllegalStateException("Validation already attempted for round2 payload for" + this.participantId);
        }
        if (i < 20) {
            throw new IllegalStateException("Round1 payload must be validated prior to validating Round2 payload for " + this.participantId);
        }
        AbstractC5820ECPoint abstractC5820ECPointCalculateGA = ECJPAKEUtil.calculateGA(this.f19170gx3, this.f19168gx1, this.f19169gx2);
        this.f19164b = eCJPAKERound2Payload.m15018getA();
        ECSchnorrZKP knowledgeProofForX2s = eCJPAKERound2Payload.getKnowledgeProofForX2s();
        ECJPAKEUtil.validateParticipantIdsDiffer(this.participantId, eCJPAKERound2Payload.getParticipantId());
        ECJPAKEUtil.validateParticipantIdsEqual(this.partnerParticipantId, eCJPAKERound2Payload.getParticipantId());
        ECJPAKEUtil.validateZeroKnowledgeProof(abstractC5820ECPointCalculateGA, this.f19164b, knowledgeProofForX2s, this.f19174q, this.f19173n, this.f19166ecCurve, this.f19172h, eCJPAKERound2Payload.getParticipantId(), this.f19165digest);
        this.f19176state = 40;
    }

    public void validateRound3PayloadReceived(ECJPAKERound3Payload eCJPAKERound3Payload, BigInteger bigInteger) throws CryptoException {
        int i = this.f19176state;
        if (i >= 70) {
            throw new IllegalStateException("Validation already attempted for round3 payload for" + this.participantId);
        }
        if (i < 50) {
            throw new IllegalStateException("Keying material must be calculated validated prior to validating Round3 payload for " + this.participantId);
        }
        ECJPAKEUtil.validateParticipantIdsDiffer(this.participantId, eCJPAKERound3Payload.getParticipantId());
        ECJPAKEUtil.validateParticipantIdsEqual(this.partnerParticipantId, eCJPAKERound3Payload.getParticipantId());
        ECJPAKEUtil.validateMacTag(this.participantId, this.partnerParticipantId, this.f19168gx1, this.f19169gx2, this.f19170gx3, this.f19171gx4, bigInteger, this.f19165digest, eCJPAKERound3Payload.getMacTag());
        this.f19168gx1 = null;
        this.f19169gx2 = null;
        this.f19170gx3 = null;
        this.f19171gx4 = null;
        this.f19176state = 70;
    }

    public ECJPAKEParticipant(String str, char[] cArr, ECJPAKECurve eCJPAKECurve) {
        this(str, cArr, eCJPAKECurve, SHA256Digest.newInstance(), CryptoServicesRegistrar.getSecureRandom());
    }

    public ECJPAKEParticipant(String str, char[] cArr, ECJPAKECurve eCJPAKECurve, InterfaceC5277Digest interfaceC5277Digest, SecureRandom secureRandom) {
        ECJPAKEUtil.validateNotNull(str, "participantId");
        ECJPAKEUtil.validateNotNull(cArr, "password");
        ECJPAKEUtil.validateNotNull(eCJPAKECurve, "curve params");
        ECJPAKEUtil.validateNotNull(interfaceC5277Digest, CMSAttributeTableGenerator.f18937DIGEST);
        ECJPAKEUtil.validateNotNull(secureRandom, "random");
        if (cArr.length == 0) {
            throw new IllegalArgumentException("Password must not be empty.");
        }
        this.participantId = str;
        this.password = C6238Arrays.m18243copyOf(cArr, cArr.length);
        this.f19166ecCurve = eCJPAKECurve.getCurve();
        this.f19167g = eCJPAKECurve.m15012getG();
        this.f19172h = eCJPAKECurve.m15013getH();
        this.f19173n = eCJPAKECurve.m15014getN();
        this.f19174q = eCJPAKECurve.m15015getQ();
        this.f19165digest = interfaceC5277Digest;
        this.f19175random = secureRandom;
        this.f19176state = 0;
    }
}
