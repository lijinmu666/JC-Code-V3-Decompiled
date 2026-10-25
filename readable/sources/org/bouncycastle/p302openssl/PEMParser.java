package org.bouncycastle.p302openssl;

import java.io.IOException;
import java.io.Reader;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import org.bouncycastle.p133asn1.ASN1BitString;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p139cms.ContentInfo;
import org.bouncycastle.p133asn1.p166pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.RSAPrivateKey;
import org.bouncycastle.p133asn1.p166pkcs.RSAPublicKey;
import org.bouncycastle.p133asn1.p167sec.ECPrivateKey;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.DSAParameter;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.p176x9.X9ECParameters;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p177cert.X509AttributeCertificateHolder;
import org.bouncycastle.p177cert.X509CRLHolder;
import org.bouncycastle.p177cert.X509CertificateHolder;
import org.bouncycastle.p307pkcs.PKCS10CertificationRequest;
import org.bouncycastle.p307pkcs.PKCS8EncryptedPrivateKeyInfo;
import org.bouncycastle.p361util.encoders.C6255Hex;
import org.bouncycastle.p361util.p362io.p363pem.PemHeader;
import org.bouncycastle.p361util.p362io.p363pem.PemObject;
import org.bouncycastle.p361util.p362io.p363pem.PemObjectParser;
import org.bouncycastle.p361util.p362io.p363pem.PemReader;

/* loaded from: classes2.dex */
public class PEMParser extends PemReader {
    public static final String TYPE_ATTRIBUTE_CERTIFICATE = "ATTRIBUTE CERTIFICATE";
    public static final String TYPE_CERTIFICATE = "CERTIFICATE";
    public static final String TYPE_CERTIFICATE_REQUEST = "CERTIFICATE REQUEST";
    public static final String TYPE_CMS = "CMS";
    public static final String TYPE_DSA_PRIVATE_KEY = "DSA PRIVATE KEY";
    public static final String TYPE_EC_PARAMETERS = "EC PARAMETERS";
    public static final String TYPE_EC_PRIVATE_KEY = "EC PRIVATE KEY";
    public static final String TYPE_ENCRYPTED_PRIVATE_KEY = "ENCRYPTED PRIVATE KEY";
    public static final String TYPE_NEW_CERTIFICATE_REQUEST = "NEW CERTIFICATE REQUEST";
    public static final String TYPE_PKCS7 = "PKCS7";
    public static final String TYPE_PRIVATE_KEY = "PRIVATE KEY";
    public static final String TYPE_PUBLIC_KEY = "PUBLIC KEY";
    public static final String TYPE_RSA_PRIVATE_KEY = "RSA PRIVATE KEY";
    public static final String TYPE_RSA_PUBLIC_KEY = "RSA PUBLIC KEY";
    public static final String TYPE_TRUSTED_CERTIFICATE = "TRUSTED CERTIFICATE";
    public static final String TYPE_X509_CERTIFICATE = "X509 CERTIFICATE";
    public static final String TYPE_X509_CRL = "X509 CRL";

    /* renamed from: parsers */
    protected final Map f22827parsers;

    public static class DSAKeyPairParser implements PEMKeyPairParser {
        private DSAKeyPairParser() {
        }

