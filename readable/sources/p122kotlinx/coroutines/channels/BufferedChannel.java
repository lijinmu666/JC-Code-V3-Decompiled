package p122kotlinx.coroutines.channels;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.ExceptionsKt;
import p094kotlin.Metadata;
import p094kotlin.ReplaceWith;
import p094kotlin.ResultKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.C1207Boxing;
import p094kotlin.coroutines.p097jvm.internal.DebugProbesKt;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.internal.LowPriorityInOverloadResolution;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.functions.Function4;
import p094kotlin.p105jvm.internal.DefaultConstructorMarker;
import p094kotlin.p105jvm.internal.FunctionReferenceImpl;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.LongCompanionObject;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p105jvm.internal.TypeIntrinsics;
import p094kotlin.p113reflect.KFunction;
import p094kotlin.p117text.StringsKt;
import p094kotlin.p119time.DurationKt;
import p122kotlinx.coroutines.CancellableContinuation;
import p122kotlinx.coroutines.CancellableContinuationImpl;
import p122kotlinx.coroutines.CancellableContinuationKt;
import p122kotlinx.coroutines.DebugStringsKt;
import p122kotlinx.coroutines.ExperimentalCoroutinesApi;
import p122kotlinx.coroutines.InterfaceC1348Waiter;
import p122kotlinx.coroutines.channels.BufferedChannel;
import p122kotlinx.coroutines.internal.AbstractC1577Segment;
import p122kotlinx.coroutines.internal.C1578Symbol;
import p122kotlinx.coroutines.internal.ConcurrentLinkedListKt;
import p122kotlinx.coroutines.internal.ConcurrentLinkedListNode;
import p122kotlinx.coroutines.internal.InlineList;
import p122kotlinx.coroutines.internal.OnUndeliveredElementKt;
import p122kotlinx.coroutines.internal.SegmentOrClosed;
import p122kotlinx.coroutines.internal.StackTraceRecoveryKt;
import p122kotlinx.coroutines.internal.UndeliveredElementException;
import p122kotlinx.coroutines.p127selects.SelectClause1;
import p122kotlinx.coroutines.p127selects.SelectClause1Impl;
import p122kotlinx.coroutines.p127selects.SelectClause2;
import p122kotlinx.coroutines.p127selects.SelectClause2Impl;
import p122kotlinx.coroutines.p127selects.SelectImplementation;
import p122kotlinx.coroutines.p127selects.SelectInstance;
import p122kotlinx.coroutines.p127selects.TrySelectDetailedResult;
import p131o.AbstractC1852Dt;

