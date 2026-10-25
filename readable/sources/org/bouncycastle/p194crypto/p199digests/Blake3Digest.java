package org.bouncycastle.p194crypto.p199digests;

import java.util.Iterator;
import java.util.Stack;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.Blake3Parameters;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Integers;
import org.bouncycastle.p361util.Memoable;

/* loaded from: classes2.dex */
public class Blake3Digest implements ExtendedDigest, Memoable, InterfaceC5284Xof {
    private static final int BLOCKLEN = 64;
    private static final int CHAINING0 = 0;
    private static final int CHAINING1 = 1;
    private static final int CHAINING2 = 2;
    private static final int CHAINING3 = 3;
    private static final int CHAINING4 = 4;
    private static final int CHAINING5 = 5;
    private static final int CHAINING6 = 6;
    private static final int CHAINING7 = 7;
    private static final int CHUNKEND = 2;
    private static final int CHUNKLEN = 1024;
    private static final int CHUNKSTART = 1;

    /* renamed from: COUNT0 */
    private static final int f19317COUNT0 = 12;

    /* renamed from: COUNT1 */
    private static final int f19318COUNT1 = 13;

    /* renamed from: DATALEN */
    private static final int f19319DATALEN = 14;
    private static final int DERIVECONTEXT = 32;
    private static final int DERIVEKEY = 64;
    private static final String ERR_OUTPUTTING = "Already outputting";

    /* renamed from: FLAGS */
    private static final int f19320FLAGS = 15;

    /* renamed from: IV0 */
    private static final int f19322IV0 = 8;

    /* renamed from: IV1 */
    private static final int f19323IV1 = 9;

    /* renamed from: IV2 */
    private static final int f19324IV2 = 10;

    /* renamed from: IV3 */
    private static final int f19325IV3 = 11;
    private static final int KEYEDHASH = 16;
    private static final int NUMWORDS = 8;

    /* renamed from: PARENT */
    private static final int f19326PARENT = 4;

    /* renamed from: ROOT */
    private static final int f19327ROOT = 8;

    /* renamed from: ROUNDS */
    private static final int f19328ROUNDS = 7;
    private long outputAvailable;
    private boolean outputting;

    /* renamed from: purpose */
    private final CryptoServicePurpose f19330purpose;
    private final byte[] theBuffer;
    private final int[] theChaining;
    private long theCounter;
    private int theCurrBytes;
    private final int theDigestLen;
    private final byte[] theIndices;

    /* renamed from: theK */
    private final int[] f19331theK;

    /* renamed from: theM */
    private final int[] f19332theM;

    /* renamed from: theMode */
    private int f19333theMode;
    private int theOutputDataLen;
    private int theOutputMode;

    /* renamed from: thePos */
    private int f19334thePos;
    private final Stack theStack;

    /* renamed from: theV */
    private final int[] f19335theV;

    /* renamed from: SIGMA */
    private static final byte[] f19329SIGMA = {2, 6, 3, 10, 7, 0, 4, 13, 1, 11, 12, 5, 9, 14, 15, 8};

    /* renamed from: IV */
    private static final int[] f19321IV = {1779033703, -1150833019, 1013904242, -1521486534, 1359893119, -1694144372, 528734635, 1541459225};

    public Blake3Digest() {
        this(256);
    }

    private void adjustChaining() {
        if (!this.outputting) {
            for (int i = 0; i < 8; i++) {
                int[] iArr = this.theChaining;
                int[] iArr2 = this.f19335theV;
                iArr[i] = iArr2[i + 8] ^ iArr2[i];
            }
            return;
        }
        for (int i2 = 0; i2 < 8; i2++) {
            int[] iArr3 = this.f19335theV;
            int i3 = i2 + 8;
            iArr3[i2] = iArr3[i2] ^ iArr3[i3];
            iArr3[i3] = iArr3[i3] ^ this.theChaining[i2];
        }
        AbstractC6245Pack.intToLittleEndian(this.f19335theV, this.theBuffer, 0);
        this.f19334thePos = 0;
    }

    private void adjustStack() {
        for (long j = this.theCounter; j > 0 && (j & 1) != 1; j >>= 1) {
            System.arraycopy((int[]) this.theStack.pop(), 0, this.f19332theM, 0, 8);
            System.arraycopy(this.theChaining, 0, this.f19332theM, 8, 8);
            initParentBlock();
            compress();
        }
        this.theStack.push(C6238Arrays.m18244copyOf(this.theChaining, 8));
    }

