package p131o;

import android.graphics.Point;
import android.graphics.Rect;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: o.oB */
/* loaded from: classes.dex */
public abstract class AbstractC4263oB {
    /* renamed from: AZxh */
    public static List m12945AZxh(C2685QH c2685qh) {
        double dSin = Math.sin(Math.toRadians(c2685qh.f10166KLFTb));
        double dCos = Math.cos(Math.toRadians(c2685qh.f10166KLFTb));
        double d = c2685qh.f10168mjFkc;
        double d2 = c2685qh.f10169wA;
        Point point = new Point((int) (d + (d2 * dCos)), (int) (c2685qh.f10165AZxh + (d2 * dSin)));
        double d3 = point.x;
        int i = c2685qh.f10167ZfxDd;
        double d4 = i * dSin;
        double d5 = pointArr[1].y + (i * dCos);
        Point point2 = pointArr[0];
        int i2 = point2.x;
        Point point3 = pointArr[2];
        int i3 = point3.x;
        Point point4 = pointArr[1];
        Point[] pointArr = {new Point(c2685qh.f10168mjFkc, c2685qh.f10165AZxh), point, new Point((int) (d3 - d4), (int) d5), new Point(i2 + (i3 - point4.x), point2.y + (point3.y - point4.y))};
        return Arrays.asList(pointArr);
    }

    /* renamed from: mjFkc */
    public static Rect m12946mjFkc(List list) {
        Iterator it = list.iterator();
        int iMax = Integer.MIN_VALUE;
        int iMin = Integer.MAX_VALUE;
        int iMin2 = Integer.MAX_VALUE;
        int iMax2 = Integer.MIN_VALUE;
        while (it.hasNext()) {
            Point point = (Point) it.next();
            iMin = Math.min(iMin, point.x);
            iMax = Math.max(iMax, point.x);
            iMin2 = Math.min(iMin2, point.y);
            iMax2 = Math.max(iMax2, point.y);
        }
        return new Rect(iMin, iMin2, iMax, iMax2);
    }
}
