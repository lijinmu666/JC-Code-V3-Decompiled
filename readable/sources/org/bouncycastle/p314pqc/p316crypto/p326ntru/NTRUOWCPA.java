package org.bouncycastle.p314pqc.p316crypto.p326ntru;

import org.bouncycastle.p314pqc.p356math.p357ntru.HPSPolynomial;
import org.bouncycastle.p314pqc.p356math.p357ntru.Polynomial;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHPSParameterSet;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUHRSSParameterSet;
import org.bouncycastle.p314pqc.p356math.p357ntru.parameters.NTRUParameterSet;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
class NTRUOWCPA {

    /* renamed from: params */
    private final NTRUParameterSet f23381params;
    private final NTRUSampling sampling;

    public NTRUOWCPA(NTRUParameterSet nTRUParameterSet) {
        this.f23381params = nTRUParameterSet;
        this.sampling = new NTRUSampling(nTRUParameterSet);
    }

    private int checkCiphertext(byte[] bArr) {
        return (((~((short) ((255 << (8 - ((this.f23381params.m18200logQ() * this.f23381params.packDegree()) & 7))) & bArr[this.f23381params.ntruCiphertextBytes() - 1]))) + 1) >>> 15) & 1;
    }

    /* renamed from: checkM */
    private int m17757checkM(HPSPolynomial hPSPolynomial) {
        short s = 0;
        short s2 = 0;
        for (int i = 0; i < this.f23381params.m18201n() - 1; i++) {
            short s3 = hPSPolynomial.f24144coeffs[i];
            s = (short) (s + (s3 & 1));
            s2 = (short) (s2 + (s3 & 2));
        }
        return (((~((((NTRUHPSParameterSet) this.f23381params).m18199weight() ^ s2) | ((s2 >>> 1) ^ s))) + 1) >>> 31) & 1;
    }

    /* renamed from: checkR */
    private int m17758checkR(Polynomial polynomial) {
        int iM18202q = 0;
        for (int i = 0; i < this.f23381params.m18201n() - 1; i++) {
            short s = polynomial.f24144coeffs[i];
            iM18202q = iM18202q | ((s + 1) & (this.f23381params.m18202q() - 4)) | ((s + 2) & 4);
        }
        return (((~(polynomial.f24144coeffs[this.f23381params.m18201n() - 1] | iM18202q)) + 1) >>> 31) & 1;
    }

    /* renamed from: decrypt */
    public OWCPADecryptResult m17759decrypt(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[this.f23381params.owcpaMsgBytes()];
        Polynomial polynomialCreatePolynomial = this.f23381params.createPolynomial();
        Polynomial polynomialCreatePolynomial2 = this.f23381params.createPolynomial();
        Polynomial polynomialCreatePolynomial3 = this.f23381params.createPolynomial();
        Polynomial polynomialCreatePolynomial4 = this.f23381params.createPolynomial();
        polynomialCreatePolynomial.rqSumZeroFromBytes(bArr);
        polynomialCreatePolynomial2.s3FromBytes(bArr2);
        polynomialCreatePolynomial2.m18198z3ToZq();
        polynomialCreatePolynomial3.m18192rqMul(polynomialCreatePolynomial, polynomialCreatePolynomial2);
        polynomialCreatePolynomial2.m18193rqToS3(polynomialCreatePolynomial3);
        polynomialCreatePolynomial3.s3FromBytes(C6238Arrays.copyOfRange(bArr2, this.f23381params.packTrinaryBytes(), bArr2.length));
        polynomialCreatePolynomial4.m18196s3Mul(polynomialCreatePolynomial2, polynomialCreatePolynomial3);
        polynomialCreatePolynomial4.s3ToBytes(bArr3, this.f23381params.packTrinaryBytes());
        int iCheckCiphertext = checkCiphertext(bArr);
        if (this.f23381params instanceof NTRUHPSParameterSet) {
            iCheckCiphertext |= m17757checkM((HPSPolynomial) polynomialCreatePolynomial4);
        }
        polynomialCreatePolynomial2.mo18184lift(polynomialCreatePolynomial4);
        for (int i = 0; i < this.f23381params.m18201n(); i++) {
            short[] sArr = polynomialCreatePolynomial.f24144coeffs;
            sArr[i] = (short) (sArr[i] - polynomialCreatePolynomial2.f24144coeffs[i]);
        }
        polynomialCreatePolynomial3.sqFromBytes(C6238Arrays.copyOfRange(bArr2, this.f23381params.packTrinaryBytes() * 2, bArr2.length));
        polynomialCreatePolynomial4.m18197sqMul(polynomialCreatePolynomial, polynomialCreatePolynomial3);
        int iM17758checkR = m17758checkR(polynomialCreatePolynomial4) | iCheckCiphertext;
        polynomialCreatePolynomial4.trinaryZqToZ3();
        polynomialCreatePolynomial4.s3ToBytes(bArr3, 0);
        return new OWCPADecryptResult(bArr3, iM17758checkR);
    }

