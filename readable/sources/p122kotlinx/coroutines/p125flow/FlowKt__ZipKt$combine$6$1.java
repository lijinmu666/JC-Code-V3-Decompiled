package p122kotlinx.coroutines.p125flow;

import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

/* JADX INFO: Add missing generic type declarations: [T] */
@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 176)
@SourceDebugExtension(m6344value = {"SMAP\nZip.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Zip.kt\nkotlinx/coroutines/flow/FlowKt__ZipKt$combine$6$1\n*L\n1#1,328:1\n*E\n"})
/* loaded from: classes.dex */
public final class FlowKt__ZipKt$combine$6$1<T> implements Function0<T[]> {
    final /* synthetic */ InterfaceC1426Flow<T>[] $flowArray;

    public FlowKt__ZipKt$combine$6$1(InterfaceC1426Flow<T>[] interfaceC1426FlowArr) {
        this.$flowArray = interfaceC1426FlowArr;
    }

    @Override // p094kotlin.p105jvm.functions.Function0
    /* renamed from: invoke */
    public final T[] mo4323invoke() {
        int length = this.$flowArray.length;
        Intrinsics.reifiedOperationMarker(0, "T?");
        return (T[]) new Object[length];
    }
}
