package p094kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.conscrypt.BuildConfig;
import p094kotlin.annotation.AnnotationRetention;
import p094kotlin.annotation.AnnotationTarget;
import p094kotlin.annotation.InterfaceC1134Target;
import p094kotlin.p105jvm.InterfaceC1231JvmName;

@Target({ElementType.TYPE})
@SinceKotlin(m5061version = "1.3")
@Metadata(m4987d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0098\u0001\bF\u0012\u000e\b\u0002\u0010\u0002\u001a\u00020\u0003B\u0004\b\u0003\u0010\u0002\u0012\f\b\u0002\u0010\u0004\u001a\u00020\u0005B\u0002\b\f\u0012\u001e\b\u0002\u0010\u0006\u001a\u00020\u0005B\u0014\b\fJ\u0004\b\u0003\u0010\u0002J\u0004\b\u0003\u0010\u0000J\u0004\b\u0003\u0010\u0006\u0012\u0012\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bB\u0002\b\f\u0012\u0012\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bB\u0002\b\f\u0012\u000e\b\u0002\u0010\u000b\u001a\u00020\tB\u0004\b\b(\f\u0012\u000e\b\u0002\u0010\r\u001a\u00020\tB\u0004\b\b(\f\u0012\u000e\b\u0002\u0010\u000e\u001a\u00020\u0003B\u0004\b\u0003\u0010\u0000R#\u0010\u0002\u001a\u00020\u00038\u0007X\u0086\u0084\bz\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u000f¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R#\u0010\u0004\u001a\u00020\u00058\u0007X\u0086\u0084\bz\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014RA\u0010\u0006\u001a\u00020\u0005X\u0087\u0084\br\u0018\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\n\b\u001b\u0012\u0006\b\n0\u001c8\u001dz\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0017¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0014R)\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007X\u0086\u0084\bz\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u001e¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR)\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\b8\u0007X\u0086\u0084\bz\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b( ¢\u0006\u0006\u001a\u0004\b \u0010\u001fR#\u0010\u000b\u001a\u00020\t8\u0007X\u0086\u0084\bz\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(!¢\u0006\u0006\u001a\u0004\b!\u0010\"R5\u0010\r\u001a\u00020\tX\u0087\u0084\br\f\b%\u0012\b\b&\u0012\u0004\b\b('z\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b($¢\u0006\f\u0012\u0004\b#\u0010\u0016\u001a\u0004\b$\u0010\"R5\u0010\u000e\u001a\u00020\u0003X\u0087\u0084\br\f\b%\u0012\b\b&\u0012\u0004\b\b(*z\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b()¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0010Ê\u0001\u000e\b,\u0012\n\b-\u0012\u0006\b\n0.8/Ê\u0001\u0012\b0\u0012\u000e\b1\u0012\n\b\fJ\u0006\b\n0283Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\b(4¨\u0006+"}, m4988d2 = {"Lkotlin/Metadata;", BuildConfig.f24315FLAVOR, "kind", BuildConfig.f24315FLAVOR, "metadataVersion", BuildConfig.f24315FLAVOR, "bytecodeVersion", "data1", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "data2", "extraString", BuildConfig.f24315FLAVOR, "packageName", "extraInt", "k", "()I", "Lkotlin/jvm/JvmName;", "name", "mv", "()[I", "bv$annotations", "()V", "bv", "Lkotlin/Deprecated;", "message", "Bytecode version had no significant use in Kotlin metadata and it will be removed in a future version.", "level", "Lkotlin/DeprecationLevel;", "WARNING", "d1", "()[Ljava/lang/String;", "d2", "xs", "()Ljava/lang/String;", "pn$annotations", "pn", "Lkotlin/SinceKotlin;", "version", "1.2", "xi$annotations", "xi", "1.1", "kotlin-stdlib", "Lkotlin/annotation/Retention;", "value", "Lkotlin/annotation/AnnotationRetention;", "RUNTIME", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "CLASS", "1.3"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1134Target(allowedTargets = {AnnotationTarget.f4927CLASS})
@Retention(RetentionPolicy.RUNTIME)
@p094kotlin.annotation.Retention(m5109value = AnnotationRetention.f4924RUNTIME)
/* loaded from: classes.dex */
public @interface Metadata {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        @Deprecated(m4971level = DeprecationLevel.f4882WARNING, m4972message = "Bytecode version had no significant use in Kotlin metadata and it will be removed in a future version.")
        public static /* synthetic */ void bv$annotations() {
        }

        @SinceKotlin(m5061version = "1.2")
        public static /* synthetic */ void pn$annotations() {
        }

        @SinceKotlin(m5061version = "1.1")
        public static /* synthetic */ void xi$annotations() {
        }
    }

    @InterfaceC1231JvmName(m6260name = "bv")
    /* renamed from: bv */
    int[] m4986bv() default {1, 0, 3};

    @InterfaceC1231JvmName(m6260name = "d1")
    /* renamed from: d1 */
    String[] m4987d1() default {};

    @InterfaceC1231JvmName(m6260name = "d2")
    /* renamed from: d2 */
    String[] m4988d2() default {};

    @InterfaceC1231JvmName(m6260name = "k")
    /* renamed from: k */
    int m4989k() default 1;

    @InterfaceC1231JvmName(m6260name = "mv")
    /* renamed from: mv */
    int[] m4990mv() default {};

    @InterfaceC1231JvmName(m6260name = "pn")
    /* renamed from: pn */
    String m4991pn() default "";

    @InterfaceC1231JvmName(m6260name = "xi")
    /* renamed from: xi */
    int m4992xi() default 0;

    @InterfaceC1231JvmName(m6260name = "xs")
    /* renamed from: xs */
    String m4993xs() default "";
}
