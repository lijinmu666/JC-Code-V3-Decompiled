package org.bouncycastle.p302openssl;

/* loaded from: classes2.dex */
public class EncryptionException extends PEMException {

    /* renamed from: cause */
    private Throwable f22822cause;

    public EncryptionException(String str) {
        super(str);
    }

    @Override // org.bouncycastle.p302openssl.PEMException, java.lang.Throwable
    public Throwable getCause() {
        return this.f22822cause;
    }

    public EncryptionException(String str, Throwable th) {
        super(str);
        this.f22822cause = th;
    }
}
