package org.bouncycastle.p249jcajce.provider.asymmetric.p252dsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.DSAParameter;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.DSAPublicKeyParameters;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCDSAPublicKey implements DSAPublicKey {

    /* renamed from: ZERO */
    private static BigInteger f21448ZERO = BigInteger.valueOf(0);
    private static final long serialVersionUID = 1752452449903495175L;

    /* renamed from: dsaSpec */
    private transient DSAParams f21449dsaSpec;
    private transient DSAPublicKeyParameters lwKeyParams;

    /* renamed from: y */
    private BigInteger f21450y;

    public BCDSAPublicKey(DSAPublicKey dSAPublicKey) {
        this.f21450y = dSAPublicKey.getY();
        this.f21449dsaSpec = dSAPublicKey.getParams();
        this.lwKeyParams = new DSAPublicKeyParameters(this.f21450y, C5516DSAUtil.toDSAParameters(this.f21449dsaSpec));
    }

    private boolean isNotNull(ASN1Encodable aSN1Encodable) {
        return (aSN1Encodable == null || C5103DERNull.INSTANCE.m14446equals(aSN1Encodable.toASN1Primitive())) ? false : true;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        BigInteger bigInteger = (BigInteger) objectInputStream.readObject();
        if (bigInteger.equals(f21448ZERO)) {
            this.f21449dsaSpec = null;
        } else {
            this.f21449dsaSpec = new DSAParameterSpec(bigInteger, (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
        }
        this.lwKeyParams = new DSAPublicKeyParameters(this.f21450y, C5516DSAUtil.toDSAParameters(this.f21449dsaSpec));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        BigInteger g;
        objectOutputStream.defaultWriteObject();
        DSAParams dSAParams = this.f21449dsaSpec;
        if (dSAParams == null) {
            g = f21448ZERO;
        } else {
            objectOutputStream.writeObject(dSAParams.getP());
            objectOutputStream.writeObject(this.f21449dsaSpec.getQ());
            g = this.f21449dsaSpec.getG();
        }
        objectOutputStream.writeObject(g);
    }

    public DSAPublicKeyParameters engineGetKeyParameters() {
        return this.lwKeyParams;
    }

    /* renamed from: equals */
    public boolean m16091equals(Object obj) {
        if (!(obj instanceof DSAPublicKey)) {
            return false;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
        return this.f21449dsaSpec != null ? getY().equals(dSAPublicKey.getY()) && dSAPublicKey.getParams() != null && getParams().getG().equals(dSAPublicKey.getParams().getG()) && getParams().getP().equals(dSAPublicKey.getParams().getP()) && getParams().getQ().equals(dSAPublicKey.getParams().getQ()) : getY().equals(dSAPublicKey.getY()) && dSAPublicKey.getParams() == null;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        DSAParams dSAParams = this.f21449dsaSpec;
        return dSAParams == null ? C5621KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.f18789id_dsa), new ASN1Integer(this.f21450y)) : C5621KeyUtil.getEncodedSubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.f18789id_dsa, new DSAParameter(dSAParams.getP(), this.f21449dsaSpec.getQ(), this.f21449dsaSpec.getG()).toASN1Primitive()), new ASN1Integer(this.f21450y));
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.f21449dsaSpec;
    }

    @Override // java.security.interfaces.DSAPublicKey
    public BigInteger getY() {
        return this.f21450y;
    }

    public int hashCode() {
        if (this.f21449dsaSpec == null) {
            return getY().hashCode();
        }
        return getParams().getQ().hashCode() ^ ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append("DSA Public Key [");
        sb.append(C5516DSAUtil.generateKeyFingerprint(this.f21450y, getParams()));
        sb.append("]");
        sb.append(strLineSeparator);
        sb.append("            Y: ");
        sb.append(getY().toString(16));
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public BCDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) {
        this.f21450y = dSAPublicKeySpec.getY();
        this.f21449dsaSpec = new DSAParameterSpec(dSAPublicKeySpec.getP(), dSAPublicKeySpec.getQ(), dSAPublicKeySpec.getG());
        this.lwKeyParams = new DSAPublicKeyParameters(this.f21450y, C5516DSAUtil.toDSAParameters(this.f21449dsaSpec));
    }

    public BCDSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            this.f21450y = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            if (isNotNull(subjectPublicKeyInfo.getAlgorithm().getParameters())) {
                DSAParameter dSAParameter = DSAParameter.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
                this.f21449dsaSpec = new DSAParameterSpec(dSAParameter.m14680getP(), dSAParameter.m14681getQ(), dSAParameter.m14679getG());
            } else {
                this.f21449dsaSpec = null;
            }
            this.lwKeyParams = new DSAPublicKeyParameters(this.f21450y, C5516DSAUtil.toDSAParameters(this.f21449dsaSpec));
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    public BCDSAPublicKey(DSAPublicKeyParameters dSAPublicKeyParameters) {
        this.f21450y = dSAPublicKeyParameters.m15708getY();
        this.f21449dsaSpec = dSAPublicKeyParameters.getParameters() != null ? new DSAParameterSpec(dSAPublicKeyParameters.getParameters().m15705getP(), dSAPublicKeyParameters.getParameters().m15706getQ(), dSAPublicKeyParameters.getParameters().m15704getG()) : null;
        this.lwKeyParams = dSAPublicKeyParameters;
    }
}
