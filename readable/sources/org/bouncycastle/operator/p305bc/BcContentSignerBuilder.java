package org.bouncycastle.operator.p305bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.operator.RuntimeOperatorException;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.CryptoException;
import org.bouncycastle.p194crypto.InterfaceC5282Signer;
import org.bouncycastle.p194crypto.p213params.AsymmetricKeyParameter;
import org.bouncycastle.p194crypto.p213params.ParametersWithRandom;

/* loaded from: classes2.dex */
public abstract class BcContentSignerBuilder {
    private AlgorithmIdentifier digAlgId;
    protected BcDigestProvider digestProvider = BcDefaultDigestProvider.INSTANCE;

    /* renamed from: random */
    private SecureRandom f22867random;
    private AlgorithmIdentifier sigAlgId;

    public BcContentSignerBuilder(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        this.sigAlgId = algorithmIdentifier;
        this.digAlgId = algorithmIdentifier2;
    }

    /* renamed from: build */
    public ContentSigner m17388build(AsymmetricKeyParameter asymmetricKeyParameter) {
        InterfaceC5282Signer interfaceC5282SignerCreateSigner = createSigner(this.sigAlgId, this.digAlgId);
        SecureRandom secureRandom = this.f22867random;
        if (secureRandom != null) {
            interfaceC5282SignerCreateSigner.mo14987init(true, new ParametersWithRandom(asymmetricKeyParameter, secureRandom));
        } else {
            interfaceC5282SignerCreateSigner.mo14987init(true, asymmetricKeyParameter);
        }
        return new ContentSigner(this, interfaceC5282SignerCreateSigner) { // from class: org.bouncycastle.operator.bc.BcContentSignerBuilder.1

            /* renamed from: stream */
            private BcSignerOutputStream f22868stream;

            /* renamed from: this$0 */
            final /* synthetic */ BcContentSignerBuilder f22869this$0;

            /* renamed from: val$sig */
            final /* synthetic */ InterfaceC5282Signer f22870val$sig;

            {
                this.f22870val$sig = interfaceC5282SignerCreateSigner;
                this.f22869this$0 = this;
                this.f22868stream = new BcSignerOutputStream(interfaceC5282SignerCreateSigner);
            }

            @Override // org.bouncycastle.operator.ContentSigner
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return this.f22869this$0.sigAlgId;
            }

            @Override // org.bouncycastle.operator.ContentSigner
            public OutputStream getOutputStream() {
                return this.f22868stream;
            }

            @Override // org.bouncycastle.operator.ContentSigner
            public byte[] getSignature() {
                try {
                    return this.f22868stream.getSignature();
                } catch (CryptoException e) {
                    throw new RuntimeOperatorException("exception obtaining signature: " + e.getMessage(), e);
                }
            }
        };
    }

    public abstract InterfaceC5282Signer createSigner(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2);

    public BcContentSignerBuilder setSecureRandom(SecureRandom secureRandom) {
        this.f22867random = secureRandom;
        return this;
    }
}
