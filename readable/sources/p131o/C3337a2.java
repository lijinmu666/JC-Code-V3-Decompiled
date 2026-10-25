package p131o;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.p038google.p039android.datatransport.p041runtime.backends.TransportBackendDiscovery;
import java.lang.reflect.InvocationTargetException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* renamed from: o.a2 */
/* loaded from: classes.dex */
public class C3337a2 implements InterfaceC4598tAfC {

    /* renamed from: AZxh */
    public final C2039GaZ f12312AZxh;

    /* renamed from: mjFkc */
    public final mjFkc f12313mjFkc;

    /* renamed from: wA */
    public final Map f12314wA;

    /* renamed from: o.a2$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public Map f12315AZxh = null;

        /* renamed from: mjFkc */
        public final Context f12316mjFkc;

        public mjFkc(Context context) {
            this.f12316mjFkc = context;
        }

        /* renamed from: ZfxDd */
        public static Bundle m11271ZfxDd(Context context) throws PackageManager.NameNotFoundException {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("BackendRegistry", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) TransportBackendDiscovery.class), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("BackendRegistry", "TransportBackendDiscovery has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("BackendRegistry", "Application info not found.");
                return null;
            }
        }

        /* renamed from: AZxh */
        public InterfaceC2201IyS m11272AZxh(String str) {
            String str2 = (String) m11274wA().get(str);
            if (str2 == null) {
                return null;
            }
            try {
                return (InterfaceC2201IyS) Class.forName(str2).asSubclass(InterfaceC2201IyS.class).getDeclaredConstructor(null).newInstance(null);
            } catch (ClassNotFoundException e) {
                Log.w("BackendRegistry", String.format("Class %s is not found.", str2), e);
                return null;
            } catch (IllegalAccessException e2) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e2);
                return null;
            } catch (InstantiationException e3) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s.", str2), e3);
                return null;
            } catch (NoSuchMethodException e4) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e4);
                return null;
            } catch (InvocationTargetException e5) {
                Log.w("BackendRegistry", String.format("Could not instantiate %s", str2), e5);
                return null;
            }
        }

        /* renamed from: mjFkc */
        public final Map m11273mjFkc(Context context) throws PackageManager.NameNotFoundException {
            Bundle bundleM11271ZfxDd = m11271ZfxDd(context);
            if (bundleM11271ZfxDd == null) {
                Log.w("BackendRegistry", "Could not retrieve metadata, returning empty list of transport backends.");
                return Collections.emptyMap();
            }
            HashMap map = new HashMap();
            for (String str : bundleM11271ZfxDd.keySet()) {
                Object obj = bundleM11271ZfxDd.get(str);
                if ((obj instanceof String) && str.startsWith("backend:")) {
                    for (String str2 : ((String) obj).split(",", -1)) {
                        String strTrim = str2.trim();
                        if (!strTrim.isEmpty()) {
                            map.put(strTrim, str.substring(8));
                        }
                    }
                }
            }
            return map;
        }

        /* renamed from: wA */
        public final Map m11274wA() {
            if (this.f12315AZxh == null) {
                this.f12315AZxh = m11273mjFkc(this.f12316mjFkc);
            }
            return this.f12315AZxh;
        }
    }

    public C3337a2(Context context, C2039GaZ c2039GaZ) {
        this(new mjFkc(context), c2039GaZ);
    }

    @Override // p131o.InterfaceC4598tAfC
    /* renamed from: get */
    public synchronized InterfaceC3076W8 mo11270get(String str) {
        if (this.f12314wA.containsKey(str)) {
            return (InterfaceC3076W8) this.f12314wA.get(str);
        }
        InterfaceC2201IyS interfaceC2201IySM11272AZxh = this.f12313mjFkc.m11272AZxh(str);
        if (interfaceC2201IySM11272AZxh == null) {
            return null;
        }
        InterfaceC3076W8 interfaceC3076W8Mo2355create = interfaceC2201IySM11272AZxh.mo2355create(this.f12312AZxh.m8437mjFkc(str));
        this.f12314wA.put(str, interfaceC3076W8Mo2355create);
        return interfaceC3076W8Mo2355create;
    }

    public C3337a2(mjFkc mjfkc, C2039GaZ c2039GaZ) {
        this.f12314wA = new HashMap();
        this.f12313mjFkc = mjfkc;
        this.f12312AZxh = c2039GaZ;
    }
}
