package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;

/* loaded from: classes2.dex */
public class DilithiumSigner implements MessageSigner {

    /* renamed from: privKey */
    private DilithiumPrivateKeyParameters f23095privKey;

    /* renamed from: pubKey */
    private DilithiumPublicKeyParameters f23096pubKey;

    /* renamed from: random */
    private SecureRandom f23097random;

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        DilithiumEngine engine = this.f23095privKey.getParameters().getEngine(this.f23097random);
        int length = bArr.length;
        DilithiumPrivateKeyParameters dilithiumPrivateKeyParameters = this.f23095privKey;
        return engine.m17514sign(bArr, length, dilithiumPrivateKeyParameters.f23087rho, dilithiumPrivateKeyParameters.f23086k, dilithiumPrivateKeyParameters.f23092tr, dilithiumPrivateKeyParameters.f23090t0, dilithiumPrivateKeyParameters.f23088s1, dilithiumPrivateKeyParameters.f23089s2);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        SecureRandom random;
        if (!z) {
            this.f23096pubKey = (DilithiumPublicKeyParameters) cipherParameters;
            return;
        }
        if (cipherParameters instanceof ParametersWithRandom) {
            ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
            this.f23095privKey = (DilithiumPrivateKeyParameters) parametersWithRandom.getParameters();
            random = parametersWithRandom.getRandom();
        } else {
            this.f23095privKey = (DilithiumPrivateKeyParameters) cipherParameters;
            random = null;
        }
        this.f23097random = random;
    }

    public byte[] internalGenerateSignature(byte[] bArr, byte[] bArr2) {
        DilithiumEngine engine = this.f23095privKey.getParameters().getEngine(this.f23097random);
        int length = bArr.length;
        DilithiumPrivateKeyParameters dilithiumPrivateKeyParameters = this.f23095privKey;
        return engine.signSignatureInternal(bArr, length, dilithiumPrivateKeyParameters.f23087rho, dilithiumPrivateKeyParameters.f23086k, dilithiumPrivateKeyParameters.f23092tr, dilithiumPrivateKeyParameters.f23090t0, dilithiumPrivateKeyParameters.f23088s1, dilithiumPrivateKeyParameters.f23089s2, bArr2);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        DilithiumEngine engine = this.f23096pubKey.getParameters().getEngine(this.f23097random);
        int length = bArr2.length;
        DilithiumPublicKeyParameters dilithiumPublicKeyParameters = this.f23096pubKey;
        return engine.signOpen(bArr, bArr2, length, dilithiumPublicKeyParameters.f23093rho, dilithiumPublicKeyParameters.f23094t1);
    }
}
