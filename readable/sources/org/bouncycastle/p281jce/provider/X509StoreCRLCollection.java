package org.bouncycastle.p281jce.provider;

import java.util.Collection;
import org.bouncycastle.p361util.CollectionStore;
import org.bouncycastle.p361util.Selector;
import org.bouncycastle.p366x509.X509CollectionStoreParameters;
import org.bouncycastle.p366x509.X509StoreParameters;
import org.bouncycastle.p366x509.X509StoreSpi;

/* loaded from: classes2.dex */
public class X509StoreCRLCollection extends X509StoreSpi {

    /* renamed from: _store */
    private CollectionStore f22047_store;

    @Override // org.bouncycastle.p366x509.X509StoreSpi
    public Collection engineGetMatches(Selector selector) {
        return this.f22047_store.getMatches(selector);
    }

    @Override // org.bouncycastle.p366x509.X509StoreSpi
    public void engineInit(X509StoreParameters x509StoreParameters) {
        if (!(x509StoreParameters instanceof X509CollectionStoreParameters)) {
            throw new IllegalArgumentException(x509StoreParameters.toString());
        }
        this.f22047_store = new CollectionStore(((X509CollectionStoreParameters) x509StoreParameters).getCollection());
    }
}
