package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.ParametersWithContext;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p314pqc.p316crypto.DigestUtils;

@Deprecated
/* loaded from: classes2.dex */
public class HashMLDSASigner implements InterfaceC5282Signer {
    private static final byte[] EMPTY_CONTEXT = new byte[0];

    /* renamed from: digest */
    private InterfaceC5277Digest f23299digest;
    private byte[] digestOIDEncoding;

    /* renamed from: engine */
    private MLDSAEngine f23300engine;

    /* renamed from: privKey */
    private MLDSAPrivateKeyParameters f23301privKey;

    /* renamed from: pubKey */
    private MLDSAPublicKeyParameters f23302pubKey;

    /* renamed from: random */
    private SecureRandom f23303random;

    private static InterfaceC5277Digest createDigest(MLDSAParameters mLDSAParameters) {
        int iM17676getType = mLDSAParameters.m17676getType();
        if (iM17676getType == 0 || iM17676getType == 1) {
            return new SHA512Digest();
        }
        throw new IllegalArgumentException("unknown parameters type");
    }

    private SHAKEDigest finishPreHash() {
        int digestSize = this.f23299digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        this.f23299digest.mo14967doFinal(bArr, 0);
        SHAKEDigest shake256Digest = this.f23300engine.getShake256Digest();
        byte[] bArr2 = this.digestOIDEncoding;
        shake256Digest.mo14970update(bArr2, 0, bArr2.length);
        shake256Digest.mo14970update(bArr, 0, digestSize);
        return shake256Digest;
    }

    private void initDigest(MLDSAParameters mLDSAParameters) {
        InterfaceC5277Digest interfaceC5277DigestCreateDigest = createDigest(mLDSAParameters);
        this.f23299digest = interfaceC5277DigestCreateDigest;
        try {
            this.digestOIDEncoding = DigestUtils.getDigestOid(interfaceC5277DigestCreateDigest.getAlgorithmName()).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException e) {
            throw new IllegalStateException("oid encoding failed: " + e.getMessage());
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        SHAKEDigest sHAKEDigestFinishPreHash = finishPreHash();
        byte[] bArr = new byte[32];
        SecureRandom secureRandom = this.f23303random;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr);
        }
        byte[] bArrGenerateMu = this.f23300engine.generateMu(sHAKEDigestFinishPreHash);
        MLDSAEngine mLDSAEngine = this.f23300engine;
        MLDSAPrivateKeyParameters mLDSAPrivateKeyParameters = this.f23301privKey;
        return mLDSAEngine.generateSignature(bArrGenerateMu, sHAKEDigestFinishPreHash, mLDSAPrivateKeyParameters.f23313rho, mLDSAPrivateKeyParameters.f23312k, mLDSAPrivateKeyParameters.f23317t0, mLDSAPrivateKeyParameters.f23314s1, mLDSAPrivateKeyParameters.f23315s2, bArr);
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
            this.f23302pubKey = null;
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f23301privKey = (MLDSAPrivateKeyParameters) parametersWithRandom.getParameters();
                this.f23303random = parametersWithRandom.getRandom();
            } else {
                this.f23301privKey = (MLDSAPrivateKeyParameters) cipherParameters;
                this.f23303random = null;
            }
            parameters = this.f23301privKey.getParameters();
            MLDSAEngine engine = parameters.getEngine(this.f23303random);
            this.f23300engine = engine;
            engine.initSign(this.f23301privKey.f23319tr, true, context);
        } else {
            MLDSAPublicKeyParameters mLDSAPublicKeyParameters = (MLDSAPublicKeyParameters) cipherParameters;
            this.f23302pubKey = mLDSAPublicKeyParameters;
            this.f23301privKey = null;
            this.f23303random = null;
            parameters = mLDSAPublicKeyParameters.getParameters();
            MLDSAEngine engine2 = parameters.getEngine(null);
            this.f23300engine = engine2;
            MLDSAPublicKeyParameters mLDSAPublicKeyParameters2 = this.f23302pubKey;
            engine2.initVerify(mLDSAPublicKeyParameters2.f23320rho, mLDSAPublicKeyParameters2.f23321t1, true, context);
        }
        initDigest(parameters);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f23299digest.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.f23299digest.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        SHAKEDigest sHAKEDigestFinishPreHash = finishPreHash();
        MLDSAEngine mLDSAEngine = this.f23300engine;
        int length = bArr.length;
        MLDSAPublicKeyParameters mLDSAPublicKeyParameters = this.f23302pubKey;
        return mLDSAEngine.verifyInternal(bArr, length, sHAKEDigestFinishPreHash, mLDSAPublicKeyParameters.f23320rho, mLDSAPublicKeyParameters.f23321t1);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.f23299digest.mo14970update(bArr, i, i2);
    }
}
