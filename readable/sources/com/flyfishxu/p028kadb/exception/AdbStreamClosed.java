package com.flyfishxu.p028kadb.exception;

import java.io.IOException;
import java.util.Arrays;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.StringCompanionObject;

@Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m4988d2 = {"Lcom/flyfishxu/kadb/exception/AdbStreamClosed;", "Ljava/io/IOException;", "localId", BuildConfig.f24315FLAVOR, "<init>", "(I)V", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbStreamClosed extends IOException {
    /* JADX WARN: Illegal instructions before constructor call */
    public AdbStreamClosed(int i) {
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("ADB stream is closed for localId: %x", Arrays.copyOf(new Object[]{Integer.valueOf(i)}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        super(str);
    }
}
