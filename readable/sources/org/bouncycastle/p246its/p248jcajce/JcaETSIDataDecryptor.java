package org.bouncycastle.p246its.p248jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.Provider;
import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import org.bouncycastle.p246its.operator.ETSIDataDecryptor;
import org.bouncycastle.p249jcajce.p279spec.IESKEMParameterSpec;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JcaETSIDataDecryptor implements ETSIDataDecryptor {

    /* renamed from: helper */
    private final JcaJceHelper f21309helper;
    private final PrivateKey privateKey;
    private final byte[] recipientHash;
    private SecretKey secretKey = null;

    /* renamed from: org.bouncycastle.its.jcajce.JcaETSIDataDecryptor$Builder */
    public static class C5455Builder {

        /* renamed from: key */
        private final PrivateKey f21310key;
        private JcaJceHelper provider;
        private final byte[] recipientHash;

        public C5455Builder(PrivateKey privateKey, byte[] bArr) {
            this.f21310key = privateKey;
            this.recipientHash = C6238Arrays.m18231clone(bArr);
        }

        /* renamed from: build */
        public JcaETSIDataDecryptor m16023build() {
            return new JcaETSIDataDecryptor(this.f21310key, this.recipientHash, this.provider);
        }

        public C5455Builder provider(String str) {
            this.provider = new NamedJcaJceHelper(str);
            return this;
        }

        public C5455Builder provider(Provider provider) {
            this.provider = new ProviderJcaJceHelper(provider);
            return this;
        }
    }

    public JcaETSIDataDecryptor(PrivateKey privateKey, byte[] bArr, JcaJceHelper jcaJceHelper) {
        this.privateKey = privateKey;
        this.f21309helper = jcaJceHelper;
        this.recipientHash = bArr;
    }

    /* renamed from: builder */
    public static C5455Builder m16020builder(PrivateKey privateKey, byte[] bArr) {
        return new C5455Builder(privateKey, bArr);
    }

    @Override // org.bouncycastle.p246its.operator.ETSIDataDecryptor
    /* renamed from: decrypt */
    public byte[] mo16021decrypt(byte[] bArr, byte[] bArr2, byte[] bArr3) throws InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipherCreateCipher = this.f21309helper.createCipher("ETSIKEMwithSHA256");
            cipherCreateCipher.init(4, this.privateKey, new IESKEMParameterSpec(this.recipientHash));
            this.secretKey = (SecretKey) cipherCreateCipher.unwrap(bArr, "AES", 3);
            Cipher cipherCreateCipher2 = this.f21309helper.createCipher("CCM");
            cipherCreateCipher2.init(2, this.secretKey, ClassUtil.getGCMSpec(bArr3, 128));
            return cipherCreateCipher2.doFinal(bArr2);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.p246its.operator.ETSIDataDecryptor
    /* renamed from: getKey */
    public byte[] mo16022getKey() {
        SecretKey secretKey = this.secretKey;
        if (secretKey != null) {
            return secretKey.getEncoded();
        }
        throw new IllegalStateException("no secret key recovered");
    }
}
