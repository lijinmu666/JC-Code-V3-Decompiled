package androidx.fragment.p022app;

import android.view.ViewGroup;
import androidx.lifecycle.AbstractC0112wA;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import p131o.AbstractC3423bL;

/* renamed from: androidx.fragment.app.lgHUyS */
/* loaded from: classes.dex */
public abstract class AbstractC0095lgHUyS {

    /* renamed from: AZxh */
    public final ClassLoader f1254AZxh;

    /* renamed from: ETF */
    public String f1256ETF;

    /* renamed from: JHa */
    public int f1258JHa;

    /* renamed from: KLFTb */
    public int f1259KLFTb;

    /* renamed from: MiMN */
    public CharSequence f1260MiMN;

    /* renamed from: Pq */
    public ArrayList f1261Pq;

    /* renamed from: VA */
    public int f1262VA;

    /* renamed from: YoKzxo */
    public int f1263YoKzxo;

    /* renamed from: ZfxDd */
    public int f1264ZfxDd;

    /* renamed from: fehf */
    public ArrayList f1265fehf;

    /* renamed from: lgHUyS */
    public int f1266lgHUyS;

    /* renamed from: mjFkc */
    public final AbstractC3423bL f1267mjFkc;

    /* renamed from: qGY */
    public ArrayList f1268qGY;

    /* renamed from: qdMbNW */
    public boolean f1269qdMbNW;

    /* renamed from: rkYL */
    public CharSequence f1270rkYL;

    /* renamed from: xJ */
    public int f1272xJ;

    /* renamed from: wA */
    public ArrayList f1271wA = new ArrayList();

    /* renamed from: Dt */
    public boolean f1255Dt = true;

    /* renamed from: IEE */
    public boolean f1257IEE = false;

    /* renamed from: androidx.fragment.app.lgHUyS$mjFkc */
    public static final class mjFkc {

        /* renamed from: AZxh */
        public Fragment f1273AZxh;

        /* renamed from: JHa */
        public int f1274JHa;

        /* renamed from: KLFTb */
        public int f1275KLFTb;

        /* renamed from: ZfxDd */
        public int f1276ZfxDd;

        /* renamed from: lgHUyS */
        public AbstractC0112wA.AZxh f1277lgHUyS;

        /* renamed from: mjFkc */
        public int f1278mjFkc;

        /* renamed from: wA */
        public int f1279wA;

        /* renamed from: xJ */
        public AbstractC0112wA.AZxh f1280xJ;

        public mjFkc() {
        }

        public mjFkc(int i, Fragment fragment) {
            this.f1278mjFkc = i;
            this.f1273AZxh = fragment;
            AbstractC0112wA.AZxh aZxh = AbstractC0112wA.AZxh.RESUMED;
            this.f1280xJ = aZxh;
            this.f1277lgHUyS = aZxh;
        }
    }

    public AbstractC0095lgHUyS(AbstractC3423bL abstractC3423bL, ClassLoader classLoader) {
        this.f1267mjFkc = abstractC3423bL;
        this.f1254AZxh = classLoader;
    }

    /* renamed from: AZxh */
    public AbstractC0095lgHUyS m957AZxh(int i, Fragment fragment, String str) {
        mo958Dt(i, fragment, str, 1);
        return this;
    }

    /* renamed from: Dt */
    public void mo958Dt(int i, Fragment fragment, String str, int i2) {
        Class<?> cls = fragment.getClass();
        int modifiers = cls.getModifiers();
        if (cls.isAnonymousClass() || !Modifier.isPublic(modifiers) || (cls.isMemberClass() && !Modifier.isStatic(modifiers))) {
            throw new IllegalStateException("Fragment " + cls.getCanonicalName() + " must be a public static class to be  properly recreated from instance state.");
        }
        if (str != null) {
            String str2 = fragment.f1125Ucbh;
            if (str2 != null && !str.equals(str2)) {
                throw new IllegalStateException("Can't change tag of fragment " + fragment + ": was " + fragment.f1125Ucbh + " now " + str);
            }
            fragment.f1125Ucbh = str;
        }
        if (i != 0) {
            if (i == -1) {
                throw new IllegalArgumentException("Can't add fragment " + fragment + " with tag " + str + " to container view with no id");
            }
            int i3 = fragment.f1134diqgf;
            if (i3 != 0 && i3 != i) {
                throw new IllegalStateException("Can't change container ID of fragment " + fragment + ": was " + fragment.f1134diqgf + " now " + i);
            }
            fragment.f1134diqgf = i;
            fragment.f1135eyqo = i;
        }
        m965ZfxDd(new mjFkc(i2, fragment));
    }

    /* renamed from: ETF */
    public AbstractC0095lgHUyS mo959ETF(Fragment fragment) {
        m965ZfxDd(new mjFkc(3, fragment));
        return this;
    }

    /* renamed from: JHa */
    public abstract int mo960JHa();

    /* renamed from: KLFTb */
    public abstract int mo961KLFTb();

    /* renamed from: MiMN */
    public AbstractC0095lgHUyS m962MiMN(int i, Fragment fragment, String str) {
        if (i == 0) {
            throw new IllegalArgumentException("Must use non-zero containerViewId");
        }
        mo958Dt(i, fragment, str, 2);
        return this;
    }

    /* renamed from: VA */
    public AbstractC0095lgHUyS m963VA(int i, Fragment fragment) {
        return m962MiMN(i, fragment, null);
    }

    /* renamed from: YoKzxo */
    public AbstractC0095lgHUyS m964YoKzxo(boolean z) {
        this.f1257IEE = z;
        return this;
    }

    /* renamed from: ZfxDd */
    public void m965ZfxDd(mjFkc mjfkc) {
        this.f1271wA.add(mjfkc);
        mjfkc.f1279wA = this.f1264ZfxDd;
        mjfkc.f1276ZfxDd = this.f1259KLFTb;
        mjfkc.f1275KLFTb = this.f1258JHa;
        mjfkc.f1274JHa = this.f1272xJ;
    }

    /* renamed from: lgHUyS */
    public abstract void mo966lgHUyS();

    /* renamed from: qdMbNW */
    public AbstractC0095lgHUyS m967qdMbNW() {
        if (this.f1269qdMbNW) {
            throw new IllegalStateException("This transaction is already being added to the back stack");
        }
        this.f1255Dt = false;
        return this;
    }

    /* renamed from: wA */
    public AbstractC0095lgHUyS m968wA(ViewGroup viewGroup, Fragment fragment, String str) {
        fragment.f1151wJVbdd = viewGroup;
        return m957AZxh(viewGroup.getId(), fragment, str);
    }

    /* renamed from: xJ */
    public abstract void mo969xJ();
}
