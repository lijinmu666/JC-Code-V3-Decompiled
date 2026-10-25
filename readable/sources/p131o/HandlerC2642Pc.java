package p131o;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

/* renamed from: o.Pc */
/* loaded from: classes.dex */
public final class HandlerC2642Pc extends HandlerC2110Hd {

    /* renamed from: AZxh */
    public final Context f10089AZxh;

    /* renamed from: wA */
    public final /* synthetic */ C3597e f10090wA;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2642Pc(C3597e c3597e, Context context) {
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f10090wA = c3597e;
        this.f10089AZxh = context.getApplicationContext();
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + i);
            return;
        }
        C3597e c3597e = this.f10090wA;
        int iMo11789xJ = c3597e.mo11789xJ(this.f10089AZxh);
        if (c3597e.mo11773Dt(iMo11789xJ)) {
            this.f10090wA.m11787rkYL(this.f10089AZxh, iMo11789xJ);
        }
    }
}
