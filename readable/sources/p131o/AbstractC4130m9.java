package p131o;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.CancellationSignal;
import android.os.Handler;
import p131o.AbstractC2165IRE;
import p131o.AbstractC2927Tz;
import p131o.AbstractC4592t5;

/* renamed from: o.m9 */
/* loaded from: classes.dex */
public abstract class AbstractC4130m9 {

    /* renamed from: mjFkc */
    public static final AbstractC4261o9 f14881mjFkc = new C4196n9();

    /* renamed from: AZxh */
    public static final C4386q1 f14880AZxh = new C4386q1(16);

    /* renamed from: o.m9$mjFkc */
    public static class mjFkc extends AbstractC2927Tz.wA {

        /* renamed from: mjFkc */
        public AbstractC4592t5.KLFTb f14882mjFkc;

        public mjFkc(AbstractC4592t5.KLFTb kLFTb) {
            this.f14882mjFkc = kLFTb;
        }

        @Override // p131o.AbstractC2927Tz.wA
        /* renamed from: AZxh */
        public void mo10462AZxh(Typeface typeface) {
            AbstractC4592t5.KLFTb kLFTb = this.f14882mjFkc;
            if (kLFTb != null) {
                kLFTb.m13596xJ(typeface);
            }
        }

        @Override // p131o.AbstractC2927Tz.wA
        /* renamed from: mjFkc */
        public void mo10463mjFkc(int i) {
            AbstractC4592t5.KLFTb kLFTb = this.f14882mjFkc;
            if (kLFTb != null) {
                kLFTb.m13593JHa(i);
            }
        }
    }

    /* renamed from: AZxh */
    public static Typeface m12755AZxh(Context context, CancellationSignal cancellationSignal, AbstractC2927Tz.AZxh[] aZxhArr, int i) {
        return f14881mjFkc.mo12852AZxh(context, cancellationSignal, aZxhArr, i);
    }

    /* renamed from: JHa */
    public static Typeface m12756JHa(Resources resources, int i, String str, int i2, int i3) {
        return (Typeface) f14880AZxh.m13166wA(m12757KLFTb(resources, i, str, i2, i3));
    }

    /* renamed from: KLFTb */
    public static String m12757KLFTb(Resources resources, int i, String str, int i2, int i3) {
        return resources.getResourcePackageName(i) + '-' + str + '-' + i2 + '-' + i + '-' + i3;
    }

    /* renamed from: ZfxDd */
    public static Typeface m12758ZfxDd(Context context, Resources resources, int i, String str, int i2, int i3) {
        Typeface typefaceMo12855wA = f14881mjFkc.mo12855wA(context, resources, i, str, i3);
        if (typefaceMo12855wA != null) {
            f14880AZxh.m13164ZfxDd(m12757KLFTb(resources, i, str, i2, i3), typefaceMo12855wA);
        }
        return typefaceMo12855wA;
    }

    /* renamed from: mjFkc */
    public static Typeface m12759mjFkc(Context context, Typeface typeface, int i) {
        if (context != null) {
            return Typeface.create(typeface, i);
        }
        throw new IllegalArgumentException("Context cannot be null");
    }

    /* renamed from: wA */
    public static Typeface m12760wA(Context context, AbstractC2165IRE.AZxh aZxh, Resources resources, int i, String str, int i2, int i3, AbstractC4592t5.KLFTb kLFTb, Handler handler, boolean z) {
        Typeface typefaceMo12854mjFkc;
        if (aZxh instanceof AbstractC2165IRE.KLFTb) {
            AbstractC2165IRE.KLFTb kLFTb2 = (AbstractC2165IRE.KLFTb) aZxh;
            Typeface typefaceM12761xJ = m12761xJ(kLFTb2.m8739wA());
            if (typefaceM12761xJ != null) {
                if (kLFTb != null) {
                    kLFTb.m13594ZfxDd(typefaceM12761xJ, handler);
                }
                return typefaceM12761xJ;
            }
            typefaceMo12854mjFkc = AbstractC2927Tz.m10452wA(context, kLFTb2.m8736AZxh(), i3, !z ? kLFTb != null : kLFTb2.m8738mjFkc() != 0, z ? kLFTb2.m8737ZfxDd() : -1, AbstractC4592t5.KLFTb.m13591KLFTb(handler), new mjFkc(kLFTb));
        } else {
            typefaceMo12854mjFkc = f14881mjFkc.mo12854mjFkc(context, (AbstractC2165IRE.wA) aZxh, resources, i3);
            if (kLFTb != null) {
                if (typefaceMo12854mjFkc != null) {
                    kLFTb.m13594ZfxDd(typefaceMo12854mjFkc, handler);
                } else {
                    kLFTb.m13595wA(-3, handler);
                }
            }
        }
        if (typefaceMo12854mjFkc != null) {
            f14880AZxh.m13164ZfxDd(m12757KLFTb(resources, i, str, i2, i3), typefaceMo12854mjFkc);
        }
        return typefaceMo12854mjFkc;
    }

    /* renamed from: xJ */
    public static Typeface m12761xJ(String str) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Typeface typefaceCreate = Typeface.create(str, 0);
        Typeface typefaceCreate2 = Typeface.create(Typeface.DEFAULT, 0);
        if (typefaceCreate == null || typefaceCreate.equals(typefaceCreate2)) {
            return null;
        }
        return typefaceCreate;
    }
}
