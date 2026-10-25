package org.bouncycastle.p314pqc.p316crypto.p332xmss;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.HashTreeAddress;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.LTreeAddress;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.OTSHashAddress;

/* renamed from: org.bouncycastle.pqc.crypto.xmss.BDS */
/* loaded from: classes2.dex */
public final class C6108BDS implements Serializable {
    private static final long serialVersionUID = 1;
    private List<XMSSNode> authenticationPath;

    /* renamed from: index */
    private int f23592index;

    /* renamed from: k */
    private int f23593k;

    /* renamed from: keep */
    private Map<Integer, XMSSNode> f23594keep;
    private transient int maxIndex;

    /* renamed from: retain */
    private Map<Integer, LinkedList<XMSSNode>> f23595retain;

    /* renamed from: root */
    private XMSSNode f23596root;

    /* renamed from: stack */
    private Stack<XMSSNode> f23597stack;
    private final List<BDSTreeHash> treeHashInstances;
    private final int treeHeight;

    /* renamed from: used */
    private boolean f23598used;
    private transient WOTSPlus wotsPlus;

    public C6108BDS(C6108BDS c6108bds) {
        this.wotsPlus = new WOTSPlus(c6108bds.wotsPlus.getParams());
        this.treeHeight = c6108bds.treeHeight;
        this.f23593k = c6108bds.f23593k;
        this.f23596root = c6108bds.f23596root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(c6108bds.authenticationPath);
        this.f23595retain = new TreeMap();
        for (Integer num : c6108bds.f23595retain.keySet()) {
            this.f23595retain.put(num, (LinkedList) c6108bds.f23595retain.get(num).clone());
        }
        Stack<XMSSNode> stack = new Stack<>();
        this.f23597stack = stack;
        stack.addAll(c6108bds.f23597stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> it = c6108bds.treeHashInstances.iterator();
        while (it.hasNext()) {
            this.treeHashInstances.add(it.next().m17886clone());
        }
        this.f23594keep = new TreeMap(c6108bds.f23594keep);
        this.f23592index = c6108bds.f23592index;
        this.maxIndex = c6108bds.maxIndex;
        this.f23598used = c6108bds.f23598used;
    }

    private BDSTreeHash getBDSTreeHashInstanceForUpdate() {
        BDSTreeHash bDSTreeHash = null;
        for (BDSTreeHash bDSTreeHash2 : this.treeHashInstances) {
            if (!bDSTreeHash2.isFinished() && bDSTreeHash2.isInitialized() && (bDSTreeHash == null || bDSTreeHash2.getHeight() < bDSTreeHash.getHeight() || (bDSTreeHash2.getHeight() == bDSTreeHash.getHeight() && bDSTreeHash2.getIndexLeaf() < bDSTreeHash.getIndexLeaf()))) {
                bDSTreeHash = bDSTreeHash2;
            }
        }
        return bDSTreeHash;
    }

    private void initialize(byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        if (oTSHashAddress == null) {
            throw new NullPointerException("otsHashAddress == null");
        }
        LTreeAddress lTreeAddress = (LTreeAddress) new LTreeAddress.C6112Builder().withLayerAddress(oTSHashAddress.getLayerAddress()).withTreeAddress(oTSHashAddress.getTreeAddress()).mo17893build();
        HashTreeAddress hashTreeAddress = (HashTreeAddress) new HashTreeAddress.C6110Builder().withLayerAddress(oTSHashAddress.getLayerAddress()).withTreeAddress(oTSHashAddress.getTreeAddress()).mo17893build();
        for (int i = 0; i < (1 << this.treeHeight); i++) {
            oTSHashAddress = (OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(oTSHashAddress.getLayerAddress()).withTreeAddress(oTSHashAddress.getTreeAddress()).withOTSAddress(i).withChainAddress(oTSHashAddress.getChainAddress()).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask()).mo17893build();
            WOTSPlus wOTSPlus = this.wotsPlus;
            wOTSPlus.importKeys(wOTSPlus.getWOTSPlusSecretKey(bArr2, oTSHashAddress), bArr);
            WOTSPlusPublicKeyParameters publicKey = this.wotsPlus.getPublicKey(oTSHashAddress);
            lTreeAddress = (LTreeAddress) new LTreeAddress.C6112Builder().withLayerAddress(lTreeAddress.getLayerAddress()).withTreeAddress(lTreeAddress.getTreeAddress()).withLTreeAddress(i).withTreeHeight(lTreeAddress.getTreeHeight()).withTreeIndex(lTreeAddress.getTreeIndex()).withKeyAndMask(lTreeAddress.getKeyAndMask()).mo17893build();
            XMSSNode xMSSNodeM17921lTree = XMSSNodeUtil.m17921lTree(this.wotsPlus, publicKey, lTreeAddress);
            hashTreeAddress = (HashTreeAddress) new HashTreeAddress.C6110Builder().withLayerAddress(hashTreeAddress.getLayerAddress()).withTreeAddress(hashTreeAddress.getTreeAddress()).withTreeIndex(i).withKeyAndMask(hashTreeAddress.getKeyAndMask()).mo17893build();
            while (!this.f23597stack.isEmpty() && this.f23597stack.peek().getHeight() == xMSSNodeM17921lTree.getHeight()) {
                int height = i / (1 << xMSSNodeM17921lTree.getHeight());
                if (height == 1) {
                    this.authenticationPath.add(xMSSNodeM17921lTree);
                }
                if (height == 3 && xMSSNodeM17921lTree.getHeight() < this.treeHeight - this.f23593k) {
                    this.treeHashInstances.get(xMSSNodeM17921lTree.getHeight()).m17888setNode(xMSSNodeM17921lTree);
                }
                if (height >= 3 && (height & 1) == 1 && xMSSNodeM17921lTree.getHeight() >= this.treeHeight - this.f23593k && xMSSNodeM17921lTree.getHeight() <= this.treeHeight - 2) {
                    if (this.f23595retain.get(Integer.valueOf(xMSSNodeM17921lTree.getHeight())) == null) {
                        LinkedList<XMSSNode> linkedList = new LinkedList<>();
                        linkedList.add(xMSSNodeM17921lTree);
                        this.f23595retain.put(Integer.valueOf(xMSSNodeM17921lTree.getHeight()), linkedList);
                    } else {
                        this.f23595retain.get(Integer.valueOf(xMSSNodeM17921lTree.getHeight())).add(xMSSNodeM17921lTree);
                    }
                }
                HashTreeAddress hashTreeAddress2 = (HashTreeAddress) new HashTreeAddress.C6110Builder().withLayerAddress(hashTreeAddress.getLayerAddress()).withTreeAddress(hashTreeAddress.getTreeAddress()).withTreeHeight(hashTreeAddress.getTreeHeight()).withTreeIndex((hashTreeAddress.getTreeIndex() - 1) / 2).withKeyAndMask(hashTreeAddress.getKeyAndMask()).mo17893build();
                XMSSNode xMSSNodeRandomizeHash = XMSSNodeUtil.randomizeHash(this.wotsPlus, this.f23597stack.pop(), xMSSNodeM17921lTree, hashTreeAddress2);
                XMSSNode xMSSNode = new XMSSNode(xMSSNodeRandomizeHash.getHeight() + 1, xMSSNodeRandomizeHash.getValue());
                hashTreeAddress = (HashTreeAddress) new HashTreeAddress.C6110Builder().withLayerAddress(hashTreeAddress2.getLayerAddress()).withTreeAddress(hashTreeAddress2.getTreeAddress()).withTreeHeight(hashTreeAddress2.getTreeHeight() + 1).withTreeIndex(hashTreeAddress2.getTreeIndex()).withKeyAndMask(hashTreeAddress2.getKeyAndMask()).mo17893build();
                xMSSNodeM17921lTree = xMSSNode;
            }
            this.f23597stack.push(xMSSNodeM17921lTree);
        }
        this.f23596root = this.f23597stack.pop();
    }

    private void nextAuthenticationPath(byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        List<XMSSNode> list;
        XMSSNode xMSSNodeRemoveFirst;
        if (oTSHashAddress == null) {
            throw new NullPointerException("otsHashAddress == null");
        }
        if (this.f23598used) {
            throw new IllegalStateException("index already used");
        }
        int i = this.f23592index;
        if (i > this.maxIndex - 1) {
            throw new IllegalStateException("index out of bounds");
        }
        int iCalculateTau = XMSSUtil.calculateTau(i, this.treeHeight);
        if (((this.f23592index >> (iCalculateTau + 1)) & 1) == 0 && iCalculateTau < this.treeHeight - 1) {
            this.f23594keep.put(Integer.valueOf(iCalculateTau), this.authenticationPath.get(iCalculateTau));
        }
        LTreeAddress lTreeAddress = (LTreeAddress) new LTreeAddress.C6112Builder().withLayerAddress(oTSHashAddress.getLayerAddress()).withTreeAddress(oTSHashAddress.getTreeAddress()).mo17893build();
        HashTreeAddress hashTreeAddress = (HashTreeAddress) new HashTreeAddress.C6110Builder().withLayerAddress(oTSHashAddress.getLayerAddress()).withTreeAddress(oTSHashAddress.getTreeAddress()).mo17893build();
        if (iCalculateTau == 0) {
            oTSHashAddress = (OTSHashAddress) new OTSHashAddress.C6114Builder().withLayerAddress(oTSHashAddress.getLayerAddress()).withTreeAddress(oTSHashAddress.getTreeAddress()).withOTSAddress(this.f23592index).withChainAddress(oTSHashAddress.getChainAddress()).withHashAddress(oTSHashAddress.getHashAddress()).withKeyAndMask(oTSHashAddress.getKeyAndMask()).mo17893build();
            WOTSPlus wOTSPlus = this.wotsPlus;
            wOTSPlus.importKeys(wOTSPlus.getWOTSPlusSecretKey(bArr2, oTSHashAddress), bArr);
            this.authenticationPath.set(0, XMSSNodeUtil.m17921lTree(this.wotsPlus, this.wotsPlus.getPublicKey(oTSHashAddress), (LTreeAddress) new LTreeAddress.C6112Builder().withLayerAddress(lTreeAddress.getLayerAddress()).withTreeAddress(lTreeAddress.getTreeAddress()).withLTreeAddress(this.f23592index).withTreeHeight(lTreeAddress.getTreeHeight()).withTreeIndex(lTreeAddress.getTreeIndex()).withKeyAndMask(lTreeAddress.getKeyAndMask()).mo17893build()));
        } else {
            int i2 = iCalculateTau - 1;
            HashTreeAddress hashTreeAddress2 = (HashTreeAddress) new HashTreeAddress.C6110Builder().withLayerAddress(hashTreeAddress.getLayerAddress()).withTreeAddress(hashTreeAddress.getTreeAddress()).withTreeHeight(i2).withTreeIndex(this.f23592index >> iCalculateTau).withKeyAndMask(hashTreeAddress.getKeyAndMask()).mo17893build();
            WOTSPlus wOTSPlus2 = this.wotsPlus;
            wOTSPlus2.importKeys(wOTSPlus2.getWOTSPlusSecretKey(bArr2, oTSHashAddress), bArr);
            XMSSNode xMSSNodeRandomizeHash = XMSSNodeUtil.randomizeHash(this.wotsPlus, this.authenticationPath.get(i2), this.f23594keep.get(Integer.valueOf(i2)), hashTreeAddress2);
            this.authenticationPath.set(iCalculateTau, new XMSSNode(xMSSNodeRandomizeHash.getHeight() + 1, xMSSNodeRandomizeHash.getValue()));
            this.f23594keep.remove(Integer.valueOf(i2));
            for (int i3 = 0; i3 < iCalculateTau; i3++) {
                if (i3 < this.treeHeight - this.f23593k) {
                    list = this.authenticationPath;
                    xMSSNodeRemoveFirst = this.treeHashInstances.get(i3).getTailNode();
                } else {
                    list = this.authenticationPath;
                    xMSSNodeRemoveFirst = this.f23595retain.get(Integer.valueOf(i3)).removeFirst();
                }
                list.set(i3, xMSSNodeRemoveFirst);
            }
            int iMin = Math.min(iCalculateTau, this.treeHeight - this.f23593k);
            for (int i4 = 0; i4 < iMin; i4++) {
                int i5 = this.f23592index + 1 + ((1 << i4) * 3);
                if (i5 < (1 << this.treeHeight)) {
                    this.treeHashInstances.get(i4).initialize(i5);
                }
            }
        }
        for (int i6 = 0; i6 < ((this.treeHeight - this.f23593k) >> 1); i6++) {
            BDSTreeHash bDSTreeHashInstanceForUpdate = getBDSTreeHashInstanceForUpdate();
            if (bDSTreeHashInstanceForUpdate != null) {
                bDSTreeHashInstanceForUpdate.m17889update(this.f23597stack, this.wotsPlus, bArr, bArr2, oTSHashAddress);
            }
        }
        this.f23592index++;
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        this.maxIndex = objectInputStream.available() != 0 ? objectInputStream.readInt() : (1 << this.treeHeight) - 1;
        int i = this.maxIndex;
        if (i > (1 << this.treeHeight) - 1 || this.f23592index > i + 1 || objectInputStream.available() != 0) {
            throw new IOException("inconsistent BDS data detected");
        }
    }

    private void validate() {
        if (this.authenticationPath == null) {
            throw new IllegalStateException("authenticationPath == null");
        }
        if (this.f23595retain == null) {
            throw new IllegalStateException("retain == null");
        }
        if (this.f23597stack == null) {
            throw new IllegalStateException("stack == null");
        }
        if (this.treeHashInstances == null) {
            throw new IllegalStateException("treeHashInstances == null");
        }
        if (this.f23594keep == null) {
            throw new IllegalStateException("keep == null");
        }
        if (!XMSSUtil.isIndexValid(this.treeHeight, this.f23592index)) {
            throw new IllegalStateException("index in BDS state out of bounds");
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(this.maxIndex);
    }

    public List<XMSSNode> getAuthenticationPath() {
        ArrayList arrayList = new ArrayList();
        Iterator<XMSSNode> it = this.authenticationPath.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public int getIndex() {
        return this.f23592index;
    }

    public int getMaxIndex() {
        return this.maxIndex;
    }

    public C6108BDS getNextState(byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        return new C6108BDS(this, bArr, bArr2, oTSHashAddress);
    }

    /* renamed from: getRoot */
    public XMSSNode m17880getRoot() {
        return this.f23596root;
    }

    public int getTreeHeight() {
        return this.treeHeight;
    }

    /* renamed from: isUsed */
    public boolean m17881isUsed() {
        return this.f23598used;
    }

    public void markUsed() {
        this.f23598used = true;
    }

    public C6108BDS withMaxIndex(int i, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return new C6108BDS(this, i, aSN1ObjectIdentifier);
    }

    public C6108BDS withWOTSDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return new C6108BDS(this, aSN1ObjectIdentifier);
    }

    private C6108BDS(C6108BDS c6108bds, int i, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.wotsPlus = new WOTSPlus(new WOTSPlusParameters(aSN1ObjectIdentifier));
        this.treeHeight = c6108bds.treeHeight;
        this.f23593k = c6108bds.f23593k;
        this.f23596root = c6108bds.f23596root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(c6108bds.authenticationPath);
        this.f23595retain = new TreeMap();
        for (Integer num : c6108bds.f23595retain.keySet()) {
            this.f23595retain.put(num, (LinkedList) c6108bds.f23595retain.get(num).clone());
        }
        Stack<XMSSNode> stack = new Stack<>();
        this.f23597stack = stack;
        stack.addAll(c6108bds.f23597stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> it = c6108bds.treeHashInstances.iterator();
        while (it.hasNext()) {
            this.treeHashInstances.add(it.next().m17886clone());
        }
        this.f23594keep = new TreeMap(c6108bds.f23594keep);
        this.f23592index = c6108bds.f23592index;
        this.maxIndex = i;
        this.f23598used = c6108bds.f23598used;
        validate();
    }

    private C6108BDS(C6108BDS c6108bds, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.wotsPlus = new WOTSPlus(new WOTSPlusParameters(aSN1ObjectIdentifier));
        this.treeHeight = c6108bds.treeHeight;
        this.f23593k = c6108bds.f23593k;
        this.f23596root = c6108bds.f23596root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(c6108bds.authenticationPath);
        this.f23595retain = new TreeMap();
        for (Integer num : c6108bds.f23595retain.keySet()) {
            this.f23595retain.put(num, (LinkedList) c6108bds.f23595retain.get(num).clone());
        }
        Stack<XMSSNode> stack = new Stack<>();
        this.f23597stack = stack;
        stack.addAll(c6108bds.f23597stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> it = c6108bds.treeHashInstances.iterator();
        while (it.hasNext()) {
            this.treeHashInstances.add(it.next().m17886clone());
        }
        this.f23594keep = new TreeMap(c6108bds.f23594keep);
        this.f23592index = c6108bds.f23592index;
        this.maxIndex = c6108bds.maxIndex;
        this.f23598used = c6108bds.f23598used;
        validate();
    }

    private C6108BDS(C6108BDS c6108bds, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        this.wotsPlus = new WOTSPlus(c6108bds.wotsPlus.getParams());
        this.treeHeight = c6108bds.treeHeight;
        this.f23593k = c6108bds.f23593k;
        this.f23596root = c6108bds.f23596root;
        ArrayList arrayList = new ArrayList();
        this.authenticationPath = arrayList;
        arrayList.addAll(c6108bds.authenticationPath);
        this.f23595retain = new TreeMap();
        for (Integer num : c6108bds.f23595retain.keySet()) {
            this.f23595retain.put(num, (LinkedList) c6108bds.f23595retain.get(num).clone());
        }
        Stack<XMSSNode> stack = new Stack<>();
        this.f23597stack = stack;
        stack.addAll(c6108bds.f23597stack);
        this.treeHashInstances = new ArrayList();
        Iterator<BDSTreeHash> it = c6108bds.treeHashInstances.iterator();
        while (it.hasNext()) {
            this.treeHashInstances.add(it.next().m17886clone());
        }
        this.f23594keep = new TreeMap(c6108bds.f23594keep);
        this.f23592index = c6108bds.f23592index;
        this.maxIndex = c6108bds.maxIndex;
        this.f23598used = false;
        nextAuthenticationPath(bArr, bArr2, oTSHashAddress);
    }

    private C6108BDS(WOTSPlus wOTSPlus, int i, int i2, int i3) {
        this.wotsPlus = wOTSPlus;
        this.treeHeight = i;
        this.maxIndex = i3;
        this.f23593k = i2;
        if (i2 <= i && i2 >= 2) {
            int i4 = i - i2;
            if (i4 % 2 == 0) {
                this.authenticationPath = new ArrayList();
                this.f23595retain = new TreeMap();
                this.f23597stack = new Stack<>();
                this.treeHashInstances = new ArrayList();
                for (int i5 = 0; i5 < i4; i5++) {
                    this.treeHashInstances.add(new BDSTreeHash(i5));
                }
                this.f23594keep = new TreeMap();
                this.f23592index = 0;
                this.f23598used = false;
                return;
            }
        }
        throw new IllegalArgumentException("illegal value for BDS parameter k");
    }

    public C6108BDS(XMSSParameters xMSSParameters, int i, int i2) {
        this(xMSSParameters.getWOTSPlus(), xMSSParameters.getHeight(), xMSSParameters.m17922getK(), i2);
        this.maxIndex = i;
        this.f23592index = i2;
        this.f23598used = true;
    }

    public C6108BDS(XMSSParameters xMSSParameters, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress) {
        this(xMSSParameters.getWOTSPlus(), xMSSParameters.getHeight(), xMSSParameters.m17922getK(), (1 << xMSSParameters.getHeight()) - 1);
        initialize(bArr, bArr2, oTSHashAddress);
    }

    public C6108BDS(XMSSParameters xMSSParameters, byte[] bArr, byte[] bArr2, OTSHashAddress oTSHashAddress, int i) {
        this(xMSSParameters.getWOTSPlus(), xMSSParameters.getHeight(), xMSSParameters.m17922getK(), (1 << xMSSParameters.getHeight()) - 1);
        initialize(bArr, bArr2, oTSHashAddress);
        while (this.f23592index < i) {
            nextAuthenticationPath(bArr, bArr2, oTSHashAddress);
            this.f23598used = false;
        }
    }
}
