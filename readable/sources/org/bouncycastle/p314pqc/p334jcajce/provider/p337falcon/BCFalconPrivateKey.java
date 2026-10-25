package org.bouncycastle.p314pqc.p334jcajce.provider.p337falcon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.FalconPrivateKey;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.FalconPublicKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.FalconParameterSpec;
import org.bouncycastle.p314pqc.p334jcajce.provider.p349util.C6210KeyUtil;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCFalconPrivateKey implements FalconPrivateKey {
    private static final long serialVersionUID = 1;
    private transient String algorithm;
    private transient AbstractC5093ASN1Set attributes;
    private transient byte[] encoding;

    /* renamed from: params */
    private transient FalconPrivateKeyParameters f23731params;

    public BCFalconPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17956init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17956init(PrivateKeyInfo privateKeyInfo) {
        m17957init((FalconPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo), privateKeyInfo.getAttributes());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17956init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17958equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCFalconPrivateKey) {
            return C6238Arrays.areEqual(getEncoded(), ((BCFalconPrivateKey) obj).getEncoded());
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
            this.encoding = C6210KeyUtil.getEncodedPrivateKeyInfo(this.f23731params, this.attributes);
        }
        return C6238Arrays.m18231clone(this.encoding);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public FalconPrivateKeyParameters getKeyParams() {
        return this.f23731params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.FalconKey
    public FalconParameterSpec getParameterSpec() {
        return FalconParameterSpec.fromName(this.f23731params.getParameters().m17549getName());
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.FalconPrivateKey
    public FalconPublicKey getPublicKey() {
        return new BCFalconPublicKey(new FalconPublicKeyParameters(this.f23731params.getParameters(), this.f23731params.getPublicKey()));
    }

    public int hashCode() {
        return C6238Arrays.hashCode(getEncoded());
    }

    public BCFalconPrivateKey(FalconPrivateKeyParameters falconPrivateKeyParameters) {
        m17957init(falconPrivateKeyParameters, null);
    }

    /* renamed from: init */
    private void m17957init(FalconPrivateKeyParameters falconPrivateKeyParameters, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this.attributes = abstractC5093ASN1Set;
        this.f23731params = falconPrivateKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(falconPrivateKeyParameters.getParameters().m17549getName());
    }
}
