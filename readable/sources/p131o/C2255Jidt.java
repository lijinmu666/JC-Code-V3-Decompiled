package p131o;

import android.text.SpannableStringBuilder;
import java.util.Locale;
import org.conscrypt.BuildConfig;
import p094kotlin.p117text.Typography;

/* renamed from: o.Jidt */
/* loaded from: classes.dex */
public final class C2255Jidt {

    /* renamed from: JHa */
    public static final String f9015JHa;

    /* renamed from: KLFTb */
    public static final String f9016KLFTb;

    /* renamed from: ZfxDd */
    public static final InterfaceC3209Y7 f9017ZfxDd;

    /* renamed from: lgHUyS */
    public static final C2255Jidt f9018lgHUyS;

    /* renamed from: xJ */
    public static final C2255Jidt f9019xJ;

    /* renamed from: AZxh */
    public final int f9020AZxh;

    /* renamed from: mjFkc */
    public final boolean f9021mjFkc;

    /* renamed from: wA */
    public final InterfaceC3209Y7 f9022wA;

    /* renamed from: o.Jidt$AZxh */
    public static class AZxh {

        /* renamed from: JHa */
        public static final byte[] f9023JHa = new byte[1792];

        /* renamed from: AZxh */
        public final boolean f9024AZxh;

        /* renamed from: KLFTb */
        public char f9025KLFTb;

        /* renamed from: ZfxDd */
        public int f9026ZfxDd;

        /* renamed from: mjFkc */
        public final CharSequence f9027mjFkc;

        /* renamed from: wA */
        public final int f9028wA;

        static {
            for (int i = 0; i < 1792; i++) {
                f9023JHa[i] = Character.getDirectionality(i);
            }
        }

        public AZxh(CharSequence charSequence, boolean z) {
            this.f9027mjFkc = charSequence;
            this.f9024AZxh = z;
            this.f9028wA = charSequence.length();
        }

        /* renamed from: wA */
        public static byte m9015wA(char c) {
            return c < 1792 ? f9023JHa[c] : Character.getDirectionality(c);
        }

        /* renamed from: AZxh */
        public byte m9016AZxh() {
            char cCharAt = this.f9027mjFkc.charAt(this.f9026ZfxDd);
            this.f9025KLFTb = cCharAt;
            if (Character.isHighSurrogate(cCharAt)) {
                int iCodePointAt = Character.codePointAt(this.f9027mjFkc, this.f9026ZfxDd);
                this.f9026ZfxDd += Character.charCount(iCodePointAt);
                return Character.getDirectionality(iCodePointAt);
            }
            this.f9026ZfxDd++;
            byte bM9015wA = m9015wA(this.f9025KLFTb);
            if (!this.f9024AZxh) {
                return bM9015wA;
            }
            char c = this.f9025KLFTb;
            return c == '<' ? m9022qdMbNW() : c == '&' ? m9023xJ() : bM9015wA;
        }

        /* renamed from: JHa */
        public final byte m9017JHa() {
            char cCharAt;
            int i = this.f9026ZfxDd;
            do {
                int i2 = this.f9026ZfxDd;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f9027mjFkc;
                int i3 = i2 - 1;
                this.f9026ZfxDd = i3;
                cCharAt = charSequence.charAt(i3);
                this.f9025KLFTb = cCharAt;
                if (cCharAt == '&') {
                    return (byte) 12;
                }
            } while (cCharAt != ';');
            this.f9026ZfxDd = i;
            this.f9025KLFTb = ';';
            return (byte) 13;
        }

