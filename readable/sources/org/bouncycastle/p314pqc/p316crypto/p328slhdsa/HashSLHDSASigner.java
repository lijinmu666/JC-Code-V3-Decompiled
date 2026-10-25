package org.bouncycastle.p314pqc.p316crypto.p328slhdsa;

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
import org.bouncycastle.p314pqc.p316crypto.DigestUtils;

@Deprecated
/* loaded from: classes2.dex */
public class HashSLHDSASigner implements InterfaceC5282Signer {

    /* renamed from: digest */
    private InterfaceC5277Digest f23478digest;
    private byte[] msgPrefix;

    /* renamed from: optRand */
    private byte[] f23479optRand;

    /* renamed from: privKey */
    private SLHDSAPrivateKeyParameters f23480privKey;

    /* renamed from: pubKey */
    private SLHDSAPublicKeyParameters f23481pubKey;

    /* renamed from: random */
    private SecureRandom f23482random;

    private static InterfaceC5277Digest createDigest(SLHDSAParameters sLHDSAParameters) {
        int iM17838getType = sLHDSAParameters.m17838getType();
        if (iM17838getType == 0) {
            return sLHDSAParameters.m17837getName().startsWith("sha2") ? (SLHDSAParameters.sha2_128f == sLHDSAParameters || SLHDSAParameters.sha2_128s == sLHDSAParameters) ? SHA256Digest.newInstance() : new SHA512Digest() : (SLHDSAParameters.shake_128f == sLHDSAParameters || SLHDSAParameters.shake_128s == sLHDSAParameters) ? new SHAKEDigest(128) : new SHAKEDigest(256);
        }
        if (iM17838getType == 1) {
            return SHA256Digest.newInstance();
        }
        if (iM17838getType == 2) {
            return new SHA512Digest();
        }
        if (iM17838getType == 3) {
            return new SHAKEDigest(128);
        }
        if (iM17838getType == 4) {
            return new SHAKEDigest(256);
        }
        throw new IllegalArgumentException("unknown parameters type");
    }

    private void initDigest(SLHDSAParameters sLHDSAParameters, ParametersWithContext parametersWithContext) {
        InterfaceC5277Digest interfaceC5277DigestCreateDigest = createDigest(sLHDSAParameters);
        this.f23478digest = interfaceC5277DigestCreateDigest;
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
        byte[] bArr = new byte[this.f23478digest.getDigestSize()];
        this.f23478digest.mo14967doFinal(bArr, 0);
        SecureRandom secureRandom = this.f23482random;
        if (secureRandom != null) {
            secureRandom.nextBytes(this.f23479optRand);
        } else {
            byte[] bArr2 = this.f23480privKey.f23519pk.f23485seed;
            byte[] bArr3 = this.f23479optRand;
            System.arraycopy(bArr2, 0, bArr3, 0, bArr3.length);
        }
        return SLHDSAEngine.internalGenerateSignature(this.f23480privKey, this.msgPrefix, bArr, this.f23479optRand);
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
            this.f23481pubKey = null;
            if (cipherParameters instanceof ParametersWithRandom) {
                ParametersWithRandom parametersWithRandom = (ParametersWithRandom) cipherParameters;
                this.f23480privKey = (SLHDSAPrivateKeyParameters) parametersWithRandom.getParameters();
                this.f23482random = parametersWithRandom.getRandom();
            } else {
                this.f23480privKey = (SLHDSAPrivateKeyParameters) cipherParameters;
                this.f23482random = null;
            }
            parameters = this.f23480privKey.getParameters();
            this.f23479optRand = new byte[parameters.m17836getN()];
        } else {
            SLHDSAPublicKeyParameters sLHDSAPublicKeyParameters = (SLHDSAPublicKeyParameters) cipherParameters;
            this.f23481pubKey = sLHDSAPublicKeyParameters;
            this.f23480privKey = null;
            this.f23482random = null;
            parameters = sLHDSAPublicKeyParameters.getParameters();
        }
        initDigest(parameters, parametersWithContext);
    }

    public byte[] internalGenerateSignature(byte[] bArr, byte[] bArr2) {
        return SLHDSAEngine.internalGenerateSignature(this.f23480privKey, null, bArr, bArr2);
    }

    public boolean internalVerifySignature(byte[] bArr, byte[] bArr2) {
        return SLHDSAEngine.internalVerifySignature(this.f23481pubKey, null, bArr, bArr2);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: reset */
    public void mo14988reset() {
        this.f23478digest.mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14989update(byte b) {
        this.f23478digest.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    public boolean verifySignature(byte[] bArr) {
        byte[] bArr2 = new byte[this.f23478digest.getDigestSize()];
        this.f23478digest.mo14967doFinal(bArr2, 0);
        return SLHDSAEngine.internalVerifySignature(this.f23481pubKey, this.msgPrefix, bArr2, bArr);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5282Signer
    /* renamed from: update */
    public void mo14990update(byte[] bArr, int i, int i2) {
        this.f23478digest.mo14970update(bArr, i, i2);
    }
}
