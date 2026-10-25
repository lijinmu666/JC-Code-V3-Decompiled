package org.bouncycastle.p249jcajce.provider.asymmetric.p264util;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.DerivationFunction;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.agreement.p197kdf.ConcatenationKDFGenerator;
import org.bouncycastle.p194crypto.generators.HKDFBytesGenerator;
import org.bouncycastle.p194crypto.generators.KDF2BytesGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA384Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;
import org.bouncycastle.p194crypto.p209macs.C5362KMAC;
import org.bouncycastle.p194crypto.p213params.HKDFParameters;
import org.bouncycastle.p194crypto.p213params.KDFParameters;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p249jcajce.p279spec.KEMKDFSpec;
import org.bouncycastle.p361util.C6238Arrays;

/* renamed from: org.bouncycastle.jcajce.provider.asymmetric.util.KdfUtil */
/* loaded from: classes2.dex */
public class C5620KdfUtil {
    public static InterfaceC5277Digest getDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return new SHA256Digest();
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return new SHA512Digest();
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_shake128)) {
            return new SHAKEDigest(128);
        }
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_shake256)) {
            return new SHAKEDigest(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + aSN1ObjectIdentifier);
    }

    public static byte[] makeKeyBytes(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, byte[] bArr2, int i) {
        C5362KMAC c5362kmac;
        KeyParameter keyParameter;
        HKDFBytesGenerator hKDFBytesGenerator;
        HKDFParameters hKDFParameters;
        DerivationFunction concatenationKDFGenerator;
        KDFParameters kDFParameters;
        int i2 = (i + 7) / 8;
        byte[] bArr3 = new byte[i2];
        if (algorithmIdentifier == null) {
            System.arraycopy(bArr, 0, bArr3, 0, i2);
        } else {
            if (X9ObjectIdentifiers.id_kdf_kdf2.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
                concatenationKDFGenerator = new KDF2BytesGenerator(getDigest(AlgorithmIdentifier.getInstance(algorithmIdentifier.getParameters()).getAlgorithm()));
                kDFParameters = new KDFParameters(bArr, bArr2);
            } else if (X9ObjectIdentifiers.id_kdf_kdf3.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
                concatenationKDFGenerator = new ConcatenationKDFGenerator(getDigest(AlgorithmIdentifier.getInstance(algorithmIdentifier.getParameters()).getAlgorithm()));
                kDFParameters = new KDFParameters(bArr, bArr2);
            } else {
                if (PKCSObjectIdentifiers.id_alg_hkdf_with_sha256.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
                    if (algorithmIdentifier.getParameters() != null) {
                        throw new IllegalStateException("HDKF parameter support not added");
                    }
                    hKDFBytesGenerator = new HKDFBytesGenerator(new SHA256Digest());
                    hKDFParameters = new HKDFParameters(bArr, null, bArr2);
                } else if (PKCSObjectIdentifiers.id_alg_hkdf_with_sha384.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
                    if (algorithmIdentifier.getParameters() != null) {
                        throw new IllegalStateException("HDKF parameter support not added");
                    }
                    hKDFBytesGenerator = new HKDFBytesGenerator(new SHA384Digest());
                    hKDFParameters = new HKDFParameters(bArr, null, bArr2);
                } else if (!PKCSObjectIdentifiers.id_alg_hkdf_with_sha512.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
                    if (NISTObjectIdentifiers.id_Kmac128.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
                        byte[] octets = new byte[0];
                        if (algorithmIdentifier.getParameters() != null) {
                            octets = ASN1OctetString.getInstance(algorithmIdentifier.getParameters()).getOctets();
                        }
                        c5362kmac = new C5362KMAC(128, octets);
                        keyParameter = new KeyParameter(bArr, 0, bArr.length);
                    } else if (NISTObjectIdentifiers.id_Kmac256.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
                        byte[] octets2 = new byte[0];
                        if (algorithmIdentifier.getParameters() != null) {
                            octets2 = ASN1OctetString.getInstance(algorithmIdentifier.getParameters()).getOctets();
                        }
                        c5362kmac = new C5362KMAC(256, octets2);
                        keyParameter = new KeyParameter(bArr, 0, bArr.length);
                    } else {
                        if (!NISTObjectIdentifiers.id_shake256.m14446equals((ASN1Primitive) algorithmIdentifier.getAlgorithm())) {
                            throw new IllegalArgumentException("Unrecognized KDF: " + algorithmIdentifier.getAlgorithm());
                        }
                        SHAKEDigest sHAKEDigest = new SHAKEDigest(256);
                        sHAKEDigest.mo14970update(bArr, 0, bArr.length);
                        sHAKEDigest.mo14970update(bArr2, 0, bArr2.length);
                        sHAKEDigest.mo14998doFinal(bArr3, 0, i2);
                    }
                    c5362kmac.mo14976init(keyParameter);
                    c5362kmac.mo14979update(bArr2, 0, bArr2.length);
                    c5362kmac.mo14998doFinal(bArr3, 0, i2);
                } else {
                    if (algorithmIdentifier.getParameters() != null) {
                        throw new IllegalStateException("HDKF parameter support not added");
                    }
                    hKDFBytesGenerator = new HKDFBytesGenerator(new SHA512Digest());
                    hKDFParameters = new HKDFParameters(bArr, null, bArr2);
                }
                hKDFBytesGenerator.mo14966init(hKDFParameters);
                hKDFBytesGenerator.generateBytes(bArr3, 0, i2);
            }
            concatenationKDFGenerator.mo14966init(kDFParameters);
            concatenationKDFGenerator.generateBytes(bArr3, 0, i2);
        }
        return bArr3;
    }

    public static byte[] makeKeyBytes(KEMKDFSpec kEMKDFSpec, byte[] bArr) {
        byte[] bArrMakeKeyBytes;
        try {
            if (kEMKDFSpec == null) {
                int length = bArr.length;
                bArrMakeKeyBytes = new byte[length];
                System.arraycopy(bArr, 0, bArrMakeKeyBytes, 0, length);
            } else {
                bArrMakeKeyBytes = makeKeyBytes(kEMKDFSpec.getKdfAlgorithm(), bArr, kEMKDFSpec.getOtherInfo(), kEMKDFSpec.getKeySize());
            }
            C6238Arrays.m18227clear(bArr);
            return bArrMakeKeyBytes;
        } catch (Throwable th) {
            C6238Arrays.m18227clear(bArr);
            throw th;
        }
    }
}
