package org.bouncycastle.p314pqc.p316crypto.crystals.dilithium;

import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p210modes.SICBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;

/* loaded from: classes2.dex */
abstract class Symmetric {
    final int stream128BlockBytes;
    final int stream256BlockBytes;

    @Deprecated
    public static class AesSymmetric extends Symmetric {

        /* renamed from: cipher */
        private final StreamCipher f23107cipher;

        public AesSymmetric() {
            super(64, 64);
            this.f23107cipher = SICBlockCipher.newInstance(AESEngine.newInstance());
        }

        /* renamed from: aes128 */
        private void m17538aes128(byte[] bArr, int i, int i2) {
            this.f23107cipher.processBytes(new byte[i2], 0, i2, bArr, i);
        }

        private void streamInit(byte[] bArr, short s) {
            byte[] bArr2 = new byte[12];
            bArr2[0] = (byte) s;
            bArr2[1] = (byte) (s >> 8);
            this.f23107cipher.mo14993init(true, new ParametersWithIV(new KeyParameter(bArr, 0, 32), bArr2));
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.Symmetric
        public void stream128init(byte[] bArr, short s) {
            streamInit(bArr, s);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.Symmetric
        public void stream128squeezeBlocks(byte[] bArr, int i, int i2) {
            m17538aes128(bArr, i, i2);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.Symmetric
        public void stream256init(byte[] bArr, short s) {
            streamInit(bArr, s);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.Symmetric
        public void stream256squeezeBlocks(byte[] bArr, int i, int i2) {
            m17538aes128(bArr, i, i2);
        }
    }

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

        @Override // org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.Symmetric
        public void stream128init(byte[] bArr, short s) {
            streamInit(this.digest128, bArr, s);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.Symmetric
        public void stream128squeezeBlocks(byte[] bArr, int i, int i2) {
            this.digest128.doOutput(bArr, i, i2);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.Symmetric
        public void stream256init(byte[] bArr, short s) {
            streamInit(this.digest256, bArr, s);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.crystals.dilithium.Symmetric
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
