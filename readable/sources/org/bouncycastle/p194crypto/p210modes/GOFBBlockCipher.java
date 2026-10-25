package org.bouncycastle.p194crypto.p210modes;

import android.R;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.StreamBlockCipher;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class GOFBBlockCipher extends StreamBlockCipher {

    /* renamed from: C1 */
    static final int f20585C1 = 16843012;

    /* renamed from: C2 */
    static final int f20586C2 = 16843009;

    /* renamed from: IV */
    private byte[] f20587IV;

    /* renamed from: N3 */
    int f20588N3;

    /* renamed from: N4 */
    int f20589N4;
    private final int blockSize;
    private int byteCount;

    /* renamed from: cipher */
    private final BlockCipher f20590cipher;
    boolean firstStep;

    /* renamed from: ofbOutV */
    private byte[] f20591ofbOutV;

    /* renamed from: ofbV */
    private byte[] f20592ofbV;

    public GOFBBlockCipher(BlockCipher blockCipher) {
        super(blockCipher);
        this.firstStep = true;
        this.f20590cipher = blockCipher;
        int blockSize = blockCipher.getBlockSize();
        this.blockSize = blockSize;
        if (blockSize != 8) {
            throw new IllegalArgumentException("GCTR only for 64 bit block ciphers");
        }
        this.f20587IV = new byte[blockCipher.getBlockSize()];
        this.f20592ofbV = new byte[blockCipher.getBlockSize()];
        this.f20591ofbOutV = new byte[blockCipher.getBlockSize()];
    }

    private int bytesToint(byte[] bArr, int i) {
        return ((bArr[i + 3] << 24) & (-16777216)) + ((bArr[i + 2] << 16) & 16711680) + ((bArr[i + 1] << 8) & 65280) + (bArr[i] & C1126UByte.MAX_VALUE);
    }

    private void intTobytes(int i, byte[] bArr, int i2) {
        bArr[i2 + 3] = (byte) (i >>> 24);
        bArr[i2 + 2] = (byte) (i >>> 16);
        bArr[i2 + 1] = (byte) (i >>> 8);
        bArr[i2] = (byte) i;
    }

    @Override // org.bouncycastle.p194crypto.StreamBlockCipher
    public byte calculateByte(byte b) {
        if (this.byteCount == 0) {
            if (this.firstStep) {
                this.firstStep = false;
                this.f20590cipher.processBlock(this.f20592ofbV, 0, this.f20591ofbOutV, 0);
                this.f20588N3 = bytesToint(this.f20591ofbOutV, 0);
                this.f20589N4 = bytesToint(this.f20591ofbOutV, 4);
            }
            int i = this.f20588N3 + 16843009;
            this.f20588N3 = i;
            int i2 = this.f20589N4;
            int i3 = i2 + 16843012;
            this.f20589N4 = i3;
            if (i3 < 16843012 && i3 > 0) {
                this.f20589N4 = i2 + R.attr.format;
            }
            intTobytes(i, this.f20592ofbV, 0);
            intTobytes(this.f20589N4, this.f20592ofbV, 4);
            this.f20590cipher.processBlock(this.f20592ofbV, 0, this.f20591ofbOutV, 0);
        }
        byte[] bArr = this.f20591ofbOutV;
        int i4 = this.byteCount;
        int i5 = i4 + 1;
        this.byteCount = i5;
        byte b2 = (byte) (b ^ bArr[i4]);
        int i6 = this.blockSize;
        if (i5 == i6) {
            this.byteCount = 0;
            byte[] bArr2 = this.f20592ofbV;
            System.arraycopy(bArr2, i6, bArr2, 0, bArr2.length - i6);
            byte[] bArr3 = this.f20591ofbOutV;
            byte[] bArr4 = this.f20592ofbV;
            int length = bArr4.length;
            int i7 = this.blockSize;
            System.arraycopy(bArr3, 0, bArr4, length - i7, i7);
        }
        return b2;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public String getAlgorithmName() {
        return this.f20590cipher.getAlgorithmName() + "/GCTR";
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int getBlockSize() {
        return this.blockSize;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: init */
    public void mo14946init(boolean z, CipherParameters cipherParameters) {
        BlockCipher blockCipher;
        this.firstStep = true;
        this.f20588N3 = 0;
        this.f20589N4 = 0;
        if (cipherParameters instanceof ParametersWithIV) {
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            byte[] bArrM15801getIV = parametersWithIV.m15801getIV();
            int length = bArrM15801getIV.length;
            byte[] bArr = this.f20587IV;
            if (length < bArr.length) {
                System.arraycopy(bArrM15801getIV, 0, bArr, bArr.length - bArrM15801getIV.length, bArrM15801getIV.length);
                int i = 0;
                while (true) {
                    byte[] bArr2 = this.f20587IV;
                    if (i >= bArr2.length - bArrM15801getIV.length) {
                        break;
                    }
                    bArr2[i] = 0;
                    i++;
                }
            } else {
                System.arraycopy(bArrM15801getIV, 0, bArr, 0, bArr.length);
            }
            mo14947reset();
            if (parametersWithIV.getParameters() == null) {
                return;
            }
            blockCipher = this.f20590cipher;
            cipherParameters = parametersWithIV.getParameters();
        } else {
            mo14947reset();
            if (cipherParameters == null) {
                return;
            } else {
                blockCipher = this.f20590cipher;
            }
        }
        blockCipher.mo14946init(true, cipherParameters);
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    public int processBlock(byte[] bArr, int i, byte[] bArr2, int i2) {
        processBytes(bArr, i, this.blockSize, bArr2, i2);
        return this.blockSize;
    }

    @Override // org.bouncycastle.p194crypto.BlockCipher
    /* renamed from: reset */
    public void mo14947reset() {
        this.firstStep = true;
        this.f20588N3 = 0;
        this.f20589N4 = 0;
        byte[] bArr = this.f20587IV;
        System.arraycopy(bArr, 0, this.f20592ofbV, 0, bArr.length);
        this.byteCount = 0;
        this.f20590cipher.mo14947reset();
    }
}
