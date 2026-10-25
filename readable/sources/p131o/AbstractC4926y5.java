package p131o;

/* renamed from: o.y5 */
/* loaded from: classes.dex */
public abstract class AbstractC4926y5 {
    /* renamed from: mjFkc */
    public static Object m13993mjFkc(int i, Object obj, InterfaceC2837SbhK interfaceC2837SbhK, InterfaceC4990z5 interfaceC4990z5) {
        Object objMo10156apply;
        if (i < 1) {
            return interfaceC2837SbhK.mo10156apply(obj);
        }
        do {
            objMo10156apply = interfaceC2837SbhK.mo10156apply(obj);
            obj = interfaceC4990z5.mo13653mjFkc(obj, objMo10156apply);
            if (obj == null) {
                break;
            }
            i--;
        } while (i >= 1);
        return objMo10156apply;
    }
}
