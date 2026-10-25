package p131o;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.util.Log;
import com.p038google.p039android.p042gms.dynamite.DynamiteModule;

/* renamed from: o.LG */
/* loaded from: classes.dex */
public final class C2360LG implements InterfaceC3561dQ {

    /* renamed from: AZxh */
    public final C4684uS f9420AZxh = new C4684uS(null);

    /* renamed from: ZfxDd */
    public C3816hK f9421ZfxDd;

    /* renamed from: mjFkc */
    public final Context f9422mjFkc;

    /* renamed from: wA */
    public boolean f9423wA;

    public C2360LG(Context context) {
        this.f9422mjFkc = context;
    }

    @Override // p131o.InterfaceC3561dQ
    /* renamed from: AZxh */
    public final C2936U7 mo8422AZxh(C2605P c2605p) throws C3993k2 {
        Bitmap bitmapM8488wA;
        int iM12951mjFkc;
        if (this.f9421ZfxDd == null) {
            mo8424zzb();
        }
        if (this.f9421ZfxDd == null) {
            throw new C3993k2("Waiting for the text recognition module to be downloaded. Please wait.", 14);
        }
        if (c2605p.m9931KLFTb() == -1) {
            bitmapM8488wA = c2605p.m9928AZxh();
            iM12951mjFkc = AbstractC4272oJ.m12951mjFkc(c2605p.m9934qdMbNW());
        } else {
            bitmapM8488wA = C2066H.m8480ZfxDd().m8488wA(c2605p);
            iM12951mjFkc = 0;
        }
        int i = iM12951mjFkc;
        try {
            return AbstractC2231JN.m8926mjFkc(((C3816hK) AbstractC2138I3.m8648xJ(this.f9421ZfxDd)).m12217huTpC(BinderC2869T2.m10213Ucbh(bitmapM8488wA), new C1747CF(c2605p.m9929Dt(), c2605p.m9930JHa(), 0, 0L, i)), c2605p.m9932ZfxDd());
        } catch (RemoteException e) {
            throw new C3993k2("Failed to run legacy text recognizer.", 13, e);
        }
    }

    @Override // p131o.InterfaceC3561dQ
    /* renamed from: mjFkc */
    public final void mo8423mjFkc() {
        C3816hK c3816hK = this.f9421ZfxDd;
        if (c3816hK != null) {
            try {
                c3816hK.m12216Ucbh();
            } catch (RemoteException e) {
                Log.e("LegacyTextDelegate", "Failed to release legacy text recognizer.", e);
            }
            this.f9421ZfxDd = null;
        }
    }

    @Override // p131o.InterfaceC3561dQ
    /* renamed from: zzb */
    public final void mo8424zzb() throws C3993k2 {
        if (this.f9421ZfxDd != null) {
            return;
        }
        try {
            C3816hK c3816hKMo8426ETF = AbstractBinderC5007zM.m14096ZfxDd(DynamiteModule.m2398ZfxDd(this.f9422mjFkc, DynamiteModule.f2260AZxh, "com.google.android.gms.vision.dynamite").m2403wA("com.google.android.gms.vision.text.ChimeraNativeTextRecognizerCreator")).mo8426ETF(BinderC2869T2.m10213Ucbh(this.f9422mjFkc), this.f9420AZxh);
            this.f9421ZfxDd = c3816hKMo8426ETF;
            if (c3816hKMo8426ETF != null || this.f9423wA) {
                return;
            }
            Log.d("LegacyTextDelegate", "Request OCR optional module download.");
            AbstractC3994k3.m12465mjFkc(this.f9422mjFkc, "ocr");
            this.f9423wA = true;
        } catch (RemoteException e) {
            throw new C3993k2("Failed to create legacy text recognizer.", 13, e);
        } catch (DynamiteModule.C0213mjFkc e2) {
            throw new C3993k2("Failed to load deprecated vision dynamite module.", 13, e2);
        }
    }
}
