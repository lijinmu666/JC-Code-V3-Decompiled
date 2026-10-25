package org.bouncycastle.p366x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.C5194Time;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.TBSCertList;
import org.bouncycastle.p133asn1.p174x509.V2TBSCertListGenerator;
import org.bouncycastle.p133asn1.p174x509.X509Extensions;
import org.bouncycastle.p133asn1.p174x509.X509ExtensionsGenerator;
import org.bouncycastle.p133asn1.p174x509.X509Name;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p281jce.X509Principal;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p281jce.provider.X509CRLObject;

/* loaded from: classes2.dex */
public class X509V2CRLGenerator {
    private AlgorithmIdentifier sigAlgId;

    /* renamed from: sigOID */
    private ASN1ObjectIdentifier f24297sigOID;
    private String signatureAlgorithm;
    private final JcaJceHelper bcHelper = new BCJcaJceHelper();

    /* renamed from: tbsGen */
    private V2TBSCertListGenerator f24298tbsGen = new V2TBSCertListGenerator();
    private X509ExtensionsGenerator extGenerator = new X509ExtensionsGenerator();

    public static class ExtCRLException extends CRLException {

        /* renamed from: cause */
        Throwable f24299cause;

        public ExtCRLException(String str, Throwable th) {
            super(str);
            this.f24299cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f24299cause;
        }
    }

    private TBSCertList generateCertList() {
        if (!this.extGenerator.m14711isEmpty()) {
            this.f24298tbsGen.setExtensions(this.extGenerator.generate());
        }
        return this.f24298tbsGen.generateTBSCertList();
    }

    private X509CRL generateJcaObject(TBSCertList tBSCertList, byte[] bArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(tBSCertList);
        aSN1EncodableVector.m14420add(this.sigAlgId);
        aSN1EncodableVector.m14420add(new DERBitString(bArr));
        return new X509CRLObject(CertificateList.getInstance(new DERSequence(aSN1EncodableVector)));
    }

    /* renamed from: addCRL */
    public void m18402addCRL(X509CRL x509crl) throws CRLException {
        Set<? extends X509CRLEntry> revokedCertificates = x509crl.getRevokedCertificates();
        if (revokedCertificates != null) {
            Iterator<? extends X509CRLEntry> it = revokedCertificates.iterator();
            while (it.hasNext()) {
                try {
                    this.f24298tbsGen.addCRLEntry(ASN1Sequence.getInstance(new ASN1InputStream(it.next().getEncoded()).readObject()));
                } catch (IOException e) {
                    throw new CRLException("exception processing encoding of CRL: " + e.toString());
                }
            }
        }
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, int i) {
        this.f24298tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new C5194Time(date), i);
    }

    public void addExtension(String str, boolean z, ASN1Encodable aSN1Encodable) {
        addExtension(new ASN1ObjectIdentifier(str), z, aSN1Encodable);
    }

    public X509CRL generate(PrivateKey privateKey) {
        return generate(privateKey, (SecureRandom) null);
    }

    public X509CRL generateX509CRL(PrivateKey privateKey) {
        try {
            return generateX509CRL(privateKey, BouncyCastleProvider.PROVIDER_NAME, null);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }

    public Iterator getSignatureAlgNames() {
        return X509Util.getAlgNames();
    }

    /* renamed from: reset */
    public void m18403reset() {
        this.f24298tbsGen = new V2TBSCertListGenerator();
        this.extGenerator.m14712reset();
    }

    public void setIssuerDN(X500Principal x500Principal) {
        try {
            this.f24298tbsGen.setIssuer(new X509Principal(x500Principal.getEncoded()));
        } catch (IOException e) {
            throw new IllegalArgumentException("can't process principal: " + e);
        }
    }

    public void setNextUpdate(Date date) {
        this.f24298tbsGen.setNextUpdate(new C5194Time(date));
    }

    public void setSignatureAlgorithm(String str) {
        this.signatureAlgorithm = str;
        try {
            ASN1ObjectIdentifier algorithmOID = X509Util.getAlgorithmOID(str);
            this.f24297sigOID = algorithmOID;
            AlgorithmIdentifier sigAlgID = X509Util.getSigAlgID(algorithmOID, str);
            this.sigAlgId = sigAlgID;
            this.f24298tbsGen.setSignature(sigAlgID);
        } catch (Exception unused) {
            throw new IllegalArgumentException("Unknown signature type requested");
        }
    }

    public void setThisUpdate(Date date) {
        this.f24298tbsGen.setThisUpdate(new C5194Time(date));
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, int i, Date date2) {
        this.f24298tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new C5194Time(date), i, new ASN1GeneralizedTime(date2));
    }

    public void addExtension(String str, boolean z, byte[] bArr) {
        addExtension(new ASN1ObjectIdentifier(str), z, bArr);
    }

    public X509CRL generate(PrivateKey privateKey, String str) {
        return generate(privateKey, str, null);
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, String str) {
        return generateX509CRL(privateKey, str, null);
    }

    public void setIssuerDN(X509Name x509Name) {
        this.f24298tbsGen.setIssuer(x509Name);
    }

    public void addCRLEntry(BigInteger bigInteger, Date date, X509Extensions x509Extensions) {
        this.f24298tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new C5194Time(date), Extensions.getInstance(x509Extensions));
    }

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        this.extGenerator.addExtension(new ASN1ObjectIdentifier(aSN1ObjectIdentifier.m14433getId()), z, aSN1Encodable);
    }

    public X509CRL generate(PrivateKey privateKey, String str, SecureRandom secureRandom) throws ExtCRLException {
        TBSCertList tBSCertListGenerateCertList = generateCertList();
        try {
            return generateJcaObject(tBSCertListGenerateCertList, X509Util.calculateSignature(this.f24297sigOID, this.signatureAlgorithm, str, privateKey, secureRandom, tBSCertListGenerateCertList));
        } catch (IOException e) {
            throw new ExtCRLException("cannot generate CRL encoding", e);
        }
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, String str, SecureRandom secureRandom) throws SignatureException, InvalidKeyException, NoSuchProviderException {
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

    public void addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extGenerator.addExtension(new ASN1ObjectIdentifier(aSN1ObjectIdentifier.m14433getId()), z, bArr);
    }

    public X509CRL generate(PrivateKey privateKey, SecureRandom secureRandom) throws ExtCRLException {
        TBSCertList tBSCertListGenerateCertList = generateCertList();
        try {
            return generateJcaObject(tBSCertListGenerateCertList, X509Util.calculateSignature(this.f24297sigOID, this.signatureAlgorithm, privateKey, secureRandom, tBSCertListGenerateCertList));
        } catch (IOException e) {
            throw new ExtCRLException("cannot generate CRL encoding", e);
        }
    }

    public X509CRL generateX509CRL(PrivateKey privateKey, SecureRandom secureRandom) {
        try {
            return generateX509CRL(privateKey, BouncyCastleProvider.PROVIDER_NAME, secureRandom);
        } catch (NoSuchProviderException unused) {
            throw new SecurityException("BC provider not installed!");
        }
    }
}
