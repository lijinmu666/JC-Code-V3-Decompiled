package org.bouncycastle.p314pqc.p334jcajce.interfaces;

import java.security.PrivateKey;

/* loaded from: classes2.dex */
public interface LMSPrivateKey extends InterfaceC6135LMSKey, PrivateKey {
    LMSPrivateKey extractKeyShard(int i);

    long getIndex();

    long getUsagesRemaining();
}
