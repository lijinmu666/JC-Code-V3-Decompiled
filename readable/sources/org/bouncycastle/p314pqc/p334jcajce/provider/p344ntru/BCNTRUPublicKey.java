package org.bouncycastle.p314pqc.p334jcajce.provider.p344ntru;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6138NTRUKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.NTRUParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCNTRUPublicKey implements PublicKey, InterfaceC6138NTRUKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient NTRUPublicKeyParameters f23793params;

    public BCNTRUPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17989init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17989init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23793params = (NTRUPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17989init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17990equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCNTRUPublicKey) {
            return C6238Arrays.areEqual(this.f23793params.getEncoded(), ((BCNTRUPublicKey) obj).f23793params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NTRU";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23793params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public NTRUPublicKeyParameters getKeyParams() {
        return this.f23793params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6138NTRUKey
    public NTRUParameterSpec getParameterSpec() {
        return NTRUParameterSpec.fromName(this.f23793params.getParameters().m17762getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23793params.getEncoded());
    }

    public BCNTRUPublicKey(NTRUPublicKeyParameters nTRUPublicKeyParameters) {
        this.f23793params = nTRUPublicKeyParameters;
    }
}
