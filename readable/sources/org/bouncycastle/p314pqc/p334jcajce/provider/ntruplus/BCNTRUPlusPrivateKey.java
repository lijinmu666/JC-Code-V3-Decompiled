package org.bouncycastle.p314pqc.p334jcajce.provider.ntruplus;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.ntruplus.NTRUPlusPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.NTRUPlusKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.NTRUPlusParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCNTRUPlusPrivateKey implements PrivateKey, NTRUPlusKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient NTRUPlusPrivateKeyParameters f23802params;

    public BCNTRUPlusPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17991init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17991init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f23802params = (NTRUPlusPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17991init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17992equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCNTRUPlusPrivateKey) {
            return C6238Arrays.areEqual(this.f23802params.getEncoded(), ((BCNTRUPlusPrivateKey) obj).f23802params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return C6250Strings.toUpperCase(this.f23802params.getParameters().m17775getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23802params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public NTRUPlusPrivateKeyParameters getKeyParams() {
        return this.f23802params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.NTRUPlusKey
    public NTRUPlusParameterSpec getParameterSpec() {
        return NTRUPlusParameterSpec.fromName(this.f23802params.getParameters().m17775getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23802params.getEncoded());
    }

    public BCNTRUPlusPrivateKey(NTRUPlusPrivateKeyParameters nTRUPlusPrivateKeyParameters) {
        this.f23802params = nTRUPlusPrivateKeyParameters;
    }
}
