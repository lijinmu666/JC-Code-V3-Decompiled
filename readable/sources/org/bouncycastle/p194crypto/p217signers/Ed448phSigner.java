package org.bouncycastle.p194crypto.p217signers;

import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.p213params.Ed448PrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.Ed448PublicKeyParameters;
import org.bouncycastle.p249jcajce.p279spec.EdDSAParameterSpec;
import org.bouncycastle.p284math.p285ec.p292rfc8032.AbstractC5864Ed448;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class Ed448phSigner implements InterfaceC5282Signer {

    /* renamed from: context */
    private final byte[] f20961context;
    private boolean forSigning;

    /* renamed from: prehash */
    private final InterfaceC5284Xof f20962prehash = AbstractC5864Ed448.createPrehash();
    private Ed448PrivateKeyParameters privateKey;
    private Ed448PublicKeyParameters publicKey;

    public Ed448phSigner(byte[] bArr) {
        if (bArr == null) {
            throw new NullPointerException("'context' cannot be null");
        }
        this.f20961context = C6238Arrays.m18231clone(bArr);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        if (!this.forSigning || this.privateKey == null) {
            throw new IllegalStateException("Ed448phSigner not initialised for signature generation.");
        }
        byte[] bArr = new byte[64];
        if (64 != this.f20962prehash.mo14998doFinal(bArr, 0, 64)) {
            throw new IllegalStateException("Prehash digest failed");
        }
        byte[] bArr2 = new byte[114];
        this.privateKey.m15737sign(1, this.f20961context, bArr, 0, 64, bArr2, 0);
        return bArr2;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        Ed448PublicKeyParameters ed448PublicKeyParameters = null;
        if (z) {
            this.privateKey = (Ed448PrivateKeyParameters) cipherParameters;
        } else {
            this.privateKey = null;
            ed448PublicKeyParameters = (Ed448PublicKeyParameters) cipherParameters;
        }
        this.publicKey = ed448PublicKeyParameters;
        CryptoServicesRegistrar.checkConstraints(C5387Utils.getDefaultProperties(EdDSAParameterSpec.f21919Ed448, InterfaceC5102BERTags.f17976FLAGS, cipherParameters, z));
        mo14988reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f20962prehash.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.f20962prehash.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        if (this.forSigning || this.publicKey == null) {
            throw new IllegalStateException("Ed448phSigner not initialised for verification");
        }
        if (114 != bArr.length) {
            this.f20962prehash.mo14968reset();
            return false;
        }
        byte[] bArr2 = new byte[64];
        if (64 == this.f20962prehash.mo14998doFinal(bArr2, 0, 64)) {
            return this.publicKey.m15740verify(1, this.f20961context, bArr2, 0, 64, bArr, 0);
        }
        throw new IllegalStateException("Prehash digest failed");
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.f20962prehash.mo14970update(bArr, i, i2);
    }
}
