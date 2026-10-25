package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DilithiumPublicKeyParameters extends DilithiumKeyParameters {

    /* renamed from: rho */
    final byte[] f23093rho;

    /* renamed from: t1 */
    final byte[] f23094t1;

    public DilithiumPublicKeyParameters(DilithiumParameters dilithiumParameters, byte[] bArr) {
        super(false, dilithiumParameters);
        this.f23093rho = C6238Arrays.copyOfRange(bArr, 0, 32);
        this.f23094t1 = C6238Arrays.copyOfRange(bArr, 32, bArr.length);
    }

    public byte[] getEncoded() {
        return getEncoded(this.f23093rho, this.f23094t1);
    }

    /* renamed from: getRho */
    public byte[] m17523getRho() {
        return C6238Arrays.m18231clone(this.f23093rho);
    }

    /* renamed from: getT1 */
    public byte[] m17524getT1() {
        return C6238Arrays.m18231clone(this.f23094t1);
    }

    public DilithiumPublicKeyParameters(DilithiumParameters dilithiumParameters, byte[] bArr, byte[] bArr2) {
        super(false, dilithiumParameters);
        this.f23093rho = C6238Arrays.m18231clone(bArr);
        this.f23094t1 = C6238Arrays.m18231clone(bArr2);
    }

    public static byte[] getEncoded(byte[] bArr, byte[] bArr2) {
        return C6238Arrays.concatenate(bArr, bArr2);
    }
}
