package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.util.SparseArray;
import android.util.TypedValue;
import java.io.IOException;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;
import p131o.AbstractC2165IRE;

/* renamed from: o.t5 */
/* loaded from: classes.dex */
public abstract class AbstractC4592t5 {

    /* renamed from: mjFkc */
    public static final ThreadLocal f16648mjFkc = new ThreadLocal();

    /* renamed from: AZxh */
    public static final WeakHashMap f16647AZxh = new WeakHashMap(0);

    /* renamed from: wA */
    public static final Object f16649wA = new Object();

    /* renamed from: o.t5$AZxh */
    public static class AZxh {
        /* renamed from: AZxh */
        public static ColorStateList m13588AZxh(Resources resources, int i, Resources.Theme theme) {
            return resources.getColorStateList(i, theme);
        }

        /* renamed from: mjFkc */
        public static int m13589mjFkc(Resources resources, int i, Resources.Theme theme) {
            return resources.getColor(i, theme);
        }
    }

    /* renamed from: o.t5$KLFTb */
    public static abstract class KLFTb {
        /* renamed from: KLFTb */
        public static Handler m13591KLFTb(Handler handler) {
            return handler == null ? new Handler(Looper.getMainLooper()) : handler;
        }

        /* renamed from: ZfxDd */
        public final void m13594ZfxDd(final Typeface typeface, Handler handler) {
            m13591KLFTb(handler).post(new Runnable() { // from class: o.u5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16799mjFkc.m13596xJ(typeface);
                }
            });
        }

        /* renamed from: lgHUyS, reason: merged with bridge method [inline-methods] */
        public abstract void m13593JHa(int i);

        /* renamed from: qdMbNW, reason: merged with bridge method [inline-methods] */
        public abstract void m13596xJ(Typeface typeface);

