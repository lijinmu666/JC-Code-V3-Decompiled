package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p194crypto.p207kems.p208mlkem.MLKEMEngine;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLKEMPublicKeyParameters extends MLKEMKeyParameters {

    /* renamed from: rho */
    final byte[] f20805rho;

    /* renamed from: t */
    final byte[] f20806t;

    public MLKEMPublicKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr) {
        super(false, mLKEMParameters);
        MLKEMEngine mLKEMEngine = MLKEMEngine.getInstance(mLKEMParameters);
        if (bArr.length != mLKEMEngine.getIndCpaPublicKeyBytes()) {
            throw new IllegalArgumentException("'encoding' has invalid length");
        }
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 0, bArr.length - 32);
        this.f20806t = bArrCopyOfRange;
        this.f20805rho = C6238Arrays.copyOfRange(bArr, bArr.length - 32, bArr.length);
        if (!mLKEMEngine.checkModulus(bArrCopyOfRange)) {
            throw new IllegalArgumentException("Modulus check failed for ML-KEM public key");
        }
    }

    public byte[] getEncoded() {
        return getEncoded(this.f20806t, this.f20805rho);
    }

    /* renamed from: getRho */
    public byte[] m15796getRho() {
        return C6238Arrays.m18231clone(this.f20805rho);
    }

    /* renamed from: getT */
    public byte[] m15797getT() {
        return C6238Arrays.m18231clone(this.f20806t);
    }

    public MLKEMPublicKeyParameters(MLKEMParameters mLKEMParameters, byte[] bArr, byte[] bArr2) {
        super(false, mLKEMParameters);
        MLKEMEngine mLKEMEngine = MLKEMEngine.getInstance(mLKEMParameters);
        if (bArr.length != mLKEMEngine.getPolyVecBytes()) {
            throw new IllegalArgumentException("'t' has invalid length");
        }
        if (bArr2.length != 32) {
            throw new IllegalArgumentException("'rho' has invalid length");
        }
        byte[] bArrM18231clone = C6238Arrays.m18231clone(bArr);
        this.f20806t = bArrM18231clone;
        this.f20805rho = C6238Arrays.m18231clone(bArr2);
        if (!mLKEMEngine.checkModulus(bArrM18231clone)) {
            throw new IllegalArgumentException("Modulus check failed for ML-KEM public key");
        }
    }

    public static byte[] getEncoded(byte[] bArr, byte[] bArr2) {
        return C6238Arrays.concatenate(bArr, bArr2);
    }
}
