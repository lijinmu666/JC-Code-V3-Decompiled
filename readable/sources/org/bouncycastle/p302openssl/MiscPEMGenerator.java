package org.bouncycastle.p302openssl;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.DSAParameter;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p177cert.X509AttributeCertificateHolder;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p307pkcs.PKCS10CertificationRequest;
import org.bouncycastle.p307pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.bouncycastle.p361util.C6250Strings;
import org.bouncycastle.p361util.p362io.p363pem.PemGenerationException;
import org.bouncycastle.p361util.p362io.p363pem.PemHeader;
import org.bouncycastle.p361util.p362io.p363pem.PemObject;
import org.bouncycastle.p361util.p362io.p363pem.PemObjectGenerator;
import p094kotlin.C1126UByte;

/* loaded from: classes2.dex */
public class MiscPEMGenerator implements PemObjectGenerator {

    /* renamed from: dsaOids */
    private static final ASN1ObjectIdentifier[] f22823dsaOids = {X9ObjectIdentifiers.f18789id_dsa, OIWObjectIdentifiers.dsaWithSHA1};
    private static final byte[] hexEncodingTable = {48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70};
    private final PEMEncryptor encryptor;

    /* renamed from: obj */
    private final Object f22824obj;

    public MiscPEMGenerator(Object obj) {
        this.f22824obj = obj;
        this.encryptor = null;
    }

    private PemObject createPemObject(Object obj) throws PemGenerationException {
        byte[] encoded;
        String str;
        if (obj instanceof PemObject) {
            return (PemObject) obj;
        }
        if (obj instanceof PemObjectGenerator) {
            return ((PemObjectGenerator) obj).generate();
        }
        if (obj instanceof X509CertificateHolder) {
            encoded = ((X509CertificateHolder) obj).getEncoded();
            str = PEMParser.TYPE_CERTIFICATE;
        } else if (obj instanceof X509CRLHolder) {
            encoded = ((X509CRLHolder) obj).getEncoded();
            str = PEMParser.TYPE_X509_CRL;
        } else if (obj instanceof X509TrustedCertificateBlock) {
            encoded = ((X509TrustedCertificateBlock) obj).getEncoded();
            str = PEMParser.TYPE_TRUSTED_CERTIFICATE;
        } else if (obj instanceof PrivateKeyInfo) {
            PrivateKeyInfo privateKeyInfo = (PrivateKeyInfo) obj;
            ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
            if (algorithm.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.rsaEncryption)) {
                encoded = privateKeyInfo.parsePrivateKey().toASN1Primitive().getEncoded();
                str = PEMParser.TYPE_RSA_PRIVATE_KEY;
            } else {
                ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr = f22823dsaOids;
                if (algorithm.m14446equals((ASN1Primitive) aSN1ObjectIdentifierArr[0]) || algorithm.m14446equals((ASN1Primitive) aSN1ObjectIdentifierArr[1])) {
                    DSAParameter dSAParameter = DSAParameter.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
                    ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
                    aSN1EncodableVector.m14420add(ASN1Integer.f17922ZERO);
                    aSN1EncodableVector.m14420add(new ASN1Integer(dSAParameter.m14680getP()));
                    aSN1EncodableVector.m14420add(new ASN1Integer(dSAParameter.m14681getQ()));
                    aSN1EncodableVector.m14420add(new ASN1Integer(dSAParameter.m14679getG()));
                    BigInteger value = ASN1Integer.getInstance(privateKeyInfo.parsePrivateKey()).getValue();
                    aSN1EncodableVector.m14420add(new ASN1Integer(dSAParameter.m14679getG().modPow(value, dSAParameter.m14680getP())));
                    aSN1EncodableVector.m14420add(new ASN1Integer(value));
                    encoded = new DERSequence(aSN1EncodableVector).getEncoded();
                    str = PEMParser.TYPE_DSA_PRIVATE_KEY;
                } else if (algorithm.m14446equals((ASN1Primitive) X9ObjectIdentifiers.id_ecPublicKey)) {
                    encoded = privateKeyInfo.parsePrivateKey().toASN1Primitive().getEncoded();
                    str = PEMParser.TYPE_EC_PRIVATE_KEY;
                } else {
                    encoded = privateKeyInfo.getEncoded();
                    str = PEMParser.TYPE_PRIVATE_KEY;
                }
            }
        } else if (obj instanceof SubjectPublicKeyInfo) {
            encoded = ((SubjectPublicKeyInfo) obj).getEncoded();
            str = PEMParser.TYPE_PUBLIC_KEY;
        } else if (obj instanceof X509AttributeCertificateHolder) {
            encoded = ((X509AttributeCertificateHolder) obj).getEncoded();
            str = PEMParser.TYPE_ATTRIBUTE_CERTIFICATE;
        } else if (obj instanceof PKCS10CertificationRequest) {
            encoded = ((PKCS10CertificationRequest) obj).getEncoded();
            str = PEMParser.TYPE_CERTIFICATE_REQUEST;
        } else if (obj instanceof PKCS8EncryptedPrivateKeyInfo) {
            encoded = ((PKCS8EncryptedPrivateKeyInfo) obj).getEncoded();
            str = PEMParser.TYPE_ENCRYPTED_PRIVATE_KEY;
        } else {
            if (!(obj instanceof ContentInfo)) {
                throw new PemGenerationException("unknown object passed - can't encode.");
            }
            encoded = ((ContentInfo) obj).getEncoded();
            str = PEMParser.TYPE_PKCS7;
        }
        PEMEncryptor pEMEncryptor = this.encryptor;
        if (pEMEncryptor == null) {
            return new PemObject(str, encoded);
        }
        String upperCase = C6250Strings.toUpperCase(pEMEncryptor.getAlgorithm());
        if (upperCase.equals("DESEDE")) {
            upperCase = "DES-EDE3-CBC";
        }
        byte[] bArrMo17363getIV = this.encryptor.mo17363getIV();
        byte[] bArrMo17362encrypt = this.encryptor.mo17362encrypt(encoded);
        ArrayList arrayList = new ArrayList(2);
        arrayList.add(new PemHeader("Proc-Type", "4,ENCRYPTED"));
        arrayList.add(new PemHeader("DEK-Info", upperCase + "," + getHexEncoded(bArrMo17363getIV)));
        return new PemObject(str, arrayList, bArrMo17362encrypt);
    }

    private String getHexEncoded(byte[] bArr) {
        char[] cArr = new char[bArr.length * 2];
        for (int i = 0; i != bArr.length; i++) {
            byte b = bArr[i];
            int i2 = b & C1126UByte.MAX_VALUE;
            int i3 = i * 2;
            byte[] bArr2 = hexEncodingTable;
            cArr[i3] = (char) bArr2[i2 >>> 4];
            cArr[i3 + 1] = (char) bArr2[b & 15];
        }
        return new String(cArr);
    }

    @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectGenerator
    public PemObject generate() throws PemGenerationException {
        try {
            return createPemObject(this.f22824obj);
        } catch (IOException e) {
            throw new PemGenerationException("encoding exception: " + e.getMessage(), e);
        }
    }

    public MiscPEMGenerator(Object obj, PEMEncryptor pEMEncryptor) {
        this.f22824obj = obj;
        this.encryptor = pEMEncryptor;
    }
}
