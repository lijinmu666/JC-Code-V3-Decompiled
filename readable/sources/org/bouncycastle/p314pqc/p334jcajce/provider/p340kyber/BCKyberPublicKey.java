package org.bouncycastle.p314pqc.p334jcajce.provider.p340kyber;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.p213params.MLKEMPublicKeyParameters;
import org.bouncycastle.p194crypto.p221util.PublicKeyFactory;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.C5621KeyUtil;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.KyberPublicKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.KyberParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCKyberPublicKey implements KyberPublicKey {
    private static final long serialVersionUID = 1;
    private transient String algorithm;
    private transient byte[] encoding;

    /* renamed from: params */
    private transient MLKEMPublicKeyParameters f23762params;

    public BCKyberPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17972init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17972init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17973init((MLKEMPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17972init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17974equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCKyberPublicKey) {
            return C6238Arrays.areEqual(getEncoded(), ((BCKyberPublicKey) obj).getEncoded());
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
            this.encoding = C5621KeyUtil.getEncodedSubjectPublicKeyInfo(this.f23762params);
        }
        return C6238Arrays.m18231clone(this.encoding);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public MLKEMPublicKeyParameters getKeyParams() {
        return this.f23762params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.KyberKey
    public KyberParameterSpec getParameterSpec() {
        return KyberParameterSpec.fromName(this.f23762params.getParameters().m15790getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(getEncoded());
    }

    public BCKyberPublicKey(MLKEMPublicKeyParameters mLKEMPublicKeyParameters) {
        m17973init(mLKEMPublicKeyParameters);
    }

    /* renamed from: init */
    private void m17973init(MLKEMPublicKeyParameters mLKEMPublicKeyParameters) {
        this.f23762params = mLKEMPublicKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(mLKEMPublicKeyParameters.getParameters().m15790getName());
    }
}
