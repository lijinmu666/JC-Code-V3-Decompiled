package com.indidevs.p086android.p087adbeesh.p089pairing;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
@Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/pairing/PairingStage;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "SEARCHING", "AWAITING_CODE", "CODE_SUBMITTED", "PAIRING", "SUCCESS", "ERROR", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class PairingStage {
    private static final /* synthetic */ EnumEntries $ENTRIES;

    /* renamed from: $VALUES */
    private static final /* synthetic */ PairingStage[] f4196$VALUES;
    public static final PairingStage SEARCHING = new PairingStage("SEARCHING", 0);
    public static final PairingStage AWAITING_CODE = new PairingStage("AWAITING_CODE", 1);
    public static final PairingStage CODE_SUBMITTED = new PairingStage("CODE_SUBMITTED", 2);

    /* renamed from: PAIRING */
    public static final PairingStage f4198PAIRING = new PairingStage("PAIRING", 3);

    /* renamed from: SUCCESS */
    public static final PairingStage f4199SUCCESS = new PairingStage("SUCCESS", 4);

    /* renamed from: ERROR */
    public static final PairingStage f4197ERROR = new PairingStage("ERROR", 5);

    /* renamed from: $values */
    private static final /* synthetic */ PairingStage[] m4366$values() {
        return new PairingStage[]{SEARCHING, AWAITING_CODE, CODE_SUBMITTED, f4198PAIRING, f4199SUCCESS, f4197ERROR};
    }

    static {
        PairingStage[] pairingStageArrM4366$values = m4366$values();
        f4196$VALUES = pairingStageArrM4366$values;
        $ENTRIES = EnumEntriesKt.enumEntries(pairingStageArrM4366$values);
    }

    private PairingStage(String str, int i) {
    }

    public static EnumEntries<PairingStage> getEntries() {
        return $ENTRIES;
    }

    /* renamed from: valueOf */
    public static PairingStage m4367valueOf(String str) {
        return (PairingStage) Enum.valueOf(PairingStage.class, str);
    }

    /* renamed from: values */
    public static PairingStage[] m4368values() {
        return (PairingStage[]) f4196$VALUES.clone();
    }
}
