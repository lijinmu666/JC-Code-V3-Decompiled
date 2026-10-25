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

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@RequiresOptIn
@InterfaceC1134Target(allowedTargets = {AnnotationTarget.f4927CLASS, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.f4928FIELD, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.TYPEALIAS})
@Retention(RetentionPolicy.CLASS)
@p094kotlin.annotation.Retention(m5109value = AnnotationRetention.f4923BINARY)
@MustBeDocumented
@Metadata(m4987d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0002\bFÊ\u0001\u0002\b\u0003Ê\u0001\u0002\b\u0004Ê\u0001b\b\u0005\u0012^\b\u0006\u0012Z\b\fJ\u0006\b\n0\u00078\bJ\u0006\b\n0\u00078\tJ\u0006\b\n0\u00078\nJ\u0006\b\n0\u00078\u000bJ\u0006\b\n0\u00078\fJ\u0006\b\n0\u00078\rJ\u0006\b\n0\u00078\u000eJ\u0006\b\n0\u00078\u000fJ\u0006\b\n0\u00078\u0010J\u0006\b\n0\u00078\u0011J\u0006\b\n0\u00078\u0012Ê\u0001\u000e\b\u0013\u0012\n\b\u0014\u0012\u0006\b\n0\u00158\u0016¨\u0006\u0002"}, m4988d2 = {"Lkotlin/ExperimentalMultiplatform;", BuildConfig.f24315FLAVOR, "kotlin-stdlib", "Lkotlin/RequiresOptIn;", "Lkotlin/annotation/MustBeDocumented;", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "CLASS", "ANNOTATION_CLASS", "PROPERTY", "FIELD", "LOCAL_VARIABLE", "VALUE_PARAMETER", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "TYPEALIAS", "Lkotlin/annotation/Retention;", "value", "Lkotlin/annotation/AnnotationRetention;", "BINARY"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@Documented
/* loaded from: classes.dex */
public @interface ExperimentalMultiplatform {
}
