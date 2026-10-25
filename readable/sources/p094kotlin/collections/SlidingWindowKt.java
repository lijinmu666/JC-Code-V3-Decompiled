package p094kotlin.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import org.bouncycastle.p133asn1.p143eac.C5125EACTags;
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
import p094kotlin.p112ranges.RangesKt;
import p094kotlin.sequences.Sequence;
import p094kotlin.sequences.SequenceScope;
import p094kotlin.sequences.SequencesKt;

@Metadata(m4987d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003H\u0080\u0080\u0004\u001aF\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\u0006\"\u0004\b\u0000\u0010\b*\b\u0012\u0004\u0012\u0002H\b0\u00062\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0080\u0080\u0004\u001aJ\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u00070\r\"\u0004\b\u0000\u0010\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\b0\r2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0080\u0080\u0004¨\u0006\u000f"}, m4988d2 = {"checkWindowSizeStep", BuildConfig.f24315FLAVOR, "size", BuildConfig.f24315FLAVOR, "step", "windowedSequence", "Lkotlin/sequences/Sequence;", BuildConfig.f24315FLAVOR, "T", "partialWindows", BuildConfig.f24315FLAVOR, "reuseBuffer", "windowedIterator", BuildConfig.f24315FLAVOR, "iterator", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class SlidingWindowKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    @Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00040\u0003H\n"}, m4988d2 = {"<anonymous>", BuildConfig.f24315FLAVOR, "T", "Lkotlin/sequences/SequenceScope;", BuildConfig.f24315FLAVOR}, m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @DebugMetadata(m6123c = "kotlin.collections.SlidingWindowKt$windowedIterator$1", m6124f = "SlidingWindow.kt", m6125i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4}, m6126l = {34, 40, 49, 55, C5125EACTags.DYNAMIC_INTERNAL_AUTHENTIFICATION}, m6127m = "invokeSuspend", m6128n = {"$this$iterator", "buffer", "e", "bufferInitialCapacity", "gap", "skip", "$this$iterator", "buffer", "bufferInitialCapacity", "gap", "skip", "$this$iterator", "buffer", "e", "bufferInitialCapacity", "gap", "$this$iterator", "buffer", "bufferInitialCapacity", "gap", "$this$iterator", "buffer", "bufferInitialCapacity", "gap"}, m6129nl = {35, C5125EACTags.DATE_OF_BIRTH, 50, 56, 61}, m6130s = {"L$0", "L$1", "L$3", "I$0", "I$1", "I$2", "L$0", "L$1", "I$0", "I$1", "I$2", "L$0", "L$1", "L$3", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1", "L$0", "L$1", "I$0", "I$1"}, m6131v = 2)
    /* renamed from: kotlin.collections.SlidingWindowKt$windowedIterator$1 */
    public static final class C11601<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super List<? extends T>>, Continuation<? super C1133Unit>, Object> {
        final /* synthetic */ Iterator<T> $iterator;
        final /* synthetic */ boolean $partialWindows;
        final /* synthetic */ boolean $reuseBuffer;

        /* renamed from: $size */
        final /* synthetic */ int f4968$size;

        /* renamed from: $step */
        final /* synthetic */ int f4969$step;

        /* renamed from: I$0 */
        int f4970I$0;

        /* renamed from: I$1 */
        int f4971I$1;

        /* renamed from: I$2 */
        int f4972I$2;

        /* renamed from: L$0 */
        private /* synthetic */ Object f4973L$0;

        /* renamed from: L$1 */
        Object f4974L$1;

        /* renamed from: L$2 */
        Object f4975L$2;

        /* renamed from: L$3 */
        Object f4976L$3;

        /* renamed from: label */
        int f4977label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public C11601(int i, int i2, Iterator<? extends T> it, boolean z, boolean z2, Continuation<? super C11601> continuation) {
            super(2, continuation);
            this.f4968$size = i;
            this.f4969$step = i2;
            this.$iterator = it;
            this.$reuseBuffer = z;
            this.$partialWindows = z2;
        }

        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /* renamed from: create */
        public final Continuation<C1133Unit> mo2166create(Object obj, Continuation<?> continuation) {
            C11601 c11601 = new C11601(this.f4968$size, this.f4969$step, this.$iterator, this.$reuseBuffer, this.$partialWindows, continuation);
            c11601.f4973L$0 = obj;
            return c11601;
        }

        /* JADX WARN: Removed duplicated region for block: B:23:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x00b8  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x00bc  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x00f6 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:48:0x0106  */
        /* JADX WARN: Removed duplicated region for block: B:63:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0158  */
        /* JADX WARN: Removed duplicated region for block: B:74:0x017e  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:29:0x00b1 -> B:17:0x005f). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:58:0x0141 -> B:60:0x0144). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:71:0x0175 -> B:73:0x0178). Please report as a decompilation issue!!! */
        @Override // p094kotlin.coroutines.p097jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public final Object invokeSuspend(Object obj) {
            int i;
            Iterator<T> it;
            RingBuffer ringBufferExpanded;
            int i2;
            Iterator<T> it2;
            int i3;
            int i4;
            ArrayList arrayList;
            int i5;
            RingBuffer ringBuffer;
            SequenceScope sequenceScope = (SequenceScope) this.f4973L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i6 = this.f4977label;
            if (i6 == 0) {
                ResultKt.throwOnFailure(obj);
                int iCoerceAtMost = RangesKt.coerceAtMost(this.f4968$size, 1024);
                i = this.f4969$step - this.f4968$size;
                if (i < 0) {
                    RingBuffer ringBuffer2 = new RingBuffer(iCoerceAtMost);
                    it = this.$iterator;
                    ringBufferExpanded = ringBuffer2;
                    i2 = iCoerceAtMost;
                    while (it.hasNext()) {
                    }
                    if (this.$partialWindows) {
                    }
                    return C1133Unit.INSTANCE;
                }
                ArrayList arrayList2 = new ArrayList(iCoerceAtMost);
                it2 = this.$iterator;
                i3 = iCoerceAtMost;
                i4 = 0;
                arrayList = arrayList2;
                while (it2.hasNext()) {
                }
                if (!arrayList.isEmpty()) {
                    this.f4973L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                    this.f4974L$1 = SpillingKt.nullOutSpilledVariable(arrayList);
                    this.f4975L$2 = null;
                    this.f4976L$3 = null;
                    this.f4970I$0 = i3;
                    this.f4971I$1 = i;
                    this.f4972I$2 = i4;
                    this.f4977label = 2;
                    if (sequenceScope.mo6559yield(arrayList, this) == coroutine_suspended) {
                    }
                }
                return C1133Unit.INSTANCE;
            }
            if (i6 == 1) {
                i = this.f4971I$1;
                i3 = this.f4970I$0;
                it2 = (Iterator) this.f4975L$2;
                arrayList = (ArrayList) this.f4974L$1;
                ResultKt.throwOnFailure(obj);
                i4 = i;
                if (this.$reuseBuffer) {
                    arrayList = new ArrayList(this.f4968$size);
                } else {
                    arrayList.clear();
                }
                i = i4;
                while (it2.hasNext()) {
                    T next = it2.next();
                    if (i4 > 0) {
                        i4--;
                    } else {
                        arrayList.add(next);
                        if (arrayList.size() == this.f4968$size) {
                            this.f4973L$0 = sequenceScope;
                            this.f4974L$1 = arrayList;
                            this.f4975L$2 = it2;
                            this.f4976L$3 = SpillingKt.nullOutSpilledVariable(next);
                            this.f4970I$0 = i3;
                            this.f4971I$1 = i;
                            this.f4972I$2 = i4;
                            this.f4977label = 1;
                            if (sequenceScope.mo6559yield(arrayList, this) == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                            i4 = i;
                            if (this.$reuseBuffer) {
                            }
                            i = i4;
                            while (it2.hasNext()) {
                            }
                        }
                    }
                }
                if (!arrayList.isEmpty() && (this.$partialWindows || arrayList.size() == this.f4968$size)) {
                    this.f4973L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                    this.f4974L$1 = SpillingKt.nullOutSpilledVariable(arrayList);
                    this.f4975L$2 = null;
                    this.f4976L$3 = null;
                    this.f4970I$0 = i3;
                    this.f4971I$1 = i;
                    this.f4972I$2 = i4;
                    this.f4977label = 2;
                    if (sequenceScope.mo6559yield(arrayList, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
                return C1133Unit.INSTANCE;
            }
            if (i6 == 2) {
            } else {
                if (i6 == 3) {
                    i = this.f4971I$1;
                    i2 = this.f4970I$0;
                    it = (Iterator) this.f4975L$2;
                    ringBufferExpanded = (RingBuffer) this.f4974L$1;
                    ResultKt.throwOnFailure(obj);
                    ringBufferExpanded.removeFirst(this.f4969$step);
                    while (it.hasNext()) {
                        T next2 = it.next();
                        ringBufferExpanded.add((RingBuffer) next2);
                        if (ringBufferExpanded.m5990isFull()) {
                            int size = ringBufferExpanded.size();
                            int i7 = this.f4968$size;
                            if (size >= i7) {
                                RandomAccess arrayList3 = this.$reuseBuffer ? ringBufferExpanded : new ArrayList(ringBufferExpanded);
                                this.f4973L$0 = sequenceScope;
                                this.f4974L$1 = ringBufferExpanded;
                                this.f4975L$2 = it;
                                this.f4976L$3 = SpillingKt.nullOutSpilledVariable(next2);
                                this.f4970I$0 = i2;
                                this.f4971I$1 = i;
                                this.f4977label = 3;
                                if (sequenceScope.mo6559yield(arrayList3, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                                ringBufferExpanded.removeFirst(this.f4969$step);
                                while (it.hasNext()) {
                                }
                            } else {
                                ringBufferExpanded = ringBufferExpanded.expanded(i7);
                            }
                        }
                    }
                    if (this.$partialWindows) {
                        i5 = i2;
                        ringBuffer = ringBufferExpanded;
                        if (ringBuffer.size() <= this.f4969$step) {
                        }
                    }
                    return C1133Unit.INSTANCE;
                }
                if (i6 == 4) {
                    i = this.f4971I$1;
                    i5 = this.f4970I$0;
                    ringBuffer = (RingBuffer) this.f4974L$1;
                    ResultKt.throwOnFailure(obj);
                    ringBuffer.removeFirst(this.f4969$step);
                    if (ringBuffer.size() <= this.f4969$step) {
                        RandomAccess arrayList4 = this.$reuseBuffer ? ringBuffer : new ArrayList(ringBuffer);
                        this.f4973L$0 = sequenceScope;
                        this.f4974L$1 = ringBuffer;
                        this.f4975L$2 = null;
                        this.f4976L$3 = null;
                        this.f4970I$0 = i5;
                        this.f4971I$1 = i;
                        this.f4977label = 4;
                        if (sequenceScope.mo6559yield(arrayList4, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        ringBuffer.removeFirst(this.f4969$step);
                        if (ringBuffer.size() <= this.f4969$step) {
                            if (!ringBuffer.isEmpty()) {
                                this.f4973L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                                this.f4974L$1 = SpillingKt.nullOutSpilledVariable(ringBuffer);
                                this.f4975L$2 = null;
                                this.f4976L$3 = null;
                                this.f4970I$0 = i5;
                                this.f4971I$1 = i;
                                this.f4977label = 5;
                                if (sequenceScope.mo6559yield(ringBuffer, this) == coroutine_suspended) {
                                    return coroutine_suspended;
                                }
                            }
                            return C1133Unit.INSTANCE;
                        }
                    }
                } else {
                    if (i6 != 5) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                }
            }
            ResultKt.throwOnFailure(obj);
            return C1133Unit.INSTANCE;
        }

        @Override // p094kotlin.p105jvm.functions.Function2
        /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
        public final Object mo2167invoke(SequenceScope<? super List<? extends T>> sequenceScope, Continuation<? super C1133Unit> continuation) {
            return ((C11601) mo2166create(sequenceScope, continuation)).invokeSuspend(C1133Unit.INSTANCE);
        }
    }

    public static final void checkWindowSizeStep(int i, int i2) {
        String str;
        if (i <= 0 || i2 <= 0) {
            if (i != i2) {
                str = "Both size " + i + " and step " + i2 + " must be greater than zero.";
            } else {
                str = "size " + i + " must be greater than zero.";
            }
            throw new IllegalArgumentException(str.toString());
        }
    }

    public static final <T> Iterator<List<T>> windowedIterator(Iterator<? extends T> iterator, int i, int i2, boolean z, boolean z2) {
        Intrinsics.checkNotNullParameter(iterator, "iterator");
        return !iterator.hasNext() ? EmptyIterator.INSTANCE : SequencesKt.iterator(new C11601(i, i2, iterator, z2, z, null));
    }

    public static final <T> Sequence<List<T>> windowedSequence(final Sequence<? extends T> sequence, final int i, final int i2, final boolean z, final boolean z2) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        checkWindowSizeStep(i, i2);
        return new Sequence<List<? extends T>>() { // from class: kotlin.collections.SlidingWindowKt$windowedSequence$$inlined$Sequence$1
            @Override // p094kotlin.sequences.Sequence
            public Iterator<List<? extends T>> iterator() {
                return SlidingWindowKt.windowedIterator(sequence.iterator(), i, i2, z, z2);
            }
        };
    }
}
