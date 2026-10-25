package org.bouncycastle.p314pqc.p334jcajce.provider.p339hqc;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p320hqc.HQCPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6134HQCKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.HQCParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCHQCPrivateKey implements PrivateKey, InterfaceC6134HQCKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient HQCPrivateKeyParameters f23750params;

    public BCHQCPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17966init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17966init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f23750params = (HQCPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17966init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17967equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCHQCPrivateKey) {
            return C6238Arrays.areEqual(this.f23750params.getEncoded(), ((BCHQCPrivateKey) obj).f23750params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return C6250Strings.toUpperCase(this.f23750params.getParameters().m17592getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23750params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public HQCPrivateKeyParameters getKeyParams() {
        return this.f23750params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6134HQCKey
    public HQCParameterSpec getParameterSpec() {
        return HQCParameterSpec.fromName(this.f23750params.getParameters().m17592getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23750params.getEncoded());
    }

    public BCHQCPrivateKey(HQCPrivateKeyParameters hQCPrivateKeyParameters) {
        this.f23750params = hQCPrivateKeyParameters;
    }
}
