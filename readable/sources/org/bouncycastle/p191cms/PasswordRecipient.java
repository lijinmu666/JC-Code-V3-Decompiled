package org.bouncycastle.p191cms;

import org.bouncycastle.p133asn1.ASN1ObjectIdentifier;
import org.bouncycastle.p133asn1.C5103DERNull;
import org.bouncycastle.p133asn1.p166pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.p133asn1.p174x509.AlgorithmIdentifier;

/* loaded from: classes2.dex */
public interface PasswordRecipient extends Recipient {
    public static final int PKCS5_SCHEME2 = 0;
    public static final int PKCS5_SCHEME2_UTF8 = 1;

    /* renamed from: org.bouncycastle.cms.PasswordRecipient$PRF */
    public static final class C5237PRF {
        public static final C5237PRF HMacSHA1;
        public static final C5237PRF HMacSHA224;
        public static final C5237PRF HMacSHA256;
        public static final C5237PRF HMacSHA384;
        public static final C5237PRF HMacSHA512;

        /* renamed from: hmac */
        private final String f19027hmac;
        final AlgorithmIdentifier prfAlgID;

        static {
            ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.id_hmacWithSHA1;
            C5103DERNull c5103DERNull = C5103DERNull.INSTANCE;
            HMacSHA1 = new C5237PRF("HMacSHA1", new AlgorithmIdentifier(aSN1ObjectIdentifier, c5103DERNull));
            HMacSHA224 = new C5237PRF("HMacSHA224", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA224, c5103DERNull));
            HMacSHA256 = new C5237PRF("HMacSHA256", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA256, c5103DERNull));
            HMacSHA384 = new C5237PRF("HMacSHA384", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA384, c5103DERNull));
            HMacSHA512 = new C5237PRF("HMacSHA512", new AlgorithmIdentifier(PKCSObjectIdentifiers.id_hmacWithSHA512, c5103DERNull));
        }

        private C5237PRF(String str, AlgorithmIdentifier algorithmIdentifier) {
            this.f19027hmac = str;
            this.prfAlgID = algorithmIdentifier;
        }

        public AlgorithmIdentifier getAlgorithmID() {
            return this.prfAlgID;
        }

        /* renamed from: getName */
        public String m14888getName() {
            return this.f19027hmac;
        }
    }

    byte[] calculateDerivedKey(int i, AlgorithmIdentifier algorithmIdentifier, int i2);

    char[] getPassword();

    int getPasswordConversionScheme();

    RecipientOperator getRecipientOperator(AlgorithmIdentifier algorithmIdentifier, AlgorithmIdentifier algorithmIdentifier2, byte[] bArr, byte[] bArr2);
}
