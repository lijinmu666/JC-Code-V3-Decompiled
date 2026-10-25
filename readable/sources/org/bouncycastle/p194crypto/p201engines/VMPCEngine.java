package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class VMPCEngine implements StreamCipher {
    protected byte[] workingIV;
    protected byte[] workingKey;

    /* renamed from: n */
    protected byte f20154n = 0;

    /* renamed from: P */
    protected byte[] f20153P = null;

    /* renamed from: s */
    protected byte f20155s = 0;

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public String getAlgorithmName() {
        return "VMPC";
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: init */
    public void mo14993init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof ParametersWithIV)) {
            throw new IllegalArgumentException("VMPC init parameters must include an IV");
        }
        ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
        if (!(parametersWithIV.getParameters() instanceof KeyParameter)) {
            throw new IllegalArgumentException("VMPC init parameters must include a key");
        }
        KeyParameter keyParameter = (KeyParameter) parametersWithIV.getParameters();
        byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
        this.workingIV = bArrM15801getIV;
        if (bArrM15801getIV == null || bArrM15801getIV.length < 1 || bArrM15801getIV.length > 768) {
            throw new IllegalArgumentException("VMPC requires 1 to 768 bytes of IV");
        }
        byte[] bArrM15773getKey = keyParameter.m15773getKey();
        this.workingKey = bArrM15773getKey;
        mo15450initKey(bArrM15773getKey, this.workingIV);
        String algorithmName = getAlgorithmName();
        byte[] bArr = this.workingKey;
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(algorithmName, bArr.length >= 32 ? 256 : bArr.length * 8, cipherParameters, C5342Utils.getPurpose(z)));
    }

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
        this.f20154n = (byte) 0;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public int processBytes(byte[] bArr, int i, int i2, byte[] bArr2, int i3) {
        if (i + i2 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i3 + i2 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        for (int i4 = 0; i4 < i2; i4++) {
            byte[] bArr3 = this.f20153P;
            byte b = this.f20155s;
            byte b2 = this.f20154n;
            byte b3 = bArr3[(b + bArr3[b2 & C1126UByte.MAX_VALUE]) & 255];
            this.f20155s = b3;
            byte b4 = bArr3[(bArr3[bArr3[b3 & C1126UByte.MAX_VALUE] & C1126UByte.MAX_VALUE] + 1) & 255];
            byte b5 = bArr3[b2 & C1126UByte.MAX_VALUE];
            bArr3[b2 & C1126UByte.MAX_VALUE] = bArr3[b3 & C1126UByte.MAX_VALUE];
            bArr3[b3 & C1126UByte.MAX_VALUE] = b5;
            this.f20154n = (byte) ((b2 + 1) & 255);
            bArr2[i4 + i3] = (byte) (bArr[i4 + i] ^ b4);
        }
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    /* renamed from: reset */
    public void mo14994reset() {
        mo15450initKey(this.workingKey, this.workingIV);
    }

    @Override // org.bouncycastle.p194crypto.StreamCipher
    public byte returnByte(byte b) {
        byte[] bArr = this.f20153P;
        byte b2 = this.f20155s;
        byte b3 = this.f20154n;
        byte b4 = bArr[(b2 + bArr[b3 & C1126UByte.MAX_VALUE]) & 255];
        this.f20155s = b4;
        byte b5 = bArr[(bArr[bArr[b4 & C1126UByte.MAX_VALUE] & C1126UByte.MAX_VALUE] + 1) & 255];
        byte b6 = bArr[b3 & C1126UByte.MAX_VALUE];
        bArr[b3 & C1126UByte.MAX_VALUE] = bArr[b4 & C1126UByte.MAX_VALUE];
        bArr[b4 & C1126UByte.MAX_VALUE] = b6;
        this.f20154n = (byte) ((b3 + 1) & 255);
        return (byte) (b ^ b5);
    }
}
