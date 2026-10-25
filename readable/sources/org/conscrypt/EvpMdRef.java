package org.conscrypt;

import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;

/* loaded from: classes2.dex */
final class EvpMdRef {
    static final String MGF1_ALGORITHM_NAME = "MGF1";
    static final String MGF1_OID = "1.2.840.113549.1.1.8";

    /* renamed from: org.conscrypt.EvpMdRef$MD5 */
    public static final class C6280MD5 {

        /* renamed from: EVP_MD */
        static final long f24355EVP_MD;
        static final String JCA_NAME = "MD5";

        /* renamed from: OID */
        static final String f24356OID = "1.2.840.113549.2.5";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("md5");
            f24355EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private C6280MD5() {
        }
    }

    /* renamed from: org.conscrypt.EvpMdRef$SHA1 */
    public static final class C6281SHA1 {

        /* renamed from: EVP_MD */
        static final long f24357EVP_MD;
        static final String JCA_NAME = "SHA-1";

        /* renamed from: OID */
        static final String f24358OID = "1.3.14.3.2.26";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("sha1");
            f24357EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private C6281SHA1() {
        }
    }

    /* renamed from: org.conscrypt.EvpMdRef$SHA224 */
    public static final class C6282SHA224 {

        /* renamed from: EVP_MD */
        static final long f24359EVP_MD;
        static final String JCA_NAME = "SHA-224";

        /* renamed from: OID */
        static final String f24360OID = "2.16.840.1.101.3.4.2.4";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("sha224");
            f24359EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private C6282SHA224() {
        }
    }

    /* renamed from: org.conscrypt.EvpMdRef$SHA256 */
    public static final class C6283SHA256 {

        /* renamed from: EVP_MD */
        static final long f24361EVP_MD;
        static final String JCA_NAME = "SHA-256";

        /* renamed from: OID */
        static final String f24362OID = "2.16.840.1.101.3.4.2.1";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("sha256");
            f24361EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private C6283SHA256() {
        }
    }

    /* renamed from: org.conscrypt.EvpMdRef$SHA384 */
    public static final class C6284SHA384 {

        /* renamed from: EVP_MD */
        static final long f24363EVP_MD;
        static final String JCA_NAME = "SHA-384";

        /* renamed from: OID */
        static final String f24364OID = "2.16.840.1.101.3.4.2.2";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("sha384");
            f24363EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private C6284SHA384() {
        }
    }

    /* renamed from: org.conscrypt.EvpMdRef$SHA512 */
    public static final class C6285SHA512 {

        /* renamed from: EVP_MD */
        static final long f24365EVP_MD;
        static final String JCA_NAME = "SHA-512";

        /* renamed from: OID */
        static final String f24366OID = "2.16.840.1.101.3.4.2.3";
        static final int SIZE_BYTES;

        static {
            long jEVP_get_digestbyname = NativeCrypto.EVP_get_digestbyname("sha512");
            f24365EVP_MD = jEVP_get_digestbyname;
            SIZE_BYTES = NativeCrypto.EVP_MD_size(jEVP_get_digestbyname);
        }

        private C6285SHA512() {
        }
    }

    private EvpMdRef() {
    }

    public static int getDigestSizeBytesByJcaDigestAlgorithmStandardName(String str) throws NoSuchAlgorithmException {
        String upperCase = str.toUpperCase(Locale.US);
        if (XMSSKeyParameters.f23621SHA_256.equals(upperCase)) {
            return C6283SHA256.SIZE_BYTES;
        }
        if (XMSSKeyParameters.f23622SHA_512.equals(upperCase)) {
            return C6285SHA512.SIZE_BYTES;
        }
        if ("SHA-1".equals(upperCase)) {
            return C6281SHA1.SIZE_BYTES;
        }
        if ("SHA-384".equals(upperCase)) {
            return C6284SHA384.SIZE_BYTES;
        }
        if ("SHA-224".equals(upperCase)) {
            return C6282SHA224.SIZE_BYTES;
        }
        throw new NoSuchAlgorithmException("Unsupported algorithm: " + str);
    }

    public static long getEVP_MDByJcaDigestAlgorithmStandardName(String str) throws NoSuchAlgorithmException {
        String upperCase = str.toUpperCase(Locale.US);
        if (XMSSKeyParameters.f23621SHA_256.equals(upperCase)) {
            return C6283SHA256.f24361EVP_MD;
        }
        if (XMSSKeyParameters.f23622SHA_512.equals(upperCase)) {
            return C6285SHA512.f24365EVP_MD;
        }
        if ("SHA-1".equals(upperCase)) {
            return C6281SHA1.f24357EVP_MD;
        }
        if ("SHA-384".equals(upperCase)) {
            return C6284SHA384.f24363EVP_MD;
        }
        if ("SHA-224".equals(upperCase)) {
            return C6282SHA224.f24359EVP_MD;
        }
        throw new NoSuchAlgorithmException("Unsupported algorithm: " + str);
    }

    public static String getJcaDigestAlgorithmStandardName(String str) {
        String upperCase = str.toUpperCase(Locale.US);
        String str2 = XMSSKeyParameters.f23621SHA_256;
        if (!XMSSKeyParameters.f23621SHA_256.equals(upperCase) && !"2.16.840.1.101.3.4.2.1".equals(upperCase)) {
            str2 = XMSSKeyParameters.f23622SHA_512;
            if (!XMSSKeyParameters.f23622SHA_512.equals(upperCase) && !"2.16.840.1.101.3.4.2.3".equals(upperCase)) {
                str2 = "SHA-1";
                if (!"SHA-1".equals(upperCase) && !"1.3.14.3.2.26".equals(upperCase)) {
                    str2 = "SHA-384";
                    if (!"SHA-384".equals(upperCase) && !"2.16.840.1.101.3.4.2.2".equals(upperCase)) {
                        str2 = "SHA-224";
                        if (!"SHA-224".equals(upperCase) && !"2.16.840.1.101.3.4.2.4".equals(upperCase)) {
                            return null;
                        }
                    }
                }
            }
        }
        return str2;
    }

    public static String getJcaDigestAlgorithmStandardNameFromEVP_MD(long j) {
        if (j == C6280MD5.f24355EVP_MD) {
            return "MD5";
        }
        if (j == C6281SHA1.f24357EVP_MD) {
            return "SHA-1";
        }
        if (j == C6282SHA224.f24359EVP_MD) {
            return "SHA-224";
        }
        if (j == C6283SHA256.f24361EVP_MD) {
            return XMSSKeyParameters.f23621SHA_256;
        }
        if (j == C6284SHA384.f24363EVP_MD) {
            return "SHA-384";
        }
        if (j == C6285SHA512.f24365EVP_MD) {
            return XMSSKeyParameters.f23622SHA_512;
        }
        throw new IllegalArgumentException("Unknown EVP_MD reference");
    }
}
