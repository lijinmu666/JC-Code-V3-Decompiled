package p131o;

import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

/* renamed from: o.huTpC */
/* loaded from: classes.dex */
public class C3850huTpC {

    /* renamed from: mjFkc */
    public final Object f14076mjFkc;

    /* renamed from: o.huTpC$AZxh */
    public static class AZxh extends mjFkc {
        public AZxh(C3850huTpC c3850huTpC) {
            super(c3850huTpC);
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public void addExtraDataToAccessibilityNodeInfo(int i, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f14077mjFkc.m12239mjFkc(i, C2971Ucbh.m10526XtE(accessibilityNodeInfo), str, bundle);
        }
    }

    /* renamed from: o.huTpC$mjFkc */
    public static class mjFkc extends AccessibilityNodeProvider {

        /* renamed from: mjFkc */
        public final C3850huTpC f14077mjFkc;

        public mjFkc(C3850huTpC c3850huTpC) {
            this.f14077mjFkc = c3850huTpC;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i) {
            C2971Ucbh c2971UcbhMo8221AZxh = this.f14077mjFkc.mo8221AZxh(i);
            if (c2971UcbhMo8221AZxh == null) {
                return null;
            }
            return c2971UcbhMo8221AZxh.m10565XFUzSY();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public List findAccessibilityNodeInfosByText(String str, int i) {
            List listM12240wA = this.f14077mjFkc.m12240wA(str, i);
            if (listM12240wA == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = listM12240wA.size();
            for (int i2 = 0; i2 < size; i2++) {
                arrayList.add(((C2971Ucbh) listM12240wA.get(i2)).m10565XFUzSY());
            }
            return arrayList;
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public AccessibilityNodeInfo findFocus(int i) {
            C2971Ucbh c2971UcbhMo8223ZfxDd = this.f14077mjFkc.mo8223ZfxDd(i);
            if (c2971UcbhMo8223ZfxDd == null) {
                return null;
            }
            return c2971UcbhMo8223ZfxDd.m10565XFUzSY();
        }

        @Override // android.view.accessibility.AccessibilityNodeProvider
        public boolean performAction(int i, int i2, Bundle bundle) {
            return this.f14077mjFkc.mo8222JHa(i, i2, bundle);
        }
    }

    public C3850huTpC() {
        this.f14076mjFkc = new AZxh(this);
    }

    /* renamed from: AZxh */
    public C2971Ucbh mo8221AZxh(int i) {
        return null;
    }

    /* renamed from: JHa */
    public boolean mo8222JHa(int i, int i2, Bundle bundle) {
        return false;
    }

    /* renamed from: KLFTb */
    public Object m12238KLFTb() {
        return this.f14076mjFkc;
    }

    /* renamed from: ZfxDd */
    public C2971Ucbh mo8223ZfxDd(int i) {
        return null;
    }

    /* renamed from: mjFkc */
    public void m12239mjFkc(int i, C2971Ucbh c2971Ucbh, String str, Bundle bundle) {
    }

    /* renamed from: wA */
    public List m12240wA(String str, int i) {
        return null;
    }

    public C3850huTpC(Object obj) {
        this.f14076mjFkc = obj;
    }
}
