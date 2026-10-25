package org.bouncycastle.p194crypto.p217signers;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.MLDSAParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.MLDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p213params.ParametersWithContext;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p217signers.p218mldsa.MLDSAEngine;
import org.bouncycastle.p314pqc.p316crypto.DigestUtils;

/* loaded from: classes2.dex */
public class HashMLDSASigner implements InterfaceC5282Signer {
    private static final byte[] EMPTY_CONTEXT = new byte[0];

    /* renamed from: digest */
    private InterfaceC5277Digest f20971digest;
    private byte[] digestOIDEncoding;

    /* renamed from: engine */
    private MLDSAEngine f20972engine;

    /* renamed from: k */
    private byte[] f20973k;

    /* renamed from: privKey */
    private MLDSAPrivateKeyParameters f20974privKey;

    /* renamed from: pubKey */
    private MLDSAPublicKeyParameters f20975pubKey;

    /* renamed from: random */
    private SecureRandom f20976random;

    /* renamed from: rho */
    private byte[] f20977rho;

    /* renamed from: s1 */
    private byte[] f20978s1;

    /* renamed from: s2 */
    private byte[] f20979s2;

    /* renamed from: t0 */
    private byte[] f20980t0;

    /* renamed from: t1 */
    private byte[] f20981t1;

    private static InterfaceC5277Digest createDigest(MLDSAParameters mLDSAParameters) {
        int iM15778getType = mLDSAParameters.m15778getType();
        if (iM15778getType == 0 || iM15778getType == 1) {
            return new SHA512Digest();
        }
        throw new IllegalArgumentException("unknown parameters type");
    }

    private SHAKEDigest finishPreHash() {
        int digestSize = this.f20971digest.getDigestSize();
        byte[] bArr = new byte[digestSize];
        this.f20971digest.mo14967doFinal(bArr, 0);
        SHAKEDigest shake256Digest = this.f20972engine.getShake256Digest();
        byte[] bArr2 = this.digestOIDEncoding;
        shake256Digest.mo14970update(bArr2, 0, bArr2.length);
        shake256Digest.mo14970update(bArr, 0, digestSize);
        return shake256Digest;
    }

    private void initDigest(MLDSAParameters mLDSAParameters) {
        InterfaceC5277Digest interfaceC5277DigestCreateDigest = createDigest(mLDSAParameters);
        this.f20971digest = interfaceC5277DigestCreateDigest;
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
        SecureRandom secureRandom = this.f20976random;
        if (secureRandom != null) {
            secureRandom.nextBytes(bArr);
        }
        return this.f20972engine.generateSignature(this.f20972engine.generateMu(sHAKEDigestFinishPreHash), sHAKEDigestFinishPreHash, this.f20977rho, this.f20973k, this.f20980t0, this.f20978s1, this.f20979s2, bArr);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        MLDSAParameters parameters;
        byte[] context = EMPTY_CONTEXT;
        this.f20979s2 = null;
        this.f20978s1 = null;
        this.f20981t1 = null;
        this.f20980t0 = null;
        this.f20973k = null;
        this.f20977rho = null;
        if (cipherParameters instanceof ParametersWithContext) {
            ParametersWithContext parametersWithContext = (ParametersWithContext) cipherParameters;
            context = parametersWithContext.getContext();
            cipherParameters = parametersWithContext.getParameters();
            if (context.length > 255) {
                throw new IllegalArgumentException("context too long");
            }
        }
        if (z) {
            this.f20975pubKey = null;
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f20974privKey = (MLDSAPrivateKeyParameters) parametersWithRandom.getParameters();
                this.f20976random = parametersWithRandom.getRandom();
            } else {
                this.f20974privKey = (MLDSAPrivateKeyParameters) cipherParameters;
                this.f20976random = null;
            }
            parameters = this.f20974privKey.getParameters();
            this.f20972engine = MLDSAEngine.getInstance(parameters, this.f20976random);
            this.f20977rho = this.f20974privKey.m15780getRho();
            this.f20980t0 = this.f20974privKey.m15784getT0();
            this.f20973k = this.f20974privKey.m15779getK();
            this.f20978s1 = this.f20974privKey.m15781getS1();
            this.f20979s2 = this.f20974privKey.m15782getS2();
            this.f20972engine.initSign(this.f20974privKey.m15786getTr(), true, context);
        } else {
            MLDSAPublicKeyParameters mLDSAPublicKeyParameters = (MLDSAPublicKeyParameters) cipherParameters;
            this.f20975pubKey = mLDSAPublicKeyParameters;
            this.f20974privKey = null;
            this.f20976random = null;
            parameters = mLDSAPublicKeyParameters.getParameters();
            this.f20972engine = MLDSAEngine.getInstance(parameters, null);
            this.f20977rho = this.f20975pubKey.m15787getRho();
            byte[] bArrM15788getT1 = this.f20975pubKey.m15788getT1();
            this.f20981t1 = bArrM15788getT1;
            this.f20972engine.initVerify(this.f20977rho, bArrM15788getT1, true, context);
        }
        initDigest(parameters);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f20971digest.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.f20971digest.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        return this.f20972engine.verifyInternal(bArr, bArr.length, finishPreHash(), this.f20977rho, this.f20981t1);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.f20971digest.mo14970update(bArr, i, i2);
    }
}
