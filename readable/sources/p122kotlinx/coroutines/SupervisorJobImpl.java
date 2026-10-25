package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;

@Metadata(m4987d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, m4988d2 = {"Lkotlinx/coroutines/SupervisorJobImpl;", "Lkotlinx/coroutines/JobImpl;", "parent", "Lkotlinx/coroutines/Job;", "<init>", "(Lkotlinx/coroutines/Job;)V", "childCancelled", BuildConfig.f24315FLAVOR, "cause", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class SupervisorJobImpl extends C1343JobImpl {
    public SupervisorJobImpl(InterfaceC1342Job interfaceC1342Job) {
        super(interfaceC1342Job);
    }

    @Override // p122kotlinx.coroutines.JobSupport
    public boolean childCancelled(Throwable cause) {
        return false;
    }
}
