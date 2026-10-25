package org.bouncycastle.p249jcajce.provider.asymmetric.p263slhdsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p194crypto.p213params.SLHDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p221util.PrivateKeyFactory;
import org.bouncycastle.p194crypto.p221util.PrivateKeyInfoFactory;
import org.bouncycastle.p249jcajce.interfaces.InterfaceC5484BCKey;
import org.bouncycastle.p249jcajce.interfaces.SLHDSAPrivateKey;
import org.bouncycastle.p249jcajce.interfaces.SLHDSAPublicKey;
import org.bouncycastle.p249jcajce.p279spec.SLHDSAParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Fingerprint;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class BCSLHDSAPrivateKey implements SLHDSAPrivateKey, InterfaceC5484BCKey {
    private static final long serialVersionUID = 1;
    private transient AbstractC5093ASN1Set attributes;

    /* renamed from: params */
    private transient SLHDSAPrivateKeyParameters f21621params;

    public BCSLHDSAPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m16132init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m16132init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.f21621params = (SLHDSAPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m16132init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m16133equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCSLHDSAPrivateKey) {
            return C6238Arrays.areEqual(this.f21621params.getEncoded(), ((BCSLHDSAPrivateKey) obj).f21621params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SLH-DSA-" + C6250Strings.toUpperCase(this.f21621params.getParameters().m15816getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.f21621params, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public SLHDSAPrivateKeyParameters getKeyParams() {
        return this.f21621params;
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.SLHDSAKey
    public SLHDSAParameterSpec getParameterSpec() {
        return SLHDSAParameterSpec.fromName(this.f21621params.getParameters().m15816getName());
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.SLHDSAPrivateKey
    public SLHDSAPublicKey getPublicKey() {
        return new BCSLHDSAPublicKey(new SLHDSAPublicKeyParameters(this.f21621params.getParameters(), this.f21621params.getPublicKey()));
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f21621params.getEncoded());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        byte[] publicKey = this.f21621params.getPublicKey();
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

    public BCSLHDSAPrivateKey(SLHDSAPrivateKeyParameters sLHDSAPrivateKeyParameters) {
        this.f21621params = sLHDSAPrivateKeyParameters;
    }
}
