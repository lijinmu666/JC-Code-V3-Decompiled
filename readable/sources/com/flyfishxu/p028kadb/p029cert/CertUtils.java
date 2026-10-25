package com.flyfishxu.p028kadb.p029cert;

import com.flyfishxu.p028kadb.p029cert.KadbCertException;
import com.flyfishxu.p028kadb.p029cert.KadbCertPolicy;
import java.io.ByteArrayInputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateFactory;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.X509Certificate;
import java.security.interfaces.RSAPrivateCrtKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import org.bouncycastle.operator.p306jcajce.JcaContentSignerBuilder;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.RSAPrivateKey;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.BasicConstraints;
import org.bouncycastle.p133asn1.p174x509.C5194Time;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.KeyUsage;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p177cert.p178bc.BcX509ExtensionUtils;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateConverter;
import org.bouncycastle.p177cert.p185jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.p314pqc.p316crypto.p332xmss.XMSSKeyParameters;
import org.conscrypt.BuildConfig;
import p094kotlin.C1124Result;
import p094kotlin.C1126UByte;
import p094kotlin.Metadata;
import p094kotlin.ResultKt;
import p094kotlin.collections.CollectionsKt;
import p094kotlin.p101io.CloseableKt;
import p094kotlin.p101io.encoding.C1217Base64;
import p094kotlin.p105jvm.internal.Intrinsics;
import p094kotlin.p105jvm.internal.SourceDebugExtension;
import p094kotlin.p117text.StringsKt;
import p132okio.C5052Buffer;

