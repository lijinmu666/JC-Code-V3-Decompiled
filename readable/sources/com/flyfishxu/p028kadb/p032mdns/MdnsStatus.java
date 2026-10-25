package com.flyfishxu.p028kadb.p032mdns;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/MdnsStatus;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "STOPPED", "STARTING", "STARTED", "FAILED", "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class MdnsStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ MdnsStatus[] f2080$VALUES;

    /* renamed from: STOPPED */
    public static final MdnsStatus f2083STOPPED = new MdnsStatus("STOPPED", 0);
    public static final MdnsStatus STARTING = new MdnsStatus("STARTING", 1);

    /* renamed from: STARTED */
    public static final MdnsStatus f2082STARTED = new MdnsStatus("STARTED", 2);

    /* renamed from: FAILED */
    public static final MdnsStatus f2081FAILED = new MdnsStatus("FAILED", 3);

    /* renamed from: $values */
    private static final /* synthetic */ MdnsStatus[] m2250$values() {
        return new MdnsStatus[]{f2083STOPPED, STARTING, f2082STARTED, f2081FAILED};
    }

    static {
        MdnsStatus[] mdnsStatusArrM2250$values = m2250$values();
        f2080$VALUES = mdnsStatusArrM2250$values;
        $ENTRIES = EnumEntriesKt.enumEntries(mdnsStatusArrM2250$values);
    }

    private MdnsStatus(String str, int i) {
    }

    public static EnumEntries<MdnsStatus> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static MdnsStatus m2251valueOf(String str) {
        return (MdnsStatus) Enum.valueOf(MdnsStatus.class, str);
    }

    /* renamed from: values */
    public static MdnsStatus[] m2252values() {
        return (MdnsStatus[]) f2080$VALUES.clone();
    }
}
