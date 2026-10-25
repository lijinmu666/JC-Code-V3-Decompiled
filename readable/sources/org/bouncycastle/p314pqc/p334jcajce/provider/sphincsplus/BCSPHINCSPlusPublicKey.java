package org.bouncycastle.p314pqc.p334jcajce.provider.sphincsplus;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.SPHINCSPlusPublicKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SPHINCSPlusParameterSpec;
import org.bouncycastle.p314pqc.p352legacy.sphincsplus.SPHINCSPlusPublicKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCSPHINCSPlusPublicKey implements SPHINCSPlusPublicKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient SPHINCSPlusPublicKeyParameters f23869params;

    public BCSPHINCSPlusPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m18021init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m18021init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23869params = (SPHINCSPlusPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m18021init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m18022equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSPHINCSPlusPublicKey) {
            return C6238Arrays.areEqual(this.f23869params.getEncoded(), ((BCSPHINCSPlusPublicKey) obj).f23869params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS+-" + C6250Strings.toUpperCase(this.f23869params.getParameters().m18174getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23869params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public CipherParameters getKeyParams() {
        return this.f23869params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.SPHINCSPlusKey
    public SPHINCSPlusParameterSpec getParameterSpec() {
        return SPHINCSPlusParameterSpec.fromName(this.f23869params.getParameters().m18174getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23869params.getEncoded());
    }

    public BCSPHINCSPlusPublicKey(SPHINCSPlusPublicKeyParameters sPHINCSPlusPublicKeyParameters) {
        this.f23869params = sPHINCSPlusPublicKeyParameters;
    }
}
