package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.CharToByteConverter;
import org.bouncycastle.p194crypto.PasswordConverter;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class Argon2Parameters {
    public static final int ARGON2_VERSION_10 = 16;
    public static final int ARGON2_VERSION_13 = 19;
    public static final int ARGON2_d = 0;
    public static final int ARGON2_i = 1;
    public static final int ARGON2_id = 2;
    private static final int DEFAULT_ITERATIONS = 3;
    private static final int DEFAULT_LANES = 1;
    private static final int DEFAULT_MEMORY_COST = 12;
    private static final int DEFAULT_TYPE = 1;
    private static final int DEFAULT_VERSION = 19;
    private final byte[] additional;
    private final CharToByteConverter converter;
    private final int iterations;

    /* renamed from: lanes */
    private final int f20665lanes;

    /* renamed from: memory */
    private final int f20666memory;

    /* renamed from: salt */
    private final byte[] f20667salt;

    /* renamed from: secret */
    private final byte[] f20668secret;

    /* renamed from: type */
    private final int f20669type;

    /* renamed from: version */
    private final int f20670version;

    /* renamed from: org.bouncycastle.crypto.params.Argon2Parameters$Builder */
    public static class C5371Builder {
        private byte[] additional;
        private CharToByteConverter converter;
        private int iterations;

        /* renamed from: lanes */
        private int f20671lanes;

        /* renamed from: memory */
        private int f20672memory;

        /* renamed from: salt */
        private byte[] f20673salt;

        /* renamed from: secret */
        private byte[] f20674secret;

        /* renamed from: type */
        private final int f20675type;

        /* renamed from: version */
        private int f20676version;

        public C5371Builder() {
            this(1);
        }

        /* renamed from: build */
        public Argon2Parameters m15668build() {
            return new Argon2Parameters(this.f20675type, this.f20673salt, this.f20674secret, this.additional, this.iterations, this.f20672memory, this.f20671lanes, this.f20676version, this.converter);
        }

        /* renamed from: clear */
        public void m15669clear() {
            C6238Arrays.m18227clear(this.f20673salt);
            C6238Arrays.m18227clear(this.f20674secret);
            C6238Arrays.m18227clear(this.additional);
        }

        public C5371Builder withAdditional(byte[] bArr) {
            this.additional = C6238Arrays.m18231clone(bArr);
            return this;
        }

        public C5371Builder withCharToByteConverter(CharToByteConverter charToByteConverter) {
            this.converter = charToByteConverter;
            return this;
        }

        public C5371Builder withIterations(int i) {
            this.iterations = i;
            return this;
        }

        public C5371Builder withMemoryAsKB(int i) {
            this.f20672memory = i;
            return this;
        }

        public C5371Builder withMemoryPowOfTwo(int i) {
            this.f20672memory = 1 << i;
            return this;
        }

        public C5371Builder withParallelism(int i) {
            this.f20671lanes = i;
            return this;
        }

        public C5371Builder withSalt(byte[] bArr) {
            this.f20673salt = C6238Arrays.m18231clone(bArr);
            return this;
        }

        public C5371Builder withSecret(byte[] bArr) {
            this.f20674secret = C6238Arrays.m18231clone(bArr);
            return this;
        }

        public C5371Builder withVersion(int i) {
            this.f20676version = i;
            return this;
        }

        public C5371Builder(int i) {
            this.converter = PasswordConverter.UTF8;
            this.f20675type = i;
            this.f20671lanes = 1;
            this.f20672memory = 4096;
            this.iterations = 3;
            this.f20676version = 19;
        }
    }

    private Argon2Parameters(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, int i3, int i4, int i5, CharToByteConverter charToByteConverter) {
        this.f20667salt = C6238Arrays.m18231clone(bArr);
        this.f20668secret = C6238Arrays.m18231clone(bArr2);
        this.additional = C6238Arrays.m18231clone(bArr3);
        this.iterations = i2;
        this.f20666memory = i3;
        this.f20665lanes = i4;
        this.f20670version = i5;
        this.f20669type = i;
        this.converter = charToByteConverter;
    }

    /* renamed from: clear */
    public void m15665clear() {
        C6238Arrays.m18227clear(this.f20667salt);
        C6238Arrays.m18227clear(this.f20668secret);
        C6238Arrays.m18227clear(this.additional);
    }

    public byte[] getAdditional() {
        return C6238Arrays.m18231clone(this.additional);
    }

    public CharToByteConverter getCharToByteConverter() {
        return this.converter;
    }

    public int getIterations() {
        return this.iterations;
    }

    public int getLanes() {
        return this.f20665lanes;
    }

    public int getMemory() {
        return this.f20666memory;
    }

    /* renamed from: getSalt */
    public byte[] m15666getSalt() {
        return C6238Arrays.m18231clone(this.f20667salt);
    }

    public byte[] getSecret() {
        return C6238Arrays.m18231clone(this.f20668secret);
    }

    /* renamed from: getType */
    public int m15667getType() {
        return this.f20669type;
    }

    public int getVersion() {
        return this.f20670version;
    }
}
