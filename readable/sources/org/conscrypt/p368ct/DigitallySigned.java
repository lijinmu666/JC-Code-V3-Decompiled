package org.conscrypt.p368ct;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class DigitallySigned {
    private final HashAlgorithm hashAlgorithm;
    private final byte[] signature;
    private final SignatureAlgorithm signatureAlgorithm;

    public enum HashAlgorithm {
        NONE,
        MD5,
        SHA1,
        SHA224,
        SHA256,
        SHA384,
        SHA512;


        /* renamed from: values */
        private static HashAlgorithm[] f24479values = m18523values();

        /* renamed from: valueOf */
        public static HashAlgorithm m18521valueOf(int i) {
            try {
                return f24479values[i];
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Invalid hash algorithm " + i, e);
            }
        }
    }

    public enum SignatureAlgorithm {
        ANONYMOUS,
        RSA,
        DSA,
        ECDSA;


        /* renamed from: values */
        private static SignatureAlgorithm[] f24484values = m18526values();

        /* renamed from: valueOf */
        public static SignatureAlgorithm m18524valueOf(int i) {
            try {
                return f24484values[i];
            } catch (IndexOutOfBoundsException e) {
                throw new IllegalArgumentException("Invalid signature algorithm " + i, e);
            }
        }
    }

    public DigitallySigned(HashAlgorithm hashAlgorithm, SignatureAlgorithm signatureAlgorithm, byte[] bArr) {
        this.hashAlgorithm = hashAlgorithm;
        this.signatureAlgorithm = signatureAlgorithm;
        this.signature = bArr;
    }

    /* renamed from: decode */
    public static DigitallySigned m18519decode(InputStream inputStream) throws SerializationException {
        try {
            return new DigitallySigned(Serialization.readNumber(inputStream, 1), Serialization.readNumber(inputStream, 1), Serialization.readVariableBytes(inputStream, 2));
        } catch (IllegalArgumentException e) {
            throw new SerializationException(e);
        }
    }

    public String getAlgorithm() {
        return String.format("%swith%s", this.hashAlgorithm, this.signatureAlgorithm);
    }

    public HashAlgorithm getHashAlgorithm() {
        return this.hashAlgorithm;
    }

    public byte[] getSignature() {
        return this.signature;
    }

    public SignatureAlgorithm getSignatureAlgorithm() {
        return this.signatureAlgorithm;
    }

    public DigitallySigned(int i, int i2, byte[] bArr) {
        this(HashAlgorithm.m18521valueOf(i), SignatureAlgorithm.m18524valueOf(i2), bArr);
    }

    /* renamed from: decode */
    public static DigitallySigned m18520decode(byte[] bArr) {
        return m18519decode(new ByteArrayInputStream(bArr));
    }
}
