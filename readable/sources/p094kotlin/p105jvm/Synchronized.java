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

@Target({ElementType.METHOD})
@InterfaceC1134Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(RetentionPolicy.SOURCE)
@p094kotlin.annotation.Retention(m5109value = AnnotationRetention.f4925SOURCE)
@MustBeDocumented
@Metadata(m4987d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0002\bFÊ\u0001\"\b\u0003\u0012\u001e\b\u0004\u0012\u001a\b\fJ\u0006\b\n0\u00058\u0006J\u0006\b\n0\u00058\u0007J\u0006\b\n0\u00058\bÊ\u0001\u000e\b\t\u0012\n\b\n\u0012\u0006\b\n0\u000b8\fÊ\u0001\u0002\b\r¨\u0006\u0002"}, m4988d2 = {"Lkotlin/jvm/Synchronized;", BuildConfig.f24315FLAVOR, "kotlin-stdlib", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "Lkotlin/annotation/Retention;", "value", "Lkotlin/annotation/AnnotationRetention;", "SOURCE", "Lkotlin/annotation/MustBeDocumented;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@Documented
/* loaded from: classes.dex */
public @interface Synchronized {
}
