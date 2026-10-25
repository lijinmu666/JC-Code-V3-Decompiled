package p094kotlin.p101io;

import java.io.Closeable;
import org.conscrypt.BuildConfig;
import p094kotlin.ExceptionsKt;
import p094kotlin.IgnorableReturnValue;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u00002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001aQ\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0005H\u0087\u0088\bb\u0002\b\u0007b\u0002\b\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0006\u001a,\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0081\u0080\u0004b\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fb\u0002\b\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, m4988d2 = {"use", "R", "T", "Ljava/io/Closeable;", "block", "Lkotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlin/internal/InlineOnly;", "Lkotlin/IgnorableReturnValue;", "closeFinally", BuildConfig.f24315FLAVOR, "cause", BuildConfig.f24315FLAVOR, "Lkotlin/SinceKotlin;", "version", "1.1", "Lkotlin/PublishedApi;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "CloseableKt")
/* loaded from: classes.dex */
public final class CloseableKt {
    @SinceKotlin(m5061version = "1.1")
    @PublishedApi
    public static final void closeFinally(Closeable closeable, Throwable th) {
        if (closeable != null) {
            if (th == null) {
                closeable.close();
                return;
            }
            try {
                closeable.close();
            } catch (Throwable th2) {
                ExceptionsKt.addSuppressed(th, th2);
            }
        }
    }

    @IgnorableReturnValue
    @InlineOnly
    /* renamed from: use */
    private static final <T extends Closeable, R> R m6157use(T t, Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        try {
            R rMo2237invoke = block.mo2237invoke(t);
            InlineMarker.finallyStart(1);
            closeFinally(t, null);
            InlineMarker.finallyEnd(1);
            return rMo2237invoke;
        } finally {
        }
    }
}
