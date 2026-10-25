package p131o;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import p131o.C3363aQ;

/* renamed from: o.wF */
/* loaded from: classes.dex */
public final class C4801wF implements InterfaceC2801S2 {

    /* renamed from: JHa */
    public static final Charset f17173JHa = Charset.forName("UTF-8");

    /* renamed from: lgHUyS */
    public static final C3363aQ f17174lgHUyS;

    /* renamed from: qdMbNW */
    public static final InterfaceC2735R2 f17175qdMbNW;

    /* renamed from: xJ */
    public static final C3363aQ f17176xJ;

    /* renamed from: AZxh */
    public final Map f17177AZxh;

    /* renamed from: KLFTb */
    public final C2556OF f17178KLFTb = new C2556OF(this);

    /* renamed from: ZfxDd */
    public final InterfaceC2735R2 f17179ZfxDd;

    /* renamed from: mjFkc */
    public OutputStream f17180mjFkc;

    /* renamed from: wA */
    public final Map f17181wA;

    static {
        C3363aQ.AZxh aZxhM11311mjFkc = C3363aQ.m11311mjFkc("key");
        C4006kF c4006kF = new C4006kF();
        c4006kF.m12545mjFkc(1);
        f17176xJ = aZxhM11311mjFkc.m11315AZxh(c4006kF.m12544AZxh()).m11316mjFkc();
        C3363aQ.AZxh aZxhM11311mjFkc2 = C3363aQ.m11311mjFkc("value");
        C4006kF c4006kF2 = new C4006kF();
        c4006kF2.m12545mjFkc(2);
        f17174lgHUyS = aZxhM11311mjFkc2.m11315AZxh(c4006kF2.m12544AZxh()).m11316mjFkc();
        f17175qdMbNW = new InterfaceC2735R2() { // from class: o.uF
            @Override // p131o.InterfaceC4156mYYU
            /* renamed from: mjFkc */
            public final void mo7597mjFkc(Object obj, Object obj2) {
                C4801wF.m13834qdMbNW((Map.Entry) obj, (InterfaceC2801S2) obj2);
            }
        };
    }

    public C4801wF(OutputStream outputStream, Map map, Map map2, InterfaceC2735R2 interfaceC2735R2) {
        this.f17180mjFkc = outputStream;
        this.f17177AZxh = map;
        this.f17181wA = map2;
        this.f17179ZfxDd = interfaceC2735R2;
    }

    /* renamed from: Dt */
    private static int m13829Dt(C3363aQ c3363aQ) {
        InterfaceC4535sF interfaceC4535sF = (InterfaceC4535sF) c3363aQ.m11314wA(InterfaceC4535sF.class);
        if (interfaceC4535sF != null) {
            return interfaceC4535sF.mo12291zza();
        }
        throw new C2570ORe("Field has no @Protobuf config");
    }

    /* renamed from: ETF */
    private final long m13830ETF(InterfaceC2735R2 interfaceC2735R2, Object obj) throws IOException {
        C4137mF c4137mF = new C4137mF();
        try {
            OutputStream outputStream = this.f17180mjFkc;
            this.f17180mjFkc = c4137mF;
            try {
                interfaceC2735R2.mo7597mjFkc(obj, this);
                this.f17180mjFkc = outputStream;
                long jM12762ZfxDd = c4137mF.m12762ZfxDd();
                c4137mF.close();
                return jM12762ZfxDd;
            } catch (Throwable th) {
                this.f17180mjFkc = outputStream;
                throw th;
            }
        } catch (Throwable th2) {
            try {
                c4137mF.close();
            } catch (Throwable th3) {
                th2.addSuppressed(th3);
            }
            throw th2;
        }
    }

    /* renamed from: VA */
    public static InterfaceC4535sF m13831VA(C3363aQ c3363aQ) {
        InterfaceC4535sF interfaceC4535sF = (InterfaceC4535sF) c3363aQ.m11314wA(InterfaceC4535sF.class);
        if (interfaceC4535sF != null) {
            return interfaceC4535sF;
        }
        throw new C2570ORe("Field has no @Protobuf config");
    }

    /* renamed from: fehf */
    private final void m13832fehf(long j) throws IOException {
        while (true) {
            int i = ((int) j) & 127;
            if (((-128) & j) == 0) {
                this.f17180mjFkc.write(i);
                return;
            } else {
                this.f17180mjFkc.write(i | 128);
                j >>>= 7;
            }
        }
    }

