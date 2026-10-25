package org.bouncycastle.p249jcajce.provider.p266config;

import java.io.OutputStream;
import java.security.KeyStore;

/* loaded from: classes2.dex */
public class PKCS12StoreParameter extends org.bouncycastle.p249jcajce.PKCS12StoreParameter {
    public PKCS12StoreParameter(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter) {
        super(outputStream, protectionParameter, false);
    }

    public PKCS12StoreParameter(OutputStream outputStream, KeyStore.ProtectionParameter protectionParameter, boolean z) {
        super(outputStream, protectionParameter, z);
    }

    public PKCS12StoreParameter(OutputStream outputStream, char[] cArr) {
        super(outputStream, cArr, false);
    }

    public PKCS12StoreParameter(OutputStream outputStream, char[] cArr, boolean z) {
        super(outputStream, new KeyStore.PasswordProtection(cArr), z);
    }

    public PKCS12StoreParameter(OutputStream outputStream, char[] cArr, boolean z, boolean z2) {
        super(outputStream, new KeyStore.PasswordProtection(cArr), z, z2);
    }
}
