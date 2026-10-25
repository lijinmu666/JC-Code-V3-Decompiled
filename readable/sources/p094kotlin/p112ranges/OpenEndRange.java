package p094kotlin.p112ranges;

import java.lang.Comparable;
import org.conscrypt.BuildConfig;
import p094kotlin.ExperimentalStdlibApi;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.WasExperimental;
import p094kotlin.p105jvm.internal.Intrinsics;

@SinceKotlin(m5061version = "1.9")
@Metadata(m4987d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000f\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003J\u0017\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00028\u0000H\u0096\u0082\u0004¢\u0006\u0002\u0010\fJ\n\u0010\r\u001a\u00020\nH\u0096\u0080\u0004R\u0013\u0010\u0004\u001a\u00028\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0013\u0010\u0007\u001a\u00028\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\u0006Ê\u0001\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011Ê\u0001\u0010\b\u0012\u0012\f\b\u0013\u0012\b\b\fJ\u0004\b\t0\u0014¨\u0006\u000e"}, m4988d2 = {"Lkotlin/ranges/OpenEndRange;", "T", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "start", "getStart", "()Ljava/lang/Comparable;", "endExclusive", "getEndExclusive", "contains", BuildConfig.f24315FLAVOR, "value", "(Ljava/lang/Comparable;)Z", "isEmpty", "kotlin-stdlib", "Lkotlin/SinceKotlin;", "version", "1.9", "Lkotlin/WasExperimental;", "markerClass", "Lkotlin/ExperimentalStdlibApi;"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@WasExperimental(markerClass = {ExperimentalStdlibApi.class})
/* loaded from: classes.dex */
public interface OpenEndRange<T extends Comparable<? super T>> {

    @Metadata(m4989k = 3, m4990mv = {2, 4, 0}, m4992xi = 48)
    public static final class DefaultImpls {
        public static <T extends Comparable<? super T>> boolean contains(OpenEndRange<T> openEndRange, T value) {
            Intrinsics.checkNotNullParameter(value, "value");
            return value.compareTo(openEndRange.getStart()) >= 0 && value.compareTo(openEndRange.getEndExclusive()) < 0;
        }

        /* renamed from: isEmpty */
        public static <T extends Comparable<? super T>> boolean m6463isEmpty(OpenEndRange<T> openEndRange) {
            return openEndRange.getStart().compareTo(openEndRange.getEndExclusive()) >= 0;
        }
    }

    boolean contains(T value);

    T getEndExclusive();

    T getStart();

    /* renamed from: isEmpty */
    boolean mo6445isEmpty();
}
