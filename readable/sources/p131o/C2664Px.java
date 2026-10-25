package p131o;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* renamed from: o.Px */
/* loaded from: classes.dex */
public final class C2664Px {

    /* renamed from: ZfxDd */
    public static final C2664Px f10129ZfxDd = new C2664Px(true);

    /* renamed from: AZxh */
    public boolean f10130AZxh;

    /* renamed from: mjFkc */
    public final AbstractC3794gz f10131mjFkc = new C3332Zy();

    /* renamed from: wA */
    public boolean f10132wA;

    public C2664Px() {
    }

    /* renamed from: AZxh */
    public static int m9971AZxh(InterfaceC2601Ox interfaceC2601Ox, Object obj) {
        EnumC4784vz enumC4784vzMo9919JHa = interfaceC2601Ox.mo9919JHa();
        interfaceC2601Ox.mo9921mjFkc();
        interfaceC2601Ox.mo9920ZfxDd();
        return m9976mjFkc(enumC4784vzMo9919JHa, 32149011, obj);
    }

    /* renamed from: ETF */
    public static void m9972ETF(AbstractC2063Gx abstractC2063Gx, EnumC4784vz enumC4784vz, int i, Object obj) {
        if (enumC4784vz == EnumC4784vz.f17088VA) {
            InterfaceC2341Ky interfaceC2341Ky = (InterfaceC2341Ky) obj;
            AbstractC4183my.m12816ZfxDd(interfaceC2341Ky);
            abstractC2063Gx.mo8066BAnRFn(i, 3);
            interfaceC2341Ky.mo9293AZxh(abstractC2063Gx);
            abstractC2063Gx.mo8066BAnRFn(i, 4);
            return;
        }
        abstractC2063Gx.mo8066BAnRFn(i, enumC4784vz.m13804mjFkc());
        EnumC4851wz enumC4851wz = EnumC4851wz.INT;
        switch (enumC4784vz.ordinal()) {
            case 0:
                abstractC2063Gx.mo8072IEE(Double.doubleToRawLongBits(((Double) obj).doubleValue()));
                break;
            case 1:
                abstractC2063Gx.mo8086qGY(Float.floatToRawIntBits(((Float) obj).floatValue()));
                break;
            case 2:
                abstractC2063Gx.mo8074OjSQV(((Long) obj).longValue());
                break;
            case 3:
                abstractC2063Gx.mo8074OjSQV(((Long) obj).longValue());
                break;
            case 4:
                abstractC2063Gx.mo8080diqgf(((Integer) obj).intValue());
                break;
            case 5:
                abstractC2063Gx.mo8072IEE(((Long) obj).longValue());
                break;
            case 6:
                abstractC2063Gx.mo8086qGY(((Integer) obj).intValue());
                break;
            case 7:
                abstractC2063Gx.mo8068Dt(((Boolean) obj).booleanValue() ? (byte) 1 : (byte) 0);
                break;
            case 8:
                if (!(obj instanceof AbstractC4981yx)) {
                    abstractC2063Gx.mo8078VocHEe((String) obj);
                    break;
                } else {
                    abstractC2063Gx.mo8079YoKzxo((AbstractC4981yx) obj);
                    break;
                }
            case 9:
                ((InterfaceC2341Ky) obj).mo9293AZxh(abstractC2063Gx);
                break;
            case 10:
                abstractC2063Gx.mo8083huTpC((InterfaceC2341Ky) obj);
                break;
            case 11:
                if (!(obj instanceof AbstractC4981yx)) {
                    byte[] bArr = (byte[]) obj;
                    abstractC2063Gx.mo8077VA(bArr, 0, bArr.length);
                    break;
                } else {
                    abstractC2063Gx.mo8079YoKzxo((AbstractC4981yx) obj);
                    break;
                }
            case 12:
                abstractC2063Gx.mo8090wJVbdd(((Integer) obj).intValue());
                break;
            case 13:
                abstractC2063Gx.mo8080diqgf(((Integer) obj).intValue());
                break;
            case 14:
                abstractC2063Gx.mo8086qGY(((Integer) obj).intValue());
                break;
            case 15:
                abstractC2063Gx.mo8072IEE(((Long) obj).longValue());
                break;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                abstractC2063Gx.mo8090wJVbdd((iIntValue >> 31) ^ (iIntValue + iIntValue));
                break;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                abstractC2063Gx.mo8074OjSQV((jLongValue >> 63) ^ (jLongValue + jLongValue));
                break;
        }
    }

