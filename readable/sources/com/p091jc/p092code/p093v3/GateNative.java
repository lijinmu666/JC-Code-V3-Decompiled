package com.p091jc.p092code.p093v3;

import java.io.BufferedReader;
import java.io.FileReader;

/* loaded from: classes.dex */
public final class GateNative {

    /* renamed from: F_EDXP */
    public static final int f4204F_EDXP = 16;

    /* renamed from: F_FRIDA */
    public static final int f4205F_FRIDA = 2;
    public static final int F_GADGET = 128;

    /* renamed from: F_LSPD */
    public static final int f4206F_LSPD = 512;
    public static final int F_LSPOSED = 8;
    public static final int F_MAPS_ERR = 2048;

    /* renamed from: F_RIRU */
    public static final int f4207F_RIRU = 32;
    public static final int F_SUBSTRATE = 256;
    public static final int F_TAICHI = 1024;
    public static final int F_TRACER = 1;
    public static final int F_XPOSED = 4;
    public static final int F_ZYGISK = 64;
    public static final int LOCK_MASK = 3999;
    public static final int SOFT_MASK = 96;
    private static final boolean S_LOADED;

    static {
        boolean z;
        try {
            System.loadLibrary("gatejni");
            z = true;
        } catch (Throwable unused) {
            z = false;
        }
        S_LOADED = z;
    }

    private GateNative() {
    }

    public static native int aliveMagic();

    public static boolean available() {
        return S_LOADED;
    }

    public static native int envCheck();

    public static int javaEnvFlags() {
        int i = 0;
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("/proc/self/status"));
            while (true) {
                String line = bufferedReader.readLine();
                if (line == null) {
                    break;
                }
                if (line.startsWith("TracerPid:")) {
                    if (Integer.parseInt(line.substring(10).trim()) > 0) {
                        i = 1;
                    }
                }
            }
            bufferedReader.close();
        } catch (Throwable unused) {
        }
        try {
            BufferedReader bufferedReader2 = new BufferedReader(new FileReader("/proc/self/maps"));
            while (true) {
                String line2 = bufferedReader2.readLine();
                if (line2 == null) {
                    bufferedReader2.close();
                    return i;
                }
                if (line2.contains("frida")) {
                    i |= 2;
                }
                if (line2.contains("xposed")) {
                    i |= 4;
                }
                if (line2.contains("lsposed")) {
                    i |= 8;
                }
                if (line2.contains("edxp")) {
                    i |= 16;
                }
                if (line2.contains("riru")) {
                    i |= 32;
                }
                if (line2.contains("zygisk")) {
                    i |= 64;
                }
                if (line2.contains("gadget")) {
                    i |= 128;
                }
                if (line2.contains("substrate")) {
                    i |= 256;
                }
                if (line2.contains("lspd")) {
                    i |= 512;
                }
                if (line2.contains("taichi")) {
                    i |= 1024;
                }
            }
        } catch (Throwable unused2) {
            return i | 2048;
        }
    }

    public static boolean stackHooked() {
        try {
            for (StackTraceElement stackTraceElement : new Throwable().getStackTrace()) {
                String lowerCase = stackTraceElement.getClassName().toLowerCase();
                if (lowerCase.contains("xposed") || lowerCase.contains("lsposed") || lowerCase.contains("edxposed") || lowerCase.contains("frida") || lowerCase.contains("de.robv")) {
                    return true;
                }
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }
}
