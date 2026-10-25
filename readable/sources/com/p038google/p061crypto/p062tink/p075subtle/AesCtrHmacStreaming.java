package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
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
import javax.crypto.Mac;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* loaded from: classes.dex */
public final class AesCtrHmacStreaming extends NonceBasedStreamingAead {

    /* renamed from: FIPS */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f3879FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    private static final int HMAC_KEY_SIZE_IN_BYTES = 32;
    private static final int NONCE_PREFIX_IN_BYTES = 7;
    private static final int NONCE_SIZE_IN_BYTES = 16;
    private final int ciphertextSegmentSize;
    private final int firstSegmentOffset;
    private final String hkdfAlgo;

    /* renamed from: ikm */
    private final byte[] f3880ikm;
    private final int keySizeInBytes;
    private final int plaintextSegmentSize;

    /* renamed from: tagAlgo */
    private final String f3881tagAlgo;
    private final int tagSizeInBytes;

    public class AesCtrHmacStreamDecrypter implements StreamSegmentDecrypter {
        static final /* synthetic */ boolean $assertionsDisabled = false;

        /* renamed from: cipher */
        private Cipher f3882cipher;
        private SecretKeySpec hmacKeySpec;

        /* renamed from: keySpec */
        private SecretKeySpec f3883keySpec;

        /* renamed from: mac */
        private Mac f3884mac;
        private byte[] noncePrefix;

        public AesCtrHmacStreamDecrypter() {
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.StreamSegmentDecrypter
        public synchronized void decryptSegment(ByteBuffer byteBuffer, int i, boolean z, ByteBuffer byteBuffer2) {
            int iPosition = byteBuffer.position();
            byte[] bArrNonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, i, z);
            int iRemaining = byteBuffer.remaining();
            if (iRemaining < AesCtrHmacStreaming.this.tagSizeInBytes) {
                throw new GeneralSecurityException("Ciphertext too short");
            }
            int i2 = iPosition + (iRemaining - AesCtrHmacStreaming.this.tagSizeInBytes);
            ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
            byteBufferDuplicate.limit(i2);
            ByteBuffer byteBufferDuplicate2 = byteBuffer.duplicate();
            byteBufferDuplicate2.position(i2);
            this.f3884mac.init(this.hmacKeySpec);
            this.f3884mac.update(bArrNonceForSegment);
            this.f3884mac.update(byteBufferDuplicate);
            byte[] bArrCopyOf = Arrays.copyOf(this.f3884mac.doFinal(), AesCtrHmacStreaming.this.tagSizeInBytes);
            byte[] bArr = new byte[AesCtrHmacStreaming.this.tagSizeInBytes];
            byteBufferDuplicate2.get(bArr);
            if (!C0853Bytes.m4230equal(bArr, bArrCopyOf)) {
                throw new GeneralSecurityException("Tag mismatch");
            }
            byteBuffer.limit(i2);
            this.f3882cipher.init(1, this.f3883keySpec, new IvParameterSpec(bArrNonceForSegment));
            this.f3882cipher.doFinal(byteBuffer, byteBuffer2);
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.StreamSegmentDecrypter
        /* renamed from: init */
        public synchronized void mo4213init(ByteBuffer byteBuffer, byte[] bArr) {
            if (byteBuffer.remaining() != AesCtrHmacStreaming.this.getHeaderLength()) {
                throw new InvalidAlgorithmParameterException("Invalid header length");
            }
            if (byteBuffer.get() != AesCtrHmacStreaming.this.getHeaderLength()) {
                throw new GeneralSecurityException("Invalid ciphertext");
            }
            this.noncePrefix = new byte[7];
            byte[] bArr2 = new byte[AesCtrHmacStreaming.this.keySizeInBytes];
            byteBuffer.get(bArr2);
            byteBuffer.get(this.noncePrefix);
            byte[] bArrDeriveKeyMaterial = AesCtrHmacStreaming.this.deriveKeyMaterial(bArr2, bArr);
            this.f3883keySpec = AesCtrHmacStreaming.this.deriveKeySpec(bArrDeriveKeyMaterial);
            this.hmacKeySpec = AesCtrHmacStreaming.this.deriveHmacKeySpec(bArrDeriveKeyMaterial);
            this.f3882cipher = AesCtrHmacStreaming.cipherInstance();
            this.f3884mac = AesCtrHmacStreaming.this.macInstance();
        }
    }

