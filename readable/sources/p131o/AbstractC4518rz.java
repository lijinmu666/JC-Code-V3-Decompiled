package p131o;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* renamed from: o.rz */
/* loaded from: classes.dex */
public abstract class AbstractC4518rz {

    /* renamed from: AZxh */
    public static final Class f16399AZxh;

    /* renamed from: JHa */
    public static final boolean f16400JHa;

    /* renamed from: KLFTb */
    public static final boolean f16401KLFTb;

    /* renamed from: ZfxDd */
    public static final AbstractC4452qz f16402ZfxDd;

    /* renamed from: lgHUyS */
    public static final boolean f16403lgHUyS;

    /* renamed from: mjFkc */
    public static final Unsafe f16404mjFkc;

    /* renamed from: wA */
    public static final boolean f16405wA;

    /* renamed from: xJ */
    public static final long f16406xJ;

    /* JADX WARN: Removed duplicated region for block: B:11:0x003d  */
    static {
        boolean z;
        boolean z2;
        AbstractC4452qz abstractC4452qz;
        Unsafe unsafeM13414VA = m13414VA();
        f16404mjFkc = unsafeM13414VA;
        int i = AbstractC3792gx.f13874mjFkc;
        f16399AZxh = Memory.class;
        Class cls = Long.TYPE;
        boolean zM13415VocHEe = m13415VocHEe(cls);
        f16405wA = zM13415VocHEe;
        boolean zM13415VocHEe2 = m13415VocHEe(Integer.TYPE);
        AbstractC4452qz c4316oz = null;
        if (unsafeM13414VA != null) {
            if (zM13415VocHEe) {
                c4316oz = new C4383pz(unsafeM13414VA);
            } else if (zM13415VocHEe2) {
                c4316oz = new C4316oz(unsafeM13414VA);
            }
        }
        f16402ZfxDd = c4316oz;
        if (c4316oz == null) {
            z = false;
        } else {
            try {
                Class<?> cls2 = c4316oz.f16272mjFkc.getClass();
                cls2.getMethod("objectFieldOffset", Field.class);
                cls2.getMethod("getLong", Object.class, cls);
                if (m13402AZxh() != null) {
                    z = true;
                }
            } catch (Throwable th) {
                m13411MiMN(th);
            }
        }
        f16401KLFTb = z;
        AbstractC4452qz abstractC4452qz2 = f16402ZfxDd;
        if (abstractC4452qz2 == null) {
            z2 = false;
        } else {
            try {
                Class<?> cls3 = abstractC4452qz2.f16272mjFkc.getClass();
                cls3.getMethod("objectFieldOffset", Field.class);
                cls3.getMethod("arrayBaseOffset", Class.class);
                cls3.getMethod("arrayIndexScale", Class.class);
                Class cls4 = Long.TYPE;
                cls3.getMethod("getInt", Object.class, cls4);
                cls3.getMethod("putInt", Object.class, cls4, Integer.TYPE);
                cls3.getMethod("getLong", Object.class, cls4);
                cls3.getMethod("putLong", Object.class, cls4, cls4);
                cls3.getMethod("getObject", Object.class, cls4);
                cls3.getMethod("putObject", Object.class, cls4, Object.class);
                z2 = true;
            } catch (Throwable th2) {
                m13411MiMN(th2);
            }
        }
        f16400JHa = z2;
        f16406xJ = m13424mByQ(byte[].class);
        m13424mByQ(boolean[].class);
        m13425mjFkc(boolean[].class);
        m13424mByQ(int[].class);
        m13425mjFkc(int[].class);
        m13424mByQ(long[].class);
        m13425mjFkc(long[].class);
        m13424mByQ(float[].class);
        m13425mjFkc(float[].class);
        m13424mByQ(double[].class);
        m13425mjFkc(double[].class);
        m13424mByQ(Object[].class);
        m13425mjFkc(Object[].class);
        Field fieldM13402AZxh = m13402AZxh();
        if (fieldM13402AZxh != null && (abstractC4452qz = f16402ZfxDd) != null) {
            abstractC4452qz.f16272mjFkc.objectFieldOffset(fieldM13402AZxh);
        }
        f16403lgHUyS = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    /* renamed from: AZxh */
    public static Field m13402AZxh() {
        int i = AbstractC3792gx.f13874mjFkc;
        Field fieldM13430wA = m13430wA(Buffer.class, "effectiveDirectAddress");
        if (fieldM13430wA != null) {
            return fieldM13430wA;
        }
        Field fieldM13430wA2 = m13430wA(Buffer.class, "address");
        if (fieldM13430wA2 == null || fieldM13430wA2.getType() != Long.TYPE) {
            return null;
        }
        return fieldM13430wA2;
    }

    /* renamed from: BAnRFn */
    public static boolean m13403BAnRFn(Object obj, long j) {
        return f16402ZfxDd.mo13056xJ(obj, j);
    }

    /* renamed from: Dt */
    public static Object m13404Dt(Class cls) {
        try {
            return f16404mjFkc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    /* renamed from: ETF */
    public static Object m13405ETF(Object obj, long j) {
        return f16402ZfxDd.f16272mjFkc.getObject(obj, j);
    }

    /* renamed from: Gd */
    public static void m13406Gd(Object obj, long j, Object obj2) {
        f16402ZfxDd.f16272mjFkc.putObject(obj, j, obj2);
    }

    /* renamed from: HGpJ */
    public static /* bridge */ /* synthetic */ boolean m13407HGpJ(Object obj, long j) {
        return ((byte) ((f16402ZfxDd.f16272mjFkc.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    /* renamed from: IEE */
    public static void m13408IEE(Object obj, long j, boolean z) {
        f16402ZfxDd.mo13055wA(obj, j, z);
    }

    /* renamed from: JHa */
    public static double m13409JHa(Object obj, long j) {
        return f16402ZfxDd.mo13054mjFkc(obj, j);
    }

    /* renamed from: KLFTb */
    public static void m13410KLFTb(Object obj, long j, byte b) {
        AbstractC4452qz abstractC4452qz = f16402ZfxDd;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        abstractC4452qz.f16272mjFkc.putInt(obj, j2, ((255 & b) << i) | (abstractC4452qz.f16272mjFkc.getInt(obj, j2) & (~(255 << i))));
    }

    /* renamed from: MiMN */
    public static /* bridge */ /* synthetic */ void m13411MiMN(Throwable th) {
        Logger.getLogger(AbstractC4518rz.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    /* renamed from: Pq */
    public static void m13412Pq(byte[] bArr, long j, byte b) {
        f16402ZfxDd.mo13053ZfxDd(bArr, f16406xJ + j, b);
    }

    /* renamed from: Ucbh */
    public static void m13413Ucbh(Object obj, long j, int i) {
        f16402ZfxDd.f16272mjFkc.putInt(obj, j, i);
    }

    /* renamed from: VA */
    public static Unsafe m13414VA() {
        try {
            return (Unsafe) AccessController.doPrivileged(new C4250nz());
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: VocHEe */
    public static boolean m13415VocHEe(Class cls) {
        int i = AbstractC3792gx.f13874mjFkc;
        try {
            Class cls2 = f16399AZxh;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", cls, cls3);
            cls2.getMethod("pokeLong", cls, Long.TYPE, cls3);
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", cls, cls4, cls3);
            cls2.getMethod("peekInt", cls, cls3);
            cls2.getMethod("pokeByte", cls, Byte.TYPE);
            cls2.getMethod("peekByte", cls);
            cls2.getMethod("pokeByteArray", cls, byte[].class, cls4, cls4);
            cls2.getMethod("peekByteArray", cls, byte[].class, cls4, cls4);
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: ZfxDd */
    public static void m13417ZfxDd(Object obj, long j, byte b) {
        AbstractC4452qz abstractC4452qz = f16402ZfxDd;
        long j2 = (-4) & j;
        int i = abstractC4452qz.f16272mjFkc.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        abstractC4452qz.f16272mjFkc.putInt(obj, j2, ((255 & b) << i2) | (i & (~(255 << i2))));
    }

    /* renamed from: diqgf */
    public static void m13418diqgf(Object obj, long j, double d) {
        f16402ZfxDd.mo13052KLFTb(obj, j, d);
    }

    /* renamed from: eyqo */
    public static void m13419eyqo(Object obj, long j, float f) {
        f16402ZfxDd.mo13051JHa(obj, j, f);
    }

    /* renamed from: huTpC */
    public static void m13421huTpC(Object obj, long j, long j2) {
        f16402ZfxDd.f16272mjFkc.putLong(obj, j, j2);
    }

    /* renamed from: lB */
    public static boolean m13422lB() {
        return f16400JHa;
    }

    /* renamed from: lgHUyS */
    public static int m13423lgHUyS(Object obj, long j) {
        return f16402ZfxDd.f16272mjFkc.getInt(obj, j);
    }

    /* renamed from: mByQ */
    public static int m13424mByQ(Class cls) {
        if (f16400JHa) {
            return f16402ZfxDd.f16272mjFkc.arrayBaseOffset(cls);
        }
        return -1;
    }

    /* renamed from: mjFkc */
    public static int m13425mjFkc(Class cls) {
        if (f16400JHa) {
            return f16402ZfxDd.f16272mjFkc.arrayIndexScale(cls);
        }
        return -1;
    }

    /* renamed from: qdMbNW */
    public static long m13427qdMbNW(Object obj, long j) {
        return f16402ZfxDd.f16272mjFkc.getLong(obj, j);
    }

    /* renamed from: vI */
    public static /* bridge */ /* synthetic */ boolean m13429vI(Object obj, long j) {
        return ((byte) ((f16402ZfxDd.f16272mjFkc.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    /* renamed from: wA */
    public static Field m13430wA(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* renamed from: wJVbdd */
    public static boolean m13431wJVbdd() {
        return f16401KLFTb;
    }

    /* renamed from: xJ */
    public static float m13432xJ(Object obj, long j) {
        return f16402ZfxDd.mo13050AZxh(obj, j);
    }
}
