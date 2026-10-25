package org.bouncycastle.p177cert.p185jcajce;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.math.BigInteger;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.MessageDigest;
import java.security.PublicKey;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.operator.DigestCalculator;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.ASN1String;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p172x500.X500Name;
import org.bouncycastle.p133asn1.p172x500.p173style.RFC4519Style;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.AuthorityKeyIdentifier;
import org.bouncycastle.p133asn1.p174x509.Extension;
import org.bouncycastle.p133asn1.p174x509.GeneralName;
import org.bouncycastle.p133asn1.p174x509.GeneralNames;
import org.bouncycastle.p133asn1.p174x509.SubjectKeyIdentifier;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p177cert.X509ExtensionUtils;
import org.bouncycastle.p361util.Integers;

/* loaded from: classes2.dex */
public class JcaX509ExtensionUtils extends X509ExtensionUtils {

    public static class SHA1DigestCalculator implements DigestCalculator {

        /* renamed from: bOut */
        private ByteArrayOutputStream f18881bOut = new ByteArrayOutputStream();

        /* renamed from: digest */
        private MessageDigest f18882digest;

        public SHA1DigestCalculator(MessageDigest messageDigest) {
            this.f18882digest = messageDigest;
        }

        @Override // org.bouncycastle.operator.DigestCalculator
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.f18459idSHA1);
        }

        @Override // org.bouncycastle.operator.DigestCalculator
        public byte[] getDigest() {
            byte[] bArrDigest = this.f18882digest.digest(this.f18881bOut.toByteArray());
            this.f18881bOut.reset();
            return bArrDigest;
        }

        @Override // org.bouncycastle.operator.DigestCalculator
        public OutputStream getOutputStream() {
            return this.f18881bOut;
        }
    }

    public JcaX509ExtensionUtils() {
        super(new SHA1DigestCalculator(MessageDigest.getInstance("SHA1")));
    }

    private static Collection getAlternativeNames(byte[] bArr) throws CertificateParsingException, IOException {
        String string;
        if (bArr == null) {
            return Collections.EMPTY_LIST;
        }
        try {
            ArrayList arrayList = new ArrayList();
            Enumeration objects = ASN1Sequence.getInstance(parseExtensionValue(bArr)).getObjects();
            while (objects.hasMoreElements()) {
                GeneralName generalName = GeneralName.getInstance(objects.nextElement());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add(Integers.m18296valueOf(generalName.getTagNo()));
                switch (generalName.getTagNo()) {
                    case 0:
                    case 3:
                    case 5:
                        arrayList2.add(generalName.getEncoded());
                        arrayList.add(arrayList2);
                    case 1:
                    case 2:
                    case 6:
                        string = ((ASN1String) generalName.m14690getName()).getString();
                        arrayList2.add(string);
                        arrayList.add(arrayList2);
                    case 4:
                        string = X500Name.getInstance(RFC4519Style.INSTANCE, generalName.m14690getName()).toString();
                        arrayList2.add(string);
                        arrayList.add(arrayList2);
                    case 7:
                        try {
                            string = InetAddress.getByAddress(ASN1OctetString.getInstance(generalName.m14690getName()).getOctets()).getHostAddress();
                            arrayList2.add(string);
                            arrayList.add(arrayList2);
                        } catch (UnknownHostException unused) {
                        }
                    case 8:
                        string = ASN1ObjectIdentifier.getInstance(generalName.m14690getName()).m14433getId();
                        arrayList2.add(string);
                        arrayList.add(arrayList2);
                    default:
                        throw new IOException("Bad tag number: " + generalName.getTagNo());
                }
            }
            return Collections.unmodifiableCollection(arrayList);
        } catch (Exception e) {
            throw new CertificateParsingException(e.getMessage());
        }
    }

    public static Collection getIssuerAlternativeNames(X509Certificate x509Certificate) {
        return getAlternativeNames(x509Certificate.getExtensionValue(Extension.issuerAlternativeName.m14433getId()));
    }

    public static Collection getSubjectAlternativeNames(X509Certificate x509Certificate) {
        return getAlternativeNames(x509Certificate.getExtensionValue(Extension.subjectAlternativeName.m14433getId()));
    }

    public static ASN1Primitive parseExtensionValue(byte[] bArr) {
        return ASN1Primitive.fromByteArray(ASN1OctetString.getInstance(bArr).getOctets());
    }

    public AuthorityKeyIdentifier createAuthorityKeyIdentifier(PublicKey publicKey) {
        return super.createAuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
    }

    public SubjectKeyIdentifier createSubjectKeyIdentifier(PublicKey publicKey) {
        return super.createSubjectKeyIdentifier(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
    }

    public SubjectKeyIdentifier createTruncatedSubjectKeyIdentifier(PublicKey publicKey) {
        return super.createTruncatedSubjectKeyIdentifier(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()));
    }

    public JcaX509ExtensionUtils(DigestCalculator digestCalculator) {
        super(digestCalculator);
    }

    public AuthorityKeyIdentifier createAuthorityKeyIdentifier(PublicKey publicKey, X500Principal x500Principal, BigInteger bigInteger) {
        return super.createAuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()), new GeneralNames(new GeneralName(X500Name.getInstance(x500Principal.getEncoded()))), bigInteger);
    }

    public AuthorityKeyIdentifier createAuthorityKeyIdentifier(PublicKey publicKey, GeneralNames generalNames, BigInteger bigInteger) {
        return super.createAuthorityKeyIdentifier(SubjectPublicKeyInfo.getInstance(publicKey.getEncoded()), generalNames, bigInteger);
    }

    public AuthorityKeyIdentifier createAuthorityKeyIdentifier(X509Certificate x509Certificate) {
        return super.createAuthorityKeyIdentifier(new JcaX509CertificateHolder(x509Certificate));
    }
}
