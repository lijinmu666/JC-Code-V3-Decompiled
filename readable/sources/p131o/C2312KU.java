package p131o;

import android.content.Context;
import com.p038google.p039android.p042gms.dynamite.DynamiteModule;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Callable;

/* renamed from: o.KU */
/* loaded from: classes.dex */
public final class C2312KU {

    /* renamed from: qdMbNW */
    public static final AbstractC3414bC f9189qdMbNW = AbstractC3414bC.m11474wA("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* renamed from: AZxh */
    public final String f9190AZxh;

    /* renamed from: JHa */
    public final AbstractC1670B7 f9191JHa;

    /* renamed from: KLFTb */
    public final AbstractC1670B7 f9192KLFTb;

    /* renamed from: ZfxDd */
    public final C2483N6 f9193ZfxDd;

    /* renamed from: lgHUyS */
    public final int f9194lgHUyS;

    /* renamed from: mjFkc */
    public final String f9195mjFkc;

    /* renamed from: wA */
    public final InterfaceC4352pU f9196wA;

    /* renamed from: xJ */
    public final String f9197xJ;

    public C2312KU(Context context, final C2483N6 c2483n6, InterfaceC4352pU interfaceC4352pU, String str) {
        new HashMap();
        new HashMap();
        this.f9195mjFkc = context.getPackageName();
        this.f9190AZxh = AbstractC3199XyP.m11004mjFkc(context);
        this.f9193ZfxDd = c2483n6;
        this.f9196wA = interfaceC4352pU;
        C3955jV.m12437mjFkc();
        this.f9197xJ = str;
        this.f9192KLFTb = C4521s1.m13442mjFkc().m13443AZxh(new Callable() { // from class: o.FU
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.f8202mjFkc.m9241mjFkc();
            }
        });
        C4521s1 c4521s1M13442mjFkc = C4521s1.m13442mjFkc();
        Objects.requireNonNull(c2483n6);
        this.f9191JHa = c4521s1M13442mjFkc.m13443AZxh(new Callable() { // from class: o.HU
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return c2483n6.m9587mjFkc();
            }
        });
        AbstractC3414bC abstractC3414bC = f9189qdMbNW;
        this.f9194lgHUyS = abstractC3414bC.containsKey(str) ? DynamiteModule.m2393AZxh(context, (String) abstractC3414bC.get(str)) : -1;
    }

    /* renamed from: mjFkc */
    public final /* synthetic */ String m9241mjFkc() {
        return C2733R0.m10035mjFkc().m10036AZxh(this.f9197xJ);
    }
}
