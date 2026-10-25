package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class SNTRUPrimePrivateKeyParameters extends SNTRUPrimeKeyParameters {

    /* renamed from: f */
    private final byte[] f23437f;

    /* renamed from: ginv */
    private final byte[] f23438ginv;

    /* renamed from: hash */
    private final byte[] f23439hash;

    /* renamed from: pk */
    private final byte[] f23440pk;

    /* renamed from: rho */
    private final byte[] f23441rho;

    public SNTRUPrimePrivateKeyParameters(SNTRUPrimeParameters sNTRUPrimeParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, byte[] bArr5) {
        super(true, sNTRUPrimeParameters);
        this.f23437f = C6238Arrays.m18231clone(bArr);
        this.f23438ginv = C6238Arrays.m18231clone(bArr2);
        this.f23440pk = C6238Arrays.m18231clone(bArr3);
        this.f23441rho = C6238Arrays.m18231clone(bArr4);
        this.f23439hash = C6238Arrays.m18231clone(bArr5);
    }

    public byte[] getEncoded() {
        byte[] bArr = new byte[getParameters().getPrivateKeyBytes()];
        byte[] bArr2 = this.f23437f;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        byte[] bArr3 = this.f23438ginv;
        System.arraycopy(bArr3, 0, bArr, this.f23437f.length, bArr3.length);
        byte[] bArr4 = this.f23440pk;
        System.arraycopy(bArr4, 0, bArr, this.f23437f.length + this.f23438ginv.length, bArr4.length);
        byte[] bArr5 = this.f23441rho;
        System.arraycopy(bArr5, 0, bArr, this.f23437f.length + this.f23438ginv.length + this.f23440pk.length, bArr5.length);
        byte[] bArr6 = this.f23439hash;
        System.arraycopy(bArr6, 0, bArr, this.f23437f.length + this.f23438ginv.length + this.f23440pk.length + this.f23441rho.length, bArr6.length);
        return bArr;
    }

    /* renamed from: getF */
    public byte[] m17793getF() {
        return C6238Arrays.m18231clone(this.f23437f);
    }

    /* renamed from: getGinv */
    public byte[] m17794getGinv() {
        return C6238Arrays.m18231clone(this.f23438ginv);
    }

    /* renamed from: getHash */
    public byte[] m17795getHash() {
        return C6238Arrays.m18231clone(this.f23439hash);
    }

    /* renamed from: getPk */
    public byte[] m17796getPk() {
        return C6238Arrays.m18231clone(this.f23440pk);
    }

    /* renamed from: getRho */
    public byte[] m17797getRho() {
        return C6238Arrays.m18231clone(this.f23441rho);
    }
}
