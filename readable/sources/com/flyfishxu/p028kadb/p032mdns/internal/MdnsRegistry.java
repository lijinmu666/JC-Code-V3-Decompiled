package com.flyfishxu.p028kadb.p032mdns.internal;

import com.flyfishxu.p028kadb.p032mdns.MdnsConfig;
import com.flyfishxu.p028kadb.p032mdns.MdnsDiscoveryState;
import com.flyfishxu.p028kadb.p032mdns.MdnsEndpoint;
import com.flyfishxu.p028kadb.p032mdns.MdnsServiceType;
import com.flyfishxu.p028kadb.p032mdns.MdnsStatus;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.comparisons.ComparisonsKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.PropertyReference1Impl;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p122kotlinx.coroutines.p125flow.MutableStateFlow;
import p122kotlinx.coroutines.p125flow.StateFlow;
import p122kotlinx.coroutines.p125flow.StateFlowKt;

@Metadata(m4987d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J\u0006\u0010\u0016\u001a\u00020\u0013J\u000e\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\tJ\u0016\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u001fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007j\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t`\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\""}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/internal/MdnsRegistry;", BuildConfig.f24315FLAVOR, "config", "Lcom/flyfishxu/kadb/mdns/MdnsConfig;", "<init>", "(Lcom/flyfishxu/kadb/mdns/MdnsConfig;)V", "endpoints", "Ljava/util/LinkedHashMap;", "Lcom/flyfishxu/kadb/mdns/internal/MdnsServiceKey;", "Lcom/flyfishxu/kadb/mdns/MdnsEndpoint;", "Lkotlin/collections/LinkedHashMap;", "mutableState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/flyfishxu/kadb/mdns/MdnsDiscoveryState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "starting", BuildConfig.f24315FLAVOR, "started", "failed", "stopped", "upsert", "endpoint", "remove", "name", BuildConfig.f24315FLAVOR, "serviceType", "Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", "currentActiveStatus", "Lcom/flyfishxu/kadb/mdns/MdnsStatus;", "emit", "status", "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nMdnsRegistry.kt\nKotlin\n*S Kotlin\n*F\n+ 1 MdnsRegistry.kt\ncom/flyfishxu/kadb/mdns/internal/MdnsRegistry\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,71:1\n777#2:72\n873#2,2:73\n777#2:75\n873#2,2:76\n*S KotlinDebug\n*F\n+ 1 MdnsRegistry.kt\ncom/flyfishxu/kadb/mdns/internal/MdnsRegistry\n*L\n59#1:72\n59#1:73,2\n62#1:75\n62#1:76,2\n*E\n"})
/* loaded from: classes.dex */
public final class MdnsRegistry {
    private final MdnsConfig config;
    private final LinkedHashMap<MdnsServiceKey, MdnsEndpoint> endpoints;
    private final MutableStateFlow<MdnsDiscoveryState> mutableState;
    private final StateFlow<MdnsDiscoveryState> state;

    public MdnsRegistry(MdnsConfig config) {
        Intrinsics.checkNotNullParameter(config, "config");
        this.config = config;
        this.endpoints = new LinkedHashMap<>();
        MutableStateFlow<MdnsDiscoveryState> MutableStateFlow = StateFlowKt.MutableStateFlow(new MdnsDiscoveryState(null, false, null, null, 15, null));
        this.mutableState = MutableStateFlow;
        this.state = MutableStateFlow;
    }

    private final MdnsStatus currentActiveStatus() {
        MdnsStatus status = this.mutableState.getValue().getStatus();
        MdnsStatus mdnsStatus = MdnsStatus.f2083STOPPED;
        return status == mdnsStatus ? mdnsStatus : MdnsStatus.f2082STARTED;
    }

    /* renamed from: emit */
    private final void m2253emit(MdnsStatus status) {
        Collection<MdnsEndpoint> collectionValues = this.endpoints.values();
        Intrinsics.checkNotNullExpressionValue(collectionValues, "<get-values>(...)");
        boolean z = false;
        List listSortedWith = CollectionsKt.sortedWith(collectionValues, ComparisonsKt.compareBy(new PropertyReference1Impl() { // from class: com.flyfishxu.kadb.mdns.internal.MdnsRegistry$emit$values$1
            @Override // p094kotlin.p105jvm.internal.PropertyReference1Impl, p094kotlin.p113reflect.KProperty1
            /* renamed from: get */
            public Object mo2259get(Object obj) {
                return ((MdnsEndpoint) obj).m2245getName();
            }
        }, new PropertyReference1Impl() { // from class: com.flyfishxu.kadb.mdns.internal.MdnsRegistry$emit$values$2
            @Override // p094kotlin.p105jvm.internal.PropertyReference1Impl, p094kotlin.p113reflect.KProperty1
            /* renamed from: get */
            public Object mo2259get(Object obj) {
                return ((MdnsEndpoint) obj).m2244getHost();
            }
        }, new PropertyReference1Impl() { // from class: com.flyfishxu.kadb.mdns.internal.MdnsRegistry$emit$values$3
            @Override // p094kotlin.p105jvm.internal.PropertyReference1Impl, p094kotlin.p113reflect.KProperty1
            /* renamed from: get */
            public Object mo2259get(Object obj) {
                return Integer.valueOf(((MdnsEndpoint) obj).m2246getPort());
            }
        }));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listSortedWith) {
            MdnsEndpoint mdnsEndpoint = (MdnsEndpoint) obj;
            if (mdnsEndpoint.getServiceType() == MdnsServiceType.f2078ADB || mdnsEndpoint.getServiceType() == MdnsServiceType.TLS_CONNECT) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : listSortedWith) {
            if (((MdnsEndpoint) obj2).getServiceType() == MdnsServiceType.TLS_PAIRING) {
                arrayList2.add(obj2);
            }
        }
        MutableStateFlow<MdnsDiscoveryState> mutableStateFlow = this.mutableState;
        if (status != MdnsStatus.f2083STOPPED && status != MdnsStatus.f2081FAILED && listSortedWith.isEmpty()) {
            z = true;
        }
        mutableStateFlow.setValue(new MdnsDiscoveryState(status, z, arrayList, arrayList2));
    }

    /* renamed from: failed */
    public final void m2254failed() {
        MutableStateFlow<MdnsDiscoveryState> mutableStateFlow = this.mutableState;
        mutableStateFlow.setValue(MdnsDiscoveryState.copy$default(mutableStateFlow.getValue(), MdnsStatus.f2081FAILED, false, null, null, 12, null));
    }

    public final StateFlow<MdnsDiscoveryState> getState() {
        return this.state;
    }

    /* renamed from: remove */
    public final void m2255remove(String name, MdnsServiceType serviceType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        this.endpoints.remove(new MdnsServiceKey(name, serviceType));
        m2253emit(currentActiveStatus());
    }

    /* renamed from: started */
    public final void m2256started() {
        m2253emit(MdnsStatus.f2082STARTED);
    }

    public final void starting() {
        this.endpoints.clear();
        this.mutableState.setValue(new MdnsDiscoveryState(MdnsStatus.STARTING, true, null, null, 12, null));
    }

    /* renamed from: stopped */
    public final void m2257stopped() {
        this.endpoints.clear();
        this.mutableState.setValue(new MdnsDiscoveryState(MdnsStatus.f2083STOPPED, false, null, null, 12, null));
    }

    /* renamed from: upsert */
    public final void m2258upsert(MdnsEndpoint endpoint) {
        int iM2246getPort;
        Intrinsics.checkNotNullParameter(endpoint, "endpoint");
        if (this.config.getServiceTypes().contains(endpoint.getServiceType()) && !StringsKt.m6766isBlank(endpoint.m2245getName()) && !StringsKt.m6766isBlank(endpoint.m2244getHost()) && 1 <= (iM2246getPort = endpoint.m2246getPort()) && iM2246getPort < 65536) {
            this.endpoints.put(new MdnsServiceKey(endpoint.m2245getName(), endpoint.getServiceType()), endpoint);
            m2253emit(currentActiveStatus());
        }
    }
}
