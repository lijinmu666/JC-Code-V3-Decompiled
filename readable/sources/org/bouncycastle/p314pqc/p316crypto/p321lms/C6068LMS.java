package org.bouncycastle.p314pqc.p316crypto.p321lms;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* renamed from: org.bouncycastle.pqc.crypto.lms.LMS */
/* loaded from: classes2.dex */
class C6068LMS {

    /* renamed from: D_INTR */
    static final short f23240D_INTR = -31869;

    /* renamed from: D_LEAF */
    static final short f23241D_LEAF = -32126;

    public static LMSPrivateKeyParameters generateKeys(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, int i, byte[] bArr, byte[] bArr2) {
        if (bArr2 != null && bArr2.length >= lMSigParameters.m17654getM()) {
            return new LMSPrivateKeyParameters(lMSigParameters, lMOtsParameters, i, bArr, 1 << lMSigParameters.m17653getH(), bArr2);
        }
        throw new IllegalArgumentException("root seed is less than " + lMSigParameters.m17654getM());
    }

    public static LMSSignature generateSign(LMSContext lMSContext) {
        return new LMSSignature(lMSContext.getPrivateKey().m17627getQ(), C6070LM_OTS.lm_ots_generate_signature(lMSContext.getPrivateKey(), lMSContext.m17638getQ(), lMSContext.m17636getC()), lMSContext.getSigParams(), lMSContext.m17637getPath());
    }

    public static boolean verifySignature(LMSPublicKeyParameters lMSPublicKeyParameters, LMSContext lMSContext) {
        LMSSignature lMSSignature = (LMSSignature) lMSContext.getSignature();
        LMSigParameters parameter = lMSSignature.getParameter();
        int iM17653getH = parameter.m17653getH();
        byte[][] bArrM17651getY = lMSSignature.m17651getY();
        byte[] bArrLm_ots_validate_signature_calculate = C6070LM_OTS.lm_ots_validate_signature_calculate(lMSContext);
        int iM17650getQ = (1 << iM17653getH) + lMSSignature.m17650getQ();
        byte[] bArrM17646getI = lMSPublicKeyParameters.m17646getI();
        InterfaceC5277Digest digest = DigestUtil.getDigest(parameter);
        int digestSize = digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        digest.mo14970update(bArrM17646getI, 0, bArrM17646getI.length);
        LmsUtils.m17659u32str(iM17650getQ, digest);
        LmsUtils.m17658u16str(f23241D_LEAF, digest);
        digest.mo14970update(bArrLm_ots_validate_signature_calculate, 0, bArrLm_ots_validate_signature_calculate.length);
        digest.mo14967doFinal(bArr, 0);
        int i = 0;
        while (iM17650getQ > 1) {
            if ((iM17650getQ & 1) == 1) {
                digest.mo14970update(bArrM17646getI, 0, bArrM17646getI.length);
                LmsUtils.m17659u32str(iM17650getQ / 2, digest);
                LmsUtils.m17658u16str(f23240D_INTR, digest);
                byte[] bArr2 = bArrM17651getY[i];
                digest.mo14970update(bArr2, 0, bArr2.length);
                digest.mo14970update(bArr, 0, digestSize);
            } else {
                digest.mo14970update(bArrM17646getI, 0, bArrM17646getI.length);
                LmsUtils.m17659u32str(iM17650getQ / 2, digest);
                LmsUtils.m17658u16str(f23240D_INTR, digest);
                digest.mo14970update(bArr, 0, digestSize);
                byte[] bArr3 = bArrM17651getY[i];
                digest.mo14970update(bArr3, 0, bArr3.length);
            }
            digest.mo14967doFinal(bArr, 0);
            iM17650getQ /= 2;
            i++;
            if (i == bArrM17651getY.length && iM17650getQ > 1) {
                return false;
            }
        }
        return lMSPublicKeyParameters.matchesT1(bArr);
    }

    public static LMSSignature generateSign(LMSPrivateKeyParameters lMSPrivateKeyParameters, byte[] bArr) {
        LMSContext lMSContextGenerateLMSContext = lMSPrivateKeyParameters.generateLMSContext();
        lMSContextGenerateLMSContext.mo14970update(bArr, 0, bArr.length);
        return generateSign(lMSContextGenerateLMSContext);
    }

    public static boolean verifySignature(LMSPublicKeyParameters lMSPublicKeyParameters, LMSSignature lMSSignature, byte[] bArr) {
        LMSContext lMSContextGenerateOtsContext = lMSPublicKeyParameters.generateOtsContext(lMSSignature);
        LmsUtils.byteArray(bArr, lMSContextGenerateOtsContext);
        return verifySignature(lMSPublicKeyParameters, lMSContextGenerateOtsContext);
    }

    public static boolean verifySignature(LMSPublicKeyParameters lMSPublicKeyParameters, byte[] bArr, byte[] bArr2) {
        LMSContext lMSContextGenerateLMSContext = lMSPublicKeyParameters.generateLMSContext(bArr);
        LmsUtils.byteArray(bArr2, lMSContextGenerateLMSContext);
        return verifySignature(lMSPublicKeyParameters, lMSContextGenerateLMSContext);
    }
}
