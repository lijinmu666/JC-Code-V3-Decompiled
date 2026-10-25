package com.p038google.p061crypto.p062tink.p075subtle.p076prf;

import com.p038google.p061crypto.p062tink.p075subtle.C0864Enums;
import com.p038google.p061crypto.p062tink.p075subtle.EngineFactory;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.util.Arrays;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import p094kotlin.C1126UByte;

/* loaded from: classes.dex */
public class HkdfStreamingPrf implements StreamingPrf {
    private final C0864Enums.HashType hashType;

    /* renamed from: ikm */
    private final byte[] f4006ikm;

    /* renamed from: salt */
    private final byte[] f4007salt;

    /* renamed from: com.google.crypto.tink.subtle.prf.HkdfStreamingPrf$1 */
    public static /* synthetic */ class C08751 {
        static final /* synthetic */ int[] $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType;

        static {
            int[] iArr = new int[C0864Enums.HashType.m4261values().length];
            $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType = iArr;
            try {
                iArr[C0864Enums.HashType.SHA1.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[C0864Enums.HashType.SHA256.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[C0864Enums.HashType.SHA384.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[C0864Enums.HashType.SHA512.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public HkdfStreamingPrf(C0864Enums.HashType hashType, byte[] bArr, byte[] bArr2) {
        this.hashType = hashType;
        this.f4006ikm = Arrays.copyOf(bArr, bArr.length);
        this.f4007salt = Arrays.copyOf(bArr2, bArr2.length);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String getJavaxHmacName(C0864Enums.HashType hashType) throws GeneralSecurityException {
        int i = C08751.$SwitchMap$com$google$crypto$tink$subtle$Enums$HashType[hashType.ordinal()];
        if (i == 1) {
            return "HmacSha1";
        }
        if (i == 2) {
            return "HmacSha256";
        }
        if (i == 3) {
            return "HmacSha384";
        }
        if (i == 4) {
            return "HmacSha512";
        }
        throw new GeneralSecurityException("No getJavaxHmacName for given hash " + hashType + " known");
    }

    @Override // com.p038google.p061crypto.p062tink.p075subtle.p076prf.StreamingPrf
    public InputStream computePrf(byte[] bArr) {
        return new HkdfInputStream(bArr);
    }

    public class HkdfInputStream extends InputStream {

        /* renamed from: buffer */
        private ByteBuffer f4008buffer;

        /* renamed from: ctr */
        private int f4009ctr = -1;

        /* renamed from: input */
        private final byte[] f4010input;

        /* renamed from: mac */
        private Mac f4011mac;

        /* renamed from: prk */
        private byte[] f4012prk;

        public HkdfInputStream(byte[] bArr) {
            this.f4010input = Arrays.copyOf(bArr, bArr.length);
        }

        private void initialize() throws IllegalStateException, InvalidKeyException, IOException {
            try {
                this.f4011mac = EngineFactory.f3962MAC.getInstance(HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType));
                if (HkdfStreamingPrf.this.f4007salt == null || HkdfStreamingPrf.this.f4007salt.length == 0) {
                    this.f4011mac.init(new SecretKeySpec(new byte[this.f4011mac.getMacLength()], HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
                } else {
                    this.f4011mac.init(new SecretKeySpec(HkdfStreamingPrf.this.f4007salt, HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
                }
                this.f4011mac.update(HkdfStreamingPrf.this.f4006ikm);
                this.f4012prk = this.f4011mac.doFinal();
                ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(0);
                this.f4008buffer = byteBufferAllocateDirect;
                byteBufferAllocateDirect.mark();
                this.f4009ctr = 0;
            } catch (GeneralSecurityException e) {
                throw new IOException("Creating HMac failed", e);
            }
        }

        private void updateBuffer() throws IllegalStateException, InvalidKeyException {
            this.f4011mac.init(new SecretKeySpec(this.f4012prk, HkdfStreamingPrf.getJavaxHmacName(HkdfStreamingPrf.this.hashType)));
            this.f4008buffer.reset();
            this.f4011mac.update(this.f4008buffer);
            this.f4011mac.update(this.f4010input);
            int i = this.f4009ctr + 1;
            this.f4009ctr = i;
            this.f4011mac.update((byte) i);
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f4011mac.doFinal());
            this.f4008buffer = byteBufferWrap;
            byteBufferWrap.mark();
        }

        @Override // java.io.InputStream
        public int read() throws IllegalStateException, IOException {
            byte[] bArr = new byte[1];
            int i = read(bArr, 0, 1);
            if (i == 1) {
                return bArr[0] & C1126UByte.MAX_VALUE;
            }
            if (i == -1) {
                return i;
            }
            throw new IOException("Reading failed");
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr) {
            return read(bArr, 0, bArr.length);
        }

        @Override // java.io.InputStream
        public int read(byte[] bArr, int i, int i2) throws IllegalStateException, IOException {
            try {
                if (this.f4009ctr == -1) {
                    initialize();
                }
                int i3 = 0;
                while (i3 < i2) {
                    if (!this.f4008buffer.hasRemaining()) {
                        if (this.f4009ctr == 255) {
                            return i3;
                        }
                        updateBuffer();
                    }
                    int iMin = Math.min(i2 - i3, this.f4008buffer.remaining());
                    this.f4008buffer.get(bArr, i, iMin);
                    i += iMin;
                    i3 += iMin;
                }
                return i3;
            } catch (GeneralSecurityException e) {
                this.f4011mac = null;
                throw new IOException("HkdfInputStream failed", e);
            }
        }
    }
}
