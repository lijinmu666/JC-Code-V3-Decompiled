package com.p038google.p061crypto.p062tink.internal;

import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.nio.charset.Charset;
import java.security.SecureRandom;
import java.util.Objects;
import javax.annotation.Nullable;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* renamed from: com.google.crypto.tink.internal.Util */
/* loaded from: classes.dex */
public final class C0431Util {

    /* renamed from: UTF_8 */
    public static final Charset f3121UTF_8 = Charset.forName("UTF-8");

    private C0431Util() {
    }

    @Nullable
    public static Integer getAndroidApiLevel() {
        if (isAndroid()) {
            return BuildDispatchedCode.getApiLevel();
        }
        return null;
    }

    public static boolean isAndroid() {
        return Objects.equals(System.getProperty("java.vendor"), "The Android Project");
    }

    public static int randKeyId() {
        SecureRandom secureRandom = new SecureRandom();
        byte[] bArr = new byte[4];
        int i = 0;
        while (i == 0) {
            secureRandom.nextBytes(bArr);
            i = ((bArr[0] & ByteCompanionObject.MAX_VALUE) << 24) | ((bArr[1] & C1126UByte.MAX_VALUE) << 16) | ((bArr[2] & C1126UByte.MAX_VALUE) << 8) | (bArr[3] & C1126UByte.MAX_VALUE);
        }
        return i;
    }

    private static final byte toByteFromPrintableAscii(char c) {
        if (c >= '!' && c <= '~') {
            return (byte) c;
        }
        throw new TinkBugException("Not a printable ASCII character: " + c);
    }

    public static final C0878Bytes toBytesFromPrintableAscii(String str) {
        byte[] bArr = new byte[str.length()];
        for (int i = 0; i < str.length(); i++) {
            bArr[i] = toByteFromPrintableAscii(str.charAt(i));
        }
        return C0878Bytes.copyFrom(bArr);
    }
}
