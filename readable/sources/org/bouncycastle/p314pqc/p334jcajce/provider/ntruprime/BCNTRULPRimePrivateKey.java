package org.bouncycastle.p314pqc.p334jcajce.provider.ntruprime;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.ntruprime.NTRULPRimePrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.NTRULPRimeKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.NTRULPRimeParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCNTRULPRimePrivateKey implements PrivateKey, NTRULPRimeKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient NTRULPRimePrivateKeyParameters f23813params;

    public BCNTRULPRimePrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17995init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17995init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f23813params = (NTRULPRimePrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17995init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17996equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCNTRULPRimePrivateKey) {
            return C6238Arrays.areEqual(this.f23813params.getEncoded(), ((BCNTRULPRimePrivateKey) obj).f23813params.getEncoded());
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
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23813params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public NTRULPRimePrivateKeyParameters getKeyParams() {
        return this.f23813params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.NTRULPRimeKey
    public NTRULPRimeParameterSpec getParameterSpec() {
        return NTRULPRimeParameterSpec.fromName(this.f23813params.getParameters().m17776getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23813params.getEncoded());
    }

    public BCNTRULPRimePrivateKey(NTRULPRimePrivateKeyParameters nTRULPRimePrivateKeyParameters) {
        this.f23813params = nTRULPRimePrivateKeyParameters;
    }
}
