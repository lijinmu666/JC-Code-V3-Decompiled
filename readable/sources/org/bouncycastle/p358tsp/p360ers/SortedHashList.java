package org.bouncycastle.p358tsp.p360ers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/* loaded from: classes2.dex */
public class SortedHashList {
    private static final Comparator<byte[]> hashComp = new ByteArrayComparator();
    private final LinkedList<byte[]> baseList = new LinkedList<>();

    /* renamed from: add */
    public void m18217add(byte[] bArr) {
        if (this.baseList.size() == 0 || hashComp.compare(bArr, this.baseList.get(0)) < 0) {
            this.baseList.addFirst(bArr);
            return;
        }
        int i = 1;
        while (i < this.baseList.size() && hashComp.compare(this.baseList.get(i), bArr) <= 0) {
            i++;
        }
        int size = this.baseList.size();
        LinkedList<byte[]> linkedList = this.baseList;
        if (i == size) {
            linkedList.add(bArr);
        } else {
            linkedList.add(i, bArr);
        }
    }

    public byte[] getFirst() {
        return this.baseList.getFirst();
    }

    /* renamed from: size */
    public int m18218size() {
        return this.baseList.size();
    }

    /* renamed from: toList */
    public List<byte[]> m18219toList() {
        return new ArrayList(this.baseList);
    }
}
