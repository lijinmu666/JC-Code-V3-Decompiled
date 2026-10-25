package com.flyfishxu.p028kadb.p032mdns;

import android.net.nsd.NsdServiceInfo;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.FunctionReferenceImpl;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class KadbMdnsAndroid$discoveryListeners$1$2 extends FunctionReferenceImpl implements Function2<NsdServiceInfo, MdnsServiceType, C1133Unit> {
    public KadbMdnsAndroid$discoveryListeners$1$2(Object obj) {
        super(2, obj, KadbMdnsAndroid.class, "onServiceFound", "onServiceFound(Landroid/net/nsd/NsdServiceInfo;Lcom/flyfishxu/kadb/mdns/MdnsServiceType;)V", 0);
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ C1133Unit mo2167invoke(NsdServiceInfo nsdServiceInfo, MdnsServiceType mdnsServiceType) {
        invoke2(nsdServiceInfo, mdnsServiceType);
        return C1133Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(NsdServiceInfo p0, MdnsServiceType p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        ((KadbMdnsAndroid) this.receiver).onServiceFound(p0, p1);
    }
}
