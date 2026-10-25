package p094kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import org.conscrypt.BuildConfig;
import p094kotlin.RequiresOptIn;
import p094kotlin.annotation.AnnotationRetention;
import p094kotlin.annotation.MustBeDocumented;

@SinceKotlin(m5061version = "2.2")
@RequiresOptIn(m5049level = RequiresOptIn.EnumC1123Level.f4894ERROR, m5050message = "The API is related to the experimental feature \"context parameters\" (see KEEP-367) and may be changed or removed in any future release.")
@Retention(RetentionPolicy.CLASS)
@p094kotlin.annotation.Retention(m5109value = AnnotationRetention.f4923BINARY)
@MustBeDocumented
@Metadata(m4987d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0002\bFÊ\u0001\u0018\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u0012\n\b\u0006\u0012\u0006\b\n0\u00078\bÊ\u0001\u000e\b\t\u0012\n\b\n\u0012\u0006\b\n0\u000b8\fÊ\u0001\u0002\b\rÊ\u0001\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¨\u0006\u0002"}, m4988d2 = {"Lkotlin/ExperimentalContextParameters;", BuildConfig.f24315FLAVOR, "kotlin-stdlib", "Lkotlin/RequiresOptIn;", "message", "The API is related to the experimental feature \"context parameters\" (see KEEP-367) and may be changed or removed in any future release.", "level", "Lkotlin/RequiresOptIn$Level;", "ERROR", "Lkotlin/annotation/Retention;", "value", "Lkotlin/annotation/AnnotationRetention;", "BINARY", "Lkotlin/annotation/MustBeDocumented;", "Lkotlin/SinceKotlin;", "version", "2.2"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@Documented
/* loaded from: classes.dex */
public @interface ExperimentalContextParameters {
}
