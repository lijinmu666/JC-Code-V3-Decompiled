package p131o;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import p094kotlin.p117text.Typography;
import p132okio.internal.C5067Buffer;

/* renamed from: o.t0 */
/* loaded from: classes.dex */
public class C4587t0 implements Closeable {

    /* renamed from: Dt */
    public int f16585Dt;

    /* renamed from: ETF */
    public String f16586ETF;

    /* renamed from: VA */
    public int[] f16590VA;

    /* renamed from: YoKzxo */
    public String[] f16591YoKzxo;

    /* renamed from: mjFkc */
    public final Reader f16594mjFkc;

    /* renamed from: qdMbNW */
    public long f16595qdMbNW;

    /* renamed from: rkYL */
    public int[] f16596rkYL;

    /* renamed from: AZxh */
    public boolean f16584AZxh = false;

    /* renamed from: wA */
    public final char[] f16597wA = new char[1024];

    /* renamed from: ZfxDd */
    public int f16592ZfxDd = 0;

    /* renamed from: KLFTb */
    public int f16588KLFTb = 0;

    /* renamed from: JHa */
    public int f16587JHa = 0;

    /* renamed from: xJ */
    public int f16598xJ = 0;

    /* renamed from: lgHUyS */
    public int f16593lgHUyS = 0;

    /* renamed from: MiMN */
    public int f16589MiMN = 1;

    /* renamed from: o.t0$mjFkc */
    public class mjFkc extends AbstractC4654u0 {
    }

    static {
        AbstractC4654u0.f16762mjFkc = new mjFkc();
    }

    public C4587t0(Reader reader) {
        int[] iArr = new int[32];
        this.f16590VA = iArr;
        iArr[0] = 6;
        this.f16591YoKzxo = new String[32];
        this.f16596rkYL = new int[32];
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.f16594mjFkc = reader;
    }

    /* renamed from: BAnRFn */
    public String mo13541BAnRFn() throws IOException {
        String strM13564mByQ;
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        if (iM13565qdMbNW == 14) {
            strM13564mByQ = m13549Ne();
        } else if (iM13565qdMbNW == 12) {
            strM13564mByQ = m13564mByQ('\'');
        } else {
            if (iM13565qdMbNW != 13) {
                throw new IllegalStateException("Expected a name but was " + mo13542CqaNbM() + m13561huTpC());
            }
            strM13564mByQ = m13564mByQ(Typography.f5424quote);
        }
        this.f16593lgHUyS = 0;
        this.f16591YoKzxo[this.f16589MiMN - 1] = strM13564mByQ;
        return strM13564mByQ;
    }

    /* renamed from: CqaNbM */
    public EnumC4786w0 mo13542CqaNbM() throws IOException {
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        switch (iM13565qdMbNW) {
            case 1:
                return EnumC4786w0.BEGIN_OBJECT;
            case 2:
                return EnumC4786w0.END_OBJECT;
            case 3:
                return EnumC4786w0.BEGIN_ARRAY;
            case 4:
                return EnumC4786w0.END_ARRAY;
            case 5:
            case 6:
                return EnumC4786w0.BOOLEAN;
            case 7:
                return EnumC4786w0.NULL;
            case 8:
            case 9:
            case 10:
            case 11:
                return EnumC4786w0.STRING;
            case 12:
            case 13:
            case 14:
                return EnumC4786w0.NAME;
            case 15:
            case 16:
                return EnumC4786w0.NUMBER;
            case 17:
                return EnumC4786w0.END_DOCUMENT;
            default:
                throw new AssertionError();
        }
    }

    /* renamed from: Gd */
    public boolean mo13543Gd() throws IOException {
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        if (iM13565qdMbNW == 5) {
            this.f16593lgHUyS = 0;
            int[] iArr = this.f16596rkYL;
            int i = this.f16589MiMN - 1;
            iArr[i] = iArr[i] + 1;
            return true;
        }
        if (iM13565qdMbNW == 6) {
            this.f16593lgHUyS = 0;
            int[] iArr2 = this.f16596rkYL;
            int i2 = this.f16589MiMN - 1;
            iArr2[i2] = iArr2[i2] + 1;
            return false;
        }
        throw new IllegalStateException("Expected a boolean but was " + mo13542CqaNbM() + m13561huTpC());
    }

