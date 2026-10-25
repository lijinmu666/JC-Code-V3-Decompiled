package p122kotlinx.coroutines.p125flow;

import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SubclassOptInRequired;
import p094kotlin.coroutines.Continuation;
import p122kotlinx.coroutines.ExperimentalForInheritanceCoroutinesApi;

@Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002J\u001c\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH¦@¢\u0006\u0002\u0010\u000bR\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\fÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/flow/SharedFlow;", "T", "Lkotlinx/coroutines/flow/Flow;", "replayCache", BuildConfig.f24315FLAVOR, "getReplayCache", "()Ljava/util/List;", "collect", BuildConfig.f24315FLAVOR, "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
@SubclassOptInRequired(markerClass = {ExperimentalForInheritanceCoroutinesApi.class})
/* loaded from: classes.dex */
public interface SharedFlow<T> extends InterfaceC1426Flow<T> {
    @Override // p122kotlinx.coroutines.p125flow.InterfaceC1426Flow
    /* renamed from: collect */
    Object mo4308collect(FlowCollector<? super T> flowCollector, Continuation<?> continuation);

    List<T> getReplayCache();
}
