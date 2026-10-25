package p094kotlin;

import org.bouncycastle.p194crypto.p199digests.Blake2xsDigest;
import org.conscrypt.BuildConfig;
import p094kotlin.internal.InlineOnly;

@Metadata(m4987d1 = {"\u0000 \n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\n\n\u0000\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\b\u001a\u00020\u0001*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\t\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\n\u001a\u00020\u0002*\u00020\u0002H\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u000b\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u001a$\u0010\u000e\u001a\u00020\u0002*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\u0007\u001a\u00020\u0001*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\b\u001a\u00020\u0001*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\t\u001a\u00020\u000f*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a \u0010\n\u001a\u00020\u000f*\u00020\u000fH\u0087\u0088\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005b\u0002\b\u0006\u001a$\u0010\u000b\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r\u001a$\u0010\u000e\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010\f\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\r¨\u0006\u0010"}, m4988d2 = {"countOneBits", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "Lkotlin/SinceKotlin;", "version", "1.4", "Lkotlin/internal/InlineOnly;", "countLeadingZeroBits", "countTrailingZeroBits", "takeHighestOneBit", "takeLowestOneBit", "rotateLeft", "bitCount", "1.6", "rotateRight", BuildConfig.f24315FLAVOR, "kotlin-stdlib"}, m4989k = 5, m4990mv = {2, 4, 0}, m4992xi = 49, m4993xs = "kotlin/NumbersKt")
/* loaded from: classes.dex */
class NumbersKt__NumbersKt extends NumbersKt__NumbersJVMKt {
    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final int countLeadingZeroBits(byte b) {
        return Integer.numberOfLeadingZeros(b & C1126UByte.MAX_VALUE) - 24;
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final int countOneBits(byte b) {
        return Integer.bitCount(b & C1126UByte.MAX_VALUE);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final int countTrailingZeroBits(byte b) {
        return Integer.numberOfTrailingZeros(b | 256);
    }

    @SinceKotlin(m5061version = "1.6")
    public static final byte rotateLeft(byte b, int i) {
        int i2 = i & 7;
        return (byte) (((b & 255) >>> (8 - i2)) | (b << i2));
    }

    @SinceKotlin(m5061version = "1.6")
    public static final byte rotateRight(byte b, int i) {
        int i2 = i & 7;
        return (byte) (((b & 255) >>> i2) | (b << (8 - i2)));
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final byte takeHighestOneBit(byte b) {
        return (byte) Integer.highestOneBit(b & C1126UByte.MAX_VALUE);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final byte takeLowestOneBit(byte b) {
        return (byte) Integer.lowestOneBit(b);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final int countLeadingZeroBits(short s) {
        return Integer.numberOfLeadingZeros(s & 65535) - 16;
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final int countOneBits(short s) {
        return Integer.bitCount(s & 65535);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final int countTrailingZeroBits(short s) {
        return Integer.numberOfTrailingZeros(s | C1132UShort.MIN_VALUE);
    }

    @SinceKotlin(m5061version = "1.6")
    public static final short rotateLeft(short s, int i) {
        int i2 = i & 15;
        return (short) (((s & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >>> (16 - i2)) | (s << i2));
    }

    @SinceKotlin(m5061version = "1.6")
    public static final short rotateRight(short s, int i) {
        int i2 = i & 15;
        return (short) (((s & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) >>> i2) | (s << (16 - i2)));
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final short takeHighestOneBit(short s) {
        return (short) Integer.highestOneBit(s & 65535);
    }

    @SinceKotlin(m5061version = "1.4")
    @InlineOnly
    private static final short takeLowestOneBit(short s) {
        return (short) Integer.lowestOneBit(s);
    }
}
