package org.bouncycastle.p194crypto.p221util;

import java.io.IOException;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import org.bouncycastle.internal.p231asn1.p235edec.EdECObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Null;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.DERTaggedObject;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.RSAPrivateKey;
import org.bouncycastle.p133asn1.p167sec.ECPrivateKey;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.DSAParameter;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ECPoint;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.DSAParameters;
import org.bouncycastle.p194crypto.p213params.DSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.ECDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECGOST3410Parameters;
import org.bouncycastle.p194crypto.p213params.ECNamedDomainParameters;
import org.bouncycastle.p194crypto.p213params.ECPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed448PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p194crypto.p213params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PrivateKeyParameters;
import org.bouncycastle.p284math.p285ec.FixedPointCombMultiplier;

/* loaded from: classes2.dex */
public class PrivateKeyInfoFactory {
    private static Set cryptoProOids;

    static {
        HashSet hashSet = new HashSet(5);
        cryptoProOids = hashSet;
        hashSet.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_A);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_B);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_C);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchA);
        cryptoProOids.add(CryptoProObjectIdentifiers.gostR3410_2001_CryptoPro_XchB);
    }

    private PrivateKeyInfoFactory() {
    }

    public static PrivateKeyInfo createPrivateKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter) {
        return createPrivateKeyInfo(asymmetricKeyParameter, null);
    }

    private static void extractBytes(byte[] bArr, int i, int i2, BigInteger bigInteger) {
        byte[] byteArray = bigInteger.toByteArray();
        if (byteArray.length < i) {
            byte[] bArr2 = new byte[i];
            System.arraycopy(byteArray, 0, bArr2, i - byteArray.length, byteArray.length);
            byteArray = bArr2;
        }
        for (int i3 = 0; i3 != i; i3++) {
            bArr[i2 + i3] = byteArray[(byteArray.length - 1) - i3];
        }
    }

    private static ASN1Sequence getBasicPQCEncoding(byte[] bArr, byte[] bArr2) {
        return new DERSequence(new DEROctetString(bArr), new DEROctetString(bArr2));
    }

    public static PrivateKeyInfo createPrivateKeyInfo(AsymmetricKeyParameter asymmetricKeyParameter, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        int iBitLength;
        X962Parameters x962Parameters;
        BigInteger bigIntegerM15723getN;
        ASN1ObjectIdentifier aSN1ObjectIdentifier;
        if (asymmetricKeyParameter instanceof RSAKeyParameters) {
            RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters = (RSAPrivateCrtKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, C5103DERNull.INSTANCE), new RSAPrivateKey(rSAPrivateCrtKeyParameters.getModulus(), rSAPrivateCrtKeyParameters.getPublicExponent(), rSAPrivateCrtKeyParameters.getExponent(), rSAPrivateCrtKeyParameters.m15808getP(), rSAPrivateCrtKeyParameters.m15809getQ(), rSAPrivateCrtKeyParameters.m15806getDP(), rSAPrivateCrtKeyParameters.m15807getDQ(), rSAPrivateCrtKeyParameters.m15810getQInv()), abstractC5093ASN1Set);
        }
        if (asymmetricKeyParameter instanceof DSAPrivateKeyParameters) {
            DSAPrivateKeyParameters dSAPrivateKeyParameters = (DSAPrivateKeyParameters) asymmetricKeyParameter;
            DSAParameters parameters = dSAPrivateKeyParameters.getParameters();
            return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.f18789id_dsa, new DSAParameter(parameters.m15705getP(), parameters.m15706getQ(), parameters.m15704getG())), new ASN1Integer(dSAPrivateKeyParameters.m15707getX()), abstractC5093ASN1Set);
        }
        if (!(asymmetricKeyParameter instanceof ECPrivateKeyParameters)) {
            if (asymmetricKeyParameter instanceof MLDSAPrivateKeyParameters) {
                MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters = (MLDSAPrivateKeyParameters) asymmetricKeyParameter;
                AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(C5431Utils.mldsaOidLookup(mLDSAPrivateKeyParameters.getParameters()));
                return mLDSAPrivateKeyParameters.getPreferredFormat() == 1 ? new PrivateKeyInfo(algorithmIdentifier, new DERTaggedObject(false, 0, (ASN1Encodable) new DEROctetString(mLDSAPrivateKeyParameters.m15783getSeed())), abstractC5093ASN1Set) : mLDSAPrivateKeyParameters.getPreferredFormat() == 2 ? new PrivateKeyInfo(algorithmIdentifier, new DEROctetString(mLDSAPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set) : new PrivateKeyInfo(algorithmIdentifier, getBasicPQCEncoding(mLDSAPrivateKeyParameters.m15783getSeed(), mLDSAPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
            }
            if (asymmetricKeyParameter instanceof MLKEMPrivateKeyParameters) {
                MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters = (MLKEMPrivateKeyParameters) asymmetricKeyParameter;
                AlgorithmIdentifier algorithmIdentifier2 = new AlgorithmIdentifier(C5431Utils.mlkemOidLookup(mLKEMPrivateKeyParameters.getParameters()));
                return mLKEMPrivateKeyParameters.getPreferredFormat() == 1 ? new PrivateKeyInfo(algorithmIdentifier2, new DERTaggedObject(false, 0, (ASN1Encodable) new DEROctetString(mLKEMPrivateKeyParameters.m15794getSeed())), abstractC5093ASN1Set) : mLKEMPrivateKeyParameters.getPreferredFormat() == 2 ? new PrivateKeyInfo(algorithmIdentifier2, new DEROctetString(mLKEMPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set) : new PrivateKeyInfo(algorithmIdentifier2, getBasicPQCEncoding(mLKEMPrivateKeyParameters.m15794getSeed(), mLKEMPrivateKeyParameters.getEncoded()), abstractC5093ASN1Set);
            }
            if (asymmetricKeyParameter instanceof SLHDSAPrivateKeyParameters) {
                SLHDSAPrivateKeyParameters sLHDSAPrivateKeyParameters = (SLHDSAPrivateKeyParameters) asymmetricKeyParameter;
                return new PrivateKeyInfo(new AlgorithmIdentifier(C5431Utils.slhdsaOidLookup(sLHDSAPrivateKeyParameters.getParameters())), sLHDSAPrivateKeyParameters.getEncoded(), abstractC5093ASN1Set);
            }
            if (asymmetricKeyParameter instanceof X448PrivateKeyParameters) {
                X448PrivateKeyParameters x448PrivateKeyParameters = (X448PrivateKeyParameters) asymmetricKeyParameter;
                return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.f21248id_X448), new DEROctetString(x448PrivateKeyParameters.getEncoded()), abstractC5093ASN1Set, x448PrivateKeyParameters.generatePublicKey().getEncoded());
            }
            if (asymmetricKeyParameter instanceof X25519PrivateKeyParameters) {
                X25519PrivateKeyParameters x25519PrivateKeyParameters = (X25519PrivateKeyParameters) asymmetricKeyParameter;
                return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_X25519), new DEROctetString(x25519PrivateKeyParameters.getEncoded()), abstractC5093ASN1Set, x25519PrivateKeyParameters.generatePublicKey().getEncoded());
            }
            if (asymmetricKeyParameter instanceof Ed448PrivateKeyParameters) {
                Ed448PrivateKeyParameters ed448PrivateKeyParameters = (Ed448PrivateKeyParameters) asymmetricKeyParameter;
                return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed448), new DEROctetString(ed448PrivateKeyParameters.getEncoded()), abstractC5093ASN1Set, ed448PrivateKeyParameters.generatePublicKey().getEncoded());
            }
            if (!(asymmetricKeyParameter instanceof Ed25519PrivateKeyParameters)) {
                throw new IOException("key parameters not recognized");
            }
            Ed25519PrivateKeyParameters ed25519PrivateKeyParameters = (Ed25519PrivateKeyParameters) asymmetricKeyParameter;
            return new PrivateKeyInfo(new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519), new DEROctetString(ed25519PrivateKeyParameters.getEncoded()), abstractC5093ASN1Set, ed25519PrivateKeyParameters.generatePublicKey().getEncoded());
        }
        ECPrivateKeyParameters eCPrivateKeyParameters = (ECPrivateKeyParameters) asymmetricKeyParameter;
        ECDomainParameters parameters2 = eCPrivateKeyParameters.getParameters();
        if (parameters2 == null) {
            x962Parameters = new X962Parameters((ASN1Null) C5103DERNull.INSTANCE);
            bigIntegerM15723getN = eCPrivateKeyParameters.m15727getD();
        } else {
            if (parameters2 instanceof ECGOST3410Parameters) {
                ECGOST3410Parameters eCGOST3410Parameters = (ECGOST3410Parameters) parameters2;
                GOST3410PublicKeyAlgParameters gOST3410PublicKeyAlgParameters = new GOST3410PublicKeyAlgParameters(eCGOST3410Parameters.getPublicKeyParamSet(), eCGOST3410Parameters.getDigestParamSet(), eCGOST3410Parameters.getEncryptionParamSet());
                int i = 32;
                if (cryptoProOids.contains(gOST3410PublicKeyAlgParameters.getPublicKeyParamSet())) {
                    aSN1ObjectIdentifier = CryptoProObjectIdentifiers.gostR3410_2001;
                } else {
                    boolean z = eCPrivateKeyParameters.m15727getD().bitLength() > 256;
                    aSN1ObjectIdentifier = z ? RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512 : RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256;
                    if (z) {
                        i = 64;
                    }
                }
                byte[] bArr = new byte[i];
                extractBytes(bArr, i, 0, eCPrivateKeyParameters.m15727getD());
                return new PrivateKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, gOST3410PublicKeyAlgParameters), new DEROctetString(bArr));
            }
            if (!(parameters2 instanceof ECNamedDomainParameters)) {
                X962Parameters x962Parameters2 = new X962Parameters(new X9ECParameters(parameters2.getCurve(), new X9ECPoint(parameters2.m15720getG(), false), parameters2.m15723getN(), parameters2.m15721getH(), parameters2.m15724getSeed()));
                iBitLength = parameters2.m15723getN().bitLength();
                x962Parameters = x962Parameters2;
                return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters), new ECPrivateKey(iBitLength, eCPrivateKeyParameters.m15727getD(), new DERBitString(new FixedPointCombMultiplier().multiply(parameters2.m15720getG(), eCPrivateKeyParameters.m15727getD()).getEncoded(false)), x962Parameters), abstractC5093ASN1Set);
            }
            x962Parameters = new X962Parameters(((ECNamedDomainParameters) parameters2).m15726getName());
            bigIntegerM15723getN = parameters2.m15723getN();
        }
        iBitLength = bigIntegerM15723getN.bitLength();
        return new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, x962Parameters), new ECPrivateKey(iBitLength, eCPrivateKeyParameters.m15727getD(), new DERBitString(new FixedPointCombMultiplier().multiply(parameters2.m15720getG(), eCPrivateKeyParameters.m15727getD()).getEncoded(false)), x962Parameters), abstractC5093ASN1Set);
    }
}
