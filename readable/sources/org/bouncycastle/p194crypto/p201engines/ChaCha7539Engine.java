package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class ChaCha7539Engine extends Salsa20Engine {
    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine
    public void advanceCounter() {
        int[] iArr = this.engineState;
        int i = iArr[12] + 1;
        iArr[12] = i;
        if (i == 0) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine
    public void generateKeyStream(byte[] bArr) {
        ChaChaEngine.chachaCore(this.f20083rounds, this.engineState, this.f20084x);
        AbstractC6245Pack.intToLittleEndian(this.f20084x, bArr, 0);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine, org.bouncycastle.p194crypto.StreamCipher
    public String getAlgorithmName() {
        return "ChaCha7539";
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine
    public long getCounter() {
        return this.engineState[12] & BodyPartID.bodyIdMax;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine
    public int getNonceSize() {
        return 12;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine
    public void resetCounter() {
        this.engineState[12] = 0;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine
    public void retreatCounter() {
        int[] iArr = this.engineState;
        int i = iArr[12];
        if (i == 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        iArr[12] = i - 1;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine
    /* renamed from: setKey */
    public void mo15283setKey(byte[] bArr, byte[] bArr2) {
        if (bArr != null) {
            if (bArr.length != 32) {
                throw new IllegalArgumentException(getAlgorithmName() + " requires 256 bit key");
            }
            packTauOrSigma(bArr.length, this.engineState, 0);
            AbstractC6245Pack.littleEndianToInt(bArr, 0, this.engineState, 4, 8);
        }
        AbstractC6245Pack.littleEndianToInt(bArr2, 0, this.engineState, 13, 3);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine
    public void advanceCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i > 0) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
        int[] iArr = this.engineState;
        int i3 = iArr[12];
        int i4 = i2 + i3;
        iArr[12] = i4;
        if (i3 != 0 && i4 < i3) {
            throw new IllegalStateException("attempt to increase counter past 2^32.");
        }
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Salsa20Engine
    public void retreatCounter(long j) {
        int i = (int) (j >>> 32);
        int i2 = (int) j;
        if (i != 0) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        int[] iArr = this.engineState;
        int i3 = iArr[12];
        if ((i3 & BodyPartID.bodyIdMax) < (BodyPartID.bodyIdMax & i2)) {
            throw new IllegalStateException("attempt to reduce counter past zero.");
        }
        iArr[12] = i3 - i2;
    }
}
