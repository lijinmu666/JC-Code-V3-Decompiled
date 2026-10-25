package p094kotlin.p117text;

import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.AbstractCollection;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.internal.PlatformImplementationsKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p112ranges.IntRange;
import p094kotlin.sequences.SequencesKt;

@Metadata(m4987d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\n\u0010\b\u001a\u00020\tH\u0096\u0080\u0004J\u0012\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000bH\u0096\u0082\u0004J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0082\u0004J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0082\u0004R\u0015\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, m4988d2 = {"kotlin/text/MatcherMatchResult$groups$1", "Lkotlin/text/MatchNamedGroupCollection;", "Lkotlin/collections/AbstractCollection;", "Lkotlin/text/MatchGroup;", "size", BuildConfig.f24315FLAVOR, "getSize", "()I", "isEmpty", BuildConfig.f24315FLAVOR, "iterator", BuildConfig.f24315FLAVOR, "get", "index", "name", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {

    /* renamed from: this$0 */
    final /* synthetic */ MatcherMatchResult f5391this$0;

    public MatcherMatchResult$groups$1(MatcherMatchResult matcherMatchResult) {
        this.f5391this$0 = matcherMatchResult;
    }

    @Override // p094kotlin.collections.AbstractCollection, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj == null ? true : obj instanceof MatchGroup) {
            return contains((MatchGroup) obj);
        }
        return false;
    }

    @Override // p094kotlin.p117text.MatchGroupCollection
    /* renamed from: get */
    public MatchGroup mo6687get(int index) {
        IntRange intRangeM6705range = C1313RegexKt.m6705range(this.f5391this$0.getMatchResult(), index);
        if (intRangeM6705range.getStart().intValue() < 0) {
            return null;
        }
        String strGroup = this.f5391this$0.getMatchResult().group(index);
        Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
        return new MatchGroup(strGroup, intRangeM6705range);
    }

    @Override // p094kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f5391this$0.getMatchResult().groupCount() + 1;
    }

    @Override // p094kotlin.collections.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return false;
    }

    @Override // p094kotlin.collections.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator<MatchGroup> iterator() {
        return SequencesKt.m6610map(CollectionsKt.asSequence(CollectionsKt.getIndices(this)), new Function1() { // from class: o.E1
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return this.f7927mjFkc.mo6687get(((Integer) obj).intValue());
            }
        }).iterator();
    }

    public /* bridge */ boolean contains(MatchGroup matchGroup) {
        return super.contains((Object) matchGroup);
    }

    @Override // p094kotlin.p117text.MatchNamedGroupCollection
    /* renamed from: get */
    public MatchGroup mo6688get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getMatchResultNamedGroup(this.f5391this$0.getMatchResult(), name);
    }
}
