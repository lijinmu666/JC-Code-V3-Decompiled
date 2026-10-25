package org.bouncycastle.p366x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.C5190Holder;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.IssuerSerial;
import org.bouncycastle.p133asn1.p174x509.ObjectDigestInfo;
import org.bouncycastle.p281jce.PrincipalUtil;
import org.bouncycastle.p281jce.X509Principal;
import org.bouncycastle.p281jce.provider.BouncyCastleProvider;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class AttributeCertificateHolder implements CertSelector, Selector {

    /* renamed from: holder */
    final C5190Holder f24277holder;

    public AttributeCertificateHolder(int i, String str, String str2, byte[] bArr) {
        this.f24277holder = new C5190Holder(new ObjectDigestInfo(i, new ASN1ObjectIdentifier(str2), new AlgorithmIdentifier(new ASN1ObjectIdentifier(str)), C6238Arrays.m18231clone(bArr)));
    }

    private GeneralNames generateGeneralNames(X509Principal x509Principal) {
        return GeneralNames.getInstance(new DERSequence(new GeneralName(x509Principal)));
    }

    private Object[] getNames(GeneralName[] generalNameArr) {
        ArrayList arrayList = new ArrayList(generalNameArr.length);
        for (int i = 0; i != generalNameArr.length; i++) {
            if (generalNameArr[i].getTagNo() == 4) {
                try {
                    arrayList.add(new X500Principal(generalNameArr[i].m14690getName().toASN1Primitive().getEncoded()));
                } catch (IOException unused) {
                    throw new RuntimeException("badly formed Name object");
                }
            }
        }
        return arrayList.toArray(new Object[arrayList.size()]);
    }

    private Principal[] getPrincipals(GeneralNames generalNames) {
        Object[] names = getNames(generalNames.getNames());
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i != names.length; i++) {
            Object obj = names[i];
            if (obj instanceof Principal) {
                arrayList.add(obj);
            }
        }
        return (Principal[]) arrayList.toArray(new Principal[arrayList.size()]);
    }

    private boolean matchesDN(X509Principal x509Principal, GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i = 0; i != names.length; i++) {
            GeneralName generalName = names[i];
            if (generalName.getTagNo() == 4) {
                try {
                    if (new X509Principal(generalName.m14690getName().toASN1Primitive().getEncoded()).mo14431equals(x509Principal)) {
                        return true;
                    }
                } catch (IOException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    @Override // java.security.cert.CertSelector, org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new AttributeCertificateHolder((ASN1Sequence) this.f24277holder.toASN1Primitive());
    }

    /* renamed from: equals */
    public boolean m18386equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeCertificateHolder) {
            return this.f24277holder.mo14431equals(((AttributeCertificateHolder) obj).f24277holder);
        }
        return false;
    }

    public String getDigestAlgorithm() {
        if (this.f24277holder.getObjectDigestInfo() != null) {
            return this.f24277holder.getObjectDigestInfo().getDigestAlgorithm().getAlgorithm().m14433getId();
        }
        return null;
    }

    public int getDigestedObjectType() {
        if (this.f24277holder.getObjectDigestInfo() != null) {
            return this.f24277holder.getObjectDigestInfo().getDigestedObjectType().intValueExact();
        }
        return -1;
    }

    public Principal[] getEntityNames() {
        if (this.f24277holder.getEntityName() != null) {
            return getPrincipals(this.f24277holder.getEntityName());
        }
        return null;
    }

    public Principal[] getIssuer() {
        if (this.f24277holder.getBaseCertificateID() != null) {
            return getPrincipals(this.f24277holder.getBaseCertificateID().getIssuer());
        }
        return null;
    }

    public byte[] getObjectDigest() {
        if (this.f24277holder.getObjectDigestInfo() != null) {
            return this.f24277holder.getObjectDigestInfo().getObjectDigest().getBytes();
        }
        return null;
    }

    public String getOtherObjectTypeID() {
        if (this.f24277holder.getObjectDigestInfo() == null) {
            return null;
        }
        this.f24277holder.getObjectDigestInfo().getOtherObjectTypeID().m14433getId();
        return null;
    }

    public BigInteger getSerialNumber() {
        if (this.f24277holder.getBaseCertificateID() != null) {
            return this.f24277holder.getBaseCertificateID().getSerial().getValue();
        }
        return null;
    }

    public int hashCode() {
        return this.f24277holder.hashCode();
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) {
        if (obj instanceof X509Certificate) {
            return match((Certificate) obj);
        }
        return false;
    }

    public AttributeCertificateHolder(X509Certificate x509Certificate) throws CertificateParsingException {
        try {
            this.f24277holder = new C5190Holder(new IssuerSerial(generateGeneralNames(PrincipalUtil.getIssuerX509Principal(x509Certificate)), new ASN1Integer(x509Certificate.getSerialNumber())));
        } catch (Exception e) {
            throw new CertificateParsingException(e.getMessage());
        }
    }

    @Override // java.security.cert.CertSelector
    public boolean match(Certificate certificate) throws NoSuchAlgorithmException, NoSuchProviderException {
        if (!(certificate instanceof X509Certificate)) {
            return false;
        }
        X509Certificate x509Certificate = (X509Certificate) certificate;
        if (this.f24277holder.getBaseCertificateID() != null) {
            return this.f24277holder.getBaseCertificateID().getSerial().hasValue(x509Certificate.getSerialNumber()) && matchesDN(PrincipalUtil.getIssuerX509Principal(x509Certificate), this.f24277holder.getBaseCertificateID().getIssuer());
        }
        if (this.f24277holder.getEntityName() != null && matchesDN(PrincipalUtil.getSubjectX509Principal(x509Certificate), this.f24277holder.getEntityName())) {
            return true;
        }
        if (this.f24277holder.getObjectDigestInfo() != null) {
            MessageDigest messageDigest = MessageDigest.getInstance(getDigestAlgorithm(), BouncyCastleProvider.PROVIDER_NAME);
            int digestedObjectType = getDigestedObjectType();
            if (digestedObjectType == 0) {
                messageDigest.update(certificate.getPublicKey().getEncoded());
            } else if (digestedObjectType == 1) {
                messageDigest.update(certificate.getEncoded());
            }
            C6238Arrays.areEqual(messageDigest.digest(), getObjectDigest());
        }
        return false;
    }

    public AttributeCertificateHolder(X500Principal x500Principal) {
        this(X509Util.convertPrincipal(x500Principal));
    }

    public AttributeCertificateHolder(X500Principal x500Principal, BigInteger bigInteger) {
        this(X509Util.convertPrincipal(x500Principal), bigInteger);
    }

    public AttributeCertificateHolder(ASN1Sequence aSN1Sequence) {
        this.f24277holder = C5190Holder.getInstance(aSN1Sequence);
    }

    public AttributeCertificateHolder(X509Principal x509Principal) {
        this.f24277holder = new C5190Holder(generateGeneralNames(x509Principal));
    }

    public AttributeCertificateHolder(X509Principal x509Principal, BigInteger bigInteger) {
        this.f24277holder = new C5190Holder(new IssuerSerial(GeneralNames.getInstance(new DERSequence(new GeneralName(x509Principal))), new ASN1Integer(bigInteger)));
    }
}