        @Override // org.bouncycastle.p302openssl.PEMKeyPairParser
        /* renamed from: parse */
        public PEMKeyPair mo17364parse(byte[] bArr) throws IOException {
            try {
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(bArr);
                if (aSN1Sequence.mo14450size() != 6) {
                    throw new PEMException("malformed sequence in DSA private key");
                }
                ASN1Integer aSN1Integer = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1));
                ASN1Integer aSN1Integer2 = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(2));
                ASN1Integer aSN1Integer3 = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(3));
                ASN1Integer aSN1Integer4 = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(4));
                ASN1Integer aSN1Integer5 = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(5));
                ASN1ObjectIdentifier aSN1ObjectIdentifier = X9ObjectIdentifiers.f18789id_dsa;
                return new PEMKeyPair(new SubjectPublicKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, new DSAParameter(aSN1Integer.getValue(), aSN1Integer2.getValue(), aSN1Integer3.getValue())), aSN1Integer4), new PrivateKeyInfo(new AlgorithmIdentifier(aSN1ObjectIdentifier, new DSAParameter(aSN1Integer.getValue(), aSN1Integer2.getValue(), aSN1Integer3.getValue())), aSN1Integer5));
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException("problem creating DSA private key: " + e2.toString(), e2);
            }
        }
    }

    public static class ECCurveParamsParser implements PemObjectParser {
        private ECCurveParamsParser() {
        }

        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                ASN1Primitive aSN1PrimitiveFromByteArray = ASN1Primitive.fromByteArray(pemObject.getContent());
                if (aSN1PrimitiveFromByteArray instanceof ASN1ObjectIdentifier) {
                    return aSN1PrimitiveFromByteArray;
                }
                if (aSN1PrimitiveFromByteArray instanceof ASN1Sequence) {
                    return X9ECParameters.getInstance(aSN1PrimitiveFromByteArray);
                }
                return null;
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException("exception extracting EC named curve: " + e2.toString());
            }
        }
    }

    public static class ECDSAKeyPairParser implements PEMKeyPairParser {
        private ECDSAKeyPairParser() {
        }

        @Override // org.bouncycastle.p302openssl.PEMKeyPairParser
        /* renamed from: parse */
        public PEMKeyPair mo17364parse(byte[] bArr) throws IOException {
            try {
                ECPrivateKey eCPrivateKey = ECPrivateKey.getInstance(ASN1Sequence.getInstance(bArr));
                AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(X9ObjectIdentifiers.id_ecPublicKey, eCPrivateKey.getParametersObject());
                PrivateKeyInfo privateKeyInfo = new PrivateKeyInfo(algorithmIdentifier, eCPrivateKey);
                ASN1BitString publicKey = eCPrivateKey.getPublicKey();
                return new PEMKeyPair(publicKey != null ? new SubjectPublicKeyInfo(algorithmIdentifier, publicKey.getBytes()) : null, privateKeyInfo);
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException("problem creating EC private key: " + e2.toString(), e2);
            }
        }
    }

    public static class EncryptedPrivateKeyParser implements PemObjectParser {
        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws PEMException {
            try {
                return new PKCS8EncryptedPrivateKeyInfo(EncryptedPrivateKeyInfo.getInstance(pemObject.getContent()));
            } catch (Exception e) {
                throw new PEMException("problem parsing ENCRYPTED PRIVATE KEY: " + e.toString(), e);
            }
        }
    }

    public static class KeyPairParser implements PemObjectParser {
        private final PEMKeyPairParser pemKeyPairParser;

        public KeyPairParser(PEMKeyPairParser pEMKeyPairParser) {
            this.pemKeyPairParser = pEMKeyPairParser;
        }

        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws PEMException {
            boolean z = false;
            String value = null;
            for (PemHeader pemHeader : pemObject.getHeaders()) {
                if (pemHeader.m18366getName().equals("Proc-Type") && pemHeader.getValue().equals("4,ENCRYPTED")) {
                    z = true;
                } else if (pemHeader.m18366getName().equals("DEK-Info")) {
                    value = pemHeader.getValue();
                }
            }
            byte[] content = pemObject.getContent();
            try {
                if (!z) {
                    return this.pemKeyPairParser.mo17364parse(content);
                }
                StringTokenizer stringTokenizer = new StringTokenizer(value, ",");
                return new PEMEncryptedKeyPair(stringTokenizer.nextToken(), C6255Hex.m18338decode(stringTokenizer.nextToken()), content, this.pemKeyPairParser);
            } catch (IOException e) {
                if (z) {
                    throw new PEMException("exception decoding - please check password and data.", e);
                }
                throw new PEMException(e.getMessage(), e);
            } catch (IllegalArgumentException e2) {
                if (z) {
                    throw new PEMException("exception decoding - please check password and data.", e2);
                }
                throw new PEMException(e2.getMessage(), e2);
            }
        }
    }

    public static class PKCS10CertificationRequestParser implements PemObjectParser {
        private PKCS10CertificationRequestParser() {
        }

        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws PEMException {
            try {
                return new PKCS10CertificationRequest(pemObject.getContent());
            } catch (Exception e) {
                throw new PEMException("problem parsing certrequest: " + e.toString(), e);
            }
        }
    }

    public static class PKCS7Parser implements PemObjectParser {
        private PKCS7Parser() {
        }

        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws PEMException {
            try {
                return ContentInfo.getInstance(pemObject.getContent());
            } catch (Exception e) {
                throw new PEMException("problem parsing PKCS7 object: " + e.toString(), e);
            }
        }
    }

    public static class PrivateKeyParser implements PemObjectParser {
        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws PEMException {
            try {
                return PrivateKeyInfo.getInstance(pemObject.getContent());
            } catch (Exception e) {
                throw new PEMException("problem parsing PRIVATE KEY: " + e.toString(), e);
            }
        }
    }

    public static class PublicKeyParser implements PemObjectParser {
        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) {
            return SubjectPublicKeyInfo.getInstance(pemObject.getContent());
        }
    }

    public static class RSAKeyPairParser implements PEMKeyPairParser {
        private RSAKeyPairParser() {
        }

        @Override // org.bouncycastle.p302openssl.PEMKeyPairParser
        /* renamed from: parse */
        public PEMKeyPair mo17364parse(byte[] bArr) throws IOException {
            try {
                ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(bArr);
                if (aSN1Sequence.mo14450size() != 9) {
                    throw new PEMException("malformed sequence in RSA private key");
                }
                RSAPrivateKey rSAPrivateKey = RSAPrivateKey.getInstance(aSN1Sequence);
                RSAPublicKey rSAPublicKey = new RSAPublicKey(rSAPrivateKey.getModulus(), rSAPrivateKey.getPublicExponent());
                AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, C5103DERNull.INSTANCE);
                return new PEMKeyPair(new SubjectPublicKeyInfo(algorithmIdentifier, rSAPublicKey), new PrivateKeyInfo(algorithmIdentifier, rSAPrivateKey));
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException("problem creating RSA private key: " + e2.toString(), e2);
            }
        }
    }

    public static class RSAPublicKeyParser implements PemObjectParser {
        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws IOException {
            try {
                return new SubjectPublicKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.rsaEncryption, C5103DERNull.INSTANCE), RSAPublicKey.getInstance(pemObject.getContent()));
            } catch (IOException e) {
                throw e;
            } catch (Exception e2) {
                throw new PEMException("problem extracting key: " + e2.toString(), e2);
            }
        }
    }

    public static class X509AttributeCertificateParser implements PemObjectParser {
        private X509AttributeCertificateParser() {
        }

        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) {
            return new X509AttributeCertificateHolder(pemObject.getContent());
        }
    }

    public static class X509CRLParser implements PemObjectParser {
        private X509CRLParser() {
        }

        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws PEMException {
            try {
                return new X509CRLHolder(pemObject.getContent());
            } catch (Exception e) {
                throw new PEMException("problem parsing cert: " + e.toString(), e);
            }
        }
    }

    public static class X509CertificateParser implements PemObjectParser {
        private X509CertificateParser() {
        }

        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws PEMException {
            try {
                return new X509CertificateHolder(pemObject.getContent());
            } catch (Exception e) {
                throw new PEMException("problem parsing cert: " + e.toString(), e);
            }
        }
    }

    public static class X509TrustedCertificateParser implements PemObjectParser {
        private X509TrustedCertificateParser() {
        }

        @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectParser
        public Object parseObject(PemObject pemObject) throws PEMException {
            try {
                return new X509TrustedCertificateBlock(pemObject.getContent());
            } catch (Exception e) {
                throw new PEMException("problem parsing cert: " + e.toString(), e);
            }
        }
    }

    public PEMParser(Reader reader) {
        super(reader);
        HashMap map = new HashMap();
        this.f22827parsers = map;
        map.put(TYPE_CERTIFICATE_REQUEST, new PKCS10CertificationRequestParser());
        map.put(TYPE_NEW_CERTIFICATE_REQUEST, new PKCS10CertificationRequestParser());
        map.put(TYPE_CERTIFICATE, new X509CertificateParser());
        map.put(TYPE_TRUSTED_CERTIFICATE, new X509TrustedCertificateParser());
        map.put(TYPE_X509_CERTIFICATE, new X509CertificateParser());
        map.put(TYPE_X509_CRL, new X509CRLParser());
        map.put(TYPE_PKCS7, new PKCS7Parser());
        map.put(TYPE_CMS, new PKCS7Parser());
        map.put(TYPE_ATTRIBUTE_CERTIFICATE, new X509AttributeCertificateParser());
        map.put(TYPE_EC_PARAMETERS, new ECCurveParamsParser());
        map.put(TYPE_PUBLIC_KEY, new PublicKeyParser());
        map.put(TYPE_RSA_PUBLIC_KEY, new RSAPublicKeyParser());
        map.put(TYPE_RSA_PRIVATE_KEY, new KeyPairParser(new RSAKeyPairParser()));
        map.put(TYPE_DSA_PRIVATE_KEY, new KeyPairParser(new DSAKeyPairParser()));
        map.put(TYPE_EC_PRIVATE_KEY, new KeyPairParser(new ECDSAKeyPairParser()));
        map.put(TYPE_ENCRYPTED_PRIVATE_KEY, new EncryptedPrivateKeyParser());
        map.put(TYPE_PRIVATE_KEY, new PrivateKeyParser());
    }

    public Set<String> getSupportedTypes() {
        return Collections.unmodifiableSet(this.f22827parsers.keySet());
    }

    public Object readObject() throws IOException {
        PemObject pemObject = readPemObject();
        if (pemObject == null) {
            return null;
        }
        String strM18367getType = pemObject.m18367getType();
        Object obj = this.f22827parsers.get(strM18367getType);
        if (obj != null) {
            return ((PemObjectParser) obj).parseObject(pemObject);
        }
        throw new IOException("unrecognised object: " + strM18367getType);
    }
}
