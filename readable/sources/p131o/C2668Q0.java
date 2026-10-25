package p131o;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: o.Q0 */
/* loaded from: classes.dex */
public class C2668Q0 implements InterfaceC3339a4 {

    /* renamed from: AZxh */
    public volatile Set f10143AZxh = null;

    /* renamed from: mjFkc */
    public volatile Set f10144mjFkc = Collections.newSetFromMap(new ConcurrentHashMap());

    public C2668Q0(Collection collection) {
        this.f10144mjFkc.addAll(collection);
    }

    /* renamed from: AZxh */
    public static C2668Q0 m9991AZxh(Collection collection) {
        return new C2668Q0((Set) collection);
    }

    /* renamed from: ZfxDd */
    public final synchronized void m9992ZfxDd() {
        try {
            Iterator it = this.f10144mjFkc.iterator();
            while (it.hasNext()) {
                this.f10143AZxh.add(((InterfaceC3339a4) it.next()).mo8427get());
            }
            this.f10144mjFkc = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: mjFkc */
    public synchronized void m9993mjFkc(InterfaceC3339a4 interfaceC3339a4) {
        try {
            if (this.f10143AZxh == null) {
                this.f10144mjFkc.add(interfaceC3339a4);
            } else {
                this.f10143AZxh.add(interfaceC3339a4.mo8427get());
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    @Override // p131o.InterfaceC3339a4
    /* renamed from: wA, reason: merged with bridge method [inline-methods] */
    public Set mo8427get() {
        if (this.f10143AZxh == null) {
            synchronized (this) {
                try {
                    if (this.f10143AZxh == null) {
                        this.f10143AZxh = Collections.newSetFromMap(new ConcurrentHashMap());
                        m9992ZfxDd();
                    }
                } finally {
                }
            }
        }
        return Collections.unmodifiableSet(this.f10143AZxh);
    }
}
