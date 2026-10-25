package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.SavableDigest;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class SHAKEDigest extends KeccakDigest implements InterfaceC5284Xof, SavableDigest {
    public SHAKEDigest() {
        this(128);
    }

    private static int checkBitLength(int i) {
        if (i == 128 || i == 256) {
            return i;
        }
        throw new IllegalArgumentException("'bitStrength' " + i + " not supported for SHAKE");
    }

    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new SHAKEDigest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.KeccakDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, this.f19408purpose);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.KeccakDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        return mo14998doFinal(bArr, i, getDigestSize());
    }

    public int doOutput(byte[] bArr, int i, int i2) {
        if (!this.squeezing) {
            absorbBits(15, 4);
        }
        m15091squeeze(bArr, i, i2 * 8);
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.KeccakDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "SHAKE" + this.fixedOutputLength;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.KeccakDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.fixedOutputLength / 4;
    }

    public byte[] getEncodedState() {
        byte[] bArr = new byte[(this.f19410state.length * 8) + this.dataQueue.length + 14];
        super.getEncodedState(bArr);
        return bArr;
    }

    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15089copyIn((SHAKEDigest) memoable);
    }

    public SHAKEDigest(int i) {
        super(checkBitLength(i), CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.KeccakDigest
    /* renamed from: doFinal */
    public int mo15090doFinal(byte[] bArr, int i, byte b, int i2) {
        return m15172doFinal(bArr, i, getDigestSize(), b, i2);
    }

    public SHAKEDigest(int i, CryptoServicePurpose cryptoServicePurpose) {
        super(checkBitLength(i), cryptoServicePurpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
    /* renamed from: doFinal */
    public int mo14998doFinal(byte[] bArr, int i, int i2) {
        int iDoOutput = doOutput(bArr, i, i2);
        mo14968reset();
        return iDoOutput;
    }

    public SHAKEDigest(CryptoServicePurpose cryptoServicePurpose) {
        this(128, cryptoServicePurpose);
    }

    /* renamed from: doFinal */
    public int m15172doFinal(byte[] bArr, int i, int i2, byte b, int i3) {
        if (i3 < 0 || i3 > 7) {
            throw new IllegalArgumentException("'partialBits' must be in the range [0,7]");
        }
        int i4 = (b & ((1 << i3) - 1)) | (15 << i3);
        int i5 = i3 + 4;
        if (i5 >= 8) {
            m15087absorb((byte) i4);
            i5 = i3 - 4;
            i4 >>>= 8;
        }
        if (i5 > 0) {
            absorbBits(i4, i5);
        }
        m15091squeeze(bArr, i, i2 * 8);
        mo14968reset();
        return i2;
    }

    public SHAKEDigest(SHAKEDigest sHAKEDigest) {
        super(sHAKEDigest);
    }

    public SHAKEDigest(byte[] bArr) {
        super(bArr);
    }
}
