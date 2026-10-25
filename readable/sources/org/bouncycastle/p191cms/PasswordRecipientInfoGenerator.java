package org.bouncycastle.p191cms;

import java.security.SecureRandom;
import org.bouncycastle.operator.GenericKey;
import org.bouncycastle.p133asn1.ASN1EncodableVector;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.DEROctetString;
import org.bouncycastle.p133asn1.DERSequence;
import org.bouncycastle.p133asn1.p139cms.PasswordRecipientInfo;
import org.bouncycastle.p133asn1.p139cms.RecipientInfo;
import org.bouncycastle.p133asn1.p166pkcs.PBKDF2Params;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;
import org.bouncycastle.p191cms.PasswordRecipient;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public abstract class PasswordRecipientInfoGenerator implements RecipientInfoGenerator {
    private int blockSize;
    private int iterationCount;
    private ASN1ObjectIdentifier kekAlgorithm;
    private AlgorithmIdentifier keyDerivationAlgorithm;

    /* renamed from: keySize */
    private int f19028keySize;
    protected char[] password;

    /* renamed from: prf */
    private PasswordRecipient.C5237PRF f19029prf;

    /* renamed from: random */
    private SecureRandom f19030random;

    /* renamed from: salt */
    private byte[] f19031salt;
    private int schemeID;

    public PasswordRecipientInfoGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, char[] cArr) {
        this(aSN1ObjectIdentifier, cArr, getKeySize(aSN1ObjectIdentifier), ((Integer) PasswordRecipientInformation.BLOCKSIZES.get(aSN1ObjectIdentifier)).intValue());
    }

    private static int getKeySize(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        Integer num = (Integer) PasswordRecipientInformation.KEYSIZES.get(aSN1ObjectIdentifier);
        if (num != null) {
            return num.intValue();
        }
        throw new IllegalArgumentException("cannot find key size for algorithm: " + aSN1ObjectIdentifier);
    }

    public abstract byte[] calculateDerivedKey(int i, AlgorithmIdentifier algorithmIdentifier, int i2);

    @Override // org.bouncycastle.p191cms.RecipientInfoGenerator
    public RecipientInfo generate(GenericKey genericKey) {
        byte[] bArr = new byte[this.blockSize];
        if (this.f19030random == null) {
            this.f19030random = new SecureRandom();
        }
        this.f19030random.nextBytes(bArr);
        if (this.f19031salt == null) {
            byte[] bArr2 = new byte[20];
            this.f19031salt = bArr2;
            this.f19030random.nextBytes(bArr2);
        }
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(PKCSObjectIdentifiers.id_PBKDF2, new PBKDF2Params(this.f19031salt, this.iterationCount, this.f19029prf.prfAlgID));
        this.keyDerivationAlgorithm = algorithmIdentifier;
        DEROctetString dEROctetString = new DEROctetString(generateEncryptedBytes(new AlgorithmIdentifier(this.kekAlgorithm, new DEROctetString(bArr)), calculateDerivedKey(this.schemeID, algorithmIdentifier, this.f19028keySize), genericKey));
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.m14420add(this.kekAlgorithm);
        aSN1EncodableVector.m14420add(new DEROctetString(bArr));
        return new RecipientInfo(new PasswordRecipientInfo(this.keyDerivationAlgorithm, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_alg_PWRI_KEK, new DERSequence(aSN1EncodableVector)), dEROctetString));
    }

    public abstract byte[] generateEncryptedBytes(AlgorithmIdentifier algorithmIdentifier, byte[] bArr, GenericKey genericKey);

    /* renamed from: setPRF */
    public PasswordRecipientInfoGenerator m14890setPRF(PasswordRecipient.C5237PRF c5237prf) {
        this.f19029prf = c5237prf;
        return this;
    }

    public PasswordRecipientInfoGenerator setPasswordConversionScheme(int i) {
        this.schemeID = i;
        return this;
    }

    public PasswordRecipientInfoGenerator setSaltAndIterationCount(byte[] bArr, int i) {
        this.f19031salt = C6238Arrays.m18231clone(bArr);
        this.iterationCount = i;
        return this;
    }

    public PasswordRecipientInfoGenerator setSecureRandom(SecureRandom secureRandom) {
        this.f19030random = secureRandom;
        return this;
    }

    public PasswordRecipientInfoGenerator(ASN1ObjectIdentifier aSN1ObjectIdentifier, char[] cArr, int i, int i2) {
        this.password = cArr;
        this.schemeID = 1;
        this.kekAlgorithm = aSN1ObjectIdentifier;
        this.f19028keySize = i;
        this.blockSize = i2;
        this.f19029prf = PasswordRecipient.C5237PRF.HMacSHA1;
        this.iterationCount = 1024;
    }
}
