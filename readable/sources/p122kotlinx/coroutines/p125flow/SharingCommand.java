package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m4988d2 = {"Lkotlinx/coroutines/flow/SharingCommand;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "START", "STOP", "STOP_AND_RESET_REPLAY_CACHE", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class SharingCommand {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ SharingCommand[] f7014$VALUES;

    /* renamed from: START */
    public static final SharingCommand f7015START = new SharingCommand("START", 0);

    /* renamed from: STOP */
    public static final SharingCommand f7016STOP = new SharingCommand("STOP", 1);
    public static final SharingCommand STOP_AND_RESET_REPLAY_CACHE = new SharingCommand("STOP_AND_RESET_REPLAY_CACHE", 2);

    /* renamed from: $values */
    private static final /* synthetic */ SharingCommand[] m7381$values() {
        return new SharingCommand[]{f7015START, f7016STOP, STOP_AND_RESET_REPLAY_CACHE};
    }

    static {
        SharingCommand[] sharingCommandArrM7381$values = m7381$values();
        f7014$VALUES = sharingCommandArrM7381$values;
        $ENTRIES = EnumEntriesKt.enumEntries(sharingCommandArrM7381$values);
    }

    private SharingCommand(String str, int i) {
    }

    public static EnumEntries<SharingCommand> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static SharingCommand m7382valueOf(String str) {
        return (SharingCommand) Enum.valueOf(SharingCommand.class, str);
    }

    /* renamed from: values */
    public static SharingCommand[] m7383values() {
        return (SharingCommand[]) f7014$VALUES.clone();
    }
}
