package com.indidevs.p086android.p087adbeesh.internal.discovery;

import com.flyfishxu.p028kadb.p032mdns.MdnsEndpoint;
import java.util.Iterator;
import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.C1159SetsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.C1235Ref;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.channels.ProducerScope;

@Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "currentSet", BuildConfig.f24315FLAVOR, "Lcom/flyfishxu/kadb/mdns/MdnsEndpoint;"}, m4989k = 3, m4990mv = {2, 1, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "com.indidevs.android.adbeesh.internal.discovery.Scanner$discover$1$job$2", m6124f = "Scanner.kt", m6125i = {}, m6126l = {}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nScanner.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Scanner.kt\ncom/indidevs/android/adbeesh/internal/discovery/Scanner$discover$1$job$2\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,114:1\n2068#2,2:115\n*S KotlinDebug\n*F\n+ 1 Scanner.kt\ncom/indidevs/android/adbeesh/internal/discovery/Scanner$discover$1$job$2\n*L\n80#1:115,2\n*E\n"})
/* loaded from: classes.dex */
public final class Scanner$discover$1$job$2 extends SuspendLambda implements Function2<Set<? extends MdnsEndpoint>, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ ProducerScope<DiscoveredService> $$this$callbackFlow;
    final /* synthetic */ C1235Ref.ObjectRef<Set<MdnsEndpoint>> $lastEmitted;

    /* renamed from: $type */
    final /* synthetic */ ServiceType f4141$type;

    /* renamed from: L$0 */
    /* synthetic */ Object f4142L$0;

    /* renamed from: label */
    int f4143label;

    /* renamed from: this$0 */
    final /* synthetic */ C0896Scanner f4144this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public Scanner$discover$1$job$2(C1235Ref.ObjectRef<Set<MdnsEndpoint>> objectRef, ProducerScope<? super DiscoveredService> producerScope, C0896Scanner c0896Scanner, ServiceType serviceType, Continuation<? super Scanner$discover$1$job$2> continuation) {
        super(2, continuation);
        this.$lastEmitted = objectRef;
        this.$$this$callbackFlow = producerScope;
        this.f4144this$0 = c0896Scanner;
        this.f4141$type = serviceType;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        Scanner$discover$1$job$2 scanner$discover$1$job$2 = new Scanner$discover$1$job$2(this.$lastEmitted, this.$$this$callbackFlow, this.f4144this$0, this.f4141$type, continuation);
        scanner$discover$1$job$2.f4142L$0 = obj;
        return scanner$discover$1$job$2;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ Object mo2167invoke(Set<? extends MdnsEndpoint> set, Continuation<? super C1133Unit> continuation) {
        return invoke2((Set<MdnsEndpoint>) set, continuation);
    }

    /* JADX WARN: Type inference failed for: r4v3, types: [T, java.util.Set] */
    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f4143label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        ?? r4 = (Set) this.f4142L$0;
        Set setMinus = C1159SetsKt.m5996minus((Set) r4, (Iterable) this.$lastEmitted.f5202element);
        this.$lastEmitted.f5202element = r4;
        ProducerScope<DiscoveredService> producerScope = this.$$this$callbackFlow;
        C0896Scanner c0896Scanner = this.f4144this$0;
        ServiceType serviceType = this.f4141$type;
        Iterator it = setMinus.iterator();
        while (it.hasNext()) {
            producerScope.mo19989trySendJP2dKIU(c0896Scanner.toDiscoveredService((MdnsEndpoint) it.next(), serviceType));
        }
        return C1133Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(Set<MdnsEndpoint> set, Continuation<? super C1133Unit> continuation) {
        return ((Scanner$discover$1$job$2) mo2166create(set, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
