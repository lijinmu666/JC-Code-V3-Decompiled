package org.bouncycastle.p314pqc.p316crypto.p321lms;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.pqc.crypto.lms.LM_OTS */
/* loaded from: classes2.dex */
class C6070LM_OTS {

    /* renamed from: D_MESG */
    static final short f23263D_MESG = -32383;

    /* renamed from: D_PBLC */
    private static final short f23264D_PBLC = -32640;

    /* renamed from: ITER_J */
    private static final int f23265ITER_J = 22;

    /* renamed from: ITER_K */
    private static final int f23266ITER_K = 20;
    private static final int ITER_PREV = 23;
    static final int MAX_HASH = 32;
    static final int SEED_RANDOMISER_INDEX = -3;

    /* renamed from: cksm */
    public static int m17656cksm(byte[] bArr, int i, LMOtsParameters lMOtsParameters) {
        int iM17625getW = (1 << lMOtsParameters.m17625getW()) - 1;
        int iM17657coef = 0;
        for (int i2 = 0; i2 < (i * 8) / lMOtsParameters.m17625getW(); i2++) {
            iM17657coef = (iM17657coef + iM17625getW) - m17657coef(bArr, i2, lMOtsParameters.m17625getW());
        }
        return iM17657coef << lMOtsParameters.m17621getLs();
    }

    /* renamed from: coef */
    public static int m17657coef(byte[] bArr, int i, int i2) {
        int i3 = (i * i2) / 8;
        return (bArr[i3] >>> (((~i) & ((8 / i2) - 1)) * i2)) & ((1 << i2) - 1);
    }

    public static LMOtsSignature lm_ots_generate_signature(LMOtsPrivateKey lMOtsPrivateKey, byte[] bArr, byte[] bArr2) {
        LMOtsParameters parameter = lMOtsPrivateKey.getParameter();
        int iM17622getN = parameter.m17622getN();
        int iM17623getP = parameter.m17623getP();
        int iM17625getW = parameter.m17625getW();
        byte[] bArr3 = new byte[iM17623getP * iM17622getN];
        InterfaceC5277Digest digest = DigestUtil.getDigest(parameter);
        SeedDerive derivationFunction = lMOtsPrivateKey.getDerivationFunction();
        int iM17656cksm = m17656cksm(bArr, iM17622getN, parameter);
        bArr[iM17622getN] = (byte) ((iM17656cksm >>> 8) & 255);
        bArr[iM17622getN + 1] = (byte) iM17656cksm;
        int i = iM17622getN + 23;
        byte[] bArrM17600build = Composer.m17598compose().m17602bytes(lMOtsPrivateKey.m17626getI()).m17609u32str(lMOtsPrivateKey.m17627getQ()).padUntil(0, i).m17600build();
        derivationFunction.m17663setJ(0);
        int i2 = 0;
        while (i2 < iM17623getP) {
            AbstractC6245Pack.shortToBigEndian((short) i2, bArrM17600build, 20);
            int i3 = 23;
            derivationFunction.deriveSeed(bArrM17600build, i2 < iM17623getP + (-1), 23);
            int iM17657coef = m17657coef(bArr, i2, iM17625getW);
            for (int i4 = 0; i4 < iM17657coef; i4++) {
                bArrM17600build[22] = (byte) i4;
                digest.mo14970update(bArrM17600build, 0, i);
                i3 = 23;
                digest.mo14967doFinal(bArrM17600build, 23);
            }
            System.arraycopy(bArrM17600build, i3, bArr3, iM17622getN * i2, iM17622getN);
            i2++;
        }
        return new LMOtsSignature(parameter, bArr2, bArr3);
    }

    public static boolean lm_ots_validate_signature(LMOtsPublicKey lMOtsPublicKey, LMOtsSignature lMOtsSignature, byte[] bArr, boolean z) throws LMSException {
        if (lMOtsSignature.m17634getType().equals(lMOtsPublicKey.getParameter())) {
            return C6238Arrays.areEqual(lm_ots_validate_signature_calculate(lMOtsPublicKey, lMOtsSignature, bArr), lMOtsPublicKey.m17630getK());
        }
        throw new LMSException("public key and signature ots types do not match");
    }

    public static byte[] lm_ots_validate_signature_calculate(LMOtsPublicKey lMOtsPublicKey, LMOtsSignature lMOtsSignature, byte[] bArr) {
        LMSContext lMSContextCreateOtsContext = lMOtsPublicKey.createOtsContext(lMOtsSignature);
        LmsUtils.byteArray(bArr, lMSContextCreateOtsContext);
        return lm_ots_validate_signature_calculate(lMSContextCreateOtsContext);
    }

    public static LMOtsPublicKey lms_ots_generatePublicKey(LMOtsPrivateKey lMOtsPrivateKey) {
        return new LMOtsPublicKey(lMOtsPrivateKey.getParameter(), lMOtsPrivateKey.m17626getI(), lMOtsPrivateKey.m17627getQ(), lms_ots_generatePublicKey(lMOtsPrivateKey.getParameter(), lMOtsPrivateKey.m17626getI(), lMOtsPrivateKey.m17627getQ(), lMOtsPrivateKey.getMasterSecret()));
    }

