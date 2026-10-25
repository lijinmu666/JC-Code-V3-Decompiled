package p131o;

import java.util.Locale;

/* renamed from: o.Z7 */
/* loaded from: classes.dex */
public abstract class AbstractC3275Z7 {

    /* renamed from: JHa */
    public static final InterfaceC3209Y7 f11993JHa;

    /* renamed from: KLFTb */
    public static final InterfaceC3209Y7 f11994KLFTb;

    /* renamed from: ZfxDd */
    public static final InterfaceC3209Y7 f11995ZfxDd;

    /* renamed from: wA */
    public static final InterfaceC3209Y7 f11997wA;

    /* renamed from: mjFkc */
    public static final InterfaceC3209Y7 f11996mjFkc = new KLFTb(null, false);

    /* renamed from: AZxh */
    public static final InterfaceC3209Y7 f11992AZxh = new KLFTb(null, true);

    /* renamed from: o.Z7$AZxh */
    public static class AZxh implements wA {

        /* renamed from: mjFkc */
        public static final AZxh f11998mjFkc = new AZxh();

        @Override // p131o.AbstractC3275Z7.wA
        /* renamed from: mjFkc */
        public int mo11185mjFkc(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            int iM11183AZxh = 2;
            while (i < i3 && iM11183AZxh == 2) {
                iM11183AZxh = AbstractC3275Z7.m11183AZxh(Character.getDirectionality(charSequence.charAt(i)));
                i++;
            }
            return iM11183AZxh;
        }
    }

    /* renamed from: o.Z7$JHa */
    public static class JHa extends ZfxDd {

        /* renamed from: AZxh */
        public static final JHa f11999AZxh = new JHa();

        public JHa() {
            super(null);
        }

        @Override // p131o.AbstractC3275Z7.ZfxDd
        /* renamed from: AZxh */
        public boolean mo11186AZxh() {
            return AbstractC3999k8.m12485mjFkc(Locale.getDefault()) == 1;
        }
    }

    /* renamed from: o.Z7$KLFTb */
    public static class KLFTb extends ZfxDd {

        /* renamed from: AZxh */
        public final boolean f12000AZxh;

        public KLFTb(wA wAVar, boolean z) {
            super(wAVar);
            this.f12000AZxh = z;
        }

        @Override // p131o.AbstractC3275Z7.ZfxDd
        /* renamed from: AZxh */
        public boolean mo11186AZxh() {
            return this.f12000AZxh;
        }
    }

    /* renamed from: o.Z7$ZfxDd */
    public static abstract class ZfxDd implements InterfaceC3209Y7 {

        /* renamed from: mjFkc */
        public final wA f12001mjFkc;

        public ZfxDd(wA wAVar) {
            this.f12001mjFkc = wAVar;
        }

        /* renamed from: AZxh */
        public abstract boolean mo11186AZxh();

        @Override // p131o.InterfaceC3209Y7
        /* renamed from: mjFkc */
        public boolean mo11047mjFkc(CharSequence charSequence, int i, int i2) {
            if (charSequence == null || i < 0 || i2 < 0 || charSequence.length() - i2 < i) {
                throw new IllegalArgumentException();
            }
            return this.f12001mjFkc == null ? mo11186AZxh() : m11187wA(charSequence, i, i2);
        }

        /* renamed from: wA */
        public final boolean m11187wA(CharSequence charSequence, int i, int i2) {
            int iMo11185mjFkc = this.f12001mjFkc.mo11185mjFkc(charSequence, i, i2);
            if (iMo11185mjFkc == 0) {
                return true;
            }
            if (iMo11185mjFkc != 1) {
                return mo11186AZxh();
            }
            return false;
        }
    }

    /* renamed from: o.Z7$mjFkc */
    public static class mjFkc implements wA {

        /* renamed from: AZxh */
        public static final mjFkc f12002AZxh = new mjFkc(true);

        /* renamed from: mjFkc */
        public final boolean f12003mjFkc;

        public mjFkc(boolean z) {
            this.f12003mjFkc = z;
        }

        @Override // p131o.AbstractC3275Z7.wA
        /* renamed from: mjFkc */
        public int mo11185mjFkc(CharSequence charSequence, int i, int i2) {
            int i3 = i2 + i;
            boolean z = false;
            while (i < i3) {
                int iM11184mjFkc = AbstractC3275Z7.m11184mjFkc(Character.getDirectionality(charSequence.charAt(i)));
                if (iM11184mjFkc != 0) {
                    if (iM11184mjFkc != 1) {
                        continue;
                        i++;
                        z = z;
                    } else if (!this.f12003mjFkc) {
                        return 1;
                    }
                } else if (this.f12003mjFkc) {
                    return 0;
                }
                z = true;
                i++;
                z = z;
            }
            if (z) {
                return this.f12003mjFkc ? 1 : 0;
            }
            return 2;
        }
    }

    /* renamed from: o.Z7$wA */
    public interface wA {
        /* renamed from: mjFkc */
        int mo11185mjFkc(CharSequence charSequence, int i, int i2);
    }

    static {
        AZxh aZxh = AZxh.f11998mjFkc;
        f11997wA = new KLFTb(aZxh, false);
        f11995ZfxDd = new KLFTb(aZxh, true);
        f11994KLFTb = new KLFTb(mjFkc.f12002AZxh, false);
        f11993JHa = JHa.f11999AZxh;
    }

    /* renamed from: AZxh */
    public static int m11183AZxh(int i) {
        if (i != 0) {
            if (i == 1 || i == 2) {
                return 0;
            }
            switch (i) {
                case 14:
                case 15:
                    break;
                case 16:
                case 17:
                    return 0;
                default:
                    return 2;
            }
        }
        return 1;
    }

    /* renamed from: mjFkc */
    public static int m11184mjFkc(int i) {
        if (i != 0) {
            return (i == 1 || i == 2) ? 0 : 2;
        }
        return 1;
    }
}
