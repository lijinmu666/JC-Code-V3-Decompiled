package org.bouncycastle.p249jcajce.provider.asymmetric.p263slhdsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.SLHDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p221util.PublicKeyFactory;
import org.bouncycastle.p194crypto.p221util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p249jcajce.interfaces.InterfaceC5484BCKey;
import org.bouncycastle.p249jcajce.interfaces.SLHDSAPublicKey;
import org.bouncycastle.p249jcajce.p279spec.SLHDSAParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Fingerprint;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class BCSLHDSAPublicKey implements SLHDSAPublicKey, InterfaceC5484BCKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient SLHDSAPublicKeyParameters f21622params;

    public BCSLHDSAPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m16134init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m16134init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f21622params = (SLHDSAPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m16134init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m16135equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSLHDSAPublicKey) {
            return C6238Arrays.areEqual(this.f21622params.getEncoded(), ((BCSLHDSAPublicKey) obj).f21622params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SLH-DSA-" + C6250Strings.toUpperCase(this.f21622params.getParameters().m15816getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f21622params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public SLHDSAPublicKeyParameters getKeyParams() {
        return this.f21622params;
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.SLHDSAKey
    public SLHDSAParameterSpec getParameterSpec() {
        return SLHDSAParameterSpec.fromName(this.f21622params.getParameters().m15816getName());
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.SLHDSAPublicKey
    public byte[] getPublicData() {
        return this.f21622params.getEncoded();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f21622params.getEncoded());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        byte[] encoded = this.f21622params.getEncoded();
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

    public BCSLHDSAPublicKey(SLHDSAPublicKeyParameters sLHDSAPublicKeyParameters) {
        this.f21622params = sLHDSAPublicKeyParameters;
    }
}
