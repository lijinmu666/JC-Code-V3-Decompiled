package p122kotlinx.coroutines.p125flow;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p094kotlin.C1122Pair;
import p094kotlin.C1133Unit;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.OverloadResolutionByLambdaReturnType;
import p094kotlin.PublishedApi;
import p094kotlin.ReplaceWith;
import p094kotlin.collections.IndexedValue;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.CoroutineContext;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.functions.Function4;
import p094kotlin.p105jvm.functions.Function5;
import p094kotlin.p105jvm.functions.Function6;
import p094kotlin.p105jvm.functions.Function7;
import p094kotlin.p112ranges.IntRange;
import p094kotlin.p112ranges.LongRange;
import p094kotlin.p113reflect.InterfaceC1242KClass;
import p094kotlin.p119time.Duration;
import p094kotlin.sequences.Sequence;
import p122kotlinx.coroutines.CoroutineScope;
import p122kotlinx.coroutines.ExperimentalCoroutinesApi;
import p122kotlinx.coroutines.FlowPreview;
import p122kotlinx.coroutines.InterfaceC1342Job;
import p122kotlinx.coroutines.channels.BufferOverflow;
import p122kotlinx.coroutines.channels.ProducerScope;
import p122kotlinx.coroutines.channels.ReceiveChannel;

@Metadata(m4987d1 = {"kotlinx/coroutines/flow/FlowKt__BuildersKt", "kotlinx/coroutines/flow/FlowKt__ChannelsKt", "kotlinx/coroutines/flow/FlowKt__CollectKt", "kotlinx/coroutines/flow/FlowKt__CollectionKt", "kotlinx/coroutines/flow/FlowKt__ContextKt", "kotlinx/coroutines/flow/FlowKt__CountKt", "kotlinx/coroutines/flow/FlowKt__DelayKt", "kotlinx/coroutines/flow/FlowKt__DistinctKt", "kotlinx/coroutines/flow/FlowKt__EmittersKt", "kotlinx/coroutines/flow/FlowKt__ErrorsKt", "kotlinx/coroutines/flow/FlowKt__LimitKt", "kotlinx/coroutines/flow/FlowKt__LogicKt", "kotlinx/coroutines/flow/FlowKt__MergeKt", "kotlinx/coroutines/flow/FlowKt__MigrationKt", "kotlinx/coroutines/flow/FlowKt__ReduceKt", "kotlinx/coroutines/flow/FlowKt__ShareKt", "kotlinx/coroutines/flow/FlowKt__TransformKt", "kotlinx/coroutines/flow/FlowKt__ZipKt"}, m4989k = 4, m4990mv = {2, 2, 0}, m4992xi = 48)
/* renamed from: kotlinx.coroutines.flow.FlowKt */
/* loaded from: classes.dex */
public final class C1427FlowKt {
    public static final String DEFAULT_CONCURRENCY_PROPERTY_NAME = "kotlinx.coroutines.flow.defaultConcurrency";

    /* renamed from: all */
    public static final <T> Object m7182all(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Boolean> continuation) {
        return FlowKt__LogicKt.m7297all(interfaceC1426Flow, function2, continuation);
    }

    /* renamed from: any */
    public static final <T> Object m7183any(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Boolean> continuation) {
        return FlowKt__LogicKt.m7298any(interfaceC1426Flow, function2, continuation);
    }

    /* renamed from: asFlow */
    public static final <T> InterfaceC1426Flow<T> m7184asFlow(Iterable<? extends T> iterable) {
        return FlowKt__BuildersKt.m7254asFlow(iterable);
    }

    public static final <T> SharedFlow<T> asSharedFlow(MutableSharedFlow<T> mutableSharedFlow) {
        return FlowKt__ShareKt.asSharedFlow(mutableSharedFlow);
    }

    public static final <T> StateFlow<T> asStateFlow(MutableStateFlow<T> mutableStateFlow) {
        return FlowKt__ShareKt.asStateFlow(mutableStateFlow);
    }

    public static final <T, K, V> Object associate(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1122Pair<? extends K, ? extends V>>, ? extends Object> function2, Continuation<? super Map<K, ? extends V>> continuation) {
        return FlowKt__CollectionKt.associate(interfaceC1426Flow, function2, continuation);
    }

    public static final <T, K> Object associateBy(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super Map<K, ? extends T>> continuation) {
        return FlowKt__CollectionKt.associateBy(interfaceC1426Flow, function2, continuation);
    }

