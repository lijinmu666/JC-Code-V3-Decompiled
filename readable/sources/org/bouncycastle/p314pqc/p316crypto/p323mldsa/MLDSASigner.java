package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.ParametersWithContext;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;

@Deprecated
/* loaded from: classes2.dex */
public class MLDSASigner implements InterfaceC5282Signer {
    private static final byte[] EMPTY_CONTEXT = new byte[0];

    /* renamed from: engine */
    private MLDSAEngine f23322engine;
    private SHAKEDigest msgDigest;

    /* renamed from: privKey */
    private MLDSAPrivateKeyParameters f23323privKey;

    /* renamed from: pubKey */
    private MLDSAPublicKeyParameters f23324pubKey;

    /* renamed from: random */
    private SecureRandom f23325random;

    public byte[] generateMu() {
        byte[] bArrGenerateMu = this.f23322engine.generateMu(this.msgDigest);
        mo14988reset();
        return bArrGenerateMu;
    }

    public byte[] generateMuSignature(byte[] bArr) {
        if (bArr.length != 64) {
            throw new DataLengthException("mu value must be 64 bytes");
        }
        byte[] bArr2 = new byte[32];
        SecureRandom secureRandom = this.f23325random;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr2);
        }
        this.msgDigest.mo14968reset();
        MLDSAEngine mLDSAEngine = this.f23322engine;
        SHAKEDigest sHAKEDigest = this.msgDigest;
        MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters = this.f23323privKey;
        byte[] bArrGenerateSignature = mLDSAEngine.generateSignature(bArr, sHAKEDigest, mLDSAPrivateKeyParameters.f23313rho, mLDSAPrivateKeyParameters.f23312k, mLDSAPrivateKeyParameters.f23317t0, mLDSAPrivateKeyParameters.f23314s1, mLDSAPrivateKeyParameters.f23315s2, bArr2);
        mo14988reset();
        return bArrGenerateSignature;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        byte[] bArr = new byte[32];
        SecureRandom secureRandom = this.f23325random;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr);
        }
        byte[] bArrGenerateMu = this.f23322engine.generateMu(this.msgDigest);
        MLDSAEngine mLDSAEngine = this.f23322engine;
        SHAKEDigest sHAKEDigest = this.msgDigest;
        MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters = this.f23323privKey;
        byte[] bArrGenerateSignature = mLDSAEngine.generateSignature(bArrGenerateMu, sHAKEDigest, mLDSAPrivateKeyParameters.f23313rho, mLDSAPrivateKeyParameters.f23312k, mLDSAPrivateKeyParameters.f23317t0, mLDSAPrivateKeyParameters.f23314s1, mLDSAPrivateKeyParameters.f23315s2, bArr);
        mo14988reset();
        return bArrGenerateSignature;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        MLDSAParameters parameters;
        byte[] context = EMPTY_CONTEXT;
        if (cipherParameters instanceof ParametersWithContext) {
            ParametersWithContext parametersWithContext = (ParametersWithContext) cipherParameters;
            context = parametersWithContext.getContext();
            cipherParameters = parametersWithContext.getParameters();
            if (context.length > 255) {
                throw new IllegalArgumentException("context too long");
            }
        }
        if (z) {
            this.f23324pubKey = null;
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f23323privKey = (MLDSAPrivateKeyParameters) parametersWithRandom.getParameters();
                this.f23325random = parametersWithRandom.getRandom();
            } else {
                this.f23323privKey = (MLDSAPrivateKeyParameters) cipherParameters;
                this.f23325random = null;
            }
            parameters = this.f23323privKey.getParameters();
            MLDSAEngine engine = parameters.getEngine(this.f23325random);
            this.f23322engine = engine;
            engine.initSign(this.f23323privKey.f23319tr, false, context);
        } else {
            MLDSAPublicKeyParameters mLDSAPublicKeyParameters = (MLDSAPublicKeyParameters) cipherParameters;
            this.f23324pubKey = mLDSAPublicKeyParameters;
            this.f23323privKey = null;
            this.f23325random = null;
            parameters = mLDSAPublicKeyParameters.getParameters();
            MLDSAEngine engine2 = parameters.getEngine(null);
            this.f23322engine = engine2;
            MLDSAPublicKeyParameters mLDSAPublicKeyParameters2 = this.f23324pubKey;
            engine2.initVerify(mLDSAPublicKeyParameters2.f23320rho, mLDSAPublicKeyParameters2.f23321t1, false, context);
        }
        if (parameters.isPreHash()) {
            throw new IllegalArgumentException("\"pure\" ml-dsa must use non pre-hash parameters");
        }
        mo14988reset();
    }

    public byte[] internalGenerateSignature(byte[] bArr, byte[] bArr2) {
        MLDSAEngine engine = this.f23323privKey.getParameters().getEngine(this.f23325random);
        engine.initSign(this.f23323privKey.f23319tr, false, null);
        int length = bArr.length;
        MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters = this.f23323privKey;
        return engine.signInternal(bArr, length, mLDSAPrivateKeyParameters.f23313rho, mLDSAPrivateKeyParameters.f23312k, mLDSAPrivateKeyParameters.f23317t0, mLDSAPrivateKeyParameters.f23314s1, mLDSAPrivateKeyParameters.f23315s2, bArr2);
    }

    public boolean internalVerifySignature(byte[] bArr, byte[] bArr2) {
        MLDSAEngine engine = this.f23324pubKey.getParameters().getEngine(this.f23325random);
        MLDSAPublicKeyParameters mLDSAPublicKeyParameters = this.f23324pubKey;
        engine.initVerify(mLDSAPublicKeyParameters.f23320rho, mLDSAPublicKeyParameters.f23321t1, false, null);
        SHAKEDigest shake256Digest = engine.getShake256Digest();
        shake256Digest.mo14970update(bArr, 0, bArr.length);
        int length = bArr2.length;
        MLDSAPublicKeyParameters mLDSAPublicKeyParameters2 = this.f23324pubKey;
        return engine.verifyInternal(bArr2, length, shake256Digest, mLDSAPublicKeyParameters2.f23320rho, mLDSAPublicKeyParameters2.f23321t1);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.msgDigest = this.f23322engine.getShake256Digest();
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
        boolean zVerifyInternalMu = this.f23322engine.verifyInternalMu(bArr);
        mo14988reset();
        return zVerifyInternalMu;
    }

    public boolean verifyMuSignature(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 64) {
            throw new DataLengthException("mu value must be 64 bytes");
        }
        this.msgDigest.mo14968reset();
        MLDSAEngine mLDSAEngine = this.f23322engine;
        int length = bArr2.length;
        SHAKEDigest sHAKEDigest = this.msgDigest;
        MLDSAPublicKeyParameters mLDSAPublicKeyParameters = this.f23324pubKey;
        boolean zVerifyInternalMuSignature = mLDSAEngine.verifyInternalMuSignature(bArr, bArr2, length, sHAKEDigest, mLDSAPublicKeyParameters.f23320rho, mLDSAPublicKeyParameters.f23321t1);
        mo14988reset();
        return zVerifyInternalMuSignature;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        MLDSAEngine mLDSAEngine = this.f23322engine;
        int length = bArr.length;
        SHAKEDigest sHAKEDigest = this.msgDigest;
        MLDSAPublicKeyParameters mLDSAPublicKeyParameters = this.f23324pubKey;
        boolean zVerifyInternal = mLDSAEngine.verifyInternal(bArr, length, sHAKEDigest, mLDSAPublicKeyParameters.f23320rho, mLDSAPublicKeyParameters.f23321t1);
        mo14988reset();
        return zVerifyInternal;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.msgDigest.mo14970update(bArr, i, i2);
    }
}
