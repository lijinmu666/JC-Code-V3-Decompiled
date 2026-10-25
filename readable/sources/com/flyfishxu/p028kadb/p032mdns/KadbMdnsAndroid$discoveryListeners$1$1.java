package com.flyfishxu.p028kadb.p032mdns;

import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.FunctionReferenceImpl;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class KadbMdnsAndroid$discoveryListeners$1$1 extends FunctionReferenceImpl implements Function1<MdnsStatus, C1133Unit> {
    public KadbMdnsAndroid$discoveryListeners$1$1(Object obj) {
        super(1, obj, KadbMdnsAndroid.class, "onStatusChanged", "onStatusChanged(Lcom/flyfishxu/kadb/mdns/MdnsStatus;)V", 0);
    }

    @Override // p094kotlin.p105jvm.functions.Function1
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ C1133Unit mo2237invoke(MdnsStatus mdnsStatus) {
        invoke2(mdnsStatus);
        return C1133Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(MdnsStatus p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        ((KadbMdnsAndroid) this.receiver).onStatusChanged(p0);
    }
}