@Metadata(m4987d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b1\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0010\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002:\u0004ê\u0001ë\u0001B3\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\"\b\u0002\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b¢\u0006\u0004\b\t\u0010\nJ\u0016\u0010 \u001a\u00020\u00072\u0006\u0010!\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010\"J\u0016\u0010#\u001a\u00020\u00072\u0006\u0010!\u001a\u00028\u0000H\u0082@¢\u0006\u0002\u0010\"J4\u0010$\u001a\u00020\u00072\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00028\u00002\u0006\u0010'\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010(J\"\u0010)\u001a\u00020\u0007*\u00020*2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u0004H\u0002J#\u0010+\u001a\u00020\u00072\u0006\u0010!\u001a\u00028\u00002\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070-H\u0002¢\u0006\u0002\u0010.J\u001d\u0010/\u001a\b\u0012\u0004\u0012\u00020\u0007002\u0006\u0010!\u001a\u00028\u0000H\u0016¢\u0006\u0004\b1\u00102J\u0018\u00103\u001a\u00020\u00192\u0006\u0010!\u001a\u00028\u0000H\u0090@¢\u0006\u0004\b4\u0010\"Jê\u0001\u00105\u001a\u0002H6\"\u0004\b\u0001\u001062\u0006\u0010!\u001a\u00028\u00002\b\u00107\u001a\u0004\u0018\u0001082\f\u00109\u001a\b\u0012\u0004\u0012\u0002H60:2<\u0010;\u001a8\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(@\u0012\u0004\u0012\u0002H60<2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H60:2h\b\u0002\u0010B\u001ab\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(@\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b('\u0012\u0004\u0012\u0002H60CH\u0084\b¢\u0006\u0002\u0010DJX\u0010E\u001a\u00020\u00072\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00028\u00002\u0006\u0010'\u001a\u00020\u00102\u0006\u00107\u001a\u00020*2\f\u00109\u001a\b\u0012\u0004\u0012\u00020\u00070:2\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070:H\u0082\b¢\u0006\u0002\u0010FJE\u0010G\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00028\u00002\u0006\u0010'\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010H\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010IJE\u0010J\u001a\u00020\u00042\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010!\u001a\u00028\u00002\u0006\u0010'\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u0001082\u0006\u0010H\u001a\u00020\u0019H\u0002¢\u0006\u0002\u0010IJ\u0010\u0010K\u001a\u00020\u00192\u0006\u0010L\u001a\u00020\u0010H\u0003J\u0010\u0010M\u001a\u00020\u00192\u0006\u0010N\u001a\u00020\u0010H\u0002J\r\u0010K\u001a\u00020\u0019H\u0010¢\u0006\u0002\bOJ\u0019\u0010P\u001a\u00020\u0019*\u0002082\u0006\u0010!\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010QJ\b\u0010R\u001a\u00020\u0007H\u0014J\b\u0010S\u001a\u00020\u0007H\u0014J\u000e\u0010T\u001a\u00028\u0000H\u0096@¢\u0006\u0002\u0010UJ,\u0010V\u001a\u00028\u00002\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u0010H\u0082@¢\u0006\u0002\u0010XJ\"\u0010Y\u001a\u00020\u0007*\u00020*2\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u0004H\u0002J\u0016\u0010Z\u001a\u00020\u00072\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000-H\u0002J\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0096@¢\u0006\u0004\b\\\u0010UJ4\u0010]\u001a\b\u0012\u0004\u0012\u00028\u0000002\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u0010H\u0082@¢\u0006\u0004\b^\u0010XJ\u001c\u0010_\u001a\u00020\u00072\u0012\u0010,\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000-H\u0002J\u0015\u0010`\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0016¢\u0006\u0004\ba\u0010bJ\u0010\u0010c\u001a\u00020\u00072\u0006\u0010d\u001a\u00020\u0010H\u0004J÷\u0001\u0010e\u001a\u0002H6\"\u0004\b\u0001\u001062\b\u00107\u001a\u0004\u0018\u0001082!\u0010f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(!\u0012\u0004\u0012\u0002H60\u00062Q\u0010;\u001aM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(W\u0012\u0004\u0012\u0002H60g2\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H60:2S\b\u0002\u0010B\u001aM\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u001d¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(?\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(@\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(W\u0012\u0004\u0012\u0002H60gH\u0082\b¢\u0006\u0002\u0010hJ`\u0010i\u001a\u00020\u00072\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u00102\u0006\u00107\u001a\u00020*2!\u0010f\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00070:H\u0082\bJ2\u0010j\u001a\u0004\u0018\u0001082\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u000108H\u0002J2\u0010k\u001a\u0004\u0018\u0001082\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010W\u001a\u00020\u00102\b\u00107\u001a\u0004\u0018\u000108H\u0002J\"\u0010l\u001a\u00020\u0019*\u0002082\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u0004H\u0002J\b\u0010m\u001a\u00020\u0007H\u0002J&\u0010n\u001a\u00020\u00192\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010o\u001a\u00020\u0010H\u0002J&\u0010p\u001a\u00020\u00192\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010o\u001a\u00020\u0010H\u0002J\u0012\u0010q\u001a\u00020\u00072\b\b\u0002\u0010r\u001a\u00020\u0010H\u0002J\u0015\u0010s\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u0010H\u0000¢\u0006\u0002\buJ\u001e\u0010|\u001a\u00020\u00072\n\u0010}\u001a\u0006\u0012\u0002\b\u00030~2\b\u0010!\u001a\u0004\u0018\u000108H\u0014J\"\u0010\u007f\u001a\u00020\u00072\u0006\u0010!\u001a\u00028\u00002\n\u0010}\u001a\u0006\u0012\u0002\b\u00030~H\u0002¢\u0006\u0003\u0010\u0080\u0001J!\u0010\u0081\u0001\u001a\u0004\u0018\u0001082\t\u0010\u0082\u0001\u001a\u0004\u0018\u0001082\t\u0010\u0083\u0001\u001a\u0004\u0018\u000108H\u0002J \u0010\u008f\u0001\u001a\u00020\u00072\n\u0010}\u001a\u0006\u0012\u0002\b\u00030~2\t\u0010\u0082\u0001\u001a\u0004\u0018\u000108H\u0002J\u0015\u0010\u0090\u0001\u001a\u00020\u00072\n\u0010}\u001a\u0006\u0012\u0002\b\u00030~H\u0002J!\u0010\u0091\u0001\u001a\u0004\u0018\u0001082\t\u0010\u0082\u0001\u001a\u0004\u0018\u0001082\t\u0010\u0083\u0001\u001a\u0004\u0018\u000108H\u0002J!\u0010\u0092\u0001\u001a\u0004\u0018\u0001082\t\u0010\u0082\u0001\u001a\u0004\u0018\u0001082\t\u0010\u0083\u0001\u001a\u0004\u0018\u000108H\u0002J!\u0010\u0093\u0001\u001a\u0004\u0018\u0001082\t\u0010\u0082\u0001\u001a\u0004\u0018\u0001082\t\u0010\u0083\u0001\u001a\u0004\u0018\u000108H\u0002J\u0011\u0010\u009b\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u009c\u0001H\u0096\u0002J\t\u0010¦\u0001\u001a\u00020\u0007H\u0014J\u0015\u0010§\u0001\u001a\u00020\u00192\n\u0010¨\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0016J\u0013\u0010©\u0001\u001a\u00020\u00192\n\u0010¨\u0001\u001a\u0005\u0018\u00010\u0097\u0001J\u0007\u0010©\u0001\u001a\u00020\u0007J \u0010©\u0001\u001a\u00020\u00072\u0011\u0010¨\u0001\u001a\f\u0018\u00010ª\u0001j\u0005\u0018\u0001`«\u0001¢\u0006\u0003\u0010¬\u0001J\u001b\u0010\u00ad\u0001\u001a\u00020\u00192\n\u0010¨\u0001\u001a\u0005\u0018\u00010\u0097\u0001H\u0010¢\u0006\u0003\b®\u0001J\u001e\u0010¯\u0001\u001a\u00020\u00192\n\u0010¨\u0001\u001a\u0005\u0018\u00010\u0097\u00012\u0007\u0010©\u0001\u001a\u00020\u0019H\u0014J\t\u0010°\u0001\u001a\u00020\u0007H\u0002J1\u0010±\u0001\u001a\u00020\u00072&\u0010²\u0001\u001a!\u0012\u0017\u0012\u0015\u0018\u00010\u0097\u0001¢\u0006\r\b=\u0012\t\b>\u0012\u0005\b\b(¨\u0001\u0012\u0004\u0012\u00020\u00070\u0006H\u0016J\t\u0010³\u0001\u001a\u00020\u0007H\u0002J\t\u0010´\u0001\u001a\u00020\u0007H\u0002J\t\u0010µ\u0001\u001a\u00020\u0007H\u0002J\t\u0010¶\u0001\u001a\u00020\u0007H\u0002J\u0018\u0010¸\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0007\u0010¹\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010º\u0001\u001a\u00020\u00072\u0007\u0010¹\u0001\u001a\u00020\u0010H\u0002J\u000f\u0010»\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0002J\u0018\u0010¼\u0001\u001a\u00020\u00102\r\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0002J\u0018\u0010¾\u0001\u001a\u00020\u00072\r\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0002J \u0010¿\u0001\u001a\u00020\u00072\r\u0010½\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\r\u0010À\u0001\u001a\u00020\u0007*\u00020*H\u0002J\r\u0010Á\u0001\u001a\u00020\u0007*\u00020*H\u0002J\u0016\u0010Â\u0001\u001a\u00020\u0007*\u00020*2\u0007\u0010Ã\u0001\u001a\u00020\u0019H\u0002J\u001b\u0010Ë\u0001\u001a\u00020\u00192\u0007\u0010Ì\u0001\u001a\u00020\u00102\u0007\u0010È\u0001\u001a\u00020\u0019H\u0002J\u000f\u0010Ï\u0001\u001a\u00020\u0019H\u0000¢\u0006\u0003\bÐ\u0001J'\u0010Ñ\u0001\u001a\u00020\u00192\f\u0010%\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0006\u0010&\u001a\u00020\u00042\u0006\u0010t\u001a\u00020\u0010H\u0002J)\u0010Ò\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d2\u0007\u0010Ó\u0001\u001a\u00020\u00102\r\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0002J)\u0010Õ\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d2\u0007\u0010Ó\u0001\u001a\u00020\u00102\r\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0002J2\u0010Ö\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001d2\u0007\u0010Ó\u0001\u001a\u00020\u00102\r\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001d2\u0007\u0010×\u0001\u001a\u00020\u0010H\u0002J!\u0010Ø\u0001\u001a\u00020\u00072\u0007\u0010Ó\u0001\u001a\u00020\u00102\r\u0010Ô\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\u001dH\u0002J\u0012\u0010Ù\u0001\u001a\u00020\u00072\u0007\u0010Ú\u0001\u001a\u00020\u0010H\u0002J\u0012\u0010Û\u0001\u001a\u00020\u00072\u0007\u0010Ú\u0001\u001a\u00020\u0010H\u0002J\n\u0010Ü\u0001\u001a\u00030Ý\u0001H\u0016J\u0010\u0010Þ\u0001\u001a\u00030Ý\u0001H\u0000¢\u0006\u0003\bß\u0001J\u0007\u0010à\u0001\u001a\u00020\u0007Js\u0010á\u0001\u001aR\u0012\u0015\u0012\u00130\u0097\u0001¢\u0006\r\b=\u0012\t\b>\u0012\u0005\b\b(¨\u0001\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u000000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(!\u0012\u0015\u0012\u00130\u0098\u0001¢\u0006\r\b=\u0012\t\b>\u0012\u0005\b\b(ã\u0001\u0012\u0004\u0012\u00020\u00070â\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00028\u0000`\bH\u0002J4\u0010ä\u0001\u001a\u00020\u00072\b\u0010¨\u0001\u001a\u00030\u0097\u00012\f\u0010!\u001a\b\u0012\u0004\u0012\u00028\u0000002\b\u0010ã\u0001\u001a\u00030\u0098\u0001H\u0002¢\u0006\u0006\bå\u0001\u0010æ\u0001JM\u0010ç\u0001\u001a\u001e\u0012\u0005\u0012\u00030\u0097\u0001\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0005\u0012\u00030\u0098\u0001\u0012\u0004\u0012\u00020\u00070g*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00028\u0000`\b2\u0006\u0010!\u001a\u00028\u0000H\u0002¢\u0006\u0003\u0010è\u0001Jm\u0010ç\u0001\u001aL\u0012\u0015\u0012\u00130\u0097\u0001¢\u0006\r\b=\u0012\t\b>\u0012\u0005\b\b(¨\u0001\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(!\u0012\u0015\u0012\u00130\u0098\u0001¢\u0006\r\b=\u0012\t\b>\u0012\u0005\b\b(ã\u0001\u0012\u0004\u0012\u00020\u00070â\u0001*\u0018\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00028\u0000`\bH\u0002J+\u0010é\u0001\u001a\u00020\u00072\b\u0010¨\u0001\u001a\u00030\u0097\u00012\u0006\u0010!\u001a\u00028\u00002\b\u0010ã\u0001\u001a\u00030\u0098\u0001H\u0002¢\u0006\u0003\u0010æ\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u0005\u001a\u001c\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006j\n\u0012\u0004\u0012\u00028\u0000\u0018\u0001`\b8\u0000X\u0081\u0004¢\u0006\u0002\n\u0000R\t\u0010\u000b\u001a\u00020\fX\u0082\u0004R\t\u0010\r\u001a\u00020\fX\u0082\u0004R\t\u0010\u000e\u001a\u00020\fX\u0082\u0004R\u0014\u0010\u000f\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00108@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\u00108BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012R\t\u0010\u0017\u001a\u00020\fX\u0082\u0004R\u0014\u0010\u0018\u001a\u00020\u00198BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u001aR\u0015\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001cX\u0082\u0004R\u0015\u0010\u001e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001cX\u0082\u0004R\u0015\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u001d0\u001cX\u0082\u0004R,\u0010v\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00000w8VX\u0096\u0004¢\u0006\f\u0012\u0004\bx\u0010y\u001a\u0004\bz\u0010{R%\u0010\u0084\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000\u0085\u00018VX\u0096\u0004¢\u0006\u000f\u0012\u0005\b\u0086\u0001\u0010y\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001R+\u0010\u0089\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u0000000\u0085\u00018VX\u0096\u0004¢\u0006\u000f\u0012\u0005\b\u008a\u0001\u0010y\u001a\u0006\b\u008b\u0001\u0010\u0088\u0001R'\u0010\u008c\u0001\u001a\u000b\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u0085\u00018VX\u0096\u0004¢\u0006\u000f\u0012\u0005\b\u008d\u0001\u0010y\u001a\u0006\b\u008e\u0001\u0010\u0088\u0001R\u008a\u0001\u0010\u0094\u0001\u001av\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030~¢\u0006\f\b=\u0012\b\b>\u0012\u0004\b\b(}\u0012\u0016\u0012\u0014\u0018\u000108¢\u0006\r\b=\u0012\t\b>\u0012\u0005\b\b(\u0095\u0001\u0012\u0016\u0012\u0014\u0018\u000108¢\u0006\r\b=\u0012\t\b>\u0012\u0005\b\b(\u0096\u0001\u0012 \u0012\u001e\u0012\u0005\u0012\u00030\u0097\u0001\u0012\u0006\u0012\u0004\u0018\u000108\u0012\u0005\u0012\u00030\u0098\u0001\u0012\u0004\u0012\u00020\u00070g\u0018\u00010gj\u0005\u0018\u0001`\u0099\u0001X\u0082\u0004¢\u0006\t\n\u0000\u0012\u0005\b\u009a\u0001\u0010yR\u0012\u0010\u009d\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\u001cX\u0082\u0004R\u001a\u0010\u009e\u0001\u001a\u0005\u0018\u00010\u0097\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¡\u0001\u001a\u00030\u0097\u00018DX\u0084\u0004¢\u0006\b\u001a\u0006\b¢\u0001\u0010 \u0001R\u0018\u0010£\u0001\u001a\u00030\u0097\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b¤\u0001\u0010 \u0001R\u0012\u0010¥\u0001\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001080\u001cX\u0082\u0004R\u0016\u0010·\u0001\u001a\u00020\u00198TX\u0094\u0004¢\u0006\u0007\u001a\u0005\b·\u0001\u0010\u001aR\u001d\u0010Ä\u0001\u001a\u00020\u00198VX\u0097\u0004¢\u0006\u000e\u0012\u0005\bÅ\u0001\u0010y\u001a\u0005\bÄ\u0001\u0010\u001aR\u001b\u0010Æ\u0001\u001a\u00020\u0019*\u00020\u00108BX\u0082\u0004¢\u0006\b\u001a\u0006\bÆ\u0001\u0010Ç\u0001R\u001d\u0010È\u0001\u001a\u00020\u00198VX\u0097\u0004¢\u0006\u000e\u0012\u0005\bÉ\u0001\u0010y\u001a\u0005\bÈ\u0001\u0010\u001aR\u001b\u0010Ê\u0001\u001a\u00020\u0019*\u00020\u00108BX\u0082\u0004¢\u0006\b\u001a\u0006\bÊ\u0001\u0010Ç\u0001R\u001d\u0010Í\u0001\u001a\u00020\u00198VX\u0097\u0004¢\u0006\u000e\u0012\u0005\bÎ\u0001\u0010y\u001a\u0005\bÍ\u0001\u0010\u001a¨\u0006ì\u0001"}, m4988d2 = {"Lkotlinx/coroutines/channels/BufferedChannel;", "E", "Lkotlinx/coroutines/channels/Channel;", "capacity", BuildConfig.f24315FLAVOR, "onUndeliveredElement", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/internal/OnUndeliveredElement;", "<init>", "(ILkotlin/jvm/functions/Function1;)V", "sendersAndCloseStatus", "Lkotlinx/atomicfu/AtomicLong;", "receivers", "bufferEnd", "sendersCounter", BuildConfig.f24315FLAVOR, "getSendersCounter$kotlinx_coroutines_core", "()J", "receiversCounter", "getReceiversCounter$kotlinx_coroutines_core", "bufferEndCounter", "getBufferEndCounter", "completedExpandBuffersAndPauseFlag", "isRendezvousOrUnlimited", BuildConfig.f24315FLAVOR, "()Z", "sendSegment", "Lkotlinx/atomicfu/AtomicRef;", "Lkotlinx/coroutines/channels/ChannelSegment;", "receiveSegment", "bufferEndSegment", "send", "element", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedSend", "sendOnNoWaiterSuspend", "segment", "index", "s", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareSenderForSuspension", "Lkotlinx/coroutines/Waiter;", "onClosedSendOnNoWaiterSuspend", "cont", "Lkotlinx/coroutines/CancellableContinuation;", "(Ljava/lang/Object;Lkotlinx/coroutines/CancellableContinuation;)V", "trySend", "Lkotlinx/coroutines/channels/ChannelResult;", "trySend-JP2dKIU", "(Ljava/lang/Object;)Ljava/lang/Object;", "sendBroadcast", "sendBroadcast$kotlinx_coroutines_core", "sendImpl", "R", "waiter", BuildConfig.f24315FLAVOR, "onRendezvousOrBuffered", "Lkotlin/Function0;", "onSuspend", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "segm", "i", "onClosed", "onNoWaiterSuspend", "Lkotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "sendImplOnNoWaiter", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLkotlinx/coroutines/Waiter;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "updateCellSend", "closed", "(Lkotlinx/coroutines/channels/ChannelSegment;ILjava/lang/Object;JLjava/lang/Object;Z)I", "updateCellSendSlow", "shouldSendSuspend", "curSendersAndCloseStatus", "bufferOrRendezvousSend", "curSenders", "shouldSendSuspend$kotlinx_coroutines_core", "tryResumeReceiver", "(Ljava/lang/Object;Ljava/lang/Object;)Z", "onReceiveEnqueued", "onReceiveDequeued", "receive", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "receiveOnNoWaiterSuspend", "r", "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "prepareReceiverForSuspension", "onClosedReceiveOnNoWaiterSuspend", "receiveCatching", "receiveCatching-JP2dKIU", "receiveCatchingOnNoWaiterSuspend", "receiveCatchingOnNoWaiterSuspend-GKJJFZk", "onClosedReceiveCatchingOnNoWaiterSuspend", "tryReceive", "tryReceive-PtdJZtk", "()Ljava/lang/Object;", "dropFirstElementUntilTheSpecifiedCellIsInTheBuffer", "globalCellIndex", "receiveImpl", "onElementRetrieved", "Lkotlin/Function3;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "receiveImplOnNoWaiter", "updateCellReceive", "updateCellReceiveSlow", "tryResumeSender", "expandBuffer", "updateCellExpandBuffer", "b", "updateCellExpandBufferSlow", "incCompletedExpandBufferAttempts", "nAttempts", "waitExpandBufferCompletion", "globalIndex", "waitExpandBufferCompletion$kotlinx_coroutines_core", "onSend", "Lkotlinx/coroutines/selects/SelectClause2;", "getOnSend$annotations", "()V", "getOnSend", "()Lkotlinx/coroutines/selects/SelectClause2;", "registerSelectForSend", "select", "Lkotlinx/coroutines/selects/SelectInstance;", "onClosedSelectOnSend", "(Ljava/lang/Object;Lkotlinx/coroutines/selects/SelectInstance;)V", "processResultSelectSend", "ignoredParam", "selectResult", "onReceive", "Lkotlinx/coroutines/selects/SelectClause1;", "getOnReceive$annotations", "getOnReceive", "()Lkotlinx/coroutines/selects/SelectClause1;", "onReceiveCatching", "getOnReceiveCatching$annotations", "getOnReceiveCatching", "onReceiveOrNull", "getOnReceiveOrNull$annotations", "getOnReceiveOrNull", "registerSelectForReceive", "onClosedSelectOnReceive", "processResultSelectReceive", "processResultSelectReceiveOrNull", "processResultSelectReceiveCatching", "onUndeliveredElementReceiveCancellationConstructor", "param", "internalResult", BuildConfig.f24315FLAVOR, "Lkotlin/coroutines/CoroutineContext;", "Lkotlinx/coroutines/selects/OnCancellationConstructor;", "getOnUndeliveredElementReceiveCancellationConstructor$annotations", "iterator", "Lkotlinx/coroutines/channels/ChannelIterator;", "_closeCause", "closeCause", "getCloseCause", "()Ljava/lang/Throwable;", "sendException", "getSendException", "receiveException", "getReceiveException", "closeHandler", "onClosedIdempotent", "close", "cause", "cancel", "Ljava/util/concurrent/CancellationException;", "Lkotlinx/coroutines/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "cancelImpl", "cancelImpl$kotlinx_coroutines_core", "closeOrCancelImpl", "invokeCloseHandler", "invokeOnClose", "handler", "markClosed", "markCancelled", "markCancellationStarted", "completeCloseOrCancel", "isConflatedDropOldest", "completeClose", "sendersCur", "completeCancel", "closeLinkedList", "markAllEmptyCellsAsClosed", "lastSegment", "removeUnprocessedElements", "cancelSuspendedReceiveRequests", "resumeReceiverOnClosedChannel", "resumeSenderOnCancelledChannel", "resumeWaiterOnClosedChannel", "receiver", "isClosedForSend", "isClosedForSend$annotations", "isClosedForSend0", "(J)Z", "isClosedForReceive", "isClosedForReceive$annotations", "isClosedForReceive0", "isClosed", "sendersAndCloseStatusCur", "isEmpty", "isEmpty$annotations", "hasElements", "hasElements$kotlinx_coroutines_core", "isCellNonEmpty", "findSegmentSend", "id", "startFrom", "findSegmentReceive", "findSegmentBufferEnd", "currentBufferEndCounter", "moveSegmentBufferEndToSpecifiedOrLast", "updateSendersCounterIfLower", "value", "updateReceiversCounterIfLower", "toString", BuildConfig.f24315FLAVOR, "toStringDebug", "toStringDebug$kotlinx_coroutines_core", "checkSegmentStructureInvariants", "bindCancellationFunResult", "Lkotlin/reflect/KFunction3;", "context", "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8", "(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", "bindCancellationFun", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Object;)Lkotlin/jvm/functions/Function3;", "onCancellationImplDoNotCall", "SendBroadcast", "BufferedChannelIterator", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannelKt\n+ 4 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 5 DispatchedTask.kt\nkotlinx/coroutines/DispatchedTaskKt\n+ 6 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 7 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$sendImpl$1\n+ 8 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 9 InlineList.kt\nkotlinx/coroutines/internal/InlineList\n+ 10 ConcurrentLinkedList.kt\nkotlinx/coroutines/internal/ConcurrentLinkedListKt\n+ 11 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,3092:1\n270#1,6:3095\n277#1,68:3102\n371#1,20:3192\n241#1:3212\n266#1,10:3213\n277#1,48:3224\n392#1:3272\n331#1,14:3273\n396#1,3:3288\n241#1:3301\n266#1,10:3302\n277#1,68:3313\n241#1:3391\n266#1,10:3392\n277#1,68:3403\n241#1:3474\n266#1,10:3475\n277#1,68:3486\n883#1,52:3556\n961#1,9:3612\n855#1:3621\n879#1,33:3622\n971#1:3655\n913#1,14:3656\n932#1,3:3671\n976#1,6:3674\n883#1,52:3688\n961#1,9:3744\n855#1:3753\n879#1,33:3754\n971#1:3787\n913#1,14:3788\n932#1,3:3803\n976#1,6:3806\n855#1:3821\n879#1,48:3822\n932#1,3:3871\n855#1:3874\n879#1,48:3875\n932#1,3:3924\n241#1:3936\n266#1,10:3937\n277#1,68:3948\n855#1:4017\n879#1,48:4018\n932#1,3:4067\n1#2:3093\n3075#3:3094\n3075#3:3101\n3075#3:3223\n3075#3:3312\n3075#3:3402\n3075#3:3473\n3075#3:3485\n3075#3:3555\n3075#3:3820\n3075#3:3927\n3075#3:3928\n3089#3:3929\n3089#3:3930\n3088#3:3931\n3088#3:3932\n3088#3:3933\n3089#3:3934\n3088#3:3935\n3075#3:3947\n3076#3:4070\n3075#3:4071\n3075#3:4072\n3075#3:4073\n3076#3:4074\n3075#3:4075\n3076#3:4098\n3075#3:4099\n3075#3:4100\n3076#3:4101\n3075#3:4156\n3076#3:4157\n3076#3:4158\n3076#3:4176\n3076#3:4177\n433#4,9:3170\n442#4:3187\n452#4,4:3188\n456#4,8:3291\n433#4,9:3382\n442#4:3472\n452#4,4:3608\n456#4,8:3680\n452#4,4:3740\n456#4,8:3812\n204#5:3179\n205#5:3182\n204#5:3183\n205#5:3186\n57#6,2:3180\n57#6,2:3184\n57#6,2:3299\n266#7:3287\n266#7:3381\n266#7:3471\n266#7:3554\n266#7:4016\n879#8:3670\n879#8:3802\n879#8:3870\n879#8:3923\n879#8:4066\n33#9,11:4076\n33#9,11:4087\n68#10,3:4102\n41#10,9:4105\n68#10,3:4114\n41#10,9:4117\n41#10,9:4126\n68#10,3:4135\n41#10,9:4138\n41#10,9:4147\n774#11:4159\n865#11,2:4160\n2393#11,14:4162\n774#11:4178\n865#11,2:4179\n2393#11,14:4181\n774#11:4195\n865#11,2:4196\n2393#11,14:4198\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n*L\n110#1:3095,6\n110#1:3102,68\n151#1:3192,20\n151#1:3212\n151#1:3213,10\n151#1:3224,48\n151#1:3272\n151#1:3273,14\n151#1:3288,3\n191#1:3301\n191#1:3302,10\n191#1:3313,68\n222#1:3391\n222#1:3392,10\n222#1:3403,68\n388#1:3474\n388#1:3475,10\n388#1:3486,68\n664#1:3556,52\n693#1:3612,9\n693#1:3621\n693#1:3622,33\n693#1:3655\n693#1:3656,14\n693#1:3671,3\n693#1:3674,6\n729#1:3688,52\n745#1:3744,9\n745#1:3753\n745#1:3754,33\n745#1:3787\n745#1:3788,14\n745#1:3803,3\n745#1:3806,6\n778#1:3821\n778#1:3822,48\n778#1:3871,3\n968#1:3874\n968#1:3875,48\n968#1:3924,3\n1461#1:3936\n1461#1:3937,10\n1461#1:3948,68\n1509#1:4017\n1509#1:4018,48\n1509#1:4067,3\n67#1:3094\n110#1:3101\n151#1:3223\n191#1:3312\n222#1:3402\n275#1:3473\n388#1:3485\n603#1:3555\n768#1:3820\n1004#1:3927\n1053#1:3928\n1371#1:3929\n1373#1:3930\n1403#1:3931\n1413#1:3932\n1422#1:3933\n1423#1:3934\n1430#1:3935\n1461#1:3947\n1875#1:4070\n1877#1:4071\n1879#1:4072\n1892#1:4073\n1903#1:4074\n1904#1:4075\n2206#1:4098\n2219#1:4099\n2229#1:4100\n2232#1:4101\n2549#1:4156\n2551#1:4157\n2575#1:4158\n2637#1:4176\n2638#1:4177\n131#1:3170,9\n131#1:3187\n150#1:3188,4\n150#1:3291,8\n218#1:3382,9\n218#1:3472\n692#1:3608,4\n692#1:3680,8\n743#1:3740,4\n743#1:3812,8\n135#1:3179\n135#1:3182\n138#1:3183\n138#1:3186\n135#1:3180,2\n138#1:3184,2\n180#1:3299,2\n151#1:3287\n191#1:3381\n222#1:3471\n388#1:3554\n1461#1:4016\n693#1:3670\n745#1:3802\n778#1:3870\n968#1:3923\n1509#1:4066\n2108#1:4076,11\n2163#1:4087,11\n2371#1:4102,3\n2371#1:4105,9\n2426#1:4114,3\n2426#1:4117,9\n2446#1:4126,9\n2475#1:4135,3\n2475#1:4138,9\n2536#1:4147,9\n2584#1:4159\n2584#1:4160,2\n2585#1:4162,14\n2649#1:4178\n2649#1:4179,2\n2650#1:4181,14\n2690#1:4195\n2690#1:4196,2\n2691#1:4198,14\n*E\n"})
/* loaded from: classes.dex */
public class BufferedChannel<E> implements InterfaceC1361Channel<E> {
    private volatile /* synthetic */ Object _closeCause$volatile;
    private volatile /* synthetic */ long bufferEnd$volatile;
    private volatile /* synthetic */ Object bufferEndSegment$volatile;
    private final int capacity;
    private volatile /* synthetic */ Object closeHandler$volatile;
    private volatile /* synthetic */ long completedExpandBuffersAndPauseFlag$volatile;

    @JvmField
    public final Function1<E, C1133Unit> onUndeliveredElement;
    private final Function3<SelectInstance<?>, Object, Object, Function3<Throwable, Object, CoroutineContext, C1133Unit>> onUndeliveredElementReceiveCancellationConstructor;
    private volatile /* synthetic */ Object receiveSegment$volatile;
    private volatile /* synthetic */ long receivers$volatile;
    private volatile /* synthetic */ Object sendSegment$volatile;
    private volatile /* synthetic */ long sendersAndCloseStatus$volatile;
    private static final /* synthetic */ AtomicLongFieldUpdater sendersAndCloseStatus$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "sendersAndCloseStatus$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater receivers$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "receivers$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater bufferEnd$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "bufferEnd$volatile");
    private static final /* synthetic */ AtomicLongFieldUpdater completedExpandBuffersAndPauseFlag$volatile$FU = AtomicLongFieldUpdater.newUpdater(BufferedChannel.class, "completedExpandBuffersAndPauseFlag$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater sendSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "sendSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater receiveSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "receiveSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater bufferEndSegment$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "bufferEndSegment$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater _closeCause$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "_closeCause$volatile");
    private static final /* synthetic */ AtomicReferenceFieldUpdater closeHandler$volatile$FU = AtomicReferenceFieldUpdater.newUpdater(BufferedChannel.class, Object.class, "closeHandler$volatile");

    @Metadata(m4987d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0082\u0004\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000e\u0010\n\u001a\u00020\tH\u0096B¢\u0006\u0002\u0010\u000bJ\b\u0010\f\u001a\u00020\tH\u0002J,\u0010\r\u001a\u00020\t2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@¢\u0006\u0002\u0010\u0014J\u001c\u0010\u0015\u001a\u00020\u00162\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u00172\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\u000e\u0010\u0019\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00028\u0000¢\u0006\u0002\u0010\u001dJ\u0006\u0010\u001e\u001a\u00020\u0016R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, m4988d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator;", "Lkotlinx/coroutines/channels/ChannelIterator;", "Lkotlinx/coroutines/Waiter;", "<init>", "(Lkotlinx/coroutines/channels/BufferedChannel;)V", "receiveResult", BuildConfig.f24315FLAVOR, "continuation", "Lkotlinx/coroutines/CancellableContinuationImpl;", BuildConfig.f24315FLAVOR, "hasNext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onClosedHasNext", "hasNextOnNoWaiterSuspend", "segment", "Lkotlinx/coroutines/channels/ChannelSegment;", "index", BuildConfig.f24315FLAVOR, "r", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/channels/ChannelSegment;IJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "invokeOnCancellation", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/internal/Segment;", "onClosedHasNextNoWaiterSuspend", "next", "()Ljava/lang/Object;", "tryResumeHasNext", "element", "(Ljava/lang/Object;)Z", "tryResumeHasNextOnClosedChannel", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nBufferedChannel.kt\nKotlin\n*S Kotlin\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n+ 2 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel\n+ 3 CancellableContinuation.kt\nkotlinx/coroutines/CancellableContinuationKt\n+ 4 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$receiveImpl$1\n+ 5 StackTraceRecovery.kt\nkotlinx/coroutines/internal/StackTraceRecoveryKt\n+ 6 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,3092:1\n883#2,52:3093\n961#2,9:3149\n855#2:3158\n879#2,33:3159\n971#2:3192\n913#2,14:3193\n932#2,3:3208\n976#2,6:3211\n452#3,4:3145\n456#3,8:3217\n879#4:3207\n57#5,2:3225\n57#5,2:3228\n1#6:3227\n*S KotlinDebug\n*F\n+ 1 BufferedChannel.kt\nkotlinx/coroutines/channels/BufferedChannel$BufferedChannelIterator\n*L\n1596#1:3093,52\n1634#1:3149,9\n1634#1:3158\n1634#1:3159,33\n1634#1:3192\n1634#1:3193,14\n1634#1:3208,3\n1634#1:3211,6\n1632#1:3145,4\n1632#1:3217,8\n1634#1:3207\n1670#1:3225,2\n1718#1:3228,2\n*E\n"})
    public final class BufferedChannelIterator implements ChannelIterator<E>, InterfaceC1348Waiter {
        private CancellableContinuationImpl<? super Boolean> continuation;
        private Object receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;

        public BufferedChannelIterator() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final Object hasNextOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i, long j, Continuation<? super Boolean> continuation) {
            Boolean boolBoxBoolean;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
            try {
                this.continuation = orCreateCancellableContinuation;
                Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i, j, this);
                if (objUpdateCellReceive == BufferedChannelKt.f5627SUSPEND) {
                    bufferedChannel.prepareReceiverForSuspension(this, channelSegment, i);
                } else {
                    Function3 function3BindCancellationFun = null;
                    if (objUpdateCellReceive == BufferedChannelKt.f5626FAILED) {
                        if (j < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        ChannelSegment channelSegment2 = (ChannelSegment) BufferedChannel.getReceiveSegment$volatile$FU().get(bufferedChannel);
                        while (true) {
                            if (bufferedChannel.isClosedForReceive()) {
                                onClosedHasNextNoWaiterSuspend();
                                break;
                            }
                            long andIncrement = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                            int i2 = BufferedChannelKt.SEGMENT_SIZE;
                            long j2 = andIncrement / i2;
                            int i3 = (int) (andIncrement % i2);
                            if (channelSegment2.id != j2) {
                                ChannelSegment channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j2, channelSegment2);
                                if (channelSegmentFindSegmentReceive != null) {
                                    channelSegment2 = channelSegmentFindSegmentReceive;
                                }
                            }
                            Object objUpdateCellReceive2 = bufferedChannel.updateCellReceive(channelSegment2, i3, andIncrement, this);
                            if (objUpdateCellReceive2 == BufferedChannelKt.f5627SUSPEND) {
                                bufferedChannel.prepareReceiverForSuspension(this, channelSegment2, i3);
                                break;
                            }
                            if (objUpdateCellReceive2 == BufferedChannelKt.f5626FAILED) {
                                if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                                    channelSegment2.cleanPrev();
                                }
                            } else {
                                if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                    throw new IllegalStateException("unexpected");
                                }
                                channelSegment2.cleanPrev();
                                this.receiveResult = objUpdateCellReceive2;
                                this.continuation = null;
                                boolBoxBoolean = C1207Boxing.boxBoolean(true);
                                Function1<E, C1133Unit> function1 = bufferedChannel.onUndeliveredElement;
                                if (function1 != null) {
                                    function3BindCancellationFun = bufferedChannel.bindCancellationFun(function1, objUpdateCellReceive2);
                                }
                            }
                        }
                    } else {
                        channelSegment.cleanPrev();
                        this.receiveResult = objUpdateCellReceive;
                        this.continuation = null;
                        boolBoxBoolean = C1207Boxing.boxBoolean(true);
                        Function1<E, C1133Unit> function12 = bufferedChannel.onUndeliveredElement;
                        if (function12 != null) {
                            function3BindCancellationFun = bufferedChannel.bindCancellationFun(function12, objUpdateCellReceive);
                        }
                    }
                    orCreateCancellableContinuation.mo6916resume((CancellableContinuationImpl) boolBoxBoolean, (Function3<? super Throwable, ? super CancellableContinuationImpl, ? super CoroutineContext, C1133Unit>) function3BindCancellationFun);
                }
                Object result = orCreateCancellableContinuation.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(continuation);
                }
                return result;
            } catch (Throwable th) {
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        }

        private final boolean onClosedHasNext() throws Throwable {
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                return false;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(closeCause);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void onClosedHasNextNoWaiterSuspend() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                C1124Result.Companion companion = C1124Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(Boolean.FALSE));
            } else {
                C1124Result.Companion companion2 = C1124Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(ResultKt.createFailure(closeCause)));
            }
        }

        @Override // p122kotlinx.coroutines.channels.ChannelIterator
        /* renamed from: hasNext */
        public Object mo7069hasNext(Continuation<? super Boolean> continuation) throws Throwable {
            boolean zOnClosedHasNext = true;
            if (this.receiveResult == BufferedChannelKt.NO_RECEIVE_RESULT || this.receiveResult == BufferedChannelKt.getCHANNEL_CLOSED()) {
                BufferedChannel<E> bufferedChannel = BufferedChannel.this;
                ChannelSegment<E> channelSegment = (ChannelSegment) BufferedChannel.getReceiveSegment$volatile$FU().get(bufferedChannel);
                while (true) {
                    if (bufferedChannel.isClosedForReceive()) {
                        zOnClosedHasNext = onClosedHasNext();
                        break;
                    }
                    long andIncrement = BufferedChannel.getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
                    int i = BufferedChannelKt.SEGMENT_SIZE;
                    long j = andIncrement / i;
                    int i2 = (int) (andIncrement % i);
                    if (channelSegment.id != j) {
                        ChannelSegment<E> channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment);
                        if (channelSegmentFindSegmentReceive == null) {
                            continue;
                        } else {
                            channelSegment = channelSegmentFindSegmentReceive;
                        }
                    }
                    Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i2, andIncrement, null);
                    if (objUpdateCellReceive == BufferedChannelKt.f5627SUSPEND) {
                        throw new IllegalStateException("unreachable");
                    }
                    if (objUpdateCellReceive == BufferedChannelKt.f5626FAILED) {
                        if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                    } else {
                        if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                            return hasNextOnNoWaiterSuspend(channelSegment, i2, andIncrement, continuation);
                        }
                        channelSegment.cleanPrev();
                        this.receiveResult = objUpdateCellReceive;
                    }
                }
            }
            return C1207Boxing.boxBoolean(zOnClosedHasNext);
        }

        @Override // p122kotlinx.coroutines.InterfaceC1348Waiter
        public void invokeOnCancellation(AbstractC1577Segment<?> segment, int index) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            if (cancellableContinuationImpl != null) {
                cancellableContinuationImpl.invokeOnCancellation(segment, index);
            }
        }

        @Override // p122kotlinx.coroutines.channels.ChannelIterator
        @Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Since 1.3.0, binary compatibility with versions <= 1.2.x")
        @InterfaceC1231JvmName(m6260name = "next")
        /* renamed from: next */
        public /* bridge */ /* synthetic */ Object mo7071next(Continuation continuation) {
            return super.mo7071next(continuation);
        }

        public final boolean tryResumeHasNext(E element) {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = element;
            Boolean bool = Boolean.TRUE;
            BufferedChannel<E> bufferedChannel = BufferedChannel.this;
            Function1<E, C1133Unit> function1 = bufferedChannel.onUndeliveredElement;
            return BufferedChannelKt.tryResume0(cancellableContinuationImpl, bool, function1 != null ? bufferedChannel.bindCancellationFun(function1, element) : null);
        }

        public final void tryResumeHasNextOnClosedChannel() {
            CancellableContinuationImpl<? super Boolean> cancellableContinuationImpl = this.continuation;
            Intrinsics.checkNotNull(cancellableContinuationImpl);
            this.continuation = null;
            this.receiveResult = BufferedChannelKt.getCHANNEL_CLOSED();
            Throwable closeCause = BufferedChannel.this.getCloseCause();
            if (closeCause == null) {
                C1124Result.Companion companion = C1124Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(Boolean.FALSE));
            } else {
                C1124Result.Companion companion2 = C1124Result.INSTANCE;
                cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(ResultKt.createFailure(closeCause)));
            }
        }

        @Override // p122kotlinx.coroutines.channels.ChannelIterator
        /* renamed from: next */
        public E mo7070next() throws Throwable {
            E e = (E) this.receiveResult;
            if (e == BufferedChannelKt.NO_RECEIVE_RESULT) {
                throw new IllegalStateException("`hasNext()` has not been invoked");
            }
            this.receiveResult = BufferedChannelKt.NO_RECEIVE_RESULT;
            if (e != BufferedChannelKt.getCHANNEL_CLOSED()) {
                return e;
            }
            throw StackTraceRecoveryKt.recoverStackTrace(BufferedChannel.this.getReceiveException());
        }
    }

    @Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u001d\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000f"}, m4988d2 = {"Lkotlinx/coroutines/channels/BufferedChannel$SendBroadcast;", "Lkotlinx/coroutines/Waiter;", "cont", "Lkotlinx/coroutines/CancellableContinuation;", BuildConfig.f24315FLAVOR, "<init>", "(Lkotlinx/coroutines/CancellableContinuation;)V", "getCont", "()Lkotlinx/coroutines/CancellableContinuation;", "invokeOnCancellation", BuildConfig.f24315FLAVOR, "segment", "Lkotlinx/coroutines/internal/Segment;", "index", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class SendBroadcast implements InterfaceC1348Waiter {
        private final /* synthetic */ CancellableContinuationImpl<Boolean> $$delegate_0;
        private final CancellableContinuation<Boolean> cont;

        /* JADX WARN: Multi-variable type inference failed */
        public SendBroadcast(CancellableContinuation<? super Boolean> cancellableContinuation) {
            Intrinsics.checkNotNull(cancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlin.Boolean>");
            this.$$delegate_0 = (CancellableContinuationImpl) cancellableContinuation;
            this.cont = cancellableContinuation;
        }

        /* renamed from: getCont */
        public final CancellableContinuation<Boolean> m7072getCont() {
            return this.cont;
        }

        @Override // p122kotlinx.coroutines.InterfaceC1348Waiter
        public void invokeOnCancellation(AbstractC1577Segment<?> segment, int index) {
            this.$$delegate_0.invokeOnCancellation(segment, index);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.channels.BufferedChannel$bindCancellationFun$2 */
    public static final /* synthetic */ class C13562 extends FunctionReferenceImpl implements Function3<Throwable, E, CoroutineContext, C1133Unit> {
        public C13562(Object obj) {
            super(3, obj, BufferedChannel.class, "onCancellationImplDoNotCall", "onCancellationImplDoNotCall(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
        }

        @Override // p094kotlin.p105jvm.functions.Function3
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ C1133Unit mo6219invoke(Throwable th, Object obj, CoroutineContext coroutineContext) {
            invoke2(th, (Throwable) obj, coroutineContext);
            return C1133Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(Throwable th, E e, CoroutineContext coroutineContext) {
            ((BufferedChannel) this.receiver).onCancellationImplDoNotCall(th, e, coroutineContext);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    /* renamed from: kotlinx.coroutines.channels.BufferedChannel$bindCancellationFunResult$1 */
    public static final /* synthetic */ class C13571 extends FunctionReferenceImpl implements Function3<Throwable, ChannelResult<? extends E>, CoroutineContext, C1133Unit> {
        public C13571(Object obj) {
            super(3, obj, BufferedChannel.class, "onCancellationChannelResultImplDoNotCall", "onCancellationChannelResultImplDoNotCall-5_sEAP8(Ljava/lang/Throwable;Ljava/lang/Object;Lkotlin/coroutines/CoroutineContext;)V", 0);
        }

        @Override // p094kotlin.p105jvm.functions.Function3
        /* renamed from: invoke */
        public /* bridge */ /* synthetic */ C1133Unit mo6219invoke(Throwable th, Object obj, CoroutineContext coroutineContext) {
            m19997invoke5_sEAP8(th, ((ChannelResult) obj).getHolder(), coroutineContext);
            return C1133Unit.INSTANCE;
        }

        /* renamed from: invoke-5_sEAP8, reason: not valid java name */
        public final void m19997invoke5_sEAP8(Throwable th, Object obj, CoroutineContext coroutineContext) {
            ((BufferedChannel) this.receiver).m19992onCancellationChannelResultImplDoNotCall5_sEAP8(th, obj, coroutineContext);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BufferedChannel(int i, Function1<? super E, C1133Unit> function1) {
        this.capacity = i;
        this.onUndeliveredElement = function1;
        if (i < 0) {
            throw new IllegalArgumentException(("Invalid channel capacity: " + i + ", should be >=0").toString());
        }
        this.bufferEnd$volatile = BufferedChannelKt.initialBufferEnd(i);
        this.completedExpandBuffersAndPauseFlag$volatile = getBufferEndCounter();
        ChannelSegment channelSegment = new ChannelSegment(0L, null, this, 3);
        this.sendSegment$volatile = channelSegment;
        this.receiveSegment$volatile = channelSegment;
        if (isRendezvousOrUnlimited()) {
            channelSegment = BufferedChannelKt.NULL_SEGMENT;
            Intrinsics.checkNotNull(channelSegment, "null cannot be cast to non-null type kotlinx.coroutines.channels.ChannelSegment<E of kotlinx.coroutines.channels.BufferedChannel>");
        }
        this.bufferEndSegment$volatile = channelSegment;
        this.onUndeliveredElementReceiveCancellationConstructor = function1 != 0 ? new Function3() { // from class: o.APn
            @Override // p094kotlin.p105jvm.functions.Function3
            /* renamed from: invoke */
            public final Object mo6219invoke(Object obj, Object obj2, Object obj3) {
                return BufferedChannel.onUndeliveredElementReceiveCancellationConstructor$lambda$0$0(this.f7357mjFkc, (SelectInstance) obj, obj2, obj3);
            }
        } : null;
        this._closeCause$volatile = BufferedChannelKt.NO_CLOSE_CAUSE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Function3<Throwable, Object, CoroutineContext, C1133Unit> bindCancellationFun(final Function1<? super E, C1133Unit> function1, final E e) {
        return new Function3() { // from class: o.ybBTr
            @Override // p094kotlin.p105jvm.functions.Function3
            /* renamed from: invoke */
            public final Object mo6219invoke(Object obj, Object obj2, Object obj3) {
                return BufferedChannel.bindCancellationFun$lambda$0(function1, e, (Throwable) obj, obj2, (CoroutineContext) obj3);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit bindCancellationFun$lambda$0(Function1 function1, Object obj, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        OnUndeliveredElementKt.callUndeliveredElement(function1, obj, coroutineContext);
        return C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KFunction<C1133Unit> bindCancellationFunResult(Function1<? super E, C1133Unit> function1) {
        return new C13571(this);
    }

    private final boolean bufferOrRendezvousSend(long curSenders) {
        return curSenders < getBufferEndCounter() || curSenders < getReceiversCounter$kotlinx_coroutines_core() + ((long) this.capacity);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void cancelSuspendedReceiveRequests(ChannelSegment<E> lastSegment, long sendersCounter) {
        Object objM20035constructorimpl$default = InlineList.m20035constructorimpl$default(null, 1, null);
        loop0: while (lastSegment != null) {
            for (int i = BufferedChannelKt.SEGMENT_SIZE - 1; -1 < i; i--) {
                if ((lastSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i < sendersCounter) {
                    break loop0;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                        if (!(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                            if (!(state$kotlinx_coroutines_core instanceof InterfaceC1348Waiter)) {
                                break;
                            }
                            if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                objM20035constructorimpl$default = InlineList.m20040plusFjFbRPM(objM20035constructorimpl$default, state$kotlinx_coroutines_core);
                                lastSegment.onCancelledRequest(i, true);
                                break;
                            }
                        } else {
                            if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                objM20035constructorimpl$default = InlineList.m20040plusFjFbRPM(objM20035constructorimpl$default, ((WaiterEB) state$kotlinx_coroutines_core).waiter);
                                lastSegment.onCancelledRequest(i, true);
                                break;
                            }
                        }
                    } else {
                        if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            lastSegment.onSlotCleaned();
                            break;
                        }
                    }
                }
            }
            lastSegment = (ChannelSegment) lastSegment.m7408getPrev();
        }
        if (objM20035constructorimpl$default != null) {
            if (!(objM20035constructorimpl$default instanceof ArrayList)) {
                resumeReceiverOnClosedChannel((InterfaceC1348Waiter) objM20035constructorimpl$default);
                return;
            }
            Intrinsics.checkNotNull(objM20035constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
            ArrayList arrayList = (ArrayList) objM20035constructorimpl$default;
            for (int size = arrayList.size() - 1; -1 < size; size--) {
                resumeReceiverOnClosedChannel((InterfaceC1348Waiter) arrayList.get(size));
            }
        }
    }

    private final ChannelSegment<E> closeLinkedList() {
        Object obj = bufferEndSegment$volatile$FU.get(this);
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        if (channelSegment.id > ((ChannelSegment) obj).id) {
            obj = channelSegment;
        }
        ChannelSegment channelSegment2 = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        if (channelSegment2.id > ((ChannelSegment) obj).id) {
            obj = channelSegment2;
        }
        return (ChannelSegment) ConcurrentLinkedListKt.m7406close((ConcurrentLinkedListNode) obj);
    }

    private final void completeCancel(long sendersCur) {
        removeUnprocessedElements(completeClose(sendersCur));
    }

    private final ChannelSegment<E> completeClose(long sendersCur) {
        ChannelSegment<E> channelSegmentCloseLinkedList = closeLinkedList();
        if (isConflatedDropOldest()) {
            long jMarkAllEmptyCellsAsClosed = markAllEmptyCellsAsClosed(channelSegmentCloseLinkedList);
            if (jMarkAllEmptyCellsAsClosed != -1) {
                dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(jMarkAllEmptyCellsAsClosed);
            }
        }
        cancelSuspendedReceiveRequests(channelSegmentCloseLinkedList, sendersCur);
        return channelSegmentCloseLinkedList;
    }

    private final void completeCloseOrCancel() {
        isClosedForSend();
    }

    private final void expandBuffer() {
        if (isRendezvousOrUnlimited()) {
            return;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) bufferEndSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = bufferEnd$volatile$FU.getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / i;
            if (getSendersCounter$kotlinx_coroutines_core() <= andIncrement) {
                if (channelSegment.id < j && channelSegment.m7407getNext() != 0) {
                    moveSegmentBufferEndToSpecifiedOrLast(j, channelSegment);
                }
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            if (channelSegment.id != j) {
                ChannelSegment<E> channelSegmentFindSegmentBufferEnd = findSegmentBufferEnd(j, channelSegment, andIncrement);
                if (channelSegmentFindSegmentBufferEnd == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentBufferEnd;
                }
            }
            if (updateCellExpandBuffer(channelSegment, (int) (andIncrement % i), andIncrement)) {
                incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
                return;
            }
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        }
    }

    private final ChannelSegment<E> findSegmentBufferEnd(long id, ChannelSegment<E> startFrom, long currentBufferEndCounter) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.m20051isClosedimpl(objFindSegmentInternal)) {
                AbstractC1577Segment abstractC1577SegmentM20049getSegmentimpl = SegmentOrClosed.m20049getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AbstractC1577Segment abstractC1577Segment = (AbstractC1577Segment) atomicReferenceFieldUpdater.get(this);
                    if (abstractC1577Segment.id >= abstractC1577SegmentM20049getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!abstractC1577SegmentM20049getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (AbstractC1852Dt.m8064mjFkc(atomicReferenceFieldUpdater, this, abstractC1577Segment, abstractC1577SegmentM20049getSegmentimpl)) {
                        if (abstractC1577Segment.decPointers$kotlinx_coroutines_core()) {
                            abstractC1577Segment.m7410remove();
                        }
                    } else if (abstractC1577SegmentM20049getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        abstractC1577SegmentM20049getSegmentimpl.m7410remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m20051isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            moveSegmentBufferEndToSpecifiedOrLast(id, startFrom);
            incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m20049getSegmentimpl(objFindSegmentInternal);
        if (channelSegment.id <= id) {
            return channelSegment;
        }
        long j = channelSegment.id;
        int i = BufferedChannelKt.SEGMENT_SIZE;
        if (bufferEnd$volatile$FU.compareAndSet(this, currentBufferEndCounter + 1, j * i)) {
            incCompletedExpandBufferAttempts((channelSegment.id * i) - currentBufferEndCounter);
            return null;
        }
        incCompletedExpandBufferAttempts$default(this, 0L, 1, null);
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentReceive(long id, ChannelSegment<E> startFrom) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = receiveSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.m20051isClosedimpl(objFindSegmentInternal)) {
                AbstractC1577Segment abstractC1577SegmentM20049getSegmentimpl = SegmentOrClosed.m20049getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AbstractC1577Segment abstractC1577Segment = (AbstractC1577Segment) atomicReferenceFieldUpdater.get(this);
                    if (abstractC1577Segment.id >= abstractC1577SegmentM20049getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!abstractC1577SegmentM20049getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (AbstractC1852Dt.m8064mjFkc(atomicReferenceFieldUpdater, this, abstractC1577Segment, abstractC1577SegmentM20049getSegmentimpl)) {
                        if (abstractC1577Segment.decPointers$kotlinx_coroutines_core()) {
                            abstractC1577Segment.m7410remove();
                        }
                    } else if (abstractC1577SegmentM20049getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        abstractC1577SegmentM20049getSegmentimpl.m7410remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m20051isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            if (startFrom.id * BufferedChannelKt.SEGMENT_SIZE >= getSendersCounter$kotlinx_coroutines_core()) {
                return null;
            }
            startFrom.cleanPrev();
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m20049getSegmentimpl(objFindSegmentInternal);
        if (!isRendezvousOrUnlimited() && id <= getBufferEndCounter() / BufferedChannelKt.SEGMENT_SIZE) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = bufferEndSegment$volatile$FU;
            while (true) {
                AbstractC1577Segment abstractC1577Segment2 = (AbstractC1577Segment) atomicReferenceFieldUpdater2.get(this);
                if (abstractC1577Segment2.id >= channelSegment.id || !channelSegment.tryIncPointers$kotlinx_coroutines_core()) {
                    break;
                }
                if (AbstractC1852Dt.m8064mjFkc(atomicReferenceFieldUpdater2, this, abstractC1577Segment2, channelSegment)) {
                    if (abstractC1577Segment2.decPointers$kotlinx_coroutines_core()) {
                        abstractC1577Segment2.m7410remove();
                    }
                } else if (channelSegment.decPointers$kotlinx_coroutines_core()) {
                    channelSegment.m7410remove();
                }
            }
        }
        long j = channelSegment.id;
        if (j <= id) {
            return channelSegment;
        }
        int i = BufferedChannelKt.SEGMENT_SIZE;
        updateReceiversCounterIfLower(j * i);
        if (channelSegment.id * i >= getSendersCounter$kotlinx_coroutines_core()) {
            return null;
        }
        channelSegment.cleanPrev();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ChannelSegment<E> findSegmentSend(long id, ChannelSegment<E> startFrom) {
        Object objFindSegmentInternal;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = sendSegment$volatile$FU;
        Function2 function2 = (Function2) BufferedChannelKt.createSegmentFunction();
        loop0: while (true) {
            objFindSegmentInternal = ConcurrentLinkedListKt.findSegmentInternal(startFrom, id, function2);
            if (!SegmentOrClosed.m20051isClosedimpl(objFindSegmentInternal)) {
                AbstractC1577Segment abstractC1577SegmentM20049getSegmentimpl = SegmentOrClosed.m20049getSegmentimpl(objFindSegmentInternal);
                while (true) {
                    AbstractC1577Segment abstractC1577Segment = (AbstractC1577Segment) atomicReferenceFieldUpdater.get(this);
                    if (abstractC1577Segment.id >= abstractC1577SegmentM20049getSegmentimpl.id) {
                        break loop0;
                    }
                    if (!abstractC1577SegmentM20049getSegmentimpl.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (AbstractC1852Dt.m8064mjFkc(atomicReferenceFieldUpdater, this, abstractC1577Segment, abstractC1577SegmentM20049getSegmentimpl)) {
                        if (abstractC1577Segment.decPointers$kotlinx_coroutines_core()) {
                            abstractC1577Segment.m7410remove();
                        }
                    } else if (abstractC1577SegmentM20049getSegmentimpl.decPointers$kotlinx_coroutines_core()) {
                        abstractC1577SegmentM20049getSegmentimpl.m7410remove();
                    }
                }
            } else {
                break;
            }
        }
        if (SegmentOrClosed.m20051isClosedimpl(objFindSegmentInternal)) {
            completeCloseOrCancel();
            if (startFrom.id * BufferedChannelKt.SEGMENT_SIZE >= getReceiversCounter$kotlinx_coroutines_core()) {
                return null;
            }
            startFrom.cleanPrev();
            return null;
        }
        ChannelSegment<E> channelSegment = (ChannelSegment) SegmentOrClosed.m20049getSegmentimpl(objFindSegmentInternal);
        long j = channelSegment.id;
        if (j <= id) {
            return channelSegment;
        }
        int i = BufferedChannelKt.SEGMENT_SIZE;
        updateSendersCounterIfLower(j * i);
        if (channelSegment.id * i >= getReceiversCounter$kotlinx_coroutines_core()) {
            return null;
        }
        channelSegment.cleanPrev();
        return null;
    }

    private final /* synthetic */ Object getAndUpdate$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Function1<Object, ? extends Object> function1) {
        Object obj2;
        do {
            obj2 = atomicReferenceFieldUpdater.get(obj);
        } while (!AbstractC1852Dt.m8064mjFkc(atomicReferenceFieldUpdater, obj, obj2, function1.mo2237invoke(obj2)));
        return obj2;
    }

    private final /* synthetic */ long getBufferEnd$volatile() {
        return this.bufferEnd$volatile;
    }

    private final long getBufferEndCounter() {
        return bufferEnd$volatile$FU.get(this);
    }

    private final /* synthetic */ Object getBufferEndSegment$volatile() {
        return this.bufferEndSegment$volatile;
    }

    private final /* synthetic */ Object getCloseHandler$volatile() {
        return this.closeHandler$volatile;
    }

    private final /* synthetic */ long getCompletedExpandBuffersAndPauseFlag$volatile() {
        return this.completedExpandBuffersAndPauseFlag$volatile;
    }

    public static /* synthetic */ void getOnReceive$annotations() {
    }

    public static /* synthetic */ void getOnReceiveCatching$annotations() {
    }

    public static /* synthetic */ void getOnReceiveOrNull$annotations() {
    }

    public static /* synthetic */ void getOnSend$annotations() {
    }

    /* renamed from: getOnUndeliveredElementReceiveCancellationConstructor$annotations */
    private static /* synthetic */ void m7060x1df74ada() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Throwable getReceiveException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedReceiveChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    private final /* synthetic */ Object getReceiveSegment$volatile() {
        return this.receiveSegment$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater getReceiveSegment$volatile$FU() {
        return receiveSegment$volatile$FU;
    }

    private final /* synthetic */ long getReceivers$volatile() {
        return this.receivers$volatile;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicLongFieldUpdater getReceivers$volatile$FU() {
        return receivers$volatile$FU;
    }

    private final /* synthetic */ Object getSendSegment$volatile() {
        return this.sendSegment$volatile;
    }

    private final /* synthetic */ long getSendersAndCloseStatus$volatile() {
        return this.sendersAndCloseStatus$volatile;
    }

    private final /* synthetic */ Object get_closeCause$volatile() {
        return this._closeCause$volatile;
    }

    private final void incCompletedExpandBufferAttempts(long nAttempts) {
        if ((completedExpandBuffersAndPauseFlag$volatile$FU.addAndGet(this, nAttempts) & 4611686018427387904L) != 0) {
            while ((completedExpandBuffersAndPauseFlag$volatile$FU.get(this) & 4611686018427387904L) != 0) {
            }
        }
    }

    public static /* synthetic */ void incCompletedExpandBufferAttempts$default(BufferedChannel bufferedChannel, long j, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: incCompletedExpandBufferAttempts");
        }
        if ((i & 1) != 0) {
            j = 1;
        }
        bufferedChannel.incCompletedExpandBufferAttempts(j);
    }

    private final void invokeCloseHandler() {
        Object obj;
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$volatile$FU;
        do {
            obj = atomicReferenceFieldUpdater.get(this);
        } while (!AbstractC1852Dt.m8064mjFkc(atomicReferenceFieldUpdater, this, obj, obj == null ? BufferedChannelKt.CLOSE_HANDLER_CLOSED : BufferedChannelKt.CLOSE_HANDLER_INVOKED));
        if (obj == null) {
            return;
        }
        ((Function1) obj).mo2237invoke(getCloseCause());
    }

    private final boolean isCellNonEmpty(ChannelSegment<E> segment, int index, long globalIndex) {
        Object state$kotlinx_coroutines_core;
        do {
            state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core != null && state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                    return true;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED() || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == BufferedChannelKt.RESUMING_BY_EB) {
                    return true;
                }
                return state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV && globalIndex == getReceiversCounter$kotlinx_coroutines_core();
            }
        } while (!segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED));
        expandBuffer();
        return false;
    }

    private final boolean isClosed(long sendersAndCloseStatusCur, boolean isClosedForReceive) {
        int i = (int) (sendersAndCloseStatusCur >> 60);
        if (i == 0 || i == 1) {
            return false;
        }
        if (i == 2) {
            completeClose(sendersAndCloseStatusCur & 1152921504606846975L);
            if (isClosedForReceive && hasElements$kotlinx_coroutines_core()) {
                return false;
            }
        } else {
            if (i != 3) {
                throw new IllegalStateException(("unexpected close status: " + i).toString());
            }
            completeCancel(sendersAndCloseStatusCur & 1152921504606846975L);
        }
        return true;
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isClosedForReceive$annotations() {
    }

    private final boolean isClosedForReceive0(long j) {
        return isClosed(j, true);
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isClosedForSend$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean isClosedForSend0(long j) {
        return isClosed(j, false);
    }

    @ExperimentalCoroutinesApi
    public static /* synthetic */ void isEmpty$annotations() {
    }

    private final boolean isRendezvousOrUnlimited() {
        long bufferEndCounter = getBufferEndCounter();
        return bufferEndCounter == 0 || bufferEndCounter == LongCompanionObject.MAX_VALUE;
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Any(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Function1<Object, C1133Unit> function1) {
        while (true) {
            function1.mo2237invoke(atomicReferenceFieldUpdater.get(obj));
        }
    }

    private final /* synthetic */ void loop$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater atomicLongFieldUpdater, Object obj, Function1<? super Long, C1133Unit> function1) {
        while (true) {
            function1.mo2237invoke(Long.valueOf(atomicLongFieldUpdater.get(obj)));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x003c, code lost:
    
        r8 = (p122kotlinx.coroutines.channels.ChannelSegment) r8.m7408getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final long markAllEmptyCellsAsClosed(ChannelSegment<E> lastSegment) {
        do {
            int i = BufferedChannelKt.SEGMENT_SIZE;
            while (true) {
                i--;
                if (-1 >= i) {
                    break;
                }
                long j = (lastSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i;
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    return -1L;
                }
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                        if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            lastSegment.onSlotCleaned();
                            break;
                        }
                    } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED) {
                        return j;
                    }
                }
            }
        } while (lastSegment != null);
        return -1L;
    }

    private final void markCancellationStarted() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            if (((int) (j >> 60)) != 0) {
                return;
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 1)));
    }

    private final void markCancelled() {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(1152921504606846975L & j, 3)));
    }

    private final void markClosed() {
        long j;
        long jConstructSendersAndCloseStatus;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            int i = (int) (j >> 60);
            if (i == 0) {
                jConstructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(j & 1152921504606846975L, 2);
            } else if (i != 1) {
                return;
            } else {
                jConstructSendersAndCloseStatus = BufferedChannelKt.constructSendersAndCloseStatus(j & 1152921504606846975L, 3);
            }
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, jConstructSendersAndCloseStatus));
    }

    /* JADX WARN: Code restructure failed: missing block: B:38:0x0011, code lost:
    
        continue;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void moveSegmentBufferEndToSpecifiedOrLast(long id, ChannelSegment<E> startFrom) {
        ChannelSegment<E> channelSegment;
        ChannelSegment<E> channelSegment2;
        while (startFrom.id < id && (channelSegment2 = (ChannelSegment) startFrom.m7407getNext()) != null) {
            startFrom = channelSegment2;
        }
        while (true) {
            if (!startFrom.isRemoved() || (channelSegment = (ChannelSegment) startFrom.m7407getNext()) == null) {
                AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = bufferEndSegment$volatile$FU;
                while (true) {
                    AbstractC1577Segment abstractC1577Segment = (AbstractC1577Segment) atomicReferenceFieldUpdater.get(this);
                    if (abstractC1577Segment.id >= startFrom.id) {
                        return;
                    }
                    if (!startFrom.tryIncPointers$kotlinx_coroutines_core()) {
                        break;
                    }
                    if (AbstractC1852Dt.m8064mjFkc(atomicReferenceFieldUpdater, this, abstractC1577Segment, startFrom)) {
                        if (abstractC1577Segment.decPointers$kotlinx_coroutines_core()) {
                            abstractC1577Segment.m7410remove();
                            return;
                        }
                        return;
                    } else if (startFrom.decPointers$kotlinx_coroutines_core()) {
                        startFrom.m7410remove();
                    }
                }
            } else {
                startFrom = channelSegment;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onCancellationChannelResultImplDoNotCall-5_sEAP8, reason: not valid java name */
    public final void m19992onCancellationChannelResultImplDoNotCall5_sEAP8(Throwable cause, Object element, CoroutineContext context) {
        Function1<E, C1133Unit> function1 = this.onUndeliveredElement;
        Intrinsics.checkNotNull(function1);
        Object objM20007getOrNullimpl = ChannelResult.m20007getOrNullimpl(element);
        Intrinsics.checkNotNull(objM20007getOrNullimpl);
        OnUndeliveredElementKt.callUndeliveredElement(function1, objM20007getOrNullimpl, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCancellationImplDoNotCall(Throwable cause, E element, CoroutineContext context) {
        Function1<E, C1133Unit> function1 = this.onUndeliveredElement;
        Intrinsics.checkNotNull(function1);
        OnUndeliveredElementKt.callUndeliveredElement(function1, element, context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveCatchingOnNoWaiterSuspend(CancellableContinuation<? super ChannelResult<? extends E>> cont) {
        C1124Result.Companion companion = C1124Result.INSTANCE;
        cont.resumeWith(C1124Result.m18546constructorimpl(ChannelResult.m20002boximpl(ChannelResult.INSTANCE.m20015closedJP2dKIU(getCloseCause()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedReceiveOnNoWaiterSuspend(CancellableContinuation<? super E> cont) {
        C1124Result.Companion companion = C1124Result.INSTANCE;
        cont.resumeWith(C1124Result.m18546constructorimpl(ResultKt.createFailure(getReceiveException())));
    }

    private final void onClosedSelectOnReceive(SelectInstance<?> select) {
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    private final void onClosedSelectOnSend(E element, SelectInstance<?> select) {
        Function1<E, C1133Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, element, select.getContext());
        }
        select.selectInRegistrationPhase(BufferedChannelKt.getCHANNEL_CLOSED());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object onClosedSend(E e, Continuation<? super C1133Unit> continuation) {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        Function1<E, C1133Unit> function1 = this.onUndeliveredElement;
        if (function1 == null || (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, e, null, 2, null)) == null) {
            Throwable sendException = getSendException();
            C1124Result.Companion companion = C1124Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(ResultKt.createFailure(sendException)));
        } else {
            ExceptionsKt.addSuppressed(undeliveredElementExceptionCallUndeliveredElementCatchingException$default, getSendException());
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(ResultKt.createFailure(undeliveredElementExceptionCallUndeliveredElementCatchingException$default)));
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onClosedSendOnNoWaiterSuspend(E element, CancellableContinuation<? super C1133Unit> cont) {
        Function1<E, C1133Unit> function1 = this.onUndeliveredElement;
        if (function1 != null) {
            OnUndeliveredElementKt.callUndeliveredElement(function1, element, cont.getContext());
        }
        Throwable sendException = getSendException();
        C1124Result.Companion companion = C1124Result.INSTANCE;
        cont.resumeWith(C1124Result.m18546constructorimpl(ResultKt.createFailure(sendException)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function3 onUndeliveredElementReceiveCancellationConstructor$lambda$0$0(final BufferedChannel bufferedChannel, final SelectInstance selectInstance, Object obj, final Object obj2) {
        return new Function3() { // from class: o.knzZ
            @Override // p094kotlin.p105jvm.functions.Function3
            /* renamed from: invoke */
            public final Object mo6219invoke(Object obj3, Object obj4, Object obj5) {
                return BufferedChannel.onUndeliveredElementReceiveCancellationConstructor$lambda$0$0$0(obj2, bufferedChannel, selectInstance, (Throwable) obj3, obj4, (CoroutineContext) obj5);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final C1133Unit onUndeliveredElementReceiveCancellationConstructor$lambda$0$0$0(Object obj, BufferedChannel bufferedChannel, SelectInstance selectInstance, Throwable th, Object obj2, CoroutineContext coroutineContext) {
        if (obj != BufferedChannelKt.getCHANNEL_CLOSED()) {
            OnUndeliveredElementKt.callUndeliveredElement(bufferedChannel.onUndeliveredElement, obj, selectInstance.getContext());
        }
        return C1133Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareReceiverForSuspension(InterfaceC1348Waiter interfaceC1348Waiter, ChannelSegment<E> channelSegment, int i) {
        onReceiveEnqueued();
        interfaceC1348Waiter.invokeOnCancellation(channelSegment, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void prepareSenderForSuspension(InterfaceC1348Waiter interfaceC1348Waiter, ChannelSegment<E> channelSegment, int i) {
        interfaceC1348Waiter.invokeOnCancellation(channelSegment, i + BufferedChannelKt.SEGMENT_SIZE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceive(Object ignoredParam, Object selectResult) throws Throwable {
        if (selectResult != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return selectResult;
        }
        throw getReceiveException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceiveCatching(Object ignoredParam, Object selectResult) {
        return ChannelResult.m20002boximpl(selectResult == BufferedChannelKt.getCHANNEL_CLOSED() ? ChannelResult.INSTANCE.m20015closedJP2dKIU(getCloseCause()) : ChannelResult.INSTANCE.m20017successJP2dKIU(selectResult));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectReceiveOrNull(Object ignoredParam, Object selectResult) throws Throwable {
        if (selectResult != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return selectResult;
        }
        if (getCloseCause() == null) {
            return null;
        }
        throw getReceiveException();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object processResultSelectSend(Object ignoredParam, Object selectResult) throws Throwable {
        if (selectResult != BufferedChannelKt.getCHANNEL_CLOSED()) {
            return this;
        }
        throw getSendException();
    }

    public static /* synthetic */ <E> Object receive$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super E> continuation) throws Throwable {
        ChannelSegment<E> channelSegment = (ChannelSegment) getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / i;
            int i2 = (int) (andIncrement % i);
            if (channelSegment.id != j) {
                ChannelSegment<E> channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            }
            Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i2, andIncrement, null);
            if (objUpdateCellReceive == BufferedChannelKt.f5627SUSPEND) {
                throw new IllegalStateException("unexpected");
            }
            if (objUpdateCellReceive != BufferedChannelKt.f5626FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return bufferedChannel.receiveOnNoWaiterSuspend(channelSegment, i2, andIncrement, continuation);
                }
                channelSegment.cleanPrev();
                return objUpdateCellReceive;
            }
            if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        }
        throw StackTraceRecoveryKt.recoverStackTrace(bufferedChannel.getReceiveException());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /* renamed from: receiveCatching-JP2dKIU$suspendImpl, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <E> Object m19993receiveCatchingJP2dKIU$suspendImpl(BufferedChannel<E> bufferedChannel, Continuation<? super ChannelResult<? extends E>> continuation) {
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$1;
        ChannelSegment<E> channelSegment;
        if (continuation instanceof BufferedChannel$receiveCatching$1) {
            bufferedChannel$receiveCatching$1 = (BufferedChannel$receiveCatching$1) continuation;
            int i = bufferedChannel$receiveCatching$1.f5616label;
            if ((i & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatching$1.f5616label = i - Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatching$1 = new BufferedChannel$receiveCatching$1(bufferedChannel, continuation);
            }
        }
        BufferedChannel$receiveCatching$1 bufferedChannel$receiveCatching$12 = bufferedChannel$receiveCatching$1;
        Object obj = bufferedChannel$receiveCatching$12.f5617result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = bufferedChannel$receiveCatching$12.f5616label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            return ((ChannelResult) obj).getHolder();
        }
        ResultKt.throwOnFailure(obj);
        ChannelSegment<E> channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            int i3 = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / i3;
            int i4 = (int) (andIncrement % i3);
            if (channelSegment2.id != j) {
                ChannelSegment<E> channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i4, andIncrement, null);
            if (objUpdateCellReceive == BufferedChannelKt.f5627SUSPEND) {
                throw new IllegalStateException("unexpected");
            }
            if (objUpdateCellReceive != BufferedChannelKt.f5626FAILED) {
                if (objUpdateCellReceive != BufferedChannelKt.SUSPEND_NO_WAITER) {
                    channelSegment.cleanPrev();
                    return ChannelResult.INSTANCE.m20017successJP2dKIU(objUpdateCellReceive);
                }
                bufferedChannel$receiveCatching$12.f5611L$0 = SpillingKt.nullOutSpilledVariable(bufferedChannel);
                bufferedChannel$receiveCatching$12.f5612L$1 = SpillingKt.nullOutSpilledVariable(bufferedChannel);
                bufferedChannel$receiveCatching$12.f5613L$2 = SpillingKt.nullOutSpilledVariable(channelSegment);
                bufferedChannel$receiveCatching$12.f5614L$3 = SpillingKt.nullOutSpilledVariable(objUpdateCellReceive);
                bufferedChannel$receiveCatching$12.f5615L$4 = SpillingKt.nullOutSpilledVariable(channelSegment);
                bufferedChannel$receiveCatching$12.f5604I$0 = 0;
                bufferedChannel$receiveCatching$12.f5608J$0 = andIncrement;
                bufferedChannel$receiveCatching$12.f5609J$1 = j;
                bufferedChannel$receiveCatching$12.f5605I$1 = i4;
                bufferedChannel$receiveCatching$12.f5610J$2 = andIncrement;
                bufferedChannel$receiveCatching$12.f5606I$2 = i4;
                bufferedChannel$receiveCatching$12.f5607I$3 = 0;
                bufferedChannel$receiveCatching$12.f5616label = 1;
                Object objM19994receiveCatchingOnNoWaiterSuspendGKJJFZk = bufferedChannel.m19994receiveCatchingOnNoWaiterSuspendGKJJFZk(channelSegment, i4, andIncrement, bufferedChannel$receiveCatching$12);
                return objM19994receiveCatchingOnNoWaiterSuspendGKJJFZk == coroutine_suspended ? coroutine_suspended : objM19994receiveCatchingOnNoWaiterSuspendGKJJFZk;
            }
            if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            channelSegment2 = channelSegment;
        }
        return ChannelResult.INSTANCE.m20015closedJP2dKIU(bufferedChannel.getCloseCause());
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: receiveCatchingOnNoWaiterSuspend-GKJJFZk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object m19994receiveCatchingOnNoWaiterSuspendGKJJFZk(ChannelSegment<E> channelSegment, int i, long j, Continuation<? super ChannelResult<? extends E>> continuation) {
        BufferedChannel$receiveCatchingOnNoWaiterSuspend$1 bufferedChannel$receiveCatchingOnNoWaiterSuspend$1;
        ChannelResult channelResultM20002boximpl;
        Function3 function3;
        if (continuation instanceof BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) {
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = (BufferedChannel$receiveCatchingOnNoWaiterSuspend$1) continuation;
            int i2 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.f5623label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.f5623label = i2 - Integer.MIN_VALUE;
            } else {
                bufferedChannel$receiveCatchingOnNoWaiterSuspend$1 = new BufferedChannel$receiveCatchingOnNoWaiterSuspend$1(this, continuation);
            }
        }
        Object result = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.f5624result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.f5623label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(result);
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.f5622L$0 = channelSegment;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.f5619I$0 = i;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.f5621J$0 = j;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.f5620I$1 = 0;
            bufferedChannel$receiveCatchingOnNoWaiterSuspend$1.f5623label = 1;
            CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1));
            try {
                Intrinsics.checkNotNull(orCreateCancellableContinuation, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuationImpl<kotlinx.coroutines.channels.ChannelResult<E of kotlinx.coroutines.channels.BufferedChannel>>");
                ReceiveCatching receiveCatching = new ReceiveCatching(orCreateCancellableContinuation);
                Object objUpdateCellReceive = updateCellReceive(channelSegment, i, j, receiveCatching);
                if (objUpdateCellReceive == BufferedChannelKt.f5627SUSPEND) {
                    prepareReceiverForSuspension(receiveCatching, channelSegment, i);
                } else {
                    if (objUpdateCellReceive == BufferedChannelKt.f5626FAILED) {
                        if (j < getSendersCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        ChannelSegment channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
                        while (true) {
                            if (isClosedForReceive()) {
                                onClosedReceiveCatchingOnNoWaiterSuspend(orCreateCancellableContinuation);
                                break;
                            }
                            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
                            int i4 = BufferedChannelKt.SEGMENT_SIZE;
                            long j2 = andIncrement / i4;
                            int i5 = (int) (andIncrement % i4);
                            if (channelSegment2.id != j2) {
                                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j2, channelSegment2);
                                if (channelSegmentFindSegmentReceive != null) {
                                    channelSegment2 = channelSegmentFindSegmentReceive;
                                }
                            }
                            Object objUpdateCellReceive2 = updateCellReceive(channelSegment2, i5, andIncrement, receiveCatching);
                            if (objUpdateCellReceive2 == BufferedChannelKt.f5627SUSPEND) {
                                prepareReceiverForSuspension(receiveCatching, channelSegment2, i5);
                                break;
                            }
                            if (objUpdateCellReceive2 == BufferedChannelKt.f5626FAILED) {
                                if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                    channelSegment2.cleanPrev();
                                }
                            } else {
                                if (objUpdateCellReceive2 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                    throw new IllegalStateException("unexpected");
                                }
                                channelSegment2.cleanPrev();
                                channelResultM20002boximpl = ChannelResult.m20002boximpl(ChannelResult.INSTANCE.m20017successJP2dKIU(objUpdateCellReceive2));
                                Function1<E, C1133Unit> function1 = this.onUndeliveredElement;
                                function3 = (Function3) (function1 != null ? bindCancellationFunResult(function1) : null);
                            }
                        }
                    } else {
                        channelSegment.cleanPrev();
                        channelResultM20002boximpl = ChannelResult.m20002boximpl(ChannelResult.INSTANCE.m20017successJP2dKIU(objUpdateCellReceive));
                        Function1<E, C1133Unit> function12 = this.onUndeliveredElement;
                        function3 = (Function3) (function12 != null ? bindCancellationFunResult(function12) : null);
                    }
                    orCreateCancellableContinuation.mo6916resume((CancellableContinuationImpl) channelResultM20002boximpl, (Function3<? super Throwable, ? super CancellableContinuationImpl, ? super CoroutineContext, C1133Unit>) function3);
                }
                result = orCreateCancellableContinuation.getResult();
                if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    DebugProbesKt.probeCoroutineSuspended(bufferedChannel$receiveCatchingOnNoWaiterSuspend$1);
                }
                if (result == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } catch (Throwable th) {
                orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
                throw th;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(result);
        }
        return ((ChannelResult) result).getHolder();
    }

    private final <R> R receiveImpl(Object waiter, Function1<? super E, ? extends R> onElementRetrieved, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onSuspend, Function0<? extends R> onClosed, Function3<? super ChannelSegment<E>, ? super Integer, ? super Long, ? extends R> onNoWaiterSuspend) {
        ChannelSegment channelSegment = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / i;
            int i2 = (int) (andIncrement % i);
            if (channelSegment.id != j) {
                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegment);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            }
            C1578Symbol c1578Symbol = (Object) updateCellReceive(channelSegment, i2, andIncrement, waiter);
            if (c1578Symbol == BufferedChannelKt.f5627SUSPEND) {
                InterfaceC1348Waiter interfaceC1348Waiter = waiter instanceof InterfaceC1348Waiter ? (InterfaceC1348Waiter) waiter : null;
                if (interfaceC1348Waiter != null) {
                    prepareReceiverForSuspension(interfaceC1348Waiter, channelSegment, i2);
                }
                return onSuspend.mo6219invoke(channelSegment, Integer.valueOf(i2), Long.valueOf(andIncrement));
            }
            if (c1578Symbol != BufferedChannelKt.f5626FAILED) {
                if (c1578Symbol == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return onNoWaiterSuspend.mo6219invoke(channelSegment, Integer.valueOf(i2), Long.valueOf(andIncrement));
                }
                channelSegment.cleanPrev();
                return onElementRetrieved.mo2237invoke(c1578Symbol);
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        }
        return onClosed.mo4323invoke();
    }

    public static /* synthetic */ Object receiveImpl$default(BufferedChannel bufferedChannel, Object obj, Function1 function1, Function3 function3, Function0 function0, Function3 function32, int i, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: receiveImpl");
        }
        if ((i & 16) != 0) {
            function32 = new Function3() { // from class: kotlinx.coroutines.channels.BufferedChannel.receiveImpl.1
                @Override // p094kotlin.p105jvm.functions.Function3
                /* renamed from: invoke */
                public /* bridge */ /* synthetic */ Object mo6219invoke(Object obj3, Object obj4, Object obj5) {
                    return m7073invoke((ChannelSegment) obj3, ((Number) obj4).intValue(), ((Number) obj5).longValue());
                }

                /* renamed from: invoke */
                public final Void m7073invoke(ChannelSegment<E> channelSegment, int i2, long j) {
                    throw new IllegalStateException("unexpected");
                }
            };
        }
        ChannelSegment channelSegment = (ChannelSegment) getReceiveSegment$volatile$FU().get(bufferedChannel);
        while (!bufferedChannel.isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(bufferedChannel);
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / i2;
            int i3 = (int) (andIncrement % i2);
            if (channelSegment.id != j) {
                ChannelSegment channelSegmentFindSegmentReceive = bufferedChannel.findSegmentReceive(j, channelSegment);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            }
            Object objUpdateCellReceive = bufferedChannel.updateCellReceive(channelSegment, i3, andIncrement, obj);
            if (objUpdateCellReceive == BufferedChannelKt.f5627SUSPEND) {
                InterfaceC1348Waiter interfaceC1348Waiter = obj instanceof InterfaceC1348Waiter ? (InterfaceC1348Waiter) obj : null;
                if (interfaceC1348Waiter != null) {
                    bufferedChannel.prepareReceiverForSuspension(interfaceC1348Waiter, channelSegment, i3);
                }
                return function3.mo6219invoke(channelSegment, Integer.valueOf(i3), Long.valueOf(andIncrement));
            }
            if (objUpdateCellReceive != BufferedChannelKt.f5626FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    return function32.mo6219invoke(channelSegment, Integer.valueOf(i3), Long.valueOf(andIncrement));
                }
                channelSegment.cleanPrev();
                return function1.mo2237invoke(objUpdateCellReceive);
            }
            if (andIncrement < bufferedChannel.getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        }
        return function0.mo4323invoke();
    }

    private final void receiveImplOnNoWaiter(ChannelSegment<E> segment, int index, long r, InterfaceC1348Waiter waiter, Function1<? super E, C1133Unit> onElementRetrieved, Function0<C1133Unit> onClosed) {
        C1578Symbol c1578Symbol = (Object) updateCellReceive(segment, index, r, waiter);
        if (c1578Symbol == BufferedChannelKt.f5627SUSPEND) {
            prepareReceiverForSuspension(waiter, segment, index);
            return;
        }
        if (c1578Symbol != BufferedChannelKt.f5626FAILED) {
            segment.cleanPrev();
            onElementRetrieved.mo2237invoke(c1578Symbol);
            return;
        }
        if (r < getSendersCounter$kotlinx_coroutines_core()) {
            segment.cleanPrev();
        }
        ChannelSegment channelSegment = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / i;
            int i2 = (int) (andIncrement % i);
            if (channelSegment.id != j) {
                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegment);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            }
            C1578Symbol c1578Symbol2 = (Object) updateCellReceive(channelSegment, i2, andIncrement, waiter);
            if (c1578Symbol2 == BufferedChannelKt.f5627SUSPEND) {
                if (waiter == null) {
                    waiter = null;
                }
                if (waiter != null) {
                    prepareReceiverForSuspension(waiter, channelSegment, i2);
                }
                C1133Unit c1133Unit = C1133Unit.INSTANCE;
                return;
            }
            if (c1578Symbol2 != BufferedChannelKt.f5626FAILED) {
                if (c1578Symbol2 == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment.cleanPrev();
                onElementRetrieved.mo2237invoke(c1578Symbol2);
                return;
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        }
        onClosed.mo4323invoke();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object receiveOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i, long j, Continuation<? super E> continuation) {
        Function3 function3;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            Object objUpdateCellReceive = updateCellReceive(channelSegment, i, j, orCreateCancellableContinuation);
            if (objUpdateCellReceive == BufferedChannelKt.f5627SUSPEND) {
                prepareReceiverForSuspension(orCreateCancellableContinuation, channelSegment, i);
            } else {
                if (objUpdateCellReceive == BufferedChannelKt.f5626FAILED) {
                    if (j < getSendersCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    ChannelSegment channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
                    while (true) {
                        if (isClosedForReceive()) {
                            onClosedReceiveOnNoWaiterSuspend(orCreateCancellableContinuation);
                            break;
                        }
                        long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
                        int i2 = BufferedChannelKt.SEGMENT_SIZE;
                        long j2 = andIncrement / i2;
                        int i3 = (int) (andIncrement % i2);
                        if (channelSegment2.id != j2) {
                            ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j2, channelSegment2);
                            if (channelSegmentFindSegmentReceive != null) {
                                channelSegment2 = channelSegmentFindSegmentReceive;
                            }
                        }
                        objUpdateCellReceive = updateCellReceive(channelSegment2, i3, andIncrement, orCreateCancellableContinuation);
                        if (objUpdateCellReceive == BufferedChannelKt.f5627SUSPEND) {
                            CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation != null ? orCreateCancellableContinuation : null;
                            if (cancellableContinuationImpl != null) {
                                prepareReceiverForSuspension(cancellableContinuationImpl, channelSegment2, i3);
                            }
                        } else if (objUpdateCellReceive == BufferedChannelKt.f5626FAILED) {
                            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                                channelSegment2.cleanPrev();
                            }
                        } else {
                            if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                                throw new IllegalStateException("unexpected");
                            }
                            channelSegment2.cleanPrev();
                            Function1<E, C1133Unit> function1 = this.onUndeliveredElement;
                            function3 = (Function3) (function1 != null ? bindCancellationFun(function1) : null);
                        }
                    }
                } else {
                    channelSegment.cleanPrev();
                    Function1<E, C1133Unit> function12 = this.onUndeliveredElement;
                    function3 = (Function3) (function12 != null ? bindCancellationFun(function12) : null);
                }
                orCreateCancellableContinuation.mo6916resume((CancellableContinuationImpl) objUpdateCellReceive, (Function3<? super Throwable, ? super CancellableContinuationImpl, ? super CoroutineContext, C1133Unit>) function3);
            }
            Object result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void registerSelectForReceive(SelectInstance<?> select, Object ignoredParam) {
        ChannelSegment channelSegment = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = andIncrement / i;
            int i2 = (int) (andIncrement % i);
            if (channelSegment.id != j) {
                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegment);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            }
            Object objUpdateCellReceive = updateCellReceive(channelSegment, i2, andIncrement, select);
            if (objUpdateCellReceive == BufferedChannelKt.f5627SUSPEND) {
                InterfaceC1348Waiter interfaceC1348Waiter = select instanceof InterfaceC1348Waiter ? (InterfaceC1348Waiter) select : null;
                if (interfaceC1348Waiter != null) {
                    prepareReceiverForSuspension(interfaceC1348Waiter, channelSegment, i2);
                    return;
                }
                return;
            }
            if (objUpdateCellReceive != BufferedChannelKt.f5626FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment.cleanPrev();
                select.selectInRegistrationPhase(objUpdateCellReceive);
                return;
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
        }
        onClosedSelectOnReceive(select);
    }

    /* JADX WARN: Code restructure failed: missing block: B:50:0x00b3, code lost:
    
        r12 = (p122kotlinx.coroutines.channels.ChannelSegment) r12.m7408getPrev();
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private final void removeUnprocessedElements(ChannelSegment<E> lastSegment) {
        Function1<E, C1133Unit> function1 = this.onUndeliveredElement;
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException = null;
        Object objM20035constructorimpl$default = InlineList.m20035constructorimpl$default(null, 1, null);
        loop0: do {
            int i = BufferedChannelKt.SEGMENT_SIZE - 1;
            while (true) {
                if (-1 >= i) {
                    break;
                }
                long j = (lastSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i;
                while (true) {
                    Object state$kotlinx_coroutines_core = lastSegment.getState$kotlinx_coroutines_core(i);
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV) {
                        break loop0;
                    }
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                        if (state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER && state$kotlinx_coroutines_core != null) {
                            if (!(state$kotlinx_coroutines_core instanceof InterfaceC1348Waiter) && !(state$kotlinx_coroutines_core instanceof WaiterEB)) {
                                if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV) {
                                    if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB) {
                                        break;
                                    }
                                } else {
                                    break loop0;
                                }
                            } else {
                                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                                    break loop0;
                                }
                                InterfaceC1348Waiter interfaceC1348Waiter = state$kotlinx_coroutines_core instanceof WaiterEB ? ((WaiterEB) state$kotlinx_coroutines_core).waiter : (InterfaceC1348Waiter) state$kotlinx_coroutines_core;
                                if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                    if (function1 != null) {
                                        undeliveredElementExceptionCallUndeliveredElementCatchingException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, lastSegment.getElement$kotlinx_coroutines_core(i), undeliveredElementExceptionCallUndeliveredElementCatchingException);
                                    }
                                    objM20035constructorimpl$default = InlineList.m20040plusFjFbRPM(objM20035constructorimpl$default, interfaceC1348Waiter);
                                    lastSegment.cleanElement$kotlinx_coroutines_core(i);
                                    lastSegment.onSlotCleaned();
                                }
                            }
                        } else {
                            if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                                lastSegment.onSlotCleaned();
                                break;
                            }
                        }
                    } else {
                        if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            break loop0;
                        }
                        if (lastSegment.casState$kotlinx_coroutines_core(i, state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                            if (function1 != null) {
                                undeliveredElementExceptionCallUndeliveredElementCatchingException = OnUndeliveredElementKt.callUndeliveredElementCatchingException(function1, lastSegment.getElement$kotlinx_coroutines_core(i), undeliveredElementExceptionCallUndeliveredElementCatchingException);
                            }
                            lastSegment.cleanElement$kotlinx_coroutines_core(i);
                            lastSegment.onSlotCleaned();
                        }
                    }
                }
                i--;
            }
        } while (lastSegment != null);
        if (objM20035constructorimpl$default != null) {
            if (objM20035constructorimpl$default instanceof ArrayList) {
                Intrinsics.checkNotNull(objM20035constructorimpl$default, "null cannot be cast to non-null type java.util.ArrayList<E of kotlinx.coroutines.internal.InlineList>");
                ArrayList arrayList = (ArrayList) objM20035constructorimpl$default;
                for (int size = arrayList.size() - 1; -1 < size; size--) {
                    resumeSenderOnCancelledChannel((InterfaceC1348Waiter) arrayList.get(size));
                }
            } else {
                resumeSenderOnCancelledChannel((InterfaceC1348Waiter) objM20035constructorimpl$default);
            }
        }
        if (undeliveredElementExceptionCallUndeliveredElementCatchingException != null) {
            throw undeliveredElementExceptionCallUndeliveredElementCatchingException;
        }
    }

    private final void resumeReceiverOnClosedChannel(InterfaceC1348Waiter interfaceC1348Waiter) {
        resumeWaiterOnClosedChannel(interfaceC1348Waiter, true);
    }

    private final void resumeSenderOnCancelledChannel(InterfaceC1348Waiter interfaceC1348Waiter) {
        resumeWaiterOnClosedChannel(interfaceC1348Waiter, false);
    }

    private final void resumeWaiterOnClosedChannel(InterfaceC1348Waiter interfaceC1348Waiter, boolean z) {
        if (interfaceC1348Waiter instanceof SendBroadcast) {
            CancellableContinuation<Boolean> cancellableContinuationM7072getCont = ((SendBroadcast) interfaceC1348Waiter).m7072getCont();
            C1124Result.Companion companion = C1124Result.INSTANCE;
            cancellableContinuationM7072getCont.resumeWith(C1124Result.m18546constructorimpl(Boolean.FALSE));
            return;
        }
        if (interfaceC1348Waiter instanceof CancellableContinuation) {
            Continuation continuation = (Continuation) interfaceC1348Waiter;
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            continuation.resumeWith(C1124Result.m18546constructorimpl(ResultKt.createFailure(z ? getReceiveException() : getSendException())));
        } else if (interfaceC1348Waiter instanceof ReceiveCatching) {
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) interfaceC1348Waiter).cont;
            C1124Result.Companion companion3 = C1124Result.INSTANCE;
            cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(ChannelResult.m20002boximpl(ChannelResult.INSTANCE.m20015closedJP2dKIU(getCloseCause()))));
        } else if (interfaceC1348Waiter instanceof BufferedChannelIterator) {
            ((BufferedChannelIterator) interfaceC1348Waiter).tryResumeHasNextOnClosedChannel();
        } else {
            if (interfaceC1348Waiter instanceof SelectInstance) {
                ((SelectInstance) interfaceC1348Waiter).trySelect(this, BufferedChannelKt.getCHANNEL_CLOSED());
                return;
            }
            throw new IllegalStateException(("Unexpected waiter: " + interfaceC1348Waiter).toString());
        }
    }

    public static /* synthetic */ <E> Object send$suspendImpl(BufferedChannel<E> bufferedChannel, E e, Continuation<? super C1133Unit> continuation) {
        ChannelSegment<E> channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (channelSegment.id != j2) {
                ChannelSegment<E> channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    Object objOnClosedSend = bufferedChannel.onClosedSend(e, continuation);
                    if (objOnClosedSend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return objOnClosedSend;
                    }
                }
            }
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegment, i2, e, j, null, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            }
            if (iUpdateCellSend == 1) {
                break;
            }
            if (iUpdateCellSend != 2) {
                if (iUpdateCellSend == 3) {
                    Object objSendOnNoWaiterSuspend = bufferedChannel.sendOnNoWaiterSuspend(channelSegment, i2, e, j, continuation);
                    if (objSendOnNoWaiterSuspend == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return objSendOnNoWaiterSuspend;
                    }
                } else if (iUpdateCellSend == 4) {
                    if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment.cleanPrev();
                    }
                    Object objOnClosedSend2 = bufferedChannel.onClosedSend(e, continuation);
                    if (objOnClosedSend2 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return objOnClosedSend2;
                    }
                } else if (iUpdateCellSend == 5) {
                    channelSegment.cleanPrev();
                }
            } else if (zIsClosedForSend0) {
                channelSegment.onSlotCleaned();
                Object objOnClosedSend3 = bufferedChannel.onClosedSend(e, continuation);
                if (objOnClosedSend3 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                    return objOnClosedSend3;
                }
            }
        }
        return C1133Unit.INSTANCE;
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00a6, code lost:
    
        r0 = p094kotlin.C1124Result.INSTANCE;
        r9.resumeWith(p094kotlin.C1124Result.m18546constructorimpl(p094kotlin.coroutines.p097jvm.internal.C1207Boxing.boxBoolean(true)));
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static /* synthetic */ <E> Object sendBroadcast$suspendImpl(BufferedChannel<E> bufferedChannel, E e, Continuation<? super Boolean> continuation) {
        ChannelSegment channelSegment;
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        if (bufferedChannel.onUndeliveredElement != null) {
            throw new IllegalStateException("the `onUndeliveredElement` feature is unsupported for `sendBroadcast(e)`");
        }
        SendBroadcast sendBroadcast = new SendBroadcast(cancellableContinuationImpl);
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (channelSegment2.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    break;
                }
            } else {
                channelSegment = channelSegment2;
            }
            ChannelSegment channelSegment3 = channelSegment;
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegment, i2, e, j, sendBroadcast, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment3.cleanPrev();
                break;
            }
            if (iUpdateCellSend == 1) {
                break;
            }
            if (iUpdateCellSend != 2) {
                if (iUpdateCellSend == 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iUpdateCellSend != 4) {
                    if (iUpdateCellSend == 5) {
                        channelSegment3.cleanPrev();
                    }
                    channelSegment2 = channelSegment3;
                } else if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment3.cleanPrev();
                }
            } else if (zIsClosedForSend0) {
                channelSegment3.onSlotCleaned();
            } else {
                bufferedChannel.prepareSenderForSuspension(sendBroadcast, channelSegment3, i2);
            }
        }
        C1124Result.Companion companion = C1124Result.INSTANCE;
        cancellableContinuationImpl.resumeWith(C1124Result.m18546constructorimpl(C1207Boxing.boxBoolean(false)));
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }

    public static /* synthetic */ Object sendImpl$default(BufferedChannel bufferedChannel, Object obj, Object obj2, Function0 function0, Function2 function2, Function0 function02, Function4 function4, int i, Object obj3) {
        ChannelSegment channelSegment;
        if (obj3 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendImpl");
        }
        Function4 function42 = (i & 32) != 0 ? new Function4() { // from class: kotlinx.coroutines.channels.BufferedChannel.sendImpl.1
            @Override // p094kotlin.p105jvm.functions.Function4
            /* renamed from: invoke */
            public /* bridge */ /* synthetic */ Object mo6276invoke(Object obj4, Object obj5, Object obj6, Object obj7) {
                return m7074invoke((ChannelSegment<int>) obj4, ((Number) obj5).intValue(), (int) obj6, ((Number) obj7).longValue());
            }

            /* renamed from: invoke */
            public final Void m7074invoke(ChannelSegment<E> channelSegment2, int i2, E e, long j) {
                throw new IllegalStateException("unexpected");
            }
        } : function4;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(bufferedChannel);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(bufferedChannel);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = bufferedChannel.isClosedForSend0(andIncrement);
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / i2;
            int i3 = (int) (j % i2);
            if (channelSegment2.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = bufferedChannel.findSegmentSend(j2, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    return function02.mo4323invoke();
                }
            } else {
                channelSegment = channelSegment2;
            }
            int iUpdateCellSend = bufferedChannel.updateCellSend(channelSegment, i3, obj, j, obj2, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return function0.mo4323invoke();
            }
            if (iUpdateCellSend == 1) {
                return function0.mo4323invoke();
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return function02.mo4323invoke();
                }
                InterfaceC1348Waiter interfaceC1348Waiter = obj2 instanceof InterfaceC1348Waiter ? (InterfaceC1348Waiter) obj2 : null;
                if (interfaceC1348Waiter != null) {
                    bufferedChannel.prepareSenderForSuspension(interfaceC1348Waiter, channelSegment, i3);
                }
                return function2.mo2167invoke(channelSegment, Integer.valueOf(i3));
            }
            if (iUpdateCellSend == 3) {
                return function42.mo6276invoke(channelSegment, Integer.valueOf(i3), obj, Long.valueOf(j));
            }
            if (iUpdateCellSend == 4) {
                if (j < bufferedChannel.getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return function02.mo4323invoke();
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
            channelSegment2 = channelSegment;
        }
    }

    private final void sendImplOnNoWaiter(ChannelSegment<E> segment, int index, E element, long s, InterfaceC1348Waiter waiter, Function0<C1133Unit> onRendezvousOrBuffered, Function0<C1133Unit> onClosed) {
        ChannelSegment channelSegment;
        C1133Unit c1133UnitMo4323invoke;
        InterfaceC1348Waiter interfaceC1348Waiter = waiter;
        int iUpdateCellSend = updateCellSend(segment, index, element, s, waiter, false);
        if (iUpdateCellSend == 0) {
            segment.cleanPrev();
            onRendezvousOrBuffered.mo4323invoke();
            return;
        }
        if (iUpdateCellSend == 1) {
            onRendezvousOrBuffered.mo4323invoke();
            return;
        }
        if (iUpdateCellSend == 2) {
            prepareSenderForSuspension(interfaceC1348Waiter, segment, index);
            return;
        }
        if (iUpdateCellSend == 4) {
            if (s < getReceiversCounter$kotlinx_coroutines_core()) {
                segment.cleanPrev();
            }
            onClosed.mo4323invoke();
            return;
        }
        if (iUpdateCellSend != 5) {
            throw new IllegalStateException("unexpected");
        }
        segment.cleanPrev();
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (channelSegment2.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    c1133UnitMo4323invoke = onClosed.mo4323invoke();
                    break;
                }
            } else {
                channelSegment = channelSegment2;
            }
            ChannelSegment channelSegment3 = channelSegment;
            int iUpdateCellSend2 = updateCellSend(channelSegment, i2, element, j, waiter, zIsClosedForSend0);
            if (iUpdateCellSend2 == 0) {
                channelSegment3.cleanPrev();
                c1133UnitMo4323invoke = onRendezvousOrBuffered.mo4323invoke();
                break;
            }
            if (iUpdateCellSend2 == 1) {
                c1133UnitMo4323invoke = onRendezvousOrBuffered.mo4323invoke();
                break;
            }
            if (iUpdateCellSend2 != 2) {
                if (iUpdateCellSend2 == 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iUpdateCellSend2 != 4) {
                    if (iUpdateCellSend2 == 5) {
                        channelSegment3.cleanPrev();
                    }
                    channelSegment2 = channelSegment3;
                } else {
                    if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                        channelSegment3.cleanPrev();
                    }
                    c1133UnitMo4323invoke = onClosed.mo4323invoke();
                }
            } else if (zIsClosedForSend0) {
                channelSegment3.onSlotCleaned();
                c1133UnitMo4323invoke = onClosed.mo4323invoke();
            } else {
                if (interfaceC1348Waiter == null) {
                    interfaceC1348Waiter = null;
                }
                if (interfaceC1348Waiter != null) {
                    prepareSenderForSuspension(interfaceC1348Waiter, channelSegment3, i2);
                }
                c1133UnitMo4323invoke = C1133Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x011b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x011c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object sendOnNoWaiterSuspend(ChannelSegment<E> channelSegment, int i, E e, long j, Continuation<? super C1133Unit> continuation) {
        Object objM18546constructorimpl;
        Object result;
        ChannelSegment channelSegment2;
        CancellableContinuationImpl orCreateCancellableContinuation = CancellableContinuationKt.getOrCreateCancellableContinuation(IntrinsicsKt.intercepted(continuation));
        try {
            int iUpdateCellSend = updateCellSend(channelSegment, i, e, j, orCreateCancellableContinuation, false);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                C1124Result.Companion companion = C1124Result.INSTANCE;
                objM18546constructorimpl = C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
            } else {
                if (iUpdateCellSend != 1) {
                    if (iUpdateCellSend != 2) {
                        if (iUpdateCellSend != 4) {
                            if (iUpdateCellSend != 5) {
                                throw new IllegalStateException("unexpected");
                            }
                            channelSegment.cleanPrev();
                            ChannelSegment channelSegment3 = (ChannelSegment) sendSegment$volatile$FU.get(this);
                            while (true) {
                                long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
                                long j2 = andIncrement & 1152921504606846975L;
                                boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
                                int i2 = BufferedChannelKt.SEGMENT_SIZE;
                                long j3 = j2 / i2;
                                int i3 = (int) (j2 % i2);
                                if (channelSegment3.id != j3) {
                                    ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j3, channelSegment3);
                                    if (channelSegmentFindSegmentSend != null) {
                                        channelSegment2 = channelSegmentFindSegmentSend;
                                    } else if (zIsClosedForSend0) {
                                        break;
                                    }
                                } else {
                                    channelSegment2 = channelSegment3;
                                }
                                ChannelSegment channelSegment4 = channelSegment2;
                                int iUpdateCellSend2 = updateCellSend(channelSegment2, i3, e, j2, orCreateCancellableContinuation, zIsClosedForSend0);
                                if (iUpdateCellSend2 == 0) {
                                    channelSegment4.cleanPrev();
                                    C1124Result.Companion companion2 = C1124Result.INSTANCE;
                                    objM18546constructorimpl = C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
                                    break;
                                }
                                if (iUpdateCellSend2 == 1) {
                                    C1124Result.Companion companion3 = C1124Result.INSTANCE;
                                    objM18546constructorimpl = C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
                                    break;
                                }
                                if (iUpdateCellSend2 != 2) {
                                    if (iUpdateCellSend2 == 3) {
                                        throw new IllegalStateException("unexpected");
                                    }
                                    if (iUpdateCellSend2 != 4) {
                                        if (iUpdateCellSend2 == 5) {
                                            channelSegment4.cleanPrev();
                                        }
                                        channelSegment3 = channelSegment4;
                                    } else if (j2 < getReceiversCounter$kotlinx_coroutines_core()) {
                                        channelSegment4.cleanPrev();
                                    }
                                } else if (zIsClosedForSend0) {
                                    channelSegment4.onSlotCleaned();
                                } else {
                                    CancellableContinuationImpl cancellableContinuationImpl = orCreateCancellableContinuation != null ? orCreateCancellableContinuation : null;
                                    if (cancellableContinuationImpl != null) {
                                        prepareSenderForSuspension(cancellableContinuationImpl, channelSegment4, i3);
                                    }
                                }
                            }
                        } else if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                            channelSegment.cleanPrev();
                        }
                        onClosedSendOnNoWaiterSuspend(e, orCreateCancellableContinuation);
                    } else {
                        prepareSenderForSuspension(orCreateCancellableContinuation, channelSegment, i);
                    }
                    result = orCreateCancellableContinuation.getResult();
                    if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        DebugProbesKt.probeCoroutineSuspended(continuation);
                    }
                    return result != IntrinsicsKt.getCOROUTINE_SUSPENDED() ? result : C1133Unit.INSTANCE;
                }
                C1124Result.Companion companion4 = C1124Result.INSTANCE;
                objM18546constructorimpl = C1124Result.m18546constructorimpl(C1133Unit.INSTANCE);
            }
            orCreateCancellableContinuation.resumeWith(objM18546constructorimpl);
            result = orCreateCancellableContinuation.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
            if (result != IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            }
        } catch (Throwable th) {
            orCreateCancellableContinuation.releaseClaimedReusableContinuation$kotlinx_coroutines_core();
            throw th;
        }
    }

    private final /* synthetic */ void setBufferEnd$volatile(long j) {
        this.bufferEnd$volatile = j;
    }

    private final /* synthetic */ void setBufferEndSegment$volatile(Object obj) {
        this.bufferEndSegment$volatile = obj;
    }

    private final /* synthetic */ void setCloseHandler$volatile(Object obj) {
        this.closeHandler$volatile = obj;
    }

    private final /* synthetic */ void setCompletedExpandBuffersAndPauseFlag$volatile(long j) {
        this.completedExpandBuffersAndPauseFlag$volatile = j;
    }

    private final /* synthetic */ void setReceiveSegment$volatile(Object obj) {
        this.receiveSegment$volatile = obj;
    }

    private final /* synthetic */ void setReceivers$volatile(long j) {
        this.receivers$volatile = j;
    }

    private final /* synthetic */ void setSendSegment$volatile(Object obj) {
        this.sendSegment$volatile = obj;
    }

    private final /* synthetic */ void setSendersAndCloseStatus$volatile(long j) {
        this.sendersAndCloseStatus$volatile = j;
    }

    private final /* synthetic */ void set_closeCause$volatile(Object obj) {
        this._closeCause$volatile = obj;
    }

    private final boolean shouldSendSuspend(long curSendersAndCloseStatus) {
        if (isClosedForSend0(curSendersAndCloseStatus)) {
            return false;
        }
        return !bufferOrRendezvousSend(curSendersAndCloseStatus & 1152921504606846975L);
    }

    private final boolean tryResumeReceiver(Object obj, E e) {
        if (obj instanceof SelectInstance) {
            return ((SelectInstance) obj).trySelect(this, e);
        }
        if (obj instanceof ReceiveCatching) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.ReceiveCatching<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuationImpl<ChannelResult<? extends E>> cancellableContinuationImpl = ((ReceiveCatching) obj).cont;
            ChannelResult channelResultM20002boximpl = ChannelResult.m20002boximpl(ChannelResult.INSTANCE.m20017successJP2dKIU(e));
            Function1<E, C1133Unit> function1 = this.onUndeliveredElement;
            return BufferedChannelKt.tryResume0(cancellableContinuationImpl, channelResultM20002boximpl, (Function3) (function1 != null ? bindCancellationFunResult(function1) : null));
        }
        if (obj instanceof BufferedChannelIterator) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.channels.BufferedChannel.BufferedChannelIterator<E of kotlinx.coroutines.channels.BufferedChannel>");
            return ((BufferedChannelIterator) obj).tryResumeHasNext(e);
        }
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<E of kotlinx.coroutines.channels.BufferedChannel>");
            CancellableContinuation cancellableContinuation = (CancellableContinuation) obj;
            Function1<E, C1133Unit> function12 = this.onUndeliveredElement;
            return BufferedChannelKt.tryResume0(cancellableContinuation, e, (Function3) (function12 != null ? bindCancellationFun(function12) : null));
        }
        throw new IllegalStateException(("Unexpected receiver type: " + obj).toString());
    }

    private final boolean tryResumeSender(Object obj, ChannelSegment<E> channelSegment, int i) {
        if (obj instanceof CancellableContinuation) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.CancellableContinuation<kotlin.Unit>");
            return BufferedChannelKt.tryResume0$default((CancellableContinuation) obj, C1133Unit.INSTANCE, null, 2, null);
        }
        if (obj instanceof SelectInstance) {
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlinx.coroutines.selects.SelectImplementation<*>");
            TrySelectDetailedResult trySelectDetailedResultTrySelectDetailed = ((SelectImplementation) obj).trySelectDetailed(this, C1133Unit.INSTANCE);
            if (trySelectDetailedResultTrySelectDetailed == TrySelectDetailedResult.REREGISTER) {
                channelSegment.cleanElement$kotlinx_coroutines_core(i);
            }
            return trySelectDetailedResultTrySelectDetailed == TrySelectDetailedResult.SUCCESSFUL;
        }
        if (obj instanceof SendBroadcast) {
            return BufferedChannelKt.tryResume0$default(((SendBroadcast) obj).m7072getCont(), Boolean.TRUE, null, 2, null);
        }
        throw new IllegalStateException(("Unexpected waiter: " + obj).toString());
    }

    private final /* synthetic */ void update$atomicfu$ATOMIC_FIELD_UPDATER$Long(AtomicLongFieldUpdater atomicLongFieldUpdater, Object obj, Function1<? super Long, Long> function1) {
        long j;
        do {
            j = atomicLongFieldUpdater.get(obj);
        } while (!atomicLongFieldUpdater.compareAndSet(obj, j, function1.mo2237invoke(Long.valueOf(j)).longValue()));
    }

    private final boolean updateCellExpandBuffer(ChannelSegment<E> segment, int index, long b) {
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (!(state$kotlinx_coroutines_core instanceof InterfaceC1348Waiter) || b < receivers$volatile$FU.get(this) || !segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
            return updateCellExpandBufferSlow(segment, index, b);
        }
        if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
            segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
            return true;
        }
        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.INTERRUPTED_SEND);
        segment.onCancelledRequest(index, false);
        return false;
    }

    private final boolean updateCellExpandBufferSlow(ChannelSegment<E> segment, int index, long b) {
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core instanceof InterfaceC1348Waiter) {
                if (b < receivers$volatile$FU.get(this)) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, new WaiterEB((InterfaceC1348Waiter) state$kotlinx_coroutines_core))) {
                        return true;
                    }
                } else if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                    if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.BUFFERED);
                        return true;
                    }
                    segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.INTERRUPTED_SEND);
                    segment.onCancelledRequest(index, false);
                    return false;
                }
            } else {
                if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_SEND) {
                    return false;
                }
                if (state$kotlinx_coroutines_core == null) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.IN_BUFFER)) {
                        return true;
                    }
                } else {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED || state$kotlinx_coroutines_core == BufferedChannelKt.POISONED || state$kotlinx_coroutines_core == BufferedChannelKt.DONE_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV || state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        return true;
                    }
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_RCV) {
                        throw new IllegalStateException(("Unexpected cell state: " + state$kotlinx_coroutines_core).toString());
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object updateCellReceive(ChannelSegment<E> segment, int index, long r, Object waiter) {
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (r >= (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                if (waiter == null) {
                    return BufferedChannelKt.SUSPEND_NO_WAITER;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                    expandBuffer();
                    return BufferedChannelKt.f5627SUSPEND;
                }
            }
        } else if (state$kotlinx_coroutines_core == BufferedChannelKt.BUFFERED && segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
            expandBuffer();
            return segment.retrieveElement$kotlinx_coroutines_core(index);
        }
        return updateCellReceiveSlow(segment, index, r, waiter);
    }

    private final Object updateCellReceiveSlow(ChannelSegment<E> segment, int index, long r, Object waiter) {
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core == null || state$kotlinx_coroutines_core == BufferedChannelKt.IN_BUFFER) {
                if (r < (sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L)) {
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.POISONED)) {
                        expandBuffer();
                        return BufferedChannelKt.f5626FAILED;
                    }
                } else {
                    if (waiter == null) {
                        return BufferedChannelKt.SUSPEND_NO_WAITER;
                    }
                    if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, waiter)) {
                        expandBuffer();
                        return BufferedChannelKt.f5627SUSPEND;
                    }
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.BUFFERED) {
                    if (state$kotlinx_coroutines_core != BufferedChannelKt.INTERRUPTED_SEND && state$kotlinx_coroutines_core != BufferedChannelKt.POISONED) {
                        if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                            expandBuffer();
                            return BufferedChannelKt.f5626FAILED;
                        }
                        if (state$kotlinx_coroutines_core != BufferedChannelKt.RESUMING_BY_EB && segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_RCV)) {
                            boolean z = state$kotlinx_coroutines_core instanceof WaiterEB;
                            if (z) {
                                state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                            }
                            if (tryResumeSender(state$kotlinx_coroutines_core, segment, index)) {
                                segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.DONE_RCV);
                                expandBuffer();
                                return segment.retrieveElement$kotlinx_coroutines_core(index);
                            }
                            segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.INTERRUPTED_SEND);
                            segment.onCancelledRequest(index, false);
                            if (z) {
                                expandBuffer();
                            }
                            return BufferedChannelKt.f5626FAILED;
                        }
                    }
                    return BufferedChannelKt.f5626FAILED;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
                    expandBuffer();
                    return segment.retrieveElement$kotlinx_coroutines_core(index);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int updateCellSend(ChannelSegment<E> segment, int index, E element, long s, Object waiter, boolean closed) {
        segment.storeElement$kotlinx_coroutines_core(index, element);
        if (closed) {
            return updateCellSendSlow(segment, index, element, s, waiter, closed);
        }
        Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
        if (state$kotlinx_coroutines_core == null) {
            if (bufferOrRendezvousSend(s)) {
                if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (waiter == null) {
                    return 3;
                }
                if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                    return 2;
                }
            }
        } else if (state$kotlinx_coroutines_core instanceof InterfaceC1348Waiter) {
            segment.cleanElement$kotlinx_coroutines_core(index);
            if (tryResumeReceiver(state$kotlinx_coroutines_core, element)) {
                segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.DONE_RCV);
                onReceiveDequeued();
                return 0;
            }
            if (segment.getAndSetState$kotlinx_coroutines_core(index, BufferedChannelKt.INTERRUPTED_RCV) != BufferedChannelKt.INTERRUPTED_RCV) {
                segment.onCancelledRequest(index, true);
            }
            return 5;
        }
        return updateCellSendSlow(segment, index, element, s, waiter, closed);
    }

    private final int updateCellSendSlow(ChannelSegment<E> segment, int index, E element, long s, Object waiter, boolean closed) {
        while (true) {
            Object state$kotlinx_coroutines_core = segment.getState$kotlinx_coroutines_core(index);
            if (state$kotlinx_coroutines_core == null) {
                if (!bufferOrRendezvousSend(s) || closed) {
                    if (closed) {
                        if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.INTERRUPTED_SEND)) {
                            segment.onCancelledRequest(index, false);
                            return 4;
                        }
                    } else {
                        if (waiter == null) {
                            return 3;
                        }
                        if (segment.casState$kotlinx_coroutines_core(index, null, waiter)) {
                            return 2;
                        }
                    }
                } else if (segment.casState$kotlinx_coroutines_core(index, null, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            } else {
                if (state$kotlinx_coroutines_core != BufferedChannelKt.IN_BUFFER) {
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.INTERRUPTED_RCV) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.POISONED) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        return 5;
                    }
                    if (state$kotlinx_coroutines_core == BufferedChannelKt.getCHANNEL_CLOSED()) {
                        segment.cleanElement$kotlinx_coroutines_core(index);
                        completeCloseOrCancel();
                        return 4;
                    }
                    segment.cleanElement$kotlinx_coroutines_core(index);
                    if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                        state$kotlinx_coroutines_core = ((WaiterEB) state$kotlinx_coroutines_core).waiter;
                    }
                    if (tryResumeReceiver(state$kotlinx_coroutines_core, element)) {
                        segment.setState$kotlinx_coroutines_core(index, BufferedChannelKt.DONE_RCV);
                        onReceiveDequeued();
                        return 0;
                    }
                    if (segment.getAndSetState$kotlinx_coroutines_core(index, BufferedChannelKt.INTERRUPTED_RCV) != BufferedChannelKt.INTERRUPTED_RCV) {
                        segment.onCancelledRequest(index, true);
                    }
                    return 5;
                }
                if (segment.casState$kotlinx_coroutines_core(index, state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED)) {
                    return 1;
                }
            }
        }
    }

    private final void updateReceiversCounterIfLower(long value) {
        long j;
        AtomicLongFieldUpdater atomicLongFieldUpdater = receivers$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            if (j >= value) {
                return;
            }
        } while (!receivers$volatile$FU.compareAndSet(this, j, value));
    }

    private final void updateSendersCounterIfLower(long value) {
        long j;
        long j2;
        AtomicLongFieldUpdater atomicLongFieldUpdater = sendersAndCloseStatus$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
            j2 = 1152921504606846975L & j;
            if (j2 >= value) {
                return;
            }
        } while (!sendersAndCloseStatus$volatile$FU.compareAndSet(this, j, BufferedChannelKt.constructSendersAndCloseStatus(j2, (int) (j >> 60))));
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: cancel */
    public final boolean mo7065cancel(Throwable cause) {
        return cancelImpl$kotlinx_coroutines_core(cause);
    }

    public boolean cancelImpl$kotlinx_coroutines_core(Throwable cause) {
        if (cause == null) {
            cause = new CancellationException("Channel was cancelled");
        }
        return closeOrCancelImpl(cause, true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void checkSegmentStructureInvariants() {
        if (isRendezvousOrUnlimited()) {
            if (bufferEndSegment$volatile$FU.get(this) != BufferedChannelKt.NULL_SEGMENT) {
                throw new IllegalStateException(("bufferEndSegment must be NULL_SEGMENT for rendezvous and unlimited channels; they do not manipulate it.\nChannel state: " + this).toString());
            }
        } else if (((ChannelSegment) receiveSegment$volatile$FU.get(this)).id > ((ChannelSegment) bufferEndSegment$volatile$FU.get(this)).id) {
            throw new IllegalStateException(("bufferEndSegment should not have lower id than receiveSegment.\nChannel state: " + this).toString());
        }
        List listListOf = CollectionsKt.m5806listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((ChannelSegment) obj) != BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((ChannelSegment) next).id;
            do {
                Object next2 = it.next();
                long j2 = ((ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        ChannelSegment channelSegment = (ChannelSegment) next;
        if (channelSegment.m7408getPrev() != 0) {
            throw new IllegalStateException(("All processed segments should be unreachable from the data structure, but the `prev` link of the leftmost segment is non-null.\nChannel state: " + this).toString());
        }
        while (channelSegment.m7407getNext() != 0) {
            S sM7407getNext = channelSegment.m7407getNext();
            Intrinsics.checkNotNull(sM7407getNext);
            if (((ChannelSegment) sM7407getNext).m7408getPrev() != 0) {
                S sM7407getNext2 = channelSegment.m7407getNext();
                Intrinsics.checkNotNull(sM7407getNext2);
                if (((ChannelSegment) sM7407getNext2).m7408getPrev() != channelSegment) {
                    throw new IllegalStateException(("The `segment.next.prev === segment` invariant is violated.\nChannel state: " + this).toString());
                }
            }
            int i = BufferedChannelKt.SEGMENT_SIZE;
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i3);
                if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.BUFFERED) && !(state$kotlinx_coroutines_core instanceof InterfaceC1348Waiter)) {
                    if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.INTERRUPTED_RCV) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.INTERRUPTED_SEND) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                        if (channelSegment.getElement$kotlinx_coroutines_core(i3) != null) {
                            throw new IllegalStateException("Check failed.");
                        }
                        i2++;
                    } else {
                        if (!Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.POISONED) && !Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV)) {
                            throw new IllegalStateException(("Unexpected segment cell state: " + state$kotlinx_coroutines_core + ".\nChannel state: " + this).toString());
                        }
                        if (channelSegment.getElement$kotlinx_coroutines_core(i3) != null) {
                            throw new IllegalStateException("Check failed.");
                        }
                    }
                }
            }
            if (i2 == BufferedChannelKt.SEGMENT_SIZE && channelSegment != receiveSegment$volatile$FU.get(this) && channelSegment != sendSegment$volatile$FU.get(this) && channelSegment != bufferEndSegment$volatile$FU.get(this)) {
                throw new IllegalStateException(("Logically removed segment is reachable.\nChannel state: " + this).toString());
            }
            S sM7407getNext3 = channelSegment.m7407getNext();
            Intrinsics.checkNotNull(sM7407getNext3);
            channelSegment = (ChannelSegment) sM7407getNext3;
        }
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: close */
    public boolean mo7051close(Throwable cause) {
        return closeOrCancelImpl(cause, false);
    }

    public boolean closeOrCancelImpl(Throwable cause, boolean cancel) {
        if (cancel) {
            markCancellationStarted();
        }
        boolean zM8064mjFkc = AbstractC1852Dt.m8064mjFkc(_closeCause$volatile$FU, this, BufferedChannelKt.NO_CLOSE_CAUSE, cause);
        if (cancel) {
            markCancelled();
        } else {
            markClosed();
        }
        completeCloseOrCancel();
        onClosedIdempotent();
        if (zM8064mjFkc) {
            invokeCloseHandler();
        }
        return zM8064mjFkc;
    }

    public final void dropFirstElementUntilTheSpecifiedCellIsInTheBuffer(long globalCellIndex) {
        UndeliveredElementException undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
        ChannelSegment<E> channelSegment = (ChannelSegment) receiveSegment$volatile$FU.get(this);
        while (true) {
            long j = receivers$volatile$FU.get(this);
            if (globalCellIndex < Math.max(this.capacity + j, getBufferEndCounter())) {
                return;
            }
            if (receivers$volatile$FU.compareAndSet(this, j, j + 1)) {
                int i = BufferedChannelKt.SEGMENT_SIZE;
                long j2 = j / i;
                int i2 = (int) (j % i);
                if (channelSegment.id != j2) {
                    ChannelSegment<E> channelSegmentFindSegmentReceive = findSegmentReceive(j2, channelSegment);
                    if (channelSegmentFindSegmentReceive == null) {
                        continue;
                    } else {
                        channelSegment = channelSegmentFindSegmentReceive;
                    }
                }
                Object objUpdateCellReceive = updateCellReceive(channelSegment, i2, j, null);
                if (objUpdateCellReceive != BufferedChannelKt.f5626FAILED) {
                    channelSegment.cleanPrev();
                    Function1<E, C1133Unit> function1 = this.onUndeliveredElement;
                    if (function1 != null && (undeliveredElementExceptionCallUndeliveredElementCatchingException$default = OnUndeliveredElementKt.callUndeliveredElementCatchingException$default(function1, objUpdateCellReceive, null, 2, null)) != null) {
                        throw undeliveredElementExceptionCallUndeliveredElementCatchingException$default;
                    }
                } else if (j < getSendersCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            }
        }
    }

    public final Throwable getCloseCause() {
        return (Throwable) _closeCause$volatile$FU.get(this);
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceive() {
        BufferedChannel$onReceive$1 bufferedChannel$onReceive$1 = BufferedChannel$onReceive$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$1, 3);
        BufferedChannel$onReceive$2 bufferedChannel$onReceive$2 = BufferedChannel$onReceive$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceive$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceive$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<ChannelResult<E>> getOnReceiveCatching() {
        BufferedChannel$onReceiveCatching$1 bufferedChannel$onReceiveCatching$1 = BufferedChannel$onReceiveCatching$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$1, 3);
        BufferedChannel$onReceiveCatching$2 bufferedChannel$onReceiveCatching$2 = BufferedChannel$onReceiveCatching$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveCatching$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveCatching$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    public SelectClause1<E> getOnReceiveOrNull() {
        BufferedChannel$onReceiveOrNull$1 bufferedChannel$onReceiveOrNull$1 = BufferedChannel$onReceiveOrNull$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$1, 3);
        BufferedChannel$onReceiveOrNull$2 bufferedChannel$onReceiveOrNull$2 = BufferedChannel$onReceiveOrNull$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onReceiveOrNull$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause1Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onReceiveOrNull$2, 3), this.onUndeliveredElementReceiveCancellationConstructor);
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public SelectClause2<E, BufferedChannel<E>> getOnSend() {
        BufferedChannel$onSend$1 bufferedChannel$onSend$1 = BufferedChannel$onSend$1.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$1, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"select\")] kotlinx.coroutines.selects.SelectInstance<*>, @[ParameterName(name = \"param\")] kotlin.Any?, kotlin.Unit>");
        Function3 function3 = (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$1, 3);
        BufferedChannel$onSend$2 bufferedChannel$onSend$2 = BufferedChannel$onSend$2.INSTANCE;
        Intrinsics.checkNotNull(bufferedChannel$onSend$2, "null cannot be cast to non-null type kotlin.Function3<@[ParameterName(name = \"clauseObject\")] kotlin.Any, @[ParameterName(name = \"param\")] kotlin.Any?, @[ParameterName(name = \"clauseResult\")] kotlin.Any?, kotlin.Any?>");
        return new SelectClause2Impl(this, function3, (Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(bufferedChannel$onSend$2, 3), null, 8, null);
    }

    public final long getReceiversCounter$kotlinx_coroutines_core() {
        return receivers$volatile$FU.get(this);
    }

    public final Throwable getSendException() {
        Throwable closeCause = getCloseCause();
        return closeCause == null ? new ClosedSendChannelException(ChannelsKt.DEFAULT_CLOSE_MESSAGE) : closeCause;
    }

    public final long getSendersCounter$kotlinx_coroutines_core() {
        return sendersAndCloseStatus$volatile$FU.get(this) & 1152921504606846975L;
    }

    public final boolean hasElements$kotlinx_coroutines_core() {
        while (true) {
            ChannelSegment<E> channelSegmentFindSegmentReceive = (ChannelSegment) receiveSegment$volatile$FU.get(this);
            long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
            if (getSendersCounter$kotlinx_coroutines_core() <= receiversCounter$kotlinx_coroutines_core) {
                return false;
            }
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j = receiversCounter$kotlinx_coroutines_core / i;
            if (channelSegmentFindSegmentReceive.id == j || (channelSegmentFindSegmentReceive = findSegmentReceive(j, channelSegmentFindSegmentReceive)) != null) {
                channelSegmentFindSegmentReceive.cleanPrev();
                if (isCellNonEmpty(channelSegmentFindSegmentReceive, (int) (receiversCounter$kotlinx_coroutines_core % i), receiversCounter$kotlinx_coroutines_core)) {
                    return true;
                }
                receivers$volatile$FU.compareAndSet(this, receiversCounter$kotlinx_coroutines_core, 1 + receiversCounter$kotlinx_coroutines_core);
            } else if (((ChannelSegment) receiveSegment$volatile$FU.get(this)).id < j) {
                return false;
            }
        }
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public void invokeOnClose(Function1<? super Throwable, C1133Unit> handler) {
        if (AbstractC1852Dt.m8064mjFkc(closeHandler$volatile$FU, this, null, handler)) {
            return;
        }
        AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = closeHandler$volatile$FU;
        do {
            Object obj = atomicReferenceFieldUpdater.get(this);
            if (obj != BufferedChannelKt.CLOSE_HANDLER_CLOSED) {
                if (obj == BufferedChannelKt.CLOSE_HANDLER_INVOKED) {
                    throw new IllegalStateException("Another handler was already registered and successfully invoked");
                }
                throw new IllegalStateException(("Another handler is already registered: " + obj).toString());
            }
        } while (!AbstractC1852Dt.m8064mjFkc(closeHandler$volatile$FU, this, BufferedChannelKt.CLOSE_HANDLER_CLOSED, BufferedChannelKt.CLOSE_HANDLER_INVOKED));
        handler.mo2237invoke(getCloseCause());
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    public boolean isClosedForReceive() {
        return isClosedForReceive0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    public boolean isClosedForSend() {
        return isClosedForSend0(sendersAndCloseStatus$volatile$FU.get(this));
    }

    public boolean isConflatedDropOldest() {
        return false;
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: isEmpty */
    public boolean mo7066isEmpty() {
        if (isClosedForReceive() || hasElements$kotlinx_coroutines_core()) {
            return false;
        }
        return !isClosedForReceive();
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    public ChannelIterator<E> iterator() {
        return new BufferedChannelIterator();
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'trySend' method", replaceWith = @ReplaceWith(expression = "trySend(element).isSuccess", m5048imports = {}))
    /* renamed from: offer */
    public /* bridge */ boolean mo7053offer(E e) {
        return super.mo7053offer(e);
    }

    public void onClosedIdempotent() {
    }

    public void onReceiveDequeued() {
    }

    public void onReceiveEnqueued() {
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in the favour of 'tryReceive'. Please note that the provided replacement does not rethrow channel's close cause as 'poll' did, for the precise replacement please refer to the 'poll' documentation", replaceWith = @ReplaceWith(expression = "tryReceive().getOrNull()", m5048imports = {}))
    /* renamed from: poll */
    public /* bridge */ E mo7067poll() {
        return (E) super.mo7067poll();
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receive */
    public Object mo7068receive(Continuation<? super E> continuation) {
        return receive$suspendImpl(this, continuation);
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: receiveCatching-JP2dKIU, reason: not valid java name */
    public Object mo19995receiveCatchingJP2dKIU(Continuation<? super ChannelResult<? extends E>> continuation) {
        return m19993receiveCatchingJP2dKIU$suspendImpl(this, continuation);
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Deprecated in favor of 'receiveCatching'. Please note that the provided replacement does not rethrow channel's close cause as 'receiveOrNull' did, for the detailed replacement please refer to the 'receiveOrNull' documentation", replaceWith = @ReplaceWith(expression = "receiveCatching().getOrNull()", m5048imports = {}))
    @LowPriorityInOverloadResolution
    public /* bridge */ Object receiveOrNull(Continuation<? super E> continuation) {
        return super.receiveOrNull(continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0082, code lost:
    
        r14.selectInRegistrationPhase(p094kotlin.C1133Unit.INSTANCE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:?, code lost:
    
        return;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void registerSelectForSend(SelectInstance<?> select, Object element) {
        ChannelSegment channelSegment = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = 1152921504606846975L & andIncrement;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (channelSegment.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    break;
                }
            }
            int iUpdateCellSend = updateCellSend(channelSegment, i2, element, j, select, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            }
            if (iUpdateCellSend == 1) {
                break;
            }
            if (iUpdateCellSend != 2) {
                if (iUpdateCellSend == 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iUpdateCellSend != 4) {
                    if (iUpdateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                } else if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else {
                if (!zIsClosedForSend0) {
                    InterfaceC1348Waiter interfaceC1348Waiter = select instanceof InterfaceC1348Waiter ? (InterfaceC1348Waiter) select : null;
                    if (interfaceC1348Waiter != null) {
                        prepareSenderForSuspension(interfaceC1348Waiter, channelSegment, i2);
                        return;
                    }
                    return;
                }
                channelSegment.onSlotCleaned();
            }
        }
        onClosedSelectOnSend(element, select);
    }

    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: send */
    public Object mo7052send(E e, Continuation<? super C1133Unit> continuation) {
        return send$suspendImpl(this, e, continuation);
    }

    public Object sendBroadcast$kotlinx_coroutines_core(E e, Continuation<? super Boolean> continuation) {
        return sendBroadcast$suspendImpl(this, e, continuation);
    }

    public final <R> R sendImpl(E element, Object waiter, Function0<? extends R> onRendezvousOrBuffered, Function2<? super ChannelSegment<E>, ? super Integer, ? extends R> onSuspend, Function0<? extends R> onClosed, Function4<? super ChannelSegment<E>, ? super Integer, ? super E, ? super Long, ? extends R> onNoWaiterSuspend) {
        ChannelSegment channelSegment;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (channelSegment2.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    return onClosed.mo4323invoke();
                }
            } else {
                channelSegment = channelSegment2;
            }
            int iUpdateCellSend = updateCellSend(channelSegment, i2, element, j, waiter, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                return onRendezvousOrBuffered.mo4323invoke();
            }
            if (iUpdateCellSend == 1) {
                return onRendezvousOrBuffered.mo4323invoke();
            }
            if (iUpdateCellSend == 2) {
                if (zIsClosedForSend0) {
                    channelSegment.onSlotCleaned();
                    return onClosed.mo4323invoke();
                }
                InterfaceC1348Waiter interfaceC1348Waiter = waiter instanceof InterfaceC1348Waiter ? (InterfaceC1348Waiter) waiter : null;
                if (interfaceC1348Waiter != null) {
                    prepareSenderForSuspension(interfaceC1348Waiter, channelSegment, i2);
                }
                return onSuspend.mo2167invoke(channelSegment, Integer.valueOf(i2));
            }
            if (iUpdateCellSend == 3) {
                return onNoWaiterSuspend.mo6276invoke(channelSegment, Integer.valueOf(i2), element, Long.valueOf(j));
            }
            if (iUpdateCellSend == 4) {
                if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
                return onClosed.mo4323invoke();
            }
            if (iUpdateCellSend == 5) {
                channelSegment.cleanPrev();
            }
            channelSegment2 = channelSegment;
        }
    }

    public boolean shouldSendSuspend$kotlinx_coroutines_core() {
        return shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this));
    }

    /* JADX WARN: Code restructure failed: missing block: B:90:0x01dc, code lost:
    
        r3 = (p122kotlinx.coroutines.channels.ChannelSegment) r3.m7407getNext();
     */
    /* JADX WARN: Code restructure failed: missing block: B:91:0x01e3, code lost:
    
        if (r3 != null) goto L97;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public String toString() {
        String string;
        StringBuilder sb = new StringBuilder();
        int i = (int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60);
        if (i == 2) {
            sb.append("closed,");
        } else if (i == 3) {
            sb.append("cancelled,");
        }
        sb.append("capacity=" + this.capacity + ',');
        sb.append("data=[");
        int i2 = 0;
        List listListOf = CollectionsKt.m5806listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((ChannelSegment) obj) != BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((ChannelSegment) next).id;
            do {
                Object next2 = it.next();
                long j2 = ((ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        ChannelSegment channelSegment = (ChannelSegment) next;
        long receiversCounter$kotlinx_coroutines_core = getReceiversCounter$kotlinx_coroutines_core();
        long sendersCounter$kotlinx_coroutines_core = getSendersCounter$kotlinx_coroutines_core();
        loop2: while (true) {
            int i3 = BufferedChannelKt.SEGMENT_SIZE;
            int i4 = i2;
            while (true) {
                if (i4 >= i3) {
                    break;
                }
                long j3 = (channelSegment.id * BufferedChannelKt.SEGMENT_SIZE) + i4;
                if (j3 >= sendersCounter$kotlinx_coroutines_core && j3 >= receiversCounter$kotlinx_coroutines_core) {
                    break loop2;
                }
                Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i4);
                Object element$kotlinx_coroutines_core = channelSegment.getElement$kotlinx_coroutines_core(i4);
                if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                    string = (sendersCounter$kotlinx_coroutines_core > j3 || j3 >= receiversCounter$kotlinx_coroutines_core) ? (receiversCounter$kotlinx_coroutines_core > j3 || j3 >= sendersCounter$kotlinx_coroutines_core) ? "cont" : "send" : "receive";
                } else if (state$kotlinx_coroutines_core instanceof SelectInstance) {
                    string = (sendersCounter$kotlinx_coroutines_core > j3 || j3 >= receiversCounter$kotlinx_coroutines_core) ? (receiversCounter$kotlinx_coroutines_core > j3 || j3 >= sendersCounter$kotlinx_coroutines_core) ? "select" : "onSend" : "onReceive";
                } else if (state$kotlinx_coroutines_core instanceof ReceiveCatching) {
                    string = "receiveCatching";
                } else if (state$kotlinx_coroutines_core instanceof SendBroadcast) {
                    string = "sendBroadcast";
                } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    string = "EB(" + state$kotlinx_coroutines_core + ')';
                } else if (Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_RCV) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.RESUMING_BY_EB)) {
                    string = "resuming_sender";
                } else if (state$kotlinx_coroutines_core == null || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.IN_BUFFER) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.DONE_RCV) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.POISONED) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.INTERRUPTED_RCV) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.INTERRUPTED_SEND) || Intrinsics.areEqual(state$kotlinx_coroutines_core, BufferedChannelKt.getCHANNEL_CLOSED())) {
                    i4++;
                } else {
                    string = state$kotlinx_coroutines_core.toString();
                }
                if (element$kotlinx_coroutines_core != null) {
                    sb.append('(' + string + ',' + element$kotlinx_coroutines_core + "),");
                } else {
                    sb.append(string + ',');
                }
                i4++;
            }
            i2 = 0;
        }
        if (StringsKt.m6819last(sb) == ',') {
            Intrinsics.checkNotNullExpressionValue(sb.deleteCharAt(sb.length() - 1), "deleteCharAt(...)");
        }
        sb.append("]");
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final String toStringDebug$kotlinx_coroutines_core() {
        String strValueOf;
        StringBuilder sb = new StringBuilder();
        sb.append("S=" + getSendersCounter$kotlinx_coroutines_core() + ",R=" + getReceiversCounter$kotlinx_coroutines_core() + ",B=" + getBufferEndCounter() + ",B'=" + completedExpandBuffersAndPauseFlag$volatile$FU.get(this) + ",C=" + ((int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60)) + ',');
        int i = (int) (sendersAndCloseStatus$volatile$FU.get(this) >> 60);
        if (i == 1) {
            sb.append("CANCELLATION_STARTED,");
        } else if (i == 2) {
            sb.append("CLOSED,");
        } else if (i == 3) {
            sb.append("CANCELLED,");
        }
        sb.append("SEND_SEGM=" + DebugStringsKt.getHexAddress(sendSegment$volatile$FU.get(this)) + ",RCV_SEGM=" + DebugStringsKt.getHexAddress(receiveSegment$volatile$FU.get(this)));
        if (!isRendezvousOrUnlimited()) {
            sb.append(",EB_SEGM=" + DebugStringsKt.getHexAddress(bufferEndSegment$volatile$FU.get(this)));
        }
        sb.append("  ");
        List listListOf = CollectionsKt.m5806listOf((Object[]) new ChannelSegment[]{receiveSegment$volatile$FU.get(this), sendSegment$volatile$FU.get(this), bufferEndSegment$volatile$FU.get(this)});
        ArrayList arrayList = new ArrayList();
        for (Object obj : listListOf) {
            if (((ChannelSegment) obj) != BufferedChannelKt.NULL_SEGMENT) {
                arrayList.add(obj);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            throw new NoSuchElementException();
        }
        Object next = it.next();
        if (it.hasNext()) {
            long j = ((ChannelSegment) next).id;
            do {
                Object next2 = it.next();
                long j2 = ((ChannelSegment) next2).id;
                if (j > j2) {
                    next = next2;
                    j = j2;
                }
            } while (it.hasNext());
        }
        ChannelSegment channelSegment = (ChannelSegment) next;
        do {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(DebugStringsKt.getHexAddress(channelSegment));
            sb2.append("=[");
            sb2.append(channelSegment.isRemoved() ? "*" : BuildConfig.f24315FLAVOR);
            sb2.append(channelSegment.id);
            sb2.append(",prev=");
            ChannelSegment channelSegment2 = (ChannelSegment) channelSegment.m7408getPrev();
            sb2.append(channelSegment2 != null ? DebugStringsKt.getHexAddress(channelSegment2) : null);
            sb2.append(',');
            sb.append(sb2.toString());
            int i2 = BufferedChannelKt.SEGMENT_SIZE;
            for (int i3 = 0; i3 < i2; i3++) {
                Object state$kotlinx_coroutines_core = channelSegment.getState$kotlinx_coroutines_core(i3);
                Object element$kotlinx_coroutines_core = channelSegment.getElement$kotlinx_coroutines_core(i3);
                if (state$kotlinx_coroutines_core instanceof CancellableContinuation) {
                    strValueOf = "cont";
                } else if (state$kotlinx_coroutines_core instanceof SelectInstance) {
                    strValueOf = "select";
                } else if (state$kotlinx_coroutines_core instanceof ReceiveCatching) {
                    strValueOf = "receiveCatching";
                } else if (state$kotlinx_coroutines_core instanceof SendBroadcast) {
                    strValueOf = "send(broadcast)";
                } else if (state$kotlinx_coroutines_core instanceof WaiterEB) {
                    strValueOf = "EB(" + state$kotlinx_coroutines_core + ')';
                } else {
                    strValueOf = String.valueOf(state$kotlinx_coroutines_core);
                }
                sb.append('[' + i3 + "]=(" + strValueOf + ',' + element$kotlinx_coroutines_core + "),");
            }
            StringBuilder sb3 = new StringBuilder();
            sb3.append("next=");
            ChannelSegment channelSegment3 = (ChannelSegment) channelSegment.m7407getNext();
            sb3.append(channelSegment3 != null ? DebugStringsKt.getHexAddress(channelSegment3) : null);
            sb3.append("]  ");
            sb.append(sb3.toString());
            channelSegment = (ChannelSegment) channelSegment.m7407getNext();
        } while (channelSegment != null);
        return sb.toString();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: tryReceive-PtdJZtk, reason: not valid java name */
    public Object mo19996tryReceivePtdJZtk() {
        ChannelSegment channelSegment;
        long j = receivers$volatile$FU.get(this);
        long j2 = sendersAndCloseStatus$volatile$FU.get(this);
        if (isClosedForReceive0(j2)) {
            return ChannelResult.INSTANCE.m20015closedJP2dKIU(getCloseCause());
        }
        if (j >= (j2 & 1152921504606846975L)) {
            return ChannelResult.INSTANCE.m20016failurePtdJZtk();
        }
        Object obj = BufferedChannelKt.INTERRUPTED_RCV;
        ChannelSegment channelSegment2 = (ChannelSegment) getReceiveSegment$volatile$FU().get(this);
        while (!isClosedForReceive()) {
            long andIncrement = getReceivers$volatile$FU().getAndIncrement(this);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j3 = andIncrement / i;
            int i2 = (int) (andIncrement % i);
            if (channelSegment2.id != j3) {
                ChannelSegment channelSegmentFindSegmentReceive = findSegmentReceive(j3, channelSegment2);
                if (channelSegmentFindSegmentReceive == null) {
                    continue;
                } else {
                    channelSegment = channelSegmentFindSegmentReceive;
                }
            } else {
                channelSegment = channelSegment2;
            }
            Object objUpdateCellReceive = updateCellReceive(channelSegment, i2, andIncrement, obj);
            if (objUpdateCellReceive == BufferedChannelKt.f5627SUSPEND) {
                InterfaceC1348Waiter interfaceC1348Waiter = obj instanceof InterfaceC1348Waiter ? (InterfaceC1348Waiter) obj : null;
                if (interfaceC1348Waiter != null) {
                    prepareReceiverForSuspension(interfaceC1348Waiter, channelSegment, i2);
                }
                waitExpandBufferCompletion$kotlinx_coroutines_core(andIncrement);
                channelSegment.onSlotCleaned();
                return ChannelResult.INSTANCE.m20016failurePtdJZtk();
            }
            if (objUpdateCellReceive != BufferedChannelKt.f5626FAILED) {
                if (objUpdateCellReceive == BufferedChannelKt.SUSPEND_NO_WAITER) {
                    throw new IllegalStateException("unexpected");
                }
                channelSegment.cleanPrev();
                return ChannelResult.INSTANCE.m20017successJP2dKIU(objUpdateCellReceive);
            }
            if (andIncrement < getSendersCounter$kotlinx_coroutines_core()) {
                channelSegment.cleanPrev();
            }
            channelSegment2 = channelSegment;
        }
        return ChannelResult.INSTANCE.m20015closedJP2dKIU(getCloseCause());
    }

    /* JADX WARN: Code restructure failed: missing block: B:60:?, code lost:
    
        return p122kotlinx.coroutines.channels.ChannelResult.INSTANCE.m20017successJP2dKIU(p094kotlin.C1133Unit.INSTANCE);
     */
    @Override // p122kotlinx.coroutines.channels.SendChannel
    /* renamed from: trySend-JP2dKIU */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Object mo19989trySendJP2dKIU(E element) {
        ChannelSegment channelSegment;
        if (shouldSendSuspend(sendersAndCloseStatus$volatile$FU.get(this))) {
            return ChannelResult.INSTANCE.m20016failurePtdJZtk();
        }
        Object obj = BufferedChannelKt.INTERRUPTED_SEND;
        ChannelSegment channelSegment2 = (ChannelSegment) sendSegment$volatile$FU.get(this);
        while (true) {
            long andIncrement = sendersAndCloseStatus$volatile$FU.getAndIncrement(this);
            long j = andIncrement & 1152921504606846975L;
            boolean zIsClosedForSend0 = isClosedForSend0(andIncrement);
            int i = BufferedChannelKt.SEGMENT_SIZE;
            long j2 = j / i;
            int i2 = (int) (j % i);
            if (channelSegment2.id != j2) {
                ChannelSegment channelSegmentFindSegmentSend = findSegmentSend(j2, channelSegment2);
                if (channelSegmentFindSegmentSend != null) {
                    channelSegment = channelSegmentFindSegmentSend;
                } else if (zIsClosedForSend0) {
                    break;
                }
            } else {
                channelSegment = channelSegment2;
            }
            int iUpdateCellSend = updateCellSend(channelSegment, i2, element, j, obj, zIsClosedForSend0);
            if (iUpdateCellSend == 0) {
                channelSegment.cleanPrev();
                break;
            }
            if (iUpdateCellSend == 1) {
                break;
            }
            if (iUpdateCellSend != 2) {
                if (iUpdateCellSend == 3) {
                    throw new IllegalStateException("unexpected");
                }
                if (iUpdateCellSend != 4) {
                    if (iUpdateCellSend == 5) {
                        channelSegment.cleanPrev();
                    }
                    channelSegment2 = channelSegment;
                } else if (j < getReceiversCounter$kotlinx_coroutines_core()) {
                    channelSegment.cleanPrev();
                }
            } else {
                if (!zIsClosedForSend0) {
                    InterfaceC1348Waiter interfaceC1348Waiter = obj instanceof InterfaceC1348Waiter ? (InterfaceC1348Waiter) obj : null;
                    if (interfaceC1348Waiter != null) {
                        prepareSenderForSuspension(interfaceC1348Waiter, channelSegment, i2);
                    }
                    channelSegment.onSlotCleaned();
                    return ChannelResult.INSTANCE.m20016failurePtdJZtk();
                }
                channelSegment.onSlotCleaned();
            }
        }
        return ChannelResult.INSTANCE.m20015closedJP2dKIU(getSendException());
    }

    public final void waitExpandBufferCompletion$kotlinx_coroutines_core(long globalIndex) {
        long j;
        long j2;
        if (isRendezvousOrUnlimited()) {
            return;
        }
        while (getBufferEndCounter() <= globalIndex) {
        }
        int i = BufferedChannelKt.EXPAND_BUFFER_COMPLETION_WAIT_ITERATIONS;
        for (int i2 = 0; i2 < i; i2++) {
            long bufferEndCounter = getBufferEndCounter();
            if (bufferEndCounter == (completedExpandBuffersAndPauseFlag$volatile$FU.get(this) & DurationKt.MAX_MILLIS) && bufferEndCounter == getBufferEndCounter()) {
                return;
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater = completedExpandBuffersAndPauseFlag$volatile$FU;
        do {
            j = atomicLongFieldUpdater.get(this);
        } while (!atomicLongFieldUpdater.compareAndSet(this, j, BufferedChannelKt.constructEBCompletedAndPauseFlag(j & DurationKt.MAX_MILLIS, true)));
        while (true) {
            long bufferEndCounter2 = getBufferEndCounter();
            long j3 = completedExpandBuffersAndPauseFlag$volatile$FU.get(this);
            long j4 = j3 & DurationKt.MAX_MILLIS;
            boolean z = (4611686018427387904L & j3) != 0;
            if (bufferEndCounter2 == j4 && bufferEndCounter2 == getBufferEndCounter()) {
                break;
            } else if (!z) {
                completedExpandBuffersAndPauseFlag$volatile$FU.compareAndSet(this, j3, BufferedChannelKt.constructEBCompletedAndPauseFlag(j4, true));
            }
        }
        AtomicLongFieldUpdater atomicLongFieldUpdater2 = completedExpandBuffersAndPauseFlag$volatile$FU;
        do {
            j2 = atomicLongFieldUpdater2.get(this);
        } while (!atomicLongFieldUpdater2.compareAndSet(this, j2, BufferedChannelKt.constructEBCompletedAndPauseFlag(j2 & DurationKt.MAX_MILLIS, false)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final KFunction<C1133Unit> bindCancellationFun(Function1<? super E, C1133Unit> function1) {
        return new C13562(this);
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: cancel */
    public final void mo7063cancel() {
        cancelImpl$kotlinx_coroutines_core(null);
    }

    @Override // p122kotlinx.coroutines.channels.ReceiveChannel
    /* renamed from: cancel */
    public final void mo7064cancel(CancellationException cause) {
        cancelImpl$kotlinx_coroutines_core(cause);
    }

    public /* synthetic */ BufferedChannel(int i, Function1 function1, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, (i2 & 2) != 0 ? null : function1);
    }
}
