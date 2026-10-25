package org.bouncycastle.p314pqc.p334jcajce.provider.p335bike;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6132BIKEKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.BIKEParameterSpec;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEPublicKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCBIKEPublicKey implements PublicKey, InterfaceC6132BIKEKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient BIKEPublicKeyParameters f23703params;

    public BCBIKEPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17944init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17944init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23703params = (BIKEPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17944init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17945equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCBIKEPublicKey) {
            return C6238Arrays.areEqual(this.f23703params.getEncoded(), ((BCBIKEPublicKey) obj).f23703params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return C6250Strings.toUpperCase(this.f23703params.getParameters().m18064getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23703params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public BIKEPublicKeyParameters getKeyParams() {
        return this.f23703params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6132BIKEKey
    public BIKEParameterSpec getParameterSpec() {
        return BIKEParameterSpec.fromName(this.f23703params.getParameters().m18064getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23703params.getEncoded());
    }

    public BCBIKEPublicKey(BIKEPublicKeyParameters bIKEPublicKeyParameters) {
        this.f23703params = bIKEPublicKeyParameters;
    }
}
