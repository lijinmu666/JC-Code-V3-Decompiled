package p131o;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: o.V1 */
/* loaded from: classes.dex */
public class C3002V1 {

    /* renamed from: mjFkc */
    public final Runnable f10932mjFkc;

    /* renamed from: AZxh */
    public final CopyOnWriteArrayList f10931AZxh = new CopyOnWriteArrayList();

    /* renamed from: wA */
    public final Map f10933wA = new HashMap();

    public C3002V1(Runnable runnable) {
        this.f10932mjFkc = runnable;
    }

    /* renamed from: AZxh */
    public boolean m10654AZxh(MenuItem menuItem) {
        Iterator it = this.f10931AZxh.iterator();
        if (!it.hasNext()) {
            return false;
        }
        AbstractC4793w7.m13819mjFkc(it.next());
        throw null;
    }

    /* renamed from: mjFkc */
    public void m10655mjFkc(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.f10931AZxh.iterator();
        if (it.hasNext()) {
            AbstractC4793w7.m13819mjFkc(it.next());
            throw null;
        }
    }

    /* renamed from: wA */
    public void m10656wA(Menu menu) {
        Iterator it = this.f10931AZxh.iterator();
        if (it.hasNext()) {
            AbstractC4793w7.m13819mjFkc(it.next());
            throw null;
        }
    }
}
