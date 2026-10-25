package p131o;

import android.content.Context;
import android.os.RemoteException;
import org.conscrypt.BuildConfig;
import p131o.AbstractC2038Ga;

/* renamed from: o.Qd */
/* loaded from: classes.dex */
public final class BinderC2706Qd extends AbstractBinderC2060Gu {

    /* renamed from: AZxh */
    public final String f10188AZxh;

    /* renamed from: JHa */
    public C4110lr f10189JHa;

    /* renamed from: KLFTb */
    public final String f10190KLFTb;

    /* renamed from: ZfxDd */
    public final String f10191ZfxDd;

    /* renamed from: mjFkc */
    public final Context f10192mjFkc;

    /* renamed from: wA */
    public final boolean f10193wA;

    public BinderC2706Qd(Context context, String str, String str2, String str3, boolean z) {
        this.f10192mjFkc = context;
        this.f10188AZxh = str;
        this.f10191ZfxDd = str2;
        this.f10190KLFTb = str3;
        this.f10193wA = z;
    }

    @Override // p131o.InterfaceC2337Ku
    /* renamed from: AZxh */
    public final void mo9285AZxh() throws RemoteException {
        if (this.f10189JHa == null) {
            System.loadLibrary("mlkit_google_ocr_pipeline");
            String str = this.f10190KLFTb;
            String str2 = (str == null || str.isEmpty()) ? BuildConfig.f24315FLAVOR : this.f10190KLFTb;
            String str3 = this.f10188AZxh;
            String str4 = this.f10191ZfxDd;
            boolean z = this.f10193wA;
            AbstractC2038Ga.mjFkc mjfkcM8428mjFkc = AbstractC2038Ga.m8428mjFkc(str3, str4, str2);
            mjfkcM8428mjFkc.mo8433AZxh(z);
            C4110lr c4110lrM12712mjFkc = C4110lr.m12712mjFkc(this.f10192mjFkc, mjfkcM8428mjFkc.mo8435mjFkc());
            this.f10189JHa = c4110lrM12712mjFkc;
            AbstractC2194Iu abstractC2194IuM12715wA = c4110lrM12712mjFkc.m12715wA();
            if (!abstractC2194IuM12715wA.m8804ZfxDd()) {
                throw ((RemoteException) abstractC2194IuM12715wA.mo8803AZxh().mo7939mjFkc());
            }
        }
    }

    @Override // p131o.InterfaceC2337Ku
    /* renamed from: Dt */
    public final C4908xp[] mo9286Dt(InterfaceC1929F interfaceC1929F, C1923Eu c1923Eu) throws RemoteException {
        throw new RemoteException("#recognizeBitmap should not be triggered from text thick client.");
    }

    @Override // p131o.InterfaceC2337Ku
    /* renamed from: JHa */
    public final void mo9287JHa() {
        C4110lr c4110lr = this.f10189JHa;
        if (c4110lr != null) {
            c4110lr.m12714ZfxDd();
            this.f10189JHa = null;
        }
    }

    @Override // p131o.InterfaceC2337Ku
    /* renamed from: rkYL */
    public final C2994Uu mo9288rkYL(InterfaceC1929F interfaceC1929F, C1923Eu c1923Eu) throws C3993k2, RemoteException {
        C4110lr c4110lr = this.f10189JHa;
        if (c4110lr == null) {
            throw new RemoteException("Process is started without initiation.");
        }
        AbstractC3720fu abstractC3720fuM12713AZxh = ((C4110lr) AbstractC2138I3.m8648xJ(c4110lr)).m12713AZxh(interfaceC1929F, c1923Eu, true);
        AbstractC2194Iu abstractC2194IuMo10090wA = abstractC3720fuM12713AZxh.mo10090wA();
        if (abstractC2194IuMo10090wA.m8804ZfxDd()) {
            return abstractC3720fuM12713AZxh.mo10086AZxh();
        }
        throw ((RemoteException) abstractC2194IuMo10090wA.mo8803AZxh().mo7939mjFkc());
    }
}
