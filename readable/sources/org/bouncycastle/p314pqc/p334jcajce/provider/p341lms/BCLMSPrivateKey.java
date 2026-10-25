package org.bouncycastle.p314pqc.p334jcajce.provider.p341lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.LMSPrivateKey;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCLMSPrivateKey implements PrivateKey, LMSPrivateKey {
    private static final long serialVersionUID = 8568701712864512338L;
    private transient AbstractC5093ASN1Set attributes;
    private transient LMSKeyParameters keyParams;

    public BCLMSPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17975init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17975init(PrivateKeyInfo privateKeyInfo) {
        this.attributes = privateKeyInfo.getAttributes();
        this.keyParams = (LMSKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17975init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17976equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCLMSPrivateKey)) {
            return false;
        }
        try {
            return C6238Arrays.areEqual(this.keyParams.getEncoded(), ((BCLMSPrivateKey) obj).keyParams.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to perform equals");
        }
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.LMSPrivateKey
    public LMSPrivateKey extractKeyShard(int i) {
        LMSKeyParameters lMSKeyParameters = this.keyParams;
        return lMSKeyParameters instanceof LMSPrivateKeyParameters ? new BCLMSPrivateKey(((LMSPrivateKeyParameters) lMSKeyParameters).extractKeyShard(i)) : new BCLMSPrivateKey(((HSSPrivateKeyParameters) lMSKeyParameters).extractKeyShard(i));
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(this.keyParams, this.attributes).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.LMSPrivateKey
    public long getIndex() {
        if (getUsagesRemaining() == 0) {
            throw new IllegalStateException("key exhausted");
        }
        LMSKeyParameters lMSKeyParameters = this.keyParams;
        return lMSKeyParameters instanceof LMSPrivateKeyParameters ? ((LMSPrivateKeyParameters) lMSKeyParameters).getIndex() : ((HSSPrivateKeyParameters) lMSKeyParameters).getIndex();
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6135LMSKey
    public int getLevels() {
        LMSKeyParameters lMSKeyParameters = this.keyParams;
        if (lMSKeyParameters instanceof LMSPrivateKeyParameters) {
            return 1;
        }
        return ((HSSPrivateKeyParameters) lMSKeyParameters).m17614getL();
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.LMSPrivateKey
    public long getUsagesRemaining() {
        LMSKeyParameters lMSKeyParameters = this.keyParams;
        return lMSKeyParameters instanceof LMSPrivateKeyParameters ? ((LMSPrivateKeyParameters) lMSKeyParameters).getUsagesRemaining() : ((HSSPrivateKeyParameters) lMSKeyParameters).getUsagesRemaining();
    }

    public int hashCode() {
        try {
            return C6238Arrays.hashCode(this.keyParams.getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("unable to calculate hashCode");
        }
    }

    public BCLMSPrivateKey(LMSKeyParameters lMSKeyParameters) {
        HSSPrivateKeyParameters hSSPrivateKeyParameters;
        if (lMSKeyParameters instanceof HSSPrivateKeyParameters) {
            hSSPrivateKeyParameters = (HSSPrivateKeyParameters) lMSKeyParameters;
        } else {
            LMSPrivateKeyParameters lMSPrivateKeyParameters = (LMSPrivateKeyParameters) lMSKeyParameters;
            hSSPrivateKeyParameters = new HSSPrivateKeyParameters(lMSPrivateKeyParameters, lMSPrivateKeyParameters.getIndex(), lMSPrivateKeyParameters.getIndex() + lMSPrivateKeyParameters.getUsagesRemaining());
        }
        this.keyParams = hSSPrivateKeyParameters;
    }
}
