package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p133asn1.p137cmc.BodyPartID;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.OutputLengthException;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* loaded from: classes2.dex */
public class Poly1305 implements InterfaceC5278Mac {
    private static final int BLOCK_SIZE = 16;

    /* renamed from: cipher */
    private final BlockCipher f20471cipher;
    private final byte[] currentBlock;
    private int currentBlockOffset;

    /* renamed from: h0 */
    private int f20472h0;

    /* renamed from: h1 */
    private int f20473h1;

    /* renamed from: h2 */
    private int f20474h2;

    /* renamed from: h3 */
    private int f20475h3;

    /* renamed from: h4 */
    private int f20476h4;

    /* renamed from: k0 */
    private int f20477k0;

    /* renamed from: k1 */
    private int f20478k1;

    /* renamed from: k2 */
    private int f20479k2;

    /* renamed from: k3 */
    private int f20480k3;

    /* renamed from: r0 */
    private int f20481r0;

    /* renamed from: r1 */
    private int f20482r1;

    /* renamed from: r2 */
    private int f20483r2;

    /* renamed from: r3 */
    private int f20484r3;

    /* renamed from: r4 */
    private int f20485r4;

    /* renamed from: s1 */
    private int f20486s1;

    /* renamed from: s2 */
    private int f20487s2;

    /* renamed from: s3 */
    private int f20488s3;

    /* renamed from: s4 */
    private int f20489s4;
    private final byte[] singleByte;

    public Poly1305() {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        this.f20471cipher = null;
    }

    private static final long mul32x32_64(int i, int i2) {
        return (i & BodyPartID.bodyIdMax) * i2;
    }

    private void processBlock() {
        int i = this.currentBlockOffset;
        if (i < 16) {
            this.currentBlock[i] = 1;
            for (int i2 = i + 1; i2 < 16; i2++) {
                this.currentBlock[i2] = 0;
            }
        }
        long jLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(this.currentBlock, 0);
        long j = jLittleEndianToInt & BodyPartID.bodyIdMax;
        long jLittleEndianToInt2 = AbstractC6245Pack.littleEndianToInt(this.currentBlock, 4) & BodyPartID.bodyIdMax;
        long jLittleEndianToInt3 = AbstractC6245Pack.littleEndianToInt(this.currentBlock, 8) & BodyPartID.bodyIdMax;
        long jLittleEndianToInt4 = BodyPartID.bodyIdMax & AbstractC6245Pack.littleEndianToInt(this.currentBlock, 12);
        int i3 = (int) (this.f20472h0 + (jLittleEndianToInt & 67108863));
        this.f20472h0 = i3;
        this.f20473h1 = (int) (this.f20473h1 + ((((jLittleEndianToInt2 << 32) | j) >>> 26) & 67108863));
        this.f20474h2 = (int) (this.f20474h2 + (((jLittleEndianToInt2 | (jLittleEndianToInt3 << 32)) >>> 20) & 67108863));
        this.f20475h3 = (int) (this.f20475h3 + ((((jLittleEndianToInt4 << 32) | jLittleEndianToInt3) >>> 14) & 67108863));
        int i4 = (int) (this.f20476h4 + (jLittleEndianToInt4 >>> 8));
        this.f20476h4 = i4;
        if (this.currentBlockOffset == 16) {
            this.f20476h4 = i4 + 16777216;
        }
        long jMul32x32_64 = mul32x32_64(i3, this.f20481r0) + mul32x32_64(this.f20473h1, this.f20489s4) + mul32x32_64(this.f20474h2, this.f20488s3) + mul32x32_64(this.f20475h3, this.f20487s2) + mul32x32_64(this.f20476h4, this.f20486s1);
        long jMul32x32_642 = mul32x32_64(this.f20472h0, this.f20482r1) + mul32x32_64(this.f20473h1, this.f20481r0) + mul32x32_64(this.f20474h2, this.f20489s4) + mul32x32_64(this.f20475h3, this.f20488s3) + mul32x32_64(this.f20476h4, this.f20487s2);
        long jMul32x32_643 = mul32x32_64(this.f20472h0, this.f20483r2) + mul32x32_64(this.f20473h1, this.f20482r1) + mul32x32_64(this.f20474h2, this.f20481r0) + mul32x32_64(this.f20475h3, this.f20489s4) + mul32x32_64(this.f20476h4, this.f20488s3);
        long jMul32x32_644 = mul32x32_64(this.f20472h0, this.f20484r3) + mul32x32_64(this.f20473h1, this.f20483r2) + mul32x32_64(this.f20474h2, this.f20482r1) + mul32x32_64(this.f20475h3, this.f20481r0) + mul32x32_64(this.f20476h4, this.f20489s4);
        long jMul32x32_645 = mul32x32_64(this.f20472h0, this.f20485r4) + mul32x32_64(this.f20473h1, this.f20484r3) + mul32x32_64(this.f20474h2, this.f20483r2) + mul32x32_64(this.f20475h3, this.f20482r1) + mul32x32_64(this.f20476h4, this.f20481r0);
        long j2 = jMul32x32_642 + (jMul32x32_64 >>> 26);
        long j3 = jMul32x32_643 + (j2 >>> 26);
        this.f20474h2 = ((int) j3) & 67108863;
        long j4 = jMul32x32_644 + (j3 >>> 26);
        this.f20475h3 = ((int) j4) & 67108863;
        long j5 = jMul32x32_645 + (j4 >>> 26);
        this.f20476h4 = ((int) j5) & 67108863;
        int i5 = (((int) jMul32x32_64) & 67108863) + (((int) (j5 >>> 26)) * 5);
        this.f20473h1 = (((int) j2) & 67108863) + (i5 >>> 26);
        this.f20472h0 = i5 & 67108863;
    }

