package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;

/* loaded from: classes2.dex */
public abstract class SerpentEngineBase implements BlockCipher {
    protected static final int BLOCK_SIZE = 16;

    /* renamed from: PHI */
    static final int f20085PHI = -1640531527;

    /* renamed from: ROUNDS */
    static final int f20086ROUNDS = 32;
    protected boolean encrypting;

    /* renamed from: keyBits */
    protected int f20087keyBits;

    /* renamed from: wKey */
    protected int[] f20088wKey;

    public SerpentEngineBase() {
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 256));
    }

    private CryptoServicePurpose getPurpose() {
        return this.f20088wKey == null ? CryptoServicePurpose.ANY : this.encrypting ? CryptoServicePurpose.ENCRYPTION : CryptoServicePurpose.DECRYPTION;
    }

    public static int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    public static int rotateRight(int i, int i2) {
        return (i << (-i2)) | (i >>> i2);
    }

    /* renamed from: LT */
    public final void m15408LT(int[] iArr) {
        int iRotateLeft = rotateLeft(iArr[0], 13);
        int iRotateLeft2 = rotateLeft(iArr[2], 3);
        int i = (iArr[1] ^ iRotateLeft) ^ iRotateLeft2;
        int i2 = (iArr[3] ^ iRotateLeft2) ^ (iRotateLeft << 3);
        iArr[1] = rotateLeft(i, 1);
        int iRotateLeft3 = rotateLeft(i2, 7);
        iArr[3] = iRotateLeft3;
        iArr[0] = rotateLeft((iRotateLeft ^ iArr[1]) ^ iRotateLeft3, 5);
        iArr[2] = rotateLeft((iArr[3] ^ iRotateLeft2) ^ (iArr[1] << 7), 22);
    }

    public abstract void decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2);

    public abstract void encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2);

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "Serpent";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return 16;
    }

    /* renamed from: ib0 */
    public final void m15409ib0(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i2 ^ i;
        int i7 = (i5 | i6) ^ i4;
        int i8 = i3 ^ i7;
        int i9 = i6 ^ i8;
        iArr[2] = i9;
        int i10 = i5 ^ (i6 & i4);
        int i11 = (i9 & i10) ^ i7;
        iArr[1] = i11;
        int i12 = (i & i7) ^ (i11 | i8);
        iArr[3] = i12;
        iArr[0] = (i10 ^ i8) ^ i12;
    }

    /* renamed from: ib1 */
    public final void m15410ib1(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = i2 ^ i4;
        int i6 = i ^ (i2 & i5);
        int i7 = i5 ^ i6;
        int i8 = i3 ^ i7;
        iArr[3] = i8;
        int i9 = (i5 & i6) ^ i2;
        int i10 = i6 ^ (i8 | i9);
        iArr[1] = i10;
        int i11 = ~i10;
        int i12 = i9 ^ i8;
        iArr[0] = i11 ^ i12;
        iArr[2] = (i12 | i11) ^ i7;
    }

    /* renamed from: ib2 */
    public final void m15411ib2(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = i2 ^ i4;
        int i6 = ~i5;
        int i7 = i ^ i3;
        int i8 = i3 ^ i5;
        int i9 = (i2 & i8) ^ i7;
        iArr[0] = i9;
        int i10 = i5 ^ (((i | i6) ^ i4) | i7);
        iArr[3] = i10;
        int i11 = ~i8;
        int i12 = i10 | i9;
        iArr[1] = i11 ^ i12;
        iArr[2] = (i12 ^ i7) ^ (i11 & i4);
    }

    /* renamed from: ib3 */
    public final void m15412ib3(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = i | i2;
        int i6 = i2 ^ i3;
        int i7 = i ^ (i2 & i6);
        int i8 = i3 ^ i7;
        int i9 = i4 | i7;
        int i10 = i6 ^ i9;
        iArr[0] = i10;
        int i11 = (i9 | i6) ^ i4;
        iArr[2] = i8 ^ i11;
        int i12 = i5 ^ i11;
        int i13 = i7 ^ (i10 & i12);
        iArr[3] = i13;
        iArr[1] = (i12 ^ i10) ^ i13;
    }

    /* renamed from: ib4 */
    public final void m15413ib4(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = ((i3 | i4) & i) ^ i2;
        int i6 = (i & i5) ^ i3;
        int i7 = i4 ^ i6;
        iArr[1] = i7;
        int i8 = ~i;
        int i9 = (i6 & i7) ^ i5;
        iArr[3] = i9;
        int i10 = i4 ^ (i7 | i8);
        iArr[0] = i9 ^ i10;
        iArr[2] = (i5 & i10) ^ (i8 ^ i7);
    }

    /* renamed from: ib5 */
    public final void m15414ib5(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = ~i3;
        int i6 = (i2 & i5) ^ i4;
        int i7 = i & i6;
        int i8 = (i2 ^ i5) ^ i7;
        iArr[3] = i8;
        int i9 = i8 | i2;
        iArr[1] = i6 ^ (i & i9);
        int i10 = i4 | i;
        iArr[0] = (i5 ^ i9) ^ i10;
        iArr[2] = (i2 & i10) ^ ((i ^ i3) | i7);
    }

    /* renamed from: ib6 */
    public final void m15415ib6(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i ^ i2;
        int i7 = i3 ^ i6;
        int i8 = (i3 | i5) ^ i4;
        iArr[1] = i7 ^ i8;
        int i9 = i6 ^ (i7 & i8);
        int i10 = i8 ^ (i2 | i9);
        iArr[3] = i10;
        int i11 = i2 | i10;
        iArr[0] = i9 ^ i11;
        iArr[2] = (i5 & i4) ^ (i7 ^ i11);
    }

    /* renamed from: ib7 */
    public final void m15416ib7(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = (i & i2) | i3;
        int i6 = (i | i2) & i4;
        int i7 = i5 ^ i6;
        iArr[3] = i7;
        int i8 = i2 ^ i6;
        int i9 = ((i7 ^ (~i4)) | i8) ^ i;
        iArr[1] = i9;
        int i10 = (i8 ^ i3) ^ (i4 | i9);
        iArr[0] = i10;
        iArr[2] = (i5 ^ i9) ^ ((i & i7) ^ i10);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (cipherParameters instanceof KeyParameter) {
            this.encrypting = z;
            byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
            this.f20088wKey = makeWorkingKey(bArrM15773getKey);
            CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), bArrM15773getKey.length * 8, cipherParameters, getPurpose()));
            return;
        }
        throw new IllegalArgumentException("invalid parameter passed to " + getAlgorithmName() + " init - " + cipherParameters.getClass().getName());
    }

    public final void inverseLT(int[] iArr) {
        int iRotateRight = (rotateRight(iArr[2], 22) ^ iArr[3]) ^ (iArr[1] << 7);
        int iRotateRight2 = rotateRight(iArr[0], 5) ^ iArr[1];
        int i = iArr[3];
        int i2 = iRotateRight2 ^ i;
        int iRotateRight3 = rotateRight(i, 7);
        int iRotateRight4 = rotateRight(iArr[1], 1);
        iArr[3] = (iRotateRight3 ^ iRotateRight) ^ (i2 << 3);
        iArr[1] = (iRotateRight4 ^ i2) ^ iRotateRight;
        iArr[2] = rotateRight(iRotateRight, 3);
        iArr[0] = rotateRight(i2, 13);
    }

    public abstract int[] makeWorkingKey(byte[] bArr);

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public final int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f20088wKey == null) {
            throw new IllegalStateException(getAlgorithmName() + " not initialised");
        }
        if (i + 16 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 16 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.encrypting) {
            encryptBlock(bArr, i, bArr2, i2);
            return 16;
        }
        decryptBlock(bArr, i, bArr2, i2);
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
    }

    /* renamed from: sb0 */
    public final void m15417sb0(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = i ^ i4;
        int i6 = i3 ^ i5;
        int i7 = i2 ^ i6;
        int i8 = (i4 & i) ^ i7;
        iArr[3] = i8;
        int i9 = (i5 & i2) ^ i;
        iArr[2] = (i3 | i9) ^ i7;
        int i10 = (i6 ^ i9) & i8;
        iArr[1] = (~i6) ^ i10;
        iArr[0] = (~i9) ^ i10;
    }

    /* renamed from: sb1 */
    public final void m15418sb1(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = (~i) ^ i2;
        int i6 = (i | i5) ^ i3;
        int i7 = i4 ^ i6;
        iArr[2] = i7;
        int i8 = i2 ^ (i4 | i5);
        int i9 = i5 ^ i7;
        int i10 = (i6 & i8) ^ i9;
        iArr[3] = i10;
        int i11 = i8 ^ i6;
        iArr[1] = i10 ^ i11;
        iArr[0] = (i9 & i11) ^ i6;
    }

    /* renamed from: sb2 */
    public final void m15419sb2(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i2 ^ i4;
        int i7 = (i3 & i5) ^ i6;
        iArr[0] = i7;
        int i8 = i3 ^ i5;
        int i9 = i2 & (i3 ^ i7);
        int i10 = i8 ^ i9;
        iArr[3] = i10;
        int i11 = i ^ ((i9 | i4) & (i7 | i8));
        iArr[2] = i11;
        iArr[1] = ((i5 | i4) ^ i11) ^ (i6 ^ i10);
    }

    /* renamed from: sb3 */
    public final void m15420sb3(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = i ^ i2;
        int i6 = i & i3;
        int i7 = i | i4;
        int i8 = i3 ^ i4;
        int i9 = i6 | (i5 & i7);
        int i10 = i8 ^ i9;
        iArr[2] = i10;
        int i11 = (i7 ^ i2) ^ i9;
        int i12 = i5 ^ (i8 & i11);
        iArr[0] = i12;
        int i13 = i12 & i10;
        iArr[1] = i11 ^ i13;
        iArr[3] = (i13 ^ i8) ^ (i2 | i4);
    }

    /* renamed from: sb4 */
    public final void m15421sb4(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = i ^ i4;
        int i6 = i3 ^ (i4 & i5);
        int i7 = i2 | i6;
        iArr[3] = i5 ^ i7;
        int i8 = ~i2;
        int i9 = (i5 | i8) ^ i6;
        iArr[0] = i9;
        int i10 = i5 ^ i8;
        int i11 = (i7 & i10) ^ (i9 & i);
        iArr[2] = i11;
        iArr[1] = (i10 & i11) ^ (i ^ i6);
    }

    /* renamed from: sb5 */
    public final void m15422sb5(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i ^ i2;
        int i7 = i ^ i4;
        int i8 = (i3 ^ i5) ^ (i6 | i7);
        iArr[0] = i8;
        int i9 = i4 & i8;
        int i10 = (i6 ^ i8) ^ i9;
        iArr[1] = i10;
        int i11 = (i5 | i8) ^ i7;
        iArr[2] = (i6 | i9) ^ i11;
        iArr[3] = (i11 & i10) ^ (i2 ^ i9);
    }

    /* renamed from: sb6 */
    public final void m15423sb6(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = ~i;
        int i6 = i ^ i4;
        int i7 = i2 ^ i6;
        int i8 = (i5 | i6) ^ i3;
        int i9 = i2 ^ i8;
        iArr[1] = i9;
        int i10 = (i6 | i9) ^ i4;
        int i11 = (i8 & i10) ^ i7;
        iArr[2] = i11;
        int i12 = i10 ^ i8;
        iArr[0] = i11 ^ i12;
        iArr[3] = (~i8) ^ (i12 & i7);
    }

    /* renamed from: sb7 */
    public final void m15424sb7(int[] iArr, int i, int i2, int i3, int i4) {
        int i5 = i2 ^ i3;
        int i6 = (i3 & i5) ^ i4;
        int i7 = i ^ i6;
        int i8 = i2 ^ ((i4 | i5) & i7);
        iArr[1] = i8;
        int i9 = i5 ^ (i & i7);
        iArr[3] = i9;
        int i10 = i7 ^ (i8 | i6);
        int i11 = (i9 & i10) ^ i6;
        iArr[2] = i11;
        iArr[0] = (i9 & i11) ^ (~i10);
    }
}