    private void compress() {
        initIndices();
        int i = 0;
        while (true) {
            performRound();
            if (i >= 6) {
                adjustChaining();
                return;
            } else {
                permuteIndices();
                i++;
            }
        }
    }

    private void compressBlock(byte[] bArr, int i) {
        initChunkBlock(64, false);
        m15055initM(bArr, i);
        compress();
        if (this.theCurrBytes == 0) {
            adjustStack();
        }
    }

    private void compressFinalBlock(int i) {
        initChunkBlock(i, true);
        m15055initM(this.theBuffer, 0);
        compress();
        processStack();
    }

    private void incrementBlockCount() {
        this.theCounter++;
        this.theCurrBytes = 0;
    }

    private void initChunkBlock(int i, boolean z) {
        System.arraycopy(this.theCurrBytes == 0 ? this.f19331theK : this.theChaining, 0, this.f19335theV, 0, 8);
        System.arraycopy(f19321IV, 0, this.f19335theV, 8, 4);
        int[] iArr = this.f19335theV;
        long j = this.theCounter;
        iArr[12] = (int) j;
        iArr[13] = (int) (j >> 32);
        iArr[14] = i;
        int i2 = this.f19333theMode;
        int i3 = this.theCurrBytes;
        iArr[15] = i2 + (i3 == 0 ? 1 : 0) + (z ? 2 : 0);
        int i4 = i3 + i;
        this.theCurrBytes = i4;
        if (i4 >= 1024) {
            incrementBlockCount();
            int[] iArr2 = this.f19335theV;
            iArr2[15] = iArr2[15] | 2;
        }
        if (z && this.theStack.isEmpty()) {
            m15057setRoot();
        }
    }

    private void initIndices() {
        byte b = 0;
        while (true) {
            byte[] bArr = this.theIndices;
            if (b >= bArr.length) {
                return;
            }
            bArr[b] = b;
            b = (byte) (b + 1);
        }
    }

    /* renamed from: initKey */
    private void m15054initKey(byte[] bArr) {
        AbstractC6245Pack.littleEndianToInt(bArr, 0, this.f19331theK);
        this.f19333theMode = 16;
    }

    private void initKeyFromContext() {
        System.arraycopy(this.f19335theV, 0, this.f19331theK, 0, 8);
        this.f19333theMode = 64;
    }

    /* renamed from: initM */
    private void m15055initM(byte[] bArr, int i) {
        AbstractC6245Pack.littleEndianToInt(bArr, i, this.f19332theM);
    }

    private void initNullKey() {
        System.arraycopy(f19321IV, 0, this.f19331theK, 0, 8);
    }

    private void initParentBlock() {
        System.arraycopy(this.f19331theK, 0, this.f19335theV, 0, 8);
        System.arraycopy(f19321IV, 0, this.f19335theV, 8, 4);
        int[] iArr = this.f19335theV;
        iArr[12] = 0;
        iArr[13] = 0;
        iArr[14] = 64;
        iArr[15] = this.f19333theMode | 4;
    }

    /* renamed from: mixG */
    private void m15056mixG(int i, int i2, int i3, int i4, int i5) {
        int i6 = i << 1;
        int[] iArr = this.f19335theV;
        int i7 = i6 + 1;
        int i8 = iArr[i2] + iArr[i3] + this.f19332theM[this.theIndices[i6]];
        iArr[i2] = i8;
        iArr[i5] = Integers.rotateRight(iArr[i5] ^ i8, 16);
        int[] iArr2 = this.f19335theV;
        int i9 = iArr2[i4] + iArr2[i5];
        iArr2[i4] = i9;
        iArr2[i3] = Integers.rotateRight(i9 ^ iArr2[i3], 12);
        int[] iArr3 = this.f19335theV;
        int i10 = iArr3[i2] + iArr3[i3] + this.f19332theM[this.theIndices[i7]];
        iArr3[i2] = i10;
        iArr3[i5] = Integers.rotateRight(iArr3[i5] ^ i10, 8);
        int[] iArr4 = this.f19335theV;
        int i11 = iArr4[i4] + iArr4[i5];
        iArr4[i4] = i11;
        iArr4[i3] = Integers.rotateRight(i11 ^ iArr4[i3], 7);
    }

    private void nextOutputBlock() {
        this.theCounter++;
        System.arraycopy(this.theChaining, 0, this.f19335theV, 0, 8);
        System.arraycopy(f19321IV, 0, this.f19335theV, 8, 4);
        int[] iArr = this.f19335theV;
        long j = this.theCounter;
        iArr[12] = (int) j;
        iArr[13] = (int) (j >> 32);
        iArr[14] = this.theOutputDataLen;
        iArr[15] = this.theOutputMode;
        compress();
    }

