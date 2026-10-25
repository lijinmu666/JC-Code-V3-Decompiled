package org.conscrypt;

import java.io.IOException;
import java.io.NotSerializableException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.security.InvalidKeyException;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPoint;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import org.conscrypt.NativeRef;
import org.conscrypt.OpenSSLX509CertificateFactory;

/* loaded from: classes2.dex */
final class OpenSSLECPublicKey implements ECPublicKey, OpenSSLKeyHolder {
    private static final String ALGORITHM = "EC";
    private static final long serialVersionUID = 3215842926808298020L;

    /* renamed from: group */
    protected transient OpenSSLECGroupContext f24423group;

    /* renamed from: key */
    protected transient OpenSSLKey f24424key;

    public OpenSSLECPublicKey(OpenSSLECGroupContext openSSLECGroupContext, OpenSSLKey openSSLKey) {
        this.f24423group = openSSLECGroupContext;
        this.f24424key = openSSLKey;
    }

    public static OpenSSLKey getInstance(ECPublicKey eCPublicKey) throws InvalidKeyException {
        try {
            OpenSSLECGroupContext openSSLECGroupContext = OpenSSLECGroupContext.getInstance(eCPublicKey.getParams());
            return new OpenSSLKey(NativeCrypto.EVP_PKEY_new_EC_KEY(openSSLECGroupContext.getNativeRef(), OpenSSLECPointContext.getInstance(openSSLECGroupContext, eCPublicKey.getW()).getNativeRef(), null));
        } catch (Exception e) {
            throw new InvalidKeyException(e);
        }
    }

    private ECPoint getPublicKey() {
        return new OpenSSLECPointContext(this.f24423group, new NativeRef.EC_POINT(NativeCrypto.EC_KEY_get_public_key(this.f24424key.getNativeRef()))).getECPoint();
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        try {
            this.f24424key = new OpenSSLKey(NativeCrypto.EVP_parse_public_key((byte[]) objectInputStream.readObject()));
            this.f24423group = new OpenSSLECGroupContext(new NativeRef.EC_GROUP(NativeCrypto.EC_KEY_get1_group(this.f24424key.getNativeRef())));
        } catch (OpenSSLX509CertificateFactory.ParsingException e) {
            throw new IOException(e);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        if (this.f24424key.isHardwareBacked()) {
            throw new NotSerializableException("Hardware backed keys cannot be serialized");
        }
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m18481equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof OpenSSLECPublicKey) {
            return this.f24424key.m18483equals(((OpenSSLECPublicKey) obj).f24424key);
        }
        if (!(obj instanceof ECPublicKey)) {
            return false;
        }
        ECPublicKey eCPublicKey = (ECPublicKey) obj;
        if (!getPublicKey().equals(eCPublicKey.getW())) {
            return false;
        }
        ECParameterSpec params = getParams();
        ECParameterSpec params2 = eCPublicKey.getParams();
        return params.getCurve().equals(params2.getCurve()) && params.getGenerator().equals(params2.getGenerator()) && params.getOrder().equals(params2.getOrder()) && params.getCofactor() == params2.getCofactor();
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return ALGORITHM;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return NativeCrypto.EVP_marshal_public_key(this.f24424key.getNativeRef());
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    @Override // org.conscrypt.OpenSSLKeyHolder
    public OpenSSLKey getOpenSSLKey() {
        return this.f24424key;
    }

    @Override // java.security.interfaces.ECKey
    public ECParameterSpec getParams() {
        return this.f24423group.getECParameterSpec();
    }

    @Override // java.security.interfaces.ECPublicKey
    public ECPoint getW() {
        return getPublicKey();
    }

    public int hashCode() {
        return Arrays.hashCode(NativeCrypto.EVP_marshal_public_key(this.f24424key.getNativeRef()));
    }

    public String toString() {
        return NativeCrypto.EVP_PKEY_print_public(this.f24424key.getNativeRef());
    }

    public OpenSSLECPublicKey(OpenSSLKey openSSLKey) {
        this.f24423group = new OpenSSLECGroupContext(new NativeRef.EC_GROUP(NativeCrypto.EC_KEY_get1_group(openSSLKey.getNativeRef())));
        this.f24424key = openSSLKey;
    }

    public OpenSSLECPublicKey(ECPublicKeySpec eCPublicKeySpec) throws InvalidKeySpecException {
        try {
            OpenSSLECGroupContext openSSLECGroupContext = OpenSSLECGroupContext.getInstance(eCPublicKeySpec.getParams());
            this.f24423group = openSSLECGroupContext;
            this.f24424key = new OpenSSLKey(NativeCrypto.EVP_PKEY_new_EC_KEY(this.f24423group.getNativeRef(), OpenSSLECPointContext.getInstance(openSSLECGroupContext, eCPublicKeySpec.getW()).getNativeRef(), null));
        } catch (Exception e) {
            throw new InvalidKeySpecException(e);
        }
    }
}
