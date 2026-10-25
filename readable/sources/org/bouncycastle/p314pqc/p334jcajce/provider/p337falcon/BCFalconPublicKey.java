package org.bouncycastle.p314pqc.p334jcajce.provider.p337falcon;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p318falcon.FalconPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.FalconPublicKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.FalconParameterSpec;
import org.bouncycastle.p314pqc.p334jcajce.provider.p349util.C6210KeyUtil;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCFalconPublicKey implements FalconPublicKey {
    private static final long serialVersionUID = 1;
    private transient String algorithm;
    private transient byte[] encoding;

    /* renamed from: params */
    private transient FalconPublicKeyParameters f23732params;

    public BCFalconPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17959init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17959init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17960init((FalconPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17959init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17961equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCFalconPublicKey) {
            return C6238Arrays.areEqual(getEncoded(), ((BCFalconPublicKey) obj).getEncoded());
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
            this.encoding = C6210KeyUtil.getEncodedSubjectPublicKeyInfo(this.f23732params);
        }
        return C6238Arrays.m18231clone(this.encoding);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public FalconPublicKeyParameters getKeyParams() {
        return this.f23732params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.FalconKey
    public FalconParameterSpec getParameterSpec() {
        return FalconParameterSpec.fromName(this.f23732params.getParameters().m17549getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(getEncoded());
    }

    public BCFalconPublicKey(FalconPublicKeyParameters falconPublicKeyParameters) {
        m17960init(falconPublicKeyParameters);
    }

    /* renamed from: init */
    private void m17960init(FalconPublicKeyParameters falconPublicKeyParameters) {
        this.f23732params = falconPublicKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(falconPublicKeyParameters.getParameters().m17549getName());
    }
}
