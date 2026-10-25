package p131o;

import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback;
import java.util.concurrent.atomic.AtomicReference;

/* renamed from: o.Cd */
/* loaded from: classes.dex */
public abstract class AbstractDialogInterfaceOnCancelListenerC1771Cd extends LifecycleCallback implements DialogInterface.OnCancelListener {

    /* renamed from: AZxh */
    public volatile boolean f7642AZxh;

    /* renamed from: KLFTb */
    public final C3597e f7643KLFTb;

    /* renamed from: ZfxDd */
    public final Handler f7644ZfxDd;

    /* renamed from: wA */
    public final AtomicReference f7645wA;

    public AbstractDialogInterfaceOnCancelListenerC1771Cd(InterfaceC2929U0 interfaceC2929U0, C3597e c3597e) {
        super(interfaceC2929U0);
        this.f7645wA = new AtomicReference(null);
        this.f7644ZfxDd = new HandlerC2110Hd(Looper.getMainLooper());
        this.f7643KLFTb = c3597e;
    }

    /* renamed from: qGY */
    public static final int m7849qGY(C4425qd c4425qd) {
        if (c4425qd == null) {
            return -1;
        }
        return c4425qd.m13273mjFkc();
    }

    @Override // com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback
    /* renamed from: Dt */
    public void mo2384Dt() {
        super.mo2384Dt();
        this.f7642AZxh = true;
    }

    @Override // com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback
    /* renamed from: ETF */
    public void mo2385ETF() {
        super.mo2385ETF();
        this.f7642AZxh = false;
    }

    @Override // com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback
    /* renamed from: JHa */
    public final void mo2386JHa(Bundle bundle) {
        super.mo2386JHa(bundle);
        if (bundle != null) {
            this.f7645wA.set(bundle.getBoolean("resolving_error", false) ? new C4425qd(new C3613eEOGOh(bundle.getInt("failed_status"), (PendingIntent) bundle.getParcelable("failed_resolution")), bundle.getInt("failed_client_id", -1)) : null);
        }
    }

    @Override // com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback
    /* renamed from: KLFTb */
    public final void mo2387KLFTb(int i, int i2, Intent intent) {
        C4425qd c4425qd = (C4425qd) this.f7645wA.get();
        if (i != 1) {
            if (i == 2) {
                int iMo11789xJ = this.f7643KLFTb.mo11789xJ(m2383AZxh());
                if (iMo11789xJ == 0) {
                    m7854rkYL();
                    return;
                } else {
                    if (c4425qd == null) {
                        return;
                    }
                    if (c4425qd.m13272AZxh().m11826mjFkc() == 18 && iMo11789xJ == 18) {
                        return;
                    }
                }
            }
        } else if (i2 == -1) {
            m7854rkYL();
            return;
        } else if (i2 == 0) {
            if (c4425qd != null) {
                m7852VA(new C3613eEOGOh(intent != null ? intent.getIntExtra("<<ResolutionFailureErrorDetail>>", 13) : 13, null, c4425qd.m13272AZxh().toString()), m7849qGY(c4425qd));
                return;
            }
            return;
        }
        if (c4425qd != null) {
            m7852VA(c4425qd.m13272AZxh(), c4425qd.m13273mjFkc());
        }
    }

    /* renamed from: MiMN */
    public abstract void mo7850MiMN(C3613eEOGOh c3613eEOGOh, int i);

    /* renamed from: Pq */
    public final void m7851Pq(C3613eEOGOh c3613eEOGOh, int i) {
        AtomicReference atomicReference;
        C4425qd c4425qd = new C4425qd(c3613eEOGOh, i);
        do {
            atomicReference = this.f7645wA;
            if (AbstractC5024zd.m14125mjFkc(atomicReference, null, c4425qd)) {
                this.f7644ZfxDd.post(new RunnableC4960yd(this, c4425qd));
                return;
            }
        } while (atomicReference.get() == null);
    }

    /* renamed from: VA */
    public final void m7852VA(C3613eEOGOh c3613eEOGOh, int i) {
        this.f7645wA.set(null);
        mo7850MiMN(c3613eEOGOh, i);
    }

    /* renamed from: YoKzxo */
    public abstract void mo7853YoKzxo();

    @Override // android.content.DialogInterface.OnCancelListener
    public final void onCancel(DialogInterface dialogInterface) {
        m7852VA(new C3613eEOGOh(13, null), m7849qGY((C4425qd) this.f7645wA.get()));
    }

    @Override // com.p038google.p039android.p042gms.p046common.p047api.internal.LifecycleCallback
    /* renamed from: qdMbNW */
    public final void mo2390qdMbNW(Bundle bundle) {
        super.mo2390qdMbNW(bundle);
        C4425qd c4425qd = (C4425qd) this.f7645wA.get();
        if (c4425qd == null) {
            return;
        }
        bundle.putBoolean("resolving_error", true);
        bundle.putInt("failed_client_id", c4425qd.m13273mjFkc());
        bundle.putInt("failed_status", c4425qd.m13272AZxh().m11826mjFkc());
        bundle.putParcelable("failed_resolution", c4425qd.m13272AZxh().m11827wA());
    }

    /* renamed from: rkYL */
    public final void m7854rkYL() {
        this.f7645wA.set(null);
        mo7853YoKzxo();
    }
}
