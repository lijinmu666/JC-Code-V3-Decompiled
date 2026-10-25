package org.bouncycastle.p281jce.provider;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.DSAParams;
import java.security.interfaces.DSAPublicKey;
import java.security.spec.DSAParameterSpec;
import java.security.spec.DSAPublicKeySpec;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.DSAParameter;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.p213params.DSAPublicKeyParameters;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class JDKDSAPublicKey implements DSAPublicKey {
    private static final long serialVersionUID = 1752452449903495175L;

    /* renamed from: dsaSpec */
    private DSAParams f22016dsaSpec;

    /* renamed from: y */
    private BigInteger f22017y;

    public JDKDSAPublicKey(BigInteger bigInteger, DSAParameterSpec dSAParameterSpec) {
        this.f22017y = bigInteger;
        this.f22016dsaSpec = dSAParameterSpec;
    }

    private boolean isNotNull(ASN1Encodable aSN1Encodable) {
        return (aSN1Encodable == null || C5103DERNull.INSTANCE.m14445equals(aSN1Encodable)) ? false : true;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        this.f22017y = (BigInteger) objectInputStream.readObject();
        this.f22016dsaSpec = new DSAParameterSpec((BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject(), (BigInteger) objectInputStream.readObject());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeObject(this.f22017y);
        objectOutputStream.writeObject(this.f22016dsaSpec.getP());
        objectOutputStream.writeObject(this.f22016dsaSpec.getQ());
        objectOutputStream.writeObject(this.f22016dsaSpec.getG());
    }

    /* renamed from: equals */
    public boolean m16245equals(Object obj) {
        if (!(obj instanceof DSAPublicKey)) {
            return false;
        }
        DSAPublicKey dSAPublicKey = (DSAPublicKey) obj;
        return getY().equals(dSAPublicKey.getY()) && getParams().getG().equals(dSAPublicKey.getParams().getG()) && getParams().getP().equals(dSAPublicKey.getParams().getP()) && getParams().getQ().equals(dSAPublicKey.getParams().getQ());
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "DSA";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            DSAParams dSAParams = this.f22016dsaSpec;
            return dSAParams == null ? new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.f18789id_dsa), new ASN1Integer(this.f22017y)).getEncoded(ASN1Encoding.f17902DER) : new SubjectPublicKeyInfo(new AlgorithmIdentifier(X9ObjectIdentifiers.f18789id_dsa, new DSAParameter(dSAParams.getP(), this.f22016dsaSpec.getQ(), this.f22016dsaSpec.getG())), new ASN1Integer(this.f22017y)).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // java.security.interfaces.DSAKey
    public DSAParams getParams() {
        return this.f22016dsaSpec;
    }

    @Override // java.security.interfaces.DSAPublicKey
    public BigInteger getY() {
        return this.f22017y;
    }

    public int hashCode() {
        return getParams().getQ().hashCode() ^ ((getY().hashCode() ^ getParams().getG().hashCode()) ^ getParams().getP().hashCode());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append("DSA Public Key");
        sb.append(strLineSeparator);
        sb.append("            y: ");
        sb.append(getY().toString(16));
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public JDKDSAPublicKey(DSAPublicKey dSAPublicKey) {
        this.f22017y = dSAPublicKey.getY();
        this.f22016dsaSpec = dSAPublicKey.getParams();
    }

    public JDKDSAPublicKey(DSAPublicKeySpec dSAPublicKeySpec) {
        this.f22017y = dSAPublicKeySpec.getY();
        this.f22016dsaSpec = new DSAParameterSpec(dSAPublicKeySpec.getP(), dSAPublicKeySpec.getQ(), dSAPublicKeySpec.getG());
    }

    public JDKDSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            this.f22017y = ((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue();
            if (isNotNull(subjectPublicKeyInfo.getAlgorithm().getParameters())) {
                DSAParameter dSAParameter = DSAParameter.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
                this.f22016dsaSpec = new DSAParameterSpec(dSAParameter.m14680getP(), dSAParameter.m14681getQ(), dSAParameter.m14679getG());
            }
        } catch (IOException unused) {
            throw new IllegalArgumentException("invalid info structure in DSA public key");
        }
    }

    public JDKDSAPublicKey(DSAPublicKeyParameters dSAPublicKeyParameters) {
        this.f22017y = dSAPublicKeyParameters.m15708getY();
        this.f22016dsaSpec = new DSAParameterSpec(dSAPublicKeyParameters.getParameters().m15705getP(), dSAPublicKeyParameters.getParameters().m15706getQ(), dSAPublicKeyParameters.getParameters().m15704getG());
    }
}
