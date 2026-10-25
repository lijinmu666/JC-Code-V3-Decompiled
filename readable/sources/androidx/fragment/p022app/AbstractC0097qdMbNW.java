package androidx.fragment.p022app;

import android.view.View;
import java.util.ArrayList;
import p131o.AbstractC2318KbpP;
import p131o.C3231YRhJjQ;
import p131o.C4633tjSezt;
import p131o.C5035zo;

/* renamed from: androidx.fragment.app.qdMbNW */
/* loaded from: classes.dex */
public abstract class AbstractC0097qdMbNW {

    /* renamed from: mjFkc */
    public static final int[] f1285mjFkc = {0, 3, 0, 1, 5, 4, 7, 6, 9, 8, 10};

    /* renamed from: AZxh */
    public static final AbstractC2318KbpP f1284AZxh = new C5035zo();

    /* renamed from: wA */
    public static final AbstractC2318KbpP f1286wA = m985AZxh();

    /* renamed from: androidx.fragment.app.qdMbNW$mjFkc */
    public interface mjFkc {
    }

    /* renamed from: AZxh */
    public static AbstractC2318KbpP m985AZxh() {
        try {
            return (AbstractC2318KbpP) C3231YRhJjQ.class.getDeclaredConstructor(null).newInstance(null);
        } catch (Exception unused) {
            return null;
        }
    }

    /* renamed from: ZfxDd */
    public static void m986ZfxDd(ArrayList arrayList, int i) {
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((View) arrayList.get(size)).setVisibility(i);
        }
    }

    /* renamed from: mjFkc */
    public static void m987mjFkc(Fragment fragment, Fragment fragment2, boolean z, C4633tjSezt c4633tjSezt, boolean z2) {
        if (z) {
            fragment2.m812fehf();
        } else {
            fragment.m812fehf();
        }
    }

    /* renamed from: wA */
    public static void m988wA(C4633tjSezt c4633tjSezt, C4633tjSezt c4633tjSezt2) {
        for (int iM10827size = c4633tjSezt.m10827size() - 1; iM10827size >= 0; iM10827size--) {
            if (!c4633tjSezt2.containsKey((String) c4633tjSezt.m10813MiMN(iM10827size))) {
                c4633tjSezt.m10810ETF(iM10827size);
            }
        }
    }
}
