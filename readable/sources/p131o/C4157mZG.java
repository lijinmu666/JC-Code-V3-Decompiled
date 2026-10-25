package p131o;

import java.util.Arrays;
import java.util.List;

/* renamed from: o.mZG */
/* loaded from: classes.dex */
public class C4157mZG extends C2269JtIAgM {

    /* renamed from: mjFkc */
    public final List f15199mjFkc;

    public C4157mZG(List list) {
        super("Dependency cycle detected: " + Arrays.toString(list.toArray()));
        this.f15199mjFkc = list;
    }
}
