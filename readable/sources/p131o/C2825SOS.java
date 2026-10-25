package p131o;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.p024startup.InitializationProvider;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: o.SOS */
/* loaded from: classes.dex */
public final class C2825SOS {

    /* renamed from: KLFTb */
    public static final Object f10542KLFTb = new Object();

    /* renamed from: ZfxDd */
    public static volatile C2825SOS f10543ZfxDd;

    /* renamed from: AZxh */
    public final Set f10544AZxh = new HashSet();

    /* renamed from: mjFkc */
    public final Map f10545mjFkc = new HashMap();

    /* renamed from: wA */
    public final Context f10546wA;

    public C2825SOS(Context context) {
        this.f10546wA = context.getApplicationContext();
    }

    /* renamed from: KLFTb */
    public static C2825SOS m10142KLFTb(Context context) {
        if (f10543ZfxDd == null) {
            synchronized (f10542KLFTb) {
                try {
                    if (f10543ZfxDd == null) {
                        f10543ZfxDd = new C2825SOS(context);
                    }
                } finally {
                }
            }
        }
        return f10543ZfxDd;
    }

    /* renamed from: AZxh */
    public void m10143AZxh(Bundle bundle) throws ClassNotFoundException {
        String string = this.f10546wA.getString(AbstractC2281K4.f9106mjFkc);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, null))) {
                        Class<?> cls = Class.forName(str);
                        if (InterfaceC2343L.class.isAssignableFrom(cls)) {
                            this.f10544AZxh.add(cls);
                        }
                    }
                }
                Iterator it = this.f10544AZxh.iterator();
                while (it.hasNext()) {
                    m10145ZfxDd((Class) it.next(), hashSet);
                }
            } catch (ClassNotFoundException e) {
                throw new C3865i7(e);
            }
        }
    }

    /* renamed from: JHa */
    public Object m10144JHa(Class cls) {
        return m10147wA(cls);
    }

    /* renamed from: ZfxDd */
    public final Object m10145ZfxDd(Class cls, Set set) {
        Object objMo626AZxh;
        if (AbstractC2212J8.m8909ZfxDd()) {
            try {
                AbstractC2212J8.m8910mjFkc(cls.getSimpleName());
            } catch (Throwable th) {
                AbstractC2212J8.m8907AZxh();
                throw th;
            }
        }
        if (set.contains(cls)) {
            throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", cls.getName()));
        }
        if (this.f10545mjFkc.containsKey(cls)) {
            objMo626AZxh = this.f10545mjFkc.get(cls);
        } else {
            set.add(cls);
            try {
                InterfaceC2343L interfaceC2343L = (InterfaceC2343L) cls.getDeclaredConstructor(null).newInstance(null);
                List<Class> listMo629mjFkc = interfaceC2343L.mo629mjFkc();
                if (!listMo629mjFkc.isEmpty()) {
                    for (Class cls2 : listMo629mjFkc) {
                        if (!this.f10545mjFkc.containsKey(cls2)) {
                            m10145ZfxDd(cls2, set);
                        }
                    }
                }
                objMo626AZxh = interfaceC2343L.mo626AZxh(this.f10546wA);
                set.remove(cls);
                this.f10545mjFkc.put(cls, objMo626AZxh);
            } catch (Throwable th2) {
                throw new C3865i7(th2);
            }
        }
        AbstractC2212J8.m8907AZxh();
        return objMo626AZxh;
    }

    /* renamed from: mjFkc */
    public void m10146mjFkc() {
        try {
            try {
                AbstractC2212J8.m8910mjFkc("Startup");
                m10143AZxh(this.f10546wA.getPackageManager().getProviderInfo(new ComponentName(this.f10546wA.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            } catch (PackageManager.NameNotFoundException e) {
                throw new C3865i7(e);
            }
        } finally {
            AbstractC2212J8.m8907AZxh();
        }
    }

    /* renamed from: wA */
    public Object m10147wA(Class cls) {
        Object objM10145ZfxDd;
        synchronized (f10542KLFTb) {
            try {
                objM10145ZfxDd = this.f10545mjFkc.get(cls);
                if (objM10145ZfxDd == null) {
                    objM10145ZfxDd = m10145ZfxDd(cls, new HashSet());
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return objM10145ZfxDd;
    }

    /* renamed from: xJ */
    public boolean m10148xJ(Class cls) {
        return this.f10544AZxh.contains(cls);
    }
}
