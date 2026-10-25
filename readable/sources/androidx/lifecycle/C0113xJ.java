package androidx.lifecycle;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.conscrypt.BuildConfig;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p117text.StringsKt;
import p131o.AbstractC4793w7;
import p131o.InterfaceC3001V0;
import p131o.InterfaceC4543sMIIyd;

/* renamed from: androidx.lifecycle.xJ */
/* loaded from: classes.dex */
public final class C0113xJ {

    /* renamed from: mjFkc */
    public static final C0113xJ f1416mjFkc = new C0113xJ();

    /* renamed from: AZxh */
    public static final Map f1415AZxh = new HashMap();

    /* renamed from: wA */
    public static final Map f1417wA = new HashMap();

    /* renamed from: JHa */
    public static final InterfaceC0104KLFTb m1105JHa(Object object) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Intrinsics.checkNotNullParameter(object, "object");
        boolean z = object instanceof InterfaceC0104KLFTb;
        boolean z2 = object instanceof InterfaceC4543sMIIyd;
        if (z && z2) {
            return new DefaultLifecycleObserverAdapter((InterfaceC4543sMIIyd) object, (InterfaceC0104KLFTb) object);
        }
        if (z2) {
            return new DefaultLifecycleObserverAdapter((InterfaceC4543sMIIyd) object, null);
        }
        if (z) {
            return (InterfaceC0104KLFTb) object;
        }
        Class<?> cls = object.getClass();
        C0113xJ c0113xJ = f1416mjFkc;
        if (c0113xJ.m1109ZfxDd(cls) != 2) {
            return new ReflectiveGenericLifecycleObserver(object);
        }
        Object obj = f1417wA.get(cls);
        Intrinsics.checkNotNull(obj);
        List list = (List) obj;
        if (list.size() == 1) {
            c0113xJ.m1110mjFkc((Constructor) list.get(0), object);
            return new SingleGeneratedAdapterObserver(null);
        }
        int size = list.size();
        InterfaceC0100AZxh[] interfaceC0100AZxhArr = new InterfaceC0100AZxh[size];
        for (int i = 0; i < size; i++) {
            f1416mjFkc.m1110mjFkc((Constructor) list.get(i), object);
            interfaceC0100AZxhArr[i] = null;
        }
        return new CompositeGeneratedAdaptersObserver(interfaceC0100AZxhArr);
    }

    /* renamed from: wA */
    public static final String m1106wA(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        return StringsKt.replace$default(className, ".", "_", false, 4, (Object) null) + "_LifecycleAdapter";
    }

    /* renamed from: AZxh */
    public final Constructor m1107AZxh(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        try {
            Package r3 = cls.getPackage();
            String name = cls.getCanonicalName();
            String fullPackage = r3 != null ? r3.getName() : BuildConfig.f24315FLAVOR;
            Intrinsics.checkNotNullExpressionValue(fullPackage, "fullPackage");
            if (fullPackage.length() != 0) {
                Intrinsics.checkNotNullExpressionValue(name, "name");
                name = name.substring(fullPackage.length() + 1);
                Intrinsics.checkNotNullExpressionValue(name, "this as java.lang.String).substring(startIndex)");
            }
            Intrinsics.checkNotNullExpressionValue(name, "if (fullPackage.isEmpty(…g(fullPackage.length + 1)");
            String strM1106wA = m1106wA(name);
            if (fullPackage.length() != 0) {
                strM1106wA = fullPackage + '.' + strM1106wA;
            }
            Class<?> cls2 = Class.forName(strM1106wA);
            Intrinsics.checkNotNull(cls2, "null cannot be cast to non-null type java.lang.Class<out androidx.lifecycle.GeneratedAdapter>");
            Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls);
            if (declaredConstructor.isAccessible()) {
                return declaredConstructor;
            }
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (ClassNotFoundException unused) {
            return null;
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: KLFTb */
    public final boolean m1108KLFTb(Class cls) {
        return cls != null && InterfaceC3001V0.class.isAssignableFrom(cls);
    }

    /* renamed from: ZfxDd */
    public final int m1109ZfxDd(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Map map = f1415AZxh;
        Integer num = (Integer) map.get(cls);
        if (num != null) {
            return num.intValue();
        }
        int iM1111xJ = m1111xJ(cls);
        map.put(cls, Integer.valueOf(iM1111xJ));
        return iM1111xJ;
    }

    /* renamed from: mjFkc */
    public final InterfaceC0100AZxh m1110mjFkc(Constructor constructor, Object obj) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        try {
            Object objNewInstance = constructor.newInstance(obj);
            Intrinsics.checkNotNullExpressionValue(objNewInstance, "{\n            constructo…tance(`object`)\n        }");
            AbstractC4793w7.m13819mjFkc(objNewInstance);
            return null;
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e2) {
            throw new RuntimeException(e2);
        } catch (InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    /* renamed from: xJ */
    public final int m1111xJ(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        ArrayList arrayList;
        if (cls.getCanonicalName() == null) {
            return 1;
        }
        Constructor constructorM1107AZxh = m1107AZxh(cls);
        if (constructorM1107AZxh != null) {
            f1417wA.put(cls, CollectionsKt.m5801listOf(constructorM1107AZxh));
            return 2;
        }
        if (C0110mjFkc.f1382wA.m1075ZfxDd(cls)) {
            return 1;
        }
        Class superclass = cls.getSuperclass();
        if (m1108KLFTb(superclass)) {
            Intrinsics.checkNotNullExpressionValue(superclass, "superclass");
            if (m1109ZfxDd(superclass) == 1) {
                return 1;
            }
            Object obj = f1417wA.get(superclass);
            Intrinsics.checkNotNull(obj);
            arrayList = new ArrayList((Collection) obj);
        } else {
            arrayList = null;
        }
        Class<?>[] interfaces = cls.getInterfaces();
        Intrinsics.checkNotNullExpressionValue(interfaces, "klass.interfaces");
        for (Class<?> intrface : interfaces) {
            if (m1108KLFTb(intrface)) {
                Intrinsics.checkNotNullExpressionValue(intrface, "intrface");
                if (m1109ZfxDd(intrface) == 1) {
                    return 1;
                }
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                Object obj2 = f1417wA.get(intrface);
                Intrinsics.checkNotNull(obj2);
                arrayList.addAll((Collection) obj2);
            }
        }
        if (arrayList == null) {
            return 1;
        }
        f1417wA.put(cls, arrayList);
        return 2;
    }
}
