package org.bouncycastle.p314pqc.p334jcajce.provider.p340kyber;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;
import org.bouncycastle.p194crypto.p221util.PrivateKeyFactory;
import org.bouncycastle.p194crypto.p221util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.KyberPrivateKey;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.KyberPublicKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.KyberParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCKyberPrivateKey implements KyberPrivateKey {
    private static final long serialVersionUID = 1;
    private transient String algorithm;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient MLKEMPrivateKeyParameters f23761params;

    public BCKyberPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17970init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17970init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters = (MLKEMPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
        this.f23761params = mLKEMPrivateKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(mLKEMPrivateKeyParameters.getParameters().m15790getName());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17970init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17971equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCKyberPrivateKey) {
            return C6238Arrays.areEqual(getEncoded(), ((BCKyberPrivateKey) obj).getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f23761params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public MLKEMPrivateKeyParameters getKeyParams() {
        return this.f23761params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.KyberKey
    public KyberParameterSpec getParameterSpec() {
        return KyberParameterSpec.fromName(this.f23761params.getParameters().m15790getName());
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.KyberPrivateKey
    public KyberPublicKey getPublicKey() {
        return new BCKyberPublicKey(this.f23761params.getPublicKeyParameters());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(getEncoded());
    }

    public BCKyberPrivateKey(MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters) {
        this.f23761params = mLKEMPrivateKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(mLKEMPrivateKeyParameters.getParameters().m15790getName());
    }
}
