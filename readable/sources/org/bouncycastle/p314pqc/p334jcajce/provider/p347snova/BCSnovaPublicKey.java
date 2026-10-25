package org.bouncycastle.p314pqc.p334jcajce.provider.p347snova;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p329snova.SnovaPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.SnovaKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SnovaParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCSnovaPublicKey implements PublicKey, SnovaKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient SnovaPublicKeyParameters f23852params;

    public BCSnovaPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m18013init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m18013init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23852params = (SnovaPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m18013init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m18014equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSnovaPublicKey) {
            return C6238Arrays.areEqual(this.f23852params.getEncoded(), ((BCSnovaPublicKey) obj).f23852params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return C6250Strings.toUpperCase(this.f23852params.getParameters().m17868getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23852params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public SnovaPublicKeyParameters getKeyParams() {
        return this.f23852params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.SnovaKey
    public SnovaParameterSpec getParameterSpec() {
        return SnovaParameterSpec.fromName(this.f23852params.getParameters().m17868getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23852params.getEncoded());
    }

    public BCSnovaPublicKey(SnovaPublicKeyParameters snovaPublicKeyParameters) {
        this.f23852params = snovaPublicKeyParameters;
    }
}
