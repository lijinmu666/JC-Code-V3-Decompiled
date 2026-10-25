package p122kotlinx.coroutines.channels;

import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.FunctionReferenceImpl;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class BufferedChannel$onReceiveOrNull$2 extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, Object, Object, Object> {
    public static final BufferedChannel$onReceiveOrNull$2 INSTANCE = new BufferedChannel$onReceiveOrNull$2();

    public BufferedChannel$onReceiveOrNull$2() {
        super(3, BufferedChannel.class, "processResultSelectReceiveOrNull", "processResultSelectReceiveOrNull(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", 0);
    }

    @Override // p094kotlin.p105jvm.functions.Function3
    /* renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo6219invoke(BufferedChannel<?> bufferedChannel, Object obj, Object obj2) {
        return bufferedChannel.processResultSelectReceiveOrNull(obj, obj2);
    }
}
