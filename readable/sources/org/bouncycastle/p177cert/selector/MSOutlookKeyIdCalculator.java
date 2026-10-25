package org.bouncycastle.p177cert.selector;

import java.io.IOException;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p361util.AbstractC6245Pack;
import p094kotlin.C1126UByte;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
class MSOutlookKeyIdCalculator {

    public static abstract class GeneralDigest {
        private static final int BYTE_LENGTH = 64;
        private long byteCount;

        /* renamed from: xBuf */
        private byte[] f18907xBuf;

        /* renamed from: xBufOff */
        private int f18908xBufOff;

        public GeneralDigest() {
            this.f18907xBuf = new byte[4];
            this.f18908xBufOff = 0;
        }

        /* renamed from: copyIn */
        public void m14831copyIn(GeneralDigest generalDigest) {
            byte[] bArr = generalDigest.f18907xBuf;
            System.arraycopy(bArr, 0, this.f18907xBuf, 0, bArr.length);
            this.f18908xBufOff = generalDigest.f18908xBufOff;
            this.byteCount = generalDigest.byteCount;
        }

        /* renamed from: finish */
        public void m14832finish() {
            long j = this.byteCount << 3;
            byte b = ByteCompanionObject.MIN_VALUE;
            while (true) {
                m14834update(b);
                if (this.f18908xBufOff == 0) {
                    processLength(j);
                    processBlock();
                    return;
                }
                b = 0;
            }
        }

        public abstract void processBlock();

        public abstract void processLength(long j);

        public abstract void processWord(byte[] bArr, int i);

        /* renamed from: reset */
        public void mo14833reset() {
            this.byteCount = 0L;
            this.f18908xBufOff = 0;
            int i = 0;
            while (true) {
                byte[] bArr = this.f18907xBuf;
                if (i >= bArr.length) {
                    return;
                }
                bArr[i] = 0;
                i++;
            }
        }

        /* renamed from: update */
        public void m14834update(byte b) {
            byte[] bArr = this.f18907xBuf;
            int i = this.f18908xBufOff;
            int i2 = i + 1;
            this.f18908xBufOff = i2;
            bArr[i] = b;
            if (i2 == bArr.length) {
                processWord(bArr, 0);
                this.f18908xBufOff = 0;
            }
            this.byteCount++;
        }

        public GeneralDigest(GeneralDigest generalDigest) {
            this.f18907xBuf = new byte[generalDigest.f18907xBuf.length];
            m14831copyIn(generalDigest);
        }

        /* renamed from: update */
        public void m14835update(byte[] bArr, int i, int i2) {
            while (this.f18908xBufOff != 0 && i2 > 0) {
                m14834update(bArr[i]);
                i++;
                i2--;
            }
            while (i2 > this.f18907xBuf.length) {
                processWord(bArr, i);
                byte[] bArr2 = this.f18907xBuf;
                i += bArr2.length;
                i2 -= bArr2.length;
                this.byteCount += bArr2.length;
            }
            while (i2 > 0) {
                m14834update(bArr[i]);
                i++;
                i2--;
            }
        }
    }

    public static class SHA1Digest extends GeneralDigest {
        private static final int DIGEST_LENGTH = 20;

        /* renamed from: Y1 */
        private static final int f18909Y1 = 1518500249;

        /* renamed from: Y2 */
        private static final int f18910Y2 = 1859775393;

        /* renamed from: Y3 */
        private static final int f18911Y3 = -1894007588;

        /* renamed from: Y4 */
        private static final int f18912Y4 = -899497514;

        /* renamed from: H1 */
        private int f18913H1;

        /* renamed from: H2 */
        private int f18914H2;

        /* renamed from: H3 */
        private int f18915H3;

        /* renamed from: H4 */
        private int f18916H4;

        /* renamed from: H5 */
        private int f18917H5;

        /* renamed from: X */
        private int[] f18918X = new int[80];

        /* renamed from: xOff */
        private int f18919xOff;

        public SHA1Digest() {
            mo14833reset();
        }

        /* renamed from: f */
        private int m14836f(int i, int i2, int i3) {
            return (i & i2) | ((~i) & i3);
        }

        /* renamed from: g */
        private int m14837g(int i, int i2, int i3) {
            return ((i2 | i3) & i) | (i2 & i3);
        }

        /* renamed from: h */
        private int m14838h(int i, int i2, int i3) {
            return (i ^ i2) ^ i3;
        }

        /* renamed from: doFinal */
        public int m14839doFinal(byte[] bArr, int i) {
            m14832finish();
            AbstractC6245Pack.intToBigEndian(this.f18913H1, bArr, i);
            AbstractC6245Pack.intToBigEndian(this.f18914H2, bArr, i + 4);
            AbstractC6245Pack.intToBigEndian(this.f18915H3, bArr, i + 8);
            AbstractC6245Pack.intToBigEndian(this.f18916H4, bArr, i + 12);
            AbstractC6245Pack.intToBigEndian(this.f18917H5, bArr, i + 16);
            mo14833reset();
            return 20;
        }

