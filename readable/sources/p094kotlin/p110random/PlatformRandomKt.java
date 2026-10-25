package p094kotlin.p110random;

import java.util.Random;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.internal.InlineOnly;
import p094kotlin.internal.PlatformImplementationsKt;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u001c\u0010\u0006\u001a\u00020\u0002*\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005\u001a\u000e\u0010\u0007\u001a\u00020\u0002H\u0081\u0088\u0004b\u0002\b\b\u001a\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0080\u0080\u0004¨\u0006\u000e"}, m4988d2 = {"asJavaRandom", "Ljava/util/Random;", "Lkotlin/random/Random;", "Lkotlin/SinceKotlin;", "version", "1.3", "asKotlinRandom", "defaultPlatformRandom", "Lkotlin/internal/InlineOnly;", "doubleFromParts", BuildConfig.f24315FLAVOR, "hi26", BuildConfig.f24315FLAVOR, "low27", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class PlatformRandomKt {
    @SinceKotlin(m5061version = "1.3")
    public static final Random asJavaRandom(AbstractC1241Random abstractC1241Random) {
        Random impl;
        Intrinsics.checkNotNullParameter(abstractC1241Random, "<this>");
        AbstractPlatformRandom abstractPlatformRandom = abstractC1241Random instanceof AbstractPlatformRandom ? (AbstractPlatformRandom) abstractC1241Random : null;
        return (abstractPlatformRandom == null || (impl = abstractPlatformRandom.getImpl()) == null) ? new KotlinRandom(abstractC1241Random) : impl;
    }

    @SinceKotlin(m5061version = "1.3")
    public static final AbstractC1241Random asKotlinRandom(Random random) {
        AbstractC1241Random abstractC1241RandomM6437getImpl;
        Intrinsics.checkNotNullParameter(random, "<this>");
        KotlinRandom kotlinRandom = random instanceof KotlinRandom ? (KotlinRandom) random : null;
        return (kotlinRandom == null || (abstractC1241RandomM6437getImpl = kotlinRandom.getImpl()) == null) ? new PlatformRandom(random) : abstractC1241RandomM6437getImpl;
    }

    @InlineOnly
    private static final AbstractC1241Random defaultPlatformRandom() {
        return PlatformImplementationsKt.IMPLEMENTATIONS.defaultPlatformRandom();
    }

    public static final double doubleFromParts(int i, int i2) {
        return ((i << 27) + i2) / 9.007199254740992E15d;
    }
}
