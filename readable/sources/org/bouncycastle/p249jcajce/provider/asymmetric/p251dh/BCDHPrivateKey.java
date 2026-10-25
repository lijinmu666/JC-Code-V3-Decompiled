package org.bouncycastle.p249jcajce.provider.asymmetric.p251dh;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p166pkcs.DHParameter;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p176x9.DomainParameters;
import org.bouncycastle.p133asn1.p176x9.ValidationParams;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.DHValidationParameters;
import org.bouncycastle.p249jcajce.p279spec.DHDomainParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.DHExtendedPrivateKeySpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier;

/* loaded from: classes2.dex */
public class BCDHPrivateKey implements DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 311058815616901812L;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();
    private transient DHPrivateKeyParameters dhPrivateKey;

    /* renamed from: dhSpec */
    private transient DHParameterSpec f21420dhSpec;

    /* renamed from: info */
    private transient PrivateKeyInfo f21421info;

    /* renamed from: x */
    private BigInteger f21422x;

    public BCDHPrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f21420dhSpec = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.f21421info = null;
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f21420dhSpec.getP());
        objectOutputStream.writeObject(this.f21420dhSpec.getG());
        objectOutputStream.writeInt(this.f21420dhSpec.getL());
    }

    public DHPrivateKeyParameters engineGetKeyParameters() {
        DHPrivateKeyParameters dHPrivateKeyParameters = this.dhPrivateKey;
        if (dHPrivateKeyParameters != null) {
            return dHPrivateKeyParameters;
        }
        DHParameterSpec dHParameterSpec = this.f21420dhSpec;
        return dHParameterSpec instanceof DHDomainParameterSpec ? new DHPrivateKeyParameters(this.f21422x, ((DHDomainParameterSpec) dHParameterSpec).getDomainParameters()) : new DHPrivateKeyParameters(this.f21422x, new DHParameters(dHParameterSpec.getP(), this.f21420dhSpec.getG(), null, this.f21420dhSpec.getL()));
    }

    /* renamed from: equals */
    public boolean m16088equals(Object obj) {
        if (!(obj instanceof DHPrivateKey)) {
            return false;
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) obj;
        return getX().equals(dHPrivateKey.getX()) && getParams().getG().equals(dHPrivateKey.getParams().getG()) && getParams().getP().equals(dHPrivateKey.getParams().getP()) && getParams().getL() == dHPrivateKey.getParams().getL();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
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
        PrivateKeyInfo privateKeyInfo;
        try {
            PrivateKeyInfo privateKeyInfo2 = this.f21421info;
            if (privateKeyInfo2 != null) {
                return privateKeyInfo2.getEncoded(ASN1Encoding.f17902DER);
            }
            DHParameterSpec dHParameterSpec = this.f21420dhSpec;
            if (!(dHParameterSpec instanceof DHDomainParameterSpec) || ((DHDomainParameterSpec) dHParameterSpec).m16187getQ() == null) {
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.f21420dhSpec.getP(), this.f21420dhSpec.getG(), this.f21420dhSpec.getL()).toASN1Primitive()), new ASN1Integer(getX()));
            } else {
                DHParameters domainParameters = ((DHDomainParameterSpec) this.f21420dhSpec).getDomainParameters();
                DHValidationParameters validationParameters = domainParameters.getValidationParameters();
                privateKeyInfo = new PrivateKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.dhpublicnumber, new DomainParameters(domainParameters.m15695getP(), domainParameters.m15691getG(), domainParameters.m15696getQ(), domainParameters.m15692getJ(), validationParameters != null ? new ValidationParams(validationParameters.m15700getSeed(), validationParameters.getCounter()) : null).toASN1Primitive()), new ASN1Integer(getX()));
            }
            return privateKeyInfo.getEncoded(ASN1Encoding.f17902DER);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.f21420dhSpec;
    }

    @Override // javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        return this.f21422x;
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public boolean hasFriendlyName() {
        return this.attrCarrier.hasFriendlyName();
    }

    public int hashCode() {
        return getParams().getL() ^ ((getX().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode());
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
        return C5506DHUtil.privateKeyToString("DH", this.f21422x, new DHParameters(this.f21420dhSpec.getP(), this.f21420dhSpec.getG()));
    }

    public BCDHPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f21422x = dHPrivateKey.getX();
        this.f21420dhSpec = dHPrivateKey.getParams();
    }

    public BCDHPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f21422x = dHPrivateKeySpec.getX();
        if (dHPrivateKeySpec instanceof DHExtendedPrivateKeySpec) {
            this.f21420dhSpec = ((DHExtendedPrivateKeySpec) dHPrivateKeySpec).getParams();
        } else {
            this.f21420dhSpec = new DHParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
        }
    }

    public BCDHPrivateKey(PrivateKeyInfo privateKeyInfo) {
        DHPrivateKeyParameters dHPrivateKeyParameters;
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        ASN1Integer aSN1Integer = (ASN1Integer) privateKeyInfo.parsePrivateKey();
        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        this.f21421info = privateKeyInfo;
        this.f21422x = aSN1Integer.getValue();
        if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.dhKeyAgreement)) {
            DHParameter dHParameter = DHParameter.getInstance(aSN1Sequence);
            if (dHParameter.m14628getL() != null) {
                this.f21420dhSpec = new DHParameterSpec(dHParameter.m14629getP(), dHParameter.m14627getG(), dHParameter.m14628getL().intValue());
                dHPrivateKeyParameters = new DHPrivateKeyParameters(this.f21422x, new DHParameters(dHParameter.m14629getP(), dHParameter.m14627getG(), null, dHParameter.m14628getL().intValue()));
            } else {
                this.f21420dhSpec = new DHParameterSpec(dHParameter.m14629getP(), dHParameter.m14627getG());
                dHPrivateKeyParameters = new DHPrivateKeyParameters(this.f21422x, new DHParameters(dHParameter.m14629getP(), dHParameter.m14627getG()));
            }
        } else {
            if (!algorithm.m14446equals((ASN1Primitive) X9ObjectIdentifiers.dhpublicnumber)) {
                throw new IllegalArgumentException("unknown algorithm type: " + algorithm);
            }
            DomainParameters domainParameters = DomainParameters.getInstance(aSN1Sequence);
            this.f21420dhSpec = new DHDomainParameterSpec(domainParameters.m14725getP(), domainParameters.m14726getQ(), domainParameters.m14723getG(), domainParameters.m14724getJ(), 0);
            dHPrivateKeyParameters = new DHPrivateKeyParameters(this.f21422x, new DHParameters(domainParameters.m14725getP(), domainParameters.m14723getG(), domainParameters.m14726getQ(), domainParameters.m14724getJ(), (DHValidationParameters) null));
        }
        this.dhPrivateKey = dHPrivateKeyParameters;
    }

    public BCDHPrivateKey(DHPrivateKeyParameters dHPrivateKeyParameters) {
        this.f21422x = dHPrivateKeyParameters.m15697getX();
        this.f21420dhSpec = new DHDomainParameterSpec(dHPrivateKeyParameters.getParameters());
    }
}
