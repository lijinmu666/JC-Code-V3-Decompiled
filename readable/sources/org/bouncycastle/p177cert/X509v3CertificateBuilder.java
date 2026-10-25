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
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1Object;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DERBitString;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.C5194Time;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.DeltaCertificateDescriptor;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.ExtensionsGenerator;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p174x509.TBSCertificate;
import org.bouncycastle.p133asn1.p174x509.V3TBSCertificateGenerator;
import org.bouncycastle.p361util.Exceptions;

/* loaded from: classes2.dex */
public class X509v3CertificateBuilder {
    private ExtensionsGenerator extGenerator;

    /* renamed from: tbsGen */
    private V3TBSCertificateGenerator f18805tbsGen;

    public X509v3CertificateBuilder(X500Name x500Name, BigInteger bigInteger, Date date, Date date2, Locale locale, X500Name x500Name2, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this(x500Name, bigInteger, new C5194Time(date, locale), new C5194Time(date2, locale), x500Name2, subjectPublicKeyInfo);
    }

    public static DERBitString booleanToBitString(boolean[] zArr) {
        byte[] bArr = new byte[(zArr.length + 7) / 8];
        for (int i = 0; i != zArr.length; i++) {
            int i2 = i >>> 3;
            bArr[i2] = (byte) (bArr[i2] | (zArr[i] ? (byte) (128 >> (i & 7)) : (byte) 0));
        }
        return new DERBitString(bArr, (8 - zArr.length) & 7);
    }

