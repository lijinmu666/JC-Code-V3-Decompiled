package p122kotlinx.coroutines.p129sync;

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

@Metadata(m4987d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a?\u0010\u0004\u001a\u0002H\u0005\"\u0004\b\u0000\u0010\u0005*\u00020\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00050\tH\u0086H\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0012\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0013\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0014\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, m4988d2 = {"Mutex", "Lkotlinx/coroutines/sync/Mutex;", "locked", BuildConfig.f24315FLAVOR, "withLock", "T", "owner", BuildConfig.f24315FLAVOR, "action", "Lkotlin/Function0;", "(Lkotlinx/coroutines/sync/Mutex;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "NO_OWNER", "Lkotlinx/coroutines/internal/Symbol;", "ON_LOCK_ALREADY_LOCKED_BY_OWNER", "TRY_LOCK_SUCCESS", BuildConfig.f24315FLAVOR, "TRY_LOCK_FAILED", "TRY_LOCK_ALREADY_LOCKED_BY_OWNER", "HOLDS_LOCK_UNLOCKED", "HOLDS_LOCK_YES", "HOLDS_LOCK_ANOTHER_OWNER", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* renamed from: kotlinx.coroutines.sync.MutexKt */
/* loaded from: classes.dex */
public final class C1593MutexKt {
    private static final int HOLDS_LOCK_ANOTHER_OWNER = 2;
    private static final int HOLDS_LOCK_UNLOCKED = 0;
    private static final int HOLDS_LOCK_YES = 1;
    private static final C1578Symbol NO_OWNER = new C1578Symbol("NO_OWNER");
    private static final C1578Symbol ON_LOCK_ALREADY_LOCKED_BY_OWNER = new C1578Symbol("ALREADY_LOCKED_BY_OWNER");
    private static final int TRY_LOCK_ALREADY_LOCKED_BY_OWNER = 2;
    private static final int TRY_LOCK_FAILED = 1;
    private static final int TRY_LOCK_SUCCESS = 0;

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.sync.MutexKt", m6124f = "Mutex.kt", m6125i = {0, 0, 0, 0}, m6126l = {121}, m6127m = "withLock", m6128n = {"$this$withLock", "owner", "action", "$i$f$withLock"}, m6130s = {"L$0", "L$1", "L$2", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nMutex.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Mutex.kt\nkotlinx/coroutines/sync/MutexKt$withLock$1\n*L\n1#1,314:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.sync.MutexKt$withLock$1, reason: invalid class name */
    public static final class AnonymousClass1<T> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f7282I$0;

        /* renamed from: L$0 */
        Object f7283L$0;

        /* renamed from: L$1 */
        Object f7284L$1;

        /* renamed from: L$2 */
        Object f7285L$2;

        /* renamed from: label */
        int f7286label;

        /* renamed from: result */
        /* synthetic */ Object f7287result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7287result = obj;
            this.f7286label |= Integer.MIN_VALUE;
            return C1593MutexKt.withLock(null, null, null, this);
        }
    }

    /* renamed from: Mutex */
    public static final InterfaceC1592Mutex m7500Mutex(boolean z) {
        return new MutexImpl(z);
    }

    public static /* synthetic */ InterfaceC1592Mutex Mutex$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return m7500Mutex(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T> Object withLock(InterfaceC1592Mutex interfaceC1592Mutex, Object obj, Function0<? extends T> function0, Continuation<? super T> continuation) {
        AnonymousClass1 anonymousClass1;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i = anonymousClass1.f7286label;
            if ((i & Integer.MIN_VALUE) != 0) {
                anonymousClass1.f7286label = i - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj2 = anonymousClass1.f7287result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.f7286label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(obj2);
            anonymousClass1.f7283L$0 = interfaceC1592Mutex;
            anonymousClass1.f7284L$1 = obj;
            anonymousClass1.f7285L$2 = function0;
            anonymousClass1.f7282I$0 = 0;
            anonymousClass1.f7286label = 1;
            if (interfaceC1592Mutex.mo7492lock(obj, anonymousClass1) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function0 = (Function0) anonymousClass1.f7285L$2;
            obj = anonymousClass1.f7284L$1;
            interfaceC1592Mutex = (InterfaceC1592Mutex) anonymousClass1.f7283L$0;
            ResultKt.throwOnFailure(obj2);
        }
        try {
            return function0.mo4323invoke();
        } finally {
            InlineMarker.finallyStart(1);
            interfaceC1592Mutex.mo7494unlock(obj);
            InlineMarker.finallyEnd(1);
        }
    }

    private static final <T> Object withLock$$forInline(InterfaceC1592Mutex interfaceC1592Mutex, Object obj, Function0<? extends T> function0, Continuation<? super T> continuation) {
        InlineMarker.m6315mark(0);
        interfaceC1592Mutex.mo7492lock(obj, continuation);
        InlineMarker.m6315mark(1);
        try {
            return function0.mo4323invoke();
        } finally {
            InlineMarker.finallyStart(1);
            interfaceC1592Mutex.mo7494unlock(obj);
            InlineMarker.finallyEnd(1);
        }
    }

    public static /* synthetic */ Object withLock$default(InterfaceC1592Mutex interfaceC1592Mutex, Object obj, Function0 function0, Continuation continuation, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = null;
        }
        InlineMarker.m6315mark(0);
        interfaceC1592Mutex.mo7492lock(obj, continuation);
        InlineMarker.m6315mark(1);
        try {
            return function0.mo4323invoke();
        } finally {
            InlineMarker.finallyStart(1);
            interfaceC1592Mutex.mo7494unlock(obj);
            InlineMarker.finallyEnd(1);
        }
    }
}
