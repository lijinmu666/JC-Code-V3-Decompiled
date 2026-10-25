package com.flyfishxu.p028kadb.p029cert;

import com.flyfishxu.p028kadb.p033pair.PairingAuthCtxKt;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.interfaces.RSAPublicKey;
import java.util.Arrays;
import java.util.Objects;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p101io.CloseableKt;
import p094kotlin.p101io.encoding.C1217Base64;
import p094kotlin.p105jvm.JvmStatic;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.StringCompanionObject;
import p094kotlin.p117text.Charsets;
import p132okio.C5052Buffer;

@Metadata(m4987d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001c\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0007b\u0002\b\u0013J\u0014\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007b\u0002\b\u0015J\u000e\u0010\u0016\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J \u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0010\u0010\u001f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\tH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0017\u0010\b\u001a\u00020\t¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/AndroidPubkey;", BuildConfig.f24315FLAVOR, "<init>", "()V", "ANDROID_PUBKEY_MODULUS_SIZE", BuildConfig.f24315FLAVOR, "ANDROID_PUBKEY_ENCODED_SIZE", "ANDROID_PUBKEY_MODULUS_SIZE_WORDS", "SIGNATURE_PADDING", BuildConfig.f24315FLAVOR, "getSIGNATURE_PADDING$annotations", "getSIGNATURE_PADDING", "()[B", "RSA_SHA_PKCS1_SIGNATURE_PADDING", "encodeWithName", "publicKey", "Ljava/security/interfaces/RSAPublicKey;", "name", BuildConfig.f24315FLAVOR, "Lkotlin/jvm/JvmStatic;", "getUserInfo", "Lorg/jetbrains/annotations/VisibleForTesting;", "encode", "igbEndianToLittleEndianPadded", "len", "in", "Ljava/math/BigInteger;", "fitsInBytes", BuildConfig.f24315FLAVOR, "bytes", "numBytes", "swapEndianness", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class AndroidPubkey {
    private static final int ANDROID_PUBKEY_ENCODED_SIZE = 524;
    private static final int ANDROID_PUBKEY_MODULUS_SIZE = 256;
    private static final int ANDROID_PUBKEY_MODULUS_SIZE_WORDS = 64;
    public static final AndroidPubkey INSTANCE = new AndroidPubkey();
    private static final byte[] RSA_SHA_PKCS1_SIGNATURE_PADDING;
    private static final byte[] SIGNATURE_PADDING;

    static {
        byte[] bArrCopyOf = Arrays.copyOf(new byte[]{0, 1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 0, 48, 33, 48, 9, 6, 5, 43, 14, 3, 2, 26, 5, 0, 4, 20}, 236);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        SIGNATURE_PADDING = bArrCopyOf;
        byte[] bArr = new byte[bArrCopyOf.length];
        RSA_SHA_PKCS1_SIGNATURE_PADDING = bArr;
        int length = bArr.length;
        for (int i = 0; i < length; i++) {
            RSA_SHA_PKCS1_SIGNATURE_PADDING[i] = SIGNATURE_PADDING[i];
        }
    }

    private AndroidPubkey() {
    }

    @JvmStatic
    public static final byte[] encodeWithName(RSAPublicKey publicKey, String name) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        Intrinsics.checkNotNullParameter(name, "name");
        int iCeil = ((int) Math.ceil(174.66666666666666d)) * 4;
        C5052Buffer c5052Buffer = new C5052Buffer();
        try {
            C1217Base64.Companion companion = C1217Base64.INSTANCE;
            AndroidPubkey androidPubkey = INSTANCE;
            byte[] bytes = C1217Base64.encode$default(companion, androidPubkey.m2176encode(publicKey), 0, 0, 6, null).getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            c5052Buffer.mo14230write(bytes);
            C5052Buffer c5052BufferMo14230write = c5052Buffer.mo14230write(androidPubkey.getUserInfo(name));
            CloseableKt.closeFinally(c5052Buffer, null);
            return c5052BufferMo14230write.readByteArray(iCeil + name.length() + 2);
        } finally {
        }
    }

    private final boolean fitsInBytes(byte[] bytes, int numBytes, int len) {
        byte b = 0;
        while (len < numBytes) {
            b = (byte) (b | bytes[len]);
            len++;
        }
        return b == 0;
    }

    public static /* synthetic */ void getSIGNATURE_PADDING$annotations() {
    }

    private final byte[] igbEndianToLittleEndianPadded(int len, BigInteger in) {
        byte[] bArr = new byte[len];
        byte[] byteArray = in.toByteArray();
        Intrinsics.checkNotNullExpressionValue(byteArray, "toByteArray(...)");
        byte[] bArrSwapEndianness = swapEndianness(byteArray);
        int length = bArrSwapEndianness.length;
        if (len >= length) {
            len = length;
        } else if (!fitsInBytes(bArrSwapEndianness, length, len)) {
            return null;
        }
        System.arraycopy(bArrSwapEndianness, 0, bArr, 0, len);
        return bArr;
    }

    private final byte[] swapEndianness(byte[] bytes) {
        int length = bytes.length;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            bArr[i] = bytes[(length - i) - 1];
        }
        return bArr;
    }

    /* renamed from: encode */
    public final byte[] m2176encode(RSAPublicKey publicKey) throws InvalidKeyException {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        if (publicKey.getModulus().toByteArray().length < 256) {
            throw new InvalidKeyException("Invalid key length " + publicKey.getModulus().toByteArray().length);
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(ANDROID_PUBKEY_ENCODED_SIZE).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.putInt(64);
        BigInteger bigInteger = BigInteger.ZERO;
        BigInteger bit = bigInteger.setBit(32);
        Intrinsics.checkNotNullExpressionValue(bit, "setBit(...)");
        BigInteger bigIntegerMod = publicKey.getModulus().mod(bit);
        Intrinsics.checkNotNullExpressionValue(bigIntegerMod, "mod(...)");
        BigInteger bigIntegerModInverse = bigIntegerMod.modInverse(bit);
        Intrinsics.checkNotNullExpressionValue(bigIntegerModInverse, "modInverse(...)");
        BigInteger bigIntegerSubtract = bit.subtract(bigIntegerModInverse);
        Intrinsics.checkNotNullExpressionValue(bigIntegerSubtract, "subtract(...)");
        byteBufferOrder.putInt(bigIntegerSubtract.intValue());
        BigInteger modulus = publicKey.getModulus();
        Intrinsics.checkNotNullExpressionValue(modulus, "getModulus(...)");
        byte[] bArrIgbEndianToLittleEndianPadded = igbEndianToLittleEndianPadded(256, modulus);
        Objects.requireNonNull(bArrIgbEndianToLittleEndianPadded);
        byteBufferOrder.put(bArrIgbEndianToLittleEndianPadded);
        BigInteger bit2 = bigInteger.setBit(2048);
        Intrinsics.checkNotNullExpressionValue(bit2, "setBit(...)");
        BigInteger bigIntegerModPow = bit2.modPow(BigInteger.valueOf(2L), publicKey.getModulus());
        Intrinsics.checkNotNullExpressionValue(bigIntegerModPow, "modPow(...)");
        byte[] bArrIgbEndianToLittleEndianPadded2 = igbEndianToLittleEndianPadded(256, bigIntegerModPow);
        Objects.requireNonNull(bArrIgbEndianToLittleEndianPadded2);
        byteBufferOrder.put(bArrIgbEndianToLittleEndianPadded2);
        byteBufferOrder.putInt(publicKey.getPublicExponent().intValue());
        byte[] bArrArray = byteBufferOrder.array();
        Intrinsics.checkNotNullExpressionValue(bArrArray, "array(...)");
        return bArrArray;
    }

    public final byte[] getSIGNATURE_PADDING() {
        return SIGNATURE_PADDING;
    }

    public final byte[] getUserInfo(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format(" %s\u0000", Arrays.copyOf(new Object[]{name}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return PairingAuthCtxKt.getBytes(str, "UTF-8");
    }
}
