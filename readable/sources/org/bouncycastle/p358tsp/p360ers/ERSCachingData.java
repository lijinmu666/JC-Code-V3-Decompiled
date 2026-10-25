package org.bouncycastle.p358tsp.p360ers;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public abstract class ERSCachingData implements InterfaceC6235ERSData {
    private Map<CacheIndex, byte[]> preCalcs = new HashMap();

    public static class CacheIndex {

        /* renamed from: algId */
        final AlgorithmIdentifier f24180algId;
        final byte[] chainHash;

        private CacheIndex(AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
            this.f24180algId = algorithmIdentifier;
            this.chainHash = bArr;
        }

        /* renamed from: equals */
        public boolean m18213equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CacheIndex)) {
                return false;
            }
            CacheIndex cacheIndex = (CacheIndex) obj;
            return this.f24180algId.mo14431equals(cacheIndex.f24180algId) && C6238Arrays.areEqual(this.chainHash, cacheIndex.chainHash);
        }

        public int hashCode() {
            return (this.f24180algId.hashCode() * 31) + C6238Arrays.hashCode(this.chainHash);
        }
    }

    public abstract byte[] calculateHash(DigestCalculator digestCalculator, byte[] bArr);

    @Override // org.bouncycastle.p358tsp.p360ers.InterfaceC6235ERSData
    /* renamed from: getHash */
    public byte[] mo18212getHash(DigestCalculator digestCalculator, byte[] bArr) {
        CacheIndex cacheIndex = new CacheIndex(digestCalculator.getAlgorithmIdentifier(), bArr);
        if (this.preCalcs.containsKey(cacheIndex)) {
            return this.preCalcs.get(cacheIndex);
        }
        byte[] bArrCalculateHash = calculateHash(digestCalculator, bArr);
        this.preCalcs.put(cacheIndex, bArrCalculateHash);
        return bArrCalculateHash;
    }
}
