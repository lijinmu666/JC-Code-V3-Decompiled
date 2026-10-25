package com.p038google.p061crypto.p062tink.signature;

import com.p038google.p061crypto.p062tink.AbstractC0308Key;
import com.p038google.p061crypto.p062tink.AccessesPartialKey;
import com.p038google.p061crypto.p062tink.InsecureSecretKeyAccess;
import com.p038google.p061crypto.p062tink.annotations.InterfaceC0389Alpha;
import com.p038google.p061crypto.p062tink.internal.EllipticCurvesUtil;
import com.p038google.p061crypto.p062tink.p078util.SecretBigInteger;
import com.p038google.p061crypto.p062tink.signature.EcdsaParameters;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.spec.ECPoint;

@InterfaceC0389Alpha
/* loaded from: classes.dex */
public final class EcdsaPrivateKey extends SignaturePrivateKey {
    private final SecretBigInteger privateValue;
    private final EcdsaPublicKey publicKey;

    /* renamed from: com.google.crypto.tink.signature.EcdsaPrivateKey$Builder */
    public static class C0817Builder {
        private SecretBigInteger privateValue;
        private EcdsaPublicKey publicKey;

        private static void validatePrivateValue(BigInteger bigInteger, ECPoint eCPoint, EcdsaParameters.CurveType curveType) throws GeneralSecurityException {
            BigInteger order = curveType.toParameterSpec().getOrder();
            if (bigInteger.signum() <= 0 || bigInteger.compareTo(order) >= 0) {
                throw new GeneralSecurityException("Invalid private value");
            }
            if (!EllipticCurvesUtil.multiplyByGenerator(bigInteger, curveType.toParameterSpec()).equals(eCPoint)) {
                throw new GeneralSecurityException("Invalid private value");
            }
        }

        @AccessesPartialKey
        /* renamed from: build */
        public EcdsaPrivateKey m4198build() throws GeneralSecurityException {
            if (this.publicKey == null) {
                throw new GeneralSecurityException("Cannot build without a ecdsa public key");
            }
            SecretBigInteger secretBigInteger = this.privateValue;
            if (secretBigInteger == null) {
                throw new GeneralSecurityException("Cannot build without a private value");
            }
            validatePrivateValue(secretBigInteger.getBigInteger(InsecureSecretKeyAccess.m3332get()), this.publicKey.getPublicPoint(), this.publicKey.getParameters().getCurveType());
            return new EcdsaPrivateKey(this.publicKey, this.privateValue);
        }

        public C0817Builder setPrivateValue(SecretBigInteger secretBigInteger) {
            this.privateValue = secretBigInteger;
            return this;
        }

        public C0817Builder setPublicKey(EcdsaPublicKey ecdsaPublicKey) {
            this.publicKey = ecdsaPublicKey;
            return this;
        }

        private C0817Builder() {
            this.publicKey = null;
            this.privateValue = null;
        }
    }

    /* renamed from: builder */
    public static C0817Builder m4197builder() {
        return new C0817Builder();
    }

    @Override // com.p038google.p061crypto.p062tink.AbstractC0308Key
    public boolean equalsKey(AbstractC0308Key abstractC0308Key) {
        if (!(abstractC0308Key instanceof EcdsaPrivateKey)) {
            return false;
        }
        EcdsaPrivateKey ecdsaPrivateKey = (EcdsaPrivateKey) abstractC0308Key;
        return ecdsaPrivateKey.publicKey.equalsKey(this.publicKey) && this.privateValue.equalsSecretBigInteger(ecdsaPrivateKey.privateValue);
    }

    public SecretBigInteger getPrivateValue() {
        return this.privateValue;
    }

    private EcdsaPrivateKey(EcdsaPublicKey ecdsaPublicKey, SecretBigInteger secretBigInteger) {
        this.publicKey = ecdsaPublicKey;
        this.privateValue = secretBigInteger;
    }

    @Override // com.p038google.p061crypto.p062tink.signature.SignaturePrivateKey, com.p038google.p061crypto.p062tink.AbstractC0308Key
    public EcdsaParameters getParameters() {
        return this.publicKey.getParameters();
    }

    @Override // com.p038google.p061crypto.p062tink.signature.SignaturePrivateKey, com.p038google.p061crypto.p062tink.PrivateKey
    public EcdsaPublicKey getPublicKey() {
        return this.publicKey;
    }
}
