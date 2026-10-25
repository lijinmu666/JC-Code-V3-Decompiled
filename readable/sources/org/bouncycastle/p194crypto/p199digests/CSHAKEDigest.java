package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class CSHAKEDigest extends SHAKEDigest {

    /* renamed from: padding */
    private static final byte[] f19340padding = new byte[100];

    /* renamed from: diff */
    private byte[] f19341diff;

    public CSHAKEDigest(int i, CryptoServicePurpose cryptoServicePurpose, byte[] bArr, byte[] bArr2) {
        super(i, cryptoServicePurpose);
        if ((bArr == null || bArr.length == 0) && (bArr2 == null || bArr2.length == 0)) {
            this.f19341diff = null;
        } else {
            this.f19341diff = C6238Arrays.concatenate(XofUtils.leftEncode(this.f19409rate / 8), encodeString(bArr), encodeString(bArr2));
            diffPadAndAbsorb();
        }
    }

    /* renamed from: copyIn */
    private void m15060copyIn(CSHAKEDigest cSHAKEDigest) {
        super.m15089copyIn((KeccakDigest) cSHAKEDigest);
        this.f19341diff = C6238Arrays.m18231clone(cSHAKEDigest.f19341diff);
    }

    private void diffPadAndAbsorb() {
        int i = this.f19409rate / 8;
        byte[] bArr = this.f19341diff;
        m15088absorb(bArr, 0, bArr.length);
        int length = this.f19341diff.length % i;
        if (length == 0) {
            return;
        }
        while (true) {
            i -= length;
            byte[] bArr2 = f19340padding;
            if (i <= bArr2.length) {
                m15088absorb(bArr2, 0, i);
                return;
            } else {
                m15088absorb(bArr2, 0, bArr2.length);
                length = bArr2.length;
            }
        }
    }

    private byte[] encodeString(byte[] bArr) {
        return (bArr == null || bArr.length == 0) ? XofUtils.leftEncode(0L) : C6238Arrays.concatenate(XofUtils.leftEncode(bArr.length * 8), bArr);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.SHAKEDigest, org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new CSHAKEDigest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.SHAKEDigest, org.bouncycastle.p194crypto.InterfaceC5284Xof
    public int doOutput(byte[] bArr, int i, int i2) {
        if (this.f19341diff == null) {
            return super.doOutput(bArr, i, i2);
        }
        if (!this.squeezing) {
            absorbBits(0, 2);
        }
        m15091squeeze(bArr, i, i2 * 8);
        return i2;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.SHAKEDigest, org.bouncycastle.p194crypto.p199digests.KeccakDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "CSHAKE" + this.fixedOutputLength;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.SHAKEDigest, org.bouncycastle.p194crypto.p199digests.EncodableDigest, org.bouncycastle.p194crypto.EncodableService
    public byte[] getEncodedState() {
        int length = (this.f19410state.length * 8) + this.dataQueue.length + 14;
        byte[] bArr = this.f19341diff;
        if (bArr == null) {
            byte[] bArr2 = new byte[length];
            super.getEncodedState(bArr2);
            return bArr2;
        }
        byte[] bArr3 = new byte[bArr.length + length];
        super.getEncodedState(bArr3);
        byte[] bArr4 = this.f19341diff;
        System.arraycopy(bArr4, 0, bArr3, length, bArr4.length);
        return bArr3;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.KeccakDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        if (this.f19341diff != null) {
            diffPadAndAbsorb();
        }
    }

    public CSHAKEDigest(int i, byte[] bArr, byte[] bArr2) {
        this(i, CryptoServicePurpose.ANY, bArr, bArr2);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.SHAKEDigest, org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        m15060copyIn((CSHAKEDigest) memoable);
    }

    public CSHAKEDigest(CSHAKEDigest cSHAKEDigest) {
        super(cSHAKEDigest);
        this.f19341diff = C6238Arrays.m18231clone(cSHAKEDigest.f19341diff);
    }

    public CSHAKEDigest(byte[] bArr) {
        super(bArr);
        int length = (this.f19410state.length * 8) + this.dataQueue.length + 14;
        if (bArr.length == length) {
            this.f19341diff = null;
            return;
        }
        byte[] bArr2 = new byte[bArr.length - length];
        this.f19341diff = bArr2;
        System.arraycopy(bArr, length, bArr2, 0, bArr2.length);
    }
}
