package p131o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: o.uW */
/* loaded from: classes.dex */
public final class C4688uW extends AbstractC4864xB implements IInterface {
    public C4688uW(IBinder iBinder) {
        super(iBinder, "com.google.mlkit.vision.text.aidls.ITextRecognizer");
    }

    /* renamed from: Gd */
    public final void m13715Gd() {
        m13906xJ(2, m13905ZfxDd());
    }

    /* renamed from: Ucbh */
    public final C2243JW m13716Ucbh(InterfaceC1929F interfaceC1929F, C4555sW c4555sW) {
        Parcel parcelM13905ZfxDd = m13905ZfxDd();
        AbstractC4602tE.m13612AZxh(parcelM13905ZfxDd, interfaceC1929F);
        AbstractC4602tE.m13613mjFkc(parcelM13905ZfxDd, c4555sW);
        Parcel parcelM13904KLFTb = m13904KLFTb(3, parcelM13905ZfxDd);
        C2243JW c2243jwCreateFromParcel = parcelM13904KLFTb.readInt() == 0 ? null : C2243JW.f8985CREATOR.createFromParcel(parcelM13904KLFTb);
        parcelM13904KLFTb.recycle();
        return c2243jwCreateFromParcel;
    }

    /* renamed from: huTpC */
    public final void m13717huTpC() {
        m13906xJ(1, m13905ZfxDd());
    }
}
