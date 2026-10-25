package org.bouncycastle.p302openssl.p304jcajce;

import java.security.Provider;
import java.security.SecureRandom;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p302openssl.PEMEncryptor;

/* loaded from: classes2.dex */
public class JcePEMEncryptorBuilder {
    private final String algorithm;

    /* renamed from: helper */
    private JcaJceHelper f22849helper = new DefaultJcaJceHelper();

    /* renamed from: random */
    private SecureRandom f22850random;

    public JcePEMEncryptorBuilder(String str) {
        this.algorithm = str;
    }

    /* renamed from: build */
    public PEMEncryptor m17375build(final char[] cArr) {
        if (this.f22850random == null) {
            this.f22850random = new SecureRandom();
        }
        final byte[] bArr = new byte[this.algorithm.startsWith("AES-") ? 16 : 8];
        this.f22850random.nextBytes(bArr);
        return new PEMEncryptor(this) { // from class: org.bouncycastle.openssl.jcajce.JcePEMEncryptorBuilder.1

            /* renamed from: this$0 */
            final /* synthetic */ JcePEMEncryptorBuilder f22851this$0;

            {
                this.f22851this$0 = this;
            }

            @Override // org.bouncycastle.p302openssl.PEMEncryptor
            /* renamed from: encrypt */
            public byte[] mo17362encrypt(byte[] bArr2) {
                return PEMUtilities.m17376crypt(true, this.f22851this$0.f22849helper, bArr2, cArr, this.f22851this$0.algorithm, bArr);
            }

            @Override // org.bouncycastle.p302openssl.PEMEncryptor
            public String getAlgorithm() {
                return this.f22851this$0.algorithm;
            }

            @Override // org.bouncycastle.p302openssl.PEMEncryptor
            /* renamed from: getIV */
            public byte[] mo17363getIV() {
                return bArr;
            }
        };
    }

    public JcePEMEncryptorBuilder setProvider(String str) {
        this.f22849helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcePEMEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.f22850random = secureRandom;
        return this;
    }

    public JcePEMEncryptorBuilder setProvider(Provider provider) {
        this.f22849helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
