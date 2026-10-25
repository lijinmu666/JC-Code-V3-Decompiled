package org.bouncycastle.p314pqc.p334jcajce.provider.p348sphincs;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PublicKey;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p314pqc.p315asn1.PQCObjectIdentifiers;
import org.bouncycastle.p314pqc.p315asn1.SPHINCS256KeyParams;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.SPHINCSPublicKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PublicKeyFactory;
import org.bouncycastle.p314pqc.p316crypto.p331util.SubjectPublicKeyInfoFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.SPHINCSKey;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BCSphincs256PublicKey implements PublicKey, SPHINCSKey {
    private static final long serialVersionUID = 1;

    /* renamed from: params */
    private transient SPHINCSPublicKeyParameters f23861params;
    private transient ASN1ObjectIdentifier treeDigest;

    public BCSphincs256PublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, SPHINCSPublicKeyParameters sPHINCSPublicKeyParameters) {
        this.treeDigest = aSN1ObjectIdentifier;
        this.f23861params = sPHINCSPublicKeyParameters;
    }

    /* renamed from: init */
    private void m18017init(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this.treeDigest = SPHINCS256KeyParams.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters()).getTreeDigest().getAlgorithm();
        this.f23861params = (SPHINCSPublicKeyParameters) PublicKeyFactory.createKey(subjectPublicKeyInfo);
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m18017init(SubjectPublicKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m18018equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof BCSphincs256PublicKey)) {
            return false;
        }
        BCSphincs256PublicKey bCSphincs256PublicKey = (BCSphincs256PublicKey) obj;
        return this.treeDigest.m14446equals((ASN1Primitive) bCSphincs256PublicKey.treeDigest) && C6238Arrays.areEqual(this.f23861params.getKeyData(), bCSphincs256PublicKey.f23861params.getKeyData());
    }

    @Override // java.security.Key
    public final String getAlgorithm() {
        return "SPHINCS-256";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            return (this.f23861params.getTreeDigest() != null ? SubjectPublicKeyInfoFactory.createSubjectPublicKeyInfo(this.f23861params) : new SubjectPublicKeyInfo(new AlgorithmIdentifier(PQCObjectIdentifiers.sphincs256, new SPHINCS256KeyParams(new AlgorithmIdentifier(this.treeDigest))), this.f23861params.getKeyData())).getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.SPHINCSKey
    public byte[] getKeyData() {
        return this.f23861params.getKeyData();
    }

    public CipherParameters getKeyParams() {
        return this.f23861params;
    }

    public ASN1ObjectIdentifier getTreeDigest() {
        return this.treeDigest;
    }

    public int hashCode() {
        return this.treeDigest.hashCode() + (C6238Arrays.hashCode(this.f23861params.getKeyData()) * 37);
    }

    public BCSphincs256PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        m18017init(subjectPublicKeyInfo);
    }
}
