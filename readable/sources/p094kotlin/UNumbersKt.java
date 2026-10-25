package p094kotlin;

import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;
import p094kotlin.p105jvm.InterfaceC1231JvmName;

@Metadata(m4987d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u0003\u0010\u0004\u001a'\u0010\t\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\n\u0010\u0004\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\f\u0010\u0004\u001a'\u0010\r\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u000e\u0010\u0004\u001a'\u0010\u000f\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u0010\u0010\u0004\u001a/\u0010\u0011\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a/\u0010\u0016\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b\u0017\u0010\u0014\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u0019\u0010\u001a\u001a'\u0010\t\u001a\u00020\u0001*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001b\u0010\u001a\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001c\u0010\u001a\u001a'\u0010\r\u001a\u00020\u0018*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001d\u0010\u001e\u001a'\u0010\u000f\u001a\u00020\u0018*\u00020\u0018H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b\u001f\u0010\u001e\u001a/\u0010\u0011\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b \u0010!\u001a/\u0010\u0016\u001a\u00020\u0018*\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b\"\u0010!\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b$\u0010%\u001a'\u0010\t\u001a\u00020\u0001*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b&\u0010%\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b'\u0010%\u001a'\u0010\r\u001a\u00020#*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b(\u0010)\u001a'\u0010\u000f\u001a\u00020#*\u00020#H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b*\u0010)\u001a/\u0010\u0011\u001a\u00020#*\u00020#2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b+\u0010,\u001a/\u0010\u0016\u001a\u00020#*\u00020#2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b-\u0010,\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b/\u00100\u001a'\u0010\t\u001a\u00020\u0001*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b1\u00100\u001a'\u0010\u000b\u001a\u00020\u0001*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b2\u00100\u001a'\u0010\r\u001a\u00020.*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b3\u00104\u001a'\u0010\u000f\u001a\u00020.*\u00020.H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\b¢\u0006\u0004\b5\u00104\u001a/\u0010\u0011\u001a\u00020.*\u00020.2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b6\u00107\u001a/\u0010\u0016\u001a\u00020.*\u00020.2\u0006\u0010\u0012\u001a\u00020\u0001H\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0015b\u0002\b\b¢\u0006\u0004\b8\u00107¨\u00069"}, m4988d2 = {"countOneBits", BuildConfig.f24315FLAVOR, "Lkotlin/UInt;", "countOneBits-WZ4Q5Ns", "(I)I", "Lkotlin/SinceKotlin;", "version", "1.5", "Lkotlin/internal/InlineOnly;", "countLeadingZeroBits", "countLeadingZeroBits-WZ4Q5Ns", "countTrailingZeroBits", "countTrailingZeroBits-WZ4Q5Ns", "takeHighestOneBit", "takeHighestOneBit-WZ4Q5Ns", "takeLowestOneBit", "takeLowestOneBit-WZ4Q5Ns", "rotateLeft", "bitCount", "rotateLeft-V7xB4Y4", "(II)I", "1.6", "rotateRight", "rotateRight-V7xB4Y4", "Lkotlin/ULong;", "countOneBits-VKZWuLQ", "(J)I", "countLeadingZeroBits-VKZWuLQ", "countTrailingZeroBits-VKZWuLQ", "takeHighestOneBit-VKZWuLQ", "(J)J", "takeLowestOneBit-VKZWuLQ", "rotateLeft-JSWoG40", "(JI)J", "rotateRight-JSWoG40", "Lkotlin/UByte;", "countOneBits-7apg3OU", "(B)I", "countLeadingZeroBits-7apg3OU", "countTrailingZeroBits-7apg3OU", "takeHighestOneBit-7apg3OU", "(B)B", "takeLowestOneBit-7apg3OU", "rotateLeft-LxnNnR4", "(BI)B", "rotateRight-LxnNnR4", "Lkotlin/UShort;", "countOneBits-xj2QHRw", "(S)I", "countLeadingZeroBits-xj2QHRw", "countTrailingZeroBits-xj2QHRw", "takeHighestOneBit-xj2QHRw", "(S)S", "takeLowestOneBit-xj2QHRw", "rotateLeft-olVBNx4", "(SI)S", "rotateRight-olVBNx4", "kotlin-stdlib"}, m4989k = 2, m4990mv = {2, 4, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "UNumbersKt")
/* loaded from: classes.dex */
public final class UNumbersKt {
    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countLeadingZeroBits-7apg3OU, reason: not valid java name */
    private static final int m18792countLeadingZeroBits7apg3OU(byte b) {
        return Integer.numberOfLeadingZeros(b & C1126UByte.MAX_VALUE) - 24;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countLeadingZeroBits-VKZWuLQ, reason: not valid java name */
    private static final int m18793countLeadingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfLeadingZeros(j);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countLeadingZeroBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m18794countLeadingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfLeadingZeros(i);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countLeadingZeroBits-xj2QHRw, reason: not valid java name */
    private static final int m18795countLeadingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfLeadingZeros(s & 65535) - 16;
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countOneBits-7apg3OU, reason: not valid java name */
    private static final int m18796countOneBits7apg3OU(byte b) {
        return Integer.bitCount(C1128UInt.m18641constructorimpl(b & C1126UByte.MAX_VALUE));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countOneBits-VKZWuLQ, reason: not valid java name */
    private static final int m18797countOneBitsVKZWuLQ(long j) {
        return Long.bitCount(j);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countOneBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m18798countOneBitsWZ4Q5Ns(int i) {
        return Integer.bitCount(i);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countOneBits-xj2QHRw, reason: not valid java name */
    private static final int m18799countOneBitsxj2QHRw(short s) {
        return Integer.bitCount(C1128UInt.m18641constructorimpl(s & 65535));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countTrailingZeroBits-7apg3OU, reason: not valid java name */
    private static final int m18800countTrailingZeroBits7apg3OU(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countTrailingZeroBits-VKZWuLQ, reason: not valid java name */
    private static final int m18801countTrailingZeroBitsVKZWuLQ(long j) {
        return Long.numberOfTrailingZeros(j);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countTrailingZeroBits-WZ4Q5Ns, reason: not valid java name */
    private static final int m18802countTrailingZeroBitsWZ4Q5Ns(int i) {
        return Integer.numberOfTrailingZeros(i);
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: countTrailingZeroBits-xj2QHRw, reason: not valid java name */
    private static final int m18803countTrailingZeroBitsxj2QHRw(short s) {
        return Integer.numberOfTrailingZeros(s | C1132UShort.MIN_VALUE);
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    /* renamed from: rotateLeft-JSWoG40, reason: not valid java name */
    private static final long m18804rotateLeftJSWoG40(long j, int i) {
        return C1130ULong.m18720constructorimpl(Long.rotateLeft(j, i));
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    /* renamed from: rotateLeft-LxnNnR4, reason: not valid java name */
    private static final byte m18805rotateLeftLxnNnR4(byte b, int i) {
        return C1126UByte.m18564constructorimpl(NumbersKt__NumbersKt.rotateLeft(b, i));
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    /* renamed from: rotateLeft-V7xB4Y4, reason: not valid java name */
    private static final int m18806rotateLeftV7xB4Y4(int i, int i2) {
        return C1128UInt.m18641constructorimpl(Integer.rotateLeft(i, i2));
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    /* renamed from: rotateLeft-olVBNx4, reason: not valid java name */
    private static final short m18807rotateLeftolVBNx4(short s, int i) {
        return C1132UShort.m18827constructorimpl(NumbersKt__NumbersKt.rotateLeft(s, i));
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    /* renamed from: rotateRight-JSWoG40, reason: not valid java name */
    private static final long m18808rotateRightJSWoG40(long j, int i) {
        return C1130ULong.m18720constructorimpl(Long.rotateRight(j, i));
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    /* renamed from: rotateRight-LxnNnR4, reason: not valid java name */
    private static final byte m18809rotateRightLxnNnR4(byte b, int i) {
        return C1126UByte.m18564constructorimpl(NumbersKt__NumbersKt.rotateRight(b, i));
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    /* renamed from: rotateRight-V7xB4Y4, reason: not valid java name */
    private static final int m18810rotateRightV7xB4Y4(int i, int i2) {
        return C1128UInt.m18641constructorimpl(Integer.rotateRight(i, i2));
    }

    @SinceKotlin(m5061version = "1.6")
    @InlineOnly
    /* renamed from: rotateRight-olVBNx4, reason: not valid java name */
    private static final short m18811rotateRightolVBNx4(short s, int i) {
        return C1132UShort.m18827constructorimpl(NumbersKt__NumbersKt.rotateRight(s, i));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: takeHighestOneBit-7apg3OU, reason: not valid java name */
    private static final byte m18812takeHighestOneBit7apg3OU(byte b) {
        return C1126UByte.m18564constructorimpl((byte) Integer.highestOneBit(b & C1126UByte.MAX_VALUE));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: takeHighestOneBit-VKZWuLQ, reason: not valid java name */
    private static final long m18813takeHighestOneBitVKZWuLQ(long j) {
        return C1130ULong.m18720constructorimpl(Long.highestOneBit(j));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: takeHighestOneBit-WZ4Q5Ns, reason: not valid java name */
    private static final int m18814takeHighestOneBitWZ4Q5Ns(int i) {
        return C1128UInt.m18641constructorimpl(Integer.highestOneBit(i));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: takeHighestOneBit-xj2QHRw, reason: not valid java name */
    private static final short m18815takeHighestOneBitxj2QHRw(short s) {
        return C1132UShort.m18827constructorimpl((short) Integer.highestOneBit(s & 65535));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: takeLowestOneBit-7apg3OU, reason: not valid java name */
    private static final byte m18816takeLowestOneBit7apg3OU(byte b) {
        return C1126UByte.m18564constructorimpl((byte) Integer.lowestOneBit(b & C1126UByte.MAX_VALUE));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: takeLowestOneBit-VKZWuLQ, reason: not valid java name */
    private static final long m18817takeLowestOneBitVKZWuLQ(long j) {
        return C1130ULong.m18720constructorimpl(Long.lowestOneBit(j));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: takeLowestOneBit-WZ4Q5Ns, reason: not valid java name */
    private static final int m18818takeLowestOneBitWZ4Q5Ns(int i) {
        return C1128UInt.m18641constructorimpl(Integer.lowestOneBit(i));
    }

    @SinceKotlin(m5061version = "1.5")
    @InlineOnly
    /* renamed from: takeLowestOneBit-xj2QHRw, reason: not valid java name */
    private static final short m18819takeLowestOneBitxj2QHRw(short s) {
        return C1132UShort.m18827constructorimpl((short) Integer.lowestOneBit(s & 65535));
    }
}
