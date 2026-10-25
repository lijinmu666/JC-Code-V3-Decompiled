package org.bouncycastle.p249jcajce.interfaces;

import java.security.PrivateKey;

/* loaded from: classes2.dex */
public interface MLKEMPrivateKey extends PrivateKey, MLKEMKey {
    byte[] getPrivateData();

    MLKEMPrivateKey getPrivateKey(boolean z);

    MLKEMPublicKey getPublicKey();

    /* renamed from: getSeed */
    byte[] mo16082getSeed();
}
