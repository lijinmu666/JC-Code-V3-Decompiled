package org.bouncycastle.p314pqc.p316crypto;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;

/* loaded from: classes2.dex */
public class DigestingStateAwareMessageSigner extends DigestingMessageSigner {

    /* renamed from: signer */
    private final StateAwareMessageSigner f23055signer;

    public DigestingStateAwareMessageSigner(StateAwareMessageSigner stateAwareMessageSigner, InterfaceC5277Digest interfaceC5277Digest) {
        super(stateAwareMessageSigner, interfaceC5277Digest);
        this.f23055signer = stateAwareMessageSigner;
    }

    public AsymmetricKeyParameter getUpdatedPrivateKey() {
        return this.f23055signer.getUpdatedPrivateKey();
    }
}
