package p131o;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.conscrypt.BuildConfig;
import p131o.C3788gtr;

/* renamed from: o.HPA */
/* loaded from: classes.dex */
public abstract class AbstractC2097HPA {

    /* renamed from: o.HPA$mjFkc */
    public static abstract class mjFkc {
        /* renamed from: AZxh */
        public final mjFkc m8557AZxh(String str, long j) {
            mo8561KLFTb().put(str, String.valueOf(j));
            return this;
        }

        /* renamed from: Dt */
        public abstract mjFkc mo8558Dt(String str);

        /* renamed from: ETF */
        public abstract mjFkc mo8559ETF(long j);

        /* renamed from: JHa */
        public abstract mjFkc mo8560JHa(Map map);

        /* renamed from: KLFTb */
        public abstract Map mo8561KLFTb();

        /* renamed from: ZfxDd */
        public abstract AbstractC2097HPA mo8562ZfxDd();

        /* renamed from: lgHUyS */
        public abstract mjFkc mo8563lgHUyS(C3331ZxmHEb c3331ZxmHEb);

        /* renamed from: mjFkc */
        public final mjFkc m8564mjFkc(String str, int i) {
            mo8561KLFTb().put(str, String.valueOf(i));
            return this;
        }

        /* renamed from: qdMbNW */
        public abstract mjFkc mo8565qdMbNW(long j);

        /* renamed from: wA */
        public final mjFkc m8566wA(String str, String str2) {
            mo8561KLFTb().put(str, str2);
            return this;
        }

        /* renamed from: xJ */
        public abstract mjFkc mo8567xJ(Integer num);
    }

    /* renamed from: mjFkc */
    public static mjFkc m8545mjFkc() {
        return new C3788gtr.AZxh().mo8560JHa(new HashMap());
    }

    /* renamed from: AZxh */
    public final String m8546AZxh(String str) {
        String str2 = (String) mo8555wA().get(str);
        return str2 == null ? BuildConfig.f24315FLAVOR : str2;
    }

    /* renamed from: Dt */
    public abstract String mo8547Dt();

    /* renamed from: ETF */
    public abstract long mo8548ETF();

    /* renamed from: JHa */
    public abstract long mo8549JHa();

    /* renamed from: KLFTb */
    public abstract C3331ZxmHEb mo8550KLFTb();

    /* renamed from: VA */
    public mjFkc m8551VA() {
        return new C3788gtr.AZxh().mo8558Dt(mo8547Dt()).mo8567xJ(mo8552ZfxDd()).mo8563lgHUyS(mo8550KLFTb()).mo8565qdMbNW(mo8549JHa()).mo8559ETF(mo8548ETF()).mo8560JHa(new HashMap(mo8555wA()));
    }

    /* renamed from: ZfxDd */
    public abstract Integer mo8552ZfxDd();

    /* renamed from: lgHUyS */
    public final long m8553lgHUyS(String str) {
        String str2 = (String) mo8555wA().get(str);
        if (str2 == null) {
            return 0L;
        }
        return Long.valueOf(str2).longValue();
    }

    /* renamed from: qdMbNW */
    public final Map m8554qdMbNW() {
        return Collections.unmodifiableMap(mo8555wA());
    }

    /* renamed from: wA */
    public abstract Map mo8555wA();

    /* renamed from: xJ */
    public final int m8556xJ(String str) {
        String str2 = (String) mo8555wA().get(str);
        if (str2 == null) {
            return 0;
        }
        return Integer.valueOf(str2).intValue();
    }
}
