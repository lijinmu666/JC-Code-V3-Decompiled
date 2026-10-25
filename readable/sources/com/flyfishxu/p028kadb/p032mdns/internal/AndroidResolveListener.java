package com.flyfishxu.p028kadb.p032mdns.internal;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001B/\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0004\b\b\u0010\tJ\u0018\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0016J\u0010\u0010\r\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/internal/AndroidResolveListener;", "Landroid/net/nsd/NsdManager$ResolveListener;", "onServiceResolvedAction", "Lkotlin/Function1;", "Landroid/net/nsd/NsdServiceInfo;", BuildConfig.f24315FLAVOR, "onResolveFailedAction", BuildConfig.f24315FLAVOR, "<init>", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "onResolveFailed", "serviceInfo", "errorCode", "onServiceResolved", "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AndroidResolveListener implements NsdManager.ResolveListener {
    private final Function1<Integer, C1133Unit> onResolveFailedAction;
    private final Function1<NsdServiceInfo, C1133Unit> onServiceResolvedAction;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidResolveListener(Function1<? super NsdServiceInfo, C1133Unit> onServiceResolvedAction, Function1<? super Integer, C1133Unit> onResolveFailedAction) {
        Intrinsics.checkNotNullParameter(onServiceResolvedAction, "onServiceResolvedAction");
        Intrinsics.checkNotNullParameter(onResolveFailedAction, "onResolveFailedAction");
        this.onServiceResolvedAction = onServiceResolvedAction;
        this.onResolveFailedAction = onResolveFailedAction;
    }

    @Override // android.net.nsd.NsdManager.ResolveListener
    public void onResolveFailed(NsdServiceInfo serviceInfo, int errorCode) {
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
        this.onResolveFailedAction.mo2237invoke(Integer.valueOf(errorCode));
    }

    @Override // android.net.nsd.NsdManager.ResolveListener
    public void onServiceResolved(NsdServiceInfo serviceInfo) {
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
        this.onServiceResolvedAction.mo2237invoke(serviceInfo);
    }
}
