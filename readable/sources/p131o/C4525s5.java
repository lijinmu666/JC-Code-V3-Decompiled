package p131o;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.util.Xml;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: o.s5 */
/* loaded from: classes.dex */
public final class C4525s5 {

    /* renamed from: qdMbNW */
    public static C4525s5 f16453qdMbNW;

    /* renamed from: AZxh */
    public C3074W6 f16454AZxh;

    /* renamed from: JHa */
    public boolean f16455JHa;

    /* renamed from: KLFTb */
    public TypedValue f16456KLFTb;

    /* renamed from: ZfxDd */
    public final WeakHashMap f16457ZfxDd = new WeakHashMap(0);

    /* renamed from: mjFkc */
    public WeakHashMap f16458mjFkc;

    /* renamed from: wA */
    public C3605e7 f16459wA;

    /* renamed from: xJ */
    public wA f16460xJ;

    /* renamed from: lgHUyS */
    public static final PorterDuff.Mode f16452lgHUyS = PorterDuff.Mode.SRC_IN;

    /* renamed from: Dt */
    public static final mjFkc f16451Dt = new mjFkc(6);

    /* renamed from: o.s5$AZxh */
    public interface AZxh {
        /* renamed from: mjFkc */
        Drawable m13478mjFkc(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* renamed from: o.s5$mjFkc */
    public static class mjFkc extends C4386q1 {
        public mjFkc(int i) {
            super(i);
        }

        /* renamed from: lgHUyS */
        public static int m13479lgHUyS(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* renamed from: Dt */
        public PorterDuffColorFilter m13480Dt(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) m13164ZfxDd(Integer.valueOf(m13479lgHUyS(i, mode)), porterDuffColorFilter);
        }

        /* renamed from: qdMbNW */
        public PorterDuffColorFilter m13481qdMbNW(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) m13166wA(Integer.valueOf(m13479lgHUyS(i, mode)));
        }
    }

    /* renamed from: o.s5$wA */
    public interface wA {
        /* renamed from: AZxh */
        Drawable mo11539AZxh(C4525s5 c4525s5, Context context, int i);

        /* renamed from: KLFTb */
        boolean mo11543KLFTb(Context context, int i, Drawable drawable);

        /* renamed from: ZfxDd */
        ColorStateList mo11546ZfxDd(Context context, int i);

        /* renamed from: mjFkc */
        boolean mo11548mjFkc(Context context, int i, Drawable drawable);

        /* renamed from: wA */
        PorterDuff.Mode mo11550wA(int i);
    }

    /* renamed from: ETF */
    public static synchronized PorterDuffColorFilter m13456ETF(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter porterDuffColorFilterM13481qdMbNW;
        mjFkc mjfkc = f16451Dt;
        porterDuffColorFilterM13481qdMbNW = mjfkc.m13481qdMbNW(i, mode);
        if (porterDuffColorFilterM13481qdMbNW == null) {
            porterDuffColorFilterM13481qdMbNW = new PorterDuffColorFilter(i, mode);
            mjfkc.m13480Dt(i, mode, porterDuffColorFilterM13481qdMbNW);
        }
        return porterDuffColorFilterM13481qdMbNW;
    }

