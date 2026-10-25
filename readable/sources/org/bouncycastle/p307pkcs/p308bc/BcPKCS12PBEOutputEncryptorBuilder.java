package org.bouncycastle.p307pkcs.p308bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.p166pkcs.PKCS12PBEParams;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p194crypto.BlockCipher;
import org.bouncycastle.p194crypto.BufferedBlockCipher;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p206io.CipherOutputStream;
import org.bouncycastle.p194crypto.paddings.PKCS7Padding;
import org.bouncycastle.p194crypto.paddings.PaddedBufferedBlockCipher;

/* loaded from: classes2.dex */
public class BcPKCS12PBEOutputEncryptorBuilder {
    private ASN1ObjectIdentifier algorithm;

    /* renamed from: digest */
    private ExtendedDigest f22940digest;

    /* renamed from: engine */
    private BufferedBlockCipher f22941engine;
    private int iterationCount;

    /* renamed from: random */
    private SecureRandom f22942random;

    public BcPKCS12PBEOutputEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier, BlockCipher blockCipher) {
        this(aSN1ObjectIdentifier, blockCipher, new SHA1Digest());
    }

    /* renamed from: build */
    public OutputEncryptor m17417build(final char[] cArr) {
        if (this.f22942random == null) {
            this.f22942random = new SecureRandom();
        }
        byte[] bArr = new byte[20];
        this.f22942random.nextBytes(bArr);
        final PKCS12PBEParams pKCS12PBEParams = new PKCS12PBEParams(bArr, this.iterationCount);
        this.f22941engine.mo14952init(true, PKCS12PBEUtils.createCipherParameters(this.algorithm, this.f22940digest, this.f22941engine.getBlockSize(), pKCS12PBEParams, cArr));
        return new OutputEncryptor(this) { // from class: org.bouncycastle.pkcs.bc.BcPKCS12PBEOutputEncryptorBuilder.1

            /* renamed from: this$0 */
            final /* synthetic */ BcPKCS12PBEOutputEncryptorBuilder f22943this$0;

            {
                this.f22943this$0 = this;
            }

            @Override // org.bouncycastle.operator.OutputEncryptor
            public AlgorithmIdentifier getAlgorithmIdentifier() {
                return new AlgorithmIdentifier(this.f22943this$0.algorithm, pKCS12PBEParams);
            }

            @Override // org.bouncycastle.operator.OutputEncryptor
            /* renamed from: getKey */
            public GenericKey mo14795getKey() {
                return new GenericKey(new AlgorithmIdentifier(this.f22943this$0.algorithm, pKCS12PBEParams), PBEParametersGenerator.PKCS12PasswordToBytes(cArr));
            }

            @Override // org.bouncycastle.operator.OutputEncryptor
            public OutputStream getOutputStream(OutputStream outputStream) {
                return new CipherOutputStream(outputStream, this.f22943this$0.f22941engine);
            }
        };
    }

    public BcPKCS12PBEOutputEncryptorBuilder setIterationCount(int i) {
        this.iterationCount = i;
        return this;
    }

    public BcPKCS12PBEOutputEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier, BlockCipher blockCipher, ExtendedDigest extendedDigest) {
        this.iterationCount = 1024;
        this.algorithm = aSN1ObjectIdentifier;
        this.f22941engine = new PaddedBufferedBlockCipher(blockCipher, new PKCS7Padding());
        this.f22940digest = extendedDigest;
    }
}
