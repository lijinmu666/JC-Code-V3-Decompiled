package org.bouncycastle.p249jcajce.provider.asymmetric.p265x509;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.cert.CRL;
import java.security.cert.CRLException;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactorySpi;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1TaggedObject;
import org.bouncycastle.p133asn1.AbstractC5093ASN1Set;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.SignedData;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p302openssl.PEMParser;
import org.bouncycastle.p361util.p362io.C6257Streams;

/* loaded from: classes2.dex */
public class CertificateFactory extends CertificateFactorySpi {
    private static final C5622PEMUtil PEM_CERT_PARSER = new C5622PEMUtil(PEMParser.TYPE_CERTIFICATE);
    private static final C5622PEMUtil PEM_CRL_PARSER = new C5622PEMUtil("CRL");
    private static final C5622PEMUtil PEM_PKCS7_PARSER = new C5622PEMUtil(PEMParser.TYPE_PKCS7);
    private final JcaJceHelper bcHelper = new BCJcaJceHelper();

    /* renamed from: sData */
    private AbstractC5093ASN1Set f21645sData = null;
    private int sDataObjectCount = 0;
    private InputStream currentStream = null;
    private AbstractC5093ASN1Set sCrlData = null;
    private int sCrlDataObjectCount = 0;
    private InputStream currentCrlStream = null;

    public static class ExCertificateException extends CertificateException {

        /* renamed from: cause */
        private Throwable f21646cause;

        public ExCertificateException(String str, Throwable th) {
            super(str);
            this.f21646cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f21646cause;
        }

        public ExCertificateException(Throwable th) {
            this.f21646cause = th;
        }
    }

    private CRL doGenerateCRL(InputStream inputStream, boolean z) throws IOException, CRLException {
        InputStream inputStream2 = this.currentCrlStream;
        if (inputStream2 == null || inputStream2 != inputStream) {
            this.currentCrlStream = inputStream;
            this.sCrlData = null;
            this.sCrlDataObjectCount = 0;
        }
        try {
            AbstractC5093ASN1Set abstractC5093ASN1Set = this.sCrlData;
            if (abstractC5093ASN1Set != null) {
                if (this.sCrlDataObjectCount != abstractC5093ASN1Set.m14454size()) {
                    return m16143getCRL();
                }
                this.sCrlData = null;
                this.sCrlDataObjectCount = 0;
                return null;
            }
            if (!inputStream.markSupported()) {
                inputStream = new ByteArrayInputStream(C6257Streams.m18363readAll(inputStream));
            }
            inputStream.mark(1);
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            inputStream.reset();
            return i != 48 ? readPEMCRL(inputStream, z) : readDERCRL(new ASN1InputStream(inputStream, true));
        } catch (CRLException e) {
            throw e;
        } catch (Exception e2) {
            throw new CRLException(e2.toString());
        }
    }

    private Certificate doGenerateCertificate(InputStream inputStream, boolean z) throws IOException, ExCertificateException {
        InputStream inputStream2 = this.currentStream;
        if (inputStream2 == null || inputStream2 != inputStream) {
            this.currentStream = inputStream;
            this.f21645sData = null;
            this.sDataObjectCount = 0;
        }
        try {
            AbstractC5093ASN1Set abstractC5093ASN1Set = this.f21645sData;
            if (abstractC5093ASN1Set != null) {
                if (this.sDataObjectCount != abstractC5093ASN1Set.m14454size()) {
                    return getCertificate();
                }
                this.f21645sData = null;
                this.sDataObjectCount = 0;
                return null;
            }
            if (!inputStream.markSupported()) {
                inputStream = new ByteArrayInputStream(C6257Streams.m18363readAll(inputStream));
            }
            inputStream.mark(1);
            int i = inputStream.read();
            if (i == -1) {
                return null;
            }
            inputStream.reset();
            return i != 48 ? readPEMCertificate(inputStream, z) : readDERCertificate(new ASN1InputStream(inputStream));
        } catch (Exception e) {
            throw new ExCertificateException("parsing issue: " + e.getMessage(), e);
        }
    }

    /* renamed from: getCRL */
    private CRL m16143getCRL() {
        AbstractC5093ASN1Set abstractC5093ASN1Set = this.sCrlData;
        if (abstractC5093ASN1Set == null || this.sCrlDataObjectCount >= abstractC5093ASN1Set.m14454size()) {
            return null;
        }
        AbstractC5093ASN1Set abstractC5093ASN1Set2 = this.sCrlData;
        int i = this.sCrlDataObjectCount;
        this.sCrlDataObjectCount = i + 1;
        return createCRL(CertificateList.getInstance(abstractC5093ASN1Set2.getObjectAt(i)));
    }

