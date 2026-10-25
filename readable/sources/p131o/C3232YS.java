package p131o;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import p131o.InterfaceC1929F;

/* renamed from: o.YS */
/* loaded from: classes.dex */
public final class C3232YS extends AbstractC4666uB implements IInterface {
    public C3232YS(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    /* renamed from: Gd */
    public final InterfaceC1929F m11122Gd(InterfaceC1929F interfaceC1929F, String str, int i) {
        Parcel parcelM13703KLFTb = m13703KLFTb();
        AbstractC4468rE.m13364wA(parcelM13703KLFTb, interfaceC1929F);
        parcelM13703KLFTb.writeString(str);
        parcelM13703KLFTb.writeInt(i);
        Parcel parcelM13704ZfxDd = m13704ZfxDd(2, parcelM13703KLFTb);
        InterfaceC1929F interfaceC1929FM8243KLFTb = InterfaceC1929F.mjFkc.m8243KLFTb(parcelM13704ZfxDd.readStrongBinder());
        parcelM13704ZfxDd.recycle();
        return interfaceC1929FM8243KLFTb;
    }

    /* renamed from: HGpJ */
    public final InterfaceC1929F m11123HGpJ(InterfaceC1929F interfaceC1929F, String str, int i, InterfaceC1929F interfaceC1929F2) {
        Parcel parcelM13703KLFTb = m13703KLFTb();
        AbstractC4468rE.m13364wA(parcelM13703KLFTb, interfaceC1929F);
        parcelM13703KLFTb.writeString(str);
        parcelM13703KLFTb.writeInt(i);
        AbstractC4468rE.m13364wA(parcelM13703KLFTb, interfaceC1929F2);
        Parcel parcelM13704ZfxDd = m13704ZfxDd(8, parcelM13703KLFTb);
        InterfaceC1929F interfaceC1929FM8243KLFTb = InterfaceC1929F.mjFkc.m8243KLFTb(parcelM13704ZfxDd.readStrongBinder());
        parcelM13704ZfxDd.recycle();
        return interfaceC1929FM8243KLFTb;
    }

    /* renamed from: Ucbh */
    public final int m11124Ucbh(InterfaceC1929F interfaceC1929F, String str, boolean z) {
        Parcel parcelM13703KLFTb = m13703KLFTb();
        AbstractC4468rE.m13364wA(parcelM13703KLFTb, interfaceC1929F);
        parcelM13703KLFTb.writeString(str);
        parcelM13703KLFTb.writeInt(z ? 1 : 0);
        Parcel parcelM13704ZfxDd = m13704ZfxDd(3, parcelM13703KLFTb);
        int i = parcelM13704ZfxDd.readInt();
        parcelM13704ZfxDd.recycle();
        return i;
    }

    /* renamed from: VocHEe */
    public final InterfaceC1929F m11125VocHEe(InterfaceC1929F interfaceC1929F, String str, boolean z, long j) {
        Parcel parcelM13703KLFTb = m13703KLFTb();
        AbstractC4468rE.m13364wA(parcelM13703KLFTb, interfaceC1929F);
        parcelM13703KLFTb.writeString(str);
        parcelM13703KLFTb.writeInt(z ? 1 : 0);
        parcelM13703KLFTb.writeLong(j);
        Parcel parcelM13704ZfxDd = m13704ZfxDd(7, parcelM13703KLFTb);
        InterfaceC1929F interfaceC1929FM8243KLFTb = InterfaceC1929F.mjFkc.m8243KLFTb(parcelM13704ZfxDd.readStrongBinder());
        parcelM13704ZfxDd.recycle();
        return interfaceC1929FM8243KLFTb;
    }

    /* renamed from: huTpC */
    public final int m11126huTpC(InterfaceC1929F interfaceC1929F, String str, boolean z) {
        Parcel parcelM13703KLFTb = m13703KLFTb();
        AbstractC4468rE.m13364wA(parcelM13703KLFTb, interfaceC1929F);
        parcelM13703KLFTb.writeString(str);
        parcelM13703KLFTb.writeInt(z ? 1 : 0);
        Parcel parcelM13704ZfxDd = m13704ZfxDd(5, parcelM13703KLFTb);
        int i = parcelM13704ZfxDd.readInt();
        parcelM13704ZfxDd.recycle();
        return i;
    }

    /* renamed from: vI */
    public final InterfaceC1929F m11127vI(InterfaceC1929F interfaceC1929F, String str, int i) {
        Parcel parcelM13703KLFTb = m13703KLFTb();
        AbstractC4468rE.m13364wA(parcelM13703KLFTb, interfaceC1929F);
        parcelM13703KLFTb.writeString(str);
        parcelM13703KLFTb.writeInt(i);
        Parcel parcelM13704ZfxDd = m13704ZfxDd(4, parcelM13703KLFTb);
        InterfaceC1929F interfaceC1929FM8243KLFTb = InterfaceC1929F.mjFkc.m8243KLFTb(parcelM13704ZfxDd.readStrongBinder());
        parcelM13704ZfxDd.recycle();
        return interfaceC1929FM8243KLFTb;
    }

    /* renamed from: xJ */
    public final int m11128xJ() {
        Parcel parcelM13704ZfxDd = m13704ZfxDd(6, m13703KLFTb());
        int i = parcelM13704ZfxDd.readInt();
        parcelM13704ZfxDd.recycle();
        return i;
    }
}
