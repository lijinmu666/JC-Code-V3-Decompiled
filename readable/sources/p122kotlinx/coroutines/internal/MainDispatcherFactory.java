package p122kotlinx.coroutines.internal;

import java.util.List;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p122kotlinx.coroutines.InternalCoroutinesApi;
import p122kotlinx.coroutines.MainCoroutineDispatcher;

@InternalCoroutinesApi
@Metadata(m4987d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000e\n\u0000\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00000\tH&J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\fÀ\u0006\u0003"}, m4988d2 = {"Lkotlinx/coroutines/internal/MainDispatcherFactory;", BuildConfig.f24315FLAVOR, "loadPriority", BuildConfig.f24315FLAVOR, "getLoadPriority", "()I", "createDispatcher", "Lkotlinx/coroutines/MainCoroutineDispatcher;", "allFactories", BuildConfig.f24315FLAVOR, "hintOnError", BuildConfig.f24315FLAVOR, "kotlinx-coroutines-core"}, m4989k = 1, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface MainDispatcherFactory {

    @Metadata(m4989k = 3, m4990mv = {2, 2, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static String hintOnError(MainDispatcherFactory mainDispatcherFactory) {
            return MainDispatcherFactory.super.hintOnError();
        }
    }

    MainCoroutineDispatcher createDispatcher(List<? extends MainDispatcherFactory> allFactories);

    int getLoadPriority();

    default String hintOnError() {
        return null;
    }
}
