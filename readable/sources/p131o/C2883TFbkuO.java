package p131o;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: o.TFbkuO */
/* loaded from: classes.dex */
public final class C2883TFbkuO {

    /* renamed from: AZxh */
    public final wA f10684AZxh;

    /* renamed from: mjFkc */
    public final Object f10685mjFkc;

    /* renamed from: o.TFbkuO$AZxh */
    public static class AZxh implements wA {

        /* renamed from: mjFkc */
        public final Class f10686mjFkc;

        /* renamed from: AZxh */
        public final Bundle m10409AZxh(Context context) throws PackageManager.NameNotFoundException {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w("ComponentDiscovery", "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, (Class<?>) this.f10686mjFkc), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w("ComponentDiscovery", this.f10686mjFkc + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w("ComponentDiscovery", "Application info not found.");
                return null;
            }
        }

        @Override // p131o.C2883TFbkuO.wA
        /* renamed from: wA, reason: merged with bridge method [inline-methods] */
        public List mo10410mjFkc(Context context) throws PackageManager.NameNotFoundException {
            Bundle bundleM10409AZxh = m10409AZxh(context);
            if (bundleM10409AZxh == null) {
                Log.w("ComponentDiscovery", "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : bundleM10409AZxh.keySet()) {
                if ("com.google.firebase.components.ComponentRegistrar".equals(bundleM10409AZxh.get(str)) && str.startsWith("com.google.firebase.components:")) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }

        public AZxh(Class cls) {
            this.f10686mjFkc = cls;
        }
    }

    /* renamed from: o.TFbkuO$wA */
    public interface wA {
        /* renamed from: mjFkc */
        List mo10410mjFkc(Object obj);
    }

    public C2883TFbkuO(Object obj, wA wAVar) {
        this.f10685mjFkc = obj;
        this.f10684AZxh = wAVar;
    }

    /* renamed from: AZxh */
    public static C2883TFbkuO m10405AZxh(Context context, Class cls) {
        return new C2883TFbkuO(context, new AZxh(cls));
    }

    /* renamed from: wA */
    public static InterfaceC1653ArO m10407wA(String str) throws ClassNotFoundException {
        try {
            Class<?> cls = Class.forName(str);
            if (InterfaceC1653ArO.class.isAssignableFrom(cls)) {
                return (InterfaceC1653ArO) cls.getDeclaredConstructor(null).newInstance(null);
            }
            throw new C3534d0(String.format("Class %s is not an instance of %s", str, "com.google.firebase.components.ComponentRegistrar"));
        } catch (ClassNotFoundException unused) {
            Log.w("ComponentDiscovery", String.format("Class %s is not an found.", str));
            return null;
        } catch (IllegalAccessException e) {
            throw new C3534d0(String.format("Could not instantiate %s.", str), e);
        } catch (InstantiationException e2) {
            throw new C3534d0(String.format("Could not instantiate %s.", str), e2);
        } catch (NoSuchMethodException e3) {
            throw new C3534d0(String.format("Could not instantiate %s", str), e3);
        } catch (InvocationTargetException e4) {
            throw new C3534d0(String.format("Could not instantiate %s", str), e4);
        }
    }

    /* renamed from: mjFkc */
    public List m10408mjFkc() {
        ArrayList arrayList = new ArrayList();
        Iterator it = this.f10684AZxh.mo10410mjFkc(this.f10685mjFkc).iterator();
        while (it.hasNext()) {
            arrayList.add(C4615tPvjn.m13622mjFkc((String) it.next()));
        }
        return arrayList;
    }
}
