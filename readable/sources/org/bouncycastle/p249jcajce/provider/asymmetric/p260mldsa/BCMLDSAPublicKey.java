package org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.MLDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p221util.PublicKeyFactory;
import org.bouncycastle.p194crypto.p221util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p249jcajce.interfaces.InterfaceC5484BCKey;
import org.bouncycastle.p249jcajce.interfaces.MLDSAPublicKey;
import org.bouncycastle.p249jcajce.p279spec.MLDSAParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Fingerprint;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class BCMLDSAPublicKey implements MLDSAPublicKey, InterfaceC5484BCKey {
    private static final long serialVersionUID = 1;
    private transient String algorithm;

    /* renamed from: params */
    private transient MLDSAPublicKeyParameters f21574params;

    public BCMLDSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m16122init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m16122init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        MLDSAPublicKeyParameters mLDSAPublicKeyParameters = (MLDSAPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
        this.f21574params = mLDSAPublicKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(MLDSAParameterSpec.fromName(mLDSAPublicKeyParameters.getParameters().m15777getName()).m16205getName());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m16122init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m16123equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCMLDSAPublicKey) {
            return C6238Arrays.areEqual(this.f21574params.getEncoded(), ((BCMLDSAPublicKey) obj).f21574params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f21574params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public MLDSAPublicKeyParameters getKeyParams() {
        return this.f21574params;
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAKey
    public MLDSAParameterSpec getParameterSpec() {
        return MLDSAParameterSpec.fromName(this.f21574params.getParameters().m15777getName());
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAPublicKey
    public byte[] getPublicData() {
        return this.f21574params.getEncoded();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f21574params.getEncoded());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        byte[] encoded = this.f21574params.getEncoded();
        sb.append(getAlgorithm());
        sb.append(" ");
        sb.append("Public Key");
        sb.append(" [");
        sb.append(new Fingerprint(encoded).toString());
        sb.append("]");
        sb.append(strLineSeparator);
        sb.append("    public data: ");
        sb.append(C6255Hex.toHexString(encoded));
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public BCMLDSAPublicKey(MLDSAPublicKeyParameters mLDSAPublicKeyParameters) {
        this.f21574params = mLDSAPublicKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(MLDSAParameterSpec.fromName(mLDSAPublicKeyParameters.getParameters().m15777getName()).m16205getName());
    }
}
