package org.bouncycastle.p314pqc.p316crypto.p323mldsa;

import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;

/* loaded from: classes2.dex */
abstract class Symmetric {
    final int stream128BlockBytes;
    final int stream256BlockBytes;

    public static class ShakeSymmetric extends Symmetric {
        private final SHAKEDigest digest128;
        private final SHAKEDigest digest256;

        public ShakeSymmetric() {
            super(168, 136);
            this.digest128 = new SHAKEDigest(128);
            this.digest256 = new SHAKEDigest(256);
        }

        private void streamInit(SHAKEDigest sHAKEDigest, byte[] bArr, short s) {
            sHAKEDigest.mo14968reset();
            sHAKEDigest.mo14970update(bArr, 0, bArr.length);
            sHAKEDigest.mo14970update(new byte[]{(byte) s, (byte) (s >> 8)}, 0, 2);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p323mldsa.Symmetric
        public void stream128init(byte[] bArr, short s) {
            streamInit(this.digest128, bArr, s);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p323mldsa.Symmetric
        public void stream128squeezeBlocks(byte[] bArr, int i, int i2) {
            this.digest128.doOutput(bArr, i, i2);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p323mldsa.Symmetric
        public void stream256init(byte[] bArr, short s) {
            streamInit(this.digest256, bArr, s);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p323mldsa.Symmetric
        public void stream256squeezeBlocks(byte[] bArr, int i, int i2) {
            this.digest256.doOutput(bArr, i, i2);
        }
    }

    public Symmetric(int i, int i2) {
        this.stream128BlockBytes = i;
        this.stream256BlockBytes = i2;
    }

    public abstract void stream128init(byte[] bArr, short s);

    public abstract void stream128squeezeBlocks(byte[] bArr, int i, int i2);

    public abstract void stream256init(byte[] bArr, short s);

    public abstract void stream256squeezeBlocks(byte[] bArr, int i, int i2);
}
