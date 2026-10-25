package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public abstract class GeneralDigest implements ExtendedDigest, Memoable {
    private static final int BYTE_LENGTH = 64;
    private long byteCount;

    /* renamed from: purpose */
    protected final CryptoServicePurpose f19390purpose;

    /* renamed from: xBuf */
    private final byte[] f19391xBuf;

    /* renamed from: xBufOff */
    private int f19392xBufOff;

    public GeneralDigest() {
        this(CryptoServicePurpose.ANY);
    }

    /* renamed from: copyIn */
    public void m15075copyIn(GeneralDigest generalDigest) {
        byte[] bArr = generalDigest.f19391xBuf;
        System.arraycopy(bArr, 0, this.f19391xBuf, 0, bArr.length);
        this.f19392xBufOff = generalDigest.f19392xBufOff;
        this.byteCount = generalDigest.byteCount;
    }

    public abstract CryptoServiceProperties cryptoServiceProperties();

    /* renamed from: finish */
    public void m15076finish() {
        long j = this.byteCount << 3;
        byte b = ByteCompanionObject.MIN_VALUE;
        while (true) {
            mo14969update(b);
            if (this.f19392xBufOff == 0) {
                processLength(j);
                processBlock();
                return;
            }
            b = 0;
        }
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    public void populateState(byte[] bArr) {
        System.arraycopy(this.f19391xBuf, 0, bArr, 0, this.f19392xBufOff);
        AbstractC6245Pack.intToBigEndian(this.f19392xBufOff, bArr, 4);
        AbstractC6245Pack.longToBigEndian(this.byteCount, bArr, 8);
    }

    public abstract void processBlock();

    public abstract void processLength(long j);

    public abstract void processWord(byte[] bArr, int i);

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        this.byteCount = 0L;
        this.f19392xBufOff = 0;
        int i = 0;
        while (true) {
            byte[] bArr = this.f19391xBuf;
            if (i >= bArr.length) {
                return;
            }
            bArr[i] = 0;
            i++;
        }
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        byte[] bArr = this.f19391xBuf;
        int i = this.f19392xBufOff;
        int i2 = i + 1;
        this.f19392xBufOff = i2;
        bArr[i] = b;
        if (i2 == bArr.length) {
            processWord(bArr, 0);
            this.f19392xBufOff = 0;
        }
        this.byteCount++;
    }

    public GeneralDigest(CryptoServicePurpose cryptoServicePurpose) {
        this.f19391xBuf = new byte[4];
        this.f19390purpose = cryptoServicePurpose;
        this.f19392xBufOff = 0;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        int i3 = 0;
        int iMax = Math.max(0, i2);
        if (this.f19392xBufOff != 0) {
            int i4 = 0;
            while (true) {
                if (i4 >= iMax) {
                    i3 = i4;
                    break;
                }
                byte[] bArr2 = this.f19391xBuf;
                int i5 = this.f19392xBufOff;
                int i6 = i5 + 1;
                this.f19392xBufOff = i6;
                int i7 = i4 + 1;
                bArr2[i5] = bArr[i4 + i];
                if (i6 == 4) {
                    processWord(bArr2, 0);
                    this.f19392xBufOff = 0;
                    i3 = i7;
                    break;
                }
                i4 = i7;
            }
        }
        int i8 = iMax - 3;
        while (i3 < i8) {
            processWord(bArr, i + i3);
            i3 += 4;
        }
        while (i3 < iMax) {
            byte[] bArr3 = this.f19391xBuf;
            int i9 = this.f19392xBufOff;
            this.f19392xBufOff = i9 + 1;
            bArr3[i9] = bArr[i3 + i];
            i3++;
        }
        this.byteCount += iMax;
    }

    public GeneralDigest(GeneralDigest generalDigest) {
        this.f19391xBuf = new byte[4];
        this.f19390purpose = generalDigest.f19390purpose;
        m15075copyIn(generalDigest);
    }

    public GeneralDigest(byte[] bArr) {
        byte[] bArr2 = new byte[4];
        this.f19391xBuf = bArr2;
        this.f19390purpose = CryptoServicePurpose.m14960values()[bArr[bArr.length - 1]];
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f19392xBufOff = AbstractC6245Pack.bigEndianToInt(bArr, 4);
        this.byteCount = AbstractC6245Pack.bigEndianToLong(bArr, 8);
    }
}
