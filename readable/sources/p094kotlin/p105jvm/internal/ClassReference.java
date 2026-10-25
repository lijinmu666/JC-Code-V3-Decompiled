package p094kotlin.p105jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.conscrypt.BuildConfig;
import p094kotlin.Function;
import p094kotlin.KotlinNothingValueException;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.TuplesKt;
import p094kotlin.collections.C1155MapsKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p105jvm.JvmClassMappingKt;
import p094kotlin.p105jvm.KotlinReflectionNotSupportedError;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.functions.Function1;
import p094kotlin.p105jvm.functions.Function10;
import p094kotlin.p105jvm.functions.Function11;
import p094kotlin.p105jvm.functions.Function12;
import p094kotlin.p105jvm.functions.Function13;
import p094kotlin.p105jvm.functions.Function14;
import p094kotlin.p105jvm.functions.Function15;
import p094kotlin.p105jvm.functions.Function16;
import p094kotlin.p105jvm.functions.Function17;
import p094kotlin.p105jvm.functions.Function18;
import p094kotlin.p105jvm.functions.Function19;
import p094kotlin.p105jvm.functions.Function2;
import p094kotlin.p105jvm.functions.Function20;
import p094kotlin.p105jvm.functions.Function21;
import p094kotlin.p105jvm.functions.Function22;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.functions.Function4;
import p094kotlin.p105jvm.functions.Function5;
import p094kotlin.p105jvm.functions.Function6;
import p094kotlin.p105jvm.functions.Function7;
import p094kotlin.p105jvm.functions.Function8;
import p094kotlin.p105jvm.functions.Function9;
import p094kotlin.p113reflect.InterfaceC1242KClass;
import p094kotlin.p113reflect.InterfaceC1252KType;
import p094kotlin.p113reflect.KCallable;
import p094kotlin.p113reflect.KFunction;
import p094kotlin.p113reflect.KTypeParameter;
import p094kotlin.p113reflect.KVisibility;
import p094kotlin.p117text.StringsKt;
import p094kotlin.p117text.Typography;

