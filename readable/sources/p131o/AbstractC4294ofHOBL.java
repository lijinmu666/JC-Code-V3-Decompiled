package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import java.io.File;

/* renamed from: o.ofHOBL */
/* loaded from: classes.dex */
public abstract class AbstractC4294ofHOBL {

    /* renamed from: mjFkc */
    public static final Object f15787mjFkc = new Object();

    /* renamed from: o.ofHOBL$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public static <T> T m12998AZxh(Context context, Class<T> cls) {
            return (T) context.getSystemService(cls);
        }

        /* renamed from: mjFkc */
        public static int m12999mjFkc(Context context, int i) {
            return context.getColor(i);
        }

        /* renamed from: wA */
        public static String m13000wA(Context context, Class<?> cls) {
            return context.getSystemServiceName(cls);
        }
    }

    /* renamed from: o.ofHOBL$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static Drawable m13001AZxh(Context context, int i) {
            return context.getDrawable(i);
        }

        /* renamed from: mjFkc */
        public static File m13002mjFkc(Context context) {
            return context.getCodeCacheDir();
        }

        /* renamed from: wA */
        public static File m13003wA(Context context) {
            return context.getNoBackupFilesDir();
        }
    }

    /* renamed from: AZxh */
    public static ColorStateList m12995AZxh(Context context, int i) {
        return AbstractC4592t5.m13582ZfxDd(context.getResources(), i, context.getTheme());
    }

    /* renamed from: mjFkc */
    public static int m12996mjFkc(Context context, int i) {
        return AZxh.m12999mjFkc(context, i);
    }

    /* renamed from: wA */
    public static Drawable m12997wA(Context context, int i) {
        return mjFkc.m13001AZxh(context, i);
    }
}
