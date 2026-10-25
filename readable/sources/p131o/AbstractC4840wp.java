package p131o;

import android.graphics.Matrix;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.RectF;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* renamed from: o.wp */
/* loaded from: classes.dex */
public abstract class AbstractC4840wp {
    /* renamed from: AZxh */
    public static C4312ov m13867AZxh(C3638ee c3638ee) {
        return c3638ee.m11857cMLeY() ? c3638ee.m11855Ne().m12243CqaNbM() : c3638ee.m11856OjSQV() ? c3638ee.m11858xrEuO().m11736OjSQV() : c3638ee.m11854CqaNbM();
    }

    /* renamed from: mjFkc */
    public static Rect m13868mjFkc(List list, Matrix matrix) {
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
        RectF rectF = new RectF(iMin, iMin2, iMax, iMax2);
        if (matrix != null) {
            matrix.mapRect(rectF);
        }
        Rect rect = new Rect();
        rectF.round(rect);
        return rect;
    }

    /* renamed from: wA */
    public static List m13869wA(C4312ov c4312ov) {
        double dSin = Math.sin(Math.toRadians(c4312ov.m13046OjSQV()));
        double dCos = Math.cos(Math.toRadians(c4312ov.m13046OjSQV()));
        Point point = new Point((int) (c4312ov.m13043CqaNbM() + (c4312ov.m13044KLMXS() * dCos)), (int) (c4312ov.m13047xrEuO() + (c4312ov.m13044KLMXS() * dSin)));
        double d = point.x;
        double dM13045Ne = c4312ov.m13045Ne() * dSin;
        double dM13045Ne2 = pointArr[1].y + (c4312ov.m13045Ne() * dCos);
        Point point2 = pointArr[0];
        int i = point2.x;
        Point point3 = pointArr[2];
        int i2 = point3.x;
        Point point4 = pointArr[1];
        Point[] pointArr = {new Point(c4312ov.m13043CqaNbM(), c4312ov.m13047xrEuO()), point, new Point((int) (d - dM13045Ne), (int) dM13045Ne2), new Point(i + (i2 - point4.x), point2.y + (point3.y - point4.y))};
        return Arrays.asList(pointArr);
    }
}
