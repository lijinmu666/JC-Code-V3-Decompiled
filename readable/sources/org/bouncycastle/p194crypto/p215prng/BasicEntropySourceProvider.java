package org.bouncycastle.p194crypto.p215prng;

import java.security.SecureRandom;

/* loaded from: classes2.dex */
public class BasicEntropySourceProvider implements EntropySourceProvider {
    private final boolean _predictionResistant;

    /* renamed from: _sr */
    private final SecureRandom f20871_sr;

    public BasicEntropySourceProvider(SecureRandom secureRandom, boolean z) {
        this.f20871_sr = secureRandom;
        this._predictionResistant = z;
    }

    @Override // org.bouncycastle.p194crypto.p215prng.EntropySourceProvider
    /* renamed from: get */
    public EntropySource mo15836get(final int i) {
        return new EntropySource(this) { // from class: org.bouncycastle.crypto.prng.BasicEntropySourceProvider.1

            /* renamed from: this$0 */
            final /* synthetic */ BasicEntropySourceProvider f20872this$0;

            {
                this.f20872this$0 = this;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public int entropySize() {
                return i;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public byte[] getEntropy() {
                if (!(this.f20872this$0.f20871_sr instanceof SP800SecureRandom) && !(this.f20872this$0.f20871_sr instanceof X931SecureRandom)) {
                    return this.f20872this$0.f20871_sr.generateSeed((i + 7) / 8);
                }
                byte[] bArr = new byte[(i + 7) / 8];
                this.f20872this$0.f20871_sr.nextBytes(bArr);
                return bArr;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public boolean isPredictionResistant() {
                return this.f20872this$0._predictionResistant;
            }
        };
    }
}
