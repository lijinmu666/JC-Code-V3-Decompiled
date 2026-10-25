package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import java.security.InvalidKeyException;
import java.util.Arrays;
import p094kotlin.p105jvm.internal.ByteCompanionObject;
import p132okio.C5066Utf8;

@InterfaceC0389Alpha
/* renamed from: com.google.crypto.tink.subtle.X25519 */
/* loaded from: classes.dex */
public final class C0874X25519 {
    private C0874X25519() {
    }

    public static byte[] computeSharedSecret(byte[] bArr, byte[] bArr2) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        long[] jArr = new long[11];
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 32);
        bArrCopyOf[0] = (byte) (bArrCopyOf[0] & 248);
        byte b = (byte) (bArrCopyOf[31] & ByteCompanionObject.MAX_VALUE);
        bArrCopyOf[31] = b;
        bArrCopyOf[31] = (byte) (b | 64);
        Curve25519.curveMult(jArr, bArrCopyOf, bArr2);
        return Field25519.contract(jArr);
    }

    public static byte[] generatePrivateKey() {
        byte[] bArrRandBytes = C0870Random.randBytes(32);
        bArrRandBytes[0] = (byte) (bArrRandBytes[0] | 7);
        byte b = (byte) (bArrRandBytes[31] & C5066Utf8.REPLACEMENT_BYTE);
        bArrRandBytes[31] = b;
        bArrRandBytes[31] = (byte) (b | ByteCompanionObject.MIN_VALUE);
        return bArrRandBytes;
    }

    public static byte[] publicFromPrivate(byte[] bArr) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("Private key must have 32 bytes.");
        }
        byte[] bArr2 = new byte[32];
        bArr2[0] = 9;
        return computeSharedSecret(bArr, bArr2);
    }
}
