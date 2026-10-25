package p122kotlinx.coroutines.p129sync;

import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.internal.C1578Symbol;
import p122kotlinx.coroutines.internal.SystemPropsKt__SystemProps_commonKt;

@Metadata(m4987d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u001a3\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\u00020\u00012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0086H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\t\u001a\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000bH\u0002\"\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0015\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m4988d2 = {"Semaphore", "Lkotlinx/coroutines/sync/Semaphore;", "permits", BuildConfig.f24315FLAVOR, "acquiredPermits", "withPermit", "T", "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Semaphore;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createSegment", "Lkotlinx/coroutines/sync/SemaphoreSegment;", "id", BuildConfig.f24315FLAVOR, "prev", "MAX_SPIN_CYCLES", "PERMIT", "Lkotlinx/coroutines/internal/Symbol;", "TAKEN", "BROKEN", "CANCELLED", "SEGMENT_SIZE", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class SemaphoreKt {
    private static final int MAX_SPIN_CYCLES = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.maxSpinCycles", 100, 0, 0, 12, (Object) null);

    /* renamed from: PERMIT */
    private static final C1578Symbol f7290PERMIT = new C1578Symbol("PERMIT");

    /* renamed from: TAKEN */
    private static final C1578Symbol f7291TAKEN = new C1578Symbol("TAKEN");

    /* renamed from: BROKEN */
    private static final C1578Symbol f7289BROKEN = new C1578Symbol("BROKEN");
    private static final C1578Symbol CANCELLED = new C1578Symbol("CANCELLED");
    private static final int SEGMENT_SIZE = SystemPropsKt__SystemProps_commonKt.systemProp$default("kotlinx.coroutines.semaphore.segmentSize", 16, 0, 0, 12, (Object) null);

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.sync.SemaphoreKt", m6124f = "Semaphore.kt", m6125i = {0, 0, 0}, m6126l = {C5125EACTags.ANSWER_TO_RESET}, m6127m = "withPermit", m6128n = {"$this$withPermit", "action", "$i$f$withPermit"}, m6130s = {"L$0", "L$1", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nSemaphore.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Semaphore.kt\nkotlinx/coroutines/sync/SemaphoreKt$withPermit$1\n*L\n1#1,396:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.sync.SemaphoreKt$withPermit$1 */
    public static final class C15941<T> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f7292I$0;

        /* renamed from: L$0 */
        Object f7293L$0;

        /* renamed from: L$1 */
        Object f7294L$1;

        /* renamed from: label */
        int f7295label;

        /* renamed from: result */
        /* synthetic */ Object f7296result;

        public C15941(Continuation<? super C15941> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7296result = obj;
            this.f7295label |= Integer.MIN_VALUE;
            return SemaphoreKt.withPermit(null, null, this);
        }
    }

    public static final Semaphore Semaphore(int i, int i2) {
        return new SemaphoreImpl(i, i2);
    }

    public static /* synthetic */ Semaphore Semaphore$default(int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        return Semaphore(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SemaphoreSegment createSegment(long j, SemaphoreSegment semaphoreSegment) {
        return new SemaphoreSegment(j, semaphoreSegment, 0);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withPermit(Semaphore semaphore, Function0<? extends T> function0, Continuation<? super T> continuation) {
        C15941 c15941;
        if (continuation instanceof C15941) {
            c15941 = (C15941) continuation;
            int i = c15941.f7295label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c15941.f7295label = i - Integer.MIN_VALUE;
            } else {
                c15941 = new C15941(continuation);
            }
        }
        Object obj = c15941.f7296result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c15941.f7295label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj);
            c15941.f7293L$0 = semaphore;
            c15941.f7294L$1 = function0;
            c15941.f7292I$0 = 0;
            c15941.f7295label = 1;
            if (semaphore.m7501acquire(c15941) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function0 = (Function0) c15941.f7294L$1;
            semaphore = (Semaphore) c15941.f7293L$0;
            ResultKt.throwOnFailure(obj);
        }
        try {
            return function0.mo4323invoke();
        } finally {
            InlineMarker.finallyStart(1);
            semaphore.m7502release();
            InlineMarker.finallyEnd(1);
        }
    }

    private static final <T> Object withPermit$$forInline(Semaphore semaphore, Function0<? extends T> function0, Continuation<? super T> continuation) {
        InlineMarker.m6315mark(0);
        semaphore.m7501acquire(continuation);
        InlineMarker.m6315mark(1);
        try {
            return function0.mo4323invoke();
        } finally {
            InlineMarker.finallyStart(1);
            semaphore.m7502release();
            InlineMarker.finallyEnd(1);
        }
    }
}
