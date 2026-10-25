package com.p038google.p061crypto.p062tink.p063aead.internal;

import com.p038google.p061crypto.p062tink.p075subtle.C0853Bytes;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

/* loaded from: classes.dex */
abstract class InsecureNonceChaCha20Base {
    private final int initialCounter;

    /* renamed from: key */
    int[] f3063key;

    public InsecureNonceChaCha20Base(byte[] bArr, int i) throws InvalidKeyException {
        if (bArr.length != 32) {
            throw new InvalidKeyException("The key length in bytes must be 32.");
        }
        this.f3063key = ChaCha20Util.toIntArray(bArr);
        this.initialCounter = i;
    }

    /* renamed from: process */
    private void m3446process(byte[] bArr, ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws GeneralSecurityException {
        if (bArr.length != nonceSizeInBytes()) {
            throw new GeneralSecurityException("The nonce length (in bytes) must be " + nonceSizeInBytes());
        }
        int iRemaining = byteBuffer2.remaining();
        int i = iRemaining / 64;
        int i2 = i + 1;
        for (int i3 = 0; i3 < i2; i3++) {
            ByteBuffer byteBufferChacha20Block = chacha20Block(bArr, this.initialCounter + i3);
            if (i3 == i) {
                C0853Bytes.m4231xor(byteBuffer, byteBuffer2, byteBufferChacha20Block, iRemaining % 64);
            } else {
                C0853Bytes.m4231xor(byteBuffer, byteBuffer2, byteBufferChacha20Block, 64);
            }
        }
    }

    public ByteBuffer chacha20Block(byte[] bArr, int i) {
        int[] iArrCreateInitialState = createInitialState(ChaCha20Util.toIntArray(bArr), i);
        int[] iArr = (int[]) iArrCreateInitialState.clone();
        ChaCha20Util.shuffleState(iArr);
        for (int i2 = 0; i2 < iArrCreateInitialState.length; i2++) {
            iArrCreateInitialState[i2] = iArrCreateInitialState[i2] + iArr[i2];
        }
        ByteBuffer byteBufferOrder = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        byteBufferOrder.asIntBuffer().put(iArrCreateInitialState, 0, 16);
        return byteBufferOrder;
    }

    public abstract int[] createInitialState(int[] iArr, int i);

    /* renamed from: decrypt */
    public byte[] mo3443decrypt(byte[] bArr, byte[] bArr2) {
        return mo3442decrypt(bArr, ByteBuffer.wrap(bArr2));
    }

    /* renamed from: encrypt */
    public byte[] mo3445encrypt(byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr2.length);
        mo3444encrypt(byteBufferAllocate, bArr, bArr2);
        return byteBufferAllocate.array();
    }

    public abstract int nonceSizeInBytes();

    /* renamed from: decrypt */
    public byte[] mo3442decrypt(byte[] bArr, ByteBuffer byteBuffer) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(byteBuffer.remaining());
        m3446process(bArr, byteBufferAllocate, byteBuffer);
        return byteBufferAllocate.array();
    }

    /* renamed from: encrypt */
    public void mo3444encrypt(ByteBuffer byteBuffer, byte[] bArr, byte[] bArr2) throws GeneralSecurityException {
        if (byteBuffer.remaining() >= bArr2.length) {
            m3446process(bArr, byteBuffer, ByteBuffer.wrap(bArr2));
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }
}
