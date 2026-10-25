package androidx.profileinstaller;

import android.content.Context;
import androidx.profileinstaller.ProfileInstallReceiver;
import java.io.File;

/* renamed from: androidx.profileinstaller.mjFkc */
/* loaded from: classes.dex */
public abstract class AbstractC0120mjFkc {

    /* renamed from: androidx.profileinstaller.mjFkc$mjFkc */
    public static class mjFkc {
        /* renamed from: mjFkc */
        public static File m1152mjFkc(Context context) {
            return context.createDeviceProtectedStorageContext().getCodeCacheDir();
        }
    }

    /* renamed from: AZxh */
    public static void m1150AZxh(Context context, ProfileInstallReceiver.C0115mjFkc c0115mjFkc) {
        if (m1151mjFkc(mjFkc.m1152mjFkc(context))) {
            c0115mjFkc.mo1127AZxh(14, null);
        } else {
            c0115mjFkc.mo1127AZxh(15, null);
        }
    }

    /* renamed from: mjFkc */
    public static boolean m1151mjFkc(File file) {
        if (!file.isDirectory()) {
            file.delete();
            return true;
        }
        File[] fileArrListFiles = file.listFiles();
        if (fileArrListFiles == null) {
            return false;
        }
        boolean z = true;
        for (File file2 : fileArrListFiles) {
            z = m1151mjFkc(file2) && z;
        }
        return z;
    }
}
