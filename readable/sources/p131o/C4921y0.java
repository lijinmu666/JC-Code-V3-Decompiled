package p131o;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

/* renamed from: o.y0 */
/* loaded from: classes.dex */
public final class C4921y0 extends C1598A0 {

    /* renamed from: MiMN */
    public String f17469MiMN;

    /* renamed from: VA */
    public final List f17470VA;

    /* renamed from: YoKzxo */
    public AbstractC4187n0 f17471YoKzxo;

    /* renamed from: rkYL */
    public static final Writer f17468rkYL = new mjFkc();

    /* renamed from: qGY */
    public static final C4520s0 f17467qGY = new C4520s0("closed");

    /* renamed from: o.y0$mjFkc */
    public class mjFkc extends Writer {
        @Override // java.io.Writer, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Writer, java.io.Flushable
        public void flush() {
            throw new AssertionError();
        }

        @Override // java.io.Writer
        public void write(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public C4921y0() {
        super(f17468rkYL);
        this.f17470VA = new ArrayList();
        this.f17471YoKzxo = C4318p0.f15892mjFkc;
    }

    /* renamed from: KLMXS */
    public final AbstractC4187n0 m13978KLMXS() {
        return (AbstractC4187n0) this.f17470VA.get(r1.size() - 1);
    }

    @Override // p131o.C1598A0
    /* renamed from: MiMN */
    public C1598A0 mo7527MiMN() {
        if (this.f17470VA.isEmpty() || this.f17469MiMN != null) {
            throw new IllegalStateException();
        }
        if (!(m13978KLMXS() instanceof C4385q0)) {
            throw new IllegalStateException();
        }
        this.f17470VA.remove(r0.size() - 1);
        return this;
    }

    @Override // p131o.C1598A0
    /* renamed from: Ne */
    public C1598A0 mo7528Ne(boolean z) {
        m13980zvd(new C4520s0(Boolean.valueOf(z)));
        return this;
    }

    @Override // p131o.C1598A0
    /* renamed from: OjSQV */
    public C1598A0 mo7529OjSQV(String str) {
        if (str == null) {
            return mo7531Ucbh();
        }
        m13980zvd(new C4520s0(str));
        return this;
    }

    @Override // p131o.C1598A0
    /* renamed from: Ucbh */
    public C1598A0 mo7531Ucbh() {
        m13980zvd(C4318p0.f15892mjFkc);
        return this;
    }

    @Override // p131o.C1598A0
    /* renamed from: VA */
    public C1598A0 mo7532VA() {
        if (this.f17470VA.isEmpty() || this.f17469MiMN != null) {
            throw new IllegalStateException();
        }
        if (!(m13978KLMXS() instanceof C3858i0)) {
            throw new IllegalStateException();
        }
        this.f17470VA.remove(r0.size() - 1);
        return this;
    }

    @Override // p131o.C1598A0, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (!this.f17470VA.isEmpty()) {
            throw new IOException("Incomplete document");
        }
        this.f17470VA.add(f17467qGY);
    }

    @Override // p131o.C1598A0
    /* renamed from: diqgf */
    public C1598A0 mo7535diqgf(String str) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        if (this.f17470VA.isEmpty() || this.f17469MiMN != null) {
            throw new IllegalStateException();
        }
        if (!(m13978KLMXS() instanceof C4385q0)) {
            throw new IllegalStateException();
        }
        this.f17469MiMN = str;
        return this;
    }

    @Override // p131o.C1598A0, java.io.Flushable
    public void flush() {
    }

    @Override // p131o.C1598A0
    /* renamed from: lB */
    public C1598A0 mo7539lB(long j) {
        m13980zvd(new C4520s0(Long.valueOf(j)));
        return this;
    }

    @Override // p131o.C1598A0
    /* renamed from: lgHUyS */
    public C1598A0 mo7540lgHUyS() {
        C4385q0 c4385q0 = new C4385q0();
        m13980zvd(c4385q0);
        this.f17470VA.add(c4385q0);
        return this;
    }

    @Override // p131o.C1598A0
    /* renamed from: mByQ */
    public C1598A0 mo7541mByQ(Number number) {
        if (number == null) {
            return mo7531Ucbh();
        }
        if (!m7530Pq()) {
            double dDoubleValue = number.doubleValue();
            if (Double.isNaN(dDoubleValue) || Double.isInfinite(dDoubleValue)) {
                throw new IllegalArgumentException("JSON forbids NaN and infinities: " + number);
            }
        }
        m13980zvd(new C4520s0(number));
        return this;
    }

    @Override // p131o.C1598A0
    /* renamed from: wJVbdd */
    public C1598A0 mo7544wJVbdd(Boolean bool) {
        if (bool == null) {
            return mo7531Ucbh();
        }
        m13980zvd(new C4520s0(bool));
        return this;
    }

    @Override // p131o.C1598A0
    /* renamed from: xJ */
    public C1598A0 mo7545xJ() {
        C3858i0 c3858i0 = new C3858i0();
        m13980zvd(c3858i0);
        this.f17470VA.add(c3858i0);
        return this;
    }

    /* renamed from: xrEuO */
    public AbstractC4187n0 m13979xrEuO() {
        if (this.f17470VA.isEmpty()) {
            return this.f17471YoKzxo;
        }
        throw new IllegalStateException("Expected one JSON element but was " + this.f17470VA);
    }

    /* renamed from: zvd */
    public final void m13980zvd(AbstractC4187n0 abstractC4187n0) {
        if (this.f17469MiMN != null) {
            if (!abstractC4187n0.m12831YoKzxo() || m7537fehf()) {
                ((C4385q0) m13978KLMXS()).m13158fehf(this.f17469MiMN, abstractC4187n0);
            }
            this.f17469MiMN = null;
            return;
        }
        if (this.f17470VA.isEmpty()) {
            this.f17471YoKzxo = abstractC4187n0;
            return;
        }
        AbstractC4187n0 abstractC4187n0M13978KLMXS = m13978KLMXS();
        if (!(abstractC4187n0M13978KLMXS instanceof C3858i0)) {
            throw new IllegalStateException();
        }
        ((C3858i0) abstractC4187n0M13978KLMXS).m12264IEE(abstractC4187n0);
    }
}
