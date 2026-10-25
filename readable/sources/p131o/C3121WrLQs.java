package p131o;

import com.p038google.p039android.p042gms.p046common.p047api.C0210Status;
import org.conscrypt.BuildConfig;

/* renamed from: o.WrLQs */
/* loaded from: classes.dex */
public class C3121WrLQs extends Exception {

    /* renamed from: mjFkc */
    public final C0210Status f11494mjFkc;

    public C3121WrLQs(C0210Status c0210Status) {
        super(c0210Status.m2374AZxh() + ": " + (c0210Status.m2379wA() != null ? c0210Status.m2379wA() : BuildConfig.f24315FLAVOR));
        this.f11494mjFkc = c0210Status;
    }

    /* renamed from: mjFkc */
    public C0210Status m10844mjFkc() {
        return this.f11494mjFkc;
    }
}
