package p094kotlin.sequences;

import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p094kotlin.BuilderInference;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.coroutines.Continuation;
import p094kotlin.coroutines.intrinsics.IntrinsicsKt;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a^\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u000223\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t:\u0002\b\nH\u0087\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010\u000b\u001a^\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u000223\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t:\u0002\b\nH\u0087\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010\u0011\"\u0013\u0010\u0014\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0016\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0017\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0018\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0019\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u001a\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000*\f\b\u0002\u0010\u0012\"\u00020\u00132\u00020\u0013¨\u0006\u001b"}, m4988d2 = {"sequence", "Lkotlin/sequences/Sequence;", "T", "block", "Lkotlin/Function2;", "Lkotlin/sequences/SequenceScope;", "Lkotlin/coroutines/Continuation;", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/ExtensionFunctionType;", "Lkotlin/BuilderInference;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "Lkotlin/SinceKotlin;", "version", "1.3", "iterator", BuildConfig.f24315FLAVOR, "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "State", BuildConfig.f24315FLAVOR, "State_NotReady", "Lkotlin/sequences/State;", "State_ManyNotReady", "State_ManyReady", "State_Ready", "State_Done", "State_Failed", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/sequences/SequencesKt")
/* loaded from: classes.dex */
public class SequencesKt__SequenceBuilderKt {
    private static final int State_Done = 4;
    private static final int State_Failed = 5;
    private static final int State_ManyNotReady = 1;
    private static final int State_ManyReady = 2;
    private static final int State_NotReady = 0;
    private static final int State_Ready = 3;

    @SinceKotlin(m5061version = "1.3")
    public static <T> Iterator<T> iterator(@BuilderInference Function2<? super SequenceScope<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        SequenceBuilderIterator sequenceBuilderIterator = new SequenceBuilderIterator();
        sequenceBuilderIterator.setNextStep(IntrinsicsKt.createCoroutineUnintercepted(block, sequenceBuilderIterator, sequenceBuilderIterator));
        return sequenceBuilderIterator;
    }

    @SinceKotlin(m5061version = "1.3")
    public static <T> Sequence<T> sequence(@BuilderInference final Function2<? super SequenceScope<? super T>, ? super Continuation<? super C1133Unit>, ? extends Object> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        return new Sequence<T>() { // from class: kotlin.sequences.SequencesKt__SequenceBuilderKt$sequence$$inlined$Sequence$1
            @Override // p094kotlin.sequences.Sequence
            public Iterator<T> iterator() {
                return SequencesKt.iterator(block);
            }
        };
    }
}
