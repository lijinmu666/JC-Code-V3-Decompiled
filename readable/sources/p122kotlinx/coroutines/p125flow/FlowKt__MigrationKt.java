package p122kotlinx.coroutines.p125flow;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.coroutines.p097jvm.internal.SuspendLambda;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.functions.Function4;
import p094kotlin.p105jvm.functions.Function5;
import p094kotlin.p105jvm.functions.Function6;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.C1338DelayKt;

@Metadata(m4987d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\t\u001a\b\u0010\u0000\u001a\u00020\u0001H\u0000\u001a&\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a&\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a&\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a,\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a,\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a\u0018\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001aA\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fH\u0007¢\u0006\u0002\u0010\u0012\u001ae\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\"\u0010\u000e\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000f2\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fH\u0007¢\u0006\u0002\u0010\u0015\u001aS\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00040\u00032(\u0010\u0018\u001a$\b\u0001\u0012\u0004\u0012\u0002H\u0004\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u00030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fH\u0007¢\u0006\u0002\u0010\u0019\u001a>\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0018\u0010\u0018\u001a\u0014\u0012\u0004\u0012\u0002H\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u00030\u001bH\u0007\u001a$\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0003H\u0007\u001a$\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u00030\u0003H\u0007\u001aI\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00040\u00032#\u0010\u001f\u001a\u001f\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u00030\u001b¢\u0006\u0002\b H\u0007\u001a&\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\"\u001a\u00020#H\u0007\u001aP\u0010$\u001a\u00020\r\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u000321\u0010%\u001a-\b\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u00020\r0\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fH\u0007¢\u0006\u0002\u0010\u0012\u001ay\u0010)\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010*\u001a\u0002H\u00172F\u0010+\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0017¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(-\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0007¢\u0006\u0002\u0010.\u001a+\u0010/\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\n\u001a\u0002H\u0004H\u0007¢\u0006\u0002\u00100\u001aA\u0010/\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010\n\u001a\u0002H\u00042\u0014\b\u0002\u00101\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u0002020\u001bH\u0007¢\u0006\u0002\u00103\u001a+\u00104\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010(\u001a\u0002H\u0004H\u0007¢\u0006\u0002\u00100\u001a,\u00104\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a+\u00106\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010(\u001a\u0002H\u0004H\u0007¢\u0006\u0002\u00100\u001a,\u00106\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001ag\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u00109\"\u0004\b\u0002\u0010\u0017*\b\u0012\u0004\u0012\u0002H80\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u0002H90\u00032(\u0010:\u001a$\b\u0001\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H9\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0007¢\u0006\u0002\u0010;\u001a\u0081\u0001\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u00109\"\u0004\b\u0002\u0010<\"\u0004\b\u0003\u0010\u0017*\b\u0012\u0004\u0012\u0002H80\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u0002H90\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0\u00032.\u0010:\u001a*\b\u0001\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H<\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110>H\u0007¢\u0006\u0002\u0010?\u001a\u009b\u0001\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u00109\"\u0004\b\u0002\u0010<\"\u0004\b\u0003\u0010@\"\u0004\b\u0004\u0010\u0017*\b\u0012\u0004\u0012\u0002H80\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u0002H90\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0\u00032\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H@0\u000324\u0010:\u001a0\b\u0001\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H@\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110BH\u0007¢\u0006\u0002\u0010C\u001aµ\u0001\u00107\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u00108\"\u0004\b\u0001\u00109\"\u0004\b\u0002\u0010<\"\u0004\b\u0003\u0010@\"\u0004\b\u0004\u0010D\"\u0004\b\u0005\u0010\u0017*\b\u0012\u0004\u0012\u0002H80\u00032\f\u00105\u001a\b\u0012\u0004\u0012\u0002H90\u00032\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H<0\u00032\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H@0\u00032\f\u0010E\u001a\b\u0012\u0004\u0012\u0002HD0\u00032:\u0010:\u001a6\b\u0001\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H9\u0012\u0004\u0012\u0002H<\u0012\u0004\u0012\u0002H@\u0012\u0004\u0012\u0002HD\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110FH\u0007¢\u0006\u0002\u0010G\u001a&\u0010H\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010I\u001a\u00020JH\u0007\u001a&\u0010K\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010I\u001a\u00020JH\u0007\u001ab\u0010L\u001a\b\u0012\u0004\u0012\u0002H\u00170\u0003\"\u0004\b\u0000\u0010\u0004\"\u0004\b\u0001\u0010\u0017*\b\u0012\u0004\u0012\u0002H\u00040\u000327\u0010:\u001a3\b\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00170\u00030\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110\u000fH\u0007¢\u0006\u0002\u0010\u0019\u001ak\u0010M\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032F\u0010+\u001aB\b\u0001\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b(-\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b&\u0012\b\b'\u0012\u0004\b\b((\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00040\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u00110,H\u0007¢\u0006\u0002\u0010N\u001a\u001e\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a&\u0010O\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010P\u001a\u00020#H\u0007\u001a\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007\u001a&\u0010Q\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u00032\u0006\u0010P\u001a\u00020#H\u0007\u001a\u001e\u0010R\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0003\"\u0004\b\u0000\u0010\u0004*\b\u0012\u0004\u0012\u0002H\u00040\u0003H\u0007¨\u0006S"}, m4988d2 = {"noImpl", BuildConfig.f24315FLAVOR, "observeOn", "Lkotlinx/coroutines/flow/Flow;", "T", "context", "Lkotlin/coroutines/CoroutineContext;", "publishOn", "subscribeOn", "onErrorResume", "fallback", "onErrorResumeNext", "subscribe", BuildConfig.f24315FLAVOR, "onEach", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)V", "onError", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;)V", "flatMap", "R", "mapper", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;)Lkotlinx/coroutines/flow/Flow;", "concatMap", "Lkotlin/Function1;", "merge", "flatten", "compose", "transformer", "Lkotlin/ExtensionFunctionType;", "skip", "count", BuildConfig.f24315FLAVOR, "forEach", "action", "Lkotlin/ParameterName;", "name", "value", "scanFold", "initial", "operation", "Lkotlin/Function3;", "accumulator", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "onErrorReturn", "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;)Lkotlinx/coroutines/flow/Flow;", "predicate", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlinx/coroutines/flow/Flow;", "startWith", "other", "concatWith", "combineLatest", "T1", "T2", "transform", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "T3", "other2", "Lkotlin/Function4;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function4;)Lkotlinx/coroutines/flow/Flow;", "T4", "other3", "Lkotlin/Function5;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function5;)Lkotlinx/coroutines/flow/Flow;", "T5", "other4", "Lkotlin/Function6;", "(Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function6;)Lkotlinx/coroutines/flow/Flow;", "delayFlow", "timeMillis", BuildConfig.f24315FLAVOR, "delayEach", "switchMap", "scanReduce", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function3;)Lkotlinx/coroutines/flow/Flow;", "publish", "bufferSize", "replay", "cache", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nMigration.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n+ 2 Merge.kt\nkotlinx/coroutines/flow/FlowKt__MergeKt\n*L\n1#1,492:1\n189#2:493\n*S KotlinDebug\n*F\n+ 1 Migration.kt\nkotlinx/coroutines/flow/FlowKt__MigrationKt\n*L\n431#1:493\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__MigrationKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "it"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayEach$1", m6124f = "Migration.kt", m6125i = {}, m6126l = {423}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$delayEach$1 */
    public static final class C14961<T> extends SuspendLambda implements Function2<T, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ long $timeMillis;

        /* renamed from: label */
        int f6636label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14961(long j, Continuation<? super C14961> continuation) {
            super(2, continuation);
            this.$timeMillis = j;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return new C14961(this.$timeMillis, continuation);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ Object mo2167invoke(Object obj, Continuation<? super C1133Unit> continuation) {
            return invoke2((C14961<T>) obj, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6636label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.$timeMillis;
                this.f6636label = 1;
                if (C1338DelayKt.m6972delay(j, this) == coroutine_suspended) {
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

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(T t, Continuation<? super C1133Unit> continuation) {
            return ((C14961) mo2166create(t, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/flow/FlowCollector;"}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1", m6124f = "Migration.kt", m6125i = {}, m6126l = {411}, m6127m = "invokeSuspend", m6128n = {}, m6130s = {}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$delayFlow$1 */
    public static final class C14971<T> extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ long $timeMillis;

        /* renamed from: label */
        int f6637label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C14971(long j, Continuation<? super C14971> continuation) {
            super(2, continuation);
            this.$timeMillis = j;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            return new C14971(this.$timeMillis, continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6637label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                long j = this.$timeMillis;
                this.f6637label = 1;
                if (C1338DelayKt.m6972delay(j, this) == coroutine_suspended) {
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
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(FlowCollector<? super T> flowCollector, Continuation<? super C1133Unit> continuation) {
            return ((C14971) mo2166create(flowCollector, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/flow/FlowCollector;", "e", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2", m6124f = "Migration.kt", m6125i = {0, 0}, m6126l = {302}, m6127m = "invokeSuspend", m6128n = {"$this$catch", "e"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__MigrationKt$onErrorReturn$2 */
    public static final class C14982<T> extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ T $fallback;
        final /* synthetic */ Function1<Throwable, Boolean> $predicate;

        /* renamed from: L$0 */
        private /* synthetic */ Object f6638L$0;

        /* renamed from: L$1 */
        /* synthetic */ Object f6639L$1;

        /* renamed from: label */
        int f6640label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C14982(Function1<? super Throwable, Boolean> function1, T t, Continuation<? super C14982> continuation) {
            super(3, continuation);
            this.$predicate = function1;
            this.$fallback = t;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            FlowCollector flowCollector = (FlowCollector) this.f6638L$0;
            Throwable th = (Throwable) this.f6639L$1;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.f6640label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (!this.$predicate.mo2237invoke(th).booleanValue()) {
                    throw th;
                }
                T t = this.$fallback;
                this.f6638L$0 = SpillingKt.nullOutSpilledVariable(flowCollector);
                this.f6639L$1 = SpillingKt.nullOutSpilledVariable(th);
                this.f6640label = 1;
                if (flowCollector.mo4309emit(t, this) == coroutine_suspended) {
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

        @Override // p094kotlin.p105jvm.functions.Function3
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo6219invoke(FlowCollector<? super T> flowCollector, Throwable th, Continuation<? super C1133Unit> continuation) {
            C14982 c14982 = new C14982(this.$predicate, this.$fallback, continuation);
            c14982.f6638L$0 = flowCollector;
            c14982.f6639L$1 = th;
            return c14982.invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStarted.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, started = SharingStarted.Lazily, replay = Int.MAX_VALUE)", m5048imports = {}))
    /* renamed from: cache */
    public static final <T> InterfaceC1426Flow<T> m7305cache(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", m5048imports = {}))
    public static final <T1, T2, R> InterfaceC1426Flow<R> combineLatest(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return C1427FlowKt.m7203combine(interfaceC1426Flow, interfaceC1426Flow2, function3);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", m5048imports = {}))
    /* renamed from: compose */
    public static final <T, R> InterfaceC1426Flow<R> m7306compose(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function1<? super InterfaceC1426Flow<? extends T>, ? extends InterfaceC1426Flow<? extends R>> function1) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", m5048imports = {}))
    public static final <T, R> InterfaceC1426Flow<R> concatMap(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function1<? super T, ? extends InterfaceC1426Flow<? extends R>> function1) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> concatWith(InterfaceC1426Flow<? extends T> interfaceC1426Flow, T t) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> delayEach(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return C1427FlowKt.m7234onEach(interfaceC1426Flow, new C14961(j, null));
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> delayFlow(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return C1427FlowKt.m7236onStart(interfaceC1426Flow, new C14971(j, null));
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", m5048imports = {}))
    /* renamed from: flatMap */
    public static final <T, R> InterfaceC1426Flow<R> m7307flatMap(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super InterfaceC1426Flow<? extends R>>, ? extends Object> function2) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", m5048imports = {}))
    /* renamed from: flatten */
    public static final <T> InterfaceC1426Flow<T> m7308flatten(InterfaceC1426Flow<? extends InterfaceC1426Flow<? extends T>> interfaceC1426Flow) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(action)", m5048imports = {}))
    /* renamed from: forEach */
    public static final <T> void m7309forEach(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", m5048imports = {}))
    /* renamed from: merge */
    public static final <T> InterfaceC1426Flow<T> m7310merge(InterfaceC1426Flow<? extends InterfaceC1426Flow<? extends T>> interfaceC1426Flow) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    /* renamed from: noImpl */
    public static final Void m7312noImpl() {
        throw new UnsupportedOperationException("Not implemented, should not be called");
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Collect flow in the desired context instead")
    public static final <T> InterfaceC1426Flow<T> observeOn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineContext coroutineContext) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> onErrorResume(InterfaceC1426Flow<? extends T> interfaceC1426Flow, InterfaceC1426Flow<? extends T> interfaceC1426Flow2) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> onErrorResumeNext(InterfaceC1426Flow<? extends T> interfaceC1426Flow, InterfaceC1426Flow<? extends T> interfaceC1426Flow2) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> onErrorReturn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, T t) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    public static /* synthetic */ InterfaceC1426Flow onErrorReturn$default(InterfaceC1426Flow interfaceC1426Flow, Object obj, Function1 function1, int i, Object obj2) {
        if ((i & 2) != 0) {
            function1 = new Function1() { // from class: kotlinx.coroutines.flow.KLFTb
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public final Object mo2237invoke(Object obj3) {
                    return Boolean.valueOf(FlowKt__MigrationKt.onErrorReturn$lambda$0$FlowKt__MigrationKt((Throwable) obj3));
                }
            };
        }
        return C1427FlowKt.onErrorReturn(interfaceC1426Flow, obj, function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean onErrorReturn$lambda$0$FlowKt__MigrationKt(Throwable th) {
        return true;
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStarted.Lazily' argument, \npublish().refCount() translates to 'started = SharingStarted.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", m5048imports = {}))
    /* renamed from: publish */
    public static final <T> InterfaceC1426Flow<T> m7313publish(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Collect flow in the desired context instead")
    public static final <T> InterfaceC1426Flow<T> publishOn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineContext coroutineContext) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStarted.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStarted.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", m5048imports = {}))
    /* renamed from: replay */
    public static final <T> InterfaceC1426Flow<T> m7315replay(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", m5048imports = {}))
    public static final <T, R> InterfaceC1426Flow<R> scanFold(InterfaceC1426Flow<? extends T> interfaceC1426Flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> scanReduce(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return C1427FlowKt.runningReduce(interfaceC1426Flow, function3);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", m5048imports = {}))
    /* renamed from: skip */
    public static final <T> InterfaceC1426Flow<T> m7317skip(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> startWith(InterfaceC1426Flow<? extends T> interfaceC1426Flow, T t) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'flowOn' instead")
    public static final <T> InterfaceC1426Flow<T> subscribeOn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineContext coroutineContext) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", m5048imports = {}))
    public static final <T, R> InterfaceC1426Flow<R> switchMap(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super InterfaceC1426Flow<? extends R>>, ? extends Object> function2) {
        return C1427FlowKt.transformLatest(interfaceC1426Flow, new FlowKt__MigrationKt$switchMap$$inlined$flatMapLatest$1(function2, null));
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", m5048imports = {}))
    public static final <T1, T2, T3, R> InterfaceC1426Flow<R> combineLatest(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return C1427FlowKt.m7204combine(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, function4);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { if (it == null) emitAll(other) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> concatWith(InterfaceC1426Flow<? extends T> interfaceC1426Flow, InterfaceC1426Flow<? extends T> interfaceC1426Flow2) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> onErrorReturn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, T t, Function1<? super Throwable, Boolean> function1) {
        return C1427FlowKt.m7198catch(interfaceC1426Flow, new C14982(function1, t, null));
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStarted.Lazily' argument, \npublish().refCount() translates to 'started = SharingStarted.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", m5048imports = {}))
    /* renamed from: publish */
    public static final <T> InterfaceC1426Flow<T> m7314publish(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStarted.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStarted.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", m5048imports = {}))
    /* renamed from: replay */
    public static final <T> InterfaceC1426Flow<T> m7316replay(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> startWith(InterfaceC1426Flow<? extends T> interfaceC1426Flow, InterfaceC1426Flow<? extends T> interfaceC1426Flow2) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", m5048imports = {}))
    public static final <T1, T2, T3, T4, R> InterfaceC1426Flow<R> combineLatest(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return C1427FlowKt.m7205combine(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4, function5);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2, Function2<? super Throwable, ? super Continuation<? super C1133Unit>, ? extends Object> function22) {
        C1427FlowKt.m7232noImpl();
        throw new KotlinNothingValueException();
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", m5048imports = {}))
    public static final <T1, T2, T3, T4, T5, R> InterfaceC1426Flow<R> combineLatest(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, InterfaceC1426Flow<? extends T5> interfaceC1426Flow5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return C1427FlowKt.m7206combine(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4, interfaceC1426Flow5, function6);
    }
}
