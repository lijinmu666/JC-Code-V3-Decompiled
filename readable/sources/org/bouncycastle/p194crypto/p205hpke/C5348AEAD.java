package org.bouncycastle.p194crypto.p205hpke;

import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p210modes.AEADCipher;
import org.bouncycastle.p194crypto.p210modes.ChaCha20Poly1305;
import org.bouncycastle.p194crypto.p210modes.GCMBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6240Bytes;

/* renamed from: org.bouncycastle.crypto.hpke.AEAD */
/* loaded from: classes2.dex */
public class C5348AEAD {

    /* renamed from: aeadId */
    private final short f20328aeadId;
    private final byte[] baseNonce;

    /* renamed from: cipher */
    private AEADCipher f20329cipher;

    /* renamed from: key */
    private final byte[] f20330key;

    /* renamed from: seq */
    private long f20331seq = 0;

    public C5348AEAD(short s, byte[] bArr, byte[] bArr2) {
        AEADCipher aEADCipherNewInstance;
        this.f20330key = bArr;
        this.baseNonce = bArr2;
        this.f20328aeadId = s;
        if (s == 1 || s == 2) {
            aEADCipherNewInstance = GCMBlockCipher.newInstance(AESEngine.newInstance());
        } else if (s != 3) {
            return;
        } else {
            aEADCipherNewInstance = new ChaCha20Poly1305();
        }
        this.f20329cipher = aEADCipherNewInstance;
    }

    private byte[] computeNonce() {
        long j = this.f20331seq;
        this.f20331seq = 1 + j;
        byte[] bArrLongToBigEndian = AbstractC6245Pack.longToBigEndian(j);
        byte[] bArrM18231clone = C6238Arrays.m18231clone(this.baseNonce);
        C6240Bytes.m18280xorTo(8, bArrLongToBigEndian, 0, bArrM18231clone, bArrM18231clone.length - 8);
        return bArrM18231clone;
    }

    /* renamed from: process */
    private byte[] m15535process(boolean z, byte[] bArr, byte[] bArr2, int i, int i2) {
        short s = this.f20328aeadId;
        if (s != 1 && s != 2 && s != 3) {
            throw new IllegalStateException("Export only mode, cannot be used to seal/open");
        }
        this.f20329cipher.mo15226init(z, new ParametersWithIV(new KeyParameter(this.f20330key), computeNonce()));
        this.f20329cipher.processAADBytes(bArr, 0, bArr.length);
        int outputSize = this.f20329cipher.getOutputSize(i2);
        byte[] bArr3 = new byte[outputSize];
        int iProcessBytes = this.f20329cipher.processBytes(bArr2, i, i2, bArr3, 0);
        if (iProcessBytes + this.f20329cipher.mo15224doFinal(bArr3, iProcessBytes) == outputSize) {
            return bArr3;
        }
        throw new IllegalStateException();
    }

    /* renamed from: open */
    public byte[] m15536open(byte[] bArr, byte[] bArr2) {
        return m15535process(false, bArr, bArr2, 0, bArr2.length);
    }

    /* renamed from: seal */
    public byte[] m15538seal(byte[] bArr, byte[] bArr2) {
        return m15535process(true, bArr, bArr2, 0, bArr2.length);
    }

    /* renamed from: open */
    public byte[] m15537open(byte[] bArr, byte[] bArr2, int i, int i2) {
        C6238Arrays.validateSegment(bArr2, i, i2);
        return m15535process(false, bArr, bArr2, i, i2);
    }

    /* renamed from: seal */
    public byte[] m15539seal(byte[] bArr, byte[] bArr2, int i, int i2) {
        C6238Arrays.validateSegment(bArr2, i, i2);
        return m15535process(true, bArr, bArr2, i, i2);
    }
}
