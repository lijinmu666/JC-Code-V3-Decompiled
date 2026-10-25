package org.bouncycastle.p194crypto.p217signers;

import java.io.IOException;
import java.security.SecureRandom;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p213params.ParametersWithContext;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;
import org.bouncycastle.p194crypto.p213params.SLHDSAParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPrivateKeyParameters;
import org.bouncycastle.p194crypto.p213params.SLHDSAPublicKeyParameters;
import org.bouncycastle.p194crypto.p217signers.p219slhdsa.SLHDSAEngine;
import org.bouncycastle.p314pqc.p316crypto.DigestUtils;

/* loaded from: classes2.dex */
public class HashSLHDSASigner implements InterfaceC5282Signer {

    /* renamed from: digest */
    private InterfaceC5277Digest f20982digest;
    private byte[] msgPrefix;

    /* renamed from: optRand */
    private byte[] f20983optRand;

    /* renamed from: pkRoot */
    private byte[] f20984pkRoot;

    /* renamed from: pkSeed */
    private byte[] f20985pkSeed;

    /* renamed from: privKey */
    private SLHDSAPrivateKeyParameters f20986privKey;

    /* renamed from: pubKey */
    private SLHDSAPublicKeyParameters f20987pubKey;

    /* renamed from: random */
    private SecureRandom f20988random;

    /* renamed from: skPrf */
    private byte[] f20989skPrf;

    /* renamed from: skSeed */
    private byte[] f20990skSeed;

    private static InterfaceC5277Digest createDigest(SLHDSAParameters sLHDSAParameters) {
        int iM15817getType = sLHDSAParameters.m15817getType();
        if (iM15817getType == 0) {
            return sLHDSAParameters.m15816getName().startsWith("sha2") ? (SLHDSAParameters.sha2_128f == sLHDSAParameters || SLHDSAParameters.sha2_128s == sLHDSAParameters) ? SHA256Digest.newInstance() : new SHA512Digest() : (SLHDSAParameters.shake_128f == sLHDSAParameters || SLHDSAParameters.shake_128s == sLHDSAParameters) ? new SHAKEDigest(128) : new SHAKEDigest(256);
        }
        if (iM15817getType == 1) {
            return SHA256Digest.newInstance();
        }
        if (iM15817getType == 2) {
            return new SHA512Digest();
        }
        if (iM15817getType == 3) {
            return new SHAKEDigest(128);
        }
        if (iM15817getType == 4) {
            return new SHAKEDigest(256);
        }
        throw new IllegalArgumentException("unknown parameters type");
    }

    private void initDigest(SLHDSAParameters sLHDSAParameters, ParametersWithContext parametersWithContext) {
        InterfaceC5277Digest interfaceC5277DigestCreateDigest = createDigest(sLHDSAParameters);
        this.f20982digest = interfaceC5277DigestCreateDigest;
        try {
            byte[] encoded = DigestUtils.getDigestOid(interfaceC5277DigestCreateDigest.getAlgorithmName()).getEncoded(ASN1Encoding.f17902DER);
            int contextLength = parametersWithContext == null ? 0 : parametersWithContext.getContextLength();
            int i = contextLength + 2;
            byte[] bArr = new byte[encoded.length + i];
            this.msgPrefix = bArr;
            bArr[0] = 1;
            bArr[1] = (byte) contextLength;
            if (parametersWithContext != null) {
                parametersWithContext.copyContextTo(bArr, 2, contextLength);
            }
            System.arraycopy(encoded, 0, this.msgPrefix, i, encoded.length);
        } catch (IOException e) {
            throw new IllegalStateException("oid encoding failed: " + e.getMessage());
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public byte[] generateSignature() {
        byte[] bArr = new byte[this.f20982digest.getDigestSize()];
        this.f20982digest.mo14967doFinal(bArr, 0);
        SecureRandom secureRandom = this.f20988random;
        if (secureRandom != null) {
            secureRandom.nextBytes(this.f20983optRand);
        } else {
            byte[] publicSeed = this.f20986privKey.getPublicSeed();
            byte[] bArr2 = this.f20983optRand;
            System.arraycopy(publicSeed, 0, bArr2, 0, bArr2.length);
        }
        return SLHDSAEngine.internalGenerateSignature(this.f20986privKey.getParameters(), this.f20990skSeed, this.f20989skPrf, this.f20985pkSeed, this.f20984pkRoot, this.msgPrefix, bArr, this.f20983optRand);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: init */
    public void mo14987init(boolean z, CipherParameters cipherParameters) {
        ParametersWithContext parametersWithContext;
        SLHDSAParameters parameters;
        if (cipherParameters instanceof ParametersWithContext) {
            ParametersWithContext parametersWithContext2 = (ParametersWithContext) cipherParameters;
            CipherParameters parameters2 = parametersWithContext2.getParameters();
            if (parametersWithContext2.getContextLength() > 255) {
                throw new IllegalArgumentException("context too long");
            }
            parametersWithContext = parametersWithContext2;
            cipherParameters = parameters2;
        } else {
            parametersWithContext = null;
        }
        if (z) {
            this.f20987pubKey = null;
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f20986privKey = (SLHDSAPrivateKeyParameters) parametersWithRandom.getParameters();
                this.f20988random = parametersWithRandom.getRandom();
            } else {
                this.f20986privKey = (SLHDSAPrivateKeyParameters) cipherParameters;
                this.f20988random = null;
            }
            parameters = this.f20986privKey.getParameters();
            this.f20990skSeed = this.f20986privKey.m15822getSeed();
            this.f20989skPrf = this.f20986privKey.m15820getPrf();
            this.f20985pkSeed = this.f20986privKey.getPublicSeed();
            this.f20984pkRoot = this.f20986privKey.m15821getRoot();
            this.f20983optRand = new byte[parameters.m15815getN()];
        } else {
            SLHDSAPublicKeyParameters sLHDSAPublicKeyParameters = (SLHDSAPublicKeyParameters) cipherParameters;
            this.f20987pubKey = sLHDSAPublicKeyParameters;
            this.f20986privKey = null;
            this.f20988random = null;
            this.f20990skSeed = null;
            this.f20989skPrf = null;
            this.f20985pkSeed = sLHDSAPublicKeyParameters.m15824getSeed();
            this.f20984pkRoot = this.f20987pubKey.m15823getRoot();
            parameters = this.f20987pubKey.getParameters();
        }
        initDigest(parameters, parametersWithContext);
    }

    public byte[] internalGenerateSignature(byte[] bArr, byte[] bArr2) {
        return SLHDSAEngine.internalGenerateSignature(this.f20986privKey.getParameters(), this.f20990skSeed, this.f20989skPrf, this.f20985pkSeed, this.f20984pkRoot, null, bArr, bArr2);
    }

    public boolean internalVerifySignature(byte[] bArr, byte[] bArr2) {
        return SLHDSAEngine.internalVerifySignature(this.f20987pubKey.getParameters(), this.f20985pkSeed, this.f20984pkRoot, null, bArr, bArr2);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f20982digest.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.f20982digest.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArr2 = new byte[this.f20982digest.getDigestSize()];
        this.f20982digest.mo14967doFinal(bArr2, 0);
        return SLHDSAEngine.internalVerifySignature(this.f20987pubKey.getParameters(), this.f20985pkSeed, this.f20984pkRoot, this.msgPrefix, bArr2, bArr);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.f20982digest.mo14970update(bArr, i, i2);
    }
}
