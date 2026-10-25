package p131o;

import android.view.View;
import android.view.ViewGroup;
import p094kotlin.C1133Unit;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.RestrictedSuspendLambda;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.sequences.Sequence;
import p094kotlin.sequences.SequenceScope;
import p094kotlin.sequences.SequencesKt;

/* renamed from: o.fa */
/* loaded from: classes.dex */
public abstract class AbstractC3699fa {

    /* renamed from: o.fa$mjFkc */
    public static final class mjFkc extends RestrictedSuspendLambda implements Function2 {

        /* renamed from: AZxh */
        public /* synthetic */ Object f13612AZxh;

        /* renamed from: mjFkc */
        public int f13613mjFkc;

        /* renamed from: wA */
        public final /* synthetic */ View f13614wA;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public mjFkc(View view, Continuation continuation) {
            super(2, continuation);
            this.f13614wA = view;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation mo2166create(Object obj, Continuation continuation) {
            mjFkc mjfkc = new mjFkc(this.f13614wA, continuation);
            mjfkc.f13612AZxh = obj;
            return mjfkc;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SequenceScope sequenceScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f13613mjFkc;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                sequenceScope = (SequenceScope) this.f13612AZxh;
                View view = this.f13614wA;
                this.f13612AZxh = sequenceScope;
                this.f13613mjFkc = 1;
                if (sequenceScope.mo6559yield(view, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return C1133Unit.INSTANCE;
                }
                sequenceScope = (SequenceScope) this.f13612AZxh;
                ResultKt.throwOnFailure(obj);
            }
            View view2 = this.f13614wA;
            if (view2 instanceof ViewGroup) {
                Sequence sequenceM11324AZxh = AbstractC3371aa.m11324AZxh((ViewGroup) view2);
                this.f13612AZxh = null;
                this.f13613mjFkc = 2;
                if (sequenceScope.yieldAll(sequenceM11324AZxh, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(SequenceScope sequenceScope, Continuation continuation) {
            return ((mjFkc) mo2166create(sequenceScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* renamed from: mjFkc */
    public static final Sequence m11958mjFkc(View view) {
        return SequencesKt.sequence(new mjFkc(view, null));
    }
}
