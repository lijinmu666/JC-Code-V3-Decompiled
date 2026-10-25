package p131o;

import java.io.Reader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import p094kotlin.p117text.Typography;

/* renamed from: o.x0 */
/* loaded from: classes.dex */
public final class C4853x0 extends C4587t0 {

    /* renamed from: diqgf */
    public static final Reader f17302diqgf = new mjFkc();

    /* renamed from: eyqo */
    public static final Object f17303eyqo = new Object();

    /* renamed from: IEE */
    public String[] f17304IEE;

    /* renamed from: Pq */
    public int[] f17305Pq;

    /* renamed from: fehf */
    public int f17306fehf;

    /* renamed from: qGY */
    public Object[] f17307qGY;

    /* renamed from: o.x0$mjFkc */
    public class mjFkc extends Reader {
        @Override // java.io.Reader, java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            throw new AssertionError();
        }

        @Override // java.io.Reader
        public int read(char[] cArr, int i, int i2) {
            throw new AssertionError();
        }
    }

    public C4853x0(AbstractC4187n0 abstractC4187n0) {
        super(f17302diqgf);
        this.f17307qGY = new Object[32];
        this.f17306fehf = 0;
        this.f17304IEE = new String[32];
        this.f17305Pq = new int[32];
        m13876GMIER(abstractC4187n0);
    }

    /* renamed from: huTpC */
    private String m13875huTpC() {
        return " at path " + mo13551Pq();
    }

    @Override // p131o.C4587t0
    /* renamed from: BAnRFn */
    public String mo13541BAnRFn() {
        m13880oCFDzJ(EnumC4786w0.NAME);
        Map.Entry entry = (Map.Entry) ((Iterator) m13878WrLQs()).next();
        String str = (String) entry.getKey();
        this.f17304IEE[this.f17306fehf - 1] = str;
        m13876GMIER(entry.getValue());
        return str;
    }

    @Override // p131o.C4587t0
    /* renamed from: CqaNbM */
    public EnumC4786w0 mo13542CqaNbM() {
        if (this.f17306fehf == 0) {
            return EnumC4786w0.END_DOCUMENT;
        }
        Object objM13878WrLQs = m13878WrLQs();
        if (objM13878WrLQs instanceof Iterator) {
            boolean z = this.f17307qGY[this.f17306fehf - 2] instanceof C4385q0;
            Iterator it = (Iterator) objM13878WrLQs;
            if (!it.hasNext()) {
                return z ? EnumC4786w0.END_OBJECT : EnumC4786w0.END_ARRAY;
            }
            if (z) {
                return EnumC4786w0.NAME;
            }
            m13876GMIER(it.next());
            return mo13542CqaNbM();
        }
        if (objM13878WrLQs instanceof C4385q0) {
            return EnumC4786w0.BEGIN_OBJECT;
        }
        if (objM13878WrLQs instanceof C3858i0) {
            return EnumC4786w0.BEGIN_ARRAY;
        }
        if (!(objM13878WrLQs instanceof C4520s0)) {
            if (objM13878WrLQs instanceof C4318p0) {
                return EnumC4786w0.NULL;
            }
            if (objM13878WrLQs == f17303eyqo) {
                throw new IllegalStateException("JsonReader is closed");
            }
            throw new AssertionError();
        }
        C4520s0 c4520s0 = (C4520s0) objM13878WrLQs;
        if (c4520s0.m13436Ucbh()) {
            return EnumC4786w0.STRING;
        }
        if (c4520s0.m13435Pq()) {
            return EnumC4786w0.BOOLEAN;
        }
        if (c4520s0.m13438eyqo()) {
            return EnumC4786w0.NUMBER;
        }
        throw new AssertionError();
    }

    /* renamed from: GMIER */
    public final void m13876GMIER(Object obj) {
        int i = this.f17306fehf;
        Object[] objArr = this.f17307qGY;
        if (i == objArr.length) {
            int i2 = i * 2;
            this.f17307qGY = Arrays.copyOf(objArr, i2);
            this.f17305Pq = Arrays.copyOf(this.f17305Pq, i2);
            this.f17304IEE = (String[]) Arrays.copyOf(this.f17304IEE, i2);
        }
        Object[] objArr2 = this.f17307qGY;
        int i3 = this.f17306fehf;
        this.f17306fehf = i3 + 1;
        objArr2[i3] = obj;
    }

    @Override // p131o.C4587t0
    /* renamed from: Gd */
    public boolean mo13543Gd() {
        m13880oCFDzJ(EnumC4786w0.BOOLEAN);
        boolean zMo12268ZfxDd = ((C4520s0) m13877KRTLGT()).mo12268ZfxDd();
        int i = this.f17306fehf;
        if (i > 0) {
            int[] iArr = this.f17305Pq;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return zMo12268ZfxDd;
    }

    @Override // p131o.C4587t0
    /* renamed from: HGpJ */
    public double mo13544HGpJ() {
        EnumC4786w0 enumC4786w0Mo13542CqaNbM = mo13542CqaNbM();
        EnumC4786w0 enumC4786w0 = EnumC4786w0.NUMBER;
        if (enumC4786w0Mo13542CqaNbM != enumC4786w0 && enumC4786w0Mo13542CqaNbM != EnumC4786w0.STRING) {
            throw new IllegalStateException("Expected " + enumC4786w0 + " but was " + enumC4786w0Mo13542CqaNbM + m13875huTpC());
        }
        double dMo12265JHa = ((C4520s0) m13878WrLQs()).mo12265JHa();
        if (!m13559eyqo() && (Double.isNaN(dMo12265JHa) || Double.isInfinite(dMo12265JHa))) {
            throw new NumberFormatException("JSON forbids NaN and infinities: " + dMo12265JHa);
        }
        m13877KRTLGT();
        int i = this.f17306fehf;
        if (i > 0) {
            int[] iArr = this.f17305Pq;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return dMo12265JHa;
    }

    @Override // p131o.C4587t0
    /* renamed from: KLFTb */
    public void mo13545KLFTb() {
        m13880oCFDzJ(EnumC4786w0.BEGIN_OBJECT);
        m13876GMIER(((C4385q0) m13878WrLQs()).m13157eyqo().iterator());
    }

    /* renamed from: KRTLGT */
    public final Object m13877KRTLGT() {
        Object[] objArr = this.f17307qGY;
        int i = this.f17306fehf - 1;
        this.f17306fehf = i;
        Object obj = objArr[i];
        objArr[i] = null;
        return obj;
    }

    @Override // p131o.C4587t0
    /* renamed from: MiMN */
    public void mo13547MiMN() {
        m13880oCFDzJ(EnumC4786w0.END_OBJECT);
        m13877KRTLGT();
        m13877KRTLGT();
        int i = this.f17306fehf;
        if (i > 0) {
            int[] iArr = this.f17305Pq;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // p131o.C4587t0
    /* renamed from: OjSQV */
    public String mo13550OjSQV() {
        EnumC4786w0 enumC4786w0Mo13542CqaNbM = mo13542CqaNbM();
        EnumC4786w0 enumC4786w0 = EnumC4786w0.STRING;
        if (enumC4786w0Mo13542CqaNbM == enumC4786w0 || enumC4786w0Mo13542CqaNbM == EnumC4786w0.NUMBER) {
            String strMo12267VA = ((C4520s0) m13877KRTLGT()).mo12267VA();
            int i = this.f17306fehf;
            if (i > 0) {
                int[] iArr = this.f17305Pq;
                int i2 = i - 1;
                iArr[i2] = iArr[i2] + 1;
            }
            return strMo12267VA;
        }
        throw new IllegalStateException("Expected " + enumC4786w0 + " but was " + enumC4786w0Mo13542CqaNbM + m13875huTpC());
    }

    @Override // p131o.C4587t0
    /* renamed from: Pq */
    public String mo13551Pq() {
        StringBuilder sb = new StringBuilder();
        sb.append(Typography.f5414dollar);
        int i = 0;
        while (true) {
            int i2 = this.f17306fehf;
            if (i >= i2) {
                return sb.toString();
            }
            Object[] objArr = this.f17307qGY;
            Object obj = objArr[i];
            if (obj instanceof C3858i0) {
                i++;
                if (i < i2 && (objArr[i] instanceof Iterator)) {
                    sb.append('[');
                    sb.append(this.f17305Pq[i]);
                    sb.append(']');
                }
            } else if ((obj instanceof C4385q0) && (i = i + 1) < i2 && (objArr[i] instanceof Iterator)) {
                sb.append('.');
                String str = this.f17304IEE[i];
                if (str != null) {
                    sb.append(str);
                }
            }
            i++;
        }
    }

    @Override // p131o.C4587t0
    /* renamed from: VA */
    public void mo13553VA() {
        m13880oCFDzJ(EnumC4786w0.END_ARRAY);
        m13877KRTLGT();
        m13877KRTLGT();
        int i = this.f17306fehf;
        if (i > 0) {
            int[] iArr = this.f17305Pq;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }

    @Override // p131o.C4587t0
    /* renamed from: VocHEe */
    public long mo13555VocHEe() {
        EnumC4786w0 enumC4786w0Mo13542CqaNbM = mo13542CqaNbM();
        EnumC4786w0 enumC4786w0 = EnumC4786w0.NUMBER;
        if (enumC4786w0Mo13542CqaNbM != enumC4786w0 && enumC4786w0Mo13542CqaNbM != EnumC4786w0.STRING) {
            throw new IllegalStateException("Expected " + enumC4786w0 + " but was " + enumC4786w0Mo13542CqaNbM + m13875huTpC());
        }
        long jMo12262Dt = ((C4520s0) m13878WrLQs()).mo12262Dt();
        m13877KRTLGT();
        int i = this.f17306fehf;
        if (i > 0) {
            int[] iArr = this.f17305Pq;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return jMo12262Dt;
    }

    /* renamed from: WrLQs */
    public final Object m13878WrLQs() {
        return this.f17307qGY[this.f17306fehf - 1];
    }

    @Override // p131o.C4587t0
    /* renamed from: ZfxDd */
    public void mo13556ZfxDd() {
        m13880oCFDzJ(EnumC4786w0.BEGIN_ARRAY);
        m13876GMIER(((C3858i0) m13878WrLQs()).iterator());
        this.f17305Pq[this.f17306fehf - 1] = 0;
    }

    /* renamed from: aqHPIZ */
    public AbstractC4187n0 m13879aqHPIZ() {
        EnumC4786w0 enumC4786w0Mo13542CqaNbM = mo13542CqaNbM();
        if (enumC4786w0Mo13542CqaNbM != EnumC4786w0.NAME && enumC4786w0Mo13542CqaNbM != EnumC4786w0.END_ARRAY && enumC4786w0Mo13542CqaNbM != EnumC4786w0.END_OBJECT && enumC4786w0Mo13542CqaNbM != EnumC4786w0.END_DOCUMENT) {
            AbstractC4187n0 abstractC4187n0 = (AbstractC4187n0) m13878WrLQs();
            m13881uHVRx();
            return abstractC4187n0;
        }
        throw new IllegalStateException("Unexpected " + enumC4786w0Mo13542CqaNbM + " when reading a JsonElement.");
    }

    @Override // p131o.C4587t0, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f17307qGY = new Object[]{f17303eyqo};
        this.f17306fehf = 1;
    }

    @Override // p131o.C4587t0
    /* renamed from: diqgf */
    public boolean mo13558diqgf() {
        EnumC4786w0 enumC4786w0Mo13542CqaNbM = mo13542CqaNbM();
        return (enumC4786w0Mo13542CqaNbM == EnumC4786w0.END_OBJECT || enumC4786w0Mo13542CqaNbM == EnumC4786w0.END_ARRAY) ? false : true;
    }

    /* renamed from: oCFDzJ */
    public final void m13880oCFDzJ(EnumC4786w0 enumC4786w0) {
        if (mo13542CqaNbM() == enumC4786w0) {
            return;
        }
        throw new IllegalStateException("Expected " + enumC4786w0 + " but was " + mo13542CqaNbM() + m13875huTpC());
    }

    @Override // p131o.C4587t0
    public String toString() {
        return C4853x0.class.getSimpleName() + m13875huTpC();
    }

    /* renamed from: uHVRx */
    public void m13881uHVRx() {
        if (mo13542CqaNbM() == EnumC4786w0.NAME) {
            mo13541BAnRFn();
            this.f17304IEE[this.f17306fehf - 2] = "null";
        } else {
            m13877KRTLGT();
            int i = this.f17306fehf;
            if (i > 0) {
                this.f17304IEE[i - 1] = "null";
            }
        }
        int i2 = this.f17306fehf;
        if (i2 > 0) {
            int[] iArr = this.f17305Pq;
            int i3 = i2 - 1;
            iArr[i3] = iArr[i3] + 1;
        }
    }

    @Override // p131o.C4587t0
    /* renamed from: vI */
    public int mo13567vI() {
        EnumC4786w0 enumC4786w0Mo13542CqaNbM = mo13542CqaNbM();
        EnumC4786w0 enumC4786w0 = EnumC4786w0.NUMBER;
        if (enumC4786w0Mo13542CqaNbM != enumC4786w0 && enumC4786w0Mo13542CqaNbM != EnumC4786w0.STRING) {
            throw new IllegalStateException("Expected " + enumC4786w0 + " but was " + enumC4786w0Mo13542CqaNbM + m13875huTpC());
        }
        int iM13434IEE = ((C4520s0) m13878WrLQs()).m13434IEE();
        m13877KRTLGT();
        int i = this.f17306fehf;
        if (i > 0) {
            int[] iArr = this.f17305Pq;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
        return iM13434IEE;
    }

    @Override // p131o.C4587t0
    /* renamed from: wJVbdd */
    public void mo13569wJVbdd() {
        m13880oCFDzJ(EnumC4786w0.NULL);
        m13877KRTLGT();
        int i = this.f17306fehf;
        if (i > 0) {
            int[] iArr = this.f17305Pq;
            int i2 = i - 1;
            iArr[i2] = iArr[i2] + 1;
        }
    }
}
