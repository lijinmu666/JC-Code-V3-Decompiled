package org.bouncycastle.p314pqc.p334jcajce.provider.ntruprime;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.SNTRUPrimePrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.SNTRUPrimeKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SNTRUPrimeParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCSNTRUPrimePrivateKey implements PrivateKey, SNTRUPrimeKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient SNTRUPrimePrivateKeyParameters f23815params;

    public BCSNTRUPrimePrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17999init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17999init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f23815params = (SNTRUPrimePrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17999init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m18000equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSNTRUPrimePrivateKey) {
            return C6238Arrays.areEqual(this.f23815params.getEncoded(), ((BCSNTRUPrimePrivateKey) obj).f23815params.getEncoded());
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
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23815params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public SNTRUPrimePrivateKeyParameters getKeyParams() {
        return this.f23815params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.SNTRUPrimeKey
    public SNTRUPrimeParameterSpec getParameterSpec() {
        return SNTRUPrimeParameterSpec.fromName(this.f23815params.getParameters().m17789getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23815params.getEncoded());
    }

    public BCSNTRUPrimePrivateKey(SNTRUPrimePrivateKeyParameters sNTRUPrimePrivateKeyParameters) {
        this.f23815params = sNTRUPrimePrivateKeyParameters;
    }
}
