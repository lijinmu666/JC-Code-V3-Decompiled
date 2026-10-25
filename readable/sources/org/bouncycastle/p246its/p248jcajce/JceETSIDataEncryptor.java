package org.bouncycastle.p246its.p248jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p246its.operator.ETSIDataEncryptor;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;

/* loaded from: classes2.dex */
public class JceETSIDataEncryptor implements ETSIDataEncryptor {

    /* renamed from: helper */
    private final JcaJceHelper f21324helper;

    /* renamed from: key */
    private byte[] f21325key;

    /* renamed from: nonce */
    private byte[] f21326nonce;

    /* renamed from: random */
    private final SecureRandom f21327random;

    /* renamed from: org.bouncycastle.its.jcajce.JceETSIDataEncryptor$Builder */
    public static class C5462Builder {

        /* renamed from: helper */
        private JcaJceHelper f21328helper = new DefaultJcaJceHelper();

        /* renamed from: random */
        private SecureRandom f21329random;

        /* renamed from: build */
        public JceETSIDataEncryptor m16036build() {
            if (this.f21329random == null) {
                this.f21329random = new SecureRandom();
            }
            return new JceETSIDataEncryptor(this.f21329random, this.f21328helper);
        }

        public C5462Builder setProvider(String str) {
            this.f21328helper = new NamedJcaJceHelper(str);
            return this;
        }

        public C5462Builder setRandom(SecureRandom secureRandom) {
            this.f21329random = secureRandom;
            return this;
        }

        public C5462Builder setProvider(Provider provider) {
            this.f21328helper = new ProviderJcaJceHelper(provider);
            return this;
        }
    }

    private JceETSIDataEncryptor(SecureRandom secureRandom, JcaJceHelper jcaJceHelper) {
        this.f21327random = secureRandom;
        this.f21324helper = jcaJceHelper;
    }

    @Override // org.bouncycastle.p246its.operator.ETSIDataEncryptor
    /* renamed from: encrypt */
    public byte[] mo16034encrypt(byte[] bArr) throws InvalidKeyException, InvalidAlgorithmParameterException {
        byte[] bArr2 = new byte[16];
        this.f21325key = bArr2;
        this.f21327random.nextBytes(bArr2);
        byte[] bArr3 = new byte[12];
        this.f21326nonce = bArr3;
        this.f21327random.nextBytes(bArr3);
        try {
            SecretKeySpec secretKeySpec = new SecretKeySpec(this.f21325key, "AES");
            Cipher cipherCreateCipher = this.f21324helper.createCipher("CCM");
            cipherCreateCipher.init(1, secretKeySpec, ClassUtil.getGCMSpec(this.f21326nonce, 128));
            return cipherCreateCipher.doFinal(bArr);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.p246its.operator.ETSIDataEncryptor
    /* renamed from: getKey */
    public byte[] mo16035getKey() {
        return this.f21325key;
    }

    @Override // org.bouncycastle.p246its.operator.ETSIDataEncryptor
    public byte[] getNonce() {
        return this.f21326nonce;
    }
}
