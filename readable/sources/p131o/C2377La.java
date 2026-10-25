package p131o;

import android.view.View;
import android.view.WindowId;

/* renamed from: o.La */
/* loaded from: classes.dex */
public class C2377La implements InterfaceC2445Ma {

    /* renamed from: mjFkc */
    public final WindowId f9459mjFkc;

    public C2377La(View view) {
        this.f9459mjFkc = view.getWindowId();
    }

    /* renamed from: equals */
    public boolean m9370equals(Object obj) {
        return (obj instanceof C2377La) && ((C2377La) obj).f9459mjFkc.equals(this.f9459mjFkc);
    }

    public int hashCode() {
        return this.f9459mjFkc.hashCode();
    }
}
