package org.bouncycastle.p249jcajce.provider.asymmetric.p262rsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.RSAPrivateKey;
import java.security.spec.RSAPrivateKeySpec;
import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p249jcajce.interfaces.InterfaceC5484BCKey;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCRSAPrivateKey implements RSAPrivateKey, PKCS12BagAttributeCarrier, InterfaceC5484BCKey {

    /* renamed from: ZERO */
    private static BigInteger f21594ZERO = BigInteger.valueOf(0);
    static final long serialVersionUID = 5110188922551353628L;
    protected transient AlgorithmIdentifier algorithmIdentifier;
    private byte[] algorithmIdentifierEnc;
    protected transient PKCS12BagAttributeCarrierImpl attrCarrier;

    /* renamed from: modulus */
    protected BigInteger f21595modulus;
    protected BigInteger privateExponent;
    protected transient RSAKeyParameters rsaPrivateKey;

    public BCRSAPrivateKey(RSAPrivateKey rSAPrivateKey) {
        AlgorithmIdentifier algorithmIdentifier = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.algorithmIdentifierEnc = getEncoding(algorithmIdentifier);
        this.algorithmIdentifier = algorithmIdentifier;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21595modulus = rSAPrivateKey.getModulus();
        this.privateExponent = rSAPrivateKey.getPrivateExponent();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.f21595modulus, this.privateExponent);
    }

    private static byte[] getEncoding(AlgorithmIdentifier algorithmIdentifier) {
        try {
            return algorithmIdentifier.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        if (this.algorithmIdentifierEnc == null) {
            this.algorithmIdentifierEnc = getEncoding(BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER);
        }
        this.algorithmIdentifier = AlgorithmIdentifier.getInstance(this.algorithmIdentifierEnc);
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.f21595modulus, this.privateExponent);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
    }

    public RSAKeyParameters engineGetKeyParameters() {
        return this.rsaPrivateKey;
    }

    /* renamed from: equals */
    public boolean mo16129equals(Object obj) {
        if (!(obj instanceof RSAPrivateKey)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) obj;
        return getModulus().equals(rSAPrivateKey.getModulus()) && getPrivateExponent().equals(rSAPrivateKey.getPrivateExponent());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS) ? "RSASSA-PSS" : "RSA";
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.attrCarrier.getBagAttribute(aSN1ObjectIdentifier);
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        AlgorithmIdentifier algorithmIdentifier = this.algorithmIdentifier;
        BigInteger modulus = getModulus();
        BigInteger bigInteger = f21594ZERO;
        BigInteger privateExponent = getPrivateExponent();
        BigInteger bigInteger2 = f21594ZERO;
        return C5621KeyUtil.getEncodedPrivateKeyInfo(algorithmIdentifier, new org.bouncycastle.p133asn1.p166pkcs.RSAPrivateKey(modulus, bigInteger, privateExponent, bigInteger2, bigInteger2, bigInteger2, bigInteger2, bigInteger2));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAKey
    public BigInteger getModulus() {
        return this.f21595modulus;
    }

    @Override // java.security.interfaces.RSAPrivateKey
    public BigInteger getPrivateExponent() {
        return this.privateExponent;
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public boolean hasFriendlyName() {
        return this.attrCarrier.hasFriendlyName();
    }

    public int hashCode() {
        return getPrivateExponent().hashCode() ^ getModulus().hashCode();
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.attrCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public void setFriendlyName(String str) {
        this.attrCarrier.setFriendlyName(str);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append("RSA Private Key [");
        sb.append(C5606RSAUtil.generateKeyFingerprint(getModulus()));
        sb.append("],[]");
        sb.append(strLineSeparator);
        sb.append("            modulus: ");
        sb.append(getModulus().toString(16));
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public BCRSAPrivateKey(RSAPrivateKeySpec rSAPrivateKeySpec) {
        AlgorithmIdentifier algorithmIdentifier = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.algorithmIdentifierEnc = getEncoding(algorithmIdentifier);
        this.algorithmIdentifier = algorithmIdentifier;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21595modulus = rSAPrivateKeySpec.getModulus();
        this.privateExponent = rSAPrivateKeySpec.getPrivateExponent();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.f21595modulus, this.privateExponent);
    }

    public BCRSAPrivateKey(AlgorithmIdentifier algorithmIdentifier, org.bouncycastle.p133asn1.p166pkcs.RSAPrivateKey rSAPrivateKey) {
        AlgorithmIdentifier algorithmIdentifier2 = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.algorithmIdentifierEnc = getEncoding(algorithmIdentifier2);
        this.algorithmIdentifier = algorithmIdentifier2;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithmIdentifier = algorithmIdentifier;
        this.algorithmIdentifierEnc = getEncoding(algorithmIdentifier);
        this.f21595modulus = rSAPrivateKey.getModulus();
        this.privateExponent = rSAPrivateKey.getPrivateExponent();
        this.rsaPrivateKey = new RSAKeyParameters(true, this.f21595modulus, this.privateExponent);
    }

    public BCRSAPrivateKey(AlgorithmIdentifier algorithmIdentifier, RSAKeyParameters rSAKeyParameters) {
        AlgorithmIdentifier algorithmIdentifier2 = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.algorithmIdentifierEnc = getEncoding(algorithmIdentifier2);
        this.algorithmIdentifier = algorithmIdentifier2;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.algorithmIdentifier = algorithmIdentifier;
        this.algorithmIdentifierEnc = getEncoding(algorithmIdentifier);
        this.f21595modulus = rSAKeyParameters.getModulus();
        this.privateExponent = rSAKeyParameters.getExponent();
        this.rsaPrivateKey = rSAKeyParameters;
    }

    public BCRSAPrivateKey(RSAKeyParameters rSAKeyParameters) {
        AlgorithmIdentifier algorithmIdentifier = BCRSAPublicKey.DEFAULT_ALGORITHM_IDENTIFIER;
        this.algorithmIdentifierEnc = getEncoding(algorithmIdentifier);
        this.algorithmIdentifier = algorithmIdentifier;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
        this.f21595modulus = rSAKeyParameters.getModulus();
        this.privateExponent = rSAKeyParameters.getExponent();
        this.rsaPrivateKey = rSAKeyParameters;
    }
}
