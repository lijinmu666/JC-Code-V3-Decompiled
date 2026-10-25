package p131o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

/* renamed from: o.hK */
/* loaded from: classes.dex */
public final class C3816hK extends AbstractC4864xB implements IInterface {
    public C3816hK(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.vision.text.internal.client.INativeTextRecognizer");
    }

    /* renamed from: Ucbh */
    public final void m12216Ucbh() {
        m13906xJ(2, m13905ZfxDd());
    }

    /* renamed from: huTpC */
    public final C2630PO[] m12217huTpC(InterfaceC1929F interfaceC1929F, C1747CF c1747cf) {
        Parcel parcelM13905ZfxDd = m13905ZfxDd();
        AbstractC4602tE.m13612AZxh(parcelM13905ZfxDd, interfaceC1929F);
        AbstractC4602tE.m13613mjFkc(parcelM13905ZfxDd, c1747cf);
        Parcel parcelM13904KLFTb = m13904KLFTb(1, parcelM13905ZfxDd);
        C2630PO[] c2630poArr = (C2630PO[]) parcelM13904KLFTb.createTypedArray(C2630PO.f10073CREATOR);
        parcelM13904KLFTb.recycle();
        return c2630poArr;
    }
}
