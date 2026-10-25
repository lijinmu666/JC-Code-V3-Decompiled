package p122kotlinx.coroutines.p125flow;

import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.p105jvm.internal.C1235Ref;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class StartedLazily$command$1$1<T> implements FlowCollector {
    final /* synthetic */ C1235Ref.BooleanRef $started;
    final /* synthetic */ FlowCollector<SharingCommand> $this_unsafeFlow;

    /* JADX WARN: Multi-variable type inference failed */
    public StartedLazily$command$1$1(C1235Ref.BooleanRef booleanRef, FlowCollector<? super SharingCommand> flowCollector) {
        this.$started = booleanRef;
        this.$this_unsafeFlow = flowCollector;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: emit */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m7385emit(int i, Continuation<? super C1133Unit> continuation) {
        StartedLazily$command$1$1$emit$1 startedLazily$command$1$1$emit$1;
        if (continuation instanceof StartedLazily$command$1$1$emit$1) {
            startedLazily$command$1$1$emit$1 = (StartedLazily$command$1$1$emit$1) continuation;
            int i2 = startedLazily$command$1$1$emit$1.f7029label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                startedLazily$command$1$1$emit$1.f7029label = i2 - Integer.MIN_VALUE;
            } else {
                startedLazily$command$1$1$emit$1 = new StartedLazily$command$1$1$emit$1(this, continuation);
            }
        }
        Object obj = startedLazily$command$1$1$emit$1.f7030result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = startedLazily$command$1$1$emit$1.f7029label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            if (i > 0) {
                C1235Ref.BooleanRef booleanRef = this.$started;
                if (!booleanRef.f5195element) {
                    booleanRef.f5195element = true;
                    FlowCollector<SharingCommand> flowCollector = this.$this_unsafeFlow;
                    SharingCommand sharingCommand = SharingCommand.f7015START;
                    startedLazily$command$1$1$emit$1.f7028I$0 = i;
                    startedLazily$command$1$1$emit$1.f7029label = 1;
                    if (flowCollector.mo4309emit(sharingCommand, startedLazily$command$1$1$emit$1) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            }
            return C1133Unit.INSTANCE;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        return C1133Unit.INSTANCE;
    }

    @Override // p122kotlinx.coroutines.p125flow.FlowCollector
    /* renamed from: emit */
    public /* bridge */ /* synthetic */ Object mo4309emit(Object obj, Continuation continuation) {
        return m7385emit(((Number) obj).intValue(), (Continuation<? super C1133Unit>) continuation);
    }
}
