package p131o;

import android.os.Parcelable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* renamed from: o.O9 */
/* loaded from: classes.dex */
public abstract class AbstractC2550O9 {

    /* renamed from: AZxh */
    public final C4633tjSezt f9918AZxh;

    /* renamed from: mjFkc */
    public final C4633tjSezt f9919mjFkc;

    /* renamed from: wA */
    public final C4633tjSezt f9920wA;

    public AbstractC2550O9(C4633tjSezt c4633tjSezt, C4633tjSezt c4633tjSezt2, C4633tjSezt c4633tjSezt3) {
        this.f9919mjFkc = c4633tjSezt;
        this.f9918AZxh = c4633tjSezt2;
        this.f9920wA = c4633tjSezt3;
    }

    /* renamed from: AZxh */
    public abstract AbstractC2550O9 mo9850AZxh();

    /* renamed from: BAnRFn */
    public void m9851BAnRFn(byte[] bArr, int i) {
        mo9875huTpC(i);
        mo9868VocHEe(bArr);
    }

    /* renamed from: CqaNbM */
    public void m9852CqaNbM(Parcelable parcelable, int i) {
        mo9875huTpC(i);
        mo9862Ne(parcelable);
    }

    /* renamed from: Dt */
    public byte[] m9853Dt(byte[] bArr, int i) {
        return !mo9861MiMN(i) ? bArr : mo9881qdMbNW();
    }

    /* renamed from: ETF */
    public abstract CharSequence mo9854ETF();

    /* renamed from: Gd */
    public void m9855Gd(boolean z, boolean z2) {
    }

    /* renamed from: HGpJ */
    public abstract void mo9856HGpJ(boolean z);

    /* renamed from: IEE */
    public Parcelable m9857IEE(Parcelable parcelable, int i) {
        return !mo9861MiMN(i) ? parcelable : mo9874fehf();
    }

    /* renamed from: JHa */
    public boolean m9858JHa() {
        return false;
    }

    /* renamed from: KLFTb */
    public final Method m9859KLFTb(Class cls) throws NoSuchMethodException, ClassNotFoundException, SecurityException {
        Method method = (Method) this.f9918AZxh.m10817get(cls.getName());
        if (method != null) {
            return method;
        }
        Class clsM9885wA = m9885wA(cls);
        System.currentTimeMillis();
        Method declaredMethod = clsM9885wA.getDeclaredMethod("write", cls, AbstractC2550O9.class);
        this.f9918AZxh.m10821put(cls.getName(), declaredMethod);
        return declaredMethod;
    }

    /* renamed from: KLMXS */
    public void m9860KLMXS(String str, int i) {
        mo9875huTpC(i);
        mo9888xrEuO(str);
    }

    /* renamed from: MiMN */
    public abstract boolean mo9861MiMN(int i);

    /* renamed from: Ne */
    public abstract void mo9862Ne(Parcelable parcelable);

    /* renamed from: OjSQV */
    public void m9863OjSQV(int i, int i2) {
        mo9875huTpC(i2);
        mo9878mByQ(i);
    }

    /* renamed from: Pq */
    public abstract String mo9864Pq();

    /* renamed from: Ucbh */
    public InterfaceC2677Q9 m9865Ucbh(InterfaceC2677Q9 interfaceC2677Q9, int i) {
        return !mo9861MiMN(i) ? interfaceC2677Q9 : m9873eyqo();
    }

    /* renamed from: VA */
    public CharSequence m9866VA(CharSequence charSequence, int i) {
        return !mo9861MiMN(i) ? charSequence : mo9854ETF();
    }

    /* renamed from: Vnb */
    public final void m9867Vnb(InterfaceC2677Q9 interfaceC2677Q9) {
        try {
            mo9888xrEuO(m9885wA(interfaceC2677Q9.getClass()).getName());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(interfaceC2677Q9.getClass().getSimpleName() + " does not have a Parcelizer", e);
        }
    }

    /* renamed from: VocHEe */
    public abstract void mo9868VocHEe(byte[] bArr);

    /* renamed from: YoKzxo */
    public InterfaceC2677Q9 m9869YoKzxo(String str, AbstractC2550O9 abstractC2550O9) {
        try {
            return (InterfaceC2677Q9) m9870ZfxDd(str).invoke(null, abstractC2550O9);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (e4.getCause() instanceof RuntimeException) {
                throw ((RuntimeException) e4.getCause());
            }
            throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
        }
    }

