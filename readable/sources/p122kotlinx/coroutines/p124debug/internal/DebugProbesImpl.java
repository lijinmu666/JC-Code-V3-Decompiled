package p122kotlinx.coroutines.p124debug.internal;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import org.conscrypt.BuildConfig;
import p094kotlin.C1122Pair;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.ResultKt;
import p094kotlin.TuplesKt;
import p094kotlin.collections.ArraysKt;
import p094kotlin.collections.C1155MapsKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.comparisons.ComparisonsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.ContinuationInterceptor;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.EmptyCoroutineContext;
import p094kotlin.coroutines.p097jvm.internal.CoroutineStackFrame;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p105jvm.internal.TypeIntrinsics;
import p094kotlin.p112ranges.RangesKt;
import p094kotlin.p117text.StringsKt;
import p094kotlin.sequences.SequencesKt;
import p122kotlinx.coroutines.C1344JobKt;
import p122kotlinx.coroutines.CoroutineId;
import p122kotlinx.coroutines.CoroutineName;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.JobSupport;
import p122kotlinx.coroutines.internal.ScopeCoroutine;
import p122kotlinx.coroutines.p124debug.internal.DebugProbesImpl;
import p131o.C3678fFz;

@Metadata(m4987d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001~B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010&\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0002J\r\u0010*\u001a\u00020%H\u0000¢\u0006\u0002\b+J\r\u0010,\u001a\u00020%H\u0000¢\u0006\u0002\b-J\b\u0010.\u001a\u00020%H\u0002J\b\u0010/\u001a\u00020%H\u0002J\u0015\u00100\u001a\u0002012\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4J4\u00105\u001a\u00020%*\u0002032\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020)072\n\u00108\u001a\u000609j\u0002`:2\u0006\u0010;\u001a\u000201H\u0002J9\u0010A\u001a\b\u0012\u0004\u0012\u0002HC0B\"\b\b\u0000\u0010C*\u00020\u00012\u001e\b\u0004\u0010D\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020F\u0012\u0004\u0012\u0002HC0EH\u0082\bJ\u0011\u0010G\u001a\b\u0012\u0004\u0012\u00020\u00010H¢\u0006\u0002\u0010IJ\u000e\u0010J\u001a\u0002012\u0006\u0010K\u001a\u00020LJ\f\u0010M\u001a\u000201*\u00020\u0001H\u0002J\f\u0010N\u001a\b\u0012\u0004\u0012\u00020L0BJ\f\u0010O\u001a\b\u0012\u0004\u0012\u00020P0BJ\u0010\u0010Q\u001a\u00020%2\u0006\u0010R\u001a\u00020SH\u0001J\u0010\u0010T\u001a\u00020\r*\u0006\u0012\u0002\b\u00030\fH\u0002J\u0010\u0010U\u001a\u00020%2\u0006\u0010R\u001a\u00020SH\u0002J\u001e\u0010V\u001a\u00020%2\u0006\u0010R\u001a\u00020S2\f\u0010W\u001a\b\u0012\u0004\u0012\u00020\u00050BH\u0002J\"\u0010X\u001a\b\u0012\u0004\u0012\u00020\u00050B2\u0006\u0010K\u001a\u00020L2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050BJ.\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00050B2\u0006\u0010[\u001a\u0002012\b\u0010\\\u001a\u0004\u0018\u00010\t2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050BH\u0002J=\u0010]\u001a\u000e\u0012\u0004\u0012\u00020_\u0012\u0004\u0012\u00020_0^2\u0006\u0010`\u001a\u00020_2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00050H2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050BH\u0002¢\u0006\u0002\u0010bJ1\u0010c\u001a\u00020_2\u0006\u0010d\u001a\u00020_2\f\u0010a\u001a\b\u0012\u0004\u0012\u00020\u00050H2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020\u00050BH\u0002¢\u0006\u0002\u0010eJ\u0019\u0010f\u001a\u00020%2\n\u0010g\u001a\u0006\u0012\u0002\b\u00030hH\u0000¢\u0006\u0002\biJ\u0019\u0010j\u001a\u00020%2\n\u0010g\u001a\u0006\u0012\u0002\b\u00030hH\u0000¢\u0006\u0002\bkJ\u001c\u0010l\u001a\u00020%2\n\u0010g\u001a\u0006\u0012\u0002\b\u00030h2\u0006\u0010[\u001a\u000201H\u0002J\u0018\u0010m\u001a\u00020%2\u0006\u0010g\u001a\u00020(2\u0006\u0010[\u001a\u000201H\u0002J\u000f\u0010n\u001a\u0004\u0018\u00010(*\u00020(H\u0082\u0010J(\u0010l\u001a\u00020%2\n\u0010o\u001a\u0006\u0012\u0002\b\u00030\f2\n\u0010g\u001a\u0006\u0012\u0002\b\u00030h2\u0006\u0010[\u001a\u000201H\u0002J\u0016\u0010o\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f*\u0006\u0012\u0002\b\u00030hH\u0002J\u0013\u0010o\u001a\b\u0012\u0002\b\u0003\u0018\u00010\f*\u00020(H\u0082\u0010J'\u0010p\u001a\b\u0012\u0004\u0012\u0002Hq0h\"\u0004\b\u0000\u0010q2\f\u0010r\u001a\b\u0012\u0004\u0012\u0002Hq0hH\u0000¢\u0006\u0002\bsJ\u0012\u0010t\u001a\u00020u*\b\u0012\u0004\u0012\u00020\u00050BH\u0002J,\u0010v\u001a\b\u0012\u0004\u0012\u0002Hq0h\"\u0004\b\u0000\u0010q2\f\u0010r\u001a\b\u0012\u0004\u0012\u0002Hq0h2\b\u0010g\u001a\u0004\u0018\u00010uH\u0002J\u0014\u0010w\u001a\u00020%2\n\u0010o\u001a\u0006\u0012\u0002\b\u00030\fH\u0002J%\u0010x\u001a\b\u0012\u0004\u0012\u00020\u00050B\"\b\b\u0000\u0010q*\u00020y2\u0006\u0010z\u001a\u0002HqH\u0002¢\u0006\u0002\u0010{R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f\u0012\u0004\u0012\u00020\r0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u000e\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\t\u0010\u0012\u001a\u00020\u0013X\u0082\u0004R\u0011\u0010\u0014\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\t\u0010\u0017\u001a\u00020\u0018X\u0082\u0004R\u001a\u0010\u0019\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0016\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0016\"\u0004\b\u001f\u0010\u001cR\u001a\u0010 \u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0016\"\u0004\b\"\u0010\u001cR\u001c\u0010#\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020%\u0018\u00010$X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010<\u001a\u000201*\u0002038BX\u0082\u0004¢\u0006\f\u0012\u0004\b=\u0010>\u001a\u0004\b?\u0010@R\u0018\u0010|\u001a\u00020\r*\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}¨\u0006\u007f"}, m4988d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", BuildConfig.f24315FLAVOR, "<init>", "()V", "ARTIFICIAL_FRAME", "Ljava/lang/StackTraceElement;", "dateFormat", "Ljava/text/SimpleDateFormat;", "weakRefCleanerThread", "Ljava/lang/Thread;", "capturedCoroutinesMap", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", BuildConfig.f24315FLAVOR, "capturedCoroutines", BuildConfig.f24315FLAVOR, "getCapturedCoroutines", "()Ljava/util/Set;", "installations", "Lkotlinx/atomicfu/AtomicInt;", "isInstalled", "isInstalled$kotlinx_coroutines_debug", "()Z", "sequenceNumber", "Lkotlinx/atomicfu/AtomicLong;", "sanitizeStackTraces", "getSanitizeStackTraces$kotlinx_coroutines_core", "setSanitizeStackTraces$kotlinx_coroutines_core", "(Z)V", "enableCreationStackTraces", "getEnableCreationStackTraces$kotlinx_coroutines_core", "setEnableCreationStackTraces$kotlinx_coroutines_core", "ignoreCoroutinesWithEmptyContext", "getIgnoreCoroutinesWithEmptyContext", "setIgnoreCoroutinesWithEmptyContext", "dynamicAttach", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "getDynamicAttach", "callerInfoCache", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "install", "install$kotlinx_coroutines_core", "uninstall", "uninstall$kotlinx_coroutines_core", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "hierarchyToString", BuildConfig.f24315FLAVOR, "job", "Lkotlinx/coroutines/Job;", "hierarchyToString$kotlinx_coroutines_core", "build", "map", BuildConfig.f24315FLAVOR, "builder", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "indent", "debugString", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "getDebugString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "dumpCoroutinesInfoImpl", BuildConfig.f24315FLAVOR, "R", "create", "Lkotlin/Function2;", "Lkotlin/coroutines/CoroutineContext;", "dumpCoroutinesInfoAsJsonAndReferences", BuildConfig.f24315FLAVOR, "()[Ljava/lang/Object;", "enhanceStackTraceWithThreadDumpAsJson", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "toStringRepr", "dumpCoroutinesInfo", "dumpDebuggerInfo", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpCoroutines", "out", "Ljava/io/PrintStream;", "isFinished", "dumpCoroutinesSynchronized", "printStackTrace", "frames", "enhanceStackTraceWithThreadDump", "coroutineTrace", "enhanceStackTraceWithThreadDumpImpl", "state", "thread", "findContinuationStartIndex", "Lkotlin/Pair;", BuildConfig.f24315FLAVOR, "indexOfResumeWith", "actualTrace", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "findIndexOfFrame", "frameIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "probeCoroutineResumed", "frame", "Lkotlin/coroutines/Continuation;", "probeCoroutineResumed$kotlinx_coroutines_core", "probeCoroutineSuspended", "probeCoroutineSuspended$kotlinx_coroutines_core", "updateState", "updateRunningState", "realCaller", "owner", "probeCoroutineCreated", "T", "completion", "probeCoroutineCreated$kotlinx_coroutines_core", "toStackTraceFrame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "createOwner", "probeCoroutineCompleted", "sanitizeStackTrace", BuildConfig.f24315FLAVOR, "throwable", "(Ljava/lang/Throwable;)Ljava/util/List;", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "CoroutineOwner", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@PublishedApi
@SourceDebugExtension(m6344value = {"SMAP\nDebugProbesImpl.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n+ 4 _Sequences.kt\nkotlin/sequences/SequencesKt___SequencesKt\n+ 5 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 6 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,623:1\n154#1:641\n155#1,4:643\n160#1,5:648\n154#1:653\n155#1,4:655\n160#1,5:660\n1#2:624\n1#2:642\n1#2:654\n774#3:625\n865#3,2:626\n1222#3,2:628\n1252#3,4:630\n1869#3,2:668\n360#3,7:676\n1833#3,8:683\n608#4:634\n608#4:647\n608#4:659\n608#4:665\n1321#4,2:666\n37#5,2:635\n37#5,2:637\n37#5,2:639\n1772#6,6:670\n1880#6,6:691\n*S KotlinDebug\n*F\n+ 1 DebugProbesImpl.kt\nkotlinx/coroutines/debug/internal/DebugProbesImpl\n*L\n248#1:641\n248#1:643,4\n248#1:648,5\n255#1:653\n255#1:655,4\n255#1:660,5\n248#1:642\n255#1:654\n114#1:625\n114#1:626,2\n115#1:628,2\n115#1:630,4\n310#1:668,2\n419#1:676,7\n509#1:683,8\n158#1:634\n248#1:647\n255#1:659\n290#1:665\n291#1:666,2\n214#1:635,2\n215#1:637,2\n216#1:639,2\n358#1:670,6\n561#1:691,6\n*E\n"})
/* loaded from: classes.dex */
public final class DebugProbesImpl {
    private static final StackTraceElement ARTIFICIAL_FRAME;
    public static final DebugProbesImpl INSTANCE;
    private static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfo> callerInfoCache;
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> capturedCoroutinesMap;
    private static final SimpleDateFormat dateFormat;
    private static final Function1<Boolean, C1133Unit> dynamicAttach;
    private static boolean enableCreationStackTraces;
    private static boolean ignoreCoroutinesWithEmptyContext;
    private static final /* synthetic */ AtomicInteger installations;
    private static boolean sanitizeStackTraces;
    private static final /* synthetic */ AtomicLong sequenceNumber;
    private static Thread weakRefCleanerThread;

    @Metadata(m4987d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\u001f\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001b\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\r\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0019\u001a\u00020\u001aX\u0096\u0005¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001d"}, m4988d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "<init>", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;)V", "frame", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "getFrame", "()Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", BuildConfig.f24315FLAVOR, "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", BuildConfig.f24315FLAVOR, "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {

        @JvmField
        public final Continuation<T> delegate;

        @JvmField
        public final DebugCoroutineInfo info;

        /* JADX WARN: Multi-variable type inference failed */
        public CoroutineOwner(Continuation<? super T> continuation, DebugCoroutineInfo debugCoroutineInfoImpl) {
            this.delegate = continuation;
            this.info = debugCoroutineInfoImpl;
        }

        private final StackTraceFrame getFrame() {
            return this.info.getCreationStackBottom();
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.CoroutineStackFrame
        public CoroutineStackFrame getCallerFrame() {
            StackTraceFrame frame = getFrame();
            if (frame != null) {
                return frame.getCallerFrame();
            }
            return null;
        }

        @Override // p094kotlin.coroutines.Continuation
        /* renamed from: getContext */
        public CoroutineContext get$context() {
            return this.delegate.get$context();
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.CoroutineStackFrame
        public StackTraceElement getStackTraceElement() {
            StackTraceFrame frame = getFrame();
            if (frame != null) {
                return frame.getStackTraceElement();
            }
            return null;
        }

        @Override // p094kotlin.coroutines.Continuation
        public void resumeWith(Object result) {
            DebugProbesImpl.INSTANCE.probeCoroutineCompleted(this);
            this.delegate.resumeWith(result);
        }

        public String toString() {
            return this.delegate.toString();
        }
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        INSTANCE = debugProbesImpl;
        ARTIFICIAL_FRAME = new C3678fFz().m11902AZxh();
        dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        capturedCoroutinesMap = new ConcurrentWeakMap<>(false, 1, null);
        installations = new AtomicInteger(0);
        sequenceNumber = new AtomicLong(0L);
        sanitizeStackTraces = true;
        ignoreCoroutinesWithEmptyContext = true;
        dynamicAttach = debugProbesImpl.getDynamicAttach();
        callerInfoCache = new ConcurrentWeakMap<>(true);
    }

    private DebugProbesImpl() {
    }

    /* renamed from: build */
    private final void m7175build(InterfaceC1342Job interfaceC1342Job, Map<InterfaceC1342Job, DebugCoroutineInfo> map, StringBuilder sb, String str) {
        DebugCoroutineInfo debugCoroutineInfoImpl = map.get(interfaceC1342Job);
        if (debugCoroutineInfoImpl != null) {
            StackTraceElement stackTraceElement = (StackTraceElement) CollectionsKt.firstOrNull((List) debugCoroutineInfoImpl.lastObservedStackTrace$kotlinx_coroutines_core());
            sb.append(str + getDebugString(interfaceC1342Job) + ", continuation is " + debugCoroutineInfoImpl.get_state() + " at line " + stackTraceElement + '\n');
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append('\t');
            str = sb2.toString();
        } else if (!(interfaceC1342Job instanceof ScopeCoroutine)) {
            sb.append(str + getDebugString(interfaceC1342Job) + '\n');
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append('\t');
            str = sb3.toString();
        }
        Iterator<InterfaceC1342Job> it = interfaceC1342Job.getChildren().iterator();
        while (it.hasNext()) {
            m7175build(it.next(), map, sb, str);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final <T> Continuation<T> createOwner(Continuation<? super T> completion, StackTraceFrame frame) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return completion;
        }
        CoroutineOwner<?> coroutineOwner = new CoroutineOwner<>(completion, new DebugCoroutineInfo(completion.get$context(), frame, getSequenceNumber().incrementAndGet()));
        ConcurrentWeakMap<CoroutineOwner<?>, Boolean> concurrentWeakMap = capturedCoroutinesMap;
        concurrentWeakMap.put(coroutineOwner, Boolean.TRUE);
        if (!isInstalled$kotlinx_coroutines_debug()) {
            concurrentWeakMap.clear();
        }
        return coroutineOwner;
    }

    private final <R> List<R> dumpCoroutinesInfoImpl(final Function2<? super CoroutineOwner<?>, ? super CoroutineContext, ? extends R> create) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.m6639toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new Function1<CoroutineOwner<?>, R>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfoImpl.3
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final R mo2237invoke(CoroutineOwner<?> coroutineOwner) {
                    CoroutineContext context;
                    if (DebugProbesImpl.INSTANCE.isFinished(coroutineOwner) || (context = coroutineOwner.info.getContext()) == null) {
                        return null;
                    }
                    return create.mo2167invoke(coroutineOwner, context);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    private final void dumpCoroutinesSynchronized(PrintStream out) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            throw new IllegalStateException("Debug probes are not installed");
        }
        out.print("Coroutines dump " + dateFormat.format(Long.valueOf(System.currentTimeMillis())));
        for (CoroutineOwner coroutineOwner : SequencesKt.sortedWith(SequencesKt.m6596filter(CollectionsKt.asSequence(getCapturedCoroutines()), new Function1() { // from class: o.YfFg
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return Boolean.valueOf(DebugProbesImpl.dumpCoroutinesSynchronized$lambda$1((DebugProbesImpl.CoroutineOwner) obj));
            }
        }), new Comparator() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                return ComparisonsKt.compareValues(Long.valueOf(((DebugProbesImpl.CoroutineOwner) t).info.sequenceNumber), Long.valueOf(((DebugProbesImpl.CoroutineOwner) t2).info.sequenceNumber));
            }
        })) {
            DebugCoroutineInfo debugCoroutineInfoImpl = coroutineOwner.info;
            List<StackTraceElement> listLastObservedStackTrace$kotlinx_coroutines_core = debugCoroutineInfoImpl.lastObservedStackTrace$kotlinx_coroutines_core();
            DebugProbesImpl debugProbesImpl = INSTANCE;
            List<StackTraceElement> listEnhanceStackTraceWithThreadDumpImpl = debugProbesImpl.enhanceStackTraceWithThreadDumpImpl(debugCoroutineInfoImpl.get_state(), debugCoroutineInfoImpl.lastObservedThread, listLastObservedStackTrace$kotlinx_coroutines_core);
            out.print("\n\nCoroutine " + coroutineOwner.delegate + ", state: " + ((Intrinsics.areEqual(debugCoroutineInfoImpl.get_state(), DebugCoroutineInfoImplKt.f6042RUNNING) && listEnhanceStackTraceWithThreadDumpImpl == listLastObservedStackTrace$kotlinx_coroutines_core) ? debugCoroutineInfoImpl.get_state() + " (Last suspension stacktrace, not an actual stacktrace)" : debugCoroutineInfoImpl.get_state()));
            if (listLastObservedStackTrace$kotlinx_coroutines_core.isEmpty()) {
                out.print("\n\tat " + ARTIFICIAL_FRAME);
                debugProbesImpl.printStackTrace(out, debugCoroutineInfoImpl.getCreationStackTrace());
            } else {
                debugProbesImpl.printStackTrace(out, listEnhanceStackTraceWithThreadDumpImpl);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean dumpCoroutinesSynchronized$lambda$1(CoroutineOwner coroutineOwner) {
        return !INSTANCE.isFinished(coroutineOwner);
    }

    private final List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl(String state, Thread thread, List<StackTraceElement> coroutineTrace) {
        Object objM18546constructorimpl;
        if (!Intrinsics.areEqual(state, DebugCoroutineInfoImplKt.f6042RUNNING) || thread == null) {
            return coroutineTrace;
        }
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(thread.getStackTrace());
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
        }
        if (C1124Result.m18552isFailureimpl(objM18546constructorimpl)) {
            objM18546constructorimpl = null;
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) objM18546constructorimpl;
        if (stackTraceElementArr == null) {
            return coroutineTrace;
        }
        int length = stackTraceElementArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                i = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i];
            if (Intrinsics.areEqual(stackTraceElement.getClassName(), "kotlin.coroutines.jvm.internal.BaseContinuationImpl") && Intrinsics.areEqual(stackTraceElement.getMethodName(), "resumeWith") && Intrinsics.areEqual(stackTraceElement.getFileName(), "ContinuationImpl.kt")) {
                break;
            }
            i++;
        }
        C1122Pair<Integer, Integer> c1122PairFindContinuationStartIndex = findContinuationStartIndex(i, stackTraceElementArr, coroutineTrace);
        int iIntValue = c1122PairFindContinuationStartIndex.component1().intValue();
        int iIntValue2 = c1122PairFindContinuationStartIndex.component2().intValue();
        if (iIntValue == -1) {
            return coroutineTrace;
        }
        ArrayList arrayList = new ArrayList((((coroutineTrace.size() + i) - iIntValue) - 1) - iIntValue2);
        int i2 = i - iIntValue2;
        for (int i3 = 0; i3 < i2; i3++) {
            arrayList.add(stackTraceElementArr[i3]);
        }
        int size = coroutineTrace.size();
        for (int i4 = iIntValue + 1; i4 < size; i4++) {
            arrayList.add(coroutineTrace.get(i4));
        }
        return arrayList;
    }

    private final C1122Pair<Integer, Integer> findContinuationStartIndex(int indexOfResumeWith, StackTraceElement[] actualTrace, List<StackTraceElement> coroutineTrace) {
        for (int i = 0; i < 3; i++) {
            int iFindIndexOfFrame = INSTANCE.findIndexOfFrame((indexOfResumeWith - 1) - i, actualTrace, coroutineTrace);
            if (iFindIndexOfFrame != -1) {
                return TuplesKt.m5076to(Integer.valueOf(iFindIndexOfFrame), Integer.valueOf(i));
            }
        }
        return TuplesKt.m5076to(-1, 0);
    }

    private final int findIndexOfFrame(int frameIndex, StackTraceElement[] actualTrace, List<StackTraceElement> coroutineTrace) {
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt.getOrNull(actualTrace, frameIndex);
        if (stackTraceElement == null) {
            return -1;
        }
        int i = 0;
        for (StackTraceElement stackTraceElement2 : coroutineTrace) {
            if (Intrinsics.areEqual(stackTraceElement2.getFileName(), stackTraceElement.getFileName()) && Intrinsics.areEqual(stackTraceElement2.getClassName(), stackTraceElement.getClassName()) && Intrinsics.areEqual(stackTraceElement2.getMethodName(), stackTraceElement.getMethodName())) {
                return i;
            }
            i++;
        }
        return -1;
    }

    private final Set<CoroutineOwner<?>> getCapturedCoroutines() {
        return capturedCoroutinesMap.keySet();
    }

    private final String getDebugString(InterfaceC1342Job interfaceC1342Job) {
        return interfaceC1342Job instanceof JobSupport ? ((JobSupport) interfaceC1342Job).toDebugString() : interfaceC1342Job.toString();
    }

    private static /* synthetic */ void getDebugString$annotations(InterfaceC1342Job interfaceC1342Job) {
    }

    private final Function1<Boolean, C1133Unit> getDynamicAttach() {
        try {
            Object objNewInstance = Class.forName("kotlinx.coroutines.debug.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(null);
            Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
            return (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(objNewInstance, 1);
        } catch (Throwable unused) {
            return null;
        }
    }

    private final /* synthetic */ AtomicInteger getInstallations() {
        return installations;
    }

    private final /* synthetic */ AtomicLong getSequenceNumber() {
        return sequenceNumber;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isFinished(CoroutineOwner<?> coroutineOwner) {
        InterfaceC1342Job interfaceC1342Job;
        CoroutineContext context = coroutineOwner.info.getContext();
        if (context == null || (interfaceC1342Job = (InterfaceC1342Job) context.mo6098get(InterfaceC1342Job.INSTANCE)) == null || !interfaceC1342Job.isCompleted()) {
            return false;
        }
        capturedCoroutinesMap.remove(coroutineOwner);
        return true;
    }

    private final boolean isInternalMethod(StackTraceElement stackTraceElement) {
        return StringsKt.startsWith$default(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, (Object) null);
    }

    /* renamed from: owner */
    private final CoroutineOwner<?> m7177owner(Continuation<?> continuation) {
        CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
        if (coroutineStackFrame != null) {
            return m7178owner(coroutineStackFrame);
        }
        return null;
    }

    private final void printStackTrace(PrintStream out, List<StackTraceElement> frames) {
        Iterator<T> it = frames.iterator();
        while (it.hasNext()) {
            out.print("\n\tat " + ((StackTraceElement) it.next()));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void probeCoroutineCompleted(CoroutineOwner<?> owner) {
        CoroutineStackFrame coroutineStackFrameRealCaller;
        capturedCoroutinesMap.remove(owner);
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = owner.info.getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core == null || (coroutineStackFrameRealCaller = realCaller(lastObservedFrame$kotlinx_coroutines_core)) == null) {
            return;
        }
        callerInfoCache.remove(coroutineStackFrameRealCaller);
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    private final <T extends Throwable> List<StackTraceElement> sanitizeStackTrace(T throwable) {
        StackTraceElement[] stackTrace = throwable.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i2 = length2 - 1;
                if (Intrinsics.areEqual(stackTrace[length2].getClassName(), "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i = length2;
                    break;
                }
                if (i2 < 0) {
                    break;
                }
                length2 = i2;
            }
        }
        int i3 = i + 1;
        if (!sanitizeStackTraces) {
            int i4 = length - i3;
            ArrayList arrayList = new ArrayList(i4);
            for (int i5 = 0; i5 < i4; i5++) {
                arrayList.add(stackTrace[i5 + i3]);
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i3) + 1);
        while (i3 < length) {
            if (isInternalMethod(stackTrace[i3])) {
                arrayList2.add(stackTrace[i3]);
                int i6 = i3 + 1;
                while (i6 < length && isInternalMethod(stackTrace[i6])) {
                    i6++;
                }
                int i7 = i6 - 1;
                int i8 = i7;
                while (i8 > i3 && stackTrace[i8].getFileName() == null) {
                    i8--;
                }
                if (i8 > i3 && i8 < i7) {
                    arrayList2.add(stackTrace[i8]);
                }
                arrayList2.add(stackTrace[i7]);
                i3 = i6;
            } else {
                arrayList2.add(stackTrace[i3]);
                i3++;
            }
        }
        return arrayList2;
    }

    private final void startWeakRefCleanerThread() {
        Thread thread = new Thread(new Runnable() { // from class: o.SrJcM
            @Override // java.lang.Runnable
            public final void run() {
                DebugProbesImpl.startWeakRefCleanerThread$lambda$0();
            }
        }, "Coroutines Debugger Cleaner");
        weakRefCleanerThread = thread;
        thread.setDaemon(true);
        thread.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void startWeakRefCleanerThread$lambda$0() {
        callerInfoCache.runWeakRefQueueCleaningLoopUntilInterrupted();
    }

    private final void stopWeakRefCleanerThread() throws InterruptedException {
        Thread thread = weakRefCleanerThread;
        if (thread == null) {
            return;
        }
        weakRefCleanerThread = null;
        thread.interrupt();
        thread.join();
    }

    private final StackTraceFrame toStackTraceFrame(List<StackTraceElement> list) {
        StackTraceFrame stackTraceFrame = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                stackTraceFrame = new StackTraceFrame(stackTraceFrame, listIterator.previous());
            }
        }
        return new StackTraceFrame(stackTraceFrame, ARTIFICIAL_FRAME);
    }

    private final String toStringRepr(Object obj) {
        return DebugProbesImplKt.m7179repr(obj.toString());
    }

    private final void updateRunningState(CoroutineStackFrame frame, String state) {
        boolean z;
        if (isInstalled$kotlinx_coroutines_debug()) {
            ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfo> concurrentWeakMap = callerInfoCache;
            DebugCoroutineInfo debugCoroutineInfoImplRemove = concurrentWeakMap.remove(frame);
            if (debugCoroutineInfoImplRemove != null) {
                z = false;
            } else {
                CoroutineOwner<?> coroutineOwnerM7178owner = m7178owner(frame);
                if (coroutineOwnerM7178owner == null || (debugCoroutineInfoImplRemove = coroutineOwnerM7178owner.info) == null) {
                    return;
                }
                CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = debugCoroutineInfoImplRemove.getLastObservedFrame$kotlinx_coroutines_core();
                CoroutineStackFrame coroutineStackFrameRealCaller = lastObservedFrame$kotlinx_coroutines_core != null ? realCaller(lastObservedFrame$kotlinx_coroutines_core) : null;
                if (coroutineStackFrameRealCaller != null) {
                    concurrentWeakMap.remove(coroutineStackFrameRealCaller);
                }
                z = true;
            }
            Intrinsics.checkNotNull(frame, "null cannot be cast to non-null type kotlin.coroutines.Continuation<*>");
            debugCoroutineInfoImplRemove.updateState$kotlinx_coroutines_core(state, (Continuation) frame, z);
            CoroutineStackFrame coroutineStackFrameRealCaller2 = realCaller(frame);
            if (coroutineStackFrameRealCaller2 == null) {
                return;
            }
            concurrentWeakMap.put(coroutineStackFrameRealCaller2, debugCoroutineInfoImplRemove);
        }
    }

    private final void updateState(Continuation<?> frame, String state) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            if (ignoreCoroutinesWithEmptyContext && frame.get$context() == EmptyCoroutineContext.INSTANCE) {
                return;
            }
            if (Intrinsics.areEqual(state, DebugCoroutineInfoImplKt.f6042RUNNING)) {
                CoroutineStackFrame coroutineStackFrame = frame instanceof CoroutineStackFrame ? (CoroutineStackFrame) frame : null;
                if (coroutineStackFrame == null) {
                    return;
                }
                updateRunningState(coroutineStackFrame, state);
                return;
            }
            CoroutineOwner<?> coroutineOwnerM7177owner = m7177owner(frame);
            if (coroutineOwnerM7177owner == null) {
                return;
            }
            updateState(coroutineOwnerM7177owner, frame, state);
        }
    }

    @InterfaceC1231JvmName(m6260name = "dumpCoroutines")
    public final void dumpCoroutines(PrintStream out) {
        synchronized (out) {
            INSTANCE.dumpCoroutinesSynchronized(out);
            C1133Unit c1133Unit = C1133Unit.INSTANCE;
        }
    }

    public final List<DebugCoroutineInfo> dumpCoroutinesInfo() {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.m6639toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new Function1<CoroutineOwner<?>, DebugCoroutineInfo>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final DebugCoroutineInfo mo2237invoke(DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
                    CoroutineContext context;
                    if (DebugProbesImpl.INSTANCE.isFinished(coroutineOwner) || (context = coroutineOwner.info.getContext()) == null) {
                        return null;
                    }
                    return new DebugCoroutineInfo(coroutineOwner.info, context);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    public final Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        String strM6954getName;
        List<DebugCoroutineInfo> listDumpCoroutinesInfo = dumpCoroutinesInfo();
        int size = listDumpCoroutinesInfo.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList(size);
        for (DebugCoroutineInfo debugCoroutineInfo : listDumpCoroutinesInfo) {
            CoroutineContext context = debugCoroutineInfo.getContext();
            CoroutineName coroutineName = (CoroutineName) context.mo6098get(CoroutineName.INSTANCE);
            Long lValueOf = null;
            String stringRepr = (coroutineName == null || (strM6954getName = coroutineName.m6954getName()) == null) ? null : toStringRepr(strM6954getName);
            ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) context.mo6098get(ContinuationInterceptor.INSTANCE);
            String stringRepr2 = continuationInterceptor != null ? toStringRepr(continuationInterceptor) : null;
            StringBuilder sb = new StringBuilder();
            sb.append("\n                {\n                    \"name\": ");
            sb.append(stringRepr);
            sb.append(",\n                    \"id\": ");
            CoroutineId coroutineId = (CoroutineId) context.mo6098get(CoroutineId.INSTANCE);
            if (coroutineId != null) {
                lValueOf = Long.valueOf(coroutineId.m6951getId());
            }
            sb.append(lValueOf);
            sb.append(",\n                    \"dispatcher\": ");
            sb.append(stringRepr2);
            sb.append(",\n                    \"sequenceNumber\": ");
            sb.append(debugCoroutineInfo.getSequenceNumber());
            sb.append(",\n                    \"state\": \"");
            sb.append(debugCoroutineInfo.getState());
            sb.append("\"\n                }\n                ");
            arrayList3.add(StringsKt.trimIndent(sb.toString()));
            arrayList2.add(debugCoroutineInfo.getLastObservedFrame());
            arrayList.add(debugCoroutineInfo.getLastObservedThread());
        }
        return new Object[]{'[' + CollectionsKt.joinToString$default(arrayList3, null, null, null, 0, null, null, 63, null) + ']', arrayList.toArray(new Thread[0]), arrayList2.toArray(new CoroutineStackFrame[0]), listDumpCoroutinesInfo.toArray(new DebugCoroutineInfo[0])};
    }

    public final List<DebuggerInfo> dumpDebuggerInfo() {
        if (isInstalled$kotlinx_coroutines_debug()) {
            return SequencesKt.m6639toList(SequencesKt.mapNotNull(SequencesKt.sortedWith(CollectionsKt.asSequence(getCapturedCoroutines()), new DebugProbesImpl$dumpCoroutinesInfoImpl$$inlined$sortedBy$1()), new Function1<CoroutineOwner<?>, DebuggerInfo>() { // from class: kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
                public final DebuggerInfo mo2237invoke(DebugProbesImpl.CoroutineOwner<?> coroutineOwner) {
                    CoroutineContext context;
                    if (DebugProbesImpl.INSTANCE.isFinished(coroutineOwner) || (context = coroutineOwner.info.getContext()) == null) {
                        return null;
                    }
                    return new DebuggerInfo(coroutineOwner.info, context);
                }
            }));
        }
        throw new IllegalStateException("Debug probes are not installed");
    }

    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(DebugCoroutineInfo info, List<StackTraceElement> coroutineTrace) {
        return enhanceStackTraceWithThreadDumpImpl(info.getState(), info.getLastObservedThread(), coroutineTrace);
    }

    public final String enhanceStackTraceWithThreadDumpAsJson(DebugCoroutineInfo info) {
        List<StackTraceElement> listEnhanceStackTraceWithThreadDump = enhanceStackTraceWithThreadDump(info, info.lastObservedStackTrace());
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement stackTraceElement : listEnhanceStackTraceWithThreadDump) {
            StringBuilder sb = new StringBuilder();
            sb.append("\n                {\n                    \"declaringClass\": \"");
            sb.append(stackTraceElement.getClassName());
            sb.append("\",\n                    \"methodName\": \"");
            sb.append(stackTraceElement.getMethodName());
            sb.append("\",\n                    \"fileName\": ");
            String fileName = stackTraceElement.getFileName();
            sb.append(fileName != null ? toStringRepr(fileName) : null);
            sb.append(",\n                    \"lineNumber\": ");
            sb.append(stackTraceElement.getLineNumber());
            sb.append("\n                }\n                ");
            arrayList.add(StringsKt.trimIndent(sb.toString()));
        }
        return '[' + CollectionsKt.joinToString$default(arrayList, null, null, null, 0, null, null, 63, null) + ']';
    }

    public final boolean getEnableCreationStackTraces$kotlinx_coroutines_core() {
        return enableCreationStackTraces;
    }

    public final boolean getIgnoreCoroutinesWithEmptyContext() {
        return ignoreCoroutinesWithEmptyContext;
    }

    public final boolean getSanitizeStackTraces$kotlinx_coroutines_core() {
        return sanitizeStackTraces;
    }

    public final String hierarchyToString$kotlinx_coroutines_core(InterfaceC1342Job job) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            throw new IllegalStateException("Debug probes are not installed");
        }
        Set<CoroutineOwner<?>> capturedCoroutines = getCapturedCoroutines();
        ArrayList<CoroutineOwner> arrayList = new ArrayList();
        for (Object obj : capturedCoroutines) {
            if (((CoroutineOwner) obj).delegate.get$context().mo6098get(InterfaceC1342Job.INSTANCE) != null) {
                arrayList.add(obj);
            }
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(C1155MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(arrayList, 10)), 16));
        for (CoroutineOwner coroutineOwner : arrayList) {
            linkedHashMap.put(C1344JobKt.m7015getJob(coroutineOwner.delegate.get$context()), coroutineOwner.info);
        }
        StringBuilder sb = new StringBuilder();
        INSTANCE.m7175build(job, linkedHashMap, sb, BuildConfig.f24315FLAVOR);
        return sb.toString();
    }

    public final void install$kotlinx_coroutines_core() {
        Function1<Boolean, C1133Unit> function1;
        if (getInstallations().incrementAndGet() > 1) {
            return;
        }
        startWeakRefCleanerThread();
        if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() || (function1 = dynamicAttach) == null) {
            return;
        }
        function1.mo2237invoke(Boolean.TRUE);
    }

    @InterfaceC1231JvmName(m6260name = "isInstalled$kotlinx_coroutines_debug")
    public final boolean isInstalled$kotlinx_coroutines_debug() {
        return getInstallations().get() > 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(Continuation<? super T> completion) {
        if (!isInstalled$kotlinx_coroutines_debug()) {
            return completion;
        }
        if (!(ignoreCoroutinesWithEmptyContext && completion.get$context() == EmptyCoroutineContext.INSTANCE) && m7177owner(completion) == null) {
            return createOwner(completion, enableCreationStackTraces ? toStackTraceFrame(sanitizeStackTrace(new Exception())) : null);
        }
        return completion;
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(Continuation<?> frame) {
        updateState(frame, DebugCoroutineInfoImplKt.f6042RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(Continuation<?> frame) {
        updateState(frame, DebugCoroutineInfoImplKt.SUSPENDED);
    }

    public final void setEnableCreationStackTraces$kotlinx_coroutines_core(boolean z) {
        enableCreationStackTraces = z;
    }

    public final void setIgnoreCoroutinesWithEmptyContext(boolean z) {
        ignoreCoroutinesWithEmptyContext = z;
    }

    public final void setSanitizeStackTraces$kotlinx_coroutines_core(boolean z) {
        sanitizeStackTraces = z;
    }

    public final void uninstall$kotlinx_coroutines_core() throws InterruptedException {
        Function1<Boolean, C1133Unit> function1;
        if (!isInstalled$kotlinx_coroutines_debug()) {
            throw new IllegalStateException("Agent was not installed");
        }
        if (getInstallations().decrementAndGet() != 0) {
            return;
        }
        stopWeakRefCleanerThread();
        capturedCoroutinesMap.clear();
        callerInfoCache.clear();
        if (AgentInstallationType.INSTANCE.isInstalledStatically$kotlinx_coroutines_core() || (function1 = dynamicAttach) == null) {
            return;
        }
        function1.mo2237invoke(Boolean.FALSE);
    }

    /* renamed from: owner */
    private final CoroutineOwner<?> m7178owner(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof CoroutineOwner)) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        }
        return (CoroutineOwner) coroutineStackFrame;
    }

    private final void updateState(CoroutineOwner<?> owner, Continuation<?> frame, String state) {
        if (isInstalled$kotlinx_coroutines_debug()) {
            owner.info.updateState$kotlinx_coroutines_core(state, frame, true);
        }
    }
}
