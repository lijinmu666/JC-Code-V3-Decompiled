package org.bouncycastle.p314pqc.p334jcajce.provider.p345picnic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.PicnicKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.PicnicParameterSpec;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicPublicKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCPicnicPublicKey implements PublicKey, PicnicKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient PicnicPublicKeyParameters f23834params;

    public BCPicnicPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m18005init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m18005init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23834params = (PicnicPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m18005init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m18006equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCPicnicPublicKey) {
            return C6238Arrays.areEqual(this.f23834params.getEncoded(), ((BCPicnicPublicKey) obj).f23834params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Picnic";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23834params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public PicnicPublicKeyParameters getKeyParams() {
        return this.f23834params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.PicnicKey
    public PicnicParameterSpec getParameterSpec() {
        return PicnicParameterSpec.fromName(this.f23834params.getParameters().m18101getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23834params.getEncoded());
    }

    public BCPicnicPublicKey(PicnicPublicKeyParameters picnicPublicKeyParameters) {
        this.f23834params = picnicPublicKeyParameters;
    }
}
