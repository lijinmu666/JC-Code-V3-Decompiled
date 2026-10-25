package org.bouncycastle.p314pqc.p316crypto.p326ntru;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.EncapsulatedSecretGenerator;
import org.bouncycastle.p194crypto.SecretWithEncapsulation;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p314pqc.p316crypto.p331util.SecretWithEncapsulationImpl;
import org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRUKEMGenerator implements EncapsulatedSecretGenerator {

    /* renamed from: random */
    private final SecureRandom f23377random;

    public NTRUKEMGenerator(SecureRandom secureRandom) {
        this.f23377random = CryptoServicesRegistrar.getSecureRandom(secureRandom);
    }

    @Override // org.bouncycastle.p194crypto.EncapsulatedSecretGenerator
    public SecretWithEncapsulation generateEncapsulated(AsymmetricKeyParameter asymmetricKeyParameter) {
        if (asymmetricKeyParameter == null) {
            throw new NullPointerException("'recipientKey' cannot be null");
        }
        NTRUPublicKeyParameters nTRUPublicKeyParameters = (NTRUPublicKeyParameters) asymmetricKeyParameter;
        NTRUParameterSet parameterSet = nTRUPublicKeyParameters.getParameters().getParameterSet();
        NTRUSampling nTRUSampling = new NTRUSampling(parameterSet);
        NTRUOWCPA ntruowcpa = new NTRUOWCPA(parameterSet);
        int iOwcpaMsgBytes = parameterSet.owcpaMsgBytes();
        byte[] bArr = new byte[iOwcpaMsgBytes];
        byte[] bArr2 = new byte[parameterSet.sampleRmBytes()];
        this.f23377random.nextBytes(bArr2);
        PolynomialPair polynomialPairSampleRm = nTRUSampling.sampleRm(bArr2);
        Polynomial polynomialM17767r = polynomialPairSampleRm.m17767r();
        Polynomial polynomialM17766m = polynomialPairSampleRm.m17766m();
        polynomialM17767r.s3ToBytes(bArr, 0);
        polynomialM17766m.s3ToBytes(bArr, parameterSet.packTrinaryBytes());
        SHA3Digest sHA3Digest = new SHA3Digest(256);
        byte[] bArr3 = new byte[sHA3Digest.getDigestSize()];
        sHA3Digest.mo14970update(bArr, 0, iOwcpaMsgBytes);
        sHA3Digest.mo14967doFinal(bArr3, 0);
        polynomialM17767r.m18198z3ToZq();
        byte[] bArrM17760encrypt = ntruowcpa.m17760encrypt(polynomialM17767r, polynomialM17766m, nTRUPublicKeyParameters.publicKey);
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr3, 0, parameterSet.sharedKeyBytes());
        C6238Arrays.m18227clear(bArr3);
        return new SecretWithEncapsulationImpl(bArrCopyOfRange, bArrM17760encrypt);
    }
}
