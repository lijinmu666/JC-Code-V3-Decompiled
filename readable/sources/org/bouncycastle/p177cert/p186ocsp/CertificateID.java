package org.bouncycastle.p177cert.p186ocsp;

import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.operator.DigestCalculatorProvider;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p164ocsp.C5131CertID;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.X509CertificateHolder;

/* loaded from: classes2.dex */
public class CertificateID {
    public static final AlgorithmIdentifier HASH_SHA1 = new AlgorithmIdentifier(OIWObjectIdentifiers.f18459idSHA1, C5103DERNull.INSTANCE);

    /* renamed from: id */
    private final C5131CertID f18887id;

    public CertificateID(C5131CertID c5131CertID) {
        if (c5131CertID == null) {
            throw new IllegalArgumentException("'id' cannot be null");
        }
        this.f18887id = c5131CertID;
    }

    private static C5131CertID createCertID(DigestCalculator digestCalculator, X509CertificateHolder x509CertificateHolder, ASN1Integer aSN1Integer) throws IOException, OCSPException {
        try {
            OutputStream outputStream = digestCalculator.getOutputStream();
            outputStream.write(x509CertificateHolder.toASN1Structure().getSubject().getEncoded(ASN1Encoding.f17902DER));
            outputStream.close();
            DEROctetString dEROctetString = new DEROctetString(digestCalculator.getDigest());
            SubjectPublicKeyInfo subjectPublicKeyInfo = x509CertificateHolder.getSubjectPublicKeyInfo();
            OutputStream outputStream2 = digestCalculator.getOutputStream();
            outputStream2.write(subjectPublicKeyInfo.getPublicKeyData().getBytes());
            outputStream2.close();
            return new C5131CertID(digestCalculator.getAlgorithmIdentifier(), dEROctetString, new DEROctetString(digestCalculator.getDigest()), aSN1Integer);
        } catch (Exception e) {
            throw new OCSPException("problem creating ID: " + e, e);
        }
    }

    public static CertificateID deriveCertificateID(CertificateID certificateID, BigInteger bigInteger) {
        return new CertificateID(new C5131CertID(certificateID.f18887id.getHashAlgorithm(), certificateID.f18887id.getIssuerNameHash(), certificateID.f18887id.getIssuerKeyHash(), new ASN1Integer(bigInteger)));
    }

    /* renamed from: equals */
    public boolean m14816equals(Object obj) {
        if (obj instanceof CertificateID) {
            return this.f18887id.toASN1Primitive().m14446equals(((CertificateID) obj).f18887id.toASN1Primitive());
        }
        return false;
    }

    public ASN1ObjectIdentifier getHashAlgOID() {
        return this.f18887id.getHashAlgorithm().getAlgorithm();
    }

    public byte[] getIssuerKeyHash() {
        return this.f18887id.getIssuerKeyHash().getOctets();
    }

    public byte[] getIssuerNameHash() {
        return this.f18887id.getIssuerNameHash().getOctets();
    }

    public BigInteger getSerialNumber() {
        return this.f18887id.getSerialNumber().getValue();
    }

    public int hashCode() {
        return this.f18887id.toASN1Primitive().hashCode();
    }

    public boolean matchesIssuer(X509CertificateHolder x509CertificateHolder, DigestCalculatorProvider digestCalculatorProvider) throws OCSPException {
        try {
            return createCertID(digestCalculatorProvider.mo14763get(this.f18887id.getHashAlgorithm()), x509CertificateHolder, this.f18887id.getSerialNumber()).mo14431equals(this.f18887id);
        } catch (OperatorCreationException e) {
            throw new OCSPException("unable to create digest calculator: " + e.getMessage(), e);
        }
    }

    public C5131CertID toASN1Primitive() {
        return this.f18887id;
    }

    public CertificateID(DigestCalculator digestCalculator, X509CertificateHolder x509CertificateHolder, BigInteger bigInteger) {
        this.f18887id = createCertID(digestCalculator, x509CertificateHolder, new ASN1Integer(bigInteger));
    }
}
