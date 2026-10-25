package org.bouncycastle.p249jcajce;

import java.io.OutputStream;
import java.security.KeyStore;
import org.bouncycastle.p194crypto.p221util.PBKDFConfig;

/* loaded from: classes2.dex */
public class BCFKSStoreParameter implements KeyStore.LoadStoreParameter {

    /* renamed from: out */
    private OutputStream f21348out;
    private final KeyStore.ProtectionParameter protectionParameter;
    private final PBKDFConfig storeConfig;

    public BCFKSStoreParameter(OutputStream outputStream, PBKDFConfig pBKDFConfig, KeyStore.ProtectionParameter protectionParameter) {
        this.f21348out = outputStream;
        this.storeConfig = pBKDFConfig;
        this.protectionParameter = protectionParameter;
    }

    public OutputStream getOutputStream() {
        return this.f21348out;
    }

    @Override // java.security.KeyStore.LoadStoreParameter
    public KeyStore.ProtectionParameter getProtectionParameter() {
        return this.protectionParameter;
    }

    public PBKDFConfig getStorePBKDFConfig() {
        return this.storeConfig;
    }

    public BCFKSStoreParameter(OutputStream outputStream, PBKDFConfig pBKDFConfig, char[] cArr) {
        this(outputStream, pBKDFConfig, new KeyStore.PasswordProtection(cArr));
    }
}
