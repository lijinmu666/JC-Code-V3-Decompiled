package org.bouncycastle.p177cert;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.Set;
import org.bouncycastle.operator.ContentVerifier;
import org.bouncycastle.operator.ContentVerifierProvider;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.AltSignatureAlgorithm;
import org.bouncycastle.p133asn1.p174x509.AltSignatureValue;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p174x509.TBSCertificate;
import org.bouncycastle.p361util.Encodable;

/* loaded from: classes2.dex */
public class X509CertificateHolder implements Encodable, Serializable {
    private static final long serialVersionUID = 20170722001L;
    private transient Extensions extensions;
    private transient Certificate x509Certificate;

    public X509CertificateHolder(Certificate certificate) {
        m14748init(certificate);
    }

    /* renamed from: init */
    private void m14748init(Certificate certificate) {
        this.x509Certificate = certificate;
        this.extensions = certificate.getTBSCertificate().getExtensions();
    }

    private static Certificate parseBytes(byte[] bArr) throws CertIOException {
        try {
            return Certificate.getInstance(CertUtils.parseNonEmptyASN1(bArr));
        } catch (ClassCastException e) {
            throw new CertIOException("malformed data: " + e.getMessage(), e);
        } catch (IllegalArgumentException e2) {
            throw new CertIOException("malformed data: " + e2.getMessage(), e2);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        m14748init(Certificate.getInstance(objectInputStream.readObject()));
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    /* renamed from: equals */
    public boolean m14749equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof X509CertificateHolder) {
            return this.x509Certificate.mo14431equals(((X509CertificateHolder) obj).x509Certificate);
        }
        return false;
    }

    public Set getCriticalExtensionOIDs() {
        return CertUtils.getCriticalExtensionOIDs(this.extensions);
    }

    @Override // org.bouncycastle.p361util.Encodable
    public byte[] getEncoded() {
        return this.x509Certificate.getEncoded();
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
        return X500Name.getInstance(this.x509Certificate.getIssuer());
    }

    public Set getNonCriticalExtensionOIDs() {
        return CertUtils.getNonCriticalExtensionOIDs(this.extensions);
    }

    public Date getNotAfter() {
        return this.x509Certificate.getEndDate().m14707getDate();
    }

    public Date getNotBefore() {
        return this.x509Certificate.getStartDate().m14707getDate();
    }

    public BigInteger getSerialNumber() {
        return this.x509Certificate.getSerialNumber().getValue();
    }

    public byte[] getSignature() {
        return this.x509Certificate.getSignature().getOctets();
    }

    public AlgorithmIdentifier getSignatureAlgorithm() {
        return this.x509Certificate.getSignatureAlgorithm();
    }

    public X500Name getSubject() {
        return X500Name.getInstance(this.x509Certificate.getSubject());
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.x509Certificate.getSubjectPublicKeyInfo();
    }

    public TBSCertificate getTBSCertificate() {
        return this.x509Certificate.getTBSCertificate();
    }

    public int getVersion() {
        return this.x509Certificate.getVersionNumber();
    }

    public int getVersionNumber() {
        return this.x509Certificate.getVersionNumber();
    }

    public boolean hasExtensions() {
        return this.extensions != null;
    }

    public int hashCode() {
        return this.x509Certificate.hashCode();
    }

    public boolean isAlternativeSignatureValid(ContentVerifierProvider contentVerifierProvider) throws IOException, CertException {
        TBSCertificate tBSCertificate = this.x509Certificate.getTBSCertificate();
        AltSignatureAlgorithm altSignatureAlgorithmFromExtensions = AltSignatureAlgorithm.fromExtensions(tBSCertificate.getExtensions());
        AltSignatureValue altSignatureValueFromExtensions = AltSignatureValue.fromExtensions(tBSCertificate.getExtensions());
        try {
            ContentVerifier contentVerifierMo17379get = contentVerifierProvider.mo17379get(AlgorithmIdentifier.getInstance(altSignatureAlgorithmFromExtensions.toASN1Primitive()));
            OutputStream outputStream = contentVerifierMo17379get.getOutputStream();
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(tBSCertificate.toASN1Primitive());
            ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
            for (int i = 0; i != aSN1Sequence.mo14450size() - 1; i++) {
                if (i != 2) {
                    aSN1EncodableVector.m14420add(aSN1Sequence.getObjectAt(i));
                }
            }
            aSN1EncodableVector.m14420add(CertUtils.trimExtensions(3, tBSCertificate.getExtensions()));
            new DERSequence(aSN1EncodableVector).encodeTo(outputStream, ASN1Encoding.f17902DER);
            outputStream.close();
            return contentVerifierMo17379get.mo16015verify(altSignatureValueFromExtensions.getSignature().getOctets());
        } catch (Exception e) {
            throw new CertException("unable to process signature: " + e.getMessage(), e);
        }
    }

    public boolean isSignatureValid(ContentVerifierProvider contentVerifierProvider) throws IOException, CertException {
        TBSCertificate tBSCertificate = this.x509Certificate.getTBSCertificate();
        if (!CertUtils.isAlgIdEqual(tBSCertificate.getSignature(), this.x509Certificate.getSignatureAlgorithm())) {
            throw new CertException("signature invalid - algorithm identifier mismatch");
        }
        try {
            ContentVerifier contentVerifierMo17379get = contentVerifierProvider.mo17379get(tBSCertificate.getSignature());
            OutputStream outputStream = contentVerifierMo17379get.getOutputStream();
            tBSCertificate.encodeTo(outputStream, ASN1Encoding.f17902DER);
            outputStream.close();
            return contentVerifierMo17379get.mo16015verify(getSignature());
        } catch (Exception e) {
            throw new CertException("unable to process signature: " + e.getMessage(), e);
        }
    }

    public boolean isValidOn(Date date) {
        return (date.before(this.x509Certificate.getStartDate().m14707getDate()) || date.after(this.x509Certificate.getEndDate().m14707getDate())) ? false : true;
    }

    public Certificate toASN1Structure() {
        return this.x509Certificate;
    }

    public X509CertificateHolder(byte[] bArr) {
        this(parseBytes(bArr));
    }
}
