package org.bouncycastle.p314pqc.p316crypto.p330sphincs;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.KeyGenerationParameters;

/* loaded from: classes2.dex */
public class SPHINCS256KeyGenerationParameters extends KeyGenerationParameters {
    private final InterfaceC5277Digest treeDigest;

    public SPHINCS256KeyGenerationParameters(SecureRandom secureRandom, InterfaceC5277Digest interfaceC5277Digest) {
        super(secureRandom, 8448);
        this.treeDigest = interfaceC5277Digest;
    }

    public InterfaceC5277Digest getTreeDigest() {
        return this.treeDigest;
    }
}
