package p131o;

import android.content.Context;

/* renamed from: o.Bb */
/* loaded from: classes.dex */
public class C1703Bb {

    /* renamed from: AZxh */
    public static final C1703Bb f7497AZxh = new C1703Bb();

    /* renamed from: mjFkc */
    public C4255o3 f7498mjFkc = null;

    /* renamed from: mjFkc */
    public static C4255o3 m7729mjFkc(Context context) {
        return f7497AZxh.m7730AZxh(context);
    }

    /* renamed from: AZxh */
    public final synchronized C4255o3 m7730AZxh(Context context) {
        try {
            if (this.f7498mjFkc == null) {
                if (context.getApplicationContext() != null) {
                    context = context.getApplicationContext();
                }
                this.f7498mjFkc = new C4255o3(context);
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.f7498mjFkc;
    }
}
