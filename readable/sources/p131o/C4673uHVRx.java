package p131o;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* renamed from: o.uHVRx */
/* loaded from: classes.dex */
public class C4673uHVRx extends AbstractC1893ETF {

    /* renamed from: CREATOR */
    public static final Parcelable.Creator<C4673uHVRx> f16836CREATOR = new C4691uc();

    /* renamed from: KLFTb */
    public static final Comparator f16837KLFTb = new Comparator() { // from class: o.Yb
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            C2987UokA c2987UokA = (C2987UokA) obj;
            C2987UokA c2987UokA2 = (C2987UokA) obj2;
            Parcelable.Creator<C4673uHVRx> creator = C4673uHVRx.f16836CREATOR;
            return !c2987UokA.m10649mjFkc().equals(c2987UokA2.m10649mjFkc()) ? c2987UokA.m10649mjFkc().compareTo(c2987UokA2.m10649mjFkc()) : (c2987UokA.m10647AZxh() > c2987UokA2.m10647AZxh() ? 1 : (c2987UokA.m10647AZxh() == c2987UokA2.m10647AZxh() ? 0 : -1));
        }
    };

    /* renamed from: AZxh */
    public final boolean f16838AZxh;

    /* renamed from: ZfxDd */
    public final String f16839ZfxDd;

    /* renamed from: mjFkc */
    public final List f16840mjFkc;

    /* renamed from: wA */
    public final String f16841wA;

    public C4673uHVRx(List list, boolean z, String str, String str2) {
        AbstractC2138I3.m8648xJ(list);
        this.f16840mjFkc = list;
        this.f16838AZxh = z;
        this.f16841wA = str;
        this.f16839ZfxDd = str2;
    }

    /* renamed from: mjFkc */
    public static C4673uHVRx m13708mjFkc(C4522s2 c4522s2) {
        return m13709wA(c4522s2.m13447mjFkc(), true);
    }

    /* renamed from: wA */
    public static C4673uHVRx m13709wA(List list, boolean z) {
        TreeSet treeSet = new TreeSet(f16837KLFTb);
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Collections.addAll(treeSet, ((InterfaceC3923j3) it.next()).mo4301ZfxDd());
        }
        return new C4673uHVRx(new ArrayList(treeSet), z, null, null);
    }

    /* renamed from: AZxh */
    public List m13710AZxh() {
        return this.f16840mjFkc;
    }

    /* renamed from: equals */
    public final boolean m13711equals(Object obj) {
        if (obj == null || !(obj instanceof C4673uHVRx)) {
            return false;
        }
        C4673uHVRx c4673uHVRx = (C4673uHVRx) obj;
        return this.f16838AZxh == c4673uHVRx.f16838AZxh && AbstractC2931U2.m10465mjFkc(this.f16840mjFkc, c4673uHVRx.f16840mjFkc) && AbstractC2931U2.m10465mjFkc(this.f16841wA, c4673uHVRx.f16841wA) && AbstractC2931U2.m10465mjFkc(this.f16839ZfxDd, c4673uHVRx.f16839ZfxDd);
    }

    public final int hashCode() {
        return AbstractC2931U2.m10464AZxh(Boolean.valueOf(this.f16838AZxh), this.f16840mjFkc, this.f16841wA, this.f16839ZfxDd);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iM12479mjFkc = AbstractC3997k6.m12479mjFkc(parcel);
        AbstractC3997k6.m12475YoKzxo(parcel, 1, m13710AZxh(), false);
        AbstractC3997k6.m12483wA(parcel, 2, this.f16838AZxh);
        AbstractC3997k6.m12469ETF(parcel, 3, this.f16841wA, false);
        AbstractC3997k6.m12469ETF(parcel, 4, this.f16839ZfxDd, false);
        AbstractC3997k6.m12467AZxh(parcel, iM12479mjFkc);
    }
}