        /* renamed from: wA */
        public final void m13595wA(final int i, Handler handler) {
            m13591KLFTb(handler).post(new Runnable() { // from class: o.v5
                @Override // java.lang.Runnable
                public final void run() {
                    this.f16944mjFkc.m13593JHa(i);
                }
            });
        }
    }

    /* renamed from: o.t5$ZfxDd */
    public static final class ZfxDd {

        /* renamed from: AZxh */
        public final Resources.Theme f16650AZxh;

        /* renamed from: mjFkc */
        public final Resources f16651mjFkc;

        public ZfxDd(Resources resources, Resources.Theme theme) {
            this.f16651mjFkc = resources;
            this.f16650AZxh = theme;
        }

        /* renamed from: equals */
        public boolean m13597equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || ZfxDd.class != obj.getClass()) {
                return false;
            }
            ZfxDd zfxDd = (ZfxDd) obj;
            return this.f16651mjFkc.equals(zfxDd.f16651mjFkc) && AbstractC3003V2.m10659mjFkc(this.f16650AZxh, zfxDd.f16650AZxh);
        }

        public int hashCode() {
            return AbstractC3003V2.m10657AZxh(this.f16651mjFkc, this.f16650AZxh);
        }
    }

    /* renamed from: o.t5$mjFkc */
    public static class mjFkc {
        /* renamed from: AZxh */
        public static Drawable m13598AZxh(Resources resources, int i, int i2, Resources.Theme theme) {
            return resources.getDrawableForDensity(i, i2, theme);
        }

        /* renamed from: mjFkc */
        public static Drawable m13599mjFkc(Resources resources, int i, Resources.Theme theme) {
            return resources.getDrawable(i, theme);
        }
    }

    /* renamed from: o.t5$wA */
    public static class wA {

        /* renamed from: AZxh */
        public final Configuration f16652AZxh;

        /* renamed from: mjFkc */
        public final ColorStateList f16653mjFkc;

        /* renamed from: wA */
        public final int f16654wA;

        public wA(ColorStateList colorStateList, Configuration configuration, Resources.Theme theme) {
            this.f16653mjFkc = colorStateList;
            this.f16652AZxh = configuration;
            this.f16654wA = theme == null ? 0 : theme.hashCode();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x003c, code lost:
    
        if (r2.f16654wA == r5.hashCode()) goto L22;
     */
    /* renamed from: AZxh */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static ColorStateList m13574AZxh(ZfxDd zfxDd, int i) {
        wA wAVar;
        synchronized (f16649wA) {
            try {
                SparseArray sparseArray = (SparseArray) f16647AZxh.get(zfxDd);
                if (sparseArray != null && sparseArray.size() > 0 && (wAVar = (wA) sparseArray.get(i)) != null) {
                    if (wAVar.f16652AZxh.equals(zfxDd.f16651mjFkc.getConfiguration())) {
                        Resources.Theme theme = zfxDd.f16650AZxh;
                        if (theme != null || wAVar.f16654wA != 0) {
                            if (theme != null) {
                            }
                        }
                        return wAVar.f16653mjFkc;
                    }
                    sparseArray.remove(i);
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: Dt */
    public static TypedValue m13575Dt() {
        ThreadLocal threadLocal = f16648mjFkc;
        TypedValue typedValue = (TypedValue) threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    /* renamed from: ETF */
    public static ColorStateList m13576ETF(Resources resources, int i, Resources.Theme theme) {
        if (m13580VA(resources, i)) {
            return null;
        }
        try {
            return AbstractC2790Rsp.m10105mjFkc(resources, resources.getXml(i), theme);
        } catch (Exception e) {
            Log.w("ResourcesCompat", "Failed to inflate ColorStateList, leaving it to the framework", e);
            return null;
        }
    }

    /* renamed from: JHa */
    public static Drawable m13577JHa(Resources resources, int i, int i2, Resources.Theme theme) {
        return mjFkc.m13598AZxh(resources, i, i2, theme);
    }

    /* renamed from: KLFTb */
    public static Drawable m13578KLFTb(Resources resources, int i, Resources.Theme theme) {
        return mjFkc.m13599mjFkc(resources, i, theme);
    }

    /* renamed from: MiMN */
    public static Typeface m13579MiMN(Context context, int i, TypedValue typedValue, int i2, KLFTb kLFTb, Handler handler, boolean z, boolean z2) throws Resources.NotFoundException {
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        Typeface typefaceM13581YoKzxo = m13581YoKzxo(context, resources, typedValue, i, i2, kLFTb, handler, z, z2);
        if (typefaceM13581YoKzxo != null || kLFTb != null || z2) {
            return typefaceM13581YoKzxo;
        }
        throw new Resources.NotFoundException("Font resource ID #0x" + Integer.toHexString(i) + " could not be retrieved.");
    }

    /* renamed from: VA */
    public static boolean m13580VA(Resources resources, int i) throws Resources.NotFoundException {
        TypedValue typedValueM13575Dt = m13575Dt();
        resources.getValue(i, typedValueM13575Dt, true);
        int i2 = typedValueM13575Dt.type;
        return i2 >= 28 && i2 <= 31;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
    /* renamed from: YoKzxo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Typeface m13581YoKzxo(Context context, Resources resources, TypedValue typedValue, int i, int i2, KLFTb kLFTb, Handler handler, boolean z, boolean z2) {
        CharSequence charSequence = typedValue.string;
        if (charSequence == null) {
            throw new Resources.NotFoundException("Resource \"" + resources.getResourceName(i) + "\" (" + Integer.toHexString(i) + ") is not a Font: " + typedValue);
        }
        String string = charSequence.toString();
        int i3 = 0;
        if (!string.startsWith("res/")) {
            if (kLFTb != null) {
                kLFTb.m13595wA(-3, handler);
            }
            return null;
        }
        Typeface typefaceM12756JHa = AbstractC4130m9.m12756JHa(resources, i, string, typedValue.assetCookie, i2);
        if (typefaceM12756JHa != null) {
            if (kLFTb != null) {
                kLFTb.m13594ZfxDd(typefaceM12756JHa, handler);
            }
            return typefaceM12756JHa;
        }
        if (z2) {
            return null;
        }
        try {
        } catch (IOException e) {
            e = e;
            i3 = -3;
        } catch (XmlPullParserException e2) {
            e = e2;
            i3 = -3;
        }
        try {
            if (!string.toLowerCase().endsWith(".xml")) {
                Typeface typefaceM12758ZfxDd = AbstractC4130m9.m12758ZfxDd(context, resources, i, string, typedValue.assetCookie, i2);
                if (kLFTb != null) {
                    if (typefaceM12758ZfxDd != null) {
                        kLFTb.m13594ZfxDd(typefaceM12758ZfxDd, handler);
                    } else {
                        kLFTb.m13595wA(-3, handler);
                    }
                }
                return typefaceM12758ZfxDd;
            }
            AbstractC2165IRE.AZxh aZxhM8728AZxh = AbstractC2165IRE.m8728AZxh(resources.getXml(i), resources);
            if (aZxhM8728AZxh != null) {
                return AbstractC4130m9.m12760wA(context, aZxhM8728AZxh, resources, i, string, typedValue.assetCookie, i2, kLFTb, handler, z);
            }
            Log.e("ResourcesCompat", "Failed to find font-family tag");
            if (kLFTb != null) {
                kLFTb.m13595wA(-3, handler);
            }
            return null;
        } catch (IOException e3) {
            e = e3;
            Log.e("ResourcesCompat", "Failed to read xml resource " + string, e);
            if (kLFTb != null) {
                return null;
            }
            kLFTb.m13595wA(i3, handler);
            return null;
        } catch (XmlPullParserException e4) {
            e = e4;
            Log.e("ResourcesCompat", "Failed to parse xml resource " + string, e);
            if (kLFTb != null) {
            }
        }
    }

    /* renamed from: ZfxDd */
    public static ColorStateList m13582ZfxDd(Resources resources, int i, Resources.Theme theme) {
        ZfxDd zfxDd = new ZfxDd(resources, theme);
        ColorStateList colorStateListM13574AZxh = m13574AZxh(zfxDd, i);
        if (colorStateListM13574AZxh != null) {
            return colorStateListM13574AZxh;
        }
        ColorStateList colorStateListM13576ETF = m13576ETF(resources, i, theme);
        if (colorStateListM13576ETF == null) {
            return AZxh.m13588AZxh(resources, i, theme);
        }
        m13584mjFkc(zfxDd, i, colorStateListM13576ETF, theme);
        return colorStateListM13576ETF;
    }

    /* renamed from: lgHUyS */
    public static Typeface m13583lgHUyS(Context context, int i, TypedValue typedValue, int i2, KLFTb kLFTb) {
        if (context.isRestricted()) {
            return null;
        }
        return m13579MiMN(context, i, typedValue, i2, kLFTb, null, true, false);
    }

    /* renamed from: mjFkc */
    public static void m13584mjFkc(ZfxDd zfxDd, int i, ColorStateList colorStateList, Resources.Theme theme) {
        synchronized (f16649wA) {
            try {
                WeakHashMap weakHashMap = f16647AZxh;
                SparseArray sparseArray = (SparseArray) weakHashMap.get(zfxDd);
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    weakHashMap.put(zfxDd, sparseArray);
                }
                sparseArray.append(i, new wA(colorStateList, zfxDd.f16651mjFkc.getConfiguration(), theme));
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: qdMbNW */
    public static void m13585qdMbNW(Context context, int i, KLFTb kLFTb, Handler handler) throws Resources.NotFoundException {
        AbstractC2280K3.m9126xJ(kLFTb);
        if (context.isRestricted()) {
            kLFTb.m13595wA(-4, handler);
        } else {
            m13579MiMN(context, i, new TypedValue(), 0, kLFTb, handler, false, false);
        }
    }

    /* renamed from: wA */
    public static Typeface m13586wA(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return m13579MiMN(context, i, new TypedValue(), 0, null, null, false, true);
    }

    /* renamed from: xJ */
    public static Typeface m13587xJ(Context context, int i) {
        if (context.isRestricted()) {
            return null;
        }
        return m13579MiMN(context, i, new TypedValue(), 0, null, null, false, false);
    }
}
