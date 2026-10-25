package p131o;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

/* renamed from: o.m0 */
/* loaded from: classes.dex */
public final class C4121m0 implements InterfaceC3987jxC {

    /* renamed from: KLFTb */
    public static final InterfaceC2735R2 f14845KLFTb = C3920j0.m12332AZxh();

    /* renamed from: JHa */
    public static final InterfaceC2076H9 f14844JHa = C3991k0.m12459AZxh();

    /* renamed from: xJ */
    public static final InterfaceC2076H9 f14847xJ = C4057l0.m12649AZxh();

    /* renamed from: lgHUyS */
    public static final AZxh f14846lgHUyS = new AZxh(null);

    /* renamed from: mjFkc */
    public final Map f14850mjFkc = new HashMap();

    /* renamed from: AZxh */
    public final Map f14848AZxh = new HashMap();

    /* renamed from: wA */
    public InterfaceC2735R2 f14851wA = f14845KLFTb;

    /* renamed from: ZfxDd */
    public boolean f14849ZfxDd = false;

    /* renamed from: o.m0$AZxh */
    public static final class AZxh implements InterfaceC2076H9 {

        /* renamed from: mjFkc */
        public static final DateFormat f14852mjFkc;

        static {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.US);
            f14852mjFkc = simpleDateFormat;
            simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
        }

        public AZxh() {
        }

        @Override // p131o.InterfaceC4156mYYU
        /* renamed from: AZxh, reason: merged with bridge method [inline-methods] */
        public void mo7597mjFkc(Date date, InterfaceC2144I9 interfaceC2144I9) {
            interfaceC2144I9.mo8720add(f14852mjFkc.format(date));
        }

        public /* synthetic */ AZxh(mjFkc mjfkc) {
            this();
        }
    }

    /* renamed from: o.m0$mjFkc */
    public class mjFkc implements InterfaceC3874iEjzEW {
        public mjFkc() {
        }

        @Override // p131o.InterfaceC3874iEjzEW
        /* renamed from: AZxh */
        public void mo12289AZxh(Object obj, Writer writer) {
            C4985z0 c4985z0 = new C4985z0(writer, C4121m0.this.f14850mjFkc, C4121m0.this.f14848AZxh, C4121m0.this.f14851wA, C4121m0.this.f14849ZfxDd);
            c4985z0.m14064KLFTb(obj, false);
            c4985z0.m14066VA();
        }

        @Override // p131o.InterfaceC3874iEjzEW
        /* renamed from: mjFkc */
        public String mo12290mjFkc(Object obj) {
            StringWriter stringWriter = new StringWriter();
            try {
                mo12289AZxh(obj, stringWriter);
            } catch (IOException unused) {
            }
            return stringWriter.toString();
        }
    }

    public C4121m0() {
        m12728MiMN(String.class, f14844JHa);
        m12728MiMN(Boolean.class, f14847xJ);
        m12728MiMN(Date.class, f14846lgHUyS);
    }

    /* renamed from: qdMbNW */
    public static /* synthetic */ void m12725qdMbNW(Object obj, InterfaceC2801S2 interfaceC2801S2) {
        throw new C2570ORe("Couldn't find encoder for type " + obj.getClass().getCanonicalName());
    }

    /* renamed from: JHa */
    public InterfaceC3874iEjzEW m12727JHa() {
        return new mjFkc();
    }

    /* renamed from: MiMN */
    public C4121m0 m12728MiMN(Class cls, InterfaceC2076H9 interfaceC2076H9) {
        this.f14848AZxh.put(cls, interfaceC2076H9);
        this.f14850mjFkc.remove(cls);
        return this;
    }

    @Override // p131o.InterfaceC3987jxC
    /* renamed from: VA, reason: merged with bridge method [inline-methods] */
    public C4121m0 mo9183mjFkc(Class cls, InterfaceC2735R2 interfaceC2735R2) {
        this.f14850mjFkc.put(cls, interfaceC2735R2);
        this.f14848AZxh.remove(cls);
        return this;
    }

    /* renamed from: lgHUyS */
    public C4121m0 m12730lgHUyS(boolean z) {
        this.f14849ZfxDd = z;
        return this;
    }

    /* renamed from: xJ */
    public C4121m0 m12731xJ(InterfaceC3285ZGL interfaceC3285ZGL) {
        interfaceC3285ZGL.mo9658mjFkc(this);
        return this;
    }
}
