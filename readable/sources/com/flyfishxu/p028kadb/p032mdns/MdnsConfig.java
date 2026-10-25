package com.flyfishxu.p028kadb.p032mdns;

import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B!\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0006HÆ\u0003J#\u0010\u000f\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006HÆ\u0001J\u0014\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0015HÖ\u0081\u0004R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/MdnsConfig;", BuildConfig.f24315FLAVOR, "serviceTypes", BuildConfig.f24315FLAVOR, "Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", "preferIpv4", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/util/Set;Z)V", "getServiceTypes", "()Ljava/util/Set;", "getPreferIpv4", "()Z", "component1", "component2", "copy", "equals", "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MdnsConfig {
    private final boolean preferIpv4;
    private final Set<MdnsServiceType> serviceTypes;

    /* JADX WARN: Multi-variable type inference failed */
    public MdnsConfig() {
        this(null, false, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ MdnsConfig copy$default(MdnsConfig mdnsConfig, Set set, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            set = mdnsConfig.serviceTypes;
        }
        if ((i & 2) != 0) {
            z = mdnsConfig.preferIpv4;
        }
        return mdnsConfig.m2238copy(set, z);
    }

    public final Set<MdnsServiceType> component1() {
        return this.serviceTypes;
    }

    /* renamed from: component2, reason: from getter */
    public final boolean getPreferIpv4() {
        return this.preferIpv4;
    }

    /* renamed from: copy */
    public final MdnsConfig m2238copy(Set<? extends MdnsServiceType> serviceTypes, boolean preferIpv4) {
        Intrinsics.checkNotNullParameter(serviceTypes, "serviceTypes");
        return new MdnsConfig(serviceTypes, preferIpv4);
    }

    /* renamed from: equals */
    public boolean m2239equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MdnsConfig)) {
            return false;
        }
        MdnsConfig mdnsConfig = (MdnsConfig) other;
        return Intrinsics.areEqual(this.serviceTypes, mdnsConfig.serviceTypes) && this.preferIpv4 == mdnsConfig.preferIpv4;
    }

    public final boolean getPreferIpv4() {
        return this.preferIpv4;
    }

    public final Set<MdnsServiceType> getServiceTypes() {
        return this.serviceTypes;
    }

    public int hashCode() {
        return (this.serviceTypes.hashCode() * 31) + Boolean.hashCode(this.preferIpv4);
    }

    public String toString() {
        return "MdnsConfig(serviceTypes=" + this.serviceTypes + ", preferIpv4=" + this.preferIpv4 + ")";
    }

    /* JADX WARN: Multi-variable type inference failed */
    public MdnsConfig(Set<? extends MdnsServiceType> serviceTypes, boolean z) {
        Intrinsics.checkNotNullParameter(serviceTypes, "serviceTypes");
        this.serviceTypes = serviceTypes;
        this.preferIpv4 = z;
    }

    public /* synthetic */ MdnsConfig(Set set, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? CollectionsKt.m5900toSet(MdnsServiceType.getEntries()) : set, (i & 2) != 0 ? true : z);
    }
}
