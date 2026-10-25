package org.bouncycastle.p249jcajce.provider.asymmetric.p251dh;

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
import org.bouncycastle.p133asn1.p176x9.ValidationParams;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.DHParameters;
import org.bouncycastle.p194crypto.p213params.DHPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.DHValidationParameters;
import org.bouncycastle.p249jcajce.p279spec.DHDomainParameterSpec;
import org.bouncycastle.p249jcajce.p279spec.DHExtendedPublicKeySpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;

/* loaded from: classes2.dex */
public class BCDHPublicKey implements DHPublicKey {
    static final long serialVersionUID = -216691575254424324L;
    private transient DHPublicKeyParameters dhPublicKey;

    /* renamed from: dhSpec */
    private transient DHParameterSpec f21423dhSpec;

    /* renamed from: info */
    private transient SubjectPublicKeyInfo f21424info;

    /* renamed from: y */
    private BigInteger f21425y;

    public BCDHPublicKey(BigInteger bigInteger, DHParameterSpec dHParameterSpec) {
        this.f21425y = bigInteger;
        this.f21423dhSpec = dHParameterSpec;
        this.dhPublicKey = dHParameterSpec instanceof DHDomainParameterSpec ? new DHPublicKeyParameters(bigInteger, ((DHDomainParameterSpec) dHParameterSpec).getDomainParameters()) : new DHPublicKeyParameters(bigInteger, new DHParameters(dHParameterSpec.getP(), dHParameterSpec.getG()));
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

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.f21423dhSpec = new DHParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), objectInputStream.readInt());
        this.f21424info = null;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.f21423dhSpec.getP());
        objectOutputStream.writeObject(this.f21423dhSpec.getG());
        objectOutputStream.writeInt(this.f21423dhSpec.getL());
    }

    public DHPublicKeyParameters engineGetKeyParameters() {
        return this.dhPublicKey;
    }

    /* renamed from: equals */
    public boolean m16089equals(Object obj) {
        if (!(obj instanceof DHPublicKey)) {
            return false;
        }
        DHPublicKey dHPublicKey = (DHPublicKey) obj;
        return getY().equals(dHPublicKey.getY()) && getParams().getG().equals(dHPublicKey.getParams().getG()) && getParams().getP().equals(dHPublicKey.getParams().getP()) && getParams().getL() == dHPublicKey.getParams().getL();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.f21424info;
        if (subjectPublicKeyInfo != null) {
            return C5621KeyUtil.getEncodedSubjectPublicKeyInfo(subjectPublicKeyInfo);
        }
        DHParameterSpec dHParameterSpec = this.f21423dhSpec;
        if (!(dHParameterSpec instanceof DHDomainParameterSpec) || ((DHDomainParameterSpec) dHParameterSpec).m16187getQ() == null) {
            return C5621KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.dhKeyAgreement, new DHParameter(this.f21423dhSpec.getP(), this.f21423dhSpec.getG(), this.f21423dhSpec.getL()).toASN1Primitive()), new ASN1Integer(this.f21425y));
        }
        DHParameters domainParameters = ((DHDomainParameterSpec) this.f21423dhSpec).getDomainParameters();
        DHValidationParameters validationParameters = domainParameters.getValidationParameters();
        return C5621KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.dhpublicnumber, new DomainParameters(domainParameters.m15695getP(), domainParameters.m15691getG(), domainParameters.m15696getQ(), domainParameters.m15692getJ(), validationParameters != null ? new ValidationParams(validationParameters.m15700getSeed(), validationParameters.getCounter()) : null).toASN1Primitive()), new ASN1Integer(this.f21425y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // javax.crypto.interfaces.DHKey
    public DHParameterSpec getParams() {
        return this.f21423dhSpec;
    }

    @Override // javax.crypto.interfaces.DHPublicKey
    public BigInteger getY() {
        return this.f21425y;
    }

    public int hashCode() {
        return getParams().getL() ^ ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode());
    }

    public String toString() {
        return C5506DHUtil.publicKeyToString("DH", this.f21425y, new DHParameters(this.f21423dhSpec.getP(), this.f21423dhSpec.getG()));
    }

    public BCDHPublicKey(DHPublicKey dHPublicKey) {
        this.f21425y = dHPublicKey.getY();
        DHParameterSpec params = dHPublicKey.getParams();
        this.f21423dhSpec = params;
        if (params instanceof DHDomainParameterSpec) {
            this.dhPublicKey = new DHPublicKeyParameters(this.f21425y, ((DHDomainParameterSpec) params).getDomainParameters());
        } else {
            this.dhPublicKey = new DHPublicKeyParameters(this.f21425y, new DHParameters(this.f21423dhSpec.getP(), this.f21423dhSpec.getG()));
        }
    }

    public BCDHPublicKey(DHPublicKeySpec dHPublicKeySpec) {
        this.f21425y = dHPublicKeySpec.getY();
        this.f21423dhSpec = dHPublicKeySpec instanceof DHExtendedPublicKeySpec ? ((DHExtendedPublicKeySpec) dHPublicKeySpec).getParams() : new DHParameterSpec(dHPublicKeySpec.getP(), dHPublicKeySpec.getG());
        DHParameterSpec dHParameterSpec = this.f21423dhSpec;
        if (dHParameterSpec instanceof DHDomainParameterSpec) {
            this.dhPublicKey = new DHPublicKeyParameters(this.f21425y, ((DHDomainParameterSpec) dHParameterSpec).getDomainParameters());
        } else {
            this.dhPublicKey = new DHPublicKeyParameters(this.f21425y, new DHParameters(dHPublicKeySpec.getP(), dHPublicKeySpec.getG()));
        }
    }

    public BCDHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        DHPublicKeyParameters dHPublicKeyParameters;
        this.f21424info = subjectPublicKeyInfo;
        try {
            this.f21425y = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
            if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.dhKeyAgreement) || isPKCSParam(aSN1Sequence)) {
                DHParameter dHParameter = DHParameter.getInstance(aSN1Sequence);
                if (dHParameter.m14628getL() != null) {
                    this.f21423dhSpec = new DHParameterSpec(dHParameter.m14629getP(), dHParameter.m14627getG(), dHParameter.m14628getL().intValue());
                    dHPublicKeyParameters = new DHPublicKeyParameters(this.f21425y, new DHParameters(this.f21423dhSpec.getP(), this.f21423dhSpec.getG(), null, this.f21423dhSpec.getL()));
                } else {
                    this.f21423dhSpec = new DHParameterSpec(dHParameter.m14629getP(), dHParameter.m14627getG());
                    dHPublicKeyParameters = new DHPublicKeyParameters(this.f21425y, new DHParameters(this.f21423dhSpec.getP(), this.f21423dhSpec.getG()));
                }
                this.dhPublicKey = dHPublicKeyParameters;
                return;
            }
            if (!algorithm.m14446equals((ASN1Primitive) X9ObjectIdentifiers.dhpublicnumber)) {
                throw new IllegalArgumentException("unknown algorithm type: " + algorithm);
            }
            DomainParameters domainParameters = DomainParameters.getInstance(aSN1Sequence);
            ValidationParams validationParams = domainParameters.getValidationParams();
            if (validationParams != null) {
                this.dhPublicKey = new DHPublicKeyParameters(this.f21425y, new DHParameters(domainParameters.m14725getP(), domainParameters.m14723getG(), domainParameters.m14726getQ(), domainParameters.m14724getJ(), new DHValidationParameters(validationParams.m14729getSeed(), validationParams.getPgenCounter().intValue())));
            } else {
                this.dhPublicKey = new DHPublicKeyParameters(this.f21425y, new DHParameters(domainParameters.m14725getP(), domainParameters.m14723getG(), domainParameters.m14726getQ(), domainParameters.m14724getJ(), (DHValidationParameters) null));
            }
            this.f21423dhSpec = new DHDomainParameterSpec(this.dhPublicKey.getParameters());
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DH public key");
        }
    }

    public BCDHPublicKey(DHPublicKeyParameters dHPublicKeyParameters) {
        this.f21425y = dHPublicKeyParameters.m15698getY();
        this.f21423dhSpec = new DHDomainParameterSpec(dHPublicKeyParameters.getParameters());
        this.dhPublicKey = dHPublicKeyParameters;
    }
}
