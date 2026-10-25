package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.TreeMap;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.OTSHashAddress;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class BDSStateMap implements Serializable {
    private static final long serialVersionUID = -3464451825208522308L;
    private final Map<Integer, C6108BDS> bdsState = new TreeMap();
    private transient long maxIndex;

    public BDSStateMap(long j) {
        this.maxIndex = j;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.maxIndex = objectInputStream.available() != 0 ? objectInputStream.readLong() : 0L;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeLong(this.maxIndex);
    }

    /* renamed from: get */
    public C6108BDS m17882get(int i) {
        return this.bdsState.get(Integers.m18296valueOf(i));
    }

    public long getMaxIndex() {
        return this.maxIndex;
    }

    /* renamed from: isEmpty */
    public boolean m17883isEmpty() {
        return this.bdsState.isEmpty();
    }

    /* renamed from: put */
    public void m17884put(int i, C6108BDS c6108bds) {
        this.bdsState.put(Integers.m18296valueOf(i), c6108bds);
    }

    /* renamed from: update */
    public C6108BDS m17885update(int i, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        return this.bdsState.put(Integers.m18296valueOf(i), this.bdsState.get(Integers.m18296valueOf(i)).getNextState(bArr, bArr2, oTSHashAddress));
    }

    public void updateState(XMSSMTParameters xMSSMTParameters, long j, byte[] bArr, byte[] bArr2) {
        XMSSParameters xMSSParameters = xMSSMTParameters.getXMSSParameters();
        int height = xMSSParameters.getHeight();
        long treeIndex = XMSSUtil.getTreeIndex(j, height);
        int leafIndex = XMSSUtil.getLeafIndex(j, height);
        OTSHashAddress oTSHashAddress = (OTSHashAddress) new OTSHashAddress.C6114Builder().withTreeAddress(treeIndex).withOTSAddress(leafIndex).mo17893build();
        int i = (1 << height) - 1;
        if (leafIndex < i) {
            if (m17882get(0) == null || leafIndex == 0) {
                m17884put(0, new C6108BDS(xMSSParameters, bArr, bArr2, oTSHashAddress));
            }
            m17885update(0, bArr, bArr2, oTSHashAddress);
        }
        for (int i2 = 1; i2 < xMSSMTParameters.getLayers(); i2++) {
            int leafIndex2 = XMSSUtil.getLeafIndex(treeIndex, height);
            treeIndex = XMSSUtil.getTreeIndex(treeIndex, height);
            OTSHashAddress oTSHashAddress2 = (OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(i2).withTreeAddress(treeIndex).withOTSAddress(leafIndex2).mo17893build();
            if (this.bdsState.get(Integer.valueOf(i2)) == null || XMSSUtil.isNewBDSInitNeeded(j, height, i2)) {
                this.bdsState.put(Integer.valueOf(i2), new C6108BDS(xMSSParameters, bArr, bArr2, oTSHashAddress2));
            }
            if (leafIndex2 < i && XMSSUtil.isNewAuthenticationPathNeeded(j, height, i2)) {
                m17885update(i2, bArr, bArr2, oTSHashAddress2);
            }
        }
    }

    public BDSStateMap withWOTSDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        BDSStateMap bDSStateMap = new BDSStateMap(this.maxIndex);
        for (Integer num : this.bdsState.keySet()) {
            bDSStateMap.bdsState.put(num, this.bdsState.get(num).withWOTSDigest(aSN1ObjectIdentifier));
        }
        return bDSStateMap;
    }

    public BDSStateMap(BDSStateMap bDSStateMap, long j) {
        for (Integer num : bDSStateMap.bdsState.keySet()) {
            this.bdsState.put(num, new C6108BDS(bDSStateMap.bdsState.get(num)));
        }
        this.maxIndex = j;
    }

    public BDSStateMap(XMSSMTParameters xMSSMTParameters, long j, byte[] bArr, byte[] bArr2) {
        this.maxIndex = (1 << xMSSMTParameters.getHeight()) - 1;
        for (long j2 = 0; j2 < j; j2++) {
            updateState(xMSSMTParameters, j2, bArr, bArr2);
        }
    }
}