        /* renamed from: KLFTb */
        public int m9018KLFTb() {
            this.f9026ZfxDd = this.f9028wA;
            int i = 0;
            while (true) {
                int i2 = i;
                while (this.f9026ZfxDd > 0) {
                    byte bM9021mjFkc = m9021mjFkc();
                    if (bM9021mjFkc != 0) {
                        if (bM9021mjFkc == 1 || bM9021mjFkc == 2) {
                            if (i == 0) {
                                return 1;
                            }
                            if (i2 == 0) {
                                break;
                            }
                        } else if (bM9021mjFkc != 9) {
                            switch (bM9021mjFkc) {
                                case 14:
                                case 15:
                                    if (i2 == i) {
                                        return -1;
                                    }
                                    i--;
                                    break;
                                case 16:
                                case 17:
                                    if (i2 == i) {
                                        return 1;
                                    }
                                    i--;
                                    break;
                                case 18:
                                    i++;
                                    break;
                                default:
                                    if (i2 != 0) {
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } else {
                            continue;
                        }
                    } else {
                        if (i == 0) {
                            return -1;
                        }
                        if (i2 == 0) {
                            break;
                        }
                    }
                }
                return 0;
            }
        }

        /* renamed from: ZfxDd */
        public int m9019ZfxDd() {
            this.f9026ZfxDd = 0;
            int i = 0;
            int i2 = 0;
            int i3 = 0;
            while (this.f9026ZfxDd < this.f9028wA && i == 0) {
                byte bM9016AZxh = m9016AZxh();
                if (bM9016AZxh != 0) {
                    if (bM9016AZxh == 1 || bM9016AZxh == 2) {
                        if (i3 == 0) {
                            return 1;
                        }
                    } else if (bM9016AZxh != 9) {
                        switch (bM9016AZxh) {
                            case 14:
                            case 15:
                                i3++;
                                i2 = -1;
                                continue;
                            case 16:
                            case 17:
                                i3++;
                                i2 = 1;
                                continue;
                            case 18:
                                i3--;
                                i2 = 0;
                                continue;
                        }
                    }
                } else if (i3 == 0) {
                    return -1;
                }
                i = i3;
            }
            if (i == 0) {
                return 0;
            }
            if (i2 != 0) {
                return i2;
            }
            while (this.f9026ZfxDd > 0) {
                switch (m9021mjFkc()) {
                    case 14:
                    case 15:
                        if (i == i3) {
                            return -1;
                        }
                        break;
                    case 16:
                    case 17:
                        if (i == i3) {
                            return 1;
                        }
                        break;
                    case 18:
                        i3++;
                        continue;
                }
                i3--;
            }
            return 0;
        }

        /* renamed from: lgHUyS */
        public final byte m9020lgHUyS() {
            char cCharAt;
            int i = this.f9026ZfxDd;
            while (true) {
                int i2 = this.f9026ZfxDd;
                if (i2 <= 0) {
                    break;
                }
                CharSequence charSequence = this.f9027mjFkc;
                int i3 = i2 - 1;
                this.f9026ZfxDd = i3;
                char cCharAt2 = charSequence.charAt(i3);
                this.f9025KLFTb = cCharAt2;
                if (cCharAt2 == '<') {
                    return (byte) 12;
                }
                if (cCharAt2 == '>') {
                    break;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i4 = this.f9026ZfxDd;
                        if (i4 > 0) {
                            CharSequence charSequence2 = this.f9027mjFkc;
                            int i5 = i4 - 1;
                            this.f9026ZfxDd = i5;
                            cCharAt = charSequence2.charAt(i5);
                            this.f9025KLFTb = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
            this.f9026ZfxDd = i;
            this.f9025KLFTb = Typography.f5416greater;
            return (byte) 13;
        }

        /* renamed from: mjFkc */
        public byte m9021mjFkc() {
            char cCharAt = this.f9027mjFkc.charAt(this.f9026ZfxDd - 1);
            this.f9025KLFTb = cCharAt;
            if (Character.isLowSurrogate(cCharAt)) {
                int iCodePointBefore = Character.codePointBefore(this.f9027mjFkc, this.f9026ZfxDd);
                this.f9026ZfxDd -= Character.charCount(iCodePointBefore);
                return Character.getDirectionality(iCodePointBefore);
            }
            this.f9026ZfxDd--;
            byte bM9015wA = m9015wA(this.f9025KLFTb);
            if (!this.f9024AZxh) {
                return bM9015wA;
            }
            char c = this.f9025KLFTb;
            return c == '>' ? m9020lgHUyS() : c == ';' ? m9017JHa() : bM9015wA;
        }

        /* renamed from: qdMbNW */
        public final byte m9022qdMbNW() {
            char cCharAt;
            int i = this.f9026ZfxDd;
            while (true) {
                int i2 = this.f9026ZfxDd;
                if (i2 >= this.f9028wA) {
                    this.f9026ZfxDd = i;
                    this.f9025KLFTb = Typography.f5418less;
                    return (byte) 13;
                }
                CharSequence charSequence = this.f9027mjFkc;
                this.f9026ZfxDd = i2 + 1;
                char cCharAt2 = charSequence.charAt(i2);
                this.f9025KLFTb = cCharAt2;
                if (cCharAt2 == '>') {
                    return (byte) 12;
                }
                if (cCharAt2 == '\"' || cCharAt2 == '\'') {
                    do {
                        int i3 = this.f9026ZfxDd;
                        if (i3 < this.f9028wA) {
                            CharSequence charSequence2 = this.f9027mjFkc;
                            this.f9026ZfxDd = i3 + 1;
                            cCharAt = charSequence2.charAt(i3);
                            this.f9025KLFTb = cCharAt;
                        }
                    } while (cCharAt != cCharAt2);
                }
            }
        }

        /* renamed from: xJ */
        public final byte m9023xJ() {
            char cCharAt;
            do {
                int i = this.f9026ZfxDd;
                if (i >= this.f9028wA) {
                    return (byte) 12;
                }
                CharSequence charSequence = this.f9027mjFkc;
                this.f9026ZfxDd = i + 1;
                cCharAt = charSequence.charAt(i);
                this.f9025KLFTb = cCharAt;
            } while (cCharAt != ';');
            return (byte) 12;
        }
    }

    /* renamed from: o.Jidt$mjFkc */
    public static final class mjFkc {

        /* renamed from: AZxh */
        public int f9029AZxh;

        /* renamed from: mjFkc */
        public boolean f9030mjFkc;

        /* renamed from: wA */
        public InterfaceC3209Y7 f9031wA;

        public mjFkc() {
            m9026wA(C2255Jidt.m9005KLFTb(Locale.getDefault()));
        }

        /* renamed from: AZxh */
        public static C2255Jidt m9024AZxh(boolean z) {
            return z ? C2255Jidt.f9018lgHUyS : C2255Jidt.f9019xJ;
        }

        /* renamed from: mjFkc */
        public C2255Jidt m9025mjFkc() {
            return (this.f9029AZxh == 2 && this.f9031wA == C2255Jidt.f9017ZfxDd) ? m9024AZxh(this.f9030mjFkc) : new C2255Jidt(this.f9030mjFkc, this.f9029AZxh, this.f9031wA);
        }

        /* renamed from: wA */
        public final void m9026wA(boolean z) {
            this.f9030mjFkc = z;
            this.f9031wA = C2255Jidt.f9017ZfxDd;
            this.f9029AZxh = 2;
        }
    }

    static {
        InterfaceC3209Y7 interfaceC3209Y7 = AbstractC3275Z7.f11997wA;
        f9017ZfxDd = interfaceC3209Y7;
        f9016KLFTb = Character.toString((char) 8206);
        f9015JHa = Character.toString((char) 8207);
        f9019xJ = new C2255Jidt(false, 2, interfaceC3209Y7);
        f9018lgHUyS = new C2255Jidt(true, 2, interfaceC3209Y7);
    }

    public C2255Jidt(boolean z, int i, InterfaceC3209Y7 interfaceC3209Y7) {
        this.f9021mjFkc = z;
        this.f9020AZxh = i;
        this.f9022wA = interfaceC3209Y7;
    }

    /* renamed from: AZxh */
    public static int m9004AZxh(CharSequence charSequence) {
        return new AZxh(charSequence, false).m9018KLFTb();
    }

    /* renamed from: KLFTb */
    public static boolean m9005KLFTb(Locale locale) {
        return AbstractC3999k8.m12485mjFkc(locale) == 1;
    }

    /* renamed from: mjFkc */
    public static int m9006mjFkc(CharSequence charSequence) {
        return new AZxh(charSequence, false).m9019ZfxDd();
    }

    /* renamed from: wA */
    public static C2255Jidt m9007wA() {
        return new mjFkc().m9025mjFkc();
    }

    /* renamed from: Dt */
    public String m9008Dt(String str) {
        return m9009ETF(str, this.f9022wA, true);
    }

    /* renamed from: ETF */
    public String m9009ETF(String str, InterfaceC3209Y7 interfaceC3209Y7, boolean z) {
        if (str == null) {
            return null;
        }
        return m9013qdMbNW(str, interfaceC3209Y7, z).toString();
    }

    /* renamed from: JHa */
    public final String m9010JHa(CharSequence charSequence, InterfaceC3209Y7 interfaceC3209Y7) {
        boolean zMo11047mjFkc = interfaceC3209Y7.mo11047mjFkc(charSequence, 0, charSequence.length());
        return (this.f9021mjFkc || !(zMo11047mjFkc || m9004AZxh(charSequence) == 1)) ? this.f9021mjFkc ? (!zMo11047mjFkc || m9004AZxh(charSequence) == -1) ? f9015JHa : BuildConfig.f24315FLAVOR : BuildConfig.f24315FLAVOR : f9016KLFTb;
    }

    /* renamed from: ZfxDd */
    public boolean m9011ZfxDd() {
        return (this.f9020AZxh & 2) != 0;
    }

    /* renamed from: lgHUyS */
    public CharSequence m9012lgHUyS(CharSequence charSequence) {
        return m9013qdMbNW(charSequence, this.f9022wA, true);
    }

    /* renamed from: qdMbNW */
    public CharSequence m9013qdMbNW(CharSequence charSequence, InterfaceC3209Y7 interfaceC3209Y7, boolean z) {
        if (charSequence == null) {
            return null;
        }
        boolean zMo11047mjFkc = interfaceC3209Y7.mo11047mjFkc(charSequence, 0, charSequence.length());
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (m9011ZfxDd() && z) {
            spannableStringBuilder.append((CharSequence) m9014xJ(charSequence, zMo11047mjFkc ? AbstractC3275Z7.f11992AZxh : AbstractC3275Z7.f11996mjFkc));
        }
        if (zMo11047mjFkc != this.f9021mjFkc) {
            spannableStringBuilder.append(zMo11047mjFkc ? (char) 8235 : (char) 8234);
            spannableStringBuilder.append(charSequence);
            spannableStringBuilder.append((char) 8236);
        } else {
            spannableStringBuilder.append(charSequence);
        }
        if (z) {
            spannableStringBuilder.append((CharSequence) m9010JHa(charSequence, zMo11047mjFkc ? AbstractC3275Z7.f11992AZxh : AbstractC3275Z7.f11996mjFkc));
        }
        return spannableStringBuilder;
    }

    /* renamed from: xJ */
    public final String m9014xJ(CharSequence charSequence, InterfaceC3209Y7 interfaceC3209Y7) {
        boolean zMo11047mjFkc = interfaceC3209Y7.mo11047mjFkc(charSequence, 0, charSequence.length());
        return (this.f9021mjFkc || !(zMo11047mjFkc || m9006mjFkc(charSequence) == 1)) ? this.f9021mjFkc ? (!zMo11047mjFkc || m9006mjFkc(charSequence) == -1) ? f9015JHa : BuildConfig.f24315FLAVOR : BuildConfig.f24315FLAVOR : f9016KLFTb;
    }
}
