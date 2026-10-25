package org.bouncycastle.p194crypto.p217signers;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.MLDSAParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithContext;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p217signers.p218mldsa.MLDSAEngine;

/* loaded from: classes2.dex */
public class MLDSASigner implements InterfaceC5282Signer {
    private static final byte[] EMPTY_CONTEXT = new byte[0];

    /* renamed from: engine */
    private MLDSAEngine f21007engine;

    /* renamed from: k */
    private byte[] f21008k;
    private SHAKEDigest msgDigest;

    /* renamed from: privKey */
    private MLDSAPrivateKeyParameters f21009privKey;

    /* renamed from: pubKey */
    private MLDSAPublicKeyParameters f21010pubKey;

    /* renamed from: random */
    private SecureRandom f21011random;

    /* renamed from: rho */
    private byte[] f21012rho;

    /* renamed from: s1 */
    private byte[] f21013s1;

    /* renamed from: s2 */
    private byte[] f21014s2;

    /* renamed from: t0 */
    private byte[] f21015t0;

    /* renamed from: t1 */
    private byte[] f21016t1;

    public byte[] generateMu() {
        byte[] bArrGenerateMu = this.f21007engine.generateMu(this.msgDigest);
        mo14988reset();
        return bArrGenerateMu;
    }

    public byte[] generateMuSignature(byte[] bArr) {
        if (bArr.length != 64) {
            throw new DataLengthException("mu value must be 64 bytes");
        }
        byte[] bArr2 = new byte[32];
        SecureRandom secureRandom = this.f21011random;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr2);
        }
        this.msgDigest.mo14968reset();
        byte[] bArrGenerateSignature = this.f21007engine.generateSignature(bArr, this.msgDigest, this.f21012rho, this.f21008k, this.f21015t0, this.f21013s1, this.f21014s2, bArr2);
        mo14988reset();
        return bArrGenerateSignature;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        byte[] bArr = new byte[32];
        SecureRandom secureRandom = this.f21011random;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr);
        }
        byte[] bArrGenerateSignature = this.f21007engine.generateSignature(this.f21007engine.generateMu(this.msgDigest), this.msgDigest, this.f21012rho, this.f21008k, this.f21015t0, this.f21013s1, this.f21014s2, bArr);
        mo14988reset();
        return bArrGenerateSignature;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        MLDSAParameters parameters;
        byte[] context = EMPTY_CONTEXT;
        this.f21014s2 = null;
        this.f21013s1 = null;
        this.f21016t1 = null;
        this.f21015t0 = null;
        this.f21008k = null;
        this.f21012rho = null;
        if (cipherParameters instanceof ParametersWithContext) {
            ParametersWithContext parametersWithContext = (ParametersWithContext) cipherParameters;
            context = parametersWithContext.getContext();
            cipherParameters = parametersWithContext.getParameters();
            if (context.length > 255) {
                throw new IllegalArgumentException("context too long");
            }
        }
        if (z) {
            this.f21010pubKey = null;
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f21009privKey = (MLDSAPrivateKeyParameters) parametersWithRandom.getParameters();
                this.f21011random = parametersWithRandom.getRandom();
            } else {
                this.f21009privKey = (MLDSAPrivateKeyParameters) cipherParameters;
                this.f21011random = null;
            }
            parameters = this.f21009privKey.getParameters();
            this.f21007engine = MLDSAEngine.getInstance(parameters, this.f21011random);
            this.f21012rho = this.f21009privKey.m15780getRho();
            this.f21015t0 = this.f21009privKey.m15784getT0();
            this.f21008k = this.f21009privKey.m15779getK();
            this.f21013s1 = this.f21009privKey.m15781getS1();
            this.f21014s2 = this.f21009privKey.m15782getS2();
            this.f21007engine.initSign(this.f21009privKey.m15786getTr(), false, context);
        } else {
            MLDSAPublicKeyParameters mLDSAPublicKeyParameters = (MLDSAPublicKeyParameters) cipherParameters;
            this.f21010pubKey = mLDSAPublicKeyParameters;
            this.f21009privKey = null;
            this.f21011random = null;
            parameters = mLDSAPublicKeyParameters.getParameters();
            this.f21007engine = MLDSAEngine.getInstance(parameters, null);
            this.f21016t1 = this.f21010pubKey.m15788getT1();
            byte[] bArrM15787getRho = this.f21010pubKey.m15787getRho();
            this.f21012rho = bArrM15787getRho;
            this.f21007engine.initVerify(bArrM15787getRho, this.f21016t1, false, context);
        }
        if (parameters.isPreHash()) {
            throw new IllegalArgumentException("\"pure\" ml-dsa must use non pre-hash parameters");
        }
        mo14988reset();
    }

    public byte[] internalGenerateSignature(byte[] bArr, byte[] bArr2) {
        MLDSAEngine mLDSAEngine = MLDSAEngine.getInstance(this.f21009privKey.getParameters(), this.f21011random);
        mLDSAEngine.initSign(this.f21009privKey.m15786getTr(), false, null);
        return mLDSAEngine.signInternal(bArr, bArr.length, this.f21012rho, this.f21008k, this.f21015t0, this.f21013s1, this.f21014s2, bArr2);
    }

    public boolean internalVerifySignature(byte[] bArr, byte[] bArr2) {
        MLDSAEngine mLDSAEngine = MLDSAEngine.getInstance(this.f21010pubKey.getParameters(), this.f21011random);
        mLDSAEngine.initVerify(this.f21012rho, this.f21016t1, false, null);
        SHAKEDigest shake256Digest = mLDSAEngine.getShake256Digest();
        shake256Digest.mo14970update(bArr, 0, bArr.length);
        return mLDSAEngine.verifyInternal(bArr2, bArr2.length, shake256Digest, this.f21012rho, this.f21016t1);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.msgDigest = this.f21007engine.getShake256Digest();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.msgDigest.mo14969update(b);
    }

    public boolean verifyMu(byte[] bArr) {
        if (bArr.length != 64) {
            throw new DataLengthException("mu value must be 64 bytes");
        }
        boolean zVerifyInternalMu = this.f21007engine.verifyInternalMu(bArr);
        mo14988reset();
        return zVerifyInternalMu;
    }

    public boolean verifyMuSignature(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 64) {
            throw new DataLengthException("mu value must be 64 bytes");
        }
        this.msgDigest.mo14968reset();
        boolean zVerifyInternalMuSignature = this.f21007engine.verifyInternalMuSignature(bArr, bArr2, bArr2.length, this.msgDigest, this.f21012rho, this.f21016t1);
        mo14988reset();
        return zVerifyInternalMuSignature;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        boolean zVerifyInternal = this.f21007engine.verifyInternal(bArr, bArr.length, this.msgDigest, this.f21012rho, this.f21016t1);
        mo14988reset();
        return zVerifyInternal;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.msgDigest.mo14970update(bArr, i, i2);
    }
}
