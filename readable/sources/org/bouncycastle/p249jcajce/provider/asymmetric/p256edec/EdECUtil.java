package org.bouncycastle.p249jcajce.provider.asymmetric.p256edec;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p221util.PrivateKeyFactory;
import org.bouncycastle.p194crypto.p221util.PublicKeyFactory;

/* loaded from: classes2.dex */
class EdECUtil {
    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof BCXDHPrivateKey) {
            return ((BCXDHPrivateKey) privateKey).engineGetKeyParameters();
        }
        if (privateKey instanceof BCEdDSAPrivateKey) {
            return ((BCEdDSAPrivateKey) privateKey).engineGetKeyParameters();
        }
        try {
            byte[] encoded = privateKey.getEncoded();
            if (encoded != null) {
                return PrivateKeyFactory.createKey(encoded);
            }
            throw new InvalidKeyException("no encoding for EdEC/XDH private key");
        } catch (Exception e) {
            throw new InvalidKeyException("cannot identify EdEC/XDH private key: " + e.getMessage());
        }
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof BCXDHPublicKey) {
            return ((BCXDHPublicKey) publicKey).engineGetKeyParameters();
        }
        if (publicKey instanceof BCEdDSAPublicKey) {
            return ((BCEdDSAPublicKey) publicKey).engineGetKeyParameters();
        }
        try {
            byte[] encoded = publicKey.getEncoded();
            if (encoded != null) {
                return PublicKeyFactory.createKey(encoded);
            }
            throw new InvalidKeyException("no encoding for EdEC/XDH public key");
        } catch (Exception e) {
            throw new InvalidKeyException("cannot identify EdEC/XDH public key: " + e.getMessage());
        }
    }
}
