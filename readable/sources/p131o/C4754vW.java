package p131o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: o.vW */
/* loaded from: classes.dex */
public final class C4754vW extends AbstractC4864xB implements InterfaceC4890xW {
    public C4754vW(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.text.aidls.ITextRecognizerCreator");
    }

    @Override // p131o.InterfaceC4890xW
    /* renamed from: IEE */
    public final C4688uW mo13782IEE(InterfaceC1929F interfaceC1929F, C2376LW c2376lw) {
        C4688uW c4688uW;
        Parcel parcelM13905ZfxDd = m13905ZfxDd();
        AbstractC4602tE.m13612AZxh(parcelM13905ZfxDd, interfaceC1929F);
        AbstractC4602tE.m13613mjFkc(parcelM13905ZfxDd, c2376lw);
        Parcel parcelM13904KLFTb = m13904KLFTb(2, parcelM13905ZfxDd);
        IBinder strongBinder = parcelM13904KLFTb.readStrongBinder();
        if (strongBinder == null) {
            c4688uW = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizer");
            c4688uW = iInterfaceQueryLocalInterface instanceof C4688uW ? (C4688uW) iInterfaceQueryLocalInterface : new C4688uW(strongBinder);
        }
        parcelM13904KLFTb.recycle();
        return c4688uW;
    }

    @Override // p131o.InterfaceC4890xW
    /* renamed from: diqgf */
    public final C4688uW mo13783diqgf(InterfaceC1929F interfaceC1929F) {
        C4688uW c4688uW;
        Parcel parcelM13905ZfxDd = m13905ZfxDd();
        AbstractC4602tE.m13612AZxh(parcelM13905ZfxDd, interfaceC1929F);
        Parcel parcelM13904KLFTb = m13904KLFTb(1, parcelM13905ZfxDd);
        IBinder strongBinder = parcelM13904KLFTb.readStrongBinder();
        if (strongBinder == null) {
            c4688uW = null;
        } else {
            IInterface iInterfaceQueryLocalInterface = strongBinder.queryLocalInterface("com.google.mlkit.vision.text.aidls.ITextRecognizer");
            c4688uW = iInterfaceQueryLocalInterface instanceof C4688uW ? (C4688uW) iInterfaceQueryLocalInterface : new C4688uW(strongBinder);
        }
        parcelM13904KLFTb.recycle();
        return c4688uW;
    }
}
