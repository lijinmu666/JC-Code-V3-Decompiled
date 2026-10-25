package org.bouncycastle.p177cert;

import java.io.IOException;
import java.math.BigInteger;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5104DERSet;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p174x509.AttCertIssuer;
import org.bouncycastle.p133asn1.p174x509.Attribute;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.ExtensionsGenerator;
import org.bouncycastle.p133asn1.p174x509.V2AttributeCertificateInfoGenerator;

/* loaded from: classes2.dex */
public class X509v2AttributeCertificateBuilder {
    private V2AttributeCertificateInfoGenerator acInfoGen;
    private ExtensionsGenerator extGenerator;

    public X509v2AttributeCertificateBuilder(AttributeCertificateHolder attributeCertificateHolder, AttributeCertificateIssuer attributeCertificateIssuer, BigInteger bigInteger, Date date, Date date2) {
        this.acInfoGen = new V2AttributeCertificateInfoGenerator();
        this.extGenerator = new ExtensionsGenerator();
        this.acInfoGen.setHolder(attributeCertificateHolder.f18795holder);
        this.acInfoGen.setIssuer(AttCertIssuer.getInstance(attributeCertificateIssuer.f18796form));
        this.acInfoGen.setSerialNumber(new ASN1Integer(bigInteger));
        this.acInfoGen.setStartDate(new ASN1GeneralizedTime(date));
        this.acInfoGen.setEndDate(new ASN1GeneralizedTime(date2));
    }

    private Extension doGetExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (this.extGenerator.m14688isEmpty()) {
            return null;
        }
        return this.extGenerator.generate().getExtension(aSN1ObjectIdentifier);
    }

    public X509v2AttributeCertificateBuilder addAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.acInfoGen.addAttribute(new Attribute(aSN1ObjectIdentifier, new C5104DERSet(aSN1Encodable)));
        return this;
    }

    public X509v2AttributeCertificateBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) throws CertIOException {
        CertUtils.addExtension(this.extGenerator, aSN1ObjectIdentifier, z, aSN1Encodable);
        return this;
    }

    /* renamed from: build */
    public X509AttributeCertificateHolder m14753build(ContentSigner contentSigner) {
        this.acInfoGen.setSignature(contentSigner.getAlgorithmIdentifier());
        if (!this.extGenerator.m14688isEmpty()) {
            this.acInfoGen.setExtensions(this.extGenerator.generate());
        }
        return CertUtils.generateFullAttrCert(contentSigner, this.acInfoGen.generateAttributeCertificateInfo());
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return doGetExtension(aSN1ObjectIdentifier);
    }

    public boolean hasExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return doGetExtension(aSN1ObjectIdentifier) != null;
    }

    public X509v2AttributeCertificateBuilder removeExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.extGenerator = CertUtils.doRemoveExtension(this.extGenerator, aSN1ObjectIdentifier);
        return this;
    }

    public X509v2AttributeCertificateBuilder replaceExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) throws CertIOException {
        try {
            this.extGenerator = CertUtils.doReplaceExtension(this.extGenerator, new Extension(aSN1ObjectIdentifier, z, new DEROctetString(aSN1Encodable)));
            return this;
        } catch (IOException e) {
            throw new CertIOException("cannot encode extension: " + e.getMessage(), e);
        }
    }

    public void setIssuerUniqueId(boolean[] zArr) {
        this.acInfoGen.setIssuerUniqueID(CertUtils.booleanToBitString(zArr));
    }

    public X509v2AttributeCertificateBuilder(AttributeCertificateHolder attributeCertificateHolder, AttributeCertificateIssuer attributeCertificateIssuer, BigInteger bigInteger, Date date, Date date2, Locale locale) {
        this.acInfoGen = new V2AttributeCertificateInfoGenerator();
        this.extGenerator = new ExtensionsGenerator();
        this.acInfoGen.setHolder(attributeCertificateHolder.f18795holder);
        this.acInfoGen.setIssuer(AttCertIssuer.getInstance(attributeCertificateIssuer.f18796form));
        this.acInfoGen.setSerialNumber(new ASN1Integer(bigInteger));
        this.acInfoGen.setStartDate(new ASN1GeneralizedTime(date, locale));
        this.acInfoGen.setEndDate(new ASN1GeneralizedTime(date2, locale));
    }

    public X509v2AttributeCertificateBuilder addAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable[] aSN1EncodableArr) {
        this.acInfoGen.addAttribute(new Attribute(aSN1ObjectIdentifier, new C5104DERSet(aSN1EncodableArr)));
        return this;
    }

    public X509v2AttributeCertificateBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extGenerator.addExtension(aSN1ObjectIdentifier, z, bArr);
        return this;
    }

    public X509v2AttributeCertificateBuilder replaceExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extGenerator = CertUtils.doReplaceExtension(this.extGenerator, new Extension(aSN1ObjectIdentifier, z, bArr));
        return this;
    }

    public X509v2AttributeCertificateBuilder(X509AttributeCertificateHolder x509AttributeCertificateHolder) {
        V2AttributeCertificateInfoGenerator v2AttributeCertificateInfoGenerator = new V2AttributeCertificateInfoGenerator();
        this.acInfoGen = v2AttributeCertificateInfoGenerator;
        v2AttributeCertificateInfoGenerator.setSerialNumber(new ASN1Integer(x509AttributeCertificateHolder.getSerialNumber()));
        this.acInfoGen.setIssuer(AttCertIssuer.getInstance(x509AttributeCertificateHolder.getIssuer().f18796form));
        this.acInfoGen.setStartDate(new ASN1GeneralizedTime(x509AttributeCertificateHolder.getNotBefore()));
        this.acInfoGen.setEndDate(new ASN1GeneralizedTime(x509AttributeCertificateHolder.getNotAfter()));
        this.acInfoGen.setHolder(x509AttributeCertificateHolder.getHolder().f18795holder);
        boolean[] issuerUniqueID = x509AttributeCertificateHolder.getIssuerUniqueID();
        if (issuerUniqueID != null) {
            this.acInfoGen.setIssuerUniqueID(CertUtils.booleanToBitString(issuerUniqueID));
        }
        Attribute[] attributes = x509AttributeCertificateHolder.getAttributes();
        for (int i = 0; i != attributes.length; i++) {
            this.acInfoGen.addAttribute(attributes[i]);
        }
        this.extGenerator = new ExtensionsGenerator();
        Extensions extensions = x509AttributeCertificateHolder.getExtensions();
        Enumeration enumerationM14687oids = extensions.m14687oids();
        while (enumerationM14687oids.hasMoreElements()) {
            this.extGenerator.addExtension(extensions.getExtension((ASN1ObjectIdentifier) enumerationM14687oids.nextElement()));
        }
    }

    public X509v2AttributeCertificateBuilder addExtension(Extension extension) {
        this.extGenerator.addExtension(extension);
        return this;
    }

    public X509v2AttributeCertificateBuilder replaceExtension(Extension extension) {
        this.extGenerator = CertUtils.doReplaceExtension(this.extGenerator, extension);
        return this;
    }
}