    public static final <T, K, M extends Map<? super K, ? super T>> Object associateByTo(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super M> continuation) {
        return FlowKt__CollectionKt.associateByTo(interfaceC1426Flow, m, function2, continuation);
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> Object associateTo(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super C1122Pair<? extends K, ? extends V>>, ? extends Object> function2, Continuation<? super M> continuation) {
        return FlowKt__CollectionKt.associateTo(interfaceC1426Flow, m, function2, continuation);
    }

    public static final <K, V> Object associateWith(InterfaceC1426Flow<? extends K> interfaceC1426Flow, Function2<? super K, ? super Continuation<? super V>, ? extends Object> function2, Continuation<? super Map<K, ? extends V>> continuation) {
        return FlowKt__CollectionKt.associateWith(interfaceC1426Flow, function2, continuation);
    }

    public static final <K, V, M extends Map<? super K, ? super V>> Object associateWithTo(InterfaceC1426Flow<? extends K> interfaceC1426Flow, M m, Function2<? super K, ? super Continuation<? super V>, ? extends Object> function2, Continuation<? super M> continuation) {
        return FlowKt__CollectionKt.associateWithTo(interfaceC1426Flow, m, function2, continuation);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'cache()' is 'shareIn' with unlimited replay and 'started = SharingStarted.Lazily' argument'", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, started = SharingStarted.Lazily, replay = Int.MAX_VALUE)", m5048imports = {}))
    /* renamed from: cache */
    public static final <T> InterfaceC1426Flow<T> m7197cache(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return FlowKt__MigrationKt.m7305cache(interfaceC1426Flow);
    }

    public static final <T> InterfaceC1426Flow<T> callbackFlow(Function2<? super ProducerScope<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.callbackFlow(function2);
    }

    public static final <T> InterfaceC1426Flow<T> cancellable(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return FlowKt__ContextKt.cancellable(interfaceC1426Flow);
    }

    /* renamed from: catch */
    public static final <T> InterfaceC1426Flow<T> m7198catch(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        return FlowKt__ErrorsKt.m7291catch(interfaceC1426Flow, function3);
    }

    public static final <T> Object catchImpl(InterfaceC1426Flow<? extends T> interfaceC1426Flow, FlowCollector<? super T> flowCollector, Continuation<? super Throwable> continuation) {
        return FlowKt__ErrorsKt.catchImpl(interfaceC1426Flow, flowCollector, continuation);
    }

    public static final <T> InterfaceC1426Flow<T> channelFlow(Function2<? super ProducerScope<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.channelFlow(function2);
    }

    @ExperimentalCoroutinesApi
    /* renamed from: chunked */
    public static final <T> InterfaceC1426Flow<List<T>> m7199chunked(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        return FlowKt__TransformKt.m7333chunked(interfaceC1426Flow, i);
    }

    /* renamed from: collect */
    public static final Object m7200collect(InterfaceC1426Flow<?> interfaceC1426Flow, Continuation<? super C1133Unit> continuation) {
        return FlowKt__CollectKt.m7268collect(interfaceC1426Flow, continuation);
    }

    public static final <T> Object collectIndexed(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super Integer, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3, Continuation<? super C1133Unit> continuation) {
        return FlowKt__CollectKt.collectIndexed(interfaceC1426Flow, function3, continuation);
    }

    public static final <T> Object collectLatest(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2, Continuation<? super C1133Unit> continuation) {
        return FlowKt__CollectKt.collectLatest(interfaceC1426Flow, function2, continuation);
    }

    public static final <T> Object collectWhile(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super C1133Unit> continuation) {
        return FlowKt__LimitKt.collectWhile(interfaceC1426Flow, function2, continuation);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "this.combine(other, transform)", m5048imports = {}))
    public static final <T1, T2, R> InterfaceC1426Flow<R> combineLatest(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__MigrationKt.combineLatest(interfaceC1426Flow, interfaceC1426Flow2, function3);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'compose' is 'let'", replaceWith = @ReplaceWith(expression = "let(transformer)", m5048imports = {}))
    /* renamed from: compose */
    public static final <T, R> InterfaceC1426Flow<R> m7208compose(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function1<? super InterfaceC1426Flow<? extends T>, ? extends InterfaceC1426Flow<? extends R>> function1) {
        return FlowKt__MigrationKt.m7306compose(interfaceC1426Flow, function1);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'concatMap' is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", m5048imports = {}))
    public static final <T, R> InterfaceC1426Flow<R> concatMap(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function1<? super T, ? extends InterfaceC1426Flow<? extends R>> function1) {
        return FlowKt__MigrationKt.concatMap(interfaceC1426Flow, function1);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { emit(value) }'", replaceWith = @ReplaceWith(expression = "onCompletion { emit(value) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> concatWith(InterfaceC1426Flow<? extends T> interfaceC1426Flow, T t) {
        return FlowKt__MigrationKt.concatWith(interfaceC1426Flow, t);
    }

    public static final <T> InterfaceC1426Flow<T> conflate(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return FlowKt__ContextKt.conflate(interfaceC1426Flow);
    }

    public static final <T> InterfaceC1426Flow<T> consumeAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.consumeAsFlow(receiveChannel);
    }

    /* renamed from: count */
    public static final <T> Object m7209count(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.m7278count(interfaceC1426Flow, continuation);
    }

    @FlowPreview
    public static final <T> InterfaceC1426Flow<T> debounce(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return FlowKt__DelayKt.debounce(interfaceC1426Flow, j);
    }

    @FlowPreview
    /* renamed from: debounce-HG0u8IE, reason: not valid java name */
    public static final <T> InterfaceC1426Flow<T> m20021debounceHG0u8IE(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return FlowKt__DelayKt.m20024debounceHG0u8IE(interfaceC1426Flow, j);
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    @InterfaceC1231JvmName(m6260name = "debounceDuration")
    public static final <T> InterfaceC1426Flow<T> debounceDuration(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function1<? super T, Duration> function1) {
        return FlowKt__DelayKt.debounceDuration(interfaceC1426Flow, function1);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'onEach { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onEach { delay(timeMillis) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> delayEach(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return FlowKt__MigrationKt.delayEach(interfaceC1426Flow, j);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'onStart { delay(timeMillis) }'", replaceWith = @ReplaceWith(expression = "onStart { delay(timeMillis) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> delayFlow(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return FlowKt__MigrationKt.delayFlow(interfaceC1426Flow, j);
    }

    public static final <T> InterfaceC1426Flow<T> distinctUntilChanged(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return FlowKt__DistinctKt.distinctUntilChanged(interfaceC1426Flow);
    }

    public static final <T, K> InterfaceC1426Flow<T> distinctUntilChangedBy(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function1<? super T, ? extends K> function1) {
        return FlowKt__DistinctKt.distinctUntilChangedBy(interfaceC1426Flow, function1);
    }

    /* renamed from: drop */
    public static final <T> InterfaceC1426Flow<T> m7211drop(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        return FlowKt__LimitKt.m7294drop(interfaceC1426Flow, i);
    }

    public static final <T> InterfaceC1426Flow<T> dropWhile(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.dropWhile(interfaceC1426Flow, function2);
    }

    /* renamed from: emitAll */
    public static final <T> Object m7212emitAll(FlowCollector<? super T> flowCollector, ReceiveChannel<? extends T> receiveChannel, Continuation<? super C1133Unit> continuation) {
        return FlowKt__ChannelsKt.m7267emitAll(flowCollector, receiveChannel, continuation);
    }

    public static final <T> InterfaceC1426Flow<T> emptyFlow() {
        return FlowKt__BuildersKt.emptyFlow();
    }

    public static final void ensureActive(FlowCollector<?> flowCollector) {
        FlowKt__EmittersKt.ensureActive(flowCollector);
    }

    /* renamed from: filter */
    public static final <T> InterfaceC1426Flow<T> m7214filter(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__TransformKt.m7334filter(interfaceC1426Flow, function2);
    }

    public static final <T> InterfaceC1426Flow<T> filterNot(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__TransformKt.filterNot(interfaceC1426Flow, function2);
    }

    public static final <T> InterfaceC1426Flow<T> filterNotNull(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return FlowKt__TransformKt.filterNotNull(interfaceC1426Flow);
    }

    /* renamed from: first */
    public static final <T> Object m7215first(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.m7321first(interfaceC1426Flow, continuation);
    }

    public static final <T> Object firstOrNull(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.firstOrNull(interfaceC1426Flow, continuation);
    }

    public static final ReceiveChannel<C1133Unit> fixedPeriodTicker(CoroutineScope coroutineScope, long j) {
        return FlowKt__DelayKt.fixedPeriodTicker(coroutineScope, j);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue is 'flatMapConcat'", replaceWith = @ReplaceWith(expression = "flatMapConcat(mapper)", m5048imports = {}))
    /* renamed from: flatMap */
    public static final <T, R> InterfaceC1426Flow<R> m7217flatMap(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super InterfaceC1426Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MigrationKt.m7307flatMap(interfaceC1426Flow, function2);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> InterfaceC1426Flow<R> flatMapConcat(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super InterfaceC1426Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.flatMapConcat(interfaceC1426Flow, function2);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> InterfaceC1426Flow<R> flatMapLatest(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super InterfaceC1426Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.flatMapLatest(interfaceC1426Flow, function2);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> InterfaceC1426Flow<R> flatMapMerge(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i, Function2<? super T, ? super Continuation<? super InterfaceC1426Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MergeKt.flatMapMerge(interfaceC1426Flow, i, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'flatten' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", m5048imports = {}))
    /* renamed from: flatten */
    public static final <T> InterfaceC1426Flow<T> m7218flatten(InterfaceC1426Flow<? extends InterfaceC1426Flow<? extends T>> interfaceC1426Flow) {
        return FlowKt__MigrationKt.m7308flatten(interfaceC1426Flow);
    }

    @ExperimentalCoroutinesApi
    public static final <T> InterfaceC1426Flow<T> flattenConcat(InterfaceC1426Flow<? extends InterfaceC1426Flow<? extends T>> interfaceC1426Flow) {
        return FlowKt__MergeKt.flattenConcat(interfaceC1426Flow);
    }

    @ExperimentalCoroutinesApi
    public static final <T> InterfaceC1426Flow<T> flattenMerge(InterfaceC1426Flow<? extends InterfaceC1426Flow<? extends T>> interfaceC1426Flow, int i) {
        return FlowKt__MergeKt.flattenMerge(interfaceC1426Flow, i);
    }

    /* renamed from: flow */
    public static final <T> InterfaceC1426Flow<T> m7219flow(Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return FlowKt__BuildersKt.m7264flow(function2);
    }

    @InterfaceC1231JvmName(m6260name = "flowCombine")
    public static final <T1, T2, R> InterfaceC1426Flow<R> flowCombine(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.flowCombine(interfaceC1426Flow, interfaceC1426Flow2, function3);
    }

    @InterfaceC1231JvmName(m6260name = "flowCombineTransform")
    public static final <T1, T2, R> InterfaceC1426Flow<R> flowCombineTransform(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super C1133Unit>, ? extends Object> function4) {
        return FlowKt__ZipKt.flowCombineTransform(interfaceC1426Flow, interfaceC1426Flow2, function4);
    }

    /* renamed from: flowOf */
    public static final <T> InterfaceC1426Flow<T> m7220flowOf(T t) {
        return FlowKt__BuildersKt.m7265flowOf(t);
    }

    /* renamed from: flowOn */
    public static final <T> InterfaceC1426Flow<T> m7222flowOn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineContext coroutineContext) {
        return FlowKt__ContextKt.m7277flowOn(interfaceC1426Flow, coroutineContext);
    }

    /* renamed from: fold */
    public static final <T, R> Object m7223fold(InterfaceC1426Flow<? extends T> interfaceC1426Flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3, Continuation<? super R> continuation) {
        return FlowKt__ReduceKt.m7323fold(interfaceC1426Flow, r, function3, continuation);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'forEach' is 'collect'", replaceWith = @ReplaceWith(expression = "collect(action)", m5048imports = {}))
    /* renamed from: forEach */
    public static final <T> void m7224forEach(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        FlowKt__MigrationKt.m7309forEach(interfaceC1426Flow, function2);
    }

    public static final int getDEFAULT_CONCURRENCY() {
        return FlowKt__MergeKt.getDEFAULT_CONCURRENCY();
    }

    /* renamed from: groupBy */
    public static final <T, K> Object m7225groupBy(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super Map<K, ? extends List<? extends T>>> continuation) {
        return FlowKt__CollectionKt.m7271groupBy(interfaceC1426Flow, function2, continuation);
    }

    public static final <T, K, M extends Map<? super K, List<T>>> Object groupByTo(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super M> continuation) {
        return FlowKt__CollectionKt.groupByTo(interfaceC1426Flow, m, function2, continuation);
    }

    /* renamed from: last */
    public static final <T> Object m7227last(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.m7324last(interfaceC1426Flow, continuation);
    }

    public static final <T> Object lastOrNull(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.lastOrNull(interfaceC1426Flow, continuation);
    }

    public static final <T> InterfaceC1342Job launchIn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineScope coroutineScope) {
        return FlowKt__CollectKt.launchIn(interfaceC1426Flow, coroutineScope);
    }

    /* renamed from: map */
    public static final <T, R> InterfaceC1426Flow<R> m7228map(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__TransformKt.m7335map(interfaceC1426Flow, function2);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> InterfaceC1426Flow<R> mapLatest(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__MergeKt.mapLatest(interfaceC1426Flow, function2);
    }

    public static final <T, R> InterfaceC1426Flow<R> mapNotNull(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2) {
        return FlowKt__TransformKt.mapNotNull(interfaceC1426Flow, function2);
    }

    /* renamed from: merge */
    public static final <T> InterfaceC1426Flow<T> m7229merge(Iterable<? extends InterfaceC1426Flow<? extends T>> iterable) {
        return FlowKt__MergeKt.m7300merge(iterable);
    }

    /* renamed from: noImpl */
    public static final Void m7232noImpl() {
        return FlowKt__MigrationKt.m7312noImpl();
    }

    /* renamed from: none */
    public static final <T> Object m7233none(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Boolean> continuation) {
        return FlowKt__LogicKt.m7299none(interfaceC1426Flow, function2, continuation);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Collect flow in the desired context instead")
    public static final <T> InterfaceC1426Flow<T> observeOn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.observeOn(interfaceC1426Flow, coroutineContext);
    }

    public static final <T> InterfaceC1426Flow<T> onCompletion(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super T>, ? super Throwable, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.onCompletion(interfaceC1426Flow, function3);
    }

    /* renamed from: onEach */
    public static final <T> InterfaceC1426Flow<T> m7234onEach(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return FlowKt__TransformKt.m7336onEach(interfaceC1426Flow, function2);
    }

    /* renamed from: onEmpty */
    public static final <T> InterfaceC1426Flow<T> m7235onEmpty(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return FlowKt__EmittersKt.m7288onEmpty(interfaceC1426Flow, function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> onErrorResume(InterfaceC1426Flow<? extends T> interfaceC1426Flow, InterfaceC1426Flow<? extends T> interfaceC1426Flow2) {
        return FlowKt__MigrationKt.onErrorResume(interfaceC1426Flow, interfaceC1426Flow2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emitAll(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emitAll(fallback) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> onErrorResumeNext(InterfaceC1426Flow<? extends T> interfaceC1426Flow, InterfaceC1426Flow<? extends T> interfaceC1426Flow2) {
        return FlowKt__MigrationKt.onErrorResumeNext(interfaceC1426Flow, interfaceC1426Flow2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { emit(fallback) }'", replaceWith = @ReplaceWith(expression = "catch { emit(fallback) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> onErrorReturn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, T t) {
        return FlowKt__MigrationKt.onErrorReturn(interfaceC1426Flow, t);
    }

    /* renamed from: onStart */
    public static final <T> InterfaceC1426Flow<T> m7236onStart(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return FlowKt__EmittersKt.m7289onStart(interfaceC1426Flow, function2);
    }

    public static final <T> SharedFlow<T> onSubscription(SharedFlow<? extends T> sharedFlow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return FlowKt__ShareKt.onSubscription(sharedFlow, function2);
    }

    public static final <T> ReceiveChannel<T> produceIn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineScope coroutineScope) {
        return FlowKt__ChannelsKt.produceIn(interfaceC1426Flow, coroutineScope);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'publish()' is 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStarted.Lazily' argument, \npublish().refCount() translates to 'started = SharingStarted.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, 0)", m5048imports = {}))
    /* renamed from: publish */
    public static final <T> InterfaceC1426Flow<T> m7237publish(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return FlowKt__MigrationKt.m7313publish(interfaceC1426Flow);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Collect flow in the desired context instead")
    public static final <T> InterfaceC1426Flow<T> publishOn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.publishOn(interfaceC1426Flow, coroutineContext);
    }

    public static final <T> InterfaceC1426Flow<T> receiveAsFlow(ReceiveChannel<? extends T> receiveChannel) {
        return FlowKt__ChannelsKt.receiveAsFlow(receiveChannel);
    }

    /* renamed from: reduce */
    public static final <S, T extends S> Object m7239reduce(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super S, ? super T, ? super Continuation<? super S>, ? extends Object> function3, Continuation<? super S> continuation) {
        return FlowKt__ReduceKt.m7325reduce(interfaceC1426Flow, function3, continuation);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'replay()' is 'shareIn' with unlimited replay. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStarted.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStarted.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, Int.MAX_VALUE)", m5048imports = {}))
    /* renamed from: replay */
    public static final <T> InterfaceC1426Flow<T> m7240replay(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return FlowKt__MigrationKt.m7315replay(interfaceC1426Flow);
    }

    /* renamed from: retry */
    public static final <T> InterfaceC1426Flow<T> m7242retry(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__ErrorsKt.m7292retry(interfaceC1426Flow, j, function2);
    }

    public static final <T> InterfaceC1426Flow<T> retryWhen(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function4<? super FlowCollector<? super T>, ? super Throwable, ? super Long, ? super Continuation<? super Boolean>, ? extends Object> function4) {
        return FlowKt__ErrorsKt.retryWhen(interfaceC1426Flow, function4);
    }

    public static final <T, R> InterfaceC1426Flow<R> runningFold(InterfaceC1426Flow<? extends T> interfaceC1426Flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__TransformKt.runningFold(interfaceC1426Flow, r, function3);
    }

    public static final <T> InterfaceC1426Flow<T> runningReduce(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return FlowKt__TransformKt.runningReduce(interfaceC1426Flow, function3);
    }

    @FlowPreview
    /* renamed from: sample */
    public static final <T> InterfaceC1426Flow<T> m7243sample(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return FlowKt__DelayKt.m7282sample(interfaceC1426Flow, j);
    }

    @FlowPreview
    /* renamed from: sample-HG0u8IE, reason: not valid java name */
    public static final <T> InterfaceC1426Flow<T> m20022sampleHG0u8IE(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return FlowKt__DelayKt.m20025sampleHG0u8IE(interfaceC1426Flow, j);
    }

    /* renamed from: scan */
    public static final <T, R> InterfaceC1426Flow<R> m7244scan(InterfaceC1426Flow<? extends T> interfaceC1426Flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__TransformKt.m7337scan(interfaceC1426Flow, r, function3);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow has less verbose 'scan' shortcut", replaceWith = @ReplaceWith(expression = "scan(initial, operation)", m5048imports = {}))
    public static final <T, R> InterfaceC1426Flow<R> scanFold(InterfaceC1426Flow<? extends T> interfaceC1426Flow, R r, Function3<? super R, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__MigrationKt.scanFold(interfaceC1426Flow, r, function3);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "'scanReduce' was renamed to 'runningReduce' to be consistent with Kotlin standard library", replaceWith = @ReplaceWith(expression = "runningReduce(operation)", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> scanReduce(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3) {
        return FlowKt__MigrationKt.scanReduce(interfaceC1426Flow, function3);
    }

    /* renamed from: shareIn */
    public static final <T> SharedFlow<T> m7245shareIn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, int i) {
        return FlowKt__ShareKt.m7328shareIn(interfaceC1426Flow, coroutineScope, sharingStarted, i);
    }

    /* renamed from: single */
    public static final <T> Object m7246single(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.m7326single(interfaceC1426Flow, continuation);
    }

    public static final <T> Object singleOrNull(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.singleOrNull(interfaceC1426Flow, continuation);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'skip' is 'drop'", replaceWith = @ReplaceWith(expression = "drop(count)", m5048imports = {}))
    /* renamed from: skip */
    public static final <T> InterfaceC1426Flow<T> m7247skip(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        return FlowKt__MigrationKt.m7317skip(interfaceC1426Flow, i);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emit(value) }'", replaceWith = @ReplaceWith(expression = "onStart { emit(value) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> startWith(InterfaceC1426Flow<? extends T> interfaceC1426Flow, T t) {
        return FlowKt__MigrationKt.startWith(interfaceC1426Flow, t);
    }

    /* renamed from: stateIn */
    public static final <T> Object m7248stateIn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineScope coroutineScope, Continuation<? super StateFlow<? extends T>> continuation) {
        return FlowKt__ShareKt.m7329stateIn(interfaceC1426Flow, coroutineScope, continuation);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        FlowKt__MigrationKt.subscribe(interfaceC1426Flow);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'flowOn' instead")
    public static final <T> InterfaceC1426Flow<T> subscribeOn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineContext coroutineContext) {
        return FlowKt__MigrationKt.subscribeOn(interfaceC1426Flow, coroutineContext);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogues of 'switchMap' are 'transformLatest', 'flatMapLatest' and 'mapLatest'", replaceWith = @ReplaceWith(expression = "this.flatMapLatest(transform)", m5048imports = {}))
    public static final <T, R> InterfaceC1426Flow<R> switchMap(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super InterfaceC1426Flow<? extends R>>, ? extends Object> function2) {
        return FlowKt__MigrationKt.switchMap(interfaceC1426Flow, function2);
    }

    /* renamed from: take */
    public static final <T> InterfaceC1426Flow<T> m7250take(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        return FlowKt__LimitKt.m7295take(interfaceC1426Flow, i);
    }

    public static final <T> InterfaceC1426Flow<T> takeWhile(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2) {
        return FlowKt__LimitKt.takeWhile(interfaceC1426Flow, function2);
    }

    @FlowPreview
    /* renamed from: timeout-HG0u8IE, reason: not valid java name */
    public static final <T> InterfaceC1426Flow<T> m20023timeoutHG0u8IE(InterfaceC1426Flow<? extends T> interfaceC1426Flow, long j) {
        return FlowKt__DelayKt.m20026timeoutHG0u8IE(interfaceC1426Flow, j);
    }

    public static final <T, C extends Collection<? super T>> Object toCollection(InterfaceC1426Flow<? extends T> interfaceC1426Flow, C c, Continuation<? super C> continuation) {
        return FlowKt__CollectionKt.toCollection(interfaceC1426Flow, c, continuation);
    }

    /* renamed from: toList */
    public static final <T> Object m7251toList(InterfaceC1426Flow<? extends T> interfaceC1426Flow, List<T> list, Continuation<? super List<? extends T>> continuation) {
        return FlowKt__CollectionKt.m7273toList(interfaceC1426Flow, list, continuation);
    }

    /* renamed from: toSet */
    public static final <T> Object m7252toSet(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Set<T> set, Continuation<? super Set<? extends T>> continuation) {
        return FlowKt__CollectionKt.m7274toSet(interfaceC1426Flow, set, continuation);
    }

    public static final <T, R> InterfaceC1426Flow<R> transform(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.transform(interfaceC1426Flow, function3);
    }

    @ExperimentalCoroutinesApi
    public static final <T, R> InterfaceC1426Flow<R> transformLatest(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        return FlowKt__MergeKt.transformLatest(interfaceC1426Flow, function3);
    }

    public static final <T, R> InterfaceC1426Flow<R> transformWhile(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super Boolean>, ? extends Object> function3) {
        return FlowKt__LimitKt.transformWhile(interfaceC1426Flow, function3);
    }

    @PublishedApi
    public static final <T, R> InterfaceC1426Flow<R> unsafeTransform(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function3<? super FlowCollector<? super R>, ? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function3) {
        return FlowKt__EmittersKt.unsafeTransform(interfaceC1426Flow, function3);
    }

    public static final <T> InterfaceC1426Flow<IndexedValue<T>> withIndex(InterfaceC1426Flow<? extends T> interfaceC1426Flow) {
        return FlowKt__TransformKt.withIndex(interfaceC1426Flow);
    }

    /* renamed from: zip */
    public static final <T1, T2, R> InterfaceC1426Flow<R> m7253zip(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.m7344zip(interfaceC1426Flow, interfaceC1426Flow2, function3);
    }

    /* renamed from: asFlow */
    public static final <T> InterfaceC1426Flow<T> m7185asFlow(Iterator<? extends T> it) {
        return FlowKt__BuildersKt.m7255asFlow(it);
    }

    public static final <T, K, V> Object associateBy(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super Map<K, ? extends V>> continuation) {
        return FlowKt__CollectionKt.associateBy(interfaceC1426Flow, function2, function22, continuation);
    }

    public static final <T, K, V, M extends Map<? super K, ? super V>> Object associateByTo(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super M> continuation) {
        return FlowKt__CollectionKt.associateByTo(interfaceC1426Flow, m, function2, function22, continuation);
    }

    /* renamed from: buffer */
    public static final <T> InterfaceC1426Flow<T> m7196buffer(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i, BufferOverflow bufferOverflow) {
        return FlowKt__ContextKt.m7276buffer(interfaceC1426Flow, i, bufferOverflow);
    }

    public static final <T> Object collectLatest(SharedFlow<? extends T> sharedFlow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2, Continuation<?> continuation) {
        return FlowKt__CollectKt.collectLatest(sharedFlow, function2, continuation);
    }

    /* renamed from: combine */
    public static final <T1, T2, R> InterfaceC1426Flow<R> m7203combine(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, Function3<? super T1, ? super T2, ? super Continuation<? super R>, ? extends Object> function3) {
        return FlowKt__ZipKt.m7339combine(interfaceC1426Flow, interfaceC1426Flow2, function3);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, transform)", m5048imports = {}))
    public static final <T1, T2, T3, R> InterfaceC1426Flow<R> combineLatest(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return FlowKt__MigrationKt.combineLatest(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, function4);
    }

    public static final <T1, T2, R> InterfaceC1426Flow<R> combineTransform(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, Function4<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super Continuation<? super C1133Unit>, ? extends Object> function4) {
        return FlowKt__ZipKt.combineTransform(interfaceC1426Flow, interfaceC1426Flow2, function4);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'concatWith' is 'onCompletion'. Use 'onCompletion { if (it == null) emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onCompletion { if (it == null) emitAll(other) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> concatWith(InterfaceC1426Flow<? extends T> interfaceC1426Flow, InterfaceC1426Flow<? extends T> interfaceC1426Flow2) {
        return FlowKt__MigrationKt.concatWith((InterfaceC1426Flow) interfaceC1426Flow, (InterfaceC1426Flow) interfaceC1426Flow2);
    }

    /* renamed from: count */
    public static final <T> Object m7210count(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super Integer> continuation) {
        return FlowKt__CountKt.m7279count(interfaceC1426Flow, function2, continuation);
    }

    @FlowPreview
    @OverloadResolutionByLambdaReturnType
    public static final <T> InterfaceC1426Flow<T> debounce(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function1<? super T, Long> function1) {
        return FlowKt__DelayKt.debounce(interfaceC1426Flow, function1);
    }

    public static final <T> InterfaceC1426Flow<T> distinctUntilChanged(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super T, Boolean> function2) {
        return FlowKt__DistinctKt.distinctUntilChanged(interfaceC1426Flow, function2);
    }

    /* renamed from: emitAll */
    public static final <T> Object m7213emitAll(FlowCollector<? super T> flowCollector, InterfaceC1426Flow<? extends T> interfaceC1426Flow, Continuation<? super C1133Unit> continuation) {
        return FlowKt__CollectKt.m7270emitAll(flowCollector, interfaceC1426Flow, continuation);
    }

    public static final <R> InterfaceC1426Flow<R> filterIsInstance(InterfaceC1426Flow<?> interfaceC1426Flow, InterfaceC1242KClass<R> interfaceC1242KClass) {
        return FlowKt__TransformKt.filterIsInstance(interfaceC1426Flow, interfaceC1242KClass);
    }

    /* renamed from: first */
    public static final <T> Object m7216first(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.m7322first(interfaceC1426Flow, function2, continuation);
    }

    public static final <T> Object firstOrNull(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super T> continuation) {
        return FlowKt__ReduceKt.firstOrNull(interfaceC1426Flow, function2, continuation);
    }

    /* renamed from: flowOf */
    public static final <T> InterfaceC1426Flow<T> m7221flowOf(T... tArr) {
        return FlowKt__BuildersKt.m7266flowOf((Object[]) tArr);
    }

    /* renamed from: groupBy */
    public static final <T, K, V> Object m7226groupBy(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super Map<K, ? extends List<? extends V>>> continuation) {
        return FlowKt__CollectionKt.m7272groupBy(interfaceC1426Flow, function2, function22, continuation);
    }

    public static final <T, K, V, M extends Map<? super K, List<V>>> Object groupByTo(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super M> continuation) {
        return FlowKt__CollectionKt.groupByTo(interfaceC1426Flow, m, function2, function22, continuation);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'merge' is 'flattenConcat'", replaceWith = @ReplaceWith(expression = "flattenConcat()", m5048imports = {}))
    /* renamed from: merge */
    public static final <T> InterfaceC1426Flow<T> m7230merge(InterfaceC1426Flow<? extends InterfaceC1426Flow<? extends T>> interfaceC1426Flow) {
        return FlowKt__MigrationKt.m7310merge(interfaceC1426Flow);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'onErrorXxx' is 'catch'. Use 'catch { e -> if (predicate(e)) emit(fallback) else throw e }'", replaceWith = @ReplaceWith(expression = "catch { e -> if (predicate(e)) emit(fallback) else throw e }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> onErrorReturn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, T t, Function1<? super Throwable, Boolean> function1) {
        return FlowKt__MigrationKt.onErrorReturn(interfaceC1426Flow, t, function1);
    }

    public static final <T> StateFlow<T> onSubscription(StateFlow<? extends T> stateFlow, Function2<? super FlowCollector<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        return FlowKt__ShareKt.onSubscription((StateFlow) stateFlow, (Function2) function2);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'publish(bufferSize)' is 'buffer' followed by 'shareIn'. \npublish().connect() is the default strategy (no extra call is needed), \npublish().autoConnect() translates to 'started = SharingStarted.Lazily' argument, \npublish().refCount() translates to 'started = SharingStarted.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.buffer(bufferSize).shareIn(scope, 0)", m5048imports = {}))
    /* renamed from: publish */
    public static final <T> InterfaceC1426Flow<T> m7238publish(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        return FlowKt__MigrationKt.m7314publish(interfaceC1426Flow, i);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'replay(bufferSize)' is 'shareIn' with the specified replay parameter. \nreplay().connect() is the default strategy (no extra call is needed), \nreplay().autoConnect() translates to 'started = SharingStarted.Lazily' argument, \nreplay().refCount() translates to 'started = SharingStarted.WhileSubscribed()' argument.", replaceWith = @ReplaceWith(expression = "this.shareIn(scope, bufferSize)", m5048imports = {}))
    /* renamed from: replay */
    public static final <T> InterfaceC1426Flow<T> m7241replay(InterfaceC1426Flow<? extends T> interfaceC1426Flow, int i) {
        return FlowKt__MigrationKt.m7316replay(interfaceC1426Flow, i);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'startWith' is 'onStart'. Use 'onStart { emitAll(other) }'", replaceWith = @ReplaceWith(expression = "onStart { emitAll(other) }", m5048imports = {}))
    public static final <T> InterfaceC1426Flow<T> startWith(InterfaceC1426Flow<? extends T> interfaceC1426Flow, InterfaceC1426Flow<? extends T> interfaceC1426Flow2) {
        return FlowKt__MigrationKt.startWith((InterfaceC1426Flow) interfaceC1426Flow, (InterfaceC1426Flow) interfaceC1426Flow2);
    }

    /* renamed from: stateIn */
    public static final <T> StateFlow<T> m7249stateIn(InterfaceC1426Flow<? extends T> interfaceC1426Flow, CoroutineScope coroutineScope, SharingStarted sharingStarted, T t) {
        return FlowKt__ShareKt.m7330stateIn(interfaceC1426Flow, coroutineScope, sharingStarted, t);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2) {
        FlowKt__MigrationKt.subscribe(interfaceC1426Flow, function2);
    }

    /* renamed from: asFlow */
    public static final <T> InterfaceC1426Flow<T> m7186asFlow(Function0<? extends T> function0) {
        return FlowKt__BuildersKt.m7256asFlow(function0);
    }

    /* renamed from: combine */
    public static final <T1, T2, T3, R> InterfaceC1426Flow<R> m7204combine(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, Function4<? super T1, ? super T2, ? super T3, ? super Continuation<? super R>, ? extends Object> function4) {
        return FlowKt__ZipKt.m7340combine(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, function4);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", m5048imports = {}))
    public static final <T1, T2, T3, T4, R> InterfaceC1426Flow<R> combineLatest(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return FlowKt__MigrationKt.combineLatest(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4, function5);
    }

    public static final <T1, T2, T3, R> InterfaceC1426Flow<R> combineTransform(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, Function5<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super Continuation<? super C1133Unit>, ? extends Object> function5) {
        return FlowKt__ZipKt.combineTransform(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, function5);
    }

    /* renamed from: merge */
    public static final <T> InterfaceC1426Flow<T> m7231merge(InterfaceC1426Flow<? extends T>... interfaceC1426FlowArr) {
        return FlowKt__MergeKt.m7301merge(interfaceC1426FlowArr);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Use 'launchIn' with 'onEach', 'onCompletion' and 'catch' instead")
    public static final <T> void subscribe(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1133Unit>, ? extends Object> function2, Function2<? super Throwable, ? super Continuation<? super C1133Unit>, ? extends Object> function22) {
        FlowKt__MigrationKt.subscribe(interfaceC1426Flow, function2, function22);
    }

    /* renamed from: asFlow */
    public static final <T> InterfaceC1426Flow<T> m7187asFlow(Function1<? super Continuation<? super T>, ? extends Object> function1) {
        return FlowKt__BuildersKt.m7257asFlow(function1);
    }

    /* renamed from: combine */
    public static final <T1, T2, T3, T4, R> InterfaceC1426Flow<R> m7205combine(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, Function5<? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super R>, ? extends Object> function5) {
        return FlowKt__ZipKt.m7341combine(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4, function5);
    }

    @Deprecated(m4971level = DeprecationLevel.f4880ERROR, m4972message = "Flow analogue of 'combineLatest' is 'combine'", replaceWith = @ReplaceWith(expression = "combine(this, other, other2, other3, transform)", m5048imports = {}))
    public static final <T1, T2, T3, T4, T5, R> InterfaceC1426Flow<R> combineLatest(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, InterfaceC1426Flow<? extends T5> interfaceC1426Flow5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return FlowKt__MigrationKt.combineLatest(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4, interfaceC1426Flow5, function6);
    }

    public static final <T1, T2, T3, T4, R> InterfaceC1426Flow<R> combineTransform(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, Function6<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super Continuation<? super C1133Unit>, ? extends Object> function6) {
        return FlowKt__ZipKt.combineTransform(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4, function6);
    }

    /* renamed from: asFlow */
    public static final InterfaceC1426Flow<Integer> m7188asFlow(IntRange intRange) {
        return FlowKt__BuildersKt.m7258asFlow(intRange);
    }

    /* renamed from: combine */
    public static final <T1, T2, T3, T4, T5, R> InterfaceC1426Flow<R> m7206combine(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, InterfaceC1426Flow<? extends T5> interfaceC1426Flow5, Function6<? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super R>, ? extends Object> function6) {
        return FlowKt__ZipKt.m7342combine(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4, interfaceC1426Flow5, function6);
    }

    public static final <T1, T2, T3, T4, T5, R> InterfaceC1426Flow<R> combineTransform(InterfaceC1426Flow<? extends T1> interfaceC1426Flow, InterfaceC1426Flow<? extends T2> interfaceC1426Flow2, InterfaceC1426Flow<? extends T3> interfaceC1426Flow3, InterfaceC1426Flow<? extends T4> interfaceC1426Flow4, InterfaceC1426Flow<? extends T5> interfaceC1426Flow5, Function7<? super FlowCollector<? super R>, ? super T1, ? super T2, ? super T3, ? super T4, ? super T5, ? super Continuation<? super C1133Unit>, ? extends Object> function7) {
        return FlowKt__ZipKt.combineTransform(interfaceC1426Flow, interfaceC1426Flow2, interfaceC1426Flow3, interfaceC1426Flow4, interfaceC1426Flow5, function7);
    }

    /* renamed from: asFlow */
    public static final InterfaceC1426Flow<Long> m7189asFlow(LongRange longRange) {
        return FlowKt__BuildersKt.m7259asFlow(longRange);
    }

    /* renamed from: asFlow */
    public static final <T> InterfaceC1426Flow<T> m7190asFlow(Sequence<? extends T> sequence) {
        return FlowKt__BuildersKt.m7260asFlow(sequence);
    }

    @ExperimentalCoroutinesApi
    /* renamed from: asFlow */
    public static final <T> InterfaceC1426Flow<T> m7191asFlow(SharedFlow<? extends T> sharedFlow) {
        return FlowKt__ShareKt.m7327asFlow(sharedFlow);
    }

    /* renamed from: asFlow */
    public static final InterfaceC1426Flow<Integer> m7192asFlow(int[] iArr) {
        return FlowKt__BuildersKt.m7261asFlow(iArr);
    }

    /* renamed from: asFlow */
    public static final InterfaceC1426Flow<Long> m7193asFlow(long[] jArr) {
        return FlowKt__BuildersKt.m7262asFlow(jArr);
    }

    /* renamed from: asFlow */
    public static final <T> InterfaceC1426Flow<T> m7194asFlow(T[] tArr) {
        return FlowKt__BuildersKt.m7263asFlow(tArr);
    }
}
