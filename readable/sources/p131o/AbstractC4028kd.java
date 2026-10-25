package p131o;

import android.os.RemoteException;
import com.p038google.p039android.p042gms.p046common.p047api.C0210Status;

/* renamed from: o.kd */
/* loaded from: classes.dex */
public abstract class AbstractC4028kd {

    /* renamed from: mjFkc */
    public final int f14560mjFkc;

    public AbstractC4028kd(int i) {
        this.f14560mjFkc = i;
    }

    /* renamed from: KLFTb */
    public static /* bridge */ /* synthetic */ C0210Status m12586KLFTb(RemoteException remoteException) {
        return new C0210Status(19, remoteException.getClass().getSimpleName() + ": " + remoteException.getLocalizedMessage());
    }

    /* renamed from: AZxh */
    public abstract void mo9000AZxh(Exception exc);

    /* renamed from: ZfxDd */
    public abstract void mo11612ZfxDd(C2969Ub c2969Ub, boolean z);

    /* renamed from: mjFkc */
    public abstract void mo9002mjFkc(C0210Status c0210Status);

    /* renamed from: wA */
    public abstract void mo9003wA(C4027kc c4027kc);
}
