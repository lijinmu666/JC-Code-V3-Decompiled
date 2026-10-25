package org.bouncycastle.p223eac.operator.p225jcajce;

import java.io.OutputStream;
import java.math.BigInteger;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.Provider;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Arrays;
import java.util.Hashtable;
import org.bouncycastle.operator.OperatorCreationException;
import org.bouncycastle.operator.OperatorStreamException;
import org.bouncycastle.operator.RuntimeOperatorException;
import org.bouncycastle.p133asn1.ASN1Integer;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Sequence;
import org.bouncycastle.p133asn1.p143eac.EACObjectIdentifiers;
import org.bouncycastle.p223eac.operator.EACSigner;

/* loaded from: classes2.dex */
public class JcaEACSignerBuilder {
    private static final Hashtable sigNames;

    /* renamed from: helper */
    private EACHelper f21158helper = new DefaultEACHelper();

    public static class SignatureOutputStream extends OutputStream {

        /* renamed from: sig */
        private Signature f21160sig;

        public SignatureOutputStream(Signature signature) {
            this.f21160sig = signature;
        }

        public byte[] getSignature() {
            return this.f21160sig.sign();
        }

        @Override // java.io.OutputStream
        public void write(int i) throws SignatureException, OperatorStreamException {
            try {
                this.f21160sig.update((byte) i);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr) throws SignatureException, OperatorStreamException {
            try {
                this.f21160sig.update(bArr);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }

        @Override // java.io.OutputStream
        public void write(byte[] bArr, int i, int i2) throws SignatureException, OperatorStreamException {
            try {
                this.f21160sig.update(bArr, i, i2);
            } catch (SignatureException e) {
                throw new OperatorStreamException("exception in content signer: " + e.getMessage(), e);
            }
        }
    }

    static {
        Hashtable hashtable = new Hashtable();
        sigNames = hashtable;
        hashtable.put("SHA1withRSA", EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_1);
        hashtable.put("SHA256withRSA", EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_256);
        hashtable.put("SHA1withRSAandMGF1", EACObjectIdentifiers.id_TA_RSA_PSS_SHA_1);
        hashtable.put("SHA256withRSAandMGF1", EACObjectIdentifiers.id_TA_RSA_PSS_SHA_256);
        hashtable.put("SHA512withRSA", EACObjectIdentifiers.id_TA_RSA_v1_5_SHA_512);
        hashtable.put("SHA512withRSAandMGF1", EACObjectIdentifiers.id_TA_RSA_PSS_SHA_512);
        hashtable.put("SHA1withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_1);
        hashtable.put("SHA224withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_224);
        hashtable.put("SHA256withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_256);
        hashtable.put("SHA384withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_384);
        hashtable.put("SHA512withECDSA", EACObjectIdentifiers.id_TA_ECDSA_SHA_512);
    }

    private static void copyUnsignedInt(byte[] bArr, byte[] bArr2, int i) {
        int length = bArr.length;
        int i2 = 0;
        if (bArr[0] == 0) {
            length--;
            i2 = 1;
        }
        System.arraycopy(bArr, i2, bArr2, i, length);
    }

    /* renamed from: max */
    public static int m15952max(int i, int i2) {
        return i > i2 ? i : i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] reencode(byte[] bArr) {
        ASN1Sequence aSN1Sequence = ASN1Sequence.getInstance(bArr);
        BigInteger value = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).getValue();
        BigInteger value2 = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(1)).getValue();
        byte[] byteArray = value.toByteArray();
        byte[] byteArray2 = value2.toByteArray();
        int iUnsignedIntLength = unsignedIntLength(byteArray);
        int iUnsignedIntLength2 = unsignedIntLength(byteArray2);
        int iM15952max = m15952max(iUnsignedIntLength, iUnsignedIntLength2);
        if ((iM15952max & 1) != 0) {
            iM15952max++;
        }
        int i = iM15952max * 2;
        byte[] bArr2 = new byte[i];
        Arrays.fill(bArr2, (byte) 0);
        copyUnsignedInt(byteArray, bArr2, iM15952max - iUnsignedIntLength);
        copyUnsignedInt(byteArray2, bArr2, i - iUnsignedIntLength2);
        return bArr2;
    }

    private static int unsignedIntLength(byte[] bArr) {
        int length = bArr.length;
        return bArr[0] == 0 ? length - 1 : length;
    }

    /* renamed from: build */
    public EACSigner m15953build(String str, PrivateKey privateKey) {
        return m15954build((ASN1ObjectIdentifier) sigNames.get(str), privateKey);
    }

    public JcaEACSignerBuilder setProvider(String str) {
        this.f21158helper = new NamedEACHelper(str);
        return this;
    }

    /* renamed from: build */
    public EACSigner m15954build(final ASN1ObjectIdentifier aSN1ObjectIdentifier, PrivateKey privateKey) throws OperatorCreationException, InvalidKeyException {
        try {
            Signature signature = this.f21158helper.getSignature(aSN1ObjectIdentifier);
            signature.initSign(privateKey);
            final SignatureOutputStream signatureOutputStream = new SignatureOutputStream(signature);
            return new EACSigner(this) { // from class: org.bouncycastle.eac.operator.jcajce.JcaEACSignerBuilder.1

                /* renamed from: this$0 */
                final /* synthetic */ JcaEACSignerBuilder f21159this$0;

                {
                    this.f21159this$0 = this;
                }

                @Override // org.bouncycastle.p223eac.operator.EACSigner
                public OutputStream getOutputStream() {
                    return signatureOutputStream;
                }

                @Override // org.bouncycastle.p223eac.operator.EACSigner
                public byte[] getSignature() {
                    try {
                        byte[] signature2 = signatureOutputStream.getSignature();
                        return aSN1ObjectIdentifier.m14435on(EACObjectIdentifiers.id_TA_ECDSA) ? JcaEACSignerBuilder.reencode(signature2) : signature2;
                    } catch (SignatureException e) {
                        throw new RuntimeOperatorException("exception obtaining signature: " + e.getMessage(), e);
                    }
                }

                @Override // org.bouncycastle.p223eac.operator.EACSigner
                public ASN1ObjectIdentifier getUsageIdentifier() {
                    return aSN1ObjectIdentifier;
                }
            };
        } catch (InvalidKeyException e) {
            throw new OperatorCreationException("invalid key: " + e.getMessage(), e);
        } catch (NoSuchAlgorithmException e2) {
            throw new OperatorCreationException("unable to find algorithm: " + e2.getMessage(), e2);
        } catch (NoSuchProviderException e3) {
            throw new OperatorCreationException("unable to find provider: " + e3.getMessage(), e3);
        }
    }

    public JcaEACSignerBuilder setProvider(Provider provider) {
        this.f21158helper = new ProviderEACHelper(provider);
        return this;
    }
}
