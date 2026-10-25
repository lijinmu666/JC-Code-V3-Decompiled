package org.bouncycastle.p302openssl.p304jcajce;

import java.security.Provider;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p302openssl.PEMDecryptor;
import org.bouncycastle.p302openssl.PEMDecryptorProvider;
import org.bouncycastle.p302openssl.PasswordException;

/* loaded from: classes2.dex */
public class JcePEMDecryptorProviderBuilder {

    /* renamed from: helper */
    private JcaJceHelper f22846helper = new DefaultJcaJceHelper();

    /* renamed from: build */
    public PEMDecryptorProvider m17374build(final char[] cArr) {
        return new PEMDecryptorProvider(this) { // from class: org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder.1

            /* renamed from: this$0 */
            final /* synthetic */ JcePEMDecryptorProviderBuilder f22847this$0;

            {
                this.f22847this$0 = this;
            }

            @Override // org.bouncycastle.p302openssl.PEMDecryptorProvider
            /* renamed from: get */
            public PEMDecryptor mo17361get(final String str) {
                final char[] cArr2 = cArr;
                return new PEMDecryptor(this) { // from class: org.bouncycastle.openssl.jcajce.JcePEMDecryptorProviderBuilder.1.1

                    /* renamed from: this$1 */
                    final /* synthetic */ C59891 f22848this$1;

                    {
                        this.f22848this$1 = this;
                    }

                    @Override // org.bouncycastle.p302openssl.PEMDecryptor
                    /* renamed from: decrypt */
                    public byte[] mo17360decrypt(byte[] bArr, byte[] bArr2) throws PasswordException {
                        if (cArr2 != null) {
                            return PEMUtilities.m17376crypt(false, this.f22848this$1.f22847this$0.f22846helper, bArr, cArr2, str, bArr2);
                        }
                        throw new PasswordException("Password is null, but a password is required");
                    }
                };
            }
        };
    }

    public JcePEMDecryptorProviderBuilder setProvider(String str) {
        this.f22846helper = new NamedJcaJceHelper(str);
        return this;
    }

    public JcePEMDecryptorProviderBuilder setProvider(Provider provider) {
        this.f22846helper = new ProviderJcaJceHelper(provider);
        return this;
    }
}
