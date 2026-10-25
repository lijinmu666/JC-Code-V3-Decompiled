package com.p038google.p061crypto.p062tink.p075subtle;

import com.p038google.p061crypto.p062tink.p074shaded.protobuf.ByteString;
import com.p038google.p061crypto.p062tink.p075subtle.C0864Enums;
import com.p038google.p061crypto.p062tink.p075subtle.EllipticCurves;
import java.security.GeneralSecurityException;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.interfaces.RSAPublicKey;

/* loaded from: classes.dex */
public final class SelfKeyTestValidators {
    private static final ByteString TEST_MESSAGE = ByteString.copyFromUtf8("Tink and Wycheproof.");

    private SelfKeyTestValidators() {
    }

    public static final void validateEcdsa(ECPrivateKey eCPrivateKey, ECPublicKey eCPublicKey, C0864Enums.HashType hashType, EllipticCurves.EcdsaEncoding ecdsaEncoding) {
        EcdsaSignJce ecdsaSignJce = new EcdsaSignJce(eCPrivateKey, hashType, ecdsaEncoding);
        EcdsaVerifyJce ecdsaVerifyJce = new EcdsaVerifyJce(eCPublicKey, hashType, ecdsaEncoding);
        try {
            ByteString byteString = TEST_MESSAGE;
            ecdsaVerifyJce.mo3387verify(ecdsaSignJce.mo3386sign(byteString.toByteArray()), byteString.toByteArray());
        } catch (GeneralSecurityException e) {
            throw new GeneralSecurityException("ECDSA signing with private key followed by verifying with public key failed. The key may be corrupted.", e);
        }
    }

    public static final void validateRsaSsaPkcs1(RSAPrivateCrtKey rSAPrivateCrtKey, RSAPublicKey rSAPublicKey, C0864Enums.HashType hashType) {
        RsaSsaPkcs1SignJce rsaSsaPkcs1SignJce = new RsaSsaPkcs1SignJce(rSAPrivateCrtKey, hashType);
        RsaSsaPkcs1VerifyJce rsaSsaPkcs1VerifyJce = new RsaSsaPkcs1VerifyJce(rSAPublicKey, hashType);
        try {
            ByteString byteString = TEST_MESSAGE;
            rsaSsaPkcs1VerifyJce.mo3387verify(rsaSsaPkcs1SignJce.mo3386sign(byteString.toByteArray()), byteString.toByteArray());
        } catch (GeneralSecurityException e) {
            throw new GeneralSecurityException("RSA PKCS1 signing with private key followed by verifying with public key failed. The key may be corrupted.", e);
        }
    }

    public static final void validateRsaSsaPss(RSAPrivateCrtKey rSAPrivateCrtKey, RSAPublicKey rSAPublicKey, C0864Enums.HashType hashType, C0864Enums.HashType hashType2, int i) {
        RsaSsaPssSignJce rsaSsaPssSignJce = new RsaSsaPssSignJce(rSAPrivateCrtKey, hashType, hashType2, i);
        RsaSsaPssVerifyJce rsaSsaPssVerifyJce = new RsaSsaPssVerifyJce(rSAPublicKey, hashType, hashType2, i);
        try {
            ByteString byteString = TEST_MESSAGE;
            rsaSsaPssVerifyJce.mo3387verify(rsaSsaPssSignJce.mo3386sign(byteString.toByteArray()), byteString.toByteArray());
        } catch (GeneralSecurityException e) {
            throw new GeneralSecurityException("RSA PSS signing with private key followed by verifying with public key failed. The key may be corrupted.", e);
        }
    }
}
