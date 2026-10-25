package p131o;

import java.util.logging.Level;
import java.util.logging.Logger;

/* renamed from: o.Gx */
/* loaded from: classes.dex */
public abstract class AbstractC2063Gx extends AbstractC4247nx {

    /* renamed from: AZxh */
    public static final Logger f8462AZxh = Logger.getLogger(AbstractC2063Gx.class.getName());

    /* renamed from: wA */
    public static final boolean f8463wA = AbstractC4518rz.m13422lB();

    /* renamed from: mjFkc */
    public C2131Hx f8464mjFkc;

    public /* synthetic */ AbstractC2063Gx(AbstractC1998Fx abstractC1998Fx) {
    }

    /* renamed from: AZxh */
    public static int m8467AZxh(InterfaceC2341Ky interfaceC2341Ky, InterfaceC2998Uy interfaceC2998Uy) {
        int iMo11769qdMbNW = ((AbstractC3657ex) interfaceC2341Ky).mo11769qdMbNW(interfaceC2998Uy);
        return m8470ZfxDd(iMo11769qdMbNW) + iMo11769qdMbNW;
    }

    /* renamed from: KLFTb */
    public static int m8468KLFTb(long j) {
        return (640 - (Long.numberOfLeadingZeros(j) * 9)) >>> 6;
    }

    /* renamed from: Ne */
    public static int m8469Ne(int i, InterfaceC2341Ky interfaceC2341Ky, InterfaceC2998Uy interfaceC2998Uy) {
        int iM8470ZfxDd = m8470ZfxDd(i << 3);
        return iM8470ZfxDd + iM8470ZfxDd + ((AbstractC3657ex) interfaceC2341Ky).mo11769qdMbNW(interfaceC2998Uy);
    }

    /* renamed from: ZfxDd */
    public static int m8470ZfxDd(int i) {
        return (352 - (Integer.numberOfLeadingZeros(i) * 9)) >>> 6;
    }

    /* renamed from: mjFkc */
    public static int m8472mjFkc(InterfaceC2341Ky interfaceC2341Ky) {
        int iMo9296mjFkc = interfaceC2341Ky.mo9296mjFkc();
        return m8470ZfxDd(iMo9296mjFkc) + iMo9296mjFkc;
    }

    /* renamed from: wA */
    public static int m8473wA(String str) {
        int length;
        try {
            length = AbstractC4717uz.m13740wA(str);
        } catch (C4652tz unused) {
            length = str.getBytes(AbstractC4183my.f15287mjFkc).length;
        }
        return m8470ZfxDd(length) + length;
    }

    /* renamed from: BAnRFn */
    public abstract void mo8066BAnRFn(int i, int i2);

    /* renamed from: Dt */
    public abstract void mo8068Dt(byte b);

    /* renamed from: ETF */
    public abstract void mo8069ETF(int i, boolean z);

    /* renamed from: Gd */
    public abstract void mo8070Gd(int i, InterfaceC2341Ky interfaceC2341Ky);

    /* renamed from: HGpJ */
    public abstract void mo8071HGpJ(int i, AbstractC4981yx abstractC4981yx);

    /* renamed from: IEE */
    public abstract void mo8072IEE(long j);

    /* renamed from: JHa */
    public final void m8474JHa() {
        if (mo8087qdMbNW() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    /* renamed from: MiMN */
    public abstract void mo8073MiMN(int i, AbstractC4981yx abstractC4981yx);

    /* renamed from: OjSQV */
    public abstract void mo8074OjSQV(long j);

    /* renamed from: Pq */
    public abstract void mo8075Pq(int i, int i2);

    /* renamed from: Ucbh */
    public abstract void mo8076Ucbh(int i, InterfaceC2341Ky interfaceC2341Ky, InterfaceC2998Uy interfaceC2998Uy);

    /* renamed from: VA */
    public abstract void mo8077VA(byte[] bArr, int i, int i2);

    /* renamed from: VocHEe */
    public abstract void mo8078VocHEe(String str);

    /* renamed from: YoKzxo */
    public abstract void mo8079YoKzxo(AbstractC4981yx abstractC4981yx);

    /* renamed from: diqgf */
    public abstract void mo8080diqgf(int i);

    /* renamed from: eyqo */
    public abstract void mo8081eyqo(byte[] bArr, int i, int i2);

    /* renamed from: fehf */
    public abstract void mo8082fehf(int i, long j);

    /* renamed from: huTpC */
    public abstract void mo8083huTpC(InterfaceC2341Ky interfaceC2341Ky);

    /* renamed from: lB */
    public abstract void mo8084lB(int i, int i2);

    /* renamed from: mByQ */
    public abstract void mo8085mByQ(int i, long j);

    /* renamed from: qGY */
    public abstract void mo8086qGY(int i);

    /* renamed from: qdMbNW */
    public abstract int mo8087qdMbNW();

    /* renamed from: rkYL */
    public abstract void mo8088rkYL(int i, int i2);

    /* renamed from: vI */
    public abstract void mo8089vI(int i, String str);

    /* renamed from: wJVbdd */
    public abstract void mo8090wJVbdd(int i);

    /* renamed from: xJ */
    public final void m8475xJ(String str, C4652tz c4652tz) throws C1926Ex {
        f8462AZxh.logp(Level.WARNING, "com.google.protobuf.CodedOutputStream", "inefficientWriteStringNoTag", "Converting ill-formed UTF-16. Your Protocol Buffer will not round trip correctly!", (Throwable) c4652tz);
        byte[] bytes = str.getBytes(AbstractC4183my.f15287mjFkc);
        try {
            int length = bytes.length;
            mo8090wJVbdd(length);
            mo8081eyqo(bytes, 0, length);
        } catch (IndexOutOfBoundsException e) {
            throw new C1926Ex(e);
        }
    }
}
