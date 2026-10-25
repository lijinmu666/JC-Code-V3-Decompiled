package com.flyfishxu.p028kadb.p032mdns;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0086\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0015\u001a\u00020\bHÆ\u0003J1\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0014\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001a\u001a\u00020\u0006HÖ\u0081\u0004J\n\u0010\u001b\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u001c"}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/MdnsEndpoint;", BuildConfig.f24315FLAVOR, "name", BuildConfig.f24315FLAVOR, "host", "port", BuildConfig.f24315FLAVOR, "serviceType", "Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", "<init>", "(Ljava/lang/String;Ljava/lang/String;ILcom/flyfishxu/kadb/mdns/MdnsServiceType;)V", "getName", "()Ljava/lang/String;", "getHost", "getPort", "()I", "getServiceType", "()Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", "component1", "component2", "component3", "component4", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", "toString", "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MdnsEndpoint {
    private final String host;
    private final String name;
    private final int port;
    private final MdnsServiceType serviceType;

    public MdnsEndpoint(String name, String host, int i, MdnsServiceType serviceType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        this.name = name;
        this.host = host;
        this.port = i;
        this.serviceType = serviceType;
    }

    public static /* synthetic */ MdnsEndpoint copy$default(MdnsEndpoint mdnsEndpoint, String str, String str2, int i, MdnsServiceType mdnsServiceType, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = mdnsEndpoint.name;
        }
        if ((i2 & 2) != 0) {
            str2 = mdnsEndpoint.host;
        }
        if ((i2 & 4) != 0) {
            i = mdnsEndpoint.port;
        }
        if ((i2 & 8) != 0) {
            mdnsServiceType = mdnsEndpoint.serviceType;
        }
        return mdnsEndpoint.m2242copy(str, str2, i, mdnsServiceType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final String getHost() {
        return this.host;
    }

    /* renamed from: component3, reason: from getter */
    public final int getPort() {
        return this.port;
    }

    /* renamed from: component4, reason: from getter */
    public final MdnsServiceType getServiceType() {
        return this.serviceType;
    }

    /* renamed from: copy */
    public final MdnsEndpoint m2242copy(String name, String host, int port, MdnsServiceType serviceType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        return new MdnsEndpoint(name, host, port, serviceType);
    }

    /* renamed from: equals */
    public boolean m2243equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MdnsEndpoint)) {
            return false;
        }
        MdnsEndpoint mdnsEndpoint = (MdnsEndpoint) other;
        return Intrinsics.areEqual(this.name, mdnsEndpoint.name) && Intrinsics.areEqual(this.host, mdnsEndpoint.host) && this.port == mdnsEndpoint.port && this.serviceType == mdnsEndpoint.serviceType;
    }

    /* renamed from: getHost */
    public final String m2244getHost() {
        return this.host;
    }

    /* renamed from: getName */
    public final String m2245getName() {
        return this.name;
    }

    /* renamed from: getPort */
    public final int m2246getPort() {
        return this.port;
    }

    public final MdnsServiceType getServiceType() {
        return this.serviceType;
    }

    public int hashCode() {
        return (((((this.name.hashCode() * 31) + this.host.hashCode()) * 31) + Integer.hashCode(this.port)) * 31) + this.serviceType.hashCode();
    }

    public String toString() {
        return "MdnsEndpoint(name=" + this.name + ", host=" + this.host + ", port=" + this.port + ", serviceType=" + this.serviceType + ")";
    }
}
