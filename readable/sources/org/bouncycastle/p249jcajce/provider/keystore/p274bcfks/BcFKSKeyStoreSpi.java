package org.bouncycastle.p249jcajce.provider.keystore.p274bcfks;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.KeyStoreSpi;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.security.UnrecoverableKeyException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.security.interfaces.DSAKey;
import java.security.interfaces.RSAKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.ParseException;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.Mac;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.security.auth.callback.UnsupportedCallbackException;
import org.bouncycastle.internal.p231asn1.p233cms.CCMParameters;
import org.bouncycastle.internal.p231asn1.p241kisa.KISAObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p242misc.MiscObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p242misc.ScryptParams;
import org.bouncycastle.internal.p231asn1.p243nsri.NSRIObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p244ntt.NTTObjectIdentifiers;
import org.bouncycastle.internal.p231asn1.p245oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.ASN1Encodable;
import org.bouncycastle.p133asn1.ASN1Encoding;
import org.bouncycastle.p133asn1.ASN1InputStream;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p135bc.EncryptedObjectStoreData;
import org.bouncycastle.p133asn1.p135bc.EncryptedPrivateKeyData;
import org.bouncycastle.p133asn1.p135bc.EncryptedSecretKeyData;
import org.bouncycastle.p133asn1.p135bc.ObjectData;
import org.bouncycastle.p133asn1.p135bc.ObjectDataSequence;
import org.bouncycastle.p133asn1.p135bc.ObjectStore;
import org.bouncycastle.p133asn1.p135bc.ObjectStoreData;
import org.bouncycastle.p133asn1.p135bc.ObjectStoreIntegrityCheck;
import org.bouncycastle.p133asn1.p135bc.PbkdMacIntegrityCheck;
import org.bouncycastle.p133asn1.p135bc.SecretKeyData;
import org.bouncycastle.p133asn1.p135bc.SignatureCheck;
import org.bouncycastle.p133asn1.p161nist.NISTObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.EncryptedPrivateKeyInfo;
import org.bouncycastle.p133asn1.p166pkcs.EncryptionScheme;
import org.bouncycastle.p133asn1.p166pkcs.KeyDerivationFunc;
import org.bouncycastle.p133asn1.p166pkcs.PBES2Parameters;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PrivateKeyInfo;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p133asn1.p174x509.X509ObjectIdentifiers;
import org.bouncycastle.p133asn1.p176x9.X9ObjectIdentifiers;
import org.bouncycastle.p194crypto.CryptoServicesRegistrar;
import org.bouncycastle.p194crypto.PBEParametersGenerator;
import org.bouncycastle.p194crypto.generators.C5346SCrypt;
import org.bouncycastle.p194crypto.generators.PKCS5S2ParametersGenerator;
import org.bouncycastle.p194crypto.p199digests.SHA3Digest;
import org.bouncycastle.p194crypto.p199digests.SHA512Digest;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p221util.PBKDF2Config;
import org.bouncycastle.p194crypto.p221util.PBKDFConfig;
import org.bouncycastle.p194crypto.p221util.ScryptConfig;
import org.bouncycastle.p249jcajce.BCFKSLoadStoreParameter;
import org.bouncycastle.p249jcajce.BCFKSStoreParameter;
import org.bouncycastle.p249jcajce.BCLoadStoreParameter;
import org.bouncycastle.p249jcajce.p280util.BCJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.provider.keystore.p276util.AdaptingKeyStoreSpi;
import org.bouncycastle.p249jcajce.provider.keystore.p276util.ParameterUtil;
import org.bouncycastle.p281jce.interfaces.InterfaceC5809ECKey;
import org.bouncycastle.p361util.C6238Arrays;
import org.bouncycastle.p361util.C6250Strings;

/* loaded from: classes2.dex */
class BcFKSKeyStoreSpi extends KeyStoreSpi {
    private static final BigInteger CERTIFICATE;
    private static final BigInteger PRIVATE_KEY;
    private static final BigInteger PROTECTED_PRIVATE_KEY;
    private static final BigInteger PROTECTED_SECRET_KEY;
    private static final BigInteger SECRET_KEY;

    /* renamed from: oidMap */
    private static final Map<String, ASN1ObjectIdentifier> f21734oidMap;
    private static final Map<ASN1ObjectIdentifier, String> publicAlgMap;
    private Date creationDate;

    /* renamed from: helper */
    private final JcaJceHelper f21736helper;
    private AlgorithmIdentifier hmacAlgorithm;
    private KeyDerivationFunc hmacPkbdAlgorithm;
    private Date lastModifiedDate;
    private AlgorithmIdentifier signatureAlgorithm;
    private BCFKSLoadStoreParameter.CertChainValidator validator;
    private PublicKey verificationKey;

    /* renamed from: entries */
    private final Map<String, ObjectData> f21735entries = new HashMap();
    private final Map<String, PrivateKey> privateKeyCache = new HashMap();
    private ASN1ObjectIdentifier storeEncryptionAlgorithm = NISTObjectIdentifiers.id_aes256_CCM;