    /* renamed from: HGpJ */
    public double mo13544HGpJ() throws IOException, NumberFormatException {
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        if (iM13565qdMbNW == 15) {
            this.f16593lgHUyS = 0;
            int[] iArr = this.f16596rkYL;
            int i = this.f16589MiMN - 1;
            iArr[i] = iArr[i] + 1;
            return this.f16595qdMbNW;
        }
        if (iM13565qdMbNW == 16) {
            this.f16586ETF = new String(this.f16597wA, this.f16592ZfxDd, this.f16585Dt);
            this.f16592ZfxDd += this.f16585Dt;
        } else if (iM13565qdMbNW == 8 || iM13565qdMbNW == 9) {
            this.f16586ETF = m13564mByQ(iM13565qdMbNW == 8 ? '\'' : Typography.f5424quote);
        } else if (iM13565qdMbNW == 10) {
            this.f16586ETF = m13549Ne();
        } else if (iM13565qdMbNW != 11) {
            throw new IllegalStateException("Expected a double but was " + mo13542CqaNbM() + m13561huTpC());
        }
        this.f16593lgHUyS = 11;
        double d = Double.parseDouble(this.f16586ETF);
        if (!this.f16584AZxh && (Double.isNaN(d) || Double.isInfinite(d))) {
            throw new C4854x1("JSON forbids NaN and infinities: " + d + m13561huTpC());
        }
        this.f16586ETF = null;
        this.f16593lgHUyS = 0;
        int[] iArr2 = this.f16596rkYL;
        int i2 = this.f16589MiMN - 1;
        iArr2[i2] = iArr2[i2] + 1;
        return d;
    }

