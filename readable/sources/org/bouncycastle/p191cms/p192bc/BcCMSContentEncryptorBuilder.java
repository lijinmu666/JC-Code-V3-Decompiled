package org.bouncycastle.p191cms.p192bc;

import java.io.OutputStream;
import java.security.SecureRandom;
import org.bouncycastle.operator.DefaultSecretKeySizeProvider;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.operator.MacCaptureStream;
import org.bouncycastle.operator.OutputAEADEncryptor;
import org.bouncycastle.operator.OutputEncryptor;
import org.bouncycastle.operator.SecretKeySizeProvider;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p165oiw.OIWObjectIdentifiers;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.CMSException;
import org.bouncycastle.p194crypto.p210modes.AEADBlockCipher;
import org.bouncycastle.p194crypto.p213params.KeyParameter;
import org.bouncycastle.p194crypto.p221util.CipherFactory;

/* loaded from: classes2.dex */
public class BcCMSContentEncryptorBuilder {
    private static final SecretKeySizeProvider KEY_SIZE_PROVIDER = DefaultSecretKeySizeProvider.INSTANCE;
    private final ASN1ObjectIdentifier encryptionOID;

    /* renamed from: helper */
    private EnvelopedDataHelper f19045helper;

    /* renamed from: keySize */
    private final int f19046keySize;

    /* renamed from: random */
    private SecureRandom f19047random;

    public static class AADStream extends OutputStream {

        /* renamed from: cipher */
        private AEADBlockCipher f19048cipher;

        public AADStream(AEADBlockCipher aEADBlockCipher) {
            this.f19048cipher = aEADBlockCipher;
        }

        @Override // java.io.OutputStream
        public void write(int i) {
            this.f19048cipher.processAADByte((byte) i);
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) {
            this.f19048cipher.processAADBytes(bArr, i, i2);
        }
    }

    public class CMSAuthOutputEncryptor extends CMSOutputEncryptor implements OutputAEADEncryptor {
        private AEADBlockCipher aeadCipher;

        /* renamed from: macOut */
        private MacCaptureStream f19049macOut;

        public CMSAuthOutputEncryptor(ASN1ObjectIdentifier aSN1ObjectIdentifier, KeyParameter keyParameter, SecureRandom secureRandom) {
            super(aSN1ObjectIdentifier, keyParameter, secureRandom);
            this.aeadCipher = getCipher();
        }

        private AEADBlockCipher getCipher() {
            Object obj = this.f19051cipher;
            if (obj instanceof AEADBlockCipher) {
                return (AEADBlockCipher) obj;
            }
            throw new IllegalArgumentException("Unable to create Authenticated Output Encryptor without Authenticaed Data cipher!");
        }

        @Override // org.bouncycastle.operator.AADProcessor
        public OutputStream getAADStream() {
            return new AADStream(this.aeadCipher);
        }

        @Override // org.bouncycastle.operator.AADProcessor
        /* renamed from: getMAC */
        public byte[] mo14908getMAC() {
            return this.f19049macOut.m17386getMac();
        }

        @Override // org.bouncycastle.cms.bc.BcCMSContentEncryptorBuilder.CMSOutputEncryptor, org.bouncycastle.operator.OutputEncryptor
        public OutputStream getOutputStream(OutputStream outputStream) {
            MacCaptureStream macCaptureStream = new MacCaptureStream(outputStream, this.aeadCipher.mo15225getMac().length);
            this.f19049macOut = macCaptureStream;
            return CipherFactory.createOutputStream(macCaptureStream, this.f19051cipher);
        }
    }

    public class CMSOutputEncryptor implements OutputEncryptor {
        private AlgorithmIdentifier algorithmIdentifier;

        /* renamed from: cipher */
        protected Object f19051cipher;

        /* renamed from: encKey */
        private KeyParameter f19052encKey;

        public CMSOutputEncryptor(ASN1ObjectIdentifier aSN1ObjectIdentifier, KeyParameter keyParameter, SecureRandom secureRandom) throws CMSException {
            AlgorithmIdentifier algorithmIdentifierGenerateEncryptionAlgID = BcCMSContentEncryptorBuilder.this.f19045helper.generateEncryptionAlgID(aSN1ObjectIdentifier, keyParameter, secureRandom);
            this.algorithmIdentifier = algorithmIdentifierGenerateEncryptionAlgID;
            this.f19052encKey = keyParameter;
            this.f19051cipher = EnvelopedDataHelper.createContentCipher(true, keyParameter, algorithmIdentifierGenerateEncryptionAlgID);
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        public AlgorithmIdentifier getAlgorithmIdentifier() {
            return this.algorithmIdentifier;
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        /* renamed from: getKey */
        public GenericKey mo14795getKey() {
            return new GenericKey(this.algorithmIdentifier, this.f19052encKey.m15773getKey());
        }

        @Override // org.bouncycastle.operator.OutputEncryptor
        public OutputStream getOutputStream(OutputStream outputStream) {
            return CipherFactory.createOutputStream(outputStream, this.f19051cipher);
        }
    }

    public BcCMSContentEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        this(aSN1ObjectIdentifier, KEY_SIZE_PROVIDER.getKeySize(aSN1ObjectIdentifier));
    }

    /* renamed from: build */
    public OutputEncryptor m14906build() {
        if (this.f19047random == null) {
            this.f19047random = new SecureRandom();
        }
        return m14907build(this.f19045helper.createKeyGenerator(this.encryptionOID, this.f19046keySize, this.f19047random).generateKey());
    }

    public BcCMSContentEncryptorBuilder setSecureRandom(SecureRandom secureRandom) {
        this.f19047random = secureRandom;
        return this;
    }

    public BcCMSContentEncryptorBuilder(ASN1ObjectIdentifier aSN1ObjectIdentifier, int i) {
        int i2;
        this.f19045helper = new EnvelopedDataHelper();
        this.encryptionOID = aSN1ObjectIdentifier;
        int keySize = KEY_SIZE_PROVIDER.getKeySize(aSN1ObjectIdentifier);
        if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) PKCSObjectIdentifiers.des_EDE3_CBC)) {
            i2 = 168;
            if (i != 168 && i != keySize) {
                throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
            }
        } else {
            if (!aSN1ObjectIdentifier.m14446equals((ASN1Primitive) OIWObjectIdentifiers.f18454desCBC)) {
                if (keySize > 0 && keySize != i) {
                    throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
                }
                this.f19046keySize = i;
                return;
            }
            i2 = 56;
            if (i != 56 && i != keySize) {
                throw new IllegalArgumentException("incorrect keySize for encryptionOID passed to builder.");
            }
        }
        this.f19046keySize = i2;
    }

    /* renamed from: build */
    public OutputEncryptor m14907build(byte[] bArr) {
        if (this.f19047random == null) {
            this.f19047random = new SecureRandom();
        }
        int i = this.f19046keySize;
        if (i <= 0 || (i + 7) / 8 == bArr.length || i == 56 || bArr.length == 8 || i == 168 || bArr.length == 24) {
            return this.f19045helper.isAuthEnveloped(this.encryptionOID) ? new CMSAuthOutputEncryptor(this.encryptionOID, new KeyParameter(bArr), this.f19047random) : new CMSOutputEncryptor(this.encryptionOID, new KeyParameter(bArr), this.f19047random);
        }
        throw new IllegalArgumentException("attempt to create encryptor with the wrong sized key");
    }
}
