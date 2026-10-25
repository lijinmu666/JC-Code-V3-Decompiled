package com.p038google.p061crypto.p062tink.p071mac.internal;

import java.util.Arrays;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* renamed from: com.google.crypto.tink.mac.internal.AesUtil */
/* loaded from: classes.dex */
public final class C0478AesUtil {
    public static final int BLOCK_SIZE = 16;

    private C0478AesUtil() {
    }

    /* renamed from: cmacPad */
    public static byte[] m3530cmacPad(byte[] bArr) {
        if (bArr.length >= 16) {
            throw new IllegalArgumentException("x must be smaller than a block.");
        }
        byte[] bArrCopyOf = Arrays.copyOf(bArr, 16);
        bArrCopyOf[bArr.length] = ByteCompanionObject.MIN_VALUE;
        return bArrCopyOf;
    }

    /* renamed from: dbl */
    public static byte[] m3531dbl(byte[] bArr) {
        if (bArr.length != 16) {
            throw new IllegalArgumentException("value must be a block.");
        }
        byte[] bArr2 = new byte[16];
        for (int i = 0; i < 16; i++) {
            byte b = (byte) ((bArr[i] << 1) & 254);
            bArr2[i] = b;
            if (i < 15) {
                bArr2[i] = (byte) (((byte) ((bArr[i + 1] >> 7) & 1)) | b);
            }
        }
        bArr2[15] = (byte) (((byte) ((bArr[0] >> 7) & 135)) ^ bArr2[15]);
        return bArr2;
    }
}
