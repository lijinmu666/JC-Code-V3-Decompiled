package p131o;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.conscrypt.BuildConfig;
import p131o.C2936U7;

/* renamed from: o.U7 */
/* loaded from: classes.dex */
public class C2936U7 {

    /* renamed from: AZxh */
    public final String f10789AZxh;

    /* renamed from: mjFkc */
    public final List f10790mjFkc;

    /* renamed from: o.U7$ZfxDd */
    public static class ZfxDd {

        /* renamed from: AZxh */
        public final Rect f10795AZxh;

        /* renamed from: ZfxDd */
        public final String f10796ZfxDd;

        /* renamed from: mjFkc */
        public final String f10797mjFkc;

        /* renamed from: wA */
        public final Point[] f10798wA;

        public ZfxDd(String str, Rect rect, List list, String str2, Matrix matrix) {
            this.f10797mjFkc = str;
            Rect rect2 = new Rect(rect);
            if (matrix != null) {
                AbstractC4272oJ.m12952wA(rect2, matrix);
            }
            this.f10795AZxh = rect2;
            Point[] pointArr = new Point[list.size()];
            for (int i = 0; i < list.size(); i++) {
                pointArr[i] = new Point((Point) list.get(i));
            }
            if (matrix != null) {
                AbstractC4272oJ.m12950AZxh(pointArr, matrix);
            }
            this.f10798wA = pointArr;
            this.f10796ZfxDd = str2;
        }

        /* renamed from: AZxh */
        public String m10475AZxh() {
            return this.f10796ZfxDd;
        }

        /* renamed from: mjFkc */
        public Rect m10476mjFkc() {
            return this.f10795AZxh;
        }

        /* renamed from: wA */
        public final String m10477wA() {
            String str = this.f10797mjFkc;
            return str == null ? BuildConfig.f24315FLAVOR : str;
        }
    }

    /* renamed from: o.U7$wA */
    public static class wA extends ZfxDd {

        /* renamed from: JHa */
        public final float f10802JHa;

        /* renamed from: KLFTb */
        public final float f10803KLFTb;

        public wA(C2513NW c2513nw, Matrix matrix) {
            super(c2513nw.m9688ZfxDd(), c2513nw.m9690wA(), c2513nw.m9687JHa(), BuildConfig.f24315FLAVOR, matrix);
            this.f10803KLFTb = c2513nw.m9686AZxh();
            this.f10802JHa = c2513nw.m9689mjFkc();
        }
    }

    public C2936U7(C2243JW c2243jw, final Matrix matrix) {
        ArrayList arrayList = new ArrayList();
        this.f10790mjFkc = arrayList;
        this.f10789AZxh = c2243jw.m8983mjFkc();
        arrayList.addAll(AbstractC3612eE.m11820mjFkc(c2243jw.m8982AZxh(), new InterfaceC3301ZV() { // from class: o.nB
            @Override // p131o.InterfaceC3301ZV
            /* renamed from: mjFkc */
            public final Object mo7828mjFkc(Object obj) {
                return new C2936U7.KLFTb((C4954yW) obj, matrix);
            }
        }));
    }

    /* renamed from: AZxh */
    public List m10470AZxh() {
        return Collections.unmodifiableList(this.f10790mjFkc);
    }

    /* renamed from: mjFkc */
    public String m10471mjFkc() {
        return this.f10789AZxh;
    }

    public C2936U7(String str, List list) {
        ArrayList arrayList = new ArrayList();
        this.f10790mjFkc = arrayList;
        arrayList.addAll(list);
        this.f10789AZxh = str;
    }

    /* renamed from: o.U7$AZxh */
    public static class AZxh extends ZfxDd {

        /* renamed from: JHa */
        public final float f10791JHa;

        /* renamed from: KLFTb */
        public final List f10792KLFTb;

        /* renamed from: xJ */
        public final float f10793xJ;

