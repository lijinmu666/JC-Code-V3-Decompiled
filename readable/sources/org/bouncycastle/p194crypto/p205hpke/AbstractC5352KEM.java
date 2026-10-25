package org.bouncycastle.p194crypto.p205hpke;

import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* renamed from: org.bouncycastle.crypto.hpke.KEM */
/* loaded from: classes2.dex */
public abstract class AbstractC5352KEM {
    public abstract byte[] AuthDecap(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair, AsymmetricKeyParameter asymmetricKeyParameter);

    public abstract byte[][] AuthEncap(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricCipherKeyPair asymmetricCipherKeyPair);

    /* renamed from: Decap */
    public abstract byte[] mo15540Decap(byte[] bArr, AsymmetricCipherKeyPair asymmetricCipherKeyPair);

    public abstract AsymmetricCipherKeyPair DeriveKeyPair(byte[] bArr);

    public abstract AsymmetricCipherKeyPair DeserializePrivateKey(byte[] bArr, byte[] bArr2);

    public abstract AsymmetricKeyParameter DeserializePublicKey(byte[] bArr);

    /* renamed from: Encap */
    public abstract byte[][] mo15541Encap(AsymmetricKeyParameter asymmetricKeyParameter);

    /* renamed from: Encap */
    public abstract byte[][] mo15542Encap(AsymmetricKeyParameter asymmetricKeyParameter, AsymmetricCipherKeyPair asymmetricCipherKeyPair);

    public abstract AsymmetricCipherKeyPair GeneratePrivateKey();

    public abstract byte[] SerializePrivateKey(AsymmetricKeyParameter asymmetricKeyParameter);

    public abstract byte[] SerializePublicKey(AsymmetricKeyParameter asymmetricKeyParameter);

    public abstract int getEncryptionSize();
}
