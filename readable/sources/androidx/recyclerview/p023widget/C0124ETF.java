package androidx.recyclerview.p023widget;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import java.util.Map;
import java.util.WeakHashMap;
import p131o.AbstractC2876T9;
import p131o.C2454MiMN;
import p131o.C2971Ucbh;
import p131o.C3850huTpC;

/* renamed from: androidx.recyclerview.widget.ETF */
/* loaded from: classes.dex */
public class C0124ETF extends C2454MiMN {

    /* renamed from: KLFTb */
    public final mjFkc f1450KLFTb;

    /* renamed from: ZfxDd */
    public final RecyclerView f1451ZfxDd;

    /* renamed from: androidx.recyclerview.widget.ETF$mjFkc */
    public static class mjFkc extends C2454MiMN {

        /* renamed from: KLFTb */
        public Map f1452KLFTb = new WeakHashMap();

        /* renamed from: ZfxDd */
        public final C0124ETF f1453ZfxDd;

        public mjFkc(C0124ETF c0124etf) {
            this.f1453ZfxDd = c0124etf;
        }

        @Override // p131o.C2454MiMN
        /* renamed from: AZxh */
        public C3850huTpC mo1220AZxh(View view) {
            C2454MiMN c2454MiMN = (C2454MiMN) this.f1452KLFTb.get(view);
            return c2454MiMN != null ? c2454MiMN.mo1220AZxh(view) : super.mo1220AZxh(view);
        }

        @Override // p131o.C2454MiMN
        /* renamed from: Dt */
        public boolean mo618Dt(View view, int i, Bundle bundle) {
            if (this.f1453ZfxDd.m1219rkYL() || this.f1453ZfxDd.f1451ZfxDd.getLayoutManager() == null) {
                return super.mo618Dt(view, i, bundle);
            }
            C2454MiMN c2454MiMN = (C2454MiMN) this.f1452KLFTb.get(view);
            if (c2454MiMN != null) {
                if (c2454MiMN.mo618Dt(view, i, bundle)) {
                    return true;
                }
            } else if (super.mo618Dt(view, i, bundle)) {
                return true;
            }
            return this.f1453ZfxDd.f1451ZfxDd.getLayoutManager().m1785knzZ(view, i, bundle);
        }

        @Override // p131o.C2454MiMN
        /* renamed from: JHa */
        public void mo619JHa(View view, AccessibilityEvent accessibilityEvent) {
            C2454MiMN c2454MiMN = (C2454MiMN) this.f1452KLFTb.get(view);
            if (c2454MiMN != null) {
                c2454MiMN.mo619JHa(view, accessibilityEvent);
            } else {
                super.mo619JHa(view, accessibilityEvent);
            }
        }

        @Override // p131o.C2454MiMN
        /* renamed from: MiMN */
        public void mo1221MiMN(View view, AccessibilityEvent accessibilityEvent) {
            C2454MiMN c2454MiMN = (C2454MiMN) this.f1452KLFTb.get(view);
            if (c2454MiMN != null) {
                c2454MiMN.mo1221MiMN(view, accessibilityEvent);
            } else {
                super.mo1221MiMN(view, accessibilityEvent);
            }
        }

        @Override // p131o.C2454MiMN
        /* renamed from: VA */
        public void mo1222VA(View view, int i) {
            C2454MiMN c2454MiMN = (C2454MiMN) this.f1452KLFTb.get(view);
            if (c2454MiMN != null) {
                c2454MiMN.mo1222VA(view, i);
            } else {
                super.mo1222VA(view, i);
            }
        }

        /* renamed from: YoKzxo */
        public C2454MiMN m1223YoKzxo(View view) {
            return (C2454MiMN) this.f1452KLFTb.remove(view);
        }

        @Override // p131o.C2454MiMN
        /* renamed from: lgHUyS */
        public void mo1224lgHUyS(View view, AccessibilityEvent accessibilityEvent) {
            C2454MiMN c2454MiMN = (C2454MiMN) this.f1452KLFTb.get(view);
            if (c2454MiMN != null) {
                c2454MiMN.mo1224lgHUyS(view, accessibilityEvent);
            } else {
                super.mo1224lgHUyS(view, accessibilityEvent);
            }
        }

