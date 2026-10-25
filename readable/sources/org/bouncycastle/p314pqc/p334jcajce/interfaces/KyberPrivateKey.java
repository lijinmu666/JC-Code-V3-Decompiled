package org.bouncycastle.p314pqc.p334jcajce.interfaces;

import java.security.PrivateKey;

/* loaded from: classes2.dex */
public interface KyberPrivateKey extends PrivateKey, KyberKey {
    KyberPublicKey getPublicKey();
}
