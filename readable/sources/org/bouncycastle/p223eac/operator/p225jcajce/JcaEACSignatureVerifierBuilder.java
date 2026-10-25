package org.bouncycastle.p223eac.operator.p225jcajce;

import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OperatorStreamException;
import org.bouncycastle.operator.RuntimeOperatorException;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p143eac.EACObjectIdentifiers;
import org.bouncycastle.p223eac.operator.EACSignatureVerifier;

/* loaded from: classes2.dex */
public class JcaEACSignatureVerifierBuilder {

    /* renamed from: helper */
    private EACHelper f21155helper = new DefaultEACHelper();

    public static class SignatureOutputStream extends OutputStream {

        /* renamed from: sig */
        private Signature f21157sig;

        public SignatureOutputStream(Signature signature) {
            this.f21157sig = signature;
        }

        /* renamed from: verify */
        public boolean m15951verify(byte[] bArr) {
            return this.f21157sig.verify(bArr);
        }

        @Override // java.io.OutputStream
        public void write(int i) throws SignatureException, OperatorStreamException {
            try {
                this.f21157sig.update((byte) i);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws SignatureException, OperatorStreamException {
            try {
                this.f21157sig.update(bArr);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws SignatureException, OperatorStreamException {
            try {
                this.f21157sig.update(bArr, i, i2);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] derEncode(byte[] bArr) {
        int length = bArr.length / 2;
        byte[] bArr2 = new byte[length];
        byte[] bArr3 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        System.arraycopy(bArr, length, bArr3, 0, length);
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(new ASN1Integer(new BigInteger(1, bArr2)));
        aSN1EncodableVector.m14420add(new ASN1Integer(new BigInteger(1, bArr3)));
        return new DERSequence(aSN1EncodableVector).getEncoded();
    }

    /* renamed from: build */
    public EACSignatureVerifier m15950build(final ASN1ObjectIdentifier aSN1ObjectIdentifier, PublicKey publicKey) throws OperatorCreationException, InvalidKeyException {
        try {
            Signature signature = this.f21155helper.getSignature(aSN1ObjectIdentifier);
            signature.initVerify(publicKey);
            final SignatureOutputStream signatureOutputStream = new SignatureOutputStream(signature);
            return new EACSignatureVerifier(this) { // from class: org.bouncycastle.eac.operator.jcajce.JcaEACSignatureVerifierBuilder.1

                /* renamed from: this$0 */
                final /* synthetic */ JcaEACSignatureVerifierBuilder f21156this$0;

                {
                    this.f21156this$0 = this;
                }

                @Override // org.bouncycastle.p223eac.operator.EACSignatureVerifier
                public OutputStream getOutputStream() {
                    return signatureOutputStream;
                }

                @Override // org.bouncycastle.p223eac.operator.EACSignatureVerifier
                public ASN1ObjectIdentifier getUsageIdentifier() {
                    return aSN1ObjectIdentifier;
                }

                @Override // org.bouncycastle.p223eac.operator.EACSignatureVerifier
                /* renamed from: verify */
                public boolean mo15949verify(byte[] bArr) {
                    try {
                        if (!aSN1ObjectIdentifier.m14435on(EACObjectIdentifiers.id_TA_ECDSA)) {
                            return signatureOutputStream.m15951verify(bArr);
                        }
                        try {
                            return signatureOutputStream.m15951verify(JcaEACSignatureVerifierBuilder.derEncode(bArr));
                        } catch (Exception unused) {
                            return false;
                        }
                    } catch (SignatureException e) {
                        throw new RuntimeOperatorException("exception obtaining signature: " + e.getMessage(), e);
                    }
                }
            };
        } catch (InvalidKeyException e) {
            throw new OperatorCreationException("invalid key: " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new OperatorCreationException("unable to find algorithm: " + e2.getMessage(), e2);
        } catch (NoSuchProviderException e3) {
            throw new OperatorCreationException("unable to find provider: " + e3.getMessage(), e3);
        }
    }

    public JcaEACSignatureVerifierBuilder setProvider(String str) {
        this.f21155helper = new NamedEACHelper(str);
        return this;
    }

    public JcaEACSignatureVerifierBuilder setProvider(Provider provider) {
        this.f21155helper = new ProviderEACHelper(provider);
        return this;
    }
}
