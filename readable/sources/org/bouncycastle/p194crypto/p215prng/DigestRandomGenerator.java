package org.bouncycastle.p194crypto.p215prng;

import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DigestRandomGenerator implements RandomGenerator {
    private static long CYCLE_COUNT = 10;

    /* renamed from: digest */
    private InterfaceC5277Digest f20873digest;

    /* renamed from: seed */
    private byte[] f20874seed;

    /* renamed from: state */
    private byte[] f20875state;
    private long seedCounter = 1;
    private long stateCounter = 1;

    public DigestRandomGenerator(InterfaceC5277Digest interfaceC5277Digest) {
        this.f20873digest = interfaceC5277Digest;
        this.f20874seed = new byte[interfaceC5277Digest.getDigestSize()];
        this.f20875state = new byte[interfaceC5277Digest.getDigestSize()];
    }

    private void cycleSeed() {
        digestUpdate(this.f20874seed);
        long j = this.seedCounter;
        this.seedCounter = 1 + j;
        digestAddCounter(j);
        digestDoFinal(this.f20874seed);
    }

    private void digestAddCounter(long j) {
        for (int i = 0; i != 8; i++) {
            this.f20873digest.mo14969update((byte) j);
            j >>>= 8;
        }
    }

    private void digestDoFinal(byte[] bArr) {
        this.f20873digest.mo14967doFinal(bArr, 0);
    }

    private void digestUpdate(byte[] bArr) {
        this.f20873digest.mo14970update(bArr, 0, bArr.length);
    }

    private void generateState() {
        long j = this.stateCounter;
        this.stateCounter = 1 + j;
        digestAddCounter(j);
        digestUpdate(this.f20875state);
        digestUpdate(this.f20874seed);
        digestDoFinal(this.f20875state);
        if (this.stateCounter % CYCLE_COUNT == 0) {
            cycleSeed();
        }
    }

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void addSeedMaterial(long j) {
        synchronized (this) {
            digestAddCounter(j);
            digestUpdate(this.f20874seed);
            digestDoFinal(this.f20874seed);
        }
    }

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void nextBytes(byte[] bArr) {
        nextBytes(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void addSeedMaterial(byte[] bArr) {
        synchronized (this) {
            try {
                if (!C6238Arrays.isNullOrEmpty(bArr)) {
                    digestUpdate(bArr);
                }
                digestUpdate(this.f20874seed);
                digestDoFinal(this.f20874seed);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void nextBytes(byte[] bArr, int i, int i2) {
        synchronized (this) {
            try {
                generateState();
                int i3 = i2 + i;
                int i4 = 0;
                while (i != i3) {
                    if (i4 == this.f20875state.length) {
                        generateState();
                        i4 = 0;
                    }
                    bArr[i] = this.f20875state[i4];
                    i++;
                    i4++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
