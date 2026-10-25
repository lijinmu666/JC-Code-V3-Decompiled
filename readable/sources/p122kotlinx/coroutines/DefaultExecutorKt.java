package p122kotlinx.coroutines;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p122kotlinx.coroutines.internal.MainDispatchersKt;
import p122kotlinx.coroutines.internal.SystemPropsKt;

@Metadata(m4987d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\b\u0010\b\u001a\u00020\u0003H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0002\u001a\u00020\u00038\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, m4988d2 = {"defaultMainDelayOptIn", BuildConfig.f24315FLAVOR, "DefaultDelay", "Lkotlinx/coroutines/Delay;", "getDefaultDelay$annotations", "()V", "getDefaultDelay", "()Lkotlinx/coroutines/Delay;", "initializeDefaultDelay", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class DefaultExecutorKt {
    private static final boolean defaultMainDelayOptIn = SystemPropsKt.systemProp("kotlinx.coroutines.main.delay", false);
    private static final InterfaceC1337Delay DefaultDelay = initializeDefaultDelay();

    public static final InterfaceC1337Delay getDefaultDelay() {
        return DefaultDelay;
    }

    @PublishedApi
    public static /* synthetic */ void getDefaultDelay$annotations() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final InterfaceC1337Delay initializeDefaultDelay() {
        if (!defaultMainDelayOptIn) {
            return DefaultExecutor.INSTANCE;
        }
        MainCoroutineDispatcher mainCoroutineDispatcherM6976getMain = Dispatchers.m6976getMain();
        return (MainDispatchersKt.isMissing(mainCoroutineDispatcherM6976getMain) || !(mainCoroutineDispatcherM6976getMain instanceof InterfaceC1337Delay)) ? DefaultExecutor.INSTANCE : (InterfaceC1337Delay) mainCoroutineDispatcherM6976getMain;
    }
}
