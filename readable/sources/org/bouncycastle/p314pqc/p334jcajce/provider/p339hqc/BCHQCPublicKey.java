package org.bouncycastle.p314pqc.p334jcajce.provider.p339hqc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6134HQCKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.HQCParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCHQCPublicKey implements PublicKey, InterfaceC6134HQCKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient HQCPublicKeyParameters f23751params;

    public BCHQCPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17968init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17968init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23751params = (HQCPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17968init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17969equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCHQCPublicKey) {
            return C6238Arrays.areEqual(this.f23751params.getEncoded(), ((BCHQCPublicKey) obj).f23751params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return C6250Strings.toUpperCase(this.f23751params.getParameters().m17592getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23751params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public HQCPublicKeyParameters getKeyParams() {
        return this.f23751params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6134HQCKey
    public HQCParameterSpec getParameterSpec() {
        return HQCParameterSpec.fromName(this.f23751params.getParameters().m17592getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23751params.getEncoded());
    }

    public BCHQCPublicKey(HQCPublicKeyParameters hQCPublicKeyParameters) {
        this.f23751params = hQCPublicKeyParameters;
    }
}
