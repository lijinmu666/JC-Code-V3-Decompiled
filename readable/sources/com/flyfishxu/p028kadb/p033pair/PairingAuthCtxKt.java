package com.flyfishxu.p028kadb.p033pair;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.IllegalCharsetNameException;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0000¨\u0006\u0005"}, m4988d2 = {"getBytes", BuildConfig.f24315FLAVOR, "text", BuildConfig.f24315FLAVOR, "charsetName", "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class PairingAuthCtxKt {
    public static final byte[] getBytes(String text, String charsetName) {
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charsetName, "charsetName");
        try {
            Charset charsetForName = Charset.forName(charsetName);
            Intrinsics.checkNotNullExpressionValue(charsetForName, "forName(...)");
            byte[] bytes = text.getBytes(charsetForName);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return bytes;
        } catch (UnsupportedEncodingException e) {
            Throwable thInitCause = new IllegalCharsetNameException("Illegal charset " + charsetName).initCause(e);
            Intrinsics.checkNotNull(thInitCause, "null cannot be cast to non-null type java.nio.charset.IllegalCharsetNameException");
            throw ((IllegalCharsetNameException) thInitCause);
        }
    }
}
