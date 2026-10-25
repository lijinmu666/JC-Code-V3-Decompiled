package org.bouncycastle.p246its.p248jcajce;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Provider;
import java.security.interfaces.ECPublicKey;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.ASN1Primitive;
import org.bouncycastle.p133asn1.p167sec.SECObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.SubjectPublicKeyInfo;
import org.bouncycastle.p133asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.p246its.ETSIKeyWrapper;
import org.bouncycastle.p249jcajce.p279spec.IESKEMParameterSpec;
import org.bouncycastle.p249jcajce.p280util.DefaultJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.JcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.NamedJcaJceHelper;
import org.bouncycastle.p249jcajce.p280util.ProviderJcaJceHelper;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.EncryptedDataEncryptionKey;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EccP256CurvePoint;
import org.bouncycastle.p300oer.p301its.ieee1609dot2.basetypes.EciesP256EncryptedKey;
import org.bouncycastle.p361util.C6238Arrays;

/* loaded from: classes2.dex */
public class JceETSIKeyWrapper implements ETSIKeyWrapper {

    /* renamed from: helper */
    private final JcaJceHelper f21330helper;
    private final byte[] recipientHash;
    private final ECPublicKey recipientKey;

    /* renamed from: org.bouncycastle.its.jcajce.JceETSIKeyWrapper$Builder */
    public static class C5464Builder {

        /* renamed from: helper */
        private JcaJceHelper f21331helper = new DefaultJcaJceHelper();
        private final byte[] recipientHash;
        private final ECPublicKey recipientKey;

        public C5464Builder(ECPublicKey eCPublicKey, byte[] bArr) {
            this.recipientKey = eCPublicKey;
            this.recipientHash = bArr;
        }

        /* renamed from: build */
        public JceETSIKeyWrapper m16037build() {
            return new JceETSIKeyWrapper(this.recipientKey, this.recipientHash, this.f21331helper);
        }

        public C5464Builder setProvider(String str) {
            this.f21331helper = new NamedJcaJceHelper(str);
            return this;
        }

        public C5464Builder setProvider(Provider provider) {
            this.f21331helper = new ProviderJcaJceHelper(provider);
            return this;
        }
    }

    private JceETSIKeyWrapper(ECPublicKey eCPublicKey, byte[] bArr, JcaJceHelper jcaJceHelper) {
        this.recipientKey = eCPublicKey;
        this.recipientHash = bArr;
        this.f21330helper = jcaJceHelper;
    }

    @Override // org.bouncycastle.p246its.ETSIKeyWrapper
    /* renamed from: wrap */
    public EncryptedDataEncryptionKey mo15993wrap(byte[] bArr) throws IllegalBlockSizeException, InvalidKeyException, InvalidAlgorithmParameterException {
        try {
            Cipher cipherCreateCipher = this.f21330helper.createCipher("ETSIKEMwithSHA256");
            cipherCreateCipher.init(3, this.recipientKey, new IESKEMParameterSpec(this.recipientHash, true));
            byte[] bArrWrap = cipherCreateCipher.wrap(new SecretKeySpec(bArr, "AES"));
            int fieldSize = (this.recipientKey.getParams().getCurve().getField().getFieldSize() + 7) / 8;
            if (bArrWrap[0] == 4) {
                fieldSize *= 2;
            }
            int i = fieldSize + 1;
            ASN1ObjectIdentifier aSN1ObjectIdentifier = ASN1ObjectIdentifier.getInstance(SubjectPublicKeyInfo.getInstance(this.recipientKey.getEncoded()).getAlgorithm().getParameters());
            EciesP256EncryptedKey eciesP256EncryptedKeyCreateEciesP256EncryptedKey = EciesP256EncryptedKey.m17280builder().m17288setV(EccP256CurvePoint.createEncodedPoint(C6238Arrays.copyOfRange(bArrWrap, 0, i))).m17285setC(C6238Arrays.copyOfRange(bArrWrap, i, bArr.length + i)).m17287setT(C6238Arrays.copyOfRange(bArrWrap, i + bArr.length, bArrWrap.length)).createEciesP256EncryptedKey();
            if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) SECObjectIdentifiers.secp256r1)) {
                return EncryptedDataEncryptionKey.eciesNistP256(eciesP256EncryptedKeyCreateEciesP256EncryptedKey);
            }
            if (aSN1ObjectIdentifier.m14446equals((ASN1Primitive) TeleTrusTObjectIdentifiers.brainpoolP256r1)) {
                return EncryptedDataEncryptionKey.eciesBrainpoolP256r1(eciesP256EncryptedKeyCreateEciesP256EncryptedKey);
            }
            throw new IllegalStateException("recipient key curve is not P-256 or Brainpool P256r1");
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
