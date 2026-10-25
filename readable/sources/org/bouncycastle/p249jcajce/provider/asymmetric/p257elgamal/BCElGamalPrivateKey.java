package org.bouncycastle.p249jcajce.provider.asymmetric.p257elgamal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.util.Enumeration;
import javax.crypto.interfaces.DHPrivateKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPrivateKeySpec;
import org.bouncycastle.internal.p231asn1.p245oiw.ElGamalParameter;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.p213params.ElGamalPrivateKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.p281jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.p281jce.p282spec.ElGamalParameterSpec;
import org.bouncycastle.p281jce.p282spec.ElGamalPrivateKeySpec;

/* loaded from: classes2.dex */
public class BCElGamalPrivateKey implements ElGamalPrivateKey, DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 4819350091141529678L;
    private transient PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: elSpec */
    private transient ElGamalParameterSpec f21555elSpec;

    /* renamed from: x */
    private BigInteger f21556x;

    public BCElGamalPrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f21555elSpec = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        this.attrCarrier = new PKCS12BagAttributeCarrierImpl();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f21555elSpec.m16276getP());
        objectOutputStream.writeObject(this.f21555elSpec.m16275getG());
    }

    /* renamed from: equals */
    public boolean m16112equals(Object obj) {
        if (!(obj instanceof DHPrivateKey)) {
            return false;
        }
        DHPrivateKey dHPrivateKey = (DHPrivateKey) obj;
        return getX().equals(dHPrivateKey.getX()) && getParams().getG().equals(dHPrivateKey.getParams().getG()) && getParams().getP().equals(dHPrivateKey.getParams().getP()) && getParams().getL() == dHPrivateKey.getParams().getL();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
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
            return new PrivateKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.f21555elSpec.m16276getP(), this.f21555elSpec.m16275getG())), new ASN1Integer(getX())).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.p281jce.interfaces.ElGamalKey
    public ElGamalParameterSpec getParameters() {
        return this.f21555elSpec;
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.f21555elSpec.m16276getP(), this.f21555elSpec.m16275getG());
    }

    @Override // org.bouncycastle.p281jce.interfaces.ElGamalPrivateKey, javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        return this.f21556x;
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

    public BCElGamalPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f21556x = dHPrivateKey.getX();
        this.f21555elSpec = new ElGamalParameterSpec(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
    }

    public BCElGamalPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f21556x = dHPrivateKeySpec.getX();
        this.f21555elSpec = new ElGamalParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    public BCElGamalPrivateKey(PrivateKeyInfo privateKeyInfo) {
        ElGamalParameter elGamalParameter = ElGamalParameter.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        this.f21556x = ASN1Integer.getInstance(privateKeyInfo.parsePrivateKey()).getValue();
        this.f21555elSpec = new ElGamalParameterSpec(elGamalParameter.m15991getP(), elGamalParameter.m15990getG());
    }

    public BCElGamalPrivateKey(ElGamalPrivateKeyParameters elGamalPrivateKeyParameters) {
        this.f21556x = elGamalPrivateKeyParameters.m15746getX();
        this.f21555elSpec = new ElGamalParameterSpec(elGamalPrivateKeyParameters.getParameters().m15745getP(), elGamalPrivateKeyParameters.getParameters().m15743getG());
    }

    public BCElGamalPrivateKey(ElGamalPrivateKey elGamalPrivateKey) {
        this.f21556x = elGamalPrivateKey.getX();
        this.f21555elSpec = elGamalPrivateKey.getParameters();
    }

    public BCElGamalPrivateKey(ElGamalPrivateKeySpec elGamalPrivateKeySpec) {
        this.f21556x = elGamalPrivateKeySpec.m16277getX();
        this.f21555elSpec = new ElGamalParameterSpec(elGamalPrivateKeySpec.getParams().m16276getP(), elGamalPrivateKeySpec.getParams().m16275getG());
    }
}