    private void performRound() {
        m15056mixG(0, 0, 4, 8, 12);
        m15056mixG(1, 1, 5, 9, 13);
        m15056mixG(2, 2, 6, 10, 14);
        m15056mixG(3, 3, 7, 11, 15);
        m15056mixG(4, 0, 5, 10, 15);
        m15056mixG(5, 1, 6, 11, 12);
        m15056mixG(6, 2, 7, 8, 13);
        m15056mixG(7, 3, 4, 9, 14);
    }

    private void permuteIndices() {
        byte b = 0;
        while (true) {
            byte[] bArr = this.theIndices;
            if (b >= bArr.length) {
                return;
            }
            bArr[b] = f19329SIGMA[bArr[b]];
            b = (byte) (b + 1);
        }
    }

    private void processStack() {
        while (!this.theStack.isEmpty()) {
            System.arraycopy((int[]) this.theStack.pop(), 0, this.f19332theM, 0, 8);
            System.arraycopy(this.theChaining, 0, this.f19332theM, 8, 8);
            initParentBlock();
            if (this.theStack.isEmpty()) {
                m15057setRoot();
            }
            compress();
        }
    }

    private void resetBlockCount() {
        this.theCounter = 0L;
        this.theCurrBytes = 0;
    }

    /* renamed from: setRoot */
    private void m15057setRoot() {
        int[] iArr = this.f19335theV;
        int i = iArr[15] | 8;
        iArr[15] = i;
        this.theOutputMode = i;
        this.theOutputDataLen = iArr[14];
        this.theCounter = 0L;
        this.outputting = true;
        this.outputAvailable = -1L;
        System.arraycopy(iArr, 0, this.theChaining, 0, 8);
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new Blake3Digest(this);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public int mo14967doFinal(byte[] bArr, int i) {
        return mo14998doFinal(bArr, i, getDigestSize());
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
    public int doOutput(byte[] bArr, int i, int i2) {
        int i3;
        if (i > bArr.length - i2) {
            throw new OutputLengthException("output buffer too short");
        }
        if (!this.outputting) {
            compressFinalBlock(this.f19334thePos);
        }
        if (i2 >= 0) {
            long j = this.outputAvailable;
            if (j < 0 || i2 <= j) {
                int i4 = this.f19334thePos;
                if (i4 < 64) {
                    int iMin = Math.min(i2, 64 - i4);
                    System.arraycopy(this.theBuffer, this.f19334thePos, bArr, i, iMin);
                    this.f19334thePos += iMin;
                    i += iMin;
                    i3 = i2 - iMin;
                } else {
                    i3 = i2;
                }
                while (i3 > 0) {
                    nextOutputBlock();
                    int iMin2 = Math.min(i3, 64);
                    System.arraycopy(this.theBuffer, 0, bArr, i, iMin2);
                    this.f19334thePos += iMin2;
                    i += iMin2;
                    i3 -= iMin2;
                }
                this.outputAvailable -= i2;
                return i2;
            }
        }
        throw new IllegalArgumentException("Insufficient bytes remaining");
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public String getAlgorithmName() {
        return "BLAKE3";
    }

    @Override // org.bouncycastle.p194crypto.ExtendedDigest
    public int getByteLength() {
        return 64;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    public int getDigestSize() {
        return this.theDigestLen;
    }

    /* renamed from: init */
    public void m15058init(Blake3Parameters blake3Parameters) {
        byte[] bArrM15672getKey = blake3Parameters == null ? null : blake3Parameters.m15672getKey();
        byte[] context = blake3Parameters != null ? blake3Parameters.getContext() : null;
        mo14968reset();
        if (bArrM15672getKey != null) {
            m15054initKey(bArrM15672getKey);
            C6238Arrays.m18249fill(bArrM15672getKey, (byte) 0);
            return;
        }
        initNullKey();
        if (context == null) {
            this.f19333theMode = 0;
            return;
        }
        this.f19333theMode = 32;
        mo14970update(context, 0, context.length);
        mo14967doFinal(this.theBuffer, 0);
        initKeyFromContext();
        mo14968reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        resetBlockCount();
        this.f19334thePos = 0;
        this.outputting = false;
        C6238Arrays.m18249fill(this.theBuffer, (byte) 0);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14969update(byte b) {
        if (this.outputting) {
            throw new IllegalStateException(ERR_OUTPUTTING);
        }
        byte[] bArr = this.theBuffer;
        if (bArr.length - this.f19334thePos == 0) {
            compressBlock(bArr, 0);
            C6238Arrays.m18249fill(this.theBuffer, (byte) 0);
            this.f19334thePos = 0;
        }
        byte[] bArr2 = this.theBuffer;
        int i = this.f19334thePos;
        bArr2[i] = b;
        this.f19334thePos = i + 1;
    }

    public Blake3Digest(int i) {
        this(i <= 100 ? i * 8 : i, CryptoServicePurpose.ANY);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
    /* renamed from: doFinal */
    public int mo14998doFinal(byte[] bArr, int i, int i2) {
        int iDoOutput = doOutput(bArr, i, i2);
        mo14968reset();
        return iDoOutput;
    }

    @Override // org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        Blake3Digest blake3Digest = (Blake3Digest) memoable;
        this.theCounter = blake3Digest.theCounter;
        this.theCurrBytes = blake3Digest.theCurrBytes;
        this.f19333theMode = blake3Digest.f19333theMode;
        this.outputting = blake3Digest.outputting;
        this.outputAvailable = blake3Digest.outputAvailable;
        this.theOutputMode = blake3Digest.theOutputMode;
        this.theOutputDataLen = blake3Digest.theOutputDataLen;
        int[] iArr = blake3Digest.theChaining;
        int[] iArr2 = this.theChaining;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        int[] iArr3 = blake3Digest.f19331theK;
        int[] iArr4 = this.f19331theK;
        System.arraycopy(iArr3, 0, iArr4, 0, iArr4.length);
        int[] iArr5 = blake3Digest.f19332theM;
        int[] iArr6 = this.f19332theM;
        System.arraycopy(iArr5, 0, iArr6, 0, iArr6.length);
        this.theStack.clear();
        Iterator it = blake3Digest.theStack.iterator();
        while (it.hasNext()) {
            this.theStack.push(C6238Arrays.m18234clone((int[]) it.next()));
        }
        byte[] bArr = blake3Digest.theBuffer;
        byte[] bArr2 = this.theBuffer;
        System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
        this.f19334thePos = blake3Digest.f19334thePos;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public void mo14970update(byte[] bArr, int i, int i2) {
        int i3;
        int i4;
        if (bArr == null || i2 == 0) {
            return;
        }
        if (this.outputting) {
            throw new IllegalStateException(ERR_OUTPUTTING);
        }
        int i5 = this.f19334thePos;
        if (i5 != 0) {
            i3 = 64 - i5;
            if (i3 >= i2) {
                System.arraycopy(bArr, i, this.theBuffer, i5, i2);
                i4 = this.f19334thePos + i2;
                this.f19334thePos = i4;
            } else {
                System.arraycopy(bArr, i, this.theBuffer, i5, i3);
                compressBlock(this.theBuffer, 0);
                this.f19334thePos = 0;
                C6238Arrays.m18249fill(this.theBuffer, (byte) 0);
            }
        } else {
            i3 = 0;
        }
        int i6 = (i + i2) - 64;
        int i7 = i3 + i;
        while (i7 < i6) {
            compressBlock(bArr, i7);
            i7 += 64;
        }
        int i8 = i + (i2 - i7);
        System.arraycopy(bArr, i7, this.theBuffer, 0, i8);
        i4 = this.f19334thePos + i8;
        this.f19334thePos = i4;
    }

    public Blake3Digest(int i, CryptoServicePurpose cryptoServicePurpose) {
        this.theBuffer = new byte[64];
        this.f19331theK = new int[8];
        this.theChaining = new int[8];
        this.f19335theV = new int[16];
        this.f19332theM = new int[16];
        this.theIndices = new byte[16];
        this.theStack = new Stack();
        this.f19330purpose = cryptoServicePurpose;
        this.theDigestLen = i / 8;
        CryptoServicesRegistrar.checkConstraints(C5298Utils.getDefaultProperties(this, getDigestSize() * 8, cryptoServicePurpose));
        m15058init(null);
    }

    public Blake3Digest(Blake3Digest blake3Digest) {
        this.theBuffer = new byte[64];
        this.f19331theK = new int[8];
        this.theChaining = new int[8];
        this.f19335theV = new int[16];
        this.f19332theM = new int[16];
        this.theIndices = new byte[16];
        this.theStack = new Stack();
        this.theDigestLen = blake3Digest.theDigestLen;
        this.f19330purpose = blake3Digest.f19330purpose;
        mo14824reset(blake3Digest);
    }
}
