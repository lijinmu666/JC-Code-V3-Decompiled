package org.bouncycastle.p314pqc.p352legacy.p354picnic;

import java.lang.reflect.Array;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* renamed from: org.bouncycastle.pqc.legacy.picnic.Tape */
/* loaded from: classes2.dex */
class C6217Tape {

    /* renamed from: engine */
    private PicnicEngine f23988engine;

    /* renamed from: nTapes */
    int f23989nTapes;

    /* renamed from: pos */
    int f23990pos = 0;

    /* renamed from: tapes */
    byte[][] f23991tapes;

    public C6217Tape(PicnicEngine picnicEngine) {
        this.f23988engine = picnicEngine;
        this.f23991tapes = (byte[][]) Array.newInstance((Class<?>) Byte.TYPE, picnicEngine.numMPCParties, picnicEngine.andSizeBytes * 2);
        this.f23989nTapes = picnicEngine.numMPCParties;
    }

    private void tapesToParityBits(int[] iArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            C6219Utils.setBitInWordArray(iArr, i2, C6219Utils.parity16(tapesToWord()));
        }
    }

    public void computeAuxTape(byte[] bArr) {
        int[] iArr = new int[16];
        int[] iArr2 = new int[16];
        int[] iArr3 = new int[16];
        int[] iArr4 = new int[16];
        int[] iArr5 = new int[16];
        PicnicEngine picnicEngine = this.f23988engine;
        iArr5[picnicEngine.stateSizeWords - 1] = 0;
        tapesToParityBits(iArr5, picnicEngine.stateSizeBits);
        PicnicEngine picnicEngine2 = this.f23988engine;
        KMatricesWithPointer kMatricesWithPointerKMatrixInv = picnicEngine2.lowmcConstants.KMatrixInv(picnicEngine2);
        this.f23988engine.matrix_mul(iArr4, iArr5, kMatricesWithPointerKMatrixInv.m18081getData(), kMatricesWithPointerKMatrixInv.getMatrixPointer());
        if (bArr != null) {
            AbstractC6245Pack.intToLittleEndian(iArr4, 0, this.f23988engine.stateSizeWords, bArr, 0);
        }
        for (int i = this.f23988engine.numRounds; i > 0; i--) {
            PicnicEngine picnicEngine3 = this.f23988engine;
            KMatricesWithPointer kMatricesWithPointerM18085KMatrix = picnicEngine3.lowmcConstants.m18085KMatrix(picnicEngine3, i);
            this.f23988engine.matrix_mul(iArr, iArr4, kMatricesWithPointerM18085KMatrix.m18081getData(), kMatricesWithPointerM18085KMatrix.getMatrixPointer());
            this.f23988engine.xor_array(iArr2, iArr2, iArr, 0);
            PicnicEngine picnicEngine4 = this.f23988engine;
            int i2 = i - 1;
            KMatricesWithPointer kMatricesWithPointerLMatrixInv = picnicEngine4.lowmcConstants.LMatrixInv(picnicEngine4, i2);
            this.f23988engine.matrix_mul(iArr3, iArr2, kMatricesWithPointerLMatrixInv.m18081getData(), kMatricesWithPointerLMatrixInv.getMatrixPointer());
            if (i == 1) {
                System.arraycopy(iArr5, 0, iArr2, 0, 16);
            } else {
                int i3 = this.f23988engine.stateSizeBits;
                this.f23990pos = i3 * 2 * i2;
                tapesToParityBits(iArr2, i3);
            }
            PicnicEngine picnicEngine5 = this.f23988engine;
            int i4 = picnicEngine5.stateSizeBits;
            this.f23990pos = (i4 * 2 * i2) + i4;
            picnicEngine5.aux_mpc_sbox(iArr2, iArr3, this);
        }
        this.f23990pos = 0;
    }

    public void setAuxBits(byte[] bArr) {
        PicnicEngine picnicEngine = this.f23988engine;
        int i = picnicEngine.numMPCParties - 1;
        int i2 = picnicEngine.stateSizeBits;
        int i3 = 0;
        for (int i4 = 0; i4 < this.f23988engine.numRounds; i4++) {
            int i5 = 0;
            while (i5 < i2) {
                C6219Utils.m18110setBit(this.f23991tapes[i], (i2 * 2 * i4) + i2 + i5, C6219Utils.m18104getBit(bArr, i3));
                i5++;
                i3++;
            }
        }
    }

    public int tapesToWord() {
        int i = this.f23990pos;
        int i2 = i >>> 3;
        int i3 = (i & 7) ^ 7;
        int i4 = 1 << i3;
        byte[][] bArr = this.f23991tapes;
        int i5 = ((bArr[15][i2] & i4) << 8) | (bArr[7][i2] & i4) | ((bArr[0][i2] & i4) << 7) | ((bArr[1][i2] & i4) << 6) | ((bArr[2][i2] & i4) << 5) | ((bArr[3][i2] & i4) << 4) | ((bArr[4][i2] & i4) << 3) | ((bArr[5][i2] & i4) << 2) | ((bArr[6][i2] & i4) << 1) | ((bArr[8][i2] & i4) << 15) | ((bArr[9][i2] & i4) << 14) | ((bArr[10][i2] & i4) << 13) | ((bArr[11][i2] & i4) << 12) | ((bArr[12][i2] & i4) << 11) | ((bArr[13][i2] & i4) << 10) | ((bArr[14][i2] & i4) << 9);
        this.f23990pos = i + 1;
        return i5 >>> i3;
    }
}
