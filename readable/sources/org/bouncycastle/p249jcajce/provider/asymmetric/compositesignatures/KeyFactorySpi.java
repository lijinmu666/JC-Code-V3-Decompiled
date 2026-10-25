package org.bouncycastle.p249jcajce.provider.asymmetric.compositesignatures;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bouncycastle.internal.p231asn1.p235edec.EdECObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p237iana.IANAObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p249jcajce.CompositePrivateKey;
import org.bouncycastle.p249jcajce.CompositePublicKey;
import org.bouncycastle.p249jcajce.p279spec.EdDSAParameterSpec;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.BaseKeyFactorySpi;
import org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
public class KeyFactorySpi extends BaseKeyFactorySpi implements AsymmetricKeyInfoConverter {
    private static Map<ASN1ObjectIdentifier, int[]> componentKeySizes;
    private static final AlgorithmIdentifier ecDsaBrainpoolP256r1;
    private static final AlgorithmIdentifier ecDsaBrainpoolP384r1;
    private static final AlgorithmIdentifier ecDsaP256;
    private static final AlgorithmIdentifier ecDsaP384;
    private static final AlgorithmIdentifier ecDsaP521;

    /* renamed from: ed25519 */
    private static final AlgorithmIdentifier f21405ed25519;

    /* renamed from: ed448 */
    private static final AlgorithmIdentifier f21406ed448;

    /* renamed from: mlDsa44 */
    private static final AlgorithmIdentifier f21407mlDsa44;

    /* renamed from: mlDsa65 */
    private static final AlgorithmIdentifier f21408mlDsa65;

    /* renamed from: mlDsa87 */
    private static final AlgorithmIdentifier f21409mlDsa87;
    private static Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> pairings;

    /* renamed from: rsa */
    private static final AlgorithmIdentifier f21410rsa;

    /* renamed from: helper */
    private JcaJceHelper f21411helper;

