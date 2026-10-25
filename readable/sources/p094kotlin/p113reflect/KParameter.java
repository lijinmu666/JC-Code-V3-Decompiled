package p094kotlin.p113reflect;

import org.conscrypt.BuildConfig;
import p094kotlin.ExperimentalContextParameters;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

@Metadata(m4987d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\u001bR\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u00020\u000bX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u00020\u000fX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0012\u001a\u00020\u0013X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R)\u0010\u0015\u001a\u00020\u00138&X§\u0084\br\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¢\u0006\f\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0015\u0010\u0014¨\u0006\u001c"}, m4988d2 = {"Lkotlin/reflect/KParameter;", "Lkotlin/reflect/KAnnotatedElement;", "index", BuildConfig.f24315FLAVOR, "getIndex", "()I", "name", BuildConfig.f24315FLAVOR, "getName", "()Ljava/lang/String;", "type", "Lkotlin/reflect/KType;", "getType", "()Lkotlin/reflect/KType;", "kind", "Lkotlin/reflect/KParameter$Kind;", "getKind", "()Lkotlin/reflect/KParameter$Kind;", "isOptional", BuildConfig.f24315FLAVOR, "()Z", "isVararg", "isVararg$annotations", "()V", "Lkotlin/SinceKotlin;", "version", "1.1", "Kind", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public interface KParameter extends KAnnotatedElement {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void isVararg$annotations() {
        }
    }

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m4987d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0006\b\u0005\u0012\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m4988d2 = {"Lkotlin/reflect/KParameter$Kind;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "INSTANCE", "CONTEXT", "Lkotlin/ExperimentalContextParameters;", "EXTENSION_RECEIVER", "VALUE", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.reflect.KParameter$Kind */
    public static final class EnumC1247Kind {
        private static final /* synthetic */ EnumEntries $ENTRIES;

        /* renamed from: $VALUES */
        private static final /* synthetic */ EnumC1247Kind[] f5266$VALUES;
        public static final EnumC1247Kind INSTANCE = new EnumC1247Kind("INSTANCE", 0);

        /* renamed from: CONTEXT */
        @ExperimentalContextParameters
        public static final EnumC1247Kind f5267CONTEXT = new EnumC1247Kind("CONTEXT", 1);
        public static final EnumC1247Kind EXTENSION_RECEIVER = new EnumC1247Kind("EXTENSION_RECEIVER", 2);

        /* renamed from: VALUE */
        public static final EnumC1247Kind f5268VALUE = new EnumC1247Kind("VALUE", 3);

        /* renamed from: $values */
        private static final /* synthetic */ EnumC1247Kind[] m6535$values() {
            return new EnumC1247Kind[]{INSTANCE, f5267CONTEXT, EXTENSION_RECEIVER, f5268VALUE};
        }

        static {
            EnumC1247Kind[] enumC1247KindArrM6535$values = m6535$values();
            f5266$VALUES = enumC1247KindArrM6535$values;
            $ENTRIES = EnumEntriesKt.enumEntries(enumC1247KindArrM6535$values);
        }

        private EnumC1247Kind(String str, int i) {
        }

        public static EnumEntries<EnumC1247Kind> getEntries() {
            return $ENTRIES;
        }

        /* renamed from: valueOf */
        public static EnumC1247Kind m6536valueOf(String str) {
            return (EnumC1247Kind) Enum.valueOf(EnumC1247Kind.class, str);
        }

        /* renamed from: values */
        public static EnumC1247Kind[] m6537values() {
            return (EnumC1247Kind[]) f5266$VALUES.clone();
        }
    }

    int getIndex();

    /* renamed from: getKind */
    EnumC1247Kind m6532getKind();

    /* renamed from: getName */
    String m6533getName();

    /* renamed from: getType */
    InterfaceC1252KType m6534getType();

    boolean isOptional();

    boolean isVararg();
}
