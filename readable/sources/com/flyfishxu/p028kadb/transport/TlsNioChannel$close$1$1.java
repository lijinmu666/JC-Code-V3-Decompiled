package com.flyfishxu.p028kadb.transport;

import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p122kotlinx.coroutines.CoroutineScope;

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "com.flyfishxu.kadb.transport.TlsNioChannel$close$1$1", m6124f = "TlsNioChannel.kt", m6125i = {}, m6126l = {218}, m6127m = "invokeSuspend", m6128n = {}, m6129nl = {-1}, m6130s = {}, m6131v = 2)
/* loaded from: classes.dex */
public final class TlsNioChannel$close$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super C1133Unit>, Object> {
    final /* synthetic */ TlsNioChannel $this_runCatching;

    /* renamed from: label */
    int f2192label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TlsNioChannel$close$1$1(TlsNioChannel tlsNioChannel, Continuation<? super TlsNioChannel$close$1$1> continuation) {
        super(2, continuation);
        this.$this_runCatching = tlsNioChannel;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        return new TlsNioChannel$close$1$1(this.$this_runCatching, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2192label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TransportChannel transportChannel = this.$this_runCatching.net;
            ByteBuffer byteBuffer = this.$this_runCatching.netOut;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f2192label = 1;
            if (transportChannel.writeExactly(byteBuffer, 1000L, timeUnit, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return C1133Unit.INSTANCE;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super C1133Unit> continuation) {
        return ((TlsNioChannel$close$1$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