    static {
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_ml_dsa_44);
        f21407mlDsa44 = algorithmIdentifier;
        AlgorithmIdentifier algorithmIdentifier2 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_ml_dsa_65);
        f21408mlDsa65 = algorithmIdentifier2;
        AlgorithmIdentifier algorithmIdentifier3 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_ml_dsa_87);
        f21409mlDsa87 = algorithmIdentifier3;
        AlgorithmIdentifier algorithmIdentifier4 = new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed25519);
        f21405ed25519 = algorithmIdentifier4;
        AlgorithmIdentifier algorithmIdentifier5 = new AlgorithmIdentifier(EdECObjectIdentifiers.id_Ed448);
        f21406ed448 = algorithmIdentifier5;
        AlgorithmIdentifier algorithmIdentifierCreateECAlgID = createECAlgID(SECObjectIdentifiers.secp256r1);
        ecDsaP256 = algorithmIdentifierCreateECAlgID;
        AlgorithmIdentifier algorithmIdentifierCreateECAlgID2 = createECAlgID(SECObjectIdentifiers.secp384r1);
        ecDsaP384 = algorithmIdentifierCreateECAlgID2;
        AlgorithmIdentifier algorithmIdentifierCreateECAlgID3 = createECAlgID(SECObjectIdentifiers.secp521r1);
        ecDsaP521 = algorithmIdentifierCreateECAlgID3;
        AlgorithmIdentifier algorithmIdentifierCreateECAlgID4 = createECAlgID(TeleTrusTObjectIdentifiers.brainpoolP256r1);
        ecDsaBrainpoolP256r1 = algorithmIdentifierCreateECAlgID4;
        AlgorithmIdentifier algorithmIdentifierCreateECAlgID5 = createECAlgID(TeleTrusTObjectIdentifiers.brainpoolP384r1);
        ecDsaBrainpoolP384r1 = algorithmIdentifierCreateECAlgID5;
        AlgorithmIdentifier algorithmIdentifier6 = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption);
        f21410rsa = algorithmIdentifier6;
        pairings = new HashMap();
        componentKeySizes = new HashMap();
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = IANAObjectIdentifiers.id_MLDSA44_RSA2048_PSS_SHA256;
        map.put(aSN1ObjectIdentifier, new AlgorithmIdentifier[]{algorithmIdentifier, algorithmIdentifier6});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map2 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = IANAObjectIdentifiers.id_MLDSA44_RSA2048_PKCS15_SHA256;
        map2.put(aSN1ObjectIdentifier2, new AlgorithmIdentifier[]{algorithmIdentifier, algorithmIdentifier6});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map3 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = IANAObjectIdentifiers.id_MLDSA44_Ed25519_SHA512;
        map3.put(aSN1ObjectIdentifier3, new AlgorithmIdentifier[]{algorithmIdentifier, algorithmIdentifier4});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map4 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = IANAObjectIdentifiers.id_MLDSA44_ECDSA_P256_SHA256;
        map4.put(aSN1ObjectIdentifier4, new AlgorithmIdentifier[]{algorithmIdentifier, algorithmIdentifierCreateECAlgID});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map5 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = IANAObjectIdentifiers.id_MLDSA65_RSA3072_PSS_SHA512;
        map5.put(aSN1ObjectIdentifier5, new AlgorithmIdentifier[]{algorithmIdentifier2, algorithmIdentifier6});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map6 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = IANAObjectIdentifiers.id_MLDSA65_RSA3072_PKCS15_SHA512;
        map6.put(aSN1ObjectIdentifier6, new AlgorithmIdentifier[]{algorithmIdentifier2, algorithmIdentifier6});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map7 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = IANAObjectIdentifiers.id_MLDSA65_RSA4096_PSS_SHA512;
        map7.put(aSN1ObjectIdentifier7, new AlgorithmIdentifier[]{algorithmIdentifier2, algorithmIdentifier6});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map8 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = IANAObjectIdentifiers.id_MLDSA65_RSA4096_PKCS15_SHA512;
        map8.put(aSN1ObjectIdentifier8, new AlgorithmIdentifier[]{algorithmIdentifier2, algorithmIdentifier6});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map9 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = IANAObjectIdentifiers.id_MLDSA65_ECDSA_P256_SHA512;
        map9.put(aSN1ObjectIdentifier9, new AlgorithmIdentifier[]{algorithmIdentifier2, algorithmIdentifierCreateECAlgID});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map10 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = IANAObjectIdentifiers.id_MLDSA65_ECDSA_P384_SHA512;
        map10.put(aSN1ObjectIdentifier10, new AlgorithmIdentifier[]{algorithmIdentifier2, algorithmIdentifierCreateECAlgID2});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map11 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = IANAObjectIdentifiers.id_MLDSA65_ECDSA_brainpoolP256r1_SHA512;
        map11.put(aSN1ObjectIdentifier11, new AlgorithmIdentifier[]{algorithmIdentifier2, algorithmIdentifierCreateECAlgID4});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map12 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = IANAObjectIdentifiers.id_MLDSA65_Ed25519_SHA512;
        map12.put(aSN1ObjectIdentifier12, new AlgorithmIdentifier[]{algorithmIdentifier2, algorithmIdentifier4});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map13 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = IANAObjectIdentifiers.id_MLDSA87_ECDSA_P384_SHA512;
        map13.put(aSN1ObjectIdentifier13, new AlgorithmIdentifier[]{algorithmIdentifier3, algorithmIdentifierCreateECAlgID2});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map14 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = IANAObjectIdentifiers.id_MLDSA87_ECDSA_brainpoolP384r1_SHA512;
        map14.put(aSN1ObjectIdentifier14, new AlgorithmIdentifier[]{algorithmIdentifier3, algorithmIdentifierCreateECAlgID5});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map15 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = IANAObjectIdentifiers.id_MLDSA87_Ed448_SHAKE256;
        map15.put(aSN1ObjectIdentifier15, new AlgorithmIdentifier[]{algorithmIdentifier3, algorithmIdentifier5});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map16 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = IANAObjectIdentifiers.id_MLDSA87_RSA4096_PSS_SHA512;
        map16.put(aSN1ObjectIdentifier16, new AlgorithmIdentifier[]{algorithmIdentifier3, algorithmIdentifier6});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map17 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = IANAObjectIdentifiers.id_MLDSA87_ECDSA_P521_SHA512;
        map17.put(aSN1ObjectIdentifier17, new AlgorithmIdentifier[]{algorithmIdentifier3, algorithmIdentifierCreateECAlgID3});
        Map<ASN1ObjectIdentifier, AlgorithmIdentifier[]> map18 = pairings;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = IANAObjectIdentifiers.id_MLDSA87_RSA3072_PSS_SHA512;
        map18.put(aSN1ObjectIdentifier18, new AlgorithmIdentifier[]{algorithmIdentifier3, algorithmIdentifier6});
        componentKeySizes.put(aSN1ObjectIdentifier, new int[]{1312, 268});
        componentKeySizes.put(aSN1ObjectIdentifier2, new int[]{1312, 284});
        componentKeySizes.put(aSN1ObjectIdentifier3, new int[]{1312, 32});
        componentKeySizes.put(aSN1ObjectIdentifier4, new int[]{1312, 76});
        componentKeySizes.put(aSN1ObjectIdentifier5, new int[]{1952, 256});
        componentKeySizes.put(aSN1ObjectIdentifier6, new int[]{1952, 256});
        componentKeySizes.put(aSN1ObjectIdentifier7, new int[]{1952, 542});
        componentKeySizes.put(aSN1ObjectIdentifier8, new int[]{1952, 542});
        componentKeySizes.put(aSN1ObjectIdentifier9, new int[]{1952, 76});
        componentKeySizes.put(aSN1ObjectIdentifier10, new int[]{1952, 87});
        componentKeySizes.put(aSN1ObjectIdentifier11, new int[]{1952, 76});
        componentKeySizes.put(aSN1ObjectIdentifier12, new int[]{1952, 32});
        componentKeySizes.put(aSN1ObjectIdentifier13, new int[]{2592, 87});
        componentKeySizes.put(aSN1ObjectIdentifier14, new int[]{2592, 87});
        componentKeySizes.put(aSN1ObjectIdentifier15, new int[]{2592, 57});
        componentKeySizes.put(aSN1ObjectIdentifier16, new int[]{2592, 542});
        componentKeySizes.put(aSN1ObjectIdentifier18, new int[]{2592, 256});
        componentKeySizes.put(aSN1ObjectIdentifier17, new int[]{2592, 93});
    }

    public KeyFactorySpi() {
        this(null);
    }

    private static AlgorithmIdentifier createECAlgID(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, new X962Parameters(aSN1ObjectIdentifier));
    }

    private List<KeyFactory> getKeyFactoriesFromIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier) throws NoSuchAlgorithmException {
        ArrayList arrayList = new ArrayList();
        new ArrayList();
        String[] pairing = CompositeIndex.getPairing(aSN1ObjectIdentifier);
        if (pairing == null) {
            throw new NoSuchAlgorithmException("Cannot create KeyFactories. Unsupported algorithm identifier.");
        }
        arrayList.add(this.f21411helper.createKeyFactory(CompositeIndex.getBaseName(pairing[0])));
        arrayList.add(this.f21411helper.createKeyFactory(CompositeIndex.getBaseName(pairing[1])));
        return Collections.unmodifiableList(arrayList);
    }

    private X509EncodedKeySpec[] getKeysSpecs(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1BitString[] aSN1BitStringArr) throws IOException {
        X509EncodedKeySpec[] x509EncodedKeySpecArr = new X509EncodedKeySpec[aSN1BitStringArr.length];
        SubjectPublicKeyInfo[] subjectPublicKeyInfoArr = new SubjectPublicKeyInfo[aSN1BitStringArr.length];
        AlgorithmIdentifier[] algorithmIdentifierArr = pairings.get(aSN1ObjectIdentifier);
        if (algorithmIdentifierArr == null) {
            throw new IOException("Cannot create key specs. Unsupported algorithm identifier.");
        }
        subjectPublicKeyInfoArr[0] = new SubjectPublicKeyInfo(algorithmIdentifierArr[0], aSN1BitStringArr[0]);
        subjectPublicKeyInfoArr[1] = new SubjectPublicKeyInfo(algorithmIdentifierArr[1], aSN1BitStringArr[1]);
        x509EncodedKeySpecArr[0] = new X509EncodedKeySpec(subjectPublicKeyInfoArr[0].getEncoded());
        x509EncodedKeySpecArr[1] = new X509EncodedKeySpec(subjectPublicKeyInfoArr[1].getEncoded());
        return x509EncodedKeySpecArr;
    }

    @Override // java.security.KeyFactorySpi
    public Key engineTranslateKey(Key key) throws InvalidKeyException {
        if (this.f21411helper == null) {
            this.f21411helper = new BCJcaJceHelper();
        }
        try {
            if (key instanceof PrivateKey) {
                return generatePrivate(PrivateKeyInfo.getInstance(key.getEncoded()));
            }
            if (key instanceof PublicKey) {
                return generatePublic(SubjectPublicKeyInfo.getInstance(key.getEncoded()));
            }
            throw new InvalidKeyException("Key not recognized");
        } catch (IOException e) {
            throw new InvalidKeyException("Key could not be parsed: " + e.getMessage());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x00c2 A[Catch: GeneralSecurityException -> 0x007d, TryCatch #2 {GeneralSecurityException -> 0x007d, blocks: (B:10:0x0028, B:14:0x0046, B:16:0x0066, B:17:0x0079, B:24:0x00a9, B:25:0x00bc, B:27:0x00c2, B:29:0x00ca, B:31:0x0123, B:30:0x0102, B:32:0x0125, B:20:0x0080, B:22:0x0088, B:23:0x009c, B:13:0x003e, B:11:0x0031), top: B:51:0x0028, inners: #0 }] */
    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public PrivateKey generatePrivate(PrivateKeyInfo privateKeyInfo) throws IOException {
        byte[] octets;
        DEROctetString dEROctetString;
        DERSequence dERSequence;
        if (this.f21411helper == null) {
            this.f21411helper = new BCJcaJceHelper();
        }
        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        int i = 0;
        if (MiscObjectIdentifiers.id_alg_composite.m14446equals((ASN1Primitive) algorithm) || MiscObjectIdentifiers.id_composite_key.m14446equals((ASN1Primitive) algorithm)) {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(privateKeyInfo.parsePrivateKey());
            PrivateKey[] privateKeyArr = new PrivateKey[aSN1Sequence.mo14450size()];
            while (i != aSN1Sequence.mo14450size()) {
                PrivateKeyInfo privateKeyInfo2 = PrivateKeyInfo.getInstance(ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i)));
                try {
                    privateKeyArr[i] = this.f21411helper.createKeyFactory(privateKeyInfo2.getPrivateKeyAlgorithm().getAlgorithm().m14433getId()).generatePrivate(new PKCS8EncodedKeySpec(privateKeyInfo2.getEncoded()));
                    i++;
                } catch (Exception e) {
                    throw new IOException("cannot decode generic composite: " + e.getMessage(), e);
                }
            }
            return new CompositePrivateKey(privateKeyArr);
        }
        try {
            List<KeyFactory> keyFactoriesFromIdentifier = getKeyFactoriesFromIdentifier(algorithm);
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            try {
                octets = ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets();
            } catch (Exception unused) {
                octets = privateKeyInfo.getPrivateKey().getOctets();
            }
            aSN1EncodableVector.m14420add(new DEROctetString(C6238Arrays.copyOfRange(octets, 0, 32)));
            String algorithm2 = keyFactoriesFromIdentifier.get(1).getAlgorithm();
            if (algorithm2.equals(EdDSAParameterSpec.f21918Ed25519)) {
                dEROctetString = new DEROctetString(C6238Arrays.concatenate(new byte[]{4, 32}, C6238Arrays.copyOfRange(octets, 32, octets.length)));
            } else {
                if (!algorithm2.equals(EdDSAParameterSpec.f21919Ed448)) {
                    aSN1EncodableVector.m14420add(new DEROctetString(C6238Arrays.copyOfRange(octets, 32, octets.length)));
                    dERSequence = new DERSequence(aSN1EncodableVector);
                    PrivateKey[] privateKeyArr2 = new PrivateKey[dERSequence.mo14450size()];
                    AlgorithmIdentifier[] algorithmIdentifierArr = pairings.get(algorithm);
                    while (i < dERSequence.mo14450size()) {
                        if (dERSequence.getObjectAt(i) instanceof ASN1OctetString) {
                            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(3);
                            aSN1EncodableVector2.m14420add(privateKeyInfo.getVersion());
                            aSN1EncodableVector2.m14420add(algorithmIdentifierArr[i]);
                            aSN1EncodableVector2.m14420add(dERSequence.getObjectAt(i));
                            privateKeyArr2[i] = keyFactoriesFromIdentifier.get(i).generatePrivate(new PKCS8EncodedKeySpec(PrivateKeyInfo.getInstance(new DERSequence(aSN1EncodableVector2)).getEncoded()));
                        } else {
                            privateKeyArr2[i] = keyFactoriesFromIdentifier.get(i).generatePrivate(new PKCS8EncodedKeySpec(PrivateKeyInfo.getInstance(ASN1Sequence.getInstance(dERSequence.getObjectAt(i))).getEncoded()));
                        }
                        i++;
                    }
                    return new CompositePrivateKey(algorithm, privateKeyArr2);
                }
                dEROctetString = new DEROctetString(C6238Arrays.concatenate(new byte[]{4, 57}, C6238Arrays.copyOfRange(octets, 32, octets.length)));
            }
            aSN1EncodableVector.m14420add(dEROctetString);
            dERSequence = new DERSequence(aSN1EncodableVector);
            PrivateKey[] privateKeyArr22 = new PrivateKey[dERSequence.mo14450size()];
            AlgorithmIdentifier[] algorithmIdentifierArr2 = pairings.get(algorithm);
            while (i < dERSequence.mo14450size()) {
            }
            return new CompositePrivateKey(algorithm, privateKeyArr22);
        } catch (GeneralSecurityException e2) {
            throw Exceptions.ioException(e2.getMessage(), e2);
        }
    }

    @Override // org.bouncycastle.p249jcajce.provider.p278util.AsymmetricKeyInfoConverter
    public PublicKey generatePublic(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        ASN1Sequence aSN1Sequence;
        if (this.f21411helper == null) {
            this.f21411helper = new BCJcaJceHelper();
        }
        ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
        byte[][] bArrM16085split = new byte[2][];
        try {
            aSN1Sequence = ASN1Sequence.getInstance(subjectPublicKeyInfo.getPublicKeyData().getOctets());
        } catch (Exception unused) {
            bArrM16085split = m16085split(algorithm, subjectPublicKeyInfo.getPublicKeyData());
            aSN1Sequence = null;
        }
        int i = 0;
        if (MiscObjectIdentifiers.id_alg_composite.m14446equals((ASN1Primitive) algorithm) || MiscObjectIdentifiers.id_composite_key.m14446equals((ASN1Primitive) algorithm)) {
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(subjectPublicKeyInfo.getPublicKeyData().getOctets());
            PublicKey[] publicKeyArr = new PublicKey[aSN1Sequence2.mo14450size()];
            while (i != aSN1Sequence2.mo14450size()) {
                SubjectPublicKeyInfo subjectPublicKeyInfo2 = SubjectPublicKeyInfo.getInstance(aSN1Sequence2.getObjectAt(i));
                try {
                    publicKeyArr[i] = this.f21411helper.createKeyFactory(subjectPublicKeyInfo2.getAlgorithm().getAlgorithm().m14433getId()).generatePublic(new X509EncodedKeySpec(subjectPublicKeyInfo2.getEncoded()));
                    i++;
                } catch (Exception e) {
                    throw new IOException("cannot decode generic composite: " + e.getMessage(), e);
                }
            }
            return new CompositePublicKey(publicKeyArr);
        }
        try {
            int length = aSN1Sequence == null ? bArrM16085split.length : aSN1Sequence.mo14450size();
            List<KeyFactory> keyFactoriesFromIdentifier = getKeyFactoriesFromIdentifier(algorithm);
            ASN1BitString[] aSN1BitStringArr = new ASN1BitString[length];
            for (int i2 = 0; i2 < length; i2++) {
                if (aSN1Sequence == null) {
                    aSN1BitStringArr[i2] = new DERBitString(bArrM16085split[i2]);
                } else if (aSN1Sequence.getObjectAt(i2) instanceof DEROctetString) {
                    aSN1BitStringArr[i2] = new DERBitString(((DEROctetString) aSN1Sequence.getObjectAt(i2)).getOctets());
                } else {
                    aSN1BitStringArr[i2] = (DERBitString) aSN1Sequence.getObjectAt(i2);
                }
            }
            X509EncodedKeySpec[] keysSpecs = getKeysSpecs(algorithm, aSN1BitStringArr);
            PublicKey[] publicKeyArr2 = new PublicKey[length];
            while (i < length) {
                publicKeyArr2[i] = keyFactoriesFromIdentifier.get(i).generatePublic(keysSpecs[i]);
                i++;
            }
            return new CompositePublicKey(algorithm, publicKeyArr2);
        } catch (GeneralSecurityException e2) {
            throw Exceptions.ioException(e2.getMessage(), e2);
        }
    }

    /* renamed from: split */
    public byte[][] m16085split(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1BitString aSN1BitString) {
        int[] iArr = componentKeySizes.get(aSN1ObjectIdentifier);
        byte[] octets = aSN1BitString.getOctets();
        int i = iArr[0];
        byte[][] bArr = {new byte[i], new byte[octets.length - i]};
        System.arraycopy(octets, 0, bArr[0], 0, i);
        int i2 = iArr[0];
        byte[] bArr2 = bArr[1];
        System.arraycopy(octets, i2, bArr2, 0, bArr2.length);
        return bArr;
    }

    public KeyFactorySpi(JcaJceHelper jcaJceHelper) {
        this.f21411helper = jcaJceHelper;
    }
}