    /* renamed from: qGY */
    private final void m13833qGY(int i) throws IOException {
        while (true) {
            int i2 = i & 127;
            if ((i & (-128)) == 0) {
                this.f17180mjFkc.write(i2);
                return;
            } else {
                this.f17180mjFkc.write(i2 | 128);
                i >>>= 7;
            }
        }
    }

    /* renamed from: qdMbNW */
    public static /* synthetic */ void m13834qdMbNW(Map.Entry entry, InterfaceC2801S2 interfaceC2801S2) {
        interfaceC2801S2.mo10131wA(f17176xJ, entry.getKey());
        interfaceC2801S2.mo10131wA(f17174lgHUyS, entry.getValue());
    }

    /* renamed from: rkYL */
    private static ByteBuffer m13835rkYL(int i) {
        return ByteBuffer.allocate(i).order(ByteOrder.LITTLE_ENDIAN);
    }

    /* renamed from: AZxh */
    public final InterfaceC2801S2 m13836AZxh(C3363aQ c3363aQ, double d, boolean z) throws IOException {
        if (z && d == 0.0d) {
            return this;
        }
        m13833qGY((m13829Dt(c3363aQ) << 3) | 1);
        this.f17180mjFkc.write(m13835rkYL(8).putDouble(d).array());
        return this;
    }

    /* renamed from: JHa */
    public final C4801wF m13837JHa(C3363aQ c3363aQ, int i, boolean z) throws IOException {
        if (!z || i != 0) {
            InterfaceC4535sF interfaceC4535sFM13831VA = m13831VA(c3363aQ);
            int iOrdinal = interfaceC4535sFM13831VA.mo12292zzb().ordinal();
            if (iOrdinal == 0) {
                m13833qGY(interfaceC4535sFM13831VA.mo12291zza() << 3);
                m13833qGY(i);
            } else if (iOrdinal == 1) {
                m13833qGY(interfaceC4535sFM13831VA.mo12291zza() << 3);
                m13833qGY((i + i) ^ (i >> 31));
            } else if (iOrdinal == 2) {
                m13833qGY((interfaceC4535sFM13831VA.mo12291zza() << 3) | 5);
                this.f17180mjFkc.write(m13835rkYL(4).putInt(i).array());
            }
        }
        return this;
    }

    /* renamed from: KLFTb */
    public final InterfaceC2801S2 m13838KLFTb(C3363aQ c3363aQ, Object obj, boolean z) throws IOException {
        if (obj != null) {
            if (obj instanceof CharSequence) {
                CharSequence charSequence = (CharSequence) obj;
                if (!z || charSequence.length() != 0) {
                    m13833qGY((m13829Dt(c3363aQ) << 3) | 2);
                    byte[] bytes = charSequence.toString().getBytes(f17173JHa);
                    m13833qGY(bytes.length);
                    this.f17180mjFkc.write(bytes);
                    return this;
                }
            } else if (obj instanceof Collection) {
                Iterator it = ((Collection) obj).iterator();
                while (it.hasNext()) {
                    m13838KLFTb(c3363aQ, it.next(), false);
                }
            } else if (obj instanceof Map) {
                Iterator it2 = ((Map) obj).entrySet().iterator();
                while (it2.hasNext()) {
                    m13839MiMN(f17175qdMbNW, c3363aQ, (Map.Entry) it2.next(), false);
                }
            } else {
                if (obj instanceof Double) {
                    m13836AZxh(c3363aQ, ((Double) obj).doubleValue(), z);
                    return this;
                }
                if (obj instanceof Float) {
                    m13841ZfxDd(c3363aQ, ((Float) obj).floatValue(), z);
                    return this;
                }
                if (obj instanceof Number) {
                    m13843xJ(c3363aQ, ((Number) obj).longValue(), z);
                    return this;
                }
                if (obj instanceof Boolean) {
                    m13837JHa(c3363aQ, ((Boolean) obj).booleanValue() ? 1 : 0, z);
                    return this;
                }
                if (!(obj instanceof byte[])) {
                    InterfaceC2735R2 interfaceC2735R2 = (InterfaceC2735R2) this.f17177AZxh.get(obj.getClass());
                    if (interfaceC2735R2 != null) {
                        m13839MiMN(interfaceC2735R2, c3363aQ, obj, z);
                        return this;
                    }
                    InterfaceC2076H9 interfaceC2076H9 = (InterfaceC2076H9) this.f17181wA.get(obj.getClass());
                    if (interfaceC2076H9 != null) {
                        m13840YoKzxo(interfaceC2076H9, c3363aQ, obj, z);
                        return this;
                    }
                    if (obj instanceof InterfaceC4268oF) {
                        m13837JHa(c3363aQ, ((InterfaceC4268oF) obj).mo10152zza(), true);
                        return this;
                    }
                    if (obj instanceof Enum) {
                        m13837JHa(c3363aQ, ((Enum) obj).ordinal(), true);
                        return this;
                    }
                    m13839MiMN(this.f17179ZfxDd, c3363aQ, obj, z);
                    return this;
                }
                byte[] bArr = (byte[]) obj;
                if (!z || bArr.length != 0) {
                    m13833qGY((m13829Dt(c3363aQ) << 3) | 2);
                    m13833qGY(bArr.length);
                    this.f17180mjFkc.write(bArr);
                    return this;
                }
            }
        }
        return this;
    }

