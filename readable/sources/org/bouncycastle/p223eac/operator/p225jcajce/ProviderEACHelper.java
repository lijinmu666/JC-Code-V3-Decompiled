package org.bouncycastle.p223eac.operator.p225jcajce;

import java.security.Provider;
import java.security.Signature;

/* loaded from: classes2.dex */
class ProviderEACHelper extends EACHelper {
    private final Provider provider;

    public ProviderEACHelper(Provider provider) {
        this.provider = provider;
    }

    @Override // org.bouncycastle.p223eac.operator.p225jcajce.EACHelper
    public Signature createSignature(String str) {
        return Signature.getInstance(str, this.provider);
    }
}
