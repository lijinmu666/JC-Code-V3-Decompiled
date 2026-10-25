package org.bouncycastle.p249jcajce;

import javax.crypto.SecretKey;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public final class SecretKeyWithEncapsulation implements SecretKey {
    private final byte[] encapsulation;
    private final SecretKey secretKey;

    public SecretKeyWithEncapsulation(SecretKey secretKey, byte[] bArr) {
        this.secretKey = secretKey;
        this.encapsulation = C6238Arrays.m18231clone(bArr);
    }

    /* renamed from: equals */
    public boolean m16081equals(Object obj) {
        return this.secretKey.equals(obj);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.secretKey.getAlgorithm();
    }

    public byte[] getEncapsulation() {
        return C6238Arrays.m18231clone(this.encapsulation);
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return this.secretKey.getEncoded();
    }

    @Override // java.security.Key
    public String getFormat() {
        return this.secretKey.getFormat();
    }

    public int hashCode() {
        return this.secretKey.hashCode();
    }
}
