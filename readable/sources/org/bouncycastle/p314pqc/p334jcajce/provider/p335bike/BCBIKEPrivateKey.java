package org.bouncycastle.p314pqc.p334jcajce.provider.p335bike;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6132BIKEKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.BIKEParameterSpec;
import org.bouncycastle.p314pqc.p352legacy.p353bike.BIKEPrivateKeyParameters;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCBIKEPrivateKey implements PrivateKey, InterfaceC6132BIKEKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient BIKEPrivateKeyParameters f23702params;

    public BCBIKEPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17942init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17942init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f23702params = (BIKEPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17942init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17943equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCBIKEPrivateKey) {
            return C6238Arrays.areEqual(this.f23702params.getEncoded(), ((BCBIKEPrivateKey) obj).f23702params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return C6250Strings.toUpperCase(this.f23702params.getParameters().m18064getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23702params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public BIKEPrivateKeyParameters getKeyParams() {
        return this.f23702params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6132BIKEKey
    public BIKEParameterSpec getParameterSpec() {
        return BIKEParameterSpec.fromName(this.f23702params.getParameters().m18064getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23702params.getEncoded());
    }

    public BCBIKEPrivateKey(BIKEPrivateKeyParameters bIKEPrivateKeyParameters) {
        this.f23702params = bIKEPrivateKeyParameters;
    }
}
