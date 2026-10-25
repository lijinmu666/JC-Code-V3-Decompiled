package org.bouncycastle.p194crypto.p215prng;

/* loaded from: classes2.dex */
public class ThreadedSeedGenerator {

    public static class SeedGenerator implements Runnable {

        /* renamed from: counter */
        private volatile int f20887counter;

        /* renamed from: stop */
        private volatile boolean f20888stop;

        private SeedGenerator() {
            this.f20887counter = 0;
            this.f20888stop = false;
        }

        public byte[] generateSeed(int i, boolean z) throws InterruptedException {
            Thread thread = new Thread(this);
            byte[] bArr = new byte[i];
            this.f20887counter = 0;
            this.f20888stop = false;
            thread.start();
            if (!z) {
                i *= 8;
            }
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                while (this.f20887counter == i2) {
                    try {
                        Thread.sleep(1L);
                    } catch (InterruptedException unused) {
                    }
                }
                i2 = this.f20887counter;
                if (z) {
                    bArr[i3] = (byte) (i2 & 255);
                } else {
                    int i4 = i3 / 8;
                    bArr[i4] = (byte) ((bArr[i4] << 1) | (i2 & 1));
                }
            }
            this.f20888stop = true;
            return bArr;
        }

        @Override // java.lang.Runnable
        public void run() {
            while (!this.f20888stop) {
                this.f20887counter++;
            }
        }
    }

    public byte[] generateSeed(int i, boolean z) {
        return new SeedGenerator().generateSeed(i, z);
    }
}
