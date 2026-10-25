package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.PublicKeySign;
import com.p038google.p061crypto.p062tink.p065config.internal.TinkFipsUtil;
import java.security.GeneralSecurityException;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class Ed25519Sign implements PublicKeySign {

    /* renamed from: FIPS */
    public static final TinkFipsUtil.AlgorithmFipsCompatibility f3951FIPS = TinkFipsUtil.AlgorithmFipsCompatibility.ALGORITHM_NOT_FIPS;
    public static final int SECRET_KEY_LEN = 32;
    private final byte[] hashedPrivateKey;
    private final byte[] publicKey;

    /* renamed from: com.google.crypto.tink.subtle.Ed25519Sign$KeyPair */
    public static final class C0858KeyPair {
        private final byte[] privateKey;
        private final byte[] publicKey;

        private C0858KeyPair(byte[] bArr, byte[] bArr2) {
            this.publicKey = bArr;
            this.privateKey = bArr2;
        }

        public static C0858KeyPair newKeyPair() {
            return newKeyPairFromSeed(C0870Random.randBytes(32));
        }

        public static C0858KeyPair newKeyPairFromSeed(byte[] bArr) {
            if (bArr.length == 32) {
                return new C0858KeyPair(C0855Ed25519.scalarMultWithBaseToBytes(C0855Ed25519.getHashedScalar(bArr)), bArr);
            }
            throw new IllegalArgumentException(String.format("Given secret seed length is not %s", 32));
        }

        public byte[] getPrivateKey() {
            byte[] bArr = this.privateKey;
            return Arrays.copyOf(bArr, bArr.length);
        }

        public byte[] getPublicKey() {
            byte[] bArr = this.publicKey;
            return Arrays.copyOf(bArr, bArr.length);
        }
    }

    public Ed25519Sign(byte[] bArr) throws GeneralSecurityException {
        if (!f3951FIPS.isCompatible()) {
            throw new GeneralSecurityException("Can not use Ed25519 in FIPS-mode.");
        }
        if (bArr.length != 32) {
            throw new IllegalArgumentException(String.format("Given private key's length is not %s", 32));
        }
        byte[] hashedScalar = C0855Ed25519.getHashedScalar(bArr);
        this.hashedPrivateKey = hashedScalar;
        this.publicKey = C0855Ed25519.scalarMultWithBaseToBytes(hashedScalar);
    }

    @Override // com.p038google.p061crypto.p062tink.PublicKeySign
    /* renamed from: sign */
    public byte[] mo3386sign(byte[] bArr) {
        return C0855Ed25519.m4245sign(bArr, this.publicKey, this.hashedPrivateKey);
    }
}
