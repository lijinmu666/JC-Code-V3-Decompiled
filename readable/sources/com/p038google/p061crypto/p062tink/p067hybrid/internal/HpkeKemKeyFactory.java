package com.p038google.p061crypto.p062tink.p067hybrid.internal;

import com.p038google.p061crypto.p062tink.p073proto.EnumC0629HpkeKem;
import com.p038google.p061crypto.p062tink.p073proto.HpkePrivateKey;
import java.security.GeneralSecurityException;

/* loaded from: classes.dex */
final class HpkeKemKeyFactory {

    /* renamed from: com.google.crypto.tink.hybrid.internal.HpkeKemKeyFactory$1 */
    public static /* synthetic */ class C04031 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HpkeKem;

        static {
            int[] iArr = new int[EnumC0629HpkeKem.m3660values().length];
            $SwitchMap$com$google$crypto$tink$proto$HpkeKem = iArr;
            try {
                iArr[EnumC0629HpkeKem.DHKEM_X25519_HKDF_SHA256.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[EnumC0629HpkeKem.DHKEM_P256_HKDF_SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[EnumC0629HpkeKem.DHKEM_P384_HKDF_SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HpkeKem[EnumC0629HpkeKem.DHKEM_P521_HKDF_SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private HpkeKemKeyFactory() {
    }

    public static HpkeKemPrivateKey createPrivate(HpkePrivateKey hpkePrivateKey) throws GeneralSecurityException {
        int i = C04031.$SwitchMap$com$google$crypto$tink$proto$HpkeKem[hpkePrivateKey.getPublicKey().getParams().mo3668getKem().ordinal()];
        if (i == 1) {
            return X25519HpkeKemPrivateKey.fromBytes(hpkePrivateKey.getPrivateKey().toByteArray());
        }
        if (i == 2 || i == 3 || i == 4) {
            return NistCurvesHpkeKemPrivateKey.fromBytes(hpkePrivateKey.getPrivateKey().toByteArray(), hpkePrivateKey.getPublicKey().getPublicKey().toByteArray(), HpkeUtil.nistHpkeKemToCurve(hpkePrivateKey.getPublicKey().getParams().mo3668getKem()));
        }
        throw new GeneralSecurityException("Unrecognized HPKE KEM identifier");
    }
}
