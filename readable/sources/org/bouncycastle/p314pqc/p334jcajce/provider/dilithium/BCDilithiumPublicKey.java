package org.bouncycastle.p314pqc.p334jcajce.provider.dilithium;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.DilithiumPublicKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.DilithiumParameterSpec;
import org.bouncycastle.p314pqc.p334jcajce.provider.p349util.C6210KeyUtil;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCDilithiumPublicKey implements DilithiumPublicKey {
    private static final long serialVersionUID = 1;
    private transient String algorithm;
    private transient byte[] encoding;

    /* renamed from: params */
    private transient DilithiumPublicKeyParameters f23723params;

    public BCDilithiumPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17953init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17953init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17954init((DilithiumPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo));
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17953init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17955equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCDilithiumPublicKey) {
            return C6238Arrays.areEqual(getEncoded(), ((BCDilithiumPublicKey) obj).getEncoded());
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
            this.encoding = C6210KeyUtil.getEncodedSubjectPublicKeyInfo(this.f23723params);
        }
        return C6238Arrays.m18231clone(this.encoding);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public DilithiumPublicKeyParameters getKeyParams() {
        return this.f23723params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.DilithiumKey
    public DilithiumParameterSpec getParameterSpec() {
        return DilithiumParameterSpec.fromName(this.f23723params.getParameters().m17515getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(getEncoded());
    }

    public BCDilithiumPublicKey(DilithiumPublicKeyParameters dilithiumPublicKeyParameters) {
        m17954init(dilithiumPublicKeyParameters);
    }

    /* renamed from: init */
    private void m17954init(DilithiumPublicKeyParameters dilithiumPublicKeyParameters) {
        this.f23723params = dilithiumPublicKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(dilithiumPublicKeyParameters.getParameters().m17515getName());
    }
}
