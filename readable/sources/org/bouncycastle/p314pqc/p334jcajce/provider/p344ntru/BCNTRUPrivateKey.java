package org.bouncycastle.p314pqc.p334jcajce.provider.p344ntru;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p326ntru.NTRUPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6138NTRUKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.NTRUParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCNTRUPrivateKey implements PrivateKey, InterfaceC6138NTRUKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient NTRUPrivateKeyParameters f23792params;

    public BCNTRUPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17987init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17987init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f23792params = (NTRUPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17987init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17988equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCNTRUPrivateKey) {
            return C6238Arrays.areEqual(this.f23792params.getEncoded(), ((BCNTRUPrivateKey) obj).f23792params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "NTRU";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23792params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public NTRUPrivateKeyParameters getKeyParams() {
        return this.f23792params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6138NTRUKey
    public NTRUParameterSpec getParameterSpec() {
        return NTRUParameterSpec.fromName(this.f23792params.getParameters().m17762getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23792params.getEncoded());
    }

    public BCNTRUPrivateKey(NTRUPrivateKeyParameters nTRUPrivateKeyParameters) {
        this.f23792params = nTRUPrivateKeyParameters;
    }
}
