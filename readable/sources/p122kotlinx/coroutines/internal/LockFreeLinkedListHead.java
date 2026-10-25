package p122kotlinx.coroutines.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J!\u0010\u0004\u001a\u00020\u00052\u0016\u0010\u0006\u001a\u0012\u0012\b\u0012\u00060\u0001j\u0002`\b\u0012\u0004\u0012\u00020\u00050\u0007H\u0086\bJ\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u000b\u001a\u00020\f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\r¨\u0006\u000e"}, m4988d2 = {"Lkotlinx/coroutines/internal/LockFreeLinkedListHead;", "Lkotlinx/coroutines/internal/LockFreeLinkedListNode;", "<init>", "()V", "forEach", BuildConfig.f24315FLAVOR, "block", "Lkotlin/Function1;", "Lkotlinx/coroutines/internal/Node;", "remove", BuildConfig.f24315FLAVOR, "isRemoved", BuildConfig.f24315FLAVOR, "()Z", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public class LockFreeLinkedListHead extends LockFreeLinkedListNode {
    /* renamed from: forEach */
    public final void m7423forEach(Function1<? super LockFreeLinkedListNode, C1133Unit> block) {
        Object objM7430getNext = m7430getNext();
        Intrinsics.checkNotNull(objM7430getNext, "null cannot be cast to non-null type kotlinx.coroutines.internal.LockFreeLinkedListNode");
        for (LockFreeLinkedListNode nextNode = (LockFreeLinkedListNode) objM7430getNext; !Intrinsics.areEqual(nextNode, this); nextNode = nextNode.getNextNode()) {
            block.mo2237invoke(nextNode);
        }
    }

    @Override // p122kotlinx.coroutines.internal.LockFreeLinkedListNode
    public boolean isRemoved() {
        return false;
    }

    @Override // p122kotlinx.coroutines.internal.LockFreeLinkedListNode
    /* renamed from: remove */
    public /* bridge */ /* synthetic */ boolean mo7425remove() {
        return ((Boolean) m7424remove()).booleanValue();
    }

    /* renamed from: remove */
    public final Void m7424remove() {
        throw new IllegalStateException("head cannot be removed");
    }
}
