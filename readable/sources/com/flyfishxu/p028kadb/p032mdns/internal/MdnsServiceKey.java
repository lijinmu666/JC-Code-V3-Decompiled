package com.flyfishxu.p028kadb.p032mdns.internal;

import com.flyfishxu.p028kadb.p032mdns.MdnsServiceType;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0012\u001a\u00020\u0013HÖ\u0081\u0004J\n\u0010\u0014\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, m4988d2 = {"Lcom/flyfishxu/kadb/mdns/internal/MdnsServiceKey;", BuildConfig.f24315FLAVOR, "name", BuildConfig.f24315FLAVOR, "serviceType", "Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", "<init>", "(Ljava/lang/String;Lcom/flyfishxu/kadb/mdns/MdnsServiceType;)V", "getName", "()Ljava/lang/String;", "getServiceType", "()Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", "component1", "component2", "copy", "equals", BuildConfig.f24315FLAVOR, "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", "com.github.IndiTheo:kadb-mdns"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* data */ class MdnsServiceKey {
    private final String name;
    private final MdnsServiceType serviceType;

    public MdnsServiceKey(String name, MdnsServiceType serviceType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        this.name = name;
        this.serviceType = serviceType;
    }

    public static /* synthetic */ MdnsServiceKey copy$default(MdnsServiceKey mdnsServiceKey, String str, MdnsServiceType mdnsServiceType, int i, Object obj) {
        if ((i & 1) != 0) {
            str = mdnsServiceKey.name;
        }
        if ((i & 2) != 0) {
            mdnsServiceType = mdnsServiceKey.serviceType;
        }
        return mdnsServiceKey.m2260copy(str, mdnsServiceType);
    }

    /* renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    /* renamed from: component2, reason: from getter */
    public final MdnsServiceType getServiceType() {
        return this.serviceType;
    }

    /* renamed from: copy */
    public final MdnsServiceKey m2260copy(String name, MdnsServiceType serviceType) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(serviceType, "serviceType");
        return new MdnsServiceKey(name, serviceType);
    }

    /* renamed from: equals */
    public boolean m2261equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MdnsServiceKey)) {
            return false;
        }
        MdnsServiceKey mdnsServiceKey = (MdnsServiceKey) other;
        return Intrinsics.areEqual(this.name, mdnsServiceKey.name) && this.serviceType == mdnsServiceKey.serviceType;
    }

    /* renamed from: getName */
    public final String m2262getName() {
        return this.name;
    }

    public final MdnsServiceType getServiceType() {
        return this.serviceType;
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.serviceType.hashCode();
    }

    public String toString() {
        return "MdnsServiceKey(name=" + this.name + ", serviceType=" + this.serviceType + ")";
    }
}
