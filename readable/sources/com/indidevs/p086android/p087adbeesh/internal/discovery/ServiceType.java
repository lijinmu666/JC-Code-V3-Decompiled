package com.indidevs.p086android.p087adbeesh.internal.discovery;

import com.flyfishxu.p028kadb.p032mdns.MdnsServiceType;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.NoWhenBranchMatchedException;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\f\u001a\u00020\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000e"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/discovery/ServiceType;", BuildConfig.f24315FLAVOR, "protocol", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getProtocol", "()Ljava/lang/String;", "TLS_PAIRING", "TLS_CONNECT", "serviceType", "getServiceType", "toMdnsServiceType", "Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ServiceType {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ ServiceType[] f4145$VALUES;
    private final String protocol;
    public static final ServiceType TLS_PAIRING = new ServiceType("TLS_PAIRING", 0, "adb-tls-pairing");
    public static final ServiceType TLS_CONNECT = new ServiceType("TLS_CONNECT", 1, "adb-tls-connect");

    @Metadata(m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ServiceType.m4326values().length];
            try {
                iArr[ServiceType.TLS_PAIRING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ServiceType.TLS_CONNECT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: $values */
    private static final /* synthetic */ ServiceType[] m4324$values() {
        return new ServiceType[]{TLS_PAIRING, TLS_CONNECT};
    }

    static {
        ServiceType[] serviceTypeArrM4324$values = m4324$values();
        f4145$VALUES = serviceTypeArrM4324$values;
        $ENTRIES = EnumEntriesKt.enumEntries(serviceTypeArrM4324$values);
    }

    private ServiceType(String str, int i, String str2) {
        this.protocol = str2;
    }

    public static EnumEntries<ServiceType> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static ServiceType m4325valueOf(String str) {
        return (ServiceType) Enum.valueOf(ServiceType.class, str);
    }

    /* renamed from: values */
    public static ServiceType[] m4326values() {
        return (ServiceType[]) f4145$VALUES.clone();
    }

    public final String getProtocol() {
        return this.protocol;
    }

    public final String getServiceType() {
        return '_' + this.protocol + "._tcp";
    }

    public final MdnsServiceType toMdnsServiceType() {
        int i = WhenMappings.$EnumSwitchMapping$0[ordinal()];
        if (i == 1) {
            return MdnsServiceType.TLS_PAIRING;
        }
        if (i == 2) {
            return MdnsServiceType.TLS_CONNECT;
        }
        throw new NoWhenBranchMatchedException();
    }
}
