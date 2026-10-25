package org.bouncycastle.p314pqc.p334jcajce.interfaces;

import java.security.PrivateKey;

/* loaded from: classes2.dex */
public interface XMSSPrivateKey extends InterfaceC6139XMSSKey, PrivateKey {
    XMSSPrivateKey extractKeyShard(int i);

    long getIndex();

    long getUsagesRemaining();
}
