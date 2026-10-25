package org.bouncycastle.p249jcajce.provider.asymmetric.p260mldsa;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p194crypto.p213params.MLDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p221util.PrivateKeyFactory;
import org.bouncycastle.p249jcajce.interfaces.InterfaceC5484BCKey;
import org.bouncycastle.p249jcajce.interfaces.MLDSAPrivateKey;
import org.bouncycastle.p249jcajce.interfaces.MLDSAPublicKey;
import org.bouncycastle.p249jcajce.p279spec.MLDSAParameterSpec;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Fingerprint;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class BCMLDSAPrivateKey implements MLDSAPrivateKey, InterfaceC5484BCKey {
    private static final long serialVersionUID = 1;
    private transient String algorithm;
    private transient AbstractC5093ASN1Set attributes;
    private transient byte[] encoding;

    /* renamed from: params */
    private transient MLDSAPrivateKeyParameters f21573params;

    public BCMLDSAPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m16119init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m16119init(PrivateKeyInfo privateKeyInfo) {
        this.encoding = privateKeyInfo.getEncoded();
        m16120init((MLDSAPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo), privateKeyInfo.getAttributes());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m16119init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m16121equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCMLDSAPrivateKey) {
            return C6238Arrays.areEqual(this.f21573params.getEncoded(), ((BCMLDSAPrivateKey) obj).f21573params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return this.algorithm;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        if (this.encoding == null) {
            this.encoding = C5621KeyUtil.getEncodedPrivateKeyInfo(this.f21573params, this.attributes);
        }
        return C6238Arrays.m18231clone(this.encoding);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public MLDSAPrivateKeyParameters getKeyParams() {
        return this.f21573params;
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAKey
    public MLDSAParameterSpec getParameterSpec() {
        return MLDSAParameterSpec.fromName(this.f21573params.getParameters().m15777getName());
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAPrivateKey
    public byte[] getPrivateData() {
        return this.f21573params.getEncoded();
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAPrivateKey
    public MLDSAPrivateKey getPrivateKey(boolean z) {
        return (!z || this.f21573params.m15783getSeed() == null) ? new BCMLDSAPrivateKey(this.f21573params.getParametersWithFormat(2)) : new BCMLDSAPrivateKey(this.f21573params.getParametersWithFormat(1));
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAPrivateKey
    public MLDSAPublicKey getPublicKey() {
        MLDSAPublicKeyParameters publicKeyParameters = this.f21573params.getPublicKeyParameters();
        if (publicKeyParameters == null) {
            return null;
        }
        return new BCMLDSAPublicKey(publicKeyParameters);
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAPrivateKey
    /* renamed from: getSeed */
    public byte[] mo16063getSeed() {
        return this.f21573params.m15783getSeed();
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f21573params.getEncoded());
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        byte[] publicKey = this.f21573params.getPublicKey();
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

    public BCMLDSAPrivateKey(MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters) {
        this.f21573params = mLDSAPrivateKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(MLDSAParameterSpec.fromName(mLDSAPrivateKeyParameters.getParameters().m15777getName()).m16205getName());
    }

    /* renamed from: init */
    private void m16120init(MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this.attributes = abstractC5093ASN1Set;
        this.f21573params = mLDSAPrivateKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(MLDSAParameterSpec.fromName(mLDSAPrivateKeyParameters.getParameters().m15777getName()).m16205getName());
    }
}
