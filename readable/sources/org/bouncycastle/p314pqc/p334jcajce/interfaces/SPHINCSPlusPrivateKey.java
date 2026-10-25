package org.bouncycastle.p314pqc.p334jcajce.interfaces;

import java.security.PrivateKey;

@Deprecated
/* loaded from: classes2.dex */
public interface SPHINCSPlusPrivateKey extends PrivateKey, SPHINCSPlusKey {
    SPHINCSPlusPublicKey getPublicKey();
}
