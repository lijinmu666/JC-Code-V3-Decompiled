package org.bouncycastle.p366x509;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.X509Certificate;
import java.util.Date;
import java.util.Iterator;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.C5194Time;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p174x509.TBSCertificate;
import org.bouncycastle.p133asn1.p174x509.V1TBSCertificateGenerator;
import org.bouncycastle.p133asn1.p174x509.X509Name;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.asymmetric.p265x509.CertificateFactory;
import org.bouncycastle.p281jce.X509Principal;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;

/* loaded from: classes2.dex */
public class X509V1CertificateGenerator {
    private AlgorithmIdentifier sigAlgId;

    /* renamed from: sigOID */
    private ASN1ObjectIdentifier f24294sigOID;
    private String signatureAlgorithm;
    private final JcaJceHelper bcHelper = new BCJcaJceHelper();
    private final CertificateFactory certificateFactory = new CertificateFactory();

    /* renamed from: tbsGen */
    private V1TBSCertificateGenerator f24295tbsGen = new V1TBSCertificateGenerator();

    private X509Certificate generateJcaObject(TBSCertificate tBSCertificate, byte[] bArr) throws ExtCertificateEncodingException {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(tBSCertificate);
        aSN1EncodableVector.m14420add(this.sigAlgId);
        aSN1EncodableVector.m14420add(new DERBitString(bArr));
        try {
            return (X509Certificate) this.certificateFactory.engineGenerateCertificate(new ByteArrayInputStream(new DERSequence(aSN1EncodableVector).getEncoded(ASN1Encoding.f17902DER)));
        } catch (Exception e) {
            throw new ExtCertificateEncodingException("exception producing certificate object", e);
        }
    }

    public X509Certificate generate(PrivateKey privateKey) {
        return generate(privateKey, (SecureRandom) null);
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey) {
        try {
            return generateX509Certificate(privateKey, BouncyCastleProvider.PROVIDER_NAME, null);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public Iterator getSignatureAlgNames() {
        return X509Util.getAlgNames();
    }

    /* renamed from: reset */
    public void m18400reset() {
        this.f24295tbsGen = new V1TBSCertificateGenerator();
    }

    public void setIssuerDN(X500Principal x500Principal) {
        try {
            this.f24295tbsGen.setIssuer(new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e) {
            throw new IllegalArgumentException("can't process principal: " + e);
        }
    }

    public void setNotAfter(Date date) {
        this.f24295tbsGen.setEndDate(new C5194Time(date));
    }

    public void setNotBefore(Date date) {
        this.f24295tbsGen.setStartDate(new C5194Time(date));
    }

    public void setPublicKey(PublicKey publicKey) {
        try {
            this.f24295tbsGen.setSubjectPublicKeyInfo(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
        } catch (Exception e) {
            throw new IllegalArgumentException("unable to process key - " + e.toString());
        }
    }

    public void setSerialNumber(BigInteger bigInteger) {
        if (bigInteger.compareTo(BigInteger.ZERO) <= 0) {
            throw new IllegalArgumentException("serial number must be a positive integer");
        }
        this.f24295tbsGen.setSerialNumber(new ASN1Integer(bigInteger));
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
        try {
            ASN1ObjectIdentifier algorithmOID = X509Util.getAlgorithmOID(str);
            this.f24294sigOID = algorithmOID;
            AlgorithmIdentifier sigAlgID = X509Util.getSigAlgID(algorithmOID, str);
            this.sigAlgId = sigAlgID;
            this.f24295tbsGen.setSignature(sigAlgID);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unknown signature type requested");
        }
    }

    public void setSubjectDN(X500Principal x500Principal) {
        try {
            this.f24295tbsGen.setSubject(new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e) {
            throw new IllegalArgumentException("can't process principal: " + e);
        }
    }

    public X509Certificate generate(PrivateKey privateKey, String str) {
        return generate(privateKey, str, null);
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey, String str) {
        return generateX509Certificate(privateKey, str, null);
    }

    public void setIssuerDN(X509Name x509Name) {
        this.f24295tbsGen.setIssuer(x509Name);
    }

    public void setSubjectDN(X509Name x509Name) {
        this.f24295tbsGen.setSubject(x509Name);
    }

    public X509Certificate generate(PrivateKey privateKey, String str, SecureRandom secureRandom) throws ExtCertificateEncodingException {
        TBSCertificate tBSCertificateGenerateTBSCertificate = this.f24295tbsGen.generateTBSCertificate();
        try {
            return generateJcaObject(tBSCertificateGenerateTBSCertificate, X509Util.calculateSignature(this.f24294sigOID, this.signatureAlgorithm, str, privateKey, secureRandom, tBSCertificateGenerateTBSCertificate));
        } catch (IOException e) {
            throw new ExtCertificateEncodingException("exception encoding TBS cert", e);
        }
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey, String str, SecureRandom secureRandom) throws SignatureException, InvalidKeyException, NoSuchProviderException {
        try {
            return generate(privateKey, str, secureRandom);
        } catch (InvalidKeyException e) {
            throw e;
        } catch (NoSuchProviderException e2) {
            throw e2;
        } catch (SignatureException e3) {
            throw e3;
        } catch (GeneralSecurityException e4) {
            throw new SecurityException("exception: " + e4);
        }
    }

    public X509Certificate generate(PrivateKey privateKey, SecureRandom secureRandom) throws ExtCertificateEncodingException {
        TBSCertificate tBSCertificateGenerateTBSCertificate = this.f24295tbsGen.generateTBSCertificate();
        try {
            return generateJcaObject(tBSCertificateGenerateTBSCertificate, X509Util.calculateSignature(this.f24294sigOID, this.signatureAlgorithm, privateKey, secureRandom, tBSCertificateGenerateTBSCertificate));
        } catch (IOException e) {
            throw new ExtCertificateEncodingException("exception encoding TBS cert", e);
        }
    }

    public X509Certificate generateX509Certificate(PrivateKey privateKey, SecureRandom secureRandom) {
        try {
            return generateX509Certificate(privateKey, BouncyCastleProvider.PROVIDER_NAME, secureRandom);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }
}
