package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import org.conscrypt.BuildConfig;
import p131o.ExecutorC2671Q3;

/* renamed from: androidx.profileinstaller.wA */
/* loaded from: classes.dex */
public abstract class AbstractC0121wA {

    /* renamed from: mjFkc */
    public static final wA f1441mjFkc = new mjFkc();

    /* renamed from: AZxh */
    public static final wA f1440AZxh = new AZxh();

    /* renamed from: androidx.profileinstaller.wA$AZxh */
    public class AZxh implements wA {
        @Override // androidx.profileinstaller.AbstractC0121wA.wA
        /* renamed from: AZxh */
        public void mo1127AZxh(int i, Object obj) {
            String str;
            switch (i) {
                case 1:
                    str = "RESULT_INSTALL_SUCCESS";
                    break;
                case 2:
                    str = "RESULT_ALREADY_INSTALLED";
                    break;
                case 3:
                    str = "RESULT_UNSUPPORTED_ART_VERSION";
                    break;
                case 4:
                    str = "RESULT_NOT_WRITABLE";
                    break;
                case 5:
                    str = "RESULT_DESIRED_FORMAT_UNSUPPORTED";
                    break;
                case 6:
                    str = "RESULT_BASELINE_PROFILE_NOT_FOUND";
                    break;
                case 7:
                    str = "RESULT_IO_EXCEPTION";
                    break;
                case 8:
                    str = "RESULT_PARSE_EXCEPTION";
                    break;
                case 9:
                default:
                    str = BuildConfig.f24315FLAVOR;
                    break;
                case 10:
                    str = "RESULT_INSTALL_SKIP_FILE_SUCCESS";
                    break;
                case 11:
                    str = "RESULT_DELETE_SKIP_FILE_SUCCESS";
                    break;
            }
            if (i == 6 || i == 7 || i == 8) {
                Log.e("ProfileInstaller", str, (Throwable) obj);
            } else {
                Log.d("ProfileInstaller", str);
            }
        }

        @Override // androidx.profileinstaller.AbstractC0121wA.wA
        /* renamed from: mjFkc */
        public void mo1128mjFkc(int i, Object obj) {
            Log.d("ProfileInstaller", i != 1 ? i != 2 ? i != 3 ? i != 4 ? i != 5 ? BuildConfig.f24315FLAVOR : "DIAGNOSTIC_PROFILE_IS_COMPRESSED" : "DIAGNOSTIC_REF_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_REF_PROFILE_EXISTS" : "DIAGNOSTIC_CURRENT_PROFILE_DOES_NOT_EXIST" : "DIAGNOSTIC_CURRENT_PROFILE_EXISTS");
        }
    }

    /* renamed from: androidx.profileinstaller.wA$mjFkc */
    public class mjFkc implements wA {
        @Override // androidx.profileinstaller.AbstractC0121wA.wA
        /* renamed from: AZxh */
        public void mo1127AZxh(int i, Object obj) {
        }

        @Override // androidx.profileinstaller.AbstractC0121wA.wA
        /* renamed from: mjFkc */
        public void mo1128mjFkc(int i, Object obj) {
        }
    }

    /* renamed from: androidx.profileinstaller.wA$wA */
    public interface wA {
        /* renamed from: AZxh */
        void mo1127AZxh(int i, Object obj);

        /* renamed from: mjFkc */
        void mo1128mjFkc(int i, Object obj);
    }

    /* renamed from: AZxh */
    public static boolean m1153AZxh(File file) {
        return new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat").delete();
    }

    /* renamed from: Dt */
    public static void m1154Dt(Context context, Executor executor, wA wAVar) throws PackageManager.NameNotFoundException {
        m1155ETF(context, executor, wAVar, false);
    }

