package p131o;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* renamed from: o.T8 */
/* loaded from: classes.dex */
public class C2875T8 {

    /* renamed from: AZxh */
    public View f10645AZxh;

    /* renamed from: mjFkc */
    public final Map f10646mjFkc = new HashMap();

    /* renamed from: wA */
    public final ArrayList f10647wA = new ArrayList();

    public C2875T8(View view) {
        this.f10645AZxh = view;
    }

    /* renamed from: equals */
    public boolean m10221equals(Object obj) {
        if (!(obj instanceof C2875T8)) {
            return false;
        }
        C2875T8 c2875t8 = (C2875T8) obj;
        return this.f10645AZxh == c2875t8.f10645AZxh && this.f10646mjFkc.equals(c2875t8.f10646mjFkc);
    }

    public int hashCode() {
        return (this.f10645AZxh.hashCode() * 31) + this.f10646mjFkc.hashCode();
    }

    public String toString() {
        String str = (("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n") + "    view = " + this.f10645AZxh + "\n") + "    values:";
        for (String str2 : this.f10646mjFkc.keySet()) {
            str = str + "    " + str2 + ": " + this.f10646mjFkc.get(str2) + "\n";
        }
        return str;
    }
}
