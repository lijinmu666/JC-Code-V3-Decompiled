package org.bouncycastle.p314pqc.p334jcajce.provider.p347snova;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p329snova.SnovaPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.SnovaKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.SnovaParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCSnovaPrivateKey implements PrivateKey, SnovaKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient SnovaPrivateKeyParameters f23851params;

    public BCSnovaPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m18011init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m18011init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f23851params = (SnovaPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m18011init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m18012equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSnovaPrivateKey) {
            return C6238Arrays.areEqual(this.f23851params.getEncoded(), ((BCSnovaPrivateKey) obj).f23851params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return C6250Strings.toUpperCase(this.f23851params.getParameters().m17868getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23851params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public SnovaPrivateKeyParameters getKeyParams() {
        return this.f23851params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.SnovaKey
    public SnovaParameterSpec getParameterSpec() {
        return SnovaParameterSpec.fromName(this.f23851params.getParameters().m17868getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23851params.getEncoded());
    }

    public BCSnovaPrivateKey(SnovaPrivateKeyParameters snovaPrivateKeyParameters) {
        this.f23851params = snovaPrivateKeyParameters;
    }
}
