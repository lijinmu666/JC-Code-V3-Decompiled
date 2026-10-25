package org.bouncycastle.p358tsp.p360ers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class SortedIndexedHashList {
    private static final Comparator<byte[]> hashComp = new ByteArrayComparator();
    private final LinkedList<IndexedHash> baseList = new LinkedList<>();

    /* renamed from: add */
    public void m18220add(IndexedHash indexedHash) {
        if (this.baseList.size() == 0 || hashComp.compare(indexedHash.f24187digest, this.baseList.get(0).f24187digest) < 0) {
            this.baseList.addFirst(indexedHash);
            return;
        }
        int i = 1;
        while (i < this.baseList.size() && hashComp.compare(this.baseList.get(i).f24187digest, indexedHash.f24187digest) <= 0) {
            i++;
        }
        int size = this.baseList.size();
        LinkedList<IndexedHash> linkedList = this.baseList;
        if (i == size) {
            linkedList.add(indexedHash);
        } else {
            linkedList.add(i, indexedHash);
        }
    }

    public IndexedHash getFirst() {
        return this.baseList.getFirst();
    }

    /* renamed from: size */
    public int m18221size() {
        return this.baseList.size();
    }

    /* renamed from: toList */
    public List<IndexedHash> m18222toList() {
        return new ArrayList(this.baseList);
    }
}
