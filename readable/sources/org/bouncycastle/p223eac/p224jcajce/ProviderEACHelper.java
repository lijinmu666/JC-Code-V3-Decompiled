package org.bouncycastle.p223eac.p224jcajce;

import java.security.KeyFactory;
import java.security.Provider;

/* loaded from: classes2.dex */
class ProviderEACHelper implements EACHelper {
    private final Provider provider;

    public ProviderEACHelper(Provider provider) {
        this.provider = provider;
    }

    @Override // org.bouncycastle.p223eac.p224jcajce.EACHelper
    public KeyFactory createKeyFactory(String str) {
        return KeyFactory.getInstance(str, this.provider);
    }
}
