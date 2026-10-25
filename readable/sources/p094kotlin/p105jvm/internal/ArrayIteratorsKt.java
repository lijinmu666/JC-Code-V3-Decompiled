package p094kotlin.p105jvm.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.collections.BooleanIterator;
import p094kotlin.collections.ByteIterator;
import p094kotlin.collections.CharIterator;
import p094kotlin.collections.DoubleIterator;
import p094kotlin.collections.FloatIterator;
import p094kotlin.collections.IntIterator;
import p094kotlin.collections.LongIterator;
import p094kotlin.collections.ShortIterator;

@Metadata(m4987d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0019\n\u0002\u0018\u0002\n\u0002\u0010\u0017\n\u0002\u0018\u0002\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0018\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0005H\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0007H\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\tH\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u000bH\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\rH\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u000fH\u0086\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u00102\u0006\u0010\u0002\u001a\u00020\u0011H\u0086\u0080\u0004¨\u0006\u0012"}, m4988d2 = {"iterator", "Lkotlin/collections/ByteIterator;", "array", BuildConfig.f24315FLAVOR, "Lkotlin/collections/CharIterator;", BuildConfig.f24315FLAVOR, "Lkotlin/collections/ShortIterator;", BuildConfig.f24315FLAVOR, "Lkotlin/collections/IntIterator;", BuildConfig.f24315FLAVOR, "Lkotlin/collections/LongIterator;", BuildConfig.f24315FLAVOR, "Lkotlin/collections/FloatIterator;", BuildConfig.f24315FLAVOR, "Lkotlin/collections/DoubleIterator;", BuildConfig.f24315FLAVOR, "Lkotlin/collections/BooleanIterator;", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class ArrayIteratorsKt {
    public static final ByteIterator iterator(byte[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayByteIterator(array);
    }

    public static final CharIterator iterator(char[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayCharIterator(array);
    }

    public static final ShortIterator iterator(short[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayShortIterator(array);
    }

    public static final IntIterator iterator(int[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayIntIterator(array);
    }

    public static final LongIterator iterator(long[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayLongIterator(array);
    }

    public static final FloatIterator iterator(float[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayFloatIterator(array);
    }

    public static final DoubleIterator iterator(double[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayDoubleIterator(array);
    }

    public static final BooleanIterator iterator(boolean[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        return new ArrayBooleanIterator(array);
    }
}
