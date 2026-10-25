package com.flyfishxu.p028kadb.p032mdns.internal;

import android.net.nsd.NsdServiceInfo;
import android.p003net.p004nsd.NsdManager$ServiceInfoCallback;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001BK\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\t¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0004H\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/internal/AndroidServiceInfoCallback;", "Landroid/net/nsd/NsdManager$ServiceInfoCallback;", "onRegistrationFailedAction", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "onServiceUpdatedAction", "Landroid/net/nsd/NsdServiceInfo;", "onServiceLostAction", "Lkotlin/Function0;", "onUnregisteredAction", "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "onServiceInfoCallbackRegistrationFailed", "errorCode", "onServiceUpdated", "serviceInfo", "onServiceLost", "onServiceInfoCallbackUnregistered", "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AndroidServiceInfoCallback implements NsdManager$ServiceInfoCallback {
    private final Function1<Integer, C1133Unit> onRegistrationFailedAction;
    private final Function0<C1133Unit> onServiceLostAction;
    private final Function1<NsdServiceInfo, C1133Unit> onServiceUpdatedAction;
    private final Function0<C1133Unit> onUnregisteredAction;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidServiceInfoCallback(Function1<? super Integer, C1133Unit> onRegistrationFailedAction, Function1<? super NsdServiceInfo, C1133Unit> onServiceUpdatedAction, Function0<C1133Unit> onServiceLostAction, Function0<C1133Unit> onUnregisteredAction) {
        Intrinsics.checkNotNullParameter(onRegistrationFailedAction, "onRegistrationFailedAction");
        Intrinsics.checkNotNullParameter(onServiceUpdatedAction, "onServiceUpdatedAction");
        Intrinsics.checkNotNullParameter(onServiceLostAction, "onServiceLostAction");
        Intrinsics.checkNotNullParameter(onUnregisteredAction, "onUnregisteredAction");
        this.onRegistrationFailedAction = onRegistrationFailedAction;
        this.onServiceUpdatedAction = onServiceUpdatedAction;
        this.onServiceLostAction = onServiceLostAction;
        this.onUnregisteredAction = onUnregisteredAction;
    }

    public void onServiceInfoCallbackRegistrationFailed(int errorCode) {
        this.onRegistrationFailedAction.mo2237invoke(Integer.valueOf(errorCode));
    }

    public void onServiceInfoCallbackUnregistered() {
        this.onUnregisteredAction.mo4323invoke();
    }

    public void onServiceLost() {
        this.onServiceLostAction.mo4323invoke();
    }

    public void onServiceUpdated(NsdServiceInfo serviceInfo) {
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
        this.onServiceUpdatedAction.mo2237invoke(serviceInfo);
    }
}
