package org.bouncycastle.p249jcajce.provider.asymmetric.p265x509;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateExpiredException;
import java.security.cert.CertificateNotYetValidException;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p242misc.NetscapeCertType;
import org.bouncycastle.internal.p231asn1.p242misc.NetscapeRevocationURL;
import org.bouncycastle.internal.p231asn1.p242misc.VerisignCzagExtension;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1IA5String;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1String;
import org.bouncycastle.p133asn1.p171util.ASN1Dump;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.p173style.RFC4519Style;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.BasicConstraints;
import org.bouncycastle.p133asn1.p174x509.Certificate;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.KeyUsage;
import org.bouncycastle.p133asn1.p174x509.TBSCertificate;
import org.bouncycastle.p249jcajce.CompositePublicKey;
import org.bouncycastle.p249jcajce.interfaces.BCX509Certificate;
import org.bouncycastle.p249jcajce.p250io.OutputStreamFactory;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p281jce.X509Principal;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Exceptions;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
abstract class X509CertificateImpl extends X509Certificate implements BCX509Certificate {
    protected BasicConstraints basicConstraints;
    protected JcaJceHelper bcHelper;

    /* renamed from: c */
    protected Certificate f21657c;
    protected boolean[] keyUsage;
    protected String sigAlgName;
    protected byte[] sigAlgParams;

    public X509CertificateImpl(JcaJceHelper jcaJceHelper, Certificate certificate, BasicConstraints basicConstraints, boolean[] zArr, String str, byte[] bArr) {
        this.bcHelper = jcaJceHelper;
        this.f21657c = certificate;
        this.basicConstraints = basicConstraints;
        this.keyUsage = zArr;
        this.sigAlgName = str;
        this.sigAlgParams = bArr;
    }

    private void checkSignature(PublicKey publicKey, Signature signature, ASN1Encodable aSN1Encodable, byte[] bArr) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CertificateException, InvalidAlgorithmParameterException {
        if (!X509SignatureUtil.areEquivalentAlgorithms(this.f21657c.getSignatureAlgorithm(), this.f21657c.getTBSCertificate().getSignature())) {
            throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
        }
        X509SignatureUtil.setSignatureParameters(signature, aSN1Encodable);
        signature.initVerify(publicKey);
        try {
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(OutputStreamFactory.createStream(signature), 512);
            this.f21657c.getTBSCertificate().encodeTo(bufferedOutputStream, ASN1Encoding.f17902DER);
            bufferedOutputStream.close();
            if (!signature.verify(bArr)) {
                throw new SignatureException("certificate does not verify with supplied key");
            }
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    private void doVerify(PublicKey publicKey, SignatureCreator signatureCreator) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CertificateException, InvalidAlgorithmParameterException {
        boolean z = publicKey instanceof CompositePublicKey;
        int i = 0;
        if (z && X509SignatureUtil.isCompositeAlgorithm(this.f21657c.getSignatureAlgorithm())) {
            List<PublicKey> publicKeys = ((CompositePublicKey) publicKey).getPublicKeys();
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(this.f21657c.getSignatureAlgorithm().getParameters());
            ASN1Sequence aSN1Sequence2 = ASN1Sequence.getInstance(this.f21657c.getSignature().getOctets());
            boolean z2 = false;
            while (i != publicKeys.size()) {
                if (publicKeys.get(i) != null) {
                    AlgorithmIdentifier algorithmIdentifier = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i));
                    try {
                        checkSignature(publicKeys.get(i), signatureCreator.createSignature(X509SignatureUtil.getSignatureName(algorithmIdentifier)), algorithmIdentifier.getParameters(), ASN1BitString.getInstance(aSN1Sequence2.getObjectAt(i)).getOctets());
                        e = null;
                        z2 = true;
                    } catch (SignatureException e) {
                        e = e;
                    }
                    if (e != null) {
                        throw e;
                    }
                }
                i++;
            }
            if (!z2) {
                throw new InvalidKeyException("no matching key found");
            }
            return;
        }
        if (!X509SignatureUtil.isCompositeAlgorithm(this.f21657c.getSignatureAlgorithm())) {
            Signature signatureCreateSignature = signatureCreator.createSignature(getSigAlgName());
            if (z) {
                CompositePublicKey compositePublicKey = (CompositePublicKey) publicKey;
                if (MiscObjectIdentifiers.id_composite_key.m14446equals((ASN1Primitive) compositePublicKey.getAlgorithmIdentifier().getAlgorithm())) {
                    List<PublicKey> publicKeys2 = compositePublicKey.getPublicKeys();
                    while (i != publicKeys2.size()) {
                        try {
                            checkSignature(publicKeys2.get(i), signatureCreateSignature, this.f21657c.getSignatureAlgorithm().getParameters(), getSignature());
                            return;
                        } catch (InvalidKeyException unused) {
                            i++;
                        }
                    }
                    throw new InvalidKeyException("no matching signature found");
                }
            }
            checkSignature(publicKey, signatureCreateSignature, this.f21657c.getSignatureAlgorithm().getParameters(), getSignature());
            return;
        }
        ASN1Sequence aSN1Sequence3 = ASN1Sequence.getInstance(this.f21657c.getSignatureAlgorithm().getParameters());
        ASN1Sequence aSN1Sequence4 = ASN1Sequence.getInstance(this.f21657c.getSignature().getOctets());
        boolean z3 = false;
        while (i != aSN1Sequence4.mo14450size()) {
            AlgorithmIdentifier algorithmIdentifier2 = AlgorithmIdentifier.getInstance(aSN1Sequence3.getObjectAt(i));
            try {
                checkSignature(publicKey, signatureCreator.createSignature(X509SignatureUtil.getSignatureName(algorithmIdentifier2)), algorithmIdentifier2.getParameters(), ASN1BitString.getInstance(aSN1Sequence4.getObjectAt(i)).getOctets());
                e = null;
                z3 = true;
            } catch (InvalidKeyException | NoSuchAlgorithmException unused2) {
                e = null;
            } catch (SignatureException e2) {
                e = e2;
            }
            if (e != null) {
                throw e;
            }
            i++;
        }
        if (!z3) {
            throw new InvalidKeyException("no matching key found");
        }
    }

