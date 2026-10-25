package org.bouncycastle.p281jce.provider;

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
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.p213params.ElGamalPrivateKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.p281jce.interfaces.ElGamalPrivateKey;
import org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.p281jce.p282spec.ElGamalParameterSpec;
import org.bouncycastle.p281jce.p282spec.ElGamalPrivateKeySpec;

/* loaded from: classes2.dex */
public class JCEElGamalPrivateKey implements ElGamalPrivateKey, DHPrivateKey, PKCS12BagAttributeCarrier {
    static final long serialVersionUID = 4819350091141529678L;
    private PKCS12BagAttributeCarrierImpl attrCarrier = new PKCS12BagAttributeCarrierImpl();

    /* renamed from: elSpec */
    ElGamalParameterSpec f22005elSpec;

    /* renamed from: x */
    BigInteger f22006x;

    public JCEElGamalPrivateKey() {
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f22006x = (BigInteger) objectInputStream.readObject();
        this.f22005elSpec = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getX());
        objectOutputStream.writeObject(this.f22005elSpec.m16276getP());
        objectOutputStream.writeObject(this.f22005elSpec.m16275getG());
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
        return C5621KeyUtil.getEncodedPrivateKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.f22005elSpec.m16276getP(), this.f22005elSpec.m16275getG())), new ASN1Integer(getX()));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.p281jce.interfaces.ElGamalKey
    public ElGamalParameterSpec getParameters() {
        return this.f22005elSpec;
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.f22005elSpec.m16276getP(), this.f22005elSpec.m16275getG());
    }

    @Override // org.bouncycastle.p281jce.interfaces.ElGamalPrivateKey, javax.crypto.interfaces.DHPrivateKey
    public BigInteger getX() {
        return this.f22006x;
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

    public JCEElGamalPrivateKey(DHPrivateKey dHPrivateKey) {
        this.f22006x = dHPrivateKey.getX();
        this.f22005elSpec = new ElGamalParameterSpec(dHPrivateKey.getParams().getP(), dHPrivateKey.getParams().getG());
    }

    public JCEElGamalPrivateKey(DHPrivateKeySpec dHPrivateKeySpec) {
        this.f22006x = dHPrivateKeySpec.getX();
        this.f22005elSpec = new ElGamalParameterSpec(dHPrivateKeySpec.getP(), dHPrivateKeySpec.getG());
    }

    public JCEElGamalPrivateKey(PrivateKeyInfo privateKeyInfo) {
        ElGamalParameter elGamalParameter = ElGamalParameter.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
        this.f22006x = ASN1Integer.getInstance(privateKeyInfo.parsePrivateKey()).getValue();
        this.f22005elSpec = new ElGamalParameterSpec(elGamalParameter.m15991getP(), elGamalParameter.m15990getG());
    }

    public JCEElGamalPrivateKey(ElGamalPrivateKeyParameters elGamalPrivateKeyParameters) {
        this.f22006x = elGamalPrivateKeyParameters.m15746getX();
        this.f22005elSpec = new ElGamalParameterSpec(elGamalPrivateKeyParameters.getParameters().m15745getP(), elGamalPrivateKeyParameters.getParameters().m15743getG());
    }

    public JCEElGamalPrivateKey(ElGamalPrivateKey elGamalPrivateKey) {
        this.f22006x = elGamalPrivateKey.getX();
        this.f22005elSpec = elGamalPrivateKey.getParameters();
    }

    public JCEElGamalPrivateKey(ElGamalPrivateKeySpec elGamalPrivateKeySpec) {
        this.f22006x = elGamalPrivateKeySpec.m16277getX();
        this.f22005elSpec = new ElGamalParameterSpec(elGamalPrivateKeySpec.getParams().m16276getP(), elGamalPrivateKeySpec.getParams().m16275getG());
    }
}
