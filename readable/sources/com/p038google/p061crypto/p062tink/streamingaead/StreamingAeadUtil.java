package com.p038google.p061crypto.p062tink.streamingaead;

import com.p038google.p061crypto.p062tink.p073proto.HashType;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
final class StreamingAeadUtil {

    /* renamed from: com.google.crypto.tink.streamingaead.StreamingAeadUtil$1 */
    public static /* synthetic */ class C08471 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$proto$HashType;

        static {
            int[] iArr = new int[HashType.m3630values().length];
            $SwitchMap$com$google$crypto$tink$proto$HashType = iArr;
            try {
                iArr[HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA224.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA256.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA384.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$proto$HashType[HashType.SHA512.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    private StreamingAeadUtil() {
    }

    public static String toHmacAlgo(HashType hashType) throws NoSuchAlgorithmException {
        int i = C08471.$SwitchMap$com$google$crypto$tink$proto$HashType[hashType.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha224";
        }
        if (i == 3) {
            return "HmacSha256";
        }
        if (i == 4) {
            return "HmacSha384";
        }
        if (i == 5) {
            return "HmacSha512";
        }
        throw new NoSuchAlgorithmException("hash unsupported for HMAC: " + hashType);
    }
}
