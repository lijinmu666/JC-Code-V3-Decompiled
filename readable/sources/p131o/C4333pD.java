package p131o;

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import p122kotlinx.coroutines.internal.LockFreeTaskQueueCore;

/* renamed from: o.pD */
/* loaded from: classes.dex */
public final class C4333pD extends AbstractMap implements Serializable {

    /* renamed from: Dt */
    public static final Object f15918Dt = new Object();

    /* renamed from: AZxh */
    public transient int[] f15919AZxh;

    /* renamed from: JHa */
    public transient int f15920JHa;

    /* renamed from: KLFTb */
    public transient int f15921KLFTb;

    /* renamed from: ZfxDd */
    public transient Object[] f15922ZfxDd;

    /* renamed from: lgHUyS */
    public transient Set f15923lgHUyS;

    /* renamed from: mjFkc */
    public transient Object f15924mjFkc;

    /* renamed from: qdMbNW */
    public transient Collection f15925qdMbNW;

    /* renamed from: wA */
    public transient Object[] f15926wA;

    /* renamed from: xJ */
    public transient Set f15927xJ;

    public C4333pD(int i) {
        m13113Pq(12);
    }

    /* renamed from: Dt */
    public static /* synthetic */ Object m13095Dt(C4333pD c4333pD, int i) {
        return c4333pD.m13109AZxh()[i];
    }

    /* renamed from: MiMN */
    public static /* synthetic */ Object m13100MiMN(C4333pD c4333pD, int i) {
        return c4333pD.m13123wA()[i];
    }

    /* renamed from: VA */
    public static /* synthetic */ Object m13102VA(C4333pD c4333pD) {
        Object obj = c4333pD.f15924mjFkc;
        Objects.requireNonNull(obj);
        return obj;
    }

    /* renamed from: fehf */
    public static /* synthetic */ void m13105fehf(C4333pD c4333pD, int i, Object obj) {
        c4333pD.m13123wA()[i] = obj;
    }

    /* renamed from: AZxh */
    public final Object[] m13109AZxh() {
        Object[] objArr = this.f15926wA;
        Objects.requireNonNull(objArr);
        return objArr;
    }

    /* renamed from: BAnRFn */
    public final Object m13110BAnRFn(Object obj) {
        if (!m13116eyqo()) {
            int iM13111HGpJ = m13111HGpJ();
            Object obj2 = this.f15924mjFkc;
            Objects.requireNonNull(obj2);
            int iM13357AZxh = AbstractC4467rD.m13357AZxh(obj, null, iM13111HGpJ, obj2, m13119mjFkc(), m13109AZxh(), null);
            if (iM13357AZxh != -1) {
                Object obj3 = m13123wA()[iM13357AZxh];
                m13115diqgf(iM13357AZxh, iM13111HGpJ);
                this.f15920JHa--;
                m13112IEE();
                return obj3;
            }
        }
        return f15918Dt;
    }

    /* renamed from: HGpJ */
    public final int m13111HGpJ() {
        return (1 << (this.f15921KLFTb & 31)) - 1;
    }

    /* renamed from: IEE */
    public final void m13112IEE() {
        this.f15921KLFTb += 32;
    }

