package p122kotlinx.coroutines.p125flow;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.conscrypt.BuildConfig;
import p094kotlin.C1122Pair;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.InlineMarker;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000N\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010%\n\u0002\b\t\u001a4\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a4\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\b\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\tH\u0086@¢\u0006\u0002\u0010\n\u001a8\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0000\u0010\u0002\"\u0010\b\u0001\u0010\f*\n\u0012\u0006\b\u0000\u0012\u0002H\u00020\r*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\fH\u0086@¢\u0006\u0002\u0010\u000e\u001ah\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00020\u000320\b\u0004\u0010\u0013\u001a*\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u0018\u001aV\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u00032$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u0018\u001a\u0082\u0001\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00020\u00032$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00142$\b\u0004\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u001c\u001al\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0018\b\u0002\u0010\u001e*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\u0006\b\u0000\u0012\u0002H\u00020\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u001e2$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010 \u001a\u0098\u0001\u0010\u001d\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012\"\u0018\b\u0003\u0010\u001e*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\u0006\b\u0000\u0012\u0002H\u00120\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u001e2$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00142$\b\u0004\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010!\u001a~\u0010\"\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012\"\u0018\b\u0003\u0010\u001e*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\u0006\b\u0000\u0012\u0002H\u00120\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u001e20\b\u0004\u0010\u0013\u001a*\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0016\u0012\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010 \u001aV\u0010#\u001a\u000e\u0012\u0004\u0012\u0002H\u0011\u0012\u0004\u0012\u0002H\u00120\u0010\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00110\u00032$\b\u0004\u0010$\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u0018\u001al\u0010%\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0011\"\u0004\b\u0001\u0010\u0012\"\u0018\b\u0002\u0010\u001e*\u0012\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\u0006\b\u0000\u0012\u0002H\u00120\u001f*\b\u0012\u0004\u0012\u0002H\u00110\u00032\u0006\u0010\u0004\u001a\u0002H\u001e2$\b\u0004\u0010$\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010 \u001a\\\u0010&\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011*\b\u0012\u0004\u0012\u0002H\u00020\u00032$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u0018\u001a\u0088\u0001\u0010&\u001a\u0014\u0012\u0004\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00010\u0010\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00020\u00032$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00142$\b\u0004\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010\u001c\u001ap\u0010'\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u001c\b\u0002\u0010\u001e*\u0016\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u001e2$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010 \u001a\u009c\u0001\u0010'\u001a\u0002H\u001e\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0011\"\u0004\b\u0002\u0010\u0012\"\u001c\b\u0003\u0010\u001e*\u0016\u0012\u0006\b\u0000\u0012\u0002H\u0011\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00050\u001f*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u001e2$\b\u0004\u0010\u001a\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u00142$\b\u0004\u0010\u001b\u001a\u001e\b\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0014H\u0086H¢\u0006\u0002\u0010!¨\u0006("}, m4988d2 = {"toList", BuildConfig.f24315FLAVOR, "T", "Lkotlinx/coroutines/flow/Flow;", "destination", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toSet", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toCollection", "C", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associate", BuildConfig.f24315FLAVOR, "K", "V", "transform", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Pair;", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associateBy", "keySelector", "valueTransform", "(Lkotlinx/coroutines/flow/Flow;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associateByTo", "M", BuildConfig.f24315FLAVOR, "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "(Lkotlinx/coroutines/flow/Flow;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "associateTo", "associateWith", "valueSelector", "associateWithTo", "groupBy", "groupByTo", "kotlinx-coroutines-core"}, m4989k = 5, m4990mv = {2, 2, 0}, m4992xi = 48, m4993xs = "kotlinx/coroutines/flow/FlowKt")
@SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt\n*L\n1#1,364:1\n195#1,4:365\n129#1,4:369\n162#1,4:373\n249#1,4:377\n327#1,6:381\n357#1,6:387\n*S KotlinDebug\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt\n*L\n47#1:365,4\n73#1:369,4\n98#1:373,4\n219#1:377,4\n277#1:381,6\n301#1:387,6\n*E\n"})
/* loaded from: classes.dex */
final /* synthetic */ class FlowKt__CollectionKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {365}, m6127m = "associate", m6128n = {"$this$associate", "transform", "$this$associateTo$iv", "destination$iv", "$i$f$associate", "$i$f$associateTo"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associate$1\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associate$1 */
    public static final class C14421<T, K, V> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6221I$0;

        /* renamed from: I$1 */
        int f6222I$1;

        /* renamed from: L$0 */
        Object f6223L$0;

        /* renamed from: L$1 */
        Object f6224L$1;

        /* renamed from: L$2 */
        Object f6225L$2;

        /* renamed from: L$3 */
        Object f6226L$3;

        /* renamed from: label */
        int f6227label;

        /* renamed from: result */
        /* synthetic */ Object f6228result;

        public C14421(Continuation<? super C14421> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6228result = obj;
            this.f6227label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.associate(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {365}, m6127m = "associateBy", m6128n = {"$this$associateBy", "keySelector", "$this$associateByTo$iv", "destination$iv", "$i$f$associateBy", "$i$f$associateByTo"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associateBy$1\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associateBy$1 */
    public static final class C14431<T, K> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6229I$0;

        /* renamed from: I$1 */
        int f6230I$1;

        /* renamed from: L$0 */
        Object f6231L$0;

        /* renamed from: L$1 */
        Object f6232L$1;

        /* renamed from: L$2 */
        Object f6233L$2;

        /* renamed from: L$3 */
        Object f6234L$3;

        /* renamed from: label */
        int f6235label;

        /* renamed from: result */
        /* synthetic */ Object f6236result;

        public C14431(Continuation<? super C14431> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6236result = obj;
            this.f6235label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.associateBy(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0, 0, 0, 0}, m6126l = {365}, m6127m = "associateBy", m6128n = {"$this$associateBy", "keySelector", "valueTransform", "$this$associateByTo$iv", "destination$iv", "$i$f$associateBy", "$i$f$associateByTo"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associateBy$2\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associateBy$2 */
    public static final class C14442<T, K, V> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6237I$0;

        /* renamed from: I$1 */
        int f6238I$1;

        /* renamed from: L$0 */
        Object f6239L$0;

        /* renamed from: L$1 */
        Object f6240L$1;

        /* renamed from: L$2 */
        Object f6241L$2;

        /* renamed from: L$3 */
        Object f6242L$3;

        /* renamed from: L$4 */
        Object f6243L$4;

        /* renamed from: label */
        int f6244label;

        /* renamed from: result */
        /* synthetic */ Object f6245result;

        public C14442(Continuation<? super C14442> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6245result = obj;
            this.f6244label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.associateBy(null, null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0}, m6126l = {129}, m6127m = "associateByTo", m6128n = {"$this$associateByTo", "destination", "keySelector", "$i$f$associateByTo"}, m6130s = {"L$0", "L$1", "L$2", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associateByTo$1\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associateByTo$1 */
    public static final class C14451<T, K, M extends Map<? super K, ? super T>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6246I$0;

        /* renamed from: L$0 */
        Object f6247L$0;

        /* renamed from: L$1 */
        Object f6248L$1;

        /* renamed from: L$2 */
        Object f6249L$2;

        /* renamed from: label */
        int f6250label;

        /* renamed from: result */
        /* synthetic */ Object f6251result;

        public C14451(Continuation<? super C14451> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6251result = obj;
            this.f6250label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.associateByTo(null, null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associateByTo$2\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associateByTo$2 */
    public static final class C14462<T> implements FlowCollector {

        /* JADX INFO: Incorrect field signature: TM; */
        final /* synthetic */ Map $destination;
        final /* synthetic */ Function2<T, Continuation<? super K>, Object> $keySelector;

        /* JADX WARN: Incorrect types in method signature: (TM;Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-TK;>;+Ljava/lang/Object;>;)V */
        public C14462(Map map, Function2 function2) {
            this.$destination = map;
            this.$keySelector = function2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            FlowKt__CollectionKt$associateByTo$2$emit$1 flowKt__CollectionKt$associateByTo$2$emit$1;
            Map map;
            if (continuation instanceof FlowKt__CollectionKt$associateByTo$2$emit$1) {
                flowKt__CollectionKt$associateByTo$2$emit$1 = (FlowKt__CollectionKt$associateByTo$2$emit$1) continuation;
                int i = flowKt__CollectionKt$associateByTo$2$emit$1.f6254label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__CollectionKt$associateByTo$2$emit$1.f6254label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__CollectionKt$associateByTo$2$emit$1 = new FlowKt__CollectionKt$associateByTo$2$emit$1(this, continuation);
                }
            }
            Object obj = flowKt__CollectionKt$associateByTo$2$emit$1.f6255result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__CollectionKt$associateByTo$2$emit$1.f6254label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Map map2 = this.$destination;
                Function2<T, Continuation<? super K>, Object> function2 = this.$keySelector;
                flowKt__CollectionKt$associateByTo$2$emit$1.f6252L$0 = t;
                flowKt__CollectionKt$associateByTo$2$emit$1.f6253L$1 = map2;
                flowKt__CollectionKt$associateByTo$2$emit$1.f6254label = 1;
                Object objMo2167invoke = function2.mo2167invoke(t, flowKt__CollectionKt$associateByTo$2$emit$1);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objMo2167invoke;
                map = map2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                map = (Map) flowKt__CollectionKt$associateByTo$2$emit$1.f6253L$1;
                t = (T) flowKt__CollectionKt$associateByTo$2$emit$1.f6252L$0;
                ResultKt.throwOnFailure(obj);
            }
            map.put(obj, t);
            return C1133Unit.INSTANCE;
        }

        public final Object emit$$forInline(T t, Continuation<? super C1133Unit> continuation) {
            InlineMarker.m6315mark(4);
            new FlowKt__CollectionKt$associateByTo$2$emit$1(this, continuation);
            InlineMarker.m6315mark(5);
            this.$destination.put(this.$keySelector.mo2167invoke(t, continuation), t);
            return C1133Unit.INSTANCE;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {162}, m6127m = "associateByTo", m6128n = {"$this$associateByTo", "destination", "keySelector", "valueTransform", "$i$f$associateByTo"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associateByTo$3\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associateByTo$3 */
    public static final class C14473<T, K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6257I$0;

        /* renamed from: L$0 */
        Object f6258L$0;

        /* renamed from: L$1 */
        Object f6259L$1;

        /* renamed from: L$2 */
        Object f6260L$2;

        /* renamed from: L$3 */
        Object f6261L$3;

        /* renamed from: label */
        int f6262label;

        /* renamed from: result */
        /* synthetic */ Object f6263result;

        public C14473(Continuation<? super C14473> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6263result = obj;
            this.f6262label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.associateByTo(null, null, null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associateByTo$4\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associateByTo$4 */
    public static final class C14484<T> implements FlowCollector {

        /* JADX INFO: Incorrect field signature: TM; */
        final /* synthetic */ Map $destination;
        final /* synthetic */ Function2<T, Continuation<? super K>, Object> $keySelector;
        final /* synthetic */ Function2<T, Continuation<? super V>, Object> $valueTransform;

        /* JADX WARN: Incorrect types in method signature: (TM;Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-TK;>;+Ljava/lang/Object;>;Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-TV;>;+Ljava/lang/Object;>;)V */
        public C14484(Map map, Function2 function2, Function2 function22) {
            this.$destination = map;
            this.$keySelector = function2;
            this.$valueTransform = function22;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            FlowKt__CollectionKt$associateByTo$4$emit$1 flowKt__CollectionKt$associateByTo$4$emit$1;
            Object obj;
            Map map;
            Object obj2;
            if (continuation instanceof FlowKt__CollectionKt$associateByTo$4$emit$1) {
                flowKt__CollectionKt$associateByTo$4$emit$1 = (FlowKt__CollectionKt$associateByTo$4$emit$1) continuation;
                int i = flowKt__CollectionKt$associateByTo$4$emit$1.f6267label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__CollectionKt$associateByTo$4$emit$1.f6267label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__CollectionKt$associateByTo$4$emit$1 = new FlowKt__CollectionKt$associateByTo$4$emit$1(this, continuation);
                }
            }
            Object obj3 = flowKt__CollectionKt$associateByTo$4$emit$1.f6268result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__CollectionKt$associateByTo$4$emit$1.f6267label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj3);
                Map map2 = this.$destination;
                Function2<T, Continuation<? super K>, Object> function2 = this.$keySelector;
                flowKt__CollectionKt$associateByTo$4$emit$1.f6264L$0 = t;
                flowKt__CollectionKt$associateByTo$4$emit$1.f6265L$1 = map2;
                flowKt__CollectionKt$associateByTo$4$emit$1.f6267label = 1;
                Object objMo2167invoke = function2.mo2167invoke(t, flowKt__CollectionKt$associateByTo$4$emit$1);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = t;
                map = map2;
                obj3 = objMo2167invoke;
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    obj2 = flowKt__CollectionKt$associateByTo$4$emit$1.f6266L$2;
                    map = (Map) flowKt__CollectionKt$associateByTo$4$emit$1.f6265L$1;
                    ResultKt.throwOnFailure(obj3);
                    map.put(obj2, obj3);
                    return C1133Unit.INSTANCE;
                }
                map = (Map) flowKt__CollectionKt$associateByTo$4$emit$1.f6265L$1;
                obj = flowKt__CollectionKt$associateByTo$4$emit$1.f6264L$0;
                ResultKt.throwOnFailure(obj3);
            }
            Function2<T, Continuation<? super V>, Object> function22 = this.$valueTransform;
            flowKt__CollectionKt$associateByTo$4$emit$1.f6264L$0 = SpillingKt.nullOutSpilledVariable(obj);
            flowKt__CollectionKt$associateByTo$4$emit$1.f6265L$1 = map;
            flowKt__CollectionKt$associateByTo$4$emit$1.f6266L$2 = obj3;
            flowKt__CollectionKt$associateByTo$4$emit$1.f6267label = 2;
            Object objMo2167invoke2 = function22.mo2167invoke(obj, flowKt__CollectionKt$associateByTo$4$emit$1);
            if (objMo2167invoke2 == coroutine_suspended) {
                return coroutine_suspended;
            }
            Object obj4 = obj3;
            obj3 = objMo2167invoke2;
            obj2 = obj4;
            map.put(obj2, obj3);
            return C1133Unit.INSTANCE;
        }

        public final Object emit$$forInline(T t, Continuation<? super C1133Unit> continuation) {
            InlineMarker.m6315mark(4);
            new FlowKt__CollectionKt$associateByTo$4$emit$1(this, continuation);
            InlineMarker.m6315mark(5);
            this.$destination.put(this.$keySelector.mo2167invoke(t, continuation), this.$valueTransform.mo2167invoke(t, continuation));
            return C1133Unit.INSTANCE;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0}, m6126l = {195}, m6127m = "associateTo", m6128n = {"$this$associateTo", "destination", "transform", "$i$f$associateTo"}, m6130s = {"L$0", "L$1", "L$2", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associateTo$1\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associateTo$1 */
    public static final class C14491<T, K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6270I$0;

        /* renamed from: L$0 */
        Object f6271L$0;

        /* renamed from: L$1 */
        Object f6272L$1;

        /* renamed from: L$2 */
        Object f6273L$2;

        /* renamed from: label */
        int f6274label;

        /* renamed from: result */
        /* synthetic */ Object f6275result;

        public C14491(Continuation<? super C14491> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6275result = obj;
            this.f6274label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.associateTo(null, null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associateTo$2\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associateTo$2 */
    public static final class C14502<T> implements FlowCollector {

        /* JADX INFO: Incorrect field signature: TM; */
        final /* synthetic */ Map $destination;
        final /* synthetic */ Function2<T, Continuation<? super C1122Pair<? extends K, ? extends V>>, Object> $transform;

        /* JADX WARN: Incorrect types in method signature: (TM;Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-Lkotlin/Pair<+TK;+TV;>;>;+Ljava/lang/Object;>;)V */
        public C14502(Map map, Function2 function2) {
            this.$destination = map;
            this.$transform = function2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            FlowKt__CollectionKt$associateTo$2$emit$1 flowKt__CollectionKt$associateTo$2$emit$1;
            Map map;
            if (continuation instanceof FlowKt__CollectionKt$associateTo$2$emit$1) {
                flowKt__CollectionKt$associateTo$2$emit$1 = (FlowKt__CollectionKt$associateTo$2$emit$1) continuation;
                int i = flowKt__CollectionKt$associateTo$2$emit$1.f6278label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__CollectionKt$associateTo$2$emit$1.f6278label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__CollectionKt$associateTo$2$emit$1 = new FlowKt__CollectionKt$associateTo$2$emit$1(this, continuation);
                }
            }
            Object obj = flowKt__CollectionKt$associateTo$2$emit$1.f6279result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__CollectionKt$associateTo$2$emit$1.f6278label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj);
                Map map2 = this.$destination;
                Function2<T, Continuation<? super C1122Pair<? extends K, ? extends V>>, Object> function2 = this.$transform;
                flowKt__CollectionKt$associateTo$2$emit$1.f6276L$0 = SpillingKt.nullOutSpilledVariable(t);
                flowKt__CollectionKt$associateTo$2$emit$1.f6277L$1 = map2;
                flowKt__CollectionKt$associateTo$2$emit$1.f6278label = 1;
                Object objMo2167invoke = function2.mo2167invoke(t, flowKt__CollectionKt$associateTo$2$emit$1);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj = objMo2167invoke;
                map = map2;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                map = (Map) flowKt__CollectionKt$associateTo$2$emit$1.f6277L$1;
                ResultKt.throwOnFailure(obj);
            }
            C1122Pair c1122Pair = (C1122Pair) obj;
            map.put(c1122Pair.getFirst(), c1122Pair.getSecond());
            return C1133Unit.INSTANCE;
        }

        public final Object emit$$forInline(T t, Continuation<? super C1133Unit> continuation) {
            InlineMarker.m6315mark(4);
            new FlowKt__CollectionKt$associateTo$2$emit$1(this, continuation);
            InlineMarker.m6315mark(5);
            Map map = this.$destination;
            C1122Pair c1122Pair = (C1122Pair) this.$transform.mo2167invoke(t, continuation);
            map.put(c1122Pair.getFirst(), c1122Pair.getSecond());
            return C1133Unit.INSTANCE;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {365}, m6127m = "associateWith", m6128n = {"$this$associateWith", "valueSelector", "$this$associateWithTo$iv", "destination$iv", "$i$f$associateWith", "$i$f$associateWithTo"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associateWith$1\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associateWith$1 */
    public static final class C14511<K, V> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6281I$0;

        /* renamed from: I$1 */
        int f6282I$1;

        /* renamed from: L$0 */
        Object f6283L$0;

        /* renamed from: L$1 */
        Object f6284L$1;

        /* renamed from: L$2 */
        Object f6285L$2;

        /* renamed from: L$3 */
        Object f6286L$3;

        /* renamed from: label */
        int f6287label;

        /* renamed from: result */
        /* synthetic */ Object f6288result;

        public C14511(Continuation<? super C14511> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6288result = obj;
            this.f6287label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.associateWith(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0}, m6126l = {249}, m6127m = "associateWithTo", m6128n = {"$this$associateWithTo", "destination", "valueSelector", "$i$f$associateWithTo"}, m6130s = {"L$0", "L$1", "L$2", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associateWithTo$1\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associateWithTo$1 */
    public static final class C14521<K, V, M extends Map<? super K, ? super V>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6289I$0;

        /* renamed from: L$0 */
        Object f6290L$0;

        /* renamed from: L$1 */
        Object f6291L$1;

        /* renamed from: L$2 */
        Object f6292L$2;

        /* renamed from: label */
        int f6293label;

        /* renamed from: result */
        /* synthetic */ Object f6294result;

        public C14521(Continuation<? super C14521> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6294result = obj;
            this.f6293label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.associateWithTo(null, null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$associateWithTo$2\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$associateWithTo$2 */
    public static final class C14532<T> implements FlowCollector {

        /* JADX INFO: Incorrect field signature: TM; */
        final /* synthetic */ Map $destination;
        final /* synthetic */ Function2<K, Continuation<? super V>, Object> $valueSelector;

        /* JADX WARN: Incorrect types in method signature: (TM;Lkotlin/jvm/functions/Function2<-TK;-Lkotlin/coroutines/Continuation<-TV;>;+Ljava/lang/Object;>;)V */
        public C14532(Map map, Function2 function2) {
            this.$destination = map;
            this.$valueSelector = function2;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(K k, Continuation<? super C1133Unit> continuation) {
            FlowKt__CollectionKt$associateWithTo$2$emit$1 flowKt__CollectionKt$associateWithTo$2$emit$1;
            Map map;
            Object obj;
            if (continuation instanceof FlowKt__CollectionKt$associateWithTo$2$emit$1) {
                flowKt__CollectionKt$associateWithTo$2$emit$1 = (FlowKt__CollectionKt$associateWithTo$2$emit$1) continuation;
                int i = flowKt__CollectionKt$associateWithTo$2$emit$1.f6298label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__CollectionKt$associateWithTo$2$emit$1.f6298label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__CollectionKt$associateWithTo$2$emit$1 = new FlowKt__CollectionKt$associateWithTo$2$emit$1(this, continuation);
                }
            }
            Object obj2 = flowKt__CollectionKt$associateWithTo$2$emit$1.f6299result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__CollectionKt$associateWithTo$2$emit$1.f6298label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(obj2);
                Map map2 = this.$destination;
                Function2<K, Continuation<? super V>, Object> function2 = this.$valueSelector;
                flowKt__CollectionKt$associateWithTo$2$emit$1.f6295L$0 = SpillingKt.nullOutSpilledVariable(k);
                flowKt__CollectionKt$associateWithTo$2$emit$1.f6296L$1 = map2;
                flowKt__CollectionKt$associateWithTo$2$emit$1.f6297L$2 = k;
                flowKt__CollectionKt$associateWithTo$2$emit$1.f6298label = 1;
                Object objMo2167invoke = function2.mo2167invoke(k, flowKt__CollectionKt$associateWithTo$2$emit$1);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
                obj2 = objMo2167invoke;
                map = map2;
                obj = k;
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                Object obj3 = flowKt__CollectionKt$associateWithTo$2$emit$1.f6297L$2;
                map = (Map) flowKt__CollectionKt$associateWithTo$2$emit$1.f6296L$1;
                ResultKt.throwOnFailure(obj2);
                obj = obj3;
            }
            map.put(obj, obj2);
            return C1133Unit.INSTANCE;
        }

        public final Object emit$$forInline(K k, Continuation<? super C1133Unit> continuation) {
            InlineMarker.m6315mark(4);
            new FlowKt__CollectionKt$associateWithTo$2$emit$1(this, continuation);
            InlineMarker.m6315mark(5);
            this.$destination.put(k, this.$valueSelector.mo2167invoke(k, continuation));
            return C1133Unit.INSTANCE;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {365}, m6127m = "groupBy", m6128n = {"$this$groupBy", "keySelector", "$this$groupByTo$iv", "destination$iv", "$i$f$groupBy", "$i$f$groupByTo"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$groupBy$1\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$groupBy$1 */
    public static final class C14541<T, K> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6301I$0;

        /* renamed from: I$1 */
        int f6302I$1;

        /* renamed from: L$0 */
        Object f6303L$0;

        /* renamed from: L$1 */
        Object f6304L$1;

        /* renamed from: L$2 */
        Object f6305L$2;

        /* renamed from: L$3 */
        Object f6306L$3;

        /* renamed from: label */
        int f6307label;

        /* renamed from: result */
        /* synthetic */ Object f6308result;

        public C14541(Continuation<? super C14541> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6308result = obj;
            this.f6307label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.m7271groupBy(null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0, 0, 0, 0}, m6126l = {365}, m6127m = "groupBy", m6128n = {"$this$groupBy", "keySelector", "valueTransform", "$this$groupByTo$iv", "destination$iv", "$i$f$groupBy", "$i$f$groupByTo"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$groupBy$2\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$groupBy$2 */
    public static final class C14552<T, K, V> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6309I$0;

        /* renamed from: I$1 */
        int f6310I$1;

        /* renamed from: L$0 */
        Object f6311L$0;

        /* renamed from: L$1 */
        Object f6312L$1;

        /* renamed from: L$2 */
        Object f6313L$2;

        /* renamed from: L$3 */
        Object f6314L$3;

        /* renamed from: L$4 */
        Object f6315L$4;

        /* renamed from: label */
        int f6316label;

        /* renamed from: result */
        /* synthetic */ Object f6317result;

        public C14552(Continuation<? super C14552> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6317result = obj;
            this.f6316label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.m7272groupBy(null, null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0}, m6126l = {327}, m6127m = "groupByTo", m6128n = {"$this$groupByTo", "destination", "keySelector", "$i$f$groupByTo"}, m6130s = {"L$0", "L$1", "L$2", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$groupByTo$1\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$groupByTo$1 */
    public static final class C14561<T, K, M extends Map<? super K, List<T>>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6318I$0;

        /* renamed from: L$0 */
        Object f6319L$0;

        /* renamed from: L$1 */
        Object f6320L$1;

        /* renamed from: L$2 */
        Object f6321L$2;

        /* renamed from: label */
        int f6322label;

        /* renamed from: result */
        /* synthetic */ Object f6323result;

        public C14561(Continuation<? super C14561> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6323result = obj;
            this.f6322label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.groupByTo(null, null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$groupByTo$2\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,364:1\n382#2,7:365\n*S KotlinDebug\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$groupByTo$2\n*L\n329#1:365,7\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$groupByTo$2 */
    public static final class C14572<T> implements FlowCollector {

        /* JADX INFO: Incorrect field signature: TM; */
        final /* synthetic */ Map $destination;
        final /* synthetic */ Function2<T, Continuation<? super K>, Object> $keySelector;

        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-TK;>;+Ljava/lang/Object;>;TM;)V */
        public C14572(Function2 function2, Map map) {
            this.$keySelector = function2;
            this.$destination = map;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            FlowKt__CollectionKt$groupByTo$2$emit$1 flowKt__CollectionKt$groupByTo$2$emit$1;
            if (continuation instanceof FlowKt__CollectionKt$groupByTo$2$emit$1) {
                flowKt__CollectionKt$groupByTo$2$emit$1 = (FlowKt__CollectionKt$groupByTo$2$emit$1) continuation;
                int i = flowKt__CollectionKt$groupByTo$2$emit$1.f6325label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__CollectionKt$groupByTo$2$emit$1.f6325label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__CollectionKt$groupByTo$2$emit$1 = new FlowKt__CollectionKt$groupByTo$2$emit$1(this, continuation);
                }
            }
            Object objMo2167invoke = flowKt__CollectionKt$groupByTo$2$emit$1.f6326result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__CollectionKt$groupByTo$2$emit$1.f6325label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(objMo2167invoke);
                Function2<T, Continuation<? super K>, Object> function2 = this.$keySelector;
                flowKt__CollectionKt$groupByTo$2$emit$1.f6324L$0 = t;
                flowKt__CollectionKt$groupByTo$2$emit$1.f6325label = 1;
                objMo2167invoke = function2.mo2167invoke(t, flowKt__CollectionKt$groupByTo$2$emit$1);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                t = (T) flowKt__CollectionKt$groupByTo$2$emit$1.f6324L$0;
                ResultKt.throwOnFailure(objMo2167invoke);
            }
            Map map = this.$destination;
            Object arrayList = map.get(objMo2167invoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(objMo2167invoke, arrayList);
            }
            ((List) arrayList).add(t);
            return C1133Unit.INSTANCE;
        }

        public final Object emit$$forInline(T t, Continuation<? super C1133Unit> continuation) {
            InlineMarker.m6315mark(4);
            new FlowKt__CollectionKt$groupByTo$2$emit$1(this, continuation);
            InlineMarker.m6315mark(5);
            Object objMo2167invoke = this.$keySelector.mo2167invoke(t, continuation);
            Map map = this.$destination;
            Object arrayList = map.get(objMo2167invoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(objMo2167invoke, arrayList);
            }
            ((List) arrayList).add(t);
            return C1133Unit.INSTANCE;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0, 0, 0, 0}, m6126l = {357}, m6127m = "groupByTo", m6128n = {"$this$groupByTo", "destination", "keySelector", "valueTransform", "$i$f$groupByTo"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, m6131v = 1)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$groupByTo$3\n*L\n1#1,364:1\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$groupByTo$3 */
    public static final class C14583<T, K, V, M extends Map<? super K, List<V>>> extends ContinuationImpl {

        /* renamed from: I$0 */
        int f6328I$0;

        /* renamed from: L$0 */
        Object f6329L$0;

        /* renamed from: L$1 */
        Object f6330L$1;

        /* renamed from: L$2 */
        Object f6331L$2;

        /* renamed from: L$3 */
        Object f6332L$3;

        /* renamed from: label */
        int f6333label;

        /* renamed from: result */
        /* synthetic */ Object f6334result;

        public C14583(Continuation<? super C14583> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6334result = obj;
            this.f6333label |= Integer.MIN_VALUE;
            return FlowKt__CollectionKt.groupByTo(null, null, null, null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
    @SourceDebugExtension(m6344value = {"SMAP\nCollection.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$groupByTo$4\n+ 2 Maps.kt\nkotlin/collections/MapsKt__MapsKt\n*L\n1#1,364:1\n382#2,7:365\n*S KotlinDebug\n*F\n+ 1 Collection.kt\nkotlinx/coroutines/flow/FlowKt__CollectionKt$groupByTo$4\n*L\n359#1:365,7\n*E\n"})
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$groupByTo$4 */
    public static final class C14594<T> implements FlowCollector {

        /* JADX INFO: Incorrect field signature: TM; */
        final /* synthetic */ Map $destination;
        final /* synthetic */ Function2<T, Continuation<? super K>, Object> $keySelector;
        final /* synthetic */ Function2<T, Continuation<? super V>, Object> $valueTransform;

        /* JADX WARN: Incorrect types in method signature: (Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-TK;>;+Ljava/lang/Object;>;TM;Lkotlin/jvm/functions/Function2<-TT;-Lkotlin/coroutines/Continuation<-TV;>;+Ljava/lang/Object;>;)V */
        public C14594(Function2 function2, Map map, Function2 function22) {
            this.$keySelector = function2;
            this.$destination = map;
            this.$valueTransform = function22;
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
        @Override // p122kotlinx.coroutines.p125flow.FlowCollector
        /* renamed from: emit */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation) {
            FlowKt__CollectionKt$groupByTo$4$emit$1 flowKt__CollectionKt$groupByTo$4$emit$1;
            List list;
            if (continuation instanceof FlowKt__CollectionKt$groupByTo$4$emit$1) {
                flowKt__CollectionKt$groupByTo$4$emit$1 = (FlowKt__CollectionKt$groupByTo$4$emit$1) continuation;
                int i = flowKt__CollectionKt$groupByTo$4$emit$1.f6339label;
                if ((i & Integer.MIN_VALUE) != 0) {
                    flowKt__CollectionKt$groupByTo$4$emit$1.f6339label = i - Integer.MIN_VALUE;
                } else {
                    flowKt__CollectionKt$groupByTo$4$emit$1 = new FlowKt__CollectionKt$groupByTo$4$emit$1(this, continuation);
                }
            }
            Object objMo2167invoke = flowKt__CollectionKt$groupByTo$4$emit$1.f6340result;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = flowKt__CollectionKt$groupByTo$4$emit$1.f6339label;
            if (i2 == 0) {
                ResultKt.throwOnFailure(objMo2167invoke);
                Function2<T, Continuation<? super K>, Object> function2 = this.$keySelector;
                flowKt__CollectionKt$groupByTo$4$emit$1.f6335L$0 = t;
                flowKt__CollectionKt$groupByTo$4$emit$1.f6339label = 1;
                objMo2167invoke = function2.mo2167invoke(t, flowKt__CollectionKt$groupByTo$4$emit$1);
                if (objMo2167invoke == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i2 != 1) {
                    if (i2 != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    list = (List) flowKt__CollectionKt$groupByTo$4$emit$1.f6338L$3;
                    ResultKt.throwOnFailure(objMo2167invoke);
                    list.add(objMo2167invoke);
                    return C1133Unit.INSTANCE;
                }
                t = (T) flowKt__CollectionKt$groupByTo$4$emit$1.f6335L$0;
                ResultKt.throwOnFailure(objMo2167invoke);
            }
            Map map = this.$destination;
            Object arrayList = map.get(objMo2167invoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(objMo2167invoke, arrayList);
            }
            List list2 = (List) arrayList;
            Function2<T, Continuation<? super V>, Object> function22 = this.$valueTransform;
            flowKt__CollectionKt$groupByTo$4$emit$1.f6335L$0 = SpillingKt.nullOutSpilledVariable(t);
            flowKt__CollectionKt$groupByTo$4$emit$1.f6336L$1 = SpillingKt.nullOutSpilledVariable(objMo2167invoke);
            flowKt__CollectionKt$groupByTo$4$emit$1.f6337L$2 = SpillingKt.nullOutSpilledVariable(list2);
            flowKt__CollectionKt$groupByTo$4$emit$1.f6338L$3 = list2;
            flowKt__CollectionKt$groupByTo$4$emit$1.f6339label = 2;
            objMo2167invoke = function22.mo2167invoke(t, flowKt__CollectionKt$groupByTo$4$emit$1);
            if (objMo2167invoke == coroutine_suspended) {
                return coroutine_suspended;
            }
            list = list2;
            list.add(objMo2167invoke);
            return C1133Unit.INSTANCE;
        }

        public final Object emit$$forInline(T t, Continuation<? super C1133Unit> continuation) {
            InlineMarker.m6315mark(4);
            new FlowKt__CollectionKt$groupByTo$4$emit$1(this, continuation);
            InlineMarker.m6315mark(5);
            Object objMo2167invoke = this.$keySelector.mo2167invoke(t, continuation);
            Map map = this.$destination;
            Object arrayList = map.get(objMo2167invoke);
            if (arrayList == null) {
                arrayList = new ArrayList();
                map.put(objMo2167invoke, arrayList);
            }
            ((List) arrayList).add(this.$valueTransform.mo2167invoke(t, continuation));
            return C1133Unit.INSTANCE;
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.flow.FlowKt__CollectionKt", m6124f = "Collection.kt", m6125i = {0, 0}, m6126l = {21}, m6127m = "toCollection", m6128n = {"$this$toCollection", "destination"}, m6130s = {"L$0", "L$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.flow.FlowKt__CollectionKt$toCollection$1 */
    public static final class C14601<T, C extends Collection<? super T>> extends ContinuationImpl {

        /* renamed from: L$0 */
        Object f6342L$0;

        /* renamed from: L$1 */
        Object f6343L$1;

        /* renamed from: label */
        int f6344label;

        /* renamed from: result */
        /* synthetic */ Object f6345result;

        public C14601(Continuation<? super C14601> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f6345result = obj;
            this.f6344label |= Integer.MIN_VALUE;
            return C1427FlowKt.toCollection(null, null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V> Object associate(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1122Pair<? extends K, ? extends V>>, ? extends Object> function2, Continuation<? super Map<K, ? extends V>> continuation) {
        C14421 c14421;
        if (continuation instanceof C14421) {
            c14421 = (C14421) continuation;
            int i = c14421.f6227label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14421.f6227label = i - Integer.MIN_VALUE;
            } else {
                c14421 = new C14421(continuation);
            }
        }
        Object obj = c14421.f6228result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14421.f6227label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14421.f6226L$3;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FlowCollector<? super Object> c14502 = new C14502<>(linkedHashMap, function2);
        c14421.f6223L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14421.f6224L$1 = SpillingKt.nullOutSpilledVariable(function2);
        c14421.f6225L$2 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14421.f6226L$3 = linkedHashMap;
        c14421.f6221I$0 = 0;
        c14421.f6222I$1 = 0;
        c14421.f6227label = 1;
        return interfaceC1426Flow.mo4308collect(c14502, c14421) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
    }

    private static final <T, K, V> Object associate$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super C1122Pair<? extends K, ? extends V>>, ? extends Object> function2, Continuation<? super Map<K, ? extends V>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C14502 c14502 = new C14502(linkedHashMap, function2);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14502, continuation);
        InlineMarker.m6315mark(1);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K> Object associateBy(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super Map<K, ? extends T>> continuation) {
        C14431 c14431;
        if (continuation instanceof C14431) {
            c14431 = (C14431) continuation;
            int i = c14431.f6235label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14431.f6235label = i - Integer.MIN_VALUE;
            } else {
                c14431 = new C14431(continuation);
            }
        }
        Object obj = c14431.f6236result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14431.f6235label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14431.f6234L$3;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FlowCollector<? super Object> c14462 = new C14462<>(linkedHashMap, function2);
        c14431.f6231L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14431.f6232L$1 = SpillingKt.nullOutSpilledVariable(function2);
        c14431.f6233L$2 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14431.f6234L$3 = linkedHashMap;
        c14431.f6229I$0 = 0;
        c14431.f6230I$1 = 0;
        c14431.f6235label = 1;
        return interfaceC1426Flow.mo4308collect(c14462, c14431) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
    }

    private static final <T, K> Object associateBy$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super Map<K, ? extends T>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C14462 c14462 = new C14462(linkedHashMap, function2);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14462, continuation);
        InlineMarker.m6315mark(1);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, M extends Map<? super K, ? super T>> Object associateByTo(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super M> continuation) {
        C14451 c14451;
        if (continuation instanceof C14451) {
            c14451 = (C14451) continuation;
            int i = c14451.f6250label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14451.f6250label = i - Integer.MIN_VALUE;
            } else {
                c14451 = new C14451(continuation);
            }
        }
        Object obj = c14451.f6251result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14451.f6250label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14451.f6248L$1;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        FlowCollector<? super Object> c14462 = new C14462<>(m, function2);
        c14451.f6247L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14451.f6248L$1 = m;
        c14451.f6249L$2 = SpillingKt.nullOutSpilledVariable(function2);
        c14451.f6246I$0 = 0;
        c14451.f6250label = 1;
        return interfaceC1426Flow.mo4308collect(c14462, c14451) == coroutine_suspended ? coroutine_suspended : m;
    }

    private static final <T, K, M extends Map<? super K, ? super T>> Object associateByTo$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super M> continuation) {
        C14462 c14462 = new C14462(m, function2);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14462, continuation);
        InlineMarker.m6315mark(1);
        return m;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V, M extends Map<? super K, ? super V>> Object associateTo(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super C1122Pair<? extends K, ? extends V>>, ? extends Object> function2, Continuation<? super M> continuation) {
        C14491 c14491;
        if (continuation instanceof C14491) {
            c14491 = (C14491) continuation;
            int i = c14491.f6274label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14491.f6274label = i - Integer.MIN_VALUE;
            } else {
                c14491 = new C14491(continuation);
            }
        }
        Object obj = c14491.f6275result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14491.f6274label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14491.f6272L$1;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        FlowCollector<? super Object> c14502 = new C14502<>(m, function2);
        c14491.f6271L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14491.f6272L$1 = m;
        c14491.f6273L$2 = SpillingKt.nullOutSpilledVariable(function2);
        c14491.f6270I$0 = 0;
        c14491.f6274label = 1;
        return interfaceC1426Flow.mo4308collect(c14502, c14491) == coroutine_suspended ? coroutine_suspended : m;
    }

    private static final <T, K, V, M extends Map<? super K, ? super V>> Object associateTo$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super C1122Pair<? extends K, ? extends V>>, ? extends Object> function2, Continuation<? super M> continuation) {
        C14502 c14502 = new C14502(m, function2);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14502, continuation);
        InlineMarker.m6315mark(1);
        return m;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V> Object associateWith(InterfaceC1426Flow<? extends K> interfaceC1426Flow, Function2<? super K, ? super Continuation<? super V>, ? extends Object> function2, Continuation<? super Map<K, ? extends V>> continuation) {
        C14511 c14511;
        if (continuation instanceof C14511) {
            c14511 = (C14511) continuation;
            int i = c14511.f6287label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14511.f6287label = i - Integer.MIN_VALUE;
            } else {
                c14511 = new C14511(continuation);
            }
        }
        Object obj = c14511.f6288result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14511.f6287label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14511.f6286L$3;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FlowCollector<? super Object> c14532 = new C14532<>(linkedHashMap, function2);
        c14511.f6283L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14511.f6284L$1 = SpillingKt.nullOutSpilledVariable(function2);
        c14511.f6285L$2 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14511.f6286L$3 = linkedHashMap;
        c14511.f6281I$0 = 0;
        c14511.f6282I$1 = 0;
        c14511.f6287label = 1;
        return interfaceC1426Flow.mo4308collect(c14532, c14511) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
    }

    private static final <K, V> Object associateWith$$forInline(InterfaceC1426Flow<? extends K> interfaceC1426Flow, Function2<? super K, ? super Continuation<? super V>, ? extends Object> function2, Continuation<? super Map<K, ? extends V>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C14532 c14532 = new C14532(linkedHashMap, function2);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14532, continuation);
        InlineMarker.m6315mark(1);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <K, V, M extends Map<? super K, ? super V>> Object associateWithTo(InterfaceC1426Flow<? extends K> interfaceC1426Flow, M m, Function2<? super K, ? super Continuation<? super V>, ? extends Object> function2, Continuation<? super M> continuation) {
        C14521 c14521;
        if (continuation instanceof C14521) {
            c14521 = (C14521) continuation;
            int i = c14521.f6293label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14521.f6293label = i - Integer.MIN_VALUE;
            } else {
                c14521 = new C14521(continuation);
            }
        }
        Object obj = c14521.f6294result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14521.f6293label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14521.f6291L$1;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        FlowCollector<? super Object> c14532 = new C14532<>(m, function2);
        c14521.f6290L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14521.f6291L$1 = m;
        c14521.f6292L$2 = SpillingKt.nullOutSpilledVariable(function2);
        c14521.f6289I$0 = 0;
        c14521.f6293label = 1;
        return interfaceC1426Flow.mo4308collect(c14532, c14521) == coroutine_suspended ? coroutine_suspended : m;
    }

    private static final <K, V, M extends Map<? super K, ? super V>> Object associateWithTo$$forInline(InterfaceC1426Flow<? extends K> interfaceC1426Flow, M m, Function2<? super K, ? super Continuation<? super V>, ? extends Object> function2, Continuation<? super M> continuation) {
        C14532 c14532 = new C14532(m, function2);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14532, continuation);
        InlineMarker.m6315mark(1);
        return m;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: groupBy */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K> Object m7271groupBy(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super Map<K, ? extends List<? extends T>>> continuation) {
        C14541 c14541;
        if (continuation instanceof C14541) {
            c14541 = (C14541) continuation;
            int i = c14541.f6307label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14541.f6307label = i - Integer.MIN_VALUE;
            } else {
                c14541 = new C14541(continuation);
            }
        }
        Object obj = c14541.f6308result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14541.f6307label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14541.f6306L$3;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FlowCollector<? super Object> c14572 = new C14572<>(function2, linkedHashMap);
        c14541.f6303L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14541.f6304L$1 = SpillingKt.nullOutSpilledVariable(function2);
        c14541.f6305L$2 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14541.f6306L$3 = linkedHashMap;
        c14541.f6301I$0 = 0;
        c14541.f6302I$1 = 0;
        c14541.f6307label = 1;
        return interfaceC1426Flow.mo4308collect(c14572, c14541) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
    }

    private static final <T, K> Object groupBy$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super Map<K, ? extends List<? extends T>>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C14572 c14572 = new C14572(function2, linkedHashMap);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14572, continuation);
        InlineMarker.m6315mark(1);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, M extends Map<? super K, List<T>>> Object groupByTo(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super M> continuation) {
        C14561 c14561;
        if (continuation instanceof C14561) {
            c14561 = (C14561) continuation;
            int i = c14561.f6322label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14561.f6322label = i - Integer.MIN_VALUE;
            } else {
                c14561 = new C14561(continuation);
            }
        }
        Object obj = c14561.f6323result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14561.f6322label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14561.f6320L$1;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        FlowCollector<? super Object> c14572 = new C14572<>(function2, m);
        c14561.f6319L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14561.f6320L$1 = m;
        c14561.f6321L$2 = SpillingKt.nullOutSpilledVariable(function2);
        c14561.f6318I$0 = 0;
        c14561.f6322label = 1;
        return interfaceC1426Flow.mo4308collect(c14572, c14561) == coroutine_suspended ? coroutine_suspended : m;
    }

    private static final <T, K, M extends Map<? super K, List<T>>> Object groupByTo$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Continuation<? super M> continuation) {
        C14572 c14572 = new C14572(function2, m);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14572, continuation);
        InlineMarker.m6315mark(1);
        return m;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, C extends Collection<? super T>> Object toCollection(InterfaceC1426Flow<? extends T> interfaceC1426Flow, final C c, Continuation<? super C> continuation) {
        C14601 c14601;
        if (continuation instanceof C14601) {
            c14601 = (C14601) continuation;
            int i = c14601.f6344label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14601.f6344label = i - Integer.MIN_VALUE;
            } else {
                c14601 = new C14601(continuation);
            }
        }
        Object obj = c14601.f6345result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14601.f6344label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Collection collection = (Collection) c14601.f6343L$1;
            ResultKt.throwOnFailure(obj);
            return collection;
        }
        ResultKt.throwOnFailure(obj);
        FlowCollector<? super Object> flowCollector = new FlowCollector() { // from class: kotlinx.coroutines.flow.FlowKt__CollectionKt.toCollection.2
            @Override // p122kotlinx.coroutines.p125flow.FlowCollector
            /* renamed from: emit */
            public final Object mo4309emit(T t, Continuation<? super C1133Unit> continuation2) {
                c.add(t);
                return C1133Unit.INSTANCE;
            }
        };
        c14601.f6342L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14601.f6343L$1 = c;
        c14601.f6344label = 1;
        return interfaceC1426Flow.mo4308collect(flowCollector, c14601) == coroutine_suspended ? coroutine_suspended : c;
    }

    /* renamed from: toList */
    public static final <T> Object m7273toList(InterfaceC1426Flow<? extends T> interfaceC1426Flow, List<T> list, Continuation<? super List<? extends T>> continuation) {
        return C1427FlowKt.toCollection(interfaceC1426Flow, list, continuation);
    }

    public static /* synthetic */ Object toList$default(InterfaceC1426Flow interfaceC1426Flow, List list, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            list = new ArrayList();
        }
        return C1427FlowKt.m7251toList(interfaceC1426Flow, list, continuation);
    }

    /* renamed from: toSet */
    public static final <T> Object m7274toSet(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Set<T> set, Continuation<? super Set<? extends T>> continuation) {
        return C1427FlowKt.toCollection(interfaceC1426Flow, set, continuation);
    }

    public static /* synthetic */ Object toSet$default(InterfaceC1426Flow interfaceC1426Flow, Set set, Continuation continuation, int i, Object obj) {
        if ((i & 1) != 0) {
            set = new LinkedHashSet();
        }
        return C1427FlowKt.m7252toSet(interfaceC1426Flow, set, continuation);
    }

    private static final <T, K, V, M extends Map<? super K, ? super V>> Object associateByTo$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super M> continuation) {
        C14484 c14484 = new C14484(m, function2, function22);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14484, continuation);
        InlineMarker.m6315mark(1);
        return m;
    }

    private static final <T, K, V, M extends Map<? super K, List<V>>> Object groupByTo$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super M> continuation) {
        C14594 c14594 = new C14594(function2, m, function22);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14594, continuation);
        InlineMarker.m6315mark(1);
        return m;
    }

    private static final <T, K, V> Object associateBy$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super Map<K, ? extends V>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C14484 c14484 = new C14484(linkedHashMap, function2, function22);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14484, continuation);
        InlineMarker.m6315mark(1);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V, M extends Map<? super K, ? super V>> Object associateByTo(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super M> continuation) {
        C14473 c14473;
        if (continuation instanceof C14473) {
            c14473 = (C14473) continuation;
            int i = c14473.f6262label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14473.f6262label = i - Integer.MIN_VALUE;
            } else {
                c14473 = new C14473(continuation);
            }
        }
        Object obj = c14473.f6263result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14473.f6262label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14473.f6259L$1;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        FlowCollector<? super Object> c14484 = new C14484<>(m, function2, function22);
        c14473.f6258L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14473.f6259L$1 = m;
        c14473.f6260L$2 = SpillingKt.nullOutSpilledVariable(function2);
        c14473.f6261L$3 = SpillingKt.nullOutSpilledVariable(function22);
        c14473.f6257I$0 = 0;
        c14473.f6262label = 1;
        return interfaceC1426Flow.mo4308collect(c14484, c14473) == coroutine_suspended ? coroutine_suspended : m;
    }

    private static final <T, K, V> Object groupBy$$forInline(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super Map<K, ? extends List<? extends V>>> continuation) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        C14594 c14594 = new C14594(function2, linkedHashMap, function22);
        InlineMarker.m6315mark(0);
        interfaceC1426Flow.mo4308collect(c14594, continuation);
        InlineMarker.m6315mark(1);
        return linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V, M extends Map<? super K, List<V>>> Object groupByTo(InterfaceC1426Flow<? extends T> interfaceC1426Flow, M m, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super M> continuation) {
        C14583 c14583;
        if (continuation instanceof C14583) {
            c14583 = (C14583) continuation;
            int i = c14583.f6333label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14583.f6333label = i - Integer.MIN_VALUE;
            } else {
                c14583 = new C14583(continuation);
            }
        }
        Object obj = c14583.f6334result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14583.f6333label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14583.f6330L$1;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        FlowCollector<? super Object> c14594 = new C14594<>(function2, m, function22);
        c14583.f6329L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14583.f6330L$1 = m;
        c14583.f6331L$2 = SpillingKt.nullOutSpilledVariable(function2);
        c14583.f6332L$3 = SpillingKt.nullOutSpilledVariable(function22);
        c14583.f6328I$0 = 0;
        c14583.f6333label = 1;
        return interfaceC1426Flow.mo4308collect(c14594, c14583) == coroutine_suspended ? coroutine_suspended : m;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V> Object associateBy(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super Map<K, ? extends V>> continuation) {
        C14442 c14442;
        if (continuation instanceof C14442) {
            c14442 = (C14442) continuation;
            int i = c14442.f6244label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14442.f6244label = i - Integer.MIN_VALUE;
            } else {
                c14442 = new C14442(continuation);
            }
        }
        Object obj = c14442.f6245result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14442.f6244label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14442.f6243L$4;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FlowCollector<? super Object> c14484 = new C14484<>(linkedHashMap, function2, function22);
        c14442.f6239L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14442.f6240L$1 = SpillingKt.nullOutSpilledVariable(function2);
        c14442.f6241L$2 = SpillingKt.nullOutSpilledVariable(function22);
        c14442.f6242L$3 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14442.f6243L$4 = linkedHashMap;
        c14442.f6237I$0 = 0;
        c14442.f6238I$1 = 0;
        c14442.f6244label = 1;
        return interfaceC1426Flow.mo4308collect(c14484, c14442) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: groupBy */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final <T, K, V> Object m7272groupBy(InterfaceC1426Flow<? extends T> interfaceC1426Flow, Function2<? super T, ? super Continuation<? super K>, ? extends Object> function2, Function2<? super T, ? super Continuation<? super V>, ? extends Object> function22, Continuation<? super Map<K, ? extends List<? extends V>>> continuation) {
        C14552 c14552;
        if (continuation instanceof C14552) {
            c14552 = (C14552) continuation;
            int i = c14552.f6316label;
            if ((i & Integer.MIN_VALUE) != 0) {
                c14552.f6316label = i - Integer.MIN_VALUE;
            } else {
                c14552 = new C14552(continuation);
            }
        }
        Object obj = c14552.f6317result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = c14552.f6316label;
        if (i2 != 0) {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            Map map = (Map) c14552.f6315L$4;
            ResultKt.throwOnFailure(obj);
            return map;
        }
        ResultKt.throwOnFailure(obj);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        FlowCollector<? super Object> c14594 = new C14594<>(function2, linkedHashMap, function22);
        c14552.f6311L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14552.f6312L$1 = SpillingKt.nullOutSpilledVariable(function2);
        c14552.f6313L$2 = SpillingKt.nullOutSpilledVariable(function22);
        c14552.f6314L$3 = SpillingKt.nullOutSpilledVariable(interfaceC1426Flow);
        c14552.f6315L$4 = linkedHashMap;
        c14552.f6309I$0 = 0;
        c14552.f6310I$1 = 0;
        c14552.f6316label = 1;
        return interfaceC1426Flow.mo4308collect(c14594, c14552) == coroutine_suspended ? coroutine_suspended : linkedHashMap;
    }
}
