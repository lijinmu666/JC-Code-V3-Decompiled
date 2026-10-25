package p131o;

import android.app.Dialog;
import android.app.PendingIntent;
import com.p038google.p039android.p042gms.p046common.p047api.GoogleApiActivity;

/* renamed from: o.yd */
/* loaded from: classes.dex */
public final class RunnableC4960yd implements Runnable {

    /* renamed from: AZxh */
    public final /* synthetic */ AbstractDialogInterfaceOnCancelListenerC1771Cd f17541AZxh;

    /* renamed from: mjFkc */
    public final C4425qd f17542mjFkc;

    public RunnableC4960yd(AbstractDialogInterfaceOnCancelListenerC1771Cd abstractDialogInterfaceOnCancelListenerC1771Cd, C4425qd c4425qd) {
        this.f17541AZxh = abstractDialogInterfaceOnCancelListenerC1771Cd;
        this.f17542mjFkc = c4425qd;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f17541AZxh.f7642AZxh) {
            C3613eEOGOh c3613eEOGOhM13272AZxh = this.f17542mjFkc.m13272AZxh();
            if (c3613eEOGOhM13272AZxh.m11824ZfxDd()) {
                AbstractDialogInterfaceOnCancelListenerC1771Cd abstractDialogInterfaceOnCancelListenerC1771Cd = this.f17541AZxh;
                abstractDialogInterfaceOnCancelListenerC1771Cd.f2259mjFkc.startActivityForResult(GoogleApiActivity.m2370mjFkc(abstractDialogInterfaceOnCancelListenerC1771Cd.m2383AZxh(), (PendingIntent) AbstractC2138I3.m8648xJ(c3613eEOGOhM13272AZxh.m11827wA()), this.f17542mjFkc.m13273mjFkc(), false), 1);
                return;
            }
            AbstractDialogInterfaceOnCancelListenerC1771Cd abstractDialogInterfaceOnCancelListenerC1771Cd2 = this.f17541AZxh;
            if (abstractDialogInterfaceOnCancelListenerC1771Cd2.f7643KLFTb.mo11772AZxh(abstractDialogInterfaceOnCancelListenerC1771Cd2.m2383AZxh(), c3613eEOGOhM13272AZxh.m11826mjFkc(), null) != null) {
                AbstractDialogInterfaceOnCancelListenerC1771Cd abstractDialogInterfaceOnCancelListenerC1771Cd3 = this.f17541AZxh;
                abstractDialogInterfaceOnCancelListenerC1771Cd3.f7643KLFTb.m11778Ucbh(abstractDialogInterfaceOnCancelListenerC1771Cd3.m2383AZxh(), abstractDialogInterfaceOnCancelListenerC1771Cd3.f2259mjFkc, c3613eEOGOhM13272AZxh.m11826mjFkc(), 2, this.f17541AZxh);
                return;
            }
            if (c3613eEOGOhM13272AZxh.m11826mjFkc() != 18) {
                this.f17541AZxh.m7852VA(c3613eEOGOhM13272AZxh, this.f17542mjFkc.m13273mjFkc());
                return;
            }
            AbstractDialogInterfaceOnCancelListenerC1771Cd abstractDialogInterfaceOnCancelListenerC1771Cd4 = this.f17541AZxh;
            Dialog dialogM11783fehf = abstractDialogInterfaceOnCancelListenerC1771Cd4.f7643KLFTb.m11783fehf(abstractDialogInterfaceOnCancelListenerC1771Cd4.m2383AZxh(), abstractDialogInterfaceOnCancelListenerC1771Cd4);
            AbstractDialogInterfaceOnCancelListenerC1771Cd abstractDialogInterfaceOnCancelListenerC1771Cd5 = this.f17541AZxh;
            abstractDialogInterfaceOnCancelListenerC1771Cd5.f7643KLFTb.m11775IEE(abstractDialogInterfaceOnCancelListenerC1771Cd5.m2383AZxh().getApplicationContext(), new C4692ud(this, dialogM11783fehf));
        }
    }
}
