package org.bouncycastle.p314pqc.p334jcajce.provider.p343newhope;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p314pqc.p316crypto.p325newhope.NHPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.NHPublicKey;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCNHPublicKey implements NHPublicKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient NHPublicKeyParameters f23788params;

    public BCNHPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17985init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17985init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23788params = (NHPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17985init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17986equals(Object obj) {
        if (obj == null || !(obj instanceof BCNHPublicKey)) {
            return false;
        }
        return C6238Arrays.areEqual(this.f23788params.getPubData(), ((BCNHPublicKey) obj).f23788params.getPubData());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NH";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23788params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public CipherParameters getKeyParams() {
        return this.f23788params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.NHPublicKey
    public byte[] getPublicData() {
        return this.f23788params.getPubData();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23788params.getPubData());
    }

    public BCNHPublicKey(NHPublicKeyParameters nHPublicKeyParameters) {
        this.f23788params = nHPublicKeyParameters;
    }
}
