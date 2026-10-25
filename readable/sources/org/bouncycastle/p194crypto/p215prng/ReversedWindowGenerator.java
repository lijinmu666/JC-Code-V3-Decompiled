package org.bouncycastle.p194crypto.p215prng;

/* loaded from: classes2.dex */
public class ReversedWindowGenerator implements RandomGenerator {
    private final RandomGenerator generator;

    /* renamed from: window */
    private byte[] f20879window;
    private int windowCount;

    public ReversedWindowGenerator(RandomGenerator randomGenerator, int i) {
        if (randomGenerator == null) {
            throw new IllegalArgumentException("generator cannot be null");
        }
        if (i < 2) {
            throw new IllegalArgumentException("windowSize must be at least 2");
        }
        this.generator = randomGenerator;
        this.f20879window = new byte[i];
    }

    private void doNextBytes(byte[] bArr, int i, int i2) {
        synchronized (this) {
            for (int i3 = 0; i3 < i2; i3++) {
                try {
                    if (this.windowCount < 1) {
                        RandomGenerator randomGenerator = this.generator;
                        byte[] bArr2 = this.f20879window;
                        randomGenerator.nextBytes(bArr2, 0, bArr2.length);
                        this.windowCount = this.f20879window.length;
                    }
                    byte[] bArr3 = this.f20879window;
                    int i4 = this.windowCount - 1;
                    this.windowCount = i4;
                    bArr[i3 + i] = bArr3[i4];
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void addSeedMaterial(long j) {
        synchronized (this) {
            this.windowCount = 0;
            this.generator.addSeedMaterial(j);
        }
    }

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void nextBytes(byte[] bArr) {
        doNextBytes(bArr, 0, bArr.length);
    }

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void addSeedMaterial(byte[] bArr) {
        synchronized (this) {
            this.windowCount = 0;
            this.generator.addSeedMaterial(bArr);
        }
    }

    @Override // org.bouncycastle.p194crypto.p215prng.RandomGenerator
    public void nextBytes(byte[] bArr, int i, int i2) {
        doNextBytes(bArr, i, i2);
    }
}
