package org.bouncycastle.p194crypto.p217signers;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithContext;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.SLHDSAParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine;
import org.bouncycastle.p314pqc.p316crypto.MessageSigner;

/* loaded from: classes2.dex */
public class SLHDSASigner implements MessageSigner {
    private static final byte[] DEFAULT_PREFIX = {0, 0};
    private byte[] msgPrefix;

    /* renamed from: optRand */
    private byte[] f21034optRand;

    /* renamed from: pkRoot */
    private byte[] f21035pkRoot;

    /* renamed from: pkSeed */
    private byte[] f21036pkSeed;

    /* renamed from: privKey */
    private SLHDSAPrivateKeyParameters f21037privKey;

    /* renamed from: pubKey */
    private SLHDSAPublicKeyParameters f21038pubKey;

    /* renamed from: random */
    private SecureRandom f21039random;

    /* renamed from: skPrf */
    private byte[] f21040skPrf;

    /* renamed from: skSeed */
    private byte[] f21041skSeed;

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public byte[] generateSignature(byte[] bArr) {
        SecureRandom secureRandom = this.f21039random;
        if (secureRandom != null) {
            secureRandom.nextBytes(this.f21034optRand);
        } else {
            byte[] publicSeed = this.f21037privKey.getPublicSeed();
            byte[] bArr2 = this.f21034optRand;
            System.arraycopy(publicSeed, 0, bArr2, 0, bArr2.length);
        }
        return SLHDSAEngine.internalGenerateSignature(this.f21037privKey.getParameters(), this.f21041skSeed, this.f21040skPrf, this.f21036pkSeed, this.f21035pkRoot, this.msgPrefix, bArr, this.f21034optRand);
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
            this.f21038pubKey = null;
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f21037privKey = (SLHDSAPrivateKeyParameters) parametersWithRandom.getParameters();
                this.f21039random = parametersWithRandom.getRandom();
            } else {
                this.f21037privKey = (SLHDSAPrivateKeyParameters) cipherParameters;
                this.f21039random = null;
            }
            this.f21041skSeed = this.f21037privKey.m15822getSeed();
            this.f21040skPrf = this.f21037privKey.m15820getPrf();
            this.f21036pkSeed = this.f21037privKey.getPublicSeed();
            this.f21035pkRoot = this.f21037privKey.m15821getRoot();
            parameters = this.f21037privKey.getParameters();
            this.f21034optRand = new byte[parameters.m15815getN()];
        } else {
            SLHDSAPublicKeyParameters sLHDSAPublicKeyParameters = (SLHDSAPublicKeyParameters) cipherParameters;
            this.f21038pubKey = sLHDSAPublicKeyParameters;
            this.f21037privKey = null;
            this.f21039random = null;
            this.f21041skSeed = null;
            this.f21040skPrf = null;
            this.f21036pkSeed = sLHDSAPublicKeyParameters.m15824getSeed();
            this.f21035pkRoot = this.f21038pubKey.m15823getRoot();
            parameters = this.f21038pubKey.getParameters();
        }
        if (parameters.isPreHash()) {
            throw new IllegalArgumentException("\"pure\" slh-dsa must use non pre-hash parameters");
        }
    }

    public byte[] internalGenerateSignature(byte[] bArr, byte[] bArr2) {
        return SLHDSAEngine.internalGenerateSignature(this.f21037privKey.getParameters(), this.f21041skSeed, this.f21040skPrf, this.f21036pkSeed, this.f21035pkRoot, null, bArr, bArr2);
    }

    public boolean internalVerifySignature(byte[] bArr, byte[] bArr2) {
        return SLHDSAEngine.internalVerifySignature(this.f21038pubKey.getParameters(), this.f21036pkSeed, this.f21035pkRoot, null, bArr, bArr2);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.MessageSigner
    public boolean verifySignature(byte[] bArr, byte[] bArr2) {
        return SLHDSAEngine.internalVerifySignature(this.f21038pubKey.getParameters(), this.f21036pkSeed, this.f21035pkRoot, this.msgPrefix, bArr, bArr2);
    }
}
