package p094kotlin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;

@Target({ElementType.ANNOTATION_TYPE})
@MustBeDocumented
@Metadata(m4987d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0016\bF\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005Ê\u0001\u0012\b\u0000\u0012\u000e\b\u0002\u0012\n\b\fJ\u0006\b\n0\u00048\u0007Ê\u0001\u0002\b\b¨\u0006\u0006"}, m4988d2 = {"Lkotlin/annotation/Target;", BuildConfig.f24315FLAVOR, "allowedTargets", BuildConfig.f24315FLAVOR, "Lkotlin/annotation/AnnotationTarget;", "()[Lkotlin/annotation/AnnotationTarget;", "kotlin-stdlib", "ANNOTATION_CLASS", "Lkotlin/annotation/MustBeDocumented;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1134Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
/* renamed from: kotlin.annotation.Target */
/* loaded from: classes.dex */
public @interface InterfaceC1134Target {
    AnnotationTarget[] allowedTargets();
}
