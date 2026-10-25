package org.bouncycastle.p281jce;

import java.io.IOException;
import java.math.BigInteger;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1OctetString;
import org.bouncycastle.p133asn1.ASN1ParsingException;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.p166pkcs.C5136MacData;
import org.bouncycastle.p133asn1.p166pkcs.C5137Pfx;
import org.bouncycastle.p133asn1.p166pkcs.ContentInfo;
import org.bouncycastle.p133asn1.p166pkcs.EncryptedData;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.DigestInfo;
import org.bouncycastle.p361util.BigIntegers;
import org.bouncycastle.p361util.Properties;

/* loaded from: classes2.dex */
public class PKCS12Util {
    private static final BigInteger DEFAULT_MAX_IT_COUNT = BigInteger.valueOf(5000000);
    static final String PKCS12_MAX_IT_COUNT_PROPERTY = "org.bouncycastle.pkcs12.max_it_count";

    private static byte[] calculatePbeMac(ASN1ObjectIdentifier aSN1ObjectIdentifier, byte[] bArr, int i, char[] cArr, byte[] bArr2, String str) throws IllegalStateException, InvalidKeySpecException, NoSuchAlgorithmException, InvalidKeyException, NoSuchProviderException, InvalidAlgorithmParameterException {
        SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance(aSN1ObjectIdentifier.m14433getId(), str);
        PBEParameterSpec pBEParameterSpec = new PBEParameterSpec(bArr, i);
        SecretKey secretKeyGenerateSecret = secretKeyFactory.generateSecret(new PBEKeySpec(cArr));
        Mac mac = Mac.getInstance(aSN1ObjectIdentifier.m14433getId(), str);
        mac.init(secretKeyGenerateSecret, pBEParameterSpec);
        mac.update(bArr2);
        return mac.doFinal();
    }

    public static byte[] convertToDefiniteLength(byte[] bArr) {
        return C5137Pfx.getInstance(bArr).getEncoded(ASN1Encoding.f17902DER);
    }

    public static ASN1Encodable getContent(ContentInfo contentInfo) {
        ASN1Encodable content = contentInfo.getContent();
        if (content != null) {
            return content;
        }
        throw new ASN1ParsingException("ContentInfo content missing");
    }

    public static byte[] getContentOctets(ContentInfo contentInfo) {
        return ASN1OctetString.getInstance(getContent(contentInfo)).getOctets();
    }

    public static ASN1OctetString getEncryptedContent(EncryptedData encryptedData) {
        ASN1OctetString content = encryptedData.getContent();
        if (content != null) {
            return content;
        }
        throw new ASN1ParsingException("EncryptedContentInfo content missing");
    }

    public static int validateIterationCount(BigInteger bigInteger) {
        if (bigInteger.signum() < 0) {
            throw new IllegalStateException("negative iteration count found");
        }
        if (bigInteger.bitLength() > 31) {
            throw new IllegalStateException("iteration counts >= 2^31 are not suppported");
        }
        BigInteger bigIntegerAsBigInteger = Properties.asBigInteger(PKCS12_MAX_IT_COUNT_PROPERTY);
        if (bigIntegerAsBigInteger == null) {
            bigIntegerAsBigInteger = DEFAULT_MAX_IT_COUNT;
        }
        if (bigInteger.compareTo(bigIntegerAsBigInteger) <= 0) {
            return BigIntegers.intValueExact(bigInteger);
        }
        throw new IllegalStateException("iteration count " + bigInteger + " greater than " + bigIntegerAsBigInteger);
    }

    public static byte[] convertToDefiniteLength(byte[] bArr, char[] cArr, String str) throws IOException {
        C5137Pfx c5137Pfx = C5137Pfx.getInstance(bArr);
        ContentInfo authSafe = c5137Pfx.getAuthSafe();
        ContentInfo contentInfo = new ContentInfo(authSafe.getContentType(), new DEROctetString(ASN1Primitive.fromByteArray(getContentOctets(authSafe)).getEncoded(ASN1Encoding.f17902DER)));
        C5136MacData macData = c5137Pfx.getMacData();
        try {
            int iValidateIterationCount = validateIterationCount(macData.getIterationCount());
            return new C5137Pfx(contentInfo, new C5136MacData(new DigestInfo(new AlgorithmIdentifier(macData.m14631getMac().getAlgorithmId().getAlgorithm(), C5103DERNull.INSTANCE), calculatePbeMac(macData.m14631getMac().getAlgorithmId().getAlgorithm(), macData.m14632getSalt(), iValidateIterationCount, cArr, getContentOctets(contentInfo), str)), macData.m14632getSalt(), iValidateIterationCount)).getEncoded(ASN1Encoding.f17902DER);
        } catch (Exception e) {
            throw new IOException("error constructing MAC: " + e.toString());
        }
    }
}
