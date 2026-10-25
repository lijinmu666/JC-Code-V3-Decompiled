package com.p091jc.p092code.p093v3;

import android.content.ComponentName;
import android.os.IBinder;
import java.io.PrintStream;
import java.lang.reflect.Method;
import org.p370lsposed.hiddenapibypass.HiddenApiBypass;

/* loaded from: classes.dex */
public final class SetDeviceOwnerAgent {
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00c2, code lost:
    
        java.lang.System.out.println("REMOVE_NOTE clearDeviceOwner: " + r0);
     */
    /* renamed from: AZxh */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void m4878AZxh() {
        Object obj = "JC.CODE.V3";
        try {
            int i = HiddenApiBypass.f24525mjFkc;
            HiddenApiBypass.class.getMethod("addHiddenApiExemptions", String[].class).invoke(null, new String[]{"L"});
        } catch (Throwable unused) {
        }
        try {
            Object componentName = new ComponentName("JC.CODE.V3", "com.jc.code.v3.JcDeviceAdminReceiver");
            Object objInvoke = Class.forName("android.app.admin.IDevicePolicyManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "device_policy"));
            boolean zEquals = true;
            try {
                Method methodM4880mjFkc = m4880mjFkc(objInvoke.getClass(), "clearDeviceOwner", 1);
                if (methodM4880mjFkc != null) {
                    if (methodM4880mjFkc.getParameterTypes()[0] != String.class) {
                        obj = componentName;
                    }
                    Object objInvoke2 = methodM4880mjFkc.invoke(objInvoke, obj);
                    System.out.println("REMOVE_NOTE clearDeviceOwner → " + objInvoke2);
                } else {
                    System.out.println("REMOVE_NOTE clearDeviceOwner 不存在");
                }
            } catch (Throwable th) {
                if (th.getCause() != null) {
                    Throwable cause = th.getCause();
                    System.out.println("REMOVE_NOTE clearDeviceOwner: " + cause);
                } else {
                    System.out.println("REMOVE_NOTE clearDeviceOwner: " + cause);
                }
            }
            try {
                Method methodM4880mjFkc2 = m4880mjFkc(objInvoke.getClass(), "removeActiveAdmin", 2);
                if (methodM4880mjFkc2 != null) {
                    methodM4880mjFkc2.invoke(objInvoke, componentName, 0);
                    System.out.println("REMOVE_NOTE removeActiveAdmin 已调用");
                }
            } catch (Throwable th2) {
                th = th2;
                if (th.getCause() != null) {
                    th = th.getCause();
                }
                System.out.println("REMOVE_NOTE removeActiveAdmin: " + th);
            }
            try {
                Method methodM4880mjFkc3 = m4880mjFkc(objInvoke.getClass(), "hasDeviceOwner", 0);
                if (methodM4880mjFkc3 != null) {
                    Object objInvoke3 = methodM4880mjFkc3.invoke(objInvoke, null);
                    zEquals = Boolean.TRUE.equals(objInvoke3);
                    System.out.println("REMOVE_NOTE hasDeviceOwner=" + objInvoke3);
                } else {
                    Method methodM4880mjFkc4 = m4880mjFkc(objInvoke.getClass(), "getDeviceOwnerUserId", 0);
                    if (methodM4880mjFkc4 != null) {
                        Object objInvoke4 = methodM4880mjFkc4.invoke(objInvoke, null);
                        if ((objInvoke4 instanceof Integer ? ((Integer) objInvoke4).intValue() : -2) < 0) {
                            zEquals = false;
                        }
                        System.out.println("REMOVE_NOTE ownerUserId=" + objInvoke4);
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                if (th.getCause() != null) {
                    th = th.getCause();
                }
                System.out.println("REMOVE_NOTE 验证失败: " + th);
            }
            System.out.println(zEquals ? "REMOVE_FAILED 仍然是设备所有者" : "REMOVE_OK 已取消设备所有者");
        } catch (Throwable th4) {
            th = th4;
            if (th.getCause() != null) {
                th = th.getCause();
            }
            System.out.println("REMOVE_ERROR " + th);
        }
    }

    /* renamed from: main */
    public static void m4879main(String[] strArr) {
        Object objInvoke;
        try {
            String str = strArr.length > 0 ? strArr[0] : "JC.CODE.V3/com.jc.code.v3.JcDeviceAdminReceiver";
            if ("remove".equals(str)) {
                m4878AZxh();
                return;
            }
            int iIndexOf = str.indexOf(47);
            if (iIndexOf <= 0) {
                System.out.println("SET_OWNER_ERROR bad component: " + str);
                return;
            }
            String strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 1);
            if (strSubstring2.startsWith(".")) {
                strSubstring2 = strSubstring + strSubstring2;
            }
            try {
                int i = HiddenApiBypass.f24525mjFkc;
                HiddenApiBypass.class.getMethod("addHiddenApiExemptions", String[].class).invoke(null, new String[]{"L"});
            } catch (Throwable unused) {
            }
            ComponentName componentName = new ComponentName(strSubstring, strSubstring2);
            Object objInvoke2 = Class.forName("android.os.ServiceManager").getMethod("getService", String.class).invoke(null, "device_policy");
            if (objInvoke2 == null) {
                System.out.println("SET_OWNER_ERROR device_policy service not found");
                return;
            }
            Object objInvoke3 = Class.forName("android.app.admin.IDevicePolicyManager$Stub").getMethod("asInterface", IBinder.class).invoke(null, objInvoke2);
            try {
                Method methodM4880mjFkc = m4880mjFkc(objInvoke3.getClass(), "setActiveAdmin", 3);
                if (methodM4880mjFkc == null) {
                    methodM4880mjFkc = m4880mjFkc(objInvoke3.getClass(), "addActiveAdmin", 3);
                }
                if (methodM4880mjFkc != null) {
                    Class<?>[] parameterTypes = methodM4880mjFkc.getParameterTypes();
                    if (parameterTypes.length == 3 && parameterTypes[1] == Boolean.TYPE) {
                        methodM4880mjFkc.invoke(objInvoke3, componentName, Boolean.FALSE, 0);
                    } else {
                        methodM4880mjFkc.invoke(objInvoke3, componentName, 0, 0);
                    }
                    System.out.println("SET_OWNER_NOTE setActiveAdmin done (" + methodM4880mjFkc.getName() + ")");
                } else {
                    System.out.println("SET_OWNER_NOTE setActiveAdmin method missing");
                }
            } catch (Throwable th) {
                th = th;
                if (th.getCause() != null) {
                    th = th.getCause();
                }
                System.out.println("SET_OWNER_NOTE setActiveAdmin: " + th);
            }
            Method methodM4880mjFkc2 = m4880mjFkc(objInvoke3.getClass(), "setDeviceOwner", 3);
            if (methodM4880mjFkc2 != null) {
                objInvoke = methodM4880mjFkc2.invoke(objInvoke3, componentName, "JC Code V3", 0);
            } else {
                Method methodM4880mjFkc3 = m4880mjFkc(objInvoke3.getClass(), "setDeviceOwner", 2);
                if (methodM4880mjFkc3 == null) {
                    System.out.println("SET_OWNER_ERROR setDeviceOwner not found");
                    return;
                }
                objInvoke = methodM4880mjFkc3.invoke(objInvoke3, componentName, "JC Code V3");
            }
            PrintStream printStream = System.out;
            printStream.println("SET_OWNER_OK ret=" + objInvoke);
            try {
                Method methodM4880mjFkc4 = m4880mjFkc(objInvoke3.getClass(), "getDeviceOwner", 0);
                if (methodM4880mjFkc4 != null) {
                    printStream.println("SET_OWNER_NOTE currentOwner=" + methodM4880mjFkc4.invoke(objInvoke3, null));
                }
            } catch (Throwable unused2) {
            }
        } catch (Throwable th2) {
            th = th2;
            if (th.getCause() != null) {
                th = th.getCause();
            }
            System.out.println("SET_OWNER_ERROR " + th);
        }
    }

    /* renamed from: mjFkc */
    public static Method m4880mjFkc(Class cls, String str, int i) throws SecurityException {
        for (Method method : cls.getMethods()) {
            if (method.getName().equals(str) && method.getParameterTypes().length == i) {
                return method;
            }
        }
        for (Method method2 : cls.getDeclaredMethods()) {
            if (method2.getName().equals(str) && method2.getParameterTypes().length == i) {
                method2.setAccessible(true);
                return method2;
            }
        }
        return null;
    }
}
