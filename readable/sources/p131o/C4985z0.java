package p131o;

import android.util.Base64;
import android.util.JsonWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

/* renamed from: o.z0 */
/* loaded from: classes.dex */
public final class C4985z0 implements InterfaceC2801S2, InterfaceC2144I9 {

    /* renamed from: JHa */
    public final InterfaceC2735R2 f17605JHa;

    /* renamed from: KLFTb */
    public final Map f17606KLFTb;

    /* renamed from: ZfxDd */
    public final Map f17607ZfxDd;

    /* renamed from: wA */
    public final JsonWriter f17609wA;

    /* renamed from: xJ */
    public final boolean f17610xJ;

    /* renamed from: mjFkc */
    public C4985z0 f17608mjFkc = null;

    /* renamed from: AZxh */
    public boolean f17604AZxh = true;

    public C4985z0(Writer writer, Map map, Map map2, InterfaceC2735R2 interfaceC2735R2, boolean z) {
        this.f17609wA = new JsonWriter(writer);
        this.f17607ZfxDd = map;
        this.f17606KLFTb = map2;
        this.f17605JHa = interfaceC2735R2;
        this.f17610xJ = z;
    }

    /* renamed from: Dt */
    public C4985z0 m14061Dt(byte[] bArr) throws IOException {
        m14070qGY();
        if (bArr == null) {
            this.f17609wA.nullValue();
        } else {
            this.f17609wA.value(Base64.encodeToString(bArr, 2));
        }
        return this;
    }

    /* renamed from: ETF */
    public final boolean m14062ETF(Object obj) {
        return obj == null || obj.getClass().isArray() || (obj instanceof Collection) || (obj instanceof Date) || (obj instanceof Enum) || (obj instanceof Number);
    }

    @Override // p131o.InterfaceC2144I9
    /* renamed from: JHa, reason: merged with bridge method [inline-methods] */
    public C4985z0 mo8720add(String str) throws IOException {
        m14070qGY();
        this.f17609wA.value(str);
        return this;
    }

