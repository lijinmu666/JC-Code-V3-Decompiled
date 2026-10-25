package p131o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p131o.InterfaceC1929F;

/* renamed from: o.ET */
/* loaded from: classes.dex */
public final class C1892ET extends AbstractC4666uB implements IInterface {
    public C1892ET(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    /* renamed from: Ucbh */
    public final InterfaceC1929F m8127Ucbh(InterfaceC1929F interfaceC1929F, String str, int i, InterfaceC1929F interfaceC1929F2) {
        Parcel parcelM13703KLFTb = m13703KLFTb();
        AbstractC4468rE.m13364wA(parcelM13703KLFTb, interfaceC1929F);
        parcelM13703KLFTb.writeString(str);
        parcelM13703KLFTb.writeInt(i);
        AbstractC4468rE.m13364wA(parcelM13703KLFTb, interfaceC1929F2);
        Parcel parcelM13704ZfxDd = m13704ZfxDd(3, parcelM13703KLFTb);
        InterfaceC1929F interfaceC1929FM8243KLFTb = InterfaceC1929F.mjFkc.m8243KLFTb(parcelM13704ZfxDd.readStrongBinder());
        parcelM13704ZfxDd.recycle();
        return interfaceC1929FM8243KLFTb;
    }

    /* renamed from: xJ */
    public final InterfaceC1929F m8128xJ(InterfaceC1929F interfaceC1929F, String str, int i, InterfaceC1929F interfaceC1929F2) {
        Parcel parcelM13703KLFTb = m13703KLFTb();
        AbstractC4468rE.m13364wA(parcelM13703KLFTb, interfaceC1929F);
        parcelM13703KLFTb.writeString(str);
        parcelM13703KLFTb.writeInt(i);
        AbstractC4468rE.m13364wA(parcelM13703KLFTb, interfaceC1929F2);
        Parcel parcelM13704ZfxDd = m13704ZfxDd(2, parcelM13703KLFTb);
        InterfaceC1929F interfaceC1929FM8243KLFTb = InterfaceC1929F.mjFkc.m8243KLFTb(parcelM13704ZfxDd.readStrongBinder());
        parcelM13704ZfxDd.recycle();
        return interfaceC1929FM8243KLFTb;
    }
}
