package p131o;

import java.io.IOException;
import java.io.StringWriter;

/* renamed from: o.n0 */
/* loaded from: classes.dex */
public abstract class AbstractC4187n0 {
    /* renamed from: Dt */
    public long mo12262Dt() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: ETF */
    public Number mo12263ETF() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: JHa */
    public double mo12265JHa() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: MiMN */
    public boolean m12830MiMN() {
        return this instanceof C3858i0;
    }

    /* renamed from: VA */
    public String mo12267VA() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: YoKzxo */
    public boolean m12831YoKzxo() {
        return this instanceof C4318p0;
    }

    /* renamed from: ZfxDd */
    public boolean mo12268ZfxDd() {
        throw new UnsupportedOperationException(getClass().getSimpleName());
    }

    /* renamed from: lgHUyS */
    public C4385q0 m12832lgHUyS() {
        if (m12835rkYL()) {
            return (C4385q0) this;
        }
        throw new IllegalStateException("Not a JSON Object: " + this);
    }

    /* renamed from: mjFkc */
    public abstract AbstractC4187n0 mo12272mjFkc();

    /* renamed from: qGY */
    public boolean m12833qGY() {
        return this instanceof C4520s0;
    }

    /* renamed from: qdMbNW */
    public C4520s0 m12834qdMbNW() {
        if (m12833qGY()) {
            return (C4520s0) this;
        }
        throw new IllegalStateException("Not a JSON Primitive: " + this);
    }

    /* renamed from: rkYL */
    public boolean m12835rkYL() {
        return this instanceof C4385q0;
    }

    public String toString() {
        try {
            StringWriter stringWriter = new StringWriter();
            C1598A0 c1598a0 = new C1598A0(stringWriter);
            c1598a0.m7533VocHEe(true);
            AbstractC4194n7.m12849AZxh(this, c1598a0);
            return stringWriter.toString();
        } catch (IOException e) {
            throw new AssertionError(e);
        }
    }

    /* renamed from: xJ */
    public C3858i0 m12836xJ() {
        if (m12830MiMN()) {
            return (C3858i0) this;
        }
        throw new IllegalStateException("Not a JSON Array: " + this);
    }
}
