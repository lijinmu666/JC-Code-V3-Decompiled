package org.bouncycastle.p314pqc.p334jcajce.provider.ntruprime;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimePublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.SNTRUPrimeKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SNTRUPrimeParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCSNTRUPrimePublicKey implements PublicKey, SNTRUPrimeKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient SNTRUPrimePublicKeyParameters f23816params;

    public BCSNTRUPrimePublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m18001init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m18001init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23816params = (SNTRUPrimePublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m18001init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m18002equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSNTRUPrimePublicKey) {
            return C6238Arrays.areEqual(this.f23816params.getEncoded(), ((BCSNTRUPrimePublicKey) obj).f23816params.getEncoded());
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
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23816params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public SNTRUPrimePublicKeyParameters getKeyParams() {
        return this.f23816params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.SNTRUPrimeKey
    public SNTRUPrimeParameterSpec getParameterSpec() {
        return SNTRUPrimeParameterSpec.fromName(this.f23816params.getParameters().m17789getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23816params.getEncoded());
    }

    public BCSNTRUPrimePublicKey(SNTRUPrimePublicKeyParameters sNTRUPrimePublicKeyParameters) {
        this.f23816params = sNTRUPrimePublicKeyParameters;
    }
}
