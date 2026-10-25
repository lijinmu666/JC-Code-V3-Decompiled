package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.coroutines.Continuation;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a`\u0010\u0000\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001\"\u0004\b\u0000\u0010\u00032\u001e\b\b\u0010\u0005\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001H\u0087\u0088\u0004b\u0002\b\u0007b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, m4988d2 = {"suspend", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "R", BuildConfig.f24315FLAVOR, "block", "(Lkotlin/jvm/functions/Function1;)Lkotlin/jvm/functions/Function1;", "Lkotlin/internal/InlineOnly;", "Lkotlin/SinceKotlin;", "version", "1.2", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class SuspendKt {
    /* JADX WARN: Multi-variable type inference failed */
    @SinceKotlin(m5061version = "1.2")
    @InlineOnly
    /* renamed from: suspend */
    private static final <R> Function1<Continuation<? super R>, Object> m5073suspend(Function1<? super Continuation<? super R>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return block;
    }
}
