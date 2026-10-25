package com.flyfishxu.p028kadb.p032mdns.internal;

import android.net.nsd.NsdServiceInfo;
import android.os.Build;
import com.flyfishxu.p028kadb.p032mdns.MdnsConfig;
import com.flyfishxu.p028kadb.p032mdns.MdnsEndpoint;
import com.flyfishxu.p028kadb.p032mdns.MdnsServiceType;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.util.Iterator;
import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;

@Metadata(m4987d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\u001e\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0016\u0010\u0007\u001a\u0004\u0018\u00010\b*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0016\u0010\t\u001a\u0004\u0018\u00010\n*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\fH\u0002\u001a \u0010\r\u001a\u0004\u0018\u00010\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\u0011"}, m4988d2 = {"toMdnsEndpoint", "Lcom/flyfishxu/kadb/mdns/MdnsEndpoint;", "Landroid/net/nsd/NsdServiceInfo;", "config", "Lcom/flyfishxu/kadb/mdns/MdnsConfig;", "fallbackServiceType", "Lcom/flyfishxu/kadb/mdns/MdnsServiceType;", "toMdnsServiceKey", "Lcom/flyfishxu/kadb/mdns/internal/MdnsServiceKey;", "resolveHostAddress", BuildConfig.f24315FLAVOR, "preferIpv4", BuildConfig.f24315FLAVOR, "selectAddress", "Ljava/net/InetAddress;", "addresses", BuildConfig.f24315FLAVOR, "com.github.IndiTheo:kadb-mdns"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nNsdServiceInfoMapper.kt\nKotlin\n*S Kotlin\n*F\n+ 1 NsdServiceInfoMapper.kt\ncom/flyfishxu/kadb/mdns/internal/NsdServiceInfoMapperKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,51:1\n1#2:52\n296#3,2:53\n*S KotlinDebug\n*F\n+ 1 NsdServiceInfoMapper.kt\ncom/flyfishxu/kadb/mdns/internal/NsdServiceInfoMapperKt\n*L\n47#1:53,2\n*E\n"})
/* loaded from: classes.dex */
public final class NsdServiceInfoMapperKt {
    private static final String resolveHostAddress(NsdServiceInfo nsdServiceInfo, boolean z) {
        InetAddress host;
        String hostAddress;
        if (Build.VERSION.SDK_INT >= 34) {
            List hostAddresses = nsdServiceInfo.getHostAddresses();
            Intrinsics.checkNotNullExpressionValue(hostAddresses, "getHostAddresses(...)");
            host = selectAddress(hostAddresses, z);
        } else {
            host = nsdServiceInfo.getHost();
        }
        if (host == null || (hostAddress = host.getHostAddress()) == null || StringsKt.m6766isBlank(hostAddress)) {
            return null;
        }
        return hostAddress;
    }

    private static final InetAddress selectAddress(List<? extends InetAddress> list, boolean z) {
        Object next;
        if (!z) {
            return (InetAddress) CollectionsKt.firstOrNull((List) list);
        }
        Iterator<T> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (((InetAddress) next) instanceof Inet4Address) {
                break;
            }
        }
        InetAddress inetAddress = (InetAddress) next;
        return inetAddress == null ? (InetAddress) CollectionsKt.firstOrNull((List) list) : inetAddress;
    }

    public static final MdnsEndpoint toMdnsEndpoint(NsdServiceInfo nsdServiceInfo, MdnsConfig config, MdnsServiceType fallbackServiceType) {
        String strResolveHostAddress;
        Intrinsics.checkNotNullParameter(nsdServiceInfo, "<this>");
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(fallbackServiceType, "fallbackServiceType");
        MdnsServiceKey mdnsServiceKey = toMdnsServiceKey(nsdServiceInfo, fallbackServiceType);
        if (mdnsServiceKey == null || (strResolveHostAddress = resolveHostAddress(nsdServiceInfo, config.getPreferIpv4())) == null) {
            return null;
        }
        Integer numValueOf = Integer.valueOf(nsdServiceInfo.getPort());
        int iIntValue = numValueOf.intValue();
        if (1 > iIntValue || iIntValue >= 65536) {
            numValueOf = null;
        }
        if (numValueOf != null) {
            return new MdnsEndpoint(mdnsServiceKey.m2262getName(), strResolveHostAddress, numValueOf.intValue(), mdnsServiceKey.getServiceType());
        }
        return null;
    }

    public static final MdnsServiceKey toMdnsServiceKey(NsdServiceInfo nsdServiceInfo, MdnsServiceType fallbackServiceType) {
        Intrinsics.checkNotNullParameter(nsdServiceInfo, "<this>");
        Intrinsics.checkNotNullParameter(fallbackServiceType, "fallbackServiceType");
        String serviceName = nsdServiceInfo.getServiceName();
        String string = serviceName != null ? StringsKt.m6778trim((CharSequence) serviceName).toString() : null;
        if (string == null) {
            string = BuildConfig.f24315FLAVOR;
        }
        if (StringsKt.m6766isBlank(string)) {
            return null;
        }
        MdnsServiceType mdnsServiceType = MdnsServiceTypeParserKt.parseMdnsServiceType(nsdServiceInfo.getServiceType());
        if (mdnsServiceType != null) {
            fallbackServiceType = mdnsServiceType;
        }
        return new MdnsServiceKey(string, fallbackServiceType);
    }
}
