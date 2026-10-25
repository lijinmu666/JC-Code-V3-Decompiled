package com.p038google.p061crypto.p062tink.p075subtle;

import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.SeekableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesGcmHkdfStreaming extends NonceBasedStreamingAead {
    private static final int NONCE_PREFIX_IN_BYTES = 7;
    private static final int NONCE_SIZE_IN_BYTES = 12;
    private static final int TAG_SIZE_IN_BYTES = 16;
    private final int ciphertextSegmentSize;
    private final int firstSegmentOffset;

    /* renamed from: hkdfAlg */
    private final String f3898hkdfAlg;

    /* renamed from: ikm */
    private final byte[] f3899ikm;
    private final int keySizeInBytes;
    private final int plaintextSegmentSize;

    public class AesGcmHkdfStreamDecrypter implements StreamSegmentDecrypter {

        /* renamed from: cipher */
        private Cipher f3900cipher;

        /* renamed from: keySpec */
        private SecretKeySpec f3901keySpec;
        private byte[] noncePrefix;

        public AesGcmHkdfStreamDecrypter() {
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.StreamSegmentDecrypter
        public synchronized void decryptSegment(ByteBuffer byteBuffer, int i, boolean z, ByteBuffer byteBuffer2) {
            this.f3900cipher.init(2, this.f3901keySpec, AesGcmHkdfStreaming.paramsForSegment(this.noncePrefix, i, z));
            this.f3900cipher.doFinal(byteBuffer, byteBuffer2);
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.StreamSegmentDecrypter
        /* renamed from: init */
        public synchronized void mo4213init(ByteBuffer byteBuffer, byte[] bArr) {
            if (byteBuffer.remaining() != AesGcmHkdfStreaming.this.getHeaderLength()) {
                throw new InvalidAlgorithmParameterException("Invalid header length");
            }
            if (byteBuffer.get() != AesGcmHkdfStreaming.this.getHeaderLength()) {
                throw new GeneralSecurityException("Invalid ciphertext");
            }
            this.noncePrefix = new byte[7];
            byte[] bArr2 = new byte[AesGcmHkdfStreaming.this.keySizeInBytes];
            byteBuffer.get(bArr2);
            byteBuffer.get(this.noncePrefix);
            this.f3901keySpec = AesGcmHkdfStreaming.this.deriveKeySpec(bArr2, bArr);
            this.f3900cipher = AesGcmHkdfStreaming.cipherInstance();
        }
    }

    public AesGcmHkdfStreaming(byte[] bArr, String str, int i, int i2, int i3) throws InvalidAlgorithmParameterException {
        if (bArr.length < 16 || bArr.length < i) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i));
        }
        Validators.validateAesKeySize(i);
        if (i2 <= getHeaderLength() + i3 + 16) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
        this.f3899ikm = Arrays.copyOf(bArr, bArr.length);
        this.f3898hkdfAlg = str;
        this.keySizeInBytes = i;
        this.ciphertextSegmentSize = i2;
        this.firstSegmentOffset = i3;
        this.plaintextSegmentSize = i2 - 16;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher cipherInstance() {
        return EngineFactory.f3961CIPHER.getInstance("AES/GCM/NoPadding");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec deriveKeySpec(byte[] bArr, byte[] bArr2) {
        return new SecretKeySpec(C0866Hkdf.computeHkdf(this.f3898hkdfAlg, this.f3899ikm, bArr, bArr2, this.keySizeInBytes), "AES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static GCMParameterSpec paramsForSegment(byte[] bArr, long j, boolean z) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(12);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(bArr);
        SubtleUtil.putAsUnsigedInt(byteBufferAllocate, j);
        byteBufferAllocate.put(z ? (byte) 1 : (byte) 0);
        return new GCMParameterSpec(128, byteBufferAllocate.array());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] randomNonce() {
        return C0870Random.randBytes(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] randomSalt() {
        return C0870Random.randBytes(this.keySizeInBytes);
    }

    public long expectedCiphertextSize(long j) {
        long ciphertextOffset = j + getCiphertextOffset();
        int i = this.plaintextSegmentSize;
        long j2 = (ciphertextOffset / i) * this.ciphertextSegmentSize;
        long j3 = ciphertextOffset % i;
        return j3 > 0 ? j2 + j3 + 16 : j2;
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead
    public int getCiphertextOffset() {
        return getHeaderLength() + this.firstSegmentOffset;
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead
    public int getCiphertextOverhead() {
        return 16;
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead
    public int getCiphertextSegmentSize() {
        return this.ciphertextSegmentSize;
    }

    public int getFirstSegmentOffset() {
        return this.firstSegmentOffset;
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead
    public int getHeaderLength() {
        return this.keySizeInBytes + 8;
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead
    public int getPlaintextSegmentSize() {
        return this.plaintextSegmentSize;
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead, com.p038google.p061crypto.p062tink.StreamingAead
    public /* bridge */ /* synthetic */ ReadableByteChannel newDecryptingChannel(ReadableByteChannel readableByteChannel, byte[] bArr) {
        return super.newDecryptingChannel(readableByteChannel, bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead, com.p038google.p061crypto.p062tink.StreamingAead
    public /* bridge */ /* synthetic */ InputStream newDecryptingStream(InputStream inputStream, byte[] bArr) {
        return super.newDecryptingStream(inputStream, bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead, com.p038google.p061crypto.p062tink.StreamingAead
    public /* bridge */ /* synthetic */ WritableByteChannel newEncryptingChannel(WritableByteChannel writableByteChannel, byte[] bArr) {
        return super.newEncryptingChannel(writableByteChannel, bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead, com.p038google.p061crypto.p062tink.StreamingAead
    public /* bridge */ /* synthetic */ OutputStream newEncryptingStream(OutputStream outputStream, byte[] bArr) {
        return super.newEncryptingStream(outputStream, bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead, com.p038google.p061crypto.p062tink.StreamingAead
    public /* bridge */ /* synthetic */ SeekableByteChannel newSeekableDecryptingChannel(SeekableByteChannel seekableByteChannel, byte[] bArr) {
        return super.newSeekableDecryptingChannel(seekableByteChannel, bArr);
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead
    public AesGcmHkdfStreamDecrypter newStreamSegmentDecrypter() {
        return new AesGcmHkdfStreamDecrypter();
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead
    public AesGcmHkdfStreamEncrypter newStreamSegmentEncrypter(byte[] bArr) {
        return new AesGcmHkdfStreamEncrypter(bArr);
    }

    public class AesGcmHkdfStreamEncrypter implements StreamSegmentEncrypter {

        /* renamed from: cipher */
        private final Cipher f3903cipher = AesGcmHkdfStreaming.cipherInstance();
        private long encryptedSegments;

        /* renamed from: header */
        private final ByteBuffer f3904header;

        /* renamed from: keySpec */
        private final SecretKeySpec f3905keySpec;
        private final byte[] noncePrefix;

        public AesGcmHkdfStreamEncrypter(byte[] bArr) {
            this.encryptedSegments = 0L;
            this.encryptedSegments = 0L;
            byte[] bArrRandomSalt = AesGcmHkdfStreaming.this.randomSalt();
            byte[] bArrRandomNonce = AesGcmHkdfStreaming.randomNonce();
            this.noncePrefix = bArrRandomNonce;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(AesGcmHkdfStreaming.this.getHeaderLength());
            this.f3904header = byteBufferAllocate;
            byteBufferAllocate.put((byte) AesGcmHkdfStreaming.this.getHeaderLength());
            byteBufferAllocate.put(bArrRandomSalt);
            byteBufferAllocate.put(bArrRandomNonce);
            byteBufferAllocate.flip();
            this.f3905keySpec = AesGcmHkdfStreaming.this.deriveKeySpec(bArrRandomSalt, bArr);
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer byteBuffer, boolean z, ByteBuffer byteBuffer2) {
            this.f3903cipher.init(1, this.f3905keySpec, AesGcmHkdfStreaming.paramsForSegment(this.noncePrefix, this.encryptedSegments, z));
            this.encryptedSegments++;
            this.f3903cipher.doFinal(byteBuffer, byteBuffer2);
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.StreamSegmentEncrypter
        public ByteBuffer getHeader() {
            return this.f3904header.asReadOnlyBuffer();
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, ByteBuffer byteBuffer3) {
            try {
                this.f3903cipher.init(1, this.f3905keySpec, AesGcmHkdfStreaming.paramsForSegment(this.noncePrefix, this.encryptedSegments, z));
                this.encryptedSegments++;
                if (byteBuffer2.hasRemaining()) {
                    this.f3903cipher.update(byteBuffer, byteBuffer3);
                    this.f3903cipher.doFinal(byteBuffer2, byteBuffer3);
                } else {
                    this.f3903cipher.doFinal(byteBuffer, byteBuffer3);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
