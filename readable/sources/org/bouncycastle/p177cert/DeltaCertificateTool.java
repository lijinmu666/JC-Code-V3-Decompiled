package org.bouncycastle.p177cert;

import java.util.Enumeration;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.DeltaCertificateDescriptor;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.ExtensionsGenerator;
import org.bouncycastle.p133asn1.p174x509.TBSCertificate;
import org.bouncycastle.p133asn1.p174x509.Validity;

/* loaded from: classes2.dex */
public class DeltaCertificateTool {
    public static Certificate extractDeltaCertificate(TBSCertificate tBSCertificate) {
        Extensions extensions = tBSCertificate.getExtensions();
        Extension extension = extensions.getExtension(Extension.deltaCertificateDescriptor);
        if (extension == null) {
            throw new IllegalStateException("no deltaCertificateDescriptor present");
        }
        DeltaCertificateDescriptor deltaCertificateDescriptor = DeltaCertificateDescriptor.getInstance(extension.getParsedValue());
        ASN1Integer version = tBSCertificate.getVersion();
        ASN1Integer serialNumber = deltaCertificateDescriptor.getSerialNumber();
        AlgorithmIdentifier signature = deltaCertificateDescriptor.getSignature();
        if (signature == null) {
            signature = tBSCertificate.getSignature();
        }
        AlgorithmIdentifier algorithmIdentifier = signature;
        X500Name issuer = deltaCertificateDescriptor.getIssuer();
        if (issuer == null) {
            issuer = tBSCertificate.getIssuer();
        }
        X500Name x500Name = issuer;
        Validity validityObject = deltaCertificateDescriptor.getValidityObject();
        if (validityObject == null) {
            validityObject = tBSCertificate.getValidity();
        }
        Validity validity = validityObject;
        X500Name subject = deltaCertificateDescriptor.getSubject();
        return new Certificate(new TBSCertificate(version, serialNumber, algorithmIdentifier, x500Name, validity, subject == null ? tBSCertificate.getSubject() : subject, deltaCertificateDescriptor.getSubjectPublicKeyInfo(), null, null, extractDeltaExtensions(deltaCertificateDescriptor.getExtensions(), extensions)), algorithmIdentifier, deltaCertificateDescriptor.getSignatureValue());
    }

    private static Extensions extractDeltaExtensions(Extensions extensions, Extensions extensions2) {
        ExtensionsGenerator extensionsGenerator = new ExtensionsGenerator();
        Enumeration enumerationM14687oids = extensions2.m14687oids();
        while (enumerationM14687oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) enumerationM14687oids.nextElement();
            if (!Extension.deltaCertificateDescriptor.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                extensionsGenerator.addExtension(extensions2.getExtension(aSN1ObjectIdentifier));
            }
        }
        if (extensions != null) {
            Enumeration enumerationM14687oids2 = extensions.m14687oids();
            while (enumerationM14687oids2.hasMoreElements()) {
                extensionsGenerator.replaceExtension(extensions.getExtension((ASN1ObjectIdentifier) enumerationM14687oids2.nextElement()));
            }
        }
        if (extensionsGenerator.m14688isEmpty()) {
            return null;
        }
        return extensionsGenerator.generate();
    }

    public static Extension makeDeltaCertificateExtension(boolean z, Certificate certificate) {
        return new Extension(Extension.deltaCertificateDescriptor, z, new DEROctetString(new DeltaCertificateDescriptor(certificate.getSerialNumber(), certificate.getSignatureAlgorithm(), certificate.getIssuer(), certificate.getValidity(), certificate.getSubject(), certificate.getSubjectPublicKeyInfo(), certificate.getExtensions(), certificate.getSignature()).getEncoded(ASN1Encoding.f17902DER)));
    }

    public static DeltaCertificateDescriptor trimDeltaCertificateDescriptor(DeltaCertificateDescriptor deltaCertificateDescriptor, TBSCertificate tBSCertificate, Extensions extensions) {
        return deltaCertificateDescriptor.m14682trimTo(tBSCertificate, extensions);
    }

    public static X509CertificateHolder extractDeltaCertificate(X509CertificateHolder x509CertificateHolder) {
        return new X509CertificateHolder(extractDeltaCertificate(x509CertificateHolder.getTBSCertificate()));
    }

    public static Extension makeDeltaCertificateExtension(boolean z, X509CertificateHolder x509CertificateHolder) {
        return makeDeltaCertificateExtension(z, x509CertificateHolder.toASN1Structure());
    }
}
