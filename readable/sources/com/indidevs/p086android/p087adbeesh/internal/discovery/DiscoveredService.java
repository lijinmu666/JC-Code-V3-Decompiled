package com.indidevs.p086android.p087adbeesh.internal.discovery;

import java.net.InetAddress;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0080\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0017\u001a\u00020\tHÆ\u0003J3\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u0007HÖ\u0081\u0004J\n\u0010\u001d\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u001e"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/discovery/DiscoveredService;", BuildConfig.f24315FLAVOR, "name", BuildConfig.f24315FLAVOR, "host", "Ljava/net/InetAddress;", "port", BuildConfig.f24315FLAVOR, "type", "Lcom/indidevs/android/adbeesh/internal/discovery/ServiceType;", "<init>", "(Ljava/lang/String;Ljava/net/InetAddress;ILcom/indidevs/android/adbeesh/internal/discovery/ServiceType;)V", "getName", "()Ljava/lang/String;", "getHost", "()Ljava/net/InetAddress;", "getPort", "()I", "getType", "()Lcom/indidevs/android/adbeesh/internal/discovery/ServiceType;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", "toString", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class DiscoveredService {
    private final InetAddress host;
    private final String name;
    private final int port;
    private final ServiceType type;

    public DiscoveredService(String name, InetAddress inetAddress, int i, ServiceType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        this.name = name;
        this.host = inetAddress;
        this.port = i;
        this.type = type;
    }

    public static /* synthetic */ DiscoveredService copy$default(DiscoveredService discoveredService, String str, InetAddress inetAddress, int i, ServiceType serviceType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = discoveredService.name;
        }
        if ((i2 & 2) != 0) {
            inetAddress = discoveredService.host;
        }
        if ((i2 & 4) != 0) {
            i = discoveredService.port;
        }
        if ((i2 & 8) != 0) {
            serviceType = discoveredService.type;
        }
        return discoveredService.m4317copy(str, inetAddress, i, serviceType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final InetAddress getHost() {
        return this.host;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* renamed from: component4, reason: from getter */
    public final ServiceType getType() {
        return this.type;
    }

    /* renamed from: copy */
    public final DiscoveredService m4317copy(String name, InetAddress host, int port, ServiceType type) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(type, "type");
        return new DiscoveredService(name, host, port, type);
    }

    /* renamed from: equals */
    public boolean m4318equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof DiscoveredService)) {
            return false;
        }
        DiscoveredService discoveredService = (DiscoveredService) other;
        return Intrinsics.areEqual(this.name, discoveredService.name) && Intrinsics.areEqual(this.host, discoveredService.host) && this.port == discoveredService.port && this.type == discoveredService.type;
    }

    /* renamed from: getHost */
    public final InetAddress m4319getHost() {
        return this.host;
    }

    /* renamed from: getName */
    public final String m4320getName() {
        return this.name;
    }

    /* renamed from: getPort */
    public final int m4321getPort() {
        return this.port;
    }

    /* renamed from: getType */
    public final ServiceType m4322getType() {
        return this.type;
    }

    public int hashCode() {
        int iHashCode = this.name.hashCode() * 31;
        InetAddress inetAddress = this.host;
        return ((((iHashCode + (inetAddress == null ? 0 : inetAddress.hashCode())) * 31) + Integer.hashCode(this.port)) * 31) + this.type.hashCode();
    }

    public String toString() {
        return "DiscoveredService(name=" + this.name + ", host=" + this.host + ", port=" + this.port + ", type=" + this.type + ')';
    }
}
