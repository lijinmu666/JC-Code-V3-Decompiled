package p094kotlin.p109math;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.JvmField;

@Metadata(m4987d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u00020\u00058\u0000X\u0081\u0084\b\u0092\u0002\u0002\b\u0006¢\u0006\u0002\n\u0000¨\u0006\f"}, m4988d2 = {"Lkotlin/math/Constants;", BuildConfig.f24315FLAVOR, "<init>", "()V", "LN2", BuildConfig.f24315FLAVOR, "Lkotlin/jvm/JvmField;", "epsilon", "taylor_2_bound", "taylor_n_bound", "upper_taylor_2_bound", "upper_taylor_n_bound", "kotlin-stdlib"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
final class Constants {
    public static final Constants INSTANCE = new Constants();

    @JvmField
    public static final double LN2 = Math.log(2.0d);

    @JvmField
    public static final double epsilon;

    @JvmField
    public static final double taylor_2_bound;

    @JvmField
    public static final double taylor_n_bound;

    @JvmField
    public static final double upper_taylor_2_bound;

    @JvmField
    public static final double upper_taylor_n_bound;

    static {
        double dUlp = Math.ulp(1.0d);
        epsilon = dUlp;
        double dSqrt = Math.sqrt(dUlp);
        taylor_2_bound = dSqrt;
        double dSqrt2 = Math.sqrt(dSqrt);
        taylor_n_bound = dSqrt2;
        double d = 1;
        upper_taylor_2_bound = d / dSqrt;
        upper_taylor_n_bound = d / dSqrt2;
    }

    private Constants() {
    }
}
