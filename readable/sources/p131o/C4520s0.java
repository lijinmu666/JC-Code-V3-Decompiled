package p131o;

import java.math.BigInteger;

/* renamed from: o.s0 */
/* loaded from: classes.dex */
public final class C4520s0 extends AbstractC4187n0 {

    /* renamed from: mjFkc */
    public final Object f16408mjFkc;

    public C4520s0(Boolean bool) {
        this.f16408mjFkc = AbstractC4168mjFkc.m12790mjFkc(bool);
    }

    /* renamed from: diqgf */
    public static boolean m13433diqgf(C4520s0 c4520s0) {
        Object obj = c4520s0.f16408mjFkc;
        if (!(obj instanceof Number)) {
            return false;
        }
        Number number = (Number) obj;
        return (number instanceof BigInteger) || (number instanceof Long) || (number instanceof Integer) || (number instanceof Short) || (number instanceof Byte);
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: Dt */
    public long mo12262Dt() {
        return m13438eyqo() ? mo12263ETF().longValue() : Long.parseLong(mo12267VA());
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: ETF */
    public Number mo12263ETF() {
        Object obj = this.f16408mjFkc;
        return obj instanceof String ? new C2477N0((String) obj) : (Number) obj;
    }

    /* renamed from: IEE */
    public int m13434IEE() {
        return m13438eyqo() ? mo12263ETF().intValue() : Integer.parseInt(mo12267VA());
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: JHa */
    public double mo12265JHa() {
        return m13438eyqo() ? mo12263ETF().doubleValue() : Double.parseDouble(mo12267VA());
    }

    /* renamed from: Pq */
    public boolean m13435Pq() {
        return this.f16408mjFkc instanceof Boolean;
    }

    /* renamed from: Ucbh */
    public boolean m13436Ucbh() {
        return this.f16408mjFkc instanceof String;
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: VA */
    public String mo12267VA() {
        return m13438eyqo() ? mo12263ETF().toString() : m13435Pq() ? ((Boolean) this.f16408mjFkc).toString() : (String) this.f16408mjFkc;
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: ZfxDd */
    public boolean mo12268ZfxDd() {
        return m13435Pq() ? ((Boolean) this.f16408mjFkc).booleanValue() : Boolean.parseBoolean(mo12267VA());
    }

    /* renamed from: equals */
    public boolean m13437equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || C4520s0.class != obj.getClass()) {
            return false;
        }
        C4520s0 c4520s0 = (C4520s0) obj;
        if (this.f16408mjFkc == null) {
            return c4520s0.f16408mjFkc == null;
        }
        if (m13433diqgf(this) && m13433diqgf(c4520s0)) {
            return mo12263ETF().longValue() == c4520s0.mo12263ETF().longValue();
        }
        Object obj2 = this.f16408mjFkc;
        if (!(obj2 instanceof Number) || !(c4520s0.f16408mjFkc instanceof Number)) {
            return obj2.equals(c4520s0.f16408mjFkc);
        }
        double dDoubleValue = mo12263ETF().doubleValue();
        double dDoubleValue2 = c4520s0.mo12263ETF().doubleValue();
        if (dDoubleValue != dDoubleValue2) {
            return Double.isNaN(dDoubleValue) && Double.isNaN(dDoubleValue2);
        }
        return true;
    }

    /* renamed from: eyqo */
    public boolean m13438eyqo() {
        return this.f16408mjFkc instanceof Number;
    }

    @Override // p131o.AbstractC4187n0
    /* renamed from: fehf, reason: merged with bridge method [inline-methods] */
    public C4520s0 mo12272mjFkc() {
        return this;
    }

    public int hashCode() {
        long jDoubleToLongBits;
        if (this.f16408mjFkc == null) {
            return 31;
        }
        if (m13433diqgf(this)) {
            jDoubleToLongBits = mo12263ETF().longValue();
        } else {
            Object obj = this.f16408mjFkc;
            if (!(obj instanceof Number)) {
                return obj.hashCode();
            }
            jDoubleToLongBits = Double.doubleToLongBits(mo12263ETF().doubleValue());
        }
        return (int) ((jDoubleToLongBits >>> 32) ^ jDoubleToLongBits);
    }

    public C4520s0(Number number) {
        this.f16408mjFkc = AbstractC4168mjFkc.m12790mjFkc(number);
    }

    public C4520s0(String str) {
        this.f16408mjFkc = AbstractC4168mjFkc.m12790mjFkc(str);
    }
}
