package p131o;

import android.content.Context;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.CancellationSignal;
import android.os.Handler;

/* renamed from: o.Tz */
/* loaded from: classes.dex */
public abstract class AbstractC2927Tz {

    /* renamed from: o.Tz$AZxh */
    public static class AZxh {

        /* renamed from: AZxh */
        public final int f10758AZxh;

        /* renamed from: KLFTb */
        public final int f10759KLFTb;

        /* renamed from: ZfxDd */
        public final boolean f10760ZfxDd;

        /* renamed from: mjFkc */
        public final Uri f10761mjFkc;

        /* renamed from: wA */
        public final int f10762wA;

        public AZxh(Uri uri, int i, int i2, boolean z, int i3) {
            this.f10761mjFkc = (Uri) AbstractC2280K3.m9126xJ(uri);
            this.f10758AZxh = i;
            this.f10762wA = i2;
            this.f10760ZfxDd = z;
            this.f10759KLFTb = i3;
        }

        /* renamed from: mjFkc */
        public static AZxh m10453mjFkc(Uri uri, int i, int i2, boolean z, int i3) {
            return new AZxh(uri, i, i2, z, i3);
        }

        /* renamed from: AZxh */
        public int m10454AZxh() {
            return this.f10759KLFTb;
        }

        /* renamed from: JHa */
        public boolean m10455JHa() {
            return this.f10760ZfxDd;
        }

        /* renamed from: KLFTb */
        public int m10456KLFTb() {
            return this.f10762wA;
        }

        /* renamed from: ZfxDd */
        public Uri m10457ZfxDd() {
            return this.f10761mjFkc;
        }

        /* renamed from: wA */
        public int m10458wA() {
            return this.f10758AZxh;
        }
    }

    /* renamed from: o.Tz$mjFkc */
    public static class mjFkc {

        /* renamed from: AZxh */
        public final AZxh[] f10763AZxh;

        /* renamed from: mjFkc */
        public final int f10764mjFkc;

        public mjFkc(int i, AZxh[] aZxhArr) {
            this.f10764mjFkc = i;
            this.f10763AZxh = aZxhArr;
        }

        /* renamed from: mjFkc */
        public static mjFkc m10459mjFkc(int i, AZxh[] aZxhArr) {
            return new mjFkc(i, aZxhArr);
        }

        /* renamed from: AZxh */
        public AZxh[] m10460AZxh() {
            return this.f10763AZxh;
        }

        /* renamed from: wA */
        public int m10461wA() {
            return this.f10764mjFkc;
        }
    }

    /* renamed from: o.Tz$wA */
    public static class wA {
        /* renamed from: AZxh */
        public abstract void mo10462AZxh(Typeface typeface);

        /* renamed from: mjFkc */
        public abstract void mo10463mjFkc(int i);
    }

    /* renamed from: AZxh */
    public static mjFkc m10450AZxh(Context context, CancellationSignal cancellationSignal, C3395avDfWJ c3395avDfWJ) {
        return AbstractC2240JTqL.m8969KLFTb(context, c3395avDfWJ, cancellationSignal);
    }

    /* renamed from: mjFkc */
    public static Typeface m10451mjFkc(Context context, CancellationSignal cancellationSignal, AZxh[] aZxhArr) {
        return AbstractC4130m9.m12755AZxh(context, cancellationSignal, aZxhArr, 0);
    }

    /* renamed from: wA */
    public static Typeface m10452wA(Context context, C3395avDfWJ c3395avDfWJ, int i, boolean z, int i2, Handler handler, wA wAVar) {
        C4285oVXlhB c4285oVXlhB = new C4285oVXlhB(wAVar, handler);
        return z ? AbstractC4165mh.m12781KLFTb(context, c3395avDfWJ, c4285oVXlhB, i, i2) : AbstractC4165mh.m12782ZfxDd(context, c3395avDfWJ, i, null, c4285oVXlhB);
    }
}
