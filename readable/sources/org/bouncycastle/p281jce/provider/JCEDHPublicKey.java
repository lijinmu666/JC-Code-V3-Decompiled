package org.bouncycastle.p281jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;
import javax.crypto.spec.DHPublicKeySpec;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p166pkcs.DHParameter;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.DomainParameters;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.DHPublicKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;

/* loaded from: classes2.dex */
public class JCEDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;

    /* renamed from: dhSpec */
    private DHParameterSpec f21998dhSpec;

    /* renamed from: info */
    private SubjectPublicKeyInfo f21999info;

    /* renamed from: y */
    private BigInteger f22000y;

    public JCEDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.f22000y = bigInteger;
        this.f21998dhSpec = dHParameterSpec;
    }

    private boolean isPKCSParam(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.mo14450size() == 2) {
            return true;
        }
        if (aSN1Sequence.mo14450size() > 3) {
            return false;
        }
        return ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2)).getValue().compareTo(BigInteger.valueOf((long) ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue().bitLength())) <= 0;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f22000y = (BigInteger) objectInputStream.readObject();
        this.f21998dhSpec = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(getY());
        objectOutputStream.writeObject(this.f21998dhSpec.getP());
        objectOutputStream.writeObject(this.f21998dhSpec.getG());
        objectOutputStream.writeInt(this.f21998dhSpec.getL());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.f21999info;
        return subjectPublicKeyInfo != null ? C5621KeyUtil.getEncodedSubjectPublicKeyInfo(subjectPublicKeyInfo) : C5621KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.f21998dhSpec.getP(), this.f21998dhSpec.getG(), this.f21998dhSpec.getL())), new ASN1Integer(this.f22000y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.f21998dhSpec;
    }

    @Override // javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.f22000y;
    }

    public JCEDHPublicKey(DHPublicKey dHPublicKey) {
        this.f22000y = dHPublicKey.getY();
        this.f21998dhSpec = dHPublicKey.getParams();
    }

    public JCEDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f22000y = dHPublicKeySpec.getY();
        this.f21998dhSpec = new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
    }

    public JCEDHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        DHParameterSpec dHParameterSpec;
        this.f21999info = subjectPublicKeyInfo;
        try {
            this.f22000y = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
            if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.dhKeyAgreement) || isPKCSParam(aSN1Sequence)) {
                DHParameter dHParameter = DHParameter.getInstance(aSN1Sequence);
                dHParameterSpec = dHParameter.m14628getL() != null ? new DHParameterSpec(dHParameter.m14629getP(), dHParameter.m14627getG(), dHParameter.m14628getL().intValue()) : new DHParameterSpec(dHParameter.m14629getP(), dHParameter.m14627getG());
            } else {
                if (!algorithm.m14446equals((ASN1Primitive) X9ObjectIdentifiers.dhpublicnumber)) {
                    throw new IllegalArgumentException("unknown algorithm type: " + algorithm);
                }
                DomainParameters domainParameters = DomainParameters.getInstance(aSN1Sequence);
                dHParameterSpec = new DHParameterSpec(domainParameters.m14725getP(), domainParameters.m14723getG());
            }
            this.f21998dhSpec = dHParameterSpec;
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DH public key");
        }
    }

    public JCEDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) {
        this.f22000y = dHPublicKeyParameters.m15698getY();
        this.f21998dhSpec = new DHParameterSpec(dHPublicKeyParameters.getParameters().m15695getP(), dHPublicKeyParameters.getParameters().m15691getG(), dHPublicKeyParameters.getParameters().m15693getL());
    }
}
