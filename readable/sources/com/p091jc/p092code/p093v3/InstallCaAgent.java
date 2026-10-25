package com.p091jc.p092code.p093v3;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Looper;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import org.p370lsposed.hiddenapibypass.HiddenApiBypass;

/* loaded from: classes.dex */
public final class InstallCaAgent {

    /* renamed from: mjFkc */
    public static volatile IBinder f4210mjFkc;

    /* renamed from: com.jc.code.v3.InstallCaAgent$AZxh */
    public class RunnableC0907AZxh implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ byte[] f4211mjFkc;

        public RunnableC0907AZxh(byte[] bArr) {
            this.f4211mjFkc = bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                long jCurrentTimeMillis = System.currentTimeMillis() + 15000;
                while (InstallCaAgent.f4210mjFkc == null && System.currentTimeMillis() < jCurrentTimeMillis) {
                    Thread.sleep(100L);
                }
            } catch (Throwable th) {
                th = th;
                if (th.getCause() != null) {
                    th = th.getCause();
                }
                System.out.println("INSTALL_CA_ERROR " + th);
            }
            if (InstallCaAgent.f4210mjFkc == null) {
                System.out.println("INSTALL_CA_ERROR bind timeout");
                System.exit(1);
                return;
            }
            Object objInvoke = Class.forName("android.security.IKeyChainService$Stub").getMethod("asInterface", IBinder.class).invoke(null, InstallCaAgent.f4210mjFkc);
            Method methodM4385ZfxDd = InstallCaAgent.m4385ZfxDd(objInvoke.getClass(), "installCaCertificate", 1);
            if (methodM4385ZfxDd == null) {
                System.out.println("INSTALL_CA_ERROR installCaCertificate not found");
                System.exit(1);
                return;
            }
            Object objInvoke2 = methodM4385ZfxDd.invoke(objInvoke, this.f4211mjFkc);
            System.out.println("INSTALL_CA_OK alias=" + objInvoke2);
            System.exit(0);
        }
    }

    /* renamed from: com.jc.code.v3.InstallCaAgent$mjFkc */
    public class ServiceConnectionC0908mjFkc implements ServiceConnection {
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            IBinder unused = InstallCaAgent.f4210mjFkc = iBinder;
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            IBinder unused = InstallCaAgent.f4210mjFkc = null;
        }
    }

    /* renamed from: KLFTb */
    public static byte[] m4384KLFTb(File file) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        int length = (int) file.length();
        byte[] bArr = new byte[length];
        int i = 0;
        while (i < length) {
            int i2 = fileInputStream.read(bArr, i, length - i);
            if (i2 < 0) {
                break;
            }
            i += i2;
        }
        fileInputStream.close();
        return bArr;
    }

    /* renamed from: ZfxDd */
    public static Method m4385ZfxDd(Class cls, String str, int i) throws SecurityException {
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

    /* renamed from: main */
    public static void m4386main(String[] strArr) {
        String str = strArr.length > 0 ? strArr[0] : "/sdcard/jc_dev_ca.crt";
        try {
            File file = new File(str);
            if (!file.exists()) {
                System.out.println("INSTALL_CA_ERROR cert not found: " + str);
                return;
            }
            byte[] bArrM4384KLFTb = m4384KLFTb(file);
            try {
                int i = HiddenApiBypass.f24525mjFkc;
                HiddenApiBypass.class.getMethod("addHiddenApiExemptions", String[].class).invoke(null, new String[]{"L"});
            } catch (Throwable unused) {
            }
            Looper.prepareMainLooper();
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Context context = (Context) cls.getMethod("getSystemContext", null).invoke(cls.getMethod("systemMain", null).invoke(null, null), null);
            Intent intent = new Intent("android.security.IKeyChainService");
            intent.setComponent(new ComponentName("com.android.keychain", "com.android.keychain.KeyChainService"));
            boolean zBindService = context.bindService(intent, new ServiceConnectionC0908mjFkc(), 1);
            System.out.println("INSTALL_CA_NOTE bindService=" + zBindService);
            Thread thread = new Thread(new RunnableC0907AZxh(bArrM4384KLFTb), "ca-install");
            thread.setDaemon(true);
            thread.start();
            Looper.loop();
            System.exit(0);
        } catch (Throwable th) {
            th = th;
            if (th.getCause() != null) {
                th = th.getCause();
            }
            System.out.println("INSTALL_CA_ERROR " + th);
        }
    }
}
