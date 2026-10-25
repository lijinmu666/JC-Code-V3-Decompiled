package org.bouncycastle.p249jcajce.provider.asymmetric.p257elgamal;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.internal.p231asn1.p245oiw.ElGamalParameter;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.ElGamalPublicKeyParameters;
import org.bouncycastle.p281jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.p281jce.p282spec.ElGamalParameterSpec;
import org.bouncycastle.p281jce.p282spec.ElGamalPublicKeySpec;

/* loaded from: classes2.dex */
public class BCElGamalPublicKey implements ElGamalPublicKey, DHPublicKey {
    static final long serialVersionUID = 8712728417091216948L;

    /* renamed from: elSpec */
    private transient ElGamalParameterSpec f21557elSpec;

    /* renamed from: y */
    private BigInteger f21558y;

    public BCElGamalPublicKey(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        this.f21558y = bigInteger;
        this.f21557elSpec = elGamalParameterSpec;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f21557elSpec = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f21557elSpec.m16276getP());
        objectOutputStream.writeObject(this.f21557elSpec.m16275getG());
    }

    /* renamed from: equals */
    public boolean m16113equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        return getY().equals(dHPublicKey.getY()) && getParams().getG().equals(dHPublicKey.getParams().getG()) && getParams().getP().equals(dHPublicKey.getParams().getP()) && getParams().getL() == dHPublicKey.getParams().getL();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return new SubjectPublicKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.f21557elSpec.m16276getP(), this.f21557elSpec.m16275getG())), new ASN1Integer(this.f21558y)).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.p281jce.interfaces.ElGamalKey
    public ElGamalParameterSpec getParameters() {
        return this.f21557elSpec;
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.f21557elSpec.m16276getP(), this.f21557elSpec.m16275getG());
    }

    @Override // org.bouncycastle.p281jce.interfaces.ElGamalPublicKey, javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.f21558y;
    }

    public int hashCode() {
        return getParams().getL() ^ ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode());
    }

    public BCElGamalPublicKey(DHPublicKey dHPublicKey) {
        this.f21558y = dHPublicKey.getY();
        this.f21557elSpec = new ElGamalParameterSpec(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
    }

    public BCElGamalPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f21558y = dHPublicKeySpec.getY();
        this.f21557elSpec = new ElGamalParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    public BCElGamalPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ElGamalParameter elGamalParameter = ElGamalParameter.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
        try {
            this.f21558y = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            this.f21557elSpec = new ElGamalParameterSpec(elGamalParameter.m15991getP(), elGamalParameter.m15990getG());
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    public BCElGamalPublicKey(ElGamalPublicKeyParameters elGamalPublicKeyParameters) {
        this.f21558y = elGamalPublicKeyParameters.m15747getY();
        this.f21557elSpec = new ElGamalParameterSpec(elGamalPublicKeyParameters.getParameters().m15745getP(), elGamalPublicKeyParameters.getParameters().m15743getG());
    }

    public BCElGamalPublicKey(ElGamalPublicKey elGamalPublicKey) {
        this.f21558y = elGamalPublicKey.getY();
        this.f21557elSpec = elGamalPublicKey.getParameters();
    }

    public BCElGamalPublicKey(ElGamalPublicKeySpec elGamalPublicKeySpec) {
        this.f21558y = elGamalPublicKeySpec.m16278getY();
        this.f21557elSpec = new ElGamalParameterSpec(elGamalPublicKeySpec.getParams().m16276getP(), elGamalPublicKeySpec.getParams().m16275getG());
    }
}