        public String getAlgorithmName() {
            return "SHA-1";
        }

        public int getDigestSize() {
            return 20;
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        public void processBlock() {
            for (int i = 16; i < 80; i++) {
                int[] iArr = this.f18918X;
                int i2 = ((iArr[i - 3] ^ iArr[i - 8]) ^ iArr[i - 14]) ^ iArr[i - 16];
                iArr[i] = (i2 >>> 31) | (i2 << 1);
            }
            int iM14838h = this.f18913H1;
            int iM14838h2 = this.f18914H2;
            int i3 = this.f18915H3;
            int i4 = this.f18916H4;
            int i5 = this.f18917H5;
            int i6 = 0;
            for (int i7 = 0; i7 < 4; i7++) {
                int iM14836f = i5 + ((iM14838h << 5) | (iM14838h >>> 27)) + m14836f(iM14838h2, i3, i4) + this.f18918X[i6] + f18909Y1;
                int i8 = (iM14838h2 >>> 2) | (iM14838h2 << 30);
                int iM14836f2 = i4 + ((iM14836f << 5) | (iM14836f >>> 27)) + m14836f(iM14838h, i8, i3) + this.f18918X[i6 + 1] + f18909Y1;
                int i9 = (iM14838h >>> 2) | (iM14838h << 30);
                int iM14836f3 = i3 + ((iM14836f2 << 5) | (iM14836f2 >>> 27)) + m14836f(iM14836f, i9, i8) + this.f18918X[i6 + 2] + f18909Y1;
                i5 = (iM14836f >>> 2) | (iM14836f << 30);
                int i10 = i6 + 4;
                iM14838h2 = i8 + ((iM14836f3 << 5) | (iM14836f3 >>> 27)) + m14836f(iM14836f2, i5, i9) + this.f18918X[i6 + 3] + f18909Y1;
                i4 = (iM14836f2 >>> 2) | (iM14836f2 << 30);
                i6 += 5;
                iM14838h = i9 + ((iM14838h2 << 5) | (iM14838h2 >>> 27)) + m14836f(iM14836f3, i4, i5) + this.f18918X[i10] + f18909Y1;
                i3 = (iM14836f3 >>> 2) | (iM14836f3 << 30);
            }
            for (int i11 = 0; i11 < 4; i11++) {
                int iM14838h3 = i5 + ((iM14838h << 5) | (iM14838h >>> 27)) + m14838h(iM14838h2, i3, i4) + this.f18918X[i6] + f18910Y2;
                int i12 = (iM14838h2 >>> 2) | (iM14838h2 << 30);
                int iM14838h4 = i4 + ((iM14838h3 << 5) | (iM14838h3 >>> 27)) + m14838h(iM14838h, i12, i3) + this.f18918X[i6 + 1] + f18910Y2;
                int i13 = (iM14838h >>> 2) | (iM14838h << 30);
                int iM14838h5 = i3 + ((iM14838h4 << 5) | (iM14838h4 >>> 27)) + m14838h(iM14838h3, i13, i12) + this.f18918X[i6 + 2] + f18910Y2;
                i5 = (iM14838h3 >>> 2) | (iM14838h3 << 30);
                int i14 = i6 + 4;
                iM14838h2 = i12 + ((iM14838h5 << 5) | (iM14838h5 >>> 27)) + m14838h(iM14838h4, i5, i13) + this.f18918X[i6 + 3] + f18910Y2;
                i4 = (iM14838h4 >>> 2) | (iM14838h4 << 30);
                i6 += 5;
                iM14838h = i13 + ((iM14838h2 << 5) | (iM14838h2 >>> 27)) + m14838h(iM14838h5, i4, i5) + this.f18918X[i14] + f18910Y2;
                i3 = (iM14838h5 >>> 2) | (iM14838h5 << 30);
            }
            for (int i15 = 0; i15 < 4; i15++) {
                int iM14837g = i5 + ((iM14838h << 5) | (iM14838h >>> 27)) + m14837g(iM14838h2, i3, i4) + this.f18918X[i6] + f18911Y3;
                int i16 = (iM14838h2 >>> 2) | (iM14838h2 << 30);
                int iM14837g2 = i4 + ((iM14837g << 5) | (iM14837g >>> 27)) + m14837g(iM14838h, i16, i3) + this.f18918X[i6 + 1] + f18911Y3;
                int i17 = (iM14838h >>> 2) | (iM14838h << 30);
                int iM14837g3 = i3 + ((iM14837g2 << 5) | (iM14837g2 >>> 27)) + m14837g(iM14837g, i17, i16) + this.f18918X[i6 + 2] + f18911Y3;
                i5 = (iM14837g >>> 2) | (iM14837g << 30);
                int i18 = i6 + 4;
                iM14838h2 = i16 + ((iM14837g3 << 5) | (iM14837g3 >>> 27)) + m14837g(iM14837g2, i5, i17) + this.f18918X[i6 + 3] + f18911Y3;
                i4 = (iM14837g2 >>> 2) | (iM14837g2 << 30);
                i6 += 5;
                iM14838h = i17 + ((iM14838h2 << 5) | (iM14838h2 >>> 27)) + m14837g(iM14837g3, i4, i5) + this.f18918X[i18] + f18911Y3;
                i3 = (iM14837g3 >>> 2) | (iM14837g3 << 30);
            }
            for (int i19 = 0; i19 <= 3; i19++) {
                int iM14838h6 = i5 + ((iM14838h << 5) | (iM14838h >>> 27)) + m14838h(iM14838h2, i3, i4) + this.f18918X[i6] + f18912Y4;
                int i20 = (iM14838h2 >>> 2) | (iM14838h2 << 30);
                int iM14838h7 = i4 + ((iM14838h6 << 5) | (iM14838h6 >>> 27)) + m14838h(iM14838h, i20, i3) + this.f18918X[i6 + 1] + f18912Y4;
                int i21 = (iM14838h >>> 2) | (iM14838h << 30);
                int iM14838h8 = i3 + ((iM14838h7 << 5) | (iM14838h7 >>> 27)) + m14838h(iM14838h6, i21, i20) + this.f18918X[i6 + 2] + f18912Y4;
                i5 = (iM14838h6 >>> 2) | (iM14838h6 << 30);
                int i22 = i6 + 4;
                iM14838h2 = i20 + ((iM14838h8 << 5) | (iM14838h8 >>> 27)) + m14838h(iM14838h7, i5, i21) + this.f18918X[i6 + 3] + f18912Y4;
                i4 = (iM14838h7 >>> 2) | (iM14838h7 << 30);
                i6 += 5;
                iM14838h = i21 + ((iM14838h2 << 5) | (iM14838h2 >>> 27)) + m14838h(iM14838h8, i4, i5) + this.f18918X[i22] + f18912Y4;
                i3 = (iM14838h8 >>> 2) | (iM14838h8 << 30);
            }
            this.f18913H1 += iM14838h;
            this.f18914H2 += iM14838h2;
            this.f18915H3 += i3;
            this.f18916H4 += i4;
            this.f18917H5 += i5;
            this.f18919xOff = 0;
            for (int i23 = 0; i23 < 16; i23++) {
                this.f18918X[i23] = 0;
            }
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        public void processLength(long j) {
            if (this.f18919xOff > 14) {
                processBlock();
            }
            int[] iArr = this.f18918X;
            iArr[14] = (int) (j >>> 32);
            iArr[15] = (int) j;
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        public void processWord(byte[] bArr, int i) {
            int i2 = (bArr[i + 3] & C1126UByte.MAX_VALUE) | (bArr[i] << 24) | ((bArr[i + 1] & C1126UByte.MAX_VALUE) << 16) | ((bArr[i + 2] & C1126UByte.MAX_VALUE) << 8);
            int[] iArr = this.f18918X;
            int i3 = this.f18919xOff;
            iArr[i3] = i2;
            int i4 = i3 + 1;
            this.f18919xOff = i4;
            if (i4 == 16) {
                processBlock();
            }
        }

        @Override // org.bouncycastle.cert.selector.MSOutlookKeyIdCalculator.GeneralDigest
        /* renamed from: reset */
        public void mo14833reset() {
            super.mo14833reset();
            this.f18913H1 = 1732584193;
            this.f18914H2 = -271733879;
            this.f18915H3 = -1732584194;
            this.f18916H4 = 271733878;
            this.f18917H5 = -1009589776;
            this.f18919xOff = 0;
            int i = 0;
            while (true) {
                int[] iArr = this.f18918X;
                if (i == iArr.length) {
                    return;
                }
                iArr[i] = 0;
                i++;
            }
        }
    }

    public static byte[] calculateKeyId(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        SHA1Digest sHA1Digest = new SHA1Digest();
        byte[] bArr = new byte[sHA1Digest.getDigestSize()];
        try {
            byte[] encoded = subjectPublicKeyInfo.getEncoded(ASN1Encoding.f17902DER);
            sHA1Digest.m14835update(encoded, 0, encoded.length);
            sHA1Digest.m14839doFinal(bArr, 0);
            return bArr;
        } catch (IOException unused) {
            return new byte[0];
        }
    }
}