@Metadata(m4987d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001YB\u0015\bF\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0097\u0080\u0004b\f\b&\u0012\b\b'\u0012\u0004\b\b((J\n\u0010P\u001a\u00020QH\u0082\u0080\u0004J\n\u0010R\u001a\u00020SH\u0096\u0080\u0004J\u0014\u0010T\u001a\u00020$2\b\u0010U\u001a\u0004\u0018\u00010\u0002H\u0096\u0082\u0004J\n\u0010V\u001a\u00020WH\u0096\u0080\u0004J\n\u0010X\u001a\u00020\fH\u0096\u0080\u0004R\u0019\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001f\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00128VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u00128VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u001f\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00128VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u0004\u0018\u00010\u00028VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b!\u0010\"R/\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001c8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010\u001fR/\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u001c8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\b0\u0010,\u001a\u0004\b1\u0010\u001fR7\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u001c8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b(5¢\u0006\f\u0012\u0004\b3\u0010,\u001a\u0004\b4\u0010\u001fR+\u00106\u001a\u0004\u0018\u0001078VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\b8\u0010,\u001a\u0004\b9\u0010:R)\u0010;\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\b<\u0010,\u001a\u0004\b;\u0010=R)\u0010>\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\b?\u0010,\u001a\u0004\b>\u0010=R)\u0010@\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\bA\u0010,\u001a\u0004\b@\u0010=R)\u0010B\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\bC\u0010,\u001a\u0004\bB\u0010=R)\u0010D\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\bE\u0010,\u001a\u0004\bD\u0010=R)\u0010F\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\bG\u0010,\u001a\u0004\bF\u0010=R)\u0010H\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\bI\u0010,\u001a\u0004\bH\u0010=R)\u0010J\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b(L¢\u0006\f\u0012\u0004\bK\u0010,\u001a\u0004\bJ\u0010=R)\u0010M\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b(O¢\u0006\f\u0012\u0004\bN\u0010,\u001a\u0004\bM\u0010=¨\u0006Z"}, m4988d2 = {"Lkotlin/jvm/internal/ClassReference;", "Lkotlin/reflect/KClass;", BuildConfig.f24315FLAVOR, "Lkotlin/jvm/internal/ClassBasedDeclarationContainer;", "Lkotlin/jvm/internal/KotlinGenericDeclaration;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "simpleName", BuildConfig.f24315FLAVOR, "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "members", BuildConfig.f24315FLAVOR, "Lkotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructors", "Lkotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "annotations", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "getAnnotations", "()Ljava/util/List;", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", BuildConfig.f24315FLAVOR, "value", "Lkotlin/SinceKotlin;", "version", "1.1", "typeParameters", "Lkotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "()V", "getTypeParameters", "supertypes", "Lkotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "1.3", "visibility", "Lkotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "1.4", "isValue", "isValue$annotations", "1.5", "error", BuildConfig.f24315FLAVOR, "findJavaDeclaration", "Ljava/lang/reflect/GenericDeclaration;", "equals", "other", "hashCode", BuildConfig.f24315FLAVOR, "toString", "Companion", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n+ 2 _Collections.kt\nkotlin/collections/CollectionsKt___CollectionsKt\n*L\n1#1,293:1\n1749#2:294\n1782#2,4:295\n*S KotlinDebug\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference\n*L\n110#1:294\n110#1:295,4\n*E\n"})
/* loaded from: classes.dex */
public final class ClassReference implements InterfaceC1242KClass<Object>, ClassBasedDeclarationContainer, KotlinGenericDeclaration {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    private final Class<?> jClass;

    @Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0082\u0080\u0004J\u0014\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0082\u0080\u0004J\u0018\u0010\r\u001a\u0004\u0018\u00010\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0080\u0004J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0080\u0004J \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0080\u0004R'\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m4988d2 = {"Lkotlin/jvm/internal/ClassReference$Companion;", BuildConfig.f24315FLAVOR, "<init>", "()V", "FUNCTION_CLASSES", BuildConfig.f24315FLAVOR, "Ljava/lang/Class;", "Lkotlin/Function;", BuildConfig.f24315FLAVOR, "classFqNameOf", BuildConfig.f24315FLAVOR, "type", "simpleNameOf", "getClassSimpleName", "jClass", "getClassQualifiedName", "isInstance", BuildConfig.f24315FLAVOR, "value", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    @SourceDebugExtension(m6344value = {"SMAP\nClassReference.kt\nKotlin\n*S Kotlin\n*F\n+ 1 ClassReference.kt\nkotlin/jvm/internal/ClassReference$Companion\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,293:1\n1#2:294\n*E\n"})
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:129:0x01cc, code lost:
        
            if (r9.equals("java.lang.Double") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:149:0x0211, code lost:
        
            if (r9.equals("java.lang.Long") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:157:0x022c, code lost:
        
            if (r9.equals("java.lang.Byte") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:161:0x0239, code lost:
        
            if (r9.equals("java.lang.Boolean") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x0254, code lost:
        
            if (r9.equals("java.lang.Character") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x0261, code lost:
        
            if (r9.equals("short") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x026e, code lost:
        
            if (r9.equals("float") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:189:0x0297, code lost:
        
            if (r9.equals("boolean") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:192:0x02a1, code lost:
        
            if (r9.equals("long") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:195:0x02ab, code lost:
        
            if (r9.equals("char") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:198:0x02b5, code lost:
        
            if (r9.equals("byte") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:216:0x02f3, code lost:
        
            if (r9.equals("java.lang.Short") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:219:0x02fd, code lost:
        
            if (r9.equals("java.lang.Float") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:234:0x032f, code lost:
        
            if (r9.equals("double") == false) goto L261;
         */
        /* JADX WARN: Code restructure failed: missing block: B:294:?, code lost:
        
            return "kotlin.Double";
         */
        /* JADX WARN: Code restructure failed: missing block: B:299:?, code lost:
        
            return "kotlin.Long";
         */
        /* JADX WARN: Code restructure failed: missing block: B:301:?, code lost:
        
            return "kotlin.Byte";
         */
        /* JADX WARN: Code restructure failed: missing block: B:302:?, code lost:
        
            return "kotlin.Boolean";
         */
        /* JADX WARN: Code restructure failed: missing block: B:304:?, code lost:
        
            return "kotlin.Char";
         */
        /* JADX WARN: Code restructure failed: missing block: B:305:?, code lost:
        
            return "kotlin.Short";
         */
        /* JADX WARN: Code restructure failed: missing block: B:306:?, code lost:
        
            return "kotlin.Float";
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
         */
        /* JADX WARN: Removed duplicated region for block: B:261:0x037f A[RETURN, SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final String classFqNameOf(String type) {
            int iHashCode = type.hashCode();
            switch (iHashCode) {
                case -2061550653:
                    if (type.equals("kotlin.jvm.internal.DoubleCompanionObject")) {
                        return "kotlin.Double.Companion";
                    }
                    return null;
                case -2056817302:
                    if (type.equals("java.lang.Integer")) {
                        return "kotlin.Int";
                    }
                    break;
                case -2034166429:
                    if (type.equals("java.lang.Cloneable")) {
                        return "kotlin.Cloneable";
                    }
                    break;
                case -1979556166:
                    if (type.equals("java.lang.annotation.Annotation")) {
                        return "kotlin.Annotation";
                    }
                    break;
                case -1571515090:
                    if (type.equals("java.lang.Comparable")) {
                        return "kotlin.Comparable";
                    }
                    break;
                case -1383349348:
                    if (type.equals("java.util.Map")) {
                        return "kotlin.collections.Map";
                    }
                    break;
                case -1383343454:
                    if (type.equals("java.util.Set")) {
                        return "kotlin.collections.Set";
                    }
                    break;
                case -1325958191:
                    break;
                case -1182275604:
                    if (type.equals("kotlin.jvm.internal.ByteCompanionObject")) {
                        return "kotlin.Byte.Companion";
                    }
                    break;
                case -1062240117:
                    if (type.equals("java.lang.CharSequence")) {
                        return "kotlin.CharSequence";
                    }
                    break;
                case -688322466:
                    if (type.equals("java.util.Collection")) {
                        return "kotlin.collections.Collection";
                    }
                    break;
                case -527879800:
                    break;
                case -515992664:
                    break;
                case -246476834:
                    if (type.equals("kotlin.jvm.internal.CharCompanionObject")) {
                        return "kotlin.Char.Companion";
                    }
                    break;
                case -207262728:
                    if (type.equals("kotlin.jvm.internal.LongCompanionObject")) {
                        return "kotlin.Long.Companion";
                    }
                    break;
                case -165139126:
                    if (type.equals("java.util.Map$Entry")) {
                        return "kotlin.collections.Map.Entry";
                    }
                    break;
                case 104431:
                    if (type.equals("int")) {
                        return "kotlin.Int";
                    }
                    break;
                case 3039496:
                    break;
                case 3052374:
                    break;
                case 3327612:
                    break;
                case 64711720:
                    break;
                case 65821278:
                    if (type.equals("java.util.List")) {
                        return "kotlin.collections.List";
                    }
                    break;
                case 77230534:
                    if (type.equals("kotlin.jvm.internal.ShortCompanionObject")) {
                        return "kotlin.Short.Companion";
                    }
                    break;
                case 97526364:
                    break;
                case 109413500:
                    break;
                case 155276373:
                    break;
                case 226173651:
                    if (type.equals("kotlin.jvm.internal.EnumCompanionObject")) {
                        return "kotlin.Enum.Companion";
                    }
                    break;
                case 344809556:
                    break;
                case 398507100:
                    break;
                case 398585941:
                    if (type.equals("java.lang.Enum")) {
                        return "kotlin.Enum";
                    }
                    break;
                case 398795216:
                    break;
                case 482629606:
                    if (type.equals("kotlin.jvm.internal.FloatCompanionObject")) {
                        return "kotlin.Float.Companion";
                    }
                    break;
                case 499831342:
                    if (type.equals("java.util.Iterator")) {
                        return "kotlin.collections.Iterator";
                    }
                    break;
                case 577341676:
                    if (type.equals("java.util.ListIterator")) {
                        return "kotlin.collections.ListIterator";
                    }
                    break;
                case 599019395:
                    if (type.equals("kotlin.jvm.internal.StringCompanionObject")) {
                        return "kotlin.String.Companion";
                    }
                    break;
                case 761287205:
                    break;
                case 1052881309:
                    if (type.equals("java.lang.Number")) {
                        return "kotlin.Number";
                    }
                    break;
                case 1063877011:
                    if (type.equals("java.lang.Object")) {
                        return "kotlin.Any";
                    }
                    break;
                case 1195259493:
                    if (type.equals("java.lang.String")) {
                        return "kotlin.String";
                    }
                    break;
                case 1275614662:
                    if (type.equals("java.lang.Iterable")) {
                        return "kotlin.collections.Iterable";
                    }
                    break;
                case 1383693018:
                    if (type.equals("kotlin.jvm.internal.BooleanCompanionObject")) {
                        return "kotlin.Boolean.Companion";
                    }
                    break;
                case 1630335596:
                    if (type.equals("java.lang.Throwable")) {
                        return "kotlin.Throwable";
                    }
                    break;
                case 1877171123:
                    if (type.equals("kotlin.jvm.internal.IntCompanionObject")) {
                        return "kotlin.Int.Companion";
                    }
                    break;
                default:
                    switch (iHashCode) {
                        case -1811142716:
                            if (type.equals("kotlin.jvm.functions.Function10")) {
                                return "kotlin.Function10";
                            }
                            break;
                        case -1811142715:
                            if (type.equals("kotlin.jvm.functions.Function11")) {
                                return "kotlin.Function11";
                            }
                            break;
                        case -1811142714:
                            if (type.equals("kotlin.jvm.functions.Function12")) {
                                return "kotlin.Function12";
                            }
                            break;
                        case -1811142713:
                            if (type.equals("kotlin.jvm.functions.Function13")) {
                                return "kotlin.Function13";
                            }
                            break;
                        case -1811142712:
                            if (type.equals("kotlin.jvm.functions.Function14")) {
                                return "kotlin.Function14";
                            }
                            break;
                        case -1811142711:
                            if (type.equals("kotlin.jvm.functions.Function15")) {
                                return "kotlin.Function15";
                            }
                            break;
                        case -1811142710:
                            if (type.equals("kotlin.jvm.functions.Function16")) {
                                return "kotlin.Function16";
                            }
                            break;
                        case -1811142709:
                            if (type.equals("kotlin.jvm.functions.Function17")) {
                                return "kotlin.Function17";
                            }
                            break;
                        case -1811142708:
                            if (type.equals("kotlin.jvm.functions.Function18")) {
                                return "kotlin.Function18";
                            }
                            break;
                        case -1811142707:
                            if (type.equals("kotlin.jvm.functions.Function19")) {
                                return "kotlin.Function19";
                            }
                            break;
                        default:
                            switch (iHashCode) {
                                case -1811142685:
                                    if (type.equals("kotlin.jvm.functions.Function20")) {
                                        return "kotlin.Function20";
                                    }
                                    break;
                                case -1811142684:
                                    if (type.equals("kotlin.jvm.functions.Function21")) {
                                        return "kotlin.Function21";
                                    }
                                    break;
                                case -1811142683:
                                    if (type.equals("kotlin.jvm.functions.Function22")) {
                                        return "kotlin.Function22";
                                    }
                                    break;
                                default:
                                    switch (iHashCode) {
                                        case 80123371:
                                            if (type.equals("kotlin.jvm.functions.Function0")) {
                                                return "kotlin.Function0";
                                            }
                                            break;
                                        case 80123372:
                                            if (type.equals("kotlin.jvm.functions.Function1")) {
                                                return "kotlin.Function1";
                                            }
                                            break;
                                        case 80123373:
                                            if (type.equals("kotlin.jvm.functions.Function2")) {
                                                return "kotlin.Function2";
                                            }
                                            break;
                                        case 80123374:
                                            if (type.equals("kotlin.jvm.functions.Function3")) {
                                                return "kotlin.Function3";
                                            }
                                            break;
                                        case 80123375:
                                            if (type.equals("kotlin.jvm.functions.Function4")) {
                                                return "kotlin.Function4";
                                            }
                                            break;
                                        case 80123376:
                                            if (type.equals("kotlin.jvm.functions.Function5")) {
                                                return "kotlin.Function5";
                                            }
                                            break;
                                        case 80123377:
                                            if (type.equals("kotlin.jvm.functions.Function6")) {
                                                return "kotlin.Function6";
                                            }
                                            break;
                                        case 80123378:
                                            if (type.equals("kotlin.jvm.functions.Function7")) {
                                                return "kotlin.Function7";
                                            }
                                            break;
                                        case 80123379:
                                            if (type.equals("kotlin.jvm.functions.Function8")) {
                                                return "kotlin.Function8";
                                            }
                                            break;
                                        case 80123380:
                                            if (type.equals("kotlin.jvm.functions.Function9")) {
                                                return "kotlin.Function9";
                                            }
                                            break;
                                    }
                            }
                    }
            }
        }

        /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
        /* JADX WARN: Code restructure failed: missing block: B:101:0x016c, code lost:
        
            if (r10.equals("kotlin.jvm.internal.IntCompanionObject") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:109:0x0187, code lost:
        
            if (r10.equals("kotlin.jvm.internal.BooleanCompanionObject") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:128:0x01c9, code lost:
        
            if (r10.equals("java.lang.Double") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:132:0x01d6, code lost:
        
            if (r10.equals("kotlin.jvm.internal.StringCompanionObject") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:143:0x01fc, code lost:
        
            if (r10.equals("kotlin.jvm.internal.FloatCompanionObject") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:146:0x0206, code lost:
        
            if (r10.equals("java.lang.Long") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:154:0x0221, code lost:
        
            if (r10.equals("java.lang.Byte") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:158:0x022e, code lost:
        
            if (r10.equals("java.lang.Boolean") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:162:0x023b, code lost:
        
            if (r10.equals("kotlin.jvm.internal.EnumCompanionObject") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:165:0x0245, code lost:
        
            if (r10.equals("java.lang.Character") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:169:0x0252, code lost:
        
            if (r10.equals("short") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:173:0x025f, code lost:
        
            if (r10.equals("float") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:177:0x026c, code lost:
        
            if (r10.equals("kotlin.jvm.internal.ShortCompanionObject") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:184:0x0284, code lost:
        
            if (r10.equals("boolean") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:187:0x028e, code lost:
        
            if (r10.equals("long") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:190:0x0298, code lost:
        
            if (r10.equals("char") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:193:0x02a2, code lost:
        
            if (r10.equals("byte") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:203:0x02c4, code lost:
        
            if (r10.equals("kotlin.jvm.internal.LongCompanionObject") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:206:0x02ce, code lost:
        
            if (r10.equals("kotlin.jvm.internal.CharCompanionObject") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:209:0x02d8, code lost:
        
            if (r10.equals("java.lang.Short") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:212:0x02e2, code lost:
        
            if (r10.equals("java.lang.Float") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:223:0x0308, code lost:
        
            if (r10.equals("kotlin.jvm.internal.ByteCompanionObject") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:226:0x0311, code lost:
        
            if (r10.equals("double") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:252:0x035f, code lost:
        
            if (r10.equals("kotlin.jvm.internal.DoubleCompanionObject") == false) goto L253;
         */
        /* JADX WARN: Code restructure failed: missing block: B:278:?, code lost:
        
            return "Companion";
         */
        /* JADX WARN: Code restructure failed: missing block: B:284:?, code lost:
        
            return "Double";
         */
        /* JADX WARN: Code restructure failed: missing block: B:287:?, code lost:
        
            return "Long";
         */
        /* JADX WARN: Code restructure failed: missing block: B:289:?, code lost:
        
            return "Byte";
         */
        /* JADX WARN: Code restructure failed: missing block: B:290:?, code lost:
        
            return "Boolean";
         */
        /* JADX WARN: Code restructure failed: missing block: B:291:?, code lost:
        
            return "Char";
         */
        /* JADX WARN: Code restructure failed: missing block: B:292:?, code lost:
        
            return "Short";
         */
        /* JADX WARN: Code restructure failed: missing block: B:293:?, code lost:
        
            return "Float";
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
         */
        /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
        java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterative(DepthRegionTraversal.java:31)
        	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visit(SwitchOverStringVisitor.java:60)
         */
        /* JADX WARN: Removed duplicated region for block: B:253:0x0361 A[ORIG_RETURN, RETURN] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        private final String simpleNameOf(String type) {
            int iHashCode = type.hashCode();
            switch (iHashCode) {
                case -2061550653:
                    break;
                case -2056817302:
                    if (type.equals("java.lang.Integer")) {
                        return "Int";
                    }
                    return null;
                case -2034166429:
                    if (type.equals("java.lang.Cloneable")) {
                        return "Cloneable";
                    }
                    break;
                case -1979556166:
                    if (type.equals("java.lang.annotation.Annotation")) {
                        return "Annotation";
                    }
                    break;
                case -1571515090:
                    if (type.equals("java.lang.Comparable")) {
                        return "Comparable";
                    }
                    break;
                case -1383349348:
                    if (type.equals("java.util.Map")) {
                        return "Map";
                    }
                    break;
                case -1383343454:
                    if (type.equals("java.util.Set")) {
                        return "Set";
                    }
                    break;
                case -1325958191:
                    break;
                case -1182275604:
                    break;
                case -1062240117:
                    if (type.equals("java.lang.CharSequence")) {
                        return "CharSequence";
                    }
                    break;
                case -688322466:
                    if (type.equals("java.util.Collection")) {
                        return "Collection";
                    }
                    break;
                case -527879800:
                    break;
                case -515992664:
                    break;
                case -246476834:
                    break;
                case -207262728:
                    break;
                case -165139126:
                    if (type.equals("java.util.Map$Entry")) {
                        return "Entry";
                    }
                    break;
                case 104431:
                    if (type.equals("int")) {
                        return "Int";
                    }
                    break;
                case 3039496:
                    break;
                case 3052374:
                    break;
                case 3327612:
                    break;
                case 64711720:
                    break;
                case 65821278:
                    if (type.equals("java.util.List")) {
                        return "List";
                    }
                    break;
                case 77230534:
                    break;
                case 97526364:
                    break;
                case 109413500:
                    break;
                case 155276373:
                    break;
                case 226173651:
                    break;
                case 344809556:
                    break;
                case 398507100:
                    break;
                case 398585941:
                    if (type.equals("java.lang.Enum")) {
                        return "Enum";
                    }
                    break;
                case 398795216:
                    break;
                case 482629606:
                    break;
                case 499831342:
                    if (type.equals("java.util.Iterator")) {
                        return "Iterator";
                    }
                    break;
                case 577341676:
                    if (type.equals("java.util.ListIterator")) {
                        return "ListIterator";
                    }
                    break;
                case 599019395:
                    break;
                case 761287205:
                    break;
                case 1052881309:
                    if (type.equals("java.lang.Number")) {
                        return "Number";
                    }
                    break;
                case 1063877011:
                    if (type.equals("java.lang.Object")) {
                        return "Any";
                    }
                    break;
                case 1195259493:
                    if (type.equals("java.lang.String")) {
                        return "String";
                    }
                    break;
                case 1275614662:
                    if (type.equals("java.lang.Iterable")) {
                        return "Iterable";
                    }
                    break;
                case 1383693018:
                    break;
                case 1630335596:
                    if (type.equals("java.lang.Throwable")) {
                        return "Throwable";
                    }
                    break;
                case 1877171123:
                    break;
                default:
                    switch (iHashCode) {
                        case -1811142716:
                            if (type.equals("kotlin.jvm.functions.Function10")) {
                                return "Function10";
                            }
                            break;
                        case -1811142715:
                            if (type.equals("kotlin.jvm.functions.Function11")) {
                                return "Function11";
                            }
                            break;
                        case -1811142714:
                            if (type.equals("kotlin.jvm.functions.Function12")) {
                                return "Function12";
                            }
                            break;
                        case -1811142713:
                            if (type.equals("kotlin.jvm.functions.Function13")) {
                                return "Function13";
                            }
                            break;
                        case -1811142712:
                            if (type.equals("kotlin.jvm.functions.Function14")) {
                                return "Function14";
                            }
                            break;
                        case -1811142711:
                            if (type.equals("kotlin.jvm.functions.Function15")) {
                                return "Function15";
                            }
                            break;
                        case -1811142710:
                            if (type.equals("kotlin.jvm.functions.Function16")) {
                                return "Function16";
                            }
                            break;
                        case -1811142709:
                            if (type.equals("kotlin.jvm.functions.Function17")) {
                                return "Function17";
                            }
                            break;
                        case -1811142708:
                            if (type.equals("kotlin.jvm.functions.Function18")) {
                                return "Function18";
                            }
                            break;
                        case -1811142707:
                            if (type.equals("kotlin.jvm.functions.Function19")) {
                                return "Function19";
                            }
                            break;
                        default:
                            switch (iHashCode) {
                                case -1811142685:
                                    if (type.equals("kotlin.jvm.functions.Function20")) {
                                        return "Function20";
                                    }
                                    break;
                                case -1811142684:
                                    if (type.equals("kotlin.jvm.functions.Function21")) {
                                        return "Function21";
                                    }
                                    break;
                                case -1811142683:
                                    if (type.equals("kotlin.jvm.functions.Function22")) {
                                        return "Function22";
                                    }
                                    break;
                                default:
                                    switch (iHashCode) {
                                        case 80123371:
                                            if (type.equals("kotlin.jvm.functions.Function0")) {
                                                return "Function0";
                                            }
                                            break;
                                        case 80123372:
                                            if (type.equals("kotlin.jvm.functions.Function1")) {
                                                return "Function1";
                                            }
                                            break;
                                        case 80123373:
                                            if (type.equals("kotlin.jvm.functions.Function2")) {
                                                return "Function2";
                                            }
                                            break;
                                        case 80123374:
                                            if (type.equals("kotlin.jvm.functions.Function3")) {
                                                return "Function3";
                                            }
                                            break;
                                        case 80123375:
                                            if (type.equals("kotlin.jvm.functions.Function4")) {
                                                return "Function4";
                                            }
                                            break;
                                        case 80123376:
                                            if (type.equals("kotlin.jvm.functions.Function5")) {
                                                return "Function5";
                                            }
                                            break;
                                        case 80123377:
                                            if (type.equals("kotlin.jvm.functions.Function6")) {
                                                return "Function6";
                                            }
                                            break;
                                        case 80123378:
                                            if (type.equals("kotlin.jvm.functions.Function7")) {
                                                return "Function7";
                                            }
                                            break;
                                        case 80123379:
                                            if (type.equals("kotlin.jvm.functions.Function8")) {
                                                return "Function8";
                                            }
                                            break;
                                        case 80123380:
                                            if (type.equals("kotlin.jvm.functions.Function9")) {
                                                return "Function9";
                                            }
                                            break;
                                    }
                            }
                    }
            }
        }

        public final String getClassQualifiedName(Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            String str = null;
            if (jClass.isAnonymousClass() || jClass.isLocalClass()) {
                return null;
            }
            if (!jClass.isArray()) {
                String name = jClass.getName();
                Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                String strClassFqNameOf = classFqNameOf(name);
                return strClassFqNameOf == null ? jClass.getCanonicalName() : strClassFqNameOf;
            }
            Class<?> componentType = jClass.getComponentType();
            if (componentType.isPrimitive()) {
                String name2 = componentType.getName();
                Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                String strClassFqNameOf2 = classFqNameOf(name2);
                if (strClassFqNameOf2 != null) {
                    str = strClassFqNameOf2 + "Array";
                }
            }
            return str == null ? "kotlin.Array" : str;
        }

        public final String getClassSimpleName(Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            String str = null;
            if (jClass.isAnonymousClass()) {
                return null;
            }
            if (!jClass.isLocalClass()) {
                if (!jClass.isArray()) {
                    String name = jClass.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String strSimpleNameOf = simpleNameOf(name);
                    return strSimpleNameOf == null ? jClass.getSimpleName() : strSimpleNameOf;
                }
                Class<?> componentType = jClass.getComponentType();
                if (componentType.isPrimitive()) {
                    String name2 = componentType.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    String strSimpleNameOf2 = simpleNameOf(name2);
                    if (strSimpleNameOf2 != null) {
                        str = strSimpleNameOf2 + "Array";
                    }
                }
                return str == null ? "Array" : str;
            }
            String simpleName = jClass.getSimpleName();
            Method enclosingMethod = jClass.getEnclosingMethod();
            if (enclosingMethod != null) {
                Intrinsics.checkNotNull(simpleName);
                String strSubstringAfter$default = StringsKt.substringAfter$default(simpleName, enclosingMethod.getName() + Typography.dollar, (String) null, 2, (Object) null);
                if (strSubstringAfter$default != null) {
                    return strSubstringAfter$default;
                }
            }
            Constructor<?> enclosingConstructor = jClass.getEnclosingConstructor();
            if (enclosingConstructor == null) {
                Intrinsics.checkNotNull(simpleName);
                return StringsKt.substringAfter$default(simpleName, Typography.dollar, (String) null, 2, (Object) null);
            }
            Intrinsics.checkNotNull(simpleName);
            return StringsKt.substringAfter$default(simpleName, enclosingConstructor.getName() + Typography.dollar, (String) null, 2, (Object) null);
        }

        public final boolean isInstance(Object value, Class<?> jClass) {
            Intrinsics.checkNotNullParameter(jClass, "jClass");
            Map map = ClassReference.FUNCTION_CLASSES;
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(jClass);
            if (num != null) {
                return TypeIntrinsics.isFunctionOfArity(value, num.intValue());
            }
            if (jClass.isPrimitive()) {
                jClass = JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(jClass));
            }
            return jClass.isInstance(value);
        }

        private Companion() {
        }
    }

    static {
        List listListOf = CollectionsKt.m5806listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
        int i = 0;
        for (Object obj : listListOf) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            arrayList.add(TuplesKt.m5076to((Class) obj, Integer.valueOf(i)));
            i = i2;
        }
        FUNCTION_CLASSES = C1155MapsKt.m5954toMap(arrayList);
    }

    public ClassReference(Class<?> jClass) {
        Intrinsics.checkNotNullParameter(jClass, "jClass");
        this.jClass = jClass;
    }

    /* renamed from: error */
    private final Void m6297error() {
        throw new KotlinReflectionNotSupportedError();
    }

    @SinceKotlin(m5061version = "1.3")
    public static /* synthetic */ void getSealedSubclasses$annotations() {
    }

    @SinceKotlin(m5061version = "1.1")
    public static /* synthetic */ void getSupertypes$annotations() {
    }

    @SinceKotlin(m5061version = "1.1")
    public static /* synthetic */ void getTypeParameters$annotations() {
    }

    @SinceKotlin(m5061version = "1.1")
    public static /* synthetic */ void getVisibility$annotations() {
    }

    @SinceKotlin(m5061version = "1.1")
    public static /* synthetic */ void isAbstract$annotations() {
    }

    @SinceKotlin(m5061version = "1.1")
    public static /* synthetic */ void isCompanion$annotations() {
    }

    @SinceKotlin(m5061version = "1.1")
    public static /* synthetic */ void isData$annotations() {
    }

    @SinceKotlin(m5061version = "1.1")
    public static /* synthetic */ void isFinal$annotations() {
    }

    @SinceKotlin(m5061version = "1.4")
    public static /* synthetic */ void isFun$annotations() {
    }

    @SinceKotlin(m5061version = "1.1")
    public static /* synthetic */ void isInner$annotations() {
    }

    @SinceKotlin(m5061version = "1.1")
    public static /* synthetic */ void isOpen$annotations() {
    }

    @SinceKotlin(m5061version = "1.1")
    public static /* synthetic */ void isSealed$annotations() {
    }

    @SinceKotlin(m5061version = "1.5")
    public static /* synthetic */ void isValue$annotations() {
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    /* renamed from: equals */
    public boolean mo6298equals(Object other) {
        return (other instanceof ClassReference) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((InterfaceC1242KClass) other));
    }

    @Override // p094kotlin.p105jvm.internal.KotlinGenericDeclaration
    public GenericDeclaration findJavaDeclaration() {
        return getJClass();
    }

    @Override // p094kotlin.p113reflect.KAnnotatedElement
    public List<Annotation> getAnnotations() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public Collection<KFunction<Object>> getConstructors() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p105jvm.internal.ClassBasedDeclarationContainer
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass, p094kotlin.p113reflect.KDeclarationContainer
    public Collection<KCallable<?>> getMembers() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public Collection<InterfaceC1242KClass<?>> getNestedClasses() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public Object getObjectInstance() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public String getQualifiedName() {
        return INSTANCE.getClassQualifiedName(getJClass());
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public List<InterfaceC1242KClass<? extends Object>> getSealedSubclasses() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public String getSimpleName() {
        return INSTANCE.getClassSimpleName(getJClass());
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public List<InterfaceC1252KType> getSupertypes() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public List<KTypeParameter> getTypeParameters() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public KVisibility getVisibility() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public boolean isAbstract() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public boolean isCompanion() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    /* renamed from: isData */
    public boolean mo6299isData() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    /* renamed from: isFinal */
    public boolean mo6300isFinal() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    /* renamed from: isFun */
    public boolean mo6301isFun() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    /* renamed from: isInner */
    public boolean mo6302isInner() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    @SinceKotlin(m5061version = "1.1")
    public boolean isInstance(Object value) {
        return INSTANCE.isInstance(value, getJClass());
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    /* renamed from: isOpen */
    public boolean mo6303isOpen() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    public boolean isSealed() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    @Override // p094kotlin.p113reflect.InterfaceC1242KClass
    /* renamed from: isValue */
    public boolean mo6304isValue() {
        m6297error();
        throw new KotlinNothingValueException();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
