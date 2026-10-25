package p132okio;

import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.InterfaceC1231JvmName;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p132okio.internal.ByteString;

@Metadata(m4987d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\u0007H\u0000\u001a\f\u0010\u0006\u001a\u00020\b*\u00020\bH\u0000\u001a\f\u0010\u0006\u001a\u00020\u0003*\u00020\u0003H\u0000\u001a\u0015\u0010\t\u001a\u00020\b*\u00020\b2\u0006\u0010\n\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\u000b\u001a\u00020\u0003*\u00020\u00032\u0006\u0010\n\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\f\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\u000f\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\u0010\u001a\u00020\b*\u00020\r2\u0006\u0010\u000e\u001a\u00020\bH\u0080\f\u001a\u0015\u0010\u0010\u001a\u00020\u0003*\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0003H\u0080\f\u001a\u0015\u0010\u0011\u001a\u00020\r*\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0080\f\u001a\u0015\u0010\u0010\u001a\u00020\u0003*\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0003H\u0080\f\u001a\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\bH\u0080\b\u001a\u0019\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0003H\u0080\b\u001a0\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0013\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bH\u0000\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\rH\u0000\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\bH\u0000\u001a\f\u0010\u001a\u001a\u00020\u001b*\u00020\u0003H\u0000¨\u0006\u001c"}, m4988d2 = {"checkOffsetAndCount", BuildConfig.f24315FLAVOR, "size", BuildConfig.f24315FLAVOR, "offset", "byteCount", "reverseBytes", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "leftRotate", "bitCount", "rightRotate", "shr", BuildConfig.f24315FLAVOR, "other", "shl", "and", "xor", "minOf", "a", "b", "arrayRangeEquals", BuildConfig.f24315FLAVOR, BuildConfig.f24315FLAVOR, "aOffset", "bOffset", "toHexString", BuildConfig.f24315FLAVOR, "okio"}, m4989k = 2, m4990mv = {2, 1, 0}, m4992xi = 48)
@InterfaceC1231JvmName(m6260name = "-SegmentedByteString")
@SourceDebugExtension(m6344value = {"SMAP\nUtil.kt\nKotlin\n*S Kotlin\n*F\n+ 1 Util.kt\nokio/-SegmentedByteString\n*L\n1#1,165:1\n69#1:166\n75#1:167\n*S KotlinDebug\n*F\n+ 1 Util.kt\nokio/-SegmentedByteString\n*L\n107#1:166\n108#1:167\n*E\n"})
/* renamed from: okio.-SegmentedByteString, reason: invalid class name */
/* loaded from: classes.dex */
public final class SegmentedByteString {
    /* renamed from: and */
    public static final int m14177and(byte b, int i) {
        return b & i;
    }

    public static final boolean arrayRangeEquals(byte[] a, int i, byte[] b, int i2, int i3) {
        Intrinsics.checkNotNullParameter(a, "a");
        Intrinsics.checkNotNullParameter(b, "b");
        for (int i4 = 0; i4 < i3; i4++) {
            if (a[i4 + i] != b[i4 + i2]) {
                return false;
            }
        }
        return true;
    }

    public static final void checkOffsetAndCount(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException("size=" + j + " offset=" + j2 + " byteCount=" + j3);
        }
    }

    public static final int leftRotate(int i, int i2) {
        return (i >>> (32 - i2)) | (i << i2);
    }

    /* renamed from: minOf */
    public static final long m14181minOf(long j, int i) {
        return Math.min(j, i);
    }

    public static final int reverseBytes(int i) {
        return ((i & 255) << 24) | (((-16777216) & i) >>> 24) | ((16711680 & i) >>> 8) | ((65280 & i) << 8);
    }

    public static final long rightRotate(long j, int i) {
        return (j << (64 - i)) | (j >>> i);
    }

    /* renamed from: shl */
    public static final int m14182shl(byte b, int i) {
        return b << i;
    }

    /* renamed from: shr */
    public static final int m14183shr(byte b, int i) {
        return b >> i;
    }

    public static final String toHexString(byte b) {
        return StringsKt.concatToString(new char[]{ByteString.getHEX_DIGIT_CHARS()[(b >> 4) & 15], ByteString.getHEX_DIGIT_CHARS()[b & 15]});
    }

    /* renamed from: xor */
    public static final byte m14184xor(byte b, byte b2) {
        return (byte) (b ^ b2);
    }

    /* renamed from: and */
    public static final long m14178and(byte b, long j) {
        return b & j;
    }

    /* renamed from: minOf */
    public static final long m14180minOf(int i, long j) {
        return Math.min(i, j);
    }

    public static final long reverseBytes(long j) {
        return ((j & 255) << 56) | (((-72057594037927936L) & j) >>> 56) | ((71776119061217280L & j) >>> 40) | ((280375465082880L & j) >>> 24) | ((1095216660480L & j) >>> 8) | ((4278190080L & j) << 8) | ((16711680 & j) << 24) | ((65280 & j) << 40);
    }

    /* renamed from: and */
    public static final long m14179and(int i, long j) {
        return i & j;
    }

    public static final short reverseBytes(short s) {
        return (short) (((s & 255) << 8) | ((65280 & s) >>> 8));
    }

    public static final String toHexString(int i) {
        int i2 = 0;
        if (i == 0) {
            return "0";
        }
        char[] cArr = {ByteString.getHEX_DIGIT_CHARS()[(i >> 28) & 15], ByteString.getHEX_DIGIT_CHARS()[(i >> 24) & 15], ByteString.getHEX_DIGIT_CHARS()[(i >> 20) & 15], ByteString.getHEX_DIGIT_CHARS()[(i >> 16) & 15], ByteString.getHEX_DIGIT_CHARS()[(i >> 12) & 15], ByteString.getHEX_DIGIT_CHARS()[(i >> 8) & 15], ByteString.getHEX_DIGIT_CHARS()[(i >> 4) & 15], ByteString.getHEX_DIGIT_CHARS()[i & 15]};
        while (i2 < 8 && cArr[i2] == '0') {
            i2++;
        }
        return StringsKt.concatToString(cArr, i2, 8);
    }

    public static final String toHexString(long j) {
        if (j == 0) {
            return "0";
        }
        char[] cArr = {ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 60) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 56) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 52) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 48) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 44) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 40) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 36) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 32) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 28) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 24) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 20) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 16) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 12) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 8) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) ((j >> 4) & 15)], ByteString.getHEX_DIGIT_CHARS()[(int) (j & 15)]};
        int i = 0;
        while (i < 16 && cArr[i] == '0') {
            i++;
        }
        return StringsKt.concatToString(cArr, i, 16);
    }
}
