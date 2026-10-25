package org.bouncycastle.p281jce.provider;

import java.io.IOException;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.Provider;
import java.security.PublicKey;
import java.security.Security;
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
import org.bouncycastle.p133asn1.C5103DERNull;
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
import org.bouncycastle.p249jcajce.provider.asymmetric.p264util.PKCS12BagAttributeCarrierImpl;
import org.bouncycastle.p281jce.X509Principal;
import org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.Integers;
import org.bouncycastle.p361util.encoders.C6255Hex;

/* loaded from: classes2.dex */
public class X509CertificateObject extends X509Certificate implements PKCS12BagAttributeCarrier {
    private PKCS12BagAttributeCarrier attrCarrier = new PKCS12BagAttributeCarrierImpl();
    private BasicConstraints basicConstraints;

    /* renamed from: c */
    private Certificate f22044c;
    private int hashValue;
    private boolean hashValueSet;
    private boolean[] keyUsage;

    public X509CertificateObject(Certificate certificate) throws CertificateParsingException {
        this.f22044c = certificate;
        try {
            byte[] extensionOctets = getExtensionOctets(certificate, Extension.basicConstraints);
            if (extensionOctets != null) {
                this.basicConstraints = BasicConstraints.getInstance(ASN1Primitive.fromByteArray(extensionOctets));
            }
            try {
                byte[] extensionOctets2 = getExtensionOctets(certificate, Extension.keyUsage);
                if (extensionOctets2 == null) {
                    this.keyUsage = null;
                    return;
                }
                ASN1BitString aSN1BitString = ASN1BitString.getInstance(ASN1Primitive.fromByteArray(extensionOctets2));
                byte[] bytes = aSN1BitString.getBytes();
                int length = (bytes.length * 8) - aSN1BitString.getPadBits();
                int i = 9;
                if (length >= 9) {
                    i = length;
                }
                this.keyUsage = new boolean[i];
                for (int i2 = 0; i2 != length; i2++) {
                    this.keyUsage[i2] = (bytes[i2 / 8] & (128 >>> (i2 % 8))) != 0;
                }
            } catch (Exception e) {
                throw new CertificateParsingException("cannot construct KeyUsage: " + e);
            }
        } catch (Exception e2) {
            throw new CertificateParsingException("cannot construct BasicConstraints: " + e2);
        }
    }

    private int calculateHashCode() {
        try {
            byte[] encoded = getEncoded();
            int i = 0;
            for (int i2 = 1; i2 < encoded.length; i2++) {
                i += encoded[i2] * i2;
            }
            return i;
        } catch (CertificateEncodingException unused) {
            return 0;
        }
    }

