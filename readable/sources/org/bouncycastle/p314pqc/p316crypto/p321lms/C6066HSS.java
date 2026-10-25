package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.util.Arrays;
import java.util.List;
import org.bouncycastle.p314pqc.p316crypto.ExhaustedPrivateKeyException;
import org.conscrypt.BuildConfig;
import p094kotlin.p105jvm.internal.LongCompanionObject;

/* renamed from: org.bouncycastle.pqc.crypto.lms.HSS */
/* loaded from: classes2.dex */
class C6066HSS {

    /* renamed from: org.bouncycastle.pqc.crypto.lms.HSS$PlaceholderLMSPrivateKey */
    public static class PlaceholderLMSPrivateKey extends LMSPrivateKeyParameters {
        public PlaceholderLMSPrivateKey(LMSigParameters lMSigParameters, LMOtsParameters lMOtsParameters, int i, byte[] bArr, int i2, byte[] bArr2) {
            super(lMSigParameters, lMOtsParameters, i, bArr, i2, bArr2);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSPrivateKeyParameters
        public LMOtsPrivateKey getNextOtsPrivateKey() {
            throw new RuntimeException("placeholder only");
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSPrivateKeyParameters
        public LMSPublicKeyParameters getPublicKey() {
            throw new RuntimeException("placeholder only");
        }
    }

    public static HSSPrivateKeyParameters generateHSSKeyPair(HSSKeyGenerationParameters hSSKeyGenerationParameters) {
        byte[] bArr;
        int depth = hSSKeyGenerationParameters.getDepth();
        LMSPrivateKeyParameters[] lMSPrivateKeyParametersArr = new LMSPrivateKeyParameters[depth];
        LMSSignature[] lMSSignatureArr = new LMSSignature[hSSKeyGenerationParameters.getDepth() - 1];
        int i = 0;
        byte[] bArr2 = new byte[hSSKeyGenerationParameters.getLmsParameters()[0].getLMSigParam().m17654getM()];
        hSSKeyGenerationParameters.getRandom().nextBytes(bArr2);
        byte[] bArr3 = new byte[16];
        hSSKeyGenerationParameters.getRandom().nextBytes(bArr3);
        byte[] bArr4 = new byte[0];
        long jM17653getH = 1;
        while (i < depth) {
            if (i == 0) {
                lMSPrivateKeyParametersArr[i] = new LMSPrivateKeyParameters(hSSKeyGenerationParameters.getLmsParameters()[i].getLMSigParam(), hSSKeyGenerationParameters.getLmsParameters()[i].getLMOTSParam(), 0, bArr3, 1 << hSSKeyGenerationParameters.getLmsParameters()[i].getLMSigParam().m17653getH(), bArr2);
                bArr = bArr4;
            } else {
                bArr = bArr4;
                lMSPrivateKeyParametersArr[i] = new PlaceholderLMSPrivateKey(hSSKeyGenerationParameters.getLmsParameters()[i].getLMSigParam(), hSSKeyGenerationParameters.getLmsParameters()[i].getLMOTSParam(), -1, bArr, 1 << hSSKeyGenerationParameters.getLmsParameters()[i].getLMSigParam().m17653getH(), bArr);
            }
            jM17653getH *= 1 << hSSKeyGenerationParameters.getLmsParameters()[i].getLMSigParam().m17653getH();
            i++;
            bArr4 = bArr;
        }
        if (jM17653getH == 0) {
            jM17653getH = LongCompanionObject.MAX_VALUE;
        }
        return new HSSPrivateKeyParameters(hSSKeyGenerationParameters.getDepth(), Arrays.asList(lMSPrivateKeyParametersArr), Arrays.asList(lMSSignatureArr), 0L, jM17653getH);
    }

    public static HSSSignature generateSignature(int i, LMSContext lMSContext) {
        return new HSSSignature(i - 1, lMSContext.getSignedPubKeys(), C6068LMS.generateSign(lMSContext));
    }

    public static void incrementIndex(HSSPrivateKeyParameters hSSPrivateKeyParameters) {
        synchronized (hSSPrivateKeyParameters) {
            rangeTestKeys(hSSPrivateKeyParameters);
            hSSPrivateKeyParameters.incIndex();
            hSSPrivateKeyParameters.m17613getKeys().get(hSSPrivateKeyParameters.m17614getL() - 1).incIndex();
        }
    }

    public static void rangeTestKeys(HSSPrivateKeyParameters hSSPrivateKeyParameters) {
        synchronized (hSSPrivateKeyParameters) {
            try {
                if (hSSPrivateKeyParameters.getIndex() >= hSSPrivateKeyParameters.getIndexLimit()) {
                    StringBuilder sb = new StringBuilder();
                    sb.append("hss private key");
                    sb.append(hSSPrivateKeyParameters.m17616isShard() ? " shard" : BuildConfig.f24315FLAVOR);
                    sb.append(" is exhausted");
                    throw new ExhaustedPrivateKeyException(sb.toString());
                }
                int iM17614getL = hSSPrivateKeyParameters.m17614getL();
                List<LMSPrivateKeyParameters> listM17613getKeys = hSSPrivateKeyParameters.m17613getKeys();
                int i = iM17614getL;
                while (true) {
                    int i2 = i - 1;
                    if (listM17613getKeys.get(i2).getIndex() != (1 << listM17613getKeys.get(i2).getSigParameters().m17653getH())) {
                        while (i < iM17614getL) {
                            hSSPrivateKeyParameters.replaceConsumedKey(i);
                            i++;
                        }
                    } else {
                        if (i2 == 0) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("hss private key");
                            sb2.append(hSSPrivateKeyParameters.m17616isShard() ? " shard" : BuildConfig.f24315FLAVOR);
                            sb2.append(" is exhausted the maximum limit for this HSS private key");
                            throw new ExhaustedPrivateKeyException(sb2.toString());
                        }
                        i = i2;
                    }
                }
            } finally {
            }
        }
    }

