package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;

/* renamed from: org.bouncycastle.crypto.macs.OldHMac */
/* loaded from: classes2.dex */
public class C5363OldHMac implements InterfaceC5278Mac {
    private static final int BLOCK_LENGTH = 64;

    /* renamed from: IPAD */
    private static final byte f20468IPAD = 54;

    /* renamed from: OPAD */
    private static final byte f20469OPAD = 92;

    /* renamed from: digest */
    private InterfaceC5277Digest f20470digest;
    private int digestSize;
    private byte[] inputPad = new byte[64];
    private byte[] outputPad = new byte[64];

    public C5363OldHMac(InterfaceC5277Digest interfaceC5277Digest) {
        this.f20470digest = interfaceC5277Digest;
        this.digestSize = interfaceC5277Digest.getDigestSize();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        int i2 = this.digestSize;
        byte[] bArr2 = new byte[i2];
        this.f20470digest.mo14967doFinal(bArr2, 0);
        InterfaceC5277Digest interfaceC5277Digest = this.f20470digest;
        byte[] bArr3 = this.outputPad;
        interfaceC5277Digest.mo14970update(bArr3, 0, bArr3.length);
        this.f20470digest.mo14970update(bArr2, 0, i2);
        int iMo14967doFinal = this.f20470digest.mo14967doFinal(bArr, i);
        mo14977reset();
        return iMo14967doFinal;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return this.f20470digest.getAlgorithmName() + "/HMAC";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return this.digestSize;
    }

    public InterfaceC5277Digest getUnderlyingDigest() {
        return this.f20470digest;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        this.f20470digest.mo14968reset();
        byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
        if (bArrM15773getKey.length <= 64) {
            System.arraycopy(bArrM15773getKey, 0, this.inputPad, 0, bArrM15773getKey.length);
            int length = bArrM15773getKey.length;
            while (true) {
                byte[] bArr = this.inputPad;
                if (length >= bArr.length) {
                    break;
                }
                bArr[length] = 0;
                length++;
            }
        } else {
            this.f20470digest.mo14970update(bArrM15773getKey, 0, bArrM15773getKey.length);
            this.f20470digest.mo14967doFinal(this.inputPad, 0);
            int i = this.digestSize;
            while (true) {
                byte[] bArr2 = this.inputPad;
                if (i >= bArr2.length) {
                    break;
                }
                bArr2[i] = 0;
                i++;
            }
        }
        byte[] bArr3 = this.inputPad;
        byte[] bArr4 = new byte[bArr3.length];
        this.outputPad = bArr4;
        System.arraycopy(bArr3, 0, bArr4, 0, bArr3.length);
        int i2 = 0;
        while (true) {
            byte[] bArr5 = this.inputPad;
            if (i2 >= bArr5.length) {
                break;
            }
            bArr5[i2] = (byte) (bArr5[i2] ^ f20468IPAD);
            i2++;
        }
        int i3 = 0;
        while (true) {
            byte[] bArr6 = this.outputPad;
            if (i3 >= bArr6.length) {
                InterfaceC5277Digest interfaceC5277Digest = this.f20470digest;
                byte[] bArr7 = this.inputPad;
                interfaceC5277Digest.mo14970update(bArr7, 0, bArr7.length);
                return;
            }
            bArr6[i3] = (byte) (bArr6[i3] ^ f20469OPAD);
            i3++;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        this.f20470digest.mo14968reset();
        InterfaceC5277Digest interfaceC5277Digest = this.f20470digest;
        byte[] bArr = this.inputPad;
        interfaceC5277Digest.mo14970update(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        this.f20470digest.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        this.f20470digest.mo14970update(bArr, i, i2);
    }
}