        @Override // p131o.C2454MiMN
        /* renamed from: mjFkc */
        public boolean mo1225mjFkc(View view, AccessibilityEvent accessibilityEvent) {
            C2454MiMN c2454MiMN = (C2454MiMN) this.f1452KLFTb.get(view);
            return c2454MiMN != null ? c2454MiMN.mo1225mjFkc(view, accessibilityEvent) : super.mo1225mjFkc(view, accessibilityEvent);
        }

        @Override // p131o.C2454MiMN
        /* renamed from: qdMbNW */
        public boolean mo1226qdMbNW(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            C2454MiMN c2454MiMN = (C2454MiMN) this.f1452KLFTb.get(viewGroup);
            return c2454MiMN != null ? c2454MiMN.mo1226qdMbNW(viewGroup, view, accessibilityEvent) : super.mo1226qdMbNW(viewGroup, view, accessibilityEvent);
        }

        /* renamed from: rkYL */
        public void m1227rkYL(View view) {
            C2454MiMN c2454MiMNM10286qdMbNW = AbstractC2876T9.m10286qdMbNW(view);
            if (c2454MiMNM10286qdMbNW == null || c2454MiMNM10286qdMbNW == this) {
                return;
            }
            this.f1452KLFTb.put(view, c2454MiMNM10286qdMbNW);
        }

        @Override // p131o.C2454MiMN
        /* renamed from: xJ */
        public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
            if (this.f1453ZfxDd.m1219rkYL() || this.f1453ZfxDd.f1451ZfxDd.getLayoutManager() == null) {
                super.mo620xJ(view, c2971Ucbh);
                return;
            }
            this.f1453ZfxDd.f1451ZfxDd.getLayoutManager().m1754SKTn(view, c2971Ucbh);
            C2454MiMN c2454MiMN = (C2454MiMN) this.f1452KLFTb.get(view);
            if (c2454MiMN != null) {
                c2454MiMN.mo620xJ(view, c2971Ucbh);
            } else {
                super.mo620xJ(view, c2971Ucbh);
            }
        }
    }

    public C0124ETF(RecyclerView recyclerView) {
        this.f1451ZfxDd = recyclerView;
        C2454MiMN c2454MiMNM1218YoKzxo = m1218YoKzxo();
        if (c2454MiMNM1218YoKzxo == null || !(c2454MiMNM1218YoKzxo instanceof mjFkc)) {
            this.f1450KLFTb = new mjFkc(this);
        } else {
            this.f1450KLFTb = (mjFkc) c2454MiMNM1218YoKzxo;
        }
    }

    @Override // p131o.C2454MiMN
    /* renamed from: Dt */
    public boolean mo618Dt(View view, int i, Bundle bundle) {
        if (super.mo618Dt(view, i, bundle)) {
            return true;
        }
        if (m1219rkYL() || this.f1451ZfxDd.getLayoutManager() == null) {
            return false;
        }
        return this.f1451ZfxDd.getLayoutManager().m1733IvRQOa(i, bundle);
    }

    @Override // p131o.C2454MiMN
    /* renamed from: JHa */
    public void mo619JHa(View view, AccessibilityEvent accessibilityEvent) {
        super.mo619JHa(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || m1219rkYL()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().mo1308Dp(accessibilityEvent);
        }
    }

    /* renamed from: YoKzxo */
    public C2454MiMN m1218YoKzxo() {
        return this.f1450KLFTb;
    }

    /* renamed from: rkYL */
    public boolean m1219rkYL() {
        return this.f1451ZfxDd.m1462SmIWf();
    }

    @Override // p131o.C2454MiMN
    /* renamed from: xJ */
    public void mo620xJ(View view, C2971Ucbh c2971Ucbh) {
        super.mo620xJ(view, c2971Ucbh);
        if (m1219rkYL() || this.f1451ZfxDd.getLayoutManager() == null) {
            return;
        }
        this.f1451ZfxDd.getLayoutManager().m1753Rc(c2971Ucbh);
    }
}
