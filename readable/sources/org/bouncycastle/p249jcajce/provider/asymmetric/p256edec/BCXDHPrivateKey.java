package org.bouncycastle.p249jcajce.provider.asymmetric.p256edec;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.PrivateKey;
import org.bouncycastle.internal.p231asn1.p235edec.EdECObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.X25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X25519PublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.X448PublicKeyParameters;
import org.bouncycastle.p194crypto.p221util.PrivateKeyInfoFactory;
import org.bouncycastle.p249jcajce.interfaces.XDHPrivateKey;
import org.bouncycastle.p249jcajce.interfaces.XDHPublicKey;
import org.bouncycastle.p249jcajce.p279spec.XDHParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes2.dex */
public class BCXDHPrivateKey implements XDHPrivateKey {
    static final long serialVersionUID = 1;
    private final byte[] attributes;
    private final boolean hasPublicKey;
    transient int hashCode;
    transient AsymmetricKeyParameter xdhPrivateKey;
    transient AsymmetricKeyParameter xdhPublicKey;

    public BCXDHPrivateKey(PrivateKeyInfo privateKeyInfo) {
        this.hasPublicKey = privateKeyInfo.hasPublicKey();
        this.attributes = privateKeyInfo.getAttributes() != null ? privateKeyInfo.getAttributes().getEncoded() : null;
        populateFromPrivateKeyInfo(privateKeyInfo);
    }

    private int calculateHashCode() {
        AsymmetricKeyParameter asymmetricKeyParameter = this.xdhPublicKey;
        return (getAlgorithm().hashCode() * 31) + C6238Arrays.hashCode(asymmetricKeyParameter instanceof X448PublicKeyParameters ? ((X448PublicKeyParameters) asymmetricKeyParameter).getEncoded() : ((X25519PublicKeyParameters) asymmetricKeyParameter).getEncoded());
    }

    private PrivateKeyInfo getPrivateKeyInfo() {
        try {
            AbstractC5093ASN1Set abstractC5093ASN1Set = AbstractC5093ASN1Set.getInstance(this.attributes);
            PrivateKeyInfo privateKeyInfoCreatePrivateKeyInfo = PrivateKeyInfoFactory.createPrivateKeyInfo(this.xdhPrivateKey, abstractC5093ASN1Set);
            return (!this.hasPublicKey || Properties.isOverrideSet("org.bouncycastle.pkcs8.v1_info_only")) ? new PrivateKeyInfo(privateKeyInfoCreatePrivateKeyInfo.getPrivateKeyAlgorithm(), privateKeyInfoCreatePrivateKeyInfo.parsePrivateKey(), abstractC5093ASN1Set) : privateKeyInfoCreatePrivateKeyInfo;
        } catch (IOException unused) {
            return null;
        }
    }

    private void populateFromPrivateKeyInfo(PrivateKeyInfo privateKeyInfo) {
        AsymmetricKeyParameter asymmetricKeyParameterGeneratePublicKey;
        int privateKeyLength = privateKeyInfo.getPrivateKeyLength();
        byte[] octets = ((privateKeyLength == 32 || privateKeyLength == 56) ? privateKeyInfo.getPrivateKey() : ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey())).getOctets();
        if (EdECObjectIdentifiers.f21248id_X448.m14446equals((ASN1Primitive) privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm())) {
            X448PrivateKeyParameters x448PrivateKeyParameters = new X448PrivateKeyParameters(octets);
            this.xdhPrivateKey = x448PrivateKeyParameters;
            asymmetricKeyParameterGeneratePublicKey = x448PrivateKeyParameters.generatePublicKey();
        } else {
            X25519PrivateKeyParameters x25519PrivateKeyParameters = new X25519PrivateKeyParameters(octets);
            this.xdhPrivateKey = x25519PrivateKeyParameters;
            asymmetricKeyParameterGeneratePublicKey = x25519PrivateKeyParameters.generatePublicKey();
        }
        this.xdhPublicKey = asymmetricKeyParameterGeneratePublicKey;
        this.hashCode = calculateHashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        populateFromPrivateKeyInfo(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public AsymmetricKeyParameter engineGetKeyParameters() {
        return this.xdhPrivateKey;
    }

    /* renamed from: equals */
    public boolean m16110equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof PrivateKey)) {
            return false;
        }
        PrivateKey privateKey = (PrivateKey) obj;
        PrivateKeyInfo privateKeyInfo = getPrivateKeyInfo();
        PrivateKeyInfo privateKeyInfo2 = privateKey instanceof BCXDHPrivateKey ? ((BCXDHPrivateKey) privateKey).getPrivateKeyInfo() : PrivateKeyInfo.getInstance(privateKey.getEncoded());
        if (privateKeyInfo != null && privateKeyInfo2 != null) {
            try {
                return C6238Arrays.constantTimeAreEqual(privateKeyInfo.getPrivateKey().getEncoded(), privateKeyInfo2.getPrivateKey().getEncoded()) & C6238Arrays.constantTimeAreEqual(privateKeyInfo.getPrivateKeyAlgorithm().getEncoded(), privateKeyInfo2.getPrivateKeyAlgorithm().getEncoded());
            } catch (IOException unused) {
            }
        }
        return false;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return Properties.isOverrideSet(Properties.EMULATE_ORACLE) ? "XDH" : this.xdhPrivateKey instanceof X448PrivateKeyParameters ? XDHParameterSpec.f21952X448 : XDHParameterSpec.f21951X25519;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        try {
            PrivateKeyInfo privateKeyInfo = getPrivateKeyInfo();
            if (privateKeyInfo == null) {
                return null;
            }
            return privateKeyInfo.getEncoded();
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.XDHPrivateKey
    public XDHPublicKey getPublicKey() {
        return new BCXDHPublicKey(this.xdhPublicKey);
    }

    public int hashCode() {
        return this.hashCode;
    }

    public String toString() {
        return C5571Utils.keyToString("Private Key", getAlgorithm(), this.xdhPublicKey);
    }

    public BCXDHPrivateKey(AsymmetricKeyParameter asymmetricKeyParameter) {
        this.hasPublicKey = true;
        this.attributes = null;
        this.xdhPrivateKey = asymmetricKeyParameter;
        this.xdhPublicKey = asymmetricKeyParameter instanceof X448PrivateKeyParameters ? ((X448PrivateKeyParameters) asymmetricKeyParameter).generatePublicKey() : ((X25519PrivateKeyParameters) asymmetricKeyParameter).generatePublicKey();
        this.hashCode = calculateHashCode();
    }
}
