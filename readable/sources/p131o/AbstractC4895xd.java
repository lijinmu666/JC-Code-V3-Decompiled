package p131o;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

/* renamed from: o.xd */
/* loaded from: classes.dex */
public abstract class AbstractC4895xd extends AbstractC4294ofHOBL {
    /* renamed from: ZfxDd */
    public static Intent m13956ZfxDd(Context context, BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        if (AbstractC4626td.m13644mjFkc()) {
            return context.registerReceiver(broadcastReceiver, intentFilter, true != AbstractC4626td.m13644mjFkc() ? 0 : 2);
        }
        return context.registerReceiver(broadcastReceiver, intentFilter);
    }
}
