package org.bouncycastle.p194crypto.p213params;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class MLDSAPublicKeyParameters extends MLDSAKeyParameters {

    /* renamed from: rho */
    final byte[] f20792rho;

    /* renamed from: t1 */
    final byte[] f20793t1;

    public MLDSAPublicKeyParameters(MLDSAParameters mLDSAParameters, byte[] bArr) {
        super(false, mLDSAParameters);
        this.f20792rho = C6238Arrays.copyOfRange(bArr, 0, 32);
        byte[] bArrCopyOfRange = C6238Arrays.copyOfRange(bArr, 32, bArr.length);
        this.f20793t1 = bArrCopyOfRange;
        if (bArrCopyOfRange.length == 0) {
            throw new IllegalArgumentException("encoding too short");
        }
    }

    public byte[] getEncoded() {
        return getEncoded(this.f20792rho, this.f20793t1);
    }

    /* renamed from: getRho */
    public byte[] m15787getRho() {
        return C6238Arrays.m18231clone(this.f20792rho);
    }

    /* renamed from: getT1 */
    public byte[] m15788getT1() {
        return C6238Arrays.m18231clone(this.f20793t1);
    }

    public MLDSAPublicKeyParameters(MLDSAParameters mLDSAParameters, byte[] bArr, byte[] bArr2) {
        super(false, mLDSAParameters);
        if (bArr == null) {
            throw new NullPointerException("rho cannot be null");
        }
        if (bArr2 == null) {
            throw new NullPointerException("t1 cannot be null");
        }
        this.f20792rho = C6238Arrays.m18231clone(bArr);
        this.f20793t1 = C6238Arrays.m18231clone(bArr2);
    }

    public static byte[] getEncoded(byte[] bArr, byte[] bArr2) {
        return C6238Arrays.concatenate(bArr, bArr2);
    }
}
