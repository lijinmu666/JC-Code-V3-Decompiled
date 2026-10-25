package com.p091jc.p092code.p093v3;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.pm.PackageInfo;
import android.content.pm.PackageInstaller;
import android.content.pm.PackageManager;
import android.os.Looper;
import com.flyfishxu.p028kadb.p030core.AdbProtocol;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import org.conscrypt.BuildConfig;
import org.p370lsposed.hiddenapibypass.HiddenApiBypass;

/* loaded from: classes.dex */
public final class InstallAgent {

    /* renamed from: com.jc.code.v3.InstallAgent$AZxh */
    public class RunnableC0905AZxh implements Runnable {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4208mjFkc;

        public RunnableC0905AZxh(String str) {
            this.f4208mjFkc = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Thread.sleep(40000L);
            } catch (Throwable unused) {
            }
            PrintStream printStream = System.out;
            StringBuilder sb = new StringBuilder();
            sb.append("INSTALL_AGENT_TIMEOUT ");
            String str = this.f4208mjFkc;
            if (str == null) {
                str = BuildConfig.f24315FLAVOR;
            }
            sb.append(str);
            printStream.println(sb.toString());
            System.exit(0);
        }
    }

    /* renamed from: com.jc.code.v3.InstallAgent$mjFkc */
    public class C0906mjFkc extends BroadcastReceiver {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f4209mjFkc;

        public C0906mjFkc(String str) {
            this.f4209mjFkc = str;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            int intExtra = intent.getIntExtra("android.content.pm.extra.STATUS", -999);
            String stringExtra = intent.getStringExtra("android.content.pm.extra.STATUS_MESSAGE");
            int intExtra2 = intent.getIntExtra("android.content.pm.extra.LEGACY_STATUS", 0);
            PrintStream printStream = System.out;
            printStream.println("INSTALL_AGENT_STATUS status=" + intExtra + " legacy=" + intExtra2 + " msg=" + stringExtra);
            if (intExtra == 0) {
                StringBuilder sb = new StringBuilder();
                sb.append("INSTALL_AGENT_OK ");
                String str = this.f4209mjFkc;
                if (str == null) {
                    str = BuildConfig.f24315FLAVOR;
                }
                sb.append(str);
                printStream.println(sb.toString());
            } else {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("INSTALL_AGENT_ERROR ");
                if (stringExtra == null) {
                    stringExtra = "status=" + intExtra + " legacy=" + intExtra2;
                }
                sb2.append(stringExtra);
                printStream.println(sb2.toString());
            }
            Looper.myLooper().quitSafely();
        }
    }

    /* renamed from: AZxh */
    public static void m4380AZxh() {
        try {
            try {
                int i = HiddenApiBypass.f24525mjFkc;
                HiddenApiBypass.class.getMethod("addHiddenApiExemptions", String[].class).invoke(null, new String[]{"L"});
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            cls.getMethod("setHiddenApiExemptions", String[].class).invoke(cls.getMethod("getRuntime", null).invoke(null, null), new String[]{"L"});
        }
    }

    /* renamed from: main */
    public static void m4381main(String[] strArr) {
        OutputStream outputStreamOpenWrite;
        FileInputStream fileInputStream;
        boolean z;
        PackageInfo packageArchiveInfo;
        if (strArr != null) {
            try {
                if (strArr.length >= 1) {
                    File file = new File(strArr[0]);
                    if (!file.exists()) {
                        System.out.println("INSTALL_AGENT_ERROR apk not found: " + strArr[0]);
                        return;
                    }
                    m4380AZxh();
                    Looper.prepareMainLooper();
                    Class<?> cls = Class.forName("android.app.ActivityThread");
                    FileInputStream fileInputStream2 = null;
                    Context context = (Context) cls.getMethod("getSystemContext", null).invoke(cls.getMethod("systemMain", null).invoke(null, null), null);
                    try {
                        Context contextCreatePackageContext = context.createPackageContext("JC.CODE.V3", 2);
                        if (contextCreatePackageContext != null) {
                            context = contextCreatePackageContext;
                        }
                    } catch (Throwable unused) {
                    }
                    PackageManager packageManager = context.getPackageManager();
                    try {
                        packageArchiveInfo = packageManager.getPackageArchiveInfo(file.getAbsolutePath(), 0);
                    } catch (Throwable unused2) {
                    }
                    String str = packageArchiveInfo != null ? packageArchiveInfo.packageName : null;
                    PackageInstaller packageInstaller = packageManager.getPackageInstaller();
                    PackageInstaller.SessionParams sessionParams = new PackageInstaller.SessionParams(1);
                    if (str != null) {
                        sessionParams.setAppPackageName(str);
                    }
                    try {
                        Field declaredField = sessionParams.getClass().getDeclaredField("installFlags");
                        declaredField.setAccessible(true);
                        declaredField.setInt(sessionParams, declaredField.getInt(sessionParams) | 1048742);
                    } catch (Throwable unused3) {
                    }
                    int iCreateSession = packageInstaller.createSession(sessionParams);
                    PackageInstaller.Session sessionOpenSession = packageInstaller.openSession(iCreateSession);
                    try {
                        outputStreamOpenWrite = sessionOpenSession.openWrite("base.apk", 0L, file.length());
                        try {
                            fileInputStream = new FileInputStream(file);
                        } catch (Throwable th) {
                            th = th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        outputStreamOpenWrite = null;
                    }
                    try {
                        byte[] bArr = new byte[PKIFailureInfo.transactionIdInUse];
                        while (true) {
                            int i = fileInputStream.read(bArr);
                            if (i <= 0) {
                                break;
                            } else {
                                outputStreamOpenWrite.write(bArr, 0, i);
                            }
                        }
                        outputStreamOpenWrite.flush();
                        sessionOpenSession.fsync(outputStreamOpenWrite);
                        try {
                            fileInputStream.close();
                        } catch (Throwable unused4) {
                        }
                        try {
                            outputStreamOpenWrite.close();
                        } catch (Throwable unused5) {
                        }
                        try {
                            context.registerReceiver(new C0906mjFkc(str), new IntentFilter("com.jc.code.v3.INSTALL_AGENT_STATUS"));
                            z = true;
                        } catch (Throwable th3) {
                            System.out.println("INSTALL_AGENT_NOTE status receiver unavailable: " + th3);
                            z = false;
                        }
                        sessionOpenSession.commit(m4382mjFkc(context));
                        sessionOpenSession.close();
                        PrintStream printStream = System.out;
                        StringBuilder sb = new StringBuilder();
                        sb.append("INSTALL_AGENT_COMMITTED ");
                        sb.append(iCreateSession);
                        sb.append(" ");
                        sb.append(str != null ? str : BuildConfig.f24315FLAVOR);
                        printStream.println(sb.toString());
                        if (z) {
                            Thread thread = new Thread(new RunnableC0905AZxh(str), "agent-watchdog");
                            thread.setDaemon(true);
                            thread.start();
                            Looper.loop();
                            System.exit(0);
                        }
                        if (str == null) {
                            return;
                        }
                        long jCurrentTimeMillis = System.currentTimeMillis() + 30000;
                        while (System.currentTimeMillis() < jCurrentTimeMillis) {
                            try {
                                packageManager.getPackageInfo(str, 0);
                                System.out.println("INSTALL_AGENT_OK " + str);
                                return;
                            } catch (Throwable unused6) {
                                try {
                                    Thread.sleep(500L);
                                } catch (Throwable unused7) {
                                }
                            }
                        }
                        System.out.println("INSTALL_AGENT_TIMEOUT " + str);
                        return;
                    } catch (Throwable th4) {
                        th = th4;
                        fileInputStream2 = fileInputStream;
                        if (fileInputStream2 != null) {
                            try {
                                fileInputStream2.close();
                            } catch (Throwable unused8) {
                            }
                        }
                        if (outputStreamOpenWrite == null) {
                            throw th;
                        }
                        try {
                            outputStreamOpenWrite.close();
                            throw th;
                        } catch (Throwable unused9) {
                            throw th;
                        }
                    }
                }
            } catch (Throwable th5) {
                PrintStream printStream2 = System.out;
                printStream2.println("INSTALL_AGENT_ERROR " + th5);
                PrintWriter printWriter = new PrintWriter(printStream2);
                th5.printStackTrace(printWriter);
                printWriter.flush();
                return;
            }
        }
        System.out.println("INSTALL_AGENT_ERROR usage: InstallAgent <apkPath>");
    }

    /* renamed from: mjFkc */
    public static IntentSender m4382mjFkc(Context context) {
        try {
            Context contextCreatePackageContext = context.createPackageContext("com.android.shell", 2);
            if (contextCreatePackageContext != null) {
                context = contextCreatePackageContext;
            }
        } catch (Throwable unused) {
        }
        try {
            return PendingIntent.getBroadcast(context, 0, new Intent("com.jc.code.v3.INSTALL_AGENT_STATUS"), 67108864).getIntentSender();
        } catch (Throwable unused2) {
            return PendingIntent.getBroadcast(context, 0, new Intent("com.jc.code.v3.INSTALL_AGENT_STATUS"), AdbProtocol.INITIAL_DELAYED_ACK_BYTES).getIntentSender();
        }
    }
}
