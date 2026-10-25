package org.bouncycastle.p314pqc.p334jcajce.provider.ntruplus;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.NTRUPlusKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.NTRUPlusParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCNTRUPlusPublicKey implements PublicKey, NTRUPlusKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient NTRUPlusPublicKeyParameters f23803params;

    public BCNTRUPlusPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17993init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17993init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23803params = (NTRUPlusPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17993init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17994equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCNTRUPlusPublicKey) {
            return C6238Arrays.areEqual(this.f23803params.getEncoded(), ((BCNTRUPlusPublicKey) obj).f23803params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return C6250Strings.toUpperCase(this.f23803params.getParameters().m17775getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23803params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public NTRUPlusPublicKeyParameters getKeyParams() {
        return this.f23803params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.NTRUPlusKey
    public NTRUPlusParameterSpec getParameterSpec() {
        return NTRUPlusParameterSpec.fromName(this.f23803params.getParameters().m17775getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23803params.getEncoded());
    }

    public BCNTRUPlusPublicKey(NTRUPlusPublicKeyParameters nTRUPlusPublicKeyParameters) {
        this.f23803params = nTRUPlusPublicKeyParameters;
    }
}
