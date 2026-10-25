package com.flyfishxu.p028kadb;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, m4988d2 = {"Lcom/flyfishxu/kadb/DelayedAckMode;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "AOSP_DEFAULT", "ENABLED", "DISABLED", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class DelayedAckMode {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ DelayedAckMode[] f2003$VALUES;
    public static final DelayedAckMode AOSP_DEFAULT = new DelayedAckMode("AOSP_DEFAULT", 0);

    /* renamed from: ENABLED */
    public static final DelayedAckMode f2004ENABLED = new DelayedAckMode("ENABLED", 1);
    public static final DelayedAckMode DISABLED = new DelayedAckMode("DISABLED", 2);

    /* renamed from: $values */
    private static final /* synthetic */ DelayedAckMode[] m2147$values() {
        return new DelayedAckMode[]{AOSP_DEFAULT, f2004ENABLED, DISABLED};
    }

    static {
        DelayedAckMode[] delayedAckModeArrM2147$values = m2147$values();
        f2003$VALUES = delayedAckModeArrM2147$values;
        $ENTRIES = EnumEntriesKt.enumEntries(delayedAckModeArrM2147$values);
    }

    private DelayedAckMode(String str, int i) {
    }

    public static EnumEntries<DelayedAckMode> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static DelayedAckMode m2148valueOf(String str) {
        return (DelayedAckMode) Enum.valueOf(DelayedAckMode.class, str);
    }

    /* renamed from: values */
    public static DelayedAckMode[] m2149values() {
        return (DelayedAckMode[]) f2003$VALUES.clone();
    }
}