    private Certificate getCertificate() {
        if (this.f21645sData == null) {
            return null;
        }
        while (this.sDataObjectCount < this.f21645sData.m14454size()) {
            AbstractC5093ASN1Set abstractC5093ASN1Set = this.f21645sData;
            int i = this.sDataObjectCount;
            this.sDataObjectCount = i + 1;
            ASN1Encodable objectAt = abstractC5093ASN1Set.getObjectAt(i);
            if (objectAt instanceof ASN1Sequence) {
                return new X509CertificateObject(this.bcHelper, org.bouncycastle.p133asn1.p174x509.Certificate.getInstance(objectAt));
            }
        }
        return null;
    }

    private CRL readDERCRL(ASN1InputStream aSN1InputStream) {
        return m16144getCRL(ASN1Sequence.getInstance(aSN1InputStream.readObject()));
    }

    private Certificate readDERCertificate(ASN1InputStream aSN1InputStream) {
        return getCertificate(ASN1Sequence.getInstance(aSN1InputStream.readObject()));
    }

    private CRL readPEMCRL(InputStream inputStream, boolean z) {
        return m16144getCRL(PEM_CRL_PARSER.readPEMObject(inputStream, z));
    }

    private Certificate readPEMCertificate(InputStream inputStream, boolean z) {
        return getCertificate(PEM_CERT_PARSER.readPEMObject(inputStream, z));
    }

    public CRL createCRL(CertificateList certificateList) {
        return new X509CRLObject(this.bcHelper, certificateList);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CRL engineGenerateCRL(InputStream inputStream) {
        return doGenerateCRL(inputStream, true);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection engineGenerateCRLs(InputStream inputStream) throws IOException, CRLException {
        ArrayList arrayList = new ArrayList();
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        while (true) {
            CRL crlDoGenerateCRL = doGenerateCRL(bufferedInputStream, arrayList.isEmpty());
            if (crlDoGenerateCRL == null) {
                return arrayList;
            }
            arrayList.add(crlDoGenerateCRL);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream) {
        return engineGenerateCertPath(inputStream, "PkiPath");
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Certificate engineGenerateCertificate(InputStream inputStream) {
        return doGenerateCertificate(inputStream, true);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Collection engineGenerateCertificates(InputStream inputStream) throws IOException, ExCertificateException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
        ArrayList arrayList = new ArrayList();
        while (true) {
            Certificate certificateDoGenerateCertificate = doGenerateCertificate(bufferedInputStream, arrayList.isEmpty());
            if (certificateDoGenerateCertificate == null) {
                return arrayList;
            }
            arrayList.add(certificateDoGenerateCertificate);
        }
    }

    @Override // java.security.cert.CertificateFactorySpi
    public Iterator engineGetCertPathEncodings() {
        return PKIXCertPath.certPathEncodings.iterator();
    }

    /* renamed from: getCRL */
    private CRL m16144getCRL(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence == null) {
            return null;
        }
        if (aSN1Sequence.mo14450size() <= 1 || !(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            return createCRL(CertificateList.getInstance(aSN1Sequence));
        }
        this.sCrlData = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).m14638getCRLs();
        return m16143getCRL();
    }

    private Certificate getCertificate(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence == null) {
            return null;
        }
        if (aSN1Sequence.mo14450size() <= 1 || !(aSN1Sequence.getObjectAt(0) instanceof ASN1ObjectIdentifier) || !aSN1Sequence.getObjectAt(0).equals(PKCSObjectIdentifiers.signedData)) {
            return new X509CertificateObject(this.bcHelper, org.bouncycastle.p133asn1.p174x509.Certificate.getInstance(aSN1Sequence));
        }
        this.f21645sData = SignedData.getInstance(ASN1Sequence.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(1), true)).getCertificates();
        return getCertificate();
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(InputStream inputStream, String str) {
        return new PKIXCertPath(inputStream, str);
    }

    @Override // java.security.cert.CertificateFactorySpi
    public CertPath engineGenerateCertPath(List list) {
        for (Object obj : list) {
            if (obj != null && !(obj instanceof X509Certificate)) {
                throw new CertificateException("list contains non X509Certificate object while creating CertPath\n" + obj.toString());
            }
        }
        return new PKIXCertPath(list);
    }
}
