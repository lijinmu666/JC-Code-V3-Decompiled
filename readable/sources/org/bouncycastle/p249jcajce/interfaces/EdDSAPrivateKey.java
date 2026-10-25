package org.bouncycastle.p249jcajce.interfaces;

import java.security.PrivateKey;

/* loaded from: classes2.dex */
public interface EdDSAPrivateKey extends EdDSAKey, PrivateKey {
    EdDSAPublicKey getPublicKey();
}
