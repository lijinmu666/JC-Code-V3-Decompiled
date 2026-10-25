package org.p370lsposed.hiddenapibypass;

import android.util.Log;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandleInfo;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import sun.misc.Unsafe;

/* loaded from: classes2.dex */
public final class HiddenApiBypass {

    /* renamed from: a */
    private static final Unsafe f24512a;

    /* renamed from: b */
    private static final long f24513b;

    /* renamed from: c */
    private static final long f24514c;

    /* renamed from: d */
    private static final long f24515d;

    /* renamed from: e */
    private static final long f24516e;

    /* renamed from: f */
    private static final long f24517f;

    /* renamed from: g */
    private static final long f24518g;

    /* renamed from: h */
    private static final long f24519h;

    /* renamed from: i */
    private static final long f24520i;

    /* renamed from: j */
    private static final long f24521j;

    /* renamed from: k */
    private static final long f24522k;

    /* renamed from: l */
    private static final long f24523l;

    /* renamed from: m */
    private static final long f24524m;

    /* renamed from: mjFkc */
    public static final /* synthetic */ int f24525mjFkc = 0;

    /* renamed from: n */
    private static final Set f24526n = new HashSet();

    static {
        try {
            Unsafe unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", null).invoke(null, null);
            f24512a = unsafe;
            f24513b = unsafe.objectFieldOffset(Helper$Executable.class.getDeclaredField("artMethod"));
            f24514c = unsafe.objectFieldOffset(Helper$Executable.class.getDeclaredField("declaringClass"));
            long jObjectFieldOffset = unsafe.objectFieldOffset(Helper$MethodHandle.class.getDeclaredField("artFieldOrMethod"));
            f24515d = jObjectFieldOffset;
            f24516e = unsafe.objectFieldOffset(Helper$MethodHandleImpl.class.getDeclaredField("info"));
            long jObjectFieldOffset2 = unsafe.objectFieldOffset(Helper$Class.class.getDeclaredField("methods"));
            f24517f = jObjectFieldOffset2;
            long jObjectFieldOffset3 = unsafe.objectFieldOffset(Helper$Class.class.getDeclaredField("iFields"));
            f24518g = jObjectFieldOffset3;
            f24519h = unsafe.objectFieldOffset(Helper$Class.class.getDeclaredField("sFields"));
            f24520i = unsafe.objectFieldOffset(Helper$HandleInfo.class.getDeclaredField("member"));
            Method declaredMethod = Helper$NeverCall.class.getDeclaredMethod("a", null);
            Method declaredMethod2 = Helper$NeverCall.class.getDeclaredMethod("b", null);
            declaredMethod.setAccessible(true);
            declaredMethod2.setAccessible(true);
            MethodHandle methodHandleUnreflect = MethodHandles.lookup().unreflect(declaredMethod);
            MethodHandle methodHandleUnreflect2 = MethodHandles.lookup().unreflect(declaredMethod2);
            long j = unsafe.getLong(methodHandleUnreflect, jObjectFieldOffset);
            long j2 = unsafe.getLong(methodHandleUnreflect2, jObjectFieldOffset);
            long j3 = unsafe.getLong(Helper$NeverCall.class, jObjectFieldOffset2);
            long j4 = j2 - j;
            f24521j = j4;
            f24522k = (j - j3) - j4;
            Field declaredField = Helper$NeverCall.class.getDeclaredField("i");
            Field declaredField2 = Helper$NeverCall.class.getDeclaredField("j");
            declaredField.setAccessible(true);
            declaredField2.setAccessible(true);
            MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
            MethodHandle methodHandleUnreflectGetter2 = MethodHandles.lookup().unreflectGetter(declaredField2);
            long j5 = unsafe.getLong(methodHandleUnreflectGetter, jObjectFieldOffset);
            long j6 = unsafe.getLong(methodHandleUnreflectGetter2, jObjectFieldOffset);
            long j7 = unsafe.getLong(Helper$NeverCall.class, jObjectFieldOffset3);
            f24523l = j6 - j5;
            f24524m = j5 - j7;
        } catch (ReflectiveOperationException e) {
            Log.e("HiddenApiBypass", "Initialize error", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /* renamed from: a */
    public static boolean m18540a(Class[] clsArr, Object[] objArr) {
        if (clsArr.length != objArr.length) {
            return false;
        }
        for (int i = 0; i < clsArr.length; i++) {
            if (clsArr[i].isPrimitive()) {
                Class cls = clsArr[i];
                if (cls == Integer.TYPE && !(objArr[i] instanceof Integer)) {
                    return false;
                }
                if (cls == Byte.TYPE && !(objArr[i] instanceof Byte)) {
                    return false;
                }
                if (cls == Character.TYPE && !(objArr[i] instanceof Character)) {
                    return false;
                }
                if (cls == Boolean.TYPE && !(objArr[i] instanceof Boolean)) {
                    return false;
                }
                if (cls == Double.TYPE && !(objArr[i] instanceof Double)) {
                    return false;
                }
                if (cls == Float.TYPE && !(objArr[i] instanceof Float)) {
                    return false;
                }
                if (cls == Long.TYPE && !(objArr[i] instanceof Long)) {
                    return false;
                }
                if (cls == Short.TYPE && !(objArr[i] instanceof Short)) {
                    return false;
                }
            } else {
                Object obj = objArr[i];
                if (obj != null && !clsArr[i].isInstance(obj)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean addHiddenApiExemptions(String... strArr) {
        Set set = f24526n;
        set.addAll(Arrays.asList(strArr));
        String[] strArr2 = new String[((HashSet) set).size()];
        set.toArray(strArr2);
        return setHiddenApiExemptions(strArr2);
    }

    public static boolean clearHiddenApiExemptions() {
        ((HashSet) f24526n).clear();
        return setHiddenApiExemptions(new String[0]);
    }

    public static Constructor getDeclaredConstructor(Class cls, Class... clsArr) throws NoSuchMethodException {
        for (Executable executable : getDeclaredMethods(cls)) {
            if (executable instanceof Constructor) {
                Class<?>[] parameterTypes = executable.getParameterTypes();
                if (parameterTypes.length == clsArr.length) {
                    for (int i = 0; i < clsArr.length; i++) {
                        if (clsArr[i] != parameterTypes[i]) {
                            break;
                        }
                    }
                    return (Constructor) executable;
                }
                continue;
            }
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static Method getDeclaredMethod(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        for (Executable executable : getDeclaredMethods(cls)) {
            if (executable.getName().equals(str) && (executable instanceof Method)) {
                Class<?>[] parameterTypes = executable.getParameterTypes();
                if (parameterTypes.length == clsArr.length) {
                    for (int i = 0; i < clsArr.length; i++) {
                        if (clsArr[i] != parameterTypes[i]) {
                            break;
                        }
                    }
                    return (Method) executable;
                }
                continue;
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static List getDeclaredMethods(Class cls) throws IllegalAccessException, NoSuchMethodException, SecurityException {
        ArrayList arrayList = new ArrayList();
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Method declaredMethod = Helper$NeverCall.class.getDeclaredMethod("a", null);
                declaredMethod.setAccessible(true);
                MethodHandle methodHandleUnreflect = MethodHandles.lookup().unreflect(declaredMethod);
                Unsafe unsafe = f24512a;
                long j = unsafe.getLong(cls, f24517f);
                if (j == 0) {
                    return arrayList;
                }
                int i = unsafe.getInt(j);
                for (int i2 = 0; i2 < i; i2++) {
                    long j2 = (i2 * f24521j) + j + f24522k;
                    Unsafe unsafe2 = f24512a;
                    unsafe2.putLong(methodHandleUnreflect, f24515d, j2);
                    unsafe2.putObject(methodHandleUnreflect, f24516e, (Object) null);
                    try {
                        MethodHandles.lookup().revealDirect(methodHandleUnreflect);
                    } catch (Throwable unused) {
                    }
                    Unsafe unsafe3 = f24512a;
                    arrayList.add((Executable) unsafe3.getObject((MethodHandleInfo) unsafe3.getObject(methodHandleUnreflect, f24516e), f24520i));
                }
            } catch (IllegalAccessException | NoSuchMethodException unused2) {
            }
        }
        return arrayList;
    }

    public static List getInstanceFields(Class cls) throws IllegalAccessException, NoSuchFieldException, SecurityException {
        ArrayList arrayList = new ArrayList();
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Field declaredField = Helper$NeverCall.class.getDeclaredField("i");
                declaredField.setAccessible(true);
                MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
                Unsafe unsafe = f24512a;
                long j = unsafe.getLong(cls, f24518g);
                if (j == 0) {
                    return arrayList;
                }
                int i = unsafe.getInt(j);
                for (int i2 = 0; i2 < i; i2++) {
                    long j2 = (i2 * f24523l) + j + f24524m;
                    Unsafe unsafe2 = f24512a;
                    unsafe2.putLong(methodHandleUnreflectGetter, f24515d, j2);
                    unsafe2.putObject(methodHandleUnreflectGetter, f24516e, (Object) null);
                    try {
                        MethodHandles.lookup().revealDirect(methodHandleUnreflectGetter);
                    } catch (Throwable unused) {
                    }
                    Unsafe unsafe3 = f24512a;
                    arrayList.add((Field) unsafe3.getObject((MethodHandleInfo) unsafe3.getObject(methodHandleUnreflectGetter, f24516e), f24520i));
                }
            } catch (IllegalAccessException | NoSuchFieldException unused2) {
            }
        }
        return arrayList;
    }

    public static List getStaticFields(Class cls) throws IllegalAccessException, NoSuchFieldException, SecurityException {
        ArrayList arrayList = new ArrayList();
        if (!cls.isPrimitive() && !cls.isArray()) {
            try {
                Field declaredField = Helper$NeverCall.class.getDeclaredField("s");
                declaredField.setAccessible(true);
                MethodHandle methodHandleUnreflectGetter = MethodHandles.lookup().unreflectGetter(declaredField);
                Unsafe unsafe = f24512a;
                long j = unsafe.getLong(cls, f24519h);
                if (j == 0) {
                    return arrayList;
                }
                int i = unsafe.getInt(j);
                for (int i2 = 0; i2 < i; i2++) {
                    long j2 = (i2 * f24523l) + j + f24524m;
                    Unsafe unsafe2 = f24512a;
                    unsafe2.putLong(methodHandleUnreflectGetter, f24515d, j2);
                    unsafe2.putObject(methodHandleUnreflectGetter, f24516e, (Object) null);
                    try {
                        MethodHandles.lookup().revealDirect(methodHandleUnreflectGetter);
                    } catch (Throwable unused) {
                    }
                    Unsafe unsafe3 = f24512a;
                    arrayList.add((Field) unsafe3.getObject((MethodHandleInfo) unsafe3.getObject(methodHandleUnreflectGetter, f24516e), f24520i));
                }
            } catch (IllegalAccessException | NoSuchFieldException unused2) {
            }
        }
        return arrayList;
    }

    /* renamed from: invoke */
    public static Object m18541invoke(Class cls, Object obj, String str, Object... objArr) throws NoSuchMethodException, SecurityException {
        if (obj != null && !cls.isInstance(obj)) {
            throw new IllegalArgumentException("this object is not an instance of the given class");
        }
        Method declaredMethod = Helper$InvokeStub.class.getDeclaredMethod("invoke", Object[].class);
        declaredMethod.setAccessible(true);
        Unsafe unsafe = f24512a;
        long j = unsafe.getLong(cls, f24517f);
        if (j == 0) {
            throw new NoSuchMethodException("Cannot find matching method");
        }
        int i = unsafe.getInt(j);
        for (int i2 = 0; i2 < i; i2++) {
            f24512a.putLong(declaredMethod, f24513b, (i2 * f24521j) + j + f24522k);
            if (str.equals(declaredMethod.getName()) && m18540a(declaredMethod.getParameterTypes(), objArr)) {
                return declaredMethod.invoke(obj, objArr);
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static Object newInstance(Class cls, Object... objArr) throws NoSuchMethodException, SecurityException {
        Method declaredMethod = Helper$InvokeStub.class.getDeclaredMethod("invoke", Object[].class);
        Constructor declaredConstructor = Helper$InvokeStub.class.getDeclaredConstructor(Object[].class);
        declaredConstructor.setAccessible(true);
        Unsafe unsafe = f24512a;
        long j = unsafe.getLong(cls, f24517f);
        if (j == 0) {
            throw new NoSuchMethodException("Cannot find matching constructor");
        }
        int i = unsafe.getInt(j);
        for (int i2 = 0; i2 < i; i2++) {
            long j2 = (i2 * f24521j) + j + f24522k;
            Unsafe unsafe2 = f24512a;
            long j3 = f24513b;
            unsafe2.putLong(declaredMethod, j3, j2);
            if ("<init>".equals(declaredMethod.getName())) {
                unsafe2.putLong(declaredConstructor, j3, j2);
                unsafe2.putObject(declaredConstructor, f24514c, cls);
                if (m18540a(declaredConstructor.getParameterTypes(), objArr)) {
                    return declaredConstructor.newInstance(objArr);
                }
            }
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static boolean setHiddenApiExemptions(String... strArr) {
        try {
            m18541invoke(VMRuntime.class, m18541invoke(VMRuntime.class, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
            return true;
        } catch (Throwable th) {
            Log.w("HiddenApiBypass", "setHiddenApiExemptions", th);
            return false;
        }
    }
}
