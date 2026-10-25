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

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@InterfaceC1134Target(allowedTargets = {AnnotationTarget.f4927CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.f4928FIELD, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.TYPEALIAS})
@Retention(RetentionPolicy.CLASS)
@p094kotlin.annotation.Retention(m5109value = AnnotationRetention.f4923BINARY)
@MustBeDocumented
@Metadata(m4987d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\n\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004Ê\u0001J\b\u0006\u0012F\b\u0007\u0012B\b\fJ\u0006\b\n0\b8\tJ\u0006\b\n0\b8\nJ\u0006\b\n0\b8\u000bJ\u0006\b\n0\b8\fJ\u0006\b\n0\b8\rJ\u0006\b\n0\b8\u000eJ\u0006\b\n0\b8\u000fJ\u0006\b\n0\b8\u0010Ê\u0001\u000e\b\u0011\u0012\n\b\u0012\u0012\u0006\b\n0\u00138\u0014Ê\u0001\u0002\b\u0015¨\u0006\u0005"}, m4988d2 = {"Lkotlin/SinceKotlin;", BuildConfig.f24315FLAVOR, "version", BuildConfig.f24315FLAVOR, "()Ljava/lang/String;", "kotlin-stdlib", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "CLASS", "PROPERTY", "FIELD", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "TYPEALIAS", "Lkotlin/annotation/Retention;", "value", "Lkotlin/annotation/AnnotationRetention;", "BINARY", "Lkotlin/annotation/MustBeDocumented;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@Documented
/* loaded from: classes.dex */
public @interface SinceKotlin {
    /* renamed from: version */
    String m5061version();
}
