package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.GOST3410Parameters;
import org.bouncycastle.p194crypto.p213params.GOST3410PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.GOST3410PublicKeyParameters;
import org.bouncycastle.p281jce.interfaces.GOST3410PrivateKey;
import org.bouncycastle.p281jce.interfaces.GOST3410PublicKey;
import org.bouncycastle.p281jce.p282spec.GOST3410PublicKeyParameterSetSpec;

/* loaded from: classes2.dex */
public class GOST3410Util {
    public static AsymmetricKeyParameter generatePrivateKeyParameter(PrivateKey privateKey) throws InvalidKeyException {
        if (!(privateKey instanceof GOST3410PrivateKey)) {
            throw new InvalidKeyException("can't identify GOST3410 private key.");
        }
        GOST3410PrivateKey gOST3410PrivateKey = (GOST3410PrivateKey) privateKey;
        GOST3410PublicKeyParameterSetSpec publicKeyParameters = gOST3410PrivateKey.getParameters().getPublicKeyParameters();
        return new GOST3410PrivateKeyParameters(gOST3410PrivateKey.mo16115getX(), new GOST3410Parameters(publicKeyParameters.m16286getP(), publicKeyParameters.m16287getQ(), publicKeyParameters.m16285getA()));
    }

    public static AsymmetricKeyParameter generatePublicKeyParameter(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof GOST3410PublicKey) {
            GOST3410PublicKey gOST3410PublicKey = (GOST3410PublicKey) publicKey;
            GOST3410PublicKeyParameterSetSpec publicKeyParameters = gOST3410PublicKey.getParameters().getPublicKeyParameters();
            return new GOST3410PublicKeyParameters(gOST3410PublicKey.mo16117getY(), new GOST3410Parameters(publicKeyParameters.m16286getP(), publicKeyParameters.m16287getQ(), publicKeyParameters.m16285getA()));
        }
        throw new InvalidKeyException("can't identify GOST3410 public key: " + publicKey.getClass().getName());
    }
}
