package p131o;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.p038google.p039android.material.datepicker.C0256mjFkc;

/* renamed from: o.Q1 */
/* loaded from: classes.dex */
public final class C2669Q1<S> extends AbstractC4789w3 {

    /* renamed from: WGXroI */
    public C0256mjFkc f10145WGXroI;

    /* renamed from: nxI */
    public int f10146nxI;

    /* renamed from: o.Q1$mjFkc */
    public class mjFkc extends AbstractC3601e3 {
        public mjFkc() {
        }
    }

    /* renamed from: SKTn */
    public static C2669Q1 m9995SKTn(InterfaceC2981UlIi interfaceC2981UlIi, int i, C0256mjFkc c0256mjFkc) {
        C2669Q1 c2669q1 = new C2669Q1();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i);
        bundle.putParcelable("DATE_SELECTOR_KEY", interfaceC2981UlIi);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", c0256mjFkc);
        c2669q1.m833tISON(bundle);
        return c2669q1;
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: JYn */
    public void mo772JYn(Bundle bundle) {
        super.mo772JYn(bundle);
        if (bundle == null) {
            bundle = m789VA();
        }
        this.f10146nxI = bundle.getInt("THEME_RES_ID_KEY");
        AbstractC4793w7.m13819mjFkc(bundle.getParcelable("DATE_SELECTOR_KEY"));
        this.f10145WGXroI = (C0256mjFkc) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    @Override // androidx.fragment.p022app.Fragment
    /* renamed from: nxI */
    public View mo826nxI(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        layoutInflater.cloneInContext(new ContextThemeWrapper(m801YoKzxo(), this.f10146nxI));
        new mjFkc();
        throw null;
    }
}
