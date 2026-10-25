package org.bouncycastle.p194crypto.p201engines;

import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class VMPCKSA3Engine extends VMPCEngine {
    @Override // org.bouncycastle.p194crypto.p201engines.VMPCEngine, org.bouncycastle.p194crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC-KSA3";
    }

    @Override // org.bouncycastle.p194crypto.p201engines.VMPCEngine
    /* renamed from: initKey */
    public void mo15450initKey(byte[] bArr, byte[] bArr2) {
        this.f20155s = (byte) 0;
        this.f20153P = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f20153P[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            byte[] bArr3 = this.f20153P;
            byte b = this.f20155s;
            int i3 = i2 & 255;
            byte b2 = bArr3[i3];
            byte b3 = bArr3[(b + b2 + bArr[i2 % bArr.length]) & 255];
            this.f20155s = b3;
            bArr3[i3] = bArr3[b3 & C1126UByte.MAX_VALUE];
            bArr3[b3 & C1126UByte.MAX_VALUE] = b2;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.f20153P;
            byte b4 = this.f20155s;
            int i5 = i4 & 255;
            byte b5 = bArr4[i5];
            byte b6 = bArr4[(b4 + b5 + bArr2[i4 % bArr2.length]) & 255];
            this.f20155s = b6;
            bArr4[i5] = bArr4[b6 & C1126UByte.MAX_VALUE];
            bArr4[b6 & C1126UByte.MAX_VALUE] = b5;
        }
        for (int i6 = 0; i6 < 768; i6++) {
            byte[] bArr5 = this.f20153P;
            byte b7 = this.f20155s;
            int i7 = i6 & 255;
            byte b8 = bArr5[i7];
            byte b9 = bArr5[(b7 + b8 + bArr[i6 % bArr.length]) & 255];
            this.f20155s = b9;
            bArr5[i7] = bArr5[b9 & C1126UByte.MAX_VALUE];
            bArr5[b9 & C1126UByte.MAX_VALUE] = b8;
        }
        this.f20154n = (byte) 0;
    }
}
