package p094kotlin.p119time.p120jdk8;

import java.time.Instant;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p119time.C1324Instant;
import p094kotlin.p119time.ExperimentalTime;

@Metadata(m4987d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0010\b\u0006\u0012\f\b\u0007\u0012\b\b\fJ\u0004\b\t0\b\u001a.\u0010\t\u001a\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0010\b\u0006\u0012\f\b\u0007\u0012\b\b\fJ\u0004\b\t0\b¨\u0006\n"}, m4988d2 = {"toJavaInstant", "Ljava/time/Instant;", "Lkotlin/time/Instant;", "Lkotlin/SinceKotlin;", "version", "2.3", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/time/ExperimentalTime;", "toKotlinInstant", "kotlin-stdlib-jdk8"}, m4989k = 2, m4990mv = {2, 4, 0}, m4991pn = "kotlin.time", m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "InstantConversionsJDK8Kt")
/* loaded from: classes.dex */
public final class InstantConversionsJDK8Kt {
    @SinceKotlin(m5061version = "2.3")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final Instant toJavaInstant(C1324Instant c1324Instant) {
        Intrinsics.checkNotNullParameter(c1324Instant, "<this>");
        Instant instantOfEpochSecond = Instant.ofEpochSecond(c1324Instant.getEpochSeconds(), c1324Instant.getNanosecondsOfSecond());
        Intrinsics.checkNotNullExpressionValue(instantOfEpochSecond, "ofEpochSecond(...)");
        return instantOfEpochSecond;
    }

    @SinceKotlin(m5061version = "2.3")
    @WasExperimental(markerClass = {ExperimentalTime.class})
    public static final C1324Instant toKotlinInstant(Instant instant) {
        Intrinsics.checkNotNullParameter(instant, "<this>");
        return C1324Instant.INSTANCE.fromEpochSeconds(instant.getEpochSecond(), instant.getNano());
    }
}
