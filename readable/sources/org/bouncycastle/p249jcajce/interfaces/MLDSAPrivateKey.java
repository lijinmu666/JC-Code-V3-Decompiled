package org.bouncycastle.p249jcajce.interfaces;

import java.security.PrivateKey;

/* loaded from: classes2.dex */
public interface MLDSAPrivateKey extends PrivateKey, MLDSAKey {
    byte[] getPrivateData();

    MLDSAPrivateKey getPrivateKey(boolean z);

    MLDSAPublicKey getPublicKey();

    /* renamed from: getSeed */
    byte[] mo16063getSeed();
}
