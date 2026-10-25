package com.p038google.p039android.p042gms.dynamite;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.p038google.p039android.p042gms.p046common.p048util.DynamiteApi;
import dalvik.system.DelegateLastClassLoader;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import p131o.AbstractC2138I3;
import p131o.AbstractC2693QP;
import p131o.AbstractC2931U2;
import p131o.AbstractC3934jD;
import p131o.AbstractC4550sS;
import p131o.BinderC2869T2;
import p131o.C1892ET;
import p131o.C3232YS;
import p131o.C3661f;
import p131o.C3691fR;
import p131o.C5000zF;
import p131o.InterfaceC1929F;

/* loaded from: classes.dex */
public final class DynamiteModule {

    /* renamed from: Dt */
    public static boolean f2261Dt = false;

    /* renamed from: ETF */
    public static int f2262ETF = -1;

    /* renamed from: IEE */
    public static C1892ET f2263IEE;

    /* renamed from: VA */
    public static Boolean f2267VA;

    /* renamed from: fehf */
    public static C3232YS f2270fehf;

    /* renamed from: lgHUyS */
    public static Boolean f2271lgHUyS;

    /* renamed from: qdMbNW */
    public static String f2273qdMbNW;

    /* renamed from: mjFkc */
    public final Context f2277mjFkc;

    /* renamed from: MiMN */
    public static final ThreadLocal f2266MiMN = new ThreadLocal();

    /* renamed from: YoKzxo */
    public static final ThreadLocal f2268YoKzxo = new C5000zF();

    /* renamed from: rkYL */
    public static final InterfaceC0212AZxh.mjFkc f2274rkYL = new C0218mjFkc();

    /* renamed from: AZxh */
    public static final InterfaceC0212AZxh f2260AZxh = new C0211AZxh();

    /* renamed from: wA */
    public static final InterfaceC0212AZxh f2275wA = new C0220wA();

    /* renamed from: ZfxDd */
    public static final InterfaceC0212AZxh f2269ZfxDd = new C0216ZfxDd();

    /* renamed from: KLFTb */
    public static final InterfaceC0212AZxh f2265KLFTb = new C0215KLFTb();

    /* renamed from: JHa */
    public static final InterfaceC0212AZxh f2264JHa = new C0214JHa();

    /* renamed from: xJ */
    public static final InterfaceC0212AZxh f2276xJ = new C0221xJ();

    /* renamed from: qGY */
    public static final InterfaceC0212AZxh f2272qGY = new C0217lgHUyS();

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$AZxh */
    public interface InterfaceC0212AZxh {

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$AZxh$AZxh */
        public static class AZxh {

            /* renamed from: mjFkc */
            public int f2279mjFkc = 0;

            /* renamed from: AZxh */
            public int f2278AZxh = 0;

            /* renamed from: wA */
            public int f2280wA = 0;
        }

        /* renamed from: com.google.android.gms.dynamite.DynamiteModule$AZxh$mjFkc */
        public interface mjFkc {
            /* renamed from: AZxh */
            int mo2404AZxh(Context context, String str, boolean z);

            /* renamed from: mjFkc */
            int mo2405mjFkc(Context context, String str);
        }

        /* renamed from: mjFkc */
        AZxh mo2392mjFkc(Context context, String str, mjFkc mjfkc);
    }

    @DynamiteApi
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* renamed from: com.google.android.gms.dynamite.DynamiteModule$mjFkc */
    public static class C0213mjFkc extends Exception {
        public /* synthetic */ C0213mjFkc(String str, AbstractC4550sS abstractC4550sS) {
            super(str);
        }

        public /* synthetic */ C0213mjFkc(String str, Throwable th, AbstractC4550sS abstractC4550sS) {
            super(str, th);
        }
    }

    public DynamiteModule(Context context) {
        AbstractC2138I3.m8648xJ(context);
        this.f2277mjFkc = context;
    }

