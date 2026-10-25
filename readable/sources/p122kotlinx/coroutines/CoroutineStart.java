package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.ContinuationKt;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.intrinsics.CancellableKt;
import p122kotlinx.coroutines.intrinsics.UndispatchedKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003JY\u0010\b\u001a\u00020\t\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2'\u0010\f\u001a#\b\u0001\u0012\u0004\u0012\u0002H\n\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u000e\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\r¢\u0006\u0002\b\u00102\u0006\u0010\u0011\u001a\u0002H\n2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000eH\u0087\u0002¢\u0006\u0002\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u00158FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0018j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\u0019"}, m4988d2 = {"Lkotlinx/coroutines/CoroutineStart;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "DEFAULT", "LAZY", "ATOMIC", "UNDISPATCHED", "invoke", BuildConfig.f24315FLAVOR, "R", "T", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "receiver", "completion", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)V", "isLazy", BuildConfig.f24315FLAVOR, "isLazy$annotations", "()V", "()Z", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class CoroutineStart {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ CoroutineStart[] f5504$VALUES;

    /* renamed from: DEFAULT */
    public static final CoroutineStart f5506DEFAULT = new CoroutineStart("DEFAULT", 0);

    /* renamed from: LAZY */
    public static final CoroutineStart f5507LAZY = new CoroutineStart("LAZY", 1);

    /* renamed from: ATOMIC */
    @DelicateCoroutinesApi
    public static final CoroutineStart f5505ATOMIC = new CoroutineStart("ATOMIC", 2);
    public static final CoroutineStart UNDISPATCHED = new CoroutineStart("UNDISPATCHED", 3);

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CoroutineStart.m6960values().length];
            try {
                iArr[CoroutineStart.f5506DEFAULT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CoroutineStart.f5505ATOMIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CoroutineStart.UNDISPATCHED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CoroutineStart.f5507LAZY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: $values */
    private static final /* synthetic */ CoroutineStart[] m6958$values() {
        return new CoroutineStart[]{f5506DEFAULT, f5507LAZY, f5505ATOMIC, UNDISPATCHED};
    }

    static {
        CoroutineStart[] coroutineStartArrM6958$values = m6958$values();
        f5504$VALUES = coroutineStartArrM6958$values;
        $ENTRIES = EnumEntriesKt.enumEntries(coroutineStartArrM6958$values);
    }

    private CoroutineStart(String str, int i) {
    }

    public static EnumEntries<CoroutineStart> getEntries() {
        return $ENTRIES;
    }

    @InternalCoroutinesApi
    public static /* synthetic */ void isLazy$annotations() {
    }

    /* renamed from: valueOf */
    public static CoroutineStart m6959valueOf(String str) {
        return (CoroutineStart) Enum.valueOf(CoroutineStart.class, str);
    }

    /* renamed from: values */
    public static CoroutineStart[] m6960values() {
        return (CoroutineStart[]) f5504$VALUES.clone();
    }

    @InternalCoroutinesApi
    /* renamed from: invoke */
    public final <R, T> void m6961invoke(Function2<? super R, ? super Continuation<? super T>, ? extends Object> block, R receiver, Continuation<? super T> completion) {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            CancellableKt.startCoroutineCancellable(block, receiver, completion);
            return;
        }
        if (i == 2) {
            ContinuationKt.startCoroutine(block, receiver, completion);
        } else if (i == 3) {
            UndispatchedKt.startCoroutineUndispatched(block, receiver, completion);
        } else if (i != 4) {
            throw new NoWhenBranchMatchedException();
        }
    }

    /* renamed from: isLazy */
    public final boolean m6962isLazy() {
        return this == f5507LAZY;
    }
}
