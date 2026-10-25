package p131o;

import java.nio.ByteBuffer;

/* renamed from: o.Or */
/* loaded from: classes.dex */
public abstract class AbstractC2594Or {
    /* renamed from: AZxh */
    public static int m9909AZxh(int i) {
        if (i == 1) {
            return 4;
        }
        if (i != 2) {
            return i != 3 ? 1 : 2;
        }
        return 3;
    }

    /* renamed from: mjFkc */
    public static C4235nl m9910mjFkc(ByteBuffer byteBuffer, C1923Eu c1923Eu) {
        C4104ll c4104ll = new C4104ll();
        c4104ll.m12708mjFkc(byteBuffer.array());
        c4104ll.m12705JHa(m9909AZxh(c1923Eu.m8232wA()));
        c4104ll.m12704AZxh(new C2913Tm(c1923Eu.m8230ZfxDd(), c1923Eu.m8231mjFkc()));
        c4104ll.m12709wA(c1923Eu.m8229JHa() * 1000);
        c4104ll.m12706KLFTb(2);
        return c4104ll.m12707ZfxDd();
    }
}