    /* renamed from: MiMN */
    public final C4801wF m13839MiMN(InterfaceC2735R2 interfaceC2735R2, C3363aQ c3363aQ, Object obj, boolean z) throws IOException {
        long jM13830ETF = m13830ETF(interfaceC2735R2, obj);
        if (z && jM13830ETF == 0) {
            return this;
        }
        m13833qGY((m13829Dt(c3363aQ) << 3) | 2);
        m13832fehf(jM13830ETF);
        interfaceC2735R2.mo7597mjFkc(obj, this);
        return this;
    }

    /* renamed from: YoKzxo */
    public final C4801wF m13840YoKzxo(InterfaceC2076H9 interfaceC2076H9, C3363aQ c3363aQ, Object obj, boolean z) {
        this.f17178KLFTb.m9893mjFkc(c3363aQ, z);
        interfaceC2076H9.mo7597mjFkc(obj, this.f17178KLFTb);
        return this;
    }

    /* renamed from: ZfxDd */
    public final InterfaceC2801S2 m13841ZfxDd(C3363aQ c3363aQ, float f, boolean z) throws IOException {
        if (z && f == 0.0f) {
            return this;
        }
        m13833qGY((m13829Dt(c3363aQ) << 3) | 5);
        this.f17180mjFkc.write(m13835rkYL(4).putFloat(f).array());
        return this;
    }

    /* renamed from: lgHUyS */
    public final C4801wF m13842lgHUyS(Object obj) {
        if (obj == null) {
            return this;
        }
        InterfaceC2735R2 interfaceC2735R2 = (InterfaceC2735R2) this.f17177AZxh.get(obj.getClass());
        if (interfaceC2735R2 == null) {
            throw new C2570ORe("No encoder for ".concat(String.valueOf(obj.getClass())));
        }
        interfaceC2735R2.mo7597mjFkc(obj, this);
        return this;
    }

    @Override // p131o.InterfaceC2801S2
    /* renamed from: mjFkc */
    public final /* synthetic */ InterfaceC2801S2 mo10130mjFkc(C3363aQ c3363aQ, long j) throws IOException {
        m13843xJ(c3363aQ, j, true);
        return this;
    }

    @Override // p131o.InterfaceC2801S2
    /* renamed from: wA */
    public final InterfaceC2801S2 mo10131wA(C3363aQ c3363aQ, Object obj) throws IOException {
        m13838KLFTb(c3363aQ, obj, true);
        return this;
    }

    /* renamed from: xJ */
    public final C4801wF m13843xJ(C3363aQ c3363aQ, long j, boolean z) throws IOException {
        if (!z || j != 0) {
            InterfaceC4535sF interfaceC4535sFM13831VA = m13831VA(c3363aQ);
            int iOrdinal = interfaceC4535sFM13831VA.mo12292zzb().ordinal();
            if (iOrdinal == 0) {
                m13833qGY(interfaceC4535sFM13831VA.mo12291zza() << 3);
                m13832fehf(j);
            } else if (iOrdinal == 1) {
                m13833qGY(interfaceC4535sFM13831VA.mo12291zza() << 3);
                m13832fehf((j >> 63) ^ (j + j));
            } else if (iOrdinal == 2) {
                m13833qGY((interfaceC4535sFM13831VA.mo12291zza() << 3) | 1);
                this.f17180mjFkc.write(m13835rkYL(8).putLong(j).array());
            }
        }
        return this;
    }
}