    /* renamed from: KLFTb */
    public C4985z0 m14064KLFTb(Object obj, boolean z) {
        if (z && m14062ETF(obj)) {
            throw new C2570ORe(String.format("%s cannot be encoded inline", obj == null ? null : obj.getClass()));
        }
        if (obj == null) {
            this.f17609wA.nullValue();
            return this;
        }
        if (obj instanceof Number) {
            this.f17609wA.value((Number) obj);
            return this;
        }
        int i = 0;
        if (!obj.getClass().isArray()) {
            if (obj instanceof Collection) {
                this.f17609wA.beginArray();
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    m14064KLFTb(it.next(), false);
                }
                this.f17609wA.endArray();
                return this;
            }
            if (obj instanceof Map) {
                this.f17609wA.beginObject();
                for (Map.Entry entry : ((Map) obj).entrySet()) {
                    Object key = entry.getKey();
                    try {
                        m14069lgHUyS((String) key, entry.getValue());
                    } catch (ClassCastException e) {
                        throw new C2570ORe(String.format("Only String keys are currently supported in maps, got %s of type %s instead.", key, key.getClass()), e);
                    }
                }
                this.f17609wA.endObject();
                return this;
            }
            InterfaceC2735R2 interfaceC2735R2 = (InterfaceC2735R2) this.f17607ZfxDd.get(obj.getClass());
            if (interfaceC2735R2 != null) {
                return m14065MiMN(interfaceC2735R2, obj, z);
            }
            InterfaceC2076H9 interfaceC2076H9 = (InterfaceC2076H9) this.f17606KLFTb.get(obj.getClass());
            if (interfaceC2076H9 != null) {
                interfaceC2076H9.mo7597mjFkc(obj, this);
                return this;
            }
            if (!(obj instanceof Enum)) {
                return m14065MiMN(this.f17605JHa, obj, z);
            }
            mo8720add(((Enum) obj).name());
            return this;
        }
        if (obj instanceof byte[]) {
            return m14061Dt((byte[]) obj);
        }
        this.f17609wA.beginArray();
        if (obj instanceof int[]) {
            int length = ((int[]) obj).length;
            while (i < length) {
                this.f17609wA.value(r6[i]);
                i++;
            }
        } else if (obj instanceof long[]) {
            long[] jArr = (long[]) obj;
            int length2 = jArr.length;
            while (i < length2) {
                m14068ZfxDd(jArr[i]);
                i++;
            }
        } else if (obj instanceof double[]) {
            double[] dArr = (double[]) obj;
            int length3 = dArr.length;
            while (i < length3) {
                this.f17609wA.value(dArr[i]);
                i++;
            }
        } else if (obj instanceof boolean[]) {
            boolean[] zArr = (boolean[]) obj;
            int length4 = zArr.length;
            while (i < length4) {
                this.f17609wA.value(zArr[i]);
                i++;
            }
        } else if (obj instanceof Number[]) {
            for (Number number : (Number[]) obj) {
                m14064KLFTb(number, false);
            }
        } else {
            for (Object obj2 : (Object[]) obj) {
                m14064KLFTb(obj2, false);
            }
        }
        this.f17609wA.endArray();
        return this;
    }

    /* renamed from: MiMN */
    public C4985z0 m14065MiMN(InterfaceC2735R2 interfaceC2735R2, Object obj, boolean z) throws IOException {
        if (!z) {
            this.f17609wA.beginObject();
        }
        interfaceC2735R2.mo7597mjFkc(obj, this);
        if (!z) {
            this.f17609wA.endObject();
        }
        return this;
    }

    /* renamed from: VA */
    public void m14066VA() {
        m14070qGY();
        this.f17609wA.flush();
    }

    /* renamed from: YoKzxo */
    public final C4985z0 m14067YoKzxo(String str, Object obj) throws IOException {
        m14070qGY();
        this.f17609wA.name(str);
        if (obj != null) {
            return m14064KLFTb(obj, false);
        }
        this.f17609wA.nullValue();
        return this;
    }

    /* renamed from: ZfxDd */
    public C4985z0 m14068ZfxDd(long j) throws IOException {
        m14070qGY();
        this.f17609wA.value(j);
        return this;
    }

    /* renamed from: lgHUyS */
    public C4985z0 m14069lgHUyS(String str, Object obj) {
        return this.f17610xJ ? m14072rkYL(str, obj) : m14067YoKzxo(str, obj);
    }

    @Override // p131o.InterfaceC2801S2
    /* renamed from: mjFkc */
    public InterfaceC2801S2 mo10130mjFkc(C3363aQ c3363aQ, long j) {
        return m14073xJ(c3363aQ.m11312AZxh(), j);
    }

    /* renamed from: qGY */
    public final void m14070qGY() throws IOException {
        if (!this.f17604AZxh) {
            throw new IllegalStateException("Parent context used since this context was created. Cannot use this context anymore.");
        }
        C4985z0 c4985z0 = this.f17608mjFkc;
        if (c4985z0 != null) {
            c4985z0.m14070qGY();
            this.f17608mjFkc.f17604AZxh = false;
            this.f17608mjFkc = null;
            this.f17609wA.endObject();
        }
    }

    @Override // p131o.InterfaceC2144I9
    /* renamed from: qdMbNW, reason: merged with bridge method [inline-methods] */
    public C4985z0 mo8719AZxh(boolean z) throws IOException {
        m14070qGY();
        this.f17609wA.value(z);
        return this;
    }

    /* renamed from: rkYL */
    public final C4985z0 m14072rkYL(String str, Object obj) throws IOException {
        if (obj == null) {
            return this;
        }
        m14070qGY();
        this.f17609wA.name(str);
        return m14064KLFTb(obj, false);
    }

    @Override // p131o.InterfaceC2801S2
    /* renamed from: wA */
    public InterfaceC2801S2 mo10131wA(C3363aQ c3363aQ, Object obj) {
        return m14069lgHUyS(c3363aQ.m11312AZxh(), obj);
    }

    /* renamed from: xJ */
    public C4985z0 m14073xJ(String str, long j) throws IOException {
        m14070qGY();
        this.f17609wA.name(str);
        return m14068ZfxDd(j);
    }
}
