package org.bouncycastle.operator.p306jcajce;

import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.Provider;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;

/* loaded from: classes2.dex */
public class JcaDigestCalculatorProviderBuilder {

    /* renamed from: helper */
    private OperatorHelper f22901helper = new OperatorHelper(new DefaultJcaJceHelper());

    public static class DigestOutputStream extends OutputStream {

        /* renamed from: dig */
        private MessageDigest f22904dig;

        public DigestOutputStream(MessageDigest messageDigest) {
            this.f22904dig = messageDigest;
        }

        public byte[] getDigest() {
            return this.f22904dig.digest();
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.f22904dig.update((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) {
            this.f22904dig.update(bArr);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.f22904dig.update(bArr, i, i2);
        }
    }

    /* renamed from: build */
    public DigestCalculatorProvider m17397build() {
        return new DigestCalculatorProvider() { // from class: org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder.1
            @Override // org.bouncycastle.operator.DigestCalculatorProvider
            /* renamed from: get */
            public DigestCalculator mo14763get(final AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
                try {
                    final DigestOutputStream digestOutputStream = new DigestOutputStream(JcaDigestCalculatorProviderBuilder.this.f22901helper.createDigest(algorithmIdentifier));
                    return new DigestCalculator(this) { // from class: org.bouncycastle.operator.jcajce.JcaDigestCalculatorProviderBuilder.1.1

                        /* renamed from: this$1 */
                        final /* synthetic */ C60261 f22903this$1;

                        {
                            this.f22903this$1 = this;
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
                } catch (GeneralSecurityException e) {
                    throw new OperatorCreationException("exception on setup: " + e, e);
                }
            }
        };
    }

    public JcaDigestCalculatorProviderBuilder setHelper(JcaJceHelper jcaJceHelper) {
        this.f22901helper = new OperatorHelper(jcaJceHelper);
        return this;
    }

    public JcaDigestCalculatorProviderBuilder setProvider(String str) {
        this.f22901helper = new OperatorHelper(new NamedJcaJceHelper(str));
        return this;
    }

    public JcaDigestCalculatorProviderBuilder setProvider(Provider provider) {
        this.f22901helper = new OperatorHelper(new ProviderJcaJceHelper(provider));
        return this;
    }
}
