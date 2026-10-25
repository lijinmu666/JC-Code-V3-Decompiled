package org.bouncycastle.p314pqc.p334jcajce.provider.p341lms;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.HSSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p321lms.LMSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6135LMSKey;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCLMSPublicKey implements PublicKey, InterfaceC6135LMSKey {
    private static final long serialVersionUID = -5617456225328969766L;
    private transient LMSKeyParameters keyParams;

    public BCLMSPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17977init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17977init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.keyParams = (LMSKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17977init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17978equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCLMSPublicKey) {
            try {
                return C6238Arrays.areEqual(this.keyParams.getEncoded(), ((BCLMSPublicKey) obj).keyParams.getEncoded());
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "LMS";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.keyParams).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public CipherParameters getKeyParams() {
        return this.keyParams;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6135LMSKey
    public int getLevels() {
        LMSKeyParameters lMSKeyParameters = this.keyParams;
        if (lMSKeyParameters instanceof LMSPublicKeyParameters) {
            return 1;
        }
        return ((HSSPublicKeyParameters) lMSKeyParameters).m17618getL();
    }

    public int hashCode() {
        try {
            return C6238Arrays.hashCode(this.keyParams.getEncoded());
        } catch (IOException unused) {
            return -1;
        }
    }

    public BCLMSPublicKey(LMSKeyParameters lMSKeyParameters) {
        this.keyParams = lMSKeyParameters instanceof HSSPublicKeyParameters ? lMSKeyParameters : new HSSPublicKeyParameters(1, (LMSPublicKeyParameters) lMSKeyParameters);
    }
}
