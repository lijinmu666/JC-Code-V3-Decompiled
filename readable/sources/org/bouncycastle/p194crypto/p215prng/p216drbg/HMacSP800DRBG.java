package org.bouncycastle.p194crypto.p215prng.p216drbg;

import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p215prng.EntropySource;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class HMacSP800DRBG implements SP80090DRBG {
    private static final int MAX_BITS_REQUEST = 262144;
    private static final long RESEED_MAX = 140737488355328L;

    /* renamed from: _K */
    private byte[] f20923_K;

    /* renamed from: _V */
    private byte[] f20924_V;
    private EntropySource _entropySource;

    /* renamed from: _hMac */
    private InterfaceC5278Mac f20925_hMac;
    private long _reseedCounter;
    private int _securityStrength;

    public HMacSP800DRBG(InterfaceC5278Mac interfaceC5278Mac, int i, EntropySource entropySource, byte[] bArr, byte[] bArr2) {
        if (i > C5379Utils.getMaxSecurityStrength(interfaceC5278Mac)) {
            throw new IllegalArgumentException("Requested security strength is not supported by the derivation function");
        }
        if (entropySource.entropySize() < i) {
            throw new IllegalArgumentException("Not enough entropy for security strength required");
        }
        this._securityStrength = i;
        this._entropySource = entropySource;
        this.f20925_hMac = interfaceC5278Mac;
        byte[] bArrConcatenate = C6238Arrays.concatenate(getEntropy(), bArr2, bArr);
        byte[] bArr3 = new byte[interfaceC5278Mac.getMacSize()];
        this.f20923_K = bArr3;
        byte[] bArr4 = new byte[bArr3.length];
        this.f20924_V = bArr4;
        C6238Arrays.m18249fill(bArr4, (byte) 1);
        hmac_DRBG_Update(bArrConcatenate);
        this._reseedCounter = 1L;
    }

    private byte[] getEntropy() {
        byte[] entropy = this._entropySource.getEntropy();
        if (entropy.length >= (this._securityStrength + 7) / 8) {
            return entropy;
        }
        throw new IllegalStateException("Insufficient entropy provided by entropy source");
    }

    private void hmac_DRBG_Update(byte[] bArr) {
        hmac_DRBG_Update_Func(bArr, (byte) 0);
        if (bArr != null) {
            hmac_DRBG_Update_Func(bArr, (byte) 1);
        }
    }

    private void hmac_DRBG_Update_Func(byte[] bArr, byte b) {
        this.f20925_hMac.mo14976init(new KeyParameter(this.f20923_K));
        InterfaceC5278Mac interfaceC5278Mac = this.f20925_hMac;
        byte[] bArr2 = this.f20924_V;
        interfaceC5278Mac.mo14979update(bArr2, 0, bArr2.length);
        this.f20925_hMac.mo14978update(b);
        if (bArr != null) {
            this.f20925_hMac.mo14979update(bArr, 0, bArr.length);
        }
        this.f20925_hMac.mo14975doFinal(this.f20923_K, 0);
        this.f20925_hMac.mo14976init(new KeyParameter(this.f20923_K));
        InterfaceC5278Mac interfaceC5278Mac2 = this.f20925_hMac;
        byte[] bArr3 = this.f20924_V;
        interfaceC5278Mac2.mo14979update(bArr3, 0, bArr3.length);
        this.f20925_hMac.mo14975doFinal(this.f20924_V, 0);
    }

    @Override // org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG
    public int generate(byte[] bArr, byte[] bArr2, boolean z) {
        int length = bArr.length * 8;
        if (length > 262144) {
            throw new IllegalArgumentException("Number of bits per request limited to 262144");
        }
        if (this._reseedCounter > RESEED_MAX) {
            return -1;
        }
        if (z) {
            mo15845reseed(bArr2);
            bArr2 = null;
        }
        if (bArr2 != null) {
            hmac_DRBG_Update(bArr2);
        }
        int length2 = bArr.length;
        byte[] bArr3 = new byte[length2];
        int length3 = bArr.length / this.f20924_V.length;
        this.f20925_hMac.mo14976init(new KeyParameter(this.f20923_K));
        for (int i = 0; i < length3; i++) {
            InterfaceC5278Mac interfaceC5278Mac = this.f20925_hMac;
            byte[] bArr4 = this.f20924_V;
            interfaceC5278Mac.mo14979update(bArr4, 0, bArr4.length);
            this.f20925_hMac.mo14975doFinal(this.f20924_V, 0);
            byte[] bArr5 = this.f20924_V;
            System.arraycopy(bArr5, 0, bArr3, bArr5.length * i, bArr5.length);
        }
        byte[] bArr6 = this.f20924_V;
        if (bArr6.length * length3 < length2) {
            this.f20925_hMac.mo14979update(bArr6, 0, bArr6.length);
            this.f20925_hMac.mo14975doFinal(this.f20924_V, 0);
            byte[] bArr7 = this.f20924_V;
            System.arraycopy(bArr7, 0, bArr3, bArr7.length * length3, length2 - (length3 * bArr7.length));
        }
        hmac_DRBG_Update(bArr2);
        this._reseedCounter++;
        System.arraycopy(bArr3, 0, bArr, 0, bArr.length);
        return length;
    }

    @Override // org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG
    public int getBlockSize() {
        return this.f20924_V.length * 8;
    }

    @Override // org.bouncycastle.p194crypto.p215prng.p216drbg.SP80090DRBG
    /* renamed from: reseed */
    public void mo15845reseed(byte[] bArr) {
        hmac_DRBG_Update(C6238Arrays.concatenate(getEntropy(), bArr));
        this._reseedCounter = 1L;
    }
}
