package org.bouncycastle.p194crypto.p209macs;

import org.bouncycastle.p194crypto.CipherParameters;
import org.bouncycastle.p194crypto.InterfaceC5278Mac;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p361util.AbstractC6245Pack;

/* renamed from: org.bouncycastle.crypto.macs.SipHash */
/* loaded from: classes2.dex */
public class C5364SipHash implements InterfaceC5278Mac {

    /* renamed from: c */
    protected final int f20490c;

    /* renamed from: d */
    protected final int f20491d;

    /* renamed from: k0 */
    protected long f20492k0;

    /* renamed from: k1 */
    protected long f20493k1;

    /* renamed from: m */
    protected long f20494m;

    /* renamed from: v0 */
    protected long f20495v0;

    /* renamed from: v1 */
    protected long f20496v1;

    /* renamed from: v2 */
    protected long f20497v2;

    /* renamed from: v3 */
    protected long f20498v3;
    protected int wordCount;

    /* renamed from: wordPos */
    protected int f20499wordPos;

    public C5364SipHash() {
        this.f20494m = 0L;
        this.f20499wordPos = 0;
        this.wordCount = 0;
        this.f20490c = 2;
        this.f20491d = 4;
    }

    public static long rotateLeft(long j, int i) {
        return (j >>> (-i)) | (j << i);
    }

    public void applySipRounds(int i) {
        long jRotateLeft = this.f20495v0;
        long jRotateLeft2 = this.f20496v1;
        long jRotateLeft3 = this.f20497v2;
        long jRotateLeft4 = this.f20498v3;
        for (int i2 = 0; i2 < i; i2++) {
            long j = jRotateLeft + jRotateLeft2;
            long j2 = jRotateLeft3 + jRotateLeft4;
            long jRotateLeft5 = rotateLeft(jRotateLeft2, 13) ^ j;
            long jRotateLeft6 = rotateLeft(jRotateLeft4, 16) ^ j2;
            long j3 = j2 + jRotateLeft5;
            jRotateLeft = rotateLeft(j, 32) + jRotateLeft6;
            jRotateLeft2 = rotateLeft(jRotateLeft5, 17) ^ j3;
            jRotateLeft4 = rotateLeft(jRotateLeft6, 21) ^ jRotateLeft;
            jRotateLeft3 = rotateLeft(j3, 32);
        }
        this.f20495v0 = jRotateLeft;
        this.f20496v1 = jRotateLeft2;
        this.f20497v2 = jRotateLeft3;
        this.f20498v3 = jRotateLeft4;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: doFinal */
    public int mo14975doFinal(byte[] bArr, int i) {
        AbstractC6245Pack.longToLittleEndian(mo15592doFinal(), bArr, i);
        return 8;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public String getAlgorithmName() {
        return "SipHash-" + this.f20490c + "-" + this.f20491d;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    public int getMacSize() {
        return 8;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: init */
    public void mo14976init(CipherParameters cipherParameters) {
        if (!(cipherParameters instanceof KeyParameter)) {
            throw new IllegalArgumentException("'params' must be an instance of KeyParameter");
        }
        byte[] bArrM15773getKey = ((KeyParameter) cipherParameters).m15773getKey();
        if (bArrM15773getKey.length != 16) {
            throw new IllegalArgumentException("'params' must be a 128-bit key");
        }
        this.f20492k0 = AbstractC6245Pack.littleEndianToLong(bArrM15773getKey, 0);
        this.f20493k1 = AbstractC6245Pack.littleEndianToLong(bArrM15773getKey, 8);
        mo14977reset();
    }

    public void processMessageWord() {
        this.wordCount++;
        this.f20498v3 ^= this.f20494m;
        applySipRounds(this.f20490c);
        this.f20495v0 ^= this.f20494m;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: reset */
    public void mo14977reset() {
        long j = this.f20492k0;
        this.f20495v0 = 8317987319222330741L ^ j;
        long j2 = this.f20493k1;
        this.f20496v1 = 7237128888997146477L ^ j2;
        this.f20497v2 = j ^ 7816392313619706465L;
        this.f20498v3 = 8387220255154660723L ^ j2;
        this.f20494m = 0L;
        this.f20499wordPos = 0;
        this.wordCount = 0;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14978update(byte b) {
        this.f20494m = (this.f20494m >>> 8) | ((b & 255) << 56);
        int i = this.f20499wordPos + 1;
        this.f20499wordPos = i;
        if (i == 8) {
            processMessageWord();
            this.f20499wordPos = 0;
        }
    }

    public C5364SipHash(int i, int i2) {
        this.f20494m = 0L;
        this.f20499wordPos = 0;
        this.wordCount = 0;
        this.f20490c = i;
        this.f20491d = i2;
    }

    /* renamed from: doFinal */
    public long mo15592doFinal() {
        this.f20494m = ((this.f20494m >>> ((7 - this.f20499wordPos) << 3)) >>> 8) | ((((this.wordCount << 3) + r2) & 255) << 56);
        processMessageWord();
        this.f20497v2 ^= 255;
        applySipRounds(this.f20491d);
        long j = ((this.f20495v0 ^ this.f20496v1) ^ this.f20497v2) ^ this.f20498v3;
        mo14977reset();
        return j;
    }

    @Override // org.bouncycastle.p194crypto.InterfaceC5278Mac
    /* renamed from: update */
    public void mo14979update(byte[] bArr, int i, int i2) {
        int i3 = i2 & (-8);
        int i4 = this.f20499wordPos;
        int i5 = 0;
        if (i4 == 0) {
            while (i5 < i3) {
                this.f20494m = AbstractC6245Pack.littleEndianToLong(bArr, i + i5);
                processMessageWord();
                i5 += 8;
            }
            while (i5 < i2) {
                long j = this.f20494m >>> 8;
                this.f20494m = j;
                this.f20494m = j | ((bArr[i + i5] & 255) << 56);
                i5++;
            }
            this.f20499wordPos = i2 - i3;
            return;
        }
        int i6 = i4 << 3;
        int i7 = 0;
        while (i7 < i3) {
            long jLittleEndianToLong = AbstractC6245Pack.littleEndianToLong(bArr, i + i7);
            this.f20494m = (this.f20494m >>> (-i6)) | (jLittleEndianToLong << i6);
            processMessageWord();
            this.f20494m = jLittleEndianToLong;
            i7 += 8;
        }
        while (i7 < i2) {
            long j2 = this.f20494m >>> 8;
            this.f20494m = j2;
            this.f20494m = j2 | ((bArr[i + i7] & 255) << 56);
            int i8 = this.f20499wordPos + 1;
            this.f20499wordPos = i8;
            if (i8 == 8) {
                processMessageWord();
                this.f20499wordPos = 0;
            }
            i7++;
        }
    }
}
