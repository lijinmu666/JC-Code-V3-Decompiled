package com.p038google.p061crypto.p062tink.p075subtle;

import java.security.SecureRandom;

/* renamed from: com.google.crypto.tink.subtle.Random */
/* loaded from: classes.dex */
public final class C0870Random {
    private static final ThreadLocal<SecureRandom> localRandom = new ThreadLocal<SecureRandom>() { // from class: com.google.crypto.tink.subtle.Random.1
        @Override // java.lang.ThreadLocal
        public SecureRandom initialValue() {
            return C0870Random.newDefaultSecureRandom();
        }
    };

    private C0870Random() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom newDefaultSecureRandom() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] randBytes(int i) {
        byte[] bArr = new byte[i];
        localRandom.get().nextBytes(bArr);
        return bArr;
    }

    /* renamed from: randInt */
    public static final int m4281randInt(int i) {
        return localRandom.get().nextInt(i);
    }

    /* renamed from: randInt */
    public static final int m4280randInt() {
        return localRandom.get().nextInt();
    }
}