    /* renamed from: Pq */
    public final void m13113Pq(int i) {
        this.f15921KLFTb = AbstractC3614eF.m11828mjFkc(i, 1, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
    }

    /* renamed from: VocHEe */
    public final int m13114VocHEe(int i, int i2, int i3, int i4) {
        int i5 = i2 - 1;
        Object objM13359ZfxDd = AbstractC4467rD.m13359ZfxDd(i2);
        if (i4 != 0) {
            AbstractC4467rD.m13358KLFTb(objM13359ZfxDd, i3 & i5, i4 + 1);
        }
        Object obj = this.f15924mjFkc;
        Objects.requireNonNull(obj);
        int[] iArrM13119mjFkc = m13119mjFkc();
        for (int i6 = 0; i6 <= i; i6++) {
            int iM13361wA = AbstractC4467rD.m13361wA(obj, i6);
            while (iM13361wA != 0) {
                int i7 = iM13361wA - 1;
                int i8 = iArrM13119mjFkc[i7];
                int i9 = ((~i) & i8) | i6;
                int i10 = i9 & i5;
                int iM13361wA2 = AbstractC4467rD.m13361wA(objM13359ZfxDd, i10);
                AbstractC4467rD.m13358KLFTb(objM13359ZfxDd, i10, iM13361wA);
                iArrM13119mjFkc[i7] = ((~i5) & i9) | (iM13361wA2 & i5);
                iM13361wA = i8 & i;
            }
        }
        this.f15924mjFkc = objM13359ZfxDd;
        m13117lB(i5);
        return i5;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final void clear() {
        if (m13116eyqo()) {
            return;
        }
        m13112IEE();
        Map mapM13121rkYL = m13121rkYL();
        if (mapM13121rkYL != null) {
            this.f15921KLFTb = AbstractC3614eF.m11828mjFkc(size(), 3, LockFreeTaskQueueCore.MAX_CAPACITY_MASK);
            mapM13121rkYL.clear();
            this.f15924mjFkc = null;
            this.f15920JHa = 0;
            return;
        }
        Arrays.fill(m13109AZxh(), 0, this.f15920JHa, (Object) null);
        Arrays.fill(m13123wA(), 0, this.f15920JHa, (Object) null);
        Object obj = this.f15924mjFkc;
        Objects.requireNonNull(obj);
        if (obj instanceof byte[]) {
            Arrays.fill((byte[]) obj, (byte) 0);
        } else if (obj instanceof short[]) {
            Arrays.fill((short[]) obj, (short) 0);
        } else {
            Arrays.fill((int[]) obj, 0);
        }
        Arrays.fill(m13119mjFkc(), 0, this.f15920JHa, 0);
        this.f15920JHa = 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsKey(Object obj) {
        Map mapM13121rkYL = m13121rkYL();
        return mapM13121rkYL != null ? mapM13121rkYL.containsKey(obj) : m13122vI(obj) != -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean containsValue(Object obj) {
        Map mapM13121rkYL = m13121rkYL();
        if (mapM13121rkYL != null) {
            return mapM13121rkYL.containsValue(obj);
        }
        for (int i = 0; i < this.f15920JHa; i++) {
            if (AbstractC2833SW.m10153mjFkc(obj, m13123wA()[i])) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: diqgf */
    public final void m13115diqgf(int i, int i2) {
        Object obj = this.f15924mjFkc;
        Objects.requireNonNull(obj);
        int[] iArrM13119mjFkc = m13119mjFkc();
        Object[] objArrM13109AZxh = m13109AZxh();
        Object[] objArrM13123wA = m13123wA();
        int size = size();
        int i3 = size - 1;
        if (i >= i3) {
            objArrM13109AZxh[i] = null;
            objArrM13123wA[i] = null;
            iArrM13119mjFkc[i] = 0;
            return;
        }
        int i4 = i + 1;
        Object obj2 = objArrM13109AZxh[i3];
        objArrM13109AZxh[i] = obj2;
        objArrM13123wA[i] = objArrM13123wA[i3];
        objArrM13109AZxh[i3] = null;
        objArrM13123wA[i3] = null;
        iArrM13119mjFkc[i] = iArrM13119mjFkc[i3];
        iArrM13119mjFkc[i3] = 0;
        int iM13611mjFkc = AbstractC4601tD.m13611mjFkc(obj2) & i2;
        int iM13361wA = AbstractC4467rD.m13361wA(obj, iM13611mjFkc);
        if (iM13361wA == size) {
            AbstractC4467rD.m13358KLFTb(obj, iM13611mjFkc, i4);
            return;
        }
        while (true) {
            int i5 = iM13361wA - 1;
            int i6 = iArrM13119mjFkc[i5];
            int i7 = i6 & i2;
            if (i7 == size) {
                iArrM13119mjFkc[i5] = ((~i2) & i6) | (i4 & i2);
                return;
            }
            iM13361wA = i7;
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set entrySet() {
        Set set = this.f15923lgHUyS;
        if (set != null) {
            return set;
        }
        C2553OC c2553oc = new C2553OC(this);
        this.f15923lgHUyS = c2553oc;
        return c2553oc;
    }

    /* renamed from: eyqo */
    public final boolean m13116eyqo() {
        return this.f15924mjFkc == null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object get(Object obj) {
        Map mapM13121rkYL = m13121rkYL();
        if (mapM13121rkYL != null) {
            return mapM13121rkYL.get(obj);
        }
        int iM13122vI = m13122vI(obj);
        if (iM13122vI == -1) {
            return null;
        }
        return m13123wA()[iM13122vI];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Set keySet() {
        Set set = this.f15927xJ;
        if (set != null) {
            return set;
        }
        C3013VC c3013vc = new C3013VC(this);
        this.f15927xJ = c3013vc;
        return c3013vc;
    }

    /* renamed from: lB */
    public final void m13117lB(int i) {
        this.f15921KLFTb = ((32 - Integer.numberOfLeadingZeros(i)) & 31) | (this.f15921KLFTb & (-32));
    }

    /* renamed from: lgHUyS */
    public final int m13118lgHUyS() {
        return isEmpty() ? -1 : 0;
    }

    /* renamed from: mjFkc */
    public final int[] m13119mjFkc() {
        int[] iArr = this.f15919AZxh;
        Objects.requireNonNull(iArr);
        return iArr;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        int iMin;
        if (m13116eyqo()) {
            AbstractC3168XW.m10943ZfxDd(m13116eyqo(), "Arrays already allocated");
            int i = this.f15921KLFTb;
            int iMax = Math.max(i + 1, 2);
            int iHighestOneBit = Integer.highestOneBit(iMax);
            if (iMax > iHighestOneBit && (iHighestOneBit = iHighestOneBit + iHighestOneBit) <= 0) {
                iHighestOneBit = 1073741824;
            }
            int iMax2 = Math.max(4, iHighestOneBit);
            this.f15924mjFkc = AbstractC4467rD.m13359ZfxDd(iMax2);
            m13117lB(iMax2 - 1);
            this.f15919AZxh = new int[i];
            this.f15926wA = new Object[i];
            this.f15922ZfxDd = new Object[i];
        }
        Map mapM13121rkYL = m13121rkYL();
        if (mapM13121rkYL != null) {
            return mapM13121rkYL.put(obj, obj2);
        }
        int[] iArrM13119mjFkc = m13119mjFkc();
        Object[] objArrM13109AZxh = m13109AZxh();
        Object[] objArrM13123wA = m13123wA();
        int i2 = this.f15920JHa;
        int i3 = i2 + 1;
        int iM13611mjFkc = AbstractC4601tD.m13611mjFkc(obj);
        int iM13111HGpJ = m13111HGpJ();
        int i4 = iM13611mjFkc & iM13111HGpJ;
        Object obj3 = this.f15924mjFkc;
        Objects.requireNonNull(obj3);
        int iM13361wA = AbstractC4467rD.m13361wA(obj3, i4);
        if (iM13361wA != 0) {
            int i5 = ~iM13111HGpJ;
            int i6 = iM13611mjFkc & i5;
            int i7 = 0;
            while (true) {
                int i8 = iM13361wA - 1;
                int i9 = iArrM13119mjFkc[i8];
                int i10 = i9 & i5;
                if (i10 == i6 && AbstractC2833SW.m10153mjFkc(obj, objArrM13109AZxh[i8])) {
                    Object obj4 = objArrM13123wA[i8];
                    objArrM13123wA[i8] = obj2;
                    return obj4;
                }
                int i11 = i9 & iM13111HGpJ;
                i7++;
                if (i11 != 0) {
                    iM13361wA = i11;
                } else {
                    if (i7 >= 9) {
                        LinkedHashMap linkedHashMap = new LinkedHashMap(m13111HGpJ() + 1, 1.0f);
                        int iM13118lgHUyS = m13118lgHUyS();
                        while (iM13118lgHUyS >= 0) {
                            linkedHashMap.put(m13109AZxh()[iM13118lgHUyS], m13123wA()[iM13118lgHUyS]);
                            iM13118lgHUyS = m13120qdMbNW(iM13118lgHUyS);
                        }
                        this.f15924mjFkc = linkedHashMap;
                        this.f15919AZxh = null;
                        this.f15926wA = null;
                        this.f15922ZfxDd = null;
                        m13112IEE();
                        return linkedHashMap.put(obj, obj2);
                    }
                    if (i3 > iM13111HGpJ) {
                        iM13111HGpJ = m13114VocHEe(iM13111HGpJ, AbstractC4467rD.m13360mjFkc(iM13111HGpJ), iM13611mjFkc, i2);
                    } else {
                        iArrM13119mjFkc[i8] = (i3 & iM13111HGpJ) | i10;
                    }
                }
            }
        } else if (i3 > iM13111HGpJ) {
            iM13111HGpJ = m13114VocHEe(iM13111HGpJ, AbstractC4467rD.m13360mjFkc(iM13111HGpJ), iM13611mjFkc, i2);
        } else {
            Object obj5 = this.f15924mjFkc;
            Objects.requireNonNull(obj5);
            AbstractC4467rD.m13358KLFTb(obj5, i4, i3);
        }
        int length = m13119mjFkc().length;
        if (i3 > length && (iMin = Math.min(LockFreeTaskQueueCore.MAX_CAPACITY_MASK, (Math.max(1, length >>> 1) + length) | 1)) != length) {
            this.f15919AZxh = Arrays.copyOf(m13119mjFkc(), iMin);
            this.f15926wA = Arrays.copyOf(m13109AZxh(), iMin);
            this.f15922ZfxDd = Arrays.copyOf(m13123wA(), iMin);
        }
        m13119mjFkc()[i2] = (~iM13111HGpJ) & iM13611mjFkc;
        m13109AZxh()[i2] = obj;
        m13123wA()[i2] = obj2;
        this.f15920JHa = i3;
        m13112IEE();
        return null;
    }

    /* renamed from: qdMbNW */
    public final int m13120qdMbNW(int i) {
        int i2 = i + 1;
        if (i2 < this.f15920JHa) {
            return i2;
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        Map mapM13121rkYL = m13121rkYL();
        if (mapM13121rkYL != null) {
            return mapM13121rkYL.remove(obj);
        }
        Object objM13110BAnRFn = m13110BAnRFn(obj);
        if (objM13110BAnRFn == f15918Dt) {
            return null;
        }
        return objM13110BAnRFn;
    }

    /* renamed from: rkYL */
    public final Map m13121rkYL() {
        Object obj = this.f15924mjFkc;
        if (obj instanceof Map) {
            return (Map) obj;
        }
        return null;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final int size() {
        Map mapM13121rkYL = m13121rkYL();
        return mapM13121rkYL != null ? mapM13121rkYL.size() : this.f15920JHa;
    }

    /* renamed from: vI */
    public final int m13122vI(Object obj) {
        if (m13116eyqo()) {
            return -1;
        }
        int iM13611mjFkc = AbstractC4601tD.m13611mjFkc(obj);
        int iM13111HGpJ = m13111HGpJ();
        Object obj2 = this.f15924mjFkc;
        Objects.requireNonNull(obj2);
        int iM13361wA = AbstractC4467rD.m13361wA(obj2, iM13611mjFkc & iM13111HGpJ);
        if (iM13361wA != 0) {
            int i = ~iM13111HGpJ;
            int i2 = iM13611mjFkc & i;
            do {
                int i3 = iM13361wA - 1;
                int i4 = m13119mjFkc()[i3];
                if ((i4 & i) == i2 && AbstractC2833SW.m10153mjFkc(obj, m13109AZxh()[i3])) {
                    return i3;
                }
                iM13361wA = i4 & iM13111HGpJ;
            } while (iM13361wA != 0);
        }
        return -1;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public final Collection values() {
        Collection collection = this.f15925qdMbNW;
        if (collection != null) {
            return collection;
        }
        C3280ZC c3280zc = new C3280ZC(this);
        this.f15925qdMbNW = c3280zc;
        return c3280zc;
    }

    /* renamed from: wA */
    public final Object[] m13123wA() {
        Object[] objArr = this.f15922ZfxDd;
        Objects.requireNonNull(objArr);
        return objArr;
    }
}
