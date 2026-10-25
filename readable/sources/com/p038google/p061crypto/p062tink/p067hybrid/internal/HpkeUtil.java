package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.internal.C0431Util;
import com.p038google.p061crypto.p062tink.p073proto.EnumC0628HpkeKdf;
import com.p038google.p061crypto.p062tink.p073proto.EnumC0629HpkeKem;
import com.p038google.p061crypto.p062tink.p073proto.HpkeAead;
import com.p038google.p061crypto.p062tink.p073proto.HpkeParams;
import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
public final class HpkeUtil {

    /* renamed from: HPKE */
    private static final byte[] f3087HPKE;

    /* renamed from: HPKE_V1 */
    private static final byte[] f3088HPKE_V1;

    /* renamed from: KEM */
    private static final byte[] f3089KEM;
    public static final byte[] BASE_MODE = intToByteArray(1, 0);
    public static final byte[] X25519_HKDF_SHA256_KEM_ID = intToByteArray(2, 32);
    public static final byte[] P256_HKDF_SHA256_KEM_ID = intToByteArray(2, 16);
    public static final byte[] P384_HKDF_SHA384_KEM_ID = intToByteArray(2, 17);
    public static final byte[] P521_HKDF_SHA512_KEM_ID = intToByteArray(2, 18);
    public static final byte[] HKDF_SHA256_KDF_ID = intToByteArray(2, 1);
    public static final byte[] HKDF_SHA384_KDF_ID = intToByteArray(2, 2);
    public static final byte[] HKDF_SHA512_KDF_ID = intToByteArray(2, 3);
    public static final byte[] AES_128_GCM_AEAD_ID = intToByteArray(2, 1);
    public static final byte[] AES_256_GCM_AEAD_ID = intToByteArray(2, 2);
    public static final byte[] CHACHA20_POLY1305_AEAD_ID = intToByteArray(2, 3);
    public static final byte[] EMPTY_SALT = new byte[0];

    /* renamed from: com.google.crypto.tink.hybrid.internal.HpkeUtil$1 */
    public static /* synthetic */ class C04081 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HpkeKem;

        static {
            int[] iArr = new int[EnumC0629HpkeKem.m3660values().length];
            $SwitchMap$com$google$crypto$tink$proto$HpkeKem = iArr;
            try {
                iArr[EnumC0629HpkeKem.DHKEM_P256_HKDF_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[EnumC0629HpkeKem.DHKEM_P384_HKDF_SHA384.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[EnumC0629HpkeKem.DHKEM_P521_HKDF_SHA512.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    static {
        Charset charset = C0431Util.f3121UTF_8;
        f3089KEM = "KEM".getBytes(charset);
        f3087HPKE = "HPKE".getBytes(charset);
        f3088HPKE_V1 = "HPKE-v1".getBytes(charset);
    }

    private HpkeUtil() {
    }

    public static byte[] hpkeSuiteId(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        return C0853Bytes.m4229concat(f3087HPKE, bArr, bArr2, bArr3);
    }

    public static byte[] intToByteArray(int i, int i2) {
        byte[] bArr = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr[i3] = (byte) ((i2 >> (((i - i3) - 1) * 8)) & 255);
        }
        return bArr;
    }

    public static byte[] kemSuiteId(byte[] bArr) {
        return C0853Bytes.m4229concat(f3089KEM, bArr);
    }

    public static byte[] labelIkm(String str, byte[] bArr, byte[] bArr2) {
        return C0853Bytes.m4229concat(f3088HPKE_V1, bArr2, str.getBytes(C0431Util.f3121UTF_8), bArr);
    }

    public static byte[] labelInfo(String str, byte[] bArr, byte[] bArr2, int i) {
        return C0853Bytes.m4229concat(intToByteArray(2, i), f3088HPKE_V1, bArr2, str.getBytes(C0431Util.f3121UTF_8), bArr);
    }

    public static EllipticCurves.CurveType nistHpkeKemToCurve(EnumC0629HpkeKem enumC0629HpkeKem) throws GeneralSecurityException {
        int i = C04081.$SwitchMap$com$google$crypto$tink$proto$HpkeKem[enumC0629HpkeKem.ordinal()];
        if (i == 1) {
            return EllipticCurves.CurveType.NIST_P256;
        }
        if (i == 2) {
            return EllipticCurves.CurveType.NIST_P384;
        }
        if (i == 3) {
            return EllipticCurves.CurveType.NIST_P521;
        }
        throw new GeneralSecurityException("Unrecognized NIST HPKE KEM identifier");
    }

    public static void validateParams(HpkeParams hpkeParams) throws GeneralSecurityException {
        if (hpkeParams.mo3668getKem() == EnumC0629HpkeKem.KEM_UNKNOWN || hpkeParams.mo3668getKem() == EnumC0629HpkeKem.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KEM param: " + hpkeParams.mo3668getKem().name());
        }
        if (hpkeParams.mo3667getKdf() == EnumC0628HpkeKdf.KDF_UNKNOWN || hpkeParams.mo3667getKdf() == EnumC0628HpkeKdf.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid KDF param: " + hpkeParams.mo3667getKdf().name());
        }
        if (hpkeParams.mo3666getAead() == HpkeAead.AEAD_UNKNOWN || hpkeParams.mo3666getAead() == HpkeAead.UNRECOGNIZED) {
            throw new GeneralSecurityException("Invalid AEAD param: " + hpkeParams.mo3666getAead().name());
        }
    }
}
