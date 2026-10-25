package org.bouncycastle.p177cert.p183dane;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.p361util.CollectionStore;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class DANEEntryStore implements InterfaceC6249Store {

    /* renamed from: entries */
    private final Map f18867entries;

    public DANEEntryStore(List list) {
        HashMap map = new HashMap();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            DANEEntry dANEEntry = (DANEEntry) it.next();
            map.put(dANEEntry.getDomainName(), dANEEntry);
        }
        this.f18867entries = Collections.unmodifiableMap(map);
    }

    @Override // org.bouncycastle.p361util.InterfaceC6249Store
    public Collection getMatches(Selector selector) {
        if (selector == null) {
            return this.f18867entries.values();
        }
        ArrayList arrayList = new ArrayList();
        for (Object obj : this.f18867entries.values()) {
            if (selector.mo14742match(obj)) {
                arrayList.add(obj);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    public InterfaceC6249Store toCertificateStore() {
        Collection matches = getMatches(null);
        ArrayList arrayList = new ArrayList(matches.size());
        Iterator it = matches.iterator();
        while (it.hasNext()) {
            arrayList.add(((DANEEntry) it.next()).getCertificate());
        }
        return new CollectionStore(arrayList);
    }
}
