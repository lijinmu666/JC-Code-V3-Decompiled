package org.bouncycastle.p249jcajce;

import java.io.IOException;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.bouncycastle.internal.p231asn1.p237iana.IANAObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p249jcajce.provider.asymmetric.compositesignatures.CompositeIndex;
import org.bouncycastle.p249jcajce.provider.asymmetric.compositesignatures.KeyFactorySpi;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class CompositePublicKey implements PublicKey {
    private final AlgorithmIdentifier algorithmIdentifier;

    /* renamed from: keys */
    private final List<PublicKey> f21354keys;
    private final List<Provider> providers;

    /* renamed from: org.bouncycastle.jcajce.CompositePublicKey$Builder */
    public static class C5471Builder {
        private final AlgorithmIdentifier algorithmIdentifier;

        /* renamed from: count */
        private int f21355count;

        /* renamed from: keys */
        private final PublicKey[] f21356keys;
        private final Provider[] providers;

        private C5471Builder(AlgorithmIdentifier algorithmIdentifier) {
            this.f21356keys = new PublicKey[2];
            this.providers = new Provider[2];
            this.f21355count = 0;
            this.algorithmIdentifier = algorithmIdentifier;
        }

        public C5471Builder addPublicKey(PublicKey publicKey) {
            return addPublicKey(publicKey, (Provider) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: build */
        public CompositePublicKey m16061build() {
            Provider[] providerArr = this.providers;
            return (providerArr[0] == null && providerArr[1] == null) ? new CompositePublicKey(this.algorithmIdentifier, this.f21356keys, null) : new CompositePublicKey(this.algorithmIdentifier, this.f21356keys, providerArr);
        }

        public C5471Builder addPublicKey(PublicKey publicKey, String str) {
            return addPublicKey(publicKey, Security.getProvider(str));
        }

        public C5471Builder addPublicKey(PublicKey publicKey, Provider provider) {
            int i = this.f21355count;
            PublicKey[] publicKeyArr = this.f21356keys;
            if (i != publicKeyArr.length) {
                publicKeyArr[i] = publicKey;
                Provider[] providerArr = this.providers;
                this.f21355count = i + 1;
                providerArr[i] = provider;
                return this;
            }
            throw new IllegalStateException("only " + this.f21356keys.length + " allowed in composite");
        }
    }

    public CompositePublicKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, PublicKey... publicKeyArr) {
        this(new AlgorithmIdentifier(aSN1ObjectIdentifier), publicKeyArr);
    }

    /* renamed from: builder */
    public static C5471Builder m16058builder(String str) {
        return m16059builder(CompositeUtil.m16062getOid(str));
    }

    /* renamed from: equals */
    public boolean m16060equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CompositePublicKey)) {
            return false;
        }
        CompositePublicKey compositePublicKey = (CompositePublicKey) obj;
        return this.algorithmIdentifier.mo14431equals(compositePublicKey.algorithmIdentifier) && this.f21354keys.equals(compositePublicKey.f21354keys);
    }

    @Override // java.security.Key
    public String getAlgorithm() {
        return CompositeIndex.getAlgorithmName(this.algorithmIdentifier.getAlgorithm());
    }

    public AlgorithmIdentifier getAlgorithmIdentifier() {
        return this.algorithmIdentifier;
    }

    @Override // java.security.Key
    public byte[] getEncoded() {
        ASN1ObjectIdentifier algorithm = this.algorithmIdentifier.getAlgorithm();
        if (algorithm.m14435on(IANAObjectIdentifiers.f21257id_alg)) {
            try {
                return new SubjectPublicKeyInfo(this.algorithmIdentifier, C6238Arrays.concatenate(SubjectPublicKeyInfo.getInstance(this.f21354keys.get(0).getEncoded()).getPublicKeyData().getOctets(), SubjectPublicKeyInfo.getInstance(this.f21354keys.get(1).getEncoded()).getPublicKeyData().getOctets())).getEncoded(ASN1Encoding.f17902DER);
            } catch (IOException e) {
                throw new IllegalStateException("unable to encode composite public key: " + e.getMessage());
            }
        }
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i = 0; i < this.f21354keys.size(); i++) {
            SubjectPublicKeyInfo subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(this.f21354keys.get(i).getEncoded());
            ASN1BitString publicKeyData = subjectPublicKeyInfo;
            if (!MiscObjectIdentifiers.id_composite_key.m14446equals((ASN1Primitive) algorithm)) {
                publicKeyData = subjectPublicKeyInfo.getPublicKeyData();
            }
            aSN1EncodableVector.m14420add(publicKeyData);
        }
        try {
            return new SubjectPublicKeyInfo(this.algorithmIdentifier, new DERSequence(aSN1EncodableVector)).getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException e2) {
            throw new IllegalStateException("unable to encode composite public key: " + e2.getMessage());
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "X.509";
    }

    public List<Provider> getProviders() {
        return this.providers;
    }

    public List<PublicKey> getPublicKeys() {
        return this.f21354keys;
    }

    public int hashCode() {
        return this.f21354keys.hashCode() ^ this.algorithmIdentifier.hashCode();
    }

    public CompositePublicKey(AlgorithmIdentifier algorithmIdentifier, PublicKey... publicKeyArr) {
        this.algorithmIdentifier = algorithmIdentifier;
        if (publicKeyArr == null || publicKeyArr.length == 0) {
            throw new IllegalArgumentException("at least one public key must be provided for the composite public key");
        }
        ArrayList arrayList = new ArrayList(publicKeyArr.length);
        for (PublicKey publicKey : publicKeyArr) {
            arrayList.add(publicKey);
        }
        this.f21354keys = Collections.unmodifiableList(arrayList);
        this.providers = null;
    }

    /* renamed from: builder */
    public static C5471Builder m16059builder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return new C5471Builder(new AlgorithmIdentifier(aSN1ObjectIdentifier));
    }

    private CompositePublicKey(AlgorithmIdentifier algorithmIdentifier, PublicKey[] publicKeyArr, Provider[] providerArr) {
        List<Provider> listUnmodifiableList;
        this.algorithmIdentifier = algorithmIdentifier;
        if (publicKeyArr.length != 2) {
            throw new IllegalArgumentException("two keys required for composite private key");
        }
        ArrayList arrayList = new ArrayList(publicKeyArr.length);
        int i = 0;
        if (providerArr == null) {
            while (i < publicKeyArr.length) {
                arrayList.add(publicKeyArr[i]);
                i++;
            }
            listUnmodifiableList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(providerArr.length);
            while (i < publicKeyArr.length) {
                arrayList2.add(providerArr[i]);
                arrayList.add(publicKeyArr[i]);
                i++;
            }
            listUnmodifiableList = Collections.unmodifiableList(arrayList2);
        }
        this.providers = listUnmodifiableList;
        this.f21354keys = Collections.unmodifiableList(arrayList);
    }

    public CompositePublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        try {
            if (!CompositeIndex.isAlgorithmSupported(subjectPublicKeyInfo.getAlgorithm().getAlgorithm())) {
                throw new IllegalStateException("unable to create CompositePublicKey from SubjectPublicKeyInfo");
            }
            CompositePublicKey compositePublicKey = (CompositePublicKey) new KeyFactorySpi().generatePublic(subjectPublicKeyInfo);
            if (compositePublicKey == null) {
                throw new IllegalStateException("unable to create CompositePublicKey from SubjectPublicKeyInfo");
            }
            this.f21354keys = compositePublicKey.getPublicKeys();
            this.algorithmIdentifier = compositePublicKey.getAlgorithmIdentifier();
            this.providers = null;
        } catch (IOException e) {
            throw new IllegalStateException(e.getMessage(), e);
        }
    }

    public CompositePublicKey(PublicKey... publicKeyArr) {
        this(MiscObjectIdentifiers.id_composite_key, publicKeyArr);
    }
}
