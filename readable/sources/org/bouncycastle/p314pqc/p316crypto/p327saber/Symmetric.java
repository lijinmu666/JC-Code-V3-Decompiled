package org.bouncycastle.p314pqc.p316crypto.p327saber;

import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.StreamCipher;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p201engines.AESEngine;
import org.bouncycastle.p194crypto.p210modes.SICBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithIV;

/* loaded from: classes2.dex */
abstract class Symmetric {

    public static class AesSymmetric extends Symmetric {
        private final SHA256Digest sha256Digest = new SHA256Digest();
        private final SHA512Digest sha512Digest = new SHA512Digest();

        /* renamed from: cipher */
        private final StreamCipher f23466cipher = SICBlockCipher.newInstance(AESEngine.newInstance());

        @Override // org.bouncycastle.p314pqc.p316crypto.p327saber.Symmetric
        /* renamed from: hash_g */
        public void mo17810hash_g(byte[] bArr, byte[] bArr2) {
            this.sha512Digest.mo14970update(bArr2, 0, bArr2.length);
            this.sha512Digest.mo14967doFinal(bArr, 0);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p327saber.Symmetric
        /* renamed from: hash_h */
        public void mo17811hash_h(byte[] bArr, byte[] bArr2, int i) {
            this.sha256Digest.mo14970update(bArr2, 0, bArr2.length);
            this.sha256Digest.mo14967doFinal(bArr, i);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p327saber.Symmetric
        /* renamed from: prf */
        public void mo17812prf(byte[] bArr, byte[] bArr2, int i, int i2) {
            this.f23466cipher.mo14993init(true, new ParametersWithIV(new KeyParameter(bArr2, 0, i), new byte[16]));
            this.f23466cipher.processBytes(new byte[i2], 0, i2, bArr, 0);
        }
    }

    public static class ShakeSymmetric extends Symmetric {
        private final InterfaceC5284Xof shakeDigest = new SHAKEDigest(128);
        private final SHA3Digest sha3Digest256 = new SHA3Digest(256);
        private final SHA3Digest sha3Digest512 = new SHA3Digest(512);

        @Override // org.bouncycastle.p314pqc.p316crypto.p327saber.Symmetric
        /* renamed from: hash_g */
        public void mo17810hash_g(byte[] bArr, byte[] bArr2) {
            this.sha3Digest512.mo14970update(bArr2, 0, bArr2.length);
            this.sha3Digest512.mo14967doFinal(bArr, 0);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p327saber.Symmetric
        /* renamed from: hash_h */
        public void mo17811hash_h(byte[] bArr, byte[] bArr2, int i) {
            this.sha3Digest256.mo14970update(bArr2, 0, bArr2.length);
            this.sha3Digest256.mo14967doFinal(bArr, i);
        }

        @Override // org.bouncycastle.p314pqc.p316crypto.p327saber.Symmetric
        /* renamed from: prf */
        public void mo17812prf(byte[] bArr, byte[] bArr2, int i, int i2) {
            this.shakeDigest.mo14968reset();
            this.shakeDigest.mo14970update(bArr2, 0, i);
            this.shakeDigest.mo14998doFinal(bArr, 0, i2);
        }
    }

    /* renamed from: hash_g */
    public abstract void mo17810hash_g(byte[] bArr, byte[] bArr2);

    /* renamed from: hash_h */
    public abstract void mo17811hash_h(byte[] bArr, byte[] bArr2, int i);

    /* renamed from: prf */
    public abstract void mo17812prf(byte[] bArr, byte[] bArr2, int i, int i2);
}
