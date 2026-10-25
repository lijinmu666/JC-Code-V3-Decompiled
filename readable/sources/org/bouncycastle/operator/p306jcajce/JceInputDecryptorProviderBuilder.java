package org.bouncycastle.operator.p306jcajce;

import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.operator.InputDecryptor;
import org.bouncycastle.operator.InputDecryptorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.cryptopro.GOST28147Parameters;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.p250io.CipherInputStream;
import org.bouncycastle.p249jcajce.p279spec.GOST28147ParameterSpec;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JceInputDecryptorProviderBuilder {

    /* renamed from: helper */
    private JcaJceHelper f22910helper = new DefaultJcaJceHelper();

    /* renamed from: build */
    public InputDecryptorProvider m17399build(byte[] bArr) {
        final byte[] bArrM18231clone = C6238Arrays.m18231clone(bArr);
        return new InputDecryptorProvider(this) { // from class: org.bouncycastle.operator.jcajce.JceInputDecryptorProviderBuilder.1

            /* renamed from: cipher */
            private Cipher f22911cipher;
            private AlgorithmIdentifier encryptionAlg;

            /* renamed from: this$0 */
            final /* synthetic */ JceInputDecryptorProviderBuilder f22912this$0;

            {
                this.f22912this$0 = this;
            }

            @Override // org.bouncycastle.operator.InputDecryptorProvider
            /* renamed from: get */
            public InputDecryptor mo17371get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException, InvalidKeyException, InvalidAlgorithmParameterException {
                Cipher cipher;
                AlgorithmParameterSpec gOST28147ParameterSpec;
                this.encryptionAlg = algorithmIdentifier;
                ASN1ObjectIdentifier algorithm = algorithmIdentifier.getAlgorithm();
                try {
                    this.f22911cipher = this.f22912this$0.f22910helper.createCipher(algorithm.m14433getId());
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArrM18231clone, algorithm.m14433getId());
                    ASN1Encodable parameters = algorithmIdentifier.getParameters();
                    if (parameters instanceof ASN1OctetString) {
                        cipher = this.f22911cipher;
                        gOST28147ParameterSpec = new IvParameterSpec(ASN1OctetString.getInstance(parameters).getOctets());
                    } else {
                        GOST28147Parameters gOST28147Parameters = GOST28147Parameters.getInstance(parameters);
                        cipher = this.f22911cipher;
                        gOST28147ParameterSpec = new GOST28147ParameterSpec(gOST28147Parameters.getEncryptionParamSet(), gOST28147Parameters.m14575getIV());
                    }
                    cipher.init(2, secretKeySpec, gOST28147ParameterSpec);
                    return new InputDecryptor() { // from class: org.bouncycastle.operator.jcajce.JceInputDecryptorProviderBuilder.1.1
                        @Override // org.bouncycastle.operator.InputDecryptor
                        public AlgorithmIdentifier getAlgorithmIdentifier() {
                            return C60271.this.encryptionAlg;
                        }

                        @Override // org.bouncycastle.operator.InputDecryptor
                        public InputStream getInputStream(InputStream inputStream) {
                            return new CipherInputStream(inputStream, C60271.this.f22911cipher);
                        }
                    };
                } catch (Exception e) {
                    throw new OperatorCreationException("unable to create InputDecryptor: " + e.getMessage(), e);
                }
            }
        };
    }

    public JceInputDecryptorProviderBuilder setProvider(String str) {
        this.f22910helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JceInputDecryptorProviderBuilder setProvider(Provider provider) {
        this.f22910helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
