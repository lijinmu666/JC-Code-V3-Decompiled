package p131o;

import android.view.View;
import android.view.accessibility.AccessibilityRecord;

/* renamed from: o.Gd */
/* loaded from: classes.dex */
public abstract class AbstractC2042Gd {
    /* renamed from: AZxh */
    public static void m8446AZxh(AccessibilityRecord accessibilityRecord, int i) {
        accessibilityRecord.setMaxScrollY(i);
    }

    /* renamed from: mjFkc */
    public static void m8447mjFkc(AccessibilityRecord accessibilityRecord, int i) {
        accessibilityRecord.setMaxScrollX(i);
    }

    /* renamed from: wA */
    public static void m8448wA(AccessibilityRecord accessibilityRecord, View view, int i) {
        accessibilityRecord.setSource(view, i);
    }
}
