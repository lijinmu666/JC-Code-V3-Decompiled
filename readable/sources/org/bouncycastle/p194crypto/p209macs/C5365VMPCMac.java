package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import p094kotlin.C1126UByte;

/* renamed from: org.bouncycastle.crypto.macs.VMPCMac */
/* loaded from: classes2.dex */
public class C5365VMPCMac implements InterfaceC5278Mac {

    /* renamed from: T */
    private byte[] f20502T;

    /* renamed from: g */
    private byte f20503g;
    private byte[] workingIV;
    private byte[] workingKey;

    /* renamed from: x1 */
    private byte f20506x1;

    /* renamed from: x2 */
    private byte f20507x2;

    /* renamed from: x3 */
    private byte f20508x3;

    /* renamed from: x4 */
    private byte f20509x4;

    /* renamed from: n */
    private byte f20504n = 0;

    /* renamed from: P */
    private byte[] f20501P = null;

    /* renamed from: s */
    private byte f20505s = 0;

    /* renamed from: initKey */
    private void m15593initKey(byte[] bArr, byte[] bArr2) {
        this.f20505s = (byte) 0;
        this.f20501P = new byte[256];
        for (int i = 0; i < 256; i++) {
            this.f20501P[i] = (byte) i;
        }
        for (int i2 = 0; i2 < 768; i2++) {
            byte[] bArr3 = this.f20501P;
            byte b = this.f20505s;
            int i3 = i2 & 255;
            byte b2 = bArr3[i3];
            byte b3 = bArr3[(b + b2 + bArr[i2 % bArr.length]) & 255];
            this.f20505s = b3;
            bArr3[i3] = bArr3[b3 & C1126UByte.MAX_VALUE];
            bArr3[b3 & C1126UByte.MAX_VALUE] = b2;
        }
        for (int i4 = 0; i4 < 768; i4++) {
            byte[] bArr4 = this.f20501P;
            byte b4 = this.f20505s;
            int i5 = i4 & 255;
            byte b5 = bArr4[i5];
            byte b6 = bArr4[(b4 + b5 + bArr2[i4 % bArr2.length]) & 255];
            this.f20505s = b6;
            bArr4[i5] = bArr4[b6 & C1126UByte.MAX_VALUE];
            bArr4[b6 & C1126UByte.MAX_VALUE] = b5;
        }
        this.f20504n = (byte) 0;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        for (int i2 = 1; i2 < 25; i2++) {
            byte[] bArr2 = this.f20501P;
            byte b = this.f20505s;
            byte b2 = this.f20504n;
            byte b3 = bArr2[(b + bArr2[b2 & C1126UByte.MAX_VALUE]) & 255];
            this.f20505s = b3;
            byte b4 = this.f20509x4;
            byte b5 = this.f20508x3;
            byte b6 = bArr2[(b4 + b5 + i2) & 255];
            this.f20509x4 = b6;
            byte b7 = this.f20507x2;
            byte b8 = bArr2[(b5 + b7 + i2) & 255];
            this.f20508x3 = b8;
            byte b9 = this.f20506x1;
            byte b10 = bArr2[(b7 + b9 + i2) & 255];
            this.f20507x2 = b10;
            byte b11 = bArr2[(b9 + b3 + i2) & 255];
            this.f20506x1 = b11;
            byte[] bArr3 = this.f20502T;
            byte b12 = this.f20503g;
            bArr3[b12 & 31] = (byte) (b11 ^ bArr3[b12 & 31]);
            bArr3[(b12 + 1) & 31] = (byte) (b10 ^ bArr3[(b12 + 1) & 31]);
            bArr3[(b12 + 2) & 31] = (byte) (b8 ^ bArr3[(b12 + 2) & 31]);
            bArr3[(b12 + 3) & 31] = (byte) (b6 ^ bArr3[(b12 + 3) & 31]);
            this.f20503g = (byte) ((b12 + 4) & 31);
            byte b13 = bArr2[b2 & C1126UByte.MAX_VALUE];
            bArr2[b2 & C1126UByte.MAX_VALUE] = bArr2[b3 & C1126UByte.MAX_VALUE];
            bArr2[b3 & C1126UByte.MAX_VALUE] = b13;
            this.f20504n = (byte) ((b2 + 1) & 255);
        }
        for (int i3 = 0; i3 < 768; i3++) {
            byte[] bArr4 = this.f20501P;
            byte b14 = this.f20505s;
            int i4 = i3 & 255;
            byte b15 = bArr4[i4];
            byte b16 = bArr4[(b14 + b15 + this.f20502T[i3 & 31]) & 255];
            this.f20505s = b16;
            bArr4[i4] = bArr4[b16 & C1126UByte.MAX_VALUE];
            bArr4[b16 & C1126UByte.MAX_VALUE] = b15;
        }
        byte[] bArr5 = new byte[20];
        for (int i5 = 0; i5 < 20; i5++) {
            byte[] bArr6 = this.f20501P;
            int i6 = i5 & 255;
            byte b17 = bArr6[(this.f20505s + bArr6[i6]) & 255];
            this.f20505s = b17;
            bArr5[i5] = bArr6[(bArr6[bArr6[b17 & C1126UByte.MAX_VALUE] & C1126UByte.MAX_VALUE] + 1) & 255];
            byte b18 = bArr6[i6];
            bArr6[i6] = bArr6[b17 & C1126UByte.MAX_VALUE];
            bArr6[b17 & C1126UByte.MAX_VALUE] = b18;
        }
        System.arraycopy(bArr5, 0, bArr, i, 20);
        mo14977reset();
        return 20;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return "VMPC-MAC";
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return 20;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include an IV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
        if (!(parametersWithIV.getParameters() instanceof KeyParameter)) {
            throw new IllegalArgumentException("VMPC-MAC Init parameters must include a key");
        }
        byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
        this.workingIV = bArrM15801getIV;
        if (bArrM15801getIV == null || bArrM15801getIV.length < 1 || bArrM15801getIV.length > 768) {
            throw new IllegalArgumentException("VMPC-MAC requires 1 to 768 bytes of IV");
        }
        this.workingKey = keyParameter.m15773getKey();
        mo14977reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        m15593initKey(this.workingKey, this.workingIV);
        this.f20504n = (byte) 0;
        this.f20509x4 = (byte) 0;
        this.f20508x3 = (byte) 0;
        this.f20507x2 = (byte) 0;
        this.f20506x1 = (byte) 0;
        this.f20503g = (byte) 0;
        this.f20502T = new byte[32];
        for (int i = 0; i < 32; i++) {
            this.f20502T[i] = 0;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        byte[] bArr = this.f20501P;
        byte b2 = this.f20505s;
        byte b3 = this.f20504n;
        byte b4 = bArr[(b2 + bArr[b3 & C1126UByte.MAX_VALUE]) & 255];
        this.f20505s = b4;
        byte b5 = (byte) (b ^ bArr[(bArr[bArr[b4 & C1126UByte.MAX_VALUE] & C1126UByte.MAX_VALUE] + 1) & 255]);
        byte b6 = this.f20509x4;
        byte b7 = this.f20508x3;
        byte b8 = bArr[(b6 + b7) & 255];
        this.f20509x4 = b8;
        byte b9 = this.f20507x2;
        byte b10 = bArr[(b7 + b9) & 255];
        this.f20508x3 = b10;
        byte b11 = this.f20506x1;
        byte b12 = bArr[(b9 + b11) & 255];
        this.f20507x2 = b12;
        byte b13 = bArr[(b11 + b4 + b5) & 255];
        this.f20506x1 = b13;
        byte[] bArr2 = this.f20502T;
        byte b14 = this.f20503g;
        bArr2[b14 & 31] = (byte) (b13 ^ bArr2[b14 & 31]);
        bArr2[(b14 + 1) & 31] = (byte) (b12 ^ bArr2[(b14 + 1) & 31]);
        bArr2[(b14 + 2) & 31] = (byte) (b10 ^ bArr2[(b14 + 2) & 31]);
        bArr2[(b14 + 3) & 31] = (byte) (b8 ^ bArr2[(b14 + 3) & 31]);
        this.f20503g = (byte) ((b14 + 4) & 31);
        byte b15 = bArr[b3 & C1126UByte.MAX_VALUE];
        bArr[b3 & C1126UByte.MAX_VALUE] = bArr[b4 & C1126UByte.MAX_VALUE];
        bArr[b4 & C1126UByte.MAX_VALUE] = b15;
        this.f20504n = (byte) ((b3 + 1) & 255);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        for (int i3 = 0; i3 < i2; i3++) {
            mo14978update(bArr[i + i3]);
        }
    }
}
