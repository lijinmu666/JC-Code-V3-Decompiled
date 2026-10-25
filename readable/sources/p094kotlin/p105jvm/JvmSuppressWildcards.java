package p094kotlin.p105jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.annotation.AnnotationRetention;
import p094kotlin.annotation.AnnotationTarget;
import p094kotlin.annotation.InterfaceC1134Target;
import p094kotlin.annotation.MustBeDocumented;

@Target({ElementType.TYPE, ElementType.METHOD})
@InterfaceC1134Target(allowedTargets = {AnnotationTarget.f4927CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.f4930TYPE})
@Retention(RetentionPolicy.CLASS)
@p094kotlin.annotation.Retention(m5109value = AnnotationRetention.f4923BINARY)
@MustBeDocumented
@Metadata(m4987d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0012\bF\u0012\u000e\b\u0002\u0010\u0002\u001a\u00020\u0003B\u0004\b\u0007\u0010\u0002R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004Ê\u0001*\b\u0006\u0012&\b\u0007\u0012\"\b\fJ\u0006\b\n0\b8\tJ\u0006\b\n0\b8\nJ\u0006\b\n0\b8\u000bJ\u0006\b\n0\b8\fÊ\u0001\u000e\b\r\u0012\n\b\u000e\u0012\u0006\b\n0\u000f8\u0010Ê\u0001\u0002\b\u0011¨\u0006\u0005"}, m4988d2 = {"Lkotlin/jvm/JvmSuppressWildcards;", BuildConfig.f24315FLAVOR, "suppress", BuildConfig.f24315FLAVOR, "()Z", "kotlin-stdlib", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "CLASS", "FUNCTION", "PROPERTY", "TYPE", "Lkotlin/annotation/Retention;", "value", "Lkotlin/annotation/AnnotationRetention;", "BINARY", "Lkotlin/annotation/MustBeDocumented;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@Documented
/* loaded from: classes.dex */
public @interface JvmSuppressWildcards {
    boolean suppress() default true;
}
