package org.bouncycastle.p177cert.p183dane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.operator.DigestCalculator;

/* loaded from: classes2.dex */
public class DANECertificateFetcher {
    private final DANEEntryFetcherFactory fetcherFactory;
    private final DANEEntrySelectorFactory selectorFactory;

    public DANECertificateFetcher(DANEEntryFetcherFactory dANEEntryFetcherFactory, DigestCalculator digestCalculator) {
        this.fetcherFactory = dANEEntryFetcherFactory;
        this.selectorFactory = new DANEEntrySelectorFactory(digestCalculator);
    }

    /* renamed from: fetch */
    public List m14804fetch(String str) throws DANEException, IOException {
        DANEEntrySelector dANEEntrySelectorCreateSelector = this.selectorFactory.createSelector(str);
        List<DANEEntry> entries = this.fetcherFactory.mo14805build(dANEEntrySelectorCreateSelector.getDomainName()).getEntries();
        ArrayList arrayList = new ArrayList(entries.size());
        for (DANEEntry dANEEntry : entries) {
            if (dANEEntrySelectorCreateSelector.mo14742match(dANEEntry)) {
                arrayList.add(dANEEntry.getCertificate());
            }
        }
        return Collections.unmodifiableList(arrayList);
    }
}
