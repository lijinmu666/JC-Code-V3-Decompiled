package org.bouncycastle.p281jce.provider;

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
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.DHPrivateKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier;

/* loaded from: classes2.dex */
public class JCEDHPrivateKey implements DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 311058815616901812L;
    private PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: dhSpec */
    private DHParameterSpec f21995dhSpec;

    /* renamed from: info */
    private PrivateKeyInfo f21996info;

    /* renamed from: x */
    BigInteger f21997x;

    public JCEDHPrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f21997x = (BigInteger) objectInputStream.readObject();
        this.f21995dhSpec = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getX());
        objectOutputStream.writeObject(this.f21995dhSpec.getP());
        objectOutputStream.writeObject(this.f21995dhSpec.getG());
        objectOutputStream.writeInt(this.f21995dhSpec.getL());
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
        try {
            PrivateKeyInfo privateKeyInfo = this.f21996info;
            return privateKeyInfo != null ? privateKeyInfo.getEncoded(ASN1Encoding.f17902DER) : new PrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.f21995dhSpec.getP(), this.f21995dhSpec.getG(), this.f21995dhSpec.getL())), new ASN1Integer(getX())).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.f21995dhSpec;
    }

    @Override // javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        return this.f21997x;
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public boolean hasFriendlyName() {
        return this.attrCarrier.hasFriendlyName();
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.attrCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public void setFriendlyName(String str) {
        this.attrCarrier.setFriendlyName(str);
    }

    public JCEDHPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f21997x = dHPrivateKey.getX();
        this.f21995dhSpec = dHPrivateKey.getParams();
    }

    public JCEDHPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f21997x = dHPrivateKeySpec.getX();
        this.f21995dhSpec = new DHParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    public JCEDHPrivateKey(PrivateKeyInfo privateKeyInfo) {
        DHParameterSpec dHParameterSpec;
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        ASN1Integer aSN1Integer = ASN1Integer.getInstance(privateKeyInfo.parsePrivateKey());
        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        this.f21996info = privateKeyInfo;
        this.f21997x = aSN1Integer.getValue();
        if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.dhKeyAgreement)) {
            DHParameter dHParameter = DHParameter.getInstance(aSN1Sequence);
            dHParameterSpec = dHParameter.m14628getL() != null ? new DHParameterSpec(dHParameter.m14629getP(), dHParameter.m14627getG(), dHParameter.m14628getL().intValue()) : new DHParameterSpec(dHParameter.m14629getP(), dHParameter.m14627getG());
        } else {
            if (!algorithm.m14446equals((ASN1Primitive) X9ObjectIdentifiers.dhpublicnumber)) {
                throw new IllegalArgumentException("unknown algorithm type: " + algorithm);
            }
            DomainParameters domainParameters = DomainParameters.getInstance(aSN1Sequence);
            dHParameterSpec = new DHParameterSpec(domainParameters.m14725getP(), domainParameters.m14723getG());
        }
        this.f21995dhSpec = dHParameterSpec;
    }

    public JCEDHPrivateKey(DHPrivateKeyParameters dHPrivateKeyParameters) {
        this.f21997x = dHPrivateKeyParameters.m15697getX();
        this.f21995dhSpec = new DHParameterSpec(dHPrivateKeyParameters.getParameters().m15695getP(), dHPrivateKeyParameters.getParameters().m15691getG(), dHPrivateKeyParameters.getParameters().m15693getL());
    }
}
