package org.bouncycastle.p366x509;

import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes2.dex */
public class X509CollectionStoreParameters implements X509StoreParameters {
    private Collection collection;

    public X509CollectionStoreParameters(Collection collection) {
        if (collection == null) {
            throw new NullPointerException("collection cannot be null");
        }
        this.collection = collection;
    }

    /* renamed from: clone */
    public Object m18395clone() {
        return new X509CollectionStoreParameters(this.collection);
    }

    public Collection getCollection() {
        return new ArrayList(this.collection);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("X509CollectionStoreParameters: [\n");
        sb.append("  collection: " + this.collection + "\n");
        sb.append("]");
        return sb.toString();
    }
}
