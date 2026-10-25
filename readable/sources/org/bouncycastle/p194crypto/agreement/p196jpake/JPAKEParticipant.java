package org.bouncycastle.p194crypto.agreement.p196jpake;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.bouncycastle.p191cms.CMSAttributeTableGenerator;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
public class JPAKEParticipant {
    public static final int STATE_INITIALIZED = 0;
    public static final int STATE_KEY_CALCULATED = 50;
    public static final int STATE_ROUND_1_CREATED = 10;
    public static final int STATE_ROUND_1_VALIDATED = 20;
    public static final int STATE_ROUND_2_CREATED = 30;
    public static final int STATE_ROUND_2_VALIDATED = 40;
    public static final int STATE_ROUND_3_CREATED = 60;
    public static final int STATE_ROUND_3_VALIDATED = 70;

    /* renamed from: b */
    private BigInteger f19187b;

    /* renamed from: digest */
    private final InterfaceC5277Digest f19188digest;

    /* renamed from: g */
    private final BigInteger f19189g;

    /* renamed from: gx1 */
    private BigInteger f19190gx1;

    /* renamed from: gx2 */
    private BigInteger f19191gx2;

    /* renamed from: gx3 */
    private BigInteger f19192gx3;

    /* renamed from: gx4 */
    private BigInteger f19193gx4;

    /* renamed from: p */
    private final BigInteger f19194p;
    private final String participantId;
    private String partnerParticipantId;
    private char[] password;

    /* renamed from: q */
    private final BigInteger f19195q;

    /* renamed from: random */
    private final SecureRandom f19196random;

    /* renamed from: state */
    private int f19197state;

    /* renamed from: x1 */
    private BigInteger f19198x1;

    /* renamed from: x2 */
    private BigInteger f19199x2;

    public JPAKEParticipant(String str, char[] cArr) {
        this(str, cArr, JPAKEPrimeOrderGroups.NIST_3072);
    }

    private BigInteger calculateS() {
        try {
            return JPAKEUtil.calculateS(this.f19195q, this.password);
        } catch (CryptoException e) {
            throw Exceptions.illegalStateException(e.getMessage(), e);
        }
    }

    public BigInteger calculateKeyingMaterial() {
        int i = this.f19197state;
        if (i >= 50) {
            throw new IllegalStateException("Key already calculated for " + this.participantId);
        }
        if (i < 40) {
            throw new IllegalStateException("Round2 payload must be validated prior to creating key for " + this.participantId);
        }
        BigInteger bigIntegerCalculateS = calculateS();
        C6238Arrays.m18251fill(this.password, (char) 0);
        this.password = null;
        BigInteger bigIntegerCalculateKeyingMaterial = JPAKEUtil.calculateKeyingMaterial(this.f19194p, this.f19195q, this.f19193gx4, this.f19199x2, bigIntegerCalculateS, this.f19187b);
        this.f19198x1 = null;
        this.f19199x2 = null;
        this.f19187b = null;
        this.f19197state = 50;
        return bigIntegerCalculateKeyingMaterial;
    }

    public JPAKERound1Payload createRound1PayloadToSend() {
        if (this.f19197state >= 10) {
            throw new IllegalStateException("Round1 payload already created for " + this.participantId);
        }
        this.f19198x1 = JPAKEUtil.generateX1(this.f19195q, this.f19196random);
        this.f19199x2 = JPAKEUtil.generateX2(this.f19195q, this.f19196random);
        this.f19190gx1 = JPAKEUtil.calculateGx(this.f19194p, this.f19189g, this.f19198x1);
        this.f19191gx2 = JPAKEUtil.calculateGx(this.f19194p, this.f19189g, this.f19199x2);
        BigInteger[] bigIntegerArrCalculateZeroKnowledgeProof = JPAKEUtil.calculateZeroKnowledgeProof(this.f19194p, this.f19195q, this.f19189g, this.f19190gx1, this.f19198x1, this.participantId, this.f19188digest, this.f19196random);
        BigInteger[] bigIntegerArrCalculateZeroKnowledgeProof2 = JPAKEUtil.calculateZeroKnowledgeProof(this.f19194p, this.f19195q, this.f19189g, this.f19191gx2, this.f19199x2, this.participantId, this.f19188digest, this.f19196random);
        this.f19197state = 10;
        return new JPAKERound1Payload(this.participantId, this.f19190gx1, this.f19191gx2, bigIntegerArrCalculateZeroKnowledgeProof, bigIntegerArrCalculateZeroKnowledgeProof2);
    }

