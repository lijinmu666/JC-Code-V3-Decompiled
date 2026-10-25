package p131o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/* renamed from: o.rc */
/* loaded from: classes.dex */
public final class C4491rc extends BroadcastReceiver {

    /* renamed from: AZxh */
    public final AbstractC4424qc f16342AZxh;

    /* renamed from: mjFkc */
    public Context f16343mjFkc;

    public C4491rc(AbstractC4424qc abstractC4424qc) {
        this.f16342AZxh = abstractC4424qc;
    }

    /* renamed from: AZxh */
    public final synchronized void m13380AZxh() {
        try {
            Context context = this.f16343mjFkc;
            if (context != null) {
                context.unregisterReceiver(this);
            }
            this.f16343mjFkc = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    /* renamed from: mjFkc */
    public final void m13381mjFkc(Context context) {
        this.f16343mjFkc = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        if ("com.google.android.gms".equals(data != null ? data.getSchemeSpecificPart() : null)) {
            this.f16342AZxh.mo13271mjFkc();
            m13380AZxh();
        }
    }
}
