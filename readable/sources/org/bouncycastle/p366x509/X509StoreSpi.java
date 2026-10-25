package org.bouncycastle.p366x509;

import java.util.Collection;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public abstract class X509StoreSpi {
    public abstract Collection engineGetMatches(Selector selector);

    public abstract void engineInit(X509StoreParameters x509StoreParameters);
}