    public JPAKERound2Payload createRound2PayloadToSend() {
        int i = this.f19197state;
        if (i >= 30) {
            throw new IllegalStateException("Round2 payload already created for " + this.participantId);
        }
        if (i < 20) {
            throw new IllegalStateException("Round1 payload must be validated prior to creating Round2 payload for " + this.participantId);
        }
        BigInteger bigIntegerCalculateGA = JPAKEUtil.calculateGA(this.f19194p, this.f19190gx1, this.f19192gx3, this.f19193gx4);
        BigInteger bigIntegerCalculateX2s = JPAKEUtil.calculateX2s(this.f19195q, this.f19199x2, calculateS());
        BigInteger bigIntegerCalculateA = JPAKEUtil.calculateA(this.f19194p, this.f19195q, bigIntegerCalculateGA, bigIntegerCalculateX2s);
        BigInteger[] bigIntegerArrCalculateZeroKnowledgeProof = JPAKEUtil.calculateZeroKnowledgeProof(this.f19194p, this.f19195q, bigIntegerCalculateGA, bigIntegerCalculateA, bigIntegerCalculateX2s, this.participantId, this.f19188digest, this.f19196random);
        this.f19197state = 30;
        return new JPAKERound2Payload(this.participantId, bigIntegerCalculateA, bigIntegerArrCalculateZeroKnowledgeProof);
    }

    public JPAKERound3Payload createRound3PayloadToSend(BigInteger bigInteger) {
        int i = this.f19197state;
        if (i >= 60) {
            throw new IllegalStateException("Round3 payload already created for " + this.participantId);
        }
        if (i >= 50) {
            BigInteger bigIntegerCalculateMacTag = JPAKEUtil.calculateMacTag(this.participantId, this.partnerParticipantId, this.f19190gx1, this.f19191gx2, this.f19192gx3, this.f19193gx4, bigInteger, this.f19188digest);
            this.f19197state = 60;
            return new JPAKERound3Payload(this.participantId, bigIntegerCalculateMacTag);
        }
        throw new IllegalStateException("Keying material must be calculated prior to creating Round3 payload for " + this.participantId);
    }

    public int getState() {
        return this.f19197state;
    }

    public void validateRound1PayloadReceived(JPAKERound1Payload jPAKERound1Payload) throws CryptoException {
        if (this.f19197state >= 20) {
            throw new IllegalStateException("Validation already attempted for round1 payload for" + this.participantId);
        }
        this.partnerParticipantId = jPAKERound1Payload.getParticipantId();
        this.f19192gx3 = jPAKERound1Payload.m15024getGx1();
        this.f19193gx4 = jPAKERound1Payload.m15025getGx2();
        BigInteger[] knowledgeProofForX1 = jPAKERound1Payload.getKnowledgeProofForX1();
        BigInteger[] knowledgeProofForX2 = jPAKERound1Payload.getKnowledgeProofForX2();
        JPAKEUtil.validateParticipantIdsDiffer(this.participantId, jPAKERound1Payload.getParticipantId());
        JPAKEUtil.validateGx4(this.f19193gx4);
        JPAKEUtil.validateZeroKnowledgeProof(this.f19194p, this.f19195q, this.f19189g, this.f19192gx3, knowledgeProofForX1, jPAKERound1Payload.getParticipantId(), this.f19188digest);
        JPAKEUtil.validateZeroKnowledgeProof(this.f19194p, this.f19195q, this.f19189g, this.f19193gx4, knowledgeProofForX2, jPAKERound1Payload.getParticipantId(), this.f19188digest);
        this.f19197state = 20;
    }

