package p131o;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.p023widget.RecyclerView;
import com.p038google.p039android.material.datepicker.C0253AZxh;
import java.util.Locale;

/* renamed from: o.Db */
/* loaded from: classes.dex */
public class C1834Db extends RecyclerView.AbstractC0156lgHUyS {

    /* renamed from: ZfxDd */
    public final C0253AZxh f7881ZfxDd;

    /* renamed from: o.Db$mjFkc */
    public static class mjFkc extends RecyclerView.AbstractC0157mByQ {

        /* renamed from: eyqo */
        public final TextView f7882eyqo;

        public mjFkc(TextView textView) {
            super(textView);
            this.f7882eyqo = textView;
        }
    }

    public C1834Db(C0253AZxh c0253AZxh) {
        this.f7881ZfxDd = c0253AZxh;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0156lgHUyS
    /* renamed from: Gd, reason: merged with bridge method [inline-methods] */
    public mjFkc mo1663VA(ViewGroup viewGroup, int i) {
        return new mjFkc((TextView) LayoutInflater.from(viewGroup.getContext()).inflate(AbstractC2007G4.f8321fehf, viewGroup, false));
    }

    /* renamed from: Ucbh */
    public int m8036Ucbh(int i) {
        return this.f7881ZfxDd.m2895IyS().m2924xJ().f16769wA + i;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0156lgHUyS
    /* renamed from: ZfxDd */
    public int mo1665ZfxDd() {
        return this.f7881ZfxDd.m2895IyS().m2921lgHUyS();
    }

    /* renamed from: eyqo */
    public int m8037eyqo(int i) {
        return i - this.f7881ZfxDd.m2895IyS().m2924xJ().f16769wA;
    }

    @Override // androidx.recyclerview.p023widget.RecyclerView.AbstractC0156lgHUyS
    /* renamed from: huTpC, reason: merged with bridge method [inline-methods] */
    public void mo1656Dt(mjFkc mjfkc, int i) {
        int iM8036Ucbh = m8036Ucbh(i);
        mjfkc.f7882eyqo.setText(String.format(Locale.getDefault(), "%d", Integer.valueOf(iM8036Ucbh)));
        TextView textView = mjfkc.f7882eyqo;
        textView.setContentDescription(AbstractC5019zZ.m14114KLFTb(textView.getContext(), iM8036Ucbh));
        C4715uxlM c4715uxlMM2905tAfC = this.f7881ZfxDd.m2905tAfC();
        if (AbstractC1870E9.m8113JHa().get(1) == iM8036Ucbh) {
            C3060Vu c3060Vu = c4715uxlMM2905tAfC.f16935JHa;
        } else {
            C3060Vu c3060Vu2 = c4715uxlMM2905tAfC.f16937ZfxDd;
        }
        this.f7881ZfxDd.m2900dGDT();
        throw null;
    }
}