    /* renamed from: encrypt */
    public byte[] m17760encrypt(Polynomial polynomial, Polynomial polynomial2, byte[] bArr) {
        Polynomial polynomialCreatePolynomial = this.f23381params.createPolynomial();
        Polynomial polynomialCreatePolynomial2 = this.f23381params.createPolynomial();
        polynomialCreatePolynomial.rqSumZeroFromBytes(bArr);
        polynomialCreatePolynomial2.m18192rqMul(polynomial, polynomialCreatePolynomial);
        polynomialCreatePolynomial.mo18184lift(polynomial2);
        for (int i = 0; i < this.f23381params.m18201n(); i++) {
            short[] sArr = polynomialCreatePolynomial2.f24144coeffs;
            sArr[i] = (short) (sArr[i] + polynomialCreatePolynomial.f24144coeffs[i]);
        }
        return polynomialCreatePolynomial2.rqSumZeroToBytes(this.f23381params.ntruCiphertextBytes());
    }

    /* renamed from: keypair */
    public OWCPAKeyPair m17761keypair(byte[] bArr) {
        int iOwcpaSecretKeyBytes = this.f23381params.owcpaSecretKeyBytes();
        byte[] bArr2 = new byte[iOwcpaSecretKeyBytes];
        int iM18201n = this.f23381params.m18201n();
        this.f23381params.m18202q();
        Polynomial polynomialCreatePolynomial = this.f23381params.createPolynomial();
        Polynomial polynomialCreatePolynomial2 = this.f23381params.createPolynomial();
        Polynomial polynomialCreatePolynomial3 = this.f23381params.createPolynomial();
        PolynomialPair polynomialPairSampleFg = this.sampling.sampleFg(bArr);
        Polynomial polynomialM17764f = polynomialPairSampleFg.m17764f();
        Polynomial polynomialM17765g = polynomialPairSampleFg.m17765g();
        polynomialCreatePolynomial.m18194s3Inv(polynomialM17764f);
        polynomialM17764f.s3ToBytes(bArr2, 0);
        polynomialCreatePolynomial.s3ToBytes(bArr2, this.f23381params.packTrinaryBytes());
        polynomialM17764f.m18198z3ToZq();
        polynomialM17765g.m18198z3ToZq();
        if (this.f23381params instanceof NTRUHRSSParameterSet) {
            for (int i = iM18201n - 1; i > 0; i--) {
                short[] sArr = polynomialM17765g.f24144coeffs;
                sArr[i] = (short) ((sArr[i - 1] - sArr[i]) * 3);
            }
            short[] sArr2 = polynomialM17765g.f24144coeffs;
            sArr2[0] = (short) (-(sArr2[0] * 3));
        } else {
            for (int i2 = 0; i2 < iM18201n; i2++) {
                short[] sArr3 = polynomialM17765g.f24144coeffs;
                sArr3[i2] = (short) (sArr3[i2] * 3);
            }
        }
        polynomialCreatePolynomial.m18192rqMul(polynomialM17765g, polynomialM17764f);
        polynomialCreatePolynomial2.m18190rqInv(polynomialCreatePolynomial);
        polynomialCreatePolynomial3.m18192rqMul(polynomialCreatePolynomial2, polynomialM17764f);
        polynomialCreatePolynomial.m18197sqMul(polynomialCreatePolynomial3, polynomialM17764f);
        byte[] bArrSqToBytes = polynomialCreatePolynomial.sqToBytes(iOwcpaSecretKeyBytes - (this.f23381params.packTrinaryBytes() * 2));
        System.arraycopy(bArrSqToBytes, 0, bArr2, this.f23381params.packTrinaryBytes() * 2, bArrSqToBytes.length);
        polynomialCreatePolynomial3.m18192rqMul(polynomialCreatePolynomial2, polynomialM17765g);
        polynomialCreatePolynomial.m18192rqMul(polynomialCreatePolynomial3, polynomialM17765g);
        return new OWCPAKeyPair(polynomialCreatePolynomial.rqSumZeroToBytes(this.f23381params.owcpaPublicKeyBytes()), bArr2);
    }
}
