package p122kotlinx.coroutines;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.coroutines.p097jvm.internal.ContinuationImpl;
import p094kotlin.coroutines.p097jvm.internal.DebugMetadata;
import p094kotlin.coroutines.p097jvm.internal.SpillingKt;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000*\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a:\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u001e\u0010\u0003\u001a\u0010\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004\"\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006\u001a*\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0007H\u0086@¢\u0006\u0002\u0010\b\u001a\"\u0010\t\u001a\u00020\n2\u0012\u0010\u000b\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u0004\"\u00020\fH\u0086@¢\u0006\u0002\u0010\r\u001a\u0018\u0010\t\u001a\u00020\n*\b\u0012\u0004\u0012\u00020\f0\u0007H\u0086@¢\u0006\u0002\u0010\b¨\u0006\u000e"}, m4988d2 = {"awaitAll", BuildConfig.f24315FLAVOR, "T", "deferreds", BuildConfig.f24315FLAVOR, "Lkotlinx/coroutines/Deferred;", "([Lkotlinx/coroutines/Deferred;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", BuildConfig.f24315FLAVOR, "(Ljava/util/Collection;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "joinAll", BuildConfig.f24315FLAVOR, "jobs", "Lkotlinx/coroutines/Job;", "([Lkotlinx/coroutines/Job;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nAwait.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,121:1\n37#2,2:122\n13805#3,2:124\n1869#4,2:126\n*S KotlinDebug\n*F\n+ 1 Await.kt\nkotlinx/coroutines/AwaitKt\n*L\n36#1:122,2\n47#1:124,2\n58#1:126,2\n*E\n"})
/* renamed from: kotlinx.coroutines.AwaitKt */
/* loaded from: classes.dex */
public final class C1330AwaitKt {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.AwaitKt", m6124f = "Await.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {C5125EACTags.PIN_USAGE_POLICY}, m6127m = "joinAll", m6128n = {"jobs", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-AwaitKt$joinAll$2"}, m6130s = {"L$0", "L$1", "L$2", "L$3", "I$0", "I$3"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.AwaitKt$joinAll$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5470I$0;

        /* renamed from: I$1 */
        int f5471I$1;

        /* renamed from: I$2 */
        int f5472I$2;

        /* renamed from: I$3 */
        int f5473I$3;

        /* renamed from: L$0 */
        Object f5474L$0;

        /* renamed from: L$1 */
        Object f5475L$1;

        /* renamed from: L$2 */
        Object f5476L$2;

        /* renamed from: L$3 */
        Object f5477L$3;

        /* renamed from: label */
        int f5478label;

        /* renamed from: result */
        /* synthetic */ Object f5479result;

        public AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5479result = obj;
            this.f5478label |= Integer.MIN_VALUE;
            return C1330AwaitKt.m6907joinAll((InterfaceC1342Job[]) null, this);
        }
    }

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlinx.coroutines.AwaitKt", m6124f = "Await.kt", m6125i = {0, 0, 0, 0, 0, 0}, m6126l = {C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION}, m6127m = "joinAll", m6128n = {"$this$joinAll", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-AwaitKt$joinAll$4"}, m6130s = {"L$0", "L$1", "L$3", "L$4", "I$0", "I$1"}, m6131v = 1)
    /* renamed from: kotlinx.coroutines.AwaitKt$joinAll$3, reason: invalid class name */
    public static final class AnonymousClass3 extends ContinuationImpl {

        /* renamed from: I$0 */
        int f5480I$0;

        /* renamed from: I$1 */
        int f5481I$1;

        /* renamed from: L$0 */
        Object f5482L$0;

        /* renamed from: L$1 */
        Object f5483L$1;

        /* renamed from: L$2 */
        Object f5484L$2;

        /* renamed from: L$3 */
        Object f5485L$3;

        /* renamed from: L$4 */
        Object f5486L$4;

        /* renamed from: label */
        int f5487label;

        /* renamed from: result */
        /* synthetic */ Object f5488result;

        public AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(continuation);
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.f5488result = obj;
            this.f5487label |= Integer.MIN_VALUE;
            return C1330AwaitKt.m6906joinAll((Collection<? extends InterfaceC1342Job>) null, this);
        }
    }

    public static final <T> Object awaitAll(Deferred<? extends T>[] deferredArr, Continuation<? super List<? extends T>> continuation) {
        return deferredArr.length == 0 ? CollectionsKt.emptyList() : new AwaitAll(deferredArr).m6903await(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0058  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x007f -> B:20:0x0082). Please report as a decompilation issue!!! */
    /* renamed from: joinAll */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m6907joinAll(InterfaceC1342Job[] interfaceC1342JobArr, Continuation<? super C1133Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        AnonymousClass1 anonymousClass12;
        int i;
        int i2;
        InterfaceC1342Job[] interfaceC1342JobArr2;
        int length;
        InterfaceC1342Job[] interfaceC1342JobArr3;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            int i3 = anonymousClass1.f5478label;
            if ((i3 & Integer.MIN_VALUE) != 0) {
                anonymousClass1.f5478label = i3 - Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        }
        Object obj = anonymousClass1.f5479result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i4 = anonymousClass1.f5478label;
        if (i4 == 0) {
            ResultKt.throwOnFailure(obj);
            anonymousClass12 = anonymousClass1;
            i = 0;
            i2 = 0;
            interfaceC1342JobArr2 = interfaceC1342JobArr;
            length = interfaceC1342JobArr.length;
            interfaceC1342JobArr3 = interfaceC1342JobArr2;
            if (i < length) {
            }
        } else {
            if (i4 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            length = anonymousClass1.f5472I$2;
            int i5 = anonymousClass1.f5471I$1;
            int i6 = anonymousClass1.f5470I$0;
            InterfaceC1342Job[] interfaceC1342JobArr4 = (InterfaceC1342Job[]) anonymousClass1.f5475L$1;
            InterfaceC1342Job[] interfaceC1342JobArr5 = (InterfaceC1342Job[]) anonymousClass1.f5474L$0;
            ResultKt.throwOnFailure(obj);
            interfaceC1342JobArr3 = interfaceC1342JobArr4;
            i2 = i6;
            AnonymousClass1 anonymousClass13 = anonymousClass1;
            interfaceC1342JobArr2 = interfaceC1342JobArr5;
            AnonymousClass1 anonymousClass14 = anonymousClass13;
            i = i5 + 1;
            anonymousClass12 = anonymousClass14;
            if (i < length) {
                InterfaceC1342Job interfaceC1342Job = interfaceC1342JobArr3[i];
                anonymousClass12.f5474L$0 = SpillingKt.nullOutSpilledVariable(interfaceC1342JobArr2);
                anonymousClass12.f5475L$1 = interfaceC1342JobArr3;
                anonymousClass12.f5476L$2 = SpillingKt.nullOutSpilledVariable(interfaceC1342Job);
                anonymousClass12.f5477L$3 = SpillingKt.nullOutSpilledVariable(interfaceC1342Job);
                anonymousClass12.f5470I$0 = i2;
                anonymousClass12.f5471I$1 = i;
                anonymousClass12.f5472I$2 = length;
                anonymousClass12.f5473I$3 = 0;
                anonymousClass12.f5478label = 1;
                if (interfaceC1342Job.mo7000join(anonymousClass12) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                int i7 = i;
                anonymousClass13 = anonymousClass12;
                i5 = i7;
                AnonymousClass1 anonymousClass142 = anonymousClass13;
                i = i5 + 1;
                anonymousClass12 = anonymousClass142;
                if (i < length) {
                    return C1133Unit.INSTANCE;
                }
            }
        }
    }

    public static final <T> Object awaitAll(Collection<? extends Deferred<? extends T>> collection, Continuation<? super List<? extends T>> continuation) {
        return collection.isEmpty() ? CollectionsKt.emptyList() : new AwaitAll((Deferred[]) collection.toArray(new Deferred[0])).m6903await(continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* renamed from: joinAll */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static final Object m6906joinAll(Collection<? extends InterfaceC1342Job> collection, Continuation<? super C1133Unit> continuation) {
        AnonymousClass3 anonymousClass3;
        Iterator it;
        AnonymousClass3 anonymousClass32;
        int i;
        Object obj;
        if (continuation instanceof AnonymousClass3) {
            anonymousClass3 = (AnonymousClass3) continuation;
            int i2 = anonymousClass3.f5487label;
            if ((i2 & Integer.MIN_VALUE) != 0) {
                anonymousClass3.f5487label = i2 - Integer.MIN_VALUE;
            } else {
                anonymousClass3 = new AnonymousClass3(continuation);
            }
        }
        Object obj2 = anonymousClass3.f5488result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i3 = anonymousClass3.f5487label;
        if (i3 == 0) {
            ResultKt.throwOnFailure(obj2);
            it = collection.iterator();
            anonymousClass32 = anonymousClass3;
            i = 0;
            obj = collection;
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i4 = anonymousClass3.f5480I$0;
            Iterator it2 = (Iterator) anonymousClass3.f5484L$2;
            Object obj3 = (Iterable) anonymousClass3.f5483L$1;
            Collection<? extends InterfaceC1342Job> collection2 = (Collection) anonymousClass3.f5482L$0;
            ResultKt.throwOnFailure(obj2);
            obj = obj3;
            it = it2;
            anonymousClass32 = anonymousClass3;
            i = i4;
            collection = collection2;
        }
        while (it.hasNext()) {
            Object next = it.next();
            InterfaceC1342Job interfaceC1342Job = (InterfaceC1342Job) next;
            anonymousClass32.f5482L$0 = SpillingKt.nullOutSpilledVariable(collection);
            anonymousClass32.f5483L$1 = SpillingKt.nullOutSpilledVariable(obj);
            anonymousClass32.f5484L$2 = it;
            anonymousClass32.f5485L$3 = SpillingKt.nullOutSpilledVariable(next);
            anonymousClass32.f5486L$4 = SpillingKt.nullOutSpilledVariable(interfaceC1342Job);
            anonymousClass32.f5480I$0 = i;
            anonymousClass32.f5481I$1 = 0;
            anonymousClass32.f5487label = 1;
            if (interfaceC1342Job.mo7000join(anonymousClass32) == coroutine_suspended) {
                return coroutine_suspended;
            }
        }
        return C1133Unit.INSTANCE;
    }
}
