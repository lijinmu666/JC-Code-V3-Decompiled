package p094kotlin.p105jvm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.conscrypt.BuildConfig;
import p094kotlin.Deprecated;
import p094kotlin.DeprecationLevel;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.annotation.AnnotationTarget;
import p094kotlin.annotation.InterfaceC1134Target;

@Target({ElementType.METHOD})
@SinceKotlin(m5061version = "1.2")
@Metadata(m4987d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0002\bFÊ\u0001\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005Ê\u0001\u001a\b\u0006\u0012\u0016\b\u0007\u0012\u0012\b\fJ\u0006\b\n0\b8\tJ\u0006\b\n0\b8\nÊ\u0001\u0018\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\b\u000e\u0012\u0006\b\n0\u000f8\u0010¨\u0006\u0002"}, m4988d2 = {"Lkotlin/jvm/JvmDefault;", BuildConfig.f24315FLAVOR, "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.2", "Lkotlin/annotation/Target;", "allowedTargets", "Lkotlin/annotation/AnnotationTarget;", "FUNCTION", "PROPERTY", "Lkotlin/Deprecated;", "message", "Switch to new -jvm-default modes: `enable` or `no-compatibility`", "level", "Lkotlin/DeprecationLevel;", "HIDDEN"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@Deprecated(m4971level = DeprecationLevel.f4881HIDDEN, m4972message = "Switch to new -jvm-default modes: `enable` or `no-compatibility`")
@InterfaceC1134Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface JvmDefault {
}
