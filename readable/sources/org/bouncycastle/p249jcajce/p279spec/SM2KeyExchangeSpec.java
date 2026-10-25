package org.bouncycastle.p249jcajce.p279spec;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SM2KeyExchangeSpec implements AlgorithmParameterSpec {
    private final PrivateKey ephemeralPrivateKey;

    /* renamed from: id */
    private final byte[] f21942id;
    private final boolean initiator;
    private final PublicKey otherPartyEphemeralKey;
    private final byte[] otherPartyId;

    public SM2KeyExchangeSpec(boolean z, PrivateKey privateKey, PublicKey publicKey, byte[] bArr, byte[] bArr2) {
        this.initiator = z;
        this.ephemeralPrivateKey = privateKey;
        this.otherPartyEphemeralKey = publicKey;
        this.f21942id = C6238Arrays.m18231clone(bArr);
        this.otherPartyId = C6238Arrays.m18231clone(bArr2);
    }

    public PrivateKey getEphemeralPrivateKey() {
        return this.ephemeralPrivateKey;
    }

    /* renamed from: getId */
    public byte[] m16214getId() {
        return C6238Arrays.m18231clone(this.f21942id);
    }

    public PublicKey getOtherPartyEphemeralKey() {
        return this.otherPartyEphemeralKey;
    }

    public byte[] getOtherPartyId() {
        return C6238Arrays.m18231clone(this.otherPartyId);
    }

    public boolean isInitiator() {
        return this.initiator;
    }
}
