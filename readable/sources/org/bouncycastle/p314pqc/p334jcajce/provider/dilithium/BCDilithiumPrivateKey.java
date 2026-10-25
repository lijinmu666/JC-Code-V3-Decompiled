package org.bouncycastle.p314pqc.p334jcajce.provider.dilithium;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.DilithiumPrivateKeyParameters;
import org.bouncycastle.p314pqc.p316crypto.p331util.PrivateKeyFactory;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.DilithiumPrivateKey;
import org.bouncycastle.p314pqc.p334jcajce.interfaces.DilithiumPublicKey;
import org.bouncycastle.p314pqc.p334jcajce.p351spec.DilithiumParameterSpec;
import org.bouncycastle.p314pqc.p334jcajce.provider.p349util.C6210KeyUtil;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class BCDilithiumPrivateKey implements DilithiumPrivateKey {
    private static final long serialVersionUID = 1;
    private transient String algorithm;
    private transient AbstractC5093ASN1Set attributes;
    private transient byte[] encoding;

    /* renamed from: params */
    private transient DilithiumPrivateKeyParameters f23722params;

    public BCDilithiumPrivateKey(PrivateKeyInfo privateKeyInfo) {
        m17950init(privateKeyInfo);
    }

    /* renamed from: init */
    private void m17950init(PrivateKeyInfo privateKeyInfo) {
        m17951init((DilithiumPrivateKeyParameters) PrivateKeyFactory.createKey(privateKeyInfo), privateKeyInfo.getAttributes());
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m17950init(PrivateKeyInfo.getInstance((byte[]) objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m17952equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BCDilithiumPrivateKey) {
            return C6238Arrays.areEqual(getEncoded(), ((BCDilithiumPrivateKey) obj).getEncoded());
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
            this.encoding = C6210KeyUtil.getEncodedPrivateKeyInfo(this.f23722params, this.attributes);
        }
        return C6238Arrays.m18231clone(this.encoding);
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public DilithiumPrivateKeyParameters getKeyParams() {
        return this.f23722params;
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.DilithiumKey
    public DilithiumParameterSpec getParameterSpec() {
        return DilithiumParameterSpec.fromName(this.f23722params.getParameters().m17515getName());
    }

    @Override // org.bouncycastle.p314pqc.p334jcajce.interfaces.DilithiumPrivateKey
    public DilithiumPublicKey getPublicKey() {
        return new BCDilithiumPublicKey(this.f23722params.getPublicKeyParameters());
    }

    public int hashCode() {
        return C6238Arrays.hashCode(getEncoded());
    }

    public BCDilithiumPrivateKey(DilithiumPrivateKeyParameters dilithiumPrivateKeyParameters) {
        m17951init(dilithiumPrivateKeyParameters, null);
    }

    /* renamed from: init */
    private void m17951init(DilithiumPrivateKeyParameters dilithiumPrivateKeyParameters, AbstractC5093ASN1Set abstractC5093ASN1Set) {
        this.attributes = abstractC5093ASN1Set;
        this.f23722params = dilithiumPrivateKeyParameters;
        this.algorithm = C6250Strings.toUpperCase(dilithiumPrivateKeyParameters.getParameters().m17515getName());
    }
}
