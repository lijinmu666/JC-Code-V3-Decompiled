package p122kotlinx.coroutines.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m4988d2 = {"ANDROID_DETECTED", BuildConfig.f24315FLAVOR, "getANDROID_DETECTED", "()Z", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nFastServiceLoader.kt\nKotlin\n*S Kotlin\n*F\n+ 1 FastServiceLoader.kt\nkotlinx/coroutines/internal/FastServiceLoaderKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,169:1\n1#2:170\n*E\n"})
/* loaded from: classes.dex */
public final class FastServiceLoaderKt {
    private static final boolean ANDROID_DETECTED = false;

    static {
        Object objM18546constructorimpl;
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(Class.forName("android.os.Build"));
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
        }
        C1124Result.m18553isSuccessimpl(objM18546constructorimpl);
    }

    public static final boolean getANDROID_DETECTED() {
        return true;
    }
}