    /* renamed from: ZfxDd */
    public final Method m9870ZfxDd(String str) throws NoSuchMethodException, SecurityException {
        Method method = (Method) this.f9919mjFkc.m10817get(str);
        if (method != null) {
            return method;
        }
        System.currentTimeMillis();
        Method declaredMethod = Class.forName(str, true, AbstractC2550O9.class.getClassLoader()).getDeclaredMethod("read", AbstractC2550O9.class);
        this.f9919mjFkc.m10821put(str, declaredMethod);
        return declaredMethod;
    }

    /* renamed from: cMLeY */
    public void m9871cMLeY(InterfaceC2677Q9 interfaceC2677Q9) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        if (interfaceC2677Q9 == null) {
            mo9888xrEuO(null);
            return;
        }
        m9867Vnb(interfaceC2677Q9);
        AbstractC2550O9 abstractC2550O9Mo9850AZxh = mo9850AZxh();
        m9889zvd(interfaceC2677Q9, abstractC2550O9Mo9850AZxh);
        abstractC2550O9Mo9850AZxh.mo9879mjFkc();
    }

    /* renamed from: diqgf */
    public String m9872diqgf(String str, int i) {
        return !mo9861MiMN(i) ? str : mo9864Pq();
    }

    /* renamed from: eyqo */
    public InterfaceC2677Q9 m9873eyqo() {
        String strMo9864Pq = mo9864Pq();
        if (strMo9864Pq == null) {
            return null;
        }
        return m9869YoKzxo(strMo9864Pq, mo9850AZxh());
    }

    /* renamed from: fehf */
    public abstract Parcelable mo9874fehf();

    /* renamed from: huTpC */
    public abstract void mo9875huTpC(int i);

    /* renamed from: lB */
    public abstract void mo9876lB(CharSequence charSequence);

    /* renamed from: lgHUyS */
    public boolean m9877lgHUyS(boolean z, int i) {
        return !mo9861MiMN(i) ? z : mo9887xJ();
    }

    /* renamed from: mByQ */
    public abstract void mo9878mByQ(int i);

    /* renamed from: mjFkc */
    public abstract void mo9879mjFkc();

    /* renamed from: qGY */
    public int m9880qGY(int i, int i2) {
        return !mo9861MiMN(i2) ? i : mo9883rkYL();
    }

    /* renamed from: qdMbNW */
    public abstract byte[] mo9881qdMbNW();

    /* renamed from: rWxwaT */
    public void m9882rWxwaT(InterfaceC2677Q9 interfaceC2677Q9, int i) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        mo9875huTpC(i);
        m9871cMLeY(interfaceC2677Q9);
    }

    /* renamed from: rkYL */
    public abstract int mo9883rkYL();

    /* renamed from: vI */
    public void m9884vI(boolean z, int i) {
        mo9875huTpC(i);
        mo9856HGpJ(z);
    }

    /* renamed from: wA */
    public final Class m9885wA(Class cls) throws ClassNotFoundException {
        Class cls2 = (Class) this.f9920wA.m10817get(cls.getName());
        if (cls2 != null) {
            return cls2;
        }
        Class<?> cls3 = Class.forName(String.format("%s.%sParcelizer", cls.getPackage().getName(), cls.getSimpleName()), false, cls.getClassLoader());
        this.f9920wA.m10821put(cls.getName(), cls3);
        return cls3;
    }

    /* renamed from: wJVbdd */
    public void m9886wJVbdd(CharSequence charSequence, int i) {
        mo9875huTpC(i);
        mo9876lB(charSequence);
    }

    /* renamed from: xJ */
    public abstract boolean mo9887xJ();

    /* renamed from: xrEuO */
    public abstract void mo9888xrEuO(String str);

    /* renamed from: zvd */
    public void m9889zvd(InterfaceC2677Q9 interfaceC2677Q9, AbstractC2550O9 abstractC2550O9) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            m9859KLFTb(interfaceC2677Q9.getClass()).invoke(null, interfaceC2677Q9, abstractC2550O9);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("VersionedParcel encountered ClassNotFoundException", e);
        } catch (IllegalAccessException e2) {
            throw new RuntimeException("VersionedParcel encountered IllegalAccessException", e2);
        } catch (NoSuchMethodException e3) {
            throw new RuntimeException("VersionedParcel encountered NoSuchMethodException", e3);
        } catch (InvocationTargetException e4) {
            if (!(e4.getCause() instanceof RuntimeException)) {
                throw new RuntimeException("VersionedParcel encountered InvocationTargetException", e4);
            }
            throw ((RuntimeException) e4.getCause());
        }
    }
}
