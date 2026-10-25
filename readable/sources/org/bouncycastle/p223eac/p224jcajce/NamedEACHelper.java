package org.bouncycastle.p223eac.p224jcajce;

import java.security.KeyFactory;

/* loaded from: classes2.dex */
class NamedEACHelper implements EACHelper {
    private final String providerName;

    public NamedEACHelper(String str) {
        this.providerName = str;
    }

    @Override // org.bouncycastle.p223eac.p224jcajce.EACHelper
    public KeyFactory createKeyFactory(String str) {
        return KeyFactory.getInstance(str, this.providerName);
    }
}
