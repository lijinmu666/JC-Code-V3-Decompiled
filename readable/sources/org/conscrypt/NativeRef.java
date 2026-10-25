package org.conscrypt;

/* loaded from: classes2.dex */
abstract class NativeRef {

    /* renamed from: address */
    final long f24379address;

    public static final class EC_GROUP extends NativeRef {
        public EC_GROUP(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        /* renamed from: doFree */
        public void mo18451doFree(long j) {
            NativeCrypto.EC_GROUP_clear_free(j);
        }
    }

    public static final class EC_POINT extends NativeRef {
        public EC_POINT(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        /* renamed from: doFree */
        public void mo18451doFree(long j) {
            NativeCrypto.EC_POINT_clear_free(j);
        }
    }

    public static final class EVP_CIPHER_CTX extends NativeRef {
        public EVP_CIPHER_CTX(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        /* renamed from: doFree */
        public void mo18451doFree(long j) {
            NativeCrypto.EVP_CIPHER_CTX_free(j);
        }
    }

    public static final class EVP_MD_CTX extends NativeRef {
        public EVP_MD_CTX(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        /* renamed from: doFree */
        public void mo18451doFree(long j) {
            NativeCrypto.EVP_MD_CTX_destroy(j);
        }
    }

    public static final class EVP_PKEY extends NativeRef {
        public EVP_PKEY(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        /* renamed from: doFree */
        public void mo18451doFree(long j) {
            NativeCrypto.EVP_PKEY_free(j);
        }
    }

    public static final class EVP_PKEY_CTX extends NativeRef {
        public EVP_PKEY_CTX(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        /* renamed from: doFree */
        public void mo18451doFree(long j) {
            NativeCrypto.EVP_PKEY_CTX_free(j);
        }
    }

    public static final class HMAC_CTX extends NativeRef {
        public HMAC_CTX(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        /* renamed from: doFree */
        public void mo18451doFree(long j) {
            NativeCrypto.HMAC_CTX_free(j);
        }
    }

    public static final class SSL_SESSION extends NativeRef {
        public SSL_SESSION(long j) {
            super(j);
        }

        @Override // org.conscrypt.NativeRef
        /* renamed from: doFree */
        public void mo18451doFree(long j) {
            NativeCrypto.SSL_SESSION_free(j);
        }
    }

    public NativeRef(long j) {
        if (j == 0) {
            throw new NullPointerException("address == 0");
        }
        this.f24379address = j;
    }

    /* renamed from: doFree */
    public abstract void mo18451doFree(long j);

    /* renamed from: equals */
    public boolean m18452equals(Object obj) {
        return (obj instanceof NativeRef) && ((NativeRef) obj).f24379address == this.f24379address;
    }

    public void finalize() throws Throwable {
        try {
            long j = this.f24379address;
            if (j != 0) {
                mo18451doFree(j);
            }
        } finally {
            super.finalize();
        }
    }

    public int hashCode() {
        long j = this.f24379address;
        return (int) (j ^ (j >>> 32));
    }
}
