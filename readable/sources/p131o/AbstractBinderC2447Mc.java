package p131o;

import android.os.Parcel;
import com.p038google.p039android.p042gms.p046common.p047api.C0210Status;

/* renamed from: o.Mc */
/* loaded from: classes.dex */
public abstract class AbstractBinderC2447Mc extends AbstractBinderC3304Zb implements InterfaceC2705Qc {
    public AbstractBinderC2447Mc() {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks");
    }

    @Override // p131o.AbstractBinderC3304Zb
    /* renamed from: Ucbh */
    public final boolean mo9521Ucbh(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            C0210Status c0210Status = (C0210Status) AbstractC4759vc.m13788mjFkc(parcel, C0210Status.f2246CREATOR);
            C4254o2 c4254o2 = (C4254o2) AbstractC4759vc.m13788mjFkc(parcel, C4254o2.f15493CREATOR);
            AbstractC4759vc.m13786AZxh(parcel);
            mo9373lgHUyS(c0210Status, c4254o2);
        } else if (i == 2) {
            C0210Status c0210Status2 = (C0210Status) AbstractC4759vc.m13788mjFkc(parcel, C0210Status.f2246CREATOR);
            C4589t2 c4589t2 = (C4589t2) AbstractC4759vc.m13788mjFkc(parcel, C4589t2.f16599CREATOR);
            AbstractC4759vc.m13786AZxh(parcel);
            mo8166VA(c0210Status2, c4589t2);
        } else if (i == 3) {
            C0210Status c0210Status3 = (C0210Status) AbstractC4759vc.m13788mjFkc(parcel, C0210Status.f2246CREATOR);
            C4456r2 c4456r2 = (C4456r2) AbstractC4759vc.m13788mjFkc(parcel, C4456r2.f16275CREATOR);
            AbstractC4759vc.m13786AZxh(parcel);
            mo9371Pq(c0210Status3, c4456r2);
        } else {
            if (i != 4) {
                return false;
            }
            C0210Status c0210Status4 = (C0210Status) AbstractC4759vc.m13788mjFkc(parcel, C0210Status.f2246CREATOR);
            AbstractC4759vc.m13786AZxh(parcel);
            mo9372fehf(c0210Status4);
        }
        return true;
    }
}
