package p094kotlin.sequences;

import java.util.Iterator;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.FunctionReferenceImpl;
import p094kotlin.p105jvm.internal.Intrinsics;

/* JADX INFO: Add missing generic type declarations: [R] */
@Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class SequencesKt___SequencesKt$flatMapIndexed$1<R> extends FunctionReferenceImpl implements Function1<Iterable<? extends R>, Iterator<? extends R>> {
    public static final SequencesKt___SequencesKt$flatMapIndexed$1 INSTANCE = new SequencesKt___SequencesKt$flatMapIndexed$1();

    public SequencesKt___SequencesKt$flatMapIndexed$1() {
        super(1, Iterable.class, "iterator", "iterator()Ljava/util/Iterator;", 0);
    }

    @Override // p094kotlin.p105jvm.functions.Function1
    /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
    public final Iterator<R> mo2237invoke(Iterable<? extends R> p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.iterator();
    }
}
