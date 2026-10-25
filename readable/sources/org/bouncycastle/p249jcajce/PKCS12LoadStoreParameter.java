package org.bouncycastle.p249jcajce;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;

/* loaded from: classes2.dex */
public class PKCS12LoadStoreParameter extends BCLoadStoreParameter {
    private final boolean useISO8859d1ForDecryption;

    /* renamed from: org.bouncycastle.jcajce.PKCS12LoadStoreParameter$Builder */
    public static class C5473Builder {

        /* renamed from: in */
        private final InputStream f21361in;

        /* renamed from: out */
        private final OutputStream f21362out;
        private final KeyStore.ProtectionParameter protectionParameter;
        private boolean useISO8859d1ForDecryption;

        public C5473Builder() {
            this((OutputStream) null, (KeyStore.ProtectionParameter) null);
        }

        /* renamed from: build */
        public PKCS12LoadStoreParameter m16064build() {
            return new PKCS12LoadStoreParameter(this);
        }

        public C5473Builder setUseISO8859d1ForDecryption(boolean z) {
            this.useISO8859d1ForDecryption = z;
            return this;
        }

        public C5473Builder(InputStream inputStream, KeyStore.ProtectionParameter protectionParameter) {
            this.useISO8859d1ForDecryption = false;
            this.f21361in = inputStream;
            this.f21362out = null;
            this.protectionParameter = protectionParameter;
        }

        public C5473Builder(InputStream inputStream, char[] cArr) {
            this(inputStream, new KeyStore.PasswordProtection(cArr));
        }

        public C5473Builder(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
            this.useISO8859d1ForDecryption = false;
            this.f21361in = null;
            this.f21362out = outputStream;
            this.protectionParameter = protectionParameter;
        }

        public C5473Builder(OutputStream outputStream, char[] cArr) {
            this(outputStream, new KeyStore.PasswordProtection(cArr));
        }
    }

    private PKCS12LoadStoreParameter(C5473Builder c5473Builder) {
        super(c5473Builder.f21361in, c5473Builder.f21362out, c5473Builder.protectionParameter);
        this.useISO8859d1ForDecryption = c5473Builder.useISO8859d1ForDecryption;
    }

    public boolean useISO8859d1ForDecryption() {
        return this.useISO8859d1ForDecryption;
    }
}
