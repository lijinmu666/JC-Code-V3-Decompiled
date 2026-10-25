package org.bouncycastle.p314pqc.p316crypto.p330sphincs;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPair;
import org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.KeyGenerationParameters;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p330sphincs.C6102Tree;

/* loaded from: classes2.dex */
public class SPHINCS256KeyPairGenerator implements AsymmetricCipherKeyPairGenerator {

    /* renamed from: random */
    private SecureRandom f23576random;
    private InterfaceC5277Digest treeDigest;

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    public AsymmetricCipherKeyPair generateKeyPair() {
        C6102Tree.leafaddr leafaddrVar = new C6102Tree.leafaddr();
        byte[] bArr = new byte[1088];
        this.f23576random.nextBytes(bArr);
        byte[] bArr2 = new byte[1056];
        System.arraycopy(bArr, 32, bArr2, 0, 1024);
        leafaddrVar.f23580level = 11;
        leafaddrVar.f23582subtree = 0L;
        leafaddrVar.f23581subleaf = 0L;
        C6102Tree.treehash(new HashFunctions(this.treeDigest), bArr2, 1024, 5, bArr, leafaddrVar, bArr2, 0);
        return new AsymmetricCipherKeyPair((AsymmetricKeyParameter) new SPHINCSPublicKeyParameters(bArr2, this.treeDigest.getAlgorithmName()), (AsymmetricKeyParameter) new SPHINCSPrivateKeyParameters(bArr, this.treeDigest.getAlgorithmName()));
    }

    @Override // org.bouncycastle.p194crypto.AsymmetricCipherKeyPairGenerator
    /* renamed from: init */
    public void mo14944init(KeyGenerationParameters keyGenerationParameters) {
        this.f23576random = keyGenerationParameters.getRandom();
        this.treeDigest = ((SPHINCS256KeyGenerationParameters) keyGenerationParameters).getTreeDigest();
    }
}
