package p131o;

import android.content.Context;
import android.util.Log;

/* renamed from: o.kR */
/* loaded from: classes.dex */
public abstract class AbstractC4019kR {

    /* renamed from: JHa */
    public static Context f14532JHa;

    /* renamed from: mjFkc */
    public static final AbstractBinderC2892TO f14535mjFkc = new BinderC3018VH(AbstractBinderC1821DM.m7993KLFTb("0\u0082\u0005È0\u0082\u0003° \u0003\u0002\u0001\u0002\u0002\u0014\u0010\u008ae\bsù/\u008eQí"));

    /* renamed from: AZxh */
    public static final AbstractBinderC2892TO f14531AZxh = new BinderC3554dJ(AbstractBinderC1821DM.m7993KLFTb("0\u0082\u0006\u00040\u0082\u0003ì \u0003\u0002\u0001\u0002\u0002\u0014\u0003£²\u00ad×árÊkì"));

    /* renamed from: wA */
    public static final AbstractBinderC2892TO f14536wA = new BinderC4079lK(AbstractBinderC1821DM.m7993KLFTb("0\u0082\u0004C0\u0082\u0003+ \u0003\u0002\u0001\u0002\u0002\t\u0000Âà\u0087FdJ0\u008d0"));

    /* renamed from: ZfxDd */
    public static final AbstractBinderC2892TO f14534ZfxDd = new BinderC4677uL(AbstractBinderC1821DM.m7993KLFTb("0\u0082\u0004¨0\u0082\u0003\u0090 \u0003\u0002\u0001\u0002\u0002\t\u0000Õ\u0085¸l}ÓNõ0"));

    /* renamed from: KLFTb */
    public static final Object f14533KLFTb = new Object();

    /* renamed from: mjFkc */
    public static synchronized void m12546mjFkc(Context context) {
        if (f14532JHa != null) {
            Log.w("GoogleCertificates", "GoogleCertificates has been initialized already");
        } else if (context != null) {
            f14532JHa = context.getApplicationContext();
        }
    }
}
