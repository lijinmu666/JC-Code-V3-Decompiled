package org.bouncycastle.p310pkix;

import java.io.IOException;
import java.math.BigInteger;
import java.security.AccessControlException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.Security;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.RSAPublicKey;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;
import org.bouncycastle.p133asn1.p176x9.X962Parameters;
import org.bouncycastle.p133asn1.p176x9.X9FieldID;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p284math.AbstractC5816Primes;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
public class SubjectPublicKeyInfoChecker {
    private static final BigInteger SMALL_PRIMES_PRODUCT = new BigInteger("8138e8a0fcf3a4e84a771d40fd305d7f4aa59306d7251de54d98af8fe95729a1f73d893fa424cd2edc8636a6c3285e022b0e3866a565ae8108eed8591cd4fe8d2ce86165a978d719ebf647f362d33fca29cd179fb42401cbaf3df0c614056f9c8f3cfd51e474afb6bc6974f78db8aba8e9e517fded658591ab7502bd41849462f", 16);
    private static final C6041Cache validatedMods;
    private static final C6041Cache validatedQs;

    /* renamed from: org.bouncycastle.pkix.SubjectPublicKeyInfoChecker$Cache */
    public static class C6041Cache {
        private final BigInteger[] preserve;
        private int preserveCounter;

        /* renamed from: values */
        private final Map<BigInteger, Boolean> f22977values;

        private C6041Cache() {
            this.f22977values = new WeakHashMap();
            this.preserve = new BigInteger[8];
            this.preserveCounter = 0;
        }

        /* renamed from: add */
        public synchronized void m17437add(BigInteger bigInteger) {
            this.f22977values.put(bigInteger, Boolean.TRUE);
            BigInteger[] bigIntegerArr = this.preserve;
            int i = this.preserveCounter;
            bigIntegerArr[i] = bigInteger;
            this.preserveCounter = (i + 1) % bigIntegerArr.length;
        }

        /* renamed from: clear */
        public synchronized void m17438clear() {
            this.f22977values.clear();
            int i = 0;
            while (true) {
                BigInteger[] bigIntegerArr = this.preserve;
                if (i != bigIntegerArr.length) {
                    bigIntegerArr[i] = null;
                    i++;
                }
            }
        }

        public synchronized boolean contains(BigInteger bigInteger) {
            return this.f22977values.containsKey(bigInteger);
        }

        /* renamed from: size */
        public synchronized int m17439size() {
            return this.f22977values.size();
        }
    }

    public static class Properties {
        private static final ThreadLocal threadProperties = new ThreadLocal();

        private Properties() {
        }

        public static int asInteger(String str, int i) {
            String propertyValue = getPropertyValue(str);
            return propertyValue != null ? Integer.parseInt(propertyValue) : i;
        }

