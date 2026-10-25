package org.bouncycastle.operator.p305bc;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p148gm.GMObjectIdentifiers;
import org.bouncycastle.p133asn1.p158misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p194crypto.ExtendedDigest;
import org.bouncycastle.p194crypto.InterfaceC5284Xof;
import org.bouncycastle.p194crypto.p199digests.Blake3Digest;
import org.bouncycastle.p194crypto.p199digests.GOST3411Digest;
import org.bouncycastle.p194crypto.p199digests.GOST3411_2012_256Digest;
import org.bouncycastle.p194crypto.p199digests.GOST3411_2012_512Digest;
import org.bouncycastle.p194crypto.p199digests.MD2Digest;
import org.bouncycastle.p194crypto.p199digests.MD4Digest;
import org.bouncycastle.p194crypto.p199digests.MD5Digest;
import org.bouncycastle.p194crypto.p199digests.RIPEMD128Digest;
import org.bouncycastle.p194crypto.p199digests.RIPEMD160Digest;
import org.bouncycastle.p194crypto.p199digests.RIPEMD256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p199digests.SHA224Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA384Digest;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p199digests.SM3Digest;

/* loaded from: classes2.dex */
public class BcDefaultDigestProvider implements BcDigestProvider {

    /* renamed from: lookup */
    private static final Map f22874lookup = createTable();
    public static final BcDigestProvider INSTANCE = new BcDefaultDigestProvider();

    public static class AdjustedXof implements InterfaceC5284Xof {

        /* renamed from: length */
        private final int f22875length;

        /* renamed from: xof */
        private final InterfaceC5284Xof f22876xof;

        public AdjustedXof(InterfaceC5284Xof interfaceC5284Xof, int i) {
            this.f22876xof = interfaceC5284Xof;
            this.f22875length = i;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: doFinal */
        public int mo14967doFinal(byte[] bArr, int i) {
            return mo14998doFinal(bArr, i, getDigestSize());
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
        public int doOutput(byte[] bArr, int i, int i2) {
            return this.f22876xof.doOutput(bArr, i, i2);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        public String getAlgorithmName() {
            return this.f22876xof.getAlgorithmName() + "-" + this.f22875length;
        }

        @Override // org.bouncycastle.p194crypto.ExtendedDigest
        public int getByteLength() {
            return this.f22876xof.getByteLength();
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        public int getDigestSize() {
            return (this.f22875length + 7) / 8;
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: reset */
        public void mo14968reset() {
            this.f22876xof.mo14968reset();
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: update */
        public void mo14969update(byte b) {
            this.f22876xof.mo14969update(b);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5284Xof
        /* renamed from: doFinal */
        public int mo14998doFinal(byte[] bArr, int i, int i2) {
            return this.f22876xof.mo14998doFinal(bArr, i, i2);
        }

        @Override // org.bouncycastle.p194crypto.InterfaceC5277Digest
        /* renamed from: update */
        public void mo14970update(byte[] bArr, int i, int i2) {
            this.f22876xof.mo14970update(bArr, i, i2);
        }
    }

    private BcDefaultDigestProvider() {
    }

    private static Map createTable() {
        HashMap map = new HashMap();
        map.put(OIWObjectIdentifiers.f18459idSHA1, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.1
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA1Digest();
            }
        });
        map.put(NISTObjectIdentifiers.id_sha224, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.2
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA224Digest();
            }
        });
        map.put(NISTObjectIdentifiers.id_sha256, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.3
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA256Digest();
            }
        });
        map.put(NISTObjectIdentifiers.id_sha384, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.4
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA384Digest();
            }
        });
        map.put(NISTObjectIdentifiers.id_sha512, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.5
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA512Digest();
            }
        });
        map.put(NISTObjectIdentifiers.id_sha3_224, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.6
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA3Digest(InterfaceC5102BERTags.f17976FLAGS);
            }
        });
        map.put(NISTObjectIdentifiers.id_sha3_256, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.7
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA3Digest(256);
            }
        });
        map.put(NISTObjectIdentifiers.id_sha3_384, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.8
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA3Digest(384);
            }
        });
        map.put(NISTObjectIdentifiers.id_sha3_512, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.9
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHA3Digest(512);
            }
        });
        map.put(NISTObjectIdentifiers.id_shake128, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.10
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHAKEDigest(128);
            }
        });
        map.put(NISTObjectIdentifiers.id_shake256, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.11
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SHAKEDigest(256);
            }
        });
        map.put(NISTObjectIdentifiers.id_shake128_len, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.12
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new AdjustedXof(new SHAKEDigest(128), ASN1Integer.getInstance(algorithmIdentifier.getParameters()).intValueExact());
            }
        });
        map.put(NISTObjectIdentifiers.id_shake256_len, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.13
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new AdjustedXof(new SHAKEDigest(256), ASN1Integer.getInstance(algorithmIdentifier.getParameters()).intValueExact());
            }
        });
        map.put(PKCSObjectIdentifiers.f18503md5, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.14
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new MD5Digest();
            }
        });
        map.put(PKCSObjectIdentifiers.f18502md4, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.15
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new MD4Digest();
            }
        });
        map.put(PKCSObjectIdentifiers.f18501md2, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.16
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new MD2Digest();
            }
        });
        map.put(CryptoProObjectIdentifiers.gostR3411, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.17
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new GOST3411Digest();
            }
        });
        map.put(RosstandartObjectIdentifiers.id_tc26_gost_3411_12_256, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.18
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new GOST3411_2012_256Digest();
            }
        });
        map.put(RosstandartObjectIdentifiers.id_tc26_gost_3411_12_512, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.19
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new GOST3411_2012_512Digest();
            }
        });
        map.put(TeleTrusTObjectIdentifiers.ripemd128, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.20
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new RIPEMD128Digest();
            }
        });
        map.put(TeleTrusTObjectIdentifiers.ripemd160, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.21
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new RIPEMD160Digest();
            }
        });
        map.put(TeleTrusTObjectIdentifiers.ripemd256, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.22
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new RIPEMD256Digest();
            }
        });
        map.put(GMObjectIdentifiers.f18386sm3, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.23
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new SM3Digest();
            }
        });
        map.put(MiscObjectIdentifiers.blake3_256, new BcDigestProvider() { // from class: org.bouncycastle.operator.bc.BcDefaultDigestProvider.24
            @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
            /* renamed from: get */
            public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) {
                return new Blake3Digest(256);
            }
        });
        return Collections.unmodifiableMap(map);
    }

    @Override // org.bouncycastle.operator.p305bc.BcDigestProvider
    /* renamed from: get */
    public ExtendedDigest mo14916get(AlgorithmIdentifier algorithmIdentifier) throws OperatorCreationException {
        BcDigestProvider bcDigestProvider = (BcDigestProvider) f22874lookup.get(algorithmIdentifier.getAlgorithm());
        if (bcDigestProvider != null) {
            return bcDigestProvider.mo14916get(algorithmIdentifier);
        }
        throw new OperatorCreationException("cannot recognise digest");
    }
}
