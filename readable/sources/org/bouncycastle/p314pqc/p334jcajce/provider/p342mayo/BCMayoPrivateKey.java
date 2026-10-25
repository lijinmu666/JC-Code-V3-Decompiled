package org.bouncycastle.p314pqc.p334jcajce.provider.p342mayo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p322mayo.MayoPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6136MayoKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.MayoParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCMayoPrivateKey implements PrivateKey, InterfaceC6136MayoKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient MayoPrivateKeyParameters f23778params;

    public BCMayoPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17979init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17979init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f23778params = (MayoPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17979init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17980equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCMayoPrivateKey) {
            return C6238Arrays.areEqual(this.f23778params.getEncoded(), ((BCMayoPrivateKey) obj).f23778params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return C6250Strings.toUpperCase(this.f23778params.getParameters().m17670getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23778params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public MayoPrivateKeyParameters getKeyParams() {
        return this.f23778params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6136MayoKey
    public MayoParameterSpec getParameterSpec() {
        return MayoParameterSpec.fromName(this.f23778params.getParameters().m17670getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23778params.getEncoded());
    }

    public BCMayoPrivateKey(MayoPrivateKeyParameters mayoPrivateKeyParameters) {
        this.f23778params = mayoPrivateKeyParameters;
    }
}
