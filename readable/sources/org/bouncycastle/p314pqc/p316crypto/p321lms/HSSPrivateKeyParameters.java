package org.bouncycastle.p314pqc.p316crypto.p321lms;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class HSSPrivateKeyParameters extends LMSKeyParameters implements LMSContextBasedSigner {

    /* renamed from: index */
    private long f23217index;
    private final long indexLimit;

    /* renamed from: isShard */
    private final boolean f23218isShard;

    /* renamed from: keys */
    private List<LMSPrivateKeyParameters> f23219keys;

    /* renamed from: l */
    private final int f23220l;
    private HSSPublicKeyParameters publicKey;

    /* renamed from: sig */
    private List<LMSSignature> f23221sig;

    public HSSPrivateKeyParameters(int i, List<LMSPrivateKeyParameters> list, List<LMSSignature> list2, long j, long j2) {
        super(true);
        this.f23217index = 0L;
        this.f23220l = i;
        this.f23219keys = Collections.unmodifiableList(list);
        this.f23221sig = Collections.unmodifiableList(list2);
        this.f23217index = j;
        this.indexLimit = j2;
        this.f23218isShard = false;
        resetKeyToIndex();
    }

    public static HSSPrivateKeyParameters getInstance(Object obj) throws Throwable {
        if (obj instanceof HSSPrivateKeyParameters) {
            return (HSSPrivateKeyParameters) obj;
        }
        if (obj instanceof DataInputStream) {
            DataInputStream dataInputStream = (DataInputStream) obj;
            if (dataInputStream.readInt() != 0) {
                throw new IllegalStateException("unknown version for hss private key");
            }
            int i = dataInputStream.readInt();
            long j = dataInputStream.readLong();
            long j2 = dataInputStream.readLong();
            boolean z = dataInputStream.readBoolean();
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (int i2 = 0; i2 < i; i2++) {
                arrayList.add(LMSPrivateKeyParameters.getInstance(obj));
            }
            for (int i3 = 0; i3 < i - 1; i3++) {
                arrayList2.add(LMSSignature.getInstance(obj));
            }
            return new HSSPrivateKeyParameters(i, arrayList, arrayList2, j, j2, z);
        }
        if (!(obj instanceof byte[])) {
            if (obj instanceof InputStream) {
                return getInstance(C6257Streams.m18363readAll((InputStream) obj));
            }
            throw new IllegalArgumentException("cannot parse " + obj);
        }
        DataInputStream dataInputStream2 = null;
        try {
            DataInputStream dataInputStream3 = new DataInputStream(new ByteArrayInputStream((byte[]) obj));
            try {
                try {
                    HSSPrivateKeyParameters hSSPrivateKeyParameters = getInstance(dataInputStream3);
                    dataInputStream3.close();
                    return hSSPrivateKeyParameters;
                } catch (Exception unused) {
                    HSSPrivateKeyParameters hSSPrivateKeyParameters2 = new HSSPrivateKeyParameters(LMSPrivateKeyParameters.getInstance(obj), r3.getIndex(), r3.getIndexLimit());
                    dataInputStream3.close();
                    return hSSPrivateKeyParameters2;
                }
            } catch (Throwable th) {
                th = th;
                dataInputStream2 = dataInputStream3;
                if (dataInputStream2 != null) {
                    dataInputStream2.close();
                }
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    private static HSSPrivateKeyParameters makeCopy(HSSPrivateKeyParameters hSSPrivateKeyParameters) {
        try {
            return getInstance(hSSPrivateKeyParameters.getEncoded());
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }

    /* renamed from: clone */
    public Object m17611clone() {
        return makeCopy(this);
    }

    /* renamed from: equals */
    public boolean m17612equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        HSSPrivateKeyParameters hSSPrivateKeyParameters = (HSSPrivateKeyParameters) obj;
        if (this.f23220l == hSSPrivateKeyParameters.f23220l && this.f23218isShard == hSSPrivateKeyParameters.f23218isShard && this.indexLimit == hSSPrivateKeyParameters.indexLimit && this.f23217index == hSSPrivateKeyParameters.f23217index && this.f23219keys.equals(hSSPrivateKeyParameters.f23219keys)) {
            return this.f23221sig.equals(hSSPrivateKeyParameters.f23221sig);
        }
        return false;
    }

    public HSSPrivateKeyParameters extractKeyShard(int i) {
        HSSPrivateKeyParameters hSSPrivateKeyParametersMakeCopy;
        synchronized (this) {
            try {
                if (i < 0) {
                    throw new IllegalArgumentException("usageCount cannot be negative");
                }
                long j = i;
                long j2 = this.indexLimit;
                long j3 = this.f23217index;
                if (j > j2 - j3) {
                    throw new IllegalArgumentException("usageCount exceeds usages remaining in current leaf");
                }
                long j4 = j3 + j;
                this.f23217index = j4;
                hSSPrivateKeyParametersMakeCopy = makeCopy(new HSSPrivateKeyParameters(this.f23220l, new ArrayList(m17613getKeys()), new ArrayList(m17615getSig()), j3, j4, true));
                resetKeyToIndex();
            } catch (Throwable th) {
                throw th;
            }
        }
        return hSSPrivateKeyParametersMakeCopy;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedSigner
    public LMSContext generateLMSContext() {
        LMSPrivateKeyParameters lMSPrivateKeyParameters;
        LMSSignedPubKey[] lMSSignedPubKeyArr;
        int iM17614getL = m17614getL();
        synchronized (this) {
            try {
                C6066HSS.rangeTestKeys(this);
                List<LMSPrivateKeyParameters> listM17613getKeys = m17613getKeys();
                List<LMSSignature> listM17615getSig = m17615getSig();
                int i = iM17614getL - 1;
                lMSPrivateKeyParameters = m17613getKeys().get(i);
                lMSSignedPubKeyArr = new LMSSignedPubKey[i];
                int i2 = 0;
                while (i2 < i) {
                    int i3 = i2 + 1;
                    lMSSignedPubKeyArr[i2] = new LMSSignedPubKey(listM17615getSig.get(i2), listM17613getKeys.get(i3).getPublicKey());
                    i2 = i3;
                }
                incIndex();
            } catch (Throwable th) {
                throw th;
            }
        }
        return lMSPrivateKeyParameters.generateLMSContext().withSignedPublicKeys(lMSSignedPubKeyArr);
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedSigner
    public byte[] generateSignature(LMSContext lMSContext) {
        try {
            return C6066HSS.generateSignature(m17614getL(), lMSContext).getEncoded();
        } catch (IOException e) {
            throw new IllegalStateException("unable to encode signature: " + e.getMessage(), e);
        }
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSKeyParameters, org.bouncycastle.p361util.Encodable
    public synchronized byte[] getEncoded() {
        Composer composerM17599bool;
        try {
            composerM17599bool = Composer.m17598compose().m17609u32str(0).m17609u32str(this.f23220l).m17610u64str(this.f23217index).m17610u64str(this.indexLimit).m17599bool(this.f23218isShard);
            Iterator<LMSPrivateKeyParameters> it = this.f23219keys.iterator();
            while (it.hasNext()) {
                composerM17599bool.m17601bytes(it.next());
            }
            Iterator<LMSSignature> it2 = this.f23221sig.iterator();
            while (it2.hasNext()) {
                composerM17599bool.m17601bytes(it2.next());
            }
        } catch (Throwable th) {
            throw th;
        }
        return composerM17599bool.m17600build();
    }

    public synchronized long getIndex() {
        return this.f23217index;
    }

    public long getIndexLimit() {
        return this.indexLimit;
    }

    /* renamed from: getKeys */
    public synchronized List<LMSPrivateKeyParameters> m17613getKeys() {
        return this.f23219keys;
    }

    /* renamed from: getL */
    public int m17614getL() {
        return this.f23220l;
    }

    public synchronized LMSParameters[] getLMSParameters() {
        LMSParameters[] lMSParametersArr;
        int size = this.f23219keys.size();
        lMSParametersArr = new LMSParameters[size];
        for (int i = 0; i < size; i++) {
            LMSPrivateKeyParameters lMSPrivateKeyParameters = this.f23219keys.get(i);
            lMSParametersArr[i] = new LMSParameters(lMSPrivateKeyParameters.getSigParameters(), lMSPrivateKeyParameters.getOtsParameters());
        }
        return lMSParametersArr;
    }

    public synchronized HSSPublicKeyParameters getPublicKey() {
        return new HSSPublicKeyParameters(this.f23220l, getRootKey().getPublicKey());
    }

    public LMSPrivateKeyParameters getRootKey() {
        return this.f23219keys.get(0);
    }

    /* renamed from: getSig */
    public synchronized List<LMSSignature> m17615getSig() {
        return this.f23221sig;
    }

    @Override // org.bouncycastle.p314pqc.p316crypto.p321lms.LMSContextBasedSigner
    public long getUsagesRemaining() {
        return getIndexLimit() - getIndex();
    }

    public int hashCode() {
        int iHashCode = ((((((this.f23220l * 31) + (this.f23218isShard ? 1 : 0)) * 31) + this.f23219keys.hashCode()) * 31) + this.f23221sig.hashCode()) * 31;
        long j = this.indexLimit;
        int i = (iHashCode + ((int) (j ^ (j >>> 32)))) * 31;
        long j2 = this.f23217index;
        return i + ((int) (j2 ^ (j2 >>> 32)));
    }

    public synchronized void incIndex() {
        this.f23217index++;
    }

    /* renamed from: isShard */
    public boolean m17616isShard() {
        return this.f23218isShard;
    }

    public void replaceConsumedKey(int i) {
        int i2 = i - 1;
        LMOtsPrivateKey currentOTSKey = this.f23219keys.get(i2).getCurrentOTSKey();
        int iM17622getN = currentOTSKey.getParameter().m17622getN();
        SeedDerive derivationFunction = currentOTSKey.getDerivationFunction();
        derivationFunction.m17663setJ(-2);
        byte[] bArr = new byte[iM17622getN];
        derivationFunction.deriveSeed(bArr, true);
        byte[] bArr2 = new byte[iM17622getN];
        derivationFunction.deriveSeed(bArr2, false);
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr2, 0, bArr3, 0, 16);
        ArrayList arrayList = new ArrayList(this.f23219keys);
        LMSPrivateKeyParameters lMSPrivateKeyParameters = this.f23219keys.get(i);
        arrayList.set(i, C6068LMS.generateKeys(lMSPrivateKeyParameters.getSigParameters(), lMSPrivateKeyParameters.getOtsParameters(), 0, bArr3, bArr));
        ArrayList arrayList2 = new ArrayList(this.f23221sig);
        arrayList2.set(i2, C6068LMS.generateSign((LMSPrivateKeyParameters) arrayList.get(i2), ((LMSPrivateKeyParameters) arrayList.get(i)).getPublicKey().toByteArray()));
        this.f23219keys = Collections.unmodifiableList(arrayList);
        this.f23221sig = Collections.unmodifiableList(arrayList2);
    }

    public void resetKeyToIndex() {
        boolean z;
        List<LMSPrivateKeyParameters> listM17613getKeys = m17613getKeys();
        int size = listM17613getKeys.size();
        long[] jArr = new long[size];
        long index = getIndex();
        for (int size2 = listM17613getKeys.size() - 1; size2 >= 0; size2--) {
            LMSigParameters sigParameters = listM17613getKeys.get(size2).getSigParameters();
            jArr[size2] = ((1 << sigParameters.m17653getH()) - 1) & index;
            index >>>= sigParameters.m17653getH();
        }
        LMSPrivateKeyParameters[] lMSPrivateKeyParametersArr = (LMSPrivateKeyParameters[]) listM17613getKeys.toArray(new LMSPrivateKeyParameters[listM17613getKeys.size()]);
        List<LMSSignature> list = this.f23221sig;
        LMSSignature[] lMSSignatureArr = (LMSSignature[]) list.toArray(new LMSSignature[list.size()]);
        LMSPrivateKeyParameters rootKey = getRootKey();
        if (lMSPrivateKeyParametersArr[0].getIndex() - 1 != jArr[0]) {
            lMSPrivateKeyParametersArr[0] = C6068LMS.generateKeys(rootKey.getSigParameters(), rootKey.getOtsParameters(), (int) jArr[0], rootKey.m17643getI(), rootKey.getMasterSecret());
            z = true;
        } else {
            z = false;
        }
        int i = 1;
        while (i < size) {
            int i2 = i - 1;
            LMSPrivateKeyParameters lMSPrivateKeyParameters = lMSPrivateKeyParametersArr[i2];
            int iM17622getN = lMSPrivateKeyParameters.getOtsParameters().m17622getN();
            byte[] bArr = new byte[16];
            byte[] bArr2 = new byte[iM17622getN];
            SeedDerive seedDerive = new SeedDerive(lMSPrivateKeyParameters.m17643getI(), lMSPrivateKeyParameters.getMasterSecret(), DigestUtil.getDigest(lMSPrivateKeyParameters.getOtsParameters()));
            seedDerive.m17664setQ((int) jArr[i2]);
            seedDerive.m17663setJ(-2);
            seedDerive.deriveSeed(bArr2, true);
            byte[] bArr3 = new byte[iM17622getN];
            seedDerive.deriveSeed(bArr3, false);
            System.arraycopy(bArr3, 0, bArr, 0, 16);
            boolean z2 = i >= size + (-1) ? jArr[i] == ((long) lMSPrivateKeyParametersArr[i].getIndex()) : jArr[i] == ((long) (lMSPrivateKeyParametersArr[i].getIndex() - 1));
            if (!C6238Arrays.areEqual(bArr, lMSPrivateKeyParametersArr[i].m17643getI()) || !C6238Arrays.areEqual(bArr2, lMSPrivateKeyParametersArr[i].getMasterSecret())) {
                LMSPrivateKeyParameters lMSPrivateKeyParametersGenerateKeys = C6068LMS.generateKeys(listM17613getKeys.get(i).getSigParameters(), listM17613getKeys.get(i).getOtsParameters(), (int) jArr[i], bArr, bArr2);
                lMSPrivateKeyParametersArr[i] = lMSPrivateKeyParametersGenerateKeys;
                lMSSignatureArr[i2] = C6068LMS.generateSign(lMSPrivateKeyParametersArr[i2], lMSPrivateKeyParametersGenerateKeys.getPublicKey().toByteArray());
            } else if (z2) {
                i++;
            } else {
                lMSPrivateKeyParametersArr[i] = C6068LMS.generateKeys(listM17613getKeys.get(i).getSigParameters(), listM17613getKeys.get(i).getOtsParameters(), (int) jArr[i], bArr, bArr2);
            }
            z = true;
            i++;
        }
        if (z) {
            updateHierarchy(lMSPrivateKeyParametersArr, lMSSignatureArr);
        }
    }

    public void updateHierarchy(LMSPrivateKeyParameters[] lMSPrivateKeyParametersArr, LMSSignature[] lMSSignatureArr) {
        synchronized (this) {
            this.f23219keys = Collections.unmodifiableList(Arrays.asList(lMSPrivateKeyParametersArr));
            this.f23221sig = Collections.unmodifiableList(Arrays.asList(lMSSignatureArr));
        }
    }

    private HSSPrivateKeyParameters(int i, List<LMSPrivateKeyParameters> list, List<LMSSignature> list2, long j, long j2, boolean z) {
        super(true);
        this.f23217index = 0L;
        this.f23220l = i;
        this.f23219keys = Collections.unmodifiableList(list);
        this.f23221sig = Collections.unmodifiableList(list2);
        this.f23217index = j;
        this.indexLimit = j2;
        this.f23218isShard = z;
    }

    public static HSSPrivateKeyParameters getInstance(byte[] bArr, byte[] bArr2) throws Throwable {
        HSSPrivateKeyParameters hSSPrivateKeyParameters = getInstance(bArr);
        hSSPrivateKeyParameters.publicKey = HSSPublicKeyParameters.getInstance(bArr2);
        return hSSPrivateKeyParameters;
    }

    public HSSPrivateKeyParameters(LMSPrivateKeyParameters lMSPrivateKeyParameters, long j, long j2) {
        super(true);
        this.f23217index = 0L;
        this.f23220l = 1;
        this.f23219keys = Collections.singletonList(lMSPrivateKeyParameters);
        this.f23221sig = Collections.emptyList();
        this.f23217index = j;
        this.indexLimit = j2;
        this.f23218isShard = false;
        resetKeyToIndex();
    }
}
