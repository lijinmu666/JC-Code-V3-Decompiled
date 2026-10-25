package p094kotlin.coroutines.p097jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import org.bouncycastle.p249jcajce.p280util.AnnotatedPrivateKey;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.PublishedApi;
import p094kotlin.SinceKotlin;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;

@Metadata(m4987d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a5\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003b\u0002\b\t¢\u0006\u0002\b\u0003\u001a\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0002H\u0082\u0080\u0004\u001a\u000e\u0010\f\u001a\u00020\r*\u00020\u0002H\u0082\u0080\u0004\u001a;\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f*\u00020\u0002H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000eb\u0002\b\t¢\u0006\u0002\u0010\u0011\u001a \u0010\u0014\u001a\u00020\r*\u00020\u0002H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015b\u0002\b\t\"\u000f\u0010\u0012\u001a\u00020\rX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0013\u001a\u00020\rX\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0016"}, m4988d2 = {"getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getStackTraceElement", "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/jvm/JvmName;", "name", "Lkotlin/PublishedApi;", "getDebugMetadataAnnotation", "Lkotlin/coroutines/jvm/internal/DebugMetadata;", "getLabel", BuildConfig.f24315FLAVOR, "getSpilledVariableFieldMapping", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "COROUTINES_DEBUG_METADATA_VERSION_1_3", "COROUTINES_DEBUG_METADATA_VERSION_2_2", "getNextLineNumber", "2.2", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nDebugMetadata.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n+ 2 ArraysJVM.kt\nkotlin/collections/ArraysKt__ArraysJVMKt\n*L\n1#1,161:1\n37#2,2:162\n*S KotlinDebug\n*F\n+ 1 DebugMetadata.kt\nkotlin/coroutines/jvm/internal/DebugMetadataKt\n*L\n134#1:162,2\n*E\n"})
/* loaded from: classes.dex */
public final class DebugMetadataKt {
    private static final int COROUTINES_DEBUG_METADATA_VERSION_1_3 = 1;
    private static final int COROUTINES_DEBUG_METADATA_VERSION_2_2 = 2;

    private static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl baseContinuationImpl) {
        return (DebugMetadata) baseContinuationImpl.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int getLabel(BaseContinuationImpl baseContinuationImpl) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        if (baseContinuationImpl instanceof TailCallBaseContinuationImpl) {
            return 0;
        }
        try {
            Field declaredField = baseContinuationImpl.getClass().getDeclaredField(AnnotatedPrivateKey.f21953LABEL);
            declaredField.setAccessible(true);
            Object obj = declaredField.get(baseContinuationImpl);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @SinceKotlin(m5061version = "2.2")
    @PublishedApi
    public static final int getNextLineNumber(BaseContinuationImpl baseContinuationImpl) {
        int label;
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation != null && debugMetadataAnnotation.m6131v() >= 2 && (label = getLabel(baseContinuationImpl)) >= 0 && label < debugMetadataAnnotation.m6129nl().length) {
            return debugMetadataAnnotation.m6129nl()[label];
        }
        return -1;
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    @InterfaceC1231JvmName(m6260name = "getSpilledVariableFieldMapping")
    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl baseContinuationImpl) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation == null || debugMetadataAnnotation.m6131v() < 1) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int label = getLabel(baseContinuationImpl);
        int[] iArrM6125i = debugMetadataAnnotation.m6125i();
        int length = iArrM6125i.length;
        for (int i = 0; i < length; i++) {
            if (iArrM6125i[i] == label) {
                arrayList.add(debugMetadataAnnotation.m6130s()[i]);
                arrayList.add(debugMetadataAnnotation.m6128n()[i]);
            }
        }
        return (String[]) arrayList.toArray(new String[0]);
    }

    @SinceKotlin(m5061version = "1.3")
    @PublishedApi
    @InterfaceC1231JvmName(m6260name = "getStackTraceElement")
    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl baseContinuationImpl) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        String strM6123c;
        Intrinsics.checkNotNullParameter(baseContinuationImpl, "<this>");
        DebugMetadata debugMetadataAnnotation = getDebugMetadataAnnotation(baseContinuationImpl);
        if (debugMetadataAnnotation == null || debugMetadataAnnotation.m6131v() < 1) {
            return null;
        }
        int label = getLabel(baseContinuationImpl);
        int i = label < 0 ? -1 : debugMetadataAnnotation.m6126l()[label];
        String moduleName = ModuleNameRetriever.INSTANCE.getModuleName(baseContinuationImpl);
        if (moduleName == null) {
            strM6123c = debugMetadataAnnotation.m6123c();
        } else {
            strM6123c = moduleName + '/' + debugMetadataAnnotation.m6123c();
        }
        return new StackTraceElement(strM6123c, debugMetadataAnnotation.m6127m(), debugMetadataAnnotation.m6124f(), i);
    }
}