    private Extension doGetExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (this.extGenerator.m14688isEmpty()) {
            return null;
        }
        return this.extGenerator.generate().getExtension(aSN1ObjectIdentifier);
    }

    private static byte[] generateSig(ContentSigner contentSigner, ASN1Object aSN1Object) throws IOException {
        OutputStream outputStream = contentSigner.getOutputStream();
        aSN1Object.encodeTo(outputStream, ASN1Encoding.f17902DER);
        outputStream.close();
        return contentSigner.getSignature();
    }

    private static Certificate generateStructure(TBSCertificate tBSCertificate, AlgorithmIdentifier algorithmIdentifier, byte[] bArr) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.m14420add(tBSCertificate);
        aSN1EncodableVector.m14420add(algorithmIdentifier);
        aSN1EncodableVector.m14420add(new DERBitString(bArr));
        return Certificate.getInstance(new DERSequence(aSN1EncodableVector));
    }

    public X509v3CertificateBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) {
        try {
            this.extGenerator.addExtension(aSN1ObjectIdentifier, z, aSN1Encodable);
            return this;
        } catch (IOException e) {
            throw new CertIOException("cannot encode extension: " + e.getMessage(), e);
        }
    }

    /* renamed from: build */
    public X509CertificateHolder m14757build(ContentSigner contentSigner) {
        AlgorithmIdentifier algorithmIdentifier = contentSigner.getAlgorithmIdentifier();
        this.f18805tbsGen.setSignature(algorithmIdentifier);
        if (!this.extGenerator.m14688isEmpty()) {
            ExtensionsGenerator extensionsGenerator = this.extGenerator;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = Extension.deltaCertificateDescriptor;
            Extension extension = extensionsGenerator.getExtension(aSN1ObjectIdentifier);
            if (extension != null) {
                try {
                    this.extGenerator.replaceExtension(aSN1ObjectIdentifier, extension.isCritical(), DeltaCertificateTool.trimDeltaCertificateDescriptor(DeltaCertificateDescriptor.getInstance(extension.getParsedValue()), this.f18805tbsGen.generateTBSCertificate(), this.extGenerator.generate()));
                } catch (IOException e) {
                    throw new IllegalStateException("unable to replace deltaCertificateDescriptor: " + e.getMessage());
                }
            }
            this.f18805tbsGen.setExtensions(this.extGenerator.generate());
        }
        try {
            TBSCertificate tBSCertificateGenerateTBSCertificate = this.f18805tbsGen.generateTBSCertificate();
            return new X509CertificateHolder(generateStructure(tBSCertificateGenerateTBSCertificate, algorithmIdentifier, generateSig(contentSigner, tBSCertificateGenerateTBSCertificate)));
        } catch (IOException e2) {
            throw Exceptions.illegalArgumentException("cannot produce certificate signature", e2);
        }
    }

    public X509v3CertificateBuilder copyAndAddExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, X509CertificateHolder x509CertificateHolder) {
        Extension extension = x509CertificateHolder.toASN1Structure().getTBSCertificate().getExtensions().getExtension(aSN1ObjectIdentifier);
        if (extension != null) {
            this.extGenerator.addExtension(aSN1ObjectIdentifier, z, extension.getExtnValue().getOctets());
            return this;
        }
        throw new NullPointerException("extension " + aSN1ObjectIdentifier + " not present");
    }

    public Extension getExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return doGetExtension(aSN1ObjectIdentifier);
    }

    public boolean hasExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return doGetExtension(aSN1ObjectIdentifier) != null;
    }

    public X509v3CertificateBuilder removeExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this.extGenerator = CertUtils.doRemoveExtension(this.extGenerator, aSN1ObjectIdentifier);
        return this;
    }

    public X509v3CertificateBuilder replaceExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, ASN1Encodable aSN1Encodable) throws CertIOException {
        try {
            this.extGenerator = CertUtils.doReplaceExtension(this.extGenerator, new Extension(aSN1ObjectIdentifier, z, new DEROctetString(aSN1Encodable)));
            return this;
        } catch (IOException e) {
            throw new CertIOException("cannot encode extension: " + e.getMessage(), e);
        }
    }

    public X509v3CertificateBuilder setIssuerUniqueID(boolean[] zArr) {
        this.f18805tbsGen.setIssuerUniqueID(booleanToBitString(zArr));
        return this;
    }

    public X509v3CertificateBuilder setSubjectUniqueID(boolean[] zArr) {
        this.f18805tbsGen.setSubjectUniqueID(booleanToBitString(zArr));
        return this;
    }

    public X509v3CertificateBuilder(X500Name x500Name, BigInteger bigInteger, Date date, Date date2, X500Name x500Name2, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        this(x500Name, bigInteger, new C5194Time(date), new C5194Time(date2), x500Name2, subjectPublicKeyInfo);
    }

    public X509v3CertificateBuilder addExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extGenerator.addExtension(aSN1ObjectIdentifier, z, bArr);
        return this;
    }

    /* renamed from: build */
    public X509CertificateHolder m14758build(ContentSigner contentSigner, boolean z, ContentSigner contentSigner2) {
        AlgorithmIdentifier algorithmIdentifier = contentSigner.getAlgorithmIdentifier();
        try {
            this.extGenerator.addExtension(Extension.altSignatureAlgorithm, z, contentSigner2.getAlgorithmIdentifier());
            ExtensionsGenerator extensionsGenerator = this.extGenerator;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = Extension.deltaCertificateDescriptor;
            Extension extension = extensionsGenerator.getExtension(aSN1ObjectIdentifier);
            if (extension != null) {
                this.f18805tbsGen.setSignature(algorithmIdentifier);
                try {
                    ExtensionsGenerator extensionsGenerator2 = new ExtensionsGenerator();
                    extensionsGenerator2.addExtensions(this.extGenerator.generate());
                    extensionsGenerator2.addExtension(Extension.altSignatureValue, false, (ASN1Encodable) C5103DERNull.INSTANCE);
                    this.extGenerator.replaceExtension(aSN1ObjectIdentifier, extension.isCritical(), DeltaCertificateTool.trimDeltaCertificateDescriptor(DeltaCertificateDescriptor.getInstance(extension.getParsedValue()), this.f18805tbsGen.generateTBSCertificate(), extensionsGenerator2.generate()));
                } catch (IOException e) {
                    throw new IllegalStateException("unable to replace deltaCertificateDescriptor: " + e.getMessage());
                }
            }
            this.f18805tbsGen.setSignature(null);
            this.f18805tbsGen.setExtensions(this.extGenerator.generate());
            try {
                this.extGenerator.addExtension(Extension.altSignatureValue, z, new DERBitString(generateSig(contentSigner2, this.f18805tbsGen.generatePreTBSCertificate())));
                this.f18805tbsGen.setSignature(algorithmIdentifier);
                this.f18805tbsGen.setExtensions(this.extGenerator.generate());
                TBSCertificate tBSCertificateGenerateTBSCertificate = this.f18805tbsGen.generateTBSCertificate();
                return new X509CertificateHolder(generateStructure(tBSCertificateGenerateTBSCertificate, algorithmIdentifier, generateSig(contentSigner, tBSCertificateGenerateTBSCertificate)));
            } catch (IOException e2) {
                throw Exceptions.illegalArgumentException("cannot produce certificate signature", e2);
            }
        } catch (IOException e3) {
            throw Exceptions.illegalStateException("cannot add altSignatureAlgorithm extension", e3);
        }
    }

    public X509v3CertificateBuilder replaceExtension(ASN1ObjectIdentifier aSN1ObjectIdentifier, boolean z, byte[] bArr) {
        this.extGenerator = CertUtils.doReplaceExtension(this.extGenerator, new Extension(aSN1ObjectIdentifier, z, bArr));
        return this;
    }

    public X509v3CertificateBuilder(X500Name x500Name, BigInteger bigInteger, C5194Time c5194Time, C5194Time c5194Time2, X500Name x500Name2, SubjectPublicKeyInfo subjectPublicKeyInfo) {
        V3TBSCertificateGenerator v3TBSCertificateGenerator = new V3TBSCertificateGenerator();
        this.f18805tbsGen = v3TBSCertificateGenerator;
        v3TBSCertificateGenerator.setSerialNumber(new ASN1Integer(bigInteger));
        this.f18805tbsGen.setIssuer(x500Name);
        this.f18805tbsGen.setStartDate(c5194Time);
        this.f18805tbsGen.setEndDate(c5194Time2);
        this.f18805tbsGen.setSubject(x500Name2);
        this.f18805tbsGen.setSubjectPublicKeyInfo(subjectPublicKeyInfo);
        this.extGenerator = new ExtensionsGenerator();
    }

    public X509v3CertificateBuilder addExtension(Extension extension) {
        this.extGenerator.addExtension(extension);
        return this;
    }

    public X509v3CertificateBuilder replaceExtension(Extension extension) {
        this.extGenerator = CertUtils.doReplaceExtension(this.extGenerator, extension);
        return this;
    }

    public X509v3CertificateBuilder(X509CertificateHolder x509CertificateHolder) {
        V3TBSCertificateGenerator v3TBSCertificateGenerator = new V3TBSCertificateGenerator();
        this.f18805tbsGen = v3TBSCertificateGenerator;
        v3TBSCertificateGenerator.setSerialNumber(new ASN1Integer(x509CertificateHolder.getSerialNumber()));
        this.f18805tbsGen.setIssuer(x509CertificateHolder.getIssuer());
        this.f18805tbsGen.setStartDate(new C5194Time(x509CertificateHolder.getNotBefore()));
        this.f18805tbsGen.setEndDate(new C5194Time(x509CertificateHolder.getNotAfter()));
        this.f18805tbsGen.setSubject(x509CertificateHolder.getSubject());
        this.f18805tbsGen.setSubjectPublicKeyInfo(x509CertificateHolder.getSubjectPublicKeyInfo());
        this.extGenerator = new ExtensionsGenerator();
        Extensions extensions = x509CertificateHolder.getExtensions();
        Enumeration enumerationM14687oids = extensions.m14687oids();
        while (enumerationM14687oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) enumerationM14687oids.nextElement();
            if (!Extension.subjectAltPublicKeyInfo.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.altSignatureAlgorithm.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.altSignatureValue.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                this.extGenerator.addExtension(extensions.getExtension(aSN1ObjectIdentifier));
            }
        }
    }
}