    public static LMOtsSignature lm_ots_generate_signature(LMSigParameters lMSigParameters, LMOtsPrivateKey lMOtsPrivateKey, byte[][] bArr, byte[] bArr2, boolean z) {
        byte[] bArrM17636getC;
        byte[] bArrM17638getQ = new byte[34];
        if (z) {
            int iM17622getN = lMOtsPrivateKey.getParameter().m17622getN();
            bArrM17636getC = new byte[iM17622getN];
            System.arraycopy(bArr2, 0, bArrM17638getQ, 0, iM17622getN);
        } else {
            LMSContext signatureContext = lMOtsPrivateKey.getSignatureContext(lMSigParameters, bArr);
            LmsUtils.byteArray(bArr2, 0, bArr2.length, signatureContext);
            bArrM17636getC = signatureContext.m17636getC();
            bArrM17638getQ = signatureContext.m17638getQ();
        }
        return lm_ots_generate_signature(lMOtsPrivateKey, bArrM17638getQ, bArrM17636getC);
    }

    public static byte[] lm_ots_validate_signature_calculate(LMSContext lMSContext) {
        LMOtsPublicKey publicKey = lMSContext.getPublicKey();
        LMOtsParameters parameter = publicKey.getParameter();
        Object signature = lMSContext.getSignature();
        LMOtsSignature otsSignature = signature instanceof LMSSignature ? ((LMSSignature) signature).getOtsSignature() : (LMOtsSignature) signature;
        int iM17622getN = parameter.m17622getN();
        int iM17625getW = parameter.m17625getW();
        int iM17623getP = parameter.m17623getP();
        byte[] bArrM17638getQ = lMSContext.m17638getQ();
        int iM17656cksm = m17656cksm(bArrM17638getQ, iM17622getN, parameter);
        bArrM17638getQ[iM17622getN] = (byte) ((iM17656cksm >>> 8) & 255);
        bArrM17638getQ[iM17622getN + 1] = (byte) iM17656cksm;
        byte[] bArrM17629getI = publicKey.m17629getI();
        int iM17631getQ = publicKey.m17631getQ();
        InterfaceC5277Digest digest = DigestUtil.getDigest(parameter);
        LmsUtils.byteArray(bArrM17629getI, digest);
        LmsUtils.m17659u32str(iM17631getQ, digest);
        LmsUtils.m17658u16str(f23264D_PBLC, digest);
        Composer composerM17609u32str = Composer.m17598compose().m17602bytes(bArrM17629getI).m17609u32str(iM17631getQ);
        int i = iM17622getN + 23;
        byte[] bArrM17600build = composerM17609u32str.padUntil(0, i).m17600build();
        int i2 = (1 << iM17625getW) - 1;
        byte[] bArrM17635getY = otsSignature.m17635getY();
        InterfaceC5277Digest digest2 = DigestUtil.getDigest(parameter);
        for (int i3 = 0; i3 < iM17623getP; i3++) {
            AbstractC6245Pack.shortToBigEndian((short) i3, bArrM17600build, 20);
            System.arraycopy(bArrM17635getY, i3 * iM17622getN, bArrM17600build, 23, iM17622getN);
            for (int iM17657coef = m17657coef(bArrM17638getQ, i3, iM17625getW); iM17657coef < i2; iM17657coef++) {
                bArrM17600build[22] = (byte) iM17657coef;
                digest2.mo14970update(bArrM17600build, 0, i);
                digest2.mo14967doFinal(bArrM17600build, 23);
            }
            digest.mo14970update(bArrM17600build, 23, iM17622getN);
        }
        byte[] bArr = new byte[iM17622getN];
        digest.mo14967doFinal(bArr, 0);
        return bArr;
    }

    public static byte[] lms_ots_generatePublicKey(LMOtsParameters lMOtsParameters, byte[] bArr, int i, byte[] bArr2) {
        InterfaceC5277Digest digest = DigestUtil.getDigest(lMOtsParameters);
        byte[] bArrM17600build = Composer.m17598compose().m17602bytes(bArr).m17609u32str(i).m17608u16str(-32640).padUntil(0, 22).m17600build();
        digest.mo14970update(bArrM17600build, 0, bArrM17600build.length);
        InterfaceC5277Digest digest2 = DigestUtil.getDigest(lMOtsParameters);
        byte[] bArrM17600build2 = Composer.m17598compose().m17602bytes(bArr).m17609u32str(i).padUntil(0, digest2.getDigestSize() + 23).m17600build();
        SeedDerive seedDerive = new SeedDerive(bArr, bArr2, DigestUtil.getDigest(lMOtsParameters));
        seedDerive.m17664setQ(i);
        seedDerive.m17663setJ(0);
        int iM17623getP = lMOtsParameters.m17623getP();
        int iM17622getN = lMOtsParameters.m17622getN();
        int iM17625getW = (1 << lMOtsParameters.m17625getW()) - 1;
        int i2 = 0;
        while (i2 < iM17623getP) {
            seedDerive.deriveSeed(bArrM17600build2, i2 < iM17623getP + (-1), 23);
            AbstractC6245Pack.shortToBigEndian((short) i2, bArrM17600build2, 20);
            for (int i3 = 0; i3 < iM17625getW; i3++) {
                bArrM17600build2[22] = (byte) i3;
                digest2.mo14970update(bArrM17600build2, 0, bArrM17600build2.length);
                digest2.mo14967doFinal(bArrM17600build2, 23);
            }
            digest.mo14970update(bArrM17600build2, 23, iM17622getN);
            i2++;
        }
        byte[] bArr3 = new byte[digest.getDigestSize()];
        digest.mo14967doFinal(bArr3, 0);
        return bArr3;
    }
}
