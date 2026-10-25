package p122kotlinx.coroutines.internal;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Iterator;
import org.conscrypt.BuildConfig;
import p094kotlin.C1122Pair;
import p094kotlin.C1124Result;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.TuplesKt;
import p094kotlin.p105jvm.JvmClassMappingKt;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p122kotlinx.coroutines.CopyableThrowable;
import p122kotlinx.coroutines.internal.ExceptionsConstructorKt;

@Metadata(m4987d1 = {"\u0000(\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a!\u0010\u0007\u001a\u0004\u0018\u0001H\b\"\b\b\u0000\u0010\b*\u00020\u00042\u0006\u0010\t\u001a\u0002H\bH\u0000¢\u0006\u0002\u0010\n\u001a2\u0010\u000b\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\f\"\b\b\u0000\u0010\b*\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\b0\u000eH\u0002\u001a.\u0010\u000f\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003j\u0002`\f2\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003H\u0002\u001a\u0018\u0010\u0011\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0012\u001a\u00020\u0001H\u0002\u001a\u001b\u0010\u0013\u001a\u00020\u0001*\u0006\u0012\u0002\b\u00030\u000e2\b\b\u0002\u0010\u0014\u001a\u00020\u0001H\u0082\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000*(\b\u0002\u0010\u0002\"\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00032\u0010\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0003¨\u0006\u0015"}, m4988d2 = {"throwableFields", BuildConfig.f24315FLAVOR, "Ctor", "Lkotlin/Function1;", BuildConfig.f24315FLAVOR, "ctorCache", "Lkotlinx/coroutines/internal/CtorCache;", "tryCopyException", "E", "exception", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "createConstructor", "Lkotlinx/coroutines/internal/Ctor;", "clz", "Ljava/lang/Class;", "safeCtor", "block", "fieldsCountOrDefault", "defaultValue", "fieldsCount", "accumulator", "kotlinx-coroutines-core"}, m4989k = 2, m4990mv = {2, 2, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nExceptionsConstructor.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n+ 3 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n+ 4 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,134:1\n1#2:135\n11561#3:136\n11896#3,3:137\n13130#3,3:154\n1999#4,14:140\n*S KotlinDebug\n*F\n+ 1 ExceptionsConstructor.kt\nkotlinx/coroutines/internal/ExceptionsConstructorKt\n*L\n63#1:136\n63#1:137,3\n100#1:154,3\n81#1:140,14\n*E\n"})
/* loaded from: classes.dex */
public final class ExceptionsConstructorKt {
    private static final CtorCache ctorCache;
    private static final int throwableFields = fieldsCountOrDefault(Throwable.class, -1);

    static {
        CtorCache ctorCache2;
        try {
            ctorCache2 = FastServiceLoaderKt.getANDROID_DETECTED() ? WeakMapCtorCache.INSTANCE : ClassValueCtorCache.INSTANCE;
        } catch (Throwable unused) {
            ctorCache2 = WeakMapCtorCache.INSTANCE;
        }
        ctorCache = ctorCache2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <E extends Throwable> Function1<Throwable, Throwable> createConstructor(Class<E> cls) throws NoSuchMethodException, SecurityException {
        Function1<Throwable, Throwable> function1;
        C1122Pair c1122PairM5076to;
        ExceptionsConstructorKt$createConstructor$nullResult$1 exceptionsConstructorKt$createConstructor$nullResult$1 = new Function1() { // from class: kotlinx.coroutines.internal.ExceptionsConstructorKt$createConstructor$nullResult$1
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final Void mo2237invoke(Throwable th) {
                return null;
            }
        };
        Object next = null;
        try {
            final Method method = cls.getMethod("copyForStackTraceRecovery", null);
            return new Function1() { // from class: o.RW
                @Override // p094kotlin.p105jvm.functions.Function1
                /* renamed from: invoke */
                public final Object mo2237invoke(Object obj) {
                    return ExceptionsConstructorKt.createConstructor$lambda$0(method, (Throwable) obj);
                }
            };
        } catch (NoSuchMethodException | SecurityException unused) {
            if (throwableFields != fieldsCountOrDefault(cls, 0)) {
                return exceptionsConstructorKt$createConstructor$nullResult$1;
            }
            Constructor<?>[] constructors = cls.getConstructors();
            ArrayList arrayList = new ArrayList(constructors.length);
            for (final Constructor<?> constructor : constructors) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();
                int length = parameterTypes.length;
                if (length == 0) {
                    c1122PairM5076to = TuplesKt.m5076to(safeCtor(new Function1() { // from class: o.iBHnK
                        @Override // p094kotlin.p105jvm.functions.Function1
                        /* renamed from: invoke */
                        public final Object mo2237invoke(Object obj) {
                            return ExceptionsConstructorKt.createConstructor$lambda$1$3(constructor, (Throwable) obj);
                        }
                    }), 0);
                } else if (length != 1) {
                    c1122PairM5076to = length != 2 ? TuplesKt.m5076to(null, -1) : (Intrinsics.areEqual(parameterTypes[0], String.class) && Intrinsics.areEqual(parameterTypes[1], Throwable.class)) ? TuplesKt.m5076to(safeCtor(new Function1() { // from class: o.JQSH
                        @Override // p094kotlin.p105jvm.functions.Function1
                        /* renamed from: invoke */
                        public final Object mo2237invoke(Object obj) {
                            return ExceptionsConstructorKt.createConstructor$lambda$1$0(constructor, (Throwable) obj);
                        }
                    }), 3) : TuplesKt.m5076to(null, -1);
                } else {
                    Class<?> cls2 = parameterTypes[0];
                    c1122PairM5076to = Intrinsics.areEqual(cls2, String.class) ? TuplesKt.m5076to(safeCtor(new Function1() { // from class: o.pGB
                        @Override // p094kotlin.p105jvm.functions.Function1
                        /* renamed from: invoke */
                        public final Object mo2237invoke(Object obj) {
                            return ExceptionsConstructorKt.createConstructor$lambda$1$1(constructor, (Throwable) obj);
                        }
                    }), 2) : Intrinsics.areEqual(cls2, Throwable.class) ? TuplesKt.m5076to(safeCtor(new Function1() { // from class: o.HRWx
                        @Override // p094kotlin.p105jvm.functions.Function1
                        /* renamed from: invoke */
                        public final Object mo2237invoke(Object obj) {
                            return ExceptionsConstructorKt.createConstructor$lambda$1$2(constructor, (Throwable) obj);
                        }
                    }), 1) : TuplesKt.m5076to(null, -1);
                }
                arrayList.add(c1122PairM5076to);
            }
            Iterator it = arrayList.iterator();
            if (it.hasNext()) {
                next = it.next();
                if (it.hasNext()) {
                    int iIntValue = ((Number) ((C1122Pair) next).getSecond()).intValue();
                    do {
                        Object next2 = it.next();
                        int iIntValue2 = ((Number) ((C1122Pair) next2).getSecond()).intValue();
                        if (iIntValue < iIntValue2) {
                            next = next2;
                            iIntValue = iIntValue2;
                        }
                    } while (it.hasNext());
                }
            }
            C1122Pair c1122Pair = (C1122Pair) next;
            return (c1122Pair == null || (function1 = (Function1) c1122Pair.getFirst()) == null) ? exceptionsConstructorKt$createConstructor$nullResult$1 : function1;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable createConstructor$lambda$0(Method method, Throwable th) {
        Object objM18546constructorimpl;
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl((Throwable) method.invoke(th, null));
        } catch (Throwable th2) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th2));
        }
        return (Throwable) (C1124Result.m18552isFailureimpl(objM18546constructorimpl) ? null : objM18546constructorimpl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable createConstructor$lambda$1$0(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(th.getMessage(), th);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable) objNewInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable createConstructor$lambda$1$1(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(th.getMessage());
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        Throwable th2 = (Throwable) objNewInstance;
        th2.initCause(th);
        return th2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable createConstructor$lambda$1$2(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(th);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        return (Throwable) objNewInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable createConstructor$lambda$1$3(Constructor constructor, Throwable th) throws IllegalAccessException, InstantiationException, IllegalArgumentException, InvocationTargetException {
        Object objNewInstance = constructor.newInstance(null);
        Intrinsics.checkNotNull(objNewInstance, "null cannot be cast to non-null type kotlin.Throwable");
        Throwable th2 = (Throwable) objNewInstance;
        th2.initCause(th);
        return th2;
    }

    private static final int fieldsCount(Class<?> cls, int i) {
        do {
            int i2 = 0;
            for (Field field : cls.getDeclaredFields()) {
                if (!Modifier.isStatic(field.getModifiers())) {
                    i2++;
                }
            }
            i += i2;
            cls = cls.getSuperclass();
        } while (cls != null);
        return i;
    }

    public static /* synthetic */ int fieldsCount$default(Class cls, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = 0;
        }
        return fieldsCount(cls, i);
    }

    private static final int fieldsCountOrDefault(Class<?> cls, int i) {
        Object objM18546constructorimpl;
        JvmClassMappingKt.getKotlinClass(cls);
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(Integer.valueOf(fieldsCount$default(cls, 0, 1, null)));
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
        }
        Integer numValueOf = Integer.valueOf(i);
        if (C1124Result.m18552isFailureimpl(objM18546constructorimpl)) {
            objM18546constructorimpl = numValueOf;
        }
        return ((Number) objM18546constructorimpl).intValue();
    }

    private static final Function1<Throwable, Throwable> safeCtor(final Function1<? super Throwable, ? extends Throwable> function1) {
        return new Function1() { // from class: o.lEH
            @Override // p094kotlin.p105jvm.functions.Function1
            /* renamed from: invoke */
            public final Object mo2237invoke(Object obj) {
                return ExceptionsConstructorKt.safeCtor$lambda$0(function1, (Throwable) obj);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Throwable safeCtor$lambda$0(Function1 function1, Throwable th) {
        Object objM18546constructorimpl;
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            Throwable th2 = (Throwable) function1.mo2237invoke(th);
            if (!Intrinsics.areEqual(th.getMessage(), th2.getMessage()) && !Intrinsics.areEqual(th2.getMessage(), th.toString())) {
                th2 = null;
            }
            objM18546constructorimpl = C1124Result.m18546constructorimpl(th2);
        } catch (Throwable th3) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th3));
        }
        return (Throwable) (C1124Result.m18552isFailureimpl(objM18546constructorimpl) ? null : objM18546constructorimpl);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final <E extends Throwable> E tryCopyException(E e) {
        Object objM18546constructorimpl;
        if (!(e instanceof CopyableThrowable)) {
            return (E) ctorCache.mo7405get(e.getClass()).mo2237invoke(e);
        }
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(((CopyableThrowable) e).createCopy());
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
        }
        if (C1124Result.m18552isFailureimpl(objM18546constructorimpl)) {
            objM18546constructorimpl = null;
        }
        return (E) objM18546constructorimpl;
    }
}
