package p094kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.conscrypt.BuildConfig;
import p094kotlin.annotation.AnnotationRetention;
import p094kotlin.annotation.AnnotationTarget;
import p094kotlin.annotation.InterfaceC1134Target;
import p094kotlin.annotation.MustBeDocumented;
import p094kotlin.p098enums.EnumEntries;
import p094kotlin.p098enums.EnumEntriesKt;

@Target({ElementType.ANNOTATION_TYPE})
@SinceKotlin(m5061version = "1.3")
@InterfaceC1134Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@p094kotlin.annotation.Retention(m5109value = AnnotationRetention.f4923BINARY)
@MustBeDocumented
@Metadata(m4987d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\nB$\bF\u0012\u000e\b\u0002\u0010\u0002\u001a\u00020\u0003B\u0004\b\b(\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\u00020\u0006B\u0006\b\n0\u00068\u0007R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0005\u001a\u00020\u0006X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\tÊ\u0001\u0012\b\f\u0012\u000e\b\r\u0012\n\b\fJ\u0006\b\n0\u000e8\u000fÊ\u0001\u000e\b\u0010\u0012\n\b\u0011\u0012\u0006\b\n0\u00128\u0013Ê\u0001\u0002\b\u0014Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¨\u0006\u000b"}, m4988d2 = {"Lkotlin/RequiresOptIn;", BuildConfig.f24315FLAVOR, "message", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "level", "Lkotlin/RequiresOptIn$Level;", "ERROR", "()Ljava/lang/String;", "()Lkotlin/RequiresOptIn$Level;", "Level", "kotlin-stdlib", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "ANNOTATION_CLASS", "Lkotlin/annotation/Retention;", "value", "Lkotlin/annotation/AnnotationRetention;", "BINARY", "Lkotlin/annotation/MustBeDocumented;", "Lkotlin/SinceKotlin;", "version", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@Documented
/* loaded from: classes.dex */
public @interface RequiresOptIn {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(m4987d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, m4988d2 = {"Lkotlin/RequiresOptIn$Level;", BuildConfig.f24315FLAVOR, "<init>", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
    /* renamed from: kotlin.RequiresOptIn$Level */
    public static final class EnumC1123Level {
        private static final /* synthetic */ EnumEntries $ENTRIES;

        /* renamed from: $VALUES */
        private static final /* synthetic */ EnumC1123Level[] f4893$VALUES;

        /* renamed from: WARNING */
        public static final EnumC1123Level f4895WARNING = new EnumC1123Level("WARNING", 0);

        /* renamed from: ERROR */
        public static final EnumC1123Level f4894ERROR = new EnumC1123Level("ERROR", 1);

        /* renamed from: $values */
        private static final /* synthetic */ EnumC1123Level[] m5051$values() {
            return new EnumC1123Level[]{f4895WARNING, f4894ERROR};
        }

        static {
            EnumC1123Level[] enumC1123LevelArrM5051$values = m5051$values();
            f4893$VALUES = enumC1123LevelArrM5051$values;
            $ENTRIES = EnumEntriesKt.enumEntries(enumC1123LevelArrM5051$values);
        }

        private EnumC1123Level(String str, int i) {
        }

        public static EnumEntries<EnumC1123Level> getEntries() {
            return $ENTRIES;
        }

        /* renamed from: valueOf */
        public static EnumC1123Level m5052valueOf(String str) {
            return (EnumC1123Level) Enum.valueOf(EnumC1123Level.class, str);
        }

        /* renamed from: values */
        public static EnumC1123Level[] m5053values() {
            return (EnumC1123Level[]) f4893$VALUES.clone();
        }
    }

    /* renamed from: level */
    EnumC1123Level m5049level() default EnumC1123Level.f4894ERROR;

    /* renamed from: message */
    String m5050message() default "";
}
