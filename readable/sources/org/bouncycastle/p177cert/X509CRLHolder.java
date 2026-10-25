package org.bouncycastle.p177cert;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.AltSignatureAlgorithm;
import org.bouncycastle.p133asn1.p174x509.AltSignatureValue;
import org.bouncycastle.p133asn1.p174x509.C5194Time;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.IssuingDistributionPoint;
import org.bouncycastle.p133asn1.p174x509.TBSCertList;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class X509CRLHolder implements Encodable, Serializable {
    private static final long serialVersionUID = 20170722001L;
    private transient Extensions extensions;
    private transient boolean isIndirect;
    private transient GeneralNames issuerName;

    /* renamed from: x509CRL */
    private transient CertificateList f18802x509CRL;

    public X509CRLHolder(InputStream inputStream) {
        this(parseStream(inputStream));
    }

    /* renamed from: init */
    private void m14746init(CertificateList certificateList) {
        this.f18802x509CRL = certificateList;
        Extensions extensions = certificateList.getTBSCertList().getExtensions();
        this.extensions = extensions;
        this.isIndirect = isIndirectCRL(extensions);
        this.issuerName = new GeneralNames(new GeneralName(certificateList.getIssuer()));
    }

    private static boolean isIndirectCRL(Extensions extensions) {
        Extension extension;
        return (extensions == null || (extension = extensions.getExtension(Extension.issuingDistributionPoint)) == null || !IssuingDistributionPoint.getInstance(extension.getParsedValue()).isIndirectCRL()) ? false : true;
    }

    private static CertificateList parseStream(InputStream inputStream) throws IOException {
        try {
            ASN1Primitive object = new ASN1InputStream(inputStream, true).readObject();
            if (object != null) {
                return CertificateList.getInstance(object);
            }
            throw new IOException("no content found");
        } catch (ClassCastException e) {
            throw new CertIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m14746init(CertificateList.getInstance(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m14747equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof X509CRLHolder) {
            return this.f18802x509CRL.mo14431equals(((X509CRLHolder) obj).f18802x509CRL);
        }
        return false;
    }

    public Set getCriticalExtensionOIDs() {
        return CertUtils.getCriticalExtensionOIDs(this.extensions);
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return this.f18802x509CRL.getEncoded();
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Extensions extensions = this.extensions;
        if (extensions != null) {
            return extensions.getExtension(aSN1ObjectIdentifier);
        }
        return null;
    }

    public List getExtensionOIDs() {
        return CertUtils.getExtensionOIDs(this.extensions);
    }

    public Extensions getExtensions() {
        return this.extensions;
    }

    public X500Name getIssuer() {
        return X500Name.getInstance(this.f18802x509CRL.getIssuer());
    }

    public Date getNextUpdate() {
        C5194Time nextUpdate = this.f18802x509CRL.getNextUpdate();
        if (nextUpdate != null) {
            return nextUpdate.m14707getDate();
        }
        return null;
    }

    public Set getNonCriticalExtensionOIDs() {
        return CertUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public X509CRLEntryHolder getRevokedCertificate(BigInteger bigInteger) {
        Extension extension;
        GeneralNames generalNames = this.issuerName;
        Enumeration revokedCertificateEnumeration = this.f18802x509CRL.getRevokedCertificateEnumeration();
        while (revokedCertificateEnumeration.hasMoreElements()) {
            TBSCertList.CRLEntry cRLEntry = (TBSCertList.CRLEntry) revokedCertificateEnumeration.nextElement();
            if (cRLEntry.getUserCertificate().hasValue(bigInteger)) {
                return new X509CRLEntryHolder(cRLEntry, this.isIndirect, generalNames);
            }
            if (this.isIndirect && cRLEntry.hasExtensions() && (extension = cRLEntry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
                generalNames = GeneralNames.getInstance(extension.getParsedValue());
            }
        }
        return null;
    }

    public Collection getRevokedCertificates() {
        ArrayList arrayList = new ArrayList(this.f18802x509CRL.getRevokedCertificates().length);
        GeneralNames certificateIssuer = this.issuerName;
        Enumeration revokedCertificateEnumeration = this.f18802x509CRL.getRevokedCertificateEnumeration();
        while (revokedCertificateEnumeration.hasMoreElements()) {
            X509CRLEntryHolder x509CRLEntryHolder = new X509CRLEntryHolder((TBSCertList.CRLEntry) revokedCertificateEnumeration.nextElement(), this.isIndirect, certificateIssuer);
            arrayList.add(x509CRLEntryHolder);
            certificateIssuer = x509CRLEntryHolder.getCertificateIssuer();
        }
        return arrayList;
    }

    public Date getThisUpdate() {
        return this.f18802x509CRL.getThisUpdate().m14707getDate();
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public int hashCode() {
        return this.f18802x509CRL.hashCode();
    }

    public boolean isAlternativeSignatureValid(ContentVerifierProvider contentVerifierProvider) throws IOException, CertException {
        int i;
        TBSCertList tBSCertList = this.f18802x509CRL.getTBSCertList();
        AltSignatureAlgorithm altSignatureAlgorithmFromExtensions = AltSignatureAlgorithm.fromExtensions(tBSCertList.getExtensions());
        AltSignatureValue altSignatureValueFromExtensions = AltSignatureValue.fromExtensions(tBSCertList.getExtensions());
        try {
            ContentVerifier contentVerifierMo17379get = contentVerifierProvider.mo17379get(AlgorithmIdentifier.getInstance(altSignatureAlgorithmFromExtensions.toASN1Primitive()));
            OutputStream outputStream = contentVerifierMo17379get.getOutputStream();
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(tBSCertList.toASN1Primitive());
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            if (aSN1Sequence.getObjectAt(0) instanceof ASN1Integer) {
                aSN1EncodableVector.m14420add(aSN1Sequence.getObjectAt(0));
                i = 2;
            } else {
                i = 1;
            }
            while (i != aSN1Sequence.mo14450size() - 1) {
                aSN1EncodableVector.m14420add(aSN1Sequence.getObjectAt(i));
                i++;
            }
            aSN1EncodableVector.m14420add(CertUtils.trimExtensions(0, tBSCertList.getExtensions()));
            new DERSequence(aSN1EncodableVector).encodeTo(outputStream, ASN1Encoding.f17902DER);
            outputStream.close();
            return contentVerifierMo17379get.mo16015verify(altSignatureValueFromExtensions.getSignature().getOctets());
        } catch (Exception e) {
            throw new CertException("unable to process signature: " + e.getMessage(), e);
        }
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) throws IOException, CertException {
        TBSCertList tBSCertList = this.f18802x509CRL.getTBSCertList();
        if (!CertUtils.isAlgIdEqual(tBSCertList.getSignature(), this.f18802x509CRL.getSignatureAlgorithm())) {
            throw new CertException("signature invalid - algorithm identifier mismatch");
        }
        try {
            ContentVerifier contentVerifierMo17379get = contentVerifierProvider.mo17379get(tBSCertList.getSignature());
            OutputStream outputStream = contentVerifierMo17379get.getOutputStream();
            tBSCertList.encodeTo(outputStream, ASN1Encoding.f17902DER);
            outputStream.close();
            return contentVerifierMo17379get.mo16015verify(this.f18802x509CRL.getSignature().getOctets());
        } catch (Exception e) {
            throw new CertException("unable to process signature: " + e.getMessage(), e);
        }
    }

    public CertificateList toASN1Structure() {
        return this.f18802x509CRL;
    }

    public X509CRLHolder(CertificateList certificateList) {
        m14746init(certificateList);
    }

    public X509CRLHolder(byte[] bArr) {
        this(parseStream(new ByteArrayInputStream(bArr)));
    }
}
