package org.bouncycastle.p249jcajce.provider.asymmetric.p262rsa;

import java.security.AlgorithmParameters;
import java.security.InvalidKeyException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SignatureException;
import java.security.SignatureSpi;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.AlgorithmParameterSpec;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.DigestInfo;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p194crypto.AsymmetricBlockCipher;
import org.bouncycastle.p194crypto.InterfaceC5277Digest;
import org.bouncycastle.p194crypto.encodings.PKCS1Encoding;
import org.bouncycastle.p194crypto.p199digests.MD2Digest;
import org.bouncycastle.p194crypto.p199digests.MD4Digest;
import org.bouncycastle.p194crypto.p199digests.NullDigest;
import org.bouncycastle.p194crypto.p199digests.RIPEMD128Digest;
import org.bouncycastle.p194crypto.p199digests.RIPEMD160Digest;
import org.bouncycastle.p194crypto.p199digests.RIPEMD256Digest;
import org.bouncycastle.p194crypto.p201engines.RSABlindedEngine;
import org.bouncycastle.p194crypto.p213params.RSAKeyParameters;
import org.bouncycastle.p194crypto.p221util.DigestFactory;
import org.bouncycastle.p249jcajce.p280util.AnnotatedPrivateKey;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class DigestSignatureSpi extends SignatureSpi {

    /* renamed from: algId */
    private AlgorithmIdentifier f21603algId;

    /* renamed from: cipher */
    private AsymmetricBlockCipher f21604cipher;

    /* renamed from: digest */
    private InterfaceC5277Digest f21605digest;

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD2 */
    public static class C5595MD2 extends DigestSignatureSpi {
        public C5595MD2() {
            super(PKCSObjectIdentifiers.f18501md2, new MD2Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD4 */
    public static class C5596MD4 extends DigestSignatureSpi {
        public C5596MD4() {
            super(PKCSObjectIdentifiers.f18502md4, new MD4Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$MD5 */
    public static class C5597MD5 extends DigestSignatureSpi {
        public C5597MD5() {
            super(PKCSObjectIdentifiers.f18503md5, DigestFactory.createMD5(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD128 extends DigestSignatureSpi {
        public RIPEMD128() {
            super(TeleTrusTObjectIdentifiers.ripemd128, new RIPEMD128Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD160 extends DigestSignatureSpi {
        public RIPEMD160() {
            super(TeleTrusTObjectIdentifiers.ripemd160, new RIPEMD160Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class RIPEMD256 extends DigestSignatureSpi {
        public RIPEMD256() {
            super(TeleTrusTObjectIdentifiers.ripemd256, new RIPEMD256Digest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA1 */
    public static class C5598SHA1 extends DigestSignatureSpi {
        public C5598SHA1() {
            super(OIWObjectIdentifiers.f21282idSHA1, DigestFactory.createSHA1(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA224 */
    public static class C5599SHA224 extends DigestSignatureSpi {
        public C5599SHA224() {
            super(NISTObjectIdentifiers.id_sha224, DigestFactory.createSHA224(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA256 */
    public static class C5600SHA256 extends DigestSignatureSpi {
        public C5600SHA256() {
            super(NISTObjectIdentifiers.id_sha256, DigestFactory.createSHA256(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA384 */
    public static class C5601SHA384 extends DigestSignatureSpi {
        public C5601SHA384() {
            super(NISTObjectIdentifiers.id_sha384, DigestFactory.createSHA384(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA3_224 extends DigestSignatureSpi {
        public SHA3_224() {
            super(NISTObjectIdentifiers.id_sha3_224, DigestFactory.createSHA3_224(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA3_256 extends DigestSignatureSpi {
        public SHA3_256() {
            super(NISTObjectIdentifiers.id_sha3_256, DigestFactory.createSHA3_256(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA3_384 extends DigestSignatureSpi {
        public SHA3_384() {
            super(NISTObjectIdentifiers.id_sha3_384, DigestFactory.createSHA3_384(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA3_512 extends DigestSignatureSpi {
        public SHA3_512() {
            super(NISTObjectIdentifiers.id_sha3_512, DigestFactory.createSHA3_512(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$SHA512 */
    public static class C5602SHA512 extends DigestSignatureSpi {
        public C5602SHA512() {
            super(NISTObjectIdentifiers.id_sha512, DigestFactory.createSHA512(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA512_224 extends DigestSignatureSpi {
        public SHA512_224() {
            super(NISTObjectIdentifiers.id_sha512_224, DigestFactory.createSHA512_224(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public static class SHA512_256 extends DigestSignatureSpi {
        public SHA512_256() {
            super(NISTObjectIdentifiers.id_sha512_256, DigestFactory.createSHA512_256(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.asymmetric.rsa.DigestSignatureSpi$noneRSA */
    public static class C5603noneRSA extends DigestSignatureSpi {
        public C5603noneRSA() {
            super(new NullDigest(), new PKCS1Encoding(new RSABlindedEngine()));
        }
    }

    public DigestSignatureSpi(ASN1ObjectIdentifier aSN1ObjectIdentifier, InterfaceC5277Digest interfaceC5277Digest, AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f21605digest = interfaceC5277Digest;
        this.f21604cipher = asymmetricBlockCipher;
        this.f21603algId = new AlgorithmIdentifier(aSN1ObjectIdentifier, C5103DERNull.INSTANCE);
    }

    private byte[] derEncode(byte[] bArr) {
        AlgorithmIdentifier algorithmIdentifier = this.f21603algId;
        return algorithmIdentifier == null ? bArr : new DigestInfo(algorithmIdentifier, bArr).getEncoded(ASN1Encoding.f17902DER);
    }

    /* renamed from: getType */
    private String m16131getType(Object obj) {
        if (obj == null) {
            return null;
        }
        return obj.getClass().getName();
    }

    @Override // java.security.SignatureSpi
    public Object engineGetParameter(String str) {
        return null;
    }

    @Override // java.security.SignatureSpi
    public AlgorithmParameters engineGetParameters() {
        return null;
    }

    @Override // java.security.SignatureSpi
    public void engineInitSign(PrivateKey privateKey) throws InvalidKeyException {
        if (privateKey instanceof AnnotatedPrivateKey) {
            privateKey = ((AnnotatedPrivateKey) privateKey).m16224getKey();
        }
        if (privateKey instanceof RSAPrivateKey) {
            RSAKeyParameters rSAKeyParametersGeneratePrivateKeyParameter = C5606RSAUtil.generatePrivateKeyParameter((RSAPrivateKey) privateKey);
            this.f21605digest.mo14968reset();
            this.f21604cipher.mo14943init(true, rSAKeyParametersGeneratePrivateKeyParameter);
        } else {
            throw new InvalidKeyException("Supplied key (" + m16131getType(privateKey) + ") is not a RSAPrivateKey instance");
        }
    }

    @Override // java.security.SignatureSpi
    public void engineInitVerify(PublicKey publicKey) throws InvalidKeyException {
        if (publicKey instanceof RSAPublicKey) {
            RSAKeyParameters rSAKeyParametersGeneratePublicKeyParameter = C5606RSAUtil.generatePublicKeyParameter((RSAPublicKey) publicKey);
            this.f21605digest.mo14968reset();
            this.f21604cipher.mo14943init(false, rSAKeyParametersGeneratePublicKeyParameter);
        } else {
            throw new InvalidKeyException("Supplied key (" + m16131getType(publicKey) + ") is not a RSAPublicKey instance");
        }
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(String str, Object obj) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public byte[] engineSign() throws SignatureException {
        byte[] bArr = new byte[this.f21605digest.getDigestSize()];
        this.f21605digest.mo14967doFinal(bArr, 0);
        try {
            byte[] bArrDerEncode = derEncode(bArr);
            return this.f21604cipher.processBlock(bArrDerEncode, 0, bArrDerEncode.length);
        } catch (ArrayIndexOutOfBoundsException unused) {
            throw new SignatureException("key too small for signature type");
        } catch (Exception e) {
            throw new SignatureException(e.toString());
        }
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte b) {
        this.f21605digest.mo14969update(b);
    }

    @Override // java.security.SignatureSpi
    public boolean engineVerify(byte[] bArr) {
        byte[] bArrProcessBlock;
        byte[] bArrDerEncode;
        byte[] bArr2 = new byte[this.f21605digest.getDigestSize()];
        this.f21605digest.mo14967doFinal(bArr2, 0);
        try {
            bArrProcessBlock = this.f21604cipher.processBlock(bArr, 0, bArr.length);
            bArrDerEncode = derEncode(bArr2);
        } catch (Exception unused) {
        }
        if (bArrProcessBlock.length == bArrDerEncode.length) {
            return C6238Arrays.constantTimeAreEqual(bArrProcessBlock, bArrDerEncode);
        }
        if (bArrProcessBlock.length != bArrDerEncode.length - 2) {
            C6238Arrays.constantTimeAreEqual(bArrDerEncode, bArrDerEncode);
            return false;
        }
        bArrDerEncode[1] = (byte) (bArrDerEncode[1] - 2);
        byte b = (byte) (bArrDerEncode[3] - 2);
        bArrDerEncode[3] = b;
        int i = b + 4;
        int i2 = b + 6;
        int i3 = 0;
        for (int i4 = 0; i4 < bArrDerEncode.length - i2; i4++) {
            i3 |= bArrProcessBlock[i + i4] ^ bArrDerEncode[i2 + i4];
        }
        for (int i5 = 0; i5 < i; i5++) {
            i3 |= bArrProcessBlock[i5] ^ bArrDerEncode[i5];
        }
        return i3 == 0;
    }

    public DigestSignatureSpi(InterfaceC5277Digest interfaceC5277Digest, AsymmetricBlockCipher asymmetricBlockCipher) {
        this.f21605digest = interfaceC5277Digest;
        this.f21604cipher = asymmetricBlockCipher;
        this.f21603algId = null;
    }

    @Override // java.security.SignatureSpi
    public void engineSetParameter(AlgorithmParameterSpec algorithmParameterSpec) {
        throw new UnsupportedOperationException("engineSetParameter unsupported");
    }

    @Override // java.security.SignatureSpi
    public void engineUpdate(byte[] bArr, int i, int i2) {
        this.f21605digest.mo14970update(bArr, i, i2);
    }
}
