package p122kotlinx.coroutines.p127selects;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.ExperimentalCoroutinesApi;

@Metadata(m4987d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u001f\b\u0004\u0010\u0002\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0006H\u0087H¢\u0006\u0002\u0010\u0007¨\u0006\b"}, m4988d2 = {"whileSelect", BuildConfig.f24315FLAVOR, "builder", "Lkotlin/Function1;", "Lkotlinx/coroutines/selects/SelectBuilder;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nWhileSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n+ 2 Select.kt\nkotlinx/coroutines/selects/SelectKt\n*L\n1#1,29:1\n54#2,5:30\n*S KotlinDebug\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt\n*L\n27#1:30,5\n*E\n"})
/* loaded from: classes.dex */
public final class WhileSelectKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.selects.WhileSelectKt", m6124f = "WhileSelect.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {34}, m6127m = "whileSelect", m6128n = {"builder", "$this$select_u24lambda_u240$iv", "$i$f$whileSelect", "$i$f$select", "$i$a$-run-SelectKt$select$2$iv"}, m6130s = {"L$0", "L$1", "I$0", "I$1", "I$2"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nWhileSelect.kt\nKotlin\n*S Kotlin\n*F\n+ 1 WhileSelect.kt\nkotlinx/coroutines/selects/WhileSelectKt$whileSelect$1\n*L\n1#1,29:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.selects.WhileSelectKt$whileSelect$1 */
    public static final class C15881 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f7258I$0;

        /* renamed from: I$1 */
        int f7259I$1;

        /* renamed from: I$2 */
        int f7260I$2;

        /* renamed from: L$0 */
        Object f7261L$0;

        /* renamed from: L$1 */
        Object f7262L$1;

        /* renamed from: label */
        int f7263label;

        /* renamed from: result */
        /* synthetic */ Object f7264result;

        public C15881(Continuation<? super C15881> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f7264result = obj;
            this.f7263label |= Integer.MIN_VALUE;
            return WhileSelectKt.whileSelect(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0066 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0076  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0067 -> B:12:0x0036). Please report as a decompilation issue!!! */
    @ExperimentalCoroutinesApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object whileSelect(Function1<? super SelectBuilder<? super Boolean>, C1133Unit> function1, Continuation<? super C1133Unit> continuation) {
        C15881 c15881;
        int i;
        Object objDoSelect;
        if (continuation instanceof C15881) {
            c15881 = (C15881) continuation;
            int i2 = c15881.f7263label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                c15881.f7263label = i2 - Integer.MIN_VALUE;
            } else {
                c15881 = new C15881(continuation);
            }
        }
        Object obj = c15881.f7264result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = c15881.f7263label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj);
            i = 0;
            SelectImplementation selectImplementation = new SelectImplementation(c15881.getContext());
            function1.mo2237invoke(selectImplementation);
            c15881.f7261L$0 = function1;
            c15881.f7262L$1 = SpillingKt.nullOutSpilledVariable(selectImplementation);
            c15881.f7258I$0 = i;
            c15881.f7259I$1 = 0;
            c15881.f7260I$2 = 0;
            c15881.f7263label = 1;
            objDoSelect = selectImplementation.doSelect(c15881);
            if (objDoSelect != coroutine_suspended) {
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = c15881.f7258I$0;
            Function1<? super SelectBuilder<? super Boolean>, C1133Unit> function12 = (Function1) c15881.f7261L$0;
            ResultKt.throwOnFailure(obj);
            C15881 c158812 = c15881;
            int i5 = i4;
            function1 = function12;
            C15881 c158813 = c158812;
            if (((Boolean) obj).booleanValue()) {
                return C1133Unit.INSTANCE;
            }
            i = i5;
            c15881 = c158813;
            SelectImplementation selectImplementation2 = new SelectImplementation(c15881.getContext());
            function1.mo2237invoke(selectImplementation2);
            c15881.f7261L$0 = function1;
            c15881.f7262L$1 = SpillingKt.nullOutSpilledVariable(selectImplementation2);
            c15881.f7258I$0 = i;
            c15881.f7259I$1 = 0;
            c15881.f7260I$2 = 0;
            c15881.f7263label = 1;
            objDoSelect = selectImplementation2.doSelect(c15881);
            if (objDoSelect != coroutine_suspended) {
                return coroutine_suspended;
            }
            c158812 = c15881;
            i5 = i;
            obj = objDoSelect;
            C15881 c1588132 = c158812;
            if (((Boolean) obj).booleanValue()) {
            }
        }
    }

    @ExperimentalCoroutinesApi
    private static final Object whileSelect$$forInline(Function1<? super SelectBuilder<? super Boolean>, C1133Unit> function1, Continuation<? super C1133Unit> continuation) {
        InlineMarker.m6315mark(3);
        throw null;
    }
}
