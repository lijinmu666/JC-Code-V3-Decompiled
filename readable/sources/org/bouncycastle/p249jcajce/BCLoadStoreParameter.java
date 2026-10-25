package org.bouncycastle.p249jcajce;

import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;

/* loaded from: classes2.dex */
public class BCLoadStoreParameter implements KeyStore.LoadStoreParameter {

    /* renamed from: in */
    private final InputStream f21349in;

    /* renamed from: out */
    private final OutputStream f21350out;
    private final KeyStore.ProtectionParameter protectionParameter;

    public BCLoadStoreParameter(InputStream inputStream, OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
        this.f21349in = inputStream;
        this.f21350out = outputStream;
        this.protectionParameter = protectionParameter;
    }

    public InputStream getInputStream() {
        if (this.f21350out == null) {
            return this.f21349in;
        }
        throw new UnsupportedOperationException("parameter configured for storage OutputStream present");
    }

    public OutputStream getOutputStream() {
        OutputStream outputStream = this.f21350out;
        if (outputStream != null) {
            return outputStream;
        }
        throw new UnsupportedOperationException("parameter not configured for storage - no OutputStream");
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.protectionParameter;
    }

    public BCLoadStoreParameter(InputStream inputStream, KeyStore.ProtectionParameter protectionParameter) {
        this(inputStream, null, protectionParameter);
    }

    public BCLoadStoreParameter(InputStream inputStream, char[] cArr) {
        this(inputStream, new KeyStore.PasswordProtection(cArr));
    }

    public BCLoadStoreParameter(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
        this(null, outputStream, protectionParameter);
    }

    public BCLoadStoreParameter(OutputStream outputStream, char[] cArr) {
        this(outputStream, new KeyStore.PasswordProtection(cArr));
    }
}
