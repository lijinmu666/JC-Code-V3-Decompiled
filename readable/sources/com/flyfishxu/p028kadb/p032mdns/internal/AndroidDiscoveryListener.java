package com.flyfishxu.p028kadb.p032mdns.internal;

import android.net.nsd.NsdManager;
import android.net.nsd.NsdServiceInfo;
import com.flyfishxu.p028kadb.p032mdns.MdnsServiceType;
import com.flyfishxu.p028kadb.p032mdns.MdnsStatus;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001BW\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005\u0012\u0018\u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\t\u0012\u0018\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\t¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000fH\u0016J\u0018\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000fH\u0016J\u0018\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0010\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/internal/AndroidDiscoveryListener;", "Landroid/net/nsd/NsdManager$DiscoveryListener;", "serviceType", "Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", "onStatusChangedAction", "Lkotlin/Function1;", "Lcom/flyfishxu/kadb/mdns/MdnsStatus;", BuildConfig.f24315FLAVOR, "onServiceFoundAction", "Lkotlin/Function2;", "Landroid/net/nsd/NsdServiceInfo;", "onServiceLostAction", "<init>", "(Lcom/flyfishxu/kadb/mdns/MdnsServiceType;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "onDiscoveryStarted", BuildConfig.f24315FLAVOR, "onStartDiscoveryFailed", "errorCode", BuildConfig.f24315FLAVOR, "onDiscoveryStopped", "onStopDiscoveryFailed", "onServiceFound", "serviceInfo", "onServiceLost", "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AndroidDiscoveryListener implements NsdManager.DiscoveryListener {
    private final Function2<NsdServiceInfo, MdnsServiceType, C1133Unit> onServiceFoundAction;
    private final Function2<NsdServiceInfo, MdnsServiceType, C1133Unit> onServiceLostAction;
    private final Function1<MdnsStatus, C1133Unit> onStatusChangedAction;
    private final MdnsServiceType serviceType;

    /* JADX WARN: Multi-variable type inference failed */
    public AndroidDiscoveryListener(MdnsServiceType serviceType, Function1<? super MdnsStatus, C1133Unit> onStatusChangedAction, Function2<? super NsdServiceInfo, ? super MdnsServiceType, C1133Unit> onServiceFoundAction, Function2<? super NsdServiceInfo, ? super MdnsServiceType, C1133Unit> onServiceLostAction) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        Intrinsics.checkNotNullParameter(onStatusChangedAction, "onStatusChangedAction");
        Intrinsics.checkNotNullParameter(onServiceFoundAction, "onServiceFoundAction");
        Intrinsics.checkNotNullParameter(onServiceLostAction, "onServiceLostAction");
        this.serviceType = serviceType;
        this.onStatusChangedAction = onStatusChangedAction;
        this.onServiceFoundAction = onServiceFoundAction;
        this.onServiceLostAction = onServiceLostAction;
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onDiscoveryStarted(String serviceType) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        this.onStatusChangedAction.mo2237invoke(MdnsStatus.f2082STARTED);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onDiscoveryStopped(String serviceType) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        this.onStatusChangedAction.mo2237invoke(MdnsStatus.f2083STOPPED);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onServiceFound(NsdServiceInfo serviceInfo) {
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
        MdnsServiceType mdnsServiceType = MdnsServiceTypeParserKt.parseMdnsServiceType(serviceInfo.getServiceType());
        MdnsServiceType mdnsServiceType2 = this.serviceType;
        if (mdnsServiceType != mdnsServiceType2) {
            return;
        }
        this.onServiceFoundAction.mo2167invoke(serviceInfo, mdnsServiceType2);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onServiceLost(NsdServiceInfo serviceInfo) {
        Intrinsics.checkNotNullParameter(serviceInfo, "serviceInfo");
        MdnsServiceType mdnsServiceType = MdnsServiceTypeParserKt.parseMdnsServiceType(serviceInfo.getServiceType());
        if (mdnsServiceType == null || mdnsServiceType == this.serviceType) {
            this.onServiceLostAction.mo2167invoke(serviceInfo, this.serviceType);
        }
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onStartDiscoveryFailed(String serviceType, int errorCode) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        this.onStatusChangedAction.mo2237invoke(MdnsStatus.f2081FAILED);
    }

    @Override // android.net.nsd.NsdManager.DiscoveryListener
    public void onStopDiscoveryFailed(String serviceType, int errorCode) {
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        this.onStatusChangedAction.mo2237invoke(MdnsStatus.f2081FAILED);
    }
}