    /* renamed from: KLFTb */
    public static C2664Px m9973KLFTb() {
        return f10129ZfxDd;
    }

    /* renamed from: YoKzxo */
    public static Object m9974YoKzxo(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }

    /* renamed from: fehf */
    public static final int m9975fehf(Map.Entry entry) {
        InterfaceC2601Ox interfaceC2601Ox = (InterfaceC2601Ox) entry.getKey();
        Object value = entry.getValue();
        if (interfaceC2601Ox.mo9918AZxh() != EnumC4851wz.MESSAGE) {
            return m9971AZxh(interfaceC2601Ox, value);
        }
        interfaceC2601Ox.mo9920ZfxDd();
        interfaceC2601Ox.mo9922wA();
        ((InterfaceC2601Ox) entry.getKey()).mo9921mjFkc();
        int iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(8);
        return iM8470ZfxDd + iM8470ZfxDd + AbstractC2063Gx.m8470ZfxDd(16) + AbstractC2063Gx.m8470ZfxDd(32149011) + AbstractC2063Gx.m8470ZfxDd(24) + AbstractC2063Gx.m8472mjFkc((InterfaceC2341Ky) value);
    }

    /* renamed from: mjFkc */
    public static int m9976mjFkc(EnumC4784vz enumC4784vz, int i, Object obj) {
        int iMo13326JHa;
        int iM8470ZfxDd;
        int iM8470ZfxDd2 = AbstractC2063Gx.m8470ZfxDd(i << 3);
        if (enumC4784vz == EnumC4784vz.f17088VA) {
            AbstractC4183my.m12816ZfxDd((InterfaceC2341Ky) obj);
            iM8470ZfxDd2 += iM8470ZfxDd2;
        }
        EnumC4851wz enumC4851wz = EnumC4851wz.INT;
        int iM8468KLFTb = 4;
        switch (enumC4784vz.ordinal()) {
            case 0:
                ((Double) obj).doubleValue();
                iM8468KLFTb = 8;
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 1:
                ((Float) obj).floatValue();
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 2:
                iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(((Long) obj).longValue());
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 3:
                iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(((Long) obj).longValue());
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 4:
                iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(((Integer) obj).intValue());
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 5:
                ((Long) obj).longValue();
                iM8468KLFTb = 8;
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 6:
                ((Integer) obj).intValue();
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 7:
                ((Boolean) obj).booleanValue();
                iM8468KLFTb = 1;
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 8:
                if (!(obj instanceof AbstractC4981yx)) {
                    iM8468KLFTb = AbstractC2063Gx.m8473wA((String) obj);
                    return iM8470ZfxDd2 + iM8468KLFTb;
                }
                iMo13326JHa = ((AbstractC4981yx) obj).mo13326JHa();
                iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(iMo13326JHa);
                iM8468KLFTb = iM8470ZfxDd + iMo13326JHa;
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 9:
                iM8468KLFTb = ((InterfaceC2341Ky) obj).mo9296mjFkc();
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 10:
                iM8468KLFTb = AbstractC2063Gx.m8472mjFkc((InterfaceC2341Ky) obj);
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 11:
                if (obj instanceof AbstractC4981yx) {
                    iMo13326JHa = ((AbstractC4981yx) obj).mo13326JHa();
                    iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(iMo13326JHa);
                } else {
                    iMo13326JHa = ((byte[]) obj).length;
                    iM8470ZfxDd = AbstractC2063Gx.m8470ZfxDd(iMo13326JHa);
                }
                iM8468KLFTb = iM8470ZfxDd + iMo13326JHa;
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 12:
                iM8468KLFTb = AbstractC2063Gx.m8470ZfxDd(((Integer) obj).intValue());
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 13:
                iM8468KLFTb = AbstractC2063Gx.m8468KLFTb(((Integer) obj).intValue());
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 14:
                ((Integer) obj).intValue();
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 15:
                ((Long) obj).longValue();
                iM8468KLFTb = 8;
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 16:
                int iIntValue = ((Integer) obj).intValue();
                iM8468KLFTb = AbstractC2063Gx.m8470ZfxDd((iIntValue >> 31) ^ (iIntValue + iIntValue));
                return iM8470ZfxDd2 + iM8468KLFTb;
            case 17:
                long jLongValue = ((Long) obj).longValue();
                iM8468KLFTb = AbstractC2063Gx.m8468KLFTb((jLongValue >> 63) ^ (jLongValue + jLongValue));
                return iM8470ZfxDd2 + iM8468KLFTb;
            default:
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
        }
    }