    public void validateRound2PayloadReceived(JPAKERound2Payload jPAKERound2Payload) throws CryptoException {
        int i = this.f19197state;
        if (i >= 40) {
            throw new IllegalStateException("Validation already attempted for round2 payload for" + this.participantId);
        }
        if (i < 20) {
            throw new IllegalStateException("Round1 payload must be validated prior to validating Round2 payload for " + this.participantId);
        }
        BigInteger bigIntegerCalculateGA = JPAKEUtil.calculateGA(this.f19194p, this.f19192gx3, this.f19190gx1, this.f19191gx2);
        this.f19187b = jPAKERound2Payload.m15026getA();
        BigInteger[] knowledgeProofForX2s = jPAKERound2Payload.getKnowledgeProofForX2s();
        JPAKEUtil.validateParticipantIdsDiffer(this.participantId, jPAKERound2Payload.getParticipantId());
        JPAKEUtil.validateParticipantIdsEqual(this.partnerParticipantId, jPAKERound2Payload.getParticipantId());
        JPAKEUtil.validateGa(bigIntegerCalculateGA);
        JPAKEUtil.validateZeroKnowledgeProof(this.f19194p, this.f19195q, bigIntegerCalculateGA, this.f19187b, knowledgeProofForX2s, jPAKERound2Payload.getParticipantId(), this.f19188digest);
        this.f19197state = 40;
    }

    public void validateRound3PayloadReceived(JPAKERound3Payload jPAKERound3Payload, BigInteger bigInteger) throws CryptoException {
        int i = this.f19197state;
        if (i >= 70) {
            throw new IllegalStateException("Validation already attempted for round3 payload for" + this.participantId);
        }
        if (i < 50) {
            throw new IllegalStateException("Keying material must be calculated validated prior to validating Round3 payload for " + this.participantId);
        }
        JPAKEUtil.validateParticipantIdsDiffer(this.participantId, jPAKERound3Payload.getParticipantId());
        JPAKEUtil.validateParticipantIdsEqual(this.partnerParticipantId, jPAKERound3Payload.getParticipantId());
        JPAKEUtil.validateMacTag(this.participantId, this.partnerParticipantId, this.f19190gx1, this.f19191gx2, this.f19192gx3, this.f19193gx4, bigInteger, this.f19188digest, jPAKERound3Payload.getMacTag());
        this.f19190gx1 = null;
        this.f19191gx2 = null;
        this.f19192gx3 = null;
        this.f19193gx4 = null;
        this.f19197state = 70;
    }

    public JPAKEParticipant(String str, char[] cArr, JPAKEPrimeOrderGroup jPAKEPrimeOrderGroup) {
        this(str, cArr, jPAKEPrimeOrderGroup, SHA256Digest.newInstance(), CryptoServicesRegistrar.getSecureRandom());
    }

    public JPAKEParticipant(String str, char[] cArr, JPAKEPrimeOrderGroup jPAKEPrimeOrderGroup, InterfaceC5277Digest interfaceC5277Digest, SecureRandom secureRandom) {
        JPAKEUtil.validateNotNull(str, "participantId");
        JPAKEUtil.validateNotNull(cArr, "password");
        JPAKEUtil.validateNotNull(jPAKEPrimeOrderGroup, "p");
        JPAKEUtil.validateNotNull(interfaceC5277Digest, CMSAttributeTableGenerator.f18937DIGEST);
        JPAKEUtil.validateNotNull(secureRandom, "random");
        if (cArr.length == 0) {
            throw new IllegalArgumentException("Password must not be empty.");
        }
        this.participantId = str;
        this.password = C6238Arrays.m18243copyOf(cArr, cArr.length);
        this.f19194p = jPAKEPrimeOrderGroup.m15022getP();
        this.f19195q = jPAKEPrimeOrderGroup.m15023getQ();
        this.f19189g = jPAKEPrimeOrderGroup.m15021getG();
        this.f19188digest = interfaceC5277Digest;
        this.f19196random = secureRandom;
        this.f19197state = 0;
    }
}