        public AZxh(C2105HW c2105hw, final Matrix matrix, float f, float f2) {
            super(c2105hw.m8577JHa(), c2105hw.m8581wA(), c2105hw.m8582xJ(), c2105hw.m8578ZfxDd(), matrix);
            this.f10792KLFTb = AbstractC3612eE.m11820mjFkc(c2105hw.m8579lgHUyS(), new InterfaceC3301ZV() { // from class: o.xE
                @Override // p131o.InterfaceC3301ZV
                /* renamed from: mjFkc */
                public final Object mo7828mjFkc(Object obj) {
                    return new C2936U7.mjFkc((C1967FW) obj, matrix);
                }
            });
            this.f10791JHa = f;
            this.f10793xJ = f2;
        }

        /* renamed from: ZfxDd */
        public String m10472ZfxDd() {
            return m10477wA();
        }

        public AZxh(String str, Rect rect, List list, String str2, Matrix matrix, List list2, float f, float f2) {
            super(str, rect, list, str2, matrix);
            this.f10792KLFTb = list2;
            this.f10791JHa = f;
            this.f10793xJ = f2;
        }
    }

    /* renamed from: o.U7$KLFTb */
    public static class KLFTb extends ZfxDd {

        /* renamed from: KLFTb */
        public final List f10794KLFTb;

        public KLFTb(C4954yW c4954yW, final Matrix matrix) {
            super(c4954yW.m14012wA(), c4954yW.m14011mjFkc(), c4954yW.m14010ZfxDd(), c4954yW.m14008AZxh(), matrix);
            this.f10794KLFTb = AbstractC3612eE.m11820mjFkc(c4954yW.m14009JHa(), new InterfaceC3301ZV() { // from class: o.FF
                @Override // p131o.InterfaceC3301ZV
                /* renamed from: mjFkc */
                public final Object mo7828mjFkc(Object obj) {
                    C2105HW c2105hw = (C2105HW) obj;
                    return new C2936U7.AZxh(c2105hw, matrix, c2105hw.m8576AZxh(), c2105hw.m8580mjFkc());
                }
            });
        }

        /* renamed from: KLFTb */
        public String m10473KLFTb() {
            return m10477wA();
        }

        /* renamed from: ZfxDd */
        public synchronized List m10474ZfxDd() {
            return this.f10794KLFTb;
        }

        public KLFTb(String str, Rect rect, List list, String str2, Matrix matrix, List list2) {
            super(str, rect, list, str2, matrix);
            this.f10794KLFTb = list2;
        }
    }

    /* renamed from: o.U7$mjFkc */
    public static class mjFkc extends ZfxDd {

        /* renamed from: JHa */
        public final float f10799JHa;

        /* renamed from: KLFTb */
        public final List f10800KLFTb;

        /* renamed from: xJ */
        public final float f10801xJ;

        public mjFkc(C1967FW c1967fw, final Matrix matrix) {
            super(c1967fw.m8307JHa(), c1967fw.m8311wA(), c1967fw.m8312xJ(), c1967fw.m8308ZfxDd(), matrix);
            this.f10799JHa = c1967fw.m8306AZxh();
            this.f10801xJ = c1967fw.m8310mjFkc();
            List listM8309lgHUyS = c1967fw.m8309lgHUyS();
            this.f10800KLFTb = AbstractC3612eE.m11820mjFkc(listM8309lgHUyS == null ? new ArrayList() : listM8309lgHUyS, new InterfaceC3301ZV() { // from class: o.eD
                @Override // p131o.InterfaceC3301ZV
                /* renamed from: mjFkc */
                public final Object mo7828mjFkc(Object obj) {
                    return new C2936U7.wA((C2513NW) obj, matrix);
                }
            });
        }

        public mjFkc(String str, Rect rect, List list, String str2, Matrix matrix, float f, float f2, List list2) {
            super(str, rect, list, str2, matrix);
            this.f10799JHa = f;
            this.f10801xJ = f2;
            this.f10800KLFTb = list2;
        }
    }
}