    /* renamed from: JHa */
    public static PorterDuffColorFilter m13457JHa(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m13456ETF(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: ZfxDd */
    public static long m13458ZfxDd(TypedValue typedValue) {
        return (typedValue.assetCookie << 32) | typedValue.data;
    }

    /* renamed from: eyqo */
    public static void m13459eyqo(Drawable drawable, C4929y8 c4929y8, int[] iArr) {
        int[] state = drawable.getState();
        if (AbstractC3397awnh.m11434mjFkc(drawable) && drawable.mutate() != drawable) {
            Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
            return;
        }
        if ((drawable instanceof LayerDrawable) && drawable.isStateful()) {
            drawable.setState(new int[0]);
            drawable.setState(state);
        }
        boolean z = c4929y8.f17479ZfxDd;
        if (z || c4929y8.f17481wA) {
            drawable.setColorFilter(m13457JHa(z ? c4929y8.f17480mjFkc : null, c4929y8.f17481wA ? c4929y8.f17478AZxh : f16452lgHUyS, iArr));
        } else {
            drawable.clearColorFilter();
        }
    }

    /* renamed from: qGY */
    public static boolean m13460qGY(Drawable drawable) {
        return (drawable instanceof AbstractC2286K9) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* renamed from: rkYL */
    public static void m13461rkYL(C4525s5 c4525s5) {
    }

    /* renamed from: xJ */
    public static synchronized C4525s5 m13462xJ() {
        try {
            if (f16453qdMbNW == null) {
                C4525s5 c4525s5 = new C4525s5();
                f16453qdMbNW = c4525s5;
                m13461rkYL(c4525s5);
            }
        } catch (Throwable th) {
            throw th;
        }
        return f16453qdMbNW;
    }

    /* renamed from: AZxh */
    public final void m13463AZxh(Context context, int i, ColorStateList colorStateList) {
        if (this.f16458mjFkc == null) {
            this.f16458mjFkc = new WeakHashMap();
        }
        C3605e7 c3605e7 = (C3605e7) this.f16458mjFkc.get(context);
        if (c3605e7 == null) {
            c3605e7 = new C3605e7();
            this.f16458mjFkc.put(context, c3605e7);
        }
        c3605e7.m11813mjFkc(i, colorStateList);
    }

    /* renamed from: Dt */
    public synchronized Drawable m13464Dt(Context context, int i, boolean z) {
        Drawable drawableM13473fehf;
        try {
            m13477wA(context);
            drawableM13473fehf = m13473fehf(context, i);
            if (drawableM13473fehf == null) {
                drawableM13473fehf = m13466KLFTb(context, i);
            }
            if (drawableM13473fehf == null) {
                drawableM13473fehf = AbstractC4294ofHOBL.m12997wA(context, i);
            }
            if (drawableM13473fehf != null) {
                drawableM13473fehf = m13472diqgf(context, i, z, drawableM13473fehf);
            }
            if (drawableM13473fehf != null) {
                AbstractC3397awnh.m11432AZxh(drawableM13473fehf);
            }
        } catch (Throwable th) {
            throw th;
        }
        return drawableM13473fehf;
    }

    /* renamed from: IEE */
    public synchronized Drawable m13465IEE(Context context, C2353L9 c2353l9, int i) {
        try {
            Drawable drawableM13473fehf = m13473fehf(context, i);
            if (drawableM13473fehf == null) {
                drawableM13473fehf = c2353l9.m13817mjFkc(i);
            }
            if (drawableM13473fehf == null) {
                return null;
            }
            return m13472diqgf(context, i, false, drawableM13473fehf);
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: KLFTb */
    public final Drawable m13466KLFTb(Context context, int i) throws Resources.NotFoundException {
        if (this.f16456KLFTb == null) {
            this.f16456KLFTb = new TypedValue();
        }
        TypedValue typedValue = this.f16456KLFTb;
        context.getResources().getValue(i, typedValue, true);
        long jM13458ZfxDd = m13458ZfxDd(typedValue);
        Drawable drawableM13474lgHUyS = m13474lgHUyS(context, jM13458ZfxDd);
        if (drawableM13474lgHUyS != null) {
            return drawableM13474lgHUyS;
        }
        wA wAVar = this.f16460xJ;
        Drawable drawableMo11539AZxh = wAVar == null ? null : wAVar.mo11539AZxh(this, context, i);
        if (drawableMo11539AZxh != null) {
            drawableMo11539AZxh.setChangingConfigurations(typedValue.changingConfigurations);
            m13475mjFkc(context, jM13458ZfxDd, drawableMo11539AZxh);
        }
        return drawableMo11539AZxh;
    }

    /* renamed from: MiMN */
    public final ColorStateList m13467MiMN(Context context, int i) {
        C3605e7 c3605e7;
        WeakHashMap weakHashMap = this.f16458mjFkc;
        if (weakHashMap == null || (c3605e7 = (C3605e7) weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) c3605e7.m11807JHa(i);
    }

    /* renamed from: Pq */
    public synchronized void m13468Pq(wA wAVar) {
        this.f16460xJ = wAVar;
    }

    /* renamed from: Ucbh */
    public boolean m13469Ucbh(Context context, int i, Drawable drawable) {
        wA wAVar = this.f16460xJ;
        return wAVar != null && wAVar.mo11548mjFkc(context, i, drawable);
    }

    /* renamed from: VA */
    public synchronized ColorStateList m13470VA(Context context, int i) {
        ColorStateList colorStateListM13467MiMN;
        colorStateListM13467MiMN = m13467MiMN(context, i);
        if (colorStateListM13467MiMN == null) {
            wA wAVar = this.f16460xJ;
            colorStateListM13467MiMN = wAVar == null ? null : wAVar.mo11546ZfxDd(context, i);
            if (colorStateListM13467MiMN != null) {
                m13463AZxh(context, i, colorStateListM13467MiMN);
            }
        }
        return colorStateListM13467MiMN;
    }

    /* renamed from: YoKzxo */
    public PorterDuff.Mode m13471YoKzxo(int i) {
        wA wAVar = this.f16460xJ;
        if (wAVar == null) {
            return null;
        }
        return wAVar.mo11550wA(i);
    }

    /* renamed from: diqgf */
    public final Drawable m13472diqgf(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList colorStateListM13470VA = m13470VA(context, i);
        if (colorStateListM13470VA == null) {
            wA wAVar = this.f16460xJ;
            if ((wAVar == null || !wAVar.mo11543KLFTb(context, i, drawable)) && !m13469Ucbh(context, i, drawable) && z) {
                return null;
            }
            return drawable;
        }
        if (AbstractC3397awnh.m11434mjFkc(drawable)) {
            drawable = drawable.mutate();
        }
        Drawable drawableM13077VA = AbstractC4332pCk.m13077VA(drawable);
        AbstractC4332pCk.m13081qdMbNW(drawableM13077VA, colorStateListM13470VA);
        PorterDuff.Mode modeM13471YoKzxo = m13471YoKzxo(i);
        if (modeM13471YoKzxo == null) {
            return drawableM13077VA;
        }
        AbstractC4332pCk.m13073Dt(drawableM13077VA, modeM13471YoKzxo);
        return drawableM13077VA;
    }

    /* renamed from: fehf */
    public final Drawable m13473fehf(Context context, int i) throws XmlPullParserException, Resources.NotFoundException, IOException {
        int next;
        C3074W6 c3074w6 = this.f16454AZxh;
        if (c3074w6 == null || c3074w6.m10818isEmpty()) {
            return null;
        }
        C3605e7 c3605e7 = this.f16459wA;
        if (c3605e7 != null) {
            String str = (String) c3605e7.m11807JHa(i);
            if ("appcompat_skip_skip".equals(str) || (str != null && this.f16454AZxh.m10817get(str) == null)) {
                return null;
            }
        } else {
            this.f16459wA = new C3605e7();
        }
        if (this.f16456KLFTb == null) {
            this.f16456KLFTb = new TypedValue();
        }
        TypedValue typedValue = this.f16456KLFTb;
        Resources resources = context.getResources();
        resources.getValue(i, typedValue, true);
        long jM13458ZfxDd = m13458ZfxDd(typedValue);
        Drawable drawableM13474lgHUyS = m13474lgHUyS(context, jM13458ZfxDd);
        if (drawableM13474lgHUyS != null) {
            return drawableM13474lgHUyS;
        }
        CharSequence charSequence = typedValue.string;
        if (charSequence != null && charSequence.toString().endsWith(".xml")) {
            try {
                XmlResourceParser xml = resources.getXml(i);
                AttributeSet attributeSetAsAttributeSet = Xml.asAttributeSet(xml);
                do {
                    next = xml.next();
                    if (next == 2) {
                        break;
                    }
                } while (next != 1);
                if (next != 2) {
                    throw new XmlPullParserException("No start tag found");
                }
                String name = xml.getName();
                this.f16459wA.m11813mjFkc(i, name);
                AZxh aZxh = (AZxh) this.f16454AZxh.m10817get(name);
                if (aZxh != null) {
                    drawableM13474lgHUyS = aZxh.m13478mjFkc(context, xml, attributeSetAsAttributeSet, context.getTheme());
                }
                if (drawableM13474lgHUyS != null) {
                    drawableM13474lgHUyS.setChangingConfigurations(typedValue.changingConfigurations);
                    m13475mjFkc(context, jM13458ZfxDd, drawableM13474lgHUyS);
                }
            } catch (Exception e) {
                Log.e("ResourceManagerInternal", "Exception while inflating drawable", e);
            }
        }
        if (drawableM13474lgHUyS == null) {
            this.f16459wA.m11813mjFkc(i, "appcompat_skip_skip");
        }
        return drawableM13474lgHUyS;
    }

    /* renamed from: lgHUyS */
    public final synchronized Drawable m13474lgHUyS(Context context, long j) {
        C4253o1 c4253o1 = (C4253o1) this.f16457ZfxDd.get(context);
        if (c4253o1 == null) {
            return null;
        }
        WeakReference weakReference = (WeakReference) c4253o1.m12918KLFTb(j);
        if (weakReference != null) {
            Drawable.ConstantState constantState = (Drawable.ConstantState) weakReference.get();
            if (constantState != null) {
                return constantState.newDrawable(context.getResources());
            }
            c4253o1.m12916ETF(j);
        }
        return null;
    }

    /* renamed from: mjFkc */
    public final synchronized boolean m13475mjFkc(Context context, long j, Drawable drawable) {
        try {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState == null) {
                return false;
            }
            C4253o1 c4253o1 = (C4253o1) this.f16457ZfxDd.get(context);
            if (c4253o1 == null) {
                c4253o1 = new C4253o1();
                this.f16457ZfxDd.put(context, c4253o1);
            }
            c4253o1.m12915Dt(j, new WeakReference(constantState));
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: qdMbNW */
    public synchronized Drawable m13476qdMbNW(Context context, int i) {
        return m13464Dt(context, i, false);
    }

    /* renamed from: wA */
    public final void m13477wA(Context context) {
        if (this.f16455JHa) {
            return;
        }
        this.f16455JHa = true;
        Drawable drawableM13476qdMbNW = m13476qdMbNW(context, AbstractC4322p4.f15896mjFkc);
        if (drawableM13476qdMbNW == null || !m13460qGY(drawableM13476qdMbNW)) {
            this.f16455JHa = false;
            throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
        }
    }
}
