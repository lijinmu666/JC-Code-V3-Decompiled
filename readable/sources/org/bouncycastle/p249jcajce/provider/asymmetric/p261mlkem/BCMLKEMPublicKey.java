package org.bouncycastle.p249jcajce.provider.asymmetric.p261mlkem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p194crypto.p221util.PublicKeyFactory;
import org.bouncycastle.p194crypto.p221util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p249jcajce.interfaces.InterfaceC5484BCKey;
import org.bouncycastle.p249jcajce.interfaces.MLKEMPublicKey;
import org.bouncycastle.p249jcajce.p279spec.MLKEMParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Fingerprint;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class BCMLKEMPublicKey implements MLKEMPublicKey, InterfaceC5484BCKey {
    private static final long serialVersionUID = 1;
    private transient String algorithm;

    /* renamed from: params */
    private transient MLKEMPublicKeyParameters f21582params;

    public BCMLKEMPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m16126init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m16126init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        MLKEMPublicKeyParameters mLKEMPublicKeyParameters = (MLKEMPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
        this.f21582params = mLKEMPublicKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(MLKEMParameterSpec.fromName(mLKEMPublicKeyParameters.getParameters().m15790getName()).m16208getName());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m16126init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m16128equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCMLKEMPublicKey) {
            return C6238Arrays.areEqual(getEncoded(), ((BCMLKEMPublicKey) obj).getEncoded());
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
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f21582params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public MLKEMPublicKeyParameters getKeyParams() {
        return this.f21582params;
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLKEMKey
    public MLKEMParameterSpec getParameterSpec() {
        return MLKEMParameterSpec.fromName(this.f21582params.getParameters().m15790getName());
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLKEMPublicKey
    public byte[] getPublicData() {
        return this.f21582params.getEncoded();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(getEncoded());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        byte[] encoded = this.f21582params.getEncoded();
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

    public BCMLKEMPublicKey(MLKEMPublicKeyParameters mLKEMPublicKeyParameters) {
        m16127init(mLKEMPublicKeyParameters);
    }

    /* renamed from: init */
    private void m16127init(MLKEMPublicKeyParameters mLKEMPublicKeyParameters) {
        this.f21582params = mLKEMPublicKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(MLKEMParameterSpec.fromName(mLKEMPublicKeyParameters.getParameters().m15790getName()).m16208getName());
    }
}
