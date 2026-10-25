package org.bouncycastle.p314pqc.p334jcajce.provider.p346saber;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.SABERKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SABERParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCSABERPublicKey implements PublicKey, SABERKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient SABERPublicKeyParameters f23842params;

    public BCSABERPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m18009init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m18009init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23842params = (SABERPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m18009init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m18010equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSABERPublicKey) {
            return C6238Arrays.areEqual(this.f23842params.getEncoded(), ((BCSABERPublicKey) obj).f23842params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SABER";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23842params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public SABERPublicKeyParameters getKeyParams() {
        return this.f23842params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.SABERKey
    public SABERParameterSpec getParameterSpec() {
        return SABERParameterSpec.fromName(this.f23842params.getParameters().m17809getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23842params.getEncoded());
    }

    public BCSABERPublicKey(SABERPublicKeyParameters sABERPublicKeyParameters) {
        this.f23842params = sABERPublicKeyParameters;
    }
}
