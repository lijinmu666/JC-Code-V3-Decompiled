package org.bouncycastle.p249jcajce;

import java.security.PublicKey;
import org.bouncycastle.p249jcajce.interfaces.MLDSAPrivateKey;
import org.bouncycastle.p249jcajce.interfaces.MLDSAPublicKey;
import org.bouncycastle.p249jcajce.p279spec.MLDSAParameterSpec;

/* loaded from: classes2.dex */
public class MLDSAProxyPrivateKey implements MLDSAPrivateKey {
    private final MLDSAPublicKey publicKey;

    public MLDSAProxyPrivateKey(PublicKey publicKey) {
        if (!(publicKey instanceof MLDSAPublicKey)) {
            throw new IllegalArgumentException("public key must be an ML-DSA public key");
        }
        this.publicKey = (MLDSAPublicKey) publicKey;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return this.publicKey.getAlgorithm();
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return new byte[0];
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAKey
    public MLDSAParameterSpec getParameterSpec() {
        return this.publicKey.getParameterSpec();
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAPrivateKey
    public byte[] getPrivateData() {
        return new byte[0];
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAPrivateKey
    public MLDSAPrivateKey getPrivateKey(boolean z) {
        return null;
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAPrivateKey
    public MLDSAPublicKey getPublicKey() {
        return this.publicKey;
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.MLDSAPrivateKey
    /* renamed from: getSeed */
    public byte[] mo16063getSeed() {
        return new byte[0];
    }
}
