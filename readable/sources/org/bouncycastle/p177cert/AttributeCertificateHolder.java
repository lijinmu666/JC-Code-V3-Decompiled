package org.bouncycastle.p177cert;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.util.ArrayList;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.C5190Holder;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.IssuerSerial;
import org.bouncycastle.p133asn1.p174x509.ObjectDigestInfo;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.Selector;

/* loaded from: classes2.dex */
public class AttributeCertificateHolder implements Selector {
    private static DigestCalculatorProvider digestCalculatorProvider;

    /* renamed from: holder */
    final C5190Holder f18795holder;

    public AttributeCertificateHolder(int i, ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1ObjectIdentifier aSN1ObjectIdentifier2, byte[] bArr) {
        this.f18795holder = new C5190Holder(new ObjectDigestInfo(i, aSN1ObjectIdentifier2, new AlgorithmIdentifier(aSN1ObjectIdentifier), C6238Arrays.m18231clone(bArr)));
    }

    private GeneralNames generateGeneralNames(X500Name x500Name) {
        return new GeneralNames(new GeneralName(x500Name));
    }

    private X500Name[] getPrincipals(GeneralName[] generalNameArr) {
        ArrayList arrayList = new ArrayList(generalNameArr.length);
        for (int i = 0; i != generalNameArr.length; i++) {
            if (generalNameArr[i].getTagNo() == 4) {
                arrayList.add(X500Name.getInstance(generalNameArr[i].m14690getName()));
            }
        }
        return (X500Name[]) arrayList.toArray(new X500Name[arrayList.size()]);
    }

    private boolean matchesDN(X500Name x500Name, GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i = 0; i != names.length; i++) {
            GeneralName generalName = names[i];
            if (generalName.getTagNo() == 4 && X500Name.getInstance(generalName.m14690getName()).mo14431equals(x500Name)) {
                return true;
            }
        }
        return false;
    }

    public static void setDigestCalculatorProvider(DigestCalculatorProvider digestCalculatorProvider2) {
        digestCalculatorProvider = digestCalculatorProvider2;
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: clone */
    public Object mo14740clone() {
        return new AttributeCertificateHolder((ASN1Sequence) this.f18795holder.toASN1Primitive());
    }

    /* renamed from: equals */
    public boolean m14741equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof AttributeCertificateHolder) {
            return this.f18795holder.mo14431equals(((AttributeCertificateHolder) obj).f18795holder);
        }
        return false;
    }

    public AlgorithmIdentifier getDigestAlgorithm() {
        if (this.f18795holder.getObjectDigestInfo() != null) {
            return this.f18795holder.getObjectDigestInfo().getDigestAlgorithm();
        }
        return null;
    }

    public int getDigestedObjectType() {
        if (this.f18795holder.getObjectDigestInfo() != null) {
            return this.f18795holder.getObjectDigestInfo().getDigestedObjectType().intValueExact();
        }
        return -1;
    }

    public X500Name[] getEntityNames() {
        if (this.f18795holder.getEntityName() != null) {
            return getPrincipals(this.f18795holder.getEntityName().getNames());
        }
        return null;
    }

    public X500Name[] getIssuer() {
        if (this.f18795holder.getBaseCertificateID() != null) {
            return getPrincipals(this.f18795holder.getBaseCertificateID().getIssuer().getNames());
        }
        return null;
    }

    public byte[] getObjectDigest() {
        if (this.f18795holder.getObjectDigestInfo() != null) {
            return this.f18795holder.getObjectDigestInfo().getObjectDigest().getBytes();
        }
        return null;
    }

    public ASN1ObjectIdentifier getOtherObjectTypeID() {
        if (this.f18795holder.getObjectDigestInfo() == null) {
            return null;
        }
        new ASN1ObjectIdentifier(this.f18795holder.getObjectDigestInfo().getOtherObjectTypeID().m14433getId());
        return null;
    }

    public BigInteger getSerialNumber() {
        if (this.f18795holder.getBaseCertificateID() != null) {
            return this.f18795holder.getBaseCertificateID().getSerial().getValue();
        }
        return null;
    }

    public int hashCode() {
        return this.f18795holder.hashCode();
    }

    @Override // org.bouncycastle.p361util.Selector
    /* renamed from: match */
    public boolean mo14742match(Object obj) throws IOException {
        if (!(obj instanceof X509CertificateHolder)) {
            return false;
        }
        X509CertificateHolder x509CertificateHolder = (X509CertificateHolder) obj;
        if (this.f18795holder.getBaseCertificateID() != null) {
            return this.f18795holder.getBaseCertificateID().getSerial().hasValue(x509CertificateHolder.getSerialNumber()) && matchesDN(x509CertificateHolder.getIssuer(), this.f18795holder.getBaseCertificateID().getIssuer());
        }
        if (this.f18795holder.getEntityName() != null && matchesDN(x509CertificateHolder.getSubject(), this.f18795holder.getEntityName())) {
            return true;
        }
        if (this.f18795holder.getObjectDigestInfo() != null) {
            try {
                DigestCalculator digestCalculatorMo14763get = digestCalculatorProvider.mo14763get(this.f18795holder.getObjectDigestInfo().getDigestAlgorithm());
                OutputStream outputStream = digestCalculatorMo14763get.getOutputStream();
                int digestedObjectType = getDigestedObjectType();
                if (digestedObjectType == 0) {
                    outputStream.write(x509CertificateHolder.getSubjectPublicKeyInfo().getEncoded());
                } else if (digestedObjectType == 1) {
                    outputStream.write(x509CertificateHolder.getEncoded());
                }
                outputStream.close();
                if (C6238Arrays.areEqual(digestCalculatorMo14763get.getDigest(), getObjectDigest())) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public AttributeCertificateHolder(ASN1Sequence aSN1Sequence) {
        this.f18795holder = C5190Holder.getInstance(aSN1Sequence);
    }

    public AttributeCertificateHolder(X500Name x500Name) {
        this.f18795holder = new C5190Holder(generateGeneralNames(x500Name));
    }

    public AttributeCertificateHolder(X500Name x500Name, BigInteger bigInteger) {
        this.f18795holder = new C5190Holder(new IssuerSerial(generateGeneralNames(x500Name), new ASN1Integer(bigInteger)));
    }

    public AttributeCertificateHolder(X509CertificateHolder x509CertificateHolder) {
        this.f18795holder = new C5190Holder(new IssuerSerial(generateGeneralNames(x509CertificateHolder.getIssuer()), new ASN1Integer(x509CertificateHolder.getSerialNumber())));
    }
}
