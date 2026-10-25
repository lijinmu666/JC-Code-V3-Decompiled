package p131o;

import android.os.Parcel;

/* renamed from: o.Oc */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2578Oc extends AbstractBinderC3304Zb implements InterfaceC2903Tc {
    public AbstractBinderC2578Oc() {
        super("com.google.android.gms.signin.internal.ISignInCallbacks");
    }

    @Override // p131o.AbstractBinderC3304Zb
    /* renamed from: Ucbh */
    public final boolean mo9521Ucbh(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                AbstractC4759vc.m13786AZxh(parcel);
                break;
            case 4:
                AbstractC4759vc.m13786AZxh(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                AbstractC4759vc.m13786AZxh(parcel);
                break;
            case 7:
                AbstractC4759vc.m13786AZxh(parcel);
                break;
            case 8:
                C4161md c4161md = (C4161md) AbstractC4759vc.m13788mjFkc(parcel, C4161md.f15203CREATOR);
                AbstractC4759vc.m13786AZxh(parcel);
                mo8442MiMN(c4161md);
                break;
            case 9:
                AbstractC4759vc.m13786AZxh(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
