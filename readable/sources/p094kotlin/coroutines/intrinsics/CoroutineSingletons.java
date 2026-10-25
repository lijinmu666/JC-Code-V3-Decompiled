package p094kotlin.coroutines.intrinsics;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.SinceKotlin;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0081\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006Ê\u0001\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nÊ\u0001\u0002\b\u000b¨\u0006\u0007"}, m4988d2 = {"Lkotlin/coroutines/intrinsics/CoroutineSingletons;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "COROUTINE_SUSPENDED", "UNDECIDED", "RESUMED", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/PublishedApi;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@PublishedApi
/* loaded from: classes.dex */
public final class CoroutineSingletons {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ CoroutineSingletons[] f5037$VALUES;
    public static final CoroutineSingletons COROUTINE_SUSPENDED = new CoroutineSingletons("COROUTINE_SUSPENDED", 0);
    public static final CoroutineSingletons UNDECIDED = new CoroutineSingletons("UNDECIDED", 1);

    /* renamed from: RESUMED */
    public static final CoroutineSingletons f5038RESUMED = new CoroutineSingletons("RESUMED", 2);

    /* renamed from: $values */
    private static final /* synthetic */ CoroutineSingletons[] m6114$values() {
        return new CoroutineSingletons[]{COROUTINE_SUSPENDED, UNDECIDED, f5038RESUMED};
    }

    static {
        CoroutineSingletons[] coroutineSingletonsArrM6114$values = m6114$values();
        f5037$VALUES = coroutineSingletonsArrM6114$values;
        $ENTRIES = EnumEntriesKt.enumEntries(coroutineSingletonsArrM6114$values);
    }

    private CoroutineSingletons(String str, int i) {
    }

    public static EnumEntries<CoroutineSingletons> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static CoroutineSingletons m6115valueOf(String str) {
        return (CoroutineSingletons) Enum.valueOf(CoroutineSingletons.class, str);
    }

    /* renamed from: values */
    public static CoroutineSingletons[] m6116values() {
        return (CoroutineSingletons[]) f5037$VALUES.clone();
    }
}
