package p122kotlinx.coroutines.p129sync;

import p094kotlin.Metadata;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.internal.FunctionReferenceImpl;

@Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final /* synthetic */ class SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 extends FunctionReferenceImpl implements Function2<Long, SemaphoreSegment, SemaphoreSegment> {
    public static final SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1 INSTANCE = new SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1();

    public SemaphoreAndMutexImpl$addAcquireToQueue$createNewSegment$1() {
        super(2, SemaphoreKt.class, "createSegment", "createSegment(JLkotlinx/coroutines/sync/SemaphoreSegment;)Lkotlinx/coroutines/sync/SemaphoreSegment;", 1);
    }

    @Override // p094kotlin.p105jvm.functions.Function2
    /* renamed from: invoke */
    public /* bridge */ /* synthetic */ SemaphoreSegment mo2167invoke(Long l, SemaphoreSegment semaphoreSegment) {
        return m7508invoke(l.longValue(), semaphoreSegment);
    }

    /* renamed from: invoke */
    public final SemaphoreSegment m7508invoke(long j, SemaphoreSegment semaphoreSegment) {
        return SemaphoreKt.createSegment(j, semaphoreSegment);
    }
}
