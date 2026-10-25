package p131o;

import android.util.SparseArray;

/* renamed from: o.c4 */
/* loaded from: classes.dex */
public enum EnumC3473c4 {
    DEFAULT(0),
    UNMETERED_ONLY(1),
    UNMETERED_OR_DAILY(2),
    FAST_IF_RADIO_AWAKE(3),
    NEVER(4),
    UNRECOGNIZED(-1);


    /* renamed from: lgHUyS */
    public static final SparseArray f13199lgHUyS;

    /* renamed from: mjFkc */
    public final int f13203mjFkc;

    static {
        EnumC3473c4 enumC3473c4 = DEFAULT;
        EnumC3473c4 enumC3473c42 = UNMETERED_ONLY;
        EnumC3473c4 enumC3473c43 = UNMETERED_OR_DAILY;
        EnumC3473c4 enumC3473c44 = FAST_IF_RADIO_AWAKE;
        EnumC3473c4 enumC3473c45 = NEVER;
        EnumC3473c4 enumC3473c46 = UNRECOGNIZED;
        SparseArray sparseArray = new SparseArray();
        f13199lgHUyS = sparseArray;
        sparseArray.put(0, enumC3473c4);
        sparseArray.put(1, enumC3473c42);
        sparseArray.put(2, enumC3473c43);
        sparseArray.put(3, enumC3473c44);
        sparseArray.put(4, enumC3473c45);
        sparseArray.put(-1, enumC3473c46);
    }

    EnumC3473c4(int i) {
        this.f13203mjFkc = i;
    }
}
