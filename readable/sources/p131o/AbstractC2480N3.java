package p131o;

import android.util.SparseArray;
import java.util.HashMap;

/* renamed from: o.N3 */
/* loaded from: classes.dex */
public abstract class AbstractC2480N3 {

    /* renamed from: AZxh */
    public static HashMap f9633AZxh;

    /* renamed from: mjFkc */
    public static SparseArray f9634mjFkc = new SparseArray();

    static {
        HashMap map = new HashMap();
        f9633AZxh = map;
        map.put(EnumC2347L3.DEFAULT, 0);
        f9633AZxh.put(EnumC2347L3.VERY_LOW, 1);
        f9633AZxh.put(EnumC2347L3.HIGHEST, 2);
        for (EnumC2347L3 enumC2347L3 : f9633AZxh.keySet()) {
            f9634mjFkc.append(((Integer) f9633AZxh.get(enumC2347L3)).intValue(), enumC2347L3);
        }
    }

    /* renamed from: AZxh */
    public static EnumC2347L3 m9583AZxh(int i) {
        EnumC2347L3 enumC2347L3 = (EnumC2347L3) f9634mjFkc.get(i);
        if (enumC2347L3 != null) {
            return enumC2347L3;
        }
        throw new IllegalArgumentException("Unknown Priority for value " + i);
    }

    /* renamed from: mjFkc */
    public static int m9584mjFkc(EnumC2347L3 enumC2347L3) {
        Integer num = (Integer) f9633AZxh.get(enumC2347L3);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalStateException("PriorityMapping is missing known Priority value " + enumC2347L3);
    }
}
