package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;

@Metadata(m4987d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006¨\u0006\u0007"}, m4988d2 = {"hashCode", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/SinceKotlin;", "version", "1.3", "Lkotlin/internal/InlineOnly;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class HashCodeKt {
    @SinceKotlin(m5061version = "1.3")
    @InlineOnly
    private static final int hashCode(Object obj) {
        if (obj != null) {
            return obj.hashCode();
        }
        return 0;
    }
}
