package p094kotlin.p105jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import p094kotlin.SinceKotlin;

@Target({ElementType.ANNOTATION_TYPE})
@SinceKotlin(m5061version = "1.6")
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: classes.dex */
public @interface RepeatableContainer {
}