    private static Collection getAlternativeNames(Certificate certificate, ASN1ObjectIdentifier aSN1ObjectIdentifier) throws CertificateParsingException, IOException {
        String string;
        byte[] extensionOctets = getExtensionOctets(certificate, aSN1ObjectIdentifier);
        if (extensionOctets == null) {
            return null;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration objects = ASN1Sequence.getInstance(extensionOctets).getObjects();
            while (objects.hasMoreElements()) {
                GeneralName generalName = GeneralName.getInstance(objects.nextElement());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(Integers.m18296valueOf(generalName.getTagNo()));
                switch (generalName.getTagNo()) {
                    case 0:
                    case 3:
                    case 5:
                        arrayList2.add(generalName.getEncoded());
                        arrayList.add(Collections.unmodifiableList(arrayList2));
                    case 1:
                    case 2:
                    case 6:
                        string = ((ASN1String) generalName.m14690getName()).getString();
                        arrayList2.add(string);
                        arrayList.add(Collections.unmodifiableList(arrayList2));
                    case 4:
                        string = X500Name.getInstance(RFC4519Style.INSTANCE, generalName.m14690getName()).toString();
                        arrayList2.add(string);
                        arrayList.add(Collections.unmodifiableList(arrayList2));
                    case 7:
                        try {
                            string = InetAddress.getByAddress(ASN1OctetString.getInstance(generalName.m14690getName()).getOctets()).getHostAddress();
                            arrayList2.add(string);
                            arrayList.add(Collections.unmodifiableList(arrayList2));
                        } catch (UnknownHostException unused) {
                        }
                    case 8:
                        string = ASN1ObjectIdentifier.getInstance(generalName.m14690getName()).m14433getId();
                        arrayList2.add(string);
                        arrayList.add(Collections.unmodifiableList(arrayList2));
                    default:
                        throw new IOException("Bad tag number: " + generalName.getTagNo());
                }
            }
            if (arrayList.size() == 0) {
                return null;
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (Exception e) {
            throw new CertificateParsingException(e.getMessage());
        }
    }

    public static byte[] getExtensionOctets(Certificate certificate, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        ASN1OctetString extensionValue = Extensions.getExtensionValue(certificate.getExtensions(), aSN1ObjectIdentifier);
        if (extensionValue == null) {
            return null;
        }
        return extensionValue.getOctets();
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateNotYetValidException, CertificateExpiredException {
        checkValidity(new Date());
    }

    @Override // java.security.cert.X509Certificate
    public int getBasicConstraints() {
        BasicConstraints basicConstraints = this.basicConstraints;
        if (basicConstraints == null || !basicConstraints.m14675isCA()) {
            return -1;
        }
        ASN1Integer pathLenConstraintInteger = this.basicConstraints.getPathLenConstraintInteger();
        if (pathLenConstraintInteger == null) {
            return Integer.MAX_VALUE;
        }
        return pathLenConstraintInteger.intPositiveValueExact();
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Extensions extensions = this.f21657c.getExtensions();
        if (extensions == null) {
            return null;
        }
        Enumeration enumerationM14687oids = extensions.m14687oids();
        while (enumerationM14687oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) enumerationM14687oids.nextElement();
            if (extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                hashSet.add(aSN1ObjectIdentifier.m14433getId());
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.X509Certificate
    public List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] extensionOctets = getExtensionOctets(this.f21657c, Extension.extendedKeyUsage);
        if (extensionOctets == null) {
            return null;
        }
        try {
            ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(extensionOctets);
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i != aSN1Sequence.mo14450size(); i++) {
                arrayList.add(((ASN1ObjectIdentifier) aSN1Sequence.getObjectAt(i)).m14433getId());
            }
            return Collections.unmodifiableList(arrayList);
        } catch (Exception unused) {
            throw new CertificateParsingException("error processing extended key usage extension");
        }
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        return X509SignatureUtil.getExtensionValue(this.f21657c.getExtensions(), str);
    }

    @Override // java.security.cert.X509Certificate
    public Collection getIssuerAlternativeNames() {
        return getAlternativeNames(this.f21657c, Extension.issuerAlternativeName);
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return new X509Principal(this.f21657c.getIssuer());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        ASN1BitString issuerUniqueId = this.f21657c.getTBSCertificate().getIssuerUniqueId();
        if (issuerUniqueId == null) {
            return null;
        }
        byte[] bytes = issuerUniqueId.getBytes();
        int length = (bytes.length * 8) - issuerUniqueId.getPadBits();
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            zArr[i] = (bytes[i / 8] & (128 >>> (i % 8))) != 0;
        }
        return zArr;
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.BCX509Certificate
    public X500Name getIssuerX500Name() {
        return this.f21657c.getIssuer();
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.f21657c.getIssuer().getEncoded(ASN1Encoding.f17902DER));
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return C6238Arrays.m18239clone(this.keyUsage);
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Extensions extensions = this.f21657c.getExtensions();
        if (extensions == null) {
            return null;
        }
        Enumeration enumerationM14687oids = extensions.m14687oids();
        while (enumerationM14687oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) enumerationM14687oids.nextElement();
            if (!extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                hashSet.add(aSN1ObjectIdentifier.m14433getId());
            }
        }
        return hashSet;
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotAfter() {
        return this.f21657c.getEndDate().m14707getDate();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.f21657c.getStartDate().m14707getDate();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        try {
            return BouncyCastleProvider.getPublicKey(this.f21657c.getSubjectPublicKeyInfo());
        } catch (IOException e) {
            throw Exceptions.illegalStateException("failed to recover public key: " + e.getMessage(), e);
        }
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.f21657c.getSerialNumber().getValue();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        return this.sigAlgName;
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.f21657c.getSignatureAlgorithm().getAlgorithm().m14433getId();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        return C6238Arrays.m18231clone(this.sigAlgParams);
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.f21657c.getSignature().getOctets();
    }

    @Override // java.security.cert.X509Certificate
    public Collection getSubjectAlternativeNames() {
        return getAlternativeNames(this.f21657c, Extension.subjectAlternativeName);
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return new X509Principal(this.f21657c.getSubject());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        ASN1BitString subjectUniqueId = this.f21657c.getTBSCertificate().getSubjectUniqueId();
        if (subjectUniqueId == null) {
            return null;
        }
        byte[] bytes = subjectUniqueId.getBytes();
        int length = (bytes.length * 8) - subjectUniqueId.getPadBits();
        boolean[] zArr = new boolean[length];
        for (int i = 0; i != length; i++) {
            zArr[i] = (bytes[i / 8] & (128 >>> (i % 8))) != 0;
        }
        return zArr;
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.BCX509Certificate
    public X500Name getSubjectX500Name() {
        return this.f21657c.getSubject();
    }

    @Override // java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        try {
            return new X500Principal(this.f21657c.getSubject().getEncoded(ASN1Encoding.f17902DER));
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode subject DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        try {
            return this.f21657c.getTBSCertificate().getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    @Override // org.bouncycastle.p249jcajce.interfaces.BCX509Certificate
    public TBSCertificate getTBSCertificateNative() {
        return this.f21657c.getTBSCertificate();
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.f21657c.getVersionNumber();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Extensions extensions;
        if (getVersion() != 3 || (extensions = this.f21657c.getExtensions()) == null) {
            return false;
        }
        Enumeration enumerationM14687oids = extensions.m14687oids();
        while (enumerationM14687oids.hasMoreElements()) {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) enumerationM14687oids.nextElement();
            if (!Extension.keyUsage.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.certificatePolicies.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.policyMappings.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.inhibitAnyPolicy.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.cRLDistributionPoints.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.issuingDistributionPoint.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.deltaCRLIndicator.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.policyConstraints.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.basicConstraints.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.subjectAlternativeName.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && !Extension.nameConstraints.m14446equals((ASN1Primitive) aSN1ObjectIdentifier) && extensions.getExtension(aSN1ObjectIdentifier).isCritical()) {
                return true;
            }
        }
        return false;
    }

    @Override // java.security.cert.Certificate
    public String toString() {
        Object verisignCzagExtension;
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append("  [0]         Version: ");
        sb.append(getVersion());
        sb.append(strLineSeparator);
        sb.append("         SerialNumber: ");
        sb.append(getSerialNumber());
        sb.append(strLineSeparator);
        sb.append("             IssuerDN: ");
        sb.append(getIssuerDN());
        sb.append(strLineSeparator);
        sb.append("           Start Date: ");
        sb.append(getNotBefore());
        sb.append(strLineSeparator);
        sb.append("           Final Date: ");
        sb.append(getNotAfter());
        sb.append(strLineSeparator);
        sb.append("            SubjectDN: ");
        sb.append(getSubjectDN());
        sb.append(strLineSeparator);
        sb.append("           Public Key: ");
        sb.append(getPublicKey());
        sb.append(strLineSeparator);
        sb.append("  Signature Algorithm: ");
        sb.append(getSigAlgName());
        sb.append(strLineSeparator);
        X509SignatureUtil.prettyPrintSignature(getSignature(), sb, strLineSeparator);
        Extensions extensions = this.f21657c.getExtensions();
        if (extensions != null) {
            Enumeration enumerationM14687oids = extensions.m14687oids();
            if (enumerationM14687oids.hasMoreElements()) {
                sb.append("       Extensions: \n");
            }
            while (enumerationM14687oids.hasMoreElements()) {
                ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) enumerationM14687oids.nextElement();
                Extension extension = extensions.getExtension(aSN1ObjectIdentifier);
                if (extension.getExtnValue() != null) {
                    ASN1InputStream aSN1InputStream = new ASN1InputStream(extension.getExtnValue().getOctets());
                    sb.append("                       critical(");
                    sb.append(extension.isCritical());
                    sb.append(") ");
                    try {
                    } catch (Exception unused) {
                        sb.append(aSN1ObjectIdentifier.m14433getId());
                        sb.append(" value = ");
                        sb.append("*****");
                    }
                    if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) Extension.basicConstraints)) {
                        verisignCzagExtension = BasicConstraints.getInstance(aSN1InputStream.readObject());
                    } else if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) Extension.keyUsage)) {
                        verisignCzagExtension = KeyUsage.getInstance(aSN1InputStream.readObject());
                    } else if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) MiscObjectIdentifiers.netscapeCertType)) {
                        verisignCzagExtension = new NetscapeCertType(ASN1BitString.getInstance(aSN1InputStream.readObject()));
                    } else if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) MiscObjectIdentifiers.netscapeRevocationURL)) {
                        verisignCzagExtension = new NetscapeRevocationURL(ASN1IA5String.getInstance(aSN1InputStream.readObject()));
                    } else if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) MiscObjectIdentifiers.verisignCzagExtension)) {
                        verisignCzagExtension = new VerisignCzagExtension(ASN1IA5String.getInstance(aSN1InputStream.readObject()));
                    } else {
                        sb.append(aSN1ObjectIdentifier.m14433getId());
                        sb.append(" value = ");
                        sb.append(ASN1Dump.dumpAsString(aSN1InputStream.readObject()));
                        sb.append(strLineSeparator);
                    }
                    sb.append(verisignCzagExtension);
                    sb.append(strLineSeparator);
                }
                sb.append(strLineSeparator);
            }
        }
        return sb.toString();
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CertificateException, InvalidAlgorithmParameterException {
        doVerify(publicKey, new SignatureCreator() { // from class: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl.1
            @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p265x509.SignatureCreator
            public Signature createSignature(String str) {
                try {
                    return X509CertificateImpl.this.bcHelper.createSignature(str);
                } catch (Exception unused) {
                    return Signature.getInstance(str);
                }
            }
        });
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateNotYetValidException, CertificateExpiredException {
        if (date.getTime() > getNotAfter().getTime()) {
            throw new CertificateExpiredException("certificate expired on " + this.f21657c.getEndDate().m14708getTime());
        }
        if (date.getTime() >= getNotBefore().getTime()) {
            return;
        }
        throw new CertificateNotYetValidException("certificate not valid till " + this.f21657c.getStartDate().m14708getTime());
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey publicKey, final String str) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CertificateException, InvalidAlgorithmParameterException {
        doVerify(publicKey, new SignatureCreator(this) { // from class: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl.2

            /* renamed from: this$0 */
            final /* synthetic */ X509CertificateImpl f21659this$0;

            {
                this.f21659this$0 = this;
            }

            @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p265x509.SignatureCreator
            public Signature createSignature(String str2) {
                String str3 = str;
                return str3 != null ? Signature.getInstance(str2, str3) : Signature.getInstance(str2);
            }
        });
    }

    @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
    public final void verify(PublicKey publicKey, final Provider provider) throws NoSuchAlgorithmException, SignatureException, IOException, InvalidKeyException, CertificateException, InvalidAlgorithmParameterException {
        try {
            doVerify(publicKey, new SignatureCreator(this) { // from class: org.bouncycastle.jcajce.provider.asymmetric.x509.X509CertificateImpl.3

                /* renamed from: this$0 */
                final /* synthetic */ X509CertificateImpl f21660this$0;

                {
                    this.f21660this$0 = this;
                }

                @Override // org.bouncycastle.p249jcajce.provider.asymmetric.p265x509.SignatureCreator
                public Signature createSignature(String str) {
                    Provider provider2 = provider;
                    return provider2 != null ? Signature.getInstance(str, provider2) : Signature.getInstance(str);
                }
            });
        } catch (NoSuchProviderException e) {
            throw new NoSuchAlgorithmException("provider issue: " + e.getMessage());
        }
    }
}
