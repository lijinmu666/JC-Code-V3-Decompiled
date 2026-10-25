package org.bouncycastle.operator.p305bc;

import java.io.OutputStream;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;

/* loaded from: classes2.dex */
public class BcDigestCalculatorProvider implements DigestCalculatorProvider {
    private BcDigestProvider digestProvider = BcDefaultDigestProvider.INSTANCE;

    public static class DigestOutputStream extends OutputStream {

        /* renamed from: dig */
        private InterfaceC5277Digest f22878dig;

        public DigestOutputStream(InterfaceC5277Digest interfaceC5277Digest) {
            this.f22878dig = interfaceC5277Digest;
        }

        public byte[] getDigest() {
            byte[] bArr = new byte[this.f22878dig.getDigestSize()];
            this.f22878dig.mo14967doFinal(bArr, 0);
            return bArr;
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.f22878dig.mo14969update((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f22878dig.mo14970update(bArr, 0, bArr.length);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.f22878dig.mo14970update(bArr, i, i2);
        }
    }

    @Override // org.bouncycastle.operator.DigestCalculatorProvider
    /* renamed from: get */
    public DigestCalculator mo14763get(final AlgorithmIdentifier algorithmIdentifier) {
        final DigestOutputStream digestOutputStream = new DigestOutputStream(this.digestProvider.mo14916get(algorithmIdentifier));
        return new DigestCalculator(this) { // from class: org.bouncycastle.operator.bc.BcDigestCalculatorProvider.1

            /* renamed from: this$0 */
            final /* synthetic */ BcDigestCalculatorProvider f22877this$0;

            {
                this.f22877this$0 = this;
            }

            @Override // org.bouncycastle.operator.DigestCalculator
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return algorithmIdentifier;
            }

            @Override // org.bouncycastle.operator.DigestCalculator
            public byte[] getDigest() {
                return digestOutputStream.getDigest();
            }

            @Override // org.bouncycastle.operator.DigestCalculator
            public OutputStream getOutputStream() {
                return digestOutputStream;
            }
        };
    }
}
