package p094kotlin.p119time.p120jdk8;

import java.time.Duration;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p119time.DurationKt;
import p094kotlin.p119time.DurationUnit;

@Metadata(m4987d1 = {"\u0000\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0002\u0010\u0003\u001a'\u0010\b\u001a\u00020\u0002*\u00020\u0001H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007¢\u0006\u0004\b\t\u0010\n¨\u0006\u000b"}, m4988d2 = {"toKotlinDuration", "Lkotlin/time/Duration;", "Ljava/time/Duration;", "(Ljava/time/Duration;)J", "Lkotlin/SinceKotlin;", "version", "1.6", "Lkotlin/internal/InlineOnly;", "toJavaDuration", "toJavaDuration-LRDsOJo", "(J)Ljava/time/Duration;", "kotlin-stdlib-jdk8"}, m4989k = 2, m4990mv = {2, 4, 0}, m4991pn = "kotlin.time", m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "DurationConversionsJDK8Kt")
@SourceDebugExtension(m6344value = {"SMAP\nDurationConversions.kt\nKotlin\n*S Kotlin\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n+ 2 Duration.kt\nkotlin/time/Duration\n*L\n1#1,38:1\n620#2:39\n*S KotlinDebug\n*F\n+ 1 DurationConversions.kt\nkotlin/time/jdk8/DurationConversionsJDK8Kt\n*L\n37#1:39\n*E\n"})
/* loaded from: classes.dex */
public final class DurationConversionsJDK8Kt {
    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    /* renamed from: toJavaDuration-LRDsOJo, reason: not valid java name */
    private static final Duration m19976toJavaDurationLRDsOJo(long j) {
        Duration durationOfSeconds = Duration.ofSeconds(p094kotlin.p119time.Duration.m19850getInWholeSecondsimpl(j), p094kotlin.p119time.Duration.m19852getNanosecondsComponentimpl(j));
        Intrinsics.checkNotNullExpressionValue(durationOfSeconds, "toComponents-impl(...)");
        return durationOfSeconds;
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    private static final long toKotlinDuration(Duration duration) {
        Intrinsics.checkNotNullParameter(duration, "<this>");
        return p094kotlin.p119time.Duration.m19865plusLRDsOJo(DurationKt.toDuration(duration.getSeconds(), DurationUnit.f5447SECONDS), DurationKt.toDuration(duration.getNano(), DurationUnit.NANOSECONDS));
    }
}
