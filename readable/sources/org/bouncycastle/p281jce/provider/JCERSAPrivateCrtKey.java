package org.bouncycastle.p281jce.provider;

import java.math.BigInteger;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.RSAPrivateCrtKeySpec;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.RSAPrivateKey;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.p213params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class JCERSAPrivateCrtKey extends JCERSAPrivateKey implements RSAPrivateCrtKey {
    static final long serialVersionUID = 7834723820638524718L;
    private BigInteger crtCoefficient;
    private BigInteger primeExponentP;
    private BigInteger primeExponentQ;

    /* renamed from: primeP */
    private BigInteger f22009primeP;

    /* renamed from: primeQ */
    private BigInteger f22010primeQ;
    private BigInteger publicExponent;

    public JCERSAPrivateCrtKey(RSAPrivateCrtKey rSAPrivateCrtKey) {
        this.f22012modulus = rSAPrivateCrtKey.getModulus();
        this.publicExponent = rSAPrivateCrtKey.getPublicExponent();
        this.privateExponent = rSAPrivateCrtKey.getPrivateExponent();
        this.f22009primeP = rSAPrivateCrtKey.getPrimeP();
        this.f22010primeQ = rSAPrivateCrtKey.getPrimeQ();
        this.primeExponentP = rSAPrivateCrtKey.getPrimeExponentP();
        this.primeExponentQ = rSAPrivateCrtKey.getPrimeExponentQ();
        this.crtCoefficient = rSAPrivateCrtKey.getCrtCoefficient();
    }

    @Override // org.bouncycastle.p281jce.provider.JCERSAPrivateKey
    /* renamed from: equals */
    public boolean mo16242equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RSAPrivateCrtKey)) {
            return false;
        }
        RSAPrivateCrtKey rSAPrivateCrtKey = (RSAPrivateCrtKey) obj;
        return getModulus().equals(rSAPrivateCrtKey.getModulus()) && getPublicExponent().equals(rSAPrivateCrtKey.getPublicExponent()) && getPrivateExponent().equals(rSAPrivateCrtKey.getPrivateExponent()) && getPrimeP().equals(rSAPrivateCrtKey.getPrimeP()) && getPrimeQ().equals(rSAPrivateCrtKey.getPrimeQ()) && getPrimeExponentP().equals(rSAPrivateCrtKey.getPrimeExponentP()) && getPrimeExponentQ().equals(rSAPrivateCrtKey.getPrimeExponentQ()) && getCrtCoefficient().equals(rSAPrivateCrtKey.getCrtCoefficient());
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getCrtCoefficient() {
        return this.crtCoefficient;
    }

    @Override // org.bouncycastle.p281jce.provider.JCERSAPrivateKey, java.security.Key
    public byte[] getEncoded() {
        return C5621KeyUtil.getEncodedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, C5103DERNull.INSTANCE), new RSAPrivateKey(getModulus(), getPublicExponent(), getPrivateExponent(), getPrimeP(), getPrimeQ(), getPrimeExponentP(), getPrimeExponentQ(), getCrtCoefficient()));
    }

    @Override // org.bouncycastle.p281jce.provider.JCERSAPrivateKey, java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentP() {
        return this.primeExponentP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeExponentQ() {
        return this.primeExponentQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeP() {
        return this.f22009primeP;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPrimeQ() {
        return this.f22010primeQ;
    }

    @Override // java.security.interfaces.RSAPrivateCrtKey
    public BigInteger getPublicExponent() {
        return this.publicExponent;
    }

    @Override // org.bouncycastle.p281jce.provider.JCERSAPrivateKey
    public int hashCode() {
        return getPrivateExponent().hashCode() ^ (getModulus().hashCode() ^ getPublicExponent().hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append("RSA Private CRT Key");
        sb.append(strLineSeparator);
        sb.append("            modulus: ");
        sb.append(getModulus().toString(16));
        sb.append(strLineSeparator);
        sb.append("    public exponent: ");
        sb.append(getPublicExponent().toString(16));
        sb.append(strLineSeparator);
        sb.append("   private exponent: ");
        sb.append(getPrivateExponent().toString(16));
        sb.append(strLineSeparator);
        sb.append("             primeP: ");
        sb.append(getPrimeP().toString(16));
        sb.append(strLineSeparator);
        sb.append("             primeQ: ");
        sb.append(getPrimeQ().toString(16));
        sb.append(strLineSeparator);
        sb.append("     primeExponentP: ");
        sb.append(getPrimeExponentP().toString(16));
        sb.append(strLineSeparator);
        sb.append("     primeExponentQ: ");
        sb.append(getPrimeExponentQ().toString(16));
        sb.append(strLineSeparator);
        sb.append("     crtCoefficient: ");
        sb.append(getCrtCoefficient().toString(16));
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public JCERSAPrivateCrtKey(RSAPrivateCrtKeySpec rSAPrivateCrtKeySpec) {
        this.f22012modulus = rSAPrivateCrtKeySpec.getModulus();
        this.publicExponent = rSAPrivateCrtKeySpec.getPublicExponent();
        this.privateExponent = rSAPrivateCrtKeySpec.getPrivateExponent();
        this.f22009primeP = rSAPrivateCrtKeySpec.getPrimeP();
        this.f22010primeQ = rSAPrivateCrtKeySpec.getPrimeQ();
        this.primeExponentP = rSAPrivateCrtKeySpec.getPrimeExponentP();
        this.primeExponentQ = rSAPrivateCrtKeySpec.getPrimeExponentQ();
        this.crtCoefficient = rSAPrivateCrtKeySpec.getCrtCoefficient();
    }

    public JCERSAPrivateCrtKey(PrivateKeyInfo privateKeyInfo) {
        this(RSAPrivateKey.getInstance(privateKeyInfo.parsePrivateKey()));
    }

    public JCERSAPrivateCrtKey(RSAPrivateKey rSAPrivateKey) {
        this.f22012modulus = rSAPrivateKey.getModulus();
        this.publicExponent = rSAPrivateKey.getPublicExponent();
        this.privateExponent = rSAPrivateKey.getPrivateExponent();
        this.f22009primeP = rSAPrivateKey.getPrime1();
        this.f22010primeQ = rSAPrivateKey.getPrime2();
        this.primeExponentP = rSAPrivateKey.getExponent1();
        this.primeExponentQ = rSAPrivateKey.getExponent2();
        this.crtCoefficient = rSAPrivateKey.getCoefficient();
    }

    public JCERSAPrivateCrtKey(RSAPrivateCrtKeyParameters rSAPrivateCrtKeyParameters) {
        super(rSAPrivateCrtKeyParameters);
        this.publicExponent = rSAPrivateCrtKeyParameters.getPublicExponent();
        this.f22009primeP = rSAPrivateCrtKeyParameters.m15808getP();
        this.f22010primeQ = rSAPrivateCrtKeyParameters.m15809getQ();
        this.primeExponentP = rSAPrivateCrtKeyParameters.m15806getDP();
        this.primeExponentQ = rSAPrivateCrtKeyParameters.m15807getDQ();
        this.crtCoefficient = rSAPrivateCrtKeyParameters.m15810getQInv();
    }
}
