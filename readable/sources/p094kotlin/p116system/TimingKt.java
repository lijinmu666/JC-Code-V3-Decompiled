package p094kotlin.p116system;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function0;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a(\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a(\u0010\u0005\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0006"}, m4988d2 = {"measureTimeMillis", BuildConfig.f24315FLAVOR, "block", "Lkotlin/Function0;", BuildConfig.f24315FLAVOR, "measureNanoTime", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "TimingKt")
/* loaded from: classes.dex */
public final class TimingKt {
    public static final long measureNanoTime(Function0<C1133Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long jNanoTime = System.nanoTime();
        block.mo4323invoke();
        return System.nanoTime() - jNanoTime;
    }

    public static final long measureTimeMillis(Function0<C1133Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        long jCurrentTimeMillis = System.currentTimeMillis();
        block.mo4323invoke();
        return System.currentTimeMillis() - jCurrentTimeMillis;
    }
}
