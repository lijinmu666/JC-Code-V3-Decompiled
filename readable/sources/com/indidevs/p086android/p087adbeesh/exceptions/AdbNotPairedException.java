package com.indidevs.p086android.p087adbeesh.exceptions;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/exceptions/AdbNotPairedException;", "Lcom/indidevs/android/adbeesh/exceptions/AdbException;", "message", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;)V", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbNotPairedException extends AdbException {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AdbNotPairedException(String message) {
        super(message, null, 2, null);
        Intrinsics.checkNotNullParameter(message, "message");
    }
}
