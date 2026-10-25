package p131o;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: o.dy */
/* loaded from: classes.dex */
public abstract class AbstractC3595dy extends AbstractC3657ex {

    /* renamed from: zbb */
    private static final Map f13417zbb = new ConcurrentHashMap();

    /* renamed from: zbd */
    private int f13419zbd = -1;

    /* renamed from: zbc */
    protected C4055kz f13418zbc = C4055kz.m12635wA();

    /* renamed from: BAnRFn */
    public static InterfaceC3988jy m11749BAnRFn() {
        return C3658ey.m11867JHa();
    }

    /* renamed from: ETF */
    public static Object m11750ETF(InterfaceC2341Ky interfaceC2341Ky, String str, Object[] objArr) {
        return new C2926Ty(interfaceC2341Ky, str, objArr);
    }

    /* renamed from: Gd */
    public static AbstractC3595dy m11751Gd(Class cls) throws ClassNotFoundException {
        Map map = f13417zbb;
        AbstractC3595dy abstractC3595dy = (AbstractC3595dy) map.get(cls);
        if (abstractC3595dy == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                abstractC3595dy = (AbstractC3595dy) map.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (abstractC3595dy == null) {
            abstractC3595dy = (AbstractC3595dy) ((AbstractC3595dy) AbstractC4518rz.m13404Dt(cls)).mo7631IEE(6, null, null);
            if (abstractC3595dy == null) {
                throw new IllegalStateException();
            }
            map.put(cls, abstractC3595dy);
        }
        return abstractC3595dy;
    }

    /* renamed from: VocHEe */
    public static InterfaceC3917iy m11752VocHEe() {
        return C2795Rx.m10110JHa();
    }

    /* renamed from: YoKzxo */
    public static void m11753YoKzxo(Class cls, AbstractC3595dy abstractC3595dy) {
        abstractC3595dy.m11762MiMN();
        f13417zbb.put(cls, abstractC3595dy);
    }

    /* renamed from: diqgf */
    public static AbstractC3595dy m11754diqgf(AbstractC3595dy abstractC3595dy, byte[] bArr, int i, int i2, C2340Kx c2340Kx) throws C4315oy {
        if (i2 == 0) {
            return abstractC3595dy;
        }
        AbstractC3595dy abstractC3595dyM11761HGpJ = abstractC3595dy.m11761HGpJ();
        try {
            InterfaceC2998Uy interfaceC2998UyM10117AZxh = C2796Ry.m10116mjFkc().m10117AZxh(abstractC3595dyM11761HGpJ.getClass());
            interfaceC2998UyM10117AZxh.mo9755KLFTb(abstractC3595dyM11761HGpJ, bArr, 0, i2, new C4117lx(c2340Kx));
            interfaceC2998UyM10117AZxh.mo9768lgHUyS(abstractC3595dyM11761HGpJ);
            return abstractC3595dyM11761HGpJ;
        } catch (IndexOutOfBoundsException unused) {
            throw new C4315oy("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
        } catch (C4315oy e) {
            throw e;
        } catch (IOException e2) {
            if (e2.getCause() instanceof C4315oy) {
                throw ((C4315oy) e2.getCause());
            }
            throw new C4315oy(e2);
        } catch (C3918iz e3) {
            throw e3.m12323mjFkc();
        }
    }

    /* renamed from: huTpC */
    public static C3531cy m11755huTpC(InterfaceC2341Ky interfaceC2341Ky, Object obj, InterfaceC2341Ky interfaceC2341Ky2, InterfaceC3724fy interfaceC3724fy, int i, EnumC4784vz enumC4784vz, Class cls) {
        return new C3531cy(interfaceC2341Ky, obj, interfaceC2341Ky2, new C3399ay(null, 32149011, enumC4784vz, false, false), cls);
    }

    /* renamed from: lB */
    public static InterfaceC4054ky m11756lB() {
        return C4982yy.m14056JHa();
    }

    /* renamed from: mByQ */
    public static Object m11757mByQ(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            }
            if (cause instanceof Error) {
                throw ((Error) cause);
            }
            throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
        }
    }

    /* renamed from: qGY */
    public static final boolean m11758qGY(AbstractC3595dy abstractC3595dy, boolean z) {
        byte bByteValue = ((Byte) abstractC3595dy.mo7631IEE(1, null, null)).byteValue();
        if (bByteValue == 1) {
            return true;
        }
        if (bByteValue == 0) {
            return false;
        }
        boolean zMo9765ZfxDd = C2796Ry.m10116mjFkc().m10117AZxh(abstractC3595dy.getClass()).mo9765ZfxDd(abstractC3595dy);
        if (z) {
            abstractC3595dy.mo7631IEE(2, true != zMo9765ZfxDd ? null : abstractC3595dy, null);
        }
        return zMo9765ZfxDd;
    }

    /* renamed from: vI */
    public static AbstractC3595dy m11759vI(AbstractC3595dy abstractC3595dy, byte[] bArr, C2340Kx c2340Kx) throws C4315oy {
        AbstractC3595dy abstractC3595dyM11754diqgf = m11754diqgf(abstractC3595dy, bArr, 0, bArr.length, c2340Kx);
        if (abstractC3595dyM11754diqgf == null || m11758qGY(abstractC3595dyM11754diqgf, true)) {
            return abstractC3595dyM11754diqgf;
        }
        throw new C3918iz(abstractC3595dyM11754diqgf).m12323mjFkc();
    }

    /* renamed from: wJVbdd */
    public static InterfaceC4118ly m11760wJVbdd() {
        return C2864Sy.m10207ZfxDd();
    }

