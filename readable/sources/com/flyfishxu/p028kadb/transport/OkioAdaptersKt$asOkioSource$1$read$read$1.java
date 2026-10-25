package com.flyfishxu.p028kadb.transport;

import com.flyfishxu.p028kadb.transport.OkioAdaptersKt;
import java.nio.ByteBuffer;
import java.util.concurrent.TimeUnit;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
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

@Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/CoroutineScope;"}, m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "com.flyfishxu.kadb.transport.OkioAdaptersKt$asOkioSource$1$read$read$1", m6124f = "OkioAdapters.kt", m6125i = {}, m6126l = {C5125EACTags.PIN_USAGE_POLICY}, m6127m = "invokeSuspend", m6128n = {}, m6129nl = {-1}, m6130s = {}, m6131v = 2)
/* loaded from: classes.dex */
public final class OkioAdaptersKt$asOkioSource$1$read$read$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Integer>, Object> {
    final /* synthetic */ long $readTimeoutMs;
    final /* synthetic */ TransportChannel $this_asOkioSource;

    /* renamed from: label */
    int f2171label;

    /* renamed from: this$0 */
    final /* synthetic */ OkioAdaptersKt.C02011 f2172this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OkioAdaptersKt$asOkioSource$1$read$read$1(TransportChannel transportChannel, OkioAdaptersKt.C02011 c02011, long j, Continuation<? super OkioAdaptersKt$asOkioSource$1$read$read$1> continuation) {
        super(2, continuation);
        this.$this_asOkioSource = transportChannel;
        this.f2172this$0 = c02011;
        this.$readTimeoutMs = j;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        return new OkioAdaptersKt$asOkioSource$1$read$read$1(this.$this_asOkioSource, this.f2172this$0, this.$readTimeoutMs, continuation);
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.f2171label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            TransportChannel transportChannel = this.$this_asOkioSource;
            ByteBuffer byteBuffer = this.f2172this$0.scratch;
            long j = this.$readTimeoutMs;
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.f2171label = 1;
            obj = transportChannel.mo2350read(byteBuffer, j, timeUnit, this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        return obj;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(CoroutineScope coroutineScope, Continuation<? super Integer> continuation) {
        return ((OkioAdaptersKt$asOkioSource$1$read$read$1) mo2166create(coroutineScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
