package org.bouncycastle.p223eac.p224jcajce;

import java.security.KeyFactory;

/* loaded from: classes2.dex */
class DefaultEACHelper implements EACHelper {
    @Override // org.bouncycastle.p223eac.p224jcajce.EACHelper
    public KeyFactory createKeyFactory(String str) {
        return KeyFactory.getInstance(str);
    }
}
