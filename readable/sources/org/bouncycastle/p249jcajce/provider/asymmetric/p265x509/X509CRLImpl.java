package org.bouncycastle.p249jcajce.provider.asymmetric.p265x509;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CRLException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.X509CRL;
import java.security.cert.X509CRLEntry;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.C5194Time;
import org.bouncycastle.p133asn1.p174x509.CertificateList;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.TBSCertList;
import org.bouncycastle.p249jcajce.CompositePublicKey;
import org.bouncycastle.p249jcajce.p250io.OutputStreamFactory;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p281jce.X509Principal;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
abstract class X509CRLImpl extends X509CRL {
    protected JcaJceHelper bcHelper;

    /* renamed from: c */
    protected CertificateList f21652c;
    protected boolean isIndirect;
    protected String sigAlgName;
    protected byte[] sigAlgParams;

    public X509CRLImpl(JcaJceHelper jcaJceHelper, CertificateList certificateList, String str, byte[] bArr, boolean z) {
        this.bcHelper = jcaJceHelper;
        this.f21652c = certificateList;
        this.sigAlgName = str;
        this.sigAlgParams = bArr;
        this.isIndirect = z;
    }

    private void checkSignature(PublicKey publicKey, Signature signature, ASN1Encodable aSN1Encodable, byte[] bArr) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CRLException, InvalidAlgorithmParameterException {
        if (!X509SignatureUtil.areEquivalentAlgorithms(this.f21652c.getSignatureAlgorithm(), this.f21652c.getTBSCertList().getSignature())) {
            throw new CRLException("Signature algorithm on CertificateList does not match TbsCertList.");
        }
        X509SignatureUtil.setSignatureParameters(signature, aSN1Encodable);
        signature.initVerify(publicKey);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(OutputStreamFactory.createStream(signature), 512);
            this.f21652c.getTBSCertList().encodeTo(bufferedOutputStream, ASN1Encoding.f17902DER);
            bufferedOutputStream.close();
            if (!signature.verify(bArr)) {
                throw new SignatureException("CRL does not verify with supplied public key.");
            }
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    private void doVerify(PublicKey publicKey, SignatureCreator signatureCreator) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CRLException, InvalidAlgorithmParameterException {
        if (!this.f21652c.getSignatureAlgorithm().mo14431equals(this.f21652c.getTBSCertList().getSignature())) {
            throw new CRLException("Signature algorithm on CertificateList does not match TBSCertList.");
        }
        int i = 0;
        if ((publicKey instanceof CompositePublicKey) && X509SignatureUtil.isCompositeAlgorithm(this.f21652c.getSignatureAlgorithm())) {
            List<PublicKey> publicKeys = ((CompositePublicKey) publicKey).getPublicKeys();
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(this.f21652c.getSignatureAlgorithm().getParameters());
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(this.f21652c.getSignature().getOctets());
            boolean z = false;
            while (i != publicKeys.size()) {
                if (publicKeys.get(i) != null) {
                    AlgorithmIdentifier algorithmIdentifier = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
                    try {
                        checkSignature(publicKeys.get(i), signatureCreator.createSignature(X509SignatureUtil.getSignatureName(algorithmIdentifier)), algorithmIdentifier.getParameters(), ASN1BitString.getInstance(aSN1Sequence2.getObjectAt(i)).getOctets());
                        e = null;
                        z = true;
                    } catch (SignatureException e) {
                        e = e;
                    }
                    if (e != null) {
                        throw e;
                    }
                }
                i++;
            }
            if (!z) {
                throw new InvalidKeyException("no matching key found");
            }
            return;
        }
        if (!X509SignatureUtil.isCompositeAlgorithm(this.f21652c.getSignatureAlgorithm())) {
            Signature signatureCreateSignature = signatureCreator.createSignature(getSigAlgName());
            byte[] bArr = this.sigAlgParams;
            if (bArr == null) {
                checkSignature(publicKey, signatureCreateSignature, null, getSignature());
                return;
            }
            try {
                checkSignature(publicKey, signatureCreateSignature, ASN1Primitive.fromByteArray(bArr), getSignature());
                return;
            } catch (IOException e2) {
                throw new SignatureException("cannot decode signature parameters: " + e2.getMessage());
            }
        }
        ASN1Sequence aSN1Sequence3 = ASN1Sequence.getInstance(this.f21652c.getSignatureAlgorithm().getParameters());
        ASN1Sequence aSN1Sequence4 = ASN1Sequence.getInstance(this.f21652c.getSignature().getOctets());
        boolean z2 = false;
        while (i != aSN1Sequence4.mo14450size()) {
            AlgorithmIdentifier algorithmIdentifier2 = AlgorithmIdentifier.getInstance(aSN1Sequence3.getObjectAt(i));
            try {
                checkSignature(publicKey, signatureCreator.createSignature(X509SignatureUtil.getSignatureName(algorithmIdentifier2)), algorithmIdentifier2.getParameters(), ASN1BitString.getInstance(aSN1Sequence4.getObjectAt(i)).getOctets());
                e = null;
                z2 = true;
            } catch (InvalidKeyException | NoSuchAlgorithmException unused) {
                e = null;
            } catch (SignatureException e3) {
                e = e3;
            }
            if (e != null) {
                throw e;
            }
            i++;
        }
        if (!z2) {
            throw new InvalidKeyException("no matching key found");
        }
    }

    private Set getExtensionOIDs(boolean z) {
        Extensions extensions;
        if (getVersion() != 2 || (extensions = this.f21652c.getExtensions()) == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Enumeration enumerationM14687oids = extensions.m14687oids();
        while (enumerationM14687oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) enumerationM14687oids.nextElement();
            if (z == extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                hashSet.add(aSN1ObjectIdentifier.m14433getId());
            }
        }
        return hashSet;
    }

    public static byte[] getExtensionOctets(CertificateList certificateList, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        ASN1OctetString extensionValue = Extensions.getExtensionValue(certificateList.getExtensions(), aSN1ObjectIdentifier);
        if (extensionValue == null) {
            return null;
        }
        return extensionValue.getOctets();
    }

    private Set loadCRLEntries() {
        Extension extension;
        HashSet hashSet = new HashSet();
        Enumeration revokedCertificateEnumeration = this.f21652c.getRevokedCertificateEnumeration();
        X500Name x500Name = null;
        while (revokedCertificateEnumeration.hasMoreElements()) {
            TBSCertList.CRLEntry cRLEntry = (TBSCertList.CRLEntry) revokedCertificateEnumeration.nextElement();
            hashSet.add(new X509CRLEntryObject(cRLEntry, this.isIndirect, x500Name));
            if (this.isIndirect && cRLEntry.hasExtensions() && (extension = cRLEntry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
                x500Name = X500Name.getInstance(GeneralNames.getInstance(extension.getParsedValue()).getNames()[0].m14690getName());
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        return X509SignatureUtil.getExtensionValue(this.f21652c.getExtensions(), str);
    }

    @Override // java.security.cert.X509CRL
    public Principal getIssuerDN() {
        return new X509Principal(X500Name.getInstance(this.f21652c.getIssuer().toASN1Primitive()));
    }

    @Override // java.security.cert.X509CRL
    public X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.f21652c.getIssuer().getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509CRL
    public Date getNextUpdate() {
        C5194Time nextUpdate = this.f21652c.getNextUpdate();
        if (nextUpdate == null) {
            return null;
        }
        return nextUpdate.m14707getDate();
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    @Override // java.security.cert.X509CRL
    public X509CRLEntry getRevokedCertificate(BigInteger bigInteger) {
        Extension extension;
        Enumeration revokedCertificateEnumeration = this.f21652c.getRevokedCertificateEnumeration();
        X500Name x500Name = null;
        while (revokedCertificateEnumeration.hasMoreElements()) {
            TBSCertList.CRLEntry cRLEntry = (TBSCertList.CRLEntry) revokedCertificateEnumeration.nextElement();
            if (cRLEntry.getUserCertificate().hasValue(bigInteger)) {
                return new X509CRLEntryObject(cRLEntry, this.isIndirect, x500Name);
            }
            if (this.isIndirect && cRLEntry.hasExtensions() && (extension = cRLEntry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
                x500Name = X500Name.getInstance(GeneralNames.getInstance(extension.getParsedValue()).getNames()[0].m14690getName());
            }
        }
        return null;
    }

    @Override // java.security.cert.X509CRL
    public Set getRevokedCertificates() {
        Set setLoadCRLEntries = loadCRLEntries();
        if (setLoadCRLEntries.isEmpty()) {
            return null;
        }
        return Collections.unmodifiableSet(setLoadCRLEntries);
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgName() {
        return this.sigAlgName;
    }

    @Override // java.security.cert.X509CRL
    public String getSigAlgOID() {
        return this.f21652c.getSignatureAlgorithm().getAlgorithm().m14433getId();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSigAlgParams() {
        return C6238Arrays.m18231clone(this.sigAlgParams);
    }

    @Override // java.security.cert.X509CRL
    public byte[] getSignature() {
        return this.f21652c.getSignature().getOctets();
    }

    @Override // java.security.cert.X509CRL
    public byte[] getTBSCertList() throws CRLException {
        try {
            return this.f21652c.getTBSCertList().getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    @Override // java.security.cert.X509CRL
    public Date getThisUpdate() {
        return this.f21652c.getThisUpdate().m14707getDate();
    }

    @Override // java.security.cert.X509CRL
    public int getVersion() {
        return this.f21652c.getVersionNumber();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Extensions extensions;
        if (getVersion() != 2 || (extensions = this.f21652c.getExtensions()) == null) {
            return false;
        }
        Enumeration enumerationM14687oids = extensions.m14687oids();
        while (enumerationM14687oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) enumerationM14687oids.nextElement();
            if (!Extension.issuingDistributionPoint.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.deltaCRLIndicator.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.cert.CRL
    public boolean isRevoked(Certificate certificate) {
        X500Name issuer;
        Extension extension;
        if (!certificate.getType().equals("X.509")) {
            throw new IllegalArgumentException("X.509 CRL used with non X.509 Cert");
        }
        Enumeration revokedCertificateEnumeration = this.f21652c.getRevokedCertificateEnumeration();
        X500Name issuer2 = this.f21652c.getIssuer();
        if (revokedCertificateEnumeration.hasMoreElements()) {
            X509Certificate x509Certificate = (X509Certificate) certificate;
            BigInteger serialNumber = x509Certificate.getSerialNumber();
            while (revokedCertificateEnumeration.hasMoreElements()) {
                TBSCertList.CRLEntry cRLEntry = TBSCertList.CRLEntry.getInstance(revokedCertificateEnumeration.nextElement());
                if (this.isIndirect && cRLEntry.hasExtensions() && (extension = cRLEntry.getExtensions().getExtension(Extension.certificateIssuer)) != null) {
                    issuer2 = X500Name.getInstance(GeneralNames.getInstance(extension.getParsedValue()).getNames()[0].m14690getName());
                }
                if (cRLEntry.getUserCertificate().hasValue(serialNumber)) {
                    if (certificate instanceof X509Certificate) {
                        issuer = X500Name.getInstance(x509Certificate.getIssuerX500Principal().getEncoded());
                    } else {
                        try {
                            issuer = org.bouncycastle.p133asn1.p174x509.Certificate.getInstance(certificate.getEncoded()).getIssuer();
                        } catch (CertificateEncodingException e) {
                            throw new IllegalArgumentException("Cannot process certificate: " + e.getMessage());
                        }
                    }
                    return issuer2.mo14431equals(issuer);
                }
            }
        }
        return false;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxRuntimeException: Can't find top splitter block for handler:B:34:0x013f
        	at jadx.core.utils.BlockUtils.getTopSplitterForHandler(BlockUtils.java:1178)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.collectHandlerRegions(ExcHandlersRegionMaker.java:53)
        	at jadx.core.dex.visitors.regions.maker.ExcHandlersRegionMaker.process(ExcHandlersRegionMaker.java:38)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:27)
        */
    /* JADX WARN: Removed duplicated region for block: B:11:0x007d  */
    @Override // java.security.cert.CRL
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public java.lang.String toString() {
        /*
            Method dump skipped, instructions count: 365
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.p249jcajce.provider.asymmetric.p265x509.X509CRLImpl.toString():java.lang.String");
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CRLException, InvalidAlgorithmParameterException {
        doVerify(publicKey, new SignatureCreator() { // from class: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLImpl.1
            @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p265x509.SignatureCreator
            public Signature createSignature(String str) {
                try {
                    return X509CRLImpl.this.bcHelper.createSignature(str);
                } catch (Exception unused) {
                    return Signature.getInstance(str);
                }
            }
        });
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey, final String str) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CRLException, InvalidAlgorithmParameterException {
        doVerify(publicKey, new SignatureCreator(this) { // from class: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLImpl.2

            /* renamed from: this$0 */
            final /* synthetic */ X509CRLImpl f21654this$0;

            {
                this.f21654this$0 = this;
            }

            @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p265x509.SignatureCreator
            public Signature createSignature(String str2) {
                String str3 = str;
                return str3 != null ? Signature.getInstance(str2, str3) : Signature.getInstance(str2);
            }
        });
    }

    @Override // java.security.cert.X509CRL
    public void verify(PublicKey publicKey, final Provider provider) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CRLException, InvalidAlgorithmParameterException {
        try {
            doVerify(publicKey, new SignatureCreator(this) { // from class: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CRLImpl.3

                /* renamed from: this$0 */
                final /* synthetic */ X509CRLImpl f21655this$0;

                {
                    this.f21655this$0 = this;
                }

                @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p265x509.SignatureCreator
                public Signature createSignature(String str) {
                    return provider != null ? Signature.getInstance(this.f21655this$0.getSigAlgName(), provider) : Signature.getInstance(this.f21655this$0.getSigAlgName());
                }
            });
        } catch (NoSuchProviderException e) {
            throw new NoSuchAlgorithmException("provider issue: " + e.getMessage());
        }
    }
}
