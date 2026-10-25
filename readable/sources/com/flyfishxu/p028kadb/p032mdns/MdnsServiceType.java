package com.flyfishxu.p028kadb.p032mdns;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", BuildConfig.f24315FLAVOR, "dnsType", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getDnsType", "()Ljava/lang/String;", "ADB", "TLS_CONNECT", "TLS_PAIRING", "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class MdnsServiceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ MdnsServiceType[] f2077$VALUES;

    /* renamed from: ADB */
    public static final MdnsServiceType f2078ADB = new MdnsServiceType("ADB", 0, "_adb._tcp");
    public static final MdnsServiceType TLS_CONNECT = new MdnsServiceType("TLS_CONNECT", 1, "_adb-tls-connect._tcp");
    public static final MdnsServiceType TLS_PAIRING = new MdnsServiceType("TLS_PAIRING", 2, "_adb-tls-pairing._tcp");
    private final String dnsType;

    /* renamed from: $values */
    private static final /* synthetic */ MdnsServiceType[] m2247$values() {
        return new MdnsServiceType[]{f2078ADB, TLS_CONNECT, TLS_PAIRING};
    }

    static {
        MdnsServiceType[] mdnsServiceTypeArrM2247$values = m2247$values();
        f2077$VALUES = mdnsServiceTypeArrM2247$values;
        $ENTRIES = EnumEntriesKt.enumEntries(mdnsServiceTypeArrM2247$values);
    }

    private MdnsServiceType(String str, int i, String str2) {
        this.dnsType = str2;
    }

    public static EnumEntries<MdnsServiceType> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static MdnsServiceType m2248valueOf(String str) {
        return (MdnsServiceType) Enum.valueOf(MdnsServiceType.class, str);
    }

    /* renamed from: values */
    public static MdnsServiceType[] m2249values() {
        return (MdnsServiceType[]) f2077$VALUES.clone();
    }

    public final String getDnsType() {
        return this.dnsType;
    }
}
