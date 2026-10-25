package com.indidevs.p086android.p087adbeesh.internal.security;

import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;
import java.util.Date;
import org.bouncycastle.operator.p306jcajce.JcaContentSignerBuilder;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p177cert.p185jcajce.JcaX509CertificateConverter;
import org.bouncycastle.p177cert.p185jcajce.JcaX509v3CertificateBuilder;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.conscrypt.BuildConfig;
import p094kotlin.Metadata;
import p094kotlin.p105jvm.internal.Intrinsics;

@Metadata(m4987d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fJ(\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u000fH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, m4988d2 = {"Lcom/indidevs/android/adbeesh/internal/security/CertificateFactory;", BuildConfig.f24315FLAVOR, "<init>", "()V", "DEFAULT_ALGORITHM", BuildConfig.f24315FLAVOR, "KEY_ALGORITHM", "bcProvider", "Lorg/bouncycastle/jce/provider/BouncyCastleProvider;", "generateKeyPair", "Lcom/indidevs/android/adbeesh/internal/security/KeyPair;", "subject", "keySize", BuildConfig.f24315FLAVOR, "validityDays", BuildConfig.f24315FLAVOR, "generateRSACert", "Ljava/security/cert/X509Certificate;", "privateKey", "Ljava/security/PrivateKey;", "publicKey", "Ljava/security/PublicKey;", "formattedSubject", "expiryTimeMillis", "adbeesh"}, m4989k = 1, m4990mv = {2, 1, 0}, m4992xi = 48)
/* loaded from: classes.dex */
public final class CertificateFactory {
    private static final String DEFAULT_ALGORITHM = "SHA256withRSA";
    private static final String KEY_ALGORITHM = "RSA";
    public static final CertificateFactory INSTANCE = new CertificateFactory();
    private static final BouncyCastleProvider bcProvider = new BouncyCastleProvider();

    private CertificateFactory() {
    }

    public static /* synthetic */ KeyPair generateKeyPair$default(CertificateFactory certificateFactory, String str, int i, long j, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2048;
        }
        if ((i2 & 4) != 0) {
            j = 365;
        }
        return certificateFactory.generateKeyPair(str, i, j);
    }

    private final X509Certificate generateRSACert(PrivateKey privateKey, PublicKey publicKey, String formattedSubject, long expiryTimeMillis) throws JcaX509CertificateConverter.ExCertificateParsingException, JcaX509CertificateConverter.ExCertificateException {
        X500Name x500Name = new X500Name(formattedSubject);
        JcaX509v3CertificateBuilder jcaX509v3CertificateBuilder = new JcaX509v3CertificateBuilder(x500Name, BigInteger.valueOf(System.currentTimeMillis()), new Date(946684800000L), new Date(expiryTimeMillis), x500Name, publicKey);
        JcaContentSignerBuilder jcaContentSignerBuilder = new JcaContentSignerBuilder(DEFAULT_ALGORITHM);
        BouncyCastleProvider bouncyCastleProvider = bcProvider;
        X509Certificate certificate = new JcaX509CertificateConverter().setProvider(bouncyCastleProvider).getCertificate(jcaX509v3CertificateBuilder.m14757build(jcaContentSignerBuilder.setProvider(bouncyCastleProvider).m17392build(privateKey)));
        Intrinsics.checkNotNullExpressionValue(certificate, "getCertificate(...)");
        return certificate;
    }

    public final KeyPair generateKeyPair(String subject, int keySize, long validityDays) throws JcaX509CertificateConverter.ExCertificateParsingException, NoSuchAlgorithmException, JcaX509CertificateConverter.ExCertificateException {
        Intrinsics.checkNotNullParameter(subject, "subject");
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(keySize, new SecureRandom());
        KeyPair keyPairGenerateKeyPair = keyPairGenerator.generateKeyPair();
        long j = 60;
        long jCurrentTimeMillis = System.currentTimeMillis() + (validityDays * 24 * j * j * 1000);
        PrivateKey privateKey = keyPairGenerateKeyPair.getPrivate();
        Intrinsics.checkNotNullExpressionValue(privateKey, "getPrivate(...)");
        PublicKey publicKey = keyPairGenerateKeyPair.getPublic();
        Intrinsics.checkNotNullExpressionValue(publicKey, "getPublic(...)");
        X509Certificate x509CertificateGenerateRSACert = generateRSACert(privateKey, publicKey, subject, jCurrentTimeMillis);
        PrivateKey privateKey2 = keyPairGenerateKeyPair.getPrivate();
        Intrinsics.checkNotNullExpressionValue(privateKey2, "getPrivate(...)");
        return new KeyPair(privateKey2, x509CertificateGenerateRSACert);
    }
}
