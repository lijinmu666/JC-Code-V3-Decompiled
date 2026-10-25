package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;

/* loaded from: classes.dex */
final class NistCurvesHpkeKem implements InterfaceC0402HpkeKem {

    /* renamed from: curve */
    private final EllipticCurves.CurveType f3090curve;

    /* renamed from: hkdf */
    private final HkdfHpkeKdf f3091hkdf;

    /* renamed from: com.google.crypto.tink.hybrid.internal.NistCurvesHpkeKem$1 */
    public static /* synthetic */ class C04091 {

        /* renamed from: $SwitchMap$com$google$crypto$tink$subtle$EllipticCurves$CurveType */
        static final /* synthetic */ int[] f3092x7c2ee98b;

        static {
            int[] iArr = new int[EllipticCurves.CurveType.m4255values().length];
            f3092x7c2ee98b = iArr;
            try {
                iArr[EllipticCurves.CurveType.NIST_P256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f3092x7c2ee98b[EllipticCurves.CurveType.NIST_P384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f3092x7c2ee98b[EllipticCurves.CurveType.NIST_P521.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private NistCurvesHpkeKem(HkdfHpkeKdf hkdfHpkeKdf, EllipticCurves.CurveType curveType) {
        this.f3091hkdf = hkdfHpkeKdf;
        this.f3090curve = curveType;
    }

    private byte[] deriveKemSharedSecret(byte[] bArr, byte[] bArr2, byte[] bArr3) throws GeneralSecurityException {
        byte[] bArrM4229concat = C0853Bytes.m4229concat(bArr2, bArr3);
        byte[] bArrKemSuiteId = HpkeUtil.kemSuiteId(getKemId());
        HkdfHpkeKdf hkdfHpkeKdf = this.f3091hkdf;
        return hkdfHpkeKdf.extractAndExpand(null, bArr, "eae_prk", bArrM4229concat, "shared_secret", bArrKemSuiteId, hkdfHpkeKdf.getMacLength());
    }

    public static NistCurvesHpkeKem fromCurve(EllipticCurves.CurveType curveType) throws GeneralSecurityException {
        int i = C04091.f3092x7c2ee98b[curveType.ordinal()];
        if (i == 1) {
            return new NistCurvesHpkeKem(new HkdfHpkeKdf("HmacSha256"), EllipticCurves.CurveType.NIST_P256);
        }
        if (i == 2) {
            return new NistCurvesHpkeKem(new HkdfHpkeKdf("HmacSha384"), EllipticCurves.CurveType.NIST_P384);
        }
        if (i == 3) {
            return new NistCurvesHpkeKem(new HkdfHpkeKdf("HmacSha512"), EllipticCurves.CurveType.NIST_P521);
        }
        throw new GeneralSecurityException("invalid curve type: " + curveType);
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.InterfaceC0402HpkeKem
    public byte[] decapsulate(byte[] bArr, HpkeKemPrivateKey hpkeKemPrivateKey) {
        return deriveKemSharedSecret(EllipticCurves.computeSharedSecret(EllipticCurves.getEcPrivateKey(this.f3090curve, hpkeKemPrivateKey.getSerializedPrivate().toByteArray()), EllipticCurves.getEcPublicKey(this.f3090curve, EllipticCurves.PointFormatType.UNCOMPRESSED, bArr)), bArr, hpkeKemPrivateKey.getSerializedPublic().toByteArray());
    }

    public HpkeKemEncapOutput encapsulate(byte[] bArr, KeyPair keyPair) throws GeneralSecurityException {
        EllipticCurves.CurveType curveType = this.f3090curve;
        EllipticCurves.PointFormatType pointFormatType = EllipticCurves.PointFormatType.UNCOMPRESSED;
        byte[] bArrComputeSharedSecret = EllipticCurves.computeSharedSecret((ECPrivateKey) keyPair.getPrivate(), EllipticCurves.getEcPublicKey(curveType, pointFormatType, bArr));
        byte[] bArrPointEncode = EllipticCurves.pointEncode(this.f3090curve, pointFormatType, ((ECPublicKey) keyPair.getPublic()).getW());
        return new HpkeKemEncapOutput(deriveKemSharedSecret(bArrComputeSharedSecret, bArrPointEncode, bArr), bArrPointEncode);
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.InterfaceC0402HpkeKem
    public byte[] getKemId() throws GeneralSecurityException {
        int i = C04091.f3092x7c2ee98b[this.f3090curve.ordinal()];
        if (i == 1) {
            return HpkeUtil.P256_HKDF_SHA256_KEM_ID;
        }
        if (i == 2) {
            return HpkeUtil.P384_HKDF_SHA384_KEM_ID;
        }
        if (i == 3) {
            return HpkeUtil.P521_HKDF_SHA512_KEM_ID;
        }
        throw new GeneralSecurityException("Could not determine HPKE KEM ID");
    }

    @Override // com.p038google.p061crypto.p062tink.p067hybrid.internal.InterfaceC0402HpkeKem
    public HpkeKemEncapOutput encapsulate(byte[] bArr) {
        return encapsulate(bArr, EllipticCurves.generateKeyPair(this.f3090curve));
    }
}
