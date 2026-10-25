package p094kotlin.p101io;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m4988d2 = {"Lkotlin/io/OnErrorAction;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SKIP", "TERMINATE", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class OnErrorAction {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ OnErrorAction[] f5081$VALUES;

    /* renamed from: SKIP */
    public static final OnErrorAction f5082SKIP = new OnErrorAction("SKIP", 0);
    public static final OnErrorAction TERMINATE = new OnErrorAction("TERMINATE", 1);

    /* renamed from: $values */
    private static final /* synthetic */ OnErrorAction[] m6205$values() {
        return new OnErrorAction[]{f5082SKIP, TERMINATE};
    }

    static {
        OnErrorAction[] onErrorActionArrM6205$values = m6205$values();
        f5081$VALUES = onErrorActionArrM6205$values;
        $ENTRIES = EnumEntriesKt.enumEntries(onErrorActionArrM6205$values);
    }

    private OnErrorAction(String str, int i) {
    }

    public static EnumEntries<OnErrorAction> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static OnErrorAction m6206valueOf(String str) {
        return (OnErrorAction) Enum.valueOf(OnErrorAction.class, str);
    }

    /* renamed from: values */
    public static OnErrorAction[] m6207values() {
        return (OnErrorAction[]) f5081$VALUES.clone();
    }
}
