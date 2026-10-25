package p131o;

import android.accounts.Account;
import android.content.Context;
import android.os.Looper;
import com.p038google.p039android.p042gms.p046common.p047api.C0209Scope;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.Executor;
import p131o.AbstractC3726g;
import p131o.C3389aqHPIZ;

/* renamed from: o.Qns */
/* loaded from: classes.dex */
public abstract class AbstractC2718Qns extends AbstractC2308KRckQg implements C3389aqHPIZ.JHa {

    /* renamed from: CqaNbM */
    public final Account f10273CqaNbM;

    /* renamed from: Ne */
    public final Set f10274Ne;

    /* renamed from: OjSQV */
    public final C5011zPp f10275OjSQV;

    public AbstractC2718Qns(Context context, Looper looper, int i, C5011zPp c5011zPp, AbstractC3726g.mjFkc mjfkc, AbstractC3726g.AZxh aZxh) {
        this(context, looper, i, c5011zPp, (InterfaceC3976jpz) mjfkc, (InterfaceC3338a3) aZxh);
    }

    /* renamed from: ANMGZc */
    public Set m10024ANMGZc(Set set) {
        return set;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: BAnRFn */
    public final Set mo9201BAnRFn() {
        return this.f10274Ne;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: Ucbh */
    public Executor mo9213Ucbh() {
        return null;
    }

    /* renamed from: alEkx */
    public final Set m10025alEkx(Set set) {
        Set setM10024ANMGZc = m10024ANMGZc(set);
        Iterator it = setM10024ANMGZc.iterator();
        while (it.hasNext()) {
            if (!set.contains((C0209Scope) it.next())) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return setM10024ANMGZc;
    }

    @Override // p131o.AbstractC2308KRckQg
    /* renamed from: diqgf */
    public final Account mo9220diqgf() {
        return this.f10273CqaNbM;
    }

    @Override // p131o.C3389aqHPIZ.JHa
    /* renamed from: wA */
    public Set mo10026wA() {
        return mo9216YoKzxo() ? this.f10274Ne : Collections.emptySet();
    }

    public AbstractC2718Qns(Context context, Looper looper, int i, C5011zPp c5011zPp, InterfaceC3976jpz interfaceC3976jpz, InterfaceC3338a3 interfaceC3338a3) {
        this(context, looper, AbstractC3334a.m11239mjFkc(context), C3597e.m11771MiMN(), i, c5011zPp, (InterfaceC3976jpz) AbstractC2138I3.m8648xJ(interfaceC3976jpz), (InterfaceC3338a3) AbstractC2138I3.m8648xJ(interfaceC3338a3));
    }

    public AbstractC2718Qns(Context context, Looper looper, AbstractC3334a abstractC3334a, C3597e c3597e, int i, C5011zPp c5011zPp, InterfaceC3976jpz interfaceC3976jpz, InterfaceC3338a3 interfaceC3338a3) {
        super(context, looper, abstractC3334a, c3597e, i, interfaceC3976jpz == null ? null : new C3573dd(interfaceC3976jpz), interfaceC3338a3 == null ? null : new C3832hd(interfaceC3338a3), c5011zPp.m14101lgHUyS());
        this.f10275OjSQV = c5011zPp;
        this.f10273CqaNbM = c5011zPp.m14102mjFkc();
        this.f10274Ne = m10025alEkx(c5011zPp.m14104wA());
    }
}