    public static boolean verifySignature(HSSPublicKeyParameters hSSPublicKeyParameters, HSSSignature hSSSignature, byte[] bArr) {
        int i = hSSSignature.getlMinus1();
        int i2 = i + 1;
        if (i2 != hSSPublicKeyParameters.m17618getL()) {
            return false;
        }
        LMSSignature[] lMSSignatureArr = new LMSSignature[i2];
        LMSPublicKeyParameters[] lMSPublicKeyParametersArr = new LMSPublicKeyParameters[i];
        for (int i3 = 0; i3 < i; i3++) {
            lMSSignatureArr[i3] = hSSSignature.getSignedPubKey()[i3].getSignature();
            lMSPublicKeyParametersArr[i3] = hSSSignature.getSignedPubKey()[i3].getPublicKey();
        }
        lMSSignatureArr[i] = hSSSignature.getSignature();
        LMSPublicKeyParameters lMSPublicKey = hSSPublicKeyParameters.getLMSPublicKey();
        for (int i4 = 0; i4 < i; i4++) {
            if (!C6068LMS.verifySignature(lMSPublicKey, lMSSignatureArr[i4], lMSPublicKeyParametersArr[i4].toByteArray())) {
                return false;
            }
            try {
                lMSPublicKey = lMSPublicKeyParametersArr[i4];
            } catch (Exception e) {
                throw new IllegalStateException(e.getMessage(), e);
            }
        }
        return C6068LMS.verifySignature(lMSPublicKey, lMSSignatureArr[i], bArr);
    }

    public static HSSSignature generateSignature(HSSPrivateKeyParameters hSSPrivateKeyParameters, byte[] bArr) {
        LMSPrivateKeyParameters lMSPrivateKeyParameters;
        LMSSignedPubKey[] lMSSignedPubKeyArr;
        int iM17614getL = hSSPrivateKeyParameters.m17614getL();
        synchronized (hSSPrivateKeyParameters) {
            try {
                rangeTestKeys(hSSPrivateKeyParameters);
                List<LMSPrivateKeyParameters> listM17613getKeys = hSSPrivateKeyParameters.m17613getKeys();
                List<LMSSignature> listM17615getSig = hSSPrivateKeyParameters.m17615getSig();
                int i = iM17614getL - 1;
                lMSPrivateKeyParameters = hSSPrivateKeyParameters.m17613getKeys().get(i);
                lMSSignedPubKeyArr = new LMSSignedPubKey[i];
                int i2 = 0;
                while (i2 < i) {
                    int i3 = i2 + 1;
                    lMSSignedPubKeyArr[i2] = new LMSSignedPubKey(listM17615getSig.get(i2), listM17613getKeys.get(i3).getPublicKey());
                    i2 = i3;
                }
                hSSPrivateKeyParameters.incIndex();
            } catch (Throwable th) {
                throw th;
            }
        }
        LMSContext lMSContextWithSignedPublicKeys = lMSPrivateKeyParameters.generateLMSContext().withSignedPublicKeys(lMSSignedPubKeyArr);
        lMSContextWithSignedPublicKeys.mo14970update(bArr, 0, bArr.length);
        return generateSignature(iM17614getL, lMSContextWithSignedPublicKeys);
    }
}
