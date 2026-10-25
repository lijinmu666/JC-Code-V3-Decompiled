package com.jc.code.v3;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.conscrypt.BuildConfig;

/* renamed from: com.jc.code.v3.AZxh */
/* loaded from: classes.dex */
public abstract class LocalAdbBridge {

    /* renamed from: AZxh */
    public static volatile boolean runnerReady;

    /* renamed from: mjFkc */
    public static final Object commandLock = new Object();

    /* JADX WARN: Can't change package for inner class: com.jc.code.v3.AZxh.mjFkc to com.jc.code.v3.LocalAdbBridge$BridgeException */
    /* renamed from: com.jc.code.v3.AZxh$mjFkc */
    public static class mjFkc extends Exception {
        public mjFkc(String str) {
            super(str);
        }
    }

    /* renamed from: AZxh */
    public static void deleteQuietly(File file) {
        try {
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: JHa */
    public static void resetReady() {
        runnerReady = false;
    }

    /* renamed from: KLFTb */
    public static boolean isReady() {
        return runnerReady;
    }

    /* renamed from: ZfxDd */
    public static String executeUnlocked(String str, long j) throws Throwable {
        File file = new File("/sdcard/jc_adb_bridge");
        if (!file.exists() && !file.mkdirs()) {
            throw new mjFkc("本地目录不可用: /sdcard/jc_adb_bridge");
        }
        deleteQuietly(new File("/sdcard/jc_adb_bridge/code.txt"));
        deleteQuietly(new File("/sdcard/jc_adb_bridge/out.txt"));
        String str2 = "JC_TOKEN_" + System.nanoTime();
        writeUtf8(new File("/sdcard/jc_adb_bridge/cmd.tmp"), "echo " + str2 + "\n" + str + "\n");
        File file2 = new File("/sdcard/jc_adb_bridge/cmd.sh");
        if (file2.exists()) {
            file2.delete();
        }
        if (!new File("/sdcard/jc_adb_bridge/cmd.tmp").renameTo(file2)) {
            throw new mjFkc("命令写入失败");
        }
        long jCurrentTimeMillis = System.currentTimeMillis() + j;
        while (System.currentTimeMillis() < jCurrentTimeMillis) {
            if (new File("/sdcard/jc_adb_bridge/code.txt").exists()) {
                String utf8 = readUtf8(new File("/sdcard/jc_adb_bridge/out.txt"));
                if (utf8 != null && utf8.contains(str2)) {
                    deleteQuietly(new File("/sdcard/jc_adb_bridge/code.txt"));
                    deleteQuietly(new File("/sdcard/jc_adb_bridge/out.txt"));
                    int iIndexOf = utf8.indexOf(10);
                    return parseCommandResult(iIndexOf >= 0 ? utf8.substring(iIndexOf + 1) : BuildConfig.f24315FLAVOR);
                }
                deleteQuietly(new File("/sdcard/jc_adb_bridge/code.txt"));
                deleteQuietly(new File("/sdcard/jc_adb_bridge/out.txt"));
            }
            try {
                Thread.sleep(50L);
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
                throw new mjFkc("命令被中断");
            }
        }
        throw new mjFkc("本地 ADB 命令超时（" + j + "ms）");
    }

    /* renamed from: lgHUyS */
    public static String readUtf8(File file) throws Throwable {
        FileInputStream fileInputStream;
        FileInputStream fileInputStream2 = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (Exception unused) {
            fileInputStream = null;
        } catch (Throwable th) {
            th = th;
        }
        try {
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
            String str = new String(bArr, 0, i, "UTF-8");
            try {
                fileInputStream.close();
            } catch (Exception unused2) {
            }
            return str;
        } catch (Exception unused3) {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (Exception unused4) {
                }
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
            fileInputStream2 = fileInputStream;
            if (fileInputStream2 != null) {
                try {
                    fileInputStream2.close();
                } catch (Exception unused5) {
                }
            }
            throw th;
        }
    }

    /* renamed from: mjFkc */
    public static boolean ensureRunner() {
        synchronized (commandLock) {
            if (runnerReady) {
                return true;
            }
            try {
                AdbConnectionManager.m4892JBhc("pkill -f 'jc_adb_bridg[e]/cmd' >/dev/null 2>&1; sleep 0.5; echo CLEANED");
            } catch (Throwable unused) {
            }
            try {
                AdbConnectionManager.m4892JBhc("mkdir -p /sdcard/jc_adb_bridge; rm -f /sdcard/jc_adb_bridge/cmd.sh /sdcard/jc_adb_bridge/code.txt /sdcard/jc_adb_bridge/cmd.tmp; nohup sh -c 'while :; do if [ -f /sdcard/jc_adb_bridge/cmd.sh ]; then ( sh /sdcard/jc_adb_bridge/cmd.sh 2>&1; printf \"\\nJC_RC:%s\\n\" \"$?\" ) | cat > /sdcard/jc_adb_bridge/out.txt; echo done > /sdcard/jc_adb_bridge/code.txt; rm -f /sdcard/jc_adb_bridge/cmd.sh; fi; sleep 0.3; done' >/dev/null 2>&1 & echo RUNNER_STARTED");
                String strExecuteUnlocked = executeUnlocked("echo LOCAL_ADB_OK", 8000L);
                if (strExecuteUnlocked != null && strExecuteUnlocked.contains("LOCAL_ADB_OK")) {
                    runnerReady = true;
                    return true;
                }
            } catch (Throwable unused2) {
            }
            runnerReady = false;
            return false;
        }
    }

    /* renamed from: qdMbNW */
    public static void writeUtf8(File file, String str) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            fileOutputStream.write(str.getBytes("UTF-8"));
            fileOutputStream.flush();
        } finally {
            try {
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }

    /* renamed from: wA */
    public static String execute(String str, long j) {
        String strExecuteUnlocked;
        synchronized (commandLock) {
            strExecuteUnlocked = executeUnlocked(str, j);
        }
        return strExecuteUnlocked;
    }

    /* renamed from: xJ */
    public static String parseCommandResult(String str) throws NumberFormatException {
        int i;
        if (str == null) {
            str = BuildConfig.f24315FLAVOR;
        }
        int iLastIndexOf = str.lastIndexOf("JC_RC:");
        int i2 = 0;
        if (iLastIndexOf >= 0) {
            String strTrim = str.substring(iLastIndexOf + 6).trim();
            int i3 = 0;
            while (i3 < strTrim.length() && Character.isDigit(strTrim.charAt(i3))) {
                i3++;
            }
            if (i3 > 0) {
                try {
                    i = Integer.parseInt(strTrim.substring(0, i3));
                } catch (NumberFormatException unused) {
                }
                str = str.substring(0, iLastIndexOf);
                while (true) {
                    if (str.endsWith("\n") && !str.endsWith("\r")) {
                        break;
                    }
                    str = str.substring(0, str.length() - 1);
                }
                i2 = i;
            } else {
                i = 0;
                str = str.substring(0, iLastIndexOf);
                while (true) {
                    if (str.endsWith("\n")) {
                    }
                    str = str.substring(0, str.length() - 1);
                }
                i2 = i;
            }
        }
        if (i2 == 0) {
            return str;
        }
        if (str.length() <= 0) {
            str = "退出码 " + i2;
        }
        throw new IllegalStateException(str);
    }
}
