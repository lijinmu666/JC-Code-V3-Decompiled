package org.bouncycastle.p302openssl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p361util.p362io.p363pem.PemGenerationException;
import org.bouncycastle.p361util.p362io.p363pem.PemObject;
import org.bouncycastle.p361util.p362io.p363pem.PemObjectGenerator;

/* loaded from: classes2.dex */
public class PKCS8Generator implements PemObjectGenerator {
    public static final AlgorithmIdentifier PRF_HMACGOST3411;
    public static final AlgorithmIdentifier PRF_HMACSHA1;
    public static final AlgorithmIdentifier PRF_HMACSHA224;
    public static final AlgorithmIdentifier PRF_HMACSHA256;
    public static final AlgorithmIdentifier PRF_HMACSHA384;
    public static final AlgorithmIdentifier PRF_HMACSHA3_224;
    public static final AlgorithmIdentifier PRF_HMACSHA3_256;
    public static final AlgorithmIdentifier PRF_HMACSHA3_384;
    public static final AlgorithmIdentifier PRF_HMACSHA3_512;
    public static final AlgorithmIdentifier PRF_HMACSHA512;

    /* renamed from: key */
    private PrivateKeyInfo f22828key;
    private OutputEncryptor outputEncryptor;
    public static final ASN1ObjectIdentifier AES_128_CBC = NISTObjectIdentifiers.id_aes128_CBC;
    public static final ASN1ObjectIdentifier AES_192_CBC = NISTObjectIdentifiers.id_aes192_CBC;
    public static final ASN1ObjectIdentifier AES_256_CBC = NISTObjectIdentifiers.id_aes256_CBC;
    public static final ASN1ObjectIdentifier DES3_CBC = PKCSObjectIdentifiers.des_EDE3_CBC;
    public static final ASN1ObjectIdentifier PBE_SHA1_RC4_128 = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC4;
    public static final ASN1ObjectIdentifier PBE_SHA1_RC4_40 = PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC4;
    public static final ASN1ObjectIdentifier PBE_SHA1_3DES = PKCSObjectIdentifiers.pbeWithSHAAnd3_KeyTripleDES_CBC;
    public static final ASN1ObjectIdentifier PBE_SHA1_2DES = PKCSObjectIdentifiers.pbeWithSHAAnd2_KeyTripleDES_CBC;
    public static final ASN1ObjectIdentifier PBE_SHA1_RC2_128 = PKCSObjectIdentifiers.pbeWithSHAAnd128BitRC2_CBC;
    public static final ASN1ObjectIdentifier PBE_SHA1_RC2_40 = PKCSObjectIdentifiers.pbeWithSHAAnd40BitRC2_CBC;

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_hmacWithSHA1;
        C5103DERNull c5103DERNull = C5103DERNull.INSTANCE;
        PRF_HMACSHA1 = new AlgorithmIdentifier(aSN1ObjectIdentifier, c5103DERNull);
        PRF_HMACSHA224 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA224, c5103DERNull);
        PRF_HMACSHA256 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA256, c5103DERNull);
        PRF_HMACSHA384 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA384, c5103DERNull);
        PRF_HMACSHA512 = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, c5103DERNull);
        PRF_HMACGOST3411 = new AlgorithmIdentifier(CryptoProObjectIdentifiers.gostR3411Hmac, c5103DERNull);
        PRF_HMACSHA3_224 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_224, c5103DERNull);
        PRF_HMACSHA3_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_256, c5103DERNull);
        PRF_HMACSHA3_384 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_384, c5103DERNull);
        PRF_HMACSHA3_512 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_512, c5103DERNull);
    }

    public PKCS8Generator(PrivateKeyInfo privateKeyInfo, OutputEncryptor outputEncryptor) {
        this.f22828key = privateKeyInfo;
        this.outputEncryptor = outputEncryptor;
    }

    @Override // org.bouncycastle.p361util.p362io.p363pem.PemObjectGenerator
    public PemObject generate() {
        OutputEncryptor outputEncryptor = this.outputEncryptor;
        return outputEncryptor != null ? generate(this.f22828key, outputEncryptor) : generate(this.f22828key, null);
    }

    private PemObject generate(PrivateKeyInfo privateKeyInfo, OutputEncryptor outputEncryptor) throws IOException {
        try {
            byte[] encoded = privateKeyInfo.getEncoded();
            if (outputEncryptor == null) {
                return new PemObject(PEMParser.TYPE_PRIVATE_KEY, encoded);
            }
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            OutputStream outputStream = outputEncryptor.getOutputStream(byteArrayOutputStream);
            outputStream.write(privateKeyInfo.getEncoded());
            outputStream.close();
            return new PemObject(PEMParser.TYPE_ENCRYPTED_PRIVATE_KEY, new EncryptedPrivateKeyInfo(outputEncryptor.getAlgorithmIdentifier(), byteArrayOutputStream.toByteArray()).getEncoded());
        } catch (IOException e) {
            throw new PemGenerationException("unable to process encoded key data: " + e.getMessage(), e);
        }
    }
}
