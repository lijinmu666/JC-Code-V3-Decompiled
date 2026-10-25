package org.bouncycastle.p281jce.p282spec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.KeySpec;
import org.bouncycastle.p281jce.interfaces.InterfaceC5810IESKey;

/* loaded from: classes2.dex */
public class IEKeySpec implements KeySpec, InterfaceC5810IESKey {

    /* renamed from: privKey */
    private PrivateKey f22081privKey;

    /* renamed from: pubKey */
    private PublicKey f22082pubKey;

    public IEKeySpec(PrivateKey privateKey, PublicKey publicKey) {
        this.f22081privKey = privateKey;
        this.f22082pubKey = publicKey;
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return "IES";
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        return null;
    }

    @Override // java.security.Key
    public String getFormat() {
        return null;
    }

    @Override // org.bouncycastle.p281jce.interfaces.InterfaceC5810IESKey
    public PrivateKey getPrivate() {
        return this.f22081privKey;
    }

    @Override // org.bouncycastle.p281jce.interfaces.InterfaceC5810IESKey
    public PublicKey getPublic() {
        return this.f22082pubKey;
    }
}
