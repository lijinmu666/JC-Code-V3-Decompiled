package org.bouncycastle.p194crypto.p221util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JournalingSecureRandom extends SecureRandom {
    private static byte[] EMPTY_TRANSCRIPT = new byte[0];

    /* renamed from: base */
    private final SecureRandom f21121base;

    /* renamed from: index */
    private int f21122index;

    /* renamed from: tOut */
    private TranscriptStream f21123tOut;
    private byte[] transcript;

    public static class TranscriptStream extends ByteArrayOutputStream {
        private TranscriptStream() {
        }

        /* renamed from: clear */
        public void m15927clear() {
            C6238Arrays.m18249fill(((ByteArrayOutputStream) this).buf, (byte) 0);
        }
    }

    public JournalingSecureRandom() {
        this(CryptoServicesRegistrar.getSecureRandom());
    }

    /* renamed from: clear */
    public void m15925clear() {
        C6238Arrays.m18249fill(this.transcript, (byte) 0);
        this.f21123tOut.m15927clear();
    }

    public byte[] getFullTranscript() {
        int i = this.f21122index;
        byte[] bArr = this.transcript;
        return i == bArr.length ? this.f21123tOut.toByteArray() : C6238Arrays.m18231clone(bArr);
    }

    public byte[] getTranscript() {
        return this.f21123tOut.toByteArray();
    }

    @Override // java.security.SecureRandom, java.util.Random
    public final void nextBytes(byte[] bArr) throws IOException {
        if (this.f21122index >= this.transcript.length) {
            this.f21121base.nextBytes(bArr);
        } else {
            int i = 0;
            while (i != bArr.length) {
                int i2 = this.f21122index;
                byte[] bArr2 = this.transcript;
                if (i2 >= bArr2.length) {
                    break;
                }
                this.f21122index = i2 + 1;
                bArr[i] = bArr2[i2];
                i++;
            }
            if (i != bArr.length) {
                int length = bArr.length - i;
                byte[] bArr3 = new byte[length];
                this.f21121base.nextBytes(bArr3);
                System.arraycopy(bArr3, 0, bArr, i, length);
            }
        }
        try {
            this.f21123tOut.write(bArr);
        } catch (IOException e) {
            throw new IllegalStateException("unable to record transcript: " + e.getMessage());
        }
    }

    /* renamed from: reset */
    public void m15926reset() {
        this.f21122index = 0;
        if (this.transcript.length == 0) {
            this.transcript = this.f21123tOut.toByteArray();
        }
        this.f21123tOut.reset();
    }

    public JournalingSecureRandom(SecureRandom secureRandom) {
        this.f21123tOut = new TranscriptStream();
        this.f21122index = 0;
        this.f21121base = secureRandom;
        this.transcript = EMPTY_TRANSCRIPT;
    }

    public JournalingSecureRandom(byte[] bArr, SecureRandom secureRandom) {
        this.f21123tOut = new TranscriptStream();
        this.f21122index = 0;
        this.f21121base = secureRandom;
        this.transcript = C6238Arrays.m18231clone(bArr);
    }
}
