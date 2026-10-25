package p131o;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: o.q1 */
/* loaded from: classes.dex */
public class C4386q1 {

    /* renamed from: AZxh */
    public int f16006AZxh;

    /* renamed from: JHa */
    public int f16007JHa;

    /* renamed from: KLFTb */
    public int f16008KLFTb;

    /* renamed from: ZfxDd */
    public int f16009ZfxDd;

    /* renamed from: lgHUyS */
    public int f16010lgHUyS;

    /* renamed from: mjFkc */
    public final LinkedHashMap f16011mjFkc;

    /* renamed from: wA */
    public int f16012wA;

    /* renamed from: xJ */
    public int f16013xJ;

    public C4386q1(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f16012wA = i;
        this.f16011mjFkc = new LinkedHashMap(0, 0.75f, true);
    }

    /* renamed from: AZxh */
    public void m13161AZxh(boolean z, Object obj, Object obj2, Object obj3) {
    }

    /* renamed from: JHa */
    public int m13162JHa(Object obj, Object obj2) {
        return 1;
    }

    /* renamed from: KLFTb */
    public final int m13163KLFTb(Object obj, Object obj2) {
        int iM13162JHa = m13162JHa(obj, obj2);
        if (iM13162JHa >= 0) {
            return iM13162JHa;
        }
        throw new IllegalStateException("Negative size: " + obj + "=" + obj2);
    }

    /* renamed from: ZfxDd */
    public final Object m13164ZfxDd(Object obj, Object obj2) {
        Object objPut;
        if (obj == null || obj2 == null) {
            throw new NullPointerException("key == null || value == null");
        }
        synchronized (this) {
            try {
                this.f16009ZfxDd++;
                this.f16006AZxh += m13163KLFTb(obj, obj2);
                objPut = this.f16011mjFkc.put(obj, obj2);
                if (objPut != null) {
                    this.f16006AZxh -= m13163KLFTb(obj, objPut);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (objPut != null) {
            m13161AZxh(false, obj, objPut, obj2);
        }
        m13167xJ(this.f16012wA);
        return objPut;
    }

    /* renamed from: mjFkc */
    public Object m13165mjFkc(Object obj) {
        return null;
    }

    public final synchronized String toString() {
        int i;
        int i2;
        try {
            i = this.f16013xJ;
            i2 = this.f16010lgHUyS + i;
        } catch (Throwable th) {
            throw th;
        }
        return String.format(Locale.US, "LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", Integer.valueOf(this.f16012wA), Integer.valueOf(this.f16013xJ), Integer.valueOf(this.f16010lgHUyS), Integer.valueOf(i2 != 0 ? (i * 100) / i2 : 0));
    }

    /* renamed from: wA */
    public final Object m13166wA(Object obj) {
        Object objPut;
        if (obj == null) {
            throw new NullPointerException("key == null");
        }
        synchronized (this) {
            try {
                Object obj2 = this.f16011mjFkc.get(obj);
                if (obj2 != null) {
                    this.f16013xJ++;
                    return obj2;
                }
                this.f16010lgHUyS++;
                Object objM13165mjFkc = m13165mjFkc(obj);
                if (objM13165mjFkc == null) {
                    return null;
                }
                synchronized (this) {
                    try {
                        this.f16008KLFTb++;
                        objPut = this.f16011mjFkc.put(obj, objM13165mjFkc);
                        if (objPut != null) {
                            this.f16011mjFkc.put(obj, objPut);
                        } else {
                            this.f16006AZxh += m13163KLFTb(obj, objM13165mjFkc);
                        }
                    } finally {
                    }
                }
                if (objPut != null) {
                    m13161AZxh(false, obj, objM13165mjFkc, objPut);
                    return objPut;
                }
                m13167xJ(this.f16012wA);
                return objM13165mjFkc;
            } finally {
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0073, code lost:
    
        throw new java.lang.IllegalStateException(getClass().getName() + ".sizeOf() is reporting inconsistent results!");
     */
    /* renamed from: xJ */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void m13167xJ(int i) {
        Object key;
        Object value;
        while (true) {
            synchronized (this) {
                try {
                    if (this.f16006AZxh < 0 || (this.f16011mjFkc.isEmpty() && this.f16006AZxh != 0)) {
                        break;
                    }
                    if (this.f16006AZxh <= i || this.f16011mjFkc.isEmpty()) {
                        break;
                    }
                    Map.Entry entry = (Map.Entry) this.f16011mjFkc.entrySet().iterator().next();
                    key = entry.getKey();
                    value = entry.getValue();
                    this.f16011mjFkc.remove(key);
                    this.f16006AZxh -= m13163KLFTb(key, value);
                    this.f16007JHa++;
                } finally {
                }
            }
            m13161AZxh(true, key, value, null);
        }
    }
}
