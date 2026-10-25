package com.p038google.p061crypto.p062tink.p072prf;

import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.p078util.C0878Bytes;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.util.Objects;
import javax.annotation.Nullable;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class HkdfPrfParameters extends PrfParameters {
    private static final int MIN_KEY_SIZE = 16;
    private final HashType hashType;
    private final int keySizeBytes;

    /* renamed from: salt */
    @Nullable
    private final C0878Bytes f3192salt;

    /* renamed from: com.google.crypto.tink.prf.HkdfPrfParameters$Builder */
    public static final class C0499Builder {

        @Nullable
        private HashType hashType;

        @Nullable
        private Integer keySizeBytes;

        /* renamed from: salt */
        @Nullable
        private C0878Bytes f3193salt;

        /* renamed from: build */
        public HkdfPrfParameters m3546build() throws GeneralSecurityException {
            Integer num = this.keySizeBytes;
            if (num == null) {
                throw new GeneralSecurityException("key size is not set");
            }
            if (this.hashType != null) {
                return new HkdfPrfParameters(num.intValue(), this.hashType, this.f3193salt);
            }
            throw new GeneralSecurityException("hash type is not set");
        }

        public C0499Builder setHashType(HashType hashType) {
            this.hashType = hashType;
            return this;
        }

        public C0499Builder setKeySizeBytes(int i) throws InvalidAlgorithmParameterException {
            if (i < 16) {
                throw new InvalidAlgorithmParameterException(String.format("Invalid key size %d; only 128-bit or larger are supported", Integer.valueOf(i * 8)));
            }
            this.keySizeBytes = Integer.valueOf(i);
            return this;
        }

        /* renamed from: setSalt */
        public C0499Builder m3547setSalt(C0878Bytes c0878Bytes) {
            if (c0878Bytes.m4292size() == 0) {
                return this;
            }
            this.f3193salt = c0878Bytes;
            return this;
        }

        private C0499Builder() {
            this.keySizeBytes = null;
            this.hashType = null;
            this.f3193salt = null;
        }
    }

    public static final class HashType {

        /* renamed from: SHA1 */
        public static final HashType f3194SHA1 = new HashType("SHA1");

        /* renamed from: SHA224 */
        public static final HashType f3195SHA224 = new HashType("SHA224");

        /* renamed from: SHA256 */
        public static final HashType f3196SHA256 = new HashType("SHA256");

        /* renamed from: SHA384 */
        public static final HashType f3197SHA384 = new HashType("SHA384");

        /* renamed from: SHA512 */
        public static final HashType f3198SHA512 = new HashType("SHA512");

        /* renamed from: name */
        private final String f3199name;

        private HashType(String str) {
            this.f3199name = str;
        }

        public String toString() {
            return this.f3199name;
        }
    }

    /* renamed from: builder */
    public static C0499Builder m3543builder() {
        return new C0499Builder();
    }

    /* renamed from: equals */
    public boolean m3544equals(Object obj) {
        if (!(obj instanceof HkdfPrfParameters)) {
            return false;
        }
        HkdfPrfParameters hkdfPrfParameters = (HkdfPrfParameters) obj;
        return hkdfPrfParameters.getKeySizeBytes() == getKeySizeBytes() && hkdfPrfParameters.getHashType() == getHashType() && Objects.equals(hkdfPrfParameters.m3545getSalt(), m3545getSalt());
    }

    public HashType getHashType() {
        return this.hashType;
    }

    public int getKeySizeBytes() {
        return this.keySizeBytes;
    }

    @Nullable
    /* renamed from: getSalt */
    public C0878Bytes m3545getSalt() {
        return this.f3192salt;
    }

    @Override // com.p038google.p061crypto.p062tink.Parameters
    public boolean hasIdRequirement() {
        return false;
    }

    public int hashCode() {
        return Objects.hash(Integer.valueOf(this.keySizeBytes), this.hashType, this.f3192salt);
    }

    public String toString() {
        return "HKDF PRF Parameters (hashType: " + this.hashType + ", salt: " + this.f3192salt + ", and " + this.keySizeBytes + "-byte key)";
    }

    private HkdfPrfParameters(int i, HashType hashType, C0878Bytes c0878Bytes) {
        this.keySizeBytes = i;
        this.hashType = hashType;
        this.f3192salt = c0878Bytes;
    }
}
