package p131o;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;
import java.util.ArrayList;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import p131o.AbstractC2927Tz;

/* renamed from: o.mh */
/* loaded from: classes.dex */
public abstract class AbstractC4165mh {

    /* renamed from: mjFkc */
    public static final C4386q1 f15234mjFkc = new C4386q1(16);

    /* renamed from: AZxh */
    public static final ExecutorService f15232AZxh = AbstractC4126m5.m12741mjFkc("fonts-androidx", 10, 10000);

    /* renamed from: wA */
    public static final Object f15235wA = new Object();

    /* renamed from: ZfxDd */
    public static final C3074W6 f15233ZfxDd = new C3074W6();

    /* renamed from: o.mh$AZxh */
    public class AZxh implements InterfaceC2317KbE {

        /* renamed from: mjFkc */
        public final /* synthetic */ C4285oVXlhB f15236mjFkc;

        public AZxh(C4285oVXlhB c4285oVXlhB) {
            this.f15236mjFkc = c4285oVXlhB;
        }

        @Override // p131o.InterfaceC2317KbE
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo9246mjFkc(KLFTb kLFTb) {
            if (kLFTb == null) {
                kLFTb = new KLFTb(-3);
            }
            this.f15236mjFkc.m12962AZxh(kLFTb);
        }
    }

    /* renamed from: o.mh$ZfxDd */
    public class ZfxDd implements InterfaceC2317KbE {

        /* renamed from: mjFkc */
        public final /* synthetic */ String f15239mjFkc;

        public ZfxDd(String str) {
            this.f15239mjFkc = str;
        }

