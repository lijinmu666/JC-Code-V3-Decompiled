package p131o;

import java.util.Iterator;
import java.util.List;

/* renamed from: o.dq */
/* loaded from: classes.dex */
public abstract class AbstractC3587dq {
    /* renamed from: mjFkc */
    public static String m11746mjFkc(List list) {
        Iterator it = list.iterator();
        float fM13392OjSQV = 0.0f;
        String strM13391CqaNbM = "und";
        while (it.hasNext()) {
            C4495re c4495re = (C4495re) it.next();
            if (fM13392OjSQV < c4495re.m13392OjSQV()) {
                fM13392OjSQV = c4495re.m13392OjSQV();
                strM13391CqaNbM = c4495re.m13391CqaNbM();
            }
        }
        return strM13391CqaNbM;
    }
}