    @Override // p131o.InterfaceC2341Ky
    /* renamed from: AZxh */
    public final void mo9293AZxh(AbstractC2063Gx abstractC2063Gx) {
        C2796Ry.m10116mjFkc().m10117AZxh(getClass()).mo9771qdMbNW(this, C2131Hx.m8592rWxwaT(abstractC2063Gx));
    }

    /* renamed from: HGpJ */
    public final AbstractC3595dy m11761HGpJ() {
        return (AbstractC3595dy) mo7631IEE(4, null, null);
    }

    /* renamed from: IEE */
    public abstract Object mo7631IEE(int i, Object obj, Object obj2);

    @Override // p131o.InterfaceC2341Ky
    /* renamed from: JHa */
    public final /* synthetic */ InterfaceC2274Jy mo9294JHa() {
        AbstractC3063Vx abstractC3063Vx = (AbstractC3063Vx) mo7631IEE(5, null, null);
        abstractC3063Vx.m10738ETF(this);
        return abstractC3063Vx;
    }

    @Override // p131o.InterfaceC2341Ky
    /* renamed from: KLFTb */
    public final /* synthetic */ InterfaceC2274Jy mo9295KLFTb() {
        return (AbstractC3063Vx) mo7631IEE(5, null, null);
    }

    /* renamed from: MiMN */
    public final void m11762MiMN() {
        this.f13419zbd &= Integer.MAX_VALUE;
    }

    /* renamed from: Pq */
    public final int m11763Pq(InterfaceC2998Uy interfaceC2998Uy) {
        return C2796Ry.m10116mjFkc().m10117AZxh(getClass()).mo9769mjFkc(this);
    }

    /* renamed from: Ucbh */
    public final AbstractC3063Vx m11764Ucbh() {
        return (AbstractC3063Vx) mo7631IEE(5, null, null);
    }

    /* renamed from: VA */
    public final void m11765VA() {
        C2796Ry.m10116mjFkc().m10117AZxh(getClass()).mo9768lgHUyS(this);
        m11762MiMN();
    }

    /* renamed from: equals */
    public final boolean m11766equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return C2796Ry.m10116mjFkc().m10117AZxh(getClass()).mo9775wA(this, (AbstractC3595dy) obj);
    }

    /* renamed from: eyqo */
    public final int m11767eyqo() {
        return C2796Ry.m10116mjFkc().m10117AZxh(getClass()).mo9754JHa(this);
    }

    /* renamed from: fehf */
    public final boolean m11768fehf() {
        return (this.f13419zbd & Integer.MIN_VALUE) != 0;
    }

    public final int hashCode() {
        if (m11768fehf()) {
            return m11767eyqo();
        }
        int i = this.f13508zba;
        if (i != 0) {
            return i;
        }
        int iM11767eyqo = m11767eyqo();
        this.f13508zba = iM11767eyqo;
        return iM11767eyqo;
    }

    @Override // p131o.InterfaceC2404Ly
    /* renamed from: lgHUyS */
    public final /* synthetic */ InterfaceC2341Ky mo9399lgHUyS() {
        return (AbstractC3595dy) mo7631IEE(6, null, null);
    }

    @Override // p131o.InterfaceC2341Ky
    /* renamed from: mjFkc */
    public final int mo9296mjFkc() {
        if (m11768fehf()) {
            int iM11763Pq = m11763Pq(null);
            if (iM11763Pq >= 0) {
                return iM11763Pq;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iM11763Pq);
        }
        int iM11763Pq2 = this.f13419zbd & Integer.MAX_VALUE;
        if (iM11763Pq2 == Integer.MAX_VALUE) {
            iM11763Pq2 = m11763Pq(null);
            if (iM11763Pq2 < 0) {
                throw new IllegalStateException("serialized size must be non-negative, was " + iM11763Pq2);
            }
            this.f13419zbd = (this.f13419zbd & Integer.MIN_VALUE) | iM11763Pq2;
        }
        return iM11763Pq2;
    }

    @Override // p131o.AbstractC3657ex
    /* renamed from: qdMbNW */
    public final int mo11769qdMbNW(InterfaceC2998Uy interfaceC2998Uy) {
        if (m11768fehf()) {
            int iMo9769mjFkc = interfaceC2998Uy.mo9769mjFkc(this);
            if (iMo9769mjFkc >= 0) {
                return iMo9769mjFkc;
            }
            throw new IllegalStateException("serialized size must be non-negative, was " + iMo9769mjFkc);
        }
        int i = this.f13419zbd & Integer.MAX_VALUE;
        if (i != Integer.MAX_VALUE) {
            return i;
        }
        int iMo9769mjFkc2 = interfaceC2998Uy.mo9769mjFkc(this);
        if (iMo9769mjFkc2 >= 0) {
            this.f13419zbd = (this.f13419zbd & Integer.MIN_VALUE) | iMo9769mjFkc2;
            return iMo9769mjFkc2;
        }
        throw new IllegalStateException("serialized size must be non-negative, was " + iMo9769mjFkc2);
    }

    /* renamed from: rkYL */
    public final void m11770rkYL(int i) {
        this.f13419zbd = (this.f13419zbd & Integer.MIN_VALUE) | Integer.MAX_VALUE;
    }

    public final String toString() {
        return AbstractC2474My.m9564mjFkc(this, super.toString());
    }

    @Override // p131o.InterfaceC2404Ly
    /* renamed from: wA */
    public final boolean mo9400wA() {
        return m11758qGY(this, true);
    }
}
