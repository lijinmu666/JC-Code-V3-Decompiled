package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.DataLengthException;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.constraints.DefaultServiceProperties;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class SkipjackEngine implements BlockCipher {
    static final int BLOCK_SIZE = 8;

    /* renamed from: ftable */
    static short[] f20091ftable = {163, 215, 9, 131, 248, 72, 246, 244, 179, 33, 21, 120, 153, 177, 175, 249, 231, 45, 77, 138, 206, 76, 202, 46, 82, 149, 217, 30, 78, 56, 68, 40, 10, 223, 2, 160, 23, 241, 96, 104, 18, 183, 122, 195, 233, 250, 61, 83, 150, 132, 107, 186, 242, 99, 154, 25, 124, 174, 229, 245, 247, 22, 106, 162, 57, 182, 123, 15, 193, 147, 129, 27, 238, 180, 26, 234, 208, 145, 47, 184, 85, 185, 218, 133, 63, 65, 191, 224, 90, 88, 128, 95, 102, 11, 216, 144, 53, 213, 192, 167, 51, 6, 101, 105, 69, 0, 148, 86, 109, 152, 155, 118, 151, 252, 178, 194, 176, 254, 219, 32, 225, 235, 214, 228, 221, 71, 74, 29, 66, 237, 158, 110, 73, 60, 205, 67, 39, 210, 7, 212, 222, 199, 103, 24, 137, 203, 48, 31, 141, 198, 143, 170, 200, 116, 220, 201, 93, 92, 49, 164, 112, 136, 97, 44, 159, 13, 43, 135, 80, 130, 84, 100, 38, 125, 3, 64, 52, 75, 28, 115, 209, 196, 253, 59, 204, 251, 127, 171, 230, 62, 91, 165, 173, 4, 35, 156, 20, 81, 34, 240, 41, 121, 113, 126, 255, 140, 14, 226, 12, 239, 188, 114, 117, 111, 55, 161, 236, 211, 142, 98, 139, 134, 16, 232, 8, 119, 17, 190, 146, 79, 36, 197, 50, 54, 157, 207, 243, 166, 187, 172, 94, 108, 169, 19, 87, 37, 181, 227, 189, 168, 58, 1, 5, 89, 42, 70};
    private boolean encrypting;

    /* renamed from: key0 */
    private int[] f20092key0;

    /* renamed from: key1 */
    private int[] f20093key1;

    /* renamed from: key2 */
    private int[] f20094key2;

    /* renamed from: key3 */
    private int[] f20095key3;

    public SkipjackEngine() {
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 80));
    }

    /* renamed from: g */
    private int m15426g(int i, int i2) {
        int i3 = (i2 >> 8) & 255;
        int i4 = i2 & 255;
        short[] sArr = f20091ftable;
        int i5 = i3 ^ sArr[this.f20092key0[i] ^ i4];
        int i6 = i4 ^ sArr[this.f20093key1[i] ^ i5];
        int i7 = i5 ^ sArr[this.f20094key2[i] ^ i6];
        return (i7 << 8) + (sArr[this.f20095key3[i] ^ i7] ^ i6);
    }

    private CryptoServicePurpose getPurpose() {
        return this.f20092key0 == null ? CryptoServicePurpose.ANY : this.encrypting ? CryptoServicePurpose.ENCRYPTION : CryptoServicePurpose.DECRYPTION;
    }

    /* renamed from: h */
    private int m15427h(int i, int i2) {
        int i3 = i2 & 255;
        int i4 = (i2 >> 8) & 255;
        short[] sArr = f20091ftable;
        int i5 = i3 ^ sArr[this.f20095key3[i] ^ i4];
        int i6 = i4 ^ sArr[this.f20094key2[i] ^ i5];
        int i7 = i5 ^ sArr[this.f20093key1[i] ^ i6];
        return ((sArr[this.f20092key0[i] ^ i7] ^ i6) << 8) + i7;
    }

    public int decryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = (bArr[i] << 8) + (bArr[i + 1] & C1126UByte.MAX_VALUE);
        int i4 = (bArr[i + 2] << 8) + (bArr[i + 3] & C1126UByte.MAX_VALUE);
        int i5 = (bArr[i + 4] << 8) + (bArr[i + 5] & C1126UByte.MAX_VALUE);
        int i6 = (bArr[i + 6] << 8) + (bArr[i + 7] & C1126UByte.MAX_VALUE);
        int i7 = 31;
        for (int i8 = 0; i8 < 2; i8++) {
            int i9 = 0;
            while (i9 < 8) {
                int iM15427h = m15427h(i7, i4);
                int i10 = (i5 ^ iM15427h) ^ (i7 + 1);
                i7--;
                i9++;
                int i11 = i6;
                i6 = i3;
                i3 = iM15427h;
                i4 = i10;
                i5 = i11;
            }
            int i12 = 0;
            while (i12 < 8) {
                int i13 = (i3 ^ i4) ^ (i7 + 1);
                int iM15427h2 = m15427h(i7, i4);
                i7--;
                i12++;
                int i14 = i6;
                i6 = i13;
                i3 = iM15427h2;
                i4 = i5;
                i5 = i14;
            }
        }
        bArr2[i2] = (byte) (i3 >> 8);
        bArr2[i2 + 1] = (byte) i3;
        bArr2[i2 + 2] = (byte) (i4 >> 8);
        bArr2[i2 + 3] = (byte) i4;
        bArr2[i2 + 4] = (byte) (i5 >> 8);
        bArr2[i2 + 5] = (byte) i5;
        bArr2[i2 + 6] = (byte) (i6 >> 8);
        bArr2[i2 + 7] = (byte) i6;
        return 8;
    }

    public int encryptBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        int i3 = (bArr[i] << 8) + (bArr[i + 1] & C1126UByte.MAX_VALUE);
        int i4 = (bArr[i + 2] << 8) + (bArr[i + 3] & C1126UByte.MAX_VALUE);
        int i5 = (bArr[i + 4] << 8) + (bArr[i + 5] & C1126UByte.MAX_VALUE);
        int i6 = (bArr[i + 6] << 8) + (bArr[i + 7] & C1126UByte.MAX_VALUE);
        int i7 = 0;
        for (int i8 = 0; i8 < 2; i8++) {
            int i9 = 0;
            while (i9 < 8) {
                int iM15426g = m15426g(i7, i3);
                i7++;
                i9++;
                int i10 = i4;
                i4 = iM15426g;
                i3 = (i6 ^ iM15426g) ^ i7;
                i6 = i5;
                i5 = i10;
            }
            int i11 = 0;
            while (i11 < 8) {
                int i12 = i7 + 1;
                int i13 = (i4 ^ i3) ^ i12;
                int iM15426g2 = m15426g(i7, i3);
                i11++;
                i7 = i12;
                i4 = iM15426g2;
                i3 = i6;
                i6 = i5;
                i5 = i13;
            }
        }
        bArr2[i2] = (byte) (i3 >> 8);
        bArr2[i2 + 1] = (byte) i3;
        bArr2[i2 + 2] = (byte) (i4 >> 8);
        bArr2[i2 + 3] = (byte) i4;
        bArr2[i2 + 4] = (byte) (i5 >> 8);
        bArr2[i2 + 5] = (byte) i5;
        bArr2[i2 + 6] = (byte) (i6 >> 8);
        bArr2[i2 + 7] = (byte) i6;
        return 8;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return "SKIPJACK";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return 8;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("invalid parameter passed to SKIPJACK init - " + cipherParameters.getClass().getName());
        }
        byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
        this.encrypting = z;
        this.f20092key0 = new int[32];
        this.f20093key1 = new int[32];
        this.f20094key2 = new int[32];
        this.f20095key3 = new int[32];
        for (int i = 0; i < 32; i++) {
            int i2 = i * 4;
            this.f20092key0[i] = bArrM15773getKey[i2 % 10] & C1126UByte.MAX_VALUE;
            this.f20093key1[i] = bArrM15773getKey[(i2 + 1) % 10] & C1126UByte.MAX_VALUE;
            this.f20094key2[i] = bArrM15773getKey[(i2 + 2) % 10] & C1126UByte.MAX_VALUE;
            this.f20095key3[i] = bArrM15773getKey[(i2 + 3) % 10] & C1126UByte.MAX_VALUE;
        }
        CryptoServicesRegistrar.checkConstraints(new DefaultServiceProperties(getAlgorithmName(), 80, cipherParameters, getPurpose()));
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        if (this.f20093key1 == null) {
            throw new IllegalStateException("SKIPJACK engine not initialised");
        }
        if (i + 8 > bArr.length) {
            throw new DataLengthException("input buffer too short");
        }
        if (i2 + 8 > bArr2.length) {
            throw new OutputLengthException("output buffer too short");
        }
        if (this.encrypting) {
            encryptBlock(bArr, i, bArr2, i2);
            return 8;
        }
        decryptBlock(bArr, i, bArr2, i2);
        return 8;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
    }
}
