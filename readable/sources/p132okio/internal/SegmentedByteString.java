package p132okio.internal;

import org.conscrypt.BuildConfig;
import p094kotlin.C1133Unit;
import p094kotlin.Metadata;
import p094kotlin.collections.ArraysKt;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.functions.Function3;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p132okio.ByteString;
import p132okio.C5052Buffer;
import p132okio.C5059Segment;
import p132okio.C6370SegmentedByteString;

@Metadata(m4987d1 = {"\u0000P\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a]\u0010\t\u001a\u00020\n*\u00020\u00072K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\fH\u0080\bø\u0001\u0000\u001aj\u0010\t\u001a\u00020\n*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012K\u0010\u000b\u001aG\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\n0\fH\u0082\b\u001a\u001d\u0010\u0015\u001a\u00020\u0016*\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0018*\u00020\u00072\u0006\u0010\b\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0001*\u00020\u0007H\u0080\b\u001a\r\u0010\u001a\u001a\u00020\r*\u00020\u0007H\u0080\b\u001a%\u0010\u001b\u001a\u00020\n*\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u001e\u001a\u00020\u001f*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u001e\u001a\u00020\u001f*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\r2\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a-\u0010\"\u001a\u00020\n*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0080\b\u001a\u0017\u0010%\u001a\u00020\u001f*\u00020\u00072\b\u0010 \u001a\u0004\u0018\u00010&H\u0080\b\u001a\r\u0010'\u001a\u00020\u0001*\u00020\u0007H\u0080\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, m4988d2 = {"binarySearch", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "value", "fromIndex", "toIndex", "segment", "Lokio/SegmentedByteString;", "pos", "forEachSegment", BuildConfig.f24315FLAVOR, "action", "Lkotlin/Function3;", BuildConfig.f24315FLAVOR, "Lkotlin/ParameterName;", "name", "data", "offset", "byteCount", "beginIndex", "endIndex", "commonSubstring", "Lokio/ByteString;", "commonInternalGet", BuildConfig.f24315FLAVOR, "commonGetSize", "commonToByteArray", "commonWrite", "buffer", "Lokio/Buffer;", "commonRangeEquals", BuildConfig.f24315FLAVOR, "other", "otherOffset", "commonCopyInto", "target", "targetOffset", "commonEquals", BuildConfig.f24315FLAVOR, "commonHashCode", "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "-SegmentedByteString")
@SourceDebugExtension(m6344value = {"SMAP\nSegmentedByteString.kt\nKotlin\n*S Kotlin\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n+ 2 fake.kt\nkotlin/jvm/internal/FakeKt\n*L\n1#1,248:1\n62#1,12:250\n84#1,14:262\n84#1,14:276\n84#1,14:290\n84#1,14:304\n62#1,12:318\n1#2:249\n*S KotlinDebug\n*F\n+ 1 SegmentedByteString.kt\nokio/internal/-SegmentedByteString\n*L\n145#1:250,12\n158#1:262,14\n180#1:276,14\n200#1:290,14\n217#1:304,14\n237#1:318,12\n*E\n"})
/* renamed from: okio.internal.-SegmentedByteString, reason: invalid class name */
/* loaded from: classes.dex */
public final class SegmentedByteString {
    public static final int binarySearch(int[] iArr, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(iArr, "<this>");
        int i4 = i3 - 1;
        while (i2 <= i4) {
            int i5 = (i2 + i4) >>> 1;
            int i6 = iArr[i5];
            if (i6 < i) {
                i2 = i5 + 1;
            } else {
                if (i6 <= i) {
                    return i5;
                }
                i4 = i5 - 1;
            }
        }
        return (-i2) - 1;
    }

    public static final void commonCopyInto(C6370SegmentedByteString c6370SegmentedByteString, int i, byte[] target, int i2, int i3) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        long j = i3;
        p132okio.SegmentedByteString.checkOffsetAndCount(c6370SegmentedByteString.m14252size(), i, j);
        p132okio.SegmentedByteString.checkOffsetAndCount(target.length, i2, j);
        int i4 = i3 + i;
        int iM14404segment = m14404segment(c6370SegmentedByteString, i);
        while (i < i4) {
            int i5 = iM14404segment == 0 ? 0 : c6370SegmentedByteString.getDirectory()[iM14404segment - 1];
            int i6 = c6370SegmentedByteString.getDirectory()[iM14404segment] - i5;
            int i7 = c6370SegmentedByteString.getDirectory()[c6370SegmentedByteString.getSegments().length + iM14404segment];
            int iMin = Math.min(i4, i6 + i5) - i;
            int i8 = i7 + (i - i5);
            ArraysKt.copyInto(c6370SegmentedByteString.getSegments()[iM14404segment], target, i2, i8, i8 + iMin);
            i2 += iMin;
            i += iMin;
            iM14404segment++;
        }
    }

    public static final boolean commonEquals(C6370SegmentedByteString c6370SegmentedByteString, Object obj) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        if (obj == c6370SegmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.m14252size() == c6370SegmentedByteString.m14252size() && c6370SegmentedByteString.rangeEquals(0, byteString, 0, c6370SegmentedByteString.m14252size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(C6370SegmentedByteString c6370SegmentedByteString) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        return c6370SegmentedByteString.getDirectory()[c6370SegmentedByteString.getSegments().length - 1];
    }

    public static final int commonHashCode(C6370SegmentedByteString c6370SegmentedByteString) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        int hashCode = c6370SegmentedByteString.getHashCode();
        if (hashCode != 0) {
            return hashCode;
        }
        int length = c6370SegmentedByteString.getSegments().length;
        int i = 0;
        int i2 = 1;
        int i3 = 0;
        while (i < length) {
            int i4 = c6370SegmentedByteString.getDirectory()[length + i];
            int i5 = c6370SegmentedByteString.getDirectory()[i];
            byte[] bArr = c6370SegmentedByteString.getSegments()[i];
            int i6 = (i5 - i3) + i4;
            while (i4 < i6) {
                i2 = (i2 * 31) + bArr[i4];
                i4++;
            }
            i++;
            i3 = i5;
        }
        c6370SegmentedByteString.setHashCode$okio(i2);
        return i2;
    }

    public static final byte commonInternalGet(C6370SegmentedByteString c6370SegmentedByteString, int i) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        p132okio.SegmentedByteString.checkOffsetAndCount(c6370SegmentedByteString.getDirectory()[c6370SegmentedByteString.getSegments().length - 1], i, 1L);
        int iM14404segment = m14404segment(c6370SegmentedByteString, i);
        return c6370SegmentedByteString.getSegments()[iM14404segment][(i - (iM14404segment == 0 ? 0 : c6370SegmentedByteString.getDirectory()[iM14404segment - 1])) + c6370SegmentedByteString.getDirectory()[c6370SegmentedByteString.getSegments().length + iM14404segment]];
    }

    public static final boolean commonRangeEquals(C6370SegmentedByteString c6370SegmentedByteString, int i, ByteString other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i < 0 || i > c6370SegmentedByteString.m14252size() - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iM14404segment = m14404segment(c6370SegmentedByteString, i);
        while (i < i4) {
            int i5 = iM14404segment == 0 ? 0 : c6370SegmentedByteString.getDirectory()[iM14404segment - 1];
            int i6 = c6370SegmentedByteString.getDirectory()[iM14404segment] - i5;
            int i7 = c6370SegmentedByteString.getDirectory()[c6370SegmentedByteString.getSegments().length + iM14404segment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!other.rangeEquals(i2, c6370SegmentedByteString.getSegments()[iM14404segment], i7 + (i - i5), iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iM14404segment++;
        }
        return true;
    }

    public static final ByteString commonSubstring(C6370SegmentedByteString c6370SegmentedByteString, int i, int i2) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        if (i < 0) {
            throw new IllegalArgumentException(("beginIndex=" + i + " < 0").toString());
        }
        if (i2 > c6370SegmentedByteString.m14252size()) {
            throw new IllegalArgumentException(("endIndex=" + i2 + " > length(" + c6370SegmentedByteString.m14252size() + ')').toString());
        }
        int i3 = i2 - i;
        if (i3 < 0) {
            throw new IllegalArgumentException(("endIndex=" + i2 + " < beginIndex=" + i).toString());
        }
        if (i == 0 && i2 == c6370SegmentedByteString.m14252size()) {
            return c6370SegmentedByteString;
        }
        if (i == i2) {
            return ByteString.f17785EMPTY;
        }
        int iM14404segment = m14404segment(c6370SegmentedByteString, i);
        int iM14404segment2 = m14404segment(c6370SegmentedByteString, i2 - 1);
        byte[][] bArr = (byte[][]) ArraysKt.copyOfRange(c6370SegmentedByteString.getSegments(), iM14404segment, iM14404segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (iM14404segment <= iM14404segment2) {
            int i4 = iM14404segment;
            int i5 = 0;
            while (true) {
                iArr[i5] = Math.min(c6370SegmentedByteString.getDirectory()[i4] - i, i3);
                int i6 = i5 + 1;
                iArr[i5 + bArr.length] = c6370SegmentedByteString.getDirectory()[c6370SegmentedByteString.getSegments().length + i4];
                if (i4 == iM14404segment2) {
                    break;
                }
                i4++;
                i5 = i6;
            }
        }
        int i7 = iM14404segment != 0 ? c6370SegmentedByteString.getDirectory()[iM14404segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i - i7);
        return new C6370SegmentedByteString(bArr, iArr);
    }

    public static final byte[] commonToByteArray(C6370SegmentedByteString c6370SegmentedByteString) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        byte[] bArr = new byte[c6370SegmentedByteString.m14252size()];
        int length = c6370SegmentedByteString.getSegments().length;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            int i4 = c6370SegmentedByteString.getDirectory()[length + i];
            int i5 = c6370SegmentedByteString.getDirectory()[i];
            int i6 = i5 - i2;
            ArraysKt.copyInto(c6370SegmentedByteString.getSegments()[i], bArr, i3, i4, i4 + i6);
            i3 += i6;
            i++;
            i2 = i5;
        }
        return bArr;
    }

    public static final void commonWrite(C6370SegmentedByteString c6370SegmentedByteString, C5052Buffer buffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int i3 = i + i2;
        int iM14404segment = m14404segment(c6370SegmentedByteString, i);
        while (i < i3) {
            int i4 = iM14404segment == 0 ? 0 : c6370SegmentedByteString.getDirectory()[iM14404segment - 1];
            int i5 = c6370SegmentedByteString.getDirectory()[iM14404segment] - i4;
            int i6 = c6370SegmentedByteString.getDirectory()[c6370SegmentedByteString.getSegments().length + iM14404segment];
            int iMin = Math.min(i3, i5 + i4) - i;
            int i7 = i6 + (i - i4);
            C5059Segment c5059Segment = new C5059Segment(c6370SegmentedByteString.getSegments()[iM14404segment], i7, i7 + iMin, true, false);
            C5059Segment c5059Segment2 = buffer.head;
            if (c5059Segment2 == null) {
                c5059Segment.prev = c5059Segment;
                c5059Segment.next = c5059Segment;
                buffer.head = c5059Segment;
            } else {
                Intrinsics.checkNotNull(c5059Segment2);
                C5059Segment c5059Segment3 = c5059Segment2.prev;
                Intrinsics.checkNotNull(c5059Segment3);
                c5059Segment3.m14381push(c5059Segment);
            }
            i += iMin;
            iM14404segment++;
        }
        buffer.setSize$okio(buffer.m14225size() + i2);
    }

    public static final void forEachSegment(C6370SegmentedByteString c6370SegmentedByteString, Function3<? super byte[], ? super Integer, ? super Integer, C1133Unit> action) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(action, "action");
        int length = c6370SegmentedByteString.getSegments().length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = c6370SegmentedByteString.getDirectory()[length + i];
            int i4 = c6370SegmentedByteString.getDirectory()[i];
            action.mo6219invoke(c6370SegmentedByteString.getSegments()[i], Integer.valueOf(i3), Integer.valueOf(i4 - i2));
            i++;
            i2 = i4;
        }
    }

    /* renamed from: segment */
    public static final int m14404segment(C6370SegmentedByteString c6370SegmentedByteString, int i) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        int iBinarySearch = binarySearch(c6370SegmentedByteString.getDirectory(), i + 1, 0, c6370SegmentedByteString.getSegments().length);
        return iBinarySearch >= 0 ? iBinarySearch : ~iBinarySearch;
    }

    private static final void forEachSegment(C6370SegmentedByteString c6370SegmentedByteString, int i, int i2, Function3<? super byte[], ? super Integer, ? super Integer, C1133Unit> function3) {
        int iM14404segment = m14404segment(c6370SegmentedByteString, i);
        while (i < i2) {
            int i3 = iM14404segment == 0 ? 0 : c6370SegmentedByteString.getDirectory()[iM14404segment - 1];
            int i4 = c6370SegmentedByteString.getDirectory()[iM14404segment] - i3;
            int i5 = c6370SegmentedByteString.getDirectory()[c6370SegmentedByteString.getSegments().length + iM14404segment];
            int iMin = Math.min(i2, i4 + i3) - i;
            function3.mo6219invoke(c6370SegmentedByteString.getSegments()[iM14404segment], Integer.valueOf(i5 + (i - i3)), Integer.valueOf(iMin));
            i += iMin;
            iM14404segment++;
        }
    }

    public static final boolean commonRangeEquals(C6370SegmentedByteString c6370SegmentedByteString, int i, byte[] other, int i2, int i3) {
        Intrinsics.checkNotNullParameter(c6370SegmentedByteString, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (i < 0 || i > c6370SegmentedByteString.m14252size() - i3 || i2 < 0 || i2 > other.length - i3) {
            return false;
        }
        int i4 = i3 + i;
        int iM14404segment = m14404segment(c6370SegmentedByteString, i);
        while (i < i4) {
            int i5 = iM14404segment == 0 ? 0 : c6370SegmentedByteString.getDirectory()[iM14404segment - 1];
            int i6 = c6370SegmentedByteString.getDirectory()[iM14404segment] - i5;
            int i7 = c6370SegmentedByteString.getDirectory()[c6370SegmentedByteString.getSegments().length + iM14404segment];
            int iMin = Math.min(i4, i6 + i5) - i;
            if (!p132okio.SegmentedByteString.arrayRangeEquals(c6370SegmentedByteString.getSegments()[iM14404segment], i7 + (i - i5), other, i2, iMin)) {
                return false;
            }
            i2 += iMin;
            i += iMin;
            iM14404segment++;
        }
        return true;
    }
}
