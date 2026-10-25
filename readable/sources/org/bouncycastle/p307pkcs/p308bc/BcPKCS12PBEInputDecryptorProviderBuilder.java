package org.bouncycastle.p307pkcs.p308bc;

import java.io.InputStream;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p206io.CipherInputStream;
import org.bouncycastle.p194crypto.paddings.PaddedBufferedBlockCipher;

/* loaded from: classes2.dex */
public class BcPKCS12PBEInputDecryptorProviderBuilder {

    /* renamed from: digest */
    private ExtendedDigest f22937digest;

    public BcPKCS12PBEInputDecryptorProviderBuilder() {
        this(new SHA1Digest());
    }

    /* renamed from: build */
    public InputDecryptorProvider m17415build(final char[] cArr) {
        return new InputDecryptorProvider(this) { // from class: org.bouncycastle.pkcs.bc.BcPKCS12PBEInputDecryptorProviderBuilder.1

            /* renamed from: this$0 */
            final /* synthetic */ BcPKCS12PBEInputDecryptorProviderBuilder f22938this$0;

            {
                this.f22938this$0 = this;
            }

            @Override // org.bouncycastle.operator.InputDecryptorProvider
            /* renamed from: get */
            public InputDecryptor mo17371get(final AlgorithmIdentifier algorithmIdentifier) {
                final PaddedBufferedBlockCipher engine = PKCS12PBEUtils.getEngine(algorithmIdentifier.getAlgorithm());
                engine.mo14952init(false, PKCS12PBEUtils.createCipherParameters(algorithmIdentifier.getAlgorithm(), this.f22938this$0.f22937digest, engine.getBlockSize(), PKCS12PBEParams.getInstance(algorithmIdentifier.getParameters()), cArr));
                final char[] cArr2 = cArr;
                return new InputDecryptor(this) { // from class: org.bouncycastle.pkcs.bc.BcPKCS12PBEInputDecryptorProviderBuilder.1.1

                    /* renamed from: this$1 */
                    final /* synthetic */ C60291 f22939this$1;

                    {
                        this.f22939this$1 = this;
                    }

                    @Override // org.bouncycastle.operator.InputDecryptor
                    public AlgorithmIdentifier getAlgorithmIdentifier() {
                        return algorithmIdentifier;
                    }

                    @Override // org.bouncycastle.operator.InputDecryptor
                    public InputStream getInputStream(InputStream inputStream) {
                        return new CipherInputStream(inputStream, engine);
                    }

                    /* renamed from: getKey */
                    public GenericKey m17416getKey() {
                        return new GenericKey(algorithmIdentifier, PBEParametersGenerator.PKCS12PasswordToBytes(cArr2));
                    }
                };
            }
        };
    }

    public BcPKCS12PBEInputDecryptorProviderBuilder(ExtendedDigest extendedDigest) {
        this.f22937digest = extendedDigest;
    }
}
