package org.bouncycastle.p194crypto.p199digests;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.CryptoServiceProperties;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.Memoable;
import org.bouncycastle.p361util.MemoableResetException;

/* loaded from: classes2.dex */
public class SHA512tDigest extends LongDigest {

    /* renamed from: H1t */
    private long f19553H1t;

    /* renamed from: H2t */
    private long f19554H2t;

    /* renamed from: H3t */
    private long f19555H3t;

    /* renamed from: H4t */
    private long f19556H4t;

    /* renamed from: H5t */
    private long f19557H5t;

    /* renamed from: H6t */
    private long f19558H6t;

    /* renamed from: H7t */
    private long f19559H7t;

    /* renamed from: H8t */
    private long f19560H8t;
    private int digestLength;

    public SHA512tDigest(int i) {
        this(i, CryptoServicePurpose.ANY);
    }

    private static void intToBigEndian(int i, byte[] bArr, int i2, int i3) {
        int iMin = Math.min(4, i3);
        while (true) {
            iMin--;
            if (iMin < 0) {
                return;
            } else {
                bArr[i2 + iMin] = (byte) (i >>> ((3 - iMin) * 8));
            }
        }
    }

    private static void longToBigEndian(long j, byte[] bArr, int i, int i2) {
        if (i2 > 0) {
            intToBigEndian((int) (j >>> 32), bArr, i, i2);
            if (i2 > 4) {
                intToBigEndian((int) (j & BodyPartID.bodyIdMax), bArr, i + 4, i2 - 4);
            }
        }
    }

    private static int readDigestLength(byte[] bArr) {
        return AbstractC6245Pack.bigEndianToInt(bArr, bArr.length - 5);
    }

    private void tIvGenerate(int i) {
        this.f19412H1 = -3482333909917012819L;
        this.f19413H2 = 2216346199247487646L;
        this.f19414H3 = -7364697282686394994L;
        this.f19415H4 = 65953792586715988L;
        this.f19416H5 = -816286391624063116L;
        this.f19417H6 = 4512832404995164602L;
        this.f19418H7 = -5033199132376557362L;
        this.f19419H8 = -124578254951840548L;
        mo14969update((byte) 83);
        mo14969update((byte) 72);
        mo14969update((byte) 65);
        mo14969update((byte) 45);
        mo14969update((byte) 53);
        mo14969update((byte) 49);
        mo14969update((byte) 50);
        mo14969update((byte) 47);
        if (i <= 100) {
            if (i > 10) {
            }
            mo14969update((byte) (i + 48));
            m15099finish();
            this.f19553H1t = this.f19412H1;
            this.f19554H2t = this.f19413H2;
            this.f19555H3t = this.f19414H3;
            this.f19556H4t = this.f19415H4;
            this.f19557H5t = this.f19416H5;
            this.f19558H6t = this.f19417H6;
            this.f19559H7t = this.f19418H7;
            this.f19560H8t = this.f19419H8;
        }
        mo14969update((byte) ((i / 100) + 48));
        i %= 100;
        mo14969update((byte) ((i / 10) + 48));
        i %= 10;
        mo14969update((byte) (i + 48));
        m15099finish();
        this.f19553H1t = this.f19412H1;
        this.f19554H2t = this.f19413H2;
        this.f19555H3t = this.f19414H3;
        this.f19556H4t = this.f19415H4;
        this.f19557H5t = this.f19416H5;
        this.f19558H6t = this.f19417H6;
        this.f19559H7t = this.f19418H7;
        this.f19560H8t = this.f19419H8;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new SHA512tDigest(this);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.LongDigest
    public CryptoServiceProperties cryptoServiceProperties() {
        return C5298Utils.getDefaultProperties(this, getDigestSize() * 8, this.f19421purpose);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        m15099finish();
        longToBigEndian(this.f19412H1, bArr, i, this.digestLength);
        longToBigEndian(this.f19413H2, bArr, i + 8, this.digestLength - 8);
        longToBigEndian(this.f19414H3, bArr, i + 16, this.digestLength - 16);
        longToBigEndian(this.f19415H4, bArr, i + 24, this.digestLength - 24);
        longToBigEndian(this.f19416H5, bArr, i + 32, this.digestLength - 32);
        longToBigEndian(this.f19417H6, bArr, i + 40, this.digestLength - 40);
        longToBigEndian(this.f19418H7, bArr, i + 48, this.digestLength - 48);
        longToBigEndian(this.f19419H8, bArr, i + 56, this.digestLength - 56);
        mo14968reset();
        return this.digestLength;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "SHA-512/" + Integer.toString(this.digestLength * 8);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.digestLength;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.EncodableDigest, org.bouncycastle.p194crypto.EncodableService
    public byte[] getEncodedState() {
        int encodedStateSize = getEncodedStateSize();
        byte[] bArr = new byte[encodedStateSize + 5];
        populateState(bArr);
        AbstractC6245Pack.intToBigEndian(this.digestLength * 8, bArr, encodedStateSize);
        bArr[encodedStateSize + 4] = (byte) this.f19421purpose.ordinal();
        return bArr;
    }

    @Override // org.bouncycastle.p194crypto.p199digests.LongDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        this.f19412H1 = this.f19553H1t;
        this.f19413H2 = this.f19554H2t;
        this.f19414H3 = this.f19555H3t;
        this.f19415H4 = this.f19556H4t;
        this.f19416H5 = this.f19557H5t;
        this.f19417H6 = this.f19558H6t;
        this.f19418H7 = this.f19559H7t;
        this.f19419H8 = this.f19560H8t;
    }

    public SHA512tDigest(int i, CryptoServicePurpose cryptoServicePurpose) {
        if (i >= 512) {
            throw new IllegalArgumentException("bitLength cannot be >= 512");
        }
        if (i % 8 != 0) {
            throw new IllegalArgumentException("bitLength needs to be a multiple of 8");
        }
        if (i == 384) {
            throw new IllegalArgumentException("bitLength cannot be 384 use SHA384 instead");
        }
        this.digestLength = i / 8;
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        tIvGenerate(this.digestLength * 8);
        mo14968reset();
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        SHA512tDigest sHA512tDigest = (SHA512tDigest) memoable;
        if (this.digestLength != sHA512tDigest.digestLength) {
            throw new MemoableResetException("digestLength inappropriate in other");
        }
        super.m15098copyIn(sHA512tDigest);
        this.f19553H1t = sHA512tDigest.f19553H1t;
        this.f19554H2t = sHA512tDigest.f19554H2t;
        this.f19555H3t = sHA512tDigest.f19555H3t;
        this.f19556H4t = sHA512tDigest.f19556H4t;
        this.f19557H5t = sHA512tDigest.f19557H5t;
        this.f19558H6t = sHA512tDigest.f19558H6t;
        this.f19559H7t = sHA512tDigest.f19559H7t;
        this.f19560H8t = sHA512tDigest.f19560H8t;
    }

    public SHA512tDigest(SHA512tDigest sHA512tDigest) {
        super(sHA512tDigest);
        this.digestLength = sHA512tDigest.digestLength;
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        mo14824reset(sHA512tDigest);
    }

    public SHA512tDigest(byte[] bArr) {
        this(readDigestLength(bArr), CryptoServicePurpose.m14960values()[bArr[bArr.length - 1]]);
        CryptoServicesRegistrar.checkConstraints(cryptoServiceProperties());
        restoreState(bArr);
    }
}
