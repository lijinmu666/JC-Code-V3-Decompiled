package p122kotlinx.coroutines.channels;

import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.FunctionReferenceImpl;
import p122kotlinx.coroutines.p127selects.SelectInstance;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class BufferedChannel$onReceiveOrNull$1 extends FunctionReferenceImpl implements Function3<BufferedChannel<?>, SelectInstance<?>, Object, C1133Unit> {
    public static final BufferedChannel$onReceiveOrNull$1 INSTANCE = new BufferedChannel$onReceiveOrNull$1();

    public BufferedChannel$onReceiveOrNull$1() {
        super(3, BufferedChannel.class, "registerSelectForReceive", "registerSelectForReceive(Lkotlinx/coroutines/selects/SelectInstance;Ljava/lang/Object;)V", 0);
    }

    @Override // p094kotlin.p105jvm.functions.Function3
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ C1133Unit mo6219invoke(BufferedChannel<?> bufferedChannel, SelectInstance<?> selectInstance, Object obj) {
        invoke2(bufferedChannel, selectInstance, obj);
        return C1133Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(BufferedChannel<?> bufferedChannel, SelectInstance<?> selectInstance, Object obj) {
        bufferedChannel.registerSelectForReceive(selectInstance, obj);
    }
}
