package org.bouncycastle.p249jcajce;

import java.io.IOException;
import java.security.PrivateKey;
import java.security.Provider;
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
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p167sec.ECPrivateKey;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p249jcajce.interfaces.MLDSAPrivateKey;
import org.bouncycastle.p249jcajce.provider.asymmetric.compositesignatures.CompositeIndex;
import org.bouncycastle.p249jcajce.provider.asymmetric.compositesignatures.KeyFactorySpi;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
public class CompositePrivateKey implements PrivateKey {
    private AlgorithmIdentifier algorithmIdentifier;

    /* renamed from: keys */
    private final List<PrivateKey> f21351keys;
    private final List<Provider> providers;

    /* renamed from: org.bouncycastle.jcajce.CompositePrivateKey$Builder */
    public static class C5469Builder {
        private final AlgorithmIdentifier algorithmIdentifier;

        /* renamed from: count */
        private int f21352count;

        /* renamed from: keys */
        private final PrivateKey[] f21353keys;
        private final Provider[] providers;

        private C5469Builder(AlgorithmIdentifier algorithmIdentifier) {
            this.f21353keys = new PrivateKey[2];
            this.providers = new Provider[2];
            this.f21352count = 0;
            this.algorithmIdentifier = algorithmIdentifier;
        }

        public C5469Builder addPrivateKey(PrivateKey privateKey) {
            return addPrivateKey(privateKey, (Provider) null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* renamed from: build */
        public CompositePrivateKey m16057build() {
            Provider[] providerArr = this.providers;
            return (providerArr[0] == null && providerArr[1] == null) ? new CompositePrivateKey(this.algorithmIdentifier, this.f21353keys, null) : new CompositePrivateKey(this.algorithmIdentifier, this.f21353keys, providerArr);
        }

        public C5469Builder addPrivateKey(PrivateKey privateKey, String str) {
            return addPrivateKey(privateKey, Security.getProvider(str));
        }

        public C5469Builder addPrivateKey(PrivateKey privateKey, Provider provider) {
            int i = this.f21352count;
            PrivateKey[] privateKeyArr = this.f21353keys;
            if (i != privateKeyArr.length) {
                privateKeyArr[i] = privateKey;
                Provider[] providerArr = this.providers;
                this.f21352count = i + 1;
                providerArr[i] = provider;
                return this;
            }
            throw new IllegalStateException("only " + this.f21353keys.length + " allowed in composite");
        }
    }

    public CompositePrivateKey(ASN1ObjectIdentifier aSN1ObjectIdentifier, PrivateKey... privateKeyArr) {
        this(new AlgorithmIdentifier(aSN1ObjectIdentifier), privateKeyArr);
    }

    /* renamed from: builder */
    public static C5469Builder m16054builder(String str) {
        return m16055builder(CompositeUtil.m16062getOid(str));
    }

    private PrivateKey processKey(PrivateKey privateKey) {
        if (privateKey instanceof MLDSAPrivateKey) {
            try {
                return ((MLDSAPrivateKey) privateKey).getPrivateKey(true);
            } catch (Exception unused) {
            }
        }
        return privateKey;
    }

    /* renamed from: equals */
    public boolean m16056equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CompositePrivateKey)) {
            return false;
        }
        CompositePrivateKey compositePrivateKey = (CompositePrivateKey) obj;
        return compositePrivateKey.getAlgorithmIdentifier().mo14431equals(this.algorithmIdentifier) && this.f21351keys.equals(compositePrivateKey.f21351keys);
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
        ASN1OctetString privateKey;
        byte[] encoded;
        ASN1ObjectIdentifier algorithm = this.algorithmIdentifier.getAlgorithm();
        byte[] bArrConcatenate = null;
        int i = 0;
        if (!algorithm.m14435on(IANAObjectIdentifiers.f21257id_alg)) {
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            if (MiscObjectIdentifiers.id_composite_key.m14446equals((ASN1Primitive) algorithm)) {
                while (i < this.f21351keys.size()) {
                    aSN1EncodableVector.m14420add(PrivateKeyInfo.getInstance(this.f21351keys.get(i).getEncoded()));
                    i++;
                }
                try {
                    return new PrivateKeyInfo(this.algorithmIdentifier, new DERSequence(aSN1EncodableVector)).getEncoded(ASN1Encoding.f17902DER);
                } catch (IOException e) {
                    throw new IllegalStateException("unable to encode composite private key: " + e.getMessage());
                }
            }
            while (i < this.f21351keys.size()) {
                bArrConcatenate = C6238Arrays.concatenate(bArrConcatenate, PrivateKeyInfo.getInstance(this.f21351keys.get(i).getEncoded()).getPrivateKey().getOctets());
                i++;
            }
            try {
                return new PrivateKeyInfo(this.algorithmIdentifier, bArrConcatenate).getEncoded(ASN1Encoding.f17902DER);
            } catch (IOException e2) {
                throw new IllegalStateException("unable to encode composite private key: " + e2.getMessage());
            }
        }
        try {
            PrivateKey privateKey2 = this.f21351keys.get(0);
            PrivateKey privateKey3 = this.f21351keys.get(1);
            byte[] bArrMo16063getSeed = ((MLDSAPrivateKey) privateKey2).mo16063getSeed();
            PrivateKeyInfo privateKeyInfo = PrivateKeyInfo.getInstance(privateKey3.getEncoded());
            String algorithm2 = privateKey3.getAlgorithm();
            if (algorithm2.contains("Ed")) {
                privateKey = ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey());
            } else {
                if (algorithm2.contains("EC")) {
                    ECPrivateKey eCPrivateKey = ECPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
                    if (eCPrivateKey.getPublicKey() != null) {
                        eCPrivateKey = new ECPrivateKey(eCPrivateKey.getPrivateKey(), eCPrivateKey.getParametersObject(), (ASN1BitString) null);
                    }
                    encoded = eCPrivateKey.getEncoded(ASN1Encoding.f17902DER);
                    return new PrivateKeyInfo(this.algorithmIdentifier, C6238Arrays.concatenate(bArrMo16063getSeed, encoded)).getEncoded();
                }
                privateKey = privateKeyInfo.getPrivateKey();
            }
            encoded = privateKey.getOctets();
            return new PrivateKeyInfo(this.algorithmIdentifier, C6238Arrays.concatenate(bArrMo16063getSeed, encoded)).getEncoded();
        } catch (IOException e3) {
            throw new IllegalStateException("unable to encode composite public key: " + e3.getMessage());
        }
    }

    @Override // java.security.Key
    public String getFormat() {
        return "PKCS#8";
    }

    public List<PrivateKey> getPrivateKeys() {
        return this.f21351keys;
    }

    public List<Provider> getProviders() {
        return this.providers;
    }

    public int hashCode() {
        return this.f21351keys.hashCode();
    }

    public CompositePrivateKey(PrivateKeyInfo privateKeyInfo) {
        try {
            if (!CompositeIndex.isAlgorithmSupported(privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm())) {
                throw new IllegalStateException("Unable to create CompositePrivateKey from PrivateKeyInfo");
            }
            CompositePrivateKey compositePrivateKey = (CompositePrivateKey) new KeyFactorySpi().generatePrivate(privateKeyInfo);
            if (compositePrivateKey == null) {
                throw new IllegalStateException("Unable to create CompositePrivateKey from PrivateKeyInfo");
            }
            this.f21351keys = compositePrivateKey.getPrivateKeys();
            this.providers = null;
            this.algorithmIdentifier = compositePrivateKey.getAlgorithmIdentifier();
        } catch (IOException e) {
            throw Exceptions.illegalStateException(e.getMessage(), e);
        }
    }

    /* renamed from: builder */
    public static C5469Builder m16055builder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return new C5469Builder(new AlgorithmIdentifier(aSN1ObjectIdentifier));
    }

    public CompositePrivateKey(AlgorithmIdentifier algorithmIdentifier, PrivateKey... privateKeyArr) {
        this.algorithmIdentifier = algorithmIdentifier;
        if (privateKeyArr == null || privateKeyArr.length == 0) {
            throw new IllegalArgumentException("at least one private key must be provided for the composite private key");
        }
        ArrayList arrayList = new ArrayList(privateKeyArr.length);
        for (PrivateKey privateKey : privateKeyArr) {
            arrayList.add(processKey(privateKey));
        }
        this.f21351keys = Collections.unmodifiableList(arrayList);
        this.providers = null;
    }

    private CompositePrivateKey(AlgorithmIdentifier algorithmIdentifier, PrivateKey[] privateKeyArr, Provider[] providerArr) {
        List<Provider> listUnmodifiableList;
        this.algorithmIdentifier = algorithmIdentifier;
        if (privateKeyArr.length != 2) {
            throw new IllegalArgumentException("two keys required for composite private key");
        }
        ArrayList arrayList = new ArrayList(privateKeyArr.length);
        int i = 0;
        if (providerArr == null) {
            while (i < privateKeyArr.length) {
                arrayList.add(processKey(privateKeyArr[i]));
                i++;
            }
            listUnmodifiableList = null;
        } else {
            ArrayList arrayList2 = new ArrayList(providerArr.length);
            while (i < privateKeyArr.length) {
                arrayList2.add(providerArr[i]);
                arrayList.add(processKey(privateKeyArr[i]));
                i++;
            }
            listUnmodifiableList = Collections.unmodifiableList(arrayList2);
        }
        this.providers = listUnmodifiableList;
        this.f21351keys = Collections.unmodifiableList(arrayList);
    }

    public CompositePrivateKey(PrivateKey... privateKeyArr) {
        this(MiscObjectIdentifiers.id_composite_key, privateKeyArr);
    }
}
