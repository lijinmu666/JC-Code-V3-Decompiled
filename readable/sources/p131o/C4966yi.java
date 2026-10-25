package p131o;

import org.bouncycastle.p133asn1.p174x509.DisplayText;

/* renamed from: o.yi */
/* loaded from: classes.dex */
public final class C4966yi extends AbstractC3595dy implements InterfaceC2404Ly {

    /* renamed from: zbb */
    private static final C4966yi f17572zbb;

    /* renamed from: zbd */
    private int f17573zbd;

    /* renamed from: zbg */
    private boolean f17576zbg;

    /* renamed from: zbo */
    private boolean f17584zbo;

    /* renamed from: zbe */
    private float f17574zbe = 0.05f;

    /* renamed from: zbf */
    private float f17575zbf = 0.5f;

    /* renamed from: zbh */
    private int f17577zbh = 10;

    /* renamed from: zbi */
    private int f17578zbi = DisplayText.DISPLAY_TEXT_MAXIMUM_SIZE;

    /* renamed from: zbj */
    private float f17579zbj = 0.8f;

    /* renamed from: zbk */
    private int f17580zbk = 4;

    /* renamed from: zbl */
    private int f17581zbl = 10;

    /* renamed from: zbm */
    private float f17582zbm = 0.2f;

    /* renamed from: zbn */
    private float f17583zbn = 0.1f;

    static {
        C4966yi c4966yi = new C4966yi();
        f17572zbb = c4966yi;
        AbstractC3595dy.m11753YoKzxo(C4966yi.class, c4966yi);
    }

    @Override // p131o.AbstractC3595dy
    /* renamed from: IEE */
    public final Object mo7631IEE(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return AbstractC3595dy.m11750ETF(f17572zbb, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0000\u0000\u0001ခ\u0000\u0002ခ\u0001\u0003င\u0003\u0004င\u0004\u0005င\u0006\u0006င\u0007\u0007ခ\b\bခ\t\tဇ\n\nခ\u0005\u000bဇ\u0002", new Object[]{"zbd", "zbe", "zbf", "zbh", "zbi", "zbk", "zbl", "zbm", "zbn", "zbo", "zbj", "zbg"});
        }
        if (i2 == 3) {
            return new C4966yi();
        }
        AbstractC4833wi abstractC4833wi = null;
        if (i2 == 4) {
            return new C4901xi(abstractC4833wi);
        }
        if (i2 != 5) {
            return null;
        }
        return f17572zbb;
    }
}
