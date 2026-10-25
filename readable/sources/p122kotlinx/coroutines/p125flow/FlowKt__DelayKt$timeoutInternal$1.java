package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.CoroutineScope;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4987d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/CoroutineScope;", "downStream", "Lkotlinx/coroutines/flow/FlowCollector;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1", m6124f = "Delay.kt", m6125i = {0, 0, 0, 0, 0, 0, 0}, m6126l = {413}, m6127m = "invokeSuspend", m6128n = {"$this$scopedFlow", "downStream", "values", "$this$select_u24lambda_u240$iv$iv", "$i$f$whileSelect", "$i$f$select", "$i$a$-run-SelectKt$select$2$iv$iv"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1", "I$2"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nDelay.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n+ 2 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 3 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,407:1\n27#2:408\n28#2:414\n54#3,5:409\n*S KotlinDebug\n*F\n+ 1 Delay.kt\nkotlinx/coroutines/flow/FlowKt__DelayKt$timeoutInternal$1\n*L\n392#1:408\n392#1:414\n392#1:409,5\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__DelayKt$timeoutInternal$1<T> extends SuspendLambda implements Function3<CoroutineScope, FlowCollector<? super T>, Continuation<? super C1133Unit>, Object> {

    /* renamed from: $$v$c$kotlin-time-Duration$-timeout$0, reason: not valid java name */
    final /* synthetic */ long f24527$$v$c$kotlintimeDuration$timeout$0;
    final /* synthetic */ InterfaceC1426Flow<T> $this_timeoutInternal;

    /* renamed from: I$0 */
    int f6406I$0;

    /* renamed from: I$1 */
    int f6407I$1;

    /* renamed from: I$2 */
    int f6408I$2;

    /* renamed from: J$0 */
    long f6409J$0;

    /* renamed from: L$0 */
    private /* synthetic */ Object f6410L$0;

    /* renamed from: L$1 */
    /* synthetic */ Object f6411L$1;

    /* renamed from: L$2 */
    Object f6412L$2;

    /* renamed from: L$3 */
    Object f6413L$3;

    /* renamed from: label */
    int f6414label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public FlowKt__DelayKt$timeoutInternal$1(long j, InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super FlowKt__DelayKt$timeoutInternal$1> continuation) {
        super(3, continuation);
        this.f24527$$v$c$kotlintimeDuration$timeout$0 = j;
        this.$this_timeoutInternal = interfaceC1426Flow;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    /* JADX WARN: Removed duplicated region for block: B:13:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0093  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:12:0x0088 -> B:14:0x008b). Please report as a decompilation issue!!! */
    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r13) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.f6410L$0
            kotlinx.coroutines.CoroutineScope r0 = (p122kotlinx.coroutines.CoroutineScope) r0
            java.lang.Object r1 = r12.f6411L$1
            kotlinx.coroutines.flow.FlowCollector r1 = (p122kotlinx.coroutines.p125flow.FlowCollector) r1
            java.lang.Object r2 = p094kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r3 = r12.f6414label
            r4 = 1
            r5 = 0
            r6 = 0
            if (r3 == 0) goto L2d
            if (r3 != r4) goto L25
            int r3 = r12.f6406I$0
            long r7 = r12.f6409J$0
            java.lang.Object r9 = r12.f6413L$3
            kotlinx.coroutines.selects.SelectImplementation r9 = (p122kotlinx.coroutines.p127selects.SelectImplementation) r9
            java.lang.Object r9 = r12.f6412L$2
            kotlinx.coroutines.channels.ReceiveChannel r9 = (p122kotlinx.coroutines.channels.ReceiveChannel) r9
            p094kotlin.ResultKt.throwOnFailure(r13)
            goto L8b
        L25:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L2d:
            p094kotlin.ResultKt.throwOnFailure(r13)
            long r7 = r12.f24527$$v$c$kotlintimeDuration$timeout$0
            kotlin.time.Duration$Companion r13 = p094kotlin.p119time.Duration.INSTANCE
            long r9 = r13.m19931getZEROUwyO8pc()
            int r13 = p094kotlin.p119time.Duration.m19835compareToLRDsOJo(r7, r9)
            if (r13 <= 0) goto L96
            kotlinx.coroutines.flow.Flow<T> r13 = r12.$this_timeoutInternal
            r3 = 2
            kotlinx.coroutines.flow.Flow r13 = p122kotlinx.coroutines.p125flow.C1427FlowKt.buffer$default(r13, r6, r5, r3, r5)
            kotlinx.coroutines.channels.ReceiveChannel r13 = p122kotlinx.coroutines.p125flow.C1427FlowKt.produceIn(r13, r0)
            long r7 = r12.f24527$$v$c$kotlintimeDuration$timeout$0
            r9 = r13
            r3 = r6
        L4d:
            kotlinx.coroutines.selects.SelectImplementation r13 = new kotlinx.coroutines.selects.SelectImplementation
            kotlin.coroutines.CoroutineContext r10 = r12.get$context()
            r13.<init>(r10)
            kotlinx.coroutines.selects.SelectClause1 r10 = r9.getOnReceiveCatching()
            kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1 r11 = new kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$1
            r11.<init>(r1, r5)
            r13.mo7482invoke(r10, r11)
            kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2 r10 = new kotlinx.coroutines.flow.FlowKt__DelayKt$timeoutInternal$1$1$2
            r10.<init>(r7, r5)
            p122kotlinx.coroutines.p127selects.OnTimeoutKt.m20055onTimeout8Mi8wO0(r13, r7, r10)
            java.lang.Object r10 = p094kotlin.coroutines.p097jvm.internal.SpillingKt.nullOutSpilledVariable(r0)
            r12.f6410L$0 = r10
            r12.f6411L$1 = r1
            r12.f6412L$2 = r9
            java.lang.Object r10 = p094kotlin.coroutines.p097jvm.internal.SpillingKt.nullOutSpilledVariable(r13)
            r12.f6413L$3 = r10
            r12.f6409J$0 = r7
            r12.f6406I$0 = r3
            r12.f6407I$1 = r6
            r12.f6408I$2 = r6
            r12.f6414label = r4
            java.lang.Object r13 = r13.doSelect(r12)
            if (r13 != r2) goto L8b
            return r2
        L8b:
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            if (r13 != 0) goto L4d
            kotlin.Unit r12 = p094kotlin.C1133Unit.INSTANCE
            return r12
        L96:
            kotlinx.coroutines.TimeoutCancellationException r12 = new kotlinx.coroutines.TimeoutCancellationException
            java.lang.String r13 = "Timed out immediately"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: p122kotlinx.coroutines.p125flow.FlowKt__DelayKt$timeoutInternal$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // p094kotlin.p105jvm.functions.Function3
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Object mo6219invoke(CoroutineScope coroutineScope, FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
        FlowKt__DelayKt$timeoutInternal$1 flowKt__DelayKt$timeoutInternal$1 = new FlowKt__DelayKt$timeoutInternal$1(this.f24527$$v$c$kotlintimeDuration$timeout$0, this.$this_timeoutInternal, continuation);
        flowKt__DelayKt$timeoutInternal$1.f6410L$0 = coroutineScope;
        flowKt__DelayKt$timeoutInternal$1.f6411L$1 = flowCollector;
        return flowKt__DelayKt$timeoutInternal$1.invokeSuspend(C1133Unit.INSTANCE);
    }
}
