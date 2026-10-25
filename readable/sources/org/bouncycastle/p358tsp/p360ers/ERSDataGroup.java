package org.bouncycastle.p358tsp.p360ers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.operator.DigestCalculator;

/* loaded from: classes2.dex */
public class ERSDataGroup extends ERSCachingData {
    protected List<InterfaceC6235ERSData> dataObjects;

    public ERSDataGroup(List<InterfaceC6235ERSData> list) {
        ArrayList arrayList = new ArrayList(list.size());
        this.dataObjects = arrayList;
        arrayList.addAll(list);
    }

    @Override // org.bouncycastle.p358tsp.p360ers.ERSCachingData
    public byte[] calculateHash(DigestCalculator digestCalculator, byte[] bArr) {
        List<byte[]> hashes = getHashes(digestCalculator, bArr);
        if (hashes.size() <= 1) {
            return hashes.get(0);
        }
        ArrayList arrayList = new ArrayList(hashes.size());
        for (int i = 0; i != arrayList.size(); i++) {
            arrayList.add(hashes.get(i));
        }
        return C6236ERSUtil.calculateDigest(digestCalculator, (Iterator<byte[]>) arrayList.iterator());
    }

    @Override // org.bouncycastle.p358tsp.p360ers.ERSCachingData, org.bouncycastle.p358tsp.p360ers.InterfaceC6235ERSData
    /* renamed from: getHash */
    public byte[] mo18212getHash(DigestCalculator digestCalculator, byte[] bArr) {
        List<byte[]> hashes = getHashes(digestCalculator, bArr);
        return hashes.size() > 1 ? C6236ERSUtil.calculateDigest(digestCalculator, hashes.iterator()) : hashes.get(0);
    }

    public List<byte[]> getHashes(DigestCalculator digestCalculator, byte[] bArr) {
        return C6236ERSUtil.buildHashList(digestCalculator, this.dataObjects, bArr);
    }

    /* renamed from: size */
    public int m18214size() {
        return this.dataObjects.size();
    }

    public ERSDataGroup(InterfaceC6235ERSData interfaceC6235ERSData) {
        this.dataObjects = Collections.singletonList(interfaceC6235ERSData);
    }

    public ERSDataGroup(InterfaceC6235ERSData... interfaceC6235ERSDataArr) {
        ArrayList arrayList = new ArrayList(interfaceC6235ERSDataArr.length);
        this.dataObjects = arrayList;
        arrayList.addAll(Arrays.asList(interfaceC6235ERSDataArr));
    }
}
