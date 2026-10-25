package org.bouncycastle.p249jcajce.provider.asymmetric.p265x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.cert.CRLException;
import java.security.cert.X509CRLEntry;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Enumerated;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p171util.ASN1Dump;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.CRLReason;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.Extensions;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.TBSCertList;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
class X509CRLEntryObject extends X509CRLEntry {

    /* renamed from: c */
    private TBSCertList.CRLEntry f21651c;
    private X500Name certificateIssuer;
    private volatile int hashValue;
    private volatile boolean hashValueSet;

    public X509CRLEntryObject(TBSCertList.CRLEntry cRLEntry) {
        this.f21651c = cRLEntry;
        this.certificateIssuer = null;
    }

    private Set getExtensionOIDs(boolean z) {
        Extensions extensions = this.f21651c.getExtensions();
        if (extensions == null) {
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

    private X500Name loadCertificateIssuer(boolean z, X500Name x500Name) {
        if (!z) {
            return null;
        }
        ASN1OctetString extensionValue = Extensions.getExtensionValue(this.f21651c.getExtensions(), Extension.certificateIssuer);
        if (extensionValue == null) {
            return x500Name;
        }
        try {
            GeneralName[] names = GeneralNames.getInstance(extensionValue.getOctets()).getNames();
            for (int i = 0; i < names.length; i++) {
                if (names[i].getTagNo() == 4) {
                    return X500Name.getInstance(names[i].m14690getName());
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    @Override // java.security.cert.X509CRLEntry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof X509CRLEntryObject)) {
            return super.equals(this);
        }
        X509CRLEntryObject x509CRLEntryObject = (X509CRLEntryObject) obj;
        if (this.hashValueSet && x509CRLEntryObject.hashValueSet && this.hashValue != x509CRLEntryObject.hashValue) {
            return false;
        }
        return this.f21651c.mo14431equals(x509CRLEntryObject.f21651c);
    }

    @Override // java.security.cert.X509CRLEntry
    public X500Principal getCertificateIssuer() {
        if (this.certificateIssuer == null) {
            return null;
        }
        try {
            return new X500Principal(this.certificateIssuer.getEncoded());
        } catch (IOException unused) {
            return null;
        }
    }

    @Override // java.security.cert.X509Extension
    public Set getCriticalExtensionOIDs() {
        return getExtensionOIDs(true);
    }

    @Override // java.security.cert.X509CRLEntry
    public byte[] getEncoded() throws CRLException {
        try {
            return this.f21651c.getEncoded(ASN1Encoding.f17902DER);
        } catch (IOException e) {
            throw new CRLException(e.toString());
        }
    }

    @Override // java.security.cert.X509Extension
    public byte[] getExtensionValue(String str) {
        return X509SignatureUtil.getExtensionValue(this.f21651c.getExtensions(), str);
    }

    @Override // java.security.cert.X509Extension
    public Set getNonCriticalExtensionOIDs() {
        return getExtensionOIDs(false);
    }

    @Override // java.security.cert.X509CRLEntry
    public Date getRevocationDate() {
        return this.f21651c.getRevocationDate().m14707getDate();
    }

    @Override // java.security.cert.X509CRLEntry
    public BigInteger getSerialNumber() {
        return this.f21651c.getUserCertificate().getValue();
    }

    @Override // java.security.cert.X509CRLEntry
    public boolean hasExtensions() {
        return this.f21651c.getExtensions() != null;
    }

    @Override // java.security.cert.X509Extension
    public boolean hasUnsupportedCriticalExtension() {
        Extensions extensions = this.f21651c.getExtensions();
        return extensions != null && extensions.hasAnyCriticalExtensions();
    }

    @Override // java.security.cert.X509CRLEntry
    public int hashCode() {
        if (!this.hashValueSet) {
            this.hashValue = super.hashCode();
            this.hashValueSet = true;
        }
        return this.hashValue;
    }

    @Override // java.security.cert.X509CRLEntry
    public String toString() {
        Object generalNames;
        StringBuilder sb = new StringBuilder();
        String strLineSeparator = C6250Strings.lineSeparator();
        sb.append("      userCertificate: ");
        sb.append(getSerialNumber());
        sb.append(strLineSeparator);
        sb.append("       revocationDate: ");
        sb.append(getRevocationDate());
        sb.append(strLineSeparator);
        sb.append("       certificateIssuer: ");
        sb.append(getCertificateIssuer());
        sb.append(strLineSeparator);
        Extensions extensions = this.f21651c.getExtensions();
        if (extensions != null) {
            Enumeration enumerationM14687oids = extensions.m14687oids();
            if (enumerationM14687oids.hasMoreElements()) {
                String str = "   crlEntryExtensions:";
                loop0: while (true) {
                    sb.append(str);
                    while (true) {
                        sb.append(strLineSeparator);
                        while (enumerationM14687oids.hasMoreElements()) {
                            ASN1ObjectIdentifier aSN1ObjectIdentifier = (ASN1ObjectIdentifier) enumerationM14687oids.nextElement();
                            Extension extension = extensions.getExtension(aSN1ObjectIdentifier);
                            if (extension.getExtnValue() != null) {
                                ASN1InputStream aSN1InputStream = new ASN1InputStream(extension.getExtnValue().getOctets());
                                sb.append("                       critical(");
                                sb.append(extension.isCritical());
                                sb.append(") ");
                                try {
                                    if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) Extension.reasonCode)) {
                                        generalNames = CRLReason.getInstance(ASN1Enumerated.getInstance(aSN1InputStream.readObject()));
                                    } else if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) Extension.certificateIssuer)) {
                                        sb.append("Certificate issuer: ");
                                        generalNames = GeneralNames.getInstance(aSN1InputStream.readObject());
                                    } else {
                                        sb.append(aSN1ObjectIdentifier.m14433getId());
                                        sb.append(" value = ");
                                        sb.append(ASN1Dump.dumpAsString(aSN1InputStream.readObject()));
                                        sb.append(strLineSeparator);
                                    }
                                    sb.append(generalNames);
                                    sb.append(strLineSeparator);
                                } catch (Exception unused) {
                                    sb.append(aSN1ObjectIdentifier.m14433getId());
                                    sb.append(" value = ");
                                    str = "*****";
                                }
                            }
                        }
                    }
                }
            }
        }
        return sb.toString();
    }

    public X509CRLEntryObject(TBSCertList.CRLEntry cRLEntry, boolean z, X500Name x500Name) {
        this.f21651c = cRLEntry;
        this.certificateIssuer = loadCertificateIssuer(z, x500Name);
    }
}
