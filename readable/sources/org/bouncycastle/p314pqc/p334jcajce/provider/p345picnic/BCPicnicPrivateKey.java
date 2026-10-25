package org.bouncycastle.p314pqc.p334jcajce.provider.p345picnic;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.PicnicKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.PicnicParameterSpec;
import org.bouncycastle.p314pqc.p352legacy.p354picnic.PicnicPrivateKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCPicnicPrivateKey implements PrivateKey, PicnicKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient PicnicPrivateKeyParameters f23833params;

    public BCPicnicPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m18003init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m18003init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f23833params = (PicnicPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m18003init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m18004equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCPicnicPrivateKey) {
            return C6238Arrays.areEqual(this.f23833params.getEncoded(), ((BCPicnicPrivateKey) obj).f23833params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "Picnic";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23833params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public PicnicPrivateKeyParameters getKeyParams() {
        return this.f23833params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.PicnicKey
    public PicnicParameterSpec getParameterSpec() {
        return PicnicParameterSpec.fromName(this.f23833params.getParameters().m18101getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23833params.getEncoded());
    }

    public BCPicnicPrivateKey(PicnicPrivateKeyParameters picnicPrivateKeyParameters) {
        this.f23833params = picnicPrivateKeyParameters;
    }
}