    /* renamed from: org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$Def */
    public static class C5671Def extends BcFKSKeyStoreSpi {
        public C5671Def() {
            super(new DefaultJcaJceHelper());
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return super.engineAliases();
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return super.engineContainsAlias(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) {
            super.engineDeleteEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return super.engineGetCertificate(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return super.engineGetCertificateAlias(certificate);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return super.engineGetCertificateChain(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return super.engineGetCreationDate(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) {
            return super.engineGetKey(str, cArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return super.engineIsCertificateEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return super.engineIsKeyEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) throws IOException {
            super.engineLoad(inputStream, cArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            super.engineSetCertificateEntry(str, certificate);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return super.engineSize();
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException {
            super.engineStore(outputStream, cArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws UnsupportedCallbackException, IOException {
            super.engineLoad(loadStoreParameter);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws ExtKeyStoreException {
            super.engineSetKeyEntry(str, bArr, certificateArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, SignatureException, UnsupportedCallbackException, IOException, InvalidKeyException {
            super.engineStore(loadStoreParameter);
        }
    }

    public static class DefCompat extends AdaptingKeyStoreSpi {
        public DefCompat() {
            super(new DefaultJcaJceHelper(), new BcFKSKeyStoreSpi(new DefaultJcaJceHelper()));
        }
    }

    public static class DefShared extends SharedKeyStoreSpi {
        public DefShared() {
            super(new DefaultJcaJceHelper());
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return super.engineAliases();
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return super.engineContainsAlias(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.SharedKeyStoreSpi, org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) throws KeyStoreException {
            super.engineDeleteEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return super.engineGetCertificate(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return super.engineGetCertificateAlias(certificate);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return super.engineGetCertificateChain(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return super.engineGetCreationDate(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.SharedKeyStoreSpi, org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) {
            return super.engineGetKey(str, cArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return super.engineIsCertificateEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return super.engineIsKeyEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) throws IOException {
            super.engineLoad(inputStream, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.SharedKeyStoreSpi, org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            super.engineSetCertificateEntry(str, certificate);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.SharedKeyStoreSpi, org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return super.engineSize();
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException {
            super.engineStore(outputStream, cArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws UnsupportedCallbackException, IOException {
            super.engineLoad(loadStoreParameter);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.SharedKeyStoreSpi, org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, bArr, certificateArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, SignatureException, UnsupportedCallbackException, IOException, InvalidKeyException {
            super.engineStore(loadStoreParameter);
        }
    }

    public static class DefSharedCompat extends AdaptingKeyStoreSpi {
        public DefSharedCompat() {
            super(new DefaultJcaJceHelper(), new BcFKSKeyStoreSpi(new DefaultJcaJceHelper()));
        }
    }

    public static class ExtKeyStoreException extends KeyStoreException {

        /* renamed from: cause */
        private final Throwable f21739cause;

        public ExtKeyStoreException(String str, Throwable th) {
            super(str);
            this.f21739cause = th;
        }

        @Override // java.lang.Throwable
        public Throwable getCause() {
            return this.f21739cause;
        }
    }

    public static class SharedKeyStoreSpi extends BcFKSKeyStoreSpi implements PKCSObjectIdentifiers, X509ObjectIdentifiers {

        /* renamed from: cache */
        private final Map<String, byte[]> f21740cache;

        /* renamed from: seedKey */
        private final byte[] f21741seedKey;

        public SharedKeyStoreSpi(JcaJceHelper jcaJceHelper) {
            super(jcaJceHelper);
            try {
                byte[] bArr = new byte[32];
                this.f21741seedKey = bArr;
                jcaJceHelper.createSecureRandom("DEFAULT").nextBytes(bArr);
                this.f21740cache = new HashMap();
            } catch (GeneralSecurityException e) {
                throw new IllegalArgumentException("can't create random - " + e.toString());
            }
        }

        private byte[] calculateMac(String str, char[] cArr) {
            return C5346SCrypt.generate(cArr != null ? C6238Arrays.concatenate(C6250Strings.toUTF8ByteArray(cArr), C6250Strings.toUTF8ByteArray(str)) : C6238Arrays.concatenate(this.f21741seedKey, C6250Strings.toUTF8ByteArray(str)), this.f21741seedKey, 16384, 8, 1, 32);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public void engineDeleteEntry(String str) throws KeyStoreException {
            throw new KeyStoreException("delete operation not supported in shared mode");
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public Key engineGetKey(String str, char[] cArr) throws InvalidKeySpecException, UnrecoverableKeyException {
            try {
                byte[] bArrCalculateMac = calculateMac(str, cArr);
                if (!this.f21740cache.containsKey(str) || C6238Arrays.constantTimeAreEqual(this.f21740cache.get(str), bArrCalculateMac)) {
                    Key keyEngineGetKey = super.engineGetKey(str, cArr);
                    if (keyEngineGetKey != null && !this.f21740cache.containsKey(str)) {
                        this.f21740cache.put(str, bArrCalculateMac);
                    }
                    return keyEngineGetKey;
                }
                throw new UnrecoverableKeyException("unable to recover key (" + str + ")");
            } catch (InvalidKeyException e) {
                throw new UnrecoverableKeyException("unable to recover key (" + str + "): " + e.getMessage());
            }
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            throw new KeyStoreException("set operation not supported in shared mode");
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            throw new KeyStoreException("set operation not supported in shared mode");
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
            throw new KeyStoreException("set operation not supported in shared mode");
        }
    }

    /* renamed from: org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi$Std */
    public static class C5672Std extends BcFKSKeyStoreSpi {
        public C5672Std() {
            super(new BCJcaJceHelper());
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return super.engineAliases();
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return super.engineContainsAlias(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) {
            super.engineDeleteEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return super.engineGetCertificate(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return super.engineGetCertificateAlias(certificate);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return super.engineGetCertificateChain(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return super.engineGetCreationDate(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) {
            return super.engineGetKey(str, cArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return super.engineIsCertificateEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return super.engineIsKeyEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) throws IOException {
            super.engineLoad(inputStream, cArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            super.engineSetCertificateEntry(str, certificate);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return super.engineSize();
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException {
            super.engineStore(outputStream, cArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws UnsupportedCallbackException, IOException {
            super.engineLoad(loadStoreParameter);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws ExtKeyStoreException {
            super.engineSetKeyEntry(str, bArr, certificateArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, SignatureException, UnsupportedCallbackException, IOException, InvalidKeyException {
            super.engineStore(loadStoreParameter);
        }
    }

    public static class StdCompat extends AdaptingKeyStoreSpi {
        public StdCompat() {
            super(new DefaultJcaJceHelper(), new BcFKSKeyStoreSpi(new BCJcaJceHelper()));
        }
    }

    public static class StdShared extends SharedKeyStoreSpi {
        public StdShared() {
            super(new BCJcaJceHelper());
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Enumeration engineAliases() {
            return super.engineAliases();
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineContainsAlias(String str) {
            return super.engineContainsAlias(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.SharedKeyStoreSpi, org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineDeleteEntry(String str) throws KeyStoreException {
            super.engineDeleteEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate engineGetCertificate(String str) {
            return super.engineGetCertificate(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ String engineGetCertificateAlias(Certificate certificate) {
            return super.engineGetCertificateAlias(certificate);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Certificate[] engineGetCertificateChain(String str) {
            return super.engineGetCertificateChain(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Date engineGetCreationDate(String str) {
            return super.engineGetCreationDate(str);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.SharedKeyStoreSpi, org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ Key engineGetKey(String str, char[] cArr) {
            return super.engineGetKey(str, cArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsCertificateEntry(String str) {
            return super.engineIsCertificateEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ boolean engineIsKeyEntry(String str) {
            return super.engineIsKeyEntry(str);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(InputStream inputStream, char[] cArr) throws IOException {
            super.engineLoad(inputStream, cArr);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.SharedKeyStoreSpi, org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
            super.engineSetCertificateEntry(str, certificate);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.SharedKeyStoreSpi, org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, key, cArr, certificateArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ int engineSize() {
            return super.engineSize();
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(OutputStream outputStream, char[] cArr) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException {
            super.engineStore(outputStream, cArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws UnsupportedCallbackException, IOException {
            super.engineLoad(loadStoreParameter);
        }

        @Override // org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.SharedKeyStoreSpi, org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws KeyStoreException {
            super.engineSetKeyEntry(str, bArr, certificateArr);
        }

        @Override // org.bouncycastle.p249jcajce.provider.keystore.p274bcfks.BcFKSKeyStoreSpi, java.security.KeyStoreSpi
        public /* bridge */ /* synthetic */ void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, SignatureException, UnsupportedCallbackException, IOException, InvalidKeyException {
            super.engineStore(loadStoreParameter);
        }
    }

    public static class StdSharedCompat extends AdaptingKeyStoreSpi {
        public StdSharedCompat() {
            super(new BCJcaJceHelper(), new BcFKSKeyStoreSpi(new BCJcaJceHelper()));
        }
    }

    static {
        HashMap map = new HashMap();
        f21734oidMap = map;
        HashMap map2 = new HashMap();
        publicAlgMap = map2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = OIWObjectIdentifiers.f21280desEDE;
        map.put("DESEDE", aSN1ObjectIdentifier);
        map.put("TRIPLEDES", aSN1ObjectIdentifier);
        map.put("TDEA", aSN1ObjectIdentifier);
        map.put("HMACSHA1", PKCSObjectIdentifiers.id_hmacWithSHA1);
        map.put("HMACSHA224", PKCSObjectIdentifiers.id_hmacWithSHA224);
        map.put("HMACSHA256", PKCSObjectIdentifiers.id_hmacWithSHA256);
        map.put("HMACSHA384", PKCSObjectIdentifiers.id_hmacWithSHA384);
        map.put("HMACSHA512", PKCSObjectIdentifiers.id_hmacWithSHA512);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.id_hmacWithSHA512_224;
        map.put("HMACSHA512/224", aSN1ObjectIdentifier2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.id_hmacWithSHA512_256;
        map.put("HMACSHA512/256", aSN1ObjectIdentifier3);
        map.put("HMACSHA512(224)", aSN1ObjectIdentifier2);
        map.put("HMACSHA512(256)", aSN1ObjectIdentifier3);
        map.put("HMACSHA3-224", NISTObjectIdentifiers.id_hmacWithSHA3_224);
        map.put("HMACSHA3-256", NISTObjectIdentifiers.id_hmacWithSHA3_256);
        map.put("HMACSHA3-384", NISTObjectIdentifiers.id_hmacWithSHA3_384);
        map.put("HMACSHA3-512", NISTObjectIdentifiers.id_hmacWithSHA3_512);
        map.put("KMAC128", NISTObjectIdentifiers.id_Kmac128);
        map.put("KMAC256", NISTObjectIdentifiers.id_Kmac256);
        map.put("SEED", KISAObjectIdentifiers.id_seedCBC);
        map.put("CAMELLIA.128", NTTObjectIdentifiers.id_camellia128_cbc);
        map.put("CAMELLIA.192", NTTObjectIdentifiers.id_camellia192_cbc);
        map.put("CAMELLIA.256", NTTObjectIdentifiers.id_camellia256_cbc);
        map.put("ARIA.128", NSRIObjectIdentifiers.id_aria128_cbc);
        map.put("ARIA.192", NSRIObjectIdentifiers.id_aria192_cbc);
        map.put("ARIA.256", NSRIObjectIdentifiers.id_aria256_cbc);
        map2.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        map2.put(X9ObjectIdentifiers.id_ecPublicKey, "EC");
        map2.put(OIWObjectIdentifiers.elGamalAlgorithm, "DH");
        map2.put(PKCSObjectIdentifiers.dhKeyAgreement, "DH");
        map2.put(X9ObjectIdentifiers.f18789id_dsa, "DSA");
        CERTIFICATE = BigInteger.valueOf(0L);
        PRIVATE_KEY = BigInteger.valueOf(1L);
        SECRET_KEY = BigInteger.valueOf(2L);
        PROTECTED_PRIVATE_KEY = BigInteger.valueOf(3L);
        PROTECTED_SECRET_KEY = BigInteger.valueOf(4L);
    }

    public BcFKSKeyStoreSpi(JcaJceHelper jcaJceHelper) {
        this.f21736helper = jcaJceHelper;
    }

    private byte[] calculateMac(byte[] bArr, AlgorithmIdentifier algorithmIdentifier, KeyDerivationFunc keyDerivationFunc, char[] cArr) throws InvalidKeyException, IOException {
        String strM14433getId = algorithmIdentifier.getAlgorithm().m14433getId();
        Mac macCreateMac = this.f21736helper.createMac(strM14433getId);
        try {
            if (cArr == null) {
                cArr = new char[0];
            }
            macCreateMac.init(new SecretKeySpec(generateKey(keyDerivationFunc, "INTEGRITY_CHECK", cArr, -1), strM14433getId));
            return macCreateMac.doFinal(bArr);
        } catch (InvalidKeyException e) {
            throw new IOException("Cannot set up MAC calculation: " + e.getMessage());
        }
    }

    private Cipher createCipher(String str, byte[] bArr) throws InvalidKeyException {
        Cipher cipherCreateCipher = this.f21736helper.createCipher(str);
        cipherCreateCipher.init(1, new SecretKeySpec(bArr, "AES"));
        return cipherCreateCipher;
    }

    private EncryptedPrivateKeyData createPrivateKeySequence(EncryptedPrivateKeyInfo encryptedPrivateKeyInfo, Certificate[] certificateArr) {
        org.bouncycastle.p133asn1.p174x509.Certificate[] certificateArr2 = new org.bouncycastle.p133asn1.p174x509.Certificate[certificateArr.length];
        for (int i = 0; i != certificateArr.length; i++) {
            certificateArr2[i] = org.bouncycastle.p133asn1.p174x509.Certificate.getInstance(certificateArr[i].getEncoded());
        }
        return new EncryptedPrivateKeyData(encryptedPrivateKeyInfo, certificateArr2);
    }

    private Certificate decodeCertificate(Object obj) {
        JcaJceHelper jcaJceHelper = this.f21736helper;
        if (jcaJceHelper != null) {
            try {
                return jcaJceHelper.createCertificateFactory("X.509").generateCertificate(new ByteArrayInputStream(org.bouncycastle.p133asn1.p174x509.Certificate.getInstance(obj).getEncoded()));
            } catch (Exception unused) {
                return null;
            }
        }
        try {
            return CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(org.bouncycastle.p133asn1.p174x509.Certificate.getInstance(obj).getEncoded()));
        } catch (Exception unused2) {
            return null;
        }
    }

    private byte[] decryptData(String str, AlgorithmIdentifier algorithmIdentifier, char[] cArr, byte[] bArr) throws IOException, InvalidKeyException, InvalidAlgorithmParameterException {
        Cipher cipherCreateCipher;
        AlgorithmParameters algorithmParametersCreateAlgorithmParameters;
        if (!algorithmIdentifier.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBES2)) {
            throw new IOException("BCFKS KeyStore cannot recognize protection algorithm.");
        }
        PBES2Parameters pBES2Parameters = PBES2Parameters.getInstance(algorithmIdentifier.getParameters());
        EncryptionScheme encryptionScheme = pBES2Parameters.getEncryptionScheme();
        try {
            if (encryptionScheme.getAlgorithm().m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes256_CCM)) {
                cipherCreateCipher = this.f21736helper.createCipher("AES/CCM/NoPadding");
                algorithmParametersCreateAlgorithmParameters = this.f21736helper.createAlgorithmParameters("CCM");
                algorithmParametersCreateAlgorithmParameters.init(CCMParameters.getInstance(encryptionScheme.getParameters()).getEncoded());
            } else {
                if (!encryptionScheme.getAlgorithm().m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_aes256_wrap_pad)) {
                    throw new IOException("BCFKS KeyStore cannot recognize protection encryption algorithm.");
                }
                cipherCreateCipher = this.f21736helper.createCipher("AESKWP");
                algorithmParametersCreateAlgorithmParameters = null;
            }
            KeyDerivationFunc keyDerivationFunc = pBES2Parameters.getKeyDerivationFunc();
            if (cArr == null) {
                cArr = new char[0];
            }
            cipherCreateCipher.init(2, new SecretKeySpec(generateKey(keyDerivationFunc, str, cArr, 32), "AES"), algorithmParametersCreateAlgorithmParameters);
            return cipherCreateCipher.doFinal(bArr);
        } catch (IOException e) {
            throw e;
        } catch (Exception e2) {
            throw new IOException(e2.toString());
        }
    }

    private Date extractCreationDate(ObjectData objectData, Date date) {
        try {
            return objectData.getCreationDate().m14427getDate();
        } catch (ParseException unused) {
            return date;
        }
    }

    private byte[] generateKey(KeyDerivationFunc keyDerivationFunc, String str, char[] cArr, int i) throws IOException {
        byte[] bArrPKCS12PasswordToBytes = PBEParametersGenerator.PKCS12PasswordToBytes(cArr);
        byte[] bArrPKCS12PasswordToBytes2 = PBEParametersGenerator.PKCS12PasswordToBytes(str.toCharArray());
        if (MiscObjectIdentifiers.id_scrypt.m14446equals((ASN1Primitive) keyDerivationFunc.getAlgorithm())) {
            ScryptParams scryptParams = ScryptParams.getInstance(keyDerivationFunc.getParameters());
            if (scryptParams.getKeyLength() != null) {
                i = scryptParams.getKeyLength().intValue();
            } else if (i == -1) {
                throw new IOException("no keyLength found in ScryptParams");
            }
            return C5346SCrypt.generate(C6238Arrays.concatenate(bArrPKCS12PasswordToBytes, bArrPKCS12PasswordToBytes2), scryptParams.m15989getSalt(), scryptParams.getCostParameter().intValue(), scryptParams.getBlockSize().intValue(), scryptParams.getBlockSize().intValue(), i);
        }
        if (!keyDerivationFunc.getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_PBKDF2)) {
            throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD.");
        }
        PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(keyDerivationFunc.getParameters());
        if (pBKDF2Params.getKeyLength() != null) {
            i = pBKDF2Params.getKeyLength().intValue();
        } else if (i == -1) {
            throw new IOException("no keyLength found in PBKDF2Params");
        }
        if (pBKDF2Params.m14634getPrf().getAlgorithm().m14446equals((ASN1Primitive) PKCSObjectIdentifiers.id_hmacWithSHA512)) {
            PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator = new PKCS5S2ParametersGenerator(new SHA512Digest());
            pKCS5S2ParametersGenerator.m14982init(C6238Arrays.concatenate(bArrPKCS12PasswordToBytes, bArrPKCS12PasswordToBytes2), pBKDF2Params.m14635getSalt(), pBKDF2Params.getIterationCount().intValue());
            return ((KeyParameter) pKCS5S2ParametersGenerator.generateDerivedParameters(i * 8)).m15773getKey();
        }
        if (pBKDF2Params.m14634getPrf().getAlgorithm().m14446equals((ASN1Primitive) NISTObjectIdentifiers.id_hmacWithSHA3_512)) {
            PKCS5S2ParametersGenerator pKCS5S2ParametersGenerator2 = new PKCS5S2ParametersGenerator(new SHA3Digest(512));
            pKCS5S2ParametersGenerator2.m14982init(C6238Arrays.concatenate(bArrPKCS12PasswordToBytes, bArrPKCS12PasswordToBytes2), pBKDF2Params.m14635getSalt(), pBKDF2Params.getIterationCount().intValue());
            return ((KeyParameter) pKCS5S2ParametersGenerator2.generateDerivedParameters(i * 8)).m15773getKey();
        }
        throw new IOException("BCFKS KeyStore: unrecognized MAC PBKD PRF: " + pBKDF2Params.m14634getPrf().getAlgorithm());
    }

    private KeyDerivationFunc generatePkbdAlgorithmIdentifier(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        byte[] bArr = new byte[64];
        getDefaultSecureRandom().nextBytes(bArr);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.id_PBKDF2;
        if (aSN1ObjectIdentifier2.m14446equals((ASN1Primitive) aSN1ObjectIdentifier)) {
            return new KeyDerivationFunc(aSN1ObjectIdentifier2, new PBKDF2Params(bArr, 51200, i, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, C5103DERNull.INSTANCE)));
        }
        throw new IllegalStateException("unknown derivation algorithm: " + aSN1ObjectIdentifier);
    }

    private AlgorithmIdentifier generateSignatureAlgId(Key key, BCFKSLoadStoreParameter.SignatureAlgorithm signatureAlgorithm) throws IOException {
        if (key == null) {
            return null;
        }
        if (key instanceof InterfaceC5809ECKey) {
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA512withECDSA) {
                return new AlgorithmIdentifier(X9ObjectIdentifiers.ecdsa_with_SHA512);
            }
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA3_512withECDSA) {
                return new AlgorithmIdentifier(NISTObjectIdentifiers.id_ecdsa_with_sha3_512);
            }
        }
        if (key instanceof DSAKey) {
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA512withDSA) {
                return new AlgorithmIdentifier(NISTObjectIdentifiers.dsa_with_sha512);
            }
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA3_512withDSA) {
                return new AlgorithmIdentifier(NISTObjectIdentifiers.id_dsa_with_sha3_512);
            }
        }
        if (key instanceof RSAKey) {
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA512withRSA) {
                return new AlgorithmIdentifier(PKCSObjectIdentifiers.sha512WithRSAEncryption, C5103DERNull.INSTANCE);
            }
            if (signatureAlgorithm == BCFKSLoadStoreParameter.SignatureAlgorithm.SHA3_512withRSA) {
                return new AlgorithmIdentifier(NISTObjectIdentifiers.id_rsassa_pkcs1_v1_5_with_sha3_512, C5103DERNull.INSTANCE);
            }
        }
        throw new IOException("unknown signature algorithm");
    }

    private SecureRandom getDefaultSecureRandom() {
        return CryptoServicesRegistrar.getSecureRandom();
    }

    private EncryptedObjectStoreData getEncryptedObjectStoreData(AlgorithmIdentifier algorithmIdentifier, char[] cArr) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException {
        ObjectData[] objectDataArr = (ObjectData[]) this.f21735entries.values().toArray(new ObjectData[this.f21735entries.size()]);
        KeyDerivationFunc keyDerivationFuncGeneratePkbdAlgorithmIdentifier = generatePkbdAlgorithmIdentifier(this.hmacPkbdAlgorithm, 32);
        if (cArr == null) {
            cArr = new char[0];
        }
        byte[] bArrGenerateKey = generateKey(keyDerivationFuncGeneratePkbdAlgorithmIdentifier, "STORE_ENCRYPTION", cArr, 32);
        ObjectStoreData objectStoreData = new ObjectStoreData(algorithmIdentifier, this.creationDate, this.lastModifiedDate, new ObjectDataSequence(objectDataArr), null);
        try {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = this.storeEncryptionAlgorithm;
            ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes256_CCM;
            if (!aSN1ObjectIdentifier.m14446equals((ASN1Primitive) aSN1ObjectIdentifier2)) {
                return new EncryptedObjectStoreData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(keyDerivationFuncGeneratePkbdAlgorithmIdentifier, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_wrap_pad))), createCipher("AESKWP", bArrGenerateKey).doFinal(objectStoreData.getEncoded()));
            }
            Cipher cipherCreateCipher = createCipher("AES/CCM/NoPadding", bArrGenerateKey);
            return new EncryptedObjectStoreData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(keyDerivationFuncGeneratePkbdAlgorithmIdentifier, new EncryptionScheme(aSN1ObjectIdentifier2, CCMParameters.getInstance(cipherCreateCipher.getParameters().getEncoded())))), cipherCreateCipher.doFinal(objectStoreData.getEncoded()));
        } catch (InvalidKeyException e) {
            throw new IOException(e.toString());
        } catch (NoSuchProviderException e2) {
            throw new IOException(e2.toString());
        } catch (BadPaddingException e3) {
            throw new IOException(e3.toString());
        } catch (IllegalBlockSizeException e4) {
            throw new IOException(e4.toString());
        } catch (NoSuchPaddingException e5) {
            throw new NoSuchAlgorithmException(e5.toString());
        }
    }

    private static String getPublicKeyAlg(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        String str = publicAlgMap.get(aSN1ObjectIdentifier);
        return str != null ? str : aSN1ObjectIdentifier.m14433getId();
    }

    private boolean isSimilarHmacPbkd(PBKDFConfig pBKDFConfig, KeyDerivationFunc keyDerivationFunc) {
        if (!pBKDFConfig.getAlgorithm().m14446equals((ASN1Primitive) keyDerivationFunc.getAlgorithm())) {
            return false;
        }
        if (MiscObjectIdentifiers.id_scrypt.m14446equals((ASN1Primitive) keyDerivationFunc.getAlgorithm())) {
            if (!(pBKDFConfig instanceof ScryptConfig)) {
                return false;
            }
            ScryptConfig scryptConfig = (ScryptConfig) pBKDFConfig;
            ScryptParams scryptParams = ScryptParams.getInstance(keyDerivationFunc.getParameters());
            return scryptConfig.getSaltLength() == scryptParams.m15989getSalt().length && scryptConfig.getBlockSize() == scryptParams.getBlockSize().intValue() && scryptConfig.getCostParameter() == scryptParams.getCostParameter().intValue() && scryptConfig.getParallelizationParameter() == scryptParams.getParallelizationParameter().intValue();
        }
        if (!(pBKDFConfig instanceof PBKDF2Config)) {
            return false;
        }
        PBKDF2Config pBKDF2Config = (PBKDF2Config) pBKDFConfig;
        PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(keyDerivationFunc.getParameters());
        return pBKDF2Config.getSaltLength() == pBKDF2Params.m14635getSalt().length && pBKDF2Config.getIterationCount() == pBKDF2Params.getIterationCount().intValue();
    }

    private void verifyMac(byte[] bArr, PbkdMacIntegrityCheck pbkdMacIntegrityCheck, char[] cArr) throws IOException {
        if (!C6238Arrays.constantTimeAreEqual(calculateMac(bArr, pbkdMacIntegrityCheck.getMacAlgorithm(), pbkdMacIntegrityCheck.getPbkdAlgorithm(), cArr), pbkdMacIntegrityCheck.m14486getMac())) {
            throw new IOException("BCFKS KeyStore corrupted: MAC calculation failed");
        }
    }

    private void verifySig(ASN1Encodable aSN1Encodable, SignatureCheck signatureCheck, PublicKey publicKey) throws SignatureException, InvalidKeyException, IOException {
        Signature signatureCreateSignature = this.f21736helper.createSignature(signatureCheck.getSignatureAlgorithm().getAlgorithm().m14433getId());
        signatureCreateSignature.initVerify(publicKey);
        signatureCreateSignature.update(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.f17902DER));
        if (!signatureCreateSignature.verify(signatureCheck.getSignature().getOctets())) {
            throw new IOException("BCFKS KeyStore corrupted: signature calculation failed");
        }
    }

    @Override // java.security.KeyStoreSpi
    public Enumeration<String> engineAliases() {
        final Iterator it = new HashSet(this.f21735entries.keySet()).iterator();
        return new Enumeration(this) { // from class: org.bouncycastle.jcajce.provider.keystore.bcfks.BcFKSKeyStoreSpi.1

            /* renamed from: this$0 */
            final /* synthetic */ BcFKSKeyStoreSpi f21737this$0;

            {
                this.f21737this$0 = this;
            }

            @Override // java.util.Enumeration
            public boolean hasMoreElements() {
                return it.hasNext();
            }

            @Override // java.util.Enumeration
            public Object nextElement() {
                return it.next();
            }
        };
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineContainsAlias(String str) {
        if (str != null) {
            return this.f21735entries.containsKey(str);
        }
        throw new NullPointerException("alias value is null");
    }

    @Override // java.security.KeyStoreSpi
    public void engineDeleteEntry(String str) {
        if (this.f21735entries.get(str) == null) {
            return;
        }
        this.privateKeyCache.remove(str);
        this.f21735entries.remove(str);
        this.lastModifiedDate = new Date();
    }

    @Override // java.security.KeyStoreSpi
    public Certificate engineGetCertificate(String str) {
        ObjectData objectData = this.f21735entries.get(str);
        if (objectData == null) {
            return null;
        }
        if (objectData.m14484getType().equals(PRIVATE_KEY) || objectData.m14484getType().equals(PROTECTED_PRIVATE_KEY)) {
            return decodeCertificate(EncryptedPrivateKeyData.getInstance(objectData.m14483getData()).getCertificateChain()[0]);
        }
        if (objectData.m14484getType().equals(CERTIFICATE)) {
            return decodeCertificate(objectData.m14483getData());
        }
        return null;
    }

    @Override // java.security.KeyStoreSpi
    public String engineGetCertificateAlias(Certificate certificate) throws CertificateEncodingException {
        if (certificate == null) {
            return null;
        }
        try {
            byte[] encoded = certificate.getEncoded();
            for (String str : this.f21735entries.keySet()) {
                ObjectData objectData = this.f21735entries.get(str);
                if (objectData.m14484getType().equals(CERTIFICATE)) {
                    if (C6238Arrays.areEqual(objectData.m14483getData(), encoded)) {
                        return str;
                    }
                } else if (objectData.m14484getType().equals(PRIVATE_KEY) || objectData.m14484getType().equals(PROTECTED_PRIVATE_KEY)) {
                    try {
                        if (C6238Arrays.areEqual(EncryptedPrivateKeyData.getInstance(objectData.m14483getData()).getCertificateChain()[0].toASN1Primitive().getEncoded(), encoded)) {
                            return str;
                        }
                    } catch (IOException unused) {
                        continue;
                    }
                }
            }
        } catch (CertificateEncodingException unused2) {
        }
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.security.KeyStoreSpi
    public Certificate[] engineGetCertificateChain(String str) {
        ObjectData objectData = this.f21735entries.get(str);
        if (objectData == null) {
            return null;
        }
        if (!objectData.m14484getType().equals(PRIVATE_KEY) && !objectData.m14484getType().equals(PROTECTED_PRIVATE_KEY)) {
            return null;
        }
        org.bouncycastle.p133asn1.p174x509.Certificate[] certificateChain = EncryptedPrivateKeyData.getInstance(objectData.m14483getData()).getCertificateChain();
        int length = certificateChain.length;
        X509Certificate[] x509CertificateArr = new X509Certificate[length];
        for (int i = 0; i != length; i++) {
            x509CertificateArr[i] = decodeCertificate(certificateChain[i]);
        }
        return x509CertificateArr;
    }

    @Override // java.security.KeyStoreSpi
    public Date engineGetCreationDate(String str) {
        ObjectData objectData = this.f21735entries.get(str);
        if (objectData == null) {
            return null;
        }
        try {
            return objectData.getLastModifiedDate().m14427getDate();
        } catch (ParseException unused) {
            return new Date();
        }
    }

    @Override // java.security.KeyStoreSpi
    public Key engineGetKey(String str, char[] cArr) throws InvalidKeySpecException, UnrecoverableKeyException {
        ObjectData objectData = this.f21735entries.get(str);
        if (objectData == null) {
            return null;
        }
        if (objectData.m14484getType().equals(PRIVATE_KEY) || objectData.m14484getType().equals(PROTECTED_PRIVATE_KEY)) {
            PrivateKey privateKey = this.privateKeyCache.get(str);
            if (privateKey != null) {
                return privateKey;
            }
            EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = EncryptedPrivateKeyInfo.getInstance(EncryptedPrivateKeyData.getInstance(objectData.m14483getData()).getEncryptedPrivateKeyInfo());
            try {
                PrivateKeyInfo privateKeyInfo = PrivateKeyInfo.getInstance(decryptData("PRIVATE_KEY_ENCRYPTION", encryptedPrivateKeyInfo.getEncryptionAlgorithm(), cArr, encryptedPrivateKeyInfo.getEncryptedData()));
                PrivateKey privateKeyGeneratePrivate = this.f21736helper.createKeyFactory(getPublicKeyAlg(privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm())).generatePrivate(new PKCS8EncodedKeySpec(privateKeyInfo.getEncoded()));
                this.privateKeyCache.put(str, privateKeyGeneratePrivate);
                return privateKeyGeneratePrivate;
            } catch (Exception e) {
                throw new UnrecoverableKeyException("BCFKS KeyStore unable to recover private key (" + str + "): " + e.getMessage());
            }
        }
        if (!objectData.m14484getType().equals(SECRET_KEY) && !objectData.m14484getType().equals(PROTECTED_SECRET_KEY)) {
            throw new UnrecoverableKeyException("BCFKS KeyStore unable to recover secret key (" + str + "): type not recognized");
        }
        EncryptedSecretKeyData encryptedSecretKeyData = EncryptedSecretKeyData.getInstance(objectData.m14483getData());
        try {
            SecretKeyData secretKeyData = SecretKeyData.getInstance(decryptData("SECRET_KEY_ENCRYPTION", encryptedSecretKeyData.getKeyEncryptionAlgorithm(), cArr, encryptedSecretKeyData.getEncryptedKeyData()));
            return this.f21736helper.createSecretKeyFactory(secretKeyData.getKeyAlgorithm().m14433getId()).generateSecret(new SecretKeySpec(secretKeyData.getKeyBytes(), secretKeyData.getKeyAlgorithm().m14433getId()));
        } catch (Exception e2) {
            throw new UnrecoverableKeyException("BCFKS KeyStore unable to recover secret key (" + str + "): " + e2.getMessage());
        }
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsCertificateEntry(String str) {
        ObjectData objectData = this.f21735entries.get(str);
        if (objectData != null) {
            return objectData.m14484getType().equals(CERTIFICATE);
        }
        return false;
    }

    @Override // java.security.KeyStoreSpi
    public boolean engineIsKeyEntry(String str) {
        ObjectData objectData = this.f21735entries.get(str);
        if (objectData == null) {
            return false;
        }
        BigInteger bigIntegerM14484getType = objectData.m14484getType();
        return bigIntegerM14484getType.equals(PRIVATE_KEY) || bigIntegerM14484getType.equals(SECRET_KEY) || bigIntegerM14484getType.equals(PROTECTED_PRIVATE_KEY) || bigIntegerM14484getType.equals(PROTECTED_SECRET_KEY);
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(InputStream inputStream, char[] cArr) throws IOException {
        AlgorithmIdentifier signatureAlgorithm;
        ASN1Encodable storeData;
        PublicKey publicKey;
        ObjectStoreData objectStoreData;
        this.f21735entries.clear();
        this.privateKeyCache.clear();
        this.creationDate = null;
        this.lastModifiedDate = null;
        this.hmacAlgorithm = null;
        if (inputStream == null) {
            Date date = new Date();
            this.creationDate = date;
            this.lastModifiedDate = date;
            this.verificationKey = null;
            this.validator = null;
            this.hmacAlgorithm = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, C5103DERNull.INSTANCE);
            this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, 64);
            return;
        }
        try {
            ObjectStore objectStore = ObjectStore.getInstance(new ASN1InputStream(inputStream).readObject());
            ObjectStoreIntegrityCheck integrityCheck = objectStore.getIntegrityCheck();
            if (integrityCheck.m14485getType() == 0) {
                PbkdMacIntegrityCheck pbkdMacIntegrityCheck = PbkdMacIntegrityCheck.getInstance(integrityCheck.getIntegrityCheck());
                this.hmacAlgorithm = pbkdMacIntegrityCheck.getMacAlgorithm();
                this.hmacPkbdAlgorithm = pbkdMacIntegrityCheck.getPbkdAlgorithm();
                signatureAlgorithm = this.hmacAlgorithm;
                try {
                    verifyMac(objectStore.getStoreData().toASN1Primitive().getEncoded(), pbkdMacIntegrityCheck, cArr);
                } catch (NoSuchProviderException e) {
                    throw new IOException(e.getMessage());
                }
            } else {
                if (integrityCheck.m14485getType() != 1) {
                    throw new IOException("BCFKS KeyStore unable to recognize integrity check.");
                }
                SignatureCheck signatureCheck = SignatureCheck.getInstance(integrityCheck.getIntegrityCheck());
                signatureAlgorithm = signatureCheck.getSignatureAlgorithm();
                try {
                    org.bouncycastle.p133asn1.p174x509.Certificate[] certificates = signatureCheck.getCertificates();
                    if (this.validator == null) {
                        storeData = objectStore.getStoreData();
                        publicKey = this.verificationKey;
                    } else {
                        if (certificates == null) {
                            throw new IOException("validator specified but no certifcates in store");
                        }
                        CertificateFactory certificateFactoryCreateCertificateFactory = this.f21736helper.createCertificateFactory("X.509");
                        int length = certificates.length;
                        X509Certificate[] x509CertificateArr = new X509Certificate[length];
                        for (int i = 0; i != length; i++) {
                            x509CertificateArr[i] = (X509Certificate) certificateFactoryCreateCertificateFactory.generateCertificate(new ByteArrayInputStream(certificates[i].getEncoded()));
                        }
                        if (!this.validator.m16044isValid(x509CertificateArr)) {
                            throw new IOException("certificate chain in key store signature not valid");
                        }
                        storeData = objectStore.getStoreData();
                        publicKey = x509CertificateArr[0].getPublicKey();
                    }
                    verifySig(storeData, signatureCheck, publicKey);
                } catch (GeneralSecurityException e2) {
                    throw new IOException("error verifying signature: " + e2.getMessage(), e2);
                }
            }
            ASN1Encodable storeData2 = objectStore.getStoreData();
            if (storeData2 instanceof EncryptedObjectStoreData) {
                EncryptedObjectStoreData encryptedObjectStoreData = (EncryptedObjectStoreData) storeData2;
                objectStoreData = ObjectStoreData.getInstance(decryptData("STORE_ENCRYPTION", encryptedObjectStoreData.getEncryptionAlgorithm(), cArr, encryptedObjectStoreData.getEncryptedContent().getOctets()));
            } else {
                objectStoreData = ObjectStoreData.getInstance(storeData2);
            }
            try {
                this.creationDate = objectStoreData.getCreationDate().m14427getDate();
                this.lastModifiedDate = objectStoreData.getLastModifiedDate().m14427getDate();
                if (!objectStoreData.getIntegrityAlgorithm().mo14431equals(signatureAlgorithm)) {
                    throw new IOException("BCFKS KeyStore storeData integrity algorithm does not match store integrity algorithm.");
                }
                Iterator<ASN1Encodable> it = objectStoreData.getObjectDataSequence().iterator();
                while (it.hasNext()) {
                    ObjectData objectData = ObjectData.getInstance(it.next());
                    this.f21735entries.put(objectData.getIdentifier(), objectData);
                }
            } catch (ParseException unused) {
                throw new IOException("BCFKS KeyStore unable to parse store data information.");
            }
        } catch (Exception e3) {
            throw new IOException(e3.getMessage());
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetCertificateEntry(String str, Certificate certificate) throws KeyStoreException {
        Date dateExtractCreationDate;
        ObjectData objectData = this.f21735entries.get(str);
        Date date = new Date();
        if (objectData == null) {
            dateExtractCreationDate = date;
        } else {
            if (!objectData.m14484getType().equals(CERTIFICATE)) {
                throw new KeyStoreException("BCFKS KeyStore already has a key entry with alias " + str);
            }
            dateExtractCreationDate = extractCreationDate(objectData, date);
        }
        try {
            this.f21735entries.put(str, new ObjectData(CERTIFICATE, str, dateExtractCreationDate, date, certificate.getEncoded(), null));
            this.lastModifiedDate = date;
        } catch (CertificateEncodingException e) {
            throw new ExtKeyStoreException("BCFKS KeyStore unable to handle certificate: " + e.getMessage(), e);
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, Key key, char[] cArr, Certificate[] certificateArr) throws KeyStoreException {
        SecretKeyData secretKeyData;
        EncryptedSecretKeyData encryptedSecretKeyData;
        EncryptedPrivateKeyInfo encryptedPrivateKeyInfo;
        Date date = new Date();
        ObjectData objectData = this.f21735entries.get(str);
        Date dateExtractCreationDate = objectData != null ? extractCreationDate(objectData, date) : date;
        this.privateKeyCache.remove(str);
        if (key instanceof PrivateKey) {
            if (certificateArr == null) {
                throw new KeyStoreException("BCFKS KeyStore requires a certificate chain for private key storage.");
            }
            try {
                byte[] encoded = key.getEncoded();
                KeyDerivationFunc keyDerivationFuncGeneratePkbdAlgorithmIdentifier = generatePkbdAlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, 32);
                if (cArr == null) {
                    cArr = new char[0];
                }
                byte[] bArrGenerateKey = generateKey(keyDerivationFuncGeneratePkbdAlgorithmIdentifier, "PRIVATE_KEY_ENCRYPTION", cArr, 32);
                ASN1ObjectIdentifier aSN1ObjectIdentifier = this.storeEncryptionAlgorithm;
                ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes256_CCM;
                if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) aSN1ObjectIdentifier2)) {
                    Cipher cipherCreateCipher = createCipher("AES/CCM/NoPadding", bArrGenerateKey);
                    encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(keyDerivationFuncGeneratePkbdAlgorithmIdentifier, new EncryptionScheme(aSN1ObjectIdentifier2, CCMParameters.getInstance(cipherCreateCipher.getParameters().getEncoded())))), cipherCreateCipher.doFinal(encoded));
                } else {
                    encryptedPrivateKeyInfo = new EncryptedPrivateKeyInfo(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(keyDerivationFuncGeneratePkbdAlgorithmIdentifier, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_wrap_pad))), createCipher("AESKWP", bArrGenerateKey).doFinal(encoded));
                }
                this.f21735entries.put(str, new ObjectData(PRIVATE_KEY, str, dateExtractCreationDate, date, createPrivateKeySequence(encryptedPrivateKeyInfo, certificateArr).getEncoded(), null));
            } catch (Exception e) {
                throw new ExtKeyStoreException("BCFKS KeyStore exception storing private key: " + e.toString(), e);
            }
        } else {
            if (!(key instanceof SecretKey)) {
                throw new KeyStoreException("BCFKS KeyStore unable to recognize key.");
            }
            if (certificateArr != null) {
                throw new KeyStoreException("BCFKS KeyStore cannot store certificate chain with secret key.");
            }
            try {
                byte[] encoded2 = key.getEncoded();
                KeyDerivationFunc keyDerivationFuncGeneratePkbdAlgorithmIdentifier2 = generatePkbdAlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, 32);
                if (cArr == null) {
                    cArr = new char[0];
                }
                byte[] bArrGenerateKey2 = generateKey(keyDerivationFuncGeneratePkbdAlgorithmIdentifier2, "SECRET_KEY_ENCRYPTION", cArr, 32);
                String upperCase = C6250Strings.toUpperCase(key.getAlgorithm());
                if (upperCase.indexOf("AES") > -1) {
                    secretKeyData = new SecretKeyData(NISTObjectIdentifiers.f18429aes, encoded2);
                } else {
                    Map<String, ASN1ObjectIdentifier> map = f21734oidMap;
                    ASN1ObjectIdentifier aSN1ObjectIdentifier3 = map.get(upperCase);
                    if (aSN1ObjectIdentifier3 != null) {
                        secretKeyData = new SecretKeyData(aSN1ObjectIdentifier3, encoded2);
                    } else {
                        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = map.get(upperCase + "." + (encoded2.length * 8));
                        if (aSN1ObjectIdentifier4 == null) {
                            throw new KeyStoreException("BCFKS KeyStore cannot recognize secret key (" + upperCase + ") for storage.");
                        }
                        secretKeyData = new SecretKeyData(aSN1ObjectIdentifier4, encoded2);
                    }
                }
                ASN1ObjectIdentifier aSN1ObjectIdentifier5 = this.storeEncryptionAlgorithm;
                ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_aes256_CCM;
                if (aSN1ObjectIdentifier5.m14446equals((ASN1Primitive) aSN1ObjectIdentifier6)) {
                    Cipher cipherCreateCipher2 = createCipher("AES/CCM/NoPadding", bArrGenerateKey2);
                    encryptedSecretKeyData = new EncryptedSecretKeyData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(keyDerivationFuncGeneratePkbdAlgorithmIdentifier2, new EncryptionScheme(aSN1ObjectIdentifier6, CCMParameters.getInstance(cipherCreateCipher2.getParameters().getEncoded())))), cipherCreateCipher2.doFinal(secretKeyData.getEncoded()));
                } else {
                    encryptedSecretKeyData = new EncryptedSecretKeyData(new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBES2, new PBES2Parameters(keyDerivationFuncGeneratePkbdAlgorithmIdentifier2, new EncryptionScheme(NISTObjectIdentifiers.id_aes256_wrap_pad))), createCipher("AESKWP", bArrGenerateKey2).doFinal(secretKeyData.getEncoded()));
                }
                this.f21735entries.put(str, new ObjectData(SECRET_KEY, str, dateExtractCreationDate, date, encryptedSecretKeyData.getEncoded(), null));
            } catch (Exception e2) {
                throw new ExtKeyStoreException("BCFKS KeyStore exception storing private key: " + e2.toString(), e2);
            }
        }
        this.lastModifiedDate = date;
    }

    @Override // java.security.KeyStoreSpi
    public int engineSize() {
        return this.f21735entries.size();
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(OutputStream outputStream, char[] cArr) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, InvalidKeyException {
        KeyDerivationFunc keyDerivationFunc;
        BigInteger keyLength;
        if (this.creationDate == null) {
            throw new IOException("KeyStore not initialized");
        }
        EncryptedObjectStoreData encryptedObjectStoreData = getEncryptedObjectStoreData(this.hmacAlgorithm, cArr);
        if (MiscObjectIdentifiers.id_scrypt.m14446equals((ASN1Primitive) this.hmacPkbdAlgorithm.getAlgorithm())) {
            ScryptParams scryptParams = ScryptParams.getInstance(this.hmacPkbdAlgorithm.getParameters());
            keyDerivationFunc = this.hmacPkbdAlgorithm;
            keyLength = scryptParams.getKeyLength();
        } else {
            PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(this.hmacPkbdAlgorithm.getParameters());
            keyDerivationFunc = this.hmacPkbdAlgorithm;
            keyLength = pBKDF2Params.getKeyLength();
        }
        this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(keyDerivationFunc, keyLength.intValue());
        try {
            outputStream.write(new ObjectStore(encryptedObjectStoreData, new ObjectStoreIntegrityCheck(new PbkdMacIntegrityCheck(this.hmacAlgorithm, this.hmacPkbdAlgorithm, calculateMac(encryptedObjectStoreData.getEncoded(), this.hmacAlgorithm, this.hmacPkbdAlgorithm, cArr)))).getEncoded());
            outputStream.flush();
        } catch (NoSuchProviderException e) {
            throw new IOException("cannot calculate mac: " + e.getMessage());
        }
    }

    private KeyDerivationFunc generatePkbdAlgorithmIdentifier(KeyDerivationFunc keyDerivationFunc, int i) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.id_scrypt;
        boolean zM14446equals = aSN1ObjectIdentifier.m14446equals((ASN1Primitive) keyDerivationFunc.getAlgorithm());
        ASN1Encodable parameters = keyDerivationFunc.getParameters();
        if (zM14446equals) {
            ScryptParams scryptParams = ScryptParams.getInstance(parameters);
            byte[] bArr = new byte[scryptParams.m15989getSalt().length];
            getDefaultSecureRandom().nextBytes(bArr);
            return new KeyDerivationFunc(aSN1ObjectIdentifier, new ScryptParams(bArr, scryptParams.getCostParameter(), scryptParams.getBlockSize(), scryptParams.getParallelizationParameter(), BigInteger.valueOf(i)));
        }
        PBKDF2Params pBKDF2Params = PBKDF2Params.getInstance(parameters);
        byte[] bArr2 = new byte[pBKDF2Params.m14635getSalt().length];
        getDefaultSecureRandom().nextBytes(bArr2);
        return new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(bArr2, pBKDF2Params.getIterationCount().intValue(), i, pBKDF2Params.m14634getPrf()));
    }

    @Override // java.security.KeyStoreSpi
    public void engineLoad(KeyStore.LoadStoreParameter loadStoreParameter) throws UnsupportedCallbackException, IOException {
        if (loadStoreParameter == null) {
            engineLoad(null, null);
            return;
        }
        if (!(loadStoreParameter instanceof BCFKSLoadStoreParameter)) {
            if (loadStoreParameter instanceof BCLoadStoreParameter) {
                engineLoad(((BCLoadStoreParameter) loadStoreParameter).getInputStream(), ParameterUtil.extractPassword(loadStoreParameter));
                return;
            }
            throw new IllegalArgumentException("no support for 'parameter' of type " + loadStoreParameter.getClass().getName());
        }
        BCFKSLoadStoreParameter bCFKSLoadStoreParameter = (BCFKSLoadStoreParameter) loadStoreParameter;
        char[] cArrExtractPassword = ParameterUtil.extractPassword(bCFKSLoadStoreParameter);
        this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(bCFKSLoadStoreParameter.getStorePBKDFConfig(), 64);
        this.storeEncryptionAlgorithm = bCFKSLoadStoreParameter.getStoreEncryptionAlgorithm() == BCFKSLoadStoreParameter.EncryptionAlgorithm.AES256_CCM ? NISTObjectIdentifiers.id_aes256_CCM : NISTObjectIdentifiers.id_aes256_wrap_pad;
        this.hmacAlgorithm = bCFKSLoadStoreParameter.getStoreMacAlgorithm() == BCFKSLoadStoreParameter.MacAlgorithm.HmacSHA512 ? new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, C5103DERNull.INSTANCE) : new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_512, C5103DERNull.INSTANCE);
        this.verificationKey = (PublicKey) bCFKSLoadStoreParameter.getStoreSignatureKey();
        this.validator = bCFKSLoadStoreParameter.getCertChainValidator();
        this.signatureAlgorithm = generateSignatureAlgId(this.verificationKey, bCFKSLoadStoreParameter.getStoreSignatureAlgorithm());
        ASN1ObjectIdentifier aSN1ObjectIdentifier = this.storeEncryptionAlgorithm;
        InputStream inputStream = bCFKSLoadStoreParameter.getInputStream();
        engineLoad(inputStream, cArrExtractPassword);
        if (inputStream != null) {
            if (!isSimilarHmacPbkd(bCFKSLoadStoreParameter.getStorePBKDFConfig(), this.hmacPkbdAlgorithm) || !aSN1ObjectIdentifier.m14446equals((ASN1Primitive) this.storeEncryptionAlgorithm)) {
                throw new IOException("configuration parameters do not match existing store");
            }
        }
    }

    @Override // java.security.KeyStoreSpi
    public void engineSetKeyEntry(String str, byte[] bArr, Certificate[] certificateArr) throws ExtKeyStoreException {
        Date date = new Date();
        ObjectData objectData = this.f21735entries.get(str);
        Date dateExtractCreationDate = objectData != null ? extractCreationDate(objectData, date) : date;
        if (certificateArr != null) {
            try {
                EncryptedPrivateKeyInfo encryptedPrivateKeyInfo = EncryptedPrivateKeyInfo.getInstance(bArr);
                try {
                    this.privateKeyCache.remove(str);
                    this.f21735entries.put(str, new ObjectData(PROTECTED_PRIVATE_KEY, str, dateExtractCreationDate, date, createPrivateKeySequence(encryptedPrivateKeyInfo, certificateArr).getEncoded(), null));
                } catch (Exception e) {
                    throw new ExtKeyStoreException("BCFKS KeyStore exception storing protected private key: " + e.toString(), e);
                }
            } catch (Exception e2) {
                throw new ExtKeyStoreException("BCFKS KeyStore private key encoding must be an EncryptedPrivateKeyInfo.", e2);
            }
        } else {
            try {
                this.f21735entries.put(str, new ObjectData(PROTECTED_SECRET_KEY, str, dateExtractCreationDate, date, bArr, null));
            } catch (Exception e3) {
                throw new ExtKeyStoreException("BCFKS KeyStore exception storing protected private key: " + e3.toString(), e3);
            }
        }
        this.lastModifiedDate = date;
    }

    @Override // java.security.KeyStoreSpi
    public void engineStore(KeyStore.LoadStoreParameter loadStoreParameter) throws BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, SignatureException, UnsupportedCallbackException, IOException, InvalidKeyException {
        SignatureCheck signatureCheck;
        if (loadStoreParameter == null) {
            throw new IllegalArgumentException("'parameter' arg cannot be null");
        }
        if (loadStoreParameter instanceof BCFKSStoreParameter) {
            BCFKSStoreParameter bCFKSStoreParameter = (BCFKSStoreParameter) loadStoreParameter;
            char[] cArrExtractPassword = ParameterUtil.extractPassword(loadStoreParameter);
            this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(bCFKSStoreParameter.getStorePBKDFConfig(), 64);
            engineStore(bCFKSStoreParameter.getOutputStream(), cArrExtractPassword);
            return;
        }
        if (!(loadStoreParameter instanceof BCFKSLoadStoreParameter)) {
            if (loadStoreParameter instanceof BCLoadStoreParameter) {
                engineStore(((BCLoadStoreParameter) loadStoreParameter).getOutputStream(), ParameterUtil.extractPassword(loadStoreParameter));
                return;
            }
            throw new IllegalArgumentException("no support for 'parameter' of type " + loadStoreParameter.getClass().getName());
        }
        BCFKSLoadStoreParameter bCFKSLoadStoreParameter = (BCFKSLoadStoreParameter) loadStoreParameter;
        if (bCFKSLoadStoreParameter.getStoreSignatureKey() == null) {
            char[] cArrExtractPassword2 = ParameterUtil.extractPassword(bCFKSLoadStoreParameter);
            this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(bCFKSLoadStoreParameter.getStorePBKDFConfig(), 64);
            this.storeEncryptionAlgorithm = bCFKSLoadStoreParameter.getStoreEncryptionAlgorithm() == BCFKSLoadStoreParameter.EncryptionAlgorithm.AES256_CCM ? NISTObjectIdentifiers.id_aes256_CCM : NISTObjectIdentifiers.id_aes256_wrap_pad;
            this.hmacAlgorithm = bCFKSLoadStoreParameter.getStoreMacAlgorithm() == BCFKSLoadStoreParameter.MacAlgorithm.HmacSHA512 ? new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, C5103DERNull.INSTANCE) : new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_512, C5103DERNull.INSTANCE);
            engineStore(bCFKSLoadStoreParameter.getOutputStream(), cArrExtractPassword2);
            return;
        }
        this.signatureAlgorithm = generateSignatureAlgId(bCFKSLoadStoreParameter.getStoreSignatureKey(), bCFKSLoadStoreParameter.getStoreSignatureAlgorithm());
        this.hmacPkbdAlgorithm = generatePkbdAlgorithmIdentifier(bCFKSLoadStoreParameter.getStorePBKDFConfig(), 64);
        this.storeEncryptionAlgorithm = bCFKSLoadStoreParameter.getStoreEncryptionAlgorithm() == BCFKSLoadStoreParameter.EncryptionAlgorithm.AES256_CCM ? NISTObjectIdentifiers.id_aes256_CCM : NISTObjectIdentifiers.id_aes256_wrap_pad;
        this.hmacAlgorithm = bCFKSLoadStoreParameter.getStoreMacAlgorithm() == BCFKSLoadStoreParameter.MacAlgorithm.HmacSHA512 ? new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, C5103DERNull.INSTANCE) : new AlgorithmIdentifier(NISTObjectIdentifiers.id_hmacWithSHA3_512, C5103DERNull.INSTANCE);
        EncryptedObjectStoreData encryptedObjectStoreData = getEncryptedObjectStoreData(this.signatureAlgorithm, ParameterUtil.extractPassword(bCFKSLoadStoreParameter));
        try {
            Signature signatureCreateSignature = this.f21736helper.createSignature(this.signatureAlgorithm.getAlgorithm().m14433getId());
            signatureCreateSignature.initSign((PrivateKey) bCFKSLoadStoreParameter.getStoreSignatureKey());
            signatureCreateSignature.update(encryptedObjectStoreData.getEncoded());
            X509Certificate[] storeCertificates = bCFKSLoadStoreParameter.getStoreCertificates();
            if (storeCertificates != null) {
                int length = storeCertificates.length;
                org.bouncycastle.p133asn1.p174x509.Certificate[] certificateArr = new org.bouncycastle.p133asn1.p174x509.Certificate[length];
                for (int i = 0; i != length; i++) {
                    certificateArr[i] = org.bouncycastle.p133asn1.p174x509.Certificate.getInstance(storeCertificates[i].getEncoded());
                }
                signatureCheck = new SignatureCheck(this.signatureAlgorithm, certificateArr, signatureCreateSignature.sign());
            } else {
                signatureCheck = new SignatureCheck(this.signatureAlgorithm, signatureCreateSignature.sign());
            }
            bCFKSLoadStoreParameter.getOutputStream().write(new ObjectStore(encryptedObjectStoreData, new ObjectStoreIntegrityCheck(signatureCheck)).getEncoded());
            bCFKSLoadStoreParameter.getOutputStream().flush();
        } catch (GeneralSecurityException e) {
            throw new IOException("error creating signature: " + e.getMessage(), e);
        }
    }

    private KeyDerivationFunc generatePkbdAlgorithmIdentifier(PBKDFConfig pBKDFConfig, int i) {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = MiscObjectIdentifiers.id_scrypt;
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) pBKDFConfig.getAlgorithm())) {
            ScryptConfig scryptConfig = (ScryptConfig) pBKDFConfig;
            byte[] bArr = new byte[scryptConfig.getSaltLength()];
            getDefaultSecureRandom().nextBytes(bArr);
            return new KeyDerivationFunc(aSN1ObjectIdentifier, new ScryptParams(bArr, scryptConfig.getCostParameter(), scryptConfig.getBlockSize(), scryptConfig.getParallelizationParameter(), i));
        }
        PBKDF2Config pBKDF2Config = (PBKDF2Config) pBKDFConfig;
        byte[] bArr2 = new byte[pBKDF2Config.getSaltLength()];
        getDefaultSecureRandom().nextBytes(bArr2);
        return new KeyDerivationFunc(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(bArr2, pBKDF2Config.getIterationCount(), i, pBKDF2Config.m15928getPRF()));
    }
}