    /* renamed from: setKey */
    private void m15591setKey(byte[] bArr, byte[] bArr2) {
        if (bArr.length != 32) {
            throw new IllegalArgumentException("Poly1305 key must be 256 bits.");
        }
        int i = 16;
        if (this.f20471cipher != null && (bArr2 == null || bArr2.length != 16)) {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit IV.");
        }
        int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, 0);
        int iLittleEndianToInt2 = AbstractC6245Pack.littleEndianToInt(bArr, 4);
        int iLittleEndianToInt3 = AbstractC6245Pack.littleEndianToInt(bArr, 8);
        int iLittleEndianToInt4 = AbstractC6245Pack.littleEndianToInt(bArr, 12);
        this.f20481r0 = 67108863 & iLittleEndianToInt;
        int i2 = ((iLittleEndianToInt >>> 26) | (iLittleEndianToInt2 << 6)) & 67108611;
        this.f20482r1 = i2;
        int i3 = ((iLittleEndianToInt2 >>> 20) | (iLittleEndianToInt3 << 12)) & 67092735;
        this.f20483r2 = i3;
        int i4 = ((iLittleEndianToInt3 >>> 14) | (iLittleEndianToInt4 << 18)) & 66076671;
        this.f20484r3 = i4;
        int i5 = (iLittleEndianToInt4 >>> 8) & 1048575;
        this.f20485r4 = i5;
        this.f20486s1 = i2 * 5;
        this.f20487s2 = i3 * 5;
        this.f20488s3 = i4 * 5;
        this.f20489s4 = i5 * 5;
        BlockCipher blockCipher = this.f20471cipher;
        if (blockCipher != null) {
            byte[] bArr3 = new byte[16];
            blockCipher.mo14946init(true, new KeyParameter(bArr, 16, 16));
            this.f20471cipher.processBlock(bArr2, 0, bArr3, 0);
            i = 0;
            bArr = bArr3;
        }
        this.f20477k0 = AbstractC6245Pack.littleEndianToInt(bArr, i);
        this.f20478k1 = AbstractC6245Pack.littleEndianToInt(bArr, i + 4);
        this.f20479k2 = AbstractC6245Pack.littleEndianToInt(bArr, i + 8);
        this.f20480k3 = AbstractC6245Pack.littleEndianToInt(bArr, i + 12);
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        if (i + 16 > bArr.length) {
            throw new OutputLengthException("Output buffer is too short.");
        }
        if (this.currentBlockOffset > 0) {
            processBlock();
        }
        int i2 = this.f20473h1;
        int i3 = this.f20472h0;
        int i4 = i2 + (i3 >>> 26);
        int i5 = this.f20474h2 + (i4 >>> 26);
        int i6 = this.f20475h3 + (i5 >>> 26);
        int i7 = i5 & 67108863;
        int i8 = this.f20476h4 + (i6 >>> 26);
        int i9 = i6 & 67108863;
        int i10 = (i3 & 67108863) + ((i8 >>> 26) * 5);
        int i11 = i8 & 67108863;
        int i12 = (i4 & 67108863) + (i10 >>> 26);
        int i13 = i10 & 67108863;
        int i14 = i13 + 5;
        int i15 = (i14 >>> 26) + i12;
        int i16 = (i15 >>> 26) + i7;
        int i17 = (i16 >>> 26) + i9;
        int i18 = 67108863 & i17;
        int i19 = ((i17 >>> 26) + i11) - 67108864;
        int i20 = (i19 >>> 31) - 1;
        int i21 = ~i20;
        this.f20472h0 = (i13 & i21) | (i14 & 67108863 & i20);
        this.f20473h1 = (i12 & i21) | (i15 & 67108863 & i20);
        this.f20474h2 = (i7 & i21) | (i16 & 67108863 & i20);
        this.f20475h3 = (i18 & i20) | (i9 & i21);
        this.f20476h4 = (i11 & i21) | (i19 & i20);
        long j = ((r1 | (r0 << 26)) & BodyPartID.bodyIdMax) + (this.f20477k0 & BodyPartID.bodyIdMax);
        long j2 = (((r0 >>> 6) | (r3 << 20)) & BodyPartID.bodyIdMax) + (this.f20478k1 & BodyPartID.bodyIdMax);
        long j3 = (((r3 >>> 12) | (r2 << 14)) & BodyPartID.bodyIdMax) + (this.f20479k2 & BodyPartID.bodyIdMax);
        long j4 = (((r2 >>> 18) | (r4 << 8)) & BodyPartID.bodyIdMax) + (BodyPartID.bodyIdMax & this.f20480k3);
        AbstractC6245Pack.intToLittleEndian((int) j, bArr, i);
        long j5 = j2 + (j >>> 32);
        AbstractC6245Pack.intToLittleEndian((int) j5, bArr, i + 4);
        long j6 = j3 + (j5 >>> 32);
        AbstractC6245Pack.intToLittleEndian((int) j6, bArr, i + 8);
        AbstractC6245Pack.intToLittleEndian((int) (j4 + (j6 >>> 32)), bArr, i + 12);
        mo14977reset();
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        if (this.f20471cipher == null) {
            return "Poly1305";
        }
        return "Poly1305-" + this.f20471cipher.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return 16;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        byte[] bArrM15801getIV;
        if (this.f20471cipher == null) {
            bArrM15801getIV = null;
        } else {
            if (!(cipherParameters instanceof ParametersWithIV)) {
                throw new IllegalArgumentException("Poly1305 requires an IV when used with a block cipher.");
            }
            ParametersWithIV parametersWithIV = (ParametersWithIV) cipherParameters;
            bArrM15801getIV = parametersWithIV.m15801getIV();
            cipherParameters = parametersWithIV.getParameters();
        }
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("Poly1305 requires a key.");
        }
        m15591setKey(((KeyParameter) cipherParameters).m15773getKey(), bArrM15801getIV);
        mo14977reset();
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        this.currentBlockOffset = 0;
        this.f20476h4 = 0;
        this.f20475h3 = 0;
        this.f20474h2 = 0;
        this.f20473h1 = 0;
        this.f20472h0 = 0;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        byte[] bArr = this.singleByte;
        bArr[0] = b;
        mo14979update(bArr, 0, 1);
    }

    public Poly1305(BlockCipher blockCipher) {
        this.singleByte = new byte[1];
        this.currentBlock = new byte[16];
        this.currentBlockOffset = 0;
        if (blockCipher.getBlockSize() != 16) {
            throw new IllegalArgumentException("Poly1305 requires a 128 bit block cipher.");
        }
        this.f20471cipher = blockCipher;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        int i3 = 0;
        while (i2 > i3) {
            if (this.currentBlockOffset == 16) {
                processBlock();
                this.currentBlockOffset = 0;
            }
            int iMin = Math.min(i2 - i3, 16 - this.currentBlockOffset);
            System.arraycopy(bArr, i3 + i, this.currentBlock, this.currentBlockOffset, iMin);
            i3 += iMin;
            this.currentBlockOffset += iMin;
        }
    }
}
