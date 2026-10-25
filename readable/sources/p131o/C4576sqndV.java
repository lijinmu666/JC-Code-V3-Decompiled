package p131o;

import android.os.Build;
import android.os.ext.SdkExtensions;
import java.util.Locale;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p119time.DurationKt;

/* renamed from: o.sqndV */
/* loaded from: classes.dex */
public final class C4576sqndV {

    /* renamed from: AZxh */
    public static final int f16545AZxh;

    /* renamed from: KLFTb */
    public static final int f16546KLFTb;

    /* renamed from: ZfxDd */
    public static final int f16547ZfxDd;

    /* renamed from: mjFkc */
    public static final C4576sqndV f16548mjFkc = new C4576sqndV();

    /* renamed from: wA */
    public static final int f16549wA;

    /* renamed from: o.sqndV$mjFkc */
    public static final class mjFkc {

        /* renamed from: mjFkc */
        public static final mjFkc f16550mjFkc = new mjFkc();

        /* renamed from: mjFkc */
        public final int m13528mjFkc(int i) {
            return SdkExtensions.getExtensionVersion(i);
        }
    }

    static {
        int i = Build.VERSION.SDK_INT;
        f16545AZxh = i >= 30 ? mjFkc.f16550mjFkc.m13528mjFkc(30) : 0;
        f16549wA = i >= 30 ? mjFkc.f16550mjFkc.m13528mjFkc(31) : 0;
        f16547ZfxDd = i >= 30 ? mjFkc.f16550mjFkc.m13528mjFkc(33) : 0;
        f16546KLFTb = i >= 30 ? mjFkc.f16550mjFkc.m13528mjFkc(DurationKt.NANOS_IN_MILLIS) : 0;
    }

    /* renamed from: AZxh */
    public static final boolean m13526AZxh() {
        int i = Build.VERSION.SDK_INT;
        if (i < 33) {
            if (i >= 32) {
                String CODENAME = Build.VERSION.CODENAME;
                Intrinsics.checkNotNullExpressionValue(CODENAME, "CODENAME");
                if (m13527mjFkc("Tiramisu", CODENAME)) {
                }
            }
            return false;
        }
        return true;
    }

    /* renamed from: mjFkc */
    public static final boolean m13527mjFkc(String codename, String buildCodename) {
        Intrinsics.checkNotNullParameter(codename, "codename");
        Intrinsics.checkNotNullParameter(buildCodename, "buildCodename");
        if (Intrinsics.areEqual("REL", buildCodename)) {
            return false;
        }
        Locale locale = Locale.ROOT;
        String upperCase = buildCodename.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        String upperCase2 = codename.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
        return upperCase.compareTo(upperCase2) >= 0;
    }
}
