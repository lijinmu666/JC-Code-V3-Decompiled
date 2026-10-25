package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.p133asn1.p138cmp.PKIFailureInfo;
import p131o.C4257o5;

/* renamed from: androidx.profileinstaller.ZfxDd */
/* loaded from: classes.dex */
public abstract class AbstractC0119ZfxDd {

    /* renamed from: mjFkc */
    public static final C4257o5 f1431mjFkc = C4257o5.m12932rkYL();

    /* renamed from: AZxh */
    public static final Object f1430AZxh = new Object();

    /* renamed from: wA */
    public static wA f1432wA = null;

    /* renamed from: androidx.profileinstaller.ZfxDd$AZxh */
    public static class AZxh {

        /* renamed from: AZxh */
        public final int f1433AZxh;

        /* renamed from: ZfxDd */
        public final long f1434ZfxDd;

        /* renamed from: mjFkc */
        public final int f1435mjFkc;

        /* renamed from: wA */
        public final long f1436wA;

        public AZxh(int i, int i2, long j, long j2) {
            this.f1435mjFkc = i;
            this.f1433AZxh = i2;
            this.f1436wA = j;
            this.f1434ZfxDd = j2;
        }

        /* renamed from: mjFkc */
        public static AZxh m1146mjFkc(File file) throws IOException {
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                AZxh aZxh = new AZxh(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return aZxh;
            } catch (Throwable th) {
                try {
                    dataInputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        /* renamed from: AZxh */
        public void m1147AZxh(File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.f1435mjFkc);
                dataOutputStream.writeInt(this.f1433AZxh);
                dataOutputStream.writeLong(this.f1436wA);
                dataOutputStream.writeLong(this.f1434ZfxDd);
                dataOutputStream.close();
            } catch (Throwable th) {
                try {
                    dataOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }

        /* renamed from: equals */
        public boolean m1148equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || !(obj instanceof AZxh)) {
                return false;
            }
            AZxh aZxh = (AZxh) obj;
            return this.f1433AZxh == aZxh.f1433AZxh && this.f1436wA == aZxh.f1436wA && this.f1435mjFkc == aZxh.f1435mjFkc && this.f1434ZfxDd == aZxh.f1434ZfxDd;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.f1433AZxh), Long.valueOf(this.f1436wA), Integer.valueOf(this.f1435mjFkc), Long.valueOf(this.f1434ZfxDd));
        }
    }

    /* renamed from: androidx.profileinstaller.ZfxDd$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static PackageInfo m1149mjFkc(PackageManager packageManager, Context context) {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0L));
        }
    }

    /* renamed from: androidx.profileinstaller.ZfxDd$wA */
    public static class wA {

        /* renamed from: AZxh */
        public final boolean f1437AZxh;

        /* renamed from: mjFkc */
        public final int f1438mjFkc;

        /* renamed from: wA */
        public final boolean f1439wA;

        public wA(int i, boolean z, boolean z2) {
            this.f1438mjFkc = i;
            this.f1439wA = z2;
            this.f1437AZxh = z;
        }
    }

    /* renamed from: AZxh */
    public static wA m1143AZxh(int i, boolean z, boolean z2) {
        wA wAVar = new wA(i, z, z2);
        f1432wA = wAVar;
        f1431mjFkc.mo12933MiMN(wAVar);
        return f1432wA;
    }

    /* renamed from: mjFkc */
    public static long m1144mjFkc(Context context) {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        return Build.VERSION.SDK_INT >= 33 ? mjFkc.m1149mjFkc(packageManager, context).lastUpdateTime : packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    /* renamed from: wA */
    public static wA m1145wA(Context context, boolean z) {
        AZxh aZxhM1146mjFkc;
        int i;
        wA wAVar;
        if (!z && (wAVar = f1432wA) != null) {
            return wAVar;
        }
        synchronized (f1430AZxh) {
            if (!z) {
                try {
                    wA wAVar2 = f1432wA;
                    if (wAVar2 != null) {
                        return wAVar2;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            int i2 = 0;
            if (Build.VERSION.SDK_INT == 30) {
                return m1143AZxh(PKIFailureInfo.transactionIdInUse, false, false);
            }
            File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
            long length = file.length();
            boolean z2 = file.exists() && length > 0;
            File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
            long length2 = file2.length();
            boolean z3 = file2.exists() && length2 > 0;
            try {
                long jM1144mjFkc = m1144mjFkc(context);
                File file3 = new File(context.getFilesDir(), "profileInstalled");
                if (file3.exists()) {
                    try {
                        aZxhM1146mjFkc = AZxh.m1146mjFkc(file3);
                    } catch (IOException unused) {
                        return m1143AZxh(PKIFailureInfo.unsupportedVersion, z2, z3);
                    }
                } else {
                    aZxhM1146mjFkc = null;
                }
                if (aZxhM1146mjFkc != null && aZxhM1146mjFkc.f1436wA == jM1144mjFkc && (i = aZxhM1146mjFkc.f1433AZxh) != 2) {
                    i2 = i;
                } else if (z2) {
                    i2 = 1;
                } else if (z3) {
                    i2 = 2;
                }
                if (z && z3 && i2 != 1) {
                    i2 = 2;
                }
                if (aZxhM1146mjFkc != null && aZxhM1146mjFkc.f1433AZxh == 2 && i2 == 1 && length < aZxhM1146mjFkc.f1434ZfxDd) {
                    i2 = 3;
                }
                AZxh aZxh = new AZxh(1, i2, jM1144mjFkc, length2);
                if (aZxhM1146mjFkc == null || !aZxhM1146mjFkc.m1148equals(aZxh)) {
                    try {
                        aZxh.m1147AZxh(file3);
                    } catch (IOException unused2) {
                        i2 = 196608;
                    }
                }
                return m1143AZxh(i2, z2, z3);
            } catch (PackageManager.NameNotFoundException unused3) {
                return m1143AZxh(PKIFailureInfo.notAuthorized, z2, z3);
            }
        }
    }
}
