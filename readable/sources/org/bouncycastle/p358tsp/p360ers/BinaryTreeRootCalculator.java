package org.bouncycastle.p358tsp.p360ers;

import java.util.ArrayList;
import java.util.List;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.p169tsp.PartialHashtree;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class BinaryTreeRootCalculator implements ERSRootNodeCalculator {

    /* renamed from: tree */
    private List<List<byte[]>> f24175tree;

    @Override // org.bouncycastle.p358tsp.p360ers.ERSRootNodeCalculator
    public PartialHashtree[] computePathToRoot(DigestCalculator digestCalculator, PartialHashtree partialHashtree, int i) {
        List<byte[]> list;
        int i2;
        ArrayList arrayList = new ArrayList();
        byte[] bArrComputeNodeHash = C6236ERSUtil.computeNodeHash(digestCalculator, partialHashtree);
        arrayList.add(partialHashtree);
        int i3 = 0;
        while (i3 < this.f24175tree.size() - 1) {
            if (i == this.f24175tree.get(i3).size() - 1) {
                while (true) {
                    int i4 = i3 + 1;
                    if (!C6238Arrays.areEqual(bArrComputeNodeHash, this.f24175tree.get(i4).get(r3.size() - 1))) {
                        break;
                    }
                    i = this.f24175tree.get(i4).size() - 1;
                    i3 = i4;
                }
            }
            if ((i & 1) == 0) {
                list = this.f24175tree.get(i3);
                i2 = i + 1;
            } else {
                list = this.f24175tree.get(i3);
                i2 = i - 1;
            }
            byte[] bArr = list.get(i2);
            arrayList.add(new PartialHashtree(bArr));
            bArrComputeNodeHash = C6236ERSUtil.calculateBranchHash(digestCalculator, bArrComputeNodeHash, bArr);
            i /= 2;
            i3++;
        }
        return (PartialHashtree[]) arrayList.toArray(new PartialHashtree[0]);
    }

    @Override // org.bouncycastle.p358tsp.p360ers.ERSRootNodeCalculator
    public byte[] computeRootHash(DigestCalculator digestCalculator, PartialHashtree[] partialHashtreeArr) {
        ArrayList arrayList;
        SortedHashList sortedHashList = new SortedHashList();
        for (PartialHashtree partialHashtree : partialHashtreeArr) {
            sortedHashList.m18217add(C6236ERSUtil.computeNodeHash(digestCalculator, partialHashtree));
        }
        List<byte[]> listM18219toList = sortedHashList.m18219toList();
        ArrayList arrayList2 = new ArrayList();
        this.f24175tree = arrayList2;
        arrayList2.add(listM18219toList);
        if (listM18219toList.size() > 1) {
            while (true) {
                arrayList = new ArrayList((listM18219toList.size() / 2) + 1);
                for (int i = 0; i <= listM18219toList.size() - 2; i += 2) {
                    arrayList.add(C6236ERSUtil.calculateBranchHash(digestCalculator, listM18219toList.get(i), listM18219toList.get(i + 1)));
                }
                if (listM18219toList.size() % 2 == 1) {
                    arrayList.add(listM18219toList.get(listM18219toList.size() - 1));
                }
                this.f24175tree.add(arrayList);
                if (arrayList.size() <= 1) {
                    break;
                }
                listM18219toList = arrayList;
            }
            listM18219toList = arrayList;
        }
        return listM18219toList.get(0);
    }

    @Override // org.bouncycastle.p358tsp.p360ers.ERSRootNodeCalculator
    public byte[] recoverRootHash(DigestCalculator digestCalculator, PartialHashtree[] partialHashtreeArr) {
        byte[] bArrComputeNodeHash = C6236ERSUtil.computeNodeHash(digestCalculator, partialHashtreeArr[0]);
        for (int i = 1; i < partialHashtreeArr.length; i++) {
            bArrComputeNodeHash = C6236ERSUtil.calculateBranchHash(digestCalculator, bArrComputeNodeHash, C6236ERSUtil.computeNodeHash(digestCalculator, partialHashtreeArr[i]));
        }
        return bArrComputeNodeHash;
    }
}