    /* renamed from: KLFTb */
    public void mo13545KLFTb() throws IOException {
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        if (iM13565qdMbNW == 1) {
            m13572zvd(3);
            this.f16593lgHUyS = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_OBJECT but was " + mo13542CqaNbM() + m13561huTpC());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:54:0x0091, code lost:
    
        if (m13552Ucbh(r14) != false) goto L78;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0093, code lost:
    
        if (r9 != 2) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x0095, code lost:
    
        if (r10 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x009b, code lost:
    
        if (r11 != Long.MIN_VALUE) goto L60;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x009d, code lost:
    
        if (r13 == false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00a3, code lost:
    
        if (r11 != 0) goto L63;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00a5, code lost:
    
        if (r13 != false) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00a7, code lost:
    
        if (r13 == false) goto L65;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00aa, code lost:
    
        r11 = -r11;
     */
    /* JADX WARN: Code restructure failed: missing block: B:66:0x00ab, code lost:
    
        r18.f16595qdMbNW = r11;
        r18.f16592ZfxDd += r8;
        r18.f16593lgHUyS = 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00b6, code lost:
    
        return 15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00b7, code lost:
    
        if (r9 == 2) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00ba, code lost:
    
        if (r9 == 4) goto L76;
     */
    /* JADX WARN: Code restructure failed: missing block: B:72:0x00bd, code lost:
    
        if (r9 != 7) goto L74;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00c0, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x00c2, code lost:
    
        r18.f16585Dt = r8;
        r18.f16593lgHUyS = 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00c8, code lost:
    
        return 16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x00c9, code lost:
    
        return 0;
     */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x00ec  */
    /* renamed from: KLMXS */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final int m13546KLMXS() {
        char c;
        char c2;
        char[] cArr = this.f16597wA;
        int i = this.f16592ZfxDd;
        int i2 = this.f16588KLFTb;
        int i3 = 0;
        int i4 = 0;
        char c3 = 0;
        boolean z = false;
        boolean z2 = true;
        long j = 0;
        while (true) {
            if (i + i4 != i2) {
                c = cArr[i + i4];
                if (c == '+') {
                    if (c == 'E' || c == 'e') {
                        i3 = 0;
                        if (c3 != 2 && c3 != 4) {
                            return 0;
                        }
                        c3 = 5;
                    } else if (c != '-') {
                        c2 = 3;
                        if (c == '.') {
                            i3 = 0;
                            if (c3 != 2) {
                                return 0;
                            }
                        } else {
                            if (c < '0' || c > '9') {
                                break;
                            }
                            if (c3 == 1 || c3 == 0) {
                                j = -(c - '0');
                                c3 = 2;
                            } else if (c3 == 2) {
                                if (j == 0) {
                                    return 0;
                                }
                                long j2 = (10 * j) - (c - '0');
                                z2 &= j > C5067Buffer.OVERFLOW_ZONE || (j == C5067Buffer.OVERFLOW_ZONE && j2 < j);
                                j = j2;
                            } else if (c3 == 3) {
                                i3 = 0;
                                c3 = 4;
                            } else if (c3 == 5 || c3 == 6) {
                                i3 = 0;
                                c3 = 7;
                            }
                            i3 = 0;
                        }
                    } else {
                        c2 = 6;
                        i3 = 0;
                        if (c3 == 0) {
                            c3 = 1;
                            z = true;
                        } else if (c3 != 5) {
                            return 0;
                        }
                    }
                    i4++;
                } else {
                    c2 = 6;
                    i3 = 0;
                    if (c3 != 5) {
                        return 0;
                    }
                }
                c3 = c2;
                i4++;
            } else {
                if (i4 == cArr.length) {
                    return i3;
                }
                if (!m13560fehf(i4 + 1)) {
                    break;
                }
                i = this.f16592ZfxDd;
                i2 = this.f16588KLFTb;
                c = cArr[i + i4];
                if (c == '+') {
                }
                c3 = c2;
                i4++;
            }
        }
    }

    /* renamed from: MiMN */
    public void mo13547MiMN() throws IOException {
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        if (iM13565qdMbNW != 2) {
            throw new IllegalStateException("Expected END_OBJECT but was " + mo13542CqaNbM() + m13561huTpC());
        }
        int i = this.f16589MiMN;
        int i2 = i - 1;
        this.f16589MiMN = i2;
        this.f16591YoKzxo[i2] = null;
        int[] iArr = this.f16596rkYL;
        int i3 = i - 2;
        iArr[i3] = iArr[i3] + 1;
        this.f16593lgHUyS = 0;
    }

    /* renamed from: NPj */
    public final void m13548NPj() {
        char c;
        do {
            if (this.f16592ZfxDd >= this.f16588KLFTb && !m13560fehf(1)) {
                return;
            }
            char[] cArr = this.f16597wA;
            int i = this.f16592ZfxDd;
            int i2 = i + 1;
            this.f16592ZfxDd = i2;
            c = cArr[i];
            if (c == '\n') {
                this.f16587JHa++;
                this.f16598xJ = i2;
                return;
            }
        } while (c != '\r');
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x004a, code lost:
    
        m13570xJ();
     */
    /* JADX WARN: Failed to find 'out' block for switch in B:32:0x0044. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /* renamed from: Ne */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m13549Ne() throws IOException {
        String string;
        StringBuilder sb = null;
        int i = 0;
        do {
            int i2 = 0;
            while (true) {
                int i3 = this.f16592ZfxDd;
                if (i3 + i2 < this.f16588KLFTb) {
                    char c = this.f16597wA[i3 + i2];
                    if (c != '\t' && c != '\n' && c != '\f' && c != '\r' && c != ' ') {
                        if (c != '#') {
                            if (c != ',') {
                                if (c != '/' && c != '=') {
                                    if (c != '{' && c != '}' && c != ':') {
                                        if (c != ';') {
                                            switch (c) {
                                                case '[':
                                                case ']':
                                                    break;
                                                case '\\':
                                                    break;
                                                default:
                                                    i2++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else if (i2 >= this.f16597wA.length) {
                    if (sb == null) {
                        sb = new StringBuilder(Math.max(i2, 16));
                    }
                    sb.append(this.f16597wA, this.f16592ZfxDd, i2);
                    this.f16592ZfxDd += i2;
                } else if (m13560fehf(i2 + 1)) {
                }
            }
            i = i2;
            if (sb != null) {
                string = new String(this.f16597wA, this.f16592ZfxDd, i);
            } else {
                sb.append(this.f16597wA, this.f16592ZfxDd, i);
                string = sb.toString();
            }
            this.f16592ZfxDd += i;
            return string;
        } while (m13560fehf(1));
        if (sb != null) {
        }
        this.f16592ZfxDd += i;
        return string;
    }

    /* renamed from: OjSQV */
    public String mo13550OjSQV() throws IOException {
        String str;
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        if (iM13565qdMbNW == 10) {
            str = m13549Ne();
        } else if (iM13565qdMbNW == 8) {
            str = m13564mByQ('\'');
        } else if (iM13565qdMbNW == 9) {
            str = m13564mByQ(Typography.f5424quote);
        } else if (iM13565qdMbNW == 11) {
            str = this.f16586ETF;
            this.f16586ETF = null;
        } else if (iM13565qdMbNW == 15) {
            str = Long.toString(this.f16595qdMbNW);
        } else {
            if (iM13565qdMbNW != 16) {
                throw new IllegalStateException("Expected a string but was " + mo13542CqaNbM() + m13561huTpC());
            }
            str = new String(this.f16597wA, this.f16592ZfxDd, this.f16585Dt);
            this.f16592ZfxDd += this.f16585Dt;
        }
        this.f16593lgHUyS = 0;
        int[] iArr = this.f16596rkYL;
        int i = this.f16589MiMN - 1;
        iArr[i] = iArr[i] + 1;
        return str;
    }

    /* renamed from: Pq */
    public String mo13551Pq() {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.f5414dollar);
        int i = this.f16589MiMN;
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.f16590VA[i2];
            if (i3 == 1 || i3 == 2) {
                sb.append('[');
                sb.append(this.f16596rkYL[i2]);
                sb.append(']');
            } else if (i3 == 3 || i3 == 4 || i3 == 5) {
                sb.append('.');
                String str = this.f16591YoKzxo[i2];
                if (str != null) {
                    sb.append(str);
                }
            }
        }
        return sb.toString();
    }

    /* renamed from: Ucbh */
    public final boolean m13552Ucbh(char c) throws IOException {
        if (c == '\t' || c == '\n' || c == '\f' || c == '\r' || c == ' ') {
            return false;
        }
        if (c != '#') {
            if (c == ',') {
                return false;
            }
            if (c != '/' && c != '=') {
                if (c == '{' || c == '}' || c == ':') {
                    return false;
                }
                if (c != ';') {
                    switch (c) {
                        case '[':
                        case ']':
                            return false;
                        case '\\':
                            break;
                        default:
                            return true;
                    }
                }
            }
        }
        m13570xJ();
        return false;
    }

    /* renamed from: VA */
    public void mo13553VA() throws IOException {
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        if (iM13565qdMbNW != 4) {
            throw new IllegalStateException("Expected END_ARRAY but was " + mo13542CqaNbM() + m13561huTpC());
        }
        int i = this.f16589MiMN;
        this.f16589MiMN = i - 1;
        int[] iArr = this.f16596rkYL;
        int i2 = i - 2;
        iArr[i2] = iArr[i2] + 1;
        this.f16593lgHUyS = 0;
    }

    /* renamed from: Vnb */
    public final boolean m13554Vnb(String str) {
        int length = str.length();
        while (true) {
            if (this.f16592ZfxDd + length > this.f16588KLFTb && !m13560fehf(length)) {
                return false;
            }
            char[] cArr = this.f16597wA;
            int i = this.f16592ZfxDd;
            if (cArr[i] != '\n') {
                for (int i2 = 0; i2 < length; i2++) {
                    if (this.f16597wA[this.f16592ZfxDd + i2] != str.charAt(i2)) {
                        break;
                    }
                }
                return true;
            }
            this.f16587JHa++;
            this.f16598xJ = i + 1;
            this.f16592ZfxDd++;
        }
    }

    /* renamed from: VocHEe */
    public long mo13555VocHEe() throws IOException, NumberFormatException {
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        if (iM13565qdMbNW == 15) {
            this.f16593lgHUyS = 0;
            int[] iArr = this.f16596rkYL;
            int i = this.f16589MiMN - 1;
            iArr[i] = iArr[i] + 1;
            return this.f16595qdMbNW;
        }
        if (iM13565qdMbNW == 16) {
            this.f16586ETF = new String(this.f16597wA, this.f16592ZfxDd, this.f16585Dt);
            this.f16592ZfxDd += this.f16585Dt;
        } else {
            if (iM13565qdMbNW != 8 && iM13565qdMbNW != 9 && iM13565qdMbNW != 10) {
                throw new IllegalStateException("Expected a long but was " + mo13542CqaNbM() + m13561huTpC());
            }
            if (iM13565qdMbNW == 10) {
                this.f16586ETF = m13549Ne();
            } else {
                this.f16586ETF = m13564mByQ(iM13565qdMbNW == 8 ? '\'' : Typography.f5424quote);
            }
            try {
                long j = Long.parseLong(this.f16586ETF);
                this.f16593lgHUyS = 0;
                int[] iArr2 = this.f16596rkYL;
                int i2 = this.f16589MiMN - 1;
                iArr2[i2] = iArr2[i2] + 1;
                return j;
            } catch (NumberFormatException unused) {
            }
        }
        this.f16593lgHUyS = 11;
        double d = Double.parseDouble(this.f16586ETF);
        long j2 = (long) d;
        if (j2 != d) {
            throw new NumberFormatException("Expected a long but was " + this.f16586ETF + m13561huTpC());
        }
        this.f16586ETF = null;
        this.f16593lgHUyS = 0;
        int[] iArr3 = this.f16596rkYL;
        int i3 = this.f16589MiMN - 1;
        iArr3[i3] = iArr3[i3] + 1;
        return j2;
    }

    /* renamed from: ZfxDd */
    public void mo13556ZfxDd() throws IOException {
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        if (iM13565qdMbNW == 3) {
            m13572zvd(1);
            this.f16596rkYL[this.f16589MiMN - 1] = 0;
            this.f16593lgHUyS = 0;
        } else {
            throw new IllegalStateException("Expected BEGIN_ARRAY but was " + mo13542CqaNbM() + m13561huTpC());
        }
    }

    /* renamed from: cMLeY */
    public final char m13557cMLeY() throws IOException {
        int i;
        if (this.f16592ZfxDd == this.f16588KLFTb && !m13560fehf(1)) {
            throw m13568vadzgd("Unterminated escape sequence");
        }
        char[] cArr = this.f16597wA;
        int i2 = this.f16592ZfxDd;
        int i3 = i2 + 1;
        this.f16592ZfxDd = i3;
        char c = cArr[i2];
        if (c == '\n') {
            this.f16587JHa++;
            this.f16598xJ = i3;
        } else if (c != '\"' && c != '\'' && c != '/' && c != '\\') {
            if (c == 'b') {
                return '\b';
            }
            if (c == 'f') {
                return '\f';
            }
            if (c == 'n') {
                return '\n';
            }
            if (c == 'r') {
                return '\r';
            }
            if (c == 't') {
                return '\t';
            }
            if (c != 'u') {
                throw m13568vadzgd("Invalid escape sequence");
            }
            if (i2 + 5 > this.f16588KLFTb && !m13560fehf(4)) {
                throw m13568vadzgd("Unterminated escape sequence");
            }
            int i4 = this.f16592ZfxDd;
            int i5 = i4 + 4;
            char c2 = 0;
            while (i4 < i5) {
                char c3 = this.f16597wA[i4];
                char c4 = (char) (c2 << 4);
                if (c3 >= '0' && c3 <= '9') {
                    i = c3 - '0';
                } else if (c3 >= 'a' && c3 <= 'f') {
                    i = c3 - 'W';
                } else {
                    if (c3 < 'A' || c3 > 'F') {
                        throw new NumberFormatException("\\u" + new String(this.f16597wA, this.f16592ZfxDd, 4));
                    }
                    i = c3 - '7';
                }
                c2 = (char) (c4 + i);
                i4++;
            }
            this.f16592ZfxDd += 4;
            return c2;
        }
        return c;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f16593lgHUyS = 0;
        this.f16590VA[0] = 8;
        this.f16589MiMN = 1;
        this.f16594mjFkc.close();
    }

    /* renamed from: diqgf */
    public boolean mo13558diqgf() throws IOException {
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        return (iM13565qdMbNW == 2 || iM13565qdMbNW == 4) ? false : true;
    }

    /* renamed from: eyqo */
    public final boolean m13559eyqo() {
        return this.f16584AZxh;
    }

    /* renamed from: fehf */
    public final boolean m13560fehf(int i) throws IOException {
        int i2;
        int i3;
        char[] cArr = this.f16597wA;
        int i4 = this.f16598xJ;
        int i5 = this.f16592ZfxDd;
        this.f16598xJ = i4 - i5;
        int i6 = this.f16588KLFTb;
        if (i6 != i5) {
            int i7 = i6 - i5;
            this.f16588KLFTb = i7;
            System.arraycopy(cArr, i5, cArr, 0, i7);
        } else {
            this.f16588KLFTb = 0;
        }
        this.f16592ZfxDd = 0;
        do {
            Reader reader = this.f16594mjFkc;
            int i8 = this.f16588KLFTb;
            int i9 = reader.read(cArr, i8, cArr.length - i8);
            if (i9 == -1) {
                return false;
            }
            i2 = this.f16588KLFTb + i9;
            this.f16588KLFTb = i2;
            if (this.f16587JHa == 0 && (i3 = this.f16598xJ) == 0 && i2 > 0 && cArr[0] == 65279) {
                this.f16592ZfxDd++;
                this.f16598xJ = i3 + 1;
                i++;
            }
        } while (i2 < i);
        return true;
    }

    /* renamed from: huTpC */
    public String m13561huTpC() {
        return " at line " + (this.f16587JHa + 1) + " column " + ((this.f16592ZfxDd - this.f16598xJ) + 1) + " path " + mo13551Pq();
    }

    /* renamed from: lB */
    public final int m13562lB(boolean z) throws IOException {
        char[] cArr = this.f16597wA;
        int i = this.f16592ZfxDd;
        int i2 = this.f16588KLFTb;
        while (true) {
            if (i == i2) {
                this.f16592ZfxDd = i;
                if (!m13560fehf(1)) {
                    if (!z) {
                        return -1;
                    }
                    throw new EOFException("End of input" + m13561huTpC());
                }
                i = this.f16592ZfxDd;
                i2 = this.f16588KLFTb;
            }
            int i3 = i + 1;
            char c = cArr[i];
            if (c == '\n') {
                this.f16587JHa++;
                this.f16598xJ = i3;
            } else if (c != ' ' && c != '\r' && c != '\t') {
                if (c == '/') {
                    this.f16592ZfxDd = i3;
                    if (i3 == i2) {
                        this.f16592ZfxDd = i;
                        boolean zM13560fehf = m13560fehf(2);
                        this.f16592ZfxDd++;
                        if (!zM13560fehf) {
                            return c;
                        }
                    }
                    m13570xJ();
                    int i4 = this.f16592ZfxDd;
                    char c2 = cArr[i4];
                    if (c2 == '*') {
                        this.f16592ZfxDd = i4 + 1;
                        if (!m13554Vnb("*/")) {
                            throw m13568vadzgd("Unterminated comment");
                        }
                        i = this.f16592ZfxDd + 2;
                        i2 = this.f16588KLFTb;
                    } else {
                        if (c2 != '/') {
                            return c;
                        }
                        this.f16592ZfxDd = i4 + 1;
                        m13548NPj();
                        i = this.f16592ZfxDd;
                        i2 = this.f16588KLFTb;
                    }
                } else {
                    if (c != '#') {
                        this.f16592ZfxDd = i3;
                        return c;
                    }
                    this.f16592ZfxDd = i3;
                    m13570xJ();
                    m13548NPj();
                    i = this.f16592ZfxDd;
                    i2 = this.f16588KLFTb;
                }
            }
            i = i3;
        }
    }

    /* renamed from: lgHUyS */
    public final void m13563lgHUyS() throws IOException {
        m13562lB(true);
        int i = this.f16592ZfxDd;
        int i2 = i - 1;
        this.f16592ZfxDd = i2;
        if (i + 4 <= this.f16588KLFTb || m13560fehf(5)) {
            char[] cArr = this.f16597wA;
            if (cArr[i2] == ')' && cArr[i] == ']' && cArr[i + 1] == '}' && cArr[i + 2] == '\'' && cArr[i + 3] == '\n') {
                this.f16592ZfxDd += 5;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x005a, code lost:
    
        if (r1 != null) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005c, code lost:
    
        r1 = new java.lang.StringBuilder(java.lang.Math.max((r2 - r3) * 2, 16));
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x006a, code lost:
    
        r1.append(r0, r3, r2 - r3);
        r9.f16592ZfxDd = r2;
     */
    /* renamed from: mByQ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String m13564mByQ(char c) throws IOException {
        char[] cArr = this.f16597wA;
        StringBuilder sb = null;
        do {
            int i = this.f16592ZfxDd;
            int i2 = this.f16588KLFTb;
            while (true) {
                int i3 = i2;
                int i4 = i;
                while (i < i3) {
                    int i5 = i + 1;
                    char c2 = cArr[i];
                    if (c2 == c) {
                        this.f16592ZfxDd = i5;
                        int i6 = (i5 - i4) - 1;
                        if (sb == null) {
                            return new String(cArr, i4, i6);
                        }
                        sb.append(cArr, i4, i6);
                        return sb.toString();
                    }
                    if (c2 == '\\') {
                        this.f16592ZfxDd = i5;
                        int i7 = i5 - i4;
                        int i8 = i7 - 1;
                        if (sb == null) {
                            sb = new StringBuilder(Math.max(i7 * 2, 16));
                        }
                        sb.append(cArr, i4, i8);
                        sb.append(m13557cMLeY());
                        i = this.f16592ZfxDd;
                        i2 = this.f16588KLFTb;
                    } else {
                        if (c2 == '\n') {
                            this.f16587JHa++;
                            this.f16598xJ = i5;
                        }
                        i = i5;
                    }
                }
                break;
            }
        } while (m13560fehf(1));
        throw m13568vadzgd("Unterminated string");
    }

    /* renamed from: qdMbNW */
    public int m13565qdMbNW() throws IOException {
        int iM13562lB;
        int[] iArr = this.f16590VA;
        int i = this.f16589MiMN;
        int i2 = iArr[i - 1];
        if (i2 == 1) {
            iArr[i - 1] = 2;
        } else if (i2 == 2) {
            int iM13562lB2 = m13562lB(true);
            if (iM13562lB2 != 44) {
                if (iM13562lB2 != 59) {
                    if (iM13562lB2 != 93) {
                        throw m13568vadzgd("Unterminated array");
                    }
                    this.f16593lgHUyS = 4;
                    return 4;
                }
                m13570xJ();
            }
        } else {
            if (i2 == 3 || i2 == 5) {
                iArr[i - 1] = 4;
                if (i2 == 5 && (iM13562lB = m13562lB(true)) != 44) {
                    if (iM13562lB != 59) {
                        if (iM13562lB != 125) {
                            throw m13568vadzgd("Unterminated object");
                        }
                        this.f16593lgHUyS = 2;
                        return 2;
                    }
                    m13570xJ();
                }
                int iM13562lB3 = m13562lB(true);
                if (iM13562lB3 == 34) {
                    this.f16593lgHUyS = 13;
                    return 13;
                }
                if (iM13562lB3 == 39) {
                    m13570xJ();
                    this.f16593lgHUyS = 12;
                    return 12;
                }
                if (iM13562lB3 == 125) {
                    if (i2 == 5) {
                        throw m13568vadzgd("Expected name");
                    }
                    this.f16593lgHUyS = 2;
                    return 2;
                }
                m13570xJ();
                this.f16592ZfxDd--;
                if (!m13552Ucbh((char) iM13562lB3)) {
                    throw m13568vadzgd("Expected name");
                }
                this.f16593lgHUyS = 14;
                return 14;
            }
            if (i2 == 4) {
                iArr[i - 1] = 5;
                int iM13562lB4 = m13562lB(true);
                if (iM13562lB4 != 58) {
                    if (iM13562lB4 != 61) {
                        throw m13568vadzgd("Expected ':'");
                    }
                    m13570xJ();
                    if (this.f16592ZfxDd < this.f16588KLFTb || m13560fehf(1)) {
                        char[] cArr = this.f16597wA;
                        int i3 = this.f16592ZfxDd;
                        if (cArr[i3] == '>') {
                            this.f16592ZfxDd = i3 + 1;
                        }
                    }
                }
            } else if (i2 == 6) {
                if (this.f16584AZxh) {
                    m13563lgHUyS();
                }
                this.f16590VA[this.f16589MiMN - 1] = 7;
            } else if (i2 == 7) {
                if (m13562lB(false) == -1) {
                    this.f16593lgHUyS = 17;
                    return 17;
                }
                m13570xJ();
                this.f16592ZfxDd--;
            } else if (i2 == 8) {
                throw new IllegalStateException("JsonReader is closed");
            }
        }
        int iM13562lB5 = m13562lB(true);
        if (iM13562lB5 == 34) {
            this.f16593lgHUyS = 9;
            return 9;
        }
        if (iM13562lB5 == 39) {
            m13570xJ();
            this.f16593lgHUyS = 8;
            return 8;
        }
        if (iM13562lB5 != 44 && iM13562lB5 != 59) {
            if (iM13562lB5 == 91) {
                this.f16593lgHUyS = 3;
                return 3;
            }
            if (iM13562lB5 != 93) {
                if (iM13562lB5 == 123) {
                    this.f16593lgHUyS = 1;
                    return 1;
                }
                this.f16592ZfxDd--;
                int iM13571xrEuO = m13571xrEuO();
                if (iM13571xrEuO != 0) {
                    return iM13571xrEuO;
                }
                int iM13546KLMXS = m13546KLMXS();
                if (iM13546KLMXS != 0) {
                    return iM13546KLMXS;
                }
                if (!m13552Ucbh(this.f16597wA[this.f16592ZfxDd])) {
                    throw m13568vadzgd("Expected value");
                }
                m13570xJ();
                this.f16593lgHUyS = 10;
                return 10;
            }
            if (i2 == 1) {
                this.f16593lgHUyS = 4;
                return 4;
            }
        }
        if (i2 != 1 && i2 != 2) {
            throw m13568vadzgd("Unexpected value");
        }
        m13570xJ();
        this.f16592ZfxDd--;
        this.f16593lgHUyS = 7;
        return 7;
    }

    /* renamed from: rWxwaT */
    public final void m13566rWxwaT(boolean z) {
        this.f16584AZxh = z;
    }

    public String toString() {
        return getClass().getSimpleName() + m13561huTpC();
    }

    /* renamed from: vI */
    public int mo13567vI() throws IOException, NumberFormatException {
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        if (iM13565qdMbNW == 15) {
            long j = this.f16595qdMbNW;
            int i = (int) j;
            if (j == i) {
                this.f16593lgHUyS = 0;
                int[] iArr = this.f16596rkYL;
                int i2 = this.f16589MiMN - 1;
                iArr[i2] = iArr[i2] + 1;
                return i;
            }
            throw new NumberFormatException("Expected an int but was " + this.f16595qdMbNW + m13561huTpC());
        }
        if (iM13565qdMbNW == 16) {
            this.f16586ETF = new String(this.f16597wA, this.f16592ZfxDd, this.f16585Dt);
            this.f16592ZfxDd += this.f16585Dt;
        } else {
            if (iM13565qdMbNW != 8 && iM13565qdMbNW != 9 && iM13565qdMbNW != 10) {
                throw new IllegalStateException("Expected an int but was " + mo13542CqaNbM() + m13561huTpC());
            }
            if (iM13565qdMbNW == 10) {
                this.f16586ETF = m13549Ne();
            } else {
                this.f16586ETF = m13564mByQ(iM13565qdMbNW == 8 ? '\'' : Typography.f5424quote);
            }
            try {
                int i3 = Integer.parseInt(this.f16586ETF);
                this.f16593lgHUyS = 0;
                int[] iArr2 = this.f16596rkYL;
                int i4 = this.f16589MiMN - 1;
                iArr2[i4] = iArr2[i4] + 1;
                return i3;
            } catch (NumberFormatException unused) {
            }
        }
        this.f16593lgHUyS = 11;
        double d = Double.parseDouble(this.f16586ETF);
        int i5 = (int) d;
        if (i5 != d) {
            throw new NumberFormatException("Expected an int but was " + this.f16586ETF + m13561huTpC());
        }
        this.f16586ETF = null;
        this.f16593lgHUyS = 0;
        int[] iArr3 = this.f16596rkYL;
        int i6 = this.f16589MiMN - 1;
        iArr3[i6] = iArr3[i6] + 1;
        return i5;
    }

    /* renamed from: vadzgd */
    public final IOException m13568vadzgd(String str) throws C4854x1 {
        throw new C4854x1(str + m13561huTpC());
    }

    /* renamed from: wJVbdd */
    public void mo13569wJVbdd() throws IOException {
        int iM13565qdMbNW = this.f16593lgHUyS;
        if (iM13565qdMbNW == 0) {
            iM13565qdMbNW = m13565qdMbNW();
        }
        if (iM13565qdMbNW == 7) {
            this.f16593lgHUyS = 0;
            int[] iArr = this.f16596rkYL;
            int i = this.f16589MiMN - 1;
            iArr[i] = iArr[i] + 1;
            return;
        }
        throw new IllegalStateException("Expected null but was " + mo13542CqaNbM() + m13561huTpC());
    }

    /* renamed from: xJ */
    public final void m13570xJ() throws IOException {
        if (!this.f16584AZxh) {
            throw m13568vadzgd("Use JsonReader.setLenient(true) to accept malformed JSON");
        }
    }

    /* renamed from: xrEuO */
    public final int m13571xrEuO() {
        String str;
        String str2;
        int i;
        char c = this.f16597wA[this.f16592ZfxDd];
        if (c == 't' || c == 'T') {
            str = "true";
            str2 = "TRUE";
            i = 5;
        } else if (c == 'f' || c == 'F') {
            str = "false";
            str2 = "FALSE";
            i = 6;
        } else {
            if (c != 'n' && c != 'N') {
                return 0;
            }
            str = "null";
            str2 = "NULL";
            i = 7;
        }
        int length = str.length();
        for (int i2 = 1; i2 < length; i2++) {
            if (this.f16592ZfxDd + i2 >= this.f16588KLFTb && !m13560fehf(i2 + 1)) {
                return 0;
            }
            char c2 = this.f16597wA[this.f16592ZfxDd + i2];
            if (c2 != str.charAt(i2) && c2 != str2.charAt(i2)) {
                return 0;
            }
        }
        if ((this.f16592ZfxDd + length < this.f16588KLFTb || m13560fehf(length + 1)) && m13552Ucbh(this.f16597wA[this.f16592ZfxDd + length])) {
            return 0;
        }
        this.f16592ZfxDd += length;
        this.f16593lgHUyS = i;
        return i;
    }

    /* renamed from: zvd */
    public final void m13572zvd(int i) {
        int i2 = this.f16589MiMN;
        int[] iArr = this.f16590VA;
        if (i2 == iArr.length) {
            int i3 = i2 * 2;
            this.f16590VA = Arrays.copyOf(iArr, i3);
            this.f16596rkYL = Arrays.copyOf(this.f16596rkYL, i3);
            this.f16591YoKzxo = (String[]) Arrays.copyOf(this.f16591YoKzxo, i3);
        }
        int[] iArr2 = this.f16590VA;
        int i4 = this.f16589MiMN;
        this.f16589MiMN = i4 + 1;
        iArr2[i4] = i;
    }
}
