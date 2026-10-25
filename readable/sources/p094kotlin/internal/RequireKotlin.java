package p094kotlin.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.conscrypt.BuildConfig;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.annotation.AnnotationRetention;
import p094kotlin.annotation.AnnotationTarget;
import p094kotlin.annotation.InterfaceC1134Target;
import p094kotlin.annotation.Repeatable;
import p094kotlin.p105jvm.internal.RepeatableContainer;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@SinceKotlin(m5061version = "1.2")
@InterfaceC1134Target(allowedTargets = {AnnotationTarget.f4927CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.TYPEALIAS})
@Retention(RetentionPolicy.SOURCE)
@p094kotlin.annotation.Retention(m5109value = AnnotationRetention.f4925SOURCE)
@Metadata(m4987d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001BN\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\u00020\u0003B\u0004\b\b(\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\u00020\u0007B\u0006\b\n0\u00078\b\u0012\u0010\b\u0002\u0010\t\u001a\u00020\nB\u0006\b\n0\n8\u000b\u0012\u000e\b\u0002\u0010\f\u001a\u00020\rB\u0004\b\u0003\u0010\u0001R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u000eR\u0013\u0010\u0004\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u000eR\u0013\u0010\u0006\u001a\u00020\u0007X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000fR\u0013\u0010\t\u001a\u00020\nX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\u0010R\u0013\u0010\f\u001a\u00020\rX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\u0011Ê\u00012\b\u0013\u0012.\b\u0014\u0012*\b\fJ\u0006\b\n0\u00158\u0016J\u0006\b\n0\u00158\u0017J\u0006\b\n0\u00158\u0018J\u0006\b\n0\u00158\u0019J\u0006\b\n0\u00158\u001aÊ\u0001\u000e\b\u001b\u0012\n\b\u001c\u0012\u0006\b\n0\u001d8\u001eÊ\u0001\u0002\b\u001fÊ\u0001\f\b \u0012\b\b\u0002\u0012\u0004\b\b(!¨\u0006\u0012"}, m4988d2 = {"Lkotlin/internal/RequireKotlin;", BuildConfig.f24315FLAVOR, "version", BuildConfig.f24315FLAVOR, "message", BuildConfig.f24315FLAVOR, "level", "Lkotlin/DeprecationLevel;", "ERROR", "versionKind", "Lkotlin/internal/RequireKotlinVersionKind;", "LANGUAGE_VERSION", "errorCode", BuildConfig.f24315FLAVOR, "()Ljava/lang/String;", "()Lkotlin/DeprecationLevel;", "()Lkotlin/internal/RequireKotlinVersionKind;", "()I", "kotlin-stdlib", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "CLASS", "FUNCTION", "PROPERTY", "CONSTRUCTOR", "TYPEALIAS", "Lkotlin/annotation/Retention;", "value", "Lkotlin/annotation/AnnotationRetention;", "SOURCE", "Lkotlin/annotation/Repeatable;", "Lkotlin/SinceKotlin;", "1.2"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@Repeatable
@java.lang.annotation.Repeatable(Container.class)
/* loaded from: classes.dex */
public @interface RequireKotlin {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    @InterfaceC1134Target(allowedTargets = {AnnotationTarget.f4927CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.TYPEALIAS})
    @Retention(RetentionPolicy.SOURCE)
    @p094kotlin.annotation.Retention(m5109value = AnnotationRetention.f4925SOURCE)
    @RepeatableContainer
    public @interface Container {
        /* renamed from: value */
        RequireKotlin[] m6147value();
    }

    int errorCode() default -1;

    /* renamed from: level */
    DeprecationLevel m6144level() default DeprecationLevel.f4880ERROR;

    /* renamed from: message */
    String m6145message() default "";

    /* renamed from: version */
    String m6146version();

    RequireKotlinVersionKind versionKind() default RequireKotlinVersionKind.LANGUAGE_VERSION;
}
