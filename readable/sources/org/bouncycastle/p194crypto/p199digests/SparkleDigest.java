package org.bouncycastle.p194crypto.p199digests;

import com.flyfishxu.p028kadb.p030core.AdbProtocol;
import org.bouncycastle.p194crypto.p199digests.BufferBaseDigest;
import org.bouncycastle.p194crypto.p201engines.SparkleEngine;
import org.bouncycastle.p361util.AbstractC6245Pack;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Integers;
import p094kotlin.p105jvm.internal.ByteCompanionObject;

/* loaded from: classes2.dex */
public class SparkleDigest extends BufferBaseDigest {
    private static final int RATE_WORDS = 4;
    private final int SPARKLE_STEPS_BIG;
    private final int SPARKLE_STEPS_SLIM;
    private final int STATE_WORDS;

    /* renamed from: state */
    private final int[] f19579state;

    /* renamed from: org.bouncycastle.crypto.digests.SparkleDigest$Friend */
    public static class C5297Friend {
        private static final C5297Friend INSTANCE = new C5297Friend();

        private C5297Friend() {
        }
    }

    public enum SparkleParameters {
        ESCH256,
        ESCH384
    }

    public SparkleDigest(SparkleParameters sparkleParameters) {
        super(BufferBaseDigest.ProcessingBufferType.Buffered, 16);
        int iOrdinal = sparkleParameters.ordinal();
        if (iOrdinal == 0) {
            this.algorithmName = "ESCH-256";
            this.DigestSize = 32;
            this.SPARKLE_STEPS_SLIM = 7;
            this.SPARKLE_STEPS_BIG = 11;
            this.STATE_WORDS = 12;
        } else {
            if (iOrdinal != 1) {
                throw new IllegalArgumentException("Invalid definition of SCHWAEMM instance");
            }
            this.algorithmName = "ESCH-384";
            this.DigestSize = 48;
            this.SPARKLE_STEPS_SLIM = 8;
            this.SPARKLE_STEPS_BIG = 12;
            this.STATE_WORDS = 16;
        }
        this.f19579state = new int[this.STATE_WORDS];
    }

    /* renamed from: ELL */
    private static int m15202ELL(int i) {
        return (i & Blake2xsDigest.UNKNOWN_DIGEST_LENGTH) ^ Integers.rotateRight(i, 16);
    }

    private void processBlock(byte[] bArr, int i, int i2) {
        int iLittleEndianToInt = AbstractC6245Pack.littleEndianToInt(bArr, i);
        int iLittleEndianToInt2 = AbstractC6245Pack.littleEndianToInt(bArr, i + 4);
        int iLittleEndianToInt3 = AbstractC6245Pack.littleEndianToInt(bArr, i + 8);
        int iLittleEndianToInt4 = AbstractC6245Pack.littleEndianToInt(bArr, i + 12);
        int iM15202ELL = m15202ELL(iLittleEndianToInt ^ iLittleEndianToInt3);
        int iM15202ELL2 = m15202ELL(iLittleEndianToInt2 ^ iLittleEndianToInt4);
        int[] iArr = this.f19579state;
        iArr[0] = (iLittleEndianToInt ^ iM15202ELL2) ^ iArr[0];
        iArr[1] = (iLittleEndianToInt2 ^ iM15202ELL) ^ iArr[1];
        iArr[2] = iArr[2] ^ (iLittleEndianToInt3 ^ iM15202ELL2);
        iArr[3] = (iLittleEndianToInt4 ^ iM15202ELL) ^ iArr[3];
        iArr[4] = iArr[4] ^ iM15202ELL2;
        iArr[5] = iArr[5] ^ iM15202ELL;
        if (this.STATE_WORDS != 16) {
            SparkleEngine.sparkle_opt12(C5297Friend.INSTANCE, this.f19579state, i2);
            return;
        }
        iArr[6] = iArr[6] ^ iM15202ELL2;
        iArr[7] = iM15202ELL ^ iArr[7];
        SparkleEngine.sparkle_opt16(C5297Friend.INSTANCE, this.f19579state, i2);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: doFinal */
    public /* bridge */ /* synthetic */ int mo14967doFinal(byte[] bArr, int i) {
        return super.mo14967doFinal(bArr, i);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest
    /* renamed from: finish */
    public void mo15038finish(byte[] bArr, int i) {
        int i2 = this.m_bufPos;
        int i3 = this.BlockSize;
        if (i2 < i3) {
            int[] iArr = this.f19579state;
            int i4 = (this.STATE_WORDS >> 1) - 1;
            iArr[i4] = iArr[i4] ^ 16777216;
            byte[] bArr2 = this.f19336m_buf;
            int i5 = i2 + 1;
            this.m_bufPos = i5;
            bArr2[i2] = ByteCompanionObject.MIN_VALUE;
            C6238Arrays.m18250fill(bArr2, i5, i3, (byte) 0);
        } else {
            int[] iArr2 = this.f19579state;
            int i6 = (this.STATE_WORDS >> 1) - 1;
            iArr2[i6] = iArr2[i6] ^ AdbProtocol.INITIAL_DELAYED_ACK_BYTES;
        }
        processBlock(this.f19336m_buf, 0, this.SPARKLE_STEPS_BIG);
        AbstractC6245Pack.intToLittleEndian(this.f19579state, 0, 4, bArr, i);
        if (this.STATE_WORDS != 16) {
            SparkleEngine.sparkle_opt12(C5297Friend.INSTANCE, this.f19579state, this.SPARKLE_STEPS_SLIM);
            AbstractC6245Pack.intToLittleEndian(this.f19579state, 0, 4, bArr, i + 16);
        } else {
            SparkleEngine.sparkle_opt16(C5297Friend.INSTANCE, this.f19579state, this.SPARKLE_STEPS_SLIM);
            AbstractC6245Pack.intToLittleEndian(this.f19579state, 0, 4, bArr, i + 16);
            SparkleEngine.sparkle_opt16(C5297Friend.INSTANCE, this.f19579state, this.SPARKLE_STEPS_SLIM);
            AbstractC6245Pack.intToLittleEndian(this.f19579state, 0, 4, bArr, i + 32);
        }
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public /* bridge */ /* synthetic */ String getAlgorithmName() {
        return super.getAlgorithmName();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.ExtendedDigest
    public /* bridge */ /* synthetic */ int getByteLength() {
        return super.getByteLength();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    public /* bridge */ /* synthetic */ int getDigestSize() {
        return super.getDigestSize();
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest
    public void processBytes(byte[] bArr, int i) {
        processBlock(bArr, i, this.SPARKLE_STEPS_SLIM);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: reset */
    public void mo14968reset() {
        super.mo14968reset();
        C6238Arrays.m18253fill(this.f19579state, 0);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14969update(byte b) {
        super.mo14969update(b);
    }

    @Override // org.bouncycastle.p194crypto.p199digests.BufferBaseDigest, org.bouncycastle.p194crypto.InterfaceC5277Digest
    /* renamed from: update */
    public /* bridge */ /* synthetic */ void mo14970update(byte[] bArr, int i, int i2) {
        super.mo14970update(bArr, i, i2);
    }
}
