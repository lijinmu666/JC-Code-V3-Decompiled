package p122kotlinx.coroutines.p127selects;

import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.coroutines.Continuation;
import p094kotlin.internal.LowPriorityInOverloadResolution;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.ExperimentalCoroutinesApi;

@Metadata(m4987d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00002\u00020\u0002J0\u0010\u0003\u001a\u00020\u0004*\u00020\u00052\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H¦\u0002¢\u0006\u0002\u0010\tJB\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0001\u0010\n*\b\u0012\u0004\u0012\u0002H\n0\u000b2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH¦\u0002¢\u0006\u0002\u0010\rJV\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\n*\u000e\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\n0\u000f2\u0006\u0010\u0010\u001a\u0002H\u000e2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH¦\u0002¢\u0006\u0002\u0010\u0011JP\u0010\u0003\u001a\u00020\u0004\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\n*\u0010\u0012\u0006\u0012\u0004\u0018\u0001H\u000e\u0012\u0004\u0012\u0002H\n0\u000f2\"\u0010\u0006\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\fH\u0096\u0002¢\u0006\u0002\u0010\u0012J3\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00152\u001c\u0010\u0006\u001a\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\b\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007H\u0017¢\u0006\u0002\u0010\u0016\u0082\u0001\u0001\u0017¨\u0006\u0018À\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/selects/SelectBuilder;", "R", BuildConfig.f24315FLAVOR, "invoke", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/selects/SelectClause0;", "block", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "(Lkotlinx/coroutines/selects/SelectClause0;Lkotlin/jvm/functions/Function1;)V", "Q", "Lkotlinx/coroutines/selects/SelectClause1;", "Lkotlin/Function2;", "(Lkotlinx/coroutines/selects/SelectClause1;Lkotlin/jvm/functions/Function2;)V", "P", "Lkotlinx/coroutines/selects/SelectClause2;", "param", "(Lkotlinx/coroutines/selects/SelectClause2;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "(Lkotlinx/coroutines/selects/SelectClause2;Lkotlin/jvm/functions/Function2;)V", "onTimeout", "timeMillis", BuildConfig.f24315FLAVOR, "(JLkotlin/jvm/functions/Function1;)V", "Lkotlinx/coroutines/selects/SelectImplementation;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface SelectBuilder<R> {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        /* renamed from: invoke */
        public static <R, P, Q> void m7485invoke(SelectBuilder<? super R> selectBuilder, SelectClause2<? super P, ? extends Q> selectClause2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
            SelectBuilder.super.mo7484invoke((SelectClause2) selectClause2, (Function2<? super Q, ? super Continuation<? super Object>, ? extends Object>) function2);
        }

        @Deprecated
        @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Replaced with the same extension function", replaceWith = @ReplaceWith(expression = "onTimeout(timeMillis, block)", m5048imports = {"kotlinx.coroutines.selects.onTimeout"}))
        @LowPriorityInOverloadResolution
        @ExperimentalCoroutinesApi
        public static <R> void onTimeout(SelectBuilder<? super R> selectBuilder, long j, Function1<? super Continuation<? super R>, ? extends Object> function1) {
            SelectBuilder.super.onTimeout(j, function1);
        }
    }

    /* renamed from: invoke */
    void mo7481invoke(SelectClause0 selectClause0, Function1<? super Continuation<? super R>, ? extends Object> function1);

    /* renamed from: invoke */
    <Q> void mo7482invoke(SelectClause1<? extends Q> selectClause1, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    /* renamed from: invoke */
    <P, Q> void mo7483invoke(SelectClause2<? super P, ? extends Q> selectClause2, P p, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2);

    /* renamed from: invoke */
    default <P, Q> void mo7484invoke(SelectClause2<? super P, ? extends Q> selectClause2, Function2<? super Q, ? super Continuation<? super R>, ? extends Object> function2) {
        mo7483invoke(selectClause2, null, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Replaced with the same extension function", replaceWith = @ReplaceWith(expression = "onTimeout(timeMillis, block)", m5048imports = {"kotlinx.coroutines.selects.onTimeout"}))
    @LowPriorityInOverloadResolution
    @ExperimentalCoroutinesApi
    default void onTimeout(long timeMillis, Function1<? super Continuation<? super R>, ? extends Object> block) {
        OnTimeoutKt.onTimeout(this, timeMillis, block);
    }
}
