package org.bouncycastle.p249jcajce.provider.p268drbg;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p215prng.EntropySource;
import org.bouncycastle.p194crypto.p215prng.EntropySourceProvider;

/* loaded from: classes2.dex */
class IncrementalEntropySourceProvider implements EntropySourceProvider {
    private final boolean predictionResistant;

    /* renamed from: random */
    private final SecureRandom f21712random;

    public IncrementalEntropySourceProvider(SecureRandom secureRandom, boolean z) {
        this.f21712random = secureRandom;
        this.predictionResistant = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: sleep */
    public static void m16148sleep(long j) throws InterruptedException {
        if (j != 0) {
            Thread.sleep(j);
        }
    }

    @Override // org.bouncycastle.p194crypto.p215prng.EntropySourceProvider
    /* renamed from: get */
    public EntropySource mo15836get(int i) {
        return new IncrementalEntropySource(this, i) { // from class: org.bouncycastle.jcajce.provider.drbg.IncrementalEntropySourceProvider.1
            final int numBytes;

            /* renamed from: this$0 */
            final /* synthetic */ IncrementalEntropySourceProvider f21713this$0;
            final /* synthetic */ int val$bitsRequired;

            {
                this.val$bitsRequired = i;
                this.f21713this$0 = this;
                this.numBytes = (i + 7) / 8;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public int entropySize() {
                return this.val$bitsRequired;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public byte[] getEntropy() {
                try {
                    return getEntropy(0L);
                } catch (InterruptedException unused) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("initial entropy fetch interrupted");
                }
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public boolean isPredictionResistant() {
                return this.f21713this$0.predictionResistant;
            }

            @Override // org.bouncycastle.p249jcajce.provider.p268drbg.IncrementalEntropySource
            public byte[] getEntropy(long j) throws InterruptedException {
                int i2;
                int i3 = this.numBytes;
                byte[] bArr = new byte[i3];
                int i4 = 0;
                while (true) {
                    i2 = this.numBytes;
                    if (i4 >= i2 / 8) {
                        break;
                    }
                    IncrementalEntropySourceProvider.m16148sleep(j);
                    byte[] bArrGenerateSeed = this.f21713this$0.f21712random.generateSeed(8);
                    System.arraycopy(bArrGenerateSeed, 0, bArr, i4 * 8, bArrGenerateSeed.length);
                    i4++;
                }
                int i5 = i2 - ((i2 / 8) * 8);
                if (i5 != 0) {
                    IncrementalEntropySourceProvider.m16148sleep(j);
                    byte[] bArrGenerateSeed2 = this.f21713this$0.f21712random.generateSeed(i5);
                    System.arraycopy(bArrGenerateSeed2, 0, bArr, i3 - bArrGenerateSeed2.length, bArrGenerateSeed2.length);
                }
                return bArr;
            }
        };
    }
}
