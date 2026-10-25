package org.bouncycastle.p302openssl.p303bc;

import org.bouncycastle.p302openssl.PEMDecryptor;
import org.bouncycastle.p302openssl.PEMDecryptorProvider;
import org.bouncycastle.p302openssl.PasswordException;

/* loaded from: classes2.dex */
public class BcPEMDecryptorProvider implements PEMDecryptorProvider {
    private final char[] password;

    public BcPEMDecryptorProvider(char[] cArr) {
        this.password = cArr;
    }

    @Override // org.bouncycastle.p302openssl.PEMDecryptorProvider
    /* renamed from: get */
    public PEMDecryptor mo17361get(final String str) {
        return new PEMDecryptor(this) { // from class: org.bouncycastle.openssl.bc.BcPEMDecryptorProvider.1

            /* renamed from: this$0 */
            final /* synthetic */ BcPEMDecryptorProvider f22829this$0;

            {
                this.f22829this$0 = this;
            }

            @Override // org.bouncycastle.p302openssl.PEMDecryptor
            /* renamed from: decrypt */
            public byte[] mo17360decrypt(byte[] bArr, byte[] bArr2) throws PasswordException {
                if (this.f22829this$0.password != null) {
                    return PEMUtilities.m17365crypt(false, bArr, this.f22829this$0.password, str, bArr2);
                }
                throw new PasswordException("Password is null, but a password is required");
            }
        };
    }
}
