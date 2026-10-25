package p094kotlin.sequences;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;

@Metadata(m4987d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b`\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0080\u0004J\u0018\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u00022\u0006\u0010\u0004\u001a\u00020\u0005H¦\u0080\u0004¨\u0006\u0007"}, m4988d2 = {"Lkotlin/sequences/DropTakeSequence;", "T", "Lkotlin/sequences/Sequence;", "drop", "n", BuildConfig.f24315FLAVOR, "take", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface DropTakeSequence<T> extends Sequence<T> {
    /* renamed from: drop */
    Sequence<T> mo6553drop(int n);

    /* renamed from: take */
    Sequence<T> mo6554take(int n);
}
