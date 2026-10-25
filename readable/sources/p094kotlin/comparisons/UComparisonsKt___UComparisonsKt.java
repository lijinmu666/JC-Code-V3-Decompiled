package p094kotlin.comparisons;

import p094kotlin.C1126UByte;
import p094kotlin.ExperimentalUnsignedTypes;
import p094kotlin.Metadata;
import p094kotlin.SinceKotlin;
import p094kotlin.UByteArray;
import p094kotlin.UIntArray;
import p094kotlin.ULongArray;
import p094kotlin.UShortArray;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.internal.Intrinsics;

/* JADX INFO: Access modifiers changed from: package-private */
@Metadata(m4987d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\u001a/\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\u0004\u0010\u0005\u001a/\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\n\u0010\u000b\u001a/\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\r\u0010\u000e\u001a/\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b\u0013\u0010\u0014\u001a;\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b\u0016\u0010\u0017\u001a;\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b\u0018\u0010\u0019\u001a;\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b\u001a\u0010\u001b\u001a7\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u001c\u001a\u00020\u001d\"\u00020\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b\u001e\u0010\u001f\u001a7\u0010\u0000\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u001c\u001a\u00020\"\"\u00020\tH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b#\u0010$\u001a7\u0010\u0000\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u001c\u001a\u00020%\"\u00020\fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b&\u0010'\u001a7\u0010\u0000\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\n\u0010\u001c\u001a\u00020(\"\u00020\u000fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b)\u0010*\u001a/\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b,\u0010\u0005\u001a/\u0010+\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\tH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b-\u0010\u000b\u001a/\u0010+\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b.\u0010\u000e\u001a/\u0010+\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b¢\u0006\u0004\b/\u0010\u0011\u001a;\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b0\u0010\u0014\u001a;\u0010+\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\u0006\u0010\u0003\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\tH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b1\u0010\u0017\u001a;\u0010+\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b2\u0010\u0019\u001a;\u0010+\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0003\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0087\u0088\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\bb\u0002\b\u0015¢\u0006\u0004\b3\u0010\u001b\u001a7\u0010+\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\n\u0010\u001c\u001a\u00020\u001d\"\u00020\u0001H\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b4\u0010\u001f\u001a7\u0010+\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\t2\n\u0010\u001c\u001a\u00020\"\"\u00020\tH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b5\u0010$\u001a7\u0010+\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\f2\n\u0010\u001c\u001a\u00020%\"\u00020\fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b6\u0010'\u001a7\u0010+\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u000f2\n\u0010\u001c\u001a\u00020(\"\u00020\u000fH\u0087\u0080\u0004b\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b( b\u0002\b!¢\u0006\u0004\b7\u0010*¨\u00068"}, m4988d2 = {"maxOf", "Lkotlin/UInt;", "a", "b", "maxOf-J1ME1BU", "(II)I", "Lkotlin/SinceKotlin;", "version", "1.5", "Lkotlin/ULong;", "maxOf-eb3DHEI", "(JJ)J", "Lkotlin/UByte;", "maxOf-Kr8caGY", "(BB)B", "Lkotlin/UShort;", "maxOf-5PvTz6A", "(SS)S", "c", "maxOf-WZ9TVnA", "(III)I", "Lkotlin/internal/InlineOnly;", "maxOf-sambcqE", "(JJJ)J", "maxOf-b33U2AM", "(BBB)B", "maxOf-VKSA0NQ", "(SSS)S", "other", "Lkotlin/UIntArray;", "maxOf-Md2H83M", "(I[I)I", "1.4", "Lkotlin/ExperimentalUnsignedTypes;", "Lkotlin/ULongArray;", "maxOf-R03FKyM", "(J[J)J", "Lkotlin/UByteArray;", "maxOf-Wr6uiD8", "(B[B)B", "Lkotlin/UShortArray;", "maxOf-t1qELG4", "(S[S)S", "minOf", "minOf-J1ME1BU", "minOf-eb3DHEI", "minOf-Kr8caGY", "minOf-5PvTz6A", "minOf-WZ9TVnA", "minOf-sambcqE", "minOf-b33U2AM", "minOf-VKSA0NQ", "minOf-Md2H83M", "minOf-R03FKyM", "minOf-Wr6uiD8", "minOf-t1qELG4", "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/comparisons/UComparisonsKt")
/* loaded from: classes.dex */
public class UComparisonsKt___UComparisonsKt {
    @SinceKotlin(m5061version = "1.5")
    /* renamed from: maxOf-5PvTz6A, reason: not valid java name */
    public static final short m19702maxOf5PvTz6A(short s, short s2) {
        return Intrinsics.m6319compare(s & 65535, 65535 & s2) >= 0 ? s : s2;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: maxOf-J1ME1BU, reason: not valid java name */
    public static int m19703maxOfJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) >= 0 ? i : i2;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: maxOf-Kr8caGY, reason: not valid java name */
    public static final byte m19704maxOfKr8caGY(byte b, byte b2) {
        return Intrinsics.m6319compare(b & C1126UByte.MAX_VALUE, b2 & C1126UByte.MAX_VALUE) >= 0 ? b : b2;
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Md2H83M, reason: not valid java name */
    public static final int m19705maxOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM18702getSizeimpl = UIntArray.m18702getSizeimpl(other);
        for (int i2 = 0; i2 < iM18702getSizeimpl; i2++) {
            i = UComparisonsKt.m19703maxOfJ1ME1BU(i, UIntArray.m18701getpVg5ArA(other, i2));
        }
        return i;
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-R03FKyM, reason: not valid java name */
    public static final long m19706maxOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM18781getSizeimpl = ULongArray.m18781getSizeimpl(other);
        for (int i = 0; i < iM18781getSizeimpl; i++) {
            j = UComparisonsKt.m19711maxOfeb3DHEI(j, ULongArray.m18780getsVKNKU(other, i));
        }
        return j;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: maxOf-VKSA0NQ, reason: not valid java name */
    private static final short m19707maxOfVKSA0NQ(short s, short s2, short s3) {
        return m19702maxOf5PvTz6A(s, m19702maxOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: maxOf-WZ9TVnA, reason: not valid java name */
    private static final int m19708maxOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m19703maxOfJ1ME1BU(i, UComparisonsKt.m19703maxOfJ1ME1BU(i2, i3));
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-Wr6uiD8, reason: not valid java name */
    public static final byte m19709maxOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM18623getSizeimpl = UByteArray.m18623getSizeimpl(other);
        for (int i = 0; i < iM18623getSizeimpl; i++) {
            b = m19704maxOfKr8caGY(b, UByteArray.m18622getw2LRezQ(other, i));
        }
        return b;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: maxOf-b33U2AM, reason: not valid java name */
    private static final byte m19710maxOfb33U2AM(byte b, byte b2, byte b3) {
        return m19704maxOfKr8caGY(b, m19704maxOfKr8caGY(b2, b3));
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: maxOf-eb3DHEI, reason: not valid java name */
    public static long m19711maxOfeb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) >= 0 ? j : j2;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: maxOf-sambcqE, reason: not valid java name */
    private static final long m19712maxOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m19711maxOfeb3DHEI(j, UComparisonsKt.m19711maxOfeb3DHEI(j2, j3));
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: maxOf-t1qELG4, reason: not valid java name */
    public static final short m19713maxOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM18886getSizeimpl = UShortArray.m18886getSizeimpl(other);
        for (int i = 0; i < iM18886getSizeimpl; i++) {
            s = m19702maxOf5PvTz6A(s, UShortArray.m18885getMh2AYeg(other, i));
        }
        return s;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: minOf-5PvTz6A, reason: not valid java name */
    public static final short m19714minOf5PvTz6A(short s, short s2) {
        return Intrinsics.m6319compare(s & 65535, 65535 & s2) <= 0 ? s : s2;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: minOf-J1ME1BU, reason: not valid java name */
    public static int m19715minOfJ1ME1BU(int i, int i2) {
        return Integer.compareUnsigned(i, i2) <= 0 ? i : i2;
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: minOf-Kr8caGY, reason: not valid java name */
    public static final byte m19716minOfKr8caGY(byte b, byte b2) {
        return Intrinsics.m6319compare(b & C1126UByte.MAX_VALUE, b2 & C1126UByte.MAX_VALUE) <= 0 ? b : b2;
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Md2H83M, reason: not valid java name */
    public static final int m19717minOfMd2H83M(int i, int... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM18702getSizeimpl = UIntArray.m18702getSizeimpl(other);
        for (int i2 = 0; i2 < iM18702getSizeimpl; i2++) {
            i = UComparisonsKt.m19715minOfJ1ME1BU(i, UIntArray.m18701getpVg5ArA(other, i2));
        }
        return i;
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-R03FKyM, reason: not valid java name */
    public static final long m19718minOfR03FKyM(long j, long... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM18781getSizeimpl = ULongArray.m18781getSizeimpl(other);
        for (int i = 0; i < iM18781getSizeimpl; i++) {
            j = UComparisonsKt.m19723minOfeb3DHEI(j, ULongArray.m18780getsVKNKU(other, i));
        }
        return j;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: minOf-VKSA0NQ, reason: not valid java name */
    private static final short m19719minOfVKSA0NQ(short s, short s2, short s3) {
        return m19714minOf5PvTz6A(s, m19714minOf5PvTz6A(s2, s3));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: minOf-WZ9TVnA, reason: not valid java name */
    private static final int m19720minOfWZ9TVnA(int i, int i2, int i3) {
        return UComparisonsKt.m19715minOfJ1ME1BU(i, UComparisonsKt.m19715minOfJ1ME1BU(i2, i3));
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-Wr6uiD8, reason: not valid java name */
    public static final byte m19721minOfWr6uiD8(byte b, byte... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM18623getSizeimpl = UByteArray.m18623getSizeimpl(other);
        for (int i = 0; i < iM18623getSizeimpl; i++) {
            b = m19716minOfKr8caGY(b, UByteArray.m18622getw2LRezQ(other, i));
        }
        return b;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: minOf-b33U2AM, reason: not valid java name */
    private static final byte m19722minOfb33U2AM(byte b, byte b2, byte b3) {
        return m19716minOfKr8caGY(b, m19716minOfKr8caGY(b2, b3));
    }

    @SinceKotlin(m5061version = "1.5")
    /* renamed from: minOf-eb3DHEI, reason: not valid java name */
    public static long m19723minOfeb3DHEI(long j, long j2) {
        return Long.compareUnsigned(j, j2) <= 0 ? j : j2;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: minOf-sambcqE, reason: not valid java name */
    private static final long m19724minOfsambcqE(long j, long j2, long j3) {
        return UComparisonsKt.m19723minOfeb3DHEI(j, UComparisonsKt.m19723minOfeb3DHEI(j2, j3));
    }

    @SinceKotlin(m5061version = "1.4")
    @ExperimentalUnsignedTypes
    /* renamed from: minOf-t1qELG4, reason: not valid java name */
    public static final short m19725minOft1qELG4(short s, short... other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int iM18886getSizeimpl = UShortArray.m18886getSizeimpl(other);
        for (int i = 0; i < iM18886getSizeimpl; i++) {
            s = m19714minOf5PvTz6A(s, UShortArray.m18885getMh2AYeg(other, i));
        }
        return s;
    }
}
