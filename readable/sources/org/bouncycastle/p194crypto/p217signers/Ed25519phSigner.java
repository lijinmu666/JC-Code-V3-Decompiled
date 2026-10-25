package org.bouncycastle.p194crypto.p217signers;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p213params.Ed25519PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed25519PublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.EdDSAParameterSpec;
import org.bouncycastle.p284math.p285ec.p292rfc8032.AbstractC5863Ed25519;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class Ed25519phSigner implements InterfaceC5282Signer {

    /* renamed from: context */
    private final byte[] f20957context;
    private boolean forSigning;

    /* renamed from: prehash */
    private final InterfaceC5277Digest f20958prehash = AbstractC5863Ed25519.createPrehash();
    private Ed25519PrivateKeyParameters privateKey;
    private Ed25519PublicKeyParameters publicKey;

    public Ed25519phSigner(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'context' cannot be null");
        }
        this.f20957context = C6238Arrays.m18231clone(bArr);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        if (!this.forSigning || this.privateKey == null) {
            throw new IllegalStateException("Ed25519phSigner not initialised for signature generation.");
        }
        byte[] bArr = new byte[64];
        if (64 != this.f20958prehash.mo14967doFinal(bArr, 0)) {
            throw new IllegalStateException("Prehash digest failed");
        }
        byte[] bArr2 = new byte[64];
        this.privateKey.m15731sign(2, this.f20957context, bArr, 0, 64, bArr2, 0);
        return bArr2;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        Ed25519PublicKeyParameters ed25519PublicKeyParameters = null;
        if (z) {
            this.privateKey = (Ed25519PrivateKeyParameters) cipherParameters;
        } else {
            this.privateKey = null;
            ed25519PublicKeyParameters = (Ed25519PublicKeyParameters) cipherParameters;
        }
        this.publicKey = ed25519PublicKeyParameters;
        CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties(EdDSAParameterSpec.f21918Ed25519, 128, cipherParameters, z));
        mo14988reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f20958prehash.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.f20958prehash.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        if (this.forSigning || this.publicKey == null) {
            throw new IllegalStateException("Ed25519phSigner not initialised for verification");
        }
        if (64 != bArr.length) {
            this.f20958prehash.mo14968reset();
            return false;
        }
        byte[] bArr2 = new byte[64];
        if (64 == this.f20958prehash.mo14967doFinal(bArr2, 0)) {
            return this.publicKey.m15734verify(2, this.f20957context, bArr2, 0, 64, bArr, 0);
        }
        throw new IllegalStateException("Prehash digest failed");
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.f20958prehash.mo14970update(bArr, i, i2);
    }
}
