package p094kotlin.sequences;

import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.EmptyIterator;

@Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bÂ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003B\t\bB¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0007H\u0096\u0082\u0004J\u0012\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0096\u0080\u0004J\u0012\u0010\u000b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\nH\u0096\u0080\u0004¨\u0006\f"}, m4988d2 = {"Lkotlin/sequences/EmptySequence;", "Lkotlin/sequences/Sequence;", BuildConfig.f24315FLAVOR, "Lkotlin/sequences/DropTakeSequence;", "<init>", "()V", "iterator", BuildConfig.f24315FLAVOR, "drop", "n", BuildConfig.f24315FLAVOR, "take", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class EmptySequence implements Sequence, DropTakeSequence {
    public static final EmptySequence INSTANCE = new EmptySequence();

    private EmptySequence() {
    }

    @Override // p094kotlin.sequences.Sequence
    public Iterator iterator() {
        return EmptyIterator.INSTANCE;
    }

    @Override // p094kotlin.sequences.DropTakeSequence
    /* renamed from: drop */
    public EmptySequence mo6553drop(int n) {
        return INSTANCE;
    }

    @Override // p094kotlin.sequences.DropTakeSequence
    /* renamed from: take */
    public EmptySequence mo6554take(int n) {
        return INSTANCE;
    }
}
