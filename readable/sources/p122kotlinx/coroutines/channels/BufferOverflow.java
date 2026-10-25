package p122kotlinx.coroutines.channels;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m4988d2 = {"Lkotlinx/coroutines/channels/BufferOverflow;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SUSPEND", "DROP_OLDEST", "DROP_LATEST", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class BufferOverflow {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ BufferOverflow[] f5600$VALUES;

    /* renamed from: SUSPEND */
    public static final BufferOverflow f5601SUSPEND = new BufferOverflow("SUSPEND", 0);
    public static final BufferOverflow DROP_OLDEST = new BufferOverflow("DROP_OLDEST", 1);
    public static final BufferOverflow DROP_LATEST = new BufferOverflow("DROP_LATEST", 2);

    /* renamed from: $values */
    private static final /* synthetic */ BufferOverflow[] m7056$values() {
        return new BufferOverflow[]{f5601SUSPEND, DROP_OLDEST, DROP_LATEST};
    }

    static {
        BufferOverflow[] bufferOverflowArrM7056$values = m7056$values();
        f5600$VALUES = bufferOverflowArrM7056$values;
        $ENTRIES = EnumEntriesKt.enumEntries(bufferOverflowArrM7056$values);
    }

    private BufferOverflow(String str, int i) {
    }

    public static EnumEntries<BufferOverflow> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static BufferOverflow m7057valueOf(String str) {
        return (BufferOverflow) Enum.valueOf(BufferOverflow.class, str);
    }

    /* renamed from: values */
    public static BufferOverflow[] m7058values() {
        return (BufferOverflow[]) f5600$VALUES.clone();
    }
}
