package p131o;

import android.os.SystemClock;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* renamed from: o.RP */
/* loaded from: classes.dex */
public class C2758RP implements Closeable {

    /* renamed from: lgHUyS */
    public static final Map f10412lgHUyS = new HashMap();

    /* renamed from: AZxh */
    public int f10413AZxh;

    /* renamed from: JHa */
    public long f10414JHa;

    /* renamed from: KLFTb */
    public long f10415KLFTb;

    /* renamed from: ZfxDd */
    public long f10416ZfxDd;

    /* renamed from: mjFkc */
    public final String f10417mjFkc;

    /* renamed from: wA */
    public double f10418wA;

    /* renamed from: xJ */
    public long f10419xJ;

    public C2758RP(String str) {
        this.f10414JHa = 2147483647L;
        this.f10419xJ = -2147483648L;
        this.f10417mjFkc = str;
    }

    /* renamed from: qdMbNW */
    public static C2758RP m10060qdMbNW(String str) {
        C3364aR.m11318mjFkc();
        if (!C3364aR.m11317AZxh()) {
            return C2436MP.f9577qdMbNW;
        }
        Map map = f10412lgHUyS;
        if (map.get("detectorTaskWithResource#run") == null) {
            map.put("detectorTaskWithResource#run", new C2758RP("detectorTaskWithResource#run"));
        }
        return (C2758RP) map.get("detectorTaskWithResource#run");
    }

    /* renamed from: KLFTb */
    public C2758RP mo9503KLFTb() {
        this.f10416ZfxDd = SystemClock.elapsedRealtimeNanos() / 1000;
        return this;
    }

    /* renamed from: ZfxDd */
    public final void m10061ZfxDd() {
        this.f10413AZxh = 0;
        this.f10418wA = 0.0d;
        this.f10416ZfxDd = 0L;
        this.f10414JHa = 2147483647L;
        this.f10419xJ = -2147483648L;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        long j = this.f10416ZfxDd;
        if (j == 0) {
            throw new IllegalStateException("Did you forget to call start()?");
        }
        mo9504lgHUyS(j);
    }

    /* renamed from: lgHUyS */
    public void mo9504lgHUyS(long j) {
        mo9505xJ((SystemClock.elapsedRealtimeNanos() / 1000) - j);
    }

    /* renamed from: xJ */
    public void mo9505xJ(long j) {
        long jElapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos() / 1000;
        long j2 = this.f10415KLFTb;
        if (j2 != 0 && jElapsedRealtimeNanos - j2 >= 1000000) {
            m10061ZfxDd();
        }
        this.f10415KLFTb = jElapsedRealtimeNanos;
        this.f10413AZxh++;
        this.f10418wA += j;
        this.f10414JHa = Math.min(this.f10414JHa, j);
        this.f10419xJ = Math.max(this.f10419xJ, j);
        if (this.f10413AZxh % 50 == 0) {
            String.format(Locale.US, "[%s] cur=%dus, counts=%d, min=%dus, max=%dus, avg=%dus", this.f10417mjFkc, Long.valueOf(j), Integer.valueOf(this.f10413AZxh), Long.valueOf(this.f10414JHa), Long.valueOf(this.f10419xJ), Integer.valueOf((int) (this.f10418wA / this.f10413AZxh)));
            C3364aR.m11318mjFkc();
        }
        if (this.f10413AZxh % 500 == 0) {
            m10061ZfxDd();
        }
    }
}
