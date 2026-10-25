package p131o;

import android.content.Context;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: o.hW */
/* loaded from: classes.dex */
public final class C3828hW {

    /* renamed from: AZxh */
    public final AtomicLong f14025AZxh = new AtomicLong(-1);

    /* renamed from: mjFkc */
    public final InterfaceC2806S7 f14026mjFkc;

    public C3828hW(Context context, String str) {
        this.f14026mjFkc = AbstractC2740R7.m10041AZxh(context, C2874T7.m10216mjFkc().m10219AZxh("mlkit:vision").m10220mjFkc());
    }

    /* renamed from: mjFkc */
    public static C3828hW m12223mjFkc(Context context) {
        return new C3828hW(context, "mlkit:vision");
    }

    /* renamed from: AZxh */
    public final /* synthetic */ void m12224AZxh(long j, Exception exc) {
        this.f14025AZxh.set(j);
    }

    /* renamed from: wA */
    public final synchronized void m12225wA(int i, int i2, long j, long j2) {
        AtomicLong atomicLong = this.f14025AZxh;
        final long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (atomicLong.get() != -1 && jElapsedRealtime - this.f14025AZxh.get() <= TimeUnit.MINUTES.toMillis(30L)) {
            return;
        }
        this.f14026mjFkc.mo10134mjFkc(new C2675Q7(0, Arrays.asList(new C3729g2(i, i2, 0, j, j2, null, null, 0, -1)))).mo7670wA(new InterfaceC3405b3() { // from class: o.gW
            @Override // p131o.InterfaceC3405b3
            /* renamed from: mjFkc */
            public final void mo4877mjFkc(Exception exc) {
                this.f13719mjFkc.m12224AZxh(jElapsedRealtime, exc);
            }
        });
    }
}
