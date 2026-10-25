package org.bouncycastle.p358tsp.p360ers;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.p169tsp.ArchiveTimeStamp;
import org.bouncycastle.p133asn1.p169tsp.PartialHashtree;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.InterfaceC6249Store;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class ERSEvidenceRecordStore implements InterfaceC6249Store<ERSEvidenceRecord> {

    /* renamed from: digCalc */
    private DigestCalculator f24184digCalc;
    private Map<HashNode, List<ERSEvidenceRecord>> recordMap = new HashMap();

    public static class HashNode {
        private final byte[] dataHash;
        private final int hashCode;

        public HashNode(byte[] bArr) {
            this.dataHash = bArr;
            this.hashCode = C6238Arrays.hashCode(bArr);
        }

        /* renamed from: equals */
        public boolean m18216equals(Object obj) {
            if (obj instanceof HashNode) {
                return C6238Arrays.areEqual(this.dataHash, ((HashNode) obj).dataHash);
            }
            return false;
        }

        public int hashCode() {
            return this.hashCode;
        }
    }

    public ERSEvidenceRecordStore(Collection<ERSEvidenceRecord> collection) {
        this.f24184digCalc = null;
        for (ERSEvidenceRecord eRSEvidenceRecord : collection) {
            ArchiveTimeStamp archiveTimeStamp = eRSEvidenceRecord.getArchiveTimeStamps()[0];
            if (this.f24184digCalc == null) {
                this.f24184digCalc = eRSEvidenceRecord.getDigestAlgorithmProvider().mo14763get(archiveTimeStamp.getDigestAlgorithmIdentifier());
            }
            PartialHashtree hashTreeLeaf = archiveTimeStamp.getHashTreeLeaf();
            if (hashTreeLeaf != null) {
                byte[][] values = hashTreeLeaf.getValues();
                if (values.length > 1) {
                    for (int i = 0; i != values.length; i++) {
                        addRecord(new HashNode(values[i]), eRSEvidenceRecord);
                    }
                    addRecord(new HashNode(C6236ERSUtil.computeNodeHash(this.f24184digCalc, hashTreeLeaf)), eRSEvidenceRecord);
                } else {
                    addRecord(new HashNode(values[0]), eRSEvidenceRecord);
                }
            } else {
                addRecord(new HashNode(archiveTimeStamp.getTimeStampDigestValue()), eRSEvidenceRecord);
            }
        }
    }

    private void addRecord(HashNode hashNode, ERSEvidenceRecord eRSEvidenceRecord) {
        List<ERSEvidenceRecord> list = this.recordMap.get(hashNode);
        if (list == null) {
            this.recordMap.put(hashNode, Collections.singletonList(eRSEvidenceRecord));
            return;
        }
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.addAll(list);
        arrayList.add(eRSEvidenceRecord);
        this.recordMap.put(hashNode, arrayList);
    }

    @Override // org.bouncycastle.p361util.InterfaceC6249Store
    public Collection<ERSEvidenceRecord> getMatches(Selector<ERSEvidenceRecord> selector) {
        ArrayList arrayList;
        if (selector instanceof ERSEvidenceRecordSelector) {
            List<ERSEvidenceRecord> list = this.recordMap.get(new HashNode(((ERSEvidenceRecordSelector) selector).m18215getData().mo18212getHash(this.f24184digCalc, null)));
            if (list == null) {
                return Collections.emptyList();
            }
            ArrayList arrayList2 = new ArrayList(list.size());
            for (int i = 0; i != list.size(); i++) {
                ERSEvidenceRecord eRSEvidenceRecord = list.get(i);
                if (selector.mo14742match(eRSEvidenceRecord)) {
                    arrayList2.add(eRSEvidenceRecord);
                }
            }
            return Collections.unmodifiableList(arrayList2);
        }
        if (selector == null) {
            HashSet hashSet = new HashSet(this.recordMap.size());
            Iterator<List<ERSEvidenceRecord>> it = this.recordMap.values().iterator();
            while (it.hasNext()) {
                hashSet.addAll(it.next());
            }
            arrayList = new ArrayList(hashSet);
        } else {
            HashSet hashSet2 = new HashSet();
            for (List<ERSEvidenceRecord> list2 : this.recordMap.values()) {
                for (int i2 = 0; i2 != list2.size(); i2++) {
                    if (selector.mo14742match(list2.get(i2))) {
                        hashSet2.add(list2.get(i2));
                    }
                }
            }
            arrayList = new ArrayList(hashSet2);
        }
        return Collections.unmodifiableList(arrayList);
    }
}
