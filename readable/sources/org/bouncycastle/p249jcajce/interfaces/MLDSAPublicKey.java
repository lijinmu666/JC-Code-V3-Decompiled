package org.bouncycastle.p249jcajce.interfaces;

import java.security.PublicKey;

/* loaded from: classes2.dex */
public interface MLDSAPublicKey extends PublicKey, MLDSAKey {
    byte[] getPublicData();
}
