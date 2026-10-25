package org.bouncycastle.p194crypto.p201engines;

import org.bouncycastle.p361util.Memoable;
import p094kotlin.C1126UByte;
import p132okio.C5066Utf8;

/* loaded from: classes2.dex */
public class Zuc256CoreEngine extends Zuc128CoreEngine {

    /* renamed from: theD */
    private byte[] f20179theD;

    /* renamed from: EK_d */
    private static final byte[] f20175EK_d = {34, 47, 36, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, 48};

    /* renamed from: EK_d32 */
    private static final byte[] f20177EK_d32 = {34, 47, 37, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, 48};

    /* renamed from: EK_d64 */
    private static final byte[] f20178EK_d64 = {35, 47, 36, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, 48};

    /* renamed from: EK_d128 */
    private static final byte[] f20176EK_d128 = {35, 47, 37, 42, 109, 64, 64, 64, 64, 64, 64, 64, 64, 82, 16, 48};

    public Zuc256CoreEngine() {
        this.f20179theD = f20175EK_d;
    }

    /* renamed from: MAKEU31 */
    private static int m15463MAKEU31(byte b, byte b2, byte b3, byte b4) {
        return ((b & C1126UByte.MAX_VALUE) << 23) | ((b2 & C1126UByte.MAX_VALUE) << 16) | ((b3 & C1126UByte.MAX_VALUE) << 8) | (b4 & C1126UByte.MAX_VALUE);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Zuc128CoreEngine, org.bouncycastle.p361util.Memoable
    /* renamed from: copy */
    public Memoable mo14823copy() {
        return new Zuc256CoreEngine(this);
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Zuc128CoreEngine, org.bouncycastle.p194crypto.StreamCipher
    public String getAlgorithmName() {
        return "Zuc-256";
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Zuc128CoreEngine
    public int getMaxIterations() {
        return 625;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Zuc128CoreEngine, org.bouncycastle.p361util.Memoable
    /* renamed from: reset */
    public void mo14824reset(Memoable memoable) {
        super.mo14824reset(memoable);
        this.f20179theD = ((Zuc256CoreEngine) memoable).f20179theD;
    }

    @Override // org.bouncycastle.p194crypto.p201engines.Zuc128CoreEngine
    public void setKeyAndIV(int[] iArr, byte[] bArr, byte[] bArr2) {
        if (bArr == null || bArr.length != 32) {
            throw new IllegalArgumentException("A key of 32 bytes is needed");
        }
        if (bArr2 == null || bArr2.length != 25) {
            throw new IllegalArgumentException("An IV of 25 bytes is needed");
        }
        iArr[0] = m15463MAKEU31(bArr[0], this.f20179theD[0], bArr[21], bArr[16]);
        iArr[1] = m15463MAKEU31(bArr[1], this.f20179theD[1], bArr[22], bArr[17]);
        iArr[2] = m15463MAKEU31(bArr[2], this.f20179theD[2], bArr[23], bArr[18]);
        iArr[3] = m15463MAKEU31(bArr[3], this.f20179theD[3], bArr[24], bArr[19]);
        iArr[4] = m15463MAKEU31(bArr[4], this.f20179theD[4], bArr[25], bArr[20]);
        iArr[5] = m15463MAKEU31(bArr2[0], (byte) (this.f20179theD[5] | (bArr2[17] & C5066Utf8.REPLACEMENT_BYTE)), bArr[5], bArr[26]);
        iArr[6] = m15463MAKEU31(bArr2[1], (byte) (this.f20179theD[6] | (bArr2[18] & C5066Utf8.REPLACEMENT_BYTE)), bArr[6], bArr[27]);
        iArr[7] = m15463MAKEU31(bArr2[10], (byte) (this.f20179theD[7] | (bArr2[19] & C5066Utf8.REPLACEMENT_BYTE)), bArr[7], bArr2[2]);
        iArr[8] = m15463MAKEU31(bArr[8], (byte) (this.f20179theD[8] | (bArr2[20] & C5066Utf8.REPLACEMENT_BYTE)), bArr2[3], bArr2[11]);
        iArr[9] = m15463MAKEU31(bArr[9], (byte) ((bArr2[21] & C5066Utf8.REPLACEMENT_BYTE) | this.f20179theD[9]), bArr2[12], bArr2[4]);
        iArr[10] = m15463MAKEU31(bArr2[5], (byte) (this.f20179theD[10] | (bArr2[22] & C5066Utf8.REPLACEMENT_BYTE)), bArr[10], bArr[28]);
        iArr[11] = m15463MAKEU31(bArr[11], (byte) (this.f20179theD[11] | (bArr2[23] & C5066Utf8.REPLACEMENT_BYTE)), bArr2[6], bArr2[13]);
        iArr[12] = m15463MAKEU31(bArr[12], (byte) (this.f20179theD[12] | (bArr2[24] & C5066Utf8.REPLACEMENT_BYTE)), bArr2[7], bArr2[14]);
        iArr[13] = m15463MAKEU31(bArr[13], this.f20179theD[13], bArr2[15], bArr2[8]);
        iArr[14] = m15463MAKEU31(bArr[14], (byte) (this.f20179theD[14] | ((bArr[31] >>> 4) & 15)), bArr2[16], bArr2[9]);
        iArr[15] = m15463MAKEU31(bArr[15], (byte) (this.f20179theD[15] | (bArr[31] & 15)), bArr[30], bArr[29]);
    }

    public Zuc256CoreEngine(int i) {
        if (i == 32) {
            this.f20179theD = f20177EK_d32;
            return;
        }
        if (i == 64) {
            this.f20179theD = f20178EK_d64;
        } else {
            if (i == 128) {
                this.f20179theD = f20176EK_d128;
                return;
            }
            throw new IllegalArgumentException("Unsupported length: " + i);
        }
    }

    public Zuc256CoreEngine(Zuc256CoreEngine zuc256CoreEngine) {
        super(zuc256CoreEngine);
    }
}
