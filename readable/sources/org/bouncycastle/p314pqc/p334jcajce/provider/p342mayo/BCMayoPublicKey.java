package org.bouncycastle.p314pqc.p334jcajce.provider.p342mayo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6136MayoKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.MayoParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCMayoPublicKey implements PublicKey, InterfaceC6136MayoKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient MayoPublicKeyParameters f23779params;

    public BCMayoPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17981init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17981init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23779params = (MayoPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17981init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17982equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCMayoPublicKey) {
            return C6238Arrays.areEqual(this.f23779params.getEncoded(), ((BCMayoPublicKey) obj).f23779params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return C6250Strings.toUpperCase(this.f23779params.getParameters().m17670getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23779params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public MayoPublicKeyParameters getKeyParams() {
        return this.f23779params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6136MayoKey
    public MayoParameterSpec getParameterSpec() {
        return MayoParameterSpec.fromName(this.f23779params.getParameters().m17670getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23779params.getEncoded());
    }

    public BCMayoPublicKey(MayoPublicKeyParameters mayoPublicKeyParameters) {
        this.f23779params = mayoPublicKeyParameters;
    }
}
