package p094kotlin.p105jvm.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;

/* loaded from: classes.dex */
public class SpreadBuilder {

    /* renamed from: list */
    private final ArrayList<Object> f5206list;

    public SpreadBuilder(int i) {
        this.f5206list = new ArrayList<>(i);
    }

    /* renamed from: add */
    public void m6345add(Object obj) {
        this.f5206list.add(obj);
    }

    public void addSpread(Object obj) {
        if (obj == null) {
            return;
        }
        if (obj instanceof Object[]) {
            Object[] objArr = (Object[]) obj;
            if (objArr.length > 0) {
                ArrayList<Object> arrayList = this.f5206list;
                arrayList.ensureCapacity(arrayList.size() + objArr.length);
                Collections.addAll(this.f5206list, objArr);
                return;
            }
            return;
        }
        if (obj instanceof Collection) {
            this.f5206list.addAll((Collection) obj);
            return;
        }
        if (obj instanceof Iterable) {
            Iterator it = ((Iterable) obj).iterator();
            while (it.hasNext()) {
                this.f5206list.add(it.next());
            }
            return;
        }
        if (obj instanceof Iterator) {
            Iterator it2 = (Iterator) obj;
            while (it2.hasNext()) {
                this.f5206list.add(it2.next());
            }
        } else {
            throw new UnsupportedOperationException("Don't know how to spread " + obj.getClass());
        }
    }

    /* renamed from: size */
    public int m6346size() {
        return this.f5206list.size();
    }

    /* renamed from: toArray */
    public Object[] m6347toArray(Object[] objArr) {
        return this.f5206list.toArray(objArr);
    }
}