    /* renamed from: qGY */
    public static boolean m9977qGY(Map.Entry entry) {
        InterfaceC2601Ox interfaceC2601Ox = (InterfaceC2601Ox) entry.getKey();
        if (interfaceC2601Ox.mo9918AZxh() != EnumC4851wz.MESSAGE) {
            return true;
        }
        interfaceC2601Ox.mo9920ZfxDd();
        Object value = entry.getValue();
        if (value instanceof InterfaceC2404Ly) {
            return ((InterfaceC2404Ly) value).mo9400wA();
        }
        throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002c, code lost:
    
        if ((r4 instanceof byte[]) == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
    
        if (r0 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:6:0x001e, code lost:
    
        if ((r4 instanceof p131o.InterfaceC2341Ky) != false) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:9:0x0023, code lost:
    
        if ((r4 instanceof java.lang.Integer) != false) goto L23;
     */
    /* renamed from: Dt */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void m9978Dt(InterfaceC2601Ox interfaceC2601Ox, Object obj) {
        boolean z;
        interfaceC2601Ox.mo9920ZfxDd();
        interfaceC2601Ox.mo9919JHa();
        Charset charset = AbstractC4183my.f15287mjFkc;
        obj.getClass();
        EnumC4784vz enumC4784vz = EnumC4784vz.f17098wA;
        EnumC4851wz enumC4851wz = EnumC4851wz.INT;
        switch (r0.m13803KLFTb()) {
            case INT:
                z = obj instanceof Integer;
                break;
            case LONG:
                z = obj instanceof Long;
                break;
            case FLOAT:
                z = obj instanceof Float;
                break;
            case DOUBLE:
                z = obj instanceof Double;
                break;
            case BOOLEAN:
                z = obj instanceof Boolean;
                break;
            case STRING:
                z = obj instanceof String;
                break;
            case BYTE_STRING:
                if (!(obj instanceof AbstractC4981yx)) {
                    break;
                }
                this.f10131mjFkc.put(interfaceC2601Ox, obj);
                return;
            case ENUM:
                break;
            case MESSAGE:
                break;
            default:
                interfaceC2601Ox.mo9921mjFkc();
                throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", 32149011, interfaceC2601Ox.mo9919JHa().m13803KLFTb(), obj.getClass().getName()));
        }
    }

    /* renamed from: JHa */
    public final Object m9979JHa(InterfaceC2601Ox interfaceC2601Ox) {
        return this.f10131mjFkc.get(interfaceC2601Ox);
    }

    /* renamed from: MiMN */
    public final boolean m9980MiMN() {
        int iM12129wA = this.f10131mjFkc.m12129wA();
        for (int i = 0; i < iM12129wA; i++) {
            if (!m9977qGY(this.f10131mjFkc.m12130xJ(i))) {
                return false;
            }
        }
        Iterator it = this.f10131mjFkc.m12127ZfxDd().iterator();
        while (it.hasNext()) {
            if (!m9977qGY((Map.Entry) it.next())) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: VA */
    public final boolean m9981VA() {
        return this.f10130AZxh;
    }

    /* renamed from: ZfxDd, reason: merged with bridge method [inline-methods] */
    public final C2664Px m9983clone() {
        C2664Px c2664Px = new C2664Px();
        int iM12129wA = this.f10131mjFkc.m12129wA();
        for (int i = 0; i < iM12129wA; i++) {
            Map.Entry entryM12130xJ = this.f10131mjFkc.m12130xJ(i);
            c2664Px.m9978Dt((InterfaceC2601Ox) ((C3400az) entryM12130xJ).m11437KLFTb(), entryM12130xJ.getValue());
        }
        for (Map.Entry entry : this.f10131mjFkc.m12127ZfxDd()) {
            c2664Px.m9978Dt((InterfaceC2601Ox) entry.getKey(), entry.getValue());
        }
        c2664Px.f10132wA = this.f10132wA;
        return c2664Px;
    }

    /* renamed from: equals */
    public final boolean m9984equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C2664Px) {
            return this.f10131mjFkc.equals(((C2664Px) obj).f10131mjFkc);
        }
        return false;
    }

    public final int hashCode() {
        return this.f10131mjFkc.hashCode();
    }

    /* renamed from: lgHUyS */
    public final void m9985lgHUyS() {
        if (this.f10130AZxh) {
            return;
        }
        int iM12129wA = this.f10131mjFkc.m12129wA();
        for (int i = 0; i < iM12129wA; i++) {
            Map.Entry entryM12130xJ = this.f10131mjFkc.m12130xJ(i);
            if (entryM12130xJ.getValue() instanceof AbstractC3595dy) {
                ((AbstractC3595dy) entryM12130xJ.getValue()).m11765VA();
            }
        }
        this.f10131mjFkc.mo11236mjFkc();
        this.f10130AZxh = true;
    }

    /* renamed from: qdMbNW */
    public final void m9986qdMbNW(C2664Px c2664Px) {
        int iM12129wA = c2664Px.f10131mjFkc.m12129wA();
        for (int i = 0; i < iM12129wA; i++) {
            m9987rkYL(c2664Px.f10131mjFkc.m12130xJ(i));
        }
        Iterator it = c2664Px.f10131mjFkc.m12127ZfxDd().iterator();
        while (it.hasNext()) {
            m9987rkYL((Map.Entry) it.next());
        }
    }

    /* renamed from: rkYL */
    public final void m9987rkYL(Map.Entry entry) {
        InterfaceC2601Ox interfaceC2601Ox = (InterfaceC2601Ox) entry.getKey();
        Object value = entry.getValue();
        interfaceC2601Ox.mo9920ZfxDd();
        if (interfaceC2601Ox.mo9918AZxh() != EnumC4851wz.MESSAGE) {
            this.f10131mjFkc.put(interfaceC2601Ox, m9974YoKzxo(value));
            return;
        }
        Object objM9979JHa = m9979JHa(interfaceC2601Ox);
        if (objM9979JHa == null) {
            this.f10131mjFkc.put(interfaceC2601Ox, m9974YoKzxo(value));
        } else {
            this.f10131mjFkc.put(interfaceC2601Ox, interfaceC2601Ox.mo9923xJ(((InterfaceC2341Ky) objM9979JHa).mo9294JHa(), (InterfaceC2341Ky) value).mo9070ZfxDd());
        }
    }

    /* renamed from: wA */
    public final int m9988wA() {
        int iM12129wA = this.f10131mjFkc.m12129wA();
        int iM9975fehf = 0;
        for (int i = 0; i < iM12129wA; i++) {
            iM9975fehf += m9975fehf(this.f10131mjFkc.m12130xJ(i));
        }
        Iterator it = this.f10131mjFkc.m12127ZfxDd().iterator();
        while (it.hasNext()) {
            iM9975fehf += m9975fehf((Map.Entry) it.next());
        }
        return iM9975fehf;
    }

    /* renamed from: xJ */
    public final Iterator m9989xJ() {
        return this.f10131mjFkc.isEmpty() ? Collections.emptyIterator() : this.f10132wA ? new C4517ry(this.f10131mjFkc.entrySet().iterator()) : this.f10131mjFkc.entrySet().iterator();
    }

    public C2664Px(boolean z) {
        m9985lgHUyS();
        m9985lgHUyS();
    }
}