    private void checkSignature(PublicKey publicKey, Signature signature) throws SignatureException, InvalidKeyException, CertificateException {
        if (!isAlgIdEqual(this.f22044c.getSignatureAlgorithm(), this.f22044c.getTBSCertificate().getSignature())) {
            throw new CertificateException("signature algorithm in TBS cert not same as outer cert");
        }
        X509SignatureUtil.setSignatureParameters(signature, this.f22044c.getSignatureAlgorithm().getParameters());
        signature.initVerify(publicKey);
        signature.update(getTBSCertificate());
        if (!signature.verify(getSignature())) {
            throw new SignatureException("certificate does not verify with supplied key");
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

    private static byte[] getExtensionOctets(Certificate certificate, ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        ASN1OctetString extensionValue = Extensions.getExtensionValue(certificate.getExtensions(), aSN1ObjectIdentifier);
        if (extensionValue == null) {
            return null;
        }
        return extensionValue.getOctets();
    }

    private boolean isAlgIdEqual(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2) {
        if (algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) algorithmIdentifier2.getAlgorithm())) {
            return algorithmIdentifier.getParameters() == null ? algorithmIdentifier2.getParameters() == null || algorithmIdentifier2.getParameters().equals(C5103DERNull.INSTANCE) : algorithmIdentifier2.getParameters() == null ? algorithmIdentifier.getParameters() == null || algorithmIdentifier.getParameters().equals(C5103DERNull.INSTANCE) : algorithmIdentifier.getParameters().equals(algorithmIdentifier2.getParameters());
        }
        return false;
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity() throws CertificateNotYetValidException, CertificateExpiredException {
        checkValidity(new Date());
    }

    @Override // java.security.cert.Certificate
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof java.security.cert.Certificate)) {
            return false;
        }
        try {
            return C6238Arrays.areEqual(getEncoded(), ((java.security.cert.Certificate) obj).getEncoded());
        } catch (CertificateEncodingException unused) {
            return false;
        }
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public ASN1Encodable getBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return this.attrCarrier.getBagAttribute(aSN1ObjectIdentifier);
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public Enumeration getBagAttributeKeys() {
        return this.attrCarrier.getBagAttributeKeys();
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
        Extensions extensions = this.f22044c.getExtensions();
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

    @Override // java.security.cert.Certificate
    public byte[] getEncoded() throws CertificateEncodingException {
        try {
            return this.f22044c.getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public List getExtendedKeyUsage() throws CertificateParsingException {
        byte[] extensionOctets = getExtensionOctets(this.f22044c, Extension.extendedKeyUsage);
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
        return X509SignatureUtil.getExtensionValue(this.f22044c.getExtensions(), str);
    }

    @Override // java.security.cert.X509Certificate
    public Collection getIssuerAlternativeNames() {
        return getAlternativeNames(this.f22044c, Extension.issuerAlternativeName);
    }

    @Override // java.security.cert.X509Certificate
    public Principal getIssuerDN() {
        return new X509Principal(this.f22044c.getIssuer());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getIssuerUniqueID() {
        ASN1BitString issuerUniqueId = this.f22044c.getTBSCertificate().getIssuerUniqueId();
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

    @Override // java.security.cert.X509Certificate
    public X500Principal getIssuerX500Principal() {
        try {
            return new X500Principal(this.f22044c.getIssuer().getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getKeyUsage() {
        return this.keyUsage;
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        if (getVersion() != 3) {
            return null;
        }
        HashSet hashSet = new HashSet();
        Extensions extensions = this.f22044c.getExtensions();
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
        return this.f22044c.getEndDate().m14707getDate();
    }

    @Override // java.security.cert.X509Certificate
    public Date getNotBefore() {
        return this.f22044c.getStartDate().m14707getDate();
    }

    @Override // java.security.cert.Certificate
    public PublicKey getPublicKey() {
        try {
            return BouncyCastleProvider.getPublicKey(this.f22044c.getSubjectPublicKeyInfo());
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.cert.X509Certificate
    public BigInteger getSerialNumber() {
        return this.f22044c.getSerialNumber().getValue();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgName() {
        Provider provider = Security.getProvider(BouncyCastleProvider.PROVIDER_NAME);
        if (provider != null) {
            String property = provider.getProperty("Alg.Alias.Signature." + getSigAlgOID());
            if (property != null) {
                return property;
            }
        }
        Provider[] providers = Security.getProviders();
        for (int i = 0; i != providers.length; i++) {
            String property2 = providers[i].getProperty("Alg.Alias.Signature." + getSigAlgOID());
            if (property2 != null) {
                return property2;
            }
        }
        return getSigAlgOID();
    }

    @Override // java.security.cert.X509Certificate
    public String getSigAlgOID() {
        return this.f22044c.getSignatureAlgorithm().getAlgorithm().m14433getId();
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSigAlgParams() {
        if (this.f22044c.getSignatureAlgorithm().getParameters() != null) {
            try {
                return this.f22044c.getSignatureAlgorithm().getParameters().toASN1Primitive().getEncoded(ASN1Encoding.f17902DER);
            } catch (IOException unused) {
            }
        }
        return null;
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getSignature() {
        return this.f22044c.getSignature().getOctets();
    }

    @Override // java.security.cert.X509Certificate
    public Collection getSubjectAlternativeNames() {
        return getAlternativeNames(this.f22044c, Extension.subjectAlternativeName);
    }

    @Override // java.security.cert.X509Certificate
    public Principal getSubjectDN() {
        return new X509Principal(this.f22044c.getSubject());
    }

    @Override // java.security.cert.X509Certificate
    public boolean[] getSubjectUniqueID() {
        ASN1BitString subjectUniqueId = this.f22044c.getTBSCertificate().getSubjectUniqueId();
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

    @Override // java.security.cert.X509Certificate
    public X500Principal getSubjectX500Principal() {
        try {
            return new X500Principal(this.f22044c.getSubject().getEncoded());
        } catch (IOException unused) {
            throw new IllegalStateException("can't encode issuer DN");
        }
    }

    @Override // java.security.cert.X509Certificate
    public byte[] getTBSCertificate() throws CertificateEncodingException {
        try {
            return this.f22044c.getTBSCertificate().getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException e) {
            throw new CertificateEncodingException(e.toString());
        }
    }

    @Override // java.security.cert.X509Certificate
    public int getVersion() {
        return this.f22044c.getVersionNumber();
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public boolean hasFriendlyName() {
        return this.attrCarrier.hasFriendlyName();
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Extensions extensions;
        if (getVersion() != 3 || (extensions = this.f22044c.getExtensions()) == null) {
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
    public synchronized int hashCode() {
        try {
            if (!this.hashValueSet) {
                this.hashValue = calculateHashCode();
                this.hashValueSet = true;
            }
        } catch (Throwable th) {
            throw th;
        }
        return this.hashValue;
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public void setBagAttribute(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        this.attrCarrier.setBagAttribute(aSN1ObjectIdentifier, aSN1Encodable);
    }

    @Override // org.bouncycastle.p281jce.interfaces.PKCS12BagAttributeCarrier
    public void setFriendlyName(String str) {
        this.attrCarrier.setFriendlyName(str);
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
        byte[] signature = getSignature();
        sb.append("            Signature: ");
        sb.append(new String(C6255Hex.m18344encode(signature, 0, 20)));
        sb.append(strLineSeparator);
        int i = 20;
        while (i < signature.length) {
            int length = signature.length - 20;
            sb.append("                       ");
            sb.append(i < length ? new String(C6255Hex.m18344encode(signature, i, 20)) : new String(C6255Hex.m18344encode(signature, i, signature.length - i)));
            sb.append(strLineSeparator);
            i += 20;
        }
        Extensions extensions = this.f22044c.getExtensions();
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
                        verisignCzagExtension = new NetscapeCertType((ASN1BitString) aSN1InputStream.readObject());
                    } else if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) MiscObjectIdentifiers.netscapeRevocationURL)) {
                        verisignCzagExtension = new NetscapeRevocationURL((ASN1IA5String) aSN1InputStream.readObject());
                    } else if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) MiscObjectIdentifiers.verisignCzagExtension)) {
                        verisignCzagExtension = new VerisignCzagExtension((ASN1IA5String) aSN1InputStream.readObject());
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
    public final void verify(PublicKey publicKey) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException, CertificateException, NoSuchProviderException {
        Signature signature;
        String signatureName = X509SignatureUtil.getSignatureName(this.f22044c.getSignatureAlgorithm());
        try {
            signature = Signature.getInstance(signatureName, BouncyCastleProvider.PROVIDER_NAME);
        } catch (Exception unused) {
            signature = Signature.getInstance(signatureName);
        }
        checkSignature(publicKey, signature);
    }

    @Override // java.security.cert.X509Certificate
    public void checkValidity(Date date) throws CertificateNotYetValidException, CertificateExpiredException {
        if (date.getTime() > getNotAfter().getTime()) {
            throw new CertificateExpiredException("certificate expired on " + this.f22044c.getEndDate().m14708getTime());
        }
        if (date.getTime() >= getNotBefore().getTime()) {
            return;
        }
        throw new CertificateNotYetValidException("certificate not valid till " + this.f22044c.getStartDate().m14708getTime());
    }

    @Override // java.security.cert.Certificate
    public final void verify(PublicKey publicKey, String str) throws SignatureException, InvalidKeyException, CertificateException {
        String signatureName = X509SignatureUtil.getSignatureName(this.f22044c.getSignatureAlgorithm());
        checkSignature(publicKey, str != null ? Signature.getInstance(signatureName, str) : Signature.getInstance(signatureName));
    }

    @Override // java.security.cert.X509Certificate, java.security.cert.Certificate
    public final void verify(PublicKey publicKey, Provider provider) throws SignatureException, InvalidKeyException, CertificateException {
        String signatureName = X509SignatureUtil.getSignatureName(this.f22044c.getSignatureAlgorithm());
        checkSignature(publicKey, provider != null ? Signature.getInstance(signatureName, provider) : Signature.getInstance(signatureName));
    }
}
