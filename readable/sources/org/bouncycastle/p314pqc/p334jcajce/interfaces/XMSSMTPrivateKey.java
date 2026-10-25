package org.bouncycastle.p314pqc.p334jcajce.interfaces;

import java.security.PrivateKey;

/* loaded from: classes2.dex */
public interface XMSSMTPrivateKey extends XMSSMTKey, PrivateKey {
    XMSSMTPrivateKey extractKeyShard(int i);

    long getIndex();

    long getUsagesRemaining();
}
