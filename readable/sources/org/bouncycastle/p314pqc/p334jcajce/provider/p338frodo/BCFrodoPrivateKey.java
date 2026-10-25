package org.bouncycastle.p314pqc.p334jcajce.provider.p338frodo;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p319frodo.FrodoPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.FrodoKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.FrodoParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCFrodoPrivateKey implements PrivateKey, FrodoKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient FrodoPrivateKeyParameters f23740params;

    public BCFrodoPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17962init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17962init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f23740params = (FrodoPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17962init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17963equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCFrodoPrivateKey) {
            return C6238Arrays.areEqual(this.f23740params.getEncoded(), ((BCFrodoPrivateKey) obj).f23740params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Frodo";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23740params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public FrodoPrivateKeyParameters getKeyParams() {
        return this.f23740params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.FrodoKey
    public FrodoParameterSpec getParameterSpec() {
        return FrodoParameterSpec.fromName(this.f23740params.getParameters().m17569getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23740params.getEncoded());
    }

    public BCFrodoPrivateKey(FrodoPrivateKeyParameters frodoPrivateKeyParameters) {
        this.f23740params = frodoPrivateKeyParameters;
    }
}
