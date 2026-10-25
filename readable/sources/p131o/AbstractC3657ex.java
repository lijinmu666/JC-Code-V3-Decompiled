package p131o;

import java.io.IOException;

/* renamed from: o.ex */
/* loaded from: classes.dex */
public abstract class AbstractC3657ex implements InterfaceC2341Ky {

    /* renamed from: zba */
    protected int f13508zba = 0;

    /* renamed from: Dt */
    public final byte[] m11866Dt() {
        try {
            int iMo9296mjFkc = mo9296mjFkc();
            byte[] bArr = new byte[iMo9296mjFkc];
            C1856Dx c1856Dx = new C1856Dx(bArr, 0, iMo9296mjFkc);
            mo9293AZxh(c1856Dx);
            c1856Dx.m8474JHa();
            return bArr;
        } catch (IOException e) {
            throw new RuntimeException("Serializing " + getClass().getName() + " to a byte array threw an IOException (should never happen).", e);
        }
    }

    /* renamed from: qdMbNW */
    public abstract int mo11769qdMbNW(InterfaceC2998Uy interfaceC2998Uy);
}
