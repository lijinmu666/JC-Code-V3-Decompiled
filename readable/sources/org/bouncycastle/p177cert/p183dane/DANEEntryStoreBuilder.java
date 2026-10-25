package org.bouncycastle.p177cert.p183dane;

/* loaded from: classes2.dex */
public class DANEEntryStoreBuilder {
    private final DANEEntryFetcherFactory daneEntryFetcher;

    public DANEEntryStoreBuilder(DANEEntryFetcherFactory dANEEntryFetcherFactory) {
        this.daneEntryFetcher = dANEEntryFetcherFactory;
    }

    /* renamed from: build */
    public DANEEntryStore m14806build(String str) {
        return new DANEEntryStore(this.daneEntryFetcher.mo14805build(str).getEntries());
    }
}
