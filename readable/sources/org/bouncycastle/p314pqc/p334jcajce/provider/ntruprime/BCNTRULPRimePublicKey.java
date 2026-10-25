package org.bouncycastle.p314pqc.p334jcajce.provider.ntruprime;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimePublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.NTRULPRimeKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.NTRULPRimeParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCNTRULPRimePublicKey implements PublicKey, NTRULPRimeKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient NTRULPRimePublicKeyParameters f23814params;

    public BCNTRULPRimePublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17997init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17997init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23814params = (NTRULPRimePublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17997init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17998equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCNTRULPRimePublicKey) {
            return C6238Arrays.areEqual(this.f23814params.getEncoded(), ((BCNTRULPRimePublicKey) obj).f23814params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NTRULPRime";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23814params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public NTRULPRimePublicKeyParameters getKeyParams() {
        return this.f23814params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.NTRULPRimeKey
    public NTRULPRimeParameterSpec getParameterSpec() {
        return NTRULPRimeParameterSpec.fromName(this.f23814params.getParameters().m17776getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23814params.getEncoded());
    }

    public BCNTRULPRimePublicKey(NTRULPRimePublicKeyParameters nTRULPRimePublicKeyParameters) {
        this.f23814params = nTRULPRimePublicKeyParameters;
    }
}
