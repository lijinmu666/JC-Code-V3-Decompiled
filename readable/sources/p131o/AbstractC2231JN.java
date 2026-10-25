package p131o;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.SparseArray;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.conscrypt.BuildConfig;
import p131o.C2936U7;

/* renamed from: o.JN */
/* loaded from: classes.dex */
public abstract class AbstractC2231JN {

    /* renamed from: mjFkc */
    public static final C1699BW f8926mjFkc = C1699BW.m7696mjFkc("\n");

    /* renamed from: AZxh */
    public static final Comparator f8925AZxh = new Comparator() { // from class: o.UH
        @Override // java.util.Comparator
        public final int compare(Object obj, Object obj2) {
            C1699BW c1699bw = AbstractC2231JN.f8926mjFkc;
            return ((Integer) ((Map.Entry) obj).getValue()).compareTo((Integer) ((Map.Entry) obj2).getValue());
        }
    };

    /* renamed from: AZxh */
    public static String m8925AZxh(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String strM10475AZxh = ((C2936U7.AZxh) it.next()).m10475AZxh();
            map.put(strM10475AZxh, Integer.valueOf((map.containsKey(strM10475AZxh) ? ((Integer) map.get(strM10475AZxh)).intValue() : 0) + 1));
        }
        Set setEntrySet = map.entrySet();
        if (setEntrySet.isEmpty()) {
            return "und";
        }
        String str = (String) ((Map.Entry) Collections.max(setEntrySet, f8925AZxh)).getKey();
        return !AbstractC3438bX.m11525AZxh(str) ? str : "und";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: mjFkc */
    public static C2936U7 m8926mjFkc(C2630PO[] c2630poArr, final Matrix matrix) {
        SparseArray sparseArray = new SparseArray();
        int i = 0;
        for (C2630PO c2630po : c2630poArr) {
            SparseArray sparseArray2 = (SparseArray) sparseArray.get(c2630po.f10075Dt);
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                sparseArray.append(c2630po.f10075Dt, sparseArray2);
            }
            sparseArray2.append(c2630po.f10076ETF, c2630po);
        }
        C1812DD c1812dd = new C1812DD();
        int i2 = 0;
        while (i2 < sparseArray.size()) {
            SparseArray sparseArray3 = (SparseArray) sparseArray.valueAt(i2);
            C1812DD c1812dd2 = new C1812DD();
            for (int i3 = i; i3 < sparseArray3.size(); i3++) {
                c1812dd2.m7988mjFkc((C2630PO) sparseArray3.valueAt(i3));
            }
            AbstractC2219JD abstractC2219JDM7987AZxh = c1812dd2.m7987AZxh();
            List listM11820mjFkc = AbstractC3612eE.m11820mjFkc(abstractC2219JDM7987AZxh, new InterfaceC3301ZV() { // from class: o.kK
                @Override // p131o.InterfaceC3301ZV
                /* renamed from: mjFkc */
                public final Object mo7828mjFkc(Object obj) {
                    C2630PO c2630po2 = (C2630PO) obj;
                    C1699BW c1699bw = AbstractC2231JN.f8926mjFkc;
                    List listM12945AZxh = AbstractC4263oB.m12945AZxh(c2630po2.f10074AZxh);
                    String str = AbstractC3438bX.m11525AZxh(c2630po2.f10078KLFTb) ? BuildConfig.f24315FLAVOR : c2630po2.f10078KLFTb;
                    Rect rectM12946mjFkc = AbstractC4263oB.m12946mjFkc(listM12945AZxh);
                    String str2 = AbstractC3438bX.m11525AZxh(c2630po2.f10084xJ) ? "und" : c2630po2.f10084xJ;
                    final Matrix matrix2 = matrix;
                    return new C2936U7.AZxh(str, rectM12946mjFkc, listM12945AZxh, str2, matrix2, AbstractC3612eE.m11820mjFkc(Arrays.asList(c2630po2.f10081mjFkc), new InterfaceC3301ZV() { // from class: o.CM
                        @Override // p131o.InterfaceC3301ZV
                        /* renamed from: mjFkc */
                        public final Object mo7828mjFkc(Object obj2) {
                            C2034GT c2034gt = (C2034GT) obj2;
                            C1699BW c1699bw2 = AbstractC2231JN.f8926mjFkc;
                            List listM12945AZxh2 = AbstractC4263oB.m12945AZxh(c2034gt.f8359AZxh);
                            return new C2936U7.mjFkc(AbstractC3438bX.m11525AZxh(c2034gt.f8362ZfxDd) ? BuildConfig.f24315FLAVOR : c2034gt.f8362ZfxDd, AbstractC4263oB.m12946mjFkc(listM12945AZxh2), listM12945AZxh2, AbstractC3438bX.m11525AZxh(c2034gt.f8360JHa) ? "und" : c2034gt.f8360JHa, matrix2, c2034gt.f8361KLFTb, c2034gt.f8359AZxh.f10166KLFTb, AbstractC2219JD.m8919Dt());
                        }
                    }), c2630po2.f10077JHa, c2630po2.f10074AZxh.f10166KLFTb);
                }
            });
            C2685QH c2685qh = ((C2630PO) abstractC2219JDM7987AZxh.get(i)).f10074AZxh;
            AbstractC3484cF abstractC3484cFListIterator = abstractC2219JDM7987AZxh.listIterator(i);
            int iMax = Integer.MIN_VALUE;
            int iMin = Integer.MAX_VALUE;
            int iMin2 = Integer.MAX_VALUE;
            int iMax2 = Integer.MIN_VALUE;
            while (abstractC3484cFListIterator.hasNext()) {
                C2685QH c2685qh2 = ((C2630PO) abstractC3484cFListIterator.next()).f10074AZxh;
                int i4 = -c2685qh.f10168mjFkc;
                int i5 = -c2685qh.f10165AZxh;
                List list = listM11820mjFkc;
                double dSin = Math.sin(Math.toRadians(c2685qh.f10166KLFTb));
                AbstractC3484cF abstractC3484cF = abstractC3484cFListIterator;
                double dCos = Math.cos(Math.toRadians(c2685qh.f10166KLFTb));
                SparseArray sparseArray4 = sparseArray;
                int i6 = i2;
                C1812DD c1812dd3 = c1812dd;
                Point point = new Point(c2685qh2.f10168mjFkc, c2685qh2.f10165AZxh);
                point.offset(i4, i5);
                Point[] pointArr = {point, new Point(c2685qh2.f10169wA + i, i), new Point(c2685qh2.f10169wA + i, c2685qh2.f10167ZfxDd + i), new Point(i, i + c2685qh2.f10167ZfxDd)};
                Point point2 = pointArr[0];
                int i7 = point2.x;
                int i8 = point2.y;
                int i9 = iMax;
                double d = i8 * dSin;
                int i10 = iMin;
                double d2 = (-i7) * dSin;
                double d3 = i8 * dCos;
                int i11 = (int) ((i7 * dCos) + d);
                point2.x = i11;
                int i12 = (int) (d2 + d3);
                point2.y = i12;
                iMax = i9;
                iMax2 = iMax2;
                iMin = i10;
                iMin2 = iMin2;
                int i13 = 0;
                for (int i14 = 4; i13 < i14; i14 = 4) {
                    Point point3 = pointArr[i13];
                    iMin = Math.min(iMin, point3.x);
                    iMax = Math.max(iMax, point3.x);
                    iMin2 = Math.min(iMin2, point3.y);
                    iMax2 = Math.max(iMax2, point3.y);
                    i13++;
                }
                listM11820mjFkc = list;
                abstractC3484cFListIterator = abstractC3484cF;
                sparseArray = sparseArray4;
                i2 = i6;
                c1812dd = c1812dd3;
            }
            C1812DD c1812dd4 = c1812dd;
            SparseArray sparseArray5 = sparseArray;
            int i15 = i2;
            int i16 = iMax;
            int i17 = iMax2;
            int i18 = iMin;
            List list2 = listM11820mjFkc;
            int i19 = c2685qh.f10168mjFkc;
            int i20 = c2685qh.f10165AZxh;
            double dSin2 = Math.sin(Math.toRadians(c2685qh.f10166KLFTb));
            double dCos2 = Math.cos(Math.toRadians(c2685qh.f10166KLFTb));
            Point[] pointArr2 = {new Point(i18, iMin2), new Point(i16, iMin2), new Point(i16, i17), new Point(i18, i17)};
            int i21 = 0;
            for (int i22 = 4; i21 < i22; i22 = 4) {
                Point point4 = pointArr2[i21];
                int i23 = point4.x;
                int i24 = point4.y;
                point4.x = (int) ((i23 * dCos2) - (i24 * dSin2));
                point4.y = (int) ((i23 * dSin2) + (i24 * dCos2));
                point4.offset(i19, i20);
                i21++;
                dSin2 = dSin2;
            }
            List listAsList = Arrays.asList(pointArr2);
            c1812dd4.m7988mjFkc(new C2936U7.KLFTb(f8926mjFkc.m7698AZxh(AbstractC3612eE.m11820mjFkc(list2, new InterfaceC3301ZV() { // from class: o.tL
                @Override // p131o.InterfaceC3301ZV
                /* renamed from: mjFkc */
                public final Object mo7828mjFkc(Object obj) {
                    return ((C2936U7.AZxh) obj).m10472ZfxDd();
                }
            })), AbstractC4263oB.m12946mjFkc(listAsList), listAsList, m8925AZxh(list2), matrix, list2));
            i2 = i15 + 1;
            c1812dd = c1812dd4;
            sparseArray = sparseArray5;
            i = 0;
        }
        AbstractC2219JD abstractC2219JDM7987AZxh2 = c1812dd.m7987AZxh();
        return new C2936U7(f8926mjFkc.m7698AZxh(AbstractC3612eE.m11820mjFkc(abstractC2219JDM7987AZxh2, new InterfaceC3301ZV() { // from class: o.cJ
            @Override // p131o.InterfaceC3301ZV
            /* renamed from: mjFkc */
            public final Object mo7828mjFkc(Object obj) {
                return ((C2936U7.KLFTb) obj).m10473KLFTb();
            }
        })), abstractC2219JDM7987AZxh2);
    }
}
