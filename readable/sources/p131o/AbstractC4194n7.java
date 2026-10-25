package p131o;

import java.io.EOFException;
import java.io.IOException;

/* renamed from: o.n7 */
/* loaded from: classes.dex */
public abstract class AbstractC4194n7 {
    /* renamed from: AZxh */
    public static void m12849AZxh(AbstractC4187n0 abstractC4187n0, C1598A0 c1598a0) {
        AbstractC4000k9.f14453GMIER.mo3482write(c1598a0, abstractC4187n0);
    }

    /* renamed from: mjFkc */
    public static AbstractC4187n0 m12850mjFkc(C4587t0 c4587t0) {
        boolean z;
        try {
            try {
                c4587t0.mo13542CqaNbM();
                z = false;
                try {
                    return (AbstractC4187n0) AbstractC4000k9.f14453GMIER.mo3481read(c4587t0);
                } catch (EOFException e) {
                    e = e;
                    if (z) {
                        return C4318p0.f15892mjFkc;
                    }
                    throw new C4719v0(e);
                }
            } catch (EOFException e2) {
                e = e2;
                z = true;
            }
        } catch (IOException e3) {
            throw new C4252o0(e3);
        } catch (NumberFormatException e4) {
            throw new C4719v0(e4);
        } catch (C4854x1 e5) {
            throw new C4719v0(e5);
        }
    }
}
