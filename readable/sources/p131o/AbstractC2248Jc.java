package p131o;

import android.os.DeadObjectException;
import android.os.RemoteException;
import com.p038google.p039android.p042gms.p046common.p047api.C0210Status;

/* renamed from: o.Jc */
/* loaded from: classes.dex */
public abstract class AbstractC2248Jc extends AbstractC4894xc {

    /* renamed from: AZxh */
    public final C1806D7 f9012AZxh;

    public AbstractC2248Jc(int i, C1806D7 c1806d7) {
        super(i);
        this.f9012AZxh = c1806d7;
    }

    @Override // p131o.AbstractC4028kd
    /* renamed from: AZxh */
    public final void mo9000AZxh(Exception exc) {
        this.f9012AZxh.m7976ZfxDd(exc);
    }

    /* renamed from: lgHUyS */
    public abstract void mo9001lgHUyS(C4027kc c4027kc);

    @Override // p131o.AbstractC4028kd
    /* renamed from: mjFkc */
    public final void mo9002mjFkc(C0210Status c0210Status) {
        this.f9012AZxh.m7976ZfxDd(new C3121WrLQs(c0210Status));
    }

    @Override // p131o.AbstractC4028kd
    /* renamed from: wA */
    public final void mo9003wA(C4027kc c4027kc) throws DeadObjectException {
        try {
            mo9001lgHUyS(c4027kc);
        } catch (DeadObjectException e) {
            mo9002mjFkc(AbstractC4028kd.m12586KLFTb(e));
            throw e;
        } catch (RemoteException e2) {
            mo9002mjFkc(AbstractC4028kd.m12586KLFTb(e2));
        } catch (RuntimeException e3) {
            this.f9012AZxh.m7976ZfxDd(e3);
        }
    }
}
