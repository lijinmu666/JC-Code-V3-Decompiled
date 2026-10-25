package p131o;

import android.os.Looper;
import android.util.Log;

/* renamed from: o.jD */
/* loaded from: classes.dex */
public abstract class AbstractC3934jD {

    /* renamed from: AZxh */
    public static Thread f14280AZxh;

    /* renamed from: mjFkc */
    public static ClassLoader f14281mjFkc;

    /* JADX WARN: Removed duplicated region for block: B:52:0x00aa A[Catch: all -> 0x00a6, PHI: r1
      0x00aa: PHI (r1v4 java.lang.Thread) = (r1v3 java.lang.Thread), (r1v15 java.lang.Thread) binds: [B:7:0x000a, B:46:0x00a3] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #3 {, blocks: (B:4:0x0003, B:6:0x0007, B:8:0x000c, B:45:0x00a1, B:60:0x00d0, B:12:0x001f, B:51:0x00a9, B:52:0x00aa, B:63:0x00d4, B:64:0x00d5, B:53:0x00ab, B:59:0x00cf, B:58:0x00b5, B:13:0x0020, B:15:0x002d, B:25:0x0047, B:26:0x004e, B:28:0x0059, B:34:0x006e, B:35:0x0075, B:42:0x0085, B:43:0x009f, B:18:0x003c), top: B:74:0x0003, inners: #1, #6 }] */
    /* renamed from: mjFkc */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized ClassLoader m12408mjFkc() {
        SecurityException e;
        Thread thread;
        ThreadGroup threadGroup;
        if (f14281mjFkc == null) {
            Thread thread2 = f14280AZxh;
            ClassLoader contextClassLoader = null;
            if (thread2 != null) {
                synchronized (thread2) {
                    try {
                        contextClassLoader = f14280AZxh.getContextClassLoader();
                    } catch (SecurityException e2) {
                        Log.w("DynamiteLoaderV2CL", "Failed to get thread context classloader " + e2.getMessage());
                    }
                }
                f14281mjFkc = contextClassLoader;
            } else {
                ThreadGroup threadGroup2 = Looper.getMainLooper().getThread().getThreadGroup();
                if (threadGroup2 == null) {
                    thread2 = null;
                } else {
                    synchronized (Void.class) {
                        try {
                            try {
                                int iActiveGroupCount = threadGroup2.activeGroupCount();
                                ThreadGroup[] threadGroupArr = new ThreadGroup[iActiveGroupCount];
                                threadGroup2.enumerate(threadGroupArr);
                                int i = 0;
                                int i2 = 0;
                                while (true) {
                                    if (i2 >= iActiveGroupCount) {
                                        threadGroup = null;
                                        break;
                                    }
                                    threadGroup = threadGroupArr[i2];
                                    if ("dynamiteLoader".equals(threadGroup.getName())) {
                                        break;
                                    }
                                    i2++;
                                }
                                if (threadGroup == null) {
                                    threadGroup = new ThreadGroup(threadGroup2, "dynamiteLoader");
                                }
                                int iActiveCount = threadGroup.activeCount();
                                Thread[] threadArr = new Thread[iActiveCount];
                                threadGroup.enumerate(threadArr);
                                while (true) {
                                    if (i >= iActiveCount) {
                                        thread = null;
                                        break;
                                    }
                                    thread = threadArr[i];
                                    if ("GmsDynamite".equals(thread.getName())) {
                                        break;
                                    }
                                    i++;
                                }
                                if (thread == null) {
                                    try {
                                        C4599tB c4599tB = new C4599tB(threadGroup, "GmsDynamite");
                                        try {
                                            c4599tB.setContextClassLoader(null);
                                            c4599tB.start();
                                            thread = c4599tB;
                                        } catch (SecurityException e3) {
                                            e = e3;
                                            thread = c4599tB;
                                            Log.w("DynamiteLoaderV2CL", "Failed to enumerate thread/threadgroup " + e.getMessage());
                                            thread2 = thread;
                                            f14280AZxh = thread2;
                                            if (thread2 != null) {
                                            }
                                            f14281mjFkc = contextClassLoader;
                                            return f14281mjFkc;
                                        }
                                    } catch (SecurityException e4) {
                                        e = e4;
                                    }
                                }
                            } catch (SecurityException e5) {
                                e = e5;
                                thread = null;
                            }
                        } finally {
                        }
                    }
                    thread2 = thread;
                }
                f14280AZxh = thread2;
                if (thread2 != null) {
                }
                f14281mjFkc = contextClassLoader;
            }
        }
        return f14281mjFkc;
    }
}
