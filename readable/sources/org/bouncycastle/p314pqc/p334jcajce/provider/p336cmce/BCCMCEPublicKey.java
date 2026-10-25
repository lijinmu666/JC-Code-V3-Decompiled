package org.bouncycastle.p314pqc.p334jcajce.provider.p336cmce;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.p317cmce.CMCEPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6133CMCEKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.CMCEParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCCMCEPublicKey implements PublicKey, InterfaceC6133CMCEKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient CMCEPublicKeyParameters f23713params;

    public BCCMCEPublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m17948init(subjectPublicKeyInfo);
    }

    /* renamed from: init */
    private void m17948init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.f23713params = (CMCEPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17948init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17949equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCCMCEPublicKey) {
            return C6238Arrays.areEqual(this.f23713params.getEncoded(), ((BCCMCEPublicKey) obj).f23713params.getEncoded());
        }
        return false;
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return C6250Strings.toUpperCase(this.f23713params.getParameters().m17498getName());
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23713params).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public CMCEPublicKeyParameters getKeyParams() {
        return this.f23713params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.InterfaceC6133CMCEKey
    public CMCEParameterSpec getParameterSpec() {
        return CMCEParameterSpec.fromName(this.f23713params.getParameters().m17498getName());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(this.f23713params.getEncoded());
    }

    public BCCMCEPublicKey(CMCEPublicKeyParameters cMCEPublicKeyParameters) {
        this.f23713params = cMCEPublicKeyParameters;
    }
}
