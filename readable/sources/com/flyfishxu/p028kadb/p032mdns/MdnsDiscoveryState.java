package com.flyfishxu.p028kadb.p032mdns;

import java.util.Collection;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0014\u0010\u001a\u001a\u00020\u00052\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\b0\u00078F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0011¨\u0006 "}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/MdnsDiscoveryState;", BuildConfig.f24315FLAVOR, "status", "Lcom/flyfishxu/kadb/mdns/MdnsStatus;", "loading", BuildConfig.f24315FLAVOR, "connectDevices", BuildConfig.f24315FLAVOR, "Lcom/flyfishxu/kadb/mdns/MdnsEndpoint;", "pairDevices", "<init>", "(Lcom/flyfishxu/kadb/mdns/MdnsStatus;ZLjava/util/List;Ljava/util/List;)V", "getStatus", "()Lcom/flyfishxu/kadb/mdns/MdnsStatus;", "getLoading", "()Z", "getConnectDevices", "()Ljava/util/List;", "getPairDevices", "allDevices", "getAllDevices", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MdnsDiscoveryState {
    private final List<MdnsEndpoint> connectDevices;
    private final boolean loading;
    private final List<MdnsEndpoint> pairDevices;
    private final MdnsStatus status;

    public MdnsDiscoveryState() {
        this(null, false, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MdnsDiscoveryState copy$default(MdnsDiscoveryState mdnsDiscoveryState, MdnsStatus mdnsStatus, boolean z, List list, List list2, int i, Object obj) {
        if ((i & 1) != 0) {
            mdnsStatus = mdnsDiscoveryState.status;
        }
        if ((i & 2) != 0) {
            z = mdnsDiscoveryState.loading;
        }
        if ((i & 4) != 0) {
            list = mdnsDiscoveryState.connectDevices;
        }
        if ((i & 8) != 0) {
            list2 = mdnsDiscoveryState.pairDevices;
        }
        return mdnsDiscoveryState.m2240copy(mdnsStatus, z, list, list2);
    }

    /* renamed from: component1, reason: from getter */
    public final MdnsStatus getStatus() {
        return this.status;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getLoading() {
        return this.loading;
    }

    public final List<MdnsEndpoint> component3() {
        return this.connectDevices;
    }

    public final List<MdnsEndpoint> component4() {
        return this.pairDevices;
    }

    /* renamed from: copy */
    public final MdnsDiscoveryState m2240copy(MdnsStatus status, boolean loading, List<MdnsEndpoint> connectDevices, List<MdnsEndpoint> pairDevices) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(connectDevices, "connectDevices");
        Intrinsics.checkNotNullParameter(pairDevices, "pairDevices");
        return new MdnsDiscoveryState(status, loading, connectDevices, pairDevices);
    }

    /* renamed from: equals */
    public boolean m2241equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MdnsDiscoveryState)) {
            return false;
        }
        MdnsDiscoveryState mdnsDiscoveryState = (MdnsDiscoveryState) other;
        return this.status == mdnsDiscoveryState.status && this.loading == mdnsDiscoveryState.loading && Intrinsics.areEqual(this.connectDevices, mdnsDiscoveryState.connectDevices) && Intrinsics.areEqual(this.pairDevices, mdnsDiscoveryState.pairDevices);
    }

    public final List<MdnsEndpoint> getAllDevices() {
        return CollectionsKt.m5881plus((Collection) this.connectDevices, (Iterable) this.pairDevices);
    }

    public final List<MdnsEndpoint> getConnectDevices() {
        return this.connectDevices;
    }

    public final boolean getLoading() {
        return this.loading;
    }

    public final List<MdnsEndpoint> getPairDevices() {
        return this.pairDevices;
    }

    public final MdnsStatus getStatus() {
        return this.status;
    }

    public int hashCode() {
        return (((((this.status.hashCode() * 31) + Boolean.hashCode(this.loading)) * 31) + this.connectDevices.hashCode()) * 31) + this.pairDevices.hashCode();
    }

    public String toString() {
        return "MdnsDiscoveryState(status=" + this.status + ", loading=" + this.loading + ", connectDevices=" + this.connectDevices + ", pairDevices=" + this.pairDevices + ")";
    }

    public MdnsDiscoveryState(MdnsStatus status, boolean z, List<MdnsEndpoint> connectDevices, List<MdnsEndpoint> pairDevices) {
        Intrinsics.checkNotNullParameter(status, "status");
        Intrinsics.checkNotNullParameter(connectDevices, "connectDevices");
        Intrinsics.checkNotNullParameter(pairDevices, "pairDevices");
        this.status = status;
        this.loading = z;
        this.connectDevices = connectDevices;
        this.pairDevices = pairDevices;
    }

    public /* synthetic */ MdnsDiscoveryState(MdnsStatus mdnsStatus, boolean z, List list, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? MdnsStatus.f2083STOPPED : mdnsStatus, (i & 2) != 0 ? false : z, (i & 4) != 0 ? CollectionsKt.emptyList() : list, (i & 8) != 0 ? CollectionsKt.emptyList() : list2);
    }
}