    /* renamed from: AZxh */
    public static int m2393AZxh(Context context, String str) {
        return m2397KLFTb(context, str, false);
    }

    /* renamed from: Dt */
    public static boolean m2394Dt(Context context) {
        ApplicationInfo applicationInfo;
        Boolean bool = Boolean.TRUE;
        if (bool.equals(null) || bool.equals(f2267VA)) {
            return true;
        }
        boolean z = false;
        if (f2267VA == null) {
            ProviderInfo providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (C3661f.m11873JHa().mo11785lgHUyS(context, 10000000) == 0 && providerInfoResolveContentProvider != null && "com.google.android.gms".equals(providerInfoResolveContentProvider.packageName)) {
                z = true;
            }
            f2267VA = Boolean.valueOf(z);
            if (z && (applicationInfo = providerInfoResolveContentProvider.applicationInfo) != null && (applicationInfo.flags & 129) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                f2261Dt = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    /* renamed from: ETF */
    public static C3232YS m2395ETF(Context context) {
        C3232YS c3232ys;
        synchronized (DynamiteModule.class) {
            C3232YS c3232ys2 = f2270fehf;
            if (c3232ys2 != null) {
                return c3232ys2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    c3232ys = null;
                } else {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    c3232ys = iInterfaceQueryLocalInterface instanceof C3232YS ? (C3232YS) iInterfaceQueryLocalInterface : new C3232YS(iBinder);
                }
                if (c3232ys != null) {
                    f2270fehf = c3232ys;
                    return c3232ys;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
            return null;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00e0  */
    /* JADX WARN: Type inference failed for: r0v0 */
    /* JADX WARN: Type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* renamed from: JHa */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m2396JHa(Context context, String str, boolean z, boolean z2) throws Throwable {
        Throwable th;
        Exception e;
        ?? r0 = 0;
        ?? r02 = 0;
        ?? r03 = 0;
        ?? r04 = 0;
        try {
            try {
                boolean z3 = true;
                Cursor cursorQuery = context.getContentResolver().query(new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").path(true != z ? "api" : "api_force_staging").appendPath(str).appendQueryParameter("requestStartTime", String.valueOf(((Long) f2268YoKzxo.get()).longValue())).build(), null, null, null, null);
                if (cursorQuery != null) {
                    try {
                        if (cursorQuery.moveToFirst()) {
                            boolean z4 = false;
                            int i = cursorQuery.getInt(0);
                            if (i > 0) {
                                synchronized (DynamiteModule.class) {
                                    try {
                                        f2273qdMbNW = cursorQuery.getString(2);
                                        int columnIndex = cursorQuery.getColumnIndex("loaderVersion");
                                        if (columnIndex >= 0) {
                                            f2262ETF = cursorQuery.getInt(columnIndex);
                                        }
                                        int columnIndex2 = cursorQuery.getColumnIndex("disableStandaloneDynamiteLoader2");
                                        if (columnIndex2 >= 0) {
                                            if (cursorQuery.getInt(columnIndex2) == 0) {
                                                z3 = false;
                                            }
                                            f2261Dt = z3;
                                            z4 = z3;
                                        }
                                    } finally {
                                    }
                                }
                                if (m2401qdMbNW(cursorQuery)) {
                                    cursorQuery = null;
                                }
                            }
                            if (z2 && z4) {
                                throw new C0213mjFkc("forcing fallback to container DynamiteLoader impl", r03 == true ? 1 : 0);
                            }
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                            return i;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        if (e instanceof C0213mjFkc) {
                            throw e;
                        }
                        throw new C0213mjFkc("V2 version check failed: " + e.getMessage(), e, r02 == true ? 1 : 0);
                    }
                }
                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                throw new C0213mjFkc("Failed to connect to dynamite module ContentResolver.", r04 == true ? 1 : 0);
            } catch (Throwable th2) {
                th = th2;
                r0 = context;
                if (r0 != 0) {
                    r0.close();
                }
                throw th;
            }
        } catch (Exception e3) {
            e = e3;
        } catch (Throwable th3) {
            th = th3;
            if (r0 != 0) {
            }
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:48:0x0097 A[Catch: all -> 0x0036, TryCatch #2 {, blocks: (B:9:0x0026, B:11:0x0032, B:49:0x00a0, B:16:0x003b, B:18:0x0041, B:20:0x0047, B:25:0x004d, B:27:0x0051, B:31:0x005b, B:33:0x0063, B:36:0x006a, B:40:0x007f, B:41:0x0087, B:39:0x0071, B:44:0x008a, B:47:0x008d, B:48:0x0097, B:17:0x003e), top: B:126:0x0026, inners: #7 }] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x015b A[Catch: all -> 0x00cf, TRY_ENTER, TRY_LEAVE, TryCatch #10 {all -> 0x00cf, blocks: (B:3:0x0002, B:57:0x00c4, B:59:0x00ca, B:66:0x00ee, B:94:0x014d, B:98:0x015b, B:116:0x01ad, B:117:0x01b0, B:111:0x01a5, B:64:0x00d3, B:119:0x01b2, B:4:0x0003, B:7:0x0009, B:8:0x0025, B:55:0x00c1, B:21:0x0048, B:42:0x0088, B:45:0x008b, B:52:0x00a3, B:56:0x00c3, B:54:0x00a5), top: B:137:0x0002, inners: #5, #6 }] */
    /* renamed from: KLFTb */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static int m2397KLFTb(Context context, String str, boolean z) {
        Field declaredField;
        Throwable th;
        RemoteException e;
        Cursor cursor;
        try {
            synchronized (DynamiteModule.class) {
                Boolean bool = f2271lgHUyS;
                int iM11124Ucbh = 0;
                if (bool == null) {
                    try {
                        declaredField = context.getApplicationContext().getClassLoader().loadClass(DynamiteLoaderClassLoader.class.getName()).getDeclaredField("sClassLoader");
                    } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException e2) {
                        Log.w("DynamiteModule", "Failed to load module via V2: " + e2.toString());
                        bool = Boolean.FALSE;
                    }
                    synchronized (declaredField.getDeclaringClass()) {
                        ClassLoader classLoader = (ClassLoader) declaredField.get(null);
                        if (classLoader == ClassLoader.getSystemClassLoader()) {
                            bool = Boolean.FALSE;
                        } else if (classLoader != null) {
                            try {
                                m2399lgHUyS(classLoader);
                            } catch (C0213mjFkc unused) {
                            }
                            bool = Boolean.TRUE;
                        } else {
                            if (!m2394Dt(context)) {
                                return 0;
                            }
                            if (!f2261Dt) {
                                Boolean bool2 = Boolean.TRUE;
                                if (bool2.equals(null)) {
                                    declaredField.set(null, ClassLoader.getSystemClassLoader());
                                    bool = Boolean.FALSE;
                                } else {
                                    try {
                                        int iM2396JHa = m2396JHa(context, str, z, true);
                                        String str2 = f2273qdMbNW;
                                        if (str2 != null && !str2.isEmpty()) {
                                            ClassLoader classLoaderM12408mjFkc = AbstractC3934jD.m12408mjFkc();
                                            if (classLoaderM12408mjFkc == null) {
                                                String str3 = f2273qdMbNW;
                                                AbstractC2138I3.m8648xJ(str3);
                                                classLoaderM12408mjFkc = new DelegateLastClassLoader(str3, ClassLoader.getSystemClassLoader());
                                            }
                                            m2399lgHUyS(classLoaderM12408mjFkc);
                                            declaredField.set(null, classLoaderM12408mjFkc);
                                            f2271lgHUyS = bool2;
                                            return iM2396JHa;
                                        }
                                        return iM2396JHa;
                                    } catch (C0213mjFkc unused2) {
                                        declaredField.set(null, ClassLoader.getSystemClassLoader());
                                        bool = Boolean.FALSE;
                                    }
                                }
                            }
                        }
                        f2271lgHUyS = bool;
                    }
                }
                if (bool.booleanValue()) {
                    try {
                        return m2396JHa(context, str, z, false);
                    } catch (C0213mjFkc e3) {
                        Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e3.getMessage());
                        return 0;
                    }
                }
                C3232YS c3232ysM2395ETF = m2395ETF(context);
                if (c3232ysM2395ETF != null) {
                    try {
                        try {
                            int iM11128xJ = c3232ysM2395ETF.m11128xJ();
                            if (iM11128xJ >= 3) {
                                C3691fR c3691fR = (C3691fR) f2266MiMN.get();
                                if (c3691fR == null || (cursor = c3691fR.f13579mjFkc) == null) {
                                    Cursor cursor2 = (Cursor) BinderC2869T2.m10214xJ(c3232ysM2395ETF.m11125VocHEe(BinderC2869T2.m10213Ucbh(context), str, z, ((Long) f2268YoKzxo.get()).longValue()));
                                    if (cursor2 != null) {
                                        try {
                                            if (cursor2.moveToFirst()) {
                                                int i = cursor2.getInt(0);
                                                cursor = (i <= 0 || !m2401qdMbNW(cursor2)) ? cursor2 : null;
                                                if (cursor != null) {
                                                    cursor.close();
                                                }
                                                iM11124Ucbh = i;
                                            } else {
                                                Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                                if (cursor2 != null) {
                                                    cursor2.close();
                                                }
                                            }
                                        } catch (RemoteException e4) {
                                            e = e4;
                                            cursor = cursor2;
                                            Log.w("DynamiteModule", "Failed to retrieve remote module version: " + e.getMessage());
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            return iM11124Ucbh;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            cursor = cursor2;
                                            if (cursor != null) {
                                                cursor.close();
                                            }
                                            throw th;
                                        }
                                    } else {
                                        Log.w("DynamiteModule", "Failed to retrieve remote module version.");
                                        if (cursor2 != null) {
                                        }
                                    }
                                } else {
                                    iM11124Ucbh = cursor.getInt(0);
                                }
                            } else if (iM11128xJ == 2) {
                                Log.w("DynamiteModule", "IDynamite loader version = 2, no high precision latency measurement.");
                                iM11124Ucbh = c3232ysM2395ETF.m11126huTpC(BinderC2869T2.m10213Ucbh(context), str, z);
                            } else {
                                Log.w("DynamiteModule", "IDynamite loader version < 2, falling back to getModuleVersion2");
                                iM11124Ucbh = c3232ysM2395ETF.m11124Ucbh(BinderC2869T2.m10213Ucbh(context), str, z);
                            }
                        } catch (RemoteException e5) {
                            e = e5;
                        }
                    } catch (Throwable th3) {
                        th = th3;
                    }
                }
                return iM11124Ucbh;
            }
        } catch (Throwable th4) {
            AbstractC2693QP.m10005mjFkc(context, th4);
            throw th4;
        }
    }

    /* JADX WARN: Not initialized variable reg: 17, insn: 0x0226: MOVE (r6 I:??[OBJECT, ARRAY]) = (r17 I:??[OBJECT, ARRAY]), block:B:116:0x0226 */
    /* JADX WARN: Removed duplicated region for block: B:134:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x0284  */
    /* renamed from: ZfxDd */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static DynamiteModule m2398ZfxDd(Context context, InterfaceC0212AZxh interfaceC0212AZxh, String str) throws Throwable {
        C3691fR c3691fR;
        C3691fR c3691fR2;
        int i;
        DynamiteModule dynamiteModuleM2402xJ;
        InterfaceC1929F interfaceC1929FM11122Gd;
        DynamiteModule dynamiteModule;
        C1892ET c1892et;
        boolean z;
        InterfaceC1929F interfaceC1929FM8128xJ;
        Cursor cursor;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            throw new C0213mjFkc("null application Context", null);
        }
        ThreadLocal threadLocal = f2266MiMN;
        C3691fR c3691fR3 = (C3691fR) threadLocal.get();
        C3691fR c3691fR4 = new C3691fR(null);
        threadLocal.set(c3691fR4);
        ThreadLocal threadLocal2 = f2268YoKzxo;
        Long l = (Long) threadLocal2.get();
        long jLongValue = l.longValue();
        try {
            threadLocal2.set(Long.valueOf(SystemClock.elapsedRealtime()));
            InterfaceC0212AZxh.AZxh aZxhMo2392mjFkc = interfaceC0212AZxh.mo2392mjFkc(context, str, f2274rkYL);
            Log.i("DynamiteModule", "Considering local module " + str + ":" + aZxhMo2392mjFkc.f2279mjFkc + " and remote module " + str + ":" + aZxhMo2392mjFkc.f2278AZxh);
            int i2 = aZxhMo2392mjFkc.f2280wA;
            if (i2 != 0) {
                if (i2 == -1) {
                    if (aZxhMo2392mjFkc.f2279mjFkc != 0) {
                        i2 = -1;
                    }
                }
                if (i2 != 1 || aZxhMo2392mjFkc.f2278AZxh != 0) {
                    if (i2 == -1) {
                        dynamiteModuleM2402xJ = m2402xJ(applicationContext, str);
                        c3691fR2 = c3691fR3;
                    } else {
                        try {
                            if (i2 != 1) {
                                throw new C0213mjFkc("VersionPolicy returned invalid code:" + i2, null);
                            }
                            try {
                                try {
                                    int i3 = aZxhMo2392mjFkc.f2278AZxh;
                                    try {
                                        try {
                                            try {
                                                synchronized (DynamiteModule.class) {
                                                    try {
                                                        if (!m2394Dt(context)) {
                                                            throw new C0213mjFkc("Remote loading disabled", null);
                                                        }
                                                        Boolean bool = f2271lgHUyS;
                                                        if (bool == null) {
                                                            throw new C0213mjFkc("Failed to determine which loading route to use.", null);
                                                        }
                                                        if (bool.booleanValue()) {
                                                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i3);
                                                            synchronized (DynamiteModule.class) {
                                                                try {
                                                                    c1892et = f2263IEE;
                                                                } catch (Throwable th) {
                                                                    th = th;
                                                                    while (true) {
                                                                        try {
                                                                            throw th;
                                                                        } catch (Throwable th2) {
                                                                            th = th2;
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                            if (c1892et == null) {
                                                                throw new C0213mjFkc("DynamiteLoaderV2 was not cached.", null);
                                                            }
                                                            C3691fR c3691fR5 = (C3691fR) threadLocal.get();
                                                            if (c3691fR5 == null || c3691fR5.f13579mjFkc == null) {
                                                                throw new C0213mjFkc("No result cursor", null);
                                                            }
                                                            Context applicationContext2 = context.getApplicationContext();
                                                            Cursor cursor2 = c3691fR5.f13579mjFkc;
                                                            BinderC2869T2.m10213Ucbh(null);
                                                            synchronized (DynamiteModule.class) {
                                                                c3691fR2 = c3691fR3;
                                                                z = f2262ETF >= 2;
                                                            }
                                                            if (z) {
                                                                Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
                                                                interfaceC1929FM8128xJ = c1892et.m8127Ucbh(BinderC2869T2.m10213Ucbh(applicationContext2), str, i3, BinderC2869T2.m10213Ucbh(cursor2));
                                                            } else {
                                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
                                                                interfaceC1929FM8128xJ = c1892et.m8128xJ(BinderC2869T2.m10213Ucbh(applicationContext2), str, i3, BinderC2869T2.m10213Ucbh(cursor2));
                                                            }
                                                            Context context2 = (Context) BinderC2869T2.m10214xJ(interfaceC1929FM8128xJ);
                                                            if (context2 == null) {
                                                                throw new C0213mjFkc("Failed to get module context", null);
                                                            }
                                                            dynamiteModule = new DynamiteModule(context2);
                                                        } else {
                                                            c3691fR2 = c3691fR3;
                                                            Log.i("DynamiteModule", "Selected remote version of " + str + ", version >= " + i3);
                                                            C3232YS c3232ysM2395ETF = m2395ETF(context);
                                                            if (c3232ysM2395ETF == null) {
                                                                throw new C0213mjFkc("Failed to create IDynamiteLoader.", null);
                                                            }
                                                            int iM11128xJ = c3232ysM2395ETF.m11128xJ();
                                                            if (iM11128xJ >= 3) {
                                                                C3691fR c3691fR6 = (C3691fR) threadLocal.get();
                                                                if (c3691fR6 == null) {
                                                                    throw new C0213mjFkc("No cached result cursor holder", null);
                                                                }
                                                                interfaceC1929FM11122Gd = c3232ysM2395ETF.m11123HGpJ(BinderC2869T2.m10213Ucbh(context), str, i3, BinderC2869T2.m10213Ucbh(c3691fR6.f13579mjFkc));
                                                            } else if (iM11128xJ == 2) {
                                                                Log.w("DynamiteModule", "IDynamite loader version = 2");
                                                                interfaceC1929FM11122Gd = c3232ysM2395ETF.m11127vI(BinderC2869T2.m10213Ucbh(context), str, i3);
                                                            } else {
                                                                Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
                                                                interfaceC1929FM11122Gd = c3232ysM2395ETF.m11122Gd(BinderC2869T2.m10213Ucbh(context), str, i3);
                                                            }
                                                            Object objM10214xJ = BinderC2869T2.m10214xJ(interfaceC1929FM11122Gd);
                                                            if (objM10214xJ == null) {
                                                                throw new C0213mjFkc("Failed to load remote module.", null);
                                                            }
                                                            dynamiteModule = new DynamiteModule((Context) objM10214xJ);
                                                        }
                                                        dynamiteModuleM2402xJ = dynamiteModule;
                                                    } catch (Throwable th3) {
                                                        th = th3;
                                                        throw th;
                                                    }
                                                }
                                            } catch (Throwable th4) {
                                                th = th4;
                                            }
                                        } catch (RemoteException e) {
                                            e = e;
                                            throw new C0213mjFkc("Failed to load remote module.", e, null);
                                        } catch (C0213mjFkc e2) {
                                            throw e2;
                                        } catch (Throwable th5) {
                                            th = th5;
                                            AbstractC2693QP.m10005mjFkc(context, th);
                                            throw new C0213mjFkc("Failed to load remote module.", th, null);
                                        }
                                    } catch (RemoteException e3) {
                                        e = e3;
                                        throw new C0213mjFkc("Failed to load remote module.", e, null);
                                    } catch (C0213mjFkc e4) {
                                        throw e4;
                                    } catch (Throwable th6) {
                                        th = th6;
                                        AbstractC2693QP.m10005mjFkc(context, th);
                                        throw new C0213mjFkc("Failed to load remote module.", th, null);
                                    }
                                } catch (C0213mjFkc e5) {
                                    e = e5;
                                    Log.w("DynamiteModule", "Failed to load remote module: " + e.getMessage());
                                    i = aZxhMo2392mjFkc.f2279mjFkc;
                                    if (i != 0 || interfaceC0212AZxh.mo2392mjFkc(context, str, new C0219qdMbNW(i, 0)).f2280wA != -1) {
                                        throw new C0213mjFkc("Remote load failed. No local fallback found.", e, null);
                                    }
                                    dynamiteModuleM2402xJ = m2402xJ(applicationContext, str);
                                    if (jLongValue != 0) {
                                    }
                                    cursor = c3691fR4.f13579mjFkc;
                                    if (cursor != null) {
                                    }
                                    f2266MiMN.set(c3691fR2);
                                    return dynamiteModuleM2402xJ;
                                }
                            } catch (C0213mjFkc e6) {
                                e = e6;
                                c3691fR2 = c3691fR3;
                                Log.w("DynamiteModule", "Failed to load remote module: " + e.getMessage());
                                i = aZxhMo2392mjFkc.f2279mjFkc;
                                if (i != 0) {
                                }
                                throw new C0213mjFkc("Remote load failed. No local fallback found.", e, null);
                            } catch (Throwable th7) {
                                th = th7;
                                if (jLongValue == 0) {
                                    f2268YoKzxo.remove();
                                } else {
                                    f2268YoKzxo.set(l);
                                }
                                Cursor cursor3 = c3691fR4.f13579mjFkc;
                                if (cursor3 != null) {
                                    cursor3.close();
                                }
                                f2266MiMN.set(c3691fR3);
                                throw th;
                            }
                        } catch (Throwable th8) {
                            th = th8;
                            c3691fR3 = c3691fR;
                        }
                    }
                    if (jLongValue != 0) {
                        f2268YoKzxo.remove();
                    } else {
                        f2268YoKzxo.set(l);
                    }
                    cursor = c3691fR4.f13579mjFkc;
                    if (cursor != null) {
                        cursor.close();
                    }
                    f2266MiMN.set(c3691fR2);
                    return dynamiteModuleM2402xJ;
                }
            }
            throw new C0213mjFkc("No acceptable module " + str + " found. Local version is " + aZxhMo2392mjFkc.f2279mjFkc + " and remote version is " + aZxhMo2392mjFkc.f2278AZxh + ".", null);
        } catch (Throwable th9) {
            th = th9;
        }
    }

    /* renamed from: lgHUyS */
    public static void m2399lgHUyS(ClassLoader classLoader) throws C0213mjFkc {
        C1892ET c1892et;
        AbstractC4550sS abstractC4550sS = null;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(null).newInstance(null);
            if (iBinder == null) {
                c1892et = null;
            } else {
                IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                c1892et = iInterfaceQueryLocalInterface instanceof C1892ET ? (C1892ET) iInterfaceQueryLocalInterface : new C1892ET(iBinder);
            }
            f2263IEE = c1892et;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new C0213mjFkc("Failed to instantiate dynamite loader", e, abstractC4550sS);
        }
    }

    /* renamed from: mjFkc */
    public static int m2400mjFkc(Context context, String str) throws NoSuchFieldException, ClassNotFoundException {
        try {
            Class<?> clsLoadClass = context.getApplicationContext().getClassLoader().loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = clsLoadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = clsLoadClass.getDeclaredField("MODULE_VERSION");
            if (AbstractC2931U2.m10465mjFkc(declaredField.get(null), str)) {
                return declaredField2.getInt(null);
            }
            Log.e("DynamiteModule", "Module descriptor id '" + String.valueOf(declaredField.get(null)) + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    /* renamed from: qdMbNW */
    public static boolean m2401qdMbNW(Cursor cursor) {
        C3691fR c3691fR = (C3691fR) f2266MiMN.get();
        if (c3691fR == null || c3691fR.f13579mjFkc != null) {
            return false;
        }
        c3691fR.f13579mjFkc = cursor;
        return true;
    }

    /* renamed from: xJ */
    public static DynamiteModule m2402xJ(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    /* renamed from: wA */
    public IBinder m2403wA(String str) throws C0213mjFkc {
        try {
            return (IBinder) this.f2277mjFkc.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new C0213mjFkc("Failed to instantiate module class: ".concat(String.valueOf(str)), e, null);
        }
    }
}
