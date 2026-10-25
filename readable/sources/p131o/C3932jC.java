package p131o;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import p131o.C3363aQ;

/* renamed from: o.jC */
/* loaded from: classes.dex */
public final class C3932jC implements InterfaceC2801S2 {

    /* renamed from: JHa */
    public static final Charset f14270JHa = Charset.forName("UTF-8");

    /* renamed from: lgHUyS */
    public static final C3363aQ f14271lgHUyS;

    /* renamed from: qdMbNW */
    public static final InterfaceC2735R2 f14272qdMbNW;

    /* renamed from: xJ */
    public static final C3363aQ f14273xJ;

    /* renamed from: AZxh */
    public final Map f14274AZxh;

    /* renamed from: KLFTb */
    public final C4732vC f14275KLFTb = new C4732vC(this);

    /* renamed from: ZfxDd */
    public final InterfaceC2735R2 f14276ZfxDd;

    /* renamed from: mjFkc */
    public OutputStream f14277mjFkc;

    /* renamed from: wA */
    public final Map f14278wA;

    static {
        C3363aQ.AZxh aZxhM11311mjFkc = C3363aQ.m11311mjFkc("key");
        C2552OB c2552ob = new C2552OB();
        c2552ob.m9891mjFkc(1);
        f14273xJ = aZxhM11311mjFkc.m11315AZxh(c2552ob.m9890AZxh()).m11316mjFkc();
        C3363aQ.AZxh aZxhM11311mjFkc2 = C3363aQ.m11311mjFkc("value");
        C2552OB c2552ob2 = new C2552OB();
        c2552ob2.m9891mjFkc(2);
        f14271lgHUyS = aZxhM11311mjFkc2.m11315AZxh(c2552ob2.m9890AZxh()).m11316mjFkc();
        f14272qdMbNW = new InterfaceC2735R2() { // from class: o.gC
            @Override // p131o.InterfaceC4156mYYU
            /* renamed from: mjFkc */
            public final void mo7597mjFkc(Object obj, Object obj2) {
                C3932jC.m12395qdMbNW((Map.Entry) obj, (InterfaceC2801S2) obj2);
            }
        };
    }

    public C3932jC(OutputStream outputStream, Map map, Map map2, InterfaceC2735R2 interfaceC2735R2) {
        this.f14277mjFkc = outputStream;
        this.f14274AZxh = map;
        this.f14278wA = map2;
        this.f14276ZfxDd = interfaceC2735R2;
    }

    /* renamed from: Dt */
    public static int m12393Dt(C3363aQ c3363aQ) {
        InterfaceC3481cC interfaceC3481cC = (InterfaceC3481cC) c3363aQ.m11314wA(InterfaceC3481cC.class);
        if (interfaceC3481cC != null) {
            return interfaceC3481cC.mo9362zza();
        }
        throw new C2570ORe("Field has no @Protobuf config");
    }

    /* renamed from: VA */
    public static InterfaceC3481cC m12394VA(C3363aQ c3363aQ) {
        InterfaceC3481cC interfaceC3481cC = (InterfaceC3481cC) c3363aQ.m11314wA(InterfaceC3481cC.class);
        if (interfaceC3481cC != null) {
            return interfaceC3481cC;
        }
        throw new C2570ORe("Field has no @Protobuf config");
    }

    /* renamed from: qdMbNW */
    public static /* synthetic */ void m12395qdMbNW(Map.Entry entry, InterfaceC2801S2 interfaceC2801S2) {
        interfaceC2801S2.mo10131wA(f14273xJ, entry.getKey());
        interfaceC2801S2.mo10131wA(f14271lgHUyS, entry.getValue());
    }

