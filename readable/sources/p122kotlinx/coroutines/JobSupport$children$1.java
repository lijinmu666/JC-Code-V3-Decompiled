package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.RestrictedSuspendLambda;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.sequences.SequenceScope;
import p122kotlinx.coroutines.internal.LockFreeLinkedListHead;
import p122kotlinx.coroutines.internal.LockFreeLinkedListNode;

@Metadata(m4987d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "Lkotlin/sequences/SequenceScope;", "Lkotlinx/coroutines/Job;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
@DebugMetadata(m6123c = "kotlinx.coroutines.JobSupport$children$1", m6124f = "JobSupport.kt", m6125i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1}, m6126l = {1003, 1005}, m6127m = "invokeSuspend", m6128n = {"$this$sequence", "state", "$this$sequence", "state", "list", "this_$iv", "cur$iv", "it", "$i$a$-let-JobSupport$children$1$1", "$i$f$forEach", "$i$a$-forEach-JobSupport$children$1$1$1"}, m6130s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1", "I$2"}, m6131v = 1)
@SourceDebugExtension(m6344value = {"SMAP\nJobSupport.kt\nKotlin\n*S Kotlin\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n+ 2 LockFreeLinkedList.kt\nkotlinx/coroutines/internal/LockFreeLinkedListHead\n*L\n1#1,1583:1\n273#2,6:1584\n*S KotlinDebug\n*F\n+ 1 JobSupport.kt\nkotlinx/coroutines/JobSupport$children$1\n*L\n1005#1:1584,6\n*E\n"})
/* loaded from: classes.dex */
public final class JobSupport$children$1 extends RestrictedSuspendLambda implements Function2<SequenceScope<? super InterfaceC1342Job>, Continuation<? super C1133Unit>, Object> {

    /* renamed from: I$0 */
    int f5549I$0;

    /* renamed from: I$1 */
    int f5550I$1;

    /* renamed from: I$2 */
    int f5551I$2;

    /* renamed from: L$0 */
    private /* synthetic */ Object f5552L$0;

    /* renamed from: L$1 */
    Object f5553L$1;

    /* renamed from: L$2 */
    Object f5554L$2;

    /* renamed from: L$3 */
    Object f5555L$3;

    /* renamed from: L$4 */
    Object f5556L$4;

    /* renamed from: L$5 */
    Object f5557L$5;

    /* renamed from: label */
    int f5558label;

    /* renamed from: this$0 */
    final /* synthetic */ JobSupport f5559this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public JobSupport$children$1(JobSupport jobSupport, Continuation<? super JobSupport$children$1> continuation) {
        super(2, continuation);
        this.f5559this$0 = jobSupport;
    }

    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /* renamed from: create */
    public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
        JobSupport$children$1 jobSupport$children$1 = new JobSupport$children$1(this.f5559this$0, continuation);
        jobSupport$children$1.f5552L$0 = obj;
        return jobSupport$children$1;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0086  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0088 -> B:27:0x00b6). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x00b3 -> B:27:0x00b6). Please report as a decompilation issue!!! */
    @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object invokeSuspend(Object obj) {
        NodeList list;
        Object obj2;
        LockFreeLinkedListHead lockFreeLinkedListHead;
        LockFreeLinkedListHead lockFreeLinkedListHead2;
        LockFreeLinkedListNode nextNode;
        int i;
        int i2;
        SequenceScope sequenceScope = (SequenceScope) this.f5552L$0;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = this.f5558label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            Object state$kotlinx_coroutines_core = this.f5559this$0.getState$kotlinx_coroutines_core();
            if (state$kotlinx_coroutines_core instanceof ChildHandleNode) {
                ChildJob childJob = ((ChildHandleNode) state$kotlinx_coroutines_core).childJob;
                this.f5552L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                this.f5553L$1 = SpillingKt.nullOutSpilledVariable(state$kotlinx_coroutines_core);
                this.f5558label = 1;
                if (sequenceScope.mo6559yield(childJob, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else if ((state$kotlinx_coroutines_core instanceof Incomplete) && (list = ((Incomplete) state$kotlinx_coroutines_core).getList()) != null) {
                Object objM7430getNext = list.m7430getNext();
                Intrinsics.checkNotNull(objM7430getNext, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
                obj2 = state$kotlinx_coroutines_core;
                lockFreeLinkedListHead = list;
                lockFreeLinkedListHead2 = lockFreeLinkedListHead;
                nextNode = (LockFreeLinkedListNode) objM7430getNext;
                i = 0;
                i2 = 0;
                if (!Intrinsics.areEqual(nextNode, lockFreeLinkedListHead)) {
                }
            }
        } else if (i3 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = this.f5550I$1;
            i2 = this.f5549I$0;
            nextNode = (LockFreeLinkedListNode) this.f5556L$4;
            lockFreeLinkedListHead = (LockFreeLinkedListHead) this.f5555L$3;
            lockFreeLinkedListHead2 = (NodeList) this.f5554L$2;
            obj2 = this.f5553L$1;
            ResultKt.throwOnFailure(obj);
            nextNode = nextNode.getNextNode();
            if (!Intrinsics.areEqual(nextNode, lockFreeLinkedListHead)) {
                if (nextNode instanceof ChildHandleNode) {
                    ChildJob childJob2 = ((ChildHandleNode) nextNode).childJob;
                    this.f5552L$0 = sequenceScope;
                    this.f5553L$1 = SpillingKt.nullOutSpilledVariable(obj2);
                    this.f5554L$2 = SpillingKt.nullOutSpilledVariable(lockFreeLinkedListHead2);
                    this.f5555L$3 = lockFreeLinkedListHead;
                    this.f5556L$4 = nextNode;
                    this.f5557L$5 = SpillingKt.nullOutSpilledVariable(nextNode);
                    this.f5549I$0 = i2;
                    this.f5550I$1 = i;
                    this.f5551I$2 = 0;
                    this.f5558label = 2;
                    if (sequenceScope.mo6559yield(childJob2, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                nextNode = nextNode.getNextNode();
                if (!Intrinsics.areEqual(nextNode, lockFreeLinkedListHead)) {
                }
            }
        }
        return C1133Unit.INSTANCE;
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo2167invoke(SequenceScope<? super InterfaceC1342Job> sequenceScope, Continuation<? super C1133Unit> continuation) {
        return ((JobSupport$children$1) mo2166create(sequenceScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
    }
}
