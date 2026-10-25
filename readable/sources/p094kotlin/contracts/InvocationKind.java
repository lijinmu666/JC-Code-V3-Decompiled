package p094kotlin.contracts;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.ContractsDsl;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@SinceKotlin(m5061version = "1.3")
@ContractsDsl
@Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0006\b\u0004\u0012\u0002\b\u0005j\u0006\b\u0006\u0012\u0002\b\u0005j\u0006\b\u0007\u0012\u0002\b\u0005j\u0006\b\b\u0012\u0002\b\u0005Ê\u0001\u0002\b\u0005Ê\u0001\u0002\b\nÊ\u0001\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r¨\u0006\t"}, m4988d2 = {"Lkotlin/contracts/InvocationKind;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "AT_MOST_ONCE", "Lkotlin/internal/ContractsDsl;", "AT_LEAST_ONCE", "EXACTLY_ONCE", "UNKNOWN", "kotlin-stdlib", "Lkotlin/contracts/ExperimentalContracts;", "Lkotlin/SinceKotlin;", "version", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@ExperimentalContracts
/* loaded from: classes.dex */
public final class InvocationKind {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ InvocationKind[] f5029$VALUES;

    @ContractsDsl
    public static final InvocationKind AT_MOST_ONCE = new InvocationKind("AT_MOST_ONCE", 0);

    @ContractsDsl
    public static final InvocationKind AT_LEAST_ONCE = new InvocationKind("AT_LEAST_ONCE", 1);

    @ContractsDsl
    public static final InvocationKind EXACTLY_ONCE = new InvocationKind("EXACTLY_ONCE", 2);

    /* renamed from: UNKNOWN */
    @ContractsDsl
    public static final InvocationKind f5030UNKNOWN = new InvocationKind("UNKNOWN", 3);

    /* renamed from: $values */
    private static final /* synthetic */ InvocationKind[] m6093$values() {
        return new InvocationKind[]{AT_MOST_ONCE, AT_LEAST_ONCE, EXACTLY_ONCE, f5030UNKNOWN};
    }

    static {
        InvocationKind[] invocationKindArrM6093$values = m6093$values();
        f5029$VALUES = invocationKindArrM6093$values;
        $ENTRIES = EnumEntriesKt.enumEntries(invocationKindArrM6093$values);
    }

    private InvocationKind(String str, int i) {
    }

    public static EnumEntries<InvocationKind> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static InvocationKind m6094valueOf(String str) {
        return (InvocationKind) Enum.valueOf(InvocationKind.class, str);
    }

    /* renamed from: values */
    public static InvocationKind[] m6095values() {
        return (InvocationKind[]) f5029$VALUES.clone();
    }
}
