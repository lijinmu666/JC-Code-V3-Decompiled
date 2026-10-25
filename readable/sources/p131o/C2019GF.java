package p131o;

import android.content.Context;
import android.os.RemoteException;
import android.os.SystemClock;
import android.util.Log;
import com.p038google.p039android.p042gms.dynamite.DynamiteModule;

/* renamed from: o.GF */
/* loaded from: classes.dex */
public final class C2019GF implements InterfaceC3561dQ {

    /* renamed from: AZxh */
    public final InterfaceC3735g8 f8342AZxh;

    /* renamed from: JHa */
    public C4688uW f8343JHa;

    /* renamed from: KLFTb */
    public final C3697fW f8344KLFTb;

    /* renamed from: ZfxDd */
    public boolean f8345ZfxDd;

    /* renamed from: mjFkc */
    public final Context f8346mjFkc;

    /* renamed from: wA */
    public boolean f8347wA;

    public C2019GF(Context context, InterfaceC3735g8 interfaceC3735g8, C3697fW c3697fW) {
        this.f8346mjFkc = context;
        this.f8342AZxh = interfaceC3735g8;
        this.f8344KLFTb = c3697fW;
    }

    /* renamed from: wA */
    public static C2376LW m8421wA(InterfaceC3735g8 interfaceC3735g8, String str) {
        int i;
        String strMo11886AZxh = interfaceC3735g8.mo11886AZxh();
        String strMo11889ZfxDd = interfaceC3735g8.mo11889ZfxDd();
        switch (interfaceC3735g8.mo11891lgHUyS()) {
            case 1:
                i = 2;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 7;
                break;
            case 7:
                i = 8;
                break;
            case 8:
                i = 9;
                break;
            default:
                i = 1;
                break;
        }
        return new C2376LW(strMo11886AZxh, strMo11889ZfxDd, str, true, i - 1, interfaceC3735g8.mo11892mjFkc(), false);
    }

    @Override // p131o.InterfaceC3561dQ
    /* renamed from: AZxh */
    public final C2936U7 mo8422AZxh(C2605P c2605p) throws C3993k2 {
        if (this.f8343JHa == null) {
            mo8424zzb();
        }
        C4688uW c4688uW = (C4688uW) AbstractC2138I3.m8648xJ(this.f8343JHa);
        if (!this.f8347wA) {
            try {
                c4688uW.m13717huTpC();
                this.f8347wA = true;
            } catch (RemoteException e) {
                throw new C3993k2("Failed to init text recognizer ".concat(String.valueOf(this.f8342AZxh.mo11894wA())), 13, e);
            }
        }
        try {
            return new C2936U7(c4688uW.m13716Ucbh(C2134I.m8634AZxh().m8637mjFkc(c2605p), new C4555sW(c2605p.m9931KLFTb(), c2605p.m9929Dt(), c2605p.m9930JHa(), AbstractC4272oJ.m12951mjFkc(c2605p.m9934qdMbNW()), SystemClock.elapsedRealtime())), c2605p.m9932ZfxDd());
        } catch (RemoteException e2) {
            throw new C3993k2("Failed to run text recognizer ".concat(String.valueOf(this.f8342AZxh.mo11894wA())), 13, e2);
        }
    }

    @Override // p131o.InterfaceC3561dQ
    /* renamed from: mjFkc */
    public final void mo8423mjFkc() {
        C4688uW c4688uW = this.f8343JHa;
        if (c4688uW != null) {
            try {
                c4688uW.m13715Gd();
            } catch (RemoteException e) {
                Log.e("DecoupledTextDelegate", "Failed to release text recognizer ".concat(String.valueOf(this.f8342AZxh.mo11894wA())), e);
            }
            this.f8343JHa = null;
        }
        this.f8347wA = false;
    }

    @Override // p131o.InterfaceC3561dQ
    /* renamed from: zzb */
    public final void mo8424zzb() throws C3993k2 {
        C4688uW c4688uWMo13783diqgf;
        if (this.f8343JHa != null) {
            return;
        }
        try {
            if (this.f8342AZxh.mo11887JHa()) {
                Log.d("DecoupledTextDelegate", "Start loading thick OCR module.");
                c4688uWMo13783diqgf = AbstractBinderC4822wW.m13859ZfxDd(DynamiteModule.m2398ZfxDd(this.f8346mjFkc, DynamiteModule.f2275wA, this.f8342AZxh.mo11893qdMbNW()).m2403wA("com.google.mlkit.vision.text.bundled.common.BundledTextRecognizerCreator")).mo13782IEE(BinderC2869T2.m10213Ucbh(this.f8346mjFkc), m8421wA(this.f8342AZxh, null));
            } else {
                Log.d("DecoupledTextDelegate", "Start loading thin OCR module.");
                InterfaceC4890xW interfaceC4890xWM13859ZfxDd = AbstractBinderC4822wW.m13859ZfxDd(DynamiteModule.m2398ZfxDd(this.f8346mjFkc, DynamiteModule.f2260AZxh, this.f8342AZxh.mo11893qdMbNW()).m2403wA("com.google.android.gms.vision.text.mlkit.TextRecognizerCreator"));
                c4688uWMo13783diqgf = this.f8342AZxh.mo11891lgHUyS() == 1 ? interfaceC4890xWM13859ZfxDd.mo13783diqgf(BinderC2869T2.m10213Ucbh(this.f8346mjFkc)) : interfaceC4890xWM13859ZfxDd.mo13782IEE(BinderC2869T2.m10213Ucbh(this.f8346mjFkc), m8421wA(this.f8342AZxh, null));
            }
            this.f8343JHa = c4688uWMo13783diqgf;
            AbstractC4188n1.m12837AZxh(this.f8344KLFTb, this.f8342AZxh.mo11887JHa(), EnumC4087lS.NO_ERROR);
        } catch (RemoteException e) {
            AbstractC4188n1.m12837AZxh(this.f8344KLFTb, this.f8342AZxh.mo11887JHa(), EnumC4087lS.OPTIONAL_MODULE_INIT_ERROR);
            throw new C3993k2("Failed to create text recognizer ".concat(String.valueOf(this.f8342AZxh.mo11894wA())), 13, e);
        } catch (DynamiteModule.C0213mjFkc e2) {
            AbstractC4188n1.m12837AZxh(this.f8344KLFTb, this.f8342AZxh.mo11887JHa(), EnumC4087lS.OPTIONAL_MODULE_NOT_AVAILABLE);
            if (this.f8342AZxh.mo11887JHa()) {
                throw new C3993k2(String.format("Failed to load text module %s. %s", this.f8342AZxh.mo11894wA(), e2.getMessage()), 13, e2);
            }
            if (!this.f8345ZfxDd) {
                AbstractC3994k3.m12466wA(this.f8346mjFkc, AbstractC3477c8.m11606mjFkc(this.f8342AZxh));
                this.f8345ZfxDd = true;
            }
            throw new C3993k2("Waiting for the text optional module to be downloaded. Please wait.", 14);
        }
    }
}
