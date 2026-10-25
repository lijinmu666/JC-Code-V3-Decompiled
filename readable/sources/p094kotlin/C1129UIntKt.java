package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.internal.IntrinsicConstEvaluation;

@Metadata(m4987d1 = {"\u0000<\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0003\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\tH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\n\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u000bH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\f\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\rH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\u000e\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0010\u001a)\u0010\u0000\u001a\u00020\u0001*\u00020\u0011H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\u0002\b\u0007b\u0002\b\b¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, m4988d2 = {"toUInt", "Lkotlin/UInt;", BuildConfig.f24315FLAVOR, "(B)I", "Lkotlin/SinceKotlin;", "version", "1.5", "Lkotlin/internal/InlineOnly;", "Lkotlin/internal/IntrinsicConstEvaluation;", BuildConfig.f24315FLAVOR, "(S)I", BuildConfig.f24315FLAVOR, "(I)I", BuildConfig.f24315FLAVOR, "(J)I", BuildConfig.f24315FLAVOR, "(F)I", BuildConfig.f24315FLAVOR, "(D)I", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* renamed from: kotlin.UIntKt */
/* loaded from: classes.dex */
public final class C1129UIntKt {
    @SinceKotlin(m5061version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUInt */
    private static final int m5087toUInt(byte b) {
        return C1128UInt.m18641constructorimpl(b);
    }

    @SinceKotlin(m5061version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUInt */
    private static final int m5092toUInt(short s) {
        return C1128UInt.m18641constructorimpl(s);
    }

    @SinceKotlin(m5061version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUInt */
    private static final int m5090toUInt(int i) {
        return C1128UInt.m18641constructorimpl(i);
    }

    @SinceKotlin(m5061version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUInt */
    private static final int m5091toUInt(long j) {
        return C1128UInt.m18641constructorimpl((int) j);
    }

    @SinceKotlin(m5061version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUInt */
    private static final int m5089toUInt(float f) {
        return UnsignedKt.doubleToUInt(f);
    }

    @SinceKotlin(m5061version = "1.5")
    @IntrinsicConstEvaluation
    @InlineOnly
    /* renamed from: toUInt */
    private static final int m5088toUInt(double d) {
        return UnsignedKt.doubleToUInt(d);
    }
}
