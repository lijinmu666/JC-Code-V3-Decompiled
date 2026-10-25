package org.bouncycastle.p281jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.internal.p231asn1.p245oiw.ElGamalParameter;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.ElGamalPublicKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;
import org.bouncycastle.p281jce.interfaces.ElGamalPublicKey;
import org.bouncycastle.p281jce.p282spec.ElGamalParameterSpec;
import org.bouncycastle.p281jce.p282spec.ElGamalPublicKeySpec;

/* loaded from: classes2.dex */
public class JCEElGamalPublicKey implements ElGamalPublicKey, DHPublicKey {
    static final long serialVersionUID = 8712728417091216948L;

    /* renamed from: elSpec */
    private ElGamalParameterSpec f22007elSpec;

    /* renamed from: y */
    private BigInteger f22008y;

    public JCEElGamalPublicKey(BigInteger bigInteger, ElGamalParameterSpec elGamalParameterSpec) {
        this.f22008y = bigInteger;
        this.f22007elSpec = elGamalParameterSpec;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f22008y = (BigInteger) objectInputStream.readObject();
        this.f22007elSpec = new ElGamalParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.f22007elSpec.m16276getP());
        objectOutputStream.writeObject(this.f22007elSpec.m16275getG());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "ElGamal";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return C5621KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalParameter(this.f22007elSpec.m16276getP(), this.f22007elSpec.m16275getG())), new ASN1Integer(this.f22008y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.p281jce.interfaces.ElGamalKey
    public ElGamalParameterSpec getParameters() {
        return this.f22007elSpec;
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return new DHParameterSpec(this.f22007elSpec.m16276getP(), this.f22007elSpec.m16275getG());
    }

    @Override // org.bouncycastle.p281jce.interfaces.ElGamalPublicKey, javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.f22008y;
    }

    public JCEElGamalPublicKey(DHPublicKey dHPublicKey) {
        this.f22008y = dHPublicKey.getY();
        this.f22007elSpec = new ElGamalParameterSpec(dHPublicKey.getParams().getP(), dHPublicKey.getParams().getG());
    }

    public JCEElGamalPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f22008y = dHPublicKeySpec.getY();
        this.f22007elSpec = new ElGamalParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    public JCEElGamalPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        ElGamalParameter elGamalParameter = ElGamalParameter.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
        try {
            this.f22008y = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            this.f22007elSpec = new ElGamalParameterSpec(elGamalParameter.m15991getP(), elGamalParameter.m15990getG());
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    public JCEElGamalPublicKey(ElGamalPublicKeyParameters elGamalPublicKeyParameters) {
        this.f22008y = elGamalPublicKeyParameters.m15747getY();
        this.f22007elSpec = new ElGamalParameterSpec(elGamalPublicKeyParameters.getParameters().m15745getP(), elGamalPublicKeyParameters.getParameters().m15743getG());
    }

    public JCEElGamalPublicKey(ElGamalPublicKey elGamalPublicKey) {
        this.f22008y = elGamalPublicKey.getY();
        this.f22007elSpec = elGamalPublicKey.getParameters();
    }

    public JCEElGamalPublicKey(ElGamalPublicKeySpec elGamalPublicKeySpec) {
        this.f22008y = elGamalPublicKeySpec.m16278getY();
        this.f22007elSpec = new ElGamalParameterSpec(elGamalPublicKeySpec.getParams().m16276getP(), elGamalPublicKeySpec.getParams().m16275getG());
    }
}
