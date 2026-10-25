package org.bouncycastle.p194crypto.p221util;

import java.io.IOException;
import java.math.BigInteger;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p161nist.NISTNamedCurves;
import org.bouncycastle.p133asn1.p166pkcs.RSAPrivateKey;
import org.bouncycastle.p133asn1.p167sec.ECPrivateKey;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.DSAParameters;
import org.bouncycastle.p194crypto.p213params.DSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECNamedDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.conscrypt.BuildConfig;

/* loaded from: classes2.dex */
public class OpenSSHPrivateKeyUtil {
    private static final byte[] AUTH_MAGIC = C6250Strings.toByteArray("openssh-key-v1\u0000");

    private OpenSSHPrivateKeyUtil() {
    }

    private static boolean allIntegers(ASN1Sequence aSN1Sequence) {
        for (int i = 0; i < aSN1Sequence.mo14450size(); i++) {
            if (!(aSN1Sequence.getObjectAt(i) instanceof ASN1Integer)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] encodePrivateKey(AsymmetricKeyParameter asymmetricKeyParameter) throws IOException {
        if (asymmetricKeyParameter == null) {
            throw new IllegalArgumentException("param is null");
        }
        if (!(asymmetricKeyParameter instanceof RSAPrivateCrtKeyParameters) && !(asymmetricKeyParameter instanceof ECPrivateKeyParameters)) {
            if (asymmetricKeyParameter instanceof DSAPrivateKeyParameters) {
                DSAPrivateKeyParameters dSAPrivateKeyParameters = (DSAPrivateKeyParameters) asymmetricKeyParameter;
                DSAParameters parameters = dSAPrivateKeyParameters.getParameters();
                BigInteger bigIntegerModPow = parameters.m15704getG().modPow(dSAPrivateKeyParameters.m15707getX(), parameters.m15705getP());
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                aSN1EncodableVector.m14420add(ASN1Integer.f17922ZERO);
                aSN1EncodableVector.m14420add(new ASN1Integer(parameters.m15705getP()));
                aSN1EncodableVector.m14420add(new ASN1Integer(parameters.m15706getQ()));
                aSN1EncodableVector.m14420add(new ASN1Integer(parameters.m15704getG()));
                aSN1EncodableVector.m14420add(new ASN1Integer(bigIntegerModPow));
                aSN1EncodableVector.m14420add(new ASN1Integer(dSAPrivateKeyParameters.m15707getX()));
                try {
                    return new DERSequence(aSN1EncodableVector).getEncoded();
                } catch (Exception e) {
                    throw new IllegalStateException("unable to encode DSAPrivateKeyParameters " + e.getMessage());
                }
            }
            if (!(asymmetricKeyParameter instanceof Ed25519PrivateKeyParameters)) {
                throw new IllegalArgumentException("unable to convert " + asymmetricKeyParameter.getClass().getName() + " to openssh private key");
            }
            Ed25519PrivateKeyParameters ed25519PrivateKeyParameters = (Ed25519PrivateKeyParameters) asymmetricKeyParameter;
            Ed25519PublicKeyParameters ed25519PublicKeyParametersGeneratePublicKey = ed25519PrivateKeyParameters.generatePublicKey();
            SSHBuilder sSHBuilder = new SSHBuilder();
            sSHBuilder.writeBytes(AUTH_MAGIC);
            sSHBuilder.writeString("none");
            sSHBuilder.writeString("none");
            sSHBuilder.writeString(BuildConfig.f24315FLAVOR);
            sSHBuilder.m15932u32(1);
            sSHBuilder.writeBlock(OpenSSHPublicKeyUtil.encodePublicKey(ed25519PublicKeyParametersGeneratePublicKey));
            SSHBuilder sSHBuilder2 = new SSHBuilder();
            int iNextInt = CryptoServicesRegistrar.getSecureRandom().nextInt();
            sSHBuilder2.m15932u32(iNextInt);
            sSHBuilder2.m15932u32(iNextInt);
            sSHBuilder2.writeString("ssh-ed25519");
            byte[] encoded = ed25519PublicKeyParametersGeneratePublicKey.getEncoded();
            sSHBuilder2.writeBlock(encoded);
            sSHBuilder2.writeBlock(C6238Arrays.concatenate(ed25519PrivateKeyParameters.getEncoded(), encoded));
            sSHBuilder2.writeString(BuildConfig.f24315FLAVOR);
            sSHBuilder.writeBlock(sSHBuilder2.getPaddedBytes());
            return sSHBuilder.getBytes();
        }
        return PrivateKeyInfoFactory.createPrivateKeyInfo(asymmetricKeyParameter).parsePrivateKey().toASN1Primitive().getEncoded();
    }

    public static AsymmetricKeyParameter parsePrivateKeyBlob(byte[] bArr) {
        AsymmetricKeyParameter rSAPrivateCrtKeyParameters = null;
        if (bArr[0] == 48) {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(bArr);
            if (aSN1Sequence.mo14450size() == 6) {
                if (allIntegers(aSN1Sequence) && ((ASN1Integer) aSN1Sequence.getObjectAt(0)).getPositiveValue().equals(BigIntegers.f24192ZERO)) {
                    rSAPrivateCrtKeyParameters = new DSAPrivateKeyParameters(((ASN1Integer) aSN1Sequence.getObjectAt(5)).getPositiveValue(), new DSAParameters(((ASN1Integer) aSN1Sequence.getObjectAt(1)).getPositiveValue(), ((ASN1Integer) aSN1Sequence.getObjectAt(2)).getPositiveValue(), ((ASN1Integer) aSN1Sequence.getObjectAt(3)).getPositiveValue()));
                }
            } else if (aSN1Sequence.mo14450size() == 9) {
                if (allIntegers(aSN1Sequence) && ((ASN1Integer) aSN1Sequence.getObjectAt(0)).getPositiveValue().equals(BigIntegers.f24192ZERO)) {
                    RSAPrivateKey rSAPrivateKey = RSAPrivateKey.getInstance(aSN1Sequence);
                    rSAPrivateCrtKeyParameters = new RSAPrivateCrtKeyParameters(rSAPrivateKey.getModulus(), rSAPrivateKey.getPublicExponent(), rSAPrivateKey.getPrivateExponent(), rSAPrivateKey.getPrime1(), rSAPrivateKey.getPrime2(), rSAPrivateKey.getExponent1(), rSAPrivateKey.getExponent2(), rSAPrivateKey.getCoefficient());
                }
            } else if (aSN1Sequence.mo14450size() == 4 && (aSN1Sequence.getObjectAt(3) instanceof ASN1TaggedObject) && (aSN1Sequence.getObjectAt(2) instanceof ASN1TaggedObject)) {
                ECPrivateKey eCPrivateKey = ECPrivateKey.getInstance(aSN1Sequence);
                X962Parameters x962Parameters = X962Parameters.getInstance(eCPrivateKey.getParametersObject().toASN1Primitive());
                boolean zIsNamedCurve = x962Parameters.isNamedCurve();
                ASN1Primitive parameters = x962Parameters.getParameters();
                rSAPrivateCrtKeyParameters = new ECPrivateKeyParameters(eCPrivateKey.m14639getKey(), zIsNamedCurve ? ECNamedDomainParameters.m15725lookup(ASN1ObjectIdentifier.getInstance(parameters)) : new ECDomainParameters(X9ECParameters.getInstance(parameters)));
            }
        } else {
            SSHBuffer sSHBuffer = new SSHBuffer(AUTH_MAGIC, bArr);
            if (!"none".equals(sSHBuffer.readString())) {
                throw new IllegalStateException("encrypted keys not supported");
            }
            sSHBuffer.skipBlock();
            sSHBuffer.skipBlock();
            if (sSHBuffer.m15931readU32() != 1) {
                throw new IllegalStateException("multiple keys not supported");
            }
            OpenSSHPublicKeyUtil.parsePublicKey(sSHBuffer.readBlock());
            byte[] paddedBlock = sSHBuffer.readPaddedBlock();
            if (sSHBuffer.hasRemaining()) {
                throw new IllegalArgumentException("decoded key has trailing data");
            }
            SSHBuffer sSHBuffer2 = new SSHBuffer(paddedBlock);
            if (sSHBuffer2.m15931readU32() != sSHBuffer2.m15931readU32()) {
                throw new IllegalStateException("private key check values are not the same");
            }
            String string = sSHBuffer2.readString();
            if ("ssh-ed25519".equals(string)) {
                sSHBuffer2.readBlock();
                byte[] block = sSHBuffer2.readBlock();
                if (block.length != 64) {
                    throw new IllegalStateException("private key value of wrong length");
                }
                rSAPrivateCrtKeyParameters = new Ed25519PrivateKeyParameters(block, 0);
            } else if (string.startsWith("ecdsa")) {
                ASN1ObjectIdentifier byName = SSHNamedCurves.getByName(C6250Strings.fromByteArray(sSHBuffer2.readBlock()));
                if (byName == null) {
                    throw new IllegalStateException("OID not found for: " + string);
                }
                X9ECParameters byOID = NISTNamedCurves.getByOID(byName);
                if (byOID == null) {
                    throw new IllegalStateException("Curve not found for: " + byName);
                }
                sSHBuffer2.readBlock();
                rSAPrivateCrtKeyParameters = new ECPrivateKeyParameters(new BigInteger(1, sSHBuffer2.readBlock()), new ECNamedDomainParameters(byName, byOID));
            } else if (string.startsWith("ssh-rsa")) {
                BigInteger bigInteger = new BigInteger(1, sSHBuffer2.readBlock());
                BigInteger bigInteger2 = new BigInteger(1, sSHBuffer2.readBlock());
                BigInteger bigInteger3 = new BigInteger(1, sSHBuffer2.readBlock());
                BigInteger bigInteger4 = new BigInteger(1, sSHBuffer2.readBlock());
                BigInteger bigInteger5 = new BigInteger(1, sSHBuffer2.readBlock());
                BigInteger bigInteger6 = new BigInteger(1, sSHBuffer2.readBlock());
                BigInteger bigInteger7 = BigIntegers.f24189ONE;
                rSAPrivateCrtKeyParameters = new RSAPrivateCrtKeyParameters(bigInteger, bigInteger2, bigInteger3, bigInteger5, bigInteger6, bigInteger3.remainder(bigInteger5.subtract(bigInteger7)), bigInteger3.remainder(bigInteger6.subtract(bigInteger7)), bigInteger4);
            }
            sSHBuffer2.skipBlock();
            if (sSHBuffer2.hasRemaining()) {
                throw new IllegalArgumentException("private key block has trailing data");
            }
        }
        if (rSAPrivateCrtKeyParameters != null) {
            return rSAPrivateCrtKeyParameters;
        }
        throw new IllegalArgumentException("unable to parse key");
    }
}
