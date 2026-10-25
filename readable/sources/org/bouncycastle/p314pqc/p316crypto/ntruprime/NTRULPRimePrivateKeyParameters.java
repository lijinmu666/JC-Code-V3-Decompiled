package org.bouncycastle.p314pqc.p316crypto.ntruprime;

import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class NTRULPRimePrivateKeyParameters extends NTRULPRimeKeyParameters {

    /* renamed from: enca */
    private final byte[] f23425enca;

    /* renamed from: hash */
    private final byte[] f23426hash;

    /* renamed from: pk */
    private final byte[] f23427pk;

    /* renamed from: rho */
    private final byte[] f23428rho;

    public NTRULPRimePrivateKeyParameters(NTRULPRimeParameters nTRULPRimeParameters, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        super(true, nTRULPRimeParameters);
        this.f23425enca = C6238Arrays.m18231clone(bArr);
        this.f23427pk = C6238Arrays.m18231clone(bArr2);
        this.f23428rho = C6238Arrays.m18231clone(bArr3);
        this.f23426hash = C6238Arrays.m18231clone(bArr4);
    }

    /* renamed from: getEnca */
    public byte[] m17784getEnca() {
        return C6238Arrays.m18231clone(this.f23425enca);
    }

    public byte[] getEncoded() {
        byte[] bArr = new byte[getParameters().getPrivateKeyBytes()];
        byte[] bArr2 = this.f23425enca;
        System.arraycopy(bArr2, 0, bArr, 0, bArr2.length);
        byte[] bArr3 = this.f23427pk;
        System.arraycopy(bArr3, 0, bArr, this.f23425enca.length, bArr3.length);
        byte[] bArr4 = this.f23428rho;
        System.arraycopy(bArr4, 0, bArr, this.f23425enca.length + this.f23427pk.length, bArr4.length);
        byte[] bArr5 = this.f23426hash;
        System.arraycopy(bArr5, 0, bArr, this.f23425enca.length + this.f23427pk.length + this.f23428rho.length, bArr5.length);
        return bArr;
    }

    /* renamed from: getHash */
    public byte[] m17785getHash() {
        return C6238Arrays.m18231clone(this.f23426hash);
    }

    /* renamed from: getPk */
    public byte[] m17786getPk() {
        return C6238Arrays.m18231clone(this.f23427pk);
    }

    /* renamed from: getRho */
    public byte[] m17787getRho() {
        return C6238Arrays.m18231clone(this.f23428rho);
    }
}