    /* renamed from: rkYL */
    public static ByteBuffer m12396rkYL(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* renamed from: AZxh */
    public final InterfaceC2801S2 m12397AZxh(C3363aQ c3363aQ, double d, boolean z) throws IOException {
        if (z && d == 0.0d) {
            return this;
        }
        m12406qGY((m12393Dt(c3363aQ) << 3) | 1);
        this.f14277mjFkc.write(m12396rkYL(8).putDouble(d).array());
        return this;
    }

    /* renamed from: ETF */
    public final long m12398ETF(InterfaceC2735R2 interfaceC2735R2, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        C2744RB c2744rb = new C2744RB();
        try {
            OutputStream outputStream = this.f14277mjFkc;
            this.f14277mjFkc = c2744rb;
            try {
                interfaceC2735R2.mo7597mjFkc(obj, this);
                this.f14277mjFkc = outputStream;
                long jM10058ZfxDd = c2744rb.m10058ZfxDd();
                c2744rb.close();
                return jM10058ZfxDd;
            } catch (Throwable th) {
                this.f14277mjFkc = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                c2744rb.close();
            } catch (Throwable th3) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th2, th3);
                } catch (Exception unused) {
                }
            }
            throw th2;
        }
    }

    /* renamed from: JHa */
    public final C3932jC m12399JHa(C3363aQ c3363aQ, int i, boolean z) throws IOException {
        if (z && i == 0) {
            return this;
        }
        InterfaceC3481cC interfaceC3481cCM12394VA = m12394VA(c3363aQ);
        EnumC3213YB enumC3213YB = EnumC3213YB.DEFAULT;
        int iOrdinal = interfaceC3481cCM12394VA.mo9363zzb().ordinal();
        if (iOrdinal == 0) {
            m12406qGY(interfaceC3481cCM12394VA.mo9362zza() << 3);
            m12406qGY(i);
        } else if (iOrdinal == 1) {
            m12406qGY(interfaceC3481cCM12394VA.mo9362zza() << 3);
            m12406qGY((i + i) ^ (i >> 31));
        } else if (iOrdinal == 2) {
            m12406qGY((interfaceC3481cCM12394VA.mo9362zza() << 3) | 5);
            this.f14277mjFkc.write(m12396rkYL(4).putInt(i).array());
        }
        return this;
    }

    /* renamed from: KLFTb */
    public final InterfaceC2801S2 m12400KLFTb(C3363aQ c3363aQ, Object obj, boolean z) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        if (obj == null) {
            return this;
        }
        if (obj instanceof CharSequence) {
            CharSequence charSequence = (CharSequence) obj;
            if (z && charSequence.length() == 0) {
                return this;
            }
            m12406qGY((m12393Dt(c3363aQ) << 3) | 2);
            byte[] bytes = charSequence.toString().getBytes(f14270JHa);
            m12406qGY(bytes.length);
            this.f14277mjFkc.write(bytes);
            return this;
        }
        if (obj instanceof Collection) {
            Iterator it = ((Collection) obj).iterator();
            while (it.hasNext()) {
                m12400KLFTb(c3363aQ, it.next(), false);
            }
            return this;
        }
        if (obj instanceof Map) {
            Iterator it2 = ((Map) obj).entrySet().iterator();
            while (it2.hasNext()) {
                m12401MiMN(f14272qdMbNW, c3363aQ, (Map.Entry) it2.next(), false);
            }
            return this;
        }
        if (obj instanceof Double) {
            m12397AZxh(c3363aQ, ((Double) obj).doubleValue(), z);
            return this;
        }
        if (obj instanceof Float) {
            m12403ZfxDd(c3363aQ, ((Float) obj).floatValue(), z);
            return this;
        }
        if (obj instanceof Number) {
            m12407xJ(c3363aQ, ((Number) obj).longValue(), z);
            return this;
        }
        if (obj instanceof Boolean) {
            m12399JHa(c3363aQ, ((Boolean) obj).booleanValue() ? 1 : 0, z);
            return this;
        }
        if (obj instanceof byte[]) {
            byte[] bArr = (byte[]) obj;
            if (z && bArr.length == 0) {
                return this;
            }
            m12406qGY((m12393Dt(c3363aQ) << 3) | 2);
            m12406qGY(bArr.length);
            this.f14277mjFkc.write(bArr);
            return this;
        }
        InterfaceC2735R2 interfaceC2735R2 = (InterfaceC2735R2) this.f14274AZxh.get(obj.getClass());
        if (interfaceC2735R2 != null) {
            m12401MiMN(interfaceC2735R2, c3363aQ, obj, z);
            return this;
        }
        InterfaceC2076H9 interfaceC2076H9 = (InterfaceC2076H9) this.f14278wA.get(obj.getClass());
        if (interfaceC2076H9 != null) {
            m12402YoKzxo(interfaceC2076H9, c3363aQ, obj, z);
            return this;
        }
        if (obj instanceof InterfaceC2940UB) {
            m12399JHa(c3363aQ, ((InterfaceC2940UB) obj).mo9898zza(), true);
            return this;
        }
        if (obj instanceof Enum) {
            m12399JHa(c3363aQ, ((Enum) obj).ordinal(), true);
            return this;
        }
        m12401MiMN(this.f14276ZfxDd, c3363aQ, obj, z);
        return this;
    }

    /* renamed from: MiMN */
    public final C3932jC m12401MiMN(InterfaceC2735R2 interfaceC2735R2, C3363aQ c3363aQ, Object obj, boolean z) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        long jM12398ETF = m12398ETF(interfaceC2735R2, obj);
        if (z && jM12398ETF == 0) {
            return this;
        }
        m12406qGY((m12393Dt(c3363aQ) << 3) | 2);
        m12404fehf(jM12398ETF);
        interfaceC2735R2.mo7597mjFkc(obj, this);
        return this;
    }

    /* renamed from: YoKzxo */
    public final C3932jC m12402YoKzxo(InterfaceC2076H9 interfaceC2076H9, C3363aQ c3363aQ, Object obj, boolean z) {
        this.f14275KLFTb.m13764mjFkc(c3363aQ, z);
        interfaceC2076H9.mo7597mjFkc(obj, this.f14275KLFTb);
        return this;
    }

    /* renamed from: ZfxDd */
    public final InterfaceC2801S2 m12403ZfxDd(C3363aQ c3363aQ, float f, boolean z) throws IOException {
        if (z && f == 0.0f) {
            return this;
        }
        m12406qGY((m12393Dt(c3363aQ) << 3) | 5);
        this.f14277mjFkc.write(m12396rkYL(4).putFloat(f).array());
        return this;
    }

    /* renamed from: fehf */
    public final void m12404fehf(long j) throws IOException {
        while (((-128) & j) != 0) {
            this.f14277mjFkc.write((((int) j) & 127) | 128);
            j >>>= 7;
        }
        this.f14277mjFkc.write(((int) j) & 127);
    }

    /* renamed from: lgHUyS */
    public final C3932jC m12405lgHUyS(Object obj) {
        if (obj == null) {
            return this;
        }
        InterfaceC2735R2 interfaceC2735R2 = (InterfaceC2735R2) this.f14274AZxh.get(obj.getClass());
        if (interfaceC2735R2 == null) {
            throw new C2570ORe("No encoder for ".concat(String.valueOf(obj.getClass())));
        }
        interfaceC2735R2.mo7597mjFkc(obj, this);
        return this;
    }

    @Override // p131o.InterfaceC2801S2
    /* renamed from: mjFkc */
    public final /* synthetic */ InterfaceC2801S2 mo10130mjFkc(C3363aQ c3363aQ, long j) throws IOException {
        m12407xJ(c3363aQ, j, true);
        return this;
    }

    /* renamed from: qGY */
    public final void m12406qGY(int i) throws IOException {
        while ((i & (-128)) != 0) {
            this.f14277mjFkc.write((i & 127) | 128);
            i >>>= 7;
        }
        this.f14277mjFkc.write(i & 127);
    }

    @Override // p131o.InterfaceC2801S2
    /* renamed from: wA */
    public final InterfaceC2801S2 mo10131wA(C3363aQ c3363aQ, Object obj) throws IllegalAccessException, IOException, IllegalArgumentException, InvocationTargetException {
        m12400KLFTb(c3363aQ, obj, true);
        return this;
    }

    /* renamed from: xJ */
    public final C3932jC m12407xJ(C3363aQ c3363aQ, long j, boolean z) throws IOException {
        if (z && j == 0) {
            return this;
        }
        InterfaceC3481cC interfaceC3481cCM12394VA = m12394VA(c3363aQ);
        EnumC3213YB enumC3213YB = EnumC3213YB.DEFAULT;
        int iOrdinal = interfaceC3481cCM12394VA.mo9363zzb().ordinal();
        if (iOrdinal == 0) {
            m12406qGY(interfaceC3481cCM12394VA.mo9362zza() << 3);
            m12404fehf(j);
        } else if (iOrdinal == 1) {
            m12406qGY(interfaceC3481cCM12394VA.mo9362zza() << 3);
            m12404fehf((j >> 63) ^ (j + j));
        } else if (iOrdinal == 2) {
            m12406qGY((interfaceC3481cCM12394VA.mo9362zza() << 3) | 1);
            this.f14277mjFkc.write(m12396rkYL(8).putLong(j).array());
        }
        return this;
    }
}
