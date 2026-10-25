package com.flyfishxu.p028kadb.p031debug;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u001a\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, m4988d2 = {"ENABLED", BuildConfig.f24315FLAVOR, "log", BuildConfig.f24315FLAVOR, "block", "Lkotlin/Function0;", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class LoggingKt {

    /* renamed from: ENABLED */
    private static final boolean f2060ENABLED = Intrinsics.areEqual("true", System.getenv("KADB_LOGGING"));

    /* renamed from: log */
    public static final void m2214log(Function0<String> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        if (f2060ENABLED) {
            System.out.println((Object) block.mo4323invoke());
        }
    }
}
