package org.bouncycastle.p194crypto.p221util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.p133asn1.InterfaceC5102BERTags;
import org.bouncycastle.p194crypto.CryptoServicePurpose;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.p199digests.MD5Digest;
import org.bouncycastle.p194crypto.p199digests.SHA1Digest;
import org.bouncycastle.p194crypto.p199digests.SHA224Digest;
import org.bouncycastle.p194crypto.p199digests.SHA256Digest;
import org.bouncycastle.p194crypto.p199digests.SHA384Digest;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512tDigest;
import org.bouncycastle.p194crypto.p199digests.SHAKEDigest;

/* loaded from: classes2.dex */
public final class DigestFactory {
    private static final Map cloneMap;

    /* renamed from: org.bouncycastle.crypto.util.DigestFactory$Cloner */
    public interface InterfaceC5417Cloner {
        InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest);
    }

    static {
        HashMap map = new HashMap();
        cloneMap = map;
        map.put(createMD5().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.1
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return new MD5Digest((MD5Digest) interfaceC5277Digest);
            }
        });
        map.put(createSHA1().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.2
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return new SHA1Digest((SHA1Digest) interfaceC5277Digest);
            }
        });
        map.put(createSHA224().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.3
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return new SHA224Digest((SHA224Digest) interfaceC5277Digest);
            }
        });
        map.put(createSHA256().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.4
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return SHA256Digest.newInstance(interfaceC5277Digest);
            }
        });
        map.put(createSHA384().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.5
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return new SHA384Digest((SHA384Digest) interfaceC5277Digest);
            }
        });
        map.put(createSHA512().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.6
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return new SHA512Digest((SHA512Digest) interfaceC5277Digest);
            }
        });
        map.put(createSHA3_224().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.7
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return new SHA3Digest((SHA3Digest) interfaceC5277Digest);
            }
        });
        map.put(createSHA3_256().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.8
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return new SHA3Digest((SHA3Digest) interfaceC5277Digest);
            }
        });
        map.put(createSHA3_384().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.9
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return new SHA3Digest((SHA3Digest) interfaceC5277Digest);
            }
        });
        map.put(createSHA3_512().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.10
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return new SHA3Digest((SHA3Digest) interfaceC5277Digest);
            }
        });
        map.put(createSHAKE128().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.11
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return new SHAKEDigest((SHAKEDigest) interfaceC5277Digest);
            }
        });
        map.put(createSHAKE256().getAlgorithmName(), new InterfaceC5417Cloner() { // from class: org.bouncycastle.crypto.util.DigestFactory.12
            @Override // org.bouncycastle.p194crypto.p221util.DigestFactory.InterfaceC5417Cloner
            public InterfaceC5277Digest createClone(InterfaceC5277Digest interfaceC5277Digest) {
                return new SHAKEDigest((SHAKEDigest) interfaceC5277Digest);
            }
        });
    }

    public static InterfaceC5277Digest cloneDigest(InterfaceC5277Digest interfaceC5277Digest) {
        return ((InterfaceC5417Cloner) cloneMap.get(interfaceC5277Digest.getAlgorithmName())).createClone(interfaceC5277Digest);
    }

    public static InterfaceC5277Digest createMD5() {
        return new MD5Digest();
    }

    public static InterfaceC5277Digest createMD5PRF() {
        return new MD5Digest();
    }

    public static InterfaceC5277Digest createSHA1() {
        return new SHA1Digest();
    }

    public static InterfaceC5277Digest createSHA1PRF() {
        return new SHA1Digest(CryptoServicePurpose.PRF);
    }

    public static InterfaceC5277Digest createSHA224() {
        return new SHA224Digest();
    }

    public static InterfaceC5277Digest createSHA224PRF() {
        return new SHA224Digest(CryptoServicePurpose.PRF);
    }

    public static InterfaceC5277Digest createSHA256() {
        return SHA256Digest.newInstance();
    }

    public static InterfaceC5277Digest createSHA256PRF() {
        return new SHA256Digest(CryptoServicePurpose.PRF);
    }

    public static InterfaceC5277Digest createSHA384() {
        return new SHA384Digest();
    }

    public static InterfaceC5277Digest createSHA384PRF() {
        return new SHA384Digest(CryptoServicePurpose.PRF);
    }

    public static InterfaceC5277Digest createSHA3_224() {
        return new SHA3Digest(InterfaceC5102BERTags.f17976FLAGS);
    }

    public static InterfaceC5277Digest createSHA3_224PRF() {
        return new SHA3Digest(InterfaceC5102BERTags.f17976FLAGS, CryptoServicePurpose.PRF);
    }

    public static InterfaceC5277Digest createSHA3_256() {
        return new SHA3Digest(256);
    }

    public static InterfaceC5277Digest createSHA3_256PRF() {
        return new SHA3Digest(256, CryptoServicePurpose.PRF);
    }

    public static InterfaceC5277Digest createSHA3_384() {
        return new SHA3Digest(384);
    }

    public static InterfaceC5277Digest createSHA3_384PRF() {
        return new SHA3Digest(384, CryptoServicePurpose.PRF);
    }

    public static InterfaceC5277Digest createSHA3_512() {
        return new SHA3Digest(512);
    }

    public static InterfaceC5277Digest createSHA3_512PRF() {
        return new SHA3Digest(512, CryptoServicePurpose.PRF);
    }

    public static InterfaceC5277Digest createSHA512() {
        return new SHA512Digest();
    }

    public static InterfaceC5277Digest createSHA512PRF() {
        return new SHA512Digest(CryptoServicePurpose.PRF);
    }

    public static InterfaceC5277Digest createSHA512_224() {
        return new SHA512tDigest(InterfaceC5102BERTags.f17976FLAGS);
    }

    public static InterfaceC5277Digest createSHA512_224PRF() {
        return new SHA512tDigest(InterfaceC5102BERTags.f17976FLAGS, CryptoServicePurpose.PRF);
    }

    public static InterfaceC5277Digest createSHA512_256() {
        return new SHA512tDigest(256);
    }

    public static InterfaceC5277Digest createSHA512_256PRF() {
        return new SHA512tDigest(256, CryptoServicePurpose.PRF);
    }

    public static InterfaceC5277Digest createSHAKE128() {
        return new SHAKEDigest(128);
    }

    public static InterfaceC5277Digest createSHAKE256() {
        return new SHAKEDigest(256);
    }
}
