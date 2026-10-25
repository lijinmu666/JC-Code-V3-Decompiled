package org.bouncycastle.p314pqc.p334jcajce.provider.p338frodo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.FrodoKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.FrodoParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCFrodoPublicKey implements PublicKey, FrodoKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient FrodoPublicKeyParameters f23741params;

    public BCFrodoPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17964init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17964init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23741params = (FrodoPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17964init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17965equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCFrodoPublicKey) {
            return C6238Arrays.areEqual(this.f23741params.getEncoded(), ((BCFrodoPublicKey) obj).f23741params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Frodo";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23741params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public FrodoPublicKeyParameters getKeyParams() {
        return this.f23741params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.FrodoKey
    public FrodoParameterSpec getParameterSpec() {
        return FrodoParameterSpec.fromName(this.f23741params.getParameters().m17569getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23741params.getEncoded());
    }

    public BCFrodoPublicKey(FrodoPublicKeyParameters frodoPublicKeyParameters) {
        this.f23741params = frodoPublicKeyParameters;
    }
}
