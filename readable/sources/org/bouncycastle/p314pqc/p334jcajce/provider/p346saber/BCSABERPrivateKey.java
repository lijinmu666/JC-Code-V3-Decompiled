package org.bouncycastle.p314pqc.p334jcajce.provider.p346saber;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p327saber.SABERPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.SABERKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SABERParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCSABERPrivateKey implements PrivateKey, SABERKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient SABERPrivateKeyParameters f23841params;

    public BCSABERPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m18007init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m18007init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f23841params = (SABERPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m18007init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m18008equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSABERPrivateKey) {
            return C6238Arrays.areEqual(this.f23841params.getEncoded(), ((BCSABERPrivateKey) obj).f23841params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SABER";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23841params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public SABERPrivateKeyParameters getKeyParams() {
        return this.f23841params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.SABERKey
    public SABERParameterSpec getParameterSpec() {
        return SABERParameterSpec.fromName(this.f23841params.getParameters().m17809getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23841params.getEncoded());
    }

    public BCSABERPrivateKey(SABERPrivateKeyParameters sABERPrivateKeyParameters) {
        this.f23841params = sABERPrivateKeyParameters;
    }
}
