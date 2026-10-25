package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithContext;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;

@Deprecated
/* loaded from: classes2.dex */
public class SLHDSASigner implements MessageSigner {
    private static final byte[] DEFAULT_PREFIX = {0, 0};
    private byte[] msgPrefix;

    /* renamed from: optRand */
    private byte[] f23522optRand;

    /* renamed from: privKey */
    private SLHDSAPrivateKeyParameters f23523privKey;

    /* renamed from: pubKey */
    private SLHDSAPublicKeyParameters f23524pubKey;

    /* renamed from: random */
    private SecureRandom f23525random;

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        SecureRandom secureRandom = this.f23525random;
        if (secureRandom != null) {
            secureRandom.nextBytes(this.f23522optRand);
        } else {
            byte[] bArr2 = this.f23523privKey.f23519pk.f23485seed;
            byte[] bArr3 = this.f23522optRand;
            System.arraycopy(bArr2, 0, bArr3, 0, bArr3.length);
        }
        return SLHDSAEngine.internalGenerateSignature(this.f23523privKey, this.msgPrefix, bArr, this.f23522optRand);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    /* renamed from: init */
    public void mo15864init(boolean z, CipherParameters cipherParameters) {
        SLHDSAParameters parameters;
        if (cipherParameters instanceof ParametersWithContext) {
            ParametersWithContext parametersWithContext = (ParametersWithContext) cipherParameters;
            CipherParameters parameters2 = parametersWithContext.getParameters();
            int contextLength = parametersWithContext.getContextLength();
            if (contextLength > 255) {
                throw new IllegalArgumentException("context too long");
            }
            byte[] bArr = new byte[contextLength + 2];
            this.msgPrefix = bArr;
            bArr[0] = 0;
            bArr[1] = (byte) contextLength;
            parametersWithContext.copyContextTo(bArr, 2, contextLength);
            cipherParameters = parameters2;
        } else {
            this.msgPrefix = DEFAULT_PREFIX;
        }
        if (z) {
            this.f23524pubKey = null;
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f23523privKey = (SLHDSAPrivateKeyParameters) parametersWithRandom.getParameters();
                this.f23525random = parametersWithRandom.getRandom();
            } else {
                this.f23523privKey = (SLHDSAPrivateKeyParameters) cipherParameters;
                this.f23525random = null;
            }
            parameters = this.f23523privKey.getParameters();
            this.f23522optRand = new byte[parameters.m17836getN()];
        } else {
            SLHDSAPublicKeyParameters sLHDSAPublicKeyParameters = (SLHDSAPublicKeyParameters) cipherParameters;
            this.f23524pubKey = sLHDSAPublicKeyParameters;
            this.f23523privKey = null;
            this.f23525random = null;
            parameters = sLHDSAPublicKeyParameters.getParameters();
        }
        if (parameters.isPreHash()) {
            throw new IllegalArgumentException("\"pure\" slh-dsa must use non pre-hash parameters");
        }
    }

    public byte[] internalGenerateSignature(byte[] bArr, byte[] bArr2) {
        return SLHDSAEngine.internalGenerateSignature(this.f23523privKey, null, bArr, bArr2);
    }

    public boolean internalVerifySignature(byte[] bArr, byte[] bArr2) {
        return SLHDSAEngine.internalVerifySignature(this.f23524pubKey, null, bArr, bArr2);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        return SLHDSAEngine.internalVerifySignature(this.f23524pubKey, this.msgPrefix, bArr, bArr2);
    }
}
