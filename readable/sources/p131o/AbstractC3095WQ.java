package p131o;

import android.os.SystemClock;

/* renamed from: o.WQ */
/* loaded from: classes.dex */
public abstract class AbstractC3095WQ {
    /* renamed from: AZxh */
    public static C2960UQ m10835AZxh(int i, int i2, long j, int i3, int i4, int i5, int i6) {
        return new C2960UQ(i, i2, i5, i3, i4, SystemClock.elapsedRealtime() - j, i6);
    }

    /* renamed from: mjFkc */
    public static void m10836mjFkc(C1626AQ c1626aq, int i, int i2, long j, int i3, int i4, int i5, int i6) {
        c1626aq.m7604wA(m10835AZxh(i, i2, j, i3, i4, i5, i6), EnumC4275oM.INPUT_IMAGE_CONSTRUCTION);
    }
}
