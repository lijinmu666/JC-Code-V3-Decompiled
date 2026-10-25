package org.bouncycastle.p194crypto.p217signers;

import java.math.BigInteger;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5275DSA;
import org.bouncycastle.p194crypto.InterfaceC5276DSAExt;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;

/* loaded from: classes2.dex */
public class DSADigestSigner implements InterfaceC5282Signer {

    /* renamed from: digest */
    private final InterfaceC5277Digest f20930digest;

    /* renamed from: dsa */
    private final InterfaceC5275DSA f20931dsa;
    private final DSAEncoding encoding;
    private boolean forSigning;

    public DSADigestSigner(InterfaceC5275DSA interfaceC5275DSA, InterfaceC5277Digest interfaceC5277Digest) {
        this.f20931dsa = interfaceC5275DSA;
        this.f20930digest = interfaceC5277Digest;
        this.encoding = StandardDSAEncoding.INSTANCE;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        if (!this.forSigning) {
            throw new IllegalStateException("DSADigestSigner not initialised for signature generation.");
        }
        byte[] bArr = new byte[this.f20930digest.getDigestSize()];
        this.f20930digest.mo14967doFinal(bArr, 0);
        BigInteger[] bigIntegerArrGenerateSignature = this.f20931dsa.generateSignature(bArr);
        try {
            return this.encoding.mo15857encode(getOrder(), bigIntegerArrGenerateSignature[0], bigIntegerArrGenerateSignature[1]);
        } catch (Exception unused) {
            throw new IllegalStateException("unable to encode signature");
        }
    }

    public BigInteger getOrder() {
        InterfaceC5275DSA interfaceC5275DSA = this.f20931dsa;
        if (interfaceC5275DSA instanceof InterfaceC5276DSAExt) {
            return ((InterfaceC5276DSAExt) interfaceC5275DSA).getOrder();
        }
        return null;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        this.forSigning = z;
        AsymmetricKeyParameter asymmetricKeyParameter = cipherParameters instanceof ParametersWithRandom ? (AsymmetricKeyParameter) ((ParametersWithRandom) cipherParameters).getParameters() : (AsymmetricKeyParameter) cipherParameters;
        if (z && !asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("Signing Requires Private Key.");
        }
        if (!z && asymmetricKeyParameter.isPrivate()) {
            throw new IllegalArgumentException("Verification Requires Public Key.");
        }
        mo14988reset();
        this.f20931dsa.mo14965init(z, cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f20930digest.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.f20930digest.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        if (this.forSigning) {
            throw new IllegalStateException("DSADigestSigner not initialised for verification");
        }
        byte[] bArr2 = new byte[this.f20930digest.getDigestSize()];
        this.f20930digest.mo14967doFinal(bArr2, 0);
        try {
            BigInteger[] bigIntegerArrMo15856decode = this.encoding.mo15856decode(getOrder(), bArr);
            return this.f20931dsa.verifySignature(bArr2, bigIntegerArrMo15856decode[0], bigIntegerArrMo15856decode[1]);
        } catch (Exception unused) {
            return false;
        }
    }

    public DSADigestSigner(InterfaceC5276DSAExt interfaceC5276DSAExt, InterfaceC5277Digest interfaceC5277Digest, DSAEncoding dSAEncoding) {
        this.f20931dsa = interfaceC5276DSAExt;
        this.f20930digest = interfaceC5277Digest;
        this.encoding = dSAEncoding;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.f20930digest.mo14970update(bArr, i, i2);
    }
}