        @Override // p131o.InterfaceC2317KbE
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo9246mjFkc(KLFTb kLFTb) {
            synchronized (AbstractC4165mh.f15235wA) {
                try {
                    C3074W6 c3074w6 = AbstractC4165mh.f15233ZfxDd;
                    ArrayList arrayList = (ArrayList) c3074w6.m10817get(this.f15239mjFkc);
                    if (arrayList == null) {
                        return;
                    }
                    c3074w6.m10823remove(this.f15239mjFkc);
                    for (int i = 0; i < arrayList.size(); i++) {
                        ((InterfaceC2317KbE) arrayList.get(i)).mo9246mjFkc(kLFTb);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    /* renamed from: o.mh$mjFkc */
    public class mjFkc implements Callable {

        /* renamed from: AZxh */
        public final /* synthetic */ Context f15240AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ int f15241ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f15242mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ C3395avDfWJ f15243wA;

        public mjFkc(String str, Context context, C3395avDfWJ c3395avDfWJ, int i) {
            this.f15242mjFkc = str;
            this.f15240AZxh = context;
            this.f15243wA = c3395avDfWJ;
            this.f15241ZfxDd = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public KLFTb call() {
            return AbstractC4165mh.m12784wA(this.f15242mjFkc, this.f15240AZxh, this.f15243wA, this.f15241ZfxDd);
        }
    }

    /* renamed from: o.mh$wA */
    public class wA implements Callable {

        /* renamed from: AZxh */
        public final /* synthetic */ Context f15244AZxh;

        /* renamed from: ZfxDd */
        public final /* synthetic */ int f15245ZfxDd;

        /* renamed from: mjFkc */
        public final /* synthetic */ String f15246mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ C3395avDfWJ f15247wA;

        public wA(String str, Context context, C3395avDfWJ c3395avDfWJ, int i) {
            this.f15246mjFkc = str;
            this.f15244AZxh = context;
            this.f15247wA = c3395avDfWJ;
            this.f15245ZfxDd = i;
        }

        @Override // java.util.concurrent.Callable
        /* renamed from: mjFkc, reason: merged with bridge method [inline-methods] */
        public KLFTb call() {
            try {
                return AbstractC4165mh.m12784wA(this.f15246mjFkc, this.f15244AZxh, this.f15247wA, this.f15245ZfxDd);
            } catch (Throwable unused) {
                return new KLFTb(-3);
            }
        }
    }

    /* renamed from: AZxh */
    public static int m12780AZxh(AbstractC2927Tz.mjFkc mjfkc) {
        int i = 1;
        if (mjfkc.m10461wA() != 0) {
            return mjfkc.m10461wA() != 1 ? -3 : -2;
        }
        AbstractC2927Tz.AZxh[] aZxhArrM10460AZxh = mjfkc.m10460AZxh();
        if (aZxhArrM10460AZxh != null && aZxhArrM10460AZxh.length != 0) {
            i = 0;
            for (AbstractC2927Tz.AZxh aZxh : aZxhArrM10460AZxh) {
                int iM10454AZxh = aZxh.m10454AZxh();
                if (iM10454AZxh != 0) {
                    if (iM10454AZxh < 0) {
                        return -3;
                    }
                    return iM10454AZxh;
                }
            }
        }
        return i;
    }

    /* renamed from: KLFTb */
    public static Typeface m12781KLFTb(Context context, C3395avDfWJ c3395avDfWJ, C4285oVXlhB c4285oVXlhB, int i, int i2) {
        String strM12783mjFkc = m12783mjFkc(c3395avDfWJ, i);
        Typeface typeface = (Typeface) f15234mjFkc.m13166wA(strM12783mjFkc);
        if (typeface != null) {
            c4285oVXlhB.m12962AZxh(new KLFTb(typeface));
            return typeface;
        }
        if (i2 == -1) {
            KLFTb kLFTbM12784wA = m12784wA(strM12783mjFkc, context, c3395avDfWJ, i);
            c4285oVXlhB.m12962AZxh(kLFTbM12784wA);
            return kLFTbM12784wA.f15238mjFkc;
        }
        try {
            KLFTb kLFTb = (KLFTb) AbstractC4126m5.m12742wA(f15232AZxh, new mjFkc(strM12783mjFkc, context, c3395avDfWJ, i), i2);
            c4285oVXlhB.m12962AZxh(kLFTb);
            return kLFTb.f15238mjFkc;
        } catch (InterruptedException unused) {
            c4285oVXlhB.m12962AZxh(new KLFTb(-3));
            return null;
        }
    }

    /* renamed from: ZfxDd */
    public static Typeface m12782ZfxDd(Context context, C3395avDfWJ c3395avDfWJ, int i, Executor executor, C4285oVXlhB c4285oVXlhB) {
        String strM12783mjFkc = m12783mjFkc(c3395avDfWJ, i);
        Typeface typeface = (Typeface) f15234mjFkc.m13166wA(strM12783mjFkc);
        if (typeface != null) {
            c4285oVXlhB.m12962AZxh(new KLFTb(typeface));
            return typeface;
        }
        AZxh aZxh = new AZxh(c4285oVXlhB);
        synchronized (f15235wA) {
            try {
                C3074W6 c3074w6 = f15233ZfxDd;
                ArrayList arrayList = (ArrayList) c3074w6.m10817get(strM12783mjFkc);
                if (arrayList != null) {
                    arrayList.add(aZxh);
                    return null;
                }
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(aZxh);
                c3074w6.m10821put(strM12783mjFkc, arrayList2);
                wA wAVar = new wA(strM12783mjFkc, context, c3395avDfWJ, i);
                if (executor == null) {
                    executor = f15232AZxh;
                }
                AbstractC4126m5.m12740AZxh(executor, wAVar, new ZfxDd(strM12783mjFkc));
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    /* renamed from: mjFkc */
    public static String m12783mjFkc(C3395avDfWJ c3395avDfWJ, int i) {
        return c3395avDfWJ.m11428ZfxDd() + "-" + i;
    }

    /* renamed from: wA */
    public static KLFTb m12784wA(String str, Context context, C3395avDfWJ c3395avDfWJ, int i) {
        C4386q1 c4386q1 = f15234mjFkc;
        Typeface typeface = (Typeface) c4386q1.m13166wA(str);
        if (typeface != null) {
            return new KLFTb(typeface);
        }
        try {
            AbstractC2927Tz.mjFkc mjfkcM8969KLFTb = AbstractC2240JTqL.m8969KLFTb(context, c3395avDfWJ, null);
            int iM12780AZxh = m12780AZxh(mjfkcM8969KLFTb);
            if (iM12780AZxh != 0) {
                return new KLFTb(iM12780AZxh);
            }
            Typeface typefaceM12755AZxh = AbstractC4130m9.m12755AZxh(context, null, mjfkcM8969KLFTb.m10460AZxh(), i);
            if (typefaceM12755AZxh == null) {
                return new KLFTb(-3);
            }
            c4386q1.m13164ZfxDd(str, typefaceM12755AZxh);
            return new KLFTb(typefaceM12755AZxh);
        } catch (PackageManager.NameNotFoundException unused) {
            return new KLFTb(-1);
        }
    }

    /* renamed from: o.mh$KLFTb */
    public static final class KLFTb {

        /* renamed from: AZxh */
        public final int f15237AZxh;

        /* renamed from: mjFkc */
        public final Typeface f15238mjFkc;

        public KLFTb(int i) {
            this.f15238mjFkc = null;
            this.f15237AZxh = i;
        }

        /* renamed from: mjFkc */
        public boolean m12786mjFkc() {
            return this.f15237AZxh == 0;
        }

        public KLFTb(Typeface typeface) {
            this.f15238mjFkc = typeface;
            this.f15237AZxh = 0;
        }
    }
}
