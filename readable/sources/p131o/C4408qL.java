package p131o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: o.qL */
/* loaded from: classes.dex */
public final class C4408qL extends AbstractC4864xB implements InterfaceC2028GN {
    public C4408qL(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizerCreator");
    }

    @Override // p131o.InterfaceC2028GN
    /* renamed from: ETF */
    public final C3816hK mo8426ETF(InterfaceC1929F interfaceC1929F, C4684uS c4684uS) {
        C3816hK c3816hK;
        Parcel parcelM13905ZfxDd = m13905ZfxDd();
        AbstractC4602tE.m13612AZxh(parcelM13905ZfxDd, interfaceC1929F);
        AbstractC4602tE.m13613mjFkc(parcelM13905ZfxDd, c4684uS);
        Parcel parcelM13904KLFTb = m13904KLFTb(1, parcelM13905ZfxDd);
        IBinder strongBinder = parcelM13904KLFTb.readStrongBinder();
        if (strongBinder == null) {
            c3816hK = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
            c3816hK = iInterfaceQueryLocalInterface instanceof C3816hK ? (C3816hK) iInterfaceQueryLocalInterface : new C3816hK(strongBinder);
        }
        parcelM13904KLFTb.recycle();
        return c3816hK;
    }
}