        public static String getPropertyValue(final String str) {
            String str2;
            String str3 = (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.pkix.SubjectPublicKeyInfoChecker.Properties.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return Security.getProperty(str);
                }
            });
            if (str3 != null) {
                return str3;
            }
            Map map = (Map) threadProperties.get();
            return (map == null || (str2 = (String) map.get(str)) == null) ? (String) AccessController.doPrivileged(new PrivilegedAction() { // from class: org.bouncycastle.pkix.SubjectPublicKeyInfoChecker.Properties.2
                @Override // java.security.PrivilegedAction
                public Object run() {
                    return System.getProperty(str);
                }
            }) : str2;
        }

        public static boolean isOverrideSet(String str) {
            try {
                return isSetTrue(getPropertyValue(str));
            } catch (AccessControlException unused) {
                return false;
            }
        }

        private static boolean isSetTrue(String str) {
            if (str == null || str.length() != 4) {
                return false;
            }
            if (str.charAt(0) != 't' && str.charAt(0) != 'T') {
                return false;
            }
            if (str.charAt(1) != 'r' && str.charAt(1) != 'R') {
                return false;
            }
            if (str.charAt(2) == 'u' || str.charAt(2) == 'U') {
                return str.charAt(3) == 'e' || str.charAt(3) == 'E';
            }
            return false;
        }

        public static boolean removeThreadOverride(String str) {
            String str2;
            ThreadLocal threadLocal = threadProperties;
            Map map = (Map) threadLocal.get();
            if (map == null || (str2 = (String) map.remove(str)) == null) {
                return false;
            }
            if (map.isEmpty()) {
                threadLocal.remove();
            }
            return "true".equals(C6250Strings.toLowerCase(str2));
        }

        public static boolean setThreadOverride(String str, boolean z) {
            boolean zIsOverrideSet = isOverrideSet(str);
            ThreadLocal threadLocal = threadProperties;
            Map map = (Map) threadLocal.get();
            if (map == null) {
                map = new HashMap();
                threadLocal.set(map);
            }
            map.put(str, z ? "true" : "false");
            return zIsOverrideSet;
        }
    }

    static {
        validatedQs = new C6041Cache();
        validatedMods = new C6041Cache();
    }

    public static void checkInfo(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        C6041Cache c6041Cache;
        BigInteger modulus;
        ASN1ObjectIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm().getAlgorithm();
        if (X9ObjectIdentifiers.id_ecPublicKey.m14446equals((ASN1Primitive) algorithm)) {
            X962Parameters x962Parameters = X962Parameters.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            if (x962Parameters.isImplicitlyCA() || x962Parameters.isNamedCurve()) {
                return;
            }
            X9FieldID x9FieldID = X9FieldID.getInstance(ASN1Sequence.getInstance(x962Parameters.getParameters()).getObjectAt(1));
            if (!x9FieldID.getIdentifier().m14446equals((ASN1Primitive) X9ObjectIdentifiers.prime_field)) {
                return;
            }
            modulus = ASN1Integer.getInstance(x9FieldID.getParameters()).getValue();
            c6041Cache = validatedQs;
            if (c6041Cache.contains(modulus)) {
                return;
            }
            int iAsInteger = Properties.asInteger("org.bouncycastle.ec.fp_max_size", 1042);
            int iAsInteger2 = Properties.asInteger("org.bouncycastle.ec.fp_certainty", 100);
            int iBitLength = modulus.bitLength();
            if (iAsInteger < iBitLength) {
                throw new IllegalArgumentException("Fp q value out of range");
            }
            if (AbstractC5816Primes.hasAnySmallFactors(modulus) || !AbstractC5816Primes.isMRProbablePrime(modulus, CryptoServicesRegistrar.getSecureRandom(), getNumberOfIterations(iBitLength, iAsInteger2))) {
                throw new IllegalArgumentException("Fp q value not prime");
            }
        } else {
            if (!PKCSObjectIdentifiers.rsaEncryption.m14446equals((ASN1Primitive) algorithm) && !X509ObjectIdentifiers.id_ea_rsa.m14446equals((ASN1Primitive) algorithm) && !PKCSObjectIdentifiers.id_RSAES_OAEP.m14446equals((ASN1Primitive) algorithm) && !PKCSObjectIdentifiers.id_RSASSA_PSS.m14446equals((ASN1Primitive) algorithm)) {
                return;
            }
            try {
                RSAPublicKey rSAPublicKey = RSAPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
                if ((rSAPublicKey.getPublicExponent().intValue() & 1) == 0) {
                    throw new IllegalArgumentException("RSA publicExponent is even");
                }
                c6041Cache = validatedMods;
                if (c6041Cache.contains(rSAPublicKey.getModulus())) {
                    return;
                }
                validate(rSAPublicKey.getModulus());
                modulus = rSAPublicKey.getModulus();
            } catch (IOException unused) {
                throw new IllegalArgumentException("unable to parse RSA key");
            }
        }
        c6041Cache.m17437add(modulus);
    }

    private static int getNumberOfIterations(int i, int i2) {
        if (i >= 1536) {
            if (i2 <= 100) {
                return 3;
            }
            if (i2 <= 128) {
                return 4;
            }
            return 4 + ((i2 - 127) / 2);
        }
        if (i >= 1024) {
            if (i2 <= 100) {
                return 4;
            }
            if (i2 <= 112) {
                return 5;
            }
            return ((i2 - 111) / 2) + 5;
        }
        if (i < 512) {
            if (i2 <= 80) {
                return 40;
            }
            return 40 + ((i2 - 79) / 2);
        }
        if (i2 <= 80) {
            return 5;
        }
        if (i2 <= 100) {
            return 7;
        }
        return 7 + ((i2 - 99) / 2);
    }

    private static boolean hasAnySmallFactors(BigInteger bigInteger) {
        BigInteger bigInteger2 = SMALL_PRIMES_PRODUCT;
        if (bigInteger.compareTo(bigInteger2) < 0) {
            bigInteger2 = bigInteger;
            bigInteger = bigInteger2;
        }
        return !BigIntegers.modOddIsCoprimeVar(bigInteger, bigInteger2);
    }

    public static boolean removeThreadOverride(String str) {
        return Properties.removeThreadOverride(str);
    }

    public static boolean setThreadOverride(String str, boolean z) {
        return Properties.setThreadOverride(str, z);
    }

    private static void validate(BigInteger bigInteger) {
        if ((bigInteger.intValue() & 1) == 0) {
            throw new IllegalArgumentException("RSA modulus is even");
        }
        if (Properties.isOverrideSet("org.bouncycastle.rsa.allow_unsafe_mod")) {
            return;
        }
        if (Properties.asInteger("org.bouncycastle.rsa.max_size", 16384) < bigInteger.bitLength()) {
            throw new IllegalArgumentException("RSA modulus out of range");
        }
        if (hasAnySmallFactors(bigInteger)) {
            throw new IllegalArgumentException("RSA modulus has a small prime factor");
        }
        int iBitLength = bigInteger.bitLength() / 2;
        if (!AbstractC5816Primes.enhancedMRProbablePrimeTest(bigInteger, CryptoServicesRegistrar.getSecureRandom(), iBitLength >= 1536 ? 3 : iBitLength >= 1024 ? 4 : iBitLength >= 512 ? 7 : 50).isProvablyComposite()) {
            throw new IllegalArgumentException("RSA modulus is not composite");
        }
    }
}
