package p094kotlin.p116system;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;

@Metadata(m4987d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0087\u0088\u0004b\u0002\b\u0004¨\u0006\u0005"}, m4988d2 = {"exitProcess", BuildConfig.f24315FLAVOR, "status", BuildConfig.f24315FLAVOR, "Lkotlin/internal/InlineOnly;", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "ProcessKt")
/* loaded from: classes.dex */
public final class ProcessKt {
    @InlineOnly
    private static final Void exitProcess(int i) {
        System.exit(i);
        throw new RuntimeException("System.exit returned normally, while it was supposed to halt JVM.");
    }
}
