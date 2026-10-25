package p131o;

import android.util.Log;
import androidx.fragment.p022app.AbstractC0093KLFTb;
import androidx.fragment.p022app.Fragment;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import p131o.C3829ha;

/* renamed from: o.bzZHlx */
/* loaded from: classes.dex */
public final class C3467bzZHlx extends AbstractC3764ga {

    /* renamed from: ETF */
    public static final C3829ha.mjFkc f13187ETF = new mjFkc();

    /* renamed from: xJ */
    public final boolean f13194xJ;

    /* renamed from: ZfxDd */
    public final HashMap f13191ZfxDd = new HashMap();

    /* renamed from: KLFTb */
    public final HashMap f13190KLFTb = new HashMap();

    /* renamed from: JHa */
    public final HashMap f13189JHa = new HashMap();

    /* renamed from: lgHUyS */
    public boolean f13192lgHUyS = false;

    /* renamed from: qdMbNW */
    public boolean f13193qdMbNW = false;

    /* renamed from: Dt */
    public boolean f13188Dt = false;

    /* renamed from: o.bzZHlx$mjFkc */
    public class mjFkc implements C3829ha.mjFkc {
        @Override // p131o.C3829ha.mjFkc
        /* renamed from: mjFkc */
        public AbstractC3764ga mo11588mjFkc(Class cls) {
            return new C3467bzZHlx(true);
        }
    }

    public C3467bzZHlx(boolean z) {
        this.f13194xJ = z;
    }

    @Override // p131o.AbstractC3764ga
    /* renamed from: AZxh */
    public void mo11578AZxh() {
        if (AbstractC0093KLFTb.m857dm(3)) {
            Log.d("FragmentManager", "onCleared called for " + this);
        }
        this.f13192lgHUyS = true;
    }

    /* renamed from: Dt */
    public boolean m11579Dt(Fragment fragment) {
        if (this.f13191ZfxDd.containsKey(fragment.f1117KLFTb)) {
            return this.f13194xJ ? this.f13192lgHUyS : !this.f13193qdMbNW;
        }
        return true;
    }

    /* renamed from: JHa */
    public Collection m11580JHa() {
        return new ArrayList(this.f13191ZfxDd.values());
    }

    /* renamed from: KLFTb */
    public C3467bzZHlx m11581KLFTb(Fragment fragment) {
        C3467bzZHlx c3467bzZHlx = (C3467bzZHlx) this.f13190KLFTb.get(fragment.f1117KLFTb);
        if (c3467bzZHlx != null) {
            return c3467bzZHlx;
        }
        C3467bzZHlx c3467bzZHlx2 = new C3467bzZHlx(this.f13194xJ);
        this.f13190KLFTb.put(fragment.f1117KLFTb, c3467bzZHlx2);
        return c3467bzZHlx2;
    }

    /* renamed from: ZfxDd */
    public Fragment m11582ZfxDd(String str) {
        return (Fragment) this.f13191ZfxDd.get(str);
    }

    /* renamed from: equals */
    public boolean m11583equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C3467bzZHlx.class != obj.getClass()) {
            return false;
        }
        C3467bzZHlx c3467bzZHlx = (C3467bzZHlx) obj;
        return this.f13191ZfxDd.equals(c3467bzZHlx.f13191ZfxDd) && this.f13190KLFTb.equals(c3467bzZHlx.f13190KLFTb) && this.f13189JHa.equals(c3467bzZHlx.f13189JHa);
    }

    public int hashCode() {
        return (((this.f13191ZfxDd.hashCode() * 31) + this.f13190KLFTb.hashCode()) * 31) + this.f13189JHa.hashCode();
    }

    /* renamed from: lgHUyS */
    public void m11584lgHUyS(Fragment fragment) {
        if (this.f13188Dt) {
            if (AbstractC0093KLFTb.m857dm(2)) {
                Log.v("FragmentManager", "Ignoring removeRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f13191ZfxDd.remove(fragment.f1117KLFTb) == null || !AbstractC0093KLFTb.m857dm(2)) {
                return;
            }
            Log.v("FragmentManager", "Updating retained Fragments: Removed " + fragment);
        }
    }

    /* renamed from: qdMbNW */
    public void m11585qdMbNW(boolean z) {
        this.f13188Dt = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.f13191ZfxDd.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.f13190KLFTb.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.f13189JHa.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }

    /* renamed from: wA */
    public void m11586wA(Fragment fragment) {
        if (this.f13188Dt) {
            if (AbstractC0093KLFTb.m857dm(2)) {
                Log.v("FragmentManager", "Ignoring addRetainedFragment as the state is already saved");
            }
        } else {
            if (this.f13191ZfxDd.containsKey(fragment.f1117KLFTb)) {
                return;
            }
            this.f13191ZfxDd.put(fragment.f1117KLFTb, fragment);
            if (AbstractC0093KLFTb.m857dm(2)) {
                Log.v("FragmentManager", "Updating retained Fragments: Added " + fragment);
            }
        }
    }

    /* renamed from: xJ */
    public C3893ia m11587xJ(Fragment fragment) {
        C3893ia c3893ia = (C3893ia) this.f13189JHa.get(fragment.f1117KLFTb);
        if (c3893ia != null) {
            return c3893ia;
        }
        C3893ia c3893ia2 = new C3893ia();
        this.f13189JHa.put(fragment.f1117KLFTb, c3893ia2);
        return c3893ia2;
    }
}