@Metadata(m4987d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u000bJ\u0016\u0010\u000f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u000eJ\u000e\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u0012J\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001f\u001a\u00020 2\u0006\u0010\u0018\u001a\u00020\u0014J \u0010!\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u0018\u001a\u00020\u0014H\u0002J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0002J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00122\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0015\u0010'\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0012H\u0000¢\u0006\u0002\b(J\u0018\u0010)\u001a\u00020\u001d2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0002J\u0010\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020/H\u0002J&\u00100\u001a\u00020 2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001b022\u0006\u00103\u001a\u00020\u001b2\u0006\u00104\u001a\u00020\u001bH\u0002¨\u00065"}, m4988d2 = {"Lcom/flyfishxu/kadb/cert/CertUtils;", BuildConfig.f24315FLAVOR, "<init>", "()V", "loadKeyPair", "Lcom/flyfishxu/kadb/cert/AdbKeyPair;", "loadKeySet", "Lcom/flyfishxu/kadb/cert/HostKeySet;", "generateNewIdentity", "Lcom/flyfishxu/kadb/cert/ResolvedIdentity;", "policy", "Lcom/flyfishxu/kadb/cert/KadbCertPolicy;", "identityFromPrivateKey", "privateKeyPem", BuildConfig.f24315FLAVOR, "identityFromPrivateKeyAndCertificate", "certificatePem", "parsePrivateKeyPem", "Ljava/security/PrivateKey;", "parseCertificatePem", "Ljava/security/cert/X509Certificate;", "encodePrivateKeyPem", "privateKey", "encodeCertificatePem", "certificate", "Ljava/security/cert/Certificate;", "fingerprintSha256", BuildConfig.f24315FLAVOR, "publicKey", "Ljava/security/PublicKey;", "adbTlsFingerprintHex", "validateCertificate", BuildConfig.f24315FLAVOR, "toResolvedIdentity", "generateKeyPair", "Ljava/security/KeyPair;", "keySizeBits", BuildConfig.f24315FLAVOR, "generateCertificateFromPrivateKey", "derivePublicKey", "derivePublicKey$com_github_IndiTheo_kadb", "generateRsaPublicKey", "modulus", "Ljava/math/BigInteger;", "publicExponent", "buildSubjectName", "subject", "Lcom/flyfishxu/kadb/cert/KadbCertPolicy$Subject;", "appendSubjectEntry", "entries", BuildConfig.f24315FLAVOR, "key", "value", "com.github.IndiTheo:kadb"}, m4989k = 1, m4990mv = {2, 4, 0}, m4992xi = 48)
@SourceDebugExtension(m6344value = {"SMAP\nCertUtils.kt\nKotlin\n*S Kotlin\n*F\n+ 1 CertUtils.kt\ncom/flyfishxu/kadb/cert/CertUtils\n+ 2 _Arrays.kt\nkotlin/collections/ArraysKt___ArraysKt\n*L\n1#1,310:1\n15176#2,3:311\n*S KotlinDebug\n*F\n+ 1 CertUtils.kt\ncom/flyfishxu/kadb/cert/CertUtils\n*L\n172#1:311,3\n*E\n"})
/* loaded from: classes.dex */
public final class CertUtils {
    public static final CertUtils INSTANCE = new CertUtils();

    private CertUtils() {
    }

    private final void appendSubjectEntry(List<String> entries, String key, String value) {
        if (StringsKt.m6766isBlank(value)) {
            return;
        }
        entries.add(key + "=" + value);
    }

    private final String buildSubjectName(KadbCertPolicy.Subject subject) {
        ArrayList arrayList = new ArrayList();
        appendSubjectEntry(arrayList, "C", subject.m2192getC());
        appendSubjectEntry(arrayList, "O", subject.m2195getO());
        appendSubjectEntry(arrayList, "CN", subject.m2193getCn());
        appendSubjectEntry(arrayList, "OU", subject.m2196getOu());
        appendSubjectEntry(arrayList, "L", subject.m2194getL());
        appendSubjectEntry(arrayList, "ST", subject.m2197getSt());
        if (arrayList.isEmpty()) {
            arrayList.add("C=US");
            arrayList.add("O=Android");
            arrayList.add("CN=Adb");
        }
        return CollectionsKt.joinToString$default(arrayList, ", ", null, null, 0, null, null, 62, null);
    }

    private final X509Certificate generateCertificateFromPrivateKey(PrivateKey privateKey, KadbCertPolicy policy) throws CertificateException {
        PublicKey publicKeyDerivePublicKey$com_github_IndiTheo_kadb = derivePublicKey$com_github_IndiTheo_kadb(privateKey);
        long jCurrentTimeMillis = System.currentTimeMillis();
        C5194Time c5194Time = new C5194Time(new Date(jCurrentTimeMillis));
        C5194Time c5194Time2 = new C5194Time(new Date(jCurrentTimeMillis + TimeUnit.DAYS.toMillis(policy.getCertValidityDays())));
        X500Name x500Name = new X500Name(buildSubjectName(policy.getSubject()));
        JcaX509v3CertificateBuilder jcaX509v3CertificateBuilder = new JcaX509v3CertificateBuilder(x500Name, BigInteger.ONE, c5194Time, c5194Time2, x500Name, publicKeyDerivePublicKey$com_github_IndiTheo_kadb);
        jcaX509v3CertificateBuilder.addExtension(Extension.basicConstraints, true, (ASN1Encodable) new BasicConstraints(true));
        jcaX509v3CertificateBuilder.addExtension(Extension.keyUsage, true, (ASN1Encodable) new KeyUsage(134));
        jcaX509v3CertificateBuilder.addExtension(Extension.subjectKeyIdentifier, false, (ASN1Encodable) new BcX509ExtensionUtils().createSubjectKeyIdentifier(SubjectPublicKeyInfo.getInstance(publicKeyDerivePublicKey$com_github_IndiTheo_kadb.getEncoded())));
        X509CertificateHolder x509CertificateHolderM14757build = jcaX509v3CertificateBuilder.m14757build(new JcaContentSignerBuilder("SHA256withRSA").m17392build(privateKey));
        for (Serializable serializable : CertUtilsKt.providers) {
            try {
                if (serializable instanceof Provider) {
                    X509Certificate certificate = new JcaX509CertificateConverter().setProvider((Provider) serializable).getCertificate(x509CertificateHolderM14757build);
                    Intrinsics.checkNotNullExpressionValue(certificate, "getCertificate(...)");
                    return certificate;
                }
                if (serializable instanceof String) {
                    X509Certificate certificate2 = new JcaX509CertificateConverter().setProvider((String) serializable).getCertificate(x509CertificateHolderM14757build);
                    Intrinsics.checkNotNullExpressionValue(certificate2, "getCertificate(...)");
                    return certificate2;
                }
                X509Certificate certificate3 = new JcaX509CertificateConverter().getCertificate(x509CertificateHolderM14757build);
                Intrinsics.checkNotNullExpressionValue(certificate3, "getCertificate(...)");
                return certificate3;
            } catch (Throwable unused) {
            }
        }
        throw new CertificateException("All certificate providers failed to generate a certificate.");
    }

    private final KeyPair generateKeyPair(int keySizeBits) throws NoSuchAlgorithmException {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(keySizeBits, SecureRandom.getInstance("SHA1PRNG"));
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        Intrinsics.checkNotNullExpressionValue(keyPairGenerateKeyPair, "generateKeyPair(...)");
        return keyPairGenerateKeyPair;
    }

    private final PublicKey generateRsaPublicKey(BigInteger modulus, BigInteger publicExponent) throws InvalidKeySpecException {
        PublicKey publicKeyGeneratePublic = KeyFactory.getInstance("RSA").generatePublic(new RSAPublicKeySpec(modulus, publicExponent));
        Intrinsics.checkNotNullExpressionValue(publicKeyGeneratePublic, "generatePublic(...)");
        return publicKeyGeneratePublic;
    }

    private final ResolvedIdentity toResolvedIdentity(byte[] privateKeyPem, PrivateKey privateKey, X509Certificate certificate) {
        PublicKey publicKey = certificate.getPublicKey();
        Intrinsics.checkNotNullExpressionValue(publicKey, "getPublicKey(...)");
        AdbKeyPair adbKeyPair = new AdbKeyPair(privateKey, publicKey, certificate);
        byte[] bArrCopyOf = Arrays.copyOf(privateKeyPem, privateKeyPem.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        KadbIdentitySnapshot kadbIdentitySnapshot = new KadbIdentitySnapshot(bArrCopyOf, encodeCertificatePem(certificate), fingerprintSha256(certificate), certificate.getNotAfter().getTime());
        byte[] bArrCopyOf2 = Arrays.copyOf(privateKeyPem, privateKeyPem.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "copyOf(...)");
        return new ResolvedIdentity(bArrCopyOf2, adbKeyPair, kadbIdentitySnapshot);
    }

    public final String adbTlsFingerprintHex(PublicKey publicKey) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        byte[] bArrDigest = MessageDigest.getInstance(XMSSKeyParameters.f23621SHA_256).digest(publicKey.getEncoded());
        char[] cArr = new char[bArrDigest.length * 2];
        Intrinsics.checkNotNull(bArrDigest);
        int length = bArrDigest.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            byte b = bArrDigest[i];
            int i3 = i2 + 1;
            int i4 = i2 * 2;
            cArr[i4] = "0123456789ABCDEF".charAt((b & C1126UByte.MAX_VALUE) >>> 4);
            cArr[i4 + 1] = "0123456789ABCDEF".charAt(b & 15);
            i++;
            i2 = i3;
        }
        String str = new String(cArr);
        Locale US = Locale.US;
        Intrinsics.checkNotNullExpressionValue(US, "US");
        String upperCase = str.toUpperCase(US);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        return upperCase;
    }

    public final PublicKey derivePublicKey$com_github_IndiTheo_kadb(PrivateKey privateKey) {
        Object objM18546constructorimpl;
        Object objM18546constructorimpl2;
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        RSAPrivateCrtKey rSAPrivateCrtKey = privateKey instanceof RSAPrivateCrtKey ? (RSAPrivateCrtKey) privateKey : null;
        if (rSAPrivateCrtKey != null) {
            BigInteger modulus = rSAPrivateCrtKey.getModulus();
            Intrinsics.checkNotNullExpressionValue(modulus, "getModulus(...)");
            BigInteger publicExponent = rSAPrivateCrtKey.getPublicExponent();
            Intrinsics.checkNotNullExpressionValue(publicExponent, "getPublicExponent(...)");
            return generateRsaPublicKey(modulus, publicExponent);
        }
        byte[] encoded = privateKey.getEncoded();
        if (encoded == null) {
            throw new KadbCertException.PolicyViolation("RSA private key encoding is unavailable", null, 2, null);
        }
        try {
            C1124Result.Companion companion = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(PrivateKeyInfo.getInstance(encoded));
        } catch (Throwable th) {
            C1124Result.Companion companion2 = C1124Result.INSTANCE;
            objM18546constructorimpl = C1124Result.m18546constructorimpl(ResultKt.createFailure(th));
        }
        Throwable thM18549exceptionOrNullimpl = C1124Result.m18549exceptionOrNullimpl(objM18546constructorimpl);
        if (thM18549exceptionOrNullimpl != null) {
            throw new KadbCertException.PolicyViolation("Failed to parse RSA private key encoding", thM18549exceptionOrNullimpl);
        }
        try {
            objM18546constructorimpl2 = C1124Result.m18546constructorimpl(RSAPrivateKey.getInstance(((PrivateKeyInfo) objM18546constructorimpl).parsePrivateKey()));
        } catch (Throwable th2) {
            C1124Result.Companion companion3 = C1124Result.INSTANCE;
            objM18546constructorimpl2 = C1124Result.m18546constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable thM18549exceptionOrNullimpl2 = C1124Result.m18549exceptionOrNullimpl(objM18546constructorimpl2);
        if (thM18549exceptionOrNullimpl2 != null) {
            throw new KadbCertException.PolicyViolation("Failed to parse RSA private key parameters", thM18549exceptionOrNullimpl2);
        }
        RSAPrivateKey rSAPrivateKey = (RSAPrivateKey) objM18546constructorimpl2;
        BigInteger modulus2 = rSAPrivateKey.getModulus();
        Intrinsics.checkNotNullExpressionValue(modulus2, "getModulus(...)");
        BigInteger publicExponent2 = rSAPrivateKey.getPublicExponent();
        Intrinsics.checkNotNullExpressionValue(publicExponent2, "getPublicExponent(...)");
        return generateRsaPublicKey(modulus2, publicExponent2);
    }

    public final byte[] encodeCertificatePem(Certificate certificate) throws CertificateEncodingException {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        C1217Base64.Companion companion = C1217Base64.INSTANCE;
        byte[] encoded = certificate.getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
        String strEncode$default = C1217Base64.encode$default(companion, encoded, 0, 0, 6, null);
        C5052Buffer c5052Buffer = new C5052Buffer();
        try {
            c5052Buffer.writeUtf8("-----BEGIN CERTIFICATE-----");
            c5052Buffer.writeByte(10);
            c5052Buffer.writeUtf8(strEncode$default);
            c5052Buffer.writeByte(10);
            c5052Buffer.writeUtf8("-----END CERTIFICATE-----");
            CloseableKt.closeFinally(c5052Buffer, null);
            return c5052Buffer.readByteArray();
        } finally {
        }
    }

    public final byte[] encodePrivateKeyPem(PrivateKey privateKey) {
        Intrinsics.checkNotNullParameter(privateKey, "privateKey");
        C1217Base64.Companion companion = C1217Base64.INSTANCE;
        byte[] encoded = privateKey.getEncoded();
        Intrinsics.checkNotNullExpressionValue(encoded, "getEncoded(...)");
        String strEncode$default = C1217Base64.encode$default(companion, encoded, 0, 0, 6, null);
        C5052Buffer c5052Buffer = new C5052Buffer();
        try {
            c5052Buffer.writeUtf8("-----BEGIN PRIVATE KEY-----");
            c5052Buffer.writeByte(10);
            c5052Buffer.writeUtf8(strEncode$default);
            c5052Buffer.writeByte(10);
            c5052Buffer.writeUtf8("-----END PRIVATE KEY-----");
            CloseableKt.closeFinally(c5052Buffer, null);
            return c5052Buffer.readByteArray();
        } finally {
        }
    }

    public final String fingerprintSha256(PublicKey publicKey) {
        Intrinsics.checkNotNullParameter(publicKey, "publicKey");
        byte[] bArrDigest = MessageDigest.getInstance(XMSSKeyParameters.f23621SHA_256).digest(publicKey.getEncoded());
        C1217Base64.Companion companion = C1217Base64.INSTANCE;
        Intrinsics.checkNotNull(bArrDigest);
        return C1217Base64.encode$default(companion, bArrDigest, 0, 0, 6, null);
    }

    public final ResolvedIdentity generateNewIdentity(KadbCertPolicy policy) {
        Intrinsics.checkNotNullParameter(policy, "policy");
        PrivateKey privateKey = generateKeyPair(policy.getKeySizeBits()).getPrivate();
        Intrinsics.checkNotNullExpressionValue(privateKey, "getPrivate(...)");
        return identityFromPrivateKey(encodePrivateKeyPem(privateKey), policy);
    }

    public final ResolvedIdentity identityFromPrivateKey(byte[] privateKeyPem, KadbCertPolicy policy) throws InvalidKeySpecException {
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        Intrinsics.checkNotNullParameter(policy, "policy");
        PrivateKey privateKeyPem2 = parsePrivateKeyPem(privateKeyPem);
        return toResolvedIdentity(privateKeyPem, privateKeyPem2, generateCertificateFromPrivateKey(privateKeyPem2, policy));
    }

    public final ResolvedIdentity identityFromPrivateKeyAndCertificate(byte[] privateKeyPem, byte[] certificatePem) throws InvalidKeySpecException, CertificateException {
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        Intrinsics.checkNotNullParameter(certificatePem, "certificatePem");
        PrivateKey privateKeyPem2 = parsePrivateKeyPem(privateKeyPem);
        X509Certificate certificatePem2 = parseCertificatePem(certificatePem);
        if (Arrays.equals(certificatePem2.getPublicKey().getEncoded(), derivePublicKey$com_github_IndiTheo_kadb(privateKeyPem2).getEncoded())) {
            return toResolvedIdentity(privateKeyPem, privateKeyPem2, certificatePem2);
        }
        throw new KadbCertException.PolicyViolation("Certificate does not match private key", null, 2, null);
    }

    public final AdbKeyPair loadKeyPair() {
        return KadbCert.INSTANCE.currentKeyPair$com_github_IndiTheo_kadb();
    }

    public final HostKeySet loadKeySet() {
        return KadbCert.INSTANCE.currentKeySet$com_github_IndiTheo_kadb();
    }

    public final X509Certificate parseCertificatePem(byte[] certificatePem) throws CertificateException {
        Intrinsics.checkNotNullParameter(certificatePem, "certificatePem");
        byte[] bArrDecode$default = C1217Base64.decode$default(C1217Base64.INSTANCE, StringsKt.m6778trim((CharSequence) StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.decodeToString(certificatePem), "-----BEGIN CERTIFICATE-----", BuildConfig.f24315FLAVOR, false, 4, (Object) null), "-----END CERTIFICATE-----", BuildConfig.f24315FLAVOR, false, 4, (Object) null), "\r", BuildConfig.f24315FLAVOR, false, 4, (Object) null), "\n", BuildConfig.f24315FLAVOR, false, 4, (Object) null)).toString(), 0, 0, 6, (Object) null);
        for (Serializable serializable : CertUtilsKt.providers) {
            try {
                Certificate certificateGenerateCertificate = (serializable instanceof Provider ? CertificateFactory.getInstance("X.509", (Provider) serializable) : serializable instanceof String ? CertificateFactory.getInstance("X.509", (String) serializable) : CertificateFactory.getInstance("X.509")).generateCertificate(new ByteArrayInputStream(bArrDecode$default));
                Intrinsics.checkNotNull(certificateGenerateCertificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
                return (X509Certificate) certificateGenerateCertificate;
            } catch (Throwable unused) {
            }
        }
        throw new CertificateException("All certificate providers failed to parse certificate.");
    }

    public final PrivateKey parsePrivateKeyPem(byte[] privateKeyPem) throws InvalidKeySpecException {
        Intrinsics.checkNotNullParameter(privateKeyPem, "privateKeyPem");
        PrivateKey privateKeyGeneratePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C1217Base64.decode$default(C1217Base64.INSTANCE, StringsKt.m6778trim((CharSequence) StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(StringsKt.decodeToString(privateKeyPem), "-----BEGIN PRIVATE KEY-----", BuildConfig.f24315FLAVOR, false, 4, (Object) null), "-----END PRIVATE KEY-----", BuildConfig.f24315FLAVOR, false, 4, (Object) null), "\r", BuildConfig.f24315FLAVOR, false, 4, (Object) null), "\n", BuildConfig.f24315FLAVOR, false, 4, (Object) null)).toString(), 0, 0, 6, (Object) null)));
        Intrinsics.checkNotNullExpressionValue(privateKeyGeneratePrivate, "generatePrivate(...)");
        return privateKeyGeneratePrivate;
    }

    public final void validateCertificate(X509Certificate certificate) throws CertificateNotYetValidException, CertificateExpiredException {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        certificate.checkValidity();
    }

    public final String fingerprintSha256(Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        byte[] bArrDigest = MessageDigest.getInstance(XMSSKeyParameters.f23621SHA_256).digest(certificate.getEncoded());
        C1217Base64.Companion companion = C1217Base64.INSTANCE;
        Intrinsics.checkNotNull(bArrDigest);
        return C1217Base64.encode$default(companion, bArrDigest, 0, 0, 6, null);
    }
}
