package p131o;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

/* renamed from: o.A0 */
/* loaded from: classes.dex */
public class C1598A0 implements Closeable, Flushable {

    /* renamed from: Dt */
    public static final String[] f7301Dt = new String[128];

    /* renamed from: ETF */
    public static final String[] f7302ETF;

    /* renamed from: JHa */
    public boolean f7304JHa;

    /* renamed from: KLFTb */
    public String f7305KLFTb;

    /* renamed from: ZfxDd */
    public String f7306ZfxDd;

    /* renamed from: lgHUyS */
    public String f7307lgHUyS;

    /* renamed from: mjFkc */
    public final Writer f7308mjFkc;

    /* renamed from: qdMbNW */
    public boolean f7309qdMbNW;

    /* renamed from: xJ */
    public boolean f7311xJ;

    /* renamed from: AZxh */
    public int[] f7303AZxh = new int[32];

    /* renamed from: wA */
    public int f7310wA = 0;

    static {
        for (int i = 0; i <= 31; i++) {
            f7301Dt[i] = String.format("\\u%04x", Integer.valueOf(i));
        }
        String[] strArr = f7301Dt;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        f7302ETF = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public C1598A0(Writer writer) {
        m7525HGpJ(6);
        this.f7305KLFTb = ":";
        this.f7309qdMbNW = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.f7308mjFkc = writer;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0034  */
    /* renamed from: BAnRFn */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m7522BAnRFn(String str) throws IOException {
        String str2;
        String[] strArr = this.f7311xJ ? f7302ETF : f7301Dt;
        this.f7308mjFkc.write(34);
        int length = str.length();
        int i = 0;
        for (int i2 = 0; i2 < length; i2++) {
            char cCharAt = str.charAt(i2);
            if (cCharAt < 128) {
                str2 = strArr[cCharAt];
                if (str2 != null) {
                    if (i < i2) {
                        this.f7308mjFkc.write(str, i, i2 - i);
                    }
                    this.f7308mjFkc.write(str2);
                    i = i2 + 1;
                }
            } else {
                if (cCharAt == 8232) {
                    str2 = "\\u2028";
                } else if (cCharAt == 8233) {
                    str2 = "\\u2029";
                }
                if (i < i2) {
                }
                this.f7308mjFkc.write(str2);
                i = i2 + 1;
            }
        }
        if (i < length) {
            this.f7308mjFkc.write(str, i, length - i);
        }
        this.f7308mjFkc.write(34);
    }

    /* renamed from: CqaNbM */
    public final void m7523CqaNbM() throws IOException {
        if (this.f7307lgHUyS != null) {
            m7534ZfxDd();
            m7522BAnRFn(this.f7307lgHUyS);
            this.f7307lgHUyS = null;
        }
    }

    /* renamed from: Gd */
    public final int m7524Gd() {
        int i = this.f7310wA;
        if (i != 0) {
            return this.f7303AZxh[i - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    /* renamed from: HGpJ */
    public final void m7525HGpJ(int i) {
        int i2 = this.f7310wA;
        int[] iArr = this.f7303AZxh;
        if (i2 == iArr.length) {
            this.f7303AZxh = Arrays.copyOf(iArr, i2 * 2);
        }
        int[] iArr2 = this.f7303AZxh;
        int i3 = this.f7310wA;
        this.f7310wA = i3 + 1;
        iArr2[i3] = i;
    }

    /* renamed from: KLFTb */
    public final void m7526KLFTb() throws IOException {
        int iM7524Gd = m7524Gd();
        if (iM7524Gd == 1) {
            m7543vI(2);
            m7536eyqo();
            return;
        }
        if (iM7524Gd == 2) {
            this.f7308mjFkc.append(',');
            m7536eyqo();
        } else {
            if (iM7524Gd == 4) {
                this.f7308mjFkc.append((CharSequence) this.f7305KLFTb);
                m7543vI(5);
                return;
            }
            if (iM7524Gd != 6) {
                if (iM7524Gd != 7) {
                    throw new IllegalStateException("Nesting problem.");
                }
                if (!this.f7304JHa) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            m7543vI(7);
        }
    }

    /* renamed from: MiMN */
    public C1598A0 mo7527MiMN() {
        return m7542qdMbNW(3, 5, '}');
    }

    /* renamed from: Ne */
    public C1598A0 mo7528Ne(boolean z) throws IOException {
        m7523CqaNbM();
        m7526KLFTb();
        this.f7308mjFkc.write(z ? "true" : "false");
        return this;
    }

    /* renamed from: OjSQV */
    public C1598A0 mo7529OjSQV(String str) throws IOException {
        if (str == null) {
            return mo7531Ucbh();
        }
        m7523CqaNbM();
        m7526KLFTb();
        m7522BAnRFn(str);
        return this;
    }

    /* renamed from: Pq */
    public boolean m7530Pq() {
        return this.f7304JHa;
    }

    /* renamed from: Ucbh */
    public C1598A0 mo7531Ucbh() throws IOException {
        if (this.f7307lgHUyS != null) {
            if (!this.f7309qdMbNW) {
                this.f7307lgHUyS = null;
                return this;
            }
            m7523CqaNbM();
        }
        m7526KLFTb();
        this.f7308mjFkc.write("null");
        return this;
    }

    /* renamed from: VA */
    public C1598A0 mo7532VA() {
        return m7542qdMbNW(1, 2, ']');
    }

    /* renamed from: VocHEe */
    public final void m7533VocHEe(boolean z) {
        this.f7304JHa = z;
    }

    /* renamed from: ZfxDd */
    public final void m7534ZfxDd() throws IOException {
        int iM7524Gd = m7524Gd();
        if (iM7524Gd == 5) {
            this.f7308mjFkc.write(44);
        } else if (iM7524Gd != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        m7536eyqo();
        m7543vI(4);
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f7308mjFkc.close();
        int i = this.f7310wA;
        if (i > 1 || (i == 1 && this.f7303AZxh[i - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.f7310wA = 0;
    }

    /* renamed from: diqgf */
    public C1598A0 mo7535diqgf(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f7307lgHUyS != null) {
            throw new IllegalStateException();
        }
        if (this.f7310wA == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f7307lgHUyS = str;
        return this;
    }

    /* renamed from: eyqo */
    public final void m7536eyqo() throws IOException {
        if (this.f7306ZfxDd == null) {
            return;
        }
        this.f7308mjFkc.write(10);
        int i = this.f7310wA;
        for (int i2 = 1; i2 < i; i2++) {
            this.f7308mjFkc.write(this.f7306ZfxDd);
        }
    }

    /* renamed from: fehf */
    public final boolean m7537fehf() {
        return this.f7309qdMbNW;
    }

    @Override // java.io.Flushable
    public void flush() throws IOException {
        if (this.f7310wA == 0) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.f7308mjFkc.flush();
    }

    /* renamed from: huTpC */
    public final C1598A0 m7538huTpC(int i, char c) throws IOException {
        m7526KLFTb();
        m7525HGpJ(i);
        this.f7308mjFkc.write(c);
        return this;
    }

    /* renamed from: lB */
    public C1598A0 mo7539lB(long j) throws IOException {
        m7523CqaNbM();
        m7526KLFTb();
        this.f7308mjFkc.write(Long.toString(j));
        return this;
    }

    /* renamed from: lgHUyS */
    public C1598A0 mo7540lgHUyS() throws IOException {
        m7523CqaNbM();
        return m7538huTpC(3, '{');
    }

    /* renamed from: mByQ */
    public C1598A0 mo7541mByQ(Number number) throws IOException {
        if (number == null) {
            return mo7531Ucbh();
        }
        m7523CqaNbM();
        String string = number.toString();
        if (this.f7304JHa || !(string.equals("-Infinity") || string.equals("Infinity") || string.equals("NaN"))) {
            m7526KLFTb();
            this.f7308mjFkc.append((CharSequence) string);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }

    /* renamed from: qdMbNW */
    public final C1598A0 m7542qdMbNW(int i, int i2, char c) throws IOException {
        int iM7524Gd = m7524Gd();
        if (iM7524Gd != i2 && iM7524Gd != i) {
            throw new IllegalStateException("Nesting problem.");
        }
        if (this.f7307lgHUyS != null) {
            throw new IllegalStateException("Dangling name: " + this.f7307lgHUyS);
        }
        this.f7310wA--;
        if (iM7524Gd == i2) {
            m7536eyqo();
        }
        this.f7308mjFkc.write(c);
        return this;
    }

    /* renamed from: vI */
    public final void m7543vI(int i) {
        this.f7303AZxh[this.f7310wA - 1] = i;
    }

    /* renamed from: wJVbdd */
    public C1598A0 mo7544wJVbdd(Boolean bool) throws IOException {
        if (bool == null) {
            return mo7531Ucbh();
        }
        m7523CqaNbM();
        m7526KLFTb();
        this.f7308mjFkc.write(bool.booleanValue() ? "true" : "false");
        return this;
    }

    /* renamed from: xJ */
    public C1598A0 mo7545xJ() throws IOException {
        m7523CqaNbM();
        return m7538huTpC(1, '[');
    }
}