    /* renamed from: ETF */
    public static void m1155ETF(Context context, Executor executor, wA wAVar, boolean z) throws PackageManager.NameNotFoundException {
        Context applicationContext = context.getApplicationContext();
        String packageName = applicationContext.getPackageName();
        ApplicationInfo applicationInfo = applicationContext.getApplicationInfo();
        AssetManager assets = applicationContext.getAssets();
        String name = new File(applicationInfo.sourceDir).getName();
        boolean z2 = false;
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            File filesDir = context.getFilesDir();
            if (!z && m1159ZfxDd(packageInfo, filesDir, wAVar)) {
                Log.d("ProfileInstaller", "Skipping profile installation for " + context.getPackageName());
                AbstractC0119ZfxDd.m1145wA(context, false);
                return;
            }
            Log.d("ProfileInstaller", "Installing profile for " + context.getPackageName());
            if (m1160lgHUyS(assets, packageName, packageInfo, filesDir, name, executor, wAVar) && z) {
                z2 = true;
            }
            AbstractC0119ZfxDd.m1145wA(context, z2);
        } catch (PackageManager.NameNotFoundException e) {
            wAVar.mo1127AZxh(7, e);
            AbstractC0119ZfxDd.m1145wA(context, false);
        }
    }

    /* renamed from: JHa */
    public static void m1156JHa(PackageInfo packageInfo, File file) throws IOException {
        try {
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat")));
            try {
                dataOutputStream.writeLong(packageInfo.lastUpdateTime);
                dataOutputStream.close();
            } finally {
            }
        } catch (IOException unused) {
        }
    }

    /* renamed from: VA */
    public static void m1158VA(Context context, Executor executor, wA wAVar) throws PackageManager.NameNotFoundException, IOException {
        try {
            m1156JHa(context.getPackageManager().getPackageInfo(context.getApplicationContext().getPackageName(), 0), context.getFilesDir());
            m1164xJ(executor, wAVar, 10, null);
        } catch (PackageManager.NameNotFoundException e) {
            m1164xJ(executor, wAVar, 7, e);
        }
    }

    /* renamed from: ZfxDd */
    public static boolean m1159ZfxDd(PackageInfo packageInfo, File file, wA wAVar) throws IOException {
        File file2 = new File(file, "profileinstaller_profileWrittenFor_lastUpdateTime.dat");
        if (!file2.exists()) {
            return false;
        }
        try {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file2));
            try {
                long j = dataInputStream.readLong();
                dataInputStream.close();
                boolean z = j == packageInfo.lastUpdateTime;
                if (z) {
                    wAVar.mo1127AZxh(2, null);
                }
                return z;
            } finally {
            }
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: lgHUyS */
    public static boolean m1160lgHUyS(AssetManager assetManager, String str, PackageInfo packageInfo, File file, String str2, Executor executor, wA wAVar) throws IOException {
        C0114AZxh c0114AZxh = new C0114AZxh(assetManager, executor, wAVar, str2, "dexopt/baseline.prof", "dexopt/baseline.profm", new File(new File("/data/misc/profiles/cur/0", str), "primary.prof"));
        if (!c0114AZxh.m1118KLFTb()) {
            return false;
        }
        boolean zM1121YoKzxo = c0114AZxh.m1123qdMbNW().m1119MiMN().m1121YoKzxo();
        if (zM1121YoKzxo) {
            m1156JHa(packageInfo, file);
        }
        return zM1121YoKzxo;
    }

    /* renamed from: qdMbNW */
    public static void m1162qdMbNW(Context context) throws PackageManager.NameNotFoundException {
        m1154Dt(context, new ExecutorC2671Q3(), f1441mjFkc);
    }

    /* renamed from: wA */
    public static void m1163wA(Context context, Executor executor, wA wAVar) {
        m1153AZxh(context.getFilesDir());
        m1164xJ(executor, wAVar, 11, null);
    }

    /* renamed from: xJ */
    public static void m1164xJ(Executor executor, final wA wAVar, final int i, final Object obj) {
        executor.execute(new Runnable() { // from class: o.R3
            @Override // java.lang.Runnable
            public final void run() {
                wAVar.mo1127AZxh(i, obj);
            }
        });
    }
}
