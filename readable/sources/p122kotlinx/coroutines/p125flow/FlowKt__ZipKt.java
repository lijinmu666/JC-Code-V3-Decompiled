package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.functions.Function4;
import p094kotlin.p105jvm.functions.Function5;
import p094kotlin.p105jvm.functions.Function6;
import p094kotlin.p105jvm.functions.Function7;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.p125flow.internal.CombineKt;

@Metadata(m4987d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0005\u001a\u0087\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012F\u0010\u0006\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007H\u0007¢\u0006\u0004\b\u000e\u0010\u000f\u001a\u0087\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012F\u0010\u0006\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007¢\u0006\u0002\u0010\u000f\u001a\u0098\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012W\u0010\u0006\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0098\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012W\u0010\u0006\u001aS\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\u0013\u0012\u0011H\u0003¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\u0002\b\u0015¢\u0006\u0002\u0010\u0017\u001a\u0083\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012.\u0010\u0006\u001a*\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0012¢\u0006\u0002\u0010\u001a\u001a\u0094\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012?\u0010\u0006\u001a;\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001b¢\u0006\u0002\b\u0015¢\u0006\u0002\u0010\u001c\u001a\u009d\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001d\"\u0004\b\u0004\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u000124\u0010\u0006\u001a0\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u001b¢\u0006\u0002\u0010\u001f\u001a®\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001d\"\u0004\b\u0004\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00012E\u0010\u0006\u001aA\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0 ¢\u0006\u0002\b\u0015¢\u0006\u0002\u0010!\u001a·\u0001\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001d\"\u0004\b\u0004\u0010\"\"\u0004\b\u0005\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0\u00012:\u0010\u0006\u001a6\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\"\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0 ¢\u0006\u0002\u0010$\u001aÈ\u0001\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0018\"\u0004\b\u0003\u0010\u001d\"\u0004\b\u0004\u0010\"\"\u0004\b\u0005\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00180\u00012\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u00012\f\u0010#\u001a\b\u0012\u0004\u0012\u0002H\"0\u00012K\u0010\u0006\u001aG\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u0018\u0012\u0004\u0012\u0002H\u001d\u0012\u0004\u0012\u0002H\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0%¢\u0006\u0002\b\u0015¢\u0006\u0002\u0010&\u001an\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010(\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H'0\u00010)\"\b\u0012\u0004\u0012\u0002H'0\u00012*\b\u0004\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0)\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0*H\u0086\b¢\u0006\u0002\u0010+\u001a\u007f\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010(\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H'0\u00010)\"\b\u0012\u0004\u0012\u0002H'0\u00012;\b\u0004\u0010\u0006\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007¢\u0006\u0002\b\u0015H\u0086\b¢\u0006\u0002\u0010,\u001ap\u0010-\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010(\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H'0\u00010)\"\b\u0012\u0004\u0012\u0002H'0\u00012*\b\u0004\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0)\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0*H\u0082\b¢\u0006\u0004\b.\u0010+\u001a\u0081\u0001\u0010/\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u001e\u0010(\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H'0\u00010)\"\b\u0012\u0004\u0012\u0002H'0\u00012;\b\u0004\u0010\u0006\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007¢\u0006\u0002\b\u0015H\u0082\b¢\u0006\u0004\b0\u0010,\u001a!\u00101\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u0002H'\u0018\u00010)02\"\u0004\b\u0000\u0010'H\u0002¢\u0006\u0002\b3\u001ab\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0\u0001042*\b\u0004\u0010\u0006\u001a$\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0)\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0*H\u0086\b¢\u0006\u0002\u00105\u001as\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010'\u0018\u0001\"\u0004\b\u0001\u0010\u00022\u0012\u0010(\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0\u0001042;\b\u0004\u0010\u0006\u001a5\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007¢\u0006\u0002\b\u0015H\u0086\b¢\u0006\u0002\u00106\u001ae\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00030\u00012\f\u00108\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00012(\u0010\u0006\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0003\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\f\u0012\u0006\u0012\u0004\u0018\u00010\r0\u0007¢\u0006\u0002\u0010\u000f¨\u00069"}, m4988d2 = {"combine", "Lkotlinx/coroutines/flow/Flow;", "R", "T1", "T2", "flow", "transform", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "a", "b", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "flowCombine", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "flow2", "combineTransform", "Lkotlin/Function4;", "Lkotlinx/coroutines/flow/FlowCollector;", BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "flowCombineTransform", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "T3", "flow3", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "T4", "flow4", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function6;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "T5", "flow5", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "Lkotlin/Function7;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function7;)Lkotlinx/coroutines/flow/Flow;", "T", "flows", BuildConfig.f24315FLAVOR, "Lkotlin/Function2;", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "([Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "combineUnsafe", "combineUnsafe$FlowKt__ZipKt", "combineTransformUnsafe", "combineTransformUnsafe$FlowKt__ZipKt", "nullArrayFactory", "Lkotlin/Function0;", "nullArrayFactory$FlowKt__ZipKt", BuildConfig.f24315FLAVOR, "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "(Ljava/lang/Iterable;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "zip", "other", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n+ 2 SafeCollector.common.kt\nkotlinx/coroutines/flow/internal/SafeCollector_commonKt\n+ 3 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,328:1\n268#1,3:330\n268#1,3:333\n257#1:336\n259#1:338\n268#1,3:339\n257#1:342\n259#1:344\n268#1,3:345\n257#1:348\n259#1:350\n268#1,3:351\n105#2:329\n105#2:337\n105#2:343\n105#2:349\n105#2:354\n105#2:355\n105#2:358\n37#3,2:356\n37#3,2:359\n*S KotlinDebug\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n71#1:330,3\n99#1:333,3\n115#1:336\n115#1:338\n134#1:339,3\n152#1:342\n152#1:344\n173#1:345,3\n193#1:348\n193#1:350\n216#1:351,3\n28#1:329\n115#1:337\n152#1:343\n193#1:349\n233#1:354\n257#1:355\n284#1:358\n283#1:356,2\n302#1:359,2\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__ZipKt {

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6", m6124f = "Zip.kt", m6125i = {0}, m6126l = {247}, m6127m = "invokeSuspend", m6128n = {"$this$safeFlow"}, m6130s = {"L$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$6\n*L\n1#1,328:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6 */
    public static final class C15476<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super C1133Unit>, Object> {

        /* renamed from: $flows */
        final /* synthetic */ InterfaceC1426Flow<T>[] f6972$flows;
        final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> $transform;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6973L$0;

        /* renamed from: label */
        int f6974label;

        /* JADX INFO: Add missing generic type declarations: [T] */
        @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Function0<T[]> {

            /* renamed from: $flows */
            final /* synthetic */ InterfaceC1426Flow<T>[] f6975$flows;

            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass1(InterfaceC1426Flow<? extends T>[] interfaceC1426FlowArr) {
                this.f6975$flows = interfaceC1426FlowArr;
            }

            @Override // p094kotlin.p105jvm.functions.Function0
            /* renamed from: invoke */
            public final T[] mo4323invoke() {
                int length = this.f6975$flows.length;
                Intrinsics.reifiedOperationMarker(0, "T?");
                return (T[]) new Object[length];
            }
        }

        /* JADX INFO: Add missing generic type declarations: [T] */
        @Metadata(m4987d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
        @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2", m6124f = "Zip.kt", m6125i = {0, 0}, m6126l = {247}, m6127m = "invokeSuspend", m6128n = {"$this$combineInternal", "it"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$6$2, reason: invalid class name */
        public static final class AnonymousClass2<T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> {
            final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> $transform;

            /* renamed from: L$0 */
            private /* synthetic */ Object f6976L$0;

            /* renamed from: L$1 */
            /* synthetic */ Object f6977L$1;

            /* renamed from: label */
            int f6978label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super C1133Unit>, ? extends Object> function3, Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
                this.$transform = function3;
            }

            @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                FlowCollector flowCollector = (FlowCollector) this.f6976L$0;
                Object[] objArr = (Object[]) this.f6977L$1;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6978label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> function3 = this.$transform;
                    this.f6976L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    this.f6977L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                    this.f6978label = 1;
                    if (function3.mo6219invoke(flowCollector, objArr, this) == coroutine_suspended) {
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

            public final Object invokeSuspend$$forInline(Object obj) {
                FlowCollector flowCollector = (FlowCollector) this.f6976L$0;
                InlineMarker.m6315mark(10);
                Object[] objArr = (Object[]) this.f6977L$1;
                InlineMarker.m6315mark(10);
                this.$transform.mo6219invoke(flowCollector, objArr, this);
                return C1133Unit.INSTANCE;
            }

            @Override // p094kotlin.p105jvm.functions.Function3
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo6219invoke(FlowCollector<? super R> flowCollector, T[] tArr, Continuation<? super C1133Unit> continuation) {
                Intrinsics.needClassReification();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, continuation);
                anonymousClass2.f6976L$0 = flowCollector;
                anonymousClass2.f6977L$1 = tArr;
                return anonymousClass2.invokeSuspend(C1133Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C15476(InterfaceC1426Flow<? extends T>[] interfaceC1426FlowArr, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super C1133Unit>, ? extends Object> function3, Continuation<? super C15476> continuation) {
            super(2, continuation);
            this.f6972$flows = interfaceC1426FlowArr;
            this.$transform = function3;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C15476 c15476 = new C15476(this.f6972$flows, this.$transform, continuation);
            c15476.f6973L$0 = obj;
            return c15476;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.f6973L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6974label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC1426Flow<T>[] interfaceC1426FlowArr = this.f6972$flows;
                Intrinsics.needClassReification();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f6972$flows);
                Intrinsics.needClassReification();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
                this.f6973L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.f6974label = 1;
                if (CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, anonymousClass1, anonymousClass2, this) == coroutine_suspended) {
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

        public final Object invokeSuspend$$forInline(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.f6973L$0;
            InlineMarker.m6315mark(10);
            InterfaceC1426Flow<T>[] interfaceC1426FlowArr = this.f6972$flows;
            Intrinsics.needClassReification();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.f6972$flows);
            Intrinsics.needClassReification();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
            InlineMarker.m6315mark(0);
            CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, anonymousClass1, anonymousClass2, this);
            InlineMarker.m6315mark(1);
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(FlowCollector<? super R> flowCollector, Continuation<? super C1133Unit> continuation) {
            return ((C15476) mo2166create(flowCollector, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [R] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "Lkotlinx/coroutines/flow/FlowCollector;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7", m6124f = "Zip.kt", m6125i = {0}, m6126l = {304}, m6127m = "invokeSuspend", m6128n = {"$this$safeFlow"}, m6130s = {"L$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineTransform$7\n*L\n1#1,328:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7 */
    public static final class C15487<R> extends SuspendLambda implements Function2<FlowCollector<? super R>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ InterfaceC1426Flow<T>[] $flowArray;
        final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> $transform;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6979L$0;

        /* renamed from: label */
        int f6980label;

        /* JADX INFO: Add missing generic type declarations: [T] */
        @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$1, reason: invalid class name */
        public static final class AnonymousClass1<T> implements Function0<T[]> {
            final /* synthetic */ InterfaceC1426Flow<T>[] $flowArray;

            public AnonymousClass1(InterfaceC1426Flow<T>[] interfaceC1426FlowArr) {
                this.$flowArray = interfaceC1426FlowArr;
            }

            @Override // p094kotlin.p105jvm.functions.Function0
            /* renamed from: invoke */
            public final T[] mo4323invoke() {
                int length = this.$flowArray.length;
                Intrinsics.reifiedOperationMarker(0, "T?");
                return (T[]) new Object[length];
            }
        }

        /* JADX INFO: Add missing generic type declarations: [T] */
        @Metadata(m4987d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
        @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2", m6124f = "Zip.kt", m6125i = {0, 0}, m6126l = {304}, m6127m = "invokeSuspend", m6128n = {"$this$combineInternal", "it"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
        /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combineTransform$7$2, reason: invalid class name */
        public static final class AnonymousClass2<T> extends SuspendLambda implements Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> {
            final /* synthetic */ Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> $transform;

            /* renamed from: L$0 */
            private /* synthetic */ Object f6981L$0;

            /* renamed from: L$1 */
            /* synthetic */ Object f6982L$1;

            /* renamed from: label */
            int f6983label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public AnonymousClass2(Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super C1133Unit>, ? extends Object> function3, Continuation<? super AnonymousClass2> continuation) {
                super(3, continuation);
                this.$transform = function3;
            }

            @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                FlowCollector flowCollector = (FlowCollector) this.f6981L$0;
                Object[] objArr = (Object[]) this.f6982L$1;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.f6983label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Function3<FlowCollector<? super R>, T[], Continuation<? super C1133Unit>, Object> function3 = this.$transform;
                    this.f6981L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                    this.f6982L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                    this.f6983label = 1;
                    if (function3.mo6219invoke(flowCollector, objArr, this) == coroutine_suspended) {
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

            public final Object invokeSuspend$$forInline(Object obj) {
                FlowCollector flowCollector = (FlowCollector) this.f6981L$0;
                InlineMarker.m6315mark(10);
                Object[] objArr = (Object[]) this.f6982L$1;
                InlineMarker.m6315mark(10);
                this.$transform.mo6219invoke(flowCollector, objArr, this);
                return C1133Unit.INSTANCE;
            }

            @Override // p094kotlin.p105jvm.functions.Function3
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Object mo6219invoke(FlowCollector<? super R> flowCollector, T[] tArr, Continuation<? super C1133Unit> continuation) {
                Intrinsics.needClassReification();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, continuation);
                anonymousClass2.f6981L$0 = flowCollector;
                anonymousClass2.f6982L$1 = tArr;
                return anonymousClass2.invokeSuspend(C1133Unit.INSTANCE);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C15487(InterfaceC1426Flow<T>[] interfaceC1426FlowArr, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super C1133Unit>, ? extends Object> function3, Continuation<? super C15487> continuation) {
            super(2, continuation);
            this.$flowArray = interfaceC1426FlowArr;
            this.$transform = function3;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C15487 c15487 = new C15487(this.$flowArray, this.$transform, continuation);
            c15487.f6979L$0 = obj;
            return c15487;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.f6979L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6980label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                InterfaceC1426Flow<T>[] interfaceC1426FlowArr = this.$flowArray;
                Intrinsics.needClassReification();
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flowArray);
                Intrinsics.needClassReification();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
                this.f6979L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.f6980label = 1;
                if (CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, anonymousClass1, anonymousClass2, this) == coroutine_suspended) {
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

        public final Object invokeSuspend$$forInline(Object obj) {
            FlowCollector flowCollector = (FlowCollector) this.f6979L$0;
            InlineMarker.m6315mark(10);
            InterfaceC1426Flow<T>[] interfaceC1426FlowArr = this.$flowArray;
            Intrinsics.needClassReification();
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$flowArray);
            Intrinsics.needClassReification();
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$transform, null);
            InlineMarker.m6315mark(0);
            CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, anonymousClass1, anonymousClass2, this);
            InlineMarker.m6315mark(1);
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(FlowCollector<? super R> flowCollector, Continuation<? super C1133Unit> continuation) {
            return ((C15487) mo2166create(flowCollector, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* renamed from: combine */
    public static final <T1, T2, R> InterfaceC1426Flow<R> m7339combine(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return C1427FlowKt.flowCombine(interfaceC1426Flow, interfaceC1426Flow2, function3);
    }

    public static final <T1, T2, R> InterfaceC1426Flow<R> combineTransform(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super C1133Unit>, ? extends Object> function4) {
        return C1427FlowKt.m7219flow(new C1542xd7c321e7(new InterfaceC1426Flow[]{interfaceC1426Flow, interfaceC1426Flow2}, null, function4));
    }

    private static final /* synthetic */ <T, R> InterfaceC1426Flow<R> combineTransformUnsafe$FlowKt__ZipKt(InterfaceC1426Flow<? extends T>[] interfaceC1426FlowArr, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        Intrinsics.needClassReification();
        return C1427FlowKt.m7219flow(new FlowKt__ZipKt$combineTransformUnsafe$1(interfaceC1426FlowArr, function3, null));
    }

    private static final /* synthetic */ <T, R> InterfaceC1426Flow<R> combineUnsafe$FlowKt__ZipKt(InterfaceC1426Flow<? extends T>[] interfaceC1426FlowArr, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.needClassReification();
        return new FlowKt__ZipKt$combineUnsafe$$inlined$unsafeFlow$1(interfaceC1426FlowArr, function2);
    }

    @InterfaceC1231JvmName(m6260name = "flowCombine")
    public static final <T1, T2, R> InterfaceC1426Flow<R> flowCombine(final InterfaceC1426Flow<? extends T1> interfaceC1426Flow, final InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, final Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return new InterfaceC1426Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$unsafeFlow$1
            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector<? super R> flowCollector, Continuation<? super C1133Unit> continuation) {
                Object objCombineInternal = CombineKt.combineInternal(flowCollector, new InterfaceC1426Flow[]{interfaceC1426Flow, interfaceC1426Flow2}, new Function0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                    @Override // p094kotlin.p105jvm.functions.Function0
                    /* renamed from: invoke */
                    public final Void mo4323invoke() {
                        return null;
                    }
                }, new FlowKt__ZipKt$combine$1$1(function3, null), continuation);
                return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : C1133Unit.INSTANCE;
            }
        };
    }

    @InterfaceC1231JvmName(m6260name = "flowCombineTransform")
    public static final <T1, T2, R> InterfaceC1426Flow<R> flowCombineTransform(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super C1133Unit>, ? extends Object> function4) {
        return C1427FlowKt.m7219flow(new C1541xd7c321e6(new InterfaceC1426Flow[]{interfaceC1426Flow, interfaceC1426Flow2}, null, function4));
    }

    /* renamed from: zip */
    public static final <T1, T2, R> InterfaceC1426Flow<R> m7344zip(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return CombineKt.m7392zipImpl(interfaceC1426Flow, interfaceC1426Flow2, function3);
    }

    /* renamed from: combine */
    public static final <T1, T2, T3, R> InterfaceC1426Flow<R> m7340combine(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, final Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        final InterfaceC1426Flow[] interfaceC1426FlowArr = {interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3};
        return new InterfaceC1426Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1

            @Metadata(m4987d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n¨\u0006\u0007"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", BuildConfig.f24315FLAVOR, "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
            @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2", m6124f = "Zip.kt", m6125i = {0, 0, 0, 0, 0, 1, 1}, m6126l = {329, 258}, m6127m = "invokeSuspend", m6128n = {"$this$combineInternal", "it", "$completion", "args", "$i$a$-combineUnsafe-FlowKt__ZipKt$combine$2", "$this$combineInternal", "it"}, m6130s = {"L$0", "L$1", "L$3", "L$4", "I$0", "L$0", "L$1"}, m6131v = 1)
            @SourceDebugExtension(m6344value = {"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,328:1\n116#2,5:329\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$1$2 */
            public static final class C15362 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super C1133Unit>, Object> {
                final /* synthetic */ Function4 $transform$inlined;

                /* renamed from: I$0 */
                int f6879I$0;

                /* renamed from: L$0 */
                private /* synthetic */ Object f6880L$0;

                /* renamed from: L$1 */
                /* synthetic */ Object f6881L$1;

                /* renamed from: L$2 */
                Object f6882L$2;

                /* renamed from: L$3 */
                Object f6883L$3;

                /* renamed from: L$4 */
                Object f6884L$4;

                /* renamed from: label */
                int f6885label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C15362(Continuation continuation, Function4 function4) {
                    super(3, continuation);
                    this.$transform$inlined = function4;
                }

                @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    FlowCollector flowCollector;
                    FlowCollector flowCollector2 = (FlowCollector) this.f6880L$0;
                    Object[] objArr = (Object[]) this.f6881L$1;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f6885label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function4 function4 = this.$transform$inlined;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        this.f6880L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                        this.f6881L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.f6882L$2 = flowCollector2;
                        this.f6883L$3 = SpillingKt.nullOutSpilledVariable(this);
                        this.f6884L$4 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.f6879I$0 = 0;
                        this.f6885label = 1;
                        InlineMarker.m6315mark(6);
                        obj = function4.mo6276invoke(obj2, obj3, obj4, this);
                        InlineMarker.m6315mark(7);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector = flowCollector2;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return C1133Unit.INSTANCE;
                        }
                        flowCollector = (FlowCollector) this.f6882L$2;
                        ResultKt.throwOnFailure(obj);
                    }
                    this.f6880L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                    this.f6881L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                    this.f6882L$2 = null;
                    this.f6883L$3 = null;
                    this.f6884L$4 = null;
                    this.f6885label = 2;
                    if (flowCollector.mo4309emit(obj, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return C1133Unit.INSTANCE;
                }

                @Override // p094kotlin.p105jvm.functions.Function3
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo6219invoke(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super C1133Unit> continuation) {
                    C15362 c15362 = new C15362(continuation, this.$transform$inlined);
                    c15362.f6880L$0 = flowCollector;
                    c15362.f6881L$1 = objArr;
                    return c15362.invokeSuspend(C1133Unit.INSTANCE);
                }
            }

            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCombineInternal = CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, new Function0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                    @Override // p094kotlin.p105jvm.functions.Function0
                    /* renamed from: invoke */
                    public final Void mo4323invoke() {
                        return null;
                    }
                }, new C15362(null, function4), continuation);
                return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : C1133Unit.INSTANCE;
            }
        };
    }

    public static final <T1, T2, T3, R> InterfaceC1426Flow<R> combineTransform(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super C1133Unit>, ? extends Object> function5) {
        return C1427FlowKt.m7219flow(new C1543xd7c321e8(new InterfaceC1426Flow[]{interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3}, null, function5));
    }

    /* renamed from: combine */
    public static final <T1, T2, T3, T4, R> InterfaceC1426Flow<R> m7341combine(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, final Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        final InterfaceC1426Flow[] interfaceC1426FlowArr = {interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4};
        return new InterfaceC1426Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2

            @Metadata(m4987d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n¨\u0006\u0007"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", BuildConfig.f24315FLAVOR, "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
            @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2", m6124f = "Zip.kt", m6125i = {0, 0, 0, 0, 0, 1, 1}, m6126l = {329, 258}, m6127m = "invokeSuspend", m6128n = {"$this$combineInternal", "it", "$completion", "args", "$i$a$-combineUnsafe-FlowKt__ZipKt$combine$3", "$this$combineInternal", "it"}, m6130s = {"L$0", "L$1", "L$3", "L$4", "I$0", "L$0", "L$1"}, m6131v = 1)
            @SourceDebugExtension(m6344value = {"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,328:1\n153#2,6:329\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$2$2 */
            public static final class C15372 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super C1133Unit>, Object> {
                final /* synthetic */ Function5 $transform$inlined;

                /* renamed from: I$0 */
                int f6886I$0;

                /* renamed from: L$0 */
                private /* synthetic */ Object f6887L$0;

                /* renamed from: L$1 */
                /* synthetic */ Object f6888L$1;

                /* renamed from: L$2 */
                Object f6889L$2;

                /* renamed from: L$3 */
                Object f6890L$3;

                /* renamed from: L$4 */
                Object f6891L$4;

                /* renamed from: label */
                int f6892label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C15372(Continuation continuation, Function5 function5) {
                    super(3, continuation);
                    this.$transform$inlined = function5;
                }

                @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    FlowCollector flowCollector;
                    FlowCollector flowCollector2 = (FlowCollector) this.f6887L$0;
                    Object[] objArr = (Object[]) this.f6888L$1;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f6892label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function5 function5 = this.$transform$inlined;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        this.f6887L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                        this.f6888L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.f6889L$2 = flowCollector2;
                        this.f6890L$3 = SpillingKt.nullOutSpilledVariable(this);
                        this.f6891L$4 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.f6886I$0 = 0;
                        this.f6892label = 1;
                        InlineMarker.m6315mark(6);
                        obj = function5.mo6277invoke(obj2, obj3, obj4, obj5, this);
                        InlineMarker.m6315mark(7);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector = flowCollector2;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return C1133Unit.INSTANCE;
                        }
                        flowCollector = (FlowCollector) this.f6889L$2;
                        ResultKt.throwOnFailure(obj);
                    }
                    this.f6887L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                    this.f6888L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                    this.f6889L$2 = null;
                    this.f6890L$3 = null;
                    this.f6891L$4 = null;
                    this.f6892label = 2;
                    if (flowCollector.mo4309emit(obj, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return C1133Unit.INSTANCE;
                }

                @Override // p094kotlin.p105jvm.functions.Function3
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo6219invoke(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super C1133Unit> continuation) {
                    C15372 c15372 = new C15372(continuation, this.$transform$inlined);
                    c15372.f6887L$0 = flowCollector;
                    c15372.f6888L$1 = objArr;
                    return c15372.invokeSuspend(C1133Unit.INSTANCE);
                }
            }

            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCombineInternal = CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, new Function0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                    @Override // p094kotlin.p105jvm.functions.Function0
                    /* renamed from: invoke */
                    public final Void mo4323invoke() {
                        return null;
                    }
                }, new C15372(null, function5), continuation);
                return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : C1133Unit.INSTANCE;
            }
        };
    }

    public static final <T1, T2, T3, T4, R> InterfaceC1426Flow<R> combineTransform(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super C1133Unit>, ? extends Object> function6) {
        return C1427FlowKt.m7219flow(new C1544xd7c321e9(new InterfaceC1426Flow[]{interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4}, null, function6));
    }

    /* renamed from: combine */
    public static final <T1, T2, T3, T4, T5, R> InterfaceC1426Flow<R> m7342combine(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, InterfaceC1426Flow<? extends T5> interfaceC1426Flow5, final Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        final InterfaceC1426Flow[] interfaceC1426FlowArr = {interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4, interfaceC1426Flow5};
        return new InterfaceC1426Flow<R>() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3

            @Metadata(m4987d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0006\b\u0001\u0010\u0003\u0018\u0001*\b\u0012\u0004\u0012\u0002H\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00030\u0006H\n¨\u0006\u0007"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "R", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", BuildConfig.f24315FLAVOR, "kotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
            @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2", m6124f = "Zip.kt", m6125i = {0, 0, 0, 0, 0, 1, 1}, m6126l = {329, 258}, m6127m = "invokeSuspend", m6128n = {"$this$combineInternal", "it", "$completion", "args", "$i$a$-combineUnsafe-FlowKt__ZipKt$combine$4", "$this$combineInternal", "it"}, m6130s = {"L$0", "L$1", "L$3", "L$4", "I$0", "L$0", "L$1"}, m6131v = 1)
            @SourceDebugExtension(m6344value = {"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combineUnsafe$1$1\n+ 2 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt\n*L\n1#1,328:1\n194#2,7:329\n*E\n"})
            /* renamed from: kotlinx.coroutines.flow.FlowKt__ZipKt$combine$$inlined$combineUnsafe$FlowKt__ZipKt$3$2 */
            public static final class C15382 extends SuspendLambda implements Function3<FlowCollector<? super R>, Object[], Continuation<? super C1133Unit>, Object> {
                final /* synthetic */ Function6 $transform$inlined;

                /* renamed from: I$0 */
                int f6893I$0;

                /* renamed from: L$0 */
                private /* synthetic */ Object f6894L$0;

                /* renamed from: L$1 */
                /* synthetic */ Object f6895L$1;

                /* renamed from: L$2 */
                Object f6896L$2;

                /* renamed from: L$3 */
                Object f6897L$3;

                /* renamed from: L$4 */
                Object f6898L$4;

                /* renamed from: label */
                int f6899label;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                public C15382(Continuation continuation, Function6 function6) {
                    super(3, continuation);
                    this.$transform$inlined = function6;
                }

                @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) {
                    FlowCollector flowCollector;
                    FlowCollector flowCollector2 = (FlowCollector) this.f6894L$0;
                    Object[] objArr = (Object[]) this.f6895L$1;
                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                    int i = this.f6899label;
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        Function6 function6 = this.$transform$inlined;
                        Object obj2 = objArr[0];
                        Object obj3 = objArr[1];
                        Object obj4 = objArr[2];
                        Object obj5 = objArr[3];
                        Object obj6 = objArr[4];
                        this.f6894L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                        this.f6895L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.f6896L$2 = flowCollector2;
                        this.f6897L$3 = SpillingKt.nullOutSpilledVariable(this);
                        this.f6898L$4 = SpillingKt.nullOutSpilledVariable(objArr);
                        this.f6893I$0 = 0;
                        this.f6899label = 1;
                        InlineMarker.m6315mark(6);
                        obj = function6.mo6278invoke(obj2, obj3, obj4, obj5, obj6, this);
                        InlineMarker.m6315mark(7);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        flowCollector = flowCollector2;
                    } else {
                        if (i != 1) {
                            if (i != 2) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                            return C1133Unit.INSTANCE;
                        }
                        flowCollector = (FlowCollector) this.f6896L$2;
                        ResultKt.throwOnFailure(obj);
                    }
                    this.f6894L$0 = SpillingKt.nullOutSpilledVariable(flowCollector2);
                    this.f6895L$1 = SpillingKt.nullOutSpilledVariable(objArr);
                    this.f6896L$2 = null;
                    this.f6897L$3 = null;
                    this.f6898L$4 = null;
                    this.f6899label = 2;
                    if (flowCollector.mo4309emit(obj, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    return C1133Unit.INSTANCE;
                }

                @Override // p094kotlin.p105jvm.functions.Function3
                /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
                public final Object mo6219invoke(FlowCollector<? super R> flowCollector, Object[] objArr, Continuation<? super C1133Unit> continuation) {
                    C15382 c15382 = new C15382(continuation, this.$transform$inlined);
                    c15382.f6894L$0 = flowCollector;
                    c15382.f6895L$1 = objArr;
                    return c15382.invokeSuspend(C1133Unit.INSTANCE);
                }
            }

            @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
            /* renamed from: collect */
            public Object mo4308collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCombineInternal = CombineKt.combineInternal(flowCollector, interfaceC1426FlowArr, new Function0() { // from class: kotlinx.coroutines.flow.FlowKt__ZipKt$nullArrayFactory$1
                    @Override // p094kotlin.p105jvm.functions.Function0
                    /* renamed from: invoke */
                    public final Void mo4323invoke() {
                        return null;
                    }
                }, new C15382(null, function6), continuation);
                return objCombineInternal == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objCombineInternal : C1133Unit.INSTANCE;
            }
        };
    }

    public static final <T1, T2, T3, T4, T5, R> InterfaceC1426Flow<R> combineTransform(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, InterfaceC1426Flow<? extends T5> interfaceC1426Flow5, Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super C1133Unit>, ? extends Object> function7) {
        return C1427FlowKt.m7219flow(new C1545xd7c321ea(new InterfaceC1426Flow[]{interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4, interfaceC1426Flow5}, null, function7));
    }

    /* renamed from: combine */
    public static final /* synthetic */ <T, R> InterfaceC1426Flow<R> m7338combine(Iterable<? extends InterfaceC1426Flow<? extends T>> iterable, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2) {
        InterfaceC1426Flow[] interfaceC1426FlowArr = (InterfaceC1426Flow[]) CollectionsKt.m5899toList(iterable).toArray(new InterfaceC1426Flow[0]);
        Intrinsics.needClassReification();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$3(interfaceC1426FlowArr, function2);
    }

    public static final /* synthetic */ <T, R> InterfaceC1426Flow<R> combineTransform(InterfaceC1426Flow<? extends T>[] interfaceC1426FlowArr, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        Intrinsics.needClassReification();
        return C1427FlowKt.m7219flow(new C15476(interfaceC1426FlowArr, function3, null));
    }

    public static final /* synthetic */ <T, R> InterfaceC1426Flow<R> combineTransform(Iterable<? extends InterfaceC1426Flow<? extends T>> iterable, Function3<? super FlowCollector<? super R>, ? super T[], ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        InterfaceC1426Flow[] interfaceC1426FlowArr = (InterfaceC1426Flow[]) CollectionsKt.m5899toList(iterable).toArray(new InterfaceC1426Flow[0]);
        Intrinsics.needClassReification();
        return C1427FlowKt.m7219flow(new C15487(interfaceC1426FlowArr, function3, null));
    }

    /* renamed from: combine */
    public static final /* synthetic */ <T, R> InterfaceC1426Flow<R> m7343combine(InterfaceC1426Flow<? extends T>[] interfaceC1426FlowArr, Function2<? super T[], ? super Continuation<? super R>, ? extends Object> function2) {
        Intrinsics.needClassReification();
        return new FlowKt__ZipKt$combine$$inlined$unsafeFlow$2(interfaceC1426FlowArr, function2);
    }
}
