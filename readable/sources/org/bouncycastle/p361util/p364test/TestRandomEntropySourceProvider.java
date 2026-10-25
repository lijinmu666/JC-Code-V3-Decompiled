package org.bouncycastle.p361util.p364test;

import java.security.SecureRandom;
import org.bouncycastle.p194crypto.p215prng.EntropySource;
import org.bouncycastle.p194crypto.p215prng.EntropySourceProvider;

/* loaded from: classes2.dex */
public class TestRandomEntropySourceProvider implements EntropySourceProvider {
    private final boolean _predictionResistant;

    /* renamed from: _sr */
    private final SecureRandom f24269_sr = new SecureRandom();

    public TestRandomEntropySourceProvider(boolean z) {
        this._predictionResistant = z;
    }

    @Override // org.bouncycastle.p194crypto.p215prng.EntropySourceProvider
    /* renamed from: get */
    public EntropySource mo15836get(final int i) {
        return new EntropySource(this) { // from class: org.bouncycastle.util.test.TestRandomEntropySourceProvider.1

            /* renamed from: this$0 */
            final /* synthetic */ TestRandomEntropySourceProvider f24270this$0;

            {
                this.f24270this$0 = this;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public int entropySize() {
                return i;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public byte[] getEntropy() {
                byte[] bArr = new byte[(i + 7) / 8];
                this.f24270this$0.f24269_sr.nextBytes(bArr);
                return bArr;
            }

            @Override // org.bouncycastle.p194crypto.p215prng.EntropySource
            public boolean isPredictionResistant() {
                return this.f24270this$0._predictionResistant;
            }
        };
    }
}
