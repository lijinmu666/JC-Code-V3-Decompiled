package p094kotlin.coroutines.p097jvm.internal;

import java.lang.reflect.Method;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.coroutines.Continuation;
import p094kotlin.p105jvm.JvmField;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001:\u0001\fB\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u0007\u001a\u0004\u0018\u00010\b2\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0086\u0080\u0004J\u001a\u0010\u000b\u001a\u00020\u00052\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\nH\u0082\u0080\u0004R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\r"}, m4988d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever;", BuildConfig.f24315FLAVOR, "<init>", "()V", "notOnJava9", "Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", "cache", "getModuleName", BuildConfig.f24315FLAVOR, "continuation", "Lkotlin/coroutines/Continuation;", "buildCache", "Cache", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/ModuleNameRetriever\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,161:1\n1#2:162\n*E\n"})
/* loaded from: classes.dex */
public final class ModuleNameRetriever {
    private static C1208Cache cache;
    public static final ModuleNameRetriever INSTANCE = new ModuleNameRetriever();
    private static final C1208Cache notOnJava9 = new C1208Cache(null, null, null);

    @Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B'\bF\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\b¢\u0006\u0002\n\u0000R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\b¢\u0006\u0002\n\u0000R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0084\b\u0092\u0002\u0002\b\b¢\u0006\u0002\n\u0000¨\u0006\t"}, m4988d2 = {"Lkotlin/coroutines/jvm/internal/ModuleNameRetriever$Cache;", BuildConfig.f24315FLAVOR, "getModuleMethod", "Ljava/lang/reflect/Method;", "getDescriptorMethod", "nameMethod", "<init>", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "Lkotlin/jvm/JvmField;", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.coroutines.jvm.internal.ModuleNameRetriever$Cache */
    public static final class C1208Cache {

        @JvmField
        public final Method getDescriptorMethod;

        @JvmField
        public final Method getModuleMethod;

        @JvmField
        public final Method nameMethod;

        public C1208Cache(Method method, Method method2, Method method3) {
            this.getModuleMethod = method;
            this.getDescriptorMethod = method2;
            this.nameMethod = method3;
        }
    }

    private ModuleNameRetriever() {
    }

    private final C1208Cache buildCache(Continuation<Object> continuation) {
        try {
            C1208Cache c1208Cache = new C1208Cache(Class.class.getDeclaredMethod("getModule", null), continuation.getClass().getClassLoader().loadClass("java.lang.Module").getDeclaredMethod("getDescriptor", null), continuation.getClass().getClassLoader().loadClass("java.lang.module.ModuleDescriptor").getDeclaredMethod("name", null));
            cache = c1208Cache;
            return c1208Cache;
        } catch (Exception unused) {
            C1208Cache c1208Cache2 = notOnJava9;
            cache = c1208Cache2;
            return c1208Cache2;
        }
    }

    public final String getModuleName(Continuation<Object> continuation) {
        Method method;
        Object objInvoke;
        Method method2;
        Object objInvoke2;
        Intrinsics.checkNotNullParameter(continuation, "continuation");
        C1208Cache c1208CacheBuildCache = cache;
        if (c1208CacheBuildCache == null) {
            c1208CacheBuildCache = buildCache(continuation);
        }
        if (c1208CacheBuildCache == notOnJava9 || (method = c1208CacheBuildCache.getModuleMethod) == null || (objInvoke = method.invoke(continuation.getClass(), null)) == null || (method2 = c1208CacheBuildCache.getDescriptorMethod) == null || (objInvoke2 = method2.invoke(objInvoke, null)) == null) {
            return null;
        }
        Method method3 = c1208CacheBuildCache.nameMethod;
        Object objInvoke3 = method3 != null ? method3.invoke(objInvoke2, null) : null;
        if (objInvoke3 instanceof String) {
            return (String) objInvoke3;
        }
        return null;
    }
}
