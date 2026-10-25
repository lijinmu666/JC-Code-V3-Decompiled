package p131o;

import java.util.HashSet;
import java.util.Iterator;
import p131o.C3274Z6;

/* renamed from: o.qtZIjO */
/* loaded from: classes.dex */
public class C4446qtZIjO {

    /* renamed from: AZxh */
    public final C3776gjvQ f16245AZxh;

    /* renamed from: ZfxDd */
    public C4446qtZIjO f16248ZfxDd;

    /* renamed from: wA */
    public final AZxh f16250wA;

    /* renamed from: xJ */
    public C3274Z6 f16251xJ;

    /* renamed from: mjFkc */
    public HashSet f16249mjFkc = null;

    /* renamed from: KLFTb */
    public int f16247KLFTb = 0;

    /* renamed from: JHa */
    public int f16246JHa = -1;

    /* renamed from: o.qtZIjO$AZxh */
    public enum AZxh {
        NONE,
        LEFT,
        TOP,
        RIGHT,
        BOTTOM,
        BASELINE,
        CENTER,
        CENTER_X,
        CENTER_Y
    }

    /* renamed from: o.qtZIjO$mjFkc */
    public static /* synthetic */ class mjFkc {

        /* renamed from: mjFkc */
        public static final /* synthetic */ int[] f16262mjFkc;

        static {
            int[] iArr = new int[AZxh.m13324values().length];
            f16262mjFkc = iArr;
            try {
                iArr[AZxh.CENTER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f16262mjFkc[AZxh.LEFT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f16262mjFkc[AZxh.RIGHT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f16262mjFkc[AZxh.TOP.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f16262mjFkc[AZxh.BOTTOM.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f16262mjFkc[AZxh.BASELINE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f16262mjFkc[AZxh.CENTER_X.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f16262mjFkc[AZxh.CENTER_Y.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f16262mjFkc[AZxh.NONE.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    public C4446qtZIjO(C3776gjvQ c3776gjvQ, AZxh aZxh) {
        this.f16245AZxh = c3776gjvQ;
        this.f16250wA = aZxh;
    }

    /* renamed from: AZxh */
    public boolean m13309AZxh(C4446qtZIjO c4446qtZIjO, int i, int i2, boolean z) {
        if (c4446qtZIjO == null) {
            m13315VA();
            return true;
        }
        if (!z && !m13311ETF(c4446qtZIjO)) {
            return false;
        }
        this.f16248ZfxDd = c4446qtZIjO;
        if (c4446qtZIjO.f16249mjFkc == null) {
            c4446qtZIjO.f16249mjFkc = new HashSet();
        }
        this.f16248ZfxDd.f16249mjFkc.add(this);
        if (i > 0) {
            this.f16247KLFTb = i;
        } else {
            this.f16247KLFTb = 0;
        }
        this.f16246JHa = i2;
        return true;
    }

    /* renamed from: Dt */
    public boolean m13310Dt() {
        return this.f16248ZfxDd != null;
    }

    /* renamed from: ETF */
    public boolean m13311ETF(C4446qtZIjO c4446qtZIjO) {
        if (c4446qtZIjO == null) {
            return false;
        }
        AZxh aZxhM13318lgHUyS = c4446qtZIjO.m13318lgHUyS();
        AZxh aZxh = this.f16250wA;
        if (aZxhM13318lgHUyS == aZxh) {
            return aZxh != AZxh.BASELINE || (c4446qtZIjO.m13313KLFTb().m12057WrLQs() && m13313KLFTb().m12057WrLQs());
        }
        switch (mjFkc.f16262mjFkc[aZxh.ordinal()]) {
            case 1:
                return (aZxhM13318lgHUyS == AZxh.BASELINE || aZxhM13318lgHUyS == AZxh.CENTER_X || aZxhM13318lgHUyS == AZxh.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z = aZxhM13318lgHUyS == AZxh.LEFT || aZxhM13318lgHUyS == AZxh.RIGHT;
                if (c4446qtZIjO.m13313KLFTb() instanceof C4186n) {
                    return z || aZxhM13318lgHUyS == AZxh.CENTER_X;
                }
                return z;
            case 4:
            case 5:
                boolean z2 = aZxhM13318lgHUyS == AZxh.TOP || aZxhM13318lgHUyS == AZxh.BOTTOM;
                if (c4446qtZIjO.m13313KLFTb() instanceof C4186n) {
                    return z2 || aZxhM13318lgHUyS == AZxh.CENTER_Y;
                }
                return z2;
            case 6:
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(this.f16250wA.name());
        }
    }

    /* renamed from: JHa */
    public C3274Z6 m13312JHa() {
        return this.f16251xJ;
    }

    /* renamed from: KLFTb */
    public C3776gjvQ m13313KLFTb() {
        return this.f16245AZxh;
    }

    /* renamed from: MiMN */
    public void m13314MiMN(C2768RWyiuY c2768RWyiuY) {
        C3274Z6 c3274z6 = this.f16251xJ;
        if (c3274z6 == null) {
            this.f16251xJ = new C3274Z6(C3274Z6.mjFkc.UNRESTRICTED, null);
        } else {
            c3274z6.m11177ZfxDd();
        }
    }

    /* renamed from: VA */
    public void m13315VA() {
        HashSet hashSet;
        C4446qtZIjO c4446qtZIjO = this.f16248ZfxDd;
        if (c4446qtZIjO != null && (hashSet = c4446qtZIjO.f16249mjFkc) != null) {
            hashSet.remove(this);
        }
        this.f16248ZfxDd = null;
        this.f16247KLFTb = 0;
        this.f16246JHa = -1;
    }

    /* renamed from: YoKzxo */
    public void m13316YoKzxo(int i) {
        if (m13310Dt()) {
            this.f16246JHa = i;
        }
    }

    /* renamed from: ZfxDd */
    public final C4446qtZIjO m13317ZfxDd() {
        switch (mjFkc.f16262mjFkc[this.f16250wA.ordinal()]) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return this.f16245AZxh.f13829wJVbdd;
            case 3:
                return this.f16245AZxh.f13764BAnRFn;
            case 4:
                return this.f16245AZxh.f13815mByQ;
            case 5:
                return this.f16245AZxh.f13813lB;
            default:
                throw new AssertionError(this.f16250wA.name());
        }
    }

    /* renamed from: lgHUyS */
    public AZxh m13318lgHUyS() {
        return this.f16250wA;
    }

    /* renamed from: mjFkc */
    public boolean m13319mjFkc(C4446qtZIjO c4446qtZIjO, int i) {
        return m13309AZxh(c4446qtZIjO, i, -1, false);
    }

    /* renamed from: qdMbNW */
    public boolean m13320qdMbNW() {
        HashSet hashSet = this.f16249mjFkc;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((C4446qtZIjO) it.next()).m13317ZfxDd().m13310Dt()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return this.f16245AZxh.m12031IEE() + ":" + this.f16250wA.toString();
    }

    /* renamed from: wA */
    public int m13321wA() {
        C4446qtZIjO c4446qtZIjO;
        if (this.f16245AZxh.m12043NPj() == 8) {
            return 0;
        }
        return (this.f16246JHa <= -1 || (c4446qtZIjO = this.f16248ZfxDd) == null || c4446qtZIjO.f16245AZxh.m12043NPj() != 8) ? this.f16247KLFTb : this.f16246JHa;
    }

    /* renamed from: xJ */
    public C4446qtZIjO m13322xJ() {
        return this.f16248ZfxDd;
    }
}
