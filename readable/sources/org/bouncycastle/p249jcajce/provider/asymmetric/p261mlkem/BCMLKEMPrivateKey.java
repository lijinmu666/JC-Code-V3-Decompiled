package org.bouncycastle.p249jcajce.provider.asymmetric.p261mlkem;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p194crypto.p213params.MLKEMPrivateKeyParameters;
import org.bouncycastle.p194crypto.p221util.PrivateKeyFactory;
import org.bouncycastle.p194crypto.p221util.PrivateKeyInfoFactory;
import org.bouncycastle.p249jcajce.interfaces.InterfaceC5484BCKey;
import org.bouncycastle.p249jcajce.interfaces.MLKEMPrivateKey;
import org.bouncycastle.p249jcajce.interfaces.MLKEMPublicKey;
import org.bouncycastle.p249jcajce.p279spec.MLKEMParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Fingerprint;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class BCMLKEMPrivateKey implements MLKEMPrivateKey, InterfaceC5484BCKey {
    private static final long serialVersionUID = 1;
    private transient String algorithm;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient MLKEMPrivateKeyParameters f21581params;
    private transient byte[] priorEncoding;

    public BCMLKEMPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m16124init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m16124init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.priorEncoding = privateKeyInfo.getEncoded();
        MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters = (MLKEMPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
        this.f21581params = mLKEMPrivateKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(MLKEMParameterSpec.fromName(mLKEMPrivateKeyParameters.getParameters().m15790getName()).m16208getName());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m16124init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m16125equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCMLKEMPrivateKey) {
            return C6238Arrays.areEqual(this.f21581params.getEncoded(), ((BCMLKEMPrivateKey) obj).f21581params.getEncoded());
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
            byte[] bArr = this.priorEncoding;
            return bArr != null ? bArr : PrivateKeyInfoFactory.createPrivateKeyInfo(this.f21581params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public MLKEMPrivateKeyParameters getKeyParams() {
        return this.f21581params;
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLKEMKey
    public MLKEMParameterSpec getParameterSpec() {
        return MLKEMParameterSpec.fromName(this.f21581params.getParameters().m15790getName());
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLKEMPrivateKey
    public byte[] getPrivateData() {
        return this.f21581params.getEncoded();
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLKEMPrivateKey
    public MLKEMPrivateKey getPrivateKey(boolean z) {
        return (!z || this.f21581params.m15794getSeed() == null) ? new BCMLKEMPrivateKey(this.f21581params.withPreferredFormat(2)) : new BCMLKEMPrivateKey(this.f21581params.withPreferredFormat(1));
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLKEMPrivateKey
    public MLKEMPublicKey getPublicKey() {
        return new BCMLKEMPublicKey(this.f21581params.getPublicKeyParameters());
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLKEMPrivateKey
    /* renamed from: getSeed */
    public byte[] mo16082getSeed() {
        return this.f21581params.m15794getSeed();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f21581params.getEncoded());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        byte[] publicKey = this.f21581params.getPublicKey();
        sb.append(getAlgorithm());
        sb.append(" ");
        sb.append("Private Key");
        sb.append(" [");
        sb.append(new Fingerprint(publicKey).toString());
        sb.append("]");
        sb.append(strLineSeparator);
        sb.append("    public data: ");
        sb.append(C6255Hex.toHexString(publicKey));
        sb.append(strLineSeparator);
        return sb.toString();
    }

    public BCMLKEMPrivateKey(MLKEMPrivateKeyParameters mLKEMPrivateKeyParameters) {
        this.f21581params = mLKEMPrivateKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(mLKEMPrivateKeyParameters.getParameters().m15790getName());
    }
}
