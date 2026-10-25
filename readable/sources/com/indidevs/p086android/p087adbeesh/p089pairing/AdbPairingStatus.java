package com.indidevs.p086android.p087adbeesh.p089pairing;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/AdbPairingStatus;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "IDLE", "DISCOVERING", "AWAITING_CODE", "PAIRING", "PAIRED", "ERROR", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AdbPairingStatus {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ AdbPairingStatus[] f4189$VALUES;

    /* renamed from: IDLE */
    public static final AdbPairingStatus f4191IDLE = new AdbPairingStatus("IDLE", 0);
    public static final AdbPairingStatus DISCOVERING = new AdbPairingStatus("DISCOVERING", 1);
    public static final AdbPairingStatus AWAITING_CODE = new AdbPairingStatus("AWAITING_CODE", 2);

    /* renamed from: PAIRING */
    public static final AdbPairingStatus f4193PAIRING = new AdbPairingStatus("PAIRING", 3);

    /* renamed from: PAIRED */
    public static final AdbPairingStatus f4192PAIRED = new AdbPairingStatus("PAIRED", 4);

    /* renamed from: ERROR */
    public static final AdbPairingStatus f4190ERROR = new AdbPairingStatus("ERROR", 5);

    /* renamed from: $values */
    private static final /* synthetic */ AdbPairingStatus[] m4359$values() {
        return new AdbPairingStatus[]{f4191IDLE, DISCOVERING, AWAITING_CODE, f4193PAIRING, f4192PAIRED, f4190ERROR};
    }

    static {
        AdbPairingStatus[] adbPairingStatusArrM4359$values = m4359$values();
        f4189$VALUES = adbPairingStatusArrM4359$values;
        $ENTRIES = EnumEntriesKt.enumEntries(adbPairingStatusArrM4359$values);
    }

    private AdbPairingStatus(String str, int i) {
    }

    public static EnumEntries<AdbPairingStatus> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static AdbPairingStatus m4360valueOf(String str) {
        return (AdbPairingStatus) Enum.valueOf(AdbPairingStatus.class, str);
    }

    /* renamed from: values */
    public static AdbPairingStatus[] m4361values() {
        return (AdbPairingStatus[]) f4189$VALUES.clone();
    }
}
