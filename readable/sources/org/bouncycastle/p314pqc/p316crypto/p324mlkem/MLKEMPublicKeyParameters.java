package org.bouncycastle.p314pqc.p316crypto.p324mlkem;

import org.bouncycastle.p361util.C6238Arrays;

@Deprecated
/* loaded from: classes2.dex */
public class MLKEMPublicKeyParameters extends MLKEMKeyParameters {

    /* renamed from: rho */
    final byte[] f23353rho;

    /* renamed from: t */
    final byte[] f23354t;

    public MLKEMPublicKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr) {
        super(false, mLKEMParameters);
        MLKEMEngine engine = mLKEMParameters.getEngine();
        if (bArr.length != engine.getIndCpaPublicKeyBytes()) {
            throw new IllegalArgumentException("'encoding' has invalid length");
        }
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 0, bArr.length - 32);
        this.f23354t = bArrCopyOfRange;
        this.f23353rho = C6238Arrays.copyOfRange(bArr, bArr.length - 32, bArr.length);
        if (!engine.checkModulus(bArrCopyOfRange)) {
            throw new IllegalArgumentException("Modulus check failed for ML-KEM public key");
        }
    }

    public byte[] getEncoded() {
        return getEncoded(this.f23354t, this.f23353rho);
    }

    /* renamed from: getRho */
    public byte[] m17717getRho() {
        return C6238Arrays.m18231clone(this.f23353rho);
    }

    /* renamed from: getT */
    public byte[] m17718getT() {
        return C6238Arrays.m18231clone(this.f23354t);
    }

    public MLKEMPublicKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr, byte[] bArr2) {
        super(false, mLKEMParameters);
        MLKEMEngine engine = mLKEMParameters.getEngine();
        if (bArr.length != engine.getPolyVecBytes()) {
            throw new IllegalArgumentException("'t' has invalid length");
        }
        if (bArr2.length != 32) {
            throw new IllegalArgumentException("'rho' has invalid length");
        }
        byte[] bArrM18231clone = C6238Arrays.m18231clone(bArr);
        this.f23354t = bArrM18231clone;
        this.f23353rho = C6238Arrays.m18231clone(bArr2);
        if (!engine.checkModulus(bArrM18231clone)) {
            throw new IllegalArgumentException("Modulus check failed for ML-KEM public key");
        }
    }

    public static byte[] getEncoded(byte[] bArr, byte[] bArr2) {
        return C6238Arrays.concatenate(bArr, bArr2);
    }
}