    public AesCtrHmacStreaming(byte[] bArr, String str, int i, String str2, int i2, int i3, int i4) throws GeneralSecurityException {
        if (!f3879FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use AES-CTR-HMAC streaming in FIPS-mode.");
        }
        validateParameters(bArr.length, i, str2, i2, i3, i4);
        this.f3880ikm = Arrays.copyOf(bArr, bArr.length);
        this.hkdfAlgo = str;
        this.keySizeInBytes = i;
        this.f3881tagAlgo = str2;
        this.tagSizeInBytes = i2;
        this.ciphertextSegmentSize = i3;
        this.firstSegmentOffset = i4;
        this.plaintextSegmentSize = i3 - i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Cipher cipherInstance() {
        return EngineFactory.f3961CIPHER.getInstance("AES/CTR/NoPadding");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec deriveHmacKeySpec(byte[] bArr) {
        return new SecretKeySpec(bArr, this.keySizeInBytes, 32, this.f3881tagAlgo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] deriveKeyMaterial(byte[] bArr, byte[] bArr2) {
        return C0866Hkdf.computeHkdf(this.hkdfAlgo, this.f3880ikm, bArr, bArr2, this.keySizeInBytes + 32);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SecretKeySpec deriveKeySpec(byte[] bArr) {
        return new SecretKeySpec(bArr, 0, this.keySizeInBytes, "AES");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Mac macInstance() {
        return EngineFactory.f3962MAC.getInstance(this.f3881tagAlgo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] nonceForSegment(byte[] bArr, long j, boolean z) throws GeneralSecurityException {
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(16);
        byteBufferAllocate.order(ByteOrder.BIG_ENDIAN);
        byteBufferAllocate.put(bArr);
        SubtleUtil.putAsUnsigedInt(byteBufferAllocate, j);
        byteBufferAllocate.put(z ? (byte) 1 : (byte) 0);
        byteBufferAllocate.putInt(0);
        return byteBufferAllocate.array();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] randomNonce() {
        return C0870Random.randBytes(7);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public byte[] randomSalt() {
        return C0870Random.randBytes(this.keySizeInBytes);
    }

    private static void validateParameters(int i, int i2, String str, int i3, int i4, int i5) throws InvalidAlgorithmParameterException {
        if (i < 16 || i < i2) {
            throw new InvalidAlgorithmParameterException("ikm too short, must be >= " + Math.max(16, i2));
        }
        Validators.validateAesKeySize(i2);
        if (i3 < 10) {
            throw new InvalidAlgorithmParameterException("tag size too small " + i3);
        }
        if ((str.equals("HmacSha1") && i3 > 20) || ((str.equals("HmacSha256") && i3 > 32) || (str.equals("HmacSha512") && i3 > 64))) {
            throw new InvalidAlgorithmParameterException("tag size too big");
        }
        if ((((i4 - i5) - i3) - i2) - 8 <= 0) {
            throw new InvalidAlgorithmParameterException("ciphertextSegmentSize too small");
        }
    }

    public long expectedCiphertextSize(long j) {
        long ciphertextOffset = j + getCiphertextOffset();
        int i = this.plaintextSegmentSize;
        long j2 = (ciphertextOffset / i) * this.ciphertextSegmentSize;
        long j3 = ciphertextOffset % i;
        return j3 > 0 ? j2 + j3 + this.tagSizeInBytes : j2;
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead
    public int getCiphertextOffset() {
        return getHeaderLength() + this.firstSegmentOffset;
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead
    public int getCiphertextOverhead() {
        return this.tagSizeInBytes;
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
    public AesCtrHmacStreamDecrypter newStreamSegmentDecrypter() {
        return new AesCtrHmacStreamDecrypter();
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.NonceBasedStreamingAead
    public AesCtrHmacStreamEncrypter newStreamSegmentEncrypter(byte[] bArr) {
        return new AesCtrHmacStreamEncrypter(bArr);
    }

    public class AesCtrHmacStreamEncrypter implements StreamSegmentEncrypter {

        /* renamed from: cipher */
        private final Cipher f3886cipher = AesCtrHmacStreaming.cipherInstance();
        private long encryptedSegments;

        /* renamed from: header */
        private ByteBuffer f3887header;
        private final SecretKeySpec hmacKeySpec;

        /* renamed from: keySpec */
        private final SecretKeySpec f3888keySpec;

        /* renamed from: mac */
        private final Mac f3889mac;
        private final byte[] noncePrefix;

        public AesCtrHmacStreamEncrypter(byte[] bArr) {
            this.encryptedSegments = 0L;
            this.f3889mac = AesCtrHmacStreaming.this.macInstance();
            this.encryptedSegments = 0L;
            byte[] bArrRandomSalt = AesCtrHmacStreaming.this.randomSalt();
            byte[] bArrRandomNonce = AesCtrHmacStreaming.this.randomNonce();
            this.noncePrefix = bArrRandomNonce;
            ByteBuffer byteBufferAllocate = ByteBuffer.allocate(AesCtrHmacStreaming.this.getHeaderLength());
            this.f3887header = byteBufferAllocate;
            byteBufferAllocate.put((byte) AesCtrHmacStreaming.this.getHeaderLength());
            this.f3887header.put(bArrRandomSalt);
            this.f3887header.put(bArrRandomNonce);
            this.f3887header.flip();
            byte[] bArrDeriveKeyMaterial = AesCtrHmacStreaming.this.deriveKeyMaterial(bArrRandomSalt, bArr);
            this.f3888keySpec = AesCtrHmacStreaming.this.deriveKeySpec(bArrDeriveKeyMaterial);
            this.hmacKeySpec = AesCtrHmacStreaming.this.deriveHmacKeySpec(bArrDeriveKeyMaterial);
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer byteBuffer, boolean z, ByteBuffer byteBuffer2) {
            int iPosition = byteBuffer2.position();
            byte[] bArrNonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, this.encryptedSegments, z);
            this.f3886cipher.init(1, this.f3888keySpec, new IvParameterSpec(bArrNonceForSegment));
            this.encryptedSegments++;
            this.f3886cipher.doFinal(byteBuffer, byteBuffer2);
            ByteBuffer byteBufferDuplicate = byteBuffer2.duplicate();
            byteBufferDuplicate.flip();
            byteBufferDuplicate.position(iPosition);
            this.f3889mac.init(this.hmacKeySpec);
            this.f3889mac.update(bArrNonceForSegment);
            this.f3889mac.update(byteBufferDuplicate);
            byteBuffer2.put(this.f3889mac.doFinal(), 0, AesCtrHmacStreaming.this.tagSizeInBytes);
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.StreamSegmentEncrypter
        public ByteBuffer getHeader() {
            return this.f3887header.asReadOnlyBuffer();
        }

        @Override // com.p038google.p061crypto.p062tink.p075subtle.StreamSegmentEncrypter
        public synchronized void encryptSegment(ByteBuffer byteBuffer, ByteBuffer byteBuffer2, boolean z, ByteBuffer byteBuffer3) {
            int iPosition = byteBuffer3.position();
            byte[] bArrNonceForSegment = AesCtrHmacStreaming.this.nonceForSegment(this.noncePrefix, this.encryptedSegments, z);
            this.f3886cipher.init(1, this.f3888keySpec, new IvParameterSpec(bArrNonceForSegment));
            this.encryptedSegments++;
            this.f3886cipher.update(byteBuffer, byteBuffer3);
            this.f3886cipher.doFinal(byteBuffer2, byteBuffer3);
            ByteBuffer byteBufferDuplicate = byteBuffer3.duplicate();
            byteBufferDuplicate.flip();
            byteBufferDuplicate.position(iPosition);
            this.f3889mac.init(this.hmacKeySpec);
            this.f3889mac.update(bArrNonceForSegment);
            this.f3889mac.update(byteBufferDuplicate);
            byteBuffer3.put(this.f3889mac.doFinal(), 0, AesCtrHmacStreaming.this.tagSizeInBytes);
        }
    }
}
