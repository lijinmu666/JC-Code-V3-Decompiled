package org.bouncycastle.p177cert;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.Date;
import java.util.Enumeration;
import java.util.Locale;
import org.bouncycastle.operator.ContentSigner;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1GeneralizedTime;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.C5194Time;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.ExtensionsGenerator;
import org.bouncycastle.p133asn1.p174x509.TBSCertList;
import org.bouncycastle.p133asn1.p174x509.V2TBSCertListGenerator;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
public class X509v2CRLBuilder {
    private ExtensionsGenerator extGenerator;

    /* renamed from: tbsGen */
    private V2TBSCertListGenerator f18804tbsGen;

    public X509v2CRLBuilder(X500Name x500Name, Date date) {
        this.f18804tbsGen = new V2TBSCertListGenerator();
        this.extGenerator = new ExtensionsGenerator();
        this.f18804tbsGen.setIssuer(x500Name);
        this.f18804tbsGen.setThisUpdate(new C5194Time(date));
    }

    private Extension doGetExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (this.extGenerator.m14688isEmpty()) {
            return null;
        }
        return this.extGenerator.generate().getExtension(aSN1ObjectIdentifier);
    }

    private static CertificateList generateCRLStructure(TBSCertList tBSCertList, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(tBSCertList);
        aSN1EncodableVector.m14420add(algorithmIdentifier);
        aSN1EncodableVector.m14420add(new DERBitString(bArr));
        return CertificateList.getInstance(new DERSequence(aSN1EncodableVector));
    }

    private static X509CRLHolder generateFullCRL(ContentSigner contentSigner, TBSCertList tBSCertList) {
        try {
            return new X509CRLHolder(generateCRLStructure(tBSCertList, contentSigner.getAlgorithmIdentifier(), generateSig(contentSigner, tBSCertList)));
        } catch (IOException e) {
            throw Exceptions.illegalStateException("cannot produce certificate signature", e);
        }
    }

    private static byte[] generateSig(ContentSigner contentSigner, ASN1Object aSN1Object) throws IOException {
        OutputStream outputStream = contentSigner.getOutputStream();
        aSN1Object.encodeTo(outputStream, ASN1Encoding.f17902DER);
        outputStream.close();
        return contentSigner.getSignature();
    }

    /* renamed from: addCRL */
    public X509v2CRLBuilder m14754addCRL(X509CRLHolder x509CRLHolder) {
        TBSCertList tBSCertList = x509CRLHolder.toASN1Structure().getTBSCertList();
        if (tBSCertList != null) {
            Enumeration revokedCertificateEnumeration = tBSCertList.getRevokedCertificateEnumeration();
            while (revokedCertificateEnumeration.hasMoreElements()) {
                this.f18804tbsGen.addCRLEntry(ASN1Sequence.getInstance(((ASN1Encodable) revokedCertificateEnumeration.nextElement()).toASN1Primitive()));
            }
        }
        return this;
    }

    public X509v2CRLBuilder addCRLEntry(BigInteger bigInteger, Date date, int i) {
        this.f18804tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new C5194Time(date), i);
        return this;
    }

    public X509v2CRLBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) throws CertIOException {
        CertUtils.addExtension(this.extGenerator, aSN1ObjectIdentifier, z, aSN1Encodable);
        return this;
    }

    /* renamed from: build */
    public X509CRLHolder m14755build(ContentSigner contentSigner) {
        this.f18804tbsGen.setSignature(contentSigner.getAlgorithmIdentifier());
        if (!this.extGenerator.m14688isEmpty()) {
            this.f18804tbsGen.setExtensions(this.extGenerator.generate());
        }
        return generateFullCRL(contentSigner, this.f18804tbsGen.generateTBSCertList());
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return doGetExtension(aSN1ObjectIdentifier);
    }

    public boolean hasExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return doGetExtension(aSN1ObjectIdentifier) != null;
    }

    public X509v2CRLBuilder removeExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.extGenerator = CertUtils.doRemoveExtension(this.extGenerator, aSN1ObjectIdentifier);
        return this;
    }

    public X509v2CRLBuilder replaceExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) throws CertIOException {
        try {
            this.extGenerator = CertUtils.doReplaceExtension(this.extGenerator, new Extension(aSN1ObjectIdentifier, z, new DEROctetString(aSN1Encodable)));
            return this;
        } catch (IOException e) {
            throw new CertIOException("cannot encode extension: " + e.getMessage(), e);
        }
    }

    public X509v2CRLBuilder setNextUpdate(Date date) {
        return setNextUpdate(new C5194Time(date));
    }

    public X509v2CRLBuilder setThisUpdate(Date date) {
        return setThisUpdate(new C5194Time(date));
    }

    public X509v2CRLBuilder(X500Name x500Name, Date date, Locale locale) {
        this.f18804tbsGen = new V2TBSCertListGenerator();
        this.extGenerator = new ExtensionsGenerator();
        this.f18804tbsGen.setIssuer(x500Name);
        this.f18804tbsGen.setThisUpdate(new C5194Time(date, locale));
    }

    public X509v2CRLBuilder addCRLEntry(BigInteger bigInteger, Date date, int i, Date date2) {
        this.f18804tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new C5194Time(date), i, new ASN1GeneralizedTime(date2));
        return this;
    }

    public X509v2CRLBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extGenerator.addExtension(aSN1ObjectIdentifier, z, bArr);
        return this;
    }

    /* renamed from: build */
    public X509CRLHolder m14756build(ContentSigner contentSigner, boolean z, ContentSigner contentSigner2) {
        this.f18804tbsGen.setSignature(null);
        try {
            this.extGenerator.addExtension(Extension.altSignatureAlgorithm, z, contentSigner2.getAlgorithmIdentifier());
            this.f18804tbsGen.setExtensions(this.extGenerator.generate());
            try {
                this.extGenerator.addExtension(Extension.altSignatureValue, z, new DERBitString(generateSig(contentSigner2, this.f18804tbsGen.generatePreTBSCertList())));
                this.f18804tbsGen.setSignature(contentSigner.getAlgorithmIdentifier());
                this.f18804tbsGen.setExtensions(this.extGenerator.generate());
                TBSCertList tBSCertListGenerateTBSCertList = this.f18804tbsGen.generateTBSCertList();
                return new X509CRLHolder(generateCRLStructure(tBSCertListGenerateTBSCertList, contentSigner.getAlgorithmIdentifier(), generateSig(contentSigner, tBSCertListGenerateTBSCertList)));
            } catch (IOException e) {
                throw Exceptions.illegalArgumentException("cannot produce certificate signature", e);
            }
        } catch (IOException e2) {
            throw Exceptions.illegalStateException("cannot add altSignatureAlgorithm extension", e2);
        }
    }

    public X509v2CRLBuilder replaceExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extGenerator = CertUtils.doReplaceExtension(this.extGenerator, new Extension(aSN1ObjectIdentifier, z, bArr));
        return this;
    }

    public X509v2CRLBuilder setNextUpdate(Date date, Locale locale) {
        return setNextUpdate(new C5194Time(date, locale));
    }

    public X509v2CRLBuilder setThisUpdate(Date date, Locale locale) {
        return setThisUpdate(new C5194Time(date, locale));
    }

    public X509v2CRLBuilder(X500Name x500Name, C5194Time c5194Time) {
        this.f18804tbsGen = new V2TBSCertListGenerator();
        this.extGenerator = new ExtensionsGenerator();
        this.f18804tbsGen.setIssuer(x500Name);
        this.f18804tbsGen.setThisUpdate(c5194Time);
    }

    public X509v2CRLBuilder addCRLEntry(BigInteger bigInteger, Date date, Extensions extensions) {
        this.f18804tbsGen.addCRLEntry(new ASN1Integer(bigInteger), new C5194Time(date), extensions);
        return this;
    }

    public X509v2CRLBuilder addExtension(Extension extension) {
        this.extGenerator.addExtension(extension);
        return this;
    }

    public X509v2CRLBuilder replaceExtension(Extension extension) {
        this.extGenerator = CertUtils.doReplaceExtension(this.extGenerator, extension);
        return this;
    }

    public X509v2CRLBuilder setNextUpdate(C5194Time c5194Time) {
        this.f18804tbsGen.setNextUpdate(c5194Time);
        return this;
    }

    public X509v2CRLBuilder setThisUpdate(C5194Time c5194Time) {
        this.f18804tbsGen.setThisUpdate(c5194Time);
        return this;
    }

    public X509v2CRLBuilder(X509CRLHolder x509CRLHolder) {
        V2TBSCertListGenerator v2TBSCertListGenerator = new V2TBSCertListGenerator();
        this.f18804tbsGen = v2TBSCertListGenerator;
        v2TBSCertListGenerator.setIssuer(x509CRLHolder.getIssuer());
        this.f18804tbsGen.setThisUpdate(new C5194Time(x509CRLHolder.getThisUpdate()));
        Date nextUpdate = x509CRLHolder.getNextUpdate();
        if (nextUpdate != null) {
            this.f18804tbsGen.setNextUpdate(new C5194Time(nextUpdate));
        }
        m14754addCRL(x509CRLHolder);
        this.extGenerator = new ExtensionsGenerator();
        Extensions extensions = x509CRLHolder.getExtensions();
        if (extensions != null) {
            Enumeration enumerationM14687oids = extensions.m14687oids();
            while (enumerationM14687oids.hasMoreElements()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) enumerationM14687oids.nextElement();
                if (!Extension.altSignatureAlgorithm.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.altSignatureValue.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                    this.extGenerator.addExtension(extensions.getExtension(aSN1ObjectIdentifier));
                }
            }
        }
    }
}
