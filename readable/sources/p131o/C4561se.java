package p131o;

import java.util.List;

/* renamed from: o.se */
/* loaded from: classes.dex */
public final class C4561se extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4561se f16530zbb;

    /* renamed from: zbe */
    private byte f16532zbe = 2;

    /* renamed from: zbd */
    private InterfaceC4118ly f16531zbd = AbstractC3595dy.m11760wJVbdd();

    static {
        C4561se c4561se = new C4561se();
        f16530zbb = c4561se;
        AbstractC3595dy.m11753YoKzxo(C4561se.class, c4561se);
    }

    /* renamed from: Ne */
    public static C4561se m13518Ne() {
        return f16530zbb;
    }

    /* renamed from: CqaNbM */
    public final List m13520CqaNbM() {
        return this.f16531zbd;
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.f16532zbe);
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f16530zbb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0001\u0001Л", new Object[]{"zbd", C4495re.class});
        }
        if (i2 == 3) {
            return new C4561se();
        }
        AbstractC3240Yd abstractC3240Yd = null;
        if (i2 == 4) {
            return new C4360pe(abstractC3240Yd);
        }
        if (i2 == 5) {
            return f16530zbb;
        }
        this.f16532zbe = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
