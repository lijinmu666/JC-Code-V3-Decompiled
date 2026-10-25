package org.bouncycastle.p194crypto.p221util;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.DSAParameters;
import org.bouncycastle.p194crypto.p213params.DSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECNamedDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p284math.p285ec.AbstractC5817ECCurve;

/* loaded from: classes2.dex */
public class OpenSSHPublicKeyUtil {

    /* renamed from: DSS */
    private static final String f21124DSS = "ssh-dss";

    /* renamed from: ECDSA */
    private static final String f21125ECDSA = "ecdsa";
    private static final String ED_25519 = "ssh-ed25519";
    private static final String FIDO2_EC_P256 = "sk-ecdsa-sha2-nistp256@openssh.com";
    private static final String FIDO_ED_25519 = "sk-ssh-ed25519@openssh.com";

    /* renamed from: RSA */
    private static final String f21126RSA = "ssh-rsa";

    private OpenSSHPublicKeyUtil() {
    }

    public static byte[] encodePublicKey(AsymmetricKeyParameter asymmetricKeyParameter) throws IOException {
        if (asymmetricKeyParameter == null) {
            throw new IllegalArgumentException("cipherParameters was null.");
        }
        if (asymmetricKeyParameter instanceof RSAKeyParameters) {
            if (asymmetricKeyParameter.isPrivate()) {
                throw new IllegalArgumentException("RSAKeyParamaters was for encryption");
            }
            RSAKeyParameters rSAKeyParameters = (RSAKeyParameters) asymmetricKeyParameter;
            SSHBuilder sSHBuilder = new SSHBuilder();
            sSHBuilder.writeString(f21126RSA);
            sSHBuilder.writeBigNum(rSAKeyParameters.getExponent());
            sSHBuilder.writeBigNum(rSAKeyParameters.getModulus());
            return sSHBuilder.getBytes();
        }
        if (asymmetricKeyParameter instanceof ECPublicKeyParameters) {
            ECPublicKeyParameters eCPublicKeyParameters = (ECPublicKeyParameters) asymmetricKeyParameter;
            ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
            SSHBuilder sSHBuilder2 = new SSHBuilder();
            String nameForParameters = SSHNamedCurves.getNameForParameters(parameters);
            if (nameForParameters == null) {
                throw new IllegalArgumentException("unable to derive ssh curve name for " + parameters.getCurve().getClass().getName());
            }
            sSHBuilder2.writeString("ecdsa-sha2-" + nameForParameters);
            sSHBuilder2.writeString(nameForParameters);
            sSHBuilder2.writeBlock(eCPublicKeyParameters.m15728getQ().getEncoded(false));
            return sSHBuilder2.getBytes();
        }
        if (asymmetricKeyParameter instanceof DSAPublicKeyParameters) {
            DSAPublicKeyParameters dSAPublicKeyParameters = (DSAPublicKeyParameters) asymmetricKeyParameter;
            DSAParameters parameters2 = dSAPublicKeyParameters.getParameters();
            SSHBuilder sSHBuilder3 = new SSHBuilder();
            sSHBuilder3.writeString(f21124DSS);
            sSHBuilder3.writeBigNum(parameters2.m15705getP());
            sSHBuilder3.writeBigNum(parameters2.m15706getQ());
            sSHBuilder3.writeBigNum(parameters2.m15704getG());
            sSHBuilder3.writeBigNum(dSAPublicKeyParameters.m15708getY());
            return sSHBuilder3.getBytes();
        }
        if (asymmetricKeyParameter instanceof Ed25519PublicKeyParameters) {
            SSHBuilder sSHBuilder4 = new SSHBuilder();
            sSHBuilder4.writeString(ED_25519);
            sSHBuilder4.writeBlock(((Ed25519PublicKeyParameters) asymmetricKeyParameter).getEncoded());
            return sSHBuilder4.getBytes();
        }
        throw new IllegalArgumentException("unable to convert " + asymmetricKeyParameter.getClass().getName() + " to public key");
    }

    public static AsymmetricKeyParameter parsePublicKey(SSHBuffer sSHBuffer) {
        AsymmetricKeyParameter ed25519PublicKeyParameters;
        String string = sSHBuffer.readString();
        if (f21126RSA.equals(string)) {
            ed25519PublicKeyParameters = new RSAKeyParameters(false, sSHBuffer.readBigNumPositive(), sSHBuffer.readBigNumPositive());
        } else if (f21124DSS.equals(string)) {
            ed25519PublicKeyParameters = new DSAPublicKeyParameters(sSHBuffer.readBigNumPositive(), new DSAParameters(sSHBuffer.readBigNumPositive(), sSHBuffer.readBigNumPositive(), sSHBuffer.readBigNumPositive()));
        } else if (string.startsWith(f21125ECDSA)) {
            String string2 = sSHBuffer.readString();
            ASN1ObjectIdentifier byName = SSHNamedCurves.getByName(string2);
            X9ECParameters parameters = SSHNamedCurves.getParameters(byName);
            if (parameters == null) {
                throw new IllegalStateException("unable to find curve for " + string + " using curve name " + string2);
            }
            ed25519PublicKeyParameters = new ECPublicKeyParameters(parameters.getCurve().decodePoint(sSHBuffer.readBlock()), new ECNamedDomainParameters(byName, parameters));
        } else if (string.equals(FIDO2_EC_P256)) {
            String string3 = sSHBuffer.readString();
            ASN1ObjectIdentifier byName2 = SSHNamedCurves.getByName(string3);
            X9ECParameters parameters2 = SSHNamedCurves.getParameters(byName2);
            if (parameters2 == null) {
                throw new IllegalStateException("unable to find curve for " + string + " using curve name " + string3);
            }
            AbstractC5817ECCurve curve = parameters2.getCurve();
            byte[] block = sSHBuffer.readBlock();
            sSHBuffer.readString();
            ed25519PublicKeyParameters = new ECPublicKeyParameters(curve.decodePoint(block), new ECNamedDomainParameters(byName2, parameters2));
        } else if (ED_25519.equals(string)) {
            byte[] block2 = sSHBuffer.readBlock();
            if (block2.length != 32) {
                throw new IllegalStateException("public key value of wrong length");
            }
            ed25519PublicKeyParameters = new Ed25519PublicKeyParameters(block2, 0);
        } else if (FIDO_ED_25519.equals(string)) {
            byte[] block3 = sSHBuffer.readBlock();
            if (block3.length != 32) {
                throw new IllegalStateException("public key value of wrong length");
            }
            sSHBuffer.readString();
            ed25519PublicKeyParameters = new Ed25519PublicKeyParameters(block3, 0);
        } else {
            ed25519PublicKeyParameters = null;
        }
        if (ed25519PublicKeyParameters == null) {
            throw new IllegalArgumentException("unable to parse key");
        }
        if (sSHBuffer.hasRemaining()) {
            throw new IllegalArgumentException("decoded key has trailing data");
        }
        return ed25519PublicKeyParameters;
    }

    public static AsymmetricKeyParameter parsePublicKey(byte[] bArr) {
        return parsePublicKey(new SSHBuffer(bArr));
    }
}
