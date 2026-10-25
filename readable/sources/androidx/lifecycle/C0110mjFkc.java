package androidx.lifecycle;

import androidx.lifecycle.AbstractC0112wA;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p131o.InterfaceC3068W0;

/* renamed from: androidx.lifecycle.mjFkc */
/* loaded from: classes.dex */
public final class C0110mjFkc {

    /* renamed from: wA */
    public static C0110mjFkc f1382wA = new C0110mjFkc();

    /* renamed from: mjFkc */
    public final Map f1384mjFkc = new HashMap();

    /* renamed from: AZxh */
    public final Map f1383AZxh = new HashMap();

    /* renamed from: androidx.lifecycle.mjFkc$AZxh */
    public static final class AZxh {

        /* renamed from: AZxh */
        public final Method f1385AZxh;

        /* renamed from: mjFkc */
        public final int f1386mjFkc;

        public AZxh(int i, Method method) throws SecurityException {
            this.f1386mjFkc = i;
            this.f1385AZxh = method;
            method.setAccessible(true);
        }

        /* renamed from: equals */
        public boolean m1078equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AZxh)) {
                return false;
            }
            AZxh aZxh = (AZxh) obj;
            return this.f1386mjFkc == aZxh.f1386mjFkc && this.f1385AZxh.getName().equals(aZxh.f1385AZxh.getName());
        }

        public int hashCode() {
            return (this.f1386mjFkc * 31) + this.f1385AZxh.getName().hashCode();
        }

        /* renamed from: mjFkc */
        public void m1079mjFkc(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            try {
                int i = this.f1386mjFkc;
                if (i == 0) {
                    this.f1385AZxh.invoke(obj, null);
                } else if (i == 1) {
                    this.f1385AZxh.invoke(obj, interfaceC3068W0);
                } else {
                    if (i != 2) {
                        return;
                    }
                    this.f1385AZxh.invoke(obj, interfaceC3068W0, mjfkc);
                }
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e2) {
                throw new RuntimeException("Failed to call observer method", e2.getCause());
            }
        }
    }

    /* renamed from: androidx.lifecycle.mjFkc$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public final Map f1387AZxh;

        /* renamed from: mjFkc */
        public final Map f1388mjFkc = new HashMap();

        public mjFkc(Map map) {
            this.f1387AZxh = map;
            for (Map.Entry entry : map.entrySet()) {
                AbstractC0112wA.mjFkc mjfkc = (AbstractC0112wA.mjFkc) entry.getValue();
                List arrayList = (List) this.f1388mjFkc.get(mjfkc);
                if (arrayList == null) {
                    arrayList = new ArrayList();
                    this.f1388mjFkc.put(mjfkc, arrayList);
                }
                arrayList.add((AZxh) entry.getKey());
            }
        }

        /* renamed from: AZxh */
        public static void m1080AZxh(List list, InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            if (list != null) {
                for (int size = list.size() - 1; size >= 0; size--) {
                    ((AZxh) list.get(size)).m1079mjFkc(interfaceC3068W0, mjfkc, obj);
                }
            }
        }

        /* renamed from: mjFkc */
        public void m1081mjFkc(InterfaceC3068W0 interfaceC3068W0, AbstractC0112wA.mjFkc mjfkc, Object obj) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
            m1080AZxh((List) this.f1388mjFkc.get(mjfkc), interfaceC3068W0, mjfkc, obj);
            m1080AZxh((List) this.f1388mjFkc.get(AbstractC0112wA.mjFkc.ON_ANY), interfaceC3068W0, mjfkc, obj);
        }
    }

    /* renamed from: AZxh */
    public final Method[] m1073AZxh(Class cls) {
        try {
            return cls.getDeclaredMethods();
        } catch (NoClassDefFoundError e) {
            throw new IllegalArgumentException("The observer class has some methods that use newer APIs which are not available in the current OS version. Lifecycles cannot access even other methods so you should make sure that your observer classes only access framework classes that are available in your min API level OR use lifecycle:compiler annotation processor.", e);
        }
    }

    /* renamed from: KLFTb */
    public final void m1074KLFTb(Map map, AZxh aZxh, AbstractC0112wA.mjFkc mjfkc, Class cls) {
        AbstractC0112wA.mjFkc mjfkc2 = (AbstractC0112wA.mjFkc) map.get(aZxh);
        if (mjfkc2 == null || mjfkc == mjfkc2) {
            if (mjfkc2 == null) {
                map.put(aZxh, mjfkc);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Method " + aZxh.f1385AZxh.getName() + " in " + cls.getName() + " already declared with different @OnLifecycleEvent value: previous value " + mjfkc2 + ", new value " + mjfkc);
    }

    /* renamed from: ZfxDd */
    public boolean m1075ZfxDd(Class cls) {
        Boolean bool = (Boolean) this.f1383AZxh.get(cls);
        if (bool != null) {
            return bool.booleanValue();
        }
        Method[] methodArrM1073AZxh = m1073AZxh(cls);
        for (Method method : methodArrM1073AZxh) {
            if (((InterfaceC0109lgHUyS) method.getAnnotation(InterfaceC0109lgHUyS.class)) != null) {
                m1076mjFkc(cls, methodArrM1073AZxh);
                return true;
            }
        }
        this.f1383AZxh.put(cls, Boolean.FALSE);
        return false;
    }

    /* renamed from: mjFkc */
    public final mjFkc m1076mjFkc(Class cls, Method[] methodArr) {
        int i;
        mjFkc mjfkcM1077wA;
        Class superclass = cls.getSuperclass();
        HashMap map = new HashMap();
        if (superclass != null && (mjfkcM1077wA = m1077wA(superclass)) != null) {
            map.putAll(mjfkcM1077wA.f1387AZxh);
        }
        for (Class<?> cls2 : cls.getInterfaces()) {
            for (Map.Entry entry : m1077wA(cls2).f1387AZxh.entrySet()) {
                m1074KLFTb(map, (AZxh) entry.getKey(), (AbstractC0112wA.mjFkc) entry.getValue(), cls);
            }
        }
        if (methodArr == null) {
            methodArr = m1073AZxh(cls);
        }
        boolean z = false;
        for (Method method : methodArr) {
            InterfaceC0109lgHUyS interfaceC0109lgHUyS = (InterfaceC0109lgHUyS) method.getAnnotation(InterfaceC0109lgHUyS.class);
            if (interfaceC0109lgHUyS != null) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length <= 0) {
                    i = 0;
                } else {
                    if (!InterfaceC3068W0.class.isAssignableFrom(parameterTypes[0])) {
                        throw new IllegalArgumentException("invalid parameter type. Must be one and instanceof LifecycleOwner");
                    }
                    i = 1;
                }
                AbstractC0112wA.mjFkc mjfkcM1072value = interfaceC0109lgHUyS.m1072value();
                if (parameterTypes.length > 1) {
                    if (!AbstractC0112wA.mjFkc.class.isAssignableFrom(parameterTypes[1])) {
                        throw new IllegalArgumentException("invalid parameter type. second arg must be an event");
                    }
                    if (mjfkcM1072value != AbstractC0112wA.mjFkc.ON_ANY) {
                        throw new IllegalArgumentException("Second arg is supported only for ON_ANY value");
                    }
                    i = 2;
                }
                if (parameterTypes.length > 2) {
                    throw new IllegalArgumentException("cannot have more than 2 params");
                }
                m1074KLFTb(map, new AZxh(i, method), mjfkcM1072value, cls);
                z = true;
            }
        }
        mjFkc mjfkc = new mjFkc(map);
        this.f1384mjFkc.put(cls, mjfkc);
        this.f1383AZxh.put(cls, Boolean.valueOf(z));
        return mjfkc;
    }

    /* renamed from: wA */
    public mjFkc m1077wA(Class cls) {
        mjFkc mjfkc = (mjFkc) this.f1384mjFkc.get(cls);
        return mjfkc != null ? mjfkc : m1076mjFkc(cls, null);
    }
}
